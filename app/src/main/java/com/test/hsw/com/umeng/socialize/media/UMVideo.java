package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.b.b.e;
import java.util.HashMap;
import java.util.Map;

public class UMVideo extends BaseMediaObject
{
  public static final Parcelable.Creator<UMVideo> CREATOR = new o();
  private UMImage h;

  protected UMVideo(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public UMVideo(String paramString)
  {
    super(paramString);
  }

  public void a(UMImage paramUMImage)
  {
    this.h = paramUMImage;
  }

  public void a(UMediaObject.FetchMediaDataListener paramFetchMediaDataListener)
  {
  }

  public final Map<String, Object> c_()
  {
    HashMap localHashMap = new HashMap();
    if (b())
    {
      localHashMap.put(e.y, this.a);
      localHashMap.put(e.z, g());
    }
    return localHashMap;
  }

  public byte[] d_()
  {
    if (this.h != null)
      return this.h.d_();
    return null;
  }

  public UMediaObject.a g()
  {
    return UMediaObject.a.b;
  }

  public boolean h()
  {
    return true;
  }

  public UMImage i()
  {
    return this.h;
  }

  public String toString()
  {
    return "UMVedio [media_url=" + this.a + ", qzone_title=" + this.b + ", qzone_thumb=" + this.c + "media_url=" + this.a + ", qzone_title=" + this.b + ", qzone_thumb=" + this.c + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.UMVideo
 * JD-Core Version:    0.6.0
 */