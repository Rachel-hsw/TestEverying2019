package com.gensee.media;

import com.gensee.entity.DocInfo;

public abstract interface IOLPlayerCallback
{
  public abstract void onAnimation(int paramInt);

  public abstract void onAnnotaion(int paramInt, String paramString);

  public abstract void onAudio(int paramInt1, byte[] paramArrayOfByte, int paramInt2, short paramShort);

  public abstract void onBuffer(boolean paramBoolean);

  public abstract void onInit(int paramInt1, boolean paramBoolean1, int paramInt2, DocInfo[] paramArrayOfDocInfo, int paramInt3, boolean paramBoolean2);

  public abstract void onPage(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);

  public abstract void onPage(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, String paramString);

  public abstract void onSeek(int paramInt);

  public abstract void onStop();

  public abstract void onVideo(int paramInt1, byte[] paramArrayOfByte, int paramInt2);

  public abstract void onVideoParam(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.IOLPlayerCallback
 * JD-Core Version:    0.6.0
 */