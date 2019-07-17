package com.umeng.a.b;

public class q
{
  private int a = -1;
  private String b = "";
  private String c = "";
  private Exception d = null;

  public q(int paramInt)
  {
    this.a = paramInt;
  }

  public q(int paramInt, Exception paramException)
  {
    this.a = paramInt;
    this.d = paramException;
  }

  public Exception a()
  {
    return this.d;
  }

  public void a(int paramInt)
  {
    this.a = paramInt;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public int b()
  {
    return this.a;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public String c()
  {
    return this.b;
  }

  public String d()
  {
    return this.c;
  }

  public String toString()
  {
    return "status=" + this.a + "\r\n" + "msg:  " + this.b + "\r\n" + "data:  " + this.c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.b.q
 * JD-Core Version:    0.6.0
 */