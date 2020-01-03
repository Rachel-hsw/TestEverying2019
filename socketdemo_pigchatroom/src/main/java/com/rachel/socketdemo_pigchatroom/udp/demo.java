package com.rachel.socketdemo_pigchatroom.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class demo {
    public static void main(String[] args) {

    }
    public void listen() {
        new Thread(() -> {
            try {
                DatagramSocket socket = null;
                try {
                    socket = new DatagramSocket(65534);
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                byte[] data = new byte[1024];
                DatagramPacket packet = new DatagramPacket(data, data.length);
                //接收设备发送的数据
                // 此方法在接收到数据报之前会一直阻塞
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // 4.读取数据
                String info = new String(data, 0, packet.getLength());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }
}
