package com.rachel.socketdemo_pigchatroom.small_pig_chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 首先是服务端，就是将读写socket的操作放到自定义线程当中，创建ServerSocket后，循环 调用accept方法，当有新客户端接入，将socket加入集合当中，同时在线程池新建一个线程！
 * <p>
 * 另外，在读取信息的方法中，对输入字符串进行判断，如果为bye字符串，将socket从集合中 移除，然后close掉！
 * <p>
 * 定义相关的参数,端口,存储Socket连接的集合,ServerSocket对象以及线程池
 *
 * @author Rachel
 */
public class Server {
    private static final int PORT = 12345;
    private List<Socket> mList = new ArrayList<Socket>();
    private ServerSocket server = null;
    private ExecutorService myExecutorService = null;


    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        try {
            server = new ServerSocket(PORT);
            //创建线程池
            myExecutorService = Executors.newCachedThreadPool();
            System.out.println("服务端运行中...\n");
            Socket client = null;
            while (true) {
                client = server.accept();
                mList.add(client);
                myExecutorService.execute(new Service(client));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Service implements Runnable {
        private Socket socket;
        private BufferedReader in = null;
        private String msg = "";

        public Service(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                msg = "用户:" + this.socket.getInetAddress() + "~加入了聊天室"
                        + "当前在线人数:" + mList.size();
                this.sendmsg();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            try {
                while (true) {
                    if ((msg = in.readLine()) != null) {
                        if (msg.equals("bye")) {
                            System.out.println("~~~~~~~~~~~~~");
                            mList.remove(socket);
                            in.close();
                            msg = "用户:" + socket.getInetAddress()
                                    + "退出:" + "当前在线人数:" + mList.size();
                            socket.close();
                            this.sendmsg();
                            break;
                        } else {
                            msg = socket.getInetAddress() + "   说: " + msg;
                            this.sendmsg();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //为连接上服务端的每个客户端发送信息
        public void sendmsg() {
            System.out.println(msg);
            int num = mList.size();
            for (int index = 0; index < num; index++) {
                Socket mSocket = mList.get(index);
                PrintWriter pout = null;
                try {
                    pout = new PrintWriter(new BufferedWriter(
                            new OutputStreamWriter(mSocket.getOutputStream(), "UTF-8")), true);
                    pout.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}