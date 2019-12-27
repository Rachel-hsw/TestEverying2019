package com.rachel.wifip2p.gooddemo;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tongmin.mywifip2p.R;
import com.rachel.wifip2p.debugutil.DebugFile;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GoodActivity extends AppCompatActivity implements WifiP2pManager.ConnectionInfoListener, AdapterView.OnItemClickListener {

    List<WifiP2pDevice> listDevice = new ArrayList<>();
    WifiP2pManager mManager;
    WifiP2pManager.Channel mChannel;
    WiFiDirectBroadcastReceiver mReceiver;
    //    List<String> listInfo = new ArrayList<>();
    TextView tvName, tvMessage;
    Button btSearch;
    WifiP2pInfo info;
    ListView listView;
    ProgressBar pro;
    WifiP2pDevice localDevice;
    PeerAdapter adapter;
    MyHandler handler;
    ServerThread serverThread;
    Map<String, String> deviceMap = new HashMap<>();
    private static final int REQUEST_PERMISSION = 101;

    private static class MyHandler extends Handler {

        private final WeakReference<GoodActivity> mActivity;
        Map<String, String> ipNameMap;

        public MyHandler(GoodActivity activity, Map<String, String> map) {
            mActivity = new WeakReference<>(activity);
            ipNameMap = map;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    String str = (String) msg.obj;
                    Toast.makeText(mActivity.get(), str, Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(mActivity.get(), "发送成功", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    String[] deviceInfo = (String[]) msg.obj;
                    ipNameMap.put(deviceInfo[1], deviceInfo[0]);
//                    DebugFile.getInstance(mActivity.get()).writeLog("接收到的ip数据","ip"+deviceInfo[0]+"name"+deviceInfo[1]);

                    break;
            }
        }
    }

    public void sendInfo(WifiP2pDevice wd) {
        String host = null;
        if (info.groupFormed && info.isGroupOwner) {
            host = deviceMap.get(wd.deviceName);
            DebugFile.getInstance(GoodActivity.this).writeLog("发送给peer端", "host" + host);
        } else if (info.groupFormed) {
            host = info.groupOwnerAddress.getHostAddress();
        }
        new ClientThread(handler, host, "来自 " + localDevice.deviceName + " 的信息!").start();
    }

    private static String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_good);
        findViewById();
        ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
//            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
////                ToastUtils.get().showText("获取权限失败,部分功能可能无法正常使用！");
//            } else {
////                gotNecessaryPermission = true;
//            }
//        }else {

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String str;
        str = listDevice.get(position).toString();
        tvMessage.setText(str);
    }

    private void findViewById() {
        handler = new MyHandler(this, deviceMap);
        tvName = (TextView) findViewById(R.id.name);
        tvMessage = (TextView) findViewById(R.id.msg);
        btSearch = (Button) findViewById(R.id.bt_search);
        listView = (ListView) findViewById(R.id.listview);
        pro = (ProgressBar) findViewById(R.id.pro);
        listView.setOnItemClickListener(this);
        stopLoading();
        //在onCreate（）方法的最后，获取WifiP2pManager的一个实例，并调用其initialize（）方法。
        //此方法返回WifiP2pManager.Channel对象，稍后您将使用该对象将应用程序连接到Wi-Fi P2P框架。
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
        mReceiver = new WiFiDirectBroadcastReceiver(mManager, mChannel);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                discovery();
            }
        });


        adapter = new PeerAdapter(this);
        listView.setAdapter(adapter);

        discovery();

        mReceiver = new WiFiDirectBroadcastReceiver(mManager, mChannel);

        serverThread = new ServerThread(handler, this);
        serverThread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        serverThread.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //最后，添加代码以在主活动处于活动状态时注册intent过滤器和广播接收器，并在活动暂停时取消注册它们。
        // 执行此操作的最佳位置是onResume（）和onPause（）方法。
        registerReceiver(mReceiver, getIntentFilter());
    }

    public void disconnect() {

        mManager.removeGroup(mChannel, new WifiP2pManager.ActionListener() {

            @Override
            public void onFailure(int reasonCode) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onSuccess() {
                adapter.notifyDataSetChanged();
                Toast.makeText(GoodActivity.this, "断开成功!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void discovery() {
        loading();
        //开始使用Wi-Fi P2P搜索附近的设备
        mManager.discoverPeers(mChannel, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                //会发送广播  WIFI_P2P_PEERS_CHANGED_ACTION
                Log.e("xhc", "搜索成功");
            }

            @Override
            public void onFailure(int reasonCode) {
                Log.e("xhc", "搜索失败-->" + reasonCode);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mReceiver);
    }

    /**
     * 请注意，connect（）方法中实现的WifiP2pManager.ActionListener仅在启动成功或失败时通知您。要侦听连接状态的更改，
     * 请实现WifiP2pManager.ConnectionInfoListener接口。当连接状态发生变化时，它的onConnectionInfoAvailable（）回调会通知您。如果要将多个设备连接到单个设备
     * （如具有三个或更多播放器的游戏或聊天应用程序），则将一个设备指定为“组所有者”。您可以按照“创建组”部分中的步骤将特定设备指定为网络的组所有者。
     *
     * @param info
     */
    @Override
    public void onConnectionInfoAvailable(WifiP2pInfo info) {
        //连接后的状态
        this.info = info;
        tvMessage.setText(info.toString());
        if (!info.isGroupOwner) {
            //将自己的ip传给server端
            new ClientThread(handler, info.groupOwnerAddress.getHostAddress(), "ip:" + Constant.getLocalIpAddress() + "name:" + localDevice.deviceName).start();
        }

    }

    private IntentFilter getIntentFilter() {
        IntentFilter mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);
        mIntentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);
        return mIntentFilter;
    }

    public void requestConnectionInfo(
            WifiP2pManager.ConnectionInfoListener listener) {
        mManager.requestConnectionInfo(mChannel, listener);
    }

    //为了连接到点，创建一个新的WifiP2pConfig对象，并从代表您要连接的设备的WifiP2pDevice将数据复制到其中。然后调用connect（）方法。
    public void connect(WifiP2pConfig config) {
        loading();
        mManager.connect(mChannel, config, new WifiP2pManager.ActionListener() {

            @Override
            public void onSuccess() {
                stopLoading();
                Toast.makeText(GoodActivity.this, "连接成功", Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int reason) {
                Log.e("xhc", " 链接失败 " + reason);
                //failure logic
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void loading() {
        pro.setVisibility(View.VISIBLE);
    }

    private void stopLoading() {
        pro.setVisibility(View.GONE);
    }

    /**
     * 现在创建一个新的BroadcastReceiver类，您将用它来监听系统的Wi-Fi P2P状态的变化。
     * 在onReceive（）方法中，添加一个条件来处理上面列出的每个P2P状态更改。
     */
    class WiFiDirectBroadcastReceiver extends BroadcastReceiver implements WifiP2pManager.PeerListListener {

        private WifiP2pManager mManager;
        private WifiP2pManager.Channel mChannel;
//        private GoodActivity mActivity;

        //    private  WifiP2pManager.PeerListListener myPeerListListener;
        public WiFiDirectBroadcastReceiver(WifiP2pManager manager, WifiP2pManager.Channel channel/*,
                                           GoodActivity activity*/) {
            super();
            this.mManager = manager;
            this.mChannel = channel;
//            this.mActivity = activity;
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
                //是否启用了Wi-Fi P2P
                // Check to see if Wi-Fi is enabled and notify appropriate activity=
            } else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {
                // Call WifiP2pManager.requestPeers() to get a list of current peers
                //表示可用的点列表已更改。
                //在收到具有操作WIFI_P2P_PEERS_CHANGED_ACTION的意图时调用requestPeers（）。
                //你需要以某种方式将这个监听器传递给接收器。一种方法是将其作为参数发送给广播接收者的构造函数。
                //现在，具有操作WIFI_P2P_PEERS_CHANGED_ACTION意图的意图触发更新点列表的请求。
                if (mManager != null) {
                    mManager.requestPeers(mChannel, this);
                }
            } else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION.equals(action)) {
                //表示Wi-Fi P2P连接状态已更改。
                //现在返回广播接收器的onReceive（）方法，并修改侦听WIFI_P2P_CONNECTION_CHANGED_ACTION意图的部分。
                // 收到此意图后，请调用requestConnectionInfo（）。这是一个异步调用，因此您提供的连接信息侦听器将接收结果作为参数。
                // Respond to new connection or disconnections
                NetworkInfo networkInfo = intent
                        .getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO);
                if (networkInfo.isConnected()) {
                    requestConnectionInfo(GoodActivity.this);
                    // we are connected with the other device, request connection
                    // info to find group owner IP
                }
            } else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION.equals(action)) {
                //表示此设备的配置详细信息已更改
                localDevice = intent.getParcelableExtra(
                        WifiP2pManager.EXTRA_WIFI_P2P_DEVICE);
                tvName.setText(localDevice.deviceName);
            }
        }

        //首先实现WifiP2pManager.PeerListListener接口，该接口提供有关Wi-Fi P2P检测到的点的信息。
        //此信息还允许您的应用确定对等方何时加入或离开网络。
        @Override
        public void onPeersAvailable(WifiP2pDeviceList peers) {
            //Android 9 引入了若干行为变更，如限制后台应用访问设备传感器、限制通过 Wi-Fi 扫描检索到的信息，
            // 以及与通话、手机状态和 Wi-Fi 扫描相关的新权限规则和权限组
            stopLoading();
            listDevice.clear();
            listDevice.addAll(peers.getDeviceList());
            adapter.setList(listDevice);
        }
    }
}

