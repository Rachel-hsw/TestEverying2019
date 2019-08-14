package com.a.a.a.a.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.a.a.a.a.b;
import com.a.a.c.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public abstract class a
  implements b
{
  public static final int a = 32768;
  public static final Bitmap.CompressFormat b = Bitmap.CompressFormat.PNG;
  public static final int c = 100;
  private static final String j = " argument must be not null";
  private static final String k = ".tmp";
  protected final File d;
  protected final File e;
  protected final com.a.a.a.a.b.a f;
  protected int g = 32768;
  protected Bitmap.CompressFormat h = b;
  protected int i = 100;

  public a(File paramFile)
  {
    this(paramFile, null);
  }

  public a(File paramFile1, File paramFile2)
  {
    this(paramFile1, paramFile2, com.a.a.b.a.b());
  }

  public a(File paramFile1, File paramFile2, com.a.a.a.a.b.a parama)
  {
    if (paramFile1 == null)
      throw new IllegalArgumentException("cacheDir argument must be not null");
    if (parama == null)
      throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    this.d = paramFile1;
    this.e = paramFile2;
    this.f = parama;
  }

  public File a()
  {
    return this.d;
  }

  public File a(String paramString)
  {
    return c(paramString);
  }

  public void a(int paramInt)
  {
    this.g = paramInt;
  }

  public void a(Bitmap.CompressFormat paramCompressFormat)
  {
    this.h = paramCompressFormat;
  }

  public boolean a(String paramString, Bitmap paramBitmap)
    throws IOException
  {
    File localFile1 = c(paramString);
    File localFile2 = new File(localFile1.getAbsolutePath() + ".tmp");
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile2), this.g);
    try
    {
      boolean bool1 = paramBitmap.compress(this.h, this.i, localBufferedOutputStream);
      boolean bool2 = bool1;
      c.a(localBufferedOutputStream);
      if ((bool2) && (!localFile2.renameTo(localFile1)))
        bool2 = false;
      if (!bool2)
        localFile2.delete();
      paramBitmap.recycle();
      return bool2;
    }
    finally
    {
      c.a(localBufferedOutputStream);
      localFile2.delete();
    }
    throw localObject;
  }

  // ERROR //
  public boolean a(String paramString, java.io.InputStream paramInputStream, com.a.a.c.c.a parama)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 77	com/a/a/a/a/a/a:c	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore 4
    //   7: new 84	java/io/File
    //   10: dup
    //   11: new 86	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   18: aload 4
    //   20: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   23: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 20
    //   28: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: new 101	java/io/BufferedOutputStream
    //   42: dup
    //   43: new 103	java/io/FileOutputStream
    //   46: dup
    //   47: aload 5
    //   49: invokespecial 105	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: aload_0
    //   53: getfield 54	com/a/a/a/a/a/a:g	I
    //   56: invokespecial 108	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   59: astore 6
    //   61: aload_2
    //   62: aload 6
    //   64: aload_3
    //   65: aload_0
    //   66: getfield 54	com/a/a/a/a/a/a:g	I
    //   69: invokestatic 134	com/a/a/c/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;Lcom/a/a/c/c$a;I)Z
    //   72: istore 11
    //   74: iload 11
    //   76: istore 9
    //   78: aload 6
    //   80: invokestatic 119	com/a/a/c/c:a	(Ljava/io/Closeable;)V
    //   83: aload_2
    //   84: invokestatic 119	com/a/a/c/c:a	(Ljava/io/Closeable;)V
    //   87: iload 9
    //   89: ifeq +16 -> 105
    //   92: aload 5
    //   94: aload 4
    //   96: invokevirtual 123	java/io/File:renameTo	(Ljava/io/File;)Z
    //   99: ifne +6 -> 105
    //   102: iconst_0
    //   103: istore 9
    //   105: iload 9
    //   107: ifne +9 -> 116
    //   110: aload 5
    //   112: invokevirtual 127	java/io/File:delete	()Z
    //   115: pop
    //   116: iload 9
    //   118: ireturn
    //   119: astore 7
    //   121: aload 6
    //   123: invokestatic 119	com/a/a/c/c:a	(Ljava/io/Closeable;)V
    //   126: aload 7
    //   128: athrow
    //   129: astore 8
    //   131: iconst_0
    //   132: istore 9
    //   134: aload_2
    //   135: invokestatic 119	com/a/a/c/c:a	(Ljava/io/Closeable;)V
    //   138: iload 9
    //   140: ifeq +16 -> 156
    //   143: aload 5
    //   145: aload 4
    //   147: invokevirtual 123	java/io/File:renameTo	(Ljava/io/File;)Z
    //   150: ifne +6 -> 156
    //   153: iconst_0
    //   154: istore 9
    //   156: iload 9
    //   158: ifne +9 -> 167
    //   161: aload 5
    //   163: invokevirtual 127	java/io/File:delete	()Z
    //   166: pop
    //   167: aload 8
    //   169: athrow
    //   170: astore 8
    //   172: goto -38 -> 134
    //
    // Exception table:
    //   from	to	target	type
    //   61	74	119	finally
    //   39	61	129	finally
    //   121	129	129	finally
    //   78	83	170	finally
  }

  public void b()
  {
  }

  public void b(int paramInt)
  {
    this.i = paramInt;
  }

  public boolean b(String paramString)
  {
    return c(paramString).delete();
  }

  protected File c(String paramString)
  {
    String str = this.f.a(paramString);
    File localFile = this.d;
    if ((!this.d.exists()) && (!this.d.mkdirs()) && (this.e != null) && ((this.e.exists()) || (this.e.mkdirs())))
      localFile = this.e;
    return new File(localFile, str);
  }

  public void c()
  {
    File[] arrayOfFile = this.d.listFiles();
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      for (int n = 0; n < m; n++)
        arrayOfFile[n].delete();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.a.a.a.a
 * JD-Core Version:    0.6.0
 */