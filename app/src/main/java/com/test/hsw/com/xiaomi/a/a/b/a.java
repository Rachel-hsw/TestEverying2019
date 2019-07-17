package com.xiaomi.a.a.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class a
{
  public static final String[] a = { "jpg", "png", "bmp", "gif", "webp" };

  // ERROR //
  public static void a(java.io.File paramFile1, java.io.File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 29	java/util/zip/ZipOutputStream
    //   5: dup
    //   6: new 31	java/io/FileOutputStream
    //   9: dup
    //   10: aload_0
    //   11: iconst_0
    //   12: invokespecial 35	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   15: invokespecial 38	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_1
    //   21: aconst_null
    //   22: aconst_null
    //   23: invokestatic 41	com/xiaomi/a/a/b/a:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   26: aload_3
    //   27: invokestatic 43	com/xiaomi/a/a/b/a:a	(Ljava/io/OutputStream;)V
    //   30: return
    //   31: astore 9
    //   33: aconst_null
    //   34: astore_3
    //   35: aload_3
    //   36: invokestatic 43	com/xiaomi/a/a/b/a:a	(Ljava/io/OutputStream;)V
    //   39: return
    //   40: astore 6
    //   42: new 45	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   49: ldc 49
    //   51: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 6
    //   56: invokevirtual 57	java/io/IOException:getMessage	()Ljava/lang/String;
    //   59: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 65	com/xiaomi/a/a/c/c:a	(Ljava/lang/String;)V
    //   68: aload_2
    //   69: invokestatic 43	com/xiaomi/a/a/b/a:a	(Ljava/io/OutputStream;)V
    //   72: return
    //   73: astore 7
    //   75: aload_2
    //   76: invokestatic 43	com/xiaomi/a/a/b/a:a	(Ljava/io/OutputStream;)V
    //   79: aload 7
    //   81: athrow
    //   82: astore 8
    //   84: aload_3
    //   85: astore_2
    //   86: aload 8
    //   88: astore 7
    //   90: goto -15 -> 75
    //   93: astore 5
    //   95: aload_3
    //   96: astore_2
    //   97: aload 5
    //   99: astore 6
    //   101: goto -59 -> 42
    //   104: astore 4
    //   106: goto -71 -> 35
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	31	java/io/FileNotFoundException
    //   2	19	40	java/io/IOException
    //   2	19	73	finally
    //   42	68	73	finally
    //   19	26	82	finally
    //   19	26	93	java/io/IOException
    //   19	26	104	java/io/FileNotFoundException
  }

  public static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null);
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null);
    try
    {
      paramOutputStream.flush();
    }
    catch (IOException localIOException1)
    {
      try
      {
        while (true)
        {
          paramOutputStream.close();
          return;
          localIOException1 = localIOException1;
        }
      }
      catch (IOException localIOException2)
      {
      }
    }
  }

  public static void a(Reader paramReader)
  {
    if (paramReader != null);
    try
    {
      paramReader.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public static void a(Writer paramWriter)
  {
    if (paramWriter != null);
    try
    {
      paramWriter.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  // ERROR //
  public static void a(java.util.zip.ZipOutputStream paramZipOutputStream, java.io.File paramFile, String paramString, java.io.FileFilter paramFileFilter)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_2
    //   7: ifnonnull +6 -> 13
    //   10: ldc 87
    //   12: astore_2
    //   13: aload_1
    //   14: invokevirtual 93	java/io/File:isDirectory	()Z
    //   17: ifeq +247 -> 264
    //   20: aconst_null
    //   21: astore 4
    //   23: aload_3
    //   24: ifnull +112 -> 136
    //   27: aload_1
    //   28: aload_3
    //   29: invokevirtual 97	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   32: astore 8
    //   34: aload_0
    //   35: new 99	java/util/zip/ZipEntry
    //   38: dup
    //   39: new 45	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   46: aload_2
    //   47: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: getstatic 103	java/io/File:separator	Ljava/lang/String;
    //   53: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   62: invokevirtual 109	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   65: aload_2
    //   66: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   69: ifeq +76 -> 145
    //   72: ldc 87
    //   74: astore 9
    //   76: goto +380 -> 456
    //   79: aload 8
    //   81: arraylength
    //   82: istore 11
    //   84: aconst_null
    //   85: astore 4
    //   87: iload 10
    //   89: iload 11
    //   91: if_icmpge +79 -> 170
    //   94: aload_0
    //   95: aload 8
    //   97: iload 10
    //   99: aaload
    //   100: new 45	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   107: aload 9
    //   109: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 8
    //   114: iload 10
    //   116: aaload
    //   117: invokevirtual 118	java/io/File:getName	()Ljava/lang/String;
    //   120: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: aconst_null
    //   127: invokestatic 41	com/xiaomi/a/a/b/a:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   130: iinc 10 1
    //   133: goto -54 -> 79
    //   136: aload_1
    //   137: invokevirtual 121	java/io/File:listFiles	()[Ljava/io/File;
    //   140: astore 8
    //   142: goto -108 -> 34
    //   145: new 45	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   152: aload_2
    //   153: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: getstatic 103	java/io/File:separator	Ljava/lang/String;
    //   159: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: goto +289 -> 456
    //   170: aload_1
    //   171: new 123	com/xiaomi/a/a/b/b
    //   174: dup
    //   175: invokespecial 124	com/xiaomi/a/a/b/b:<init>	()V
    //   178: invokevirtual 97	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   181: astore 12
    //   183: aconst_null
    //   184: astore 4
    //   186: aload 12
    //   188: ifnull +67 -> 255
    //   191: aload 12
    //   193: arraylength
    //   194: istore 13
    //   196: aconst_null
    //   197: astore 4
    //   199: iload 5
    //   201: iload 13
    //   203: if_icmpge +52 -> 255
    //   206: aload 12
    //   208: iload 5
    //   210: aaload
    //   211: astore 14
    //   213: aload_0
    //   214: aload 14
    //   216: new 45	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   223: aload 9
    //   225: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: getstatic 103	java/io/File:separator	Ljava/lang/String;
    //   231: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 14
    //   236: invokevirtual 118	java/io/File:getName	()Ljava/lang/String;
    //   239: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: aload_3
    //   246: invokestatic 41	com/xiaomi/a/a/b/a:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;Ljava/io/FileFilter;)V
    //   249: iinc 5 1
    //   252: goto -56 -> 196
    //   255: aconst_null
    //   256: astore 15
    //   258: aload 15
    //   260: invokestatic 126	com/xiaomi/a/a/b/a:a	(Ljava/io/InputStream;)V
    //   263: return
    //   264: aload_2
    //   265: invokestatic 115	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   268: istore 16
    //   270: aconst_null
    //   271: astore 4
    //   273: iload 16
    //   275: ifne +101 -> 376
    //   278: aload_0
    //   279: new 99	java/util/zip/ZipEntry
    //   282: dup
    //   283: aload_2
    //   284: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   287: invokevirtual 109	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   290: new 128	java/io/FileInputStream
    //   293: dup
    //   294: aload_1
    //   295: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   298: astore 15
    //   300: sipush 1024
    //   303: newarray byte
    //   305: astore 19
    //   307: aload 15
    //   309: aload 19
    //   311: invokevirtual 135	java/io/FileInputStream:read	([B)I
    //   314: istore 20
    //   316: iload 20
    //   318: iconst_m1
    //   319: if_icmpeq -61 -> 258
    //   322: aload_0
    //   323: aload 19
    //   325: iconst_0
    //   326: iload 20
    //   328: invokevirtual 139	java/util/zip/ZipOutputStream:write	([BII)V
    //   331: goto -24 -> 307
    //   334: astore 18
    //   336: aload 15
    //   338: astore 4
    //   340: aload 18
    //   342: astore 7
    //   344: new 45	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   351: ldc 141
    //   353: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 7
    //   358: invokevirtual 142	java/io/IOException:toString	()Ljava/lang/String;
    //   361: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 145	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   370: aload 4
    //   372: invokestatic 126	com/xiaomi/a/a/b/a:a	(Ljava/io/InputStream;)V
    //   375: return
    //   376: new 147	java/util/Date
    //   379: dup
    //   380: invokespecial 148	java/util/Date:<init>	()V
    //   383: astore 21
    //   385: aload_0
    //   386: new 99	java/util/zip/ZipEntry
    //   389: dup
    //   390: new 45	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   397: aload 21
    //   399: invokevirtual 152	java/util/Date:getTime	()J
    //   402: invokestatic 156	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   405: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc 158
    //   410: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokespecial 105	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   419: invokevirtual 109	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   422: goto -132 -> 290
    //   425: astore 7
    //   427: aconst_null
    //   428: astore 4
    //   430: goto -86 -> 344
    //   433: astore 6
    //   435: aload 4
    //   437: invokestatic 126	com/xiaomi/a/a/b/a:a	(Ljava/io/InputStream;)V
    //   440: aload 6
    //   442: athrow
    //   443: astore 17
    //   445: aload 15
    //   447: astore 4
    //   449: aload 17
    //   451: astore 6
    //   453: goto -18 -> 435
    //   456: iconst_0
    //   457: istore 10
    //   459: goto -380 -> 79
    //
    // Exception table:
    //   from	to	target	type
    //   300	307	334	java/io/IOException
    //   307	316	334	java/io/IOException
    //   322	331	334	java/io/IOException
    //   13	20	425	java/io/IOException
    //   27	34	425	java/io/IOException
    //   34	72	425	java/io/IOException
    //   79	84	425	java/io/IOException
    //   94	130	425	java/io/IOException
    //   136	142	425	java/io/IOException
    //   145	167	425	java/io/IOException
    //   170	183	425	java/io/IOException
    //   191	196	425	java/io/IOException
    //   206	249	425	java/io/IOException
    //   264	270	425	java/io/IOException
    //   278	290	425	java/io/IOException
    //   290	300	425	java/io/IOException
    //   376	422	425	java/io/IOException
    //   13	20	433	finally
    //   27	34	433	finally
    //   34	72	433	finally
    //   79	84	433	finally
    //   94	130	433	finally
    //   136	142	433	finally
    //   145	167	433	finally
    //   170	183	433	finally
    //   191	196	433	finally
    //   206	249	433	finally
    //   264	270	433	finally
    //   278	290	433	finally
    //   290	300	433	finally
    //   344	370	433	finally
    //   376	422	433	finally
    //   300	307	443	finally
    //   307	316	443	finally
    //   322	331	443	finally
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.b.a
 * JD-Core Version:    0.6.0
 */