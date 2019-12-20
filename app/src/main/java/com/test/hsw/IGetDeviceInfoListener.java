package com.test.hsw;

import java.net.InetAddress;
import java.net.SocketAddress;

public interface IGetDeviceInfoListener {
    void onCallBack(String info, SocketAddress socketAddress, InetAddress address);
}
