package com.a.a.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.a.a.a.a.b;
import com.a.a.c.c;
import com.a.a.c.c.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class d
  implements b
{
  public static final int a = 32768;
  public static final Bitmap.CompressFormat b = Bitmap.CompressFormat.PNG;
  public static final int c = 100;
  private static final String i = " argument must be not null";
  private static final String j = " argument must be positive number";
  protected a d;
  protected final com.a.a.a.a.b.a e;
  protected int f = 32768;
  protected Bitmap.CompressFormat g = b;
  protected int h = 100;
  private File k;

  public d(File paramFile, com.a.a.a.a.b.a parama, long paramLong)
    throws IOException
  {
    this(paramFile, null, parama, paramLong, 0);
  }

  public d(File paramFile1, File paramFile2, com.a.a.a.a.b.a parama, long paramLong, int paramInt)
    throws IOException
  {
    if (paramFile1 == null)
      throw new IllegalArgumentException("cacheDir argument must be not null");
    if (paramLong < 0L)
      throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
    if (paramInt < 0)
      throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
    if (parama == null)
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    long l;
    if (paramLong == 0L)
      l = 9223372036854775807L;
    while (true)
    {
      if (paramInt == 0);
      for (int m = 2147483647; ; m = paramInt)
      {
        this.k = paramFile2;
        this.e = parama;
        a(paramFile1, paramFile2, l, m);
        return;
      }
      l = paramLong;
    }
  }

  private void a(File paramFile1, File paramFile2, long paramLong, int paramInt)
    throws IOException
  {
    try
    {
      this.d = a.a(paramFile1, 1, 1, paramLong, paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      do
      {
        com.a.a.c.d.a(localIOException);
        if (paramFile2 == null)
          continue;
        a(paramFile2, null, paramLong, paramInt);
      }
      while (this.d != null);
    }
    throw localIOException;
  }

  private String c(String paramString)
  {
    return this.e.a(paramString);
  }

  public File a()
  {
    return this.d.a();
  }

  // ERROR //
  public File a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/a/a/a/a/a/a/d:d	Lcom/a/a/a/a/a/a/a;
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 99	com/a/a/a/a/a/a/d:c	(Ljava/lang/String;)Ljava/lang/String;
    //   9: invokevirtual 102	com/a/a/a/a/a/a/a:a	(Ljava/lang/String;)Lcom/a/a/a/a/a/a/a$c;
    //   12: astore 7
    //   14: aload 7
    //   16: astore_3
    //   17: aconst_null
    //   18: astore 6
    //   20: aload_3
    //   21: ifnonnull +14 -> 35
    //   24: aload_3
    //   25: ifnull +7 -> 32
    //   28: aload_3
    //   29: invokevirtual 107	com/a/a/a/a/a/a/a$c:close	()V
    //   32: aload 6
    //   34: areturn
    //   35: aload_3
    //   36: iconst_0
    //   37: invokevirtual 110	com/a/a/a/a/a/a/a$c:a	(I)Ljava/io/File;
    //   40: astore 8
    //   42: aload 8
    //   44: astore 6
    //   46: goto -22 -> 24
    //   49: astore 5
    //   51: aconst_null
    //   52: astore_3
    //   53: aload 5
    //   55: invokestatic 88	com/a/a/c/d:a	(Ljava/lang/Throwable;)V
    //   58: aconst_null
    //   59: astore 6
    //   61: aload_3
    //   62: ifnull -30 -> 32
    //   65: aload_3
    //   66: invokevirtual 107	com/a/a/a/a/a/a/a$c:close	()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_3
    //   74: aload_2
    //   75: astore 4
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 107	com/a/a/a/a/a/a/a$c:close	()V
    //   85: aload 4
    //   87: athrow
    //   88: astore 4
    //   90: goto -13 -> 77
    //   93: astore 5
    //   95: goto -42 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   0	14	49	java/io/IOException
    //   0	14	71	finally
    //   35	42	88	finally
    //   53	58	88	finally
    //   35	42	93	java/io/IOException
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
  }

  public void a(Bitmap.CompressFormat paramCompressFormat)
  {
    this.g = paramCompressFormat;
  }

  public boolean a(String paramString, Bitmap paramBitmap)
    throws IOException
  {
    a.a locala = this.d.b(c(paramString));
    if (locala == null)
      return false;
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(locala.c(0), this.f);
    boolean bool;
    try
    {
      bool = paramBitmap.compress(this.g, this.h, localBufferedOutputStream);
      c.a(localBufferedOutputStream);
      if (bool)
      {
        locala.a();
        return bool;
      }
    }
    finally
    {
      c.a(localBufferedOutputStream);
    }
    locala.b();
    return bool;
  }

  public boolean a(String paramString, InputStream paramInputStream, c.a parama)
    throws IOException
  {
    a.a locala = this.d.b(c(paramString));
    if (locala == null)
      return false;
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(locala.c(0), this.f);
    try
    {
      boolean bool = c.a(paramInputStream, localBufferedOutputStream, parama, this.f);
      c.a(localBufferedOutputStream);
      if (bool)
      {
        locala.a();
        return bool;
      }
      locala.b();
      return bool;
    }
    finally
    {
      c.a(localBufferedOutputStream);
      locala.b();
    }
    throw localObject;
  }

  public void b()
  {
    try
    {
      this.d.close();
      this.d = null;
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        com.a.a.c.d.a(localIOException);
    }
  }

  public void b(int paramInt)
  {
    this.h = paramInt;
  }

  public boolean b(String paramString)
  {
    try
    {
      boolean bool = this.d.c(c(paramString));
      return bool;
    }
    catch (IOException localIOException)
    {
      com.a.a.c.d.a(localIOException);
    }
    return false;
  }

  public void c()
  {
    try
    {
      this.d.h();
    }
    catch (IOException localIOException1)
    {
      try
      {
        while (true)
        {
          a(this.d.a(), this.k, this.d.b(), this.d.c());
          return;
          localIOException1 = localIOException1;
          com.a.a.c.d.a(localIOException1);
        }
      }
      catch (IOException localIOException2)
      {
        com.a.a.c.d.a(localIOException2);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.a.a.a.d
 * JD-Core Version:    0.6.0
 */