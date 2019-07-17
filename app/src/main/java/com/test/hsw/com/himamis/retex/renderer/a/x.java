package com.himamis.retex.renderer.a;

public class x
{
  public static i a(dm paramdm, dp paramdp, int paramInt)
  {
    if (paramInt > 4)
      return paramdm.a(paramdp);
    dq localdq = paramdp.m();
    int i = paramdp.j();
    m localm = localdq.a(paramdm.i(), i);
    for (int j = 1; ; j++)
    {
      if ((j > paramInt) || (!localdq.a(localm)))
      {
        if ((j > paramInt) || (localdq.a(localm)))
          break;
        o localo = new o(localdq.a('A', "mathnormal", i));
        return a(paramdm.i(), paramdp, paramInt * (localo.e() + localo.f()));
      }
      localm = localdq.b(localm, i);
    }
    return new o(localm);
  }

  public static i a(String paramString, dp paramdp, float paramFloat)
  {
    dq localdq = paramdp.m();
    int i = paramdp.j();
    m localm = localdq.a(paramString, i);
    bh localbh1 = localm.i();
    float f = localbh1.b() + localbh1.c();
    Object localObject;
    if ((f >= paramFloat) || (!localdq.a(localm)))
    {
      if (f < paramFloat)
        break label116;
      localObject = new o(localm);
    }
    while (true)
    {
      return localObject;
      localm = localdq.b(localm, i);
      bh localbh2 = localm.i();
      f = localbh2.b() + localbh2.c();
      break;
      label116: if (!localdq.b(localm))
        break label332;
      localObject = new ej();
      ab localab = localdq.a(localm, i);
      if (localab.a())
        ((ej)localObject).a(new o(localab.d()));
      boolean bool = localab.b();
      if (bool)
        ((ej)localObject).a(new o(localab.e()));
      if (localab.c())
        ((ej)localObject).a(new o(localab.g()));
      o localo = new o(localab.f());
      while (((ej)localObject).e() + ((ej)localObject).f() <= paramFloat)
      {
        if ((localab.a()) && (localab.c()))
        {
          ((ej)localObject).a(1, localo);
          if (!bool)
            continue;
          ((ej)localObject).a(-1 + ((ej)localObject).i(), localo);
          continue;
        }
        if (localab.c())
        {
          ((ej)localObject).a(0, localo);
          continue;
        }
        ((ej)localObject).a(localo);
      }
    }
    label332: return (i)new o(localm);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.x
 * JD-Core Version:    0.6.0
 */