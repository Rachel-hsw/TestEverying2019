package com.umeng.socialize.media;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.b.b.e;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UMEmoji extends BaseMediaObject
{
  public static final Parcelable.Creator<UMEmoji> CREATOR = new i();
  public UMImage h;
  public UMImage i;

  public UMEmoji(Context paramContext, File paramFile)
  {
    this.i = new UMImage(paramContext, paramFile);
  }

  public UMEmoji(Context paramContext, String paramString)
  {
    super(paramString);
    this.i = new UMImage(paramContext, paramString);
  }

  protected UMEmoji(Parcel paramParcel)
  {
    super(paramParcel);
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
      return this.i.d_();
    return null;
  }

  public UMediaObject.a g()
  {
    return UMediaObject.a.a;
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
    return "UMEmoji [" + this.h.toString() + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.UMEmoji
 * JD-Core Version:    0.6.0
 */