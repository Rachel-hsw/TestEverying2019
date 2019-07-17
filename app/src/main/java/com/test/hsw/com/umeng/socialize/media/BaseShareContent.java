package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import com.umeng.socialize.bean.ay;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseShareContent extends SimpleShareContent
{
  protected String a = "";
  protected String b = "";

  public BaseShareContent()
  {
  }

  protected BaseShareContent(Parcel paramParcel)
  {
    super(paramParcel);
    if (paramParcel != null)
    {
      this.a = paramParcel.readString();
      this.b = paramParcel.readString();
    }
  }

  public BaseShareContent(UMediaObject paramUMediaObject)
  {
    this.d = paramUMediaObject;
  }

  public BaseShareContent(String paramString)
  {
    this.c = paramString;
  }

  public String a()
  {
    if (this.d != null)
      return this.d.a();
    return "";
  }

  public void a(UMediaObject.FetchMediaDataListener paramFetchMediaDataListener)
  {
    if (this.d != null)
      this.d.a(paramFetchMediaDataListener);
  }

  public void a(UMediaObject paramUMediaObject)
  {
    this.d = paramUMediaObject;
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
    if (this.d != null)
      return this.d.b();
    return false;
  }

  public UMediaObject c()
  {
    return this.d;
  }

  public void c(String paramString)
  {
    ay.a(f(), paramString);
  }

  public Map<String, Object> c_()
  {
    if (this.d != null)
      return this.d.c_();
    return new HashMap();
  }

  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }

  public byte[] d_()
  {
    if (this.d != null)
      return this.d.d_();
    return null;
  }

  public UMediaObject.a g()
  {
    if (this.d != null)
      return this.d.g();
    if (!TextUtils.isEmpty(this.c))
      return UMediaObject.a.d;
    return null;
  }

  public boolean h()
  {
    return true;
  }

  public String i()
  {
    return this.a;
  }

  public String j()
  {
    return this.b;
  }

  public String toString()
  {
    return "BaseShareContent [mShareContent=" + this.c + ", mShareMedia=" + this.d + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.BaseShareContent
 * JD-Core Version:    0.6.0
 */