package com.test.hsw.all;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Program {
    public static void main(String[] args) {
        Counter counter = new Counter();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("请输入数字A");


        // 从控制台读取一行数据，返回值字符串
        try {
            str = br.readLine();
            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Enter 'exit' to quit.");
    }
}
