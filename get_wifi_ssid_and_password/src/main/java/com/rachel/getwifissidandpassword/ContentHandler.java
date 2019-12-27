package com.rachel.getwifissidandpassword;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Rachel
 */
public class ContentHandler extends DefaultHandler {

    private List<WifiConfigEntity> configs = null;
    private WifiConfigEntity wifiConfig;
    /**
     * 当前解析的元素标签
     */
    private String tagName = null;

    List<WifiConfigEntity> getWifiConfig() {
        return configs;
    }

    /**
     * 【文档开始时，调用此方法】
     */
    @Override
    public void startDocument() throws SAXException {
        configs = new ArrayList<>();
    }

    /**
     * 【标签开始时，调用此方法】
     *
     * @param uri        命名空间
     * @param localName  不带命名空间前缀的标签名
     * @param qName      带命名空间前缀的标签名
     * @param attributes 可以得到所有的属性名和对应的值
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (localName.equals("WifiConfiguration")) {
            wifiConfig = new WifiConfigEntity();
        } else if (qName.equals("string")) {
            System.out.println("===============开始一个网络配置的解析================");
            //这个一个本书开始检验
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).equals("name")) {
                    this.tagName = attributes.getValue(i);
                }
            }
        }
    }

    /**
     * 【接收标签中字符数据时，调用此方法】
     *
     * @param ch     存放标签中的内容
     * @param start  起始位置
     * @param length 内容长度
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        if (tagName != null) {
            String data = new String(ch, start, length);
            if (tagName.equals("SSID")) {
                //增加不为引号的判断
                if (!data.isEmpty() && !"\"".equals(data)) {
                    this.wifiConfig.setSSID(data);
                }
            } else if (tagName.equals("PreSharedKey")) {
                if (!data.isEmpty() && !"\"".equals(data)) {
                    this.wifiConfig.setPreSharedKey(data);
                }
            }
        }
    }

    /**
     * 【标签结束时，调用此方法】
     *
     * @param uri
     * @param localName 元素本地名称（不带前缀）
     * @param qName     元素的限定名（带前缀）
     */
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (localName.equals("WifiConfiguration")) {
            configs.add(wifiConfig);
            wifiConfig = null;
        }
        this.tagName = null;
    }
}