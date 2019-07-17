package com.a.a.b;

import android.graphics.Bitmap;
import android.os.Handler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class i
  implements com.a.a.c.c.a, Runnable
{
  private static final String f = "ImageLoader is paused. Waiting...  [%s]";
  private static final String g = ".. Resume loading [%s]";
  private static final String h = "Delay %d ms before loading...  [%s]";
  private static final String i = "Start display image task [%s]";
  private static final String j = "Image already is loading. Waiting... [%s]";
  private static final String k = "...Get cached bitmap from memory after waiting. [%s]";
  private static final String l = "Load image from network [%s]";
  private static final String m = "Load image from disk cache [%s]";
  private static final String n = "Resize image in disk cache [%s]";
  private static final String o = "PreProcess image before caching in memory [%s]";
  private static final String p = "PostProcess image before displaying [%s]";
  private static final String q = "Cache image in memory [%s]";
  private static final String r = "Cache image on disk [%s]";
  private static final String s = "Process image before cache on disk [%s]";
  private static final String t = "ImageAware is reused for another image. Task is cancelled. [%s]";
  private static final String u = "ImageAware was collected by GC. Task is cancelled. [%s]";
  private static final String v = "Task was interrupted [%s]";
  private static final String w = "Pre-processor returned null [%s]";
  private static final String x = "Post-processor returned null [%s]";
  private static final String y = "Bitmap processor for disk cache returned null [%s]";
  private final h A;
  private final Handler B;
  private final e C;
  private final com.a.a.b.d.b D;
  private final com.a.a.b.d.b E;
  private final com.a.a.b.d.b F;
  private final com.a.a.b.b.b G;
  private final String H;
  private final com.a.a.b.a.e I;
  private final boolean J;
  private com.a.a.b.a.f K = com.a.a.b.a.f.a;
  final String a;
  final com.a.a.b.e.a b;
  final c c;
  final com.a.a.b.f.a d;
  final com.a.a.b.f.b e;
  private final f z;

  public i(f paramf, h paramh, Handler paramHandler)
  {
    this.z = paramf;
    this.A = paramh;
    this.B = paramHandler;
    this.C = paramf.a;
    this.D = this.C.p;
    this.E = this.C.s;
    this.F = this.C.t;
    this.G = this.C.q;
    this.a = paramh.a;
    this.H = paramh.b;
    this.b = paramh.c;
    this.I = paramh.d;
    this.c = paramh.e;
    this.d = paramh.f;
    this.e = paramh.g;
    this.J = this.c.s();
  }

  private Bitmap a(String paramString)
    throws IOException
  {
    com.a.a.b.a.h localh = this.b.c();
    com.a.a.b.b.c localc = new com.a.a.b.b.c(this.H, paramString, this.a, this.I, localh, h(), this.c);
    return this.G.a(localc);
  }

  private void a(com.a.a.b.a.b.a parama, Throwable paramThrowable)
  {
    if ((this.J) || (p()) || (j()))
      return;
    a(new k(this, parama, paramThrowable), false, this.B, this.z);
  }

  static void a(Runnable paramRunnable, boolean paramBoolean, Handler paramHandler, f paramf)
  {
    if (paramBoolean)
    {
      paramRunnable.run();
      return;
    }
    if (paramHandler == null)
    {
      paramf.a(paramRunnable);
      return;
    }
    paramHandler.post(paramRunnable);
  }

  private boolean b()
  {
    AtomicBoolean localAtomicBoolean = this.z.d();
    if (localAtomicBoolean.get());
    synchronized (this.z.e())
    {
      if (localAtomicBoolean.get())
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = this.H;
        com.a.a.c.d.a("ImageLoader is paused. Waiting...  [%s]", arrayOfObject1);
      }
      try
      {
        this.z.e().wait();
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = this.H;
        com.a.a.c.d.a(".. Resume loading [%s]", arrayOfObject3);
        return j();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.H;
        com.a.a.c.d.d("Task was interrupted [%s]", arrayOfObject2);
        return true;
      }
    }
  }

  private boolean b(int paramInt1, int paramInt2)
    throws IOException
  {
    File localFile = this.C.o.a(this.a);
    if ((localFile != null) && (localFile.exists()))
    {
      com.a.a.b.a.e locale = new com.a.a.b.a.e(paramInt1, paramInt2);
      c localc = new c.a().a(this.c).a(com.a.a.b.a.d.d).d();
      com.a.a.b.b.c localc1 = new com.a.a.b.b.c(this.H, com.a.a.b.d.b.a.c.b(localFile.getAbsolutePath()), this.a, locale, com.a.a.b.a.h.a, h(), localc);
      Bitmap localBitmap1 = this.G.a(localc1);
      if ((localBitmap1 != null) && (this.C.f != null))
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = this.H;
        com.a.a.c.d.a("Process image before cache on disk [%s]", arrayOfObject1);
        localBitmap1 = this.C.f.a(localBitmap1);
        if (localBitmap1 == null)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.H;
          com.a.a.c.d.d("Bitmap processor for disk cache returned null [%s]", arrayOfObject2);
        }
      }
      Bitmap localBitmap2 = localBitmap1;
      if (localBitmap2 != null)
      {
        boolean bool = this.C.o.a(this.a, localBitmap2);
        localBitmap2.recycle();
        return bool;
      }
    }
    return false;
  }

  private boolean c()
  {
    if (this.c.f())
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.c.l());
      arrayOfObject1[1] = this.H;
      com.a.a.c.d.a("Delay %d ms before loading...  [%s]", arrayOfObject1);
      try
      {
        Thread.sleep(this.c.l());
        return j();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.H;
        com.a.a.c.d.d("Task was interrupted [%s]", arrayOfObject2);
        return true;
      }
    }
    return false;
  }

  private boolean c(int paramInt1, int paramInt2)
  {
    if ((p()) || (j()))
      return false;
    if (this.e != null)
      a(new j(this, paramInt1, paramInt2), false, this.B, this.z);
    return true;
  }

  // ERROR //
  private Bitmap d()
    throws i.a
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 122	com/a/a/b/i:C	Lcom/a/a/b/e;
    //   4: getfield 250	com/a/a/b/e:o	Lcom/a/a/a/a/b;
    //   7: aload_0
    //   8: getfield 145	com/a/a/b/i:a	Ljava/lang/String;
    //   11: invokeinterface 255 2 0
    //   16: astore 10
    //   18: aload 10
    //   20: ifnull +312 -> 332
    //   23: aload 10
    //   25: invokevirtual 260	java/io/File:exists	()Z
    //   28: ifeq +304 -> 332
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: astore 15
    //   37: aload 15
    //   39: iconst_0
    //   40: aload_0
    //   41: getfield 149	com/a/a/b/i:H	Ljava/lang/String;
    //   44: aastore
    //   45: ldc 33
    //   47: aload 15
    //   49: invokestatic 241	com/a/a/c/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_0
    //   53: getstatic 348	com/a/a/b/a/f:b	Lcom/a/a/b/a/f;
    //   56: putfield 110	com/a/a/b/i:K	Lcom/a/a/b/a/f;
    //   59: aload_0
    //   60: invokespecial 350	com/a/a/b/i:i	()V
    //   63: aload_0
    //   64: getstatic 287	com/a/a/b/d/b$a:c	Lcom/a/a/b/d/b$a;
    //   67: aload 10
    //   69: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 294	com/a/a/b/d/b$a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokespecial 352	com/a/a/b/i:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   78: astore 16
    //   80: aload 16
    //   82: astore_2
    //   83: aload_2
    //   84: ifnull +17 -> 101
    //   87: aload_2
    //   88: invokevirtual 355	android/graphics/Bitmap:getWidth	()I
    //   91: ifle +10 -> 101
    //   94: aload_2
    //   95: invokevirtual 358	android/graphics/Bitmap:getHeight	()I
    //   98: ifgt +127 -> 225
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: astore 12
    //   107: aload 12
    //   109: iconst_0
    //   110: aload_0
    //   111: getfield 149	com/a/a/b/i:H	Ljava/lang/String;
    //   114: aastore
    //   115: ldc 30
    //   117: aload 12
    //   119: invokestatic 241	com/a/a/c/d:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_0
    //   123: getstatic 108	com/a/a/b/a/f:a	Lcom/a/a/b/a/f;
    //   126: putfield 110	com/a/a/b/i:K	Lcom/a/a/b/a/f;
    //   129: aload_0
    //   130: getfield 145	com/a/a/b/i:a	Ljava/lang/String;
    //   133: astore 13
    //   135: aload_0
    //   136: getfield 161	com/a/a/b/i:c	Lcom/a/a/b/c;
    //   139: invokevirtual 360	com/a/a/b/c:i	()Z
    //   142: ifeq +46 -> 188
    //   145: aload_0
    //   146: invokespecial 362	com/a/a/b/i:e	()Z
    //   149: ifeq +39 -> 188
    //   152: aload_0
    //   153: getfield 122	com/a/a/b/i:C	Lcom/a/a/b/e;
    //   156: getfield 250	com/a/a/b/e:o	Lcom/a/a/a/a/b;
    //   159: aload_0
    //   160: getfield 145	com/a/a/b/i:a	Ljava/lang/String;
    //   163: invokeinterface 255 2 0
    //   168: astore 14
    //   170: aload 14
    //   172: ifnull +16 -> 188
    //   175: getstatic 287	com/a/a/b/d/b$a:c	Lcom/a/a/b/d/b$a;
    //   178: aload 14
    //   180: invokevirtual 291	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   183: invokevirtual 294	com/a/a/b/d/b$a:b	(Ljava/lang/String;)Ljava/lang/String;
    //   186: astore 13
    //   188: aload_0
    //   189: invokespecial 350	com/a/a/b/i:i	()V
    //   192: aload_0
    //   193: aload 13
    //   195: invokespecial 352	com/a/a/b/i:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   198: astore_2
    //   199: aload_2
    //   200: ifnull +17 -> 217
    //   203: aload_2
    //   204: invokevirtual 355	android/graphics/Bitmap:getWidth	()I
    //   207: ifle +10 -> 217
    //   210: aload_2
    //   211: invokevirtual 358	android/graphics/Bitmap:getHeight	()I
    //   214: ifgt +11 -> 225
    //   217: aload_0
    //   218: getstatic 367	com/a/a/b/a/b$a:b	Lcom/a/a/b/a/b$a;
    //   221: aconst_null
    //   222: invokespecial 369	com/a/a/b/i:a	(Lcom/a/a/b/a/b$a;Ljava/lang/Throwable;)V
    //   225: aload_2
    //   226: areturn
    //   227: astore 9
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_0
    //   232: getstatic 371	com/a/a/b/a/b$a:c	Lcom/a/a/b/a/b$a;
    //   235: aconst_null
    //   236: invokespecial 369	com/a/a/b/i:a	(Lcom/a/a/b/a/b$a;Ljava/lang/Throwable;)V
    //   239: aload_2
    //   240: areturn
    //   241: astore 8
    //   243: aload 8
    //   245: athrow
    //   246: astore 6
    //   248: aconst_null
    //   249: astore_2
    //   250: aload 6
    //   252: astore 7
    //   254: aload 7
    //   256: invokestatic 374	com/a/a/c/d:a	(Ljava/lang/Throwable;)V
    //   259: aload_0
    //   260: getstatic 376	com/a/a/b/a/b$a:a	Lcom/a/a/b/a/b$a;
    //   263: aload 7
    //   265: invokespecial 369	com/a/a/b/i:a	(Lcom/a/a/b/a/b$a;Ljava/lang/Throwable;)V
    //   268: aload_2
    //   269: areturn
    //   270: astore 4
    //   272: aconst_null
    //   273: astore_2
    //   274: aload 4
    //   276: astore 5
    //   278: aload 5
    //   280: invokestatic 374	com/a/a/c/d:a	(Ljava/lang/Throwable;)V
    //   283: aload_0
    //   284: getstatic 378	com/a/a/b/a/b$a:d	Lcom/a/a/b/a/b$a;
    //   287: aload 5
    //   289: invokespecial 369	com/a/a/b/i:a	(Lcom/a/a/b/a/b$a;Ljava/lang/Throwable;)V
    //   292: aload_2
    //   293: areturn
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_2
    //   297: aload_1
    //   298: astore_3
    //   299: aload_3
    //   300: invokestatic 374	com/a/a/c/d:a	(Ljava/lang/Throwable;)V
    //   303: aload_0
    //   304: getstatic 380	com/a/a/b/a/b$a:e	Lcom/a/a/b/a/b$a;
    //   307: aload_3
    //   308: invokespecial 369	com/a/a/b/i:a	(Lcom/a/a/b/a/b$a;Ljava/lang/Throwable;)V
    //   311: aload_2
    //   312: areturn
    //   313: astore_3
    //   314: goto -15 -> 299
    //   317: astore 5
    //   319: goto -41 -> 278
    //   322: astore 7
    //   324: goto -70 -> 254
    //   327: astore 11
    //   329: goto -98 -> 231
    //   332: aconst_null
    //   333: astore_2
    //   334: goto -251 -> 83
    //
    // Exception table:
    //   from	to	target	type
    //   0	18	227	java/lang/IllegalStateException
    //   23	80	227	java/lang/IllegalStateException
    //   0	18	241	com/a/a/b/i$a
    //   23	80	241	com/a/a/b/i$a
    //   87	101	241	com/a/a/b/i$a
    //   101	170	241	com/a/a/b/i$a
    //   175	188	241	com/a/a/b/i$a
    //   188	199	241	com/a/a/b/i$a
    //   203	217	241	com/a/a/b/i$a
    //   217	225	241	com/a/a/b/i$a
    //   0	18	246	java/io/IOException
    //   23	80	246	java/io/IOException
    //   0	18	270	java/lang/OutOfMemoryError
    //   23	80	270	java/lang/OutOfMemoryError
    //   0	18	294	java/lang/Throwable
    //   23	80	294	java/lang/Throwable
    //   87	101	313	java/lang/Throwable
    //   101	170	313	java/lang/Throwable
    //   175	188	313	java/lang/Throwable
    //   188	199	313	java/lang/Throwable
    //   203	217	313	java/lang/Throwable
    //   217	225	313	java/lang/Throwable
    //   87	101	317	java/lang/OutOfMemoryError
    //   101	170	317	java/lang/OutOfMemoryError
    //   175	188	317	java/lang/OutOfMemoryError
    //   188	199	317	java/lang/OutOfMemoryError
    //   203	217	317	java/lang/OutOfMemoryError
    //   217	225	317	java/lang/OutOfMemoryError
    //   87	101	322	java/io/IOException
    //   101	170	322	java/io/IOException
    //   175	188	322	java/io/IOException
    //   188	199	322	java/io/IOException
    //   203	217	322	java/io/IOException
    //   217	225	322	java/io/IOException
    //   87	101	327	java/lang/IllegalStateException
    //   101	170	327	java/lang/IllegalStateException
    //   175	188	327	java/lang/IllegalStateException
    //   188	199	327	java/lang/IllegalStateException
    //   203	217	327	java/lang/IllegalStateException
    //   217	225	327	java/lang/IllegalStateException
  }

  private boolean e()
    throws i.a
  {
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.H;
    com.a.a.c.d.a("Cache image on disk [%s]", arrayOfObject1);
    try
    {
      boolean bool = f();
      if (bool)
      {
        int i1 = this.C.d;
        int i2 = this.C.e;
        if ((i1 > 0) || (i2 > 0))
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.H;
          com.a.a.c.d.a("Resize image in disk cache [%s]", arrayOfObject2);
          b(i1, i2);
        }
      }
      return bool;
    }
    catch (IOException localIOException)
    {
      com.a.a.c.d.a(localIOException);
    }
    return false;
  }

  private boolean f()
    throws IOException
  {
    InputStream localInputStream = h().a(this.a, this.c.n());
    return this.C.o.a(this.a, localInputStream, this);
  }

  private void g()
  {
    if ((this.J) || (p()))
      return;
    a(new l(this), false, this.B, this.z);
  }

  private com.a.a.b.d.b h()
  {
    if (this.z.f())
      return this.E;
    if (this.z.g())
      return this.F;
    return this.D;
  }

  private void i()
    throws i.a
  {
    k();
    m();
  }

  private boolean j()
  {
    return (l()) || (n());
  }

  private void k()
    throws i.a
  {
    if (l())
      throw new a();
  }

  private boolean l()
  {
    if (this.b.e())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.H;
      com.a.a.c.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", arrayOfObject);
      return true;
    }
    return false;
  }

  private void m()
    throws i.a
  {
    if (n())
      throw new a();
  }

  private boolean n()
  {
    String str = this.z.a(this.b);
    if (!this.H.equals(str));
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.H;
      com.a.a.c.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", arrayOfObject);
      return true;
    }
    return false;
  }

  private void o()
    throws i.a
  {
    if (p())
      throw new a();
  }

  private boolean p()
  {
    if (Thread.interrupted())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.H;
      com.a.a.c.d.a("Task was interrupted [%s]", arrayOfObject);
      return true;
    }
    return false;
  }

  String a()
  {
    return this.a;
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return (this.J) || (c(paramInt1, paramInt2));
  }

  public void run()
  {
    if (b());
    do
      return;
    while (c());
    ReentrantLock localReentrantLock = this.A.h;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.H;
    com.a.a.c.d.a("Start display image task [%s]", arrayOfObject1);
    if (localReentrantLock.isLocked())
    {
      Object[] arrayOfObject8 = new Object[1];
      arrayOfObject8[0] = this.H;
      com.a.a.c.d.a("Image already is loading. Waiting... [%s]", arrayOfObject8);
    }
    localReentrantLock.lock();
    try
    {
      i();
      Object localObject2 = (Bitmap)this.C.n.b(this.H);
      if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled()))
      {
        Bitmap localBitmap = d();
        localObject2 = localBitmap;
        if (localObject2 == null)
          return;
        i();
        o();
        if (this.c.d())
        {
          Object[] arrayOfObject5 = new Object[1];
          arrayOfObject5[0] = this.H;
          com.a.a.c.d.a("PreProcess image before caching in memory [%s]", arrayOfObject5);
          localObject2 = this.c.o().a((Bitmap)localObject2);
          if (localObject2 == null)
          {
            Object[] arrayOfObject6 = new Object[1];
            arrayOfObject6[0] = this.H;
            com.a.a.c.d.d("Pre-processor returned null [%s]", arrayOfObject6);
          }
        }
        if ((localObject2 != null) && (this.c.h()))
        {
          Object[] arrayOfObject4 = new Object[1];
          arrayOfObject4[0] = this.H;
          com.a.a.c.d.a("Cache image in memory [%s]", arrayOfObject4);
          this.C.n.a(this.H, localObject2);
        }
      }
      while (true)
      {
        if ((localObject2 != null) && (this.c.e()))
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = this.H;
          com.a.a.c.d.a("PostProcess image before displaying [%s]", arrayOfObject2);
          localObject2 = this.c.p().a((Bitmap)localObject2);
          if (localObject2 == null)
          {
            Object[] arrayOfObject3 = new Object[1];
            arrayOfObject3[0] = this.H;
            com.a.a.c.d.d("Post-processor returned null [%s]", arrayOfObject3);
          }
        }
        i();
        o();
        localReentrantLock.unlock();
        a(new b((Bitmap)localObject2, this.A, this.z, this.K), this.J, this.B, this.z);
        return;
        this.K = com.a.a.b.a.f.c;
        Object[] arrayOfObject7 = new Object[1];
        arrayOfObject7[0] = this.H;
        com.a.a.c.d.a("...Get cached bitmap from memory after waiting. [%s]", arrayOfObject7);
      }
    }
    catch (a locala)
    {
      g();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
    throw localObject1;
  }

  class a extends Exception
  {
    a()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.b.i
 * JD-Core Version:    0.6.0
 */