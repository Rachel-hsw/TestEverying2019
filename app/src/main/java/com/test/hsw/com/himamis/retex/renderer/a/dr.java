package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.b.a.c;
import com.himamis.retex.renderer.a.e.e;
import com.himamis.retex.renderer.a.e.l;
import com.himamis.retex.renderer.a.e.n;
import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.g;
import com.himamis.retex.renderer.a.g.c.h;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class dr
{
  private static final String[][] a = { { "lbrace", "rbrace" }, { "lsqbrack", "rsqbrack" }, { "lbrack", "rbrack" }, { "downarrow", "downarrow" }, { "uparrow", "uparrow" }, { "updownarrow", "updownarrow" }, { "Downarrow", "Downarrow" }, { "Uparrow", "Uparrow" }, { "Updownarrow", "Updownarrow" }, { "vert", "vert" }, { "Vert", "Vert" } };
  private static final int b = 0;
  private static final int c = 1;
  public static final String d = "1.0.3";
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 4;
  public static final int i = 8;
  public static final int j = 16;
  public static float k = 0.0F;
  protected static final float l = 1.0E-007F;
  public static Map<String, dr> m = new HashMap(150);
  public static Map<String, String> n = new HashMap(150);
  public static String[] o = new String[65536];
  public static String[] p = new String[65536];
  public static String[] q = new String[65536];
  public static Map<a.c, a> r = new HashMap();
  public List<bi> s = new LinkedList();
  protected Map<String, String> t;
  public d u = null;
  public String v = null;
  public boolean w = false;
  private dv x;

  static
  {
    dt localdt = new dt();
    localdt.b(o, p);
    new ca();
    new cc();
    new bz();
    localdt.a(q, p);
    try
    {
      v.b(new com.himamis.retex.renderer.a.c.a());
      v.b(new com.himamis.retex.renderer.a.f.a());
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public dr()
  {
    this.x = new dv("", this, false);
  }

  public dr(dr paramdr)
  {
    if (paramdr != null)
      b(paramdr);
  }

  protected dr(dv paramdv)
  {
    this.t = paramdv.a.t;
    this.x = new dv(paramdv.a(), "", this, false);
  }

  protected dr(dv paramdv, String paramString)
    throws n
  {
    this(paramdv, paramString, null);
  }

  protected dr(dv paramdv, String paramString1, String paramString2)
    throws n
  {
    this.v = paramString2;
    this.t = paramdv.a.t;
    boolean bool = paramdv.a();
    this.x = new dv(bool, paramString1, this);
    if (bool)
      try
      {
        this.x.p();
        return;
      }
      catch (Exception localException)
      {
        while (this.u != null);
        this.u = new aa();
        return;
      }
    this.x.p();
  }

  protected dr(dv paramdv, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    throws n
  {
    this.v = paramString2;
    this.t = paramdv.a.t;
    boolean bool = paramdv.a();
    this.x = new dv(bool, paramString1, this, paramBoolean1, paramBoolean2);
    if (bool)
      try
      {
        this.x.p();
        return;
      }
      catch (Exception localException)
      {
        while (this.u != null);
        this.u = new aa();
        return;
      }
    this.x.p();
  }

  protected dr(dv paramdv, String paramString, boolean paramBoolean)
    throws n
  {
    this.v = null;
    this.t = paramdv.a.t;
    boolean bool = paramdv.a();
    this.x = new dv(bool, paramString, this, paramBoolean);
    if (bool);
    try
    {
      this.x.p();
      return;
      this.x.p();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public dr(String paramString)
    throws n
  {
    this(paramString, null);
  }

  public dr(String paramString1, String paramString2)
    throws n
  {
    this.v = paramString2;
    this.x = new dv(paramString1, this);
    this.x.p();
  }

  public dr(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    throws n
  {
    this.v = paramString2;
    this.x = new dv(paramString1, this, paramBoolean1, paramBoolean2);
    this.x.p();
  }

  public dr(String paramString, Map<String, String> paramMap)
    throws n
  {
    this.t = paramMap;
    this.v = this.v;
    this.x = new dv(paramString, this);
    this.x.p();
  }

  public dr(String paramString, boolean paramBoolean)
    throws n
  {
    this.v = null;
    this.x = new dv(paramString, this, paramBoolean);
    this.x.p();
  }

  public static dr a(String paramString, int paramInt)
    throws n
  {
    dr localdr = new dr();
    if ((paramString == null) || ("".equals(paramString)))
    {
      localdr.a(new aa());
      return localdr;
    }
    String[] arrayOfString = paramString.split("\n|\\\\\\\\|\\\\cr");
    c localc = new c();
    int i1 = arrayOfString.length;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        localc.f();
        localdr.a(new bg(false, localc, 0, paramInt));
        return localdr;
      }
      localc.a(new ch(new dr(arrayOfString[i2], "mathnormal", true, false).u));
      localc.b();
    }
  }

  public static g a(String paramString, int paramInt, float paramFloat, b paramb1, b paramb2)
    throws n
  {
    int i1 = 2;
    du localdu = new dr(paramString).a(paramInt, paramFloat);
    localdu.a(new h(i1, i1, i1, i1));
    int i2 = localdu.d();
    int i3 = localdu.b();
    com.himamis.retex.renderer.a.g.d locald = new com.himamis.retex.renderer.a.g.d();
    if (paramb2 == null);
    while (true)
    {
      g localg = locald.b(i2, i3, i1);
      com.himamis.retex.renderer.a.g.c.c localc = localg.c();
      if (paramb2 != null)
      {
        localc.a(paramb2);
        localc.a(0, 0, i2, i3);
      }
      if (paramb1 == null)
        paramb1 = s.b;
      localdu.a(paramb1);
      localdu.a(null, localc, 0, 0);
      localc.f();
      return localg;
      i1 = 1;
    }
  }

  private i a(dp paramdp)
  {
    if (this.u == null)
      return new dk(0.0F, 0.0F, 0.0F, 0.0F);
    return this.u.a(paramdp);
  }

  private v a(float paramFloat, int paramInt)
  {
    v localv = new v(paramFloat);
    if (paramInt == 0)
      localv.e(false);
    if ((paramInt & 0x8) != 0)
      localv.b(true);
    if ((paramInt & 0x10) != 0)
      localv.c(true);
    if ((paramInt & 0x1) != 0)
      localv.e(true);
    if ((paramInt & 0x4) != 0)
      localv.d(true);
    if ((paramInt & 0x2) != 0)
      localv.a(true);
    return localv;
  }

  public static void a(float paramFloat)
  {
    k = paramFloat / 72.0F;
  }

  public static void a(Object paramObject)
    throws o
  {
    new cb(paramObject, "TeXFormula").a(m);
  }

  public static void a(Object paramObject, String paramString)
    throws o
  {
    dt localdt = new dt(paramObject, paramString);
    localdt.b(o, p);
    localdt.a(q, p);
  }

  public static void a(String paramString)
    throws o
  {
    a(new com.himamis.retex.renderer.a.g.f().a(paramString), paramString);
  }

  public static void a(boolean paramBoolean)
  {
    w.a(paramBoolean);
  }

  public static boolean a(a.c paramc)
  {
    return r.get(paramc) != null;
  }

  public static a b(a.c paramc)
  {
    a locala = (a)r.get(paramc);
    if (locala == null)
    {
      locala = new a("SansSerif", "Serif");
      r.put(paramc, locala);
    }
    return locala;
  }

  public static dr b(String paramString)
  {
    dr localdr = new dr();
    if (paramString == null)
      localdr.a(new aa());
    do
    {
      return localdr;
      dv localdv = new dv(true, paramString, localdr);
      try
      {
        localdv.p();
        return localdr;
      }
      catch (Exception localException)
      {
      }
    }
    while (localdr.u != null);
    localdr.u = new aa();
    return localdr;
  }

  private void b(dr paramdr)
  {
    if (paramdr.u != null)
    {
      if ((paramdr.u instanceof cl))
        a(new cl(paramdr.u));
    }
    else
      return;
    a(paramdr.u);
  }

  public static void b(Object paramObject)
    throws o
  {
    new cb(paramObject, "Command").a(be.a);
  }

  public static dr f(String paramString)
    throws e
  {
    dr localdr1 = (dr)m.get(paramString);
    if (localdr1 == null)
    {
      String str = (String)n.get(paramString);
      if (str == null)
        throw new e(paramString);
      dr localdr2 = new dr(str);
      m.put(paramString, localdr2);
      return localdr2;
    }
    return new dr(localdr1);
  }

  public static void g()
  {
  }

  public dr a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
    throws l
  {
    return a(new cu(paramInt, paramFloat1, paramFloat2, paramFloat3));
  }

  public dr a(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
    throws l
  {
    return a(new cu(paramInt1, paramFloat1, paramInt2, paramFloat2, paramInt3, paramFloat3));
  }

  public dr a(int paramInt1, int paramInt2)
    throws com.himamis.retex.renderer.a.e.f
  {
    this.u = new ea(paramInt1, paramInt2, this.u);
    return this;
  }

  public dr a(d paramd)
  {
    if (paramd != null)
    {
      if ((paramd instanceof bi))
        this.s.add((bi)paramd);
      if (this.u != null)
        break label39;
      this.u = paramd;
    }
    label39: int i1;
    do
    {
      do
      {
        return this;
        if (!(this.u instanceof cl))
          this.u = new cl(this.u);
        ((cl)this.u).a(paramd);
      }
      while (!(paramd instanceof ea));
      i1 = ((ea)paramd).b();
    }
    while ((i1 != 2) && (i1 != 3));
    ((cl)this.u).a(new k());
    return this;
  }

  public dr a(dr paramdr)
  {
    b(paramdr);
    return this;
  }

  public dr a(b paramb)
  {
    if (paramb != null)
    {
      if ((this.u instanceof r))
        this.u = new r(paramb, null, (r)this.u);
    }
    else
      return this;
    this.u = new r(this.u, paramb, null);
    return this;
  }

  public dr a(boolean paramBoolean, String paramString)
    throws n
  {
    if ((paramString != null) && (paramString.length() != 0))
      new dv(paramBoolean, paramString, this).p();
    return this;
  }

  public du a(int paramInt, float paramFloat)
  {
    return new b().a(paramInt).a(paramFloat).a();
  }

  public du a(int paramInt1, float paramFloat, int paramInt2)
  {
    return new b().a(paramInt1).a(paramFloat).b(paramInt2).a();
  }

  public du a(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3)
  {
    return a(paramInt1, paramFloat1, 0, paramInt2, paramFloat2, paramInt3);
  }

  public du a(int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4, float paramFloat3)
  {
    return a(paramInt1, paramFloat1, 0, paramInt2, paramFloat2, paramInt3, paramInt4, paramFloat3);
  }

  public du a(int paramInt1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, int paramInt4)
  {
    return new b().a(paramInt1).a(paramFloat1).b(paramInt2).a(paramInt3, paramFloat2, paramInt4).a();
  }

  public du a(int paramInt1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, int paramInt4, int paramInt5, float paramFloat3)
  {
    return new b().a(paramInt1).a(paramFloat1).b(paramInt2).a(paramInt3, paramFloat2, paramInt4).a(paramInt5, paramFloat3).a();
  }

  public du a(int paramInt1, float paramFloat, int paramInt2, b paramb)
  {
    return new b().a(paramInt1).a(paramFloat).b(paramInt2).a(paramb).a();
  }

  public du a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    return new b().a(paramInt).a(paramFloat).a(paramBoolean).a();
  }

  public g a(int paramInt, float paramFloat, b paramb1, b paramb2)
    throws n
  {
    int i1 = 2;
    du localdu = a(paramInt, paramFloat);
    localdu.a(new h(i1, i1, i1, i1));
    int i2 = localdu.d();
    int i3 = localdu.b();
    com.himamis.retex.renderer.a.g.d locald = new com.himamis.retex.renderer.a.g.d();
    if (paramb2 == null);
    while (true)
    {
      g localg = locald.b(i2, i3, i1);
      com.himamis.retex.renderer.a.g.c.c localc = localg.c();
      if (paramb2 != null)
      {
        localc.a(paramb2);
        localc.a(0, 0, i2, i3);
      }
      if (paramb1 == null)
        paramb1 = s.b;
      localdu.a(paramb1);
      localdu.a(null, localc, 0, 0);
      localc.f();
      return localg;
      i1 = 1;
    }
  }

  public void a(int paramInt, float paramFloat, String paramString, b paramb1, b paramb2)
  {
    if (paramb1 == null);
    for (boolean bool = true; ; bool = false)
    {
      a("png", paramInt, paramFloat, paramString, paramb1, paramb2, bool);
      return;
    }
  }

  public void a(String paramString1, int paramInt, float paramFloat, String paramString2, b paramb1, b paramb2, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }

  public dr b(int paramInt)
    throws l
  {
    return a(new cu(paramInt));
  }

  public dr b(b paramb)
  {
    if (paramb != null)
    {
      if ((this.u instanceof r))
        this.u = new r(null, paramb, (r)this.u);
    }
    else
      return this;
    this.u = new r(this.u, null, paramb);
    return this;
  }

  public void b(int paramInt, float paramFloat, String paramString, b paramb1, b paramb2)
  {
    if (paramb1 == null);
    for (boolean bool = true; ; bool = false)
    {
      a("gif", paramInt, paramFloat, paramString, paramb1, paramb2, bool);
      return;
    }
  }

  public void b(boolean paramBoolean)
  {
    if ((this.u instanceof cl))
      ((cl)this.u).b = paramBoolean;
  }

  public void c(int paramInt, float paramFloat, String paramString, b paramb1, b paramb2)
  {
    a("jpeg", paramInt, paramFloat, paramString, paramb1, paramb2, false);
  }

  public void c(String paramString)
    throws n
  {
    this.x.a(paramString);
    if ((paramString != null) && (paramString.length() != 0))
      this.x.p();
  }

  public void c(boolean paramBoolean)
  {
    i.a = paramBoolean;
  }

  public dr d(String paramString)
    throws n
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      this.v = null;
      a(new dr(paramString));
    }
    return this;
  }

  public dr e(String paramString)
    throws n
  {
    return a(false, paramString);
  }

  public boolean h()
  {
    if ((this.u instanceof cl))
      return ((cl)this.u).b;
    return false;
  }

  public dr i()
  {
    this.u = new eg(this.u);
    return this;
  }

  static class a
  {
    String a;
    String b;

    a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }

  public class b
  {
    private Integer b;
    private Float c;
    private Integer d;
    private b e;
    private boolean f = false;
    private Integer g;
    private Float h;
    private Integer i;
    private boolean j = false;
    private Integer k;
    private Float l;

    public b()
    {
    }

    public b a(float paramFloat)
    {
      this.c = Float.valueOf(paramFloat);
      return this;
    }

    public b a(int paramInt)
    {
      this.b = Integer.valueOf(paramInt);
      return this;
    }

    public b a(int paramInt, float paramFloat)
    {
      if (this.g == null)
        throw new IllegalStateException("Cannot set inter line spacing without having specified a width!");
      this.k = Integer.valueOf(paramInt);
      this.l = Float.valueOf(paramFloat);
      return this;
    }

    public b a(int paramInt1, float paramFloat, int paramInt2)
    {
      this.g = Integer.valueOf(paramInt1);
      this.h = Float.valueOf(paramFloat);
      this.i = Integer.valueOf(paramInt2);
      this.f = true;
      return this;
    }

    public b a(b paramb)
    {
      this.e = paramb;
      return this;
    }

    public b a(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }

    public du a()
    {
      if (this.b == null)
        throw new IllegalStateException("A style is required. Use setStyle()");
      if (this.c == null)
        throw new IllegalStateException("A size is required. Use setStyle()");
      v localv;
      dp localdp;
      label93: i locali1;
      float f3;
      label188: at localat;
      if (this.d == null)
      {
        localv = new v(this.c.floatValue());
        if (this.g == null)
          break label283;
        localdp = new dp(this.b.intValue(), localv, this.g.intValue(), this.h.floatValue());
        if (this.k != null)
          localdp.a(this.k.intValue(), this.l.floatValue());
        locali1 = dr.a(dr.this, localdp);
        if (this.g == null)
          break label355;
        if (this.k == null)
          break label311;
        float f2 = this.l.floatValue() * cu.a(this.k.intValue(), localdp);
        i locali2 = j.a(locali1, localdp.b(), f2);
        if (!this.j)
          break label302;
        f3 = locali2.c();
        localat = new at(locali2, f3, this.i.intValue());
      }
      label283: label302: label311: label355: for (du localdu = new du(localat, this.c.floatValue(), this.f); ; localdu = new du(locali1, this.c.floatValue(), this.f))
      {
        if (this.e != null)
          localdu.a(this.e);
        localdu.c = localdp.a;
        return localdu;
        localv = dr.a(dr.this, this.c.floatValue(), this.d.intValue());
        break;
        localdp = new dp(this.b.intValue(), localv);
        break label93;
        f3 = localdp.b();
        break label188;
        float f1;
        if (this.j)
          f1 = locali1.c();
        while (true)
        {
          localat = new at(locali1, f1, this.i.intValue());
          break;
          f1 = localdp.b();
        }
      }
    }

    public b b(int paramInt)
    {
      this.d = Integer.valueOf(paramInt);
      return this;
    }

    public b b(boolean paramBoolean)
    {
      if (this.g == null)
        throw new IllegalStateException("Cannot set 'isMaxWidth' without having specified a width!");
      if (paramBoolean)
        this.i = Integer.valueOf(0);
      this.j = paramBoolean;
      return this;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dr
 * JD-Core Version:    0.6.0
 */