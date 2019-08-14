package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.j;
import com.himamis.retex.renderer.a.g.f;
import java.util.Map;

public class dm extends q
{
  public static Map<String, dm> a = new dw().a();
  private static g g = new g();
  private final boolean b;
  private final String f;
  private char h;

  static
  {
    g.a(0);
    g.a(1);
    g.a(2);
    g.a(3);
    g.a(4);
    g.a(5);
    g.a(6);
    g.a(10);
  }

  public dm(dm paramdm, int paramInt)
    throws j
  {
    if (!g.b(paramInt))
      throw new j("The symbol type was not valid! Use one of the symbol type constants from the class 'TeXConstants'.");
    this.f = paramdm.f;
    this.c = paramInt;
    if (paramInt == 1)
      this.d = 0;
    this.b = paramdm.b;
  }

  public dm(String paramString, int paramInt, boolean paramBoolean)
  {
    this.f = paramString;
    this.c = paramInt;
    if (paramInt == 1)
      this.d = 0;
    this.b = paramBoolean;
  }

  public static void a(dm paramdm)
  {
    a.put(paramdm.f, paramdm);
  }

  public static void a(Object paramObject, String paramString)
  {
    dw localdw = new dw(paramObject, paramString);
    a.putAll(localdw.a());
  }

  public static void a(String paramString)
  {
    a(new f().a(paramString), paramString);
  }

  public static dm b(String paramString)
    throws com.himamis.retex.renderer.a.e.q
  {
    Object localObject = a.get(paramString);
    if (localObject == null)
      throw new com.himamis.retex.renderer.a.e.q(paramString);
    return (dm)localObject;
  }

  public dm a(char paramChar)
  {
    this.h = paramChar;
    return this;
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    int i = paramdp.j();
    m localm1 = localdq.a(this.f, i);
    o localo1 = new o(localm1);
    if ((paramdp.l()) && (this.h != 0) && (Character.isLowerCase(this.h)));
    while (true)
    {
      try
      {
        localObject = new co(new o(localdq.a(dr.p[Character.toUpperCase(this.h)], i)), 0.8D, 0.8D);
        if (this.c != 1)
          continue;
        if ((i >= 2) || (!localdq.a(localm1)))
          continue;
        localm2 = localdq.b(localm1, i);
        o localo2 = new o(localm2);
        localo2.d(-(localo2.e() + localo2.f()) / 2.0F - paramdp.m().b(paramdp.j()));
        float f1 = localm2.f();
        localObject = new at(localo2);
        if (f1 <= 1.0E-007F)
          continue;
        ((at)localObject).a(new dk(f1, 0.0F, 0.0F, 0.0F));
        return localObject;
      }
      catch (com.himamis.retex.renderer.a.e.p localp)
      {
        localObject = localo1;
        continue;
        m localm2 = localm1;
        continue;
      }
      Object localObject = localo1;
    }
  }

  public p a(dq paramdq)
  {
    return paramdq.a(this.f, 0).a();
  }

  public char d()
  {
    return this.h;
  }

  public boolean h()
  {
    return this.b;
  }

  public String i()
  {
    return this.f;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dm
 * JD-Core Version:    0.6.0
 */