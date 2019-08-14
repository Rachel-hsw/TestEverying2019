package org.android.agoo.c.c;

import java.util.HashMap;
import java.util.Map;

public final class i
{
  private volatile boolean a;
  private volatile int b;
  private volatile String c;
  private volatile String d;
  private volatile String e;
  private Map<String, String> f = new HashMap();

  public Map<String, String> a()
  {
    return this.f;
  }

  public void a(int paramInt)
  {
    this.b = paramInt;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public void a(Map<String, String> paramMap)
  {
    this.f.putAll(paramMap);
  }

  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public boolean b()
  {
    return this.a;
  }

  public String c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.e = paramString;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    return this.e;
  }

  public int f()
  {
    return this.b;
  }

  public String toString()
  {
    return "Result [isSuccess=" + this.a + ", httpCode=" + this.b + ", data=" + this.c + ", retDesc=" + this.d + ", retCode=" + this.e + ", headers=" + this.f + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.c.i
 * JD-Core Version:    0.6.0
 */