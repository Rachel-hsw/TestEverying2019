package com.test.hsw.rxjava;

public class Test {

    public static void main(String[] args) {
        byte[] cmd1 = {(byte) 0xA5, 0x5A, 0x05, 0x01, 0x04, 0x00, 0x09};
        byte vale1 = getParity(cmd1);
        String receiverData = Byte2Hex(vale1);
        System.out.println("接收数据:" + receiverData);

        byte[] cmd2 = {(byte) 0xA5, 0x5A, 0x05, 0x01, 0x04, 0x00};
        int vale2 = cmdCheck(cmd2);
        System.out.println("接收数据:" + vale2);

    }

    public static String Byte2Hex(Byte inByte) {
        return String.format("%02x", inByte).toUpperCase();
    }

    /**
     * 获取校验位，累加校验和
     */
    private static byte getParity(byte[] cmd) {
        byte parity = 0x00;
        for (int i = 0; i < cmd.length - 1; i++) {
            parity += (cmd[i] & 0xff);
        }
        return parity;
    }

    /**
     * 获取校验位，累加校验和
     * @param data
     * @return
     */
    public static int cmdCheck(byte[] data) {
        int total = 0;
        int len = data.length;
        int num = 0;
        while (num < len) {
            byte s = data[num];
            total += (s & 0xff);
            num++;
        }
        //用256求余最大是255，即16进制的FF
        int mod = total % 256;
        String hex = Integer.toHexString(mod);
        len = hex.length();
        // 如果不够校验位的长度，补0,这里用的是两位校验
        if (len < 2) {
            hex = "0" + hex;
        }
        return Integer.parseInt(hex, 16);
    }
}
