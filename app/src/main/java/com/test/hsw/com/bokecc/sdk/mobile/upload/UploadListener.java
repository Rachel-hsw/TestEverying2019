package com.bokecc.sdk.mobile.upload;

import com.bokecc.sdk.mobile.exception.DreamwinException;

public abstract interface UploadListener
{
  public abstract void handleCancel(String paramString);

  public abstract void handleException(DreamwinException paramDreamwinException, int paramInt);

  public abstract void handleProcess(long paramLong1, long paramLong2, String paramString);

  public abstract void handleStatus(VideoInfo paramVideoInfo, int paramInt);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.upload.UploadListener
 * JD-Core Version:    0.6.0
 */