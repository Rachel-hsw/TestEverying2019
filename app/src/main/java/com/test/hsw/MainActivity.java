package com.test.hsw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.test.hsw.Util.ByteUtil;
import com.test.hsw.rxjava.RxjavaActivity;
import com.test.hsw.rxjava.TestActivity;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Arrays;

/**
 * 测试UDP，监听端口
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goRxJavaActivity(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }
}
