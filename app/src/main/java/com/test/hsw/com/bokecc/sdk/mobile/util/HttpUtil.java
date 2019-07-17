package com.bokecc.sdk.mobile.util;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class HttpUtil
{
  public static HttpLogLevel LOG_LEVEL;
  public static String SDK_VERSION = "android_2.3.11";
  private static String ba;

  static
  {
    LOG_LEVEL = HttpLogLevel.GENERAL;
  }

  public static String createHashedQueryString(Map<String, String> paramMap, long paramLong, String paramString)
  {
    String str1 = createQueryString(new TreeMap(paramMap));
    if (str1 == null)
      return null;
    long l = paramLong / 1000L;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = str1;
    arrayOfObject1[1] = Long.valueOf(l);
    arrayOfObject1[2] = paramString;
    String str2 = Md5Encrypt.md5(String.format("%s&time=%d&salt=%s", arrayOfObject1)).toLowerCase();
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = str1;
    arrayOfObject2[1] = Long.valueOf(l);
    arrayOfObject2[2] = str2;
    return String.format("%s&time=%d&hash=%s", arrayOfObject2);
  }

  public static String createQueryString(Map<String, String> paramMap)
  {
    if (paramMap == null)
      return null;
    try
    {
      localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (localEntry.getValue() == null)
          continue;
        localStringBuilder.append(String.format("%s=%s&", new Object[] { ((String)localEntry.getKey()).trim(), URLEncoder.encode(((String)localEntry.getValue()).trim(), "utf-8") }));
      }
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
      StringBuilder localStringBuilder;
      Log.e("com.dreamwin.util.HttpUtil", localStringIndexOutOfBoundsException.getMessage());
      return null;
      String str = localStringBuilder.substring(0, -1 + localStringBuilder.length());
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("com.dreamwin.util.HttpUtil", localUnsupportedEncodingException.getMessage());
    }
    return null;
  }

  public static String getResult(String paramString1, Map<String, String> paramMap, String paramString2)
    throws JSONException
  {
    long l = z();
    return retrieve(paramString1.concat("?").concat(createHashedQueryString(paramMap, l, paramString2)), 5000, null, HttpMethod.GET);
  }

  public static String getUserAgent()
  {
    if (ba == null)
    {
      String str1 = System.getProperty("java.vm.name");
      String str2 = System.getProperty("java.vm.version");
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = str1;
      arrayOfObject[1] = str2;
      arrayOfObject[2] = Build.VERSION.RELEASE;
      arrayOfObject[3] = Build.MANUFACTURER;
      arrayOfObject[4] = Build.ID;
      ba = String.format("%s/%s (Linux; Android %s; %s Build/%s)", arrayOfObject);
    }
    return ba;
  }

  // ERROR //
  public static String retrieve(String paramString, int paramInt, java.util.List<org.apache.http.NameValuePair> paramList, HttpMethod paramHttpMethod)
  {
    // Byte code:
    //   0: getstatic 22	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   3: getstatic 197	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:DETAIL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   6: if_acmpne +10 -> 16
    //   9: ldc 199
    //   11: aload_0
    //   12: invokestatic 202	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   15: pop
    //   16: new 204	org/apache/http/impl/client/DefaultHttpClient
    //   19: dup
    //   20: invokespecial 205	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   23: astore 5
    //   25: aload 5
    //   27: invokeinterface 211 1 0
    //   32: ldc 213
    //   34: getstatic 219	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   37: invokeinterface 225 3 0
    //   42: pop
    //   43: aload 5
    //   45: invokeinterface 211 1 0
    //   50: ldc 227
    //   52: invokestatic 229	com/bokecc/sdk/mobile/util/HttpUtil:getUserAgent	()Ljava/lang/String;
    //   55: invokeinterface 225 3 0
    //   60: pop
    //   61: aload 5
    //   63: invokeinterface 211 1 0
    //   68: ldc 231
    //   70: getstatic 237	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   73: invokeinterface 225 3 0
    //   78: pop
    //   79: aload 5
    //   81: invokeinterface 211 1 0
    //   86: ldc 239
    //   88: ldc 241
    //   90: invokeinterface 225 3 0
    //   95: pop
    //   96: aload 5
    //   98: invokeinterface 211 1 0
    //   103: iload_1
    //   104: invokestatic 247	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   107: aload 5
    //   109: invokeinterface 211 1 0
    //   114: iload_1
    //   115: invokestatic 250	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   118: getstatic 253	com/bokecc/sdk/mobile/util/HttpUtil$HttpMethod:POST	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpMethod;
    //   121: aload_3
    //   122: invokevirtual 257	com/bokecc/sdk/mobile/util/HttpUtil$HttpMethod:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +170 -> 295
    //   128: new 259	org/apache/http/client/methods/HttpPost
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 262	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   136: astore 20
    //   138: aload 20
    //   140: new 264	org/apache/http/client/entity/UrlEncodedFormEntity
    //   143: dup
    //   144: aload_2
    //   145: ldc 108
    //   147: invokespecial 267	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   150: invokevirtual 271	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   153: aload 5
    //   155: aload 20
    //   157: invokeinterface 275 2 0
    //   162: astore 21
    //   164: aload 21
    //   166: invokeinterface 281 1 0
    //   171: invokeinterface 286 1 0
    //   176: istore 22
    //   178: getstatic 22	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   181: getstatic 20	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:GENERAL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   184: if_acmpeq +12 -> 196
    //   187: getstatic 22	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   190: getstatic 197	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:DETAIL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   193: if_acmpne +31 -> 224
    //   196: ldc_w 288
    //   199: new 70	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   206: iload 22
    //   208: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc_w 293
    //   214: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 202	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   223: pop
    //   224: iload 22
    //   226: sipush 200
    //   229: if_icmpeq +105 -> 334
    //   232: ldc_w 298
    //   235: new 70	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   242: iload 22
    //   244: invokevirtual 291	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: ldc_w 293
    //   250: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 202	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   259: pop
    //   260: aload 5
    //   262: ifnull +15 -> 277
    //   265: aload 5
    //   267: invokeinterface 302 1 0
    //   272: invokeinterface 307 1 0
    //   277: iconst_0
    //   278: ifeq +7 -> 285
    //   281: aconst_null
    //   282: invokevirtual 312	java/io/InputStream:close	()V
    //   285: iconst_0
    //   286: ifeq +7 -> 293
    //   289: aconst_null
    //   290: invokevirtual 315	java/io/BufferedReader:close	()V
    //   293: aconst_null
    //   294: areturn
    //   295: aload 5
    //   297: new 317	org/apache/http/client/methods/HttpGet
    //   300: dup
    //   301: aload_0
    //   302: invokespecial 318	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   305: invokeinterface 275 2 0
    //   310: astore 43
    //   312: aload 43
    //   314: astore 21
    //   316: goto -152 -> 164
    //   319: astore 25
    //   321: ldc 120
    //   323: aload 25
    //   325: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   328: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   331: pop
    //   332: aconst_null
    //   333: areturn
    //   334: aload 21
    //   336: invokeinterface 323 1 0
    //   341: astore 27
    //   343: aload 27
    //   345: ifnonnull +61 -> 406
    //   348: ldc_w 325
    //   351: aload_0
    //   352: invokestatic 202	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   355: pop
    //   356: aload 5
    //   358: ifnull +15 -> 373
    //   361: aload 5
    //   363: invokeinterface 302 1 0
    //   368: invokeinterface 307 1 0
    //   373: iconst_0
    //   374: ifeq +7 -> 381
    //   377: aconst_null
    //   378: invokevirtual 312	java/io/InputStream:close	()V
    //   381: iconst_0
    //   382: ifeq -89 -> 293
    //   385: aconst_null
    //   386: invokevirtual 315	java/io/BufferedReader:close	()V
    //   389: aconst_null
    //   390: areturn
    //   391: astore 29
    //   393: ldc 120
    //   395: aload 29
    //   397: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   400: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   403: pop
    //   404: aconst_null
    //   405: areturn
    //   406: aload 27
    //   408: invokeinterface 331 1 0
    //   413: astore 31
    //   415: aload 31
    //   417: astore 7
    //   419: aload 7
    //   421: ifnonnull +63 -> 484
    //   424: ldc_w 333
    //   427: aload_0
    //   428: invokestatic 202	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   431: pop
    //   432: aload 5
    //   434: ifnull +15 -> 449
    //   437: aload 5
    //   439: invokeinterface 302 1 0
    //   444: invokeinterface 307 1 0
    //   449: aload 7
    //   451: ifnull +8 -> 459
    //   454: aload 7
    //   456: invokevirtual 312	java/io/InputStream:close	()V
    //   459: iconst_0
    //   460: ifeq -167 -> 293
    //   463: aconst_null
    //   464: invokevirtual 315	java/io/BufferedReader:close	()V
    //   467: aconst_null
    //   468: areturn
    //   469: astore 41
    //   471: ldc 120
    //   473: aload 41
    //   475: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   478: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   481: pop
    //   482: aconst_null
    //   483: areturn
    //   484: new 314	java/io/BufferedReader
    //   487: dup
    //   488: new 335	java/io/InputStreamReader
    //   491: dup
    //   492: aload 7
    //   494: ldc_w 337
    //   497: invokespecial 340	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   500: invokespecial 343	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   503: astore 6
    //   505: ldc_w 293
    //   508: astore 32
    //   510: aload 6
    //   512: invokevirtual 346	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   515: astore 33
    //   517: aload 33
    //   519: ifnull +34 -> 553
    //   522: new 70	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   529: aload 32
    //   531: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 33
    //   536: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: ldc_w 348
    //   542: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: astore 32
    //   550: goto -40 -> 510
    //   553: aload 32
    //   555: ldc_w 293
    //   558: invokevirtual 349	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   561: ifne +331 -> 892
    //   564: aload 32
    //   566: iconst_0
    //   567: aload 32
    //   569: ldc_w 348
    //   572: invokevirtual 353	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   575: invokevirtual 354	java/lang/String:substring	(II)Ljava/lang/String;
    //   578: astore 34
    //   580: new 48	java/lang/String
    //   583: dup
    //   584: aload 34
    //   586: ldc_w 337
    //   589: invokevirtual 358	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   592: ldc 241
    //   594: invokespecial 361	java/lang/String:<init>	([BLjava/lang/String;)V
    //   597: astore 35
    //   599: getstatic 22	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   602: getstatic 197	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:DETAIL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   605: if_acmpne +12 -> 617
    //   608: ldc_w 363
    //   611: aload 35
    //   613: invokestatic 202	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   616: pop
    //   617: aload 5
    //   619: ifnull +15 -> 634
    //   622: aload 5
    //   624: invokeinterface 302 1 0
    //   629: invokeinterface 307 1 0
    //   634: aload 7
    //   636: ifnull +8 -> 644
    //   639: aload 7
    //   641: invokevirtual 312	java/io/InputStream:close	()V
    //   644: aload 6
    //   646: ifnull +8 -> 654
    //   649: aload 6
    //   651: invokevirtual 315	java/io/BufferedReader:close	()V
    //   654: aload 35
    //   656: areturn
    //   657: astore 36
    //   659: ldc 120
    //   661: aload 36
    //   663: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   666: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   669: pop
    //   670: goto -16 -> 654
    //   673: astore 11
    //   675: aconst_null
    //   676: astore 5
    //   678: aconst_null
    //   679: astore 6
    //   681: aconst_null
    //   682: astore 7
    //   684: ldc 120
    //   686: new 70	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   693: aload 11
    //   695: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   698: ldc_w 293
    //   701: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   710: pop
    //   711: aload 5
    //   713: ifnull +15 -> 728
    //   716: aload 5
    //   718: invokeinterface 302 1 0
    //   723: invokeinterface 307 1 0
    //   728: aload 7
    //   730: ifnull +8 -> 738
    //   733: aload 7
    //   735: invokevirtual 312	java/io/InputStream:close	()V
    //   738: aload 6
    //   740: ifnull -447 -> 293
    //   743: aload 6
    //   745: invokevirtual 315	java/io/BufferedReader:close	()V
    //   748: aconst_null
    //   749: areturn
    //   750: astore 13
    //   752: ldc 120
    //   754: aload 13
    //   756: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   759: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   762: pop
    //   763: aconst_null
    //   764: areturn
    //   765: astore 4
    //   767: aconst_null
    //   768: astore 5
    //   770: aconst_null
    //   771: astore 6
    //   773: aconst_null
    //   774: astore 7
    //   776: aload 4
    //   778: astore 8
    //   780: aload 5
    //   782: ifnull +15 -> 797
    //   785: aload 5
    //   787: invokeinterface 302 1 0
    //   792: invokeinterface 307 1 0
    //   797: aload 7
    //   799: ifnull +8 -> 807
    //   802: aload 7
    //   804: invokevirtual 312	java/io/InputStream:close	()V
    //   807: aload 6
    //   809: ifnull +8 -> 817
    //   812: aload 6
    //   814: invokevirtual 315	java/io/BufferedReader:close	()V
    //   817: aload 8
    //   819: athrow
    //   820: astore 9
    //   822: ldc 120
    //   824: aload 9
    //   826: invokevirtual 319	java/io/IOException:getMessage	()Ljava/lang/String;
    //   829: invokestatic 129	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   832: pop
    //   833: goto -16 -> 817
    //   836: astore 15
    //   838: aload 15
    //   840: astore 8
    //   842: aconst_null
    //   843: astore 6
    //   845: aconst_null
    //   846: astore 7
    //   848: goto -68 -> 780
    //   851: astore 39
    //   853: aload 39
    //   855: astore 8
    //   857: aconst_null
    //   858: astore 6
    //   860: goto -80 -> 780
    //   863: astore 8
    //   865: goto -85 -> 780
    //   868: astore 11
    //   870: aconst_null
    //   871: astore 6
    //   873: aconst_null
    //   874: astore 7
    //   876: goto -192 -> 684
    //   879: astore 11
    //   881: aconst_null
    //   882: astore 6
    //   884: goto -200 -> 684
    //   887: astore 11
    //   889: goto -205 -> 684
    //   892: aload 32
    //   894: astore 34
    //   896: goto -316 -> 580
    //
    // Exception table:
    //   from	to	target	type
    //   281	285	319	java/io/IOException
    //   289	293	319	java/io/IOException
    //   377	381	391	java/io/IOException
    //   385	389	391	java/io/IOException
    //   454	459	469	java/io/IOException
    //   463	467	469	java/io/IOException
    //   639	644	657	java/io/IOException
    //   649	654	657	java/io/IOException
    //   0	16	673	java/lang/Exception
    //   16	25	673	java/lang/Exception
    //   733	738	750	java/io/IOException
    //   743	748	750	java/io/IOException
    //   0	16	765	finally
    //   16	25	765	finally
    //   802	807	820	java/io/IOException
    //   812	817	820	java/io/IOException
    //   25	164	836	finally
    //   164	196	836	finally
    //   196	224	836	finally
    //   232	260	836	finally
    //   295	312	836	finally
    //   334	343	836	finally
    //   348	356	836	finally
    //   406	415	836	finally
    //   424	432	851	finally
    //   484	505	851	finally
    //   510	517	863	finally
    //   522	550	863	finally
    //   553	580	863	finally
    //   580	617	863	finally
    //   684	711	863	finally
    //   25	164	868	java/lang/Exception
    //   164	196	868	java/lang/Exception
    //   196	224	868	java/lang/Exception
    //   232	260	868	java/lang/Exception
    //   295	312	868	java/lang/Exception
    //   334	343	868	java/lang/Exception
    //   348	356	868	java/lang/Exception
    //   406	415	868	java/lang/Exception
    //   424	432	879	java/lang/Exception
    //   484	505	879	java/lang/Exception
    //   510	517	887	java/lang/Exception
    //   522	550	887	java/lang/Exception
    //   553	580	887	java/lang/Exception
    //   580	617	887	java/lang/Exception
  }

  public static String urlDecode(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.i("com.dreamwin.util.HttpUtil", localUnsupportedEncodingException.getMessage());
    }
    return "";
  }

  public static String urlEncode(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.i("com.dreamwin.util.HttpUtil", localUnsupportedEncodingException.getMessage());
    }
    return "";
  }

  private static long z()
  {
    long l1 = System.currentTimeMillis();
    String str = retrieve("http://p.bokecc.com/api/system/localtime?format=json", 5000, null, HttpMethod.GET);
    if ((str == null) || ("".equals(str)))
      return l1;
    try
    {
      long l2 = ((JSONObject)new JSONObject(str).get("system")).getLong("time");
      return l2;
    }
    catch (JSONException localJSONException)
    {
      Log.e("com.dreamwin.util.HttpUtil", "server is error: " + localJSONException.getMessage());
    }
    return l1;
  }

  public static enum HttpLogLevel
  {
    static
    {
      DETAIL = new HttpLogLevel("DETAIL", 1);
      CLOSE = new HttpLogLevel("CLOSE", 2);
      HttpLogLevel[] arrayOfHttpLogLevel = new HttpLogLevel[3];
      arrayOfHttpLogLevel[0] = GENERAL;
      arrayOfHttpLogLevel[1] = DETAIL;
      arrayOfHttpLogLevel[2] = CLOSE;
      bb = arrayOfHttpLogLevel;
    }
  }

  public static enum HttpMethod
  {
    static
    {
      HttpMethod[] arrayOfHttpMethod = new HttpMethod[2];
      arrayOfHttpMethod[0] = GET;
      arrayOfHttpMethod[1] = POST;
      bc = arrayOfHttpMethod;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.util.HttpUtil
 * JD-Core Version:    0.6.0
 */