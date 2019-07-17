package com.gensee.common;

import android.os.Environment;
import java.io.File;

public class GenseeConstant
{
  public static final String FILE_PUB_DIR;
  public static final String FILE_VOD_DIR = Environment.getExternalStorageDirectory().getPath() + "/vod/";
  public static final String ST_CASTLINE = "";
  public static final String ST_MEETING = "";
  public static final String ST_TRAINING = "";

  static
  {
    FILE_PUB_DIR = Environment.getExternalStorageDirectory().getPath() + "/pub/";
  }

  public static abstract interface CommonErrCode
  {
    public static final int ERR_DATA_TIMEOUT = -105;
    public static final int ERR_DOMAIN = -100;
    public static final int ERR_JSON_ERROR = -1;
    public static final int ERR_PARAM = -107;
    public static final int ERR_SERVICE = -106;
    public static final int ERR_SITE_UNUSED = -103;
    public static final int ERR_THIRD_CERTIFICATION_AUTHORITY = -108;
    public static final int ERR_TIME_OUT = -101;
    public static final int ERR_UNKNOWN = -102;
    public static final int ERR_UN_CONNECTED = -109;
    public static final int ERR_UN_NET = -104;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.common.GenseeConstant
 * JD-Core Version:    0.6.0
 */