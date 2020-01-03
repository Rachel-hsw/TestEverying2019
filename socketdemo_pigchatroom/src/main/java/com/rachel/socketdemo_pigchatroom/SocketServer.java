package com.rachel.socketdemo_pigchatroom;

import com.alibaba.fastjson.JSON;
import com.rachel.socketdemo_pigchatroom.bean.ResponseInfo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

import static com.rachel.socketdemo_pigchatroom.Constants.TCP_PORT;

/**
 * Step 1：创建ServerSocket对象，绑定监听的端口
 * <p>
 * Step 2：调用accept()方法监听客户端的请求
 * <p>
 * Step 3：连接建立后，通过输入流读取客户端发送的请求信息
 * <p>
 * Step 4：通过输出流向客户端发送响应信息
 * <p>
 * Step 5：关闭相关资源
 */
public class SocketServer {


    public static void main(String[] args) throws IOException {
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
//        sendDataOutputStream(os);
        sendOutputStream(os);
        System.out.println("通知客户端,服务器已收到!");
        //关闭输入流
        socket.shutdownInput();
        socket.close();
    }

    private static void sendOutputStream(OutputStream os) throws IOException {
        ResponseInfo info = new ResponseInfo();
        info.setStatus(true);
        String jsonString = JSON.toJSONString(info);
        os.write(jsonString.getBytes());
        os.flush();
    }

    private static void sendDataOutputStream(OutputStream os) throws IOException {
        DataOutputStream dos = new DataOutputStream(os);
//        dos.writeInt(200);
        dos.writeUTF("{ \"status\": true }");
        dos.flush();
    }
}