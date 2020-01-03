package com.rachel.socketdemo_pigchatroom.udp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.rachel.socketdemo_pigchatroom.NetUtil;
import com.rachel.socketdemo_pigchatroom.R;
import com.rachel.socketdemo_pigchatroom.util.ToastUtils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Optional;

import static com.rachel.socketdemo_pigchatroom.Constants.UDP_PORT;

/**
 * 开启UDP服务器,监听端口
 */
public class MainUdpServerActivity extends AppCompatActivity {

    private final static String TAG = "Rachel_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udp);
        new Thread(() -> accept()).start();
    }

    /**
     * 我先启动
     * A.接收客户端发送的数据
     * B.响应客户端数据
     */
    private static void accept() {
        try {
            //A.接收客户端发送的数据
            // 1.创建服务器端DatagramSocket，指定端口
            DatagramSocket socket = new DatagramSocket(UDP_PORT);
            // 2.创建数据报，用于接收客户端发送的数据
            // 创建字节数组，指定接收的数据包的大小
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            // 3.接收客户端发送的数据
            Optional<Inet4Address> ip4Address = (Optional<Inet4Address>) NetUtil.getLocalIp4Address();
            ToastUtils.get().showText("Local ip:" + ip4Address + "****服务器端已经启动，等待客户端发送数据");
            // 此方法在接收到数据报之前会一直阻塞
            socket.receive(packet);
            // 4.读取数据
            String info = new String(data, 0, packet.getLength());
            ToastUtils.get().showText("我是服务器，客户端说：" + info);

            //B.响应客户端数据
            // 1.定义客户端的地址、端口号、数据
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "UdpServer欢迎您!".getBytes();
            // 2.创建数据报，包含响应的数据信息
            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            // 3.响应客户端
            socket.send(packet2);
            // 4.关闭资源
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
