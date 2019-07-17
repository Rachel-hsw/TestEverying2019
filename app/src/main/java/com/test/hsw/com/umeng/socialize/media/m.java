package com.umeng.socialize.media;

import android.os.AsyncTask;

class m extends AsyncTask<Void, Void, byte[]>
{
  m(UMImage paramUMImage, UMediaObject.FetchMediaDataListener paramFetchMediaDataListener)
  {
  }

  protected void a(byte[] paramArrayOfByte)
  {
    if (this.a != null)
      this.a.a(paramArrayOfByte);
  }

  protected byte[] a(Void[] paramArrayOfVoid)
  {
    return UMImage.c(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.m
 * JD-Core Version:    0.6.0
 */