package com.a.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.a.a.b.a.g;
import com.a.a.c.d;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class e
{
  final Resources a;
  final int b;
  final int c;
  final int d;
  final int e;
  final com.a.a.b.g.a f;
  final Executor g;
  final Executor h;
  final boolean i;
  final boolean j;
  final int k;
  final int l;
  final g m;
  final com.a.a.a.b.c n;
  final com.a.a.a.a.b o;
  final com.a.a.b.d.b p;
  final com.a.a.b.b.b q;
  final c r;
  final com.a.a.b.d.b s;
  final com.a.a.b.d.b t;

  private e(a parama)
  {
    this.a = a.a(parama).getResources();
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.g = a.g(parama);
    this.h = a.h(parama);
    this.k = a.i(parama);
    this.l = a.j(parama);
    this.m = a.k(parama);
    this.o = a.l(parama);
    this.n = a.m(parama);
    this.r = a.n(parama);
    this.p = a.o(parama);
    this.q = a.p(parama);
    this.i = a.q(parama);
    this.j = a.r(parama);
    this.s = new b(this.p);
    this.t = new c(this.p);
    d.a(a.s(parama));
  }

  public static e a(Context paramContext)
  {
    return new a(paramContext).c();
  }

  com.a.a.b.a.e a()
  {
    DisplayMetrics localDisplayMetrics = this.a.getDisplayMetrics();
    int i1 = this.b;
    if (i1 <= 0)
      i1 = localDisplayMetrics.widthPixels;
    int i2 = this.c;
    if (i2 <= 0)
      i2 = localDisplayMetrics.heightPixels;
    return new com.a.a.b.a.e(i1, i2);
  }

  public static class a
  {
    public static final int a = 3;
    public static final int b = 4;
    public static final g c = g.a;
    private static final String d = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";
    private static final String e = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";
    private static final String f = "memoryCache() and memoryCacheSize() calls overlap each other";
    private static final String g = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
    private com.a.a.a.a.b.a A = null;
    private com.a.a.b.d.b B = null;
    private com.a.a.b.b.b C;
    private c D = null;
    private boolean E = false;
    private Context h;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private com.a.a.b.g.a m = null;
    private Executor n = null;
    private Executor o = null;
    private boolean p = false;
    private boolean q = false;
    private int r = 3;
    private int s = 4;
    private boolean t = false;
    private g u = c;
    private int v = 0;
    private long w = 0L;
    private int x = 0;
    private com.a.a.a.b.c y = null;
    private com.a.a.a.a.b z = null;

    public a(Context paramContext)
    {
      this.h = paramContext.getApplicationContext();
    }

    private void d()
    {
      if (this.n == null)
      {
        this.n = a.a(this.r, this.s, this.u);
        if (this.o != null)
          break label198;
        this.o = a.a(this.r, this.s, this.u);
      }
      while (true)
      {
        if (this.z == null)
        {
          if (this.A == null)
            this.A = a.b();
          this.z = a.a(this.h, this.A, this.w, this.x);
        }
        if (this.y == null)
          this.y = a.a(this.v);
        if (this.t)
          this.y = new com.a.a.a.b.a.b(this.y, com.a.a.c.e.a());
        if (this.B == null)
          this.B = a.a(this.h);
        if (this.C == null)
          this.C = a.a(this.E);
        if (this.D == null)
          this.D = c.t();
        return;
        this.p = true;
        break;
        label198: this.q = true;
      }
    }

    public a a()
    {
      this.t = true;
      return this;
    }

    public a a(int paramInt)
    {
      if ((this.n != null) || (this.o != null))
        d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      this.r = paramInt;
      return this;
    }

    public a a(int paramInt1, int paramInt2)
    {
      this.i = paramInt1;
      this.j = paramInt2;
      return this;
    }

    @Deprecated
    public a a(int paramInt1, int paramInt2, com.a.a.b.g.a parama)
    {
      return b(paramInt1, paramInt2, parama);
    }

    @Deprecated
    public a a(com.a.a.a.a.b.a parama)
    {
      return b(parama);
    }

    @Deprecated
    public a a(com.a.a.a.a.b paramb)
    {
      return b(paramb);
    }

    public a a(com.a.a.a.b.c paramc)
    {
      if (this.v != 0)
        d.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      this.y = paramc;
      return this;
    }

    public a a(g paramg)
    {
      if ((this.n != null) || (this.o != null))
        d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      this.u = paramg;
      return this;
    }

    public a a(com.a.a.b.b.b paramb)
    {
      this.C = paramb;
      return this;
    }

    public a a(c paramc)
    {
      this.D = paramc;
      return this;
    }

    public a a(com.a.a.b.d.b paramb)
    {
      this.B = paramb;
      return this;
    }

    public a a(Executor paramExecutor)
    {
      if ((this.r != 3) || (this.s != 4) || (this.u != c))
        d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      this.n = paramExecutor;
      return this;
    }

    public a b()
    {
      this.E = true;
      return this;
    }

    public a b(int paramInt)
    {
      if ((this.n != null) || (this.o != null))
        d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      if (paramInt < 1)
      {
        this.s = 1;
        return this;
      }
      if (paramInt > 10)
      {
        this.s = 10;
        return this;
      }
      this.s = paramInt;
      return this;
    }

    public a b(int paramInt1, int paramInt2, com.a.a.b.g.a parama)
    {
      this.k = paramInt1;
      this.l = paramInt2;
      this.m = parama;
      return this;
    }

    public a b(com.a.a.a.a.b.a parama)
    {
      if (this.z != null)
        d.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
      this.A = parama;
      return this;
    }

    public a b(com.a.a.a.a.b paramb)
    {
      if ((this.w > 0L) || (this.x > 0))
        d.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      if (this.A != null)
        d.c("diskCache() and diskCacheFileNameGenerator() calls overlap each other", new Object[0]);
      this.z = paramb;
      return this;
    }

    public a b(Executor paramExecutor)
    {
      if ((this.r != 3) || (this.s != 4) || (this.u != c))
        d.c("threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.", new Object[0]);
      this.o = paramExecutor;
      return this;
    }

    public a c(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("memoryCacheSize must be a positive number");
      if (this.y != null)
        d.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      this.v = paramInt;
      return this;
    }

    public e c()
    {
      d();
      return new e(this, null);
    }

    public a d(int paramInt)
    {
      if ((paramInt <= 0) || (paramInt >= 100))
        throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
      if (this.y != null)
        d.c("memoryCache() and memoryCacheSize() calls overlap each other", new Object[0]);
      this.v = (int)((float)Runtime.getRuntime().maxMemory() * (paramInt / 100.0F));
      return this;
    }

    @Deprecated
    public a e(int paramInt)
    {
      return f(paramInt);
    }

    public a f(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("maxCacheSize must be a positive number");
      if (this.z != null)
        d.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      this.w = paramInt;
      return this;
    }

    @Deprecated
    public a g(int paramInt)
    {
      return h(paramInt);
    }

    public a h(int paramInt)
    {
      if (paramInt <= 0)
        throw new IllegalArgumentException("maxFileCount must be a positive number");
      if (this.z != null)
        d.c("diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other", new Object[0]);
      this.x = paramInt;
      return this;
    }
  }

  private static class b
    implements com.a.a.b.d.b
  {
    private final com.a.a.b.d.b a;

    public b(com.a.a.b.d.b paramb)
    {
      this.a = paramb;
    }

    public InputStream a(String paramString, Object paramObject)
      throws IOException
    {
      switch (e.1.a[com.a.a.b.d.b.a.a(paramString).ordinal()])
      {
      default:
        return this.a.a(paramString, paramObject);
      case 1:
      case 2:
      }
      throw new IllegalStateException();
    }
  }

  private static class c
    implements com.a.a.b.d.b
  {
    private final com.a.a.b.d.b a;

    public c(com.a.a.b.d.b paramb)
    {
      this.a = paramb;
    }

    public InputStream a(String paramString, Object paramObject)
      throws IOException
    {
      InputStream localInputStream = this.a.a(paramString, paramObject);
      switch (e.1.a[com.a.a.b.d.b.a.a(paramString).ordinal()])
      {
      default:
        return localInputStream;
      case 1:
      case 2:
      }
      return new com.a.a.b.a.c(localInputStream);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.e
 * JD-Core Version:    0.6.0
 */