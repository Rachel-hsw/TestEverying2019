package com.gensee.download;

public class VodDownLoadJni
{
  public native int download(String paramString1, String paramString2, String paramString3);

  public native int initDownLoadService(Object paramObject, long paramLong1, long paramLong2, String paramString1, String paramString2);

  public native int releaseDownLoadService();

  public native int stopDownLoading(String paramString);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoadJni
 * JD-Core Version:    0.6.0
 */