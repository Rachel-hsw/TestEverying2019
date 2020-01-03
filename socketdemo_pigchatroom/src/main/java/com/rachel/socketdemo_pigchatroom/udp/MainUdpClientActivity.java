package com.rachel.socketdemo_pigchatroom.udp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rachel.socketdemo_pigchatroom.NetUtil;
import com.rachel.socketdemo_pigchatroom.R;
import com.rachel.socketdemo_pigchatroom.util.ToastUtils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Optional;

import static com.rachel.socketdemo_pigchatroom.Constants.UDP_HOST;
import static com.rachel.socketdemo_pigchatroom.Constants.UDP_PORT;

/**
 * 开启UDP服务器
 */
public class MainUdpClientActivity extends AppCompatActivity {

    private final static String TAG = "Rachel_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp);
        new Thread(() -> sendData()).start();
    }


    /**
     * A.向服务器端发送数据
     * B.接收客户端的响应
     */
    private static void sendData() {
        try {
            //A.向服务器端发送数据
            // 1.定义服务器的地址、端口号、数据
            Optional<Inet4Address> ip4Address = (Optional<Inet4Address>) NetUtil.getLocalIp4Address();
            byte[] data = ("我是客户端，我的Ip为" + ip4Address.get().getHostAddress()).getBytes();
            // 2.创建数据报，包含发送的数据信息
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName(UDP_HOST), UDP_PORT);
            // 3.创建DatagramSocket对象
            DatagramSocket socket = new DatagramSocket();
            // 4.向服务器端发送数据报
            socket.send(packet);

            //B.接收客户端的响应
            // 1.创建数据报，用于接收服务器端响应的数据
            socket.setSoTimeout(1000 * 60);
            long startTime = System.currentTimeMillis();
            while (startTime - System.currentTimeMillis() < 60 * 1000) {
                byte[] data2 = new byte[1024];
                DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
                // 2.接收服务器响应的数据
                socket.receive(packet2);
                // 3.读取数据
                String reply = new String(data2, 0, packet2.getLength());
                ToastUtils.get().showText("我是客户端，服务器说：" + reply);
            }
            // 4.关闭资源
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
