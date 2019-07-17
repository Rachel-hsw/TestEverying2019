package com.squareup.a.a.a;

import com.squareup.a.aa;
import com.squareup.a.aa.a;
import com.squareup.a.g;
import com.squareup.a.r;
import com.squareup.a.w;
import com.squareup.a.w.a;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class b
{
  public final w a;
  public final aa b;

  private b(w paramw, aa paramaa)
  {
    this.a = paramw;
    this.b = paramaa;
  }

  public static boolean a(aa paramaa, w paramw)
  {
    int i = paramaa.c();
    if ((i != 200) && (i != 203) && (i != 300) && (i != 301) && (i != 410));
    g localg;
    do
    {
      return false;
      localg = paramaa.n();
    }
    while (((paramw.a("Authorization") != null) && (!localg.e()) && (!localg.f()) && (localg.d() == -1)) || (localg.b()));
    return true;
  }

  public static class a
  {
    final long a;
    final w b;
    final aa c;
    private Date d;
    private String e;
    private Date f;
    private String g;
    private Date h;
    private long i;
    private long j;
    private String k;
    private int l = -1;

    public a(long paramLong, w paramw, aa paramaa)
    {
      this.a = paramLong;
      this.b = paramw;
      this.c = paramaa;
      if (paramaa != null)
      {
        int m = 0;
        if (m < paramaa.f().a())
        {
          String str1 = paramaa.f().a(m);
          String str2 = paramaa.f().b(m);
          if ("Date".equalsIgnoreCase(str1))
          {
            this.d = e.a(str2);
            this.e = str2;
          }
          while (true)
          {
            m++;
            break;
            if ("Expires".equalsIgnoreCase(str1))
            {
              this.h = e.a(str2);
              continue;
            }
            if ("Last-Modified".equalsIgnoreCase(str1))
            {
              this.f = e.a(str2);
              this.g = str2;
              continue;
            }
            if ("ETag".equalsIgnoreCase(str1))
            {
              this.k = str2;
              continue;
            }
            if ("Age".equalsIgnoreCase(str1))
            {
              this.l = c.a(str2);
              continue;
            }
            if (k.b.equalsIgnoreCase(str1))
            {
              this.i = Long.parseLong(str2);
              continue;
            }
            if (!k.c.equalsIgnoreCase(str1))
              continue;
            this.j = Long.parseLong(str2);
          }
        }
      }
    }

    private static boolean a(w paramw)
    {
      return (paramw.a("If-Modified-Since") != null) || (paramw.a("If-None-Match") != null);
    }

    private b b()
    {
      long l1 = 0L;
      if (this.c == null)
        return new b(this.b, null, null);
      if ((this.b.j()) && (this.c.e() == null))
        return new b(this.b, null, null);
      if (!b.a(this.c, this.b))
        return new b(this.b, null, null);
      g localg1 = this.b.i();
      if ((localg1.a()) || (a(this.b)))
        return new b(this.b, null, null);
      long l2 = d();
      long l3 = c();
      if (localg1.c() != -1)
        l3 = Math.min(l3, TimeUnit.SECONDS.toMillis(localg1.c()));
      long l4;
      if (localg1.h() != -1)
        l4 = TimeUnit.SECONDS.toMillis(localg1.h());
      while (true)
      {
        g localg2 = this.c.n();
        if ((!localg2.f()) && (localg1.g() != -1))
          l1 = TimeUnit.SECONDS.toMillis(localg1.g());
        if ((!localg2.a()) && (l2 + l4 < l1 + l3))
        {
          aa.a locala1 = this.c.h();
          if (l4 + l2 >= l3)
            locala1.b("Warning", "110 HttpURLConnection \"Response is stale\"");
          if ((l2 > 86400000L) && (e()))
            locala1.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
          return new b(null, locala1.a(), null);
        }
        w.a locala = this.b.h();
        if (this.f != null)
          locala.a("If-Modified-Since", this.g);
        w localw;
        while (true)
        {
          if (this.k != null)
            locala.a("If-None-Match", this.k);
          localw = locala.d();
          if (!a(localw))
            break;
          return new b(localw, this.c, null);
          if (this.d == null)
            continue;
          locala.a("If-Modified-Since", this.e);
        }
        return new b(localw, null, null);
        l4 = l1;
      }
    }

    private long c()
    {
      long l1 = 0L;
      g localg = this.c.n();
      if (localg.c() != -1)
        l1 = TimeUnit.SECONDS.toMillis(localg.c());
      label86: 
      do
      {
        return l1;
        if (this.h == null)
          continue;
        long l4;
        long l5;
        if (this.d != null)
        {
          l4 = this.d.getTime();
          l5 = this.h.getTime() - l4;
          if (l5 <= l1)
            break label86;
        }
        while (true)
        {
          return l5;
          l4 = this.j;
          break;
          l5 = l1;
        }
      }
      while ((this.f == null) || (this.c.a().a().getQuery() != null));
      long l2;
      if (this.d != null)
        l2 = this.d.getTime();
      while (true)
      {
        long l3 = l2 - this.f.getTime();
        if (l3 <= l1)
          break;
        return l3 / 10L;
        l2 = this.i;
      }
    }

    private long d()
    {
      long l1 = 0L;
      if (this.d != null)
        l1 = Math.max(l1, this.j - this.d.getTime());
      if (this.l != -1)
        l1 = Math.max(l1, TimeUnit.SECONDS.toMillis(this.l));
      long l2 = this.j - this.i;
      return this.a - this.j + (l1 + l2);
    }

    private boolean e()
    {
      return (this.c.n().c() == -1) && (this.h == null);
    }

    public b a()
    {
      b localb = b();
      if ((localb.a != null) && (this.b.i().i()))
        localb = new b(null, null, null);
      return localb;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.b
 * JD-Core Version:    0.6.0
 */