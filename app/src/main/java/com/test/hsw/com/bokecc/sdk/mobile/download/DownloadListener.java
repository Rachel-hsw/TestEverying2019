package com.bokecc.sdk.mobile.download;

import com.bokecc.sdk.mobile.exception.DreamwinException;

public abstract interface DownloadListener
{
  public abstract void handleCancel(String paramString);

  public abstract void handleException(DreamwinException paramDreamwinException, int paramInt);

  public abstract void handleProcess(long paramLong1, long paramLong2, String paramString);

  public abstract void handleStatus(String paramString, int paramInt);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.download.DownloadListener
 * JD-Core Version:    0.6.0
 */