package com.rachel.getwifissidandpassword;

import android.net.DhcpInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.SAXParserFactory;

import static android.content.Context.WIFI_SERVICE;

/**
 * @author Rachel
 */
public class WifiUtil {
    private final static String TAG = "Rachel_Wifi";
    private static WifiManager wifiManager;

    /**
     * 获取当前连接wifi的SSID 需要权限，特别是8.0以后需要动态添加定位权限
     *
     * @return SSID
     */
    static String getSSID() {
        wifiManager = (WifiManager) WifiApplication.get().getApplicationContext().getSystemService(WIFI_SERVICE);
        //动态主机配置协议信息的对象，获得IP等网关信息
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        //8.0以后
        String ssid = wifiInfo.getSSID();
        //取到的结果为"SSID",所以需要去除第一个和最后一个"
        ssid = ssid.substring(1, ssid.length() - 1);
        return ssid;
    }

    /**
     * 获取当前连接wifi的密码 需要读取data目录下的文件，所以需要Root权限.系统App就更好了
     *
     * @param ssid SSID
     * @return 密码
     */
    static String getWifiPassword(String ssid) {
        String wifiPassword = "获取不到";
        try {
            wifiPassword = getPsw(ssid);
//            wifiPassword = getPswV8(ssid);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getPsw error");
        }
        //纯粹是想打印一下wifi信息
        DhcpInfo dhcpinfo = wifiManager.getDhcpInfo();
        String wifiDetail = "当前网络信息如下:" + "\n" + ssid + "\n" + "=====================" + "\n"
                + "ip:   " + formatString(dhcpinfo.ipAddress) + "\n"
                + "mask:   " + formatString(dhcpinfo.netmask) + "\n"
                + "netgate:   " + formatString(dhcpinfo.gateway) + "\n"
                + "dns:   " + formatString(dhcpinfo.dns1) + "\n"
                + "密码:   " + wifiPassword + "\n";
        Log.e(TAG, wifiDetail);
        return wifiPassword;
    }

    /**
     * 获取已配置的Wi-Fi网络，包括安全配置
     *
     * @param ssid SSID
     * @return 配置实体
     */
    public WifiConfiguration getWifiConfiguration(String ssid) {
        // 当前ssid的配置
        return isExists(ssid);
    }

    /**
     * Android8.0（Oreo）之前版本 wifi密码的存储位置：/data/misc/wifi/WifiConfigStore.xml
     *
     * @param ssid SSID
     * @return 密码
     */
    private static String getPswV8(String ssid) {
//        return parseXMLWithPull("WifiConfigStore.xml", ssid);
        return parseXMLWithSAX("WifiConfigStore.xml", ssid);
    }

    /**
     * Android8.0（Oreo）之前版本 wifi密码的存储位置：/data/misc/wifi/wpa_supplicant.conf
     *
     * @param wifiName SSID
     * @return 密码
     */
    private static String getPsw(String wifiName) {
        String psw = "";
        StringBuffer fileContent = getWifiConfig("wpa_supplicant.conf");
        //匹配password
        Log.e(TAG, "PATTERN the password");
        String regex = "network=\\{([^}]+)\\}";
        Pattern network = Pattern.compile(regex, Pattern.DOTALL);
        Matcher networkMatcher = network.matcher(fileContent.toString());
        while (networkMatcher.find()) {
            String networkBlock = networkMatcher.group();
            Pattern ssid = Pattern.compile("ssid=\"" + wifiName + "\"");
            Matcher ssidMatcher = ssid.matcher(networkBlock);
            if (ssidMatcher.find()) {
                String pskRegex = "psk=\"([^\"]+)\"";
                Pattern psk = Pattern.compile(pskRegex);
                Matcher pskMatcher = psk.matcher(networkBlock);
                if (pskMatcher.find()) {
                    psw = pskMatcher.group(1);
                } else {
                    psw = "无密码";
                }
            } else {
                Log.e(TAG, "do not find the ssid");
            }
        }
        Log.e(TAG, psw);
        return psw;
    }

    /**
     * 通过命令行语句读取文件数据
     *
     * @param fileName 要读取的文件名称
     * @return 文件内容字符串
     */
    private static StringBuffer getWifiConfig(String fileName) {
        StringBuffer fileContent = new StringBuffer();
        Process process = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());
            dataInputStream = new DataInputStream(process.getInputStream());
            dataOutputStream.writeBytes("cat /data/misc/wifi/" + fileName + "\n");
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            InputStreamReader inputStreamReader = new InputStreamReader(dataInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            process.waitFor();
        } catch (Exception e) {
            Log.e(TAG, "not root");
        } finally {
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                process.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileContent;
    }

    /**
     * 通过File读取文件数据 要添加读取权限
     * 不知道为什么即使是系统应用我也没办法直接去读data下的数据 
     *
     * @param fileName 要读取的文件名称
     * @return 文件内容字符串
     */
    private static StringBuffer readFile(String fileName) {
        StringBuffer fileContent = new StringBuffer();
        String filePath = "/data/misc/wifi/" + fileName;
        File file = new File(filePath);
        FileInputStream fis = null;
        try {
            // TODO: 2019/9/25 java.io.FileNotFoundException: /data/misc/wifi/WifiConfigStore.xml (Permission+denied)
            fis = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.append(line);
            }
            return fileContent;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
        return fileContent;
    }

    /**
     * 解析XML格式数据
     * 用法比Pull解析要复杂一些，但在语义方面会更加的清楚。
     * 需要及时处理且不要保存数据考虑SAX
     *
     * @param fileName 需要解析的文件名称
     * @param ssid     SSID
     * @return 当前连接的Wifi的密码
     */
    private static String parseXMLWithSAX(String fileName, String ssid) {
        StringBuffer xmlData = getWifiConfig(fileName);
//        StringBuffer xmlData = readFile(fileName);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHandler handler = new ContentHandler();
            // 将ContentHandler的实例设置到XMLReader中
            xmlReader.setContentHandler(handler);
            // 开始执行解析
            xmlReader.parse(new InputSource(new StringReader(xmlData.toString())));
            List<WifiConfigEntity> list = handler.getWifiConfig();
            return getCurrentPassword(list, ssid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 根据wifi列表获取当前SSID的密码
     *
     * @param list wifi列表
     * @param ssid SSID
     * @return 密码
     */
    private static String getCurrentPassword(List<WifiConfigEntity> list, String ssid) {
        String password = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSSID().equals(ssid)) {
                password = list.get(i).getPreSharedKey();
            }
        }
        return password;
    }

    /**
     * 解析XML格式数据
     * Pull解析
     *
     * @param fileName 需要解析的文件名称
     * @param ssid     SSID
     * @return 当前连接的Wifi的密码
     */
    private static String parseXMLWithPull(String fileName, String ssid) {
        StringBuffer xmlData = getWifiConfig(fileName);
//        StringBuffer xmlData = readFile(fileName);
        List<WifiConfigEntity> list = new ArrayList<>();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData.toString()));
            int eventType = xmlPullParser.getEventType();
            WifiConfigEntity wifiConfig = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    // 开始解析某个结点
                    case XmlPullParser.START_TAG: {
                        if ("WifiConfiguration".equals(nodeName)) {
                            wifiConfig = new WifiConfigEntity();
                        } else if ("string".equals(nodeName)) {
                            String mName = xmlPullParser.getAttributeValue(0);
                            if ("SSID".equals(mName)) {
                                String value = xmlPullParser.nextText();
                                if (!value.isEmpty()) {
                                    value = value.substring(1, value.length() - 1);
                                }
                                wifiConfig.setSSID(value);
                            } else if ("PreSharedKey".equals(mName)) {
                                String value = xmlPullParser.nextText();
                                if (!value.isEmpty()) {
                                    value = value.substring(1, value.length() - 1);
                                }
                                wifiConfig.setPreSharedKey(value);
                            }
                        }
                        break;
                    }
                    // 完成解析某个结点
                    case XmlPullParser.END_TAG: {
                        if ("WifiConfiguration".equals(nodeName)) {
                            list.add(wifiConfig);
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getCurrentPassword(list, ssid);
    }

    private static String formatString(int value) {
        StringBuilder strValue = new StringBuilder();
        byte[] ary = intToByteArray(value);
        for (int i = ary.length - 1; i >= 0; i--) {
            strValue.append(ary[i] & 0xFF);
            if (i > 0) {
                strValue.append(".");
            }
        }
        return strValue.toString();
    }

    private static byte[] intToByteArray(int value) {
        byte[] b = new byte[4];
        for (int i = 0; i < 4; i++) {
            int offset = (b.length - 1 - i) * 8;
            b[i] = (byte) ((value >>> offset) & 0xFF);
        }
        return b;
    }

    private static WifiConfiguration isExists(String ssid) {
        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).SSID.equals(ssid)) {
                return list.get(i);
            }
        }
        return null;
    }
}
