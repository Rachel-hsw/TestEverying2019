package com.umeng.socialize.media;

import android.os.Parcel;
import java.util.Map;

public class UMWebPage extends BaseMediaObject
{
  private String h = "";
  private UMImage i = null;

  protected UMWebPage(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public UMWebPage(String paramString)
  {
    super(paramString);
    this.d = paramString;
  }

  public void a(UMImage paramUMImage)
  {
    this.i = paramUMImage;
  }

  public void a(UMediaObject.FetchMediaDataListener paramFetchMediaDataListener)
  {
  }

  public Map<String, Object> c_()
  {
    return null;
  }

  public void d(String paramString)
  {
    super.d(paramString);
    this.a = paramString;
  }

  public byte[] d_()
  {
    return null;
  }

  public void e(String paramString)
  {
    this.h = paramString;
  }

  public UMediaObject.a g()
  {
    return UMediaObject.a.f;
  }

  public boolean h()
  {
    return true;
  }

  public String i()
  {
    return this.h;
  }

  public UMImage j()
  {
    return this.i;
  }

  public String toString()
  {
    return "UMWebPage [mDescription=" + this.h + ", mMediaTitle=" + this.b + ", mMediaThumb=" + this.c + ", mMediaTargetUrl=" + this.d + ", mLength=" + this.g + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.UMWebPage
 * JD-Core Version:    0.6.0
 */