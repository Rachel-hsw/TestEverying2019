package com.rachel.getwifissidandpassword;

class WifiConfigEntity {
    /**
     * SSID
     */
    private String SSID;
    /**
     * 密码
     */
    private String PreSharedKey;

    String getSSID() {
        return SSID;
    }

    void setSSID(String SSID) {
        this.SSID = SSID;
    }

    String getPreSharedKey() {
        return PreSharedKey;
    }

    void setPreSharedKey(String preSharedKey) {
        PreSharedKey = preSharedKey;
    }
}
