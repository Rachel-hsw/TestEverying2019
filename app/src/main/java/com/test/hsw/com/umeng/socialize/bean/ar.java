package com.umeng.socialize.bean;

import com.umeng.socialize.a.a;

public class ar
{
  public String a;
  public String b;

  public ar(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public String a()
    throws a
  {
    if (this.a != null)
    {
      if (this.b == null)
        this.b = "";
      return "{" + this.a.toString() + ":" + this.b + "}";
    }
    throw new a("can`t format snspair string.");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.ar
 * JD-Core Version:    0.6.0
 */