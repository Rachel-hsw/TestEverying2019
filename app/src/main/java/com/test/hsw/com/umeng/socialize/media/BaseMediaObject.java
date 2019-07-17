package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import com.umeng.socialize.bean.p;

public abstract class BaseMediaObject
  implements UMediaObject
{
  protected String a = "";
  protected String b = "";
  protected String c = "";
  protected String d = "";
  protected String e = "";
  protected String f = "";
  protected int g = 0;

  public BaseMediaObject()
  {
  }

  protected BaseMediaObject(Parcel paramParcel)
  {
    if (paramParcel != null)
    {
      this.a = paramParcel.readString();
      this.b = paramParcel.readString();
      this.c = paramParcel.readString();
      this.d = paramParcel.readString();
    }
  }

  public BaseMediaObject(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public boolean b()
  {
    return !TextUtils.isEmpty(this.a);
  }

  public String c()
  {
    return this.b;
  }

  public void c(String paramString)
  {
    this.c = paramString;
  }

  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }

  public String d()
  {
    return this.c;
  }

  public void d(String paramString)
  {
    this.d = paramString;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.d;
  }

  public p f()
  {
    return p.b;
  }

  public String toString()
  {
    return "BaseMediaObject [media_url=" + this.a + ", qzone_title=" + this.b + ", qzone_thumb=" + this.c + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.BaseMediaObject
 * JD-Core Version:    0.6.0
 */