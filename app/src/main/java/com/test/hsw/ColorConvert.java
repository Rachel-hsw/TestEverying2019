package com.test.hsw;

/**
 * https://quietboy.net/posts/%E5%85%B3%E4%BA%8Ergba%E4%B8%8Ehex%E7%9A%84%E4%B8%80%E4%BA%9B%E4%BA%86%E8%A7%A3
 */
public class ColorConvert {
    public static void main(String[] args) {
        double parameter1=40;
        double parameter2=100;
        double alpha=parameter1/parameter2*256;
        //将其转换为十六进制并输出
        String strHex = Integer.toHexString((int) alpha);
        System.out.println(strHex);
    }
}
