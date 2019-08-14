package com.xiaomi.push.a;

import com.xiaomi.a.a.c.a;

public class e
  implements a
{
  private a a = null;
  private a b = null;

  public e(a parama1, a parama2)
  {
    this.a = parama1;
    this.b = parama2;
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString, Throwable paramThrowable)
  {
    if (this.a != null)
      this.a.a(paramString, paramThrowable);
    if (this.b != null)
      this.b.a(paramString, paramThrowable);
  }

  public void b(String paramString)
  {
    if (this.a != null)
      this.a.b(paramString);
    if (this.b != null)
      this.b.b(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.a.e
 * JD-Core Version:    0.6.0
 */