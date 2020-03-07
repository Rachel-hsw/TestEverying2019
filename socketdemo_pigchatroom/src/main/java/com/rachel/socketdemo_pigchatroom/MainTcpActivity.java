package com.rachel.socketdemo_pigchatroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.rachel.socketdemo_pigchatroom.bean.ResponseInfo;
import com.rachel.socketdemo_pigchatroom.udp.MainUdpServerActivity;
import com.rachel.socketdemo_pigchatroom.udp.MainUdpClientActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Optional;

import static com.rachel.socketdemo_pigchatroom.Constants.TCP_HOST;
import static com.rachel.socketdemo_pigchatroom.Constants.TCP_PORT;

public class MainTcpActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = "Rachel_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_accept = findViewById(R.id.btn_accept);
        btn_accept.setOnClickListener(this);
        Button btn_go = findViewById(R.id.btn_go);
        btn_go.setOnClickListener(this);
        findViewById(R.id.btn_go_udp).setOnClickListener(this);
        findViewById(R.id.btn_go_udp_client).setOnClickListener(this);
        findViewById(R.id.btn_server).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_accept:
                new Thread() {
                    @Override
                    public void run() {
                        client();
                    }
                }.start();
                break;
            case R.id.btn_server:
                new Thread() {
                    @Override
                    public void run() {
                        server();
                    }
                }.start();
                break;
            case R.id.btn_go:
                Intent intent = new Intent(this, MainTcpActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_go_udp:
                Intent intent1 = new Intent(this, MainUdpServerActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_go_udp_client:
                Intent intent2 = new Intent(this, MainUdpClientActivity.class);
                startActivity(intent2);
                break;
        }
    }

    private void server() {
        try{
        //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(TCP_PORT);
        //比较好的方案应该是遍历所有网卡拿到ip列表，然后再选择其一
        Optional<Inet4Address> ip4Address = (Optional<Inet4Address>) NetUtil.getLocalIp4Address();
        String ip = ip4Address.get().getHostAddress();
        System.out.println("~~~服务端已就绪，等待客户端接入~，服务端ip地址: " + ip);
        //2.调用accept()等待客户端连接
        Socket socket = serverSocket.accept();
        //3.连接后获取输入流，读取客户端信息
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;
        is = socket.getInputStream();
        //获取输入流
        isr = new InputStreamReader(is, "UTF-8");
        br = new BufferedReader(isr);
        String result;
        //循环读取客户端的信息
        while ((result = br.readLine()) != null) {
            System.out.println("客户端发送过来的信息" + result);
        }
        //4.告诉客户端收到
        OutputStream os = socket.getOutputStream();
        //5、发送方式和接收方式要保持一致
        sendOutputStream(os);
        System.out.println("通知客户端,服务器已收到!");
        //关闭输入流
        socket.shutdownInput();
        socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void sendOutputStream(OutputStream os) throws IOException {
        ResponseInfo info = new ResponseInfo();
        info.setStatus(true);
        String jsonString = JSON.toJSONString(info);
        os.write(jsonString.getBytes());
        os.flush();
    }
    /**
     * Step 1：创建Socket对象，指明需要链接的服务器的地址和端号
     * Socket socket = new Socket("192.168.50.238", 12345);
     * 也可以这么创建，但是这样就没办法设置超时了
     * <p>
     * Step 2：链接建立后，通过输出流向服务器发送请求信息
     * <p>
     * Step 3：通过输出流获取服务器响应的信息
     * <p>
     * Step 4：关闭相关资源
     *
     * @throws IOException IOException
     */
    private void client() {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(TCP_HOST, TCP_PORT), 10000);
            //2.获取输出流，向服务器端发送信息
            // 字节输出流
            OutputStream os = socket.getOutputStream();
            //将输出流包装为打印流
            PrintWriter pw = new PrintWriter(os);
//            DataOutputStream dos = new DataOutputStream(os);
            //获取客户端的所有IP地址
            ArrayList<String> addList = NetUtil.getLocalIpAddr();
            for (int i = 0; i < addList.size(); i++) {
                Log.i(TAG, "客户端Ip地址" + i + ":" + addList.get(i));
            }
            //获取当前使用的Ip地址
            String currentIp = NetUtil.getIPAddress(this);
            pw.write("客户端：~" + currentIp + "~ 接入服务器！！");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            InputStream in = socket.getInputStream();
            String backMsg = getInputStream(in);
//          String backMsg=getDataInputStream(in);
            pw.close();
            socket.close();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainTcpActivity.this, "收到服务器端响应：" + backMsg, Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            //连接不上时候的异常，这里设置了十秒的超时，所以十秒连接不上就会走到这
            //java.net.SocketTimeoutException: failed to connect to /192.168.30.1 (port 12345) from /192.168.50.56 (port 38844) after 10000ms
            e.printStackTrace();
        }
    }

    private String getDataInputStream(InputStream in) throws IOException {
        DataInputStream dis = new DataInputStream(in);
//      int backMsg = dis.readInt();
        String backMsg = dis.readUTF();
        dis.close();
        return backMsg;
    }

    private String getInputStream(InputStream in) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(in);
        DataInputStream dis = new DataInputStream(bis);
        byte[] bytes = new byte[1024];
        int len;
        String backMsg = null;
        while ((len = dis.read(bytes)) != -1) {
            byte[] data = new byte[len];
            System.arraycopy(bytes, 0, data, 0, len);
            backMsg = new String(data, 0, len);

        }
        in.close();
        return backMsg;
    }
}
