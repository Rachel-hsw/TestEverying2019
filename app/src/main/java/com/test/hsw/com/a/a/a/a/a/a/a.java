package com.a.a.a.a.a.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a
  implements Closeable
{
  private static final OutputStream B;
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
  private final Callable<Void> A = new b(this);
  final ThreadPoolExecutor h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File m;
  private final File n;
  private final File o;
  private final File p;
  private final int q;
  private long r;
  private int s;
  private final int t;
  private long u = 0L;
  private int v = 0;
  private Writer w;
  private final LinkedHashMap<String, b> x = new LinkedHashMap(0, 0.75F, true);
  private int y;
  private long z = 0L;

  static
  {
    B = new c();
  }

  private a(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    this.m = paramFile;
    this.q = paramInt1;
    this.n = new File(paramFile, "journal");
    this.o = new File(paramFile, "journal.tmp");
    this.p = new File(paramFile, "journal.bkp");
    this.t = paramInt2;
    this.r = paramLong;
    this.s = paramInt3;
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
        n();
        e(paramString);
        localb1 = (b)this.x.get(paramString);
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
          this.x.put(paramString, localb3);
          localb2 = localb3;
          locala2 = new a(localb2, null);
          b.a(localb2, locala2);
          this.w.write("DIRTY " + paramString + '\n');
          this.w.flush();
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

  public static a a(File paramFile, int paramInt1, int paramInt2, long paramLong, int paramInt3)
    throws IOException
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt3 <= 0)
      throw new IllegalArgumentException("maxFileCount <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    File localFile1 = new File(paramFile, "journal.bkp");
    File localFile2;
    if (localFile1.exists())
    {
      localFile2 = new File(paramFile, "journal");
      if (!localFile2.exists())
        break label165;
      localFile1.delete();
    }
    while (true)
    {
      a locala1 = new a(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
      if (locala1.n.exists())
        try
        {
          locala1.j();
          locala1.k();
          locala1.w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(locala1.n, true), g.a));
          return locala1;
          label165: a(localFile1, localFile2, false);
        }
        catch (IOException localIOException)
        {
          System.out.println("DiskLruCache " + paramFile + " is corrupt: " + localIOException.getMessage() + ", removing");
          locala1.h();
        }
    }
    paramFile.mkdirs();
    a locala2 = new a(paramFile, paramInt1, paramInt2, paramLong, paramInt3);
    locala2.l();
    return locala2;
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
          int i3 = this.t;
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
      if (i1 < this.t)
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
            this.u = (l3 + (this.u - l2));
            this.v = (1 + this.v);
          }
        }
        else
          a(localFile1);
      }
      else
      {
        this.y = (1 + this.y);
        b.a(localb, null);
        if ((paramBoolean | b.d(localb)))
        {
          b.a(localb, true);
          this.w.write("CLEAN " + b.c(localb) + localb.a() + '\n');
          if (paramBoolean)
          {
            long l1 = this.z;
            this.z = (1L + l1);
            b.a(localb, l1);
          }
        }
        while (true)
        {
          this.w.flush();
          if ((this.u <= this.r) && (this.v <= this.s) && (!m()))
            break;
          this.h.submit(this.A);
          break;
          this.x.remove(b.c(localb));
          this.w.write("REMOVE " + b.c(localb) + '\n');
        }
      }
      i1++;
    }
  }

  private static void a(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!paramFile.delete()))
      throw new IOException();
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
    return g.a(new InputStreamReader(paramInputStream, g.b));
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
      this.x.remove(str2);
      return;
    }
    label304: for (String str1 = paramString.substring(i2, i3); ; str1 = str2)
    {
      b localb = (b)this.x.get(str1);
      if (localb == null)
      {
        localb = new b(str1, null);
        this.x.put(str1, localb);
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
  private void j()
    throws IOException
  {
    // Byte code:
    //   0: new 433	com/a/a/a/a/a/a/e
    //   3: dup
    //   4: new 435	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 137	com/a/a/a/a/a/a/a:n	Ljava/io/File;
    //   12: invokespecial 437	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: getstatic 252	com/a/a/a/a/a/a/g:a	Ljava/nio/charset/Charset;
    //   18: invokespecial 438	com/a/a/a/a/a/a/e:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 439	com/a/a/a/a/a/a/e:a	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_1
    //   28: invokevirtual 439	com/a/a/a/a/a/a/e:a	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_1
    //   34: invokevirtual 439	com/a/a/a/a/a/a/e:a	()Ljava/lang/String;
    //   37: astore 5
    //   39: aload_1
    //   40: invokevirtual 439	com/a/a/a/a/a/a/e:a	()Ljava/lang/String;
    //   43: astore 6
    //   45: aload_1
    //   46: invokevirtual 439	com/a/a/a/a/a/a/e:a	()Ljava/lang/String;
    //   49: astore 7
    //   51: ldc 21
    //   53: aload_3
    //   54: invokevirtual 443	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc 24
    //   62: aload 4
    //   64: invokevirtual 443	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +44 -> 111
    //   70: aload_0
    //   71: getfield 130	com/a/a/a/a/a/a/a:q	I
    //   74: invokestatic 447	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: aload 5
    //   79: invokevirtual 443	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +29 -> 111
    //   85: aload_0
    //   86: getfield 143	com/a/a/a/a/a/a/a:t	I
    //   89: invokestatic 447	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   92: aload 6
    //   94: invokevirtual 443	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +14 -> 111
    //   100: ldc_w 449
    //   103: aload 7
    //   105: invokevirtual 443	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +77 -> 185
    //   111: new 153	java/io/IOException
    //   114: dup
    //   115: new 189	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 451
    //   125: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_3
    //   129: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 453
    //   135: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 4
    //   140: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 453
    //   146: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 6
    //   151: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 453
    //   157: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 7
    //   162: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 455
    //   168: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 386	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   177: athrow
    //   178: astore_2
    //   179: aload_1
    //   180: invokestatic 458	com/a/a/a/a/a/a/g:a	(Ljava/io/Closeable;)V
    //   183: aload_2
    //   184: athrow
    //   185: iconst_0
    //   186: istore 8
    //   188: aload_0
    //   189: aload_1
    //   190: invokevirtual 439	com/a/a/a/a/a/a/e:a	()Ljava/lang/String;
    //   193: invokespecial 460	com/a/a/a/a/a/a/a:d	(Ljava/lang/String;)V
    //   196: iinc 8 1
    //   199: goto -11 -> 188
    //   202: astore 9
    //   204: aload_0
    //   205: iload 8
    //   207: aload_0
    //   208: getfield 99	com/a/a/a/a/a/a/a:x	Ljava/util/LinkedHashMap;
    //   211: invokevirtual 463	java/util/LinkedHashMap:size	()I
    //   214: isub
    //   215: putfield 150	com/a/a/a/a/a/a/a:y	I
    //   218: aload_1
    //   219: invokestatic 458	com/a/a/a/a/a/a/g:a	(Ljava/io/Closeable;)V
    //   222: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	111	178	finally
    //   111	178	178	finally
    //   188	196	178	finally
    //   204	218	178	finally
    //   188	196	202	java/io/EOFException
  }

  private void k()
    throws IOException
  {
    a(this.o);
    Iterator localIterator = this.x.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (b.a(localb) == null)
      {
        for (int i2 = 0; i2 < this.t; i2++)
        {
          this.u += b.b(localb)[i2];
          this.v = (1 + this.v);
        }
        continue;
      }
      b.a(localb, null);
      for (int i1 = 0; i1 < this.t; i1++)
      {
        a(localb.a(i1));
        a(localb.b(i1));
      }
      localIterator.remove();
    }
  }

  private void l()
    throws IOException
  {
    monitorenter;
    BufferedWriter localBufferedWriter;
    while (true)
    {
      b localb;
      try
      {
        if (this.w == null)
          continue;
        this.w.close();
        localBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.o), g.a));
        try
        {
          localBufferedWriter.write("libcore.io.DiskLruCache");
          localBufferedWriter.write("\n");
          localBufferedWriter.write("1");
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.q));
          localBufferedWriter.write("\n");
          localBufferedWriter.write(Integer.toString(this.t));
          localBufferedWriter.write("\n");
          localBufferedWriter.write("\n");
          Iterator localIterator = this.x.values().iterator();
          if (!localIterator.hasNext())
            break;
          localb = (b)localIterator.next();
          if (b.a(localb) != null)
          {
            localBufferedWriter.write("DIRTY " + b.c(localb) + '\n');
            continue;
          }
        }
        finally
        {
          localBufferedWriter.close();
        }
      }
      finally
      {
        monitorexit;
      }
      localBufferedWriter.write("CLEAN " + b.c(localb) + localb.a() + '\n');
    }
    localBufferedWriter.close();
    if (this.n.exists())
      a(this.n, this.p, true);
    a(this.o, this.n, false);
    this.p.delete();
    this.w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.n, true), g.a));
    monitorexit;
  }

  private boolean m()
  {
    return (this.y >= 2000) && (this.y >= this.x.size());
  }

  private void n()
  {
    if (this.w == null)
      throw new IllegalStateException("cache is closed");
  }

  private void o()
    throws IOException
  {
    while (this.u > this.r)
      c((String)((Map.Entry)this.x.entrySet().iterator().next()).getKey());
  }

  private void p()
    throws IOException
  {
    while (this.v > this.s)
      c((String)((Map.Entry)this.x.entrySet().iterator().next()).getKey());
  }

  public c a(String paramString)
    throws IOException
  {
    monitorenter;
    try
    {
      n();
      e(paramString);
      b localb = (b)this.x.get(paramString);
      c localc = null;
      if (localb == null);
      while (true)
      {
        return localc;
        boolean bool = b.d(localb);
        localc = null;
        if (!bool)
          continue;
        File[] arrayOfFile = new File[this.t];
        InputStream[] arrayOfInputStream = new InputStream[this.t];
        int i1 = 0;
        while (true)
        {
          int i2;
          int i3;
          try
          {
            if (i1 >= this.t)
              break label164;
            File localFile = localb.a(i1);
            arrayOfFile[i1] = localFile;
            arrayOfInputStream[i1] = new FileInputStream(localFile);
            i1++;
            continue;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            i2 = 0;
            i3 = this.t;
            localc = null;
          }
          if (i2 >= i3)
            break;
          InputStream localInputStream = arrayOfInputStream[i2];
          localc = null;
          if (localInputStream == null)
            break;
          g.a(arrayOfInputStream[i2]);
          i2++;
        }
        label164: this.y = (1 + this.y);
        this.w.append("READ " + paramString + '\n');
        if (m())
          this.h.submit(this.A);
        localc = new c(paramString, b.e(localb), arrayOfFile, arrayOfInputStream, b.b(localb), null);
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
      this.h.submit(this.A);
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

  public int c()
  {
    monitorenter;
    try
    {
      int i1 = this.s;
      monitorexit;
      return i1;
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
    while (true)
    {
      try
      {
        n();
        e(paramString);
        b localb = (b)this.x.get(paramString);
        if (localb == null)
          continue;
        a locala = b.a(localb);
        int i1 = 0;
        if (locala == null)
          continue;
        i2 = 0;
        return i2;
        this.u -= b.b(localb)[i1];
        this.v = (-1 + this.v);
        b.b(localb)[i1] = 0L;
        i1++;
        if (i1 < this.t)
        {
          File localFile = localb.a(i1);
          if ((!localFile.exists()) || (localFile.delete()))
            continue;
          throw new IOException("failed to delete " + localFile);
        }
      }
      finally
      {
        monitorexit;
      }
      this.y = (1 + this.y);
      this.w.append("REMOVE " + paramString + '\n');
      this.x.remove(paramString);
      if (m())
        this.h.submit(this.A);
      int i2 = 1;
    }
  }

  public void close()
    throws IOException
  {
    monitorenter;
    while (true)
    {
      try
      {
        Writer localWriter = this.w;
        if (localWriter == null)
          return;
        Iterator localIterator = new ArrayList(this.x.values()).iterator();
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (b.a(localb) == null)
            continue;
          b.a(localb).b();
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      o();
      p();
      this.w.close();
      this.w = null;
    }
  }

  public long d()
  {
    monitorenter;
    try
    {
      long l1 = this.u;
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

  public long e()
  {
    monitorenter;
    try
    {
      int i1 = this.v;
      long l1 = i1;
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

  public boolean f()
  {
    monitorenter;
    try
    {
      Writer localWriter = this.w;
      if (localWriter == null)
      {
        i1 = 1;
        return i1;
      }
      int i1 = 0;
    }
    finally
    {
      monitorexit;
    }
  }

  public void g()
    throws IOException
  {
    monitorenter;
    try
    {
      n();
      o();
      p();
      this.w.flush();
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

  public void h()
    throws IOException
  {
    close();
    g.a(this.m);
  }

  public final class a
  {
    private final a.b b;
    private final boolean[] c;
    private boolean d;
    private boolean e;

    private a(a.b arg2)
    {
      a.b localb;
      this.b = localb;
      if (a.b.d(localb));
      for (boolean[] arrayOfBoolean = null; ; arrayOfBoolean = new boolean[a.f(a.this)])
      {
        this.c = arrayOfBoolean;
        return;
      }
    }

    public InputStream a(int paramInt)
      throws IOException
    {
      synchronized (a.this)
      {
        if (a.b.a(this.b) != this)
          throw new IllegalStateException();
      }
      if (!a.b.d(this.b))
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
        a.a(a.this, this, false);
        a.this.c(a.b.c(this.b));
      }
      while (true)
      {
        this.e = true;
        return;
        a.a(a.this, this, true);
      }
    }

    // ERROR //
    public void a(int paramInt, String paramString)
      throws IOException
    {
      // Byte code:
      //   0: new 76	java/io/OutputStreamWriter
      //   3: dup
      //   4: aload_0
      //   5: iload_1
      //   6: invokevirtual 79	com/a/a/a/a/a/a/a$a:c	(I)Ljava/io/OutputStream;
      //   9: getstatic 84	com/a/a/a/a/a/a/g:b	Ljava/nio/charset/Charset;
      //   12: invokespecial 87	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
      //   15: astore_3
      //   16: aload_3
      //   17: aload_2
      //   18: invokevirtual 93	java/io/Writer:write	(Ljava/lang/String;)V
      //   21: aload_3
      //   22: invokestatic 96	com/a/a/a/a/a/a/g:a	(Ljava/io/Closeable;)V
      //   25: return
      //   26: astore 4
      //   28: aconst_null
      //   29: astore_3
      //   30: aload_3
      //   31: invokestatic 96	com/a/a/a/a/a/a/g:a	(Ljava/io/Closeable;)V
      //   34: aload 4
      //   36: athrow
      //   37: astore 4
      //   39: goto -9 -> 30
      //
      // Exception table:
      //   from	to	target	type
      //   0	16	26	finally
      //   16	21	37	finally
    }

    public String b(int paramInt)
      throws IOException
    {
      InputStream localInputStream = a(paramInt);
      if (localInputStream != null)
        return a.a(localInputStream);
      return null;
    }

    public void b()
      throws IOException
    {
      a.a(a.this, this, false);
    }

    public OutputStream c(int paramInt)
      throws IOException
    {
      synchronized (a.this)
      {
        if (a.b.a(this.b) != this)
          throw new IllegalStateException();
      }
      if (!a.b.d(this.b))
        this.c[paramInt] = true;
      File localFile = this.b.b(paramInt);
      OutputStream localOutputStream;
      try
      {
        FileOutputStream localFileOutputStream1 = new FileOutputStream(localFile);
        localObject2 = localFileOutputStream1;
        a locala1 = new a((OutputStream)localObject2, null);
        monitorexit;
        return locala1;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        while (true)
        {
          Object localObject2;
          a.g(a.this).mkdirs();
          try
          {
            FileOutputStream localFileOutputStream2 = new FileOutputStream(localFile);
            localObject2 = localFileOutputStream2;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            localOutputStream = a.i();
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
          a.a.a(a.a.this, true);
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
          a.a.a(a.a.this, true);
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
          a.a.a(a.a.this, true);
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
          a.a.a(a.a.this, true);
        }
      }
    }
  }

  private final class b
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private a.a e;
    private long f;

    private b(String arg2)
    {
      Object localObject;
      this.b = localObject;
      this.c = new long[a.f(a.this)];
    }

    private void a(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != a.f(a.this))
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
      return new File(a.g(a.this), this.b + "." + paramInt);
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
      return new File(a.g(a.this), this.b + "." + paramInt + ".tmp");
    }
  }

  public final class c
    implements Closeable
  {
    private final String b;
    private final long c;
    private File[] d;
    private final InputStream[] e;
    private final long[] f;

    private c(String paramLong, long arg3, File[] paramArrayOfInputStream, InputStream[] paramArrayOfLong, long[] arg7)
    {
      this.b = paramLong;
      this.c = ???;
      this.d = paramArrayOfInputStream;
      this.e = paramArrayOfLong;
      Object localObject;
      this.f = localObject;
    }

    public a.a a()
      throws IOException
    {
      return a.a(a.this, this.b, this.c);
    }

    public File a(int paramInt)
    {
      return this.d[paramInt];
    }

    public InputStream b(int paramInt)
    {
      return this.e[paramInt];
    }

    public String c(int paramInt)
      throws IOException
    {
      return a.a(b(paramInt));
    }

    public void close()
    {
      InputStream[] arrayOfInputStream = this.e;
      int i = arrayOfInputStream.length;
      for (int j = 0; j < i; j++)
        g.a(arrayOfInputStream[j]);
    }

    public long d(int paramInt)
    {
      return this.f[paramInt];
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.a.a.a.a
 * JD-Core Version:    0.6.0
 */