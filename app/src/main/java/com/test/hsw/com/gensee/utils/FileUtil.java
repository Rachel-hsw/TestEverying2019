package com.gensee.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public class FileUtil
{
  private static final String CHARSET = "utf-8";
  private static final String TAG = "FileUtil";
  private static final int TIME_OUT = 10000;

  public static void deleteFile(File paramFile)
  {
    if (paramFile == null);
    do
    {
      return;
      if (!paramFile.isFile())
        continue;
      paramFile.delete();
      return;
    }
    while (!paramFile.isDirectory());
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0));
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfFile.length)
      {
        paramFile.delete();
        return;
      }
      deleteFile(arrayOfFile[i]);
    }
  }

  public static void deleteFile(String paramString)
  {
    if (StringUtil.isEmpty(paramString))
      return;
    deleteFile(new File(paramString));
  }

  public static void deleteFileByTime(File paramFile, long paramLong1, long paramLong2)
  {
    if (paramFile == null);
    while (true)
    {
      return;
      if (paramFile.isFile())
      {
        if (paramLong1 - paramFile.lastModified() < paramLong2)
          continue;
        paramFile.delete();
        return;
      }
      if (!paramFile.isDirectory())
        continue;
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile == null) || (arrayOfFile.length <= 0))
        continue;
      for (int i = 0; i < arrayOfFile.length; i++)
        deleteFileByTime(arrayOfFile[i], paramLong1, paramLong2);
    }
  }

  public static String getCachDir(Context paramContext, String paramString)
  {
    File localFile1;
    StringBuilder localStringBuilder;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localFile1 = paramContext.getExternalCacheDir();
      if (localFile1 == null)
        localFile1 = paramContext.getCacheDir();
      localStringBuilder = new StringBuilder(String.valueOf(localFile1.getAbsolutePath())).append(File.separator).append("gensee");
      if (paramString != null)
        break label124;
    }
    label124: for (String str = ""; ; str = File.separator + paramString)
    {
      File localFile2 = new File(str);
      if (!localFile2.exists())
        localFile2.mkdirs();
      return localFile2.getAbsolutePath() + File.separator;
      localFile1 = paramContext.getCacheDir();
      break;
    }
  }

  public static String getFileDir(Context paramContext, String paramString)
  {
    File localFile1;
    StringBuilder localStringBuilder;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localFile1 = paramContext.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
      if (localFile1 == null)
        localFile1 = paramContext.getFilesDir();
      localStringBuilder = new StringBuilder(String.valueOf(localFile1.getAbsolutePath())).append(File.separator).append("gensee");
      if (paramString != null)
        break label127;
    }
    label127: for (String str = ""; ; str = File.separator + paramString)
    {
      File localFile2 = new File(str);
      if (!localFile2.exists())
        localFile2.mkdirs();
      return localFile2.getAbsolutePath() + File.separator;
      localFile1 = paramContext.getFilesDir();
      break;
    }
  }

  // ERROR //
  public static void unzip(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: new 127	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 128	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 132	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   13: astore 7
    //   15: new 22	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 110	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload 7
    //   29: invokeinterface 137 1 0
    //   34: istore 9
    //   36: iload 9
    //   38: ifne +12 -> 50
    //   41: aload_2
    //   42: ifnull +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 140	java/util/zip/ZipFile:close	()V
    //   49: return
    //   50: aload 7
    //   52: invokeinterface 144 1 0
    //   57: checkcast 146	java/util/zip/ZipEntry
    //   60: astore 10
    //   62: aload 10
    //   64: invokevirtual 149	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   67: astore 11
    //   69: aload 10
    //   71: invokevirtual 150	java/util/zip/ZipEntry:isDirectory	()Z
    //   74: ifeq +95 -> 169
    //   77: aload 10
    //   79: invokevirtual 149	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   82: astore 30
    //   84: aload 30
    //   86: iconst_0
    //   87: iconst_m1
    //   88: aload 30
    //   90: invokevirtual 154	java/lang/String:length	()I
    //   93: iadd
    //   94: invokevirtual 158	java/lang/String:substring	(II)Ljava/lang/String;
    //   97: astore 31
    //   99: new 22	java/io/File
    //   102: dup
    //   103: new 82	java/lang/StringBuilder
    //   106: dup
    //   107: aload_1
    //   108: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   111: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: getstatic 93	java/io/File:separator	Ljava/lang/String;
    //   117: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload 31
    //   122: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   131: invokevirtual 110	java/io/File:mkdirs	()Z
    //   134: pop
    //   135: aconst_null
    //   136: astore 25
    //   138: aconst_null
    //   139: astore 24
    //   141: aload 24
    //   143: ifnull +8 -> 151
    //   146: aload 24
    //   148: invokevirtual 161	java/io/InputStream:close	()V
    //   151: aload 25
    //   153: ifnull -126 -> 27
    //   156: aload 25
    //   158: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   161: goto -134 -> 27
    //   164: astore 28
    //   166: goto -139 -> 27
    //   169: aload 11
    //   171: ldc 166
    //   173: invokevirtual 170	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   176: istore 18
    //   178: iload 18
    //   180: iconst_m1
    //   181: if_icmpeq +45 -> 226
    //   184: new 22	java/io/File
    //   187: dup
    //   188: new 82	java/lang/StringBuilder
    //   191: dup
    //   192: aload_1
    //   193: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   196: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: getstatic 93	java/io/File:separator	Ljava/lang/String;
    //   202: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 11
    //   207: iconst_0
    //   208: iload 18
    //   210: invokevirtual 158	java/lang/String:substring	(II)Ljava/lang/String;
    //   213: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   222: invokevirtual 110	java/io/File:mkdirs	()Z
    //   225: pop
    //   226: aload 11
    //   228: ldc 172
    //   230: invokevirtual 170	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   233: istore 20
    //   235: iload 20
    //   237: iconst_m1
    //   238: if_icmpeq +45 -> 283
    //   241: new 22	java/io/File
    //   244: dup
    //   245: new 82	java/lang/StringBuilder
    //   248: dup
    //   249: aload_1
    //   250: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   253: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: getstatic 93	java/io/File:separator	Ljava/lang/String;
    //   259: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 11
    //   264: iconst_0
    //   265: iload 20
    //   267: invokevirtual 158	java/lang/String:substring	(II)Ljava/lang/String;
    //   270: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   279: invokevirtual 110	java/io/File:mkdirs	()Z
    //   282: pop
    //   283: new 22	java/io/File
    //   286: dup
    //   287: new 82	java/lang/StringBuilder
    //   290: dup
    //   291: aload_1
    //   292: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   295: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   298: getstatic 93	java/io/File:separator	Ljava/lang/String;
    //   301: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 10
    //   306: invokevirtual 149	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   309: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokespecial 47	java/io/File:<init>	(Ljava/lang/String;)V
    //   318: astore 22
    //   320: aload_2
    //   321: aload 10
    //   323: invokevirtual 176	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   326: astore 23
    //   328: aload 23
    //   330: astore 24
    //   332: new 163	java/io/FileOutputStream
    //   335: dup
    //   336: aload 22
    //   338: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   341: astore 25
    //   343: sipush 1024
    //   346: newarray byte
    //   348: astore 26
    //   350: aload 24
    //   352: aload 26
    //   354: invokevirtual 182	java/io/InputStream:read	([B)I
    //   357: istore 27
    //   359: iload 27
    //   361: iconst_m1
    //   362: if_icmpne +131 -> 493
    //   365: aload 25
    //   367: invokevirtual 185	java/io/FileOutputStream:flush	()V
    //   370: goto -229 -> 141
    //   373: astore 12
    //   375: aload 25
    //   377: astore 13
    //   379: aload 24
    //   381: astore 14
    //   383: aload 12
    //   385: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   388: new 125	java/io/IOException
    //   391: dup
    //   392: new 82	java/lang/StringBuilder
    //   395: dup
    //   396: ldc 190
    //   398: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   401: aload 12
    //   403: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   406: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   415: athrow
    //   416: astore 15
    //   418: aload 14
    //   420: ifnull +8 -> 428
    //   423: aload 14
    //   425: invokevirtual 161	java/io/InputStream:close	()V
    //   428: aload 13
    //   430: ifnull +8 -> 438
    //   433: aload 13
    //   435: invokevirtual 164	java/io/FileOutputStream:close	()V
    //   438: aload 15
    //   440: athrow
    //   441: astore 5
    //   443: aload_2
    //   444: astore 6
    //   446: aload 5
    //   448: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   451: new 125	java/io/IOException
    //   454: dup
    //   455: new 82	java/lang/StringBuilder
    //   458: dup
    //   459: ldc 190
    //   461: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   464: aload 5
    //   466: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   469: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokespecial 192	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   478: athrow
    //   479: astore_3
    //   480: aload 6
    //   482: astore_2
    //   483: aload_2
    //   484: ifnull +7 -> 491
    //   487: aload_2
    //   488: invokevirtual 140	java/util/zip/ZipFile:close	()V
    //   491: aload_3
    //   492: athrow
    //   493: aload 25
    //   495: aload 26
    //   497: iconst_0
    //   498: iload 27
    //   500: invokevirtual 196	java/io/FileOutputStream:write	([BII)V
    //   503: goto -153 -> 350
    //   506: astore 15
    //   508: aload 25
    //   510: astore 13
    //   512: aload 24
    //   514: astore 14
    //   516: goto -98 -> 418
    //   519: astore 17
    //   521: goto -93 -> 428
    //   524: astore 16
    //   526: goto -88 -> 438
    //   529: astore 29
    //   531: goto -380 -> 151
    //   534: astore 4
    //   536: goto -45 -> 491
    //   539: astore 33
    //   541: return
    //   542: astore_3
    //   543: aconst_null
    //   544: astore_2
    //   545: goto -62 -> 483
    //   548: astore_3
    //   549: goto -66 -> 483
    //   552: astore 5
    //   554: aconst_null
    //   555: astore 6
    //   557: goto -111 -> 446
    //   560: astore 15
    //   562: aconst_null
    //   563: astore 13
    //   565: aconst_null
    //   566: astore 14
    //   568: goto -150 -> 418
    //   571: astore 15
    //   573: aload 24
    //   575: astore 14
    //   577: aconst_null
    //   578: astore 13
    //   580: goto -162 -> 418
    //   583: astore 12
    //   585: aconst_null
    //   586: astore 13
    //   588: aconst_null
    //   589: astore 14
    //   591: goto -208 -> 383
    //   594: astore 12
    //   596: aload 24
    //   598: astore 14
    //   600: aconst_null
    //   601: astore 13
    //   603: goto -220 -> 383
    //
    // Exception table:
    //   from	to	target	type
    //   156	161	164	java/io/IOException
    //   343	350	373	java/io/IOException
    //   350	359	373	java/io/IOException
    //   365	370	373	java/io/IOException
    //   493	503	373	java/io/IOException
    //   383	416	416	finally
    //   9	27	441	java/io/IOException
    //   27	36	441	java/io/IOException
    //   50	69	441	java/io/IOException
    //   438	441	441	java/io/IOException
    //   446	479	479	finally
    //   343	350	506	finally
    //   350	359	506	finally
    //   365	370	506	finally
    //   493	503	506	finally
    //   423	428	519	java/io/IOException
    //   433	438	524	java/io/IOException
    //   146	151	529	java/io/IOException
    //   487	491	534	java/io/IOException
    //   45	49	539	java/io/IOException
    //   0	9	542	finally
    //   9	27	548	finally
    //   27	36	548	finally
    //   50	69	548	finally
    //   146	151	548	finally
    //   156	161	548	finally
    //   423	428	548	finally
    //   433	438	548	finally
    //   438	441	548	finally
    //   0	9	552	java/io/IOException
    //   69	135	560	finally
    //   169	178	560	finally
    //   184	226	560	finally
    //   226	235	560	finally
    //   241	283	560	finally
    //   283	328	560	finally
    //   332	343	571	finally
    //   69	135	583	java/io/IOException
    //   169	178	583	java/io/IOException
    //   184	226	583	java/io/IOException
    //   226	235	583	java/io/IOException
    //   241	283	583	java/io/IOException
    //   283	328	583	java/io/IOException
    //   332	343	594	java/io/IOException
  }

  // ERROR //
  public static String uploadFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: invokestatic 206	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   3: invokevirtual 207	java/util/UUID:toString	()Ljava/lang/String;
    //   6: astore_2
    //   7: new 209	java/net/URL
    //   10: dup
    //   11: aload_1
    //   12: invokespecial 210	java/net/URL:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 214	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: checkcast 216	java/net/HttpURLConnection
    //   21: astore 8
    //   23: aload 8
    //   25: sipush 10000
    //   28: invokevirtual 220	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   31: aload 8
    //   33: sipush 10000
    //   36: invokevirtual 223	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   39: aload 8
    //   41: iconst_1
    //   42: invokevirtual 227	java/net/HttpURLConnection:setDoInput	(Z)V
    //   45: aload 8
    //   47: iconst_1
    //   48: invokevirtual 230	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   51: aload 8
    //   53: ldc 232
    //   55: invokevirtual 235	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   58: aload 8
    //   60: ldc 237
    //   62: ldc 8
    //   64: invokevirtual 240	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload 8
    //   69: ldc 242
    //   71: ldc 244
    //   73: invokevirtual 240	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload 8
    //   78: ldc 246
    //   80: new 82	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 248
    //   86: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   89: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: ldc 250
    //   94: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokevirtual 240	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: aload_0
    //   108: ifnull +404 -> 512
    //   111: new 252	java/io/DataOutputStream
    //   114: dup
    //   115: aload 8
    //   117: invokevirtual 256	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   120: invokespecial 259	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   123: astore 9
    //   125: new 261	java/lang/StringBuffer
    //   128: dup
    //   129: invokespecial 262	java/lang/StringBuffer:<init>	()V
    //   132: astore 10
    //   134: aload 10
    //   136: ldc_w 264
    //   139: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   142: pop
    //   143: aload 10
    //   145: aload_2
    //   146: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   149: pop
    //   150: aload 10
    //   152: ldc_w 269
    //   155: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   158: pop
    //   159: aload 10
    //   161: new 82	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 271
    //   168: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: invokevirtual 272	java/io/File:getName	()Ljava/lang/String;
    //   175: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 274
    //   181: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: ldc_w 269
    //   187: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   196: pop
    //   197: aload 10
    //   199: new 82	java/lang/StringBuilder
    //   202: dup
    //   203: ldc_w 276
    //   206: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: ldc_w 269
    //   212: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: aload 10
    //   224: ldc_w 269
    //   227: invokevirtual 267	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   230: pop
    //   231: aload 9
    //   233: aload 10
    //   235: invokevirtual 277	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   238: invokevirtual 281	java/lang/String:getBytes	()[B
    //   241: invokevirtual 284	java/io/DataOutputStream:write	([B)V
    //   244: new 286	java/io/FileInputStream
    //   247: dup
    //   248: aload_0
    //   249: invokespecial 287	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   252: astore 17
    //   254: sipush 1024
    //   257: newarray byte
    //   259: astore 18
    //   261: aload 17
    //   263: aload 18
    //   265: invokevirtual 182	java/io/InputStream:read	([B)I
    //   268: istore 19
    //   270: iload 19
    //   272: iconst_m1
    //   273: if_icmpne +168 -> 441
    //   276: aload 17
    //   278: invokevirtual 161	java/io/InputStream:close	()V
    //   281: aload 9
    //   283: ldc_w 269
    //   286: invokevirtual 281	java/lang/String:getBytes	()[B
    //   289: invokevirtual 284	java/io/DataOutputStream:write	([B)V
    //   292: aload 9
    //   294: new 82	java/lang/StringBuilder
    //   297: dup
    //   298: ldc_w 264
    //   301: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   304: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   307: aload_2
    //   308: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: ldc_w 264
    //   314: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc_w 269
    //   320: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokevirtual 281	java/lang/String:getBytes	()[B
    //   329: invokevirtual 284	java/io/DataOutputStream:write	([B)V
    //   332: aload 9
    //   334: invokevirtual 288	java/io/DataOutputStream:flush	()V
    //   337: aload 8
    //   339: invokevirtual 291	java/net/HttpURLConnection:getResponseCode	()I
    //   342: istore 20
    //   344: ldc 11
    //   346: new 82	java/lang/StringBuilder
    //   349: dup
    //   350: ldc_w 293
    //   353: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   356: iload 20
    //   358: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 301	com/gensee/utils/GenseeLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: ldc 11
    //   369: ldc_w 303
    //   372: invokestatic 301	com/gensee/utils/GenseeLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload 8
    //   377: invokevirtual 306	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   380: astore 21
    //   382: new 261	java/lang/StringBuffer
    //   385: dup
    //   386: invokespecial 262	java/lang/StringBuffer:<init>	()V
    //   389: astore 22
    //   391: aload 21
    //   393: invokevirtual 308	java/io/InputStream:read	()I
    //   396: istore 23
    //   398: iload 23
    //   400: iconst_m1
    //   401: if_icmpne +70 -> 471
    //   404: aload 22
    //   406: invokevirtual 277	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   409: astore 24
    //   411: aload 24
    //   413: astore 4
    //   415: ldc 11
    //   417: new 82	java/lang/StringBuilder
    //   420: dup
    //   421: ldc_w 310
    //   424: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   427: aload 4
    //   429: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 301	com/gensee/utils/GenseeLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload 4
    //   440: areturn
    //   441: aload 9
    //   443: aload 18
    //   445: iconst_0
    //   446: iload 19
    //   448: invokevirtual 311	java/io/DataOutputStream:write	([BII)V
    //   451: goto -190 -> 261
    //   454: astore 6
    //   456: aconst_null
    //   457: astore 4
    //   459: aload 6
    //   461: astore 7
    //   463: aload 7
    //   465: invokevirtual 312	java/net/MalformedURLException:printStackTrace	()V
    //   468: aload 4
    //   470: areturn
    //   471: iload 23
    //   473: i2c
    //   474: istore 25
    //   476: aload 22
    //   478: iload 25
    //   480: invokevirtual 315	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   483: pop
    //   484: goto -93 -> 391
    //   487: astore_3
    //   488: aconst_null
    //   489: astore 4
    //   491: aload_3
    //   492: astore 5
    //   494: aload 5
    //   496: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   499: aload 4
    //   501: areturn
    //   502: astore 5
    //   504: goto -10 -> 494
    //   507: astore 7
    //   509: goto -46 -> 463
    //   512: aconst_null
    //   513: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   7	107	454	java/net/MalformedURLException
    //   111	261	454	java/net/MalformedURLException
    //   261	270	454	java/net/MalformedURLException
    //   276	391	454	java/net/MalformedURLException
    //   391	398	454	java/net/MalformedURLException
    //   404	411	454	java/net/MalformedURLException
    //   441	451	454	java/net/MalformedURLException
    //   476	484	454	java/net/MalformedURLException
    //   7	107	487	java/io/IOException
    //   111	261	487	java/io/IOException
    //   261	270	487	java/io/IOException
    //   276	391	487	java/io/IOException
    //   391	398	487	java/io/IOException
    //   404	411	487	java/io/IOException
    //   441	451	487	java/io/IOException
    //   476	484	487	java/io/IOException
    //   415	438	502	java/io/IOException
    //   415	438	507	java/net/MalformedURLException
  }

  public static File zip(File paramFile, ZipOutputStream paramZipOutputStream)
  {
    try
    {
      if (paramFile.isFile())
      {
        zipFileOrDirectory(paramZipOutputStream, paramFile, "");
      }
      else
      {
        File[] arrayOfFile = paramFile.listFiles();
        for (int i = 0; i < arrayOfFile.length; i++)
          zipFileOrDirectory(paramZipOutputStream, arrayOfFile[i], "");
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }

  // ERROR //
  private static void zipFileOrDirectory(ZipOutputStream paramZipOutputStream, File paramFile, String paramString)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_1
    //   6: invokevirtual 32	java/io/File:isDirectory	()Z
    //   9: ifne +125 -> 134
    //   12: aload_1
    //   13: invokevirtual 272	java/io/File:getName	()Ljava/lang/String;
    //   16: pop
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore 13
    //   24: new 286	java/io/FileInputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 287	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore 6
    //   34: aload_0
    //   35: new 146	java/util/zip/ZipEntry
    //   38: dup
    //   39: new 82	java/lang/StringBuilder
    //   42: dup
    //   43: aload_2
    //   44: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 272	java/io/File:getName	()Ljava/lang/String;
    //   54: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokespecial 322	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   63: invokevirtual 328	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   66: aload 6
    //   68: aload 13
    //   70: invokevirtual 329	java/io/FileInputStream:read	([B)I
    //   73: istore 14
    //   75: iload 14
    //   77: iconst_m1
    //   78: if_icmpne +18 -> 96
    //   81: aload_0
    //   82: invokevirtual 332	java/util/zip/ZipOutputStream:closeEntry	()V
    //   85: aload 6
    //   87: ifnull +8 -> 95
    //   90: aload 6
    //   92: invokevirtual 333	java/io/FileInputStream:close	()V
    //   95: return
    //   96: aload_0
    //   97: aload 13
    //   99: iconst_0
    //   100: iload 14
    //   102: invokevirtual 334	java/util/zip/ZipOutputStream:write	([BII)V
    //   105: goto -39 -> 66
    //   108: astore 5
    //   110: aload 5
    //   112: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   115: aload 6
    //   117: ifnull -22 -> 95
    //   120: aload 6
    //   122: invokevirtual 333	java/io/FileInputStream:close	()V
    //   125: return
    //   126: astore 9
    //   128: aload 9
    //   130: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   133: return
    //   134: aload_1
    //   135: invokevirtual 36	java/io/File:listFiles	()[Ljava/io/File;
    //   138: astore 10
    //   140: iload_3
    //   141: aload 10
    //   143: arraylength
    //   144: if_icmplt +9 -> 153
    //   147: aconst_null
    //   148: astore 6
    //   150: goto -65 -> 85
    //   153: aload_0
    //   154: aload 10
    //   156: iload_3
    //   157: aaload
    //   158: new 82	java/lang/StringBuilder
    //   161: dup
    //   162: aload_2
    //   163: invokestatic 89	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   166: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   169: aload_1
    //   170: invokevirtual 272	java/io/File:getName	()Ljava/lang/String;
    //   173: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 172
    //   178: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 321	com/gensee/utils/FileUtil:zipFileOrDirectory	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;)V
    //   187: iinc 3 1
    //   190: goto -50 -> 140
    //   193: astore 7
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 333	java/io/FileInputStream:close	()V
    //   205: aload 7
    //   207: athrow
    //   208: astore 8
    //   210: aload 8
    //   212: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   215: goto -10 -> 205
    //   218: astore 11
    //   220: aload 11
    //   222: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   225: return
    //   226: astore 7
    //   228: aload 6
    //   230: astore 4
    //   232: goto -37 -> 195
    //   235: astore 5
    //   237: aconst_null
    //   238: astore 6
    //   240: goto -130 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   34	66	108	java/io/IOException
    //   66	75	108	java/io/IOException
    //   81	85	108	java/io/IOException
    //   96	105	108	java/io/IOException
    //   120	125	126	java/io/IOException
    //   5	34	193	finally
    //   134	140	193	finally
    //   140	147	193	finally
    //   153	187	193	finally
    //   200	205	208	java/io/IOException
    //   90	95	218	java/io/IOException
    //   34	66	226	finally
    //   66	75	226	finally
    //   81	85	226	finally
    //   96	105	226	finally
    //   110	115	226	finally
    //   5	34	235	java/io/IOException
    //   134	140	235	java/io/IOException
    //   140	147	235	java/io/IOException
    //   153	187	235	java/io/IOException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.utils.FileUtil
 * JD-Core Version:    0.6.0
 */