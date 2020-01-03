package com.rachel.socketdemo_pigchatroom.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class 广播Server {
    public static void main(String[] args) {
        int port = 9999;//开启监听的端口
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];//存储发来的消息
        StringBuffer sbuf = new StringBuffer();
        try {
            //绑定端口的
            ds = new DatagramSocket(port);
            dp = new DatagramPacket(buf, buf.length);
            System.out.println("街上的帅哥美女们都准备好了：");
            ds.receive(dp);
            ds.close();
            int i;
            for(i=0;i<1024;i++){
                if(buf[i] == 0){
                    break;
                }
                sbuf.append((char) buf[i]);
            }
            System.out.println("听到街上有人说：" + sbuf.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
