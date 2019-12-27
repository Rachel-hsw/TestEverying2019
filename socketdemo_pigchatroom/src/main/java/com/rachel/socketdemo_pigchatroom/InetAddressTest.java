package com.rachel.socketdemo_pigchatroom;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * https://www.cnblogs.com/Orange42/p/9797117.html
 * InetAddress： 用于标识网络上的硬件资源
 * URL： 统一资源定位符，通过URL可以直接读取或者写入网络上的数据
 * <p>
 * 本机名：DESKTOP-89R0VGO
 * IP地址：192.168.30.1
 * 字节数组形式的IP地址：[-64, -88, 30, 1]
 * 直接输出InetAddress对象：DESKTOP-89R0VGO/192.168.30.1
 */
public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        //获取本机InetAddress的实例：InetAddress.getLocalHost().getHostAddress()是通过本机名去获取本机ip的
        //默认情况下本机名是localhost，如果在host文件中对应的ip是127.0.0.1，所以通过这个函数获取到的ip就是127.0.0.1了
        //经过测试，手机端通过这个方法获取到的ip就是127.0.0.1
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("本机名：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());
        byte[] bytes = address.getAddress();
        System.out.println("字节数组形式的IP地址：" + Arrays.toString(bytes));
        System.out.println("直接输出InetAddress对象：" + address);
        //IP地址在现在的网络环境更加复杂了，比如有Lan，WIFI，蓝牙热点，虚拟机网卡...比较好的方案应该是遍历所有网卡拿到ip列表，然后再选择其一
        ArrayList<String> addrList = NetUtil.getLocalIpAddr();
        for (String ip : addrList) {
            System.out.println("Local ip:" + ip);
        }
        //https://www.jianshu.com/p/f619663f0f0a
        //https://www.cnblogs.com/starcrm/p/7071227.html
        //获取当前使用的ip
        Optional<Inet4Address> ip4Address= (Optional<Inet4Address>) NetUtil.getLocalIp4Address();
        System.out.println("Local ip:" + ip4Address);
    }
}