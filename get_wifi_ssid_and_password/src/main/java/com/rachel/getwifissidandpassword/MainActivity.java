package com.rachel.getwifissidandpassword;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Rachel
 */
public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Rachel_Wifi";
    private static final int REQUEST_PERMISSION = 10;
    private static String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE};
    private String ssid;
    private TextView ssidTv;
    private TextView pswTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //申请权限
        ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSION);
        //SSID
        ssidTv = findViewById(R.id.ssid);
        //密码
        pswTv = findViewById(R.id.psw);
        //设置值
        ssid = WifiUtil.getSSID();
        if (ssid != null) {
            ssidTv.setText(ssid);
            pswTv.setText(WifiUtil.getWifiPassword(ssid));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //请求权限的回调
        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED && grantResults[1] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "获取权限失败,部分功能可能无法正常使用！", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "获取权限失败,部分功能可能无法正常使用！");
            } else {
                Log.e(TAG, "获取权限成功！");
                //设置值
                ssid = WifiUtil.getSSID();
                if (ssid != null) {
                    ssidTv.setText(ssid);
                    pswTv.setText(WifiUtil.getWifiPassword(ssid));
                }
            }
        }
    }
}
