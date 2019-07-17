package com.gensee.download;

public abstract interface IDownloadCallback
{
  public abstract void onDLError(String paramString, int paramInt);

  public abstract void onDLPosition(String paramString, int paramInt);

  public abstract void onDLPrepare(String paramString);

  public abstract void onDLStart(String paramString);

  public abstract void onDLStop(String paramString);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.IDownloadCallback
 * JD-Core Version:    0.6.0
 */