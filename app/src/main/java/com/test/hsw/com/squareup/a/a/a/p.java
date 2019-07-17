package com.squareup.a.a.a;

import b.aa;
import b.ab;
import b.e;
import b.j;
import com.squareup.a.a.b.a;
import com.squareup.a.a.b.d;
import com.squareup.a.a.b.s;
import com.squareup.a.a.l;
import com.squareup.a.aa.a;
import com.squareup.a.r.a;
import com.squareup.a.t;
import com.squareup.a.v;
import com.squareup.a.w;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class p
  implements r
{
  private static final List<j> b;
  private static final List<j> c;
  private final g d;
  private final s e;
  private com.squareup.a.a.b.ac f;

  static
  {
    j[] arrayOfj1 = new j[5];
    arrayOfj1[0] = j.a("connection");
    arrayOfj1[1] = j.a("host");
    arrayOfj1[2] = j.a("keep-alive");
    arrayOfj1[3] = j.a("proxy-connection");
    arrayOfj1[4] = j.a("transfer-encoding");
    b = l.a(arrayOfj1);
    j[] arrayOfj2 = new j[8];
    arrayOfj2[0] = j.a("connection");
    arrayOfj2[1] = j.a("host");
    arrayOfj2[2] = j.a("keep-alive");
    arrayOfj2[3] = j.a("proxy-connection");
    arrayOfj2[4] = j.a("te");
    arrayOfj2[5] = j.a("transfer-encoding");
    arrayOfj2[6] = j.a("encoding");
    arrayOfj2[7] = j.a("upgrade");
    c = l.a(arrayOfj2);
  }

  public p(g paramg, s params)
  {
    this.d = paramg;
    this.e = params;
  }

  public static aa.a a(List<d> paramList, v paramv)
    throws IOException
  {
    Object localObject1 = null;
    Object localObject2 = "HTTP/1.1";
    r.a locala = new r.a();
    locala.b(k.d, paramv.toString());
    int i = 0;
    while (i < paramList.size())
    {
      j localj = ((d)paramList.get(i)).h;
      String str = ((d)paramList.get(i)).i.a();
      Object localObject3 = localObject2;
      int j = 0;
      if (j < str.length())
      {
        int k = str.indexOf(0, j);
        if (k == -1)
          k = str.length();
        Object localObject4 = str.substring(j, k);
        if (localj.equals(d.a));
        while (true)
        {
          int m = k + 1;
          localObject1 = localObject4;
          j = m;
          break;
          if (localj.equals(d.g))
          {
            localObject3 = localObject4;
            localObject4 = localObject1;
            continue;
          }
          if (!a(paramv, localj))
            locala.a(localj.a(), (String)localObject4);
          localObject4 = localObject1;
        }
      }
      i++;
      localObject2 = localObject3;
    }
    if (localObject1 == null)
      throw new ProtocolException("Expected ':status' header not present");
    if (localObject2 == null)
      throw new ProtocolException("Expected ':version' header not present");
    q localq = q.a((String)localObject2 + " " + localObject1);
    return (aa.a)(aa.a)new aa.a().a(localq.c).a(localq.d).a(localq.e).a(locala.a());
  }

  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + '\000' + paramString2;
  }

  public static List<d> a(w paramw, v paramv, String paramString)
  {
    com.squareup.a.r localr = paramw.e();
    ArrayList localArrayList = new ArrayList(10 + localr.a());
    localArrayList.add(new d(d.b, paramw.d()));
    localArrayList.add(new d(d.c, m.a(paramw.a())));
    String str1 = g.a(paramw.a());
    LinkedHashSet localLinkedHashSet;
    int i;
    label160: j localj;
    String str2;
    if (v.c == paramv)
    {
      localArrayList.add(new d(d.g, paramString));
      localArrayList.add(new d(d.f, str1));
      localArrayList.add(new d(d.d, paramw.a().getProtocol()));
      localLinkedHashSet = new LinkedHashSet();
      i = 0;
      if (i >= localr.a())
        break label436;
      localj = j.a(localr.a(i).toLowerCase(Locale.US));
      str2 = localr.b(i);
      if (!a(paramv, localj))
        break label247;
    }
    label434: 
    while (true)
    {
      i++;
      break label160;
      if (v.d == paramv)
      {
        localArrayList.add(new d(d.e, str1));
        break;
      }
      throw new AssertionError();
      label247: if ((localj.equals(d.b)) || (localj.equals(d.c)) || (localj.equals(d.d)) || (localj.equals(d.e)) || (localj.equals(d.f)) || (localj.equals(d.g)))
        continue;
      if (localLinkedHashSet.add(localj))
      {
        localArrayList.add(new d(localj, str2));
        continue;
      }
      for (int j = 0; ; j++)
      {
        if (j >= localArrayList.size())
          break label434;
        if (!((d)localArrayList.get(j)).h.equals(localj))
          continue;
        localArrayList.set(j, new d(localj, a(((d)localArrayList.get(j)).i.a(), str2)));
        break;
      }
    }
    label436: return localArrayList;
  }

  private static boolean a(v paramv, j paramj)
  {
    if (paramv == v.c)
      return b.contains(paramj);
    if (paramv == v.d)
      return c.contains(paramj);
    throw new AssertionError(paramv);
  }

  public aa a(w paramw)
    throws IOException
  {
    b(paramw);
    return this.f.k();
  }

  public ab a(CacheRequest paramCacheRequest)
    throws IOException
  {
    return new a(this.f, paramCacheRequest);
  }

  public void a()
    throws IOException
  {
    this.f.k().close();
  }

  public void a(g paramg)
    throws IOException
  {
    this.f.a(a.l);
  }

  public void a(n paramn)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }

  public aa.a b()
    throws IOException
  {
    return a(this.f.f(), this.e.a());
  }

  public void b(w paramw)
    throws IOException
  {
    if (this.f != null)
      return;
    this.d.b();
    boolean bool = this.d.c();
    String str = m.a(this.d.k().m());
    this.f = this.e.a(a(paramw, this.e.a(), str), bool, true);
    this.f.h().a(this.d.b.b(), TimeUnit.MILLISECONDS);
  }

  public void c()
  {
  }

  public boolean d()
  {
    return true;
  }

  public void e()
  {
  }

  private static class a
    implements ab
  {
    private final com.squareup.a.a.b.ac a;
    private final ab b;
    private final CacheRequest c;
    private final OutputStream d;
    private boolean e;
    private boolean f;

    a(com.squareup.a.a.b.ac paramac, CacheRequest paramCacheRequest)
      throws IOException
    {
      this.a = paramac;
      this.b = paramac.j();
      if (paramCacheRequest != null);
      for (OutputStream localOutputStream = paramCacheRequest.getBody(); ; localOutputStream = null)
      {
        if (localOutputStream == null)
          paramCacheRequest = null;
        this.d = localOutputStream;
        this.c = paramCacheRequest;
        return;
      }
    }

    // ERROR //
    private boolean b()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 26	com/squareup/a/a/a/p$a:a	Lcom/squareup/a/a/b/ac;
      //   4: invokevirtual 49	com/squareup/a/a/b/ac:h	()Lb/ac;
      //   7: invokevirtual 54	b/ac:f	()J
      //   10: lstore_1
      //   11: aload_0
      //   12: getfield 26	com/squareup/a/a/a/p$a:a	Lcom/squareup/a/a/b/ac;
      //   15: invokevirtual 49	com/squareup/a/a/b/ac:h	()Lb/ac;
      //   18: ldc2_w 55
      //   21: getstatic 62	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   24: invokevirtual 65	b/ac:a	(JLjava/util/concurrent/TimeUnit;)Lb/ac;
      //   27: pop
      //   28: aload_0
      //   29: bipush 100
      //   31: invokestatic 70	com/squareup/a/a/l:a	(Lb/ab;I)Z
      //   34: pop
      //   35: aload_0
      //   36: getfield 26	com/squareup/a/a/a/p$a:a	Lcom/squareup/a/a/b/ac;
      //   39: invokevirtual 49	com/squareup/a/a/b/ac:h	()Lb/ac;
      //   42: lload_1
      //   43: getstatic 73	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   46: invokevirtual 65	b/ac:a	(JLjava/util/concurrent/TimeUnit;)Lb/ac;
      //   49: pop
      //   50: iconst_1
      //   51: ireturn
      //   52: astore 6
      //   54: aload_0
      //   55: getfield 26	com/squareup/a/a/a/p$a:a	Lcom/squareup/a/a/b/ac;
      //   58: invokevirtual 49	com/squareup/a/a/b/ac:h	()Lb/ac;
      //   61: lload_1
      //   62: getstatic 73	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   65: invokevirtual 65	b/ac:a	(JLjava/util/concurrent/TimeUnit;)Lb/ac;
      //   68: pop
      //   69: iconst_0
      //   70: ireturn
      //   71: astore 4
      //   73: aload_0
      //   74: getfield 26	com/squareup/a/a/a/p$a:a	Lcom/squareup/a/a/b/ac;
      //   77: invokevirtual 49	com/squareup/a/a/b/ac:h	()Lb/ac;
      //   80: lload_1
      //   81: getstatic 73	java/util/concurrent/TimeUnit:NANOSECONDS	Ljava/util/concurrent/TimeUnit;
      //   84: invokevirtual 65	b/ac:a	(JLjava/util/concurrent/TimeUnit;)Lb/ac;
      //   87: pop
      //   88: aload 4
      //   90: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   28	35	52	java/io/IOException
      //   28	35	71	finally
    }

    public b.ac a()
    {
      return this.b.a();
    }

    public long b(e parame, long paramLong)
      throws IOException
    {
      if (paramLong < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + paramLong);
      if (this.f)
        throw new IllegalStateException("closed");
      long l;
      if (this.e)
        l = -1L;
      do
      {
        return l;
        l = this.b.b(parame, paramLong);
        if (l != -1L)
          continue;
        this.e = true;
        if (this.c != null)
          this.d.close();
        return -1L;
      }
      while (this.d == null);
      parame.a(this.d, parame.c() - l, l);
      return l;
    }

    public void close()
      throws IOException
    {
      if (this.f);
      do
      {
        do
        {
          return;
          if ((!this.e) && (this.d != null))
            b();
          this.f = true;
        }
        while (this.e);
        this.a.b(a.l);
      }
      while (this.c == null);
      this.c.abort();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.p
 * JD-Core Version:    0.6.0
 */