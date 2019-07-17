package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.b;
import com.android.volley.b.a;
import com.android.volley.y;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g
  implements b
{
  private static final int e = 5242880;
  private static final float f = 0.9F;
  private static final int g = 538247942;
  private final Map<String, a> a = new LinkedHashMap(16, 0.75F, true);
  private long b = 0L;
  private final File c;
  private final int d;

  public g(File paramFile)
  {
    this(paramFile, 5242880);
  }

  public g(File paramFile, int paramInt)
  {
    this.c = paramFile;
    this.d = paramInt;
  }

  static int a(InputStream paramInputStream)
    throws IOException
  {
    return 0x0 | e(paramInputStream) << 0 | e(paramInputStream) << 8 | e(paramInputStream) << 16 | e(paramInputStream) << 24;
  }

  private void a(int paramInt)
  {
    if (this.b + paramInt < this.d)
      return;
    Iterator localIterator;
    int i;
    label61: int j;
    while (true)
    {
      if (y.b)
        y.a("Pruning old cache entries.", new Object[0]);
      long l1 = this.b;
      long l2 = SystemClock.elapsedRealtime();
      localIterator = this.a.entrySet().iterator();
      i = 0;
      if (localIterator.hasNext())
        break;
      j = i;
      if (!y.b)
        continue;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Integer.valueOf(j);
      arrayOfObject2[1] = Long.valueOf(this.b - l1);
      arrayOfObject2[2] = Long.valueOf(SystemClock.elapsedRealtime() - l2);
      y.a("pruned %d files, %d bytes, %d ms", arrayOfObject2);
      return;
    }
    a locala = (a)((Map.Entry)localIterator.next()).getValue();
    if (c(locala.b).delete())
      this.b -= locala.a;
    while (true)
    {
      localIterator.remove();
      j = i + 1;
      if ((float)(this.b + paramInt) < 0.9F * this.d)
        break;
      i = j;
      break label61;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = locala.b;
      arrayOfObject1[1] = d(locala.b);
      y.b("Could not delete cache entry for key=%s, filename=%s", arrayOfObject1);
    }
  }

  static void a(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(0xFF & paramInt >> 0);
    paramOutputStream.write(0xFF & paramInt >> 8);
    paramOutputStream.write(0xFF & paramInt >> 16);
    paramOutputStream.write(0xFF & paramInt >> 24);
  }

  static void a(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }

  static void a(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    a(paramOutputStream, arrayOfByte.length);
    paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
  }

  private void a(String paramString, a parama)
  {
    if (!this.a.containsKey(paramString))
      this.b += parama.a;
    while (true)
    {
      this.a.put(paramString, parama);
      return;
      a locala = (a)this.a.get(paramString);
      this.b += parama.a - locala.a;
    }
  }

  static void a(Map<String, String> paramMap, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramMap != null)
    {
      a(paramOutputStream, paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a(paramOutputStream, (String)localEntry.getKey());
        a(paramOutputStream, (String)localEntry.getValue());
      }
    }
    a(paramOutputStream, 0);
  }

  private static byte[] a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (true)
    {
      int j;
      if (i < paramInt)
      {
        j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j != -1);
      }
      else
      {
        if (i == paramInt)
          break;
        throw new IOException("Expected " + paramInt + " bytes, read " + i + " bytes");
      }
      i += j;
    }
    return arrayOfByte;
  }

  static long b(InputStream paramInputStream)
    throws IOException
  {
    return 0L | (0xFF & e(paramInputStream)) << 0 | (0xFF & e(paramInputStream)) << 8 | (0xFF & e(paramInputStream)) << 16 | (0xFF & e(paramInputStream)) << 24 | (0xFF & e(paramInputStream)) << 32 | (0xFF & e(paramInputStream)) << 40 | (0xFF & e(paramInputStream)) << 48 | (0xFF & e(paramInputStream)) << 56;
  }

  static String c(InputStream paramInputStream)
    throws IOException
  {
    return new String(a(paramInputStream, (int)b(paramInputStream)), "UTF-8");
  }

  private String d(String paramString)
  {
    int i = paramString.length() / 2;
    return String.valueOf(paramString.substring(0, i).hashCode()) + String.valueOf(paramString.substring(i).hashCode());
  }

  static Map<String, String> d(InputStream paramInputStream)
    throws IOException
  {
    int i = a(paramInputStream);
    Object localObject;
    if (i == 0)
      localObject = Collections.emptyMap();
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        return localObject;
        localObject = new HashMap(i);
        break;
      }
      ((Map)localObject).put(c(paramInputStream).intern(), c(paramInputStream).intern());
    }
  }

  private static int e(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i == -1)
      throw new EOFException();
    return i;
  }

  private void e(String paramString)
  {
    a locala = (a)this.a.get(paramString);
    if (locala != null)
    {
      this.b -= locala.a;
      this.a.remove(paramString);
    }
  }

  // ERROR //
  public b.a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/android/volley/toolbox/g:a	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 165 2 0
    //   12: checkcast 108	com/android/volley/toolbox/g$a
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +11 -> 28
    //   20: aconst_null
    //   21: astore 9
    //   23: aload_0
    //   24: monitorexit
    //   25: aload 9
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 114	com/android/volley/toolbox/g:c	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 4
    //   35: new 266	com/android/volley/toolbox/g$b
    //   38: dup
    //   39: new 268	java/io/BufferedInputStream
    //   42: dup
    //   43: new 270	java/io/FileInputStream
    //   46: dup
    //   47: aload 4
    //   49: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 275	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: aconst_null
    //   56: invokespecial 278	com/android/volley/toolbox/g$b:<init>	(Ljava/io/InputStream;Lcom/android/volley/toolbox/g$b;)V
    //   59: astore 5
    //   61: aload 5
    //   63: invokestatic 281	com/android/volley/toolbox/g$a:a	(Ljava/io/InputStream;)Lcom/android/volley/toolbox/g$a;
    //   66: pop
    //   67: aload_3
    //   68: aload 5
    //   70: aload 4
    //   72: invokevirtual 283	java/io/File:length	()J
    //   75: aload 5
    //   77: invokestatic 286	com/android/volley/toolbox/g$b:a	(Lcom/android/volley/toolbox/g$b;)I
    //   80: i2l
    //   81: lsub
    //   82: l2i
    //   83: invokestatic 215	com/android/volley/toolbox/g:a	(Ljava/io/InputStream;I)[B
    //   86: invokevirtual 289	com/android/volley/toolbox/g$a:a	([B)Lcom/android/volley/b$a;
    //   89: astore 16
    //   91: aload 16
    //   93: astore 9
    //   95: aload 5
    //   97: ifnull -74 -> 23
    //   100: aload 5
    //   102: invokevirtual 292	com/android/volley/toolbox/g$b:close	()V
    //   105: goto -82 -> 23
    //   108: astore 17
    //   110: aconst_null
    //   111: astore 9
    //   113: goto -90 -> 23
    //   116: astore 6
    //   118: aconst_null
    //   119: astore 5
    //   121: iconst_2
    //   122: anewarray 4	java/lang/Object
    //   125: astore 10
    //   127: aload 10
    //   129: iconst_0
    //   130: aload 4
    //   132: invokevirtual 295	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: aastore
    //   136: aload 10
    //   138: iconst_1
    //   139: aload 6
    //   141: invokevirtual 296	java/io/IOException:toString	()Ljava/lang/String;
    //   144: aastore
    //   145: ldc_w 298
    //   148: aload 10
    //   150: invokestatic 131	com/android/volley/y:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: aload_1
    //   155: invokevirtual 300	com/android/volley/toolbox/g:b	(Ljava/lang/String;)V
    //   158: aload 5
    //   160: ifnull +8 -> 168
    //   163: aload 5
    //   165: invokevirtual 292	com/android/volley/toolbox/g$b:close	()V
    //   168: aconst_null
    //   169: astore 9
    //   171: goto -148 -> 23
    //   174: astore 11
    //   176: aconst_null
    //   177: astore 9
    //   179: goto -156 -> 23
    //   182: astore 12
    //   184: aconst_null
    //   185: astore 5
    //   187: iconst_2
    //   188: anewarray 4	java/lang/Object
    //   191: astore 13
    //   193: aload 13
    //   195: iconst_0
    //   196: aload 4
    //   198: invokevirtual 295	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   201: aastore
    //   202: aload 13
    //   204: iconst_1
    //   205: aload 12
    //   207: invokevirtual 301	java/lang/NegativeArraySizeException:toString	()Ljava/lang/String;
    //   210: aastore
    //   211: ldc_w 298
    //   214: aload 13
    //   216: invokestatic 131	com/android/volley/y:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload_0
    //   220: aload_1
    //   221: invokevirtual 300	com/android/volley/toolbox/g:b	(Ljava/lang/String;)V
    //   224: aload 5
    //   226: ifnull +8 -> 234
    //   229: aload 5
    //   231: invokevirtual 292	com/android/volley/toolbox/g$b:close	()V
    //   234: aconst_null
    //   235: astore 9
    //   237: goto -214 -> 23
    //   240: astore 14
    //   242: aconst_null
    //   243: astore 9
    //   245: goto -222 -> 23
    //   248: astore 7
    //   250: aconst_null
    //   251: astore 5
    //   253: aload 5
    //   255: ifnull +8 -> 263
    //   258: aload 5
    //   260: invokevirtual 292	com/android/volley/toolbox/g$b:close	()V
    //   263: aload 7
    //   265: athrow
    //   266: astore_2
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_2
    //   270: athrow
    //   271: astore 8
    //   273: aconst_null
    //   274: astore 9
    //   276: goto -253 -> 23
    //   279: astore 7
    //   281: goto -28 -> 253
    //   284: astore 12
    //   286: goto -99 -> 187
    //   289: astore 6
    //   291: goto -170 -> 121
    //
    // Exception table:
    //   from	to	target	type
    //   100	105	108	java/io/IOException
    //   35	61	116	java/io/IOException
    //   163	168	174	java/io/IOException
    //   35	61	182	java/lang/NegativeArraySizeException
    //   229	234	240	java/io/IOException
    //   35	61	248	finally
    //   2	16	266	finally
    //   28	35	266	finally
    //   100	105	266	finally
    //   163	168	266	finally
    //   229	234	266	finally
    //   258	263	266	finally
    //   263	266	266	finally
    //   258	263	271	java/io/IOException
    //   61	91	279	finally
    //   121	158	279	finally
    //   187	224	279	finally
    //   61	91	284	java/lang/NegativeArraySizeException
    //   61	91	289	java/io/IOException
  }

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/android/volley/toolbox/g:c	Ljava/io/File;
    //   6: invokevirtual 304	java/io/File:exists	()Z
    //   9: ifne +41 -> 50
    //   12: aload_0
    //   13: getfield 42	com/android/volley/toolbox/g:c	Ljava/io/File;
    //   16: invokevirtual 307	java/io/File:mkdirs	()Z
    //   19: ifne +28 -> 47
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: astore 17
    //   28: aload 17
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 42	com/android/volley/toolbox/g:c	Ljava/io/File;
    //   35: invokevirtual 295	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: ldc_w 309
    //   42: aload 17
    //   44: invokestatic 311	com/android/volley/y:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 42	com/android/volley/toolbox/g:c	Ljava/io/File;
    //   54: invokevirtual 315	java/io/File:listFiles	()[Ljava/io/File;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull -12 -> 47
    //   62: aload_2
    //   63: arraylength
    //   64: istore_3
    //   65: iconst_0
    //   66: istore 4
    //   68: iload 4
    //   70: iload_3
    //   71: if_icmpge -24 -> 47
    //   74: aload_2
    //   75: iload 4
    //   77: aaload
    //   78: astore 5
    //   80: aconst_null
    //   81: astore 6
    //   83: new 268	java/io/BufferedInputStream
    //   86: dup
    //   87: new 270	java/io/FileInputStream
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 272	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: invokespecial 275	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 7
    //   101: aload 7
    //   103: invokestatic 281	com/android/volley/toolbox/g$a:a	(Ljava/io/InputStream;)Lcom/android/volley/toolbox/g$a;
    //   106: astore 14
    //   108: aload 14
    //   110: aload 5
    //   112: invokevirtual 283	java/io/File:length	()J
    //   115: putfield 121	com/android/volley/toolbox/g$a:a	J
    //   118: aload_0
    //   119: aload 14
    //   121: getfield 111	com/android/volley/toolbox/g$a:b	Ljava/lang/String;
    //   124: aload 14
    //   126: invokespecial 317	com/android/volley/toolbox/g:a	(Ljava/lang/String;Lcom/android/volley/toolbox/g$a;)V
    //   129: aload 7
    //   131: ifnull +8 -> 139
    //   134: aload 7
    //   136: invokevirtual 318	java/io/BufferedInputStream:close	()V
    //   139: iinc 4 1
    //   142: goto -74 -> 68
    //   145: astore 16
    //   147: aconst_null
    //   148: astore 7
    //   150: aload 5
    //   152: ifnull +9 -> 161
    //   155: aload 5
    //   157: invokevirtual 119	java/io/File:delete	()Z
    //   160: pop
    //   161: aload 7
    //   163: ifnull -24 -> 139
    //   166: aload 7
    //   168: invokevirtual 318	java/io/BufferedInputStream:close	()V
    //   171: goto -32 -> 139
    //   174: astore 9
    //   176: goto -37 -> 139
    //   179: astore 11
    //   181: aload 6
    //   183: ifnull +8 -> 191
    //   186: aload 6
    //   188: invokevirtual 318	java/io/BufferedInputStream:close	()V
    //   191: aload 11
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore 12
    //   201: goto -10 -> 191
    //   204: astore 15
    //   206: goto -67 -> 139
    //   209: astore 10
    //   211: aload 7
    //   213: astore 6
    //   215: aload 10
    //   217: astore 11
    //   219: goto -38 -> 181
    //   222: astore 8
    //   224: goto -74 -> 150
    //
    // Exception table:
    //   from	to	target	type
    //   83	101	145	java/io/IOException
    //   166	171	174	java/io/IOException
    //   83	101	179	finally
    //   2	47	194	finally
    //   50	58	194	finally
    //   62	65	194	finally
    //   74	80	194	finally
    //   134	139	194	finally
    //   166	171	194	finally
    //   186	191	194	finally
    //   191	194	194	finally
    //   186	191	199	java/io/IOException
    //   134	139	204	java/io/IOException
    //   101	129	209	finally
    //   155	161	209	finally
    //   101	129	222	java/io/IOException
  }

  public void a(String paramString, b.a parama)
  {
    monitorenter;
    try
    {
      a(parama.a.length);
      File localFile = c(paramString);
      while (true)
      {
        BufferedOutputStream localBufferedOutputStream;
        a locala;
        try
        {
          localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile));
          locala = new a(paramString, parama);
          if (!locala.a(localBufferedOutputStream))
          {
            localBufferedOutputStream.close();
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = localFile.getAbsolutePath();
            y.b("Failed to write header for %s", arrayOfObject2);
            throw new IOException();
          }
        }
        catch (IOException localIOException)
        {
          if (localFile.delete())
            continue;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = localFile.getAbsolutePath();
          y.b("Could not clean up file %s", arrayOfObject1);
          monitorexit;
          return;
        }
        localBufferedOutputStream.write(parama.a);
        localBufferedOutputStream.close();
        a(paramString, locala);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(String paramString, boolean paramBoolean)
  {
    monitorenter;
    try
    {
      b.a locala = a(paramString);
      if (locala != null)
      {
        locala.f = 0L;
        if (paramBoolean)
          locala.e = 0L;
        a(paramString, locala);
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void b()
  {
    monitorenter;
    while (true)
    {
      int i;
      int j;
      try
      {
        File[] arrayOfFile = this.c.listFiles();
        if (arrayOfFile == null)
          continue;
        i = arrayOfFile.length;
        j = 0;
        break label69;
        this.a.clear();
        this.b = 0L;
        y.b("Cache cleared.", new Object[0]);
        return;
        arrayOfFile[j].delete();
        j++;
      }
      finally
      {
        monitorexit;
      }
      label69: if (j < i)
        continue;
    }
  }

  public void b(String paramString)
  {
    monitorenter;
    try
    {
      boolean bool = c(paramString).delete();
      e(paramString);
      if (!bool)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = d(paramString);
        y.b("Could not delete cache entry for key=%s, filename=%s", arrayOfObject);
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public File c(String paramString)
  {
    return new File(this.c, d(paramString));
  }

  static class a
  {
    public long a;
    public String b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
    public Map<String, String> h;

    private a()
    {
    }

    public a(String paramString, b.a parama)
    {
      this.b = paramString;
      this.a = parama.a.length;
      this.c = parama.b;
      this.d = parama.c;
      this.e = parama.d;
      this.f = parama.e;
      this.g = parama.f;
      this.h = parama.g;
    }

    public static a a(InputStream paramInputStream)
      throws IOException
    {
      a locala = new a();
      if (g.a(paramInputStream) != 538247942)
        throw new IOException();
      locala.b = g.c(paramInputStream);
      locala.c = g.c(paramInputStream);
      if (locala.c.equals(""))
        locala.c = null;
      locala.d = g.b(paramInputStream);
      locala.e = g.b(paramInputStream);
      locala.f = g.b(paramInputStream);
      locala.g = g.b(paramInputStream);
      locala.h = g.d(paramInputStream);
      return locala;
    }

    public b.a a(byte[] paramArrayOfByte)
    {
      b.a locala = new b.a();
      locala.a = paramArrayOfByte;
      locala.b = this.c;
      locala.c = this.d;
      locala.d = this.e;
      locala.e = this.f;
      locala.f = this.g;
      locala.g = this.h;
      return locala;
    }

    public boolean a(OutputStream paramOutputStream)
    {
      try
      {
        g.a(paramOutputStream, 538247942);
        g.a(paramOutputStream, this.b);
        if (this.c == null);
        for (String str = ""; ; str = this.c)
        {
          g.a(paramOutputStream, str);
          g.a(paramOutputStream, this.d);
          g.a(paramOutputStream, this.e);
          g.a(paramOutputStream, this.f);
          g.a(paramOutputStream, this.g);
          g.a(this.h, paramOutputStream);
          paramOutputStream.flush();
          return true;
        }
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localIOException.toString();
        y.b("%s", arrayOfObject);
      }
      return false;
    }
  }

  private static class b extends FilterInputStream
  {
    private int a = 0;

    private b(InputStream paramInputStream)
    {
      super();
    }

    public int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1)
        this.a = (1 + this.a);
      return i;
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i != -1)
        this.a = (i + this.a);
      return i;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.g
 * JD-Core Version:    0.6.0
 */