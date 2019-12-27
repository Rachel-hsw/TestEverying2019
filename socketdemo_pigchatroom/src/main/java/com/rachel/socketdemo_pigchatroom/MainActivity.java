package com.rachel.socketdemo_pigchatroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_accept = (Button) findViewById(R.id.btn_accept);
        btn_accept.setOnClickListener(this);
        Button btn_go = (Button) findViewById(R.id.btn_go);
        btn_go.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_accept:
                new Thread() {
                    @Override
                    public void run() {
                        acceptServer();
                    }
                }.start();
                break;
            case R.id.btn_go:
                Intent intent = new Intent(this, com.rachel.socketdemo_pigchatroom.small_pig_chat.MainActivity.class);
                startActivity(intent);
                break;
        }
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
    private void acceptServer() {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.50.238", 12345), 10000);
            //2.获取输出流，向服务器端发送信息
            // 字节输出流
            OutputStream os = socket.getOutputStream();
            //将输出流包装为打印流
            PrintWriter pw = new PrintWriter(os);
            //获取客户端的所有IP地址
            ArrayList<String> addrList = NetUtil.getLocalIpAddr();
            for (String ip : addrList) {
                pw.write("客户端：~" + ip + "~ 接入服务器！！");
            }
            //获取当前使用的Ip地址
            String currentIp = NetUtil.getIPAddress(this);
            pw.write("客户端：~" + currentIp + "~ 接入服务器！！");
            pw.flush();
            socket.shutdownOutput();//关闭输出流
            socket.close();
        } catch (Exception e) {
            //连接不上时候的异常，这里设置了十秒的超时，所以十秒连接不上就会走到这
            //java.net.SocketTimeoutException: failed to connect to /192.168.30.1 (port 12345) from /192.168.50.56 (port 38844) after 10000ms
            e.printStackTrace();
        }
    }

}
