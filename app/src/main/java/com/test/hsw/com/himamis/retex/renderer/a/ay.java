package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.a.a;
import com.himamis.retex.renderer.a.g.b;

public class ay extends d
{
  private String a;
  private int b;
  private dr.a f;

  public ay(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public ay(String paramString, dr.a parama)
  {
    this(paramString, 0);
    this.f = parama;
  }

  public i a(dp paramdp)
  {
    if (this.f == null)
      return new az(this.a, this.b, v.x(paramdp.j()));
    v localv = (v)paramdp.m();
    int i;
    int j;
    label57: int k;
    boolean bool;
    b localb;
    a locala;
    if (localv.u)
    {
      i = 2;
      if (!localv.q)
        break label142;
      j = 1;
      k = j | i;
      bool = localv.r;
      localb = new b();
      if (!localv.s)
        break label168;
      if (this.f.a != null)
        break label148;
      locala = localb.a(this.f.b, 0, 10);
    }
    while (true)
    {
      return new az(this.a, k, v.x(paramdp.j()), locala, bool);
      i = 0;
      break;
      label142: j = 0;
      break label57;
      label148: locala = localb.a(this.f.a, 0, 10);
      continue;
      label168: if (this.f.b == null)
      {
        locala = localb.a(this.f.a, 0, 10);
        continue;
      }
      locala = localb.a(this.f.b, 0, 10);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ay
 * JD-Core Version:    0.6.0
 */