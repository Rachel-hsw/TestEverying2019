package com.umeng.socialize.bean;

import android.text.TextUtils;

public class bf extends ar
{
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;

  private bf(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }

  public static bf a(ar paramar, String paramString)
  {
    bf localbf = new bf(paramar.a, paramar.b);
    localbf.a(paramString);
    return localbf;
  }

  public static bf a(ar paramar, String paramString1, String paramString2)
  {
    bf localbf = new bf(paramar.a, paramar.b);
    localbf.a(paramString1);
    localbf.b(paramString2);
    return localbf;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public String b()
  {
    return this.c;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public String c()
  {
    return this.d;
  }

  public void c(String paramString)
  {
    this.e = paramString;
  }

  public String d()
  {
    return this.e;
  }

  public void d(String paramString)
  {
    this.f = paramString;
  }

  public String e()
  {
    return this.f;
  }

  public void e(String paramString)
  {
    this.g = paramString;
  }

  public String f()
  {
    return this.g;
  }

  public void f(String paramString)
  {
    this.h = paramString;
  }

  public String g()
  {
    return this.h;
  }

  public void g(String paramString)
  {
    this.i = paramString;
  }

  public String h()
  {
    return this.i;
  }

  public void h(String paramString)
  {
    this.j = paramString;
  }

  public String i()
  {
    return this.j;
  }

  public boolean j()
  {
    return (!TextUtils.isEmpty(b())) && (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)) && (((!this.a.equals(p.f.toString())) && (!this.a.equals(p.k.toString()))) || (!TextUtils.isEmpty(c())));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.bf
 * JD-Core Version:    0.6.0
 */