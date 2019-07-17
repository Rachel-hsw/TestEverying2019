package com.himamis.retex.renderer.a.a;

import com.himamis.retex.renderer.a.dr;
import com.himamis.retex.renderer.a.du;
import com.himamis.retex.renderer.a.e.n;
import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.c;
import com.himamis.retex.renderer.a.g.c.g;
import com.himamis.retex.renderer.a.g.c.h;
import com.himamis.retex.renderer.a.g.c.k;
import com.himamis.retex.renderer.a.g.d;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class a
{
  private static final k a = new d().a();
  private static ConcurrentMap<b, SoftReference<a>> b = new ConcurrentHashMap(128);
  private static int c = 2147483647;
  private static ReferenceQueue d = new ReferenceQueue();

  public static Object a(Object paramObject, c paramc)
    throws n
  {
    if ((paramObject == null) || (!(paramObject instanceof b)))
      return null;
    b localb = (b)paramObject;
    SoftReference localSoftReference = (SoftReference)b.get(localb);
    if ((localSoftReference == null) || (localSoftReference.get() == null))
      localSoftReference = a(localb);
    paramc.a(((a)localSoftReference.get()).a, a);
    return localb;
  }

  public static Object a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, b paramb, c paramc)
    throws n
  {
    return a(new b(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramb), paramc);
  }

  public static Object a(String paramString, int paramInt1, int paramInt2, int paramInt3, c paramc)
    throws n
  {
    return a(paramString, paramInt1, 0, paramInt2, paramInt3, null, paramc);
  }

  private static SoftReference<a> a(b paramb)
    throws n
  {
    du localdu = new dr(paramb.a).a(paramb.b, paramb.d, paramb.c, paramb.i);
    localdu.a(new h(paramb.e, paramb.e, paramb.e, paramb.e));
    g localg = new d().b(localdu.d(), localdu.b(), 2);
    c localc = localg.c();
    localdu.a(null, localc, 0, 0);
    localc.f();
    paramb.a(localdu.d(), localdu.b(), localdu.c());
    SoftReference localSoftReference1 = new SoftReference(new a(localg, paramb), d);
    if (b.size() >= c);
    while (true)
    {
      Reference localReference = d.poll();
      if (localReference == null)
      {
        Iterator localIterator = b.keySet().iterator();
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          SoftReference localSoftReference2 = (SoftReference)b.get(localb);
          if (localSoftReference2 != null)
            localSoftReference2.clear();
          b.remove(localb);
        }
        b.put(paramb, localSoftReference1);
        return localSoftReference1;
      }
      a locala = (a)localReference.get();
      if (locala == null)
        continue;
      b.remove(locala.b);
    }
  }

  public static void a()
  {
    b.clear();
  }

  public static void a(int paramInt)
  {
    c = Math.max(paramInt, 1);
    b.clear();
    b = new ConcurrentHashMap(c);
  }

  public static int[] a(Object paramObject)
    throws n
  {
    if ((paramObject == null) || (!(paramObject instanceof b)))
      return new int[3];
    b localb = (b)paramObject;
    SoftReference localSoftReference = (SoftReference)b.get(localb);
    if ((localSoftReference == null) || (localSoftReference.get() == null))
      a(localb);
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = localb.f;
    arrayOfInt[1] = localb.g;
    arrayOfInt[2] = localb.h;
    return arrayOfInt;
  }

  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws n
  {
    return a(paramString, paramInt1, 0, paramInt2, paramInt3, null);
  }

  public static int[] a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, b paramb)
    throws n
  {
    return a(new b(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramb));
  }

  public static Object b(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws n
  {
    return b(paramString, paramInt1, 0, paramInt2, paramInt3, null);
  }

  public static Object b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, b paramb)
    throws n
  {
    b localb = new b(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramb);
    SoftReference localSoftReference = (SoftReference)b.get(localb);
    if ((localSoftReference == null) || (localSoftReference.get() == null))
      a(localb);
    return localb;
  }

  public static void b(Object paramObject)
    throws n
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
      b.remove((b)paramObject);
  }

  public static g c(Object paramObject)
    throws n
  {
    if ((paramObject == null) || (!(paramObject instanceof b)))
      return null;
    b localb = (b)paramObject;
    SoftReference localSoftReference = (SoftReference)b.get(localb);
    if ((localSoftReference == null) || (localSoftReference.get() == null))
      localSoftReference = a(localb);
    return ((a)localSoftReference.get()).a;
  }

  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws n
  {
    c(paramString, paramInt1, 0, paramInt2, paramInt3, null);
  }

  public static void c(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, b paramb)
    throws n
  {
    b.remove(new b(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramb));
  }

  public static g d(String paramString, int paramInt1, int paramInt2, int paramInt3)
    throws n
  {
    return d(paramString, paramInt1, 0, paramInt2, paramInt3, null);
  }

  public static g d(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, b paramb)
    throws n
  {
    return c(new b(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramb));
  }

  private static class a
  {
    g a;
    a.b b;

    a(g paramg, a.b paramb)
    {
      this.a = paramg;
      this.b = paramb;
    }
  }

  private static class b
  {
    String a;
    int b;
    int c;
    int d;
    int e;
    int f = -1;
    int g;
    int h;
    b i;

    b(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, b paramb)
    {
      this.a = paramString;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
      this.i = paramb;
    }

    void a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.f = paramInt1;
      this.g = paramInt2;
      this.h = paramInt3;
    }

    public boolean equals(Object paramObject)
    {
      int j = 0;
      b localb;
      if (paramObject != null)
      {
        boolean bool1 = paramObject instanceof b;
        j = 0;
        if (bool1)
        {
          localb = (b)paramObject;
          boolean bool2 = localb.a.equals(this.a);
          j = 0;
          if (bool2)
          {
            int k = localb.b;
            int m = this.b;
            j = 0;
            if (k == m)
            {
              int n = localb.c;
              int i1 = this.c;
              j = 0;
              if (n == i1)
              {
                int i2 = localb.d;
                int i3 = this.d;
                j = 0;
                if (i2 == i3)
                {
                  int i4 = localb.e;
                  int i5 = this.e;
                  j = 0;
                  if (i4 == i5)
                  {
                    boolean bool3 = localb.i.equals(this.i);
                    j = 0;
                    if (bool3)
                      j = 1;
                  }
                }
              }
            }
          }
          if (j != 0)
          {
            if (localb.f != -1)
              break label197;
            localb.f = this.f;
            localb.g = this.g;
            localb.h = this.h;
          }
        }
      }
      label197: 
      do
        return j;
      while (this.f != -1);
      this.f = localb.f;
      this.g = localb.g;
      this.h = localb.h;
      return j;
    }

    public int hashCode()
    {
      return this.a.hashCode();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.a.a
 * JD-Core Version:    0.6.0
 */