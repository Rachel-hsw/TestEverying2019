package com.himamis.retex.renderer.a.d;

import com.himamis.retex.renderer.a.aa;
import com.himamis.retex.renderer.a.d;
import com.himamis.retex.renderer.a.dk;
import com.himamis.retex.renderer.a.dp;
import com.himamis.retex.renderer.a.dr;
import com.himamis.retex.renderer.a.i;

public class a extends d
{
  private static c a;
  private b b;
  private dr f = new dr();
  private String g;
  private boolean h;
  private boolean i;

  public a(String paramString1, String paramString2)
  {
    this.g = paramString1;
    if (a != null)
      this.b = a.a();
    if ((paramString2 != null) && (paramString2.equals("i")))
      this.h = true;
  }

  public static void a(c paramc)
  {
    a = paramc;
  }

  public static boolean d()
  {
    return a != null;
  }

  public i a(dp paramdp)
  {
    if (this.b != null)
    {
      if (this.i)
        this.i = false;
      while (this.f.u != null)
      {
        return this.f.u.a(paramdp);
        this.f.c(this.b.a(this.g));
      }
    }
    return new dk(0.0F, 0.0F, 0.0F, 0.0F);
  }

  public boolean e()
  {
    return this.h;
  }

  public d f()
  {
    if (!this.i)
    {
      this.f.c(this.b.a(this.g));
      this.i = true;
    }
    if (this.f.u == null)
      return new aa();
    return this.f.u;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.d.a
 * JD-Core Version:    0.6.0
 */