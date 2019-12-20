package com.test.hsw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.test.hsw.Util.ByteUtil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * 测试UDP，监听端口
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listen(new IGetDeviceInfoListener() {
            @Override
            public void onCallBack(final String info, final SocketAddress socketAddress, final InetAddress address) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "接受到消息" + address.toString(), Toast.LENGTH_LONG).show();
                        try {
                            if (!info.isEmpty()) {
                                if (address.toString().equals("/192.168.43.1")) {
                                    Log.i("Rachel_", address.toString() + ":监听到信息：" + info);
                                } else {
                                    Log.i("Rachel_test", address.toString() + ":监听到信息：" + info);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
            }
        });
    }

    public void listen(final IGetDeviceInfoListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatagramSocket socket = null;
                    try {
                        //18266 7001
                        socket = new DatagramSocket(18266);
                    } catch (SocketException e) {
                        e.printStackTrace();
                    }
                    byte[] data = new byte[1024];
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    //接收设备发送的数据
                    // 此方法在接收到数据报之前会一直阻塞
                    while (true) {
                        try {
                            socket.receive(packet);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // 4.读取数据(如果是字符串)
//                        String info = new String(data, 0, packet.getLength());
                        //如果不是字符串
                        byte[] recDatas = Arrays.copyOf(packet.getData(), packet.getLength());
                        String info= ByteUtil.bytesToHexFun3(recDatas);
                        //ip地址：/192.168.50.56
                        packet.getAddress();
                        //IP address + port number
                        packet.getSocketAddress();
                        listener.onCallBack(info, packet.getSocketAddress(), packet.getAddress());
                        packet.getLength();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
