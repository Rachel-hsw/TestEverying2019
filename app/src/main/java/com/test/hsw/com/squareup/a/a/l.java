package com.squareup.a.a;

import b.ab;
import b.e;
import b.j;
import com.squareup.a.a.a.n;
import com.squareup.a.a.b.d;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public final class l
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final Charset c = Charset.forName("US-ASCII");
  public static final Charset d = Charset.forName("UTF-8");
  private static final n e = new n(0);

  public static int a(String paramString)
  {
    if ("http".equals(paramString))
      return 80;
    if ("https".equals(paramString))
      return 443;
    return -1;
  }

  private static int a(String paramString, int paramInt)
  {
    if (paramInt != -1)
      return paramInt;
    return a(paramString);
  }

  public static int a(URI paramURI)
  {
    return a(paramURI.getScheme(), paramURI.getPort());
  }

  public static int a(URL paramURL)
  {
    return a(paramURL.getProtocol(), paramURL.getPort());
  }

  public static n a()
  {
    return e;
  }

  public static <T> List<T> a(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }

  public static <T> List<T> a(T[] paramArrayOfT)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramArrayOfT.clone()));
  }

  public static List<d> a(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length / 2);
    for (int i = 0; i < paramArrayOfString.length; i += 2)
      localArrayList.add(new d(paramArrayOfString[i], paramArrayOfString[(i + 1)]));
    return localArrayList;
  }

  public static ThreadFactory a(String paramString, boolean paramBoolean)
  {
    return new m(paramString, paramBoolean);
  }

  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) < 0L) || (paramLong2 > paramLong1) || (paramLong1 - paramLong2 < paramLong3))
      throw new ArrayIndexOutOfBoundsException();
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(Closeable paramCloseable1, Closeable paramCloseable2)
    throws IOException
  {
    Object localObject = null;
    try
    {
      paramCloseable1.close();
      try
      {
        label8: paramCloseable2.close();
        if (localObject == null)
          return;
      }
      catch (Throwable localThrowable2)
      {
        while (true)
        {
          if (localObject != null)
            continue;
          localObject = localThrowable2;
        }
        if ((localObject instanceof IOException))
          throw ((IOException)localObject);
        if ((localObject instanceof RuntimeException))
          throw ((RuntimeException)localObject);
        if ((localObject instanceof Error))
          throw ((Error)localObject);
        throw new AssertionError(localObject);
      }
    }
    catch (Throwable localThrowable1)
    {
      break label8;
    }
  }

  public static void a(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null)
      throw new IOException("not a readable directory: " + paramFile);
    int i = arrayOfFile.length;
    for (int j = 0; j < i; j++)
    {
      File localFile = arrayOfFile[j];
      if (localFile.isDirectory())
        a(localFile);
      if (localFile.delete())
        continue;
      throw new IOException("failed to delete file: " + localFile);
    }
  }

  public static void a(ServerSocket paramServerSocket)
  {
    if (paramServerSocket != null);
    try
    {
      paramServerSocket.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(Socket paramSocket)
  {
    if (paramSocket != null);
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  public static boolean a(ab paramab, int paramInt)
    throws IOException
  {
    long l = System.nanoTime();
    e locale = new e();
    while (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l) < paramInt)
    {
      if (paramab.b(locale, 2048L) == -1L)
        return true;
      locale.v();
    }
    return false;
  }

  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  public static String b(String paramString)
  {
    try
    {
      String str = j.a(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"))).c();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new AssertionError(localNoSuchAlgorithmException);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new AssertionError(localUnsupportedEncodingException);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.l
 * JD-Core Version:    0.6.0
 */