package com.test.hsw.newton;

/**
 * 使用牛顿迭代法求方程的解：
 * x^3-2x-5=0
 * 区间为[2,3]
 * 这里的"^"表示乘方。
 * 没看懂
 */
public class NewtonIterationMethod {

    public static void main(String[] args) {
        double x=50;
        for(int i=0;i<20;i++) {
            x=-f(x)/f1(x)+x;
        }
        System.out.println(x+"");
    }

    /**
     * 原函数
     * @param x
     * @return
     */
    static double f(double x) {
        double ans;
        ans= Math.pow(x, 3)-2*x-5;
        return ans;
    }

    /**
     * 导数
     * @param x
     * @return
     */
    static double f1(double x) {
        double ans;
        ans=3* Math.pow(x, 2)-2;
        return ans;
    }
}
