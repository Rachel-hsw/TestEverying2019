package com.test.hsw.all;


public class Test {
    public static void main(String[] args) {
        //byte 8位  取值范围是 -128~127
        int temp = 5000;
        byte low = (byte) 5000;
        byte high = (byte) ((temp & 0xFF00) >> 8);
        int result = ((high & 0xff) << 8) + (low & 0xff);
        System.out.println(high);//19
        System.out.println(low);//-120
        System.out.println(result);//5000
        System.out.println(String.format("%02x", high).toUpperCase());//13
        System.out.println(String.format("%02x", low).toUpperCase());//88

        byte x = (byte) 128;
        byte y = (byte) -129;
        System.out.println(x);//-128
        System.out.println(y);//127
    }
}