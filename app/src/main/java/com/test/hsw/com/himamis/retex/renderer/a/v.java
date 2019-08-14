package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.b.a.c;
import com.himamis.retex.renderer.a.e.d;
import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.e.r;
import com.himamis.retex.renderer.a.e.s;
import com.himamis.retex.renderer.a.g.f;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class v
  implements dq
{
  private static ah[] A = new ah[0];
  private static Map<String, Float> B;
  private static Map<String, Number> C;
  private static boolean D = false;
  protected static final int a = -1;
  protected static final int b = 0;
  protected static final int c = 1;
  protected static final int d = 2;
  protected static final int e = 3;
  protected static final int f = 0;
  protected static final int g = 1;
  protected static final int h = 2;
  protected static final int i = 3;
  protected static final int j = 0;
  protected static final int k = 1;
  protected static final int l = 2;
  protected static final int m = 3;
  public static List<a.c> n = new ArrayList();
  public static Map<a.c, b> o = new HashMap();
  private static String[] w;
  private static final int x = 256;
  private static Map<String, p[]> y;
  private static Map<String, p> z;
  private final float E;
  protected float p = 1.0F;
  public boolean q = false;
  public boolean r = false;
  public boolean s = false;
  public boolean t = false;
  public boolean u = false;

  static
  {
    w localw = new w();
    n.add(a.c.a('a'));
    A = localw.a(A);
    B = localw.d();
    y = localw.f();
    w = localw.c();
    z = localw.b();
    C = localw.e();
    C.put("textfactor", Integer.valueOf(1));
    int i1 = ((Number)C.get("mufontid")).intValue();
    if ((i1 < 0) || (i1 >= A.length) || (A[i1] == null))
      throw new s("DefaultTeXFont.xml", "GeneralSettings", "mufontid", "contains an unknown font id!");
  }

  public v(float paramFloat)
  {
    this.E = paramFloat;
  }

  public v(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.E = paramFloat1;
    this.p = paramFloat2;
    this.q = paramBoolean1;
    this.r = paramBoolean2;
    this.s = paramBoolean3;
    this.t = paramBoolean4;
    this.u = paramBoolean5;
  }

  public v(float paramFloat, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this(paramFloat, 1.0F, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }

  private bh a(p paramp, float paramFloat)
  {
    float[] arrayOfFloat = A[paramp.b].b(paramp.a);
    return new bh(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], arrayOfFloat[3], paramFloat * dr.k, paramFloat);
  }

  public static com.himamis.retex.renderer.a.g.a.a a(int paramInt)
  {
    return A[paramInt].i();
  }

  private m a(char paramChar, p[] paramArrayOfp, int paramInt)
  {
    int i1;
    int i2;
    if ((paramChar >= '0') && (paramChar <= '9'))
    {
      i1 = 0;
      i2 = paramChar - '0';
    }
    while (paramArrayOfp[i1] == null)
    {
      return a(paramChar, paramInt);
      if ((paramChar >= 'a') && (paramChar <= 'z'))
      {
        i1 = 2;
        i2 = paramChar - 'a';
        continue;
      }
      if ((paramChar >= 'A') && (paramChar <= 'Z'))
      {
        i1 = 1;
        i2 = paramChar - 'A';
        continue;
      }
      i1 = 3;
      i2 = paramChar;
    }
    return a(new p((char)(i2 + paramArrayOfp[i1].a), paramArrayOfp[i1].b), paramInt);
  }

  public static void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (D)
    {
      C.put("scriptfactor", Float.valueOf(Math.abs(paramFloat3 / paramFloat1)));
      C.put("scriptscriptfactor", Float.valueOf(Math.abs(paramFloat4 / paramFloat1)));
      C.put("textfactor", Float.valueOf(Math.abs(paramFloat2 / paramFloat1)));
      du.a = Math.abs(paramFloat1);
    }
  }

  public static void a(a.c paramc, Object paramObject1, String paramString1, Object paramObject2, String paramString2, Object paramObject3, String paramString3)
    throws o
  {
    if (!n.contains(paramc))
    {
      a(paramObject1, paramString1);
      dm.a(paramObject2, paramString2);
      dr.a(paramObject3, paramString3);
      n.add(paramc);
    }
  }

  public static void a(a.c paramc, String paramString)
  {
    String str1 = "fonts/" + paramString + "/language_" + paramString + ".xml";
    String str2 = "fonts/" + paramString + "/symbols_" + paramString + ".xml";
    String str3 = "fonts/" + paramString + "/mappings_" + paramString + ".xml";
    f localf = new f();
    try
    {
      a(paramc, localf.a(dr.class, str1), str1, localf.a(dr.class, str2), str2, localf.a(dr.class, str3), str3);
      return;
    }
    catch (d locald)
    {
    }
  }

  public static void a(b paramb)
  {
    if (paramb != null);
    try
    {
      a(paramb.b(), paramb.a(), paramb.c());
      return;
    }
    catch (com.himamis.retex.renderer.a.e.a locala)
    {
      System.err.println(locala.toString());
      return;
    }
    catch (d locald)
    {
    }
  }

  public static void a(Object paramObject1, Object paramObject2, String paramString)
    throws o
  {
    w localw = new w(paramObject1, paramObject2, paramString);
    A = localw.a(A);
    localw.a();
    y.putAll(localw.f());
    z.putAll(localw.b());
  }

  public static void a(Object paramObject, String paramString)
    throws o
  {
    w localw = new w(paramObject, paramString);
    A = localw.a(A);
    y.putAll(localw.f());
    z.putAll(localw.b());
  }

  public static void a(Object paramObject, a.c[] paramArrayOfc, String paramString)
    throws o
  {
    int i1 = 0;
    int i2 = 0;
    if ((i2 != 0) || (i1 >= paramArrayOfc.length))
      if (i2 == 0)
      {
        dv.b = true;
        a(paramObject, new f().a(paramObject, paramString), paramString);
      }
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= paramArrayOfc.length)
      {
        dv.b = false;
        return;
        if ((!n.contains(paramArrayOfc[i1])) && (i2 == 0));
        for (i2 = 0; ; i2 = 1)
        {
          i1++;
          break;
        }
      }
      n.add(paramArrayOfc[i3]);
    }
  }

  public static void a(String paramString)
    throws o
  {
    a(new f().a(paramString), paramString);
  }

  private static float b(String paramString)
  {
    Object localObject = B.get(paramString);
    if (localObject == null)
      return 0.0F;
    return ((Float)localObject).floatValue();
  }

  public static void b(b paramb)
  {
    a.c[] arrayOfc = paramb.a();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= arrayOfc.length)
        return;
      o.put(arrayOfc[i1], paramb);
    }
  }

  public static void c(float paramFloat)
  {
    if (D)
      du.b = paramFloat / 1000.0F;
  }

  public static void f(boolean paramBoolean)
  {
    D = paramBoolean;
  }

  public static float x(int paramInt)
  {
    if (paramInt < 2)
      return 1.0F;
    if (paramInt < 4)
      return ((Number)C.get("textfactor")).floatValue();
    if (paramInt < 6)
      return ((Number)C.get("scriptfactor")).floatValue();
    return ((Number)C.get("scriptscriptfactor")).floatValue();
  }

  public float a(int paramInt1, int paramInt2)
  {
    return A[paramInt2].a(x(paramInt1) * dr.k);
  }

  public float a(p paramp1, p paramp2, int paramInt)
  {
    if (paramp1.b == paramp2.b)
      return A[paramp1.b].b(paramp1.a, paramp2.a, x(paramInt) * dr.k);
    return 0.0F;
  }

  public ab a(m paramm, int paramInt)
  {
    com.himamis.retex.renderer.a.g.a.a locala = paramm.c();
    int i1 = paramm.d();
    float f1 = x(paramInt);
    int[] arrayOfInt = A[i1].a(paramm.b());
    m[] arrayOfm = new m[arrayOfInt.length];
    int i2 = 0;
    if (i2 >= arrayOfInt.length)
      return new ab(arrayOfm[0], arrayOfm[1], arrayOfm[2], arrayOfm[3]);
    if (arrayOfInt[i2] == -1)
      arrayOfm[i2] = null;
    while (true)
    {
      i2++;
      break;
      arrayOfm[i2] = new m((char)arrayOfInt[i2], locala, i1, a(new p((char)arrayOfInt[i2], i1), f1));
    }
  }

  public dq a()
  {
    return new v(this.E, this.p, this.q, this.r, this.s, this.t, this.u);
  }

  public dq a(float paramFloat)
  {
    return new v(paramFloat, this.p, this.q, this.r, this.s, this.t, this.u);
  }

  public m a(char paramChar, int paramInt)
  {
    if ((paramChar >= '0') && (paramChar <= '9'))
      return a(paramChar, w[0], paramInt);
    if ((paramChar >= 'a') && (paramChar <= 'z'))
      return a(paramChar, w[2], paramInt);
    return a(paramChar, w[1], paramInt);
  }

  public m a(char paramChar, String paramString, int paramInt)
    throws r
  {
    Object localObject = y.get(paramString);
    if (localObject == null)
      throw new r(paramString);
    return a(paramChar, (p[])localObject, paramInt);
  }

  public m a(p paramp, int paramInt)
  {
    float f1 = x(paramInt);
    int i1;
    ah localah1;
    int i2;
    ah localah2;
    if (this.q)
    {
      i1 = paramp.c;
      localah1 = A[i1];
      if ((!this.q) || (paramp.b != paramp.c))
        break label265;
      i2 = localah1.d();
      localah2 = A[i2];
      paramp = new p(paramp.a, i2, paramInt);
    }
    while (true)
    {
      if (this.r)
      {
        i2 = localah2.e();
        localah2 = A[i2];
        paramp = new p(paramp.a, i2, paramInt);
      }
      if (this.s)
      {
        i2 = localah2.h();
        localah2 = A[i2];
        paramp = new p(paramp.a, i2, paramInt);
      }
      if (this.t)
      {
        i2 = localah2.f();
        localah2 = A[i2];
        paramp = new p(paramp.a, i2, paramInt);
      }
      if (this.u)
      {
        i2 = localah2.g();
        localah2 = A[i2];
        paramp = new p(paramp.a, i2, paramInt);
      }
      com.himamis.retex.renderer.a.g.a.a locala = localah2.i();
      return new m(paramp.a, locala, i2, a(paramp, f1 * this.p));
      i1 = paramp.b;
      break;
      label265: i2 = i1;
      localah2 = localah1;
    }
  }

  public m a(String paramString, int paramInt)
    throws com.himamis.retex.renderer.a.e.p
  {
    Object localObject = z.get(paramString);
    if (localObject == null)
      throw new com.himamis.retex.renderer.a.e.p(paramString);
    return a((p)localObject, paramInt);
  }

  public p a(p paramp1, p paramp2)
  {
    if (paramp1.b == paramp2.b)
      return A[paramp1.b].a(paramp1.a, paramp2.a);
    return null;
  }

  public void a(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public boolean a(m paramm)
  {
    return A[paramm.d()].c(paramm.b()) != null;
  }

  public float b()
  {
    return this.p;
  }

  public float b(int paramInt)
  {
    return b("axisheight") * x(paramInt) * dr.k;
  }

  public float b(int paramInt1, int paramInt2)
  {
    return A[paramInt2].c(x(paramInt1) * dr.k);
  }

  public float b(p paramp, int paramInt)
  {
    int i1 = A[paramp.b].a();
    if (i1 == -1)
      return 0.0F;
    return a(paramp, new p(i1, paramp.b), paramInt);
  }

  public dq b(float paramFloat)
  {
    return new v(this.E, paramFloat, this.q, this.r, this.s, this.t, this.u);
  }

  public m b(m paramm, int paramInt)
  {
    p localp = A[paramm.d()].c(paramm.b());
    ah localah = A[localp.b];
    return new m(localp.a, localah.i(), localp.b, a(localp, x(paramInt)));
  }

  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public boolean b(m paramm)
  {
    return A[paramm.d()].a(paramm.b()) != null;
  }

  public float c(int paramInt)
  {
    return b("bigopspacing1") * x(paramInt) * dr.k;
  }

  public int c()
  {
    return ((Number)C.get("mufontid")).intValue();
  }

  public void c(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  public float d()
  {
    return this.E;
  }

  public float d(int paramInt)
  {
    return b("bigopspacing2") * x(paramInt) * dr.k;
  }

  public void d(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public float e(int paramInt)
  {
    return b("bigopspacing3") * x(paramInt) * dr.k;
  }

  public void e(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public boolean e()
  {
    return this.q;
  }

  public float f(int paramInt)
  {
    return b("bigopspacing4") * x(paramInt) * dr.k;
  }

  public boolean f()
  {
    return this.r;
  }

  public float g(int paramInt)
  {
    return b("bigopspacing5") * x(paramInt) * dr.k;
  }

  public boolean g()
  {
    return this.t;
  }

  public float h(int paramInt)
  {
    return b("defaultrulethickness") * x(paramInt) * dr.k;
  }

  public boolean h()
  {
    return this.u;
  }

  public float i(int paramInt)
  {
    return b("denom1") * x(paramInt) * dr.k;
  }

  public boolean i()
  {
    return this.s;
  }

  public float j(int paramInt)
  {
    return b("denom2") * x(paramInt) * dr.k;
  }

  public float k(int paramInt)
  {
    return b("num1") * x(paramInt) * dr.k;
  }

  public float l(int paramInt)
  {
    return b("num2") * x(paramInt) * dr.k;
  }

  public float m(int paramInt)
  {
    return b("num3") * x(paramInt) * dr.k;
  }

  public float n(int paramInt)
  {
    int i1 = ((Number)C.get("spacefontid")).intValue();
    return A[i1].b(x(paramInt) * dr.k);
  }

  public float o(int paramInt)
  {
    return b("sub1") * x(paramInt) * dr.k;
  }

  public float p(int paramInt)
  {
    return b("sub2") * x(paramInt) * dr.k;
  }

  public float q(int paramInt)
  {
    return b("subdrop") * x(paramInt) * dr.k;
  }

  public float r(int paramInt)
  {
    return b("sup1") * x(paramInt) * dr.k;
  }

  public float s(int paramInt)
  {
    return b("sup2") * x(paramInt) * dr.k;
  }

  public float t(int paramInt)
  {
    return b("sup3") * x(paramInt) * dr.k;
  }

  public float u(int paramInt)
  {
    return b("supdrop") * x(paramInt) * dr.k;
  }

  public float v(int paramInt)
  {
    return x(paramInt) * dr.k;
  }

  public boolean w(int paramInt)
  {
    return A[paramInt].b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.v
 * JD-Core Version:    0.6.0
 */