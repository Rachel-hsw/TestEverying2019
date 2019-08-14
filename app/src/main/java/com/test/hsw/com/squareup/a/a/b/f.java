package com.squareup.a.a.b;

import b.ab;
import b.e;
import b.i;
import b.j;
import b.q;
import com.squareup.a.a.a;
import com.squareup.a.a.a.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class f
{
  private static final int a = 15;
  private static final int b = 63;
  private static final int c = 127;
  private static final d[] d;
  private static final Map<j, Integer> e;

  static
  {
    d[] arrayOfd = new d[61];
    arrayOfd[0] = new d(d.e, "");
    arrayOfd[1] = new d(d.b, "GET");
    arrayOfd[2] = new d(d.b, "POST");
    arrayOfd[3] = new d(d.c, "/");
    arrayOfd[4] = new d(d.c, "/index.html");
    arrayOfd[5] = new d(d.d, "http");
    arrayOfd[6] = new d(d.d, "https");
    arrayOfd[7] = new d(d.a, "200");
    arrayOfd[8] = new d(d.a, "204");
    arrayOfd[9] = new d(d.a, "206");
    arrayOfd[10] = new d(d.a, "304");
    arrayOfd[11] = new d(d.a, "400");
    arrayOfd[12] = new d(d.a, "404");
    arrayOfd[13] = new d(d.a, "500");
    arrayOfd[14] = new d("accept-charset", "");
    arrayOfd[15] = new d("accept-encoding", "");
    arrayOfd[16] = new d("accept-language", "");
    arrayOfd[17] = new d("accept-ranges", "");
    arrayOfd[18] = new d("accept", "");
    arrayOfd[19] = new d("access-control-allow-origin", "");
    arrayOfd[20] = new d("age", "");
    arrayOfd[21] = new d("allow", "");
    arrayOfd[22] = new d("authorization", "");
    arrayOfd[23] = new d("cache-control", "");
    arrayOfd[24] = new d("content-disposition", "");
    arrayOfd[25] = new d("content-encoding", "");
    arrayOfd[26] = new d("content-language", "");
    arrayOfd[27] = new d("content-length", "");
    arrayOfd[28] = new d("content-location", "");
    arrayOfd[29] = new d("content-range", "");
    arrayOfd[30] = new d("content-type", "");
    arrayOfd[31] = new d("cookie", "");
    arrayOfd[32] = new d("date", "");
    arrayOfd[33] = new d("etag", "");
    arrayOfd[34] = new d("expect", "");
    arrayOfd[35] = new d("expires", "");
    arrayOfd[36] = new d("from", "");
    arrayOfd[37] = new d("host", "");
    arrayOfd[38] = new d("if-match", "");
    arrayOfd[39] = new d("if-modified-since", "");
    arrayOfd[40] = new d("if-none-match", "");
    arrayOfd[41] = new d("if-range", "");
    arrayOfd[42] = new d("if-unmodified-since", "");
    arrayOfd[43] = new d("last-modified", "");
    arrayOfd[44] = new d("link", "");
    arrayOfd[45] = new d("location", "");
    arrayOfd[46] = new d("max-forwards", "");
    arrayOfd[47] = new d("proxy-authenticate", "");
    arrayOfd[48] = new d("proxy-authorization", "");
    arrayOfd[49] = new d("range", "");
    arrayOfd[50] = new d("referer", "");
    arrayOfd[51] = new d("refresh", "");
    arrayOfd[52] = new d("retry-after", "");
    arrayOfd[53] = new d("server", "");
    arrayOfd[54] = new d("set-cookie", "");
    arrayOfd[55] = new d("strict-transport-security", "");
    arrayOfd[56] = new d("transfer-encoding", "");
    arrayOfd[57] = new d("user-agent", "");
    arrayOfd[58] = new d("vary", "");
    arrayOfd[59] = new d("via", "");
    arrayOfd[60] = new d("www-authenticate", "");
    d = arrayOfd;
    e = c();
  }

  private static j b(j paramj)
    throws IOException
  {
    int i = 0;
    int j = paramj.f();
    while (i < j)
    {
      int k = paramj.a(i);
      if ((k >= 65) && (k <= 90))
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + paramj.a());
      i++;
    }
    return paramj;
  }

  private static Map<j, Integer> c()
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap(d.length);
    for (int i = 0; i < d.length; i++)
    {
      if (localLinkedHashMap.containsKey(d[i].h))
        continue;
      localLinkedHashMap.put(d[i].h, Integer.valueOf(i));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }

  static final class a
  {
    d[] a = new d[8];
    int b = -1 + this.a.length;
    int c = 0;
    a d = new a.a();
    a e = new a.a();
    int f = 0;
    private final List<d> g = new ArrayList();
    private final i h;
    private int i;
    private int j;

    a(int paramInt, ab paramab)
    {
      this.i = paramInt;
      this.j = paramInt;
      this.h = q.a(paramab);
    }

    private void a(int paramInt, d paramd)
    {
      int k = paramd.j;
      if (paramInt != -1);
      for (int m = k - this.a[d(paramInt)].j; ; m = k)
      {
        if (m > this.j)
        {
          g();
          this.g.add(paramd);
          return;
        }
        int n = b(m + this.f - this.j);
        if (paramInt == -1)
        {
          if (1 + this.c > this.a.length)
          {
            d[] arrayOfd = new d[2 * this.a.length];
            System.arraycopy(this.a, 0, arrayOfd, this.a.length, this.a.length);
            if (arrayOfd.length == 64)
            {
              this.d = ((a.a)this.d).b();
              this.e = ((a.a)this.e).b();
            }
            this.d.d(this.a.length);
            this.e.d(this.a.length);
            this.b = (-1 + this.a.length);
            this.a = arrayOfd;
          }
          int i2 = this.b;
          this.b = (i2 - 1);
          this.d.a(i2);
          this.a[i2] = paramd;
          this.c = (1 + this.c);
        }
        while (true)
        {
          this.f = (m + this.f);
          return;
          int i1 = paramInt + (n + d(paramInt));
          this.d.a(i1);
          this.a[i1] = paramd;
        }
      }
    }

    private int b(int paramInt)
    {
      int k = 0;
      if (paramInt > 0)
      {
        for (int m = -1 + this.a.length; (m >= this.b) && (paramInt > 0); m--)
        {
          paramInt -= this.a[m].j;
          this.f -= this.a[m].j;
          this.c = (-1 + this.c);
          k++;
        }
        this.d.d(k);
        this.e.d(k);
        System.arraycopy(this.a, 1 + this.b, this.a, k + (1 + this.b), this.c);
        this.b = (k + this.b);
      }
      return k;
    }

    private void c(int paramInt)
      throws IOException
    {
      if (h(paramInt))
      {
        int m = paramInt - this.c;
        if (m > -1 + f.a().length)
          throw new IOException("Header index too large " + (m + 1));
        d locald = f.a()[m];
        if (this.j == 0)
        {
          this.g.add(locald);
          return;
        }
        a(-1, locald);
        return;
      }
      int k = d(paramInt);
      if (!this.d.c(k))
      {
        this.g.add(this.a[k]);
        this.e.a(k);
      }
      this.d.b(k);
    }

    private int d(int paramInt)
    {
      return paramInt + (1 + this.b);
    }

    private void e(int paramInt)
      throws IOException
    {
      j localj1 = g(paramInt);
      j localj2 = e();
      this.g.add(new d(localj1, localj2));
    }

    private void f()
    {
      if (this.j < this.f)
      {
        if (this.j == 0)
          g();
      }
      else
        return;
      b(this.f - this.j);
    }

    private void f(int paramInt)
      throws IOException
    {
      a(-1, new d(g(paramInt), e()));
    }

    private j g(int paramInt)
    {
      if (h(paramInt))
        return f.a()[(paramInt - this.c)].h;
      return this.a[d(paramInt)].h;
    }

    private void g()
    {
      h();
      Arrays.fill(this.a, null);
      this.b = (-1 + this.a.length);
      this.c = 0;
      this.f = 0;
    }

    private void h()
    {
      this.d.a();
      this.e.a();
    }

    private boolean h(int paramInt)
    {
      return paramInt >= this.c;
    }

    private void i()
      throws IOException
    {
      j localj1 = f.a(e());
      j localj2 = e();
      this.g.add(new d(localj1, localj2));
    }

    private void j()
      throws IOException
    {
      a(-1, new d(f.a(e()), e()));
    }

    private int k()
      throws IOException
    {
      return 0xFF & this.h.j();
    }

    int a()
    {
      return this.j;
    }

    int a(int paramInt1, int paramInt2)
      throws IOException
    {
      int k = paramInt1 & paramInt2;
      if (k < paramInt2)
        return k;
      int n;
      for (int m = 0; ; m += 7)
      {
        n = k();
        if ((n & 0x80) == 0)
          break;
        paramInt2 += ((n & 0x7F) << m);
      }
      return paramInt2 + (n << m);
    }

    void a(int paramInt)
    {
      this.i = paramInt;
      this.j = this.i;
      f();
    }

    void b()
      throws IOException
    {
      while (!this.h.g())
      {
        int k = 0xFF & this.h.j();
        if (k == 128)
          throw new IOException("index == 0");
        if ((k & 0x80) == 128)
        {
          c(-1 + a(k, 127));
          continue;
        }
        if (k == 64)
        {
          j();
          continue;
        }
        if ((k & 0x40) == 64)
        {
          f(-1 + a(k, 63));
          continue;
        }
        if ((k & 0x20) == 32)
        {
          if ((k & 0x10) == 16)
          {
            if ((k & 0xF) != 0)
              throw new IOException("Invalid header table state change " + k);
            h();
            continue;
          }
          this.j = a(k, 15);
          if ((this.j < 0) || (this.j > this.i))
            throw new IOException("Invalid header table byte count " + this.j);
          f();
          continue;
        }
        if ((k == 16) || (k == 0))
        {
          i();
          continue;
        }
        e(-1 + a(k, 15));
      }
    }

    void c()
    {
      for (int k = -1 + this.a.length; k != this.b; k--)
      {
        if ((!this.d.c(k)) || (this.e.c(k)))
          continue;
        this.g.add(this.a[k]);
      }
    }

    List<d> d()
    {
      ArrayList localArrayList = new ArrayList(this.g);
      this.g.clear();
      this.e.a();
      return localArrayList;
    }

    j e()
      throws IOException
    {
      int k = k();
      if ((k & 0x80) == 128);
      int n;
      for (int m = 1; ; m = 0)
      {
        n = a(k, 127);
        if (m == 0)
          break;
        return j.a(h.a().b(this.h.f(n)));
      }
      return this.h.c(n);
    }
  }

  static final class b
  {
    private final e a;

    b(e parame)
    {
      this.a = parame;
    }

    void a(int paramInt1, int paramInt2, int paramInt3)
      throws IOException
    {
      if (paramInt1 < paramInt2)
      {
        this.a.a(paramInt3 | paramInt1);
        return;
      }
      this.a.a(paramInt3 | paramInt2);
      int i = paramInt1 - paramInt2;
      while (i >= 128)
      {
        int j = i & 0x7F;
        this.a.a(j | 0x80);
        i >>>= 7;
      }
      this.a.a(i);
    }

    void a(j paramj)
      throws IOException
    {
      a(paramj.f(), 127, 0);
      this.a.a(paramj);
    }

    void a(List<d> paramList)
      throws IOException
    {
      int i = paramList.size();
      int j = 0;
      if (j < i)
      {
        j localj = ((d)paramList.get(j)).h.d();
        Integer localInteger = (Integer)f.b().get(localj);
        if (localInteger != null)
        {
          a(1 + localInteger.intValue(), 15, 0);
          a(((d)paramList.get(j)).i);
        }
        while (true)
        {
          j++;
          break;
          this.a.a(0);
          a(localj);
          a(((d)paramList.get(j)).i);
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b.f
 * JD-Core Version:    0.6.0
 */