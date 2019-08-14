package com.a.a.c;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class c
{
  public static final int a = 32768;
  public static final int b = 512000;
  public static final int c = 75;

  public static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  public static void a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 7
    //   2: newarray byte
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_0
    //   8: ldc 7
    //   10: invokevirtual 32	java/io/InputStream:read	([BII)I
    //   13: istore 4
    //   15: iload 4
    //   17: iconst_m1
    //   18: if_icmpne -13 -> 5
    //   21: aload_0
    //   22: invokestatic 34	com/a/a/c/c:a	(Ljava/io/Closeable;)V
    //   25: return
    //   26: astore_3
    //   27: aload_0
    //   28: invokestatic 34	com/a/a/c/c:a	(Ljava/io/Closeable;)V
    //   31: return
    //   32: astore_2
    //   33: aload_0
    //   34: invokestatic 34	com/a/a/c/c:a	(Ljava/io/Closeable;)V
    //   37: aload_2
    //   38: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   5	15	26	java/io/IOException
    //   5	15	32	finally
  }

  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    return (parama != null) && (!parama.a(paramInt1, paramInt2)) && (paramInt1 * 100 / paramInt2 < 75);
  }

  public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream, a parama)
    throws IOException
  {
    return a(paramInputStream, paramOutputStream, parama, 32768);
  }

  public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream, a parama, int paramInt)
    throws IOException
  {
    int i = paramInputStream.available();
    if (i <= 0)
      i = 512000;
    byte[] arrayOfByte = new byte[paramInt];
    if (a(parama, 0, i))
      return false;
    int j = 0;
    while (true)
    {
      int k = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (k == -1)
        break;
      paramOutputStream.write(arrayOfByte, 0, k);
      j += k;
      if (a(parama, j, i))
        return false;
    }
    paramOutputStream.flush();
    return true;
  }

  public static abstract interface a
  {
    public abstract boolean a(int paramInt1, int paramInt2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.c.c
 * JD-Core Version:    0.6.0
 */