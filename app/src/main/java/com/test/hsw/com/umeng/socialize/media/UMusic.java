package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.umeng.socialize.b.b.e;
import java.util.HashMap;
import java.util.Map;

public class UMusic extends BaseMediaObject
{
  public static final Parcelable.Creator<UMusic> CREATOR = new w();
  private String h = "未知";
  private String i = "未知";
  private UMImage j;

  protected UMusic(Parcel paramParcel)
  {
    super(paramParcel);
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }

  public UMusic(String paramString)
  {
    super(paramString);
  }

  public void a(UMImage paramUMImage)
  {
    this.j = paramUMImage;
  }

  public void a(UMediaObject.FetchMediaDataListener paramFetchMediaDataListener)
  {
  }

  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.h = paramString;
  }

  public String c()
  {
    return this.h;
  }

  public final Map<String, Object> c_()
  {
    HashMap localHashMap = new HashMap();
    if (b())
    {
      localHashMap.put(e.y, this.a);
      localHashMap.put(e.z, g());
      localHashMap.put(e.A, this.h);
      localHashMap.put(e.C, this.i);
    }
    return localHashMap;
  }

  public byte[] d_()
  {
    if (this.j != null)
      return this.j.d_();
    return null;
  }

  public void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.i = paramString;
  }

  public UMediaObject.a g()
  {
    return UMediaObject.a.c;
  }

  public boolean h()
  {
    return true;
  }

  public String i()
  {
    return this.i;
  }

  public UMImage j()
  {
    return this.j;
  }

  public String toString()
  {
    return "UMusic [title=" + this.h + ", author=" + this.i + "media_url=" + this.a + ", qzone_title=" + this.b + ", qzone_thumb=" + this.c + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.UMusic
 * JD-Core Version:    0.6.0
 */