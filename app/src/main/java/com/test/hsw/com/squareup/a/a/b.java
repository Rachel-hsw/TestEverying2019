package com.squareup.a.a;

import b.e;
import b.h;
import b.q;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b
  implements Closeable
{
  static final String a = "journal";
  static final String b = "journal.tmp";
  static final String c = "journal.bkp";
  static final String d = "libcore.io.DiskLruCache";
  static final String e = "1";
  static final long f = -1L;
  static final Pattern g = Pattern.compile("[a-z0-9_-]{1,64}");
  private static final String i = "CLEAN";
  private static final String j = "DIRTY";
  private static final String k = "REMOVE";
  private static final String l = "READ";
  private static final OutputStream z = new d();
  final ThreadPoolExecutor h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), l.a("OkHttp DiskLruCache", true));
  private final File m;
  private final File n;
  private final File o;
  private final File p;
  private final int q;
  private long r;
  private final int s;
  private long t = 0L;
  private h u;
  private final LinkedHashMap<String, b> v = new LinkedHashMap(0, 0.75F, true);
  private int w;
  private long x = 0L;
  private final Runnable y = new c(this);

  private b(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.m = paramFile;
    this.q = paramInt1;
    this.n = new File(paramFile, "journal");
    this.o = new File(paramFile, "journal.tmp");
    this.p = new File(paramFile, "journal.bkp");
    this.s = paramInt2;
    this.r = paramLong;
  }

  private a a(String paramString, long paramLong)
    throws IOException
  {
    monitorenter;
    while (true)
    {
      b localb1;
      a locala2;
      try
      {
        l();
        e(paramString);
        localb1 = (b)this.v.get(paramString);
        if (paramLong == -1L)
          continue;
        if (localb1 == null)
          continue;
        long l1 = b.e(localb1);
        if (l1 == paramLong)
          continue;
        locala2 = null;
        return locala2;
        if (localb1 == null)
        {
          b localb3 = new b(paramString, null);
          this.v.put(paramString, localb3);
          localb2 = localb3;
          locala2 = new a(localb2, null);
          b.a(localb2, locala2);
          this.u.b("DIRTY").k(32).b(paramString).k(10);
          this.u.b();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      a locala1 = b.a(localb1);
      if (locala1 != null)
      {
        locala2 = null;
        continue;
      }
      b localb2 = localb1;
    }
  }

  public static b a(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    File localFile1 = new File(paramFile, "journal.bkp");
    File localFile2;
    if (localFile1.exists())
    {
      localFile2 = new File(paramFile, "journal");
      if (!localFile2.exists())
        break label137;
      localFile1.delete();
    }
    while (true)
    {
      b localb1 = new b(paramFile, paramInt1, paramInt2, paramLong);
      if (localb1.n.exists())
        try
        {
          localb1.h();
          localb1.i();
          localb1.u = q.a(q.a(new FileOutputStream(localb1.n, true)));
          return localb1;
          label137: a(localFile1, localFile2, false);
        }
        catch (IOException localIOException)
        {
          j.a().a("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
          localb1.f();
        }
    }
    paramFile.mkdirs();
    b localb2 = new b(paramFile, paramInt1, paramInt2, paramLong);
    localb2.j();
    return localb2;
  }

  private void a(a parama, boolean paramBoolean)
    throws IOException
  {
    monitorenter;
    b localb;
    try
    {
      localb = a.a(parama);
      if (b.a(localb) != parama)
        throw new IllegalStateException();
    }
    finally
    {
      monitorexit;
    }
    int i1 = 0;
    if (paramBoolean)
    {
      boolean bool = b.d(localb);
      i1 = 0;
      if (!bool)
        for (int i2 = 0; ; i2++)
        {
          int i3 = this.s;
          i1 = 0;
          if (i2 >= i3)
            break;
          if (a.b(parama)[i2] == 0)
          {
            parama.b();
            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
          }
          if (localb.b(i2).exists())
            continue;
          parama.b();
          monitorexit;
          return;
        }
    }
    while (true)
    {
      if (i1 < this.s)
      {
        File localFile1 = localb.b(i1);
        if (paramBoolean)
        {
          if (localFile1.exists())
          {
            File localFile2 = localb.a(i1);
            localFile1.renameTo(localFile2);
            long l2 = b.b(localb)[i1];
            long l3 = localFile2.length();
            b.b(localb)[i1] = l3;
            this.t = (l3 + (this.t - l2));
          }
        }
        else
          a(localFile1);
      }
      else
      {
        this.w = (1 + this.w);
        b.a(localb, null);
        if ((paramBoolean | b.d(localb)))
        {
          b.a(localb, true);
          this.u.b("CLEAN").k(32);
          this.u.b(b.c(localb));
          this.u.b(localb.a());
          this.u.k(10);
          if (paramBoolean)
          {
            long l1 = this.x;
            this.x = (1L + l1);
            b.a(localb, l1);
          }
        }
        while (true)
        {
          this.u.b();
          if ((this.t <= this.r) && (!k()))
            break;
          this.h.execute(this.y);
          break;
          this.v.remove(b.c(localb));
          this.u.b("REMOVE").k(32);
          this.u.b(b.c(localb));
          this.u.k(10);
        }
      }
      i1++;
    }
  }

  private static void a(File paramFile)
    throws IOException
  {
    if ((!paramFile.delete()) && (paramFile.exists()))
      throw new IOException("failed to delete " + paramFile);
  }

  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
      a(paramFile2);
    if (!paramFile1.renameTo(paramFile2))
      throw new IOException();
  }

  private static String b(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      e locale = new e();
      locale.a(q.a(paramInputStream));
      String str = locale.r();
      return str;
    }
    finally
    {
      l.a(paramInputStream);
    }
    throw localObject;
  }

  private void d(String paramString)
    throws IOException
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1)
      throw new IOException("unexpected journal line: " + paramString);
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    String str2;
    if (i3 == -1)
    {
      str2 = paramString.substring(i2);
      if ((i1 != "REMOVE".length()) || (!paramString.startsWith("REMOVE")))
        break label304;
      this.v.remove(str2);
      return;
    }
    label304: for (String str1 = paramString.substring(i2, i3); ; str1 = str2)
    {
      b localb = (b)this.v.get(str1);
      if (localb == null)
      {
        localb = new b(str1, null);
        this.v.put(str1, localb);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        String[] arrayOfString = paramString.substring(i3 + 1).split(" ");
        b.a(localb, true);
        b.a(localb, null);
        b.a(localb, arrayOfString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        b.a(localb, new a(localb, null));
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ")))
        break;
      throw new IOException("unexpected journal line: " + paramString);
    }
  }

  private void e(String paramString)
  {
    if (!g.matcher(paramString).matches())
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + paramString + "\"");
  }

  // ERROR //
  private void h()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 139	com/squareup/a/a/b:n	Ljava/io/File;
    //   4: invokestatic 417	b/q:a	(Ljava/io/File;)Lb/ab;
    //   7: invokestatic 420	b/q:a	(Lb/ab;)Lb/i;
    //   10: astore_1
    //   11: aload_1
    //   12: invokeinterface 424 1 0
    //   17: astore_3
    //   18: aload_1
    //   19: invokeinterface 424 1 0
    //   24: astore 4
    //   26: aload_1
    //   27: invokeinterface 424 1 0
    //   32: astore 5
    //   34: aload_1
    //   35: invokeinterface 424 1 0
    //   40: astore 6
    //   42: aload_1
    //   43: invokeinterface 424 1 0
    //   48: astore 7
    //   50: ldc 19
    //   52: aload_3
    //   53: invokevirtual 428	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +54 -> 110
    //   59: ldc 22
    //   61: aload 4
    //   63: invokevirtual 428	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifeq +44 -> 110
    //   69: aload_0
    //   70: getfield 132	com/squareup/a/a/b:q	I
    //   73: invokestatic 432	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   76: aload 5
    //   78: invokevirtual 428	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +29 -> 110
    //   84: aload_0
    //   85: getfield 145	com/squareup/a/a/b:s	I
    //   88: invokestatic 432	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   91: aload 6
    //   93: invokevirtual 428	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +14 -> 110
    //   99: ldc_w 434
    //   102: aload 7
    //   104: invokevirtual 428	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +77 -> 184
    //   110: new 156	java/io/IOException
    //   113: dup
    //   114: new 246	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 436
    //   124: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_3
    //   128: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 438
    //   134: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 4
    //   139: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 438
    //   145: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 6
    //   150: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc_w 438
    //   156: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 7
    //   161: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: ldc_w 440
    //   167: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokespecial 344	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   176: athrow
    //   177: astore_2
    //   178: aload_1
    //   179: invokestatic 359	com/squareup/a/a/l:a	(Ljava/io/Closeable;)V
    //   182: aload_2
    //   183: athrow
    //   184: iconst_0
    //   185: istore 8
    //   187: aload_0
    //   188: aload_1
    //   189: invokeinterface 424 1 0
    //   194: invokespecial 442	com/squareup/a/a/b:d	(Ljava/lang/String;)V
    //   197: iinc 8 1
    //   200: goto -13 -> 187
    //   203: astore 9
    //   205: aload_0
    //   206: iload 8
    //   208: aload_0
    //   209: getfield 94	com/squareup/a/a/b:v	Ljava/util/LinkedHashMap;
    //   212: invokevirtual 445	java/util/LinkedHashMap:size	()I
    //   215: isub
    //   216: putfield 150	com/squareup/a/a/b:w	I
    //   219: aload_1
    //   220: invokestatic 359	com/squareup/a/a/l:a	(Ljava/io/Closeable;)V
    //   223: return
    //
    // Exception table:
    //   from	to	target	type
    //   11	110	177	finally
    //   110	177	177	finally
    //   187	197	177	finally
    //   205	219	177	finally
    //   187	197	203	java/io/EOFException
  }

  private void i()
    throws IOException
  {
    a(this.o);
    Iterator localIterator = this.v.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (b.a(localb) == null)
      {
        for (int i2 = 0; i2 < this.s; i2++)
          this.t += b.b(localb)[i2];
        continue;
      }
      b.a(localb, null);
      for (int i1 = 0; i1 < this.s; i1++)
      {
        a(localb.a(i1));
        a(localb.b(i1));
      }
      localIterator.remove();
    }
  }

  private void j()
    throws IOException
  {
    monitorenter;
    h localh;
    while (true)
    {
      b localb;
      try
      {
        if (this.u == null)
          continue;
        this.u.close();
        localh = q.a(q.a(new FileOutputStream(this.o)));
        try
        {
          localh.b("libcore.io.DiskLruCache").k(10);
          localh.b("1").k(10);
          localh.b(Integer.toString(this.q)).k(10);
          localh.b(Integer.toString(this.s)).k(10);
          localh.k(10);
          Iterator localIterator = this.v.values().iterator();
          if (!localIterator.hasNext())
            break;
          localb = (b)localIterator.next();
          if (b.a(localb) != null)
          {
            localh.b("DIRTY").k(32);
            localh.b(b.c(localb));
            localh.k(10);
            continue;
          }
        }
        finally
        {
          localh.close();
        }
      }
      finally
      {
        monitorexit;
      }
      localh.b("CLEAN").k(32);
      localh.b(b.c(localb));
      localh.b(localb.a());
      localh.k(10);
    }
    localh.close();
    if (this.n.exists())
      a(this.n, this.p, true);
    a(this.o, this.n, false);
    this.p.delete();
    this.u = q.a(q.a(new FileOutputStream(this.n, true)));
    monitorexit;
  }

  private boolean k()
  {
    return (this.w >= 2000) && (this.w >= this.v.size());
  }

  private void l()
  {
    if (this.u == null)
      throw new IllegalStateException("cache is closed");
  }

  private void m()
    throws IOException
  {
    while (this.t > this.r)
      c((String)((Map.Entry)this.v.entrySet().iterator().next()).getKey());
  }

  public c a(String paramString)
    throws IOException
  {
    monitorenter;
    try
    {
      l();
      e(paramString);
      b localb = (b)this.v.get(paramString);
      c localc = null;
      if (localb == null);
      while (true)
      {
        return localc;
        boolean bool = b.d(localb);
        localc = null;
        if (!bool)
          continue;
        InputStream[] arrayOfInputStream = new InputStream[this.s];
        int i1 = 0;
        while (true)
        {
          int i2;
          int i3;
          try
          {
            if (i1 >= this.s)
              break label144;
            arrayOfInputStream[i1] = new FileInputStream(localb.a(i1));
            i1++;
            continue;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            i2 = 0;
            i3 = this.s;
            localc = null;
          }
          if (i2 >= i3)
            break;
          InputStream localInputStream = arrayOfInputStream[i2];
          localc = null;
          if (localInputStream == null)
            break;
          l.a(arrayOfInputStream[i2]);
          i2++;
        }
        label144: this.w = (1 + this.w);
        this.u.b("READ").k(32).b(paramString).k(10);
        if (k())
          this.h.execute(this.y);
        localc = new c(paramString, b.e(localb), arrayOfInputStream, b.b(localb), null);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public File a()
  {
    return this.m;
  }

  public void a(long paramLong)
  {
    monitorenter;
    try
    {
      this.r = paramLong;
      this.h.execute(this.y);
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

  public long b()
  {
    monitorenter;
    try
    {
      long l1 = this.r;
      monitorexit;
      return l1;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public a b(String paramString)
    throws IOException
  {
    return a(paramString, -1L);
  }

  public long c()
  {
    monitorenter;
    try
    {
      long l1 = this.t;
      monitorexit;
      return l1;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public boolean c(String paramString)
    throws IOException
  {
    monitorenter;
    try
    {
      l();
      e(paramString);
      b localb = (b)this.v.get(paramString);
      int i1;
      if (localb != null)
      {
        a locala = b.a(localb);
        i1 = 0;
        if (locala == null)
          break label49;
      }
      for (int i2 = 0; ; i2 = 1)
      {
        return i2;
        label49: 
        while (i1 < this.s)
        {
          a(localb.a(i1));
          this.t -= b.b(localb)[i1];
          b.b(localb)[i1] = 0L;
          i1++;
        }
        this.w = (1 + this.w);
        this.u.b("REMOVE").k(32).b(paramString).k(10);
        this.v.remove(paramString);
        if (!k())
          continue;
        this.h.execute(this.y);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void close()
    throws IOException
  {
    monitorenter;
    while (true)
    {
      int i2;
      try
      {
        h localh = this.u;
        if (localh == null)
          return;
        Object[] arrayOfObject = this.v.values().toArray();
        int i1 = arrayOfObject.length;
        i2 = 0;
        if (i2 >= i1)
          continue;
        b localb = (b)arrayOfObject[i2];
        if (b.a(localb) != null)
        {
          b.a(localb).b();
          break label95;
          m();
          this.u.close();
          this.u = null;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      label95: i2++;
    }
  }

  public boolean d()
  {
    return this.u == null;
  }

  public void e()
    throws IOException
  {
    monitorenter;
    try
    {
      l();
      m();
      this.u.b();
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

  public void f()
    throws IOException
  {
    close();
    l.a(this.m);
  }

  public final class a
  {
    private final b.b b;
    private final boolean[] c;
    private boolean d;
    private boolean e;

    private a(b.b arg2)
    {
      b.b localb;
      this.b = localb;
      if (b.b.d(localb));
      for (boolean[] arrayOfBoolean = null; ; arrayOfBoolean = new boolean[b.e(b.this)])
      {
        this.c = arrayOfBoolean;
        return;
      }
    }

    public InputStream a(int paramInt)
      throws IOException
    {
      synchronized (b.this)
      {
        if (b.b.a(this.b) != this)
          throw new IllegalStateException();
      }
      if (!b.b.d(this.b))
      {
        monitorexit;
        return null;
      }
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(this.b.a(paramInt));
        monitorexit;
        return localFileInputStream;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        monitorexit;
      }
      return null;
    }

    public void a()
      throws IOException
    {
      if (this.d)
      {
        b.a(b.this, this, false);
        b.this.c(b.b.c(this.b));
      }
      while (true)
      {
        this.e = true;
        return;
        b.a(b.this, this, true);
      }
    }

    public void a(int paramInt, String paramString)
      throws IOException
    {
      h localh = q.a(q.a(c(paramInt)));
      localh.b(paramString);
      localh.close();
    }

    public String b(int paramInt)
      throws IOException
    {
      InputStream localInputStream = a(paramInt);
      if (localInputStream != null)
        return b.a(localInputStream);
      return null;
    }

    public void b()
      throws IOException
    {
      b.a(b.this, this, false);
    }

    public OutputStream c(int paramInt)
      throws IOException
    {
      synchronized (b.this)
      {
        if (b.b.a(this.b) != this)
          throw new IllegalStateException();
      }
      if (!b.b.d(this.b))
        this.c[paramInt] = true;
      File localFile = this.b.b(paramInt);
      OutputStream localOutputStream;
      try
      {
        FileOutputStream localFileOutputStream1 = new FileOutputStream(localFile);
        localObject2 = localFileOutputStream1;
        a locala = new a((OutputStream)localObject2, null);
        monitorexit;
        return locala;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        while (true)
        {
          Object localObject2;
          b.f(b.this).mkdirs();
          try
          {
            FileOutputStream localFileOutputStream2 = new FileOutputStream(localFile);
            localObject2 = localFileOutputStream2;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            localOutputStream = b.g();
            monitorexit;
          }
        }
      }
      return (OutputStream)localOutputStream;
    }

    public void c()
    {
      if (!this.e);
      try
      {
        b();
        return;
      }
      catch (IOException localIOException)
      {
      }
    }

    private class a extends FilterOutputStream
    {
      private a(OutputStream arg2)
      {
        super();
      }

      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }

      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }

      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }

      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException localIOException)
        {
          b.a.a(b.a.this, true);
        }
      }
    }
  }

  private final class b
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private b.a e;
    private long f;

    private b(String arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = new long[b.e(b.this)];
    }

    private void a(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != b.e(b.this))
        throw b(paramArrayOfString);
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.c[i] = Long.parseLong(paramArrayOfString[i]);
          i++;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw b(paramArrayOfString);
      }
    }

    private IOException b(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }

    public File a(int paramInt)
    {
      return new File(b.f(b.this), this.b + "." + paramInt);
    }

    public String a()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (long l : this.c)
        localStringBuilder.append(' ').append(l);
      return localStringBuilder.toString();
    }

    public File b(int paramInt)
    {
      return new File(b.f(b.this), this.b + "." + paramInt + ".tmp");
    }
  }

  public final class c
    implements Closeable
  {
    private final String b;
    private final long c;
    private final InputStream[] d;
    private final long[] e;

    private c(String paramLong, long arg3, InputStream[] paramArrayOfLong, long[] arg6)
    {
      this.b = paramLong;
      this.c = ???;
      this.d = paramArrayOfLong;
      Object localObject;
      this.e = localObject;
    }

    public b.a a()
      throws IOException
    {
      return b.a(b.this, this.b, this.c);
    }

    public InputStream a(int paramInt)
    {
      return this.d[paramInt];
    }

    public String b(int paramInt)
      throws IOException
    {
      return b.a(a(paramInt));
    }

    public long c(int paramInt)
    {
      return this.e[paramInt];
    }

    public void close()
    {
      InputStream[] arrayOfInputStream = this.d;
      int i = arrayOfInputStream.length;
      for (int j = 0; j < i; j++)
        l.a(arrayOfInputStream[j]);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.b
 * JD-Core Version:    0.6.0
 */