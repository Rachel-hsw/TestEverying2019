package com.gensee.download;

public abstract interface ErrorCode
{
  public static final int DOWNLOADING_HAVE_EXIST = 2;
  public static final int DOWNLOADING_URL_NULL = 6;
  public static final int DOWNLOAD_INIT_PARAMS_ERROR = 8;
  public static final int ERROR_LICENSE = 12;
  public static final int ERR_UN_INVOKE_GETOBJECT = -201;
  public static final int FAILED = 7;
  public static final int OBJECT_HAVE_EXIST = 1;
  public static final int OBJECT_IS_NULL = 5;
  public static final int OBJECT_NOT_EXIST = 4;
  public static final int SDCARD_ERROR = 3;
  public static final int SDCARD_OR_FILEDIR_UNABLE = 9;
  public static final int SUCCESS;
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.ErrorCode
 * JD-Core Version:    0.6.0
 */