package com.squareup.a;

import b.i;
import b.j;
import com.squareup.a.a.a.k;
import com.squareup.a.a.b.a;
import com.squareup.a.a.b.c;
import com.squareup.a.a.h;
import com.squareup.a.a.l;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheRequest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
{
  private static final int b = 201105;
  private static final int c = 0;
  private static final int d = 1;
  private static final int e = 2;
  final h a = new d(this);
  private final com.squareup.a.a.b f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;

  public c(File paramFile, long paramLong)
    throws IOException
  {
    this.f = com.squareup.a.a.b.a(paramFile, 201105, 2, paramLong);
  }

  // ERROR //
  private CacheRequest a(aa paramaa)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 52	com/squareup/a/aa:a	()Lcom/squareup/a/w;
    //   4: invokevirtual 57	com/squareup/a/w:d	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 52	com/squareup/a/aa:a	()Lcom/squareup/a/w;
    //   12: invokevirtual 57	com/squareup/a/w:d	()Ljava/lang/String;
    //   15: invokestatic 62	com/squareup/a/a/a/i:a	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 52	com/squareup/a/aa:a	()Lcom/squareup/a/w;
    //   26: invokespecial 65	com/squareup/a/c:c	(Lcom/squareup/a/w;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_2
    //   32: ldc 67
    //   34: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq -8 -> 29
    //   40: aload_1
    //   41: invokestatic 78	com/squareup/a/a/a/k:b	(Lcom/squareup/a/aa;)Z
    //   44: ifne -15 -> 29
    //   47: new 80	com/squareup/a/c$c
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 83	com/squareup/a/c$c:<init>	(Lcom/squareup/a/aa;)V
    //   55: astore_3
    //   56: aload_0
    //   57: getfield 43	com/squareup/a/c:f	Lcom/squareup/a/a/b;
    //   60: aload_1
    //   61: invokevirtual 52	com/squareup/a/aa:a	()Lcom/squareup/a/w;
    //   64: invokestatic 86	com/squareup/a/c:b	(Lcom/squareup/a/w;)Ljava/lang/String;
    //   67: invokevirtual 89	com/squareup/a/a/b:b	(Ljava/lang/String;)Lcom/squareup/a/a/b$a;
    //   70: astore 6
    //   72: aload 6
    //   74: ifnull -45 -> 29
    //   77: aload_3
    //   78: aload 6
    //   80: invokevirtual 92	com/squareup/a/c$c:a	(Lcom/squareup/a/a/b$a;)V
    //   83: new 94	com/squareup/a/c$a
    //   86: dup
    //   87: aload_0
    //   88: aload 6
    //   90: invokespecial 97	com/squareup/a/c$a:<init>	(Lcom/squareup/a/c;Lcom/squareup/a/a/b$a;)V
    //   93: astore 8
    //   95: aload 8
    //   97: areturn
    //   98: astore 4
    //   100: aconst_null
    //   101: astore 5
    //   103: aload_0
    //   104: aload 5
    //   106: invokespecial 98	com/squareup/a/c:a	(Lcom/squareup/a/a/b$a;)V
    //   109: aconst_null
    //   110: areturn
    //   111: astore 7
    //   113: aload 6
    //   115: astore 5
    //   117: goto -14 -> 103
    //   120: astore 9
    //   122: aconst_null
    //   123: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   56	72	98	java/io/IOException
    //   77	95	111	java/io/IOException
    //   21	29	120	java/io/IOException
  }

  private void a(com.squareup.a.a.a.b paramb)
  {
    monitorenter;
    try
    {
      this.k = (1 + this.k);
      if (paramb.a != null)
        this.i = (1 + this.i);
      while (true)
      {
        return;
        if (paramb.b == null)
          continue;
        this.j = (1 + this.j);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void a(b.a parama)
  {
    if (parama != null);
    try
    {
      parama.b();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  private void a(aa paramaa1, aa paramaa2)
  {
    c localc = new c(paramaa2);
    b.c localc1 = b.a((b)paramaa1.g());
    b.a locala = null;
    try
    {
      locala = localc1.a();
      if (locala != null)
      {
        localc.a(locala);
        locala.a();
      }
      return;
    }
    catch (IOException localIOException)
    {
      a(locala);
    }
  }

  private static int b(i parami)
    throws IOException
  {
    String str = parami.t();
    try
    {
      int m = Integer.parseInt(str);
      return m;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new IOException("Expected an integer but was \"" + str + "\"");
  }

  private static String b(w paramw)
  {
    return l.b(paramw.c());
  }

  private void c(w paramw)
    throws IOException
  {
    this.f.c(b(paramw));
  }

  private void m()
  {
    monitorenter;
    try
    {
      this.j = (1 + this.j);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  aa a(w paramw)
  {
    String str = b(paramw);
    try
    {
      b.c localc = this.f.a(str);
      if (localc == null)
        return null;
      aa localaa;
      try
      {
        c localc1 = new c(localc.a(0));
        localaa = localc1.a(paramw, localc);
        if (!localc1.a(paramw, localaa))
        {
          l.a(localaa.g());
          return null;
        }
      }
      catch (IOException localIOException2)
      {
        l.a(localc);
        return null;
      }
      return localaa;
    }
    catch (IOException localIOException1)
    {
    }
    return null;
  }

  public void a()
    throws IOException
  {
    this.f.f();
  }

  public int b()
  {
    monitorenter;
    try
    {
      int m = this.h;
      monitorexit;
      return m;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int c()
  {
    monitorenter;
    try
    {
      int m = this.g;
      monitorexit;
      return m;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public long d()
  {
    return this.f.c();
  }

  public long e()
  {
    return this.f.b();
  }

  public void f()
    throws IOException
  {
    this.f.e();
  }

  public void g()
    throws IOException
  {
    this.f.close();
  }

  public File h()
  {
    return this.f.a();
  }

  public boolean i()
  {
    return this.f.d();
  }

  public int j()
  {
    monitorenter;
    try
    {
      int m = this.i;
      monitorexit;
      return m;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int k()
  {
    monitorenter;
    try
    {
      int m = this.j;
      monitorexit;
      return m;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public int l()
  {
    monitorenter;
    try
    {
      int m = this.k;
      monitorexit;
      return m;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private final class a extends CacheRequest
  {
    private final b.a b;
    private OutputStream c;
    private boolean d;
    private OutputStream e;

    public a(b.a arg2)
      throws IOException
    {
      b.a locala;
      this.b = locala;
      this.c = locala.c(1);
      this.e = new e(this, this.c, c.this, locala);
    }

    public void abort()
    {
      synchronized (c.this)
      {
        if (this.d)
          return;
        this.d = true;
        c.c(c.this);
        l.a(this.c);
        try
        {
          this.b.b();
          return;
        }
        catch (IOException localIOException)
        {
          return;
        }
      }
    }

    public OutputStream getBody()
      throws IOException
    {
      return this.e;
    }
  }

  private static class b extends ab
  {
    private final b.c a;
    private final i b;
    private final String c;
    private final String d;

    public b(b.c paramc, String paramString1, String paramString2)
    {
      this.a = paramc;
      this.c = paramString1;
      this.d = paramString2;
      this.b = b.q.a(new f(this, b.q.a(paramc.a(1)), paramc));
    }

    public s a()
    {
      if (this.c != null)
        return s.a(this.c);
      return null;
    }

    public long b()
    {
      long l1 = -1L;
      try
      {
        if (this.d != null)
        {
          long l2 = Long.parseLong(this.d);
          l1 = l2;
        }
        return l1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      return l1;
    }

    public i c()
    {
      return this.b;
    }
  }

  private static final class c
  {
    private final String a;
    private final r b;
    private final String c;
    private final v d;
    private final int e;
    private final String f;
    private final r g;
    private final q h;

    public c(aa paramaa)
    {
      this.a = paramaa.a().c();
      this.b = k.c(paramaa);
      this.c = paramaa.a().d();
      this.d = paramaa.b();
      this.e = paramaa.c();
      this.f = paramaa.d();
      this.g = paramaa.f();
      this.h = paramaa.e();
    }

    public c(InputStream paramInputStream)
      throws IOException
    {
      i locali;
      try
      {
        locali = b.q.a(b.q.a(paramInputStream));
        this.a = locali.t();
        this.c = locali.t();
        r.a locala1 = new r.a();
        int j = c.a(locali);
        for (int k = 0; k < j; k++)
          locala1.a(locali.t());
        this.b = locala1.a();
        com.squareup.a.a.a.q localq = com.squareup.a.a.a.q.a(locali.t());
        this.d = localq.c;
        this.e = localq.d;
        this.f = localq.e;
        r.a locala2 = new r.a();
        int m = c.a(locali);
        while (i < m)
        {
          locala2.a(locali.t());
          i++;
        }
        this.g = locala2.a();
        if (a())
        {
          String str = locali.t();
          if (str.length() > 0)
            throw new IOException("expected \"\" but was \"" + str + "\"");
        }
      }
      finally
      {
        paramInputStream.close();
      }
      for (this.h = q.a(locali.t(), a(locali), a(locali)); ; this.h = null)
      {
        paramInputStream.close();
        return;
      }
    }

    private List<Certificate> a(i parami)
      throws IOException
    {
      int i = c.a(parami);
      Object localObject;
      if (i == -1)
        localObject = Collections.emptyList();
      while (true)
      {
        return localObject;
        try
        {
          CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
          localObject = new ArrayList(i);
          for (int j = 0; j < i; j++)
            ((List)localObject).add(localCertificateFactory.generateCertificate(new ByteArrayInputStream(j.b(parami.t()).g())));
        }
        catch (CertificateException localCertificateException)
        {
        }
      }
      throw new IOException(localCertificateException.getMessage());
    }

    private void a(Writer paramWriter, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramWriter.write(Integer.toString(paramList.size()));
        paramWriter.write(10);
        int i = paramList.size();
        for (int j = 0; j < i; j++)
        {
          paramWriter.write(j.a(((Certificate)paramList.get(j)).getEncoded()).b());
          paramWriter.write(10);
        }
      }
      catch (CertificateEncodingException localCertificateEncodingException)
      {
        throw new IOException(localCertificateEncodingException.getMessage());
      }
    }

    private boolean a()
    {
      return this.a.startsWith("https://");
    }

    public aa a(w paramw, b.c paramc)
    {
      String str1 = this.g.a("Content-Type");
      String str2 = this.g.a("Content-Length");
      w localw = new w.a().a(this.a).a(this.f, null).a(this.b).d();
      return new aa.a().a(localw).a(this.d).a(this.e).a(this.f).a(this.g).a(new c.b(paramc, str1, str2)).a(this.h).a();
    }

    public void a(b.a parama)
      throws IOException
    {
      int i = 0;
      BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(parama.c(0), l.d));
      localBufferedWriter.write(this.a);
      localBufferedWriter.write(10);
      localBufferedWriter.write(this.c);
      localBufferedWriter.write(10);
      localBufferedWriter.write(Integer.toString(this.b.a()));
      localBufferedWriter.write(10);
      for (int j = 0; j < this.b.a(); j++)
      {
        localBufferedWriter.write(this.b.a(j));
        localBufferedWriter.write(": ");
        localBufferedWriter.write(this.b.b(j));
        localBufferedWriter.write(10);
      }
      localBufferedWriter.write(new com.squareup.a.a.a.q(this.d, this.e, this.f).toString());
      localBufferedWriter.write(10);
      localBufferedWriter.write(Integer.toString(this.g.a()));
      localBufferedWriter.write(10);
      while (i < this.g.a())
      {
        localBufferedWriter.write(this.g.a(i));
        localBufferedWriter.write(": ");
        localBufferedWriter.write(this.g.b(i));
        localBufferedWriter.write(10);
        i++;
      }
      if (a())
      {
        localBufferedWriter.write(10);
        localBufferedWriter.write(this.h.a());
        localBufferedWriter.write(10);
        a(localBufferedWriter, this.h.b());
        a(localBufferedWriter, this.h.d());
      }
      localBufferedWriter.close();
    }

    public boolean a(w paramw, aa paramaa)
    {
      return (this.a.equals(paramw.c())) && (this.c.equals(paramw.d())) && (k.a(paramaa, this.b, paramw));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.c
 * JD-Core Version:    0.6.0
 */