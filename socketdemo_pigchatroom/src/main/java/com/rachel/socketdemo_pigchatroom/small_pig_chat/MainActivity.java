package com.rachel.socketdemo_pigchatroom.small_pig_chat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rachel.socketdemo_pigchatroom.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个简易聊天系统
 * 接着到客户端，客户端的难点在于要另外开辟线程的问题，因为Android不允许直接在主线程中做网络操作，
 * 而且不允许在主线程外的线程操作UI，这里的做法是自己新建 一个线程，以及通过Hanlder来更新UI，实际
 * 开发不建议直接这样做！！！
 *
 * @author Rachel
 */
public class MainActivity extends AppCompatActivity {

    /**
     * 定义相关变量,完成初始化
     */
    private TextView txtshow;
    private EditText editsend;
    private Button btnsend;
    /**
     * 内网地址，而不是网卡地址
     */
    private static final String HOST = "192.168.50.238";
    private static final int PORT = 12345;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String content = "";
    private StringBuilder sb = null;
    private ExecutorService singlePool = Executors.newSingleThreadExecutor();

    /**
     * 定义一个handler对象,用来刷新界面
     */
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                sb.append(content);
                txtshow.setText(sb.toString());
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);
        sb = new StringBuilder();
        txtshow = (TextView) findViewById(R.id.txtshow);
        editsend = (EditText) findViewById(R.id.editsend);
        btnsend = (Button) findViewById(R.id.btnsend);

        //当程序一开始运行的时候就实例化Socket对象,与服务端进行连接,获取输入输出流
        //因为4.0以后不能再主线程中进行网络操作,所以需要另外开辟一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (socket != null && socket.isConnected()) {
                            if (!socket.isInputShutdown()) {
                                if ((content = in.readLine()) != null) {
                                    content += "\n";
                                    handler.sendEmptyMessage(0x123);
                                }
                            }
                        }
                    } catch (Exception e) {
                        Log.e("Rachel_test", e + "");
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        //为发送按钮设置点击事件
        btnsend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (socket == null || !socket.isConnected()) {
                    connect();
                }
                singlePool.execute(new Runnable() {
                    @Override
                    public void run() {
                        String msg = editsend.getText().toString();
                        if (socket != null && socket.isConnected()) {
                            if (!socket.isOutputShutdown()) {
                                out.println(msg);
                            }
                        }
                    }
                });
            }
        });
    }

    private void connect() {
        singlePool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket();
                    //设置连接超时时间
                    socket.connect(new InetSocketAddress(HOST, PORT), 1000);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                } catch (Exception e) {
                    Log.e("Rachel_test", e + "");
                    e.printStackTrace();
                }
            }
        });
    }


}