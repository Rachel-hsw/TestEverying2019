package com.bokecc.sdk.mobile.download;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import com.bokecc.sdk.mobile.util.HttpUtil;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Downloader
{
  public static final int DOWNLOAD = 200;
  public static final int FINISH = 400;
  public static final int PAUSE = 300;
  public static final int WAIT = 100;
  private int a;
  private final int b = 20480;
  private final int c = 0;
  private final String d = "http://p.bokecc.com/servlet/app/playinfo";
  private long e;
  private long f;
  private File file;
  private String g;
  private String h;
  private String i;
  private String j;
  private DownloadListener k;
  private OnProcessDefinitionListener l;
  private Thread m;
  private TreeMap<Integer, TreeMap<Integer, String>> n;
  private HashMap<Integer, String> o;
  private Integer p;
  private HttpClient q;
  private int r = 10000;
  private int status;

  public Downloader(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3);
    this.file = paramFile;
    b();
  }

  public Downloader(String paramString1, String paramString2, String paramString3)
  {
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
    this.status = 100;
  }

  private void a()
  {
    if (this.q != null)
      this.q.getConnectionManager().shutdown();
    this.q = new DefaultHttpClient();
    this.q.getParams().setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    this.q.getParams().setParameter("http.useragent", HttpUtil.getUserAgent());
    this.q.getParams().setParameter("http.protocol.expect-continue", Boolean.FALSE);
    this.q.getParams().setParameter("http.protocol.content-charset", "UTF-8");
    HttpConnectionParams.setConnectionTimeout(this.q.getParams(), this.r);
    HttpConnectionParams.setSoTimeout(this.q.getParams(), this.r);
  }

  private void a(ErrorCode paramErrorCode)
  {
    this.status = 300;
    if (this.k == null)
      return;
    DownloadListener localDownloadListener = this.k;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("下载失败，ErrorCode: " + paramErrorCode.name());
    localDownloadListener.handleException(new DreamwinException(paramErrorCode, arrayOfString), this.status);
    e();
  }

  @SuppressLint({"UseSparseArrays"})
  private void a(String paramString1, String paramString2, String paramString3)
    throws JSONException, DreamwinException
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", "20140214");
    localHashMap.put("videoid", paramString1);
    localHashMap.put("userid", paramString2);
    localHashMap.put("dt", Build.MODEL);
    localHashMap.put("osversion", Build.VERSION.SDK);
    localHashMap.put("hlssupport", "0");
    String str = HttpUtil.getResult("http://p.bokecc.com/servlet/app/playinfo", localHashMap, paramString3);
    if (str == null)
      throw new DreamwinException(ErrorCode.NETWORK_ERROR, new String[] { "HTTP Response is null." });
    JSONObject localJSONObject1 = new JSONObject(str);
    if (localJSONObject1.isNull("response"))
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "API Response is null." });
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("response");
    if (localJSONObject2.getInt("result") == 0)
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "API Result error." });
    JSONObject localJSONObject3 = localJSONObject2.getJSONObject("video");
    this.a = localJSONObject3.getInt("defaultquality");
    if (localJSONObject3.getInt("status") != 0)
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "下载失败，请检查视频状态" });
    JSONArray localJSONArray1 = localJSONObject2.getJSONArray("qualities");
    this.n = new TreeMap();
    this.o = new HashMap();
    for (int i1 = 0; i1 < localJSONArray1.length(); i1++)
    {
      JSONObject localJSONObject4 = localJSONArray1.getJSONObject(i1);
      JSONArray localJSONArray2 = localJSONObject4.getJSONArray("copies");
      TreeMap localTreeMap = new TreeMap(Collections.reverseOrder());
      for (int i2 = 0; i2 < localJSONArray2.length(); i2++)
      {
        JSONObject localJSONObject5 = localJSONArray2.getJSONObject(i2);
        localTreeMap.put(Integer.valueOf(localJSONObject5.getInt("priority")), localJSONObject5.getString("playurl"));
      }
      this.n.put(Integer.valueOf(localJSONObject4.getInt("quality")), localTreeMap);
      this.o.put(Integer.valueOf(localJSONObject4.getInt("quality")), localJSONObject4.getString("desp"));
    }
  }

  private void b()
  {
    long l1 = this.file.length();
    if (l1 >= 0L)
      this.e = l1;
  }

  private void b(ErrorCode paramErrorCode)
  {
    if (this.l == null)
      return;
    OnProcessDefinitionListener localOnProcessDefinitionListener = this.l;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("获取清晰度失败，ErrorCode: " + paramErrorCode.name());
    localOnProcessDefinitionListener.onProcessException(new DreamwinException(paramErrorCode, arrayOfString));
  }

  // ERROR //
  private void c()
    throws DreamwinException, IOException, JSONException
  {
    // Byte code:
    //   0: aload_0
    //   1: sipush 200
    //   4: putfield 75	com/bokecc/sdk/mobile/download/Downloader:status	I
    //   7: aload_0
    //   8: invokespecial 184	com/bokecc/sdk/mobile/download/Downloader:e	()V
    //   11: aload_0
    //   12: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifgt +7 -> 24
    //   20: aload_0
    //   21: invokespecial 346	com/bokecc/sdk/mobile/download/Downloader:d	()V
    //   24: aload_0
    //   25: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifle +10 -> 40
    //   33: aload_0
    //   34: getfield 52	com/bokecc/sdk/mobile/download/Downloader:file	Ljava/io/File;
    //   37: ifnonnull +24 -> 61
    //   40: new 150	com/bokecc/sdk/mobile/exception/DreamwinException
    //   43: dup
    //   44: getstatic 230	com/bokecc/sdk/mobile/exception/ErrorCode:NETWORK_ERROR	Lcom/bokecc/sdk/mobile/exception/ErrorCode;
    //   47: iconst_1
    //   48: anewarray 156	java/lang/String
    //   51: dup
    //   52: iconst_0
    //   53: ldc_w 348
    //   56: aastore
    //   57: invokespecial 176	com/bokecc/sdk/mobile/exception/DreamwinException:<init>	(Lcom/bokecc/sdk/mobile/exception/ErrorCode;[Ljava/lang/String;)V
    //   60: athrow
    //   61: aload_0
    //   62: getfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   65: aload_0
    //   66: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   69: lcmp
    //   70: iflt +23 -> 93
    //   73: aload_0
    //   74: sipush 400
    //   77: putfield 75	com/bokecc/sdk/mobile/download/Downloader:status	I
    //   80: aload_0
    //   81: invokespecial 184	com/bokecc/sdk/mobile/download/Downloader:e	()V
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   89: putfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   92: return
    //   93: aload_0
    //   94: getfield 75	com/bokecc/sdk/mobile/download/Downloader:status	I
    //   97: sipush 200
    //   100: if_icmpne -8 -> 92
    //   103: aconst_null
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: new 350	org/apache/http/client/methods/HttpGet
    //   110: dup
    //   111: aload_0
    //   112: getfield 352	com/bokecc/sdk/mobile/download/Downloader:g	Ljava/lang/String;
    //   115: invokespecial 353	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   118: astore_3
    //   119: aload_0
    //   120: getfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   123: lconst_0
    //   124: lcmp
    //   125: ifle +43 -> 168
    //   128: aload_3
    //   129: ldc_w 355
    //   132: new 158	java/lang/StringBuilder
    //   135: dup
    //   136: ldc_w 357
    //   139: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   146: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: ldc_w 363
    //   152: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   159: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   162: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 367	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_3
    //   169: ldc_w 369
    //   172: ldc_w 371
    //   175: invokevirtual 367	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_3
    //   179: ldc_w 373
    //   182: ldc_w 375
    //   185: invokevirtual 367	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_3
    //   189: ldc_w 377
    //   192: ldc_w 379
    //   195: invokevirtual 367	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_3
    //   199: ldc_w 381
    //   202: ldc_w 383
    //   205: invokevirtual 367	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: getfield 80	com/bokecc/sdk/mobile/download/Downloader:q	Lorg/apache/http/client/HttpClient;
    //   212: aload_3
    //   213: invokeinterface 387 2 0
    //   218: astore 7
    //   220: aload 7
    //   222: invokeinterface 393 1 0
    //   227: invokeinterface 398 1 0
    //   232: istore 8
    //   234: aconst_null
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: iload 8
    //   240: sipush 400
    //   243: if_icmplt +71 -> 314
    //   246: new 150	com/bokecc/sdk/mobile/exception/DreamwinException
    //   249: dup
    //   250: getstatic 230	com/bokecc/sdk/mobile/exception/ErrorCode:NETWORK_ERROR	Lcom/bokecc/sdk/mobile/exception/ErrorCode;
    //   253: iconst_1
    //   254: anewarray 156	java/lang/String
    //   257: dup
    //   258: iconst_0
    //   259: ldc_w 400
    //   262: aastore
    //   263: invokespecial 176	com/bokecc/sdk/mobile/exception/DreamwinException:<init>	(Lcom/bokecc/sdk/mobile/exception/ErrorCode;[Ljava/lang/String;)V
    //   266: athrow
    //   267: astore 6
    //   269: aload 6
    //   271: athrow
    //   272: astore 4
    //   274: aload_1
    //   275: ifnull +7 -> 282
    //   278: aload_1
    //   279: invokevirtual 405	java/io/RandomAccessFile:close	()V
    //   282: aload_2
    //   283: ifnull +7 -> 290
    //   286: aload_2
    //   287: invokevirtual 408	java/io/InputStream:close	()V
    //   290: aload_0
    //   291: getfield 80	com/bokecc/sdk/mobile/download/Downloader:q	Lorg/apache/http/client/HttpClient;
    //   294: ifnull +17 -> 311
    //   297: aload_0
    //   298: getfield 80	com/bokecc/sdk/mobile/download/Downloader:q	Lorg/apache/http/client/HttpClient;
    //   301: invokeinterface 86 1 0
    //   306: invokeinterface 91 1 0
    //   311: aload 4
    //   313: athrow
    //   314: new 402	java/io/RandomAccessFile
    //   317: dup
    //   318: aload_0
    //   319: getfield 52	com/bokecc/sdk/mobile/download/Downloader:file	Ljava/io/File;
    //   322: ldc_w 410
    //   325: invokespecial 413	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   328: astore 9
    //   330: aload 9
    //   332: aload_0
    //   333: getfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   336: invokevirtual 417	java/io/RandomAccessFile:seek	(J)V
    //   339: aload 7
    //   341: invokeinterface 421 1 0
    //   346: invokeinterface 427 1 0
    //   351: astore 10
    //   353: sipush 20480
    //   356: newarray byte
    //   358: astore 11
    //   360: aload 10
    //   362: aload 11
    //   364: iconst_0
    //   365: sipush 20480
    //   368: invokevirtual 431	java/io/InputStream:read	([BII)I
    //   371: istore 12
    //   373: iload 12
    //   375: iconst_m1
    //   376: if_icmpeq +108 -> 484
    //   379: aload_0
    //   380: getfield 75	com/bokecc/sdk/mobile/download/Downloader:status	I
    //   383: sipush 200
    //   386: if_icmpne +98 -> 484
    //   389: aload 9
    //   391: aload 11
    //   393: iconst_0
    //   394: iload 12
    //   396: invokevirtual 435	java/io/RandomAccessFile:write	([BII)V
    //   399: aload_0
    //   400: aload_0
    //   401: getfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   404: iload 12
    //   406: i2l
    //   407: ladd
    //   408: putfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   411: aload_0
    //   412: getfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   415: aload_0
    //   416: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   419: lcmp
    //   420: iflt +22 -> 442
    //   423: aload_0
    //   424: sipush 400
    //   427: putfield 75	com/bokecc/sdk/mobile/download/Downloader:status	I
    //   430: aload_0
    //   431: invokespecial 184	com/bokecc/sdk/mobile/download/Downloader:e	()V
    //   434: aload_0
    //   435: aload_0
    //   436: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   439: putfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   442: aload_0
    //   443: getfield 154	com/bokecc/sdk/mobile/download/Downloader:k	Lcom/bokecc/sdk/mobile/download/DownloadListener;
    //   446: ifnull -86 -> 360
    //   449: aload_0
    //   450: getfield 154	com/bokecc/sdk/mobile/download/Downloader:k	Lcom/bokecc/sdk/mobile/download/DownloadListener;
    //   453: aload_0
    //   454: getfield 328	com/bokecc/sdk/mobile/download/Downloader:e	J
    //   457: aload_0
    //   458: getfield 344	com/bokecc/sdk/mobile/download/Downloader:f	J
    //   461: aload_0
    //   462: getfield 69	com/bokecc/sdk/mobile/download/Downloader:h	Ljava/lang/String;
    //   465: invokeinterface 439 6 0
    //   470: goto -110 -> 360
    //   473: astore 6
    //   475: aload 10
    //   477: astore_2
    //   478: aload 9
    //   480: astore_1
    //   481: goto -212 -> 269
    //   484: aload 9
    //   486: ifnull +8 -> 494
    //   489: aload 9
    //   491: invokevirtual 405	java/io/RandomAccessFile:close	()V
    //   494: aload 10
    //   496: ifnull +8 -> 504
    //   499: aload 10
    //   501: invokevirtual 408	java/io/InputStream:close	()V
    //   504: aload_0
    //   505: getfield 80	com/bokecc/sdk/mobile/download/Downloader:q	Lorg/apache/http/client/HttpClient;
    //   508: ifnull -416 -> 92
    //   511: aload_0
    //   512: getfield 80	com/bokecc/sdk/mobile/download/Downloader:q	Lorg/apache/http/client/HttpClient;
    //   515: invokeinterface 86 1 0
    //   520: invokeinterface 91 1 0
    //   525: return
    //   526: astore 13
    //   528: aload 13
    //   530: athrow
    //   531: astore 5
    //   533: aload 5
    //   535: athrow
    //   536: astore 4
    //   538: aload 9
    //   540: astore_1
    //   541: aconst_null
    //   542: astore_2
    //   543: goto -269 -> 274
    //   546: astore 4
    //   548: aload 10
    //   550: astore_2
    //   551: aload 9
    //   553: astore_1
    //   554: goto -280 -> 274
    //   557: astore 6
    //   559: aload 9
    //   561: astore_1
    //   562: aconst_null
    //   563: astore_2
    //   564: goto -295 -> 269
    //
    // Exception table:
    //   from	to	target	type
    //   107	168	267	java/io/IOException
    //   168	234	267	java/io/IOException
    //   246	267	267	java/io/IOException
    //   314	330	267	java/io/IOException
    //   107	168	272	finally
    //   168	234	272	finally
    //   246	267	272	finally
    //   269	272	272	finally
    //   314	330	272	finally
    //   353	360	473	java/io/IOException
    //   360	373	473	java/io/IOException
    //   379	442	473	java/io/IOException
    //   442	470	473	java/io/IOException
    //   489	494	526	java/io/IOException
    //   499	504	526	java/io/IOException
    //   504	525	526	java/io/IOException
    //   278	282	531	java/io/IOException
    //   286	290	531	java/io/IOException
    //   290	311	531	java/io/IOException
    //   330	353	536	finally
    //   353	360	546	finally
    //   360	373	546	finally
    //   379	442	546	finally
    //   442	470	546	finally
    //   330	353	557	java/io/IOException
  }

  private void d()
    throws IOException, DreamwinException, JSONException
  {
    HttpGet localHttpGet = new HttpGet(this.g);
    HttpResponse localHttpResponse = this.q.execute(localHttpGet);
    int i1 = localHttpResponse.getStatusLine().getStatusCode();
    if (i1 != 200)
    {
      Log.e("downloader", "responseCode:" + i1);
      throw new DreamwinException(ErrorCode.NETWORK_ERROR, new String[] { "http connection fail." });
    }
    this.f = localHttpResponse.getEntity().getContentLength();
    a();
  }

  private void e()
  {
    if (this.k == null)
      return;
    this.k.handleStatus(this.h, this.status);
  }

  private void f()
    throws DreamwinException
  {
    if ((this.p != null) && (this.n.containsKey(Integer.valueOf(this.p.intValue()))))
      this.g = ((String)((TreeMap)this.n.get(Integer.valueOf(this.p.intValue()))).firstEntry().getValue());
    while ((this.g == null) || ("".equals(this.g)))
    {
      throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "copy url is null." });
      if (this.n.containsKey(Integer.valueOf(this.a)))
      {
        this.g = ((String)((TreeMap)this.n.get(Integer.valueOf(this.a))).firstEntry().getValue());
        continue;
      }
      TreeMap localTreeMap = (TreeMap)this.n.firstEntry().getValue();
      if ((localTreeMap == null) || (localTreeMap.isEmpty()))
        throw new DreamwinException(ErrorCode.PROCESS_FAIL, new String[] { "Video copy is null." });
      this.g = ((String)localTreeMap.firstEntry().getValue());
    }
    if (!this.g.contains("?"))
      this.g = this.g.concat("?");
    this.g = this.g.concat("&r=").concat("" + new Random().nextInt(10000));
    Log.i("downloader", "downloadUrl:" + this.g);
  }

  public void cancel()
  {
    if (this.status == 400);
    do
    {
      return;
      if (this.status == 300)
        this.status = 100;
      if (this.status == 200)
        this.status = 100;
      this.e = 0L;
      this.f = 0L;
    }
    while (this.k == null);
    this.k.handleCancel(this.h);
  }

  public void getDefinitionMap()
  {
    new Thread(new c(this)).start();
  }

  public int getDownloadDefinition()
  {
    return this.p.intValue();
  }

  public int getStatus()
  {
    return this.status;
  }

  public void pause()
  {
    this.status = 300;
    if (this.q != null)
      this.q.getConnectionManager().shutdown();
    e();
  }

  public void reset()
  {
    this.e = 0L;
    this.f = 0L;
    this.n = null;
    this.g = null;
    this.status = 100;
  }

  public void resume()
  {
    if (this.status == 300)
    {
      if (this.g != null)
        break label28;
      this.status = 100;
      start();
    }
    label28: 
    do
      return;
    while ((this.m != null) && (this.m.isAlive()));
    this.m = new Thread(new b(this));
    this.m.start();
  }

  public void setDownloadDefinition(int paramInt)
  {
    this.p = Integer.valueOf(paramInt);
  }

  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.k = paramDownloadListener;
  }

  public void setFile(File paramFile)
  {
    this.file = paramFile;
    b();
  }

  public void setOnProcessDefinitionListener(OnProcessDefinitionListener paramOnProcessDefinitionListener)
  {
    this.l = paramOnProcessDefinitionListener;
  }

  public void setTimeOut(int paramInt)
  {
    if ((paramInt < 5000) || (paramInt > 30000))
      return;
    this.r = paramInt;
  }

  public void start()
  {
    if ((this.status == 100) && ((this.m == null) || (!this.m.isAlive())))
    {
      this.m = new Thread(new a(this));
      this.m.start();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.download.Downloader
 * JD-Core Version:    0.6.0
 */