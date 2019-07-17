package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.bean.p;
import java.util.Map;

public abstract class SimpleShareContent
  implements UMediaObject
{
  protected String c = "";
  protected UMediaObject d = null;
  protected String e = getClass().getName();

  public SimpleShareContent()
  {
  }

  protected SimpleShareContent(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.c = paramParcel.readString();
      this.d = ((UMediaObject)paramParcel.readParcelable(UMediaObject.class.getClassLoader()));
    }
  }

  public SimpleShareContent(UMImage paramUMImage)
  {
    this.d = paramUMImage;
  }

  public SimpleShareContent(String paramString)
  {
    this.c = paramString;
  }

  public String a()
  {
    if (this.d != null)
      return this.d.a();
    return "";
  }

  public void a(UMImage paramUMImage)
  {
    this.d = paramUMImage;
  }

  public void a(UMVideo paramUMVideo)
  {
    this.d = paramUMVideo;
  }

  public void a(UMediaObject.FetchMediaDataListener paramFetchMediaDataListener)
  {
    if (this.d != null)
      this.d.a(paramFetchMediaDataListener);
  }

  public boolean b()
  {
    if (this.d != null)
      return this.d.b();
    return false;
  }

  public Map<String, Object> c_()
  {
    if (this.d != null)
      return this.d.c_();
    return null;
  }

  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }

  public void d(String paramString)
  {
    this.c = paramString;
  }

  public byte[] d_()
  {
    if (this.d != null)
      return this.d.d_();
    return null;
  }

  public int describeContents()
  {
    return 0;
  }

  public abstract p f();

  public UMediaObject.a g()
  {
    if (this.d != null)
      return this.d.g();
    return null;
  }

  public boolean h()
  {
    return true;
  }

  public String k()
  {
    return this.c;
  }

  public UMImage l()
  {
    if ((this.d instanceof UMImage))
      return (UMImage)this.d;
    return null;
  }

  public UMVideo m()
  {
    if ((this.d != null) && ((this.d instanceof UMVideo)))
      return (UMVideo)this.d;
    return null;
  }

  public String toString()
  {
    return "SimplaShareContent [mShareContent=" + this.c + ", mShareImage=" + this.d + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeParcelable(this.d, 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.SimpleShareContent
 * JD-Core Version:    0.6.0
 */