package com.rachel.socketdemo_pigchatroom.udp;

import com.rachel.socketdemo_pigchatroom.NetUtil;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Optional;

import static com.rachel.socketdemo_pigchatroom.Constants.UDP_HOST;
import static com.rachel.socketdemo_pigchatroom.Constants.UDP_PORT;

/**
 * Step 1：定义发送信息
 * Step 2：创建DatagramPacket，包含将要发送的信息
 * Step 3：创建DatagramSocket
 * Step 4：发送数据
 *
 * @author Rachel
 * 本节内容比较简单，无非就是将数据转换为字节，然后放到DatagramPacket(数据报包中)，发
 * 送的 时候带上接受者的IP地址和端口号，而接收时，用一个字节数组来缓存！
 * <p>
 * 发送的时候需要创建一个 DatagramSocket(端到端通信的类)对象，
 * 然后调用send方法给接受者发送数据报包~
 * 本节代码来源于慕客网上的一个JavaSocket教程~有兴趣的可以看看：
 * Java Socket应用---通信是这样练成的
 * http://www.imooc.com/learn/161
 */
public class UDPClient {
    public static void main(String[] args) {
        sendData();
    }

    /**
     * A.向服务器端发送数据
     * B.接收客户端的响应
     */
    private static void sendData() {
        try {
            //A.向服务器端发送数据
            // 1.定义服务器的地址(指定IP发送)、端口号、数据
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
            //设置响应超时
            socket.setSoTimeout(1000 * 60);
            long startTime = System.currentTimeMillis();
            //发出广播后，但凡是这个局域网下的监听UDP_PORT端口的，都能监听到并作出响应。这里设置接收一分钟所有响应
            while (startTime - System.currentTimeMillis() < 60 * 1000) {
                byte[] data2 = new byte[1024];
                DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
                // 2.接收服务器响应的数据
                socket.receive(packet2);
                // 3.读取数据
                String reply = new String(data2, 0, packet2.getLength());
                System.out.println("我是客户端，服务器说：" + reply);
            }
            // 4.关闭资源
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
