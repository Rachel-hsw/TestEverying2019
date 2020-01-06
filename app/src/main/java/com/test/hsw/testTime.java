package com.test.hsw;

public class testTime {
    public static void main(String[] args) {
//        long time=System.currentTimeMillis();
        //时间采用Unix时间戳格式，4字节表示，如：十进制1576805496 ，十六进制表示为 5D FC 24 78 ，表示时间为 2019/12/20 9:31:36 。
        String time1 = Long.toHexString(1576805496);
        System.out.println(time1);
        try {
            byte[] data = new byte[4];
            for (int i = 0; i < 4; i++) {
                data[i] = (byte) Integer.parseInt(time1.substring(2 * i, 2 * i + 2), 16);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
