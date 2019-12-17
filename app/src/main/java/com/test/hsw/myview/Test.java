package com.test.hsw.myview;

public class Test {
    public static void main(String args[]) {
        //角度
        double degrees = 60.0;
        //将角度转换为弧度
        double radians = Math.toRadians(degrees);
        //根据弧度值求其余弦值
        double cos = Math.cos(radians);
        System.out.format("余弦：%.1f%n", cos);
        //获取余弦值求反余弦值（弧度）
        double degree = Math.acos(cos);
        System.out.format("角度：%.1f%n", Math.toDegrees(degree));

        //Π
        System.out.format("pi (Π)的值为 %.4f%n", Math.PI);
        //2Π=360°，即1弧度=180°/Π.所以弧度转角度，弧度* 180 / Math.PI;
        double angle = degree * 180 / Math.PI;
        System.out.format("%.2f弧度的角度值为 %.2f%n", degree, angle);
    }
}