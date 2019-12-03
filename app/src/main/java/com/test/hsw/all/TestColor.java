package com.test.hsw.all;

public class TestColor {
    public static void main(String[] args) {
        //位运算符的具体使用：处理颜色值。
        int color = 0xff123456;
        int B = (color & 0xff) >>> 0;
        int G = (color & 0xff00) >>> 8;
        int R = (color & 0xff0000) >>> 16;
        int A = (color & 0xff000000) >>> 24;
        System.out.println(Integer.toHexString(B));
        System.out.println(Integer.toHexString(G));
        System.out.println(Integer.toHexString(R));
        System.out.println(Integer.toHexString(A));
        //&0xff是为了保留低八位
        color = (B & 0xff) + ((G & 0xff) << 8) + ((R & 0xff) << 16) + ((A & 0xff) << 24);
        System.out.println(Integer.toHexString(color));
        //求相反数
        System.out.println("-10的相反数：" + getOppositeNumber(-10));
        System.out.println("-12423的相反数：" + getOppositeNumber(-12423));
        System.out.println("Integer.MIN_VALUE的相反数：" + Integer.toHexString(getOppositeNumber(Integer.MIN_VALUE)));
        System.out.println("10的相反数：" + getOppositeNumber(10));
        System.out.println("2346760的相反数：" + getOppositeNumber(2346760));
        System.out.println("Integer.MAX_VALUE的相反数：" + Integer.toHexString(getOppositeNumber(Integer.MAX_VALUE)));
        System.out.println("0的相反数：" + getOppositeNumber(0));
        //加法
        System.out.println(add(12, 342));
        System.out.println(add(-12, 342));
        System.out.println(add(-12, -342));
        System.out.println(add(Integer.MAX_VALUE, 1));
        System.out.println(add(Integer.MIN_VALUE, -1));
        System.out.println(add(Integer.MIN_VALUE, 1));
        //乘法
        System.out.println(multiply(11, 12));
        System.out.println(multiply(-7, -26));
        System.out.println(multiply(-5, 9));
        System.out.println(multiply(0x10000, 0x10000));
        //除法
        System.out.println(divide(100, 3));
        System.out.println(divide(32424, 200));
        System.out.println(divide(239, 13));

    }

    public static int getOppositeNumber(int number) {
        System.out.println("getOppositeNumber============================" + Integer.toBinaryString(number));
        //1000 0000 0000 0000 0000 0000 0000 0000
        //保留最高位 如果最高位为1，为负数
        if ((number & 0x80000000) == 0x80000000) {
            // number是负数
            //负数存补码，
            // -10的原码1000 0000 0000 0000 0000 0000 0000 1010
            //反码，除符号位取反1111 1111 1111 1111 1111 1111 1111 0101
            //补码+1，
            // 下面这段，减1操作：1111 1111 1111 1111 1111 1111 1111 0110--》11111111111111111111111111110101
            // 就是先把这个数看作一个无符号的数，
            //执行-1，方法是从最低位算起，
            //如果遇到0，就将之变成1
            //如果遇到1，就将之变成0，并跳出循环
            for (int i = 0; i <= 31; i++) {
                int flag = 1 << i;
                if ((number & flag) == flag) {
                    //i=1;flag=0000 0000 0000 0000 0000 0000 0000 0010
                    //number===1111 1111 1111 1111 1111 1111 1111 0111
                    //异或操作=1111 1111 1111 1111 1111 1111 1111 0101
                    // ^位异或，两个一样为假，两个不一样为真。
                    // 当前位是1,就换成0
                    number = number ^ flag;
                    break;
                } else {
                    //i=0;flag=0000 0000 0000 0000 0000 0000 0000 0001
                    //number===1111 1111 1111 1111 1111 1111 1111 0110
                    //异或操作=1111 1111 1111 1111 1111 1111 1111 0111
                    //当前位是0,就换成1
                    number = number ^ flag;
                }
            }
            // 执行全部位的取反
            //number=====1111 1111 1111 1111 1111 1111 1111 0101
            //0xffffffff=1111 1111 1111 1111 1111 1111 1111 1111
            //异或操作===0000 0000 0000 0000 0000 0000 0000 1010
            return number ^ 0xffffffff;

        } else {
            // number是正数
            // 执行取反
            number = number ^ 0xffffffff;
//            System.out.println(number);
            // 执行+1，方法和执行-1差不多
            for (int i = 0; i <= 31; i++) {
//                System.out.println(number);
                int flag = 1 << i;
                if ((number & flag) != flag) {
                    // 当前位是0,就换成1
                    number = number ^ flag;
                    break;
                } else {
                    number = number ^ flag;
                }
            }
            return number;
        }

    }

    public static int divide(int a, int b) {
        if (b > a) {
            return 0;
        }
        //获取a的最高位
        int maxA = 0;
        for (int i = 0; i < 31; i++) {
            int flag = 1 << 31 - i;
            if ((a & flag) == flag) {
                maxA = 31 - i;
                break;
            }
        }

        //获取b的最高位
        int maxB = 0;
        for (int i = 0; i < 31; i++) {
            int flag = 1 << 31 - i;
            if ((b & flag) == flag) {
                maxB = 31 - i;
                break;
            }
        }
//        System.out.println("maxA " + maxA + " maxB " + maxB);
        int index = maxA - maxB;
        int sum = 0;
        for (int i = 0; i <= index; i++) {
            if (a > b << (index - i)) {
                sum += 1 << (index - i);
                a -= b << (index - i);
//                System.out.println("sum" + sum);
            }
        }
        return sum;
    }

    public static int multiply(int a, int b) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int flag = 1 << i;

            if ((a & flag) == flag) {
                sum += b << i;
            }
//            System.out.println("sum " + sum);
        }
        return sum;

    }

    public static int add(int a, int b) {
        int sum = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int flag = 1 << i;

            int currentIndex = ((a ^ b)) & flag;
            int currentCarry = ((a & b) & flag) << 1;
            if (carry == 0) {
                sum = sum | currentIndex;
                carry = currentCarry;
            } else {
                if (currentIndex == 0) {
                    sum = sum | flag;
                    carry = currentCarry;
                } else {
                    carry = 1;
                }
            }
//            System.out.println("currentIndex "+currentIndex+" currentCarry "+currentCarry+" carry "+carry+" sum "+sum);
        }
        return sum;
    }


}
