package com.xiaomi.mipush.sdk;

import java.util.List;

public class e
  implements PushMessageHandler.a
{
  private static final long a = 1L;
  private String b;
  private long c;
  private String d;
  private List<String> e;
  private String f;

  public String a()
  {
    return this.b;
  }

  public void a(long paramLong)
  {
    this.c = paramLong;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public void a(List<String> paramList)
  {
    this.e = paramList;
  }

  public List<String> b()
  {
    return this.e;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public long c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.f = paramString;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.f;
  }

  public String toString()
  {
    return "command={" + this.b + "}, resultCode={" + this.c + "}, reason={" + this.d + "}, category={" + this.f + "}, commandArguments={" + this.e + "}";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.e
 * JD-Core Version:    0.6.0
 */