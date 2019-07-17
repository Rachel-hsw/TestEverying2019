package com.xiaomi.a.a.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.a.a.g.c;
import java.io.BufferedReader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class d
{
  public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
  public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

  public static int a(Context paramContext)
  {
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return -1;
    }
    catch (Exception localException1)
    {
      return -1;
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return -1;
    }
    catch (Exception localException2)
    {
      return -1;
    }
    return localNetworkInfo.getType();
  }

  // ERROR //
  public static b a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 61	com/xiaomi/a/a/e/b
    //   6: dup
    //   7: invokespecial 64	com/xiaomi/a/a/e/b:<init>	()V
    //   10: astore 6
    //   12: aload_0
    //   13: aload_1
    //   14: invokestatic 67	com/xiaomi/a/a/e/d:b	(Ljava/lang/String;)Ljava/net/URL;
    //   17: invokestatic 70	com/xiaomi/a/a/e/d:b	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   20: astore 15
    //   22: aload 15
    //   24: sipush 10000
    //   27: invokevirtual 76	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   30: aload 15
    //   32: sipush 15000
    //   35: invokevirtual 79	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   38: aload_2
    //   39: ifnonnull +6 -> 45
    //   42: ldc 81
    //   44: astore_2
    //   45: aload 15
    //   47: aload_2
    //   48: invokevirtual 85	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   51: aload_3
    //   52: ifnull +104 -> 156
    //   55: aload_3
    //   56: invokeinterface 91 1 0
    //   61: invokeinterface 97 1 0
    //   66: astore 16
    //   68: aload 16
    //   70: invokeinterface 103 1 0
    //   75: ifeq +81 -> 156
    //   78: aload 16
    //   80: invokeinterface 107 1 0
    //   85: checkcast 109	java/lang/String
    //   88: astore 33
    //   90: aload 15
    //   92: aload 33
    //   94: aload_3
    //   95: aload 33
    //   97: invokeinterface 113 2 0
    //   102: checkcast 109	java/lang/String
    //   105: invokevirtual 117	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -40 -> 68
    //   111: astore 12
    //   113: aconst_null
    //   114: astore 13
    //   116: aload 12
    //   118: athrow
    //   119: astore 7
    //   121: aload 13
    //   123: astore 14
    //   125: aload 5
    //   127: astore 8
    //   129: aload 14
    //   131: astore 5
    //   133: aload 8
    //   135: ifnull +8 -> 143
    //   138: aload 8
    //   140: invokevirtual 122	java/io/OutputStream:close	()V
    //   143: aload 5
    //   145: ifnull +8 -> 153
    //   148: aload 5
    //   150: invokevirtual 125	java/io/BufferedReader:close	()V
    //   153: aload 7
    //   155: athrow
    //   156: aload 4
    //   158: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifne +413 -> 574
    //   164: aload 15
    //   166: iconst_1
    //   167: invokevirtual 135	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   170: aload 4
    //   172: invokevirtual 139	java/lang/String:getBytes	()[B
    //   175: astore 31
    //   177: aload 15
    //   179: invokevirtual 143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   182: astore 32
    //   184: aload 32
    //   186: astore 8
    //   188: aload 8
    //   190: aload 31
    //   192: iconst_0
    //   193: aload 31
    //   195: arraylength
    //   196: invokevirtual 147	java/io/OutputStream:write	([BII)V
    //   199: aload 8
    //   201: invokevirtual 150	java/io/OutputStream:flush	()V
    //   204: aload 8
    //   206: invokevirtual 122	java/io/OutputStream:close	()V
    //   209: aload 6
    //   211: aload 15
    //   213: invokevirtual 153	java/net/HttpURLConnection:getResponseCode	()I
    //   216: putfield 156	com/xiaomi/a/a/e/b:a	I
    //   219: ldc 158
    //   221: new 160	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   228: ldc 163
    //   230: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload 6
    //   235: getfield 156	com/xiaomi/a/a/e/b:a	I
    //   238: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 180	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: iconst_0
    //   249: istore 18
    //   251: aload 15
    //   253: iload 18
    //   255: invokevirtual 184	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   258: astore 19
    //   260: aload 15
    //   262: iload 18
    //   264: invokevirtual 187	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   267: astore 20
    //   269: aload 19
    //   271: ifnonnull +94 -> 365
    //   274: aload 20
    //   276: ifnonnull +89 -> 365
    //   279: new 124	java/io/BufferedReader
    //   282: dup
    //   283: new 189	java/io/InputStreamReader
    //   286: dup
    //   287: new 191	com/xiaomi/a/a/e/d$a
    //   290: dup
    //   291: aload 15
    //   293: invokevirtual 195	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   296: invokespecial 198	com/xiaomi/a/a/e/d$a:<init>	(Ljava/io/InputStream;)V
    //   299: invokespecial 199	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   302: invokespecial 202	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   305: astore 13
    //   307: aload 13
    //   309: invokevirtual 205	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   312: astore 22
    //   314: new 207	java/lang/StringBuffer
    //   317: dup
    //   318: invokespecial 208	java/lang/StringBuffer:<init>	()V
    //   321: astore 23
    //   323: ldc 210
    //   325: invokestatic 216	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   328: astore 24
    //   330: aload 22
    //   332: ifnull +115 -> 447
    //   335: aload 23
    //   337: aload 22
    //   339: invokevirtual 219	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   342: pop
    //   343: aload 23
    //   345: aload 24
    //   347: invokevirtual 219	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   350: pop
    //   351: aload 13
    //   353: invokevirtual 205	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   356: astore 27
    //   358: aload 27
    //   360: astore 22
    //   362: goto -32 -> 330
    //   365: aload 6
    //   367: getfield 222	com/xiaomi/a/a/e/b:b	Ljava/util/Map;
    //   370: aload 19
    //   372: aload 20
    //   374: invokeinterface 226 3 0
    //   379: pop
    //   380: iconst_1
    //   381: iload 18
    //   383: iconst_1
    //   384: iadd
    //   385: iadd
    //   386: istore 18
    //   388: goto -137 -> 251
    //   391: astore 30
    //   393: new 124	java/io/BufferedReader
    //   396: dup
    //   397: new 189	java/io/InputStreamReader
    //   400: dup
    //   401: new 191	com/xiaomi/a/a/e/d$a
    //   404: dup
    //   405: aload 15
    //   407: invokevirtual 229	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   410: invokespecial 198	com/xiaomi/a/a/e/d$a:<init>	(Ljava/io/InputStream;)V
    //   413: invokespecial 199	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   416: invokespecial 202	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   419: astore 13
    //   421: goto -114 -> 307
    //   424: astore 11
    //   426: aconst_null
    //   427: astore 8
    //   429: new 57	java/io/IOException
    //   432: dup
    //   433: aload 11
    //   435: invokevirtual 232	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   438: invokespecial 234	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   441: athrow
    //   442: astore 7
    //   444: goto -311 -> 133
    //   447: aload 6
    //   449: aload 23
    //   451: invokevirtual 235	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   454: putfield 238	com/xiaomi/a/a/e/b:c	Ljava/lang/String;
    //   457: aload 13
    //   459: invokevirtual 125	java/io/BufferedReader:close	()V
    //   462: iconst_0
    //   463: ifeq +7 -> 470
    //   466: aconst_null
    //   467: invokevirtual 122	java/io/OutputStream:close	()V
    //   470: iconst_0
    //   471: ifeq +7 -> 478
    //   474: aconst_null
    //   475: invokevirtual 125	java/io/BufferedReader:close	()V
    //   478: aload 6
    //   480: areturn
    //   481: astore 28
    //   483: ldc 158
    //   485: ldc 240
    //   487: aload 28
    //   489: invokestatic 244	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   492: pop
    //   493: aload 6
    //   495: areturn
    //   496: astore 9
    //   498: ldc 158
    //   500: ldc 240
    //   502: aload 9
    //   504: invokestatic 244	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   507: pop
    //   508: goto -355 -> 153
    //   511: astore 7
    //   513: aconst_null
    //   514: astore 8
    //   516: aconst_null
    //   517: astore 5
    //   519: goto -386 -> 133
    //   522: astore 7
    //   524: aload 13
    //   526: astore 5
    //   528: aconst_null
    //   529: astore 8
    //   531: goto -398 -> 133
    //   534: astore 11
    //   536: aconst_null
    //   537: astore 5
    //   539: goto -110 -> 429
    //   542: astore 11
    //   544: aload 13
    //   546: astore 5
    //   548: aconst_null
    //   549: astore 8
    //   551: goto -122 -> 429
    //   554: astore 12
    //   556: aload 8
    //   558: astore 5
    //   560: aconst_null
    //   561: astore 13
    //   563: goto -447 -> 116
    //   566: astore 12
    //   568: aconst_null
    //   569: astore 5
    //   571: goto -455 -> 116
    //   574: goto -365 -> 209
    //
    // Exception table:
    //   from	to	target	type
    //   12	38	111	java/io/IOException
    //   45	51	111	java/io/IOException
    //   55	68	111	java/io/IOException
    //   68	108	111	java/io/IOException
    //   156	184	111	java/io/IOException
    //   209	248	111	java/io/IOException
    //   251	269	111	java/io/IOException
    //   365	380	111	java/io/IOException
    //   393	421	111	java/io/IOException
    //   116	119	119	finally
    //   279	307	391	java/io/IOException
    //   12	38	424	java/lang/Throwable
    //   45	51	424	java/lang/Throwable
    //   55	68	424	java/lang/Throwable
    //   68	108	424	java/lang/Throwable
    //   156	184	424	java/lang/Throwable
    //   209	248	424	java/lang/Throwable
    //   251	269	424	java/lang/Throwable
    //   279	307	424	java/lang/Throwable
    //   365	380	424	java/lang/Throwable
    //   393	421	424	java/lang/Throwable
    //   188	209	442	finally
    //   429	442	442	finally
    //   466	470	481	java/io/IOException
    //   474	478	481	java/io/IOException
    //   138	143	496	java/io/IOException
    //   148	153	496	java/io/IOException
    //   12	38	511	finally
    //   45	51	511	finally
    //   55	68	511	finally
    //   68	108	511	finally
    //   156	184	511	finally
    //   209	248	511	finally
    //   251	269	511	finally
    //   279	307	511	finally
    //   365	380	511	finally
    //   393	421	511	finally
    //   307	330	522	finally
    //   335	358	522	finally
    //   447	462	522	finally
    //   188	209	534	java/lang/Throwable
    //   307	330	542	java/lang/Throwable
    //   335	358	542	java/lang/Throwable
    //   447	462	542	java/lang/Throwable
    //   188	209	554	java/io/IOException
    //   307	330	566	java/io/IOException
    //   335	358	566	java/io/IOException
    //   447	462	566	java/io/IOException
  }

  public static b a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    return a(paramContext, paramString, "POST", null, a(paramMap));
  }

  public static InputStream a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2)
  {
    return a(paramContext, paramURL, paramBoolean, paramString1, paramString2, null, null);
  }

  public static InputStream a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2, Map<String, String> paramMap, b paramb)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context");
    if (paramURL == null)
      throw new IllegalArgumentException("url");
    URL localURL;
    if (!paramBoolean)
      localURL = new URL(a(paramURL.toString()));
    while (true)
    {
      try
      {
        HttpURLConnection.setFollowRedirects(true);
        localHttpURLConnection = b(paramContext, localURL);
        localHttpURLConnection.setConnectTimeout(10000);
        localHttpURLConnection.setReadTimeout(15000);
        if (TextUtils.isEmpty(paramString1))
          continue;
        localHttpURLConnection.setRequestProperty("User-Agent", paramString1);
        if (paramString2 == null)
          continue;
        localHttpURLConnection.setRequestProperty("Cookie", paramString2);
        if (paramMap == null)
          continue;
        Iterator localIterator = paramMap.keySet().iterator();
        if (!localIterator.hasNext())
          continue;
        String str3 = (String)localIterator.next();
        localHttpURLConnection.setRequestProperty(str3, (String)paramMap.get(str3));
        continue;
      }
      catch (IOException localIOException)
      {
        HttpURLConnection localHttpURLConnection;
        throw localIOException;
        if ((paramb == null) || ((!paramURL.getProtocol().equals("http")) && (!paramURL.getProtocol().equals("https"))))
          continue;
        paramb.a = localHttpURLConnection.getResponseCode();
        if (paramb.b != null)
          break label340;
        paramb.b = new HashMap();
        break label340;
        String str1 = localHttpURLConnection.getHeaderFieldKey(i);
        String str2 = localHttpURLConnection.getHeaderField(i);
        if ((str1 == null) && (str2 == null))
          return new a(localHttpURLConnection.getInputStream());
        if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          break label346;
        paramb.b.put(str1, str2);
      }
      catch (Throwable localThrowable)
      {
        throw new IOException(localThrowable.getMessage());
      }
      localURL = paramURL;
      continue;
      label340: int i = 0;
      continue;
      label346: i++;
    }
  }

  public static String a(Context paramContext, URL paramURL)
  {
    return a(paramContext, paramURL, false, null, "UTF-8", null);
  }

  public static String a(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    InputStream localInputStream = null;
    StringBuilder localStringBuilder;
    try
    {
      localInputStream = a(paramContext, paramURL, paramBoolean, paramString1, paramString3);
      localStringBuilder = new StringBuilder(1024);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream, paramString2));
      char[] arrayOfChar = new char[4096];
      while (true)
      {
        int i = localBufferedReader.read(arrayOfChar);
        if (-1 == i)
          break;
        localStringBuilder.append(arrayOfChar, 0, i);
      }
    }
    finally
    {
      if (localInputStream == null);
    }
    try
    {
      localInputStream.close();
      throw localObject;
      if (localInputStream != null);
      try
      {
        localInputStream.close();
        return localStringBuilder.toString();
      }
      catch (IOException localIOException2)
      {
        while (true)
          Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + localIOException2.toString());
      }
    }
    catch (IOException localIOException1)
    {
      while (true)
        Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + localIOException1.toString());
    }
  }

  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new String();
      String str = String.format("%sbe988a6134bc8254465424e5a70ef037", new Object[] { paramString });
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = c.a(str);
      return String.format("%s&key=%s", arrayOfObject);
    }
    return null;
  }

  // ERROR //
  public static String a(String paramString1, Map<String, String> paramMap, java.io.File paramFile, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: invokevirtual 340	java/io/File:exists	()Z
    //   7: ifne +9 -> 16
    //   10: aconst_null
    //   11: astore 24
    //   13: aload 24
    //   15: areturn
    //   16: aload_2
    //   17: invokevirtual 343	java/io/File:getName	()Ljava/lang/String;
    //   20: astore 5
    //   22: new 265	java/net/URL
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 269	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 347	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   33: checkcast 72	java/net/HttpURLConnection
    //   36: astore 15
    //   38: aload 15
    //   40: sipush 15000
    //   43: invokevirtual 79	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   46: aload 15
    //   48: sipush 10000
    //   51: invokevirtual 76	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   54: aload 15
    //   56: iconst_1
    //   57: invokevirtual 350	java/net/HttpURLConnection:setDoInput	(Z)V
    //   60: aload 15
    //   62: iconst_1
    //   63: invokevirtual 135	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   66: aload 15
    //   68: iconst_0
    //   69: invokevirtual 353	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   72: aload 15
    //   74: ldc 247
    //   76: invokevirtual 85	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   79: aload 15
    //   81: ldc_w 355
    //   84: ldc_w 357
    //   87: invokevirtual 117	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload 15
    //   92: ldc_w 359
    //   95: ldc_w 361
    //   98: invokevirtual 117	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload_1
    //   102: ifnull +120 -> 222
    //   105: aload_1
    //   106: invokeinterface 364 1 0
    //   111: invokeinterface 97 1 0
    //   116: astore 16
    //   118: aload 16
    //   120: invokeinterface 103 1 0
    //   125: ifeq +97 -> 222
    //   128: aload 16
    //   130: invokeinterface 107 1 0
    //   135: checkcast 366	java/util/Map$Entry
    //   138: astore 27
    //   140: aload 15
    //   142: aload 27
    //   144: invokeinterface 369 1 0
    //   149: checkcast 109	java/lang/String
    //   152: aload 27
    //   154: invokeinterface 372 1 0
    //   159: checkcast 109	java/lang/String
    //   162: invokevirtual 117	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: goto -47 -> 118
    //   168: astore 12
    //   170: aconst_null
    //   171: astore 13
    //   173: aconst_null
    //   174: astore 14
    //   176: aload 12
    //   178: athrow
    //   179: astore 6
    //   181: aload 14
    //   183: astore 8
    //   185: aload 13
    //   187: astore 7
    //   189: aload 8
    //   191: ifnull +8 -> 199
    //   194: aload 8
    //   196: invokevirtual 375	java/io/FileInputStream:close	()V
    //   199: aload 7
    //   201: ifnull +8 -> 209
    //   204: aload 7
    //   206: invokevirtual 378	java/io/DataOutputStream:close	()V
    //   209: aload 4
    //   211: ifnull +8 -> 219
    //   214: aload 4
    //   216: invokevirtual 125	java/io/BufferedReader:close	()V
    //   219: aload 6
    //   221: athrow
    //   222: aload 15
    //   224: bipush 77
    //   226: aload 5
    //   228: invokevirtual 381	java/lang/String:length	()I
    //   231: iadd
    //   232: aload_2
    //   233: invokevirtual 384	java/io/File:length	()J
    //   236: l2i
    //   237: iadd
    //   238: aload_3
    //   239: invokevirtual 381	java/lang/String:length	()I
    //   242: iadd
    //   243: invokevirtual 387	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   246: new 377	java/io/DataOutputStream
    //   249: dup
    //   250: aload 15
    //   252: invokevirtual 143	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   255: invokespecial 390	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   258: astore 7
    //   260: aload 7
    //   262: ldc_w 392
    //   265: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   268: aload 7
    //   270: new 160	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 397
    //   280: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_3
    //   284: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 399
    //   290: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_2
    //   294: invokevirtual 343	java/io/File:getName	()Ljava/lang/String;
    //   297: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 401
    //   303: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: ldc_w 403
    //   309: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 174	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   318: aload 7
    //   320: ldc_w 403
    //   323: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   326: new 374	java/io/FileInputStream
    //   329: dup
    //   330: aload_2
    //   331: invokespecial 406	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   334: astore 8
    //   336: sipush 1024
    //   339: newarray byte
    //   341: astore 17
    //   343: aload 8
    //   345: aload 17
    //   347: invokevirtual 409	java/io/FileInputStream:read	([B)I
    //   350: istore 18
    //   352: iload 18
    //   354: iconst_m1
    //   355: if_icmpeq +21 -> 376
    //   358: aload 7
    //   360: aload 17
    //   362: iconst_0
    //   363: iload 18
    //   365: invokevirtual 410	java/io/DataOutputStream:write	([BII)V
    //   368: aload 7
    //   370: invokevirtual 411	java/io/DataOutputStream:flush	()V
    //   373: goto -30 -> 343
    //   376: aload 7
    //   378: ldc_w 403
    //   381: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   384: aload 7
    //   386: ldc_w 413
    //   389: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   392: aload 7
    //   394: ldc_w 415
    //   397: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   400: aload 7
    //   402: ldc_w 413
    //   405: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   408: aload 7
    //   410: ldc_w 403
    //   413: invokevirtual 395	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   416: aload 7
    //   418: invokevirtual 411	java/io/DataOutputStream:flush	()V
    //   421: new 207	java/lang/StringBuffer
    //   424: dup
    //   425: invokespecial 208	java/lang/StringBuffer:<init>	()V
    //   428: astore 19
    //   430: new 124	java/io/BufferedReader
    //   433: dup
    //   434: new 189	java/io/InputStreamReader
    //   437: dup
    //   438: new 191	com/xiaomi/a/a/e/d$a
    //   441: dup
    //   442: aload 15
    //   444: invokevirtual 195	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   447: invokespecial 198	com/xiaomi/a/a/e/d$a:<init>	(Ljava/io/InputStream;)V
    //   450: invokespecial 199	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   453: invokespecial 202	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   456: astore 20
    //   458: aload 20
    //   460: invokevirtual 205	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   463: astore 21
    //   465: aload 21
    //   467: ifnull +14 -> 481
    //   470: aload 19
    //   472: aload 21
    //   474: invokevirtual 219	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   477: pop
    //   478: goto -20 -> 458
    //   481: aload 19
    //   483: invokevirtual 235	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   486: astore 23
    //   488: aload 23
    //   490: astore 24
    //   492: aload 8
    //   494: ifnull +8 -> 502
    //   497: aload 8
    //   499: invokevirtual 375	java/io/FileInputStream:close	()V
    //   502: aload 7
    //   504: ifnull +8 -> 512
    //   507: aload 7
    //   509: invokevirtual 378	java/io/DataOutputStream:close	()V
    //   512: aload 20
    //   514: ifnull -501 -> 13
    //   517: aload 20
    //   519: invokevirtual 125	java/io/BufferedReader:close	()V
    //   522: aload 24
    //   524: areturn
    //   525: astore 25
    //   527: ldc 158
    //   529: ldc 240
    //   531: aload 25
    //   533: invokestatic 244	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   536: pop
    //   537: aload 24
    //   539: areturn
    //   540: astore 11
    //   542: aconst_null
    //   543: astore 7
    //   545: aconst_null
    //   546: astore 8
    //   548: new 57	java/io/IOException
    //   551: dup
    //   552: aload 11
    //   554: invokevirtual 232	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   557: invokespecial 234	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   560: athrow
    //   561: astore 6
    //   563: goto -374 -> 189
    //   566: astore 9
    //   568: ldc 158
    //   570: ldc 240
    //   572: aload 9
    //   574: invokestatic 244	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   577: pop
    //   578: goto -359 -> 219
    //   581: astore 6
    //   583: aconst_null
    //   584: astore 7
    //   586: aconst_null
    //   587: astore 4
    //   589: aconst_null
    //   590: astore 8
    //   592: goto -403 -> 189
    //   595: astore 6
    //   597: aconst_null
    //   598: astore 4
    //   600: aconst_null
    //   601: astore 8
    //   603: goto -414 -> 189
    //   606: astore 6
    //   608: aload 20
    //   610: astore 4
    //   612: goto -423 -> 189
    //   615: astore 11
    //   617: aconst_null
    //   618: astore 4
    //   620: aconst_null
    //   621: astore 8
    //   623: goto -75 -> 548
    //   626: astore 11
    //   628: aconst_null
    //   629: astore 4
    //   631: goto -83 -> 548
    //   634: astore 11
    //   636: aload 20
    //   638: astore 4
    //   640: goto -92 -> 548
    //   643: astore 12
    //   645: aload 7
    //   647: astore 13
    //   649: aconst_null
    //   650: astore 14
    //   652: aconst_null
    //   653: astore 4
    //   655: goto -479 -> 176
    //   658: astore 12
    //   660: aload 7
    //   662: astore 13
    //   664: aload 8
    //   666: astore 14
    //   668: aconst_null
    //   669: astore 4
    //   671: goto -495 -> 176
    //   674: astore 12
    //   676: aload 20
    //   678: astore 4
    //   680: aload 7
    //   682: astore 13
    //   684: aload 8
    //   686: astore 14
    //   688: goto -512 -> 176
    //
    // Exception table:
    //   from	to	target	type
    //   22	101	168	java/io/IOException
    //   105	118	168	java/io/IOException
    //   118	165	168	java/io/IOException
    //   222	260	168	java/io/IOException
    //   176	179	179	finally
    //   497	502	525	java/io/IOException
    //   507	512	525	java/io/IOException
    //   517	522	525	java/io/IOException
    //   22	101	540	java/lang/Throwable
    //   105	118	540	java/lang/Throwable
    //   118	165	540	java/lang/Throwable
    //   222	260	540	java/lang/Throwable
    //   336	343	561	finally
    //   343	352	561	finally
    //   358	373	561	finally
    //   376	458	561	finally
    //   548	561	561	finally
    //   194	199	566	java/io/IOException
    //   204	209	566	java/io/IOException
    //   214	219	566	java/io/IOException
    //   22	101	581	finally
    //   105	118	581	finally
    //   118	165	581	finally
    //   222	260	581	finally
    //   260	336	595	finally
    //   458	465	606	finally
    //   470	478	606	finally
    //   481	488	606	finally
    //   260	336	615	java/lang/Throwable
    //   336	343	626	java/lang/Throwable
    //   343	352	626	java/lang/Throwable
    //   358	373	626	java/lang/Throwable
    //   376	458	626	java/lang/Throwable
    //   458	465	634	java/lang/Throwable
    //   470	478	634	java/lang/Throwable
    //   481	488	634	java/lang/Throwable
    //   260	336	643	java/io/IOException
    //   336	343	658	java/io/IOException
    //   343	352	658	java/io/IOException
    //   358	373	658	java/io/IOException
    //   376	458	658	java/io/IOException
    //   458	465	674	java/io/IOException
    //   470	478	674	java/io/IOException
    //   481	488	674	java/io/IOException
  }

  public static String a(URL paramURL)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramURL.getProtocol()).append("://").append("10.0.0.172").append(paramURL.getPath());
    if (!TextUtils.isEmpty(paramURL.getQuery()))
      localStringBuilder.append("?").append(paramURL.getQuery());
    return localStringBuilder.toString();
  }

  public static String a(Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer1;
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      localStringBuffer1 = new StringBuffer();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() == null) || (localEntry.getValue() == null))
          continue;
        try
        {
          localStringBuffer1.append(URLEncoder.encode((String)localEntry.getKey(), "UTF-8"));
          localStringBuffer1.append("=");
          localStringBuffer1.append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
          localStringBuffer1.append("&");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + localUnsupportedEncodingException.toString());
          Log.d("com.xiaomi.common.Network", "map: " + paramMap.toString());
          return null;
        }
      }
      if (localStringBuffer1.length() <= 0)
        break label222;
    }
    label222: for (StringBuffer localStringBuffer2 = localStringBuffer1.deleteCharAt(-1 + localStringBuffer1.length()); ; localStringBuffer2 = localStringBuffer1)
    {
      return localStringBuffer2.toString();
      return null;
    }
  }

  public static HttpURLConnection b(Context paramContext, URL paramURL)
  {
    if (!"http".equals(paramURL.getProtocol()))
      return (HttpURLConnection)paramURL.openConnection();
    if (c(paramContext))
      return (HttpURLConnection)paramURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
    if (!b(paramContext))
      return (HttpURLConnection)paramURL.openConnection();
    String str = paramURL.getHost();
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(a(paramURL)).openConnection();
    localHttpURLConnection.addRequestProperty("X-Online-Host", str);
    return localHttpURLConnection;
  }

  private static URL b(String paramString)
  {
    return new URL(paramString);
  }

  public static boolean b(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso()));
    while (true)
    {
      return false;
      try
      {
        ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (localConnectivityManager == null)
          continue;
        try
        {
          NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
          if (localNetworkInfo == null)
            continue;
          String str = localNetworkInfo.getExtraInfo();
          if ((!TextUtils.isEmpty(str)) && (str.length() >= 3) && (!str.contains("ctwap")))
            return str.regionMatches(true, -3 + str.length(), "wap", 0, 3);
        }
        catch (Exception localException2)
        {
          return false;
        }
      }
      catch (Exception localException1)
      {
      }
    }
    return false;
  }

  public static boolean c(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso()))
      return false;
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return false;
    }
    catch (Exception localException1)
    {
      return false;
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return false;
    }
    catch (Exception localException2)
    {
      return false;
    }
    String str = localNetworkInfo.getExtraInfo();
    if ((TextUtils.isEmpty(str)) || (str.length() < 3))
      return false;
    return str.contains("ctwap");
  }

  public static boolean d(Context paramContext)
  {
    return a(paramContext) >= 0;
  }

  public static boolean e(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null);
      while (true)
      {
        return false;
        try
        {
          NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
          if (localNetworkInfo == null)
            continue;
          if (1 == localNetworkInfo.getType());
          for (int i = 1; ; i = 0)
            return i;
        }
        catch (Exception localException2)
        {
          return false;
        }
      }
    }
    catch (Exception localException1)
    {
    }
    return false;
  }

  public static String f(Context paramContext)
  {
    if (e(paramContext))
      return "wifi";
    ConnectivityManager localConnectivityManager;
    try
    {
      localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return "";
    }
    catch (Exception localException1)
    {
      return "";
    }
    NetworkInfo localNetworkInfo;
    try
    {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if (localNetworkInfo == null)
        return "";
    }
    catch (Exception localException2)
    {
      return "";
    }
    return (localNetworkInfo.getTypeName() + "-" + localNetworkInfo.getSubtypeName() + "-" + localNetworkInfo.getExtraInfo()).toLowerCase();
  }

  public static final class a extends FilterInputStream
  {
    private boolean a;

    public a(InputStream paramInputStream)
    {
      super();
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (!this.a)
      {
        int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
        if (i != -1)
          return i;
      }
      this.a = true;
      return -1;
    }
  }

  public static class b
  {
    public int a;
    public Map<String, String> b;

    public String toString()
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.a);
      arrayOfObject[1] = this.b.toString();
      return String.format("resCode = %1$d, headers = %2$s", arrayOfObject);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.e.d
 * JD-Core Version:    0.6.0
 */