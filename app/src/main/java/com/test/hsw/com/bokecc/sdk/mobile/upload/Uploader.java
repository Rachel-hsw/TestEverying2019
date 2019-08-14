package com.bokecc.sdk.mobile.upload;

import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import com.bokecc.sdk.mobile.util.HttpUtil;
import com.bokecc.sdk.mobile.util.HttpUtil.HttpMethod;
import com.bokecc.sdk.mobile.util.Md5Encrypt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class Uploader
{
  public static final int FINISH = 400;
  public static final int PAUSE = 300;
  public static final int UPLOAD = 200;
  public static final int WAIT = 100;
  private String TAG = "Uploader";
  private VideoInfo aG;
  private UploadListener aH;
  private HttpURLConnection aI;
  private Thread m;
  private HttpClient q;
  private int status = 100;

  public Uploader(VideoInfo paramVideoInfo, String paramString)
  {
    this.aG = paramVideoInfo;
    this.aG.setApiKey(paramString);
  }

  private long a(VideoInfo paramVideoInfo)
    throws DreamwinException, UnsupportedEncodingException
  {
    long l1 = -1L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ccvid", paramVideoInfo.getVideoId());
    localHashMap.put("uid", paramVideoInfo.getUserId());
    localHashMap.put("domain", paramVideoInfo.getServer());
    localHashMap.put("servicetype", paramVideoInfo.getServicetype());
    localHashMap.put("createtime", paramVideoInfo.getCreationTime());
    localHashMap.put("priority", paramVideoInfo.getPriority());
    localHashMap.put("filename", paramVideoInfo.getFileName());
    localHashMap.put("encodetype", paramVideoInfo.getEncodetype());
    localHashMap.put("first", paramVideoInfo.getUploadOrResume());
    localHashMap.put("md5", paramVideoInfo.getMd5());
    localHashMap.put("filesize", paramVideoInfo.getFileByteSize());
    localHashMap.put("version", HttpUtil.SDK_VERSION);
    if (paramVideoInfo.isCrop())
    {
      localHashMap.put("iscrop", "1");
      Log.i("isCrop", "isCrop=1");
    }
    ErrorCode localErrorCode;
    String[] arrayOfString;
    while (true)
    {
      String str = retrieve(paramVideoInfo.getServer() + "servlet/checkupload" + "?" + HttpUtil.createQueryString(localHashMap), 50000, null, HttpUtil.HttpMethod.GET);
      if (str != null);
      try
      {
        long l2 = Long.parseLong(str);
        l1 = l2;
        return l1;
        localHashMap.put("iscrop", "0");
        Log.i("isCrop", "isCrop=0");
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localErrorCode = ErrorCode.PROCESS_FAIL;
        arrayOfString = new String[1];
        arrayOfString[0] = ("parse result error. result: " + str);
      }
    }
    throw new DreamwinException(localErrorCode, arrayOfString);
  }

  private String a(String paramString1, Map<String, String> paramMap, String paramString2)
  {
    long l = z();
    return paramString1.concat("?").concat(HttpUtil.createHashedQueryString(paramMap, l, paramString2));
  }

  private void a(ErrorCode paramErrorCode)
  {
    this.status = 300;
    if (this.aH == null)
      return;
    UploadListener localUploadListener = this.aH;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("上传失败. ErrorCode:" + paramErrorCode.name());
    localUploadListener.handleException(new DreamwinException(paramErrorCode, arrayOfString), this.status);
    y();
  }

  // ERROR //
  private void a(String paramString, RandomAccessFile paramRandomAccessFile)
    throws IOException, DreamwinException
  {
    // Byte code:
    //   0: sipush 1024
    //   3: newarray byte
    //   5: astore_3
    //   6: aconst_null
    //   7: astore 4
    //   9: aload_0
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 242	com/bokecc/sdk/mobile/upload/Uploader:f	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   15: putfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   18: aload_0
    //   19: getfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   22: ifnonnull +84 -> 106
    //   25: aload_0
    //   26: getfield 37	com/bokecc/sdk/mobile/upload/Uploader:status	I
    //   29: sipush 200
    //   32: if_icmpne +74 -> 106
    //   35: new 49	com/bokecc/sdk/mobile/exception/DreamwinException
    //   38: dup
    //   39: getstatic 247	com/bokecc/sdk/mobile/exception/ErrorCode:NETWORK_ERROR	Lcom/bokecc/sdk/mobile/exception/ErrorCode;
    //   42: iconst_1
    //   43: anewarray 191	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc 249
    //   50: aastore
    //   51: invokespecial 196	com/bokecc/sdk/mobile/exception/DreamwinException:<init>	(Lcom/bokecc/sdk/mobile/exception/ErrorCode;[Ljava/lang/String;)V
    //   54: athrow
    //   55: astore 8
    //   57: aload 8
    //   59: athrow
    //   60: astore 5
    //   62: aload 4
    //   64: astore 6
    //   66: aload 6
    //   68: ifnull +13 -> 81
    //   71: aload 6
    //   73: invokevirtual 254	java/io/OutputStream:flush	()V
    //   76: aload 6
    //   78: invokevirtual 257	java/io/OutputStream:close	()V
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   89: aload_0
    //   90: getfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   93: ifnull +10 -> 103
    //   96: aload_0
    //   97: getfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   100: invokevirtual 265	java/net/HttpURLConnection:disconnect	()V
    //   103: aload 5
    //   105: athrow
    //   106: lconst_0
    //   107: lstore 9
    //   109: aload_0
    //   110: getfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   113: invokevirtual 269	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   116: astore 11
    //   118: aload 11
    //   120: astore 6
    //   122: aload_2
    //   123: aload_3
    //   124: invokevirtual 273	java/io/RandomAccessFile:read	([B)I
    //   127: istore 12
    //   129: iload 12
    //   131: iconst_m1
    //   132: if_icmpeq +67 -> 199
    //   135: aload_0
    //   136: getfield 37	com/bokecc/sdk/mobile/upload/Uploader:status	I
    //   139: sipush 200
    //   142: if_icmpne +57 -> 199
    //   145: aload 6
    //   147: aload_3
    //   148: iconst_0
    //   149: iload 12
    //   151: invokevirtual 277	java/io/OutputStream:write	([BII)V
    //   154: aload_2
    //   155: invokevirtual 280	java/io/RandomAccessFile:getFilePointer	()J
    //   158: lstore 9
    //   160: aload_0
    //   161: getfield 39	com/bokecc/sdk/mobile/upload/Uploader:aG	Lcom/bokecc/sdk/mobile/upload/VideoInfo;
    //   164: ifnull -42 -> 122
    //   167: aload_0
    //   168: getfield 212	com/bokecc/sdk/mobile/upload/Uploader:aH	Lcom/bokecc/sdk/mobile/upload/UploadListener;
    //   171: ifnull -49 -> 122
    //   174: aload_0
    //   175: getfield 212	com/bokecc/sdk/mobile/upload/Uploader:aH	Lcom/bokecc/sdk/mobile/upload/UploadListener;
    //   178: lload 9
    //   180: aload_2
    //   181: invokevirtual 283	java/io/RandomAccessFile:length	()J
    //   184: aload_0
    //   185: getfield 39	com/bokecc/sdk/mobile/upload/Uploader:aG	Lcom/bokecc/sdk/mobile/upload/VideoInfo;
    //   188: invokevirtual 64	com/bokecc/sdk/mobile/upload/VideoInfo:getVideoId	()Ljava/lang/String;
    //   191: invokeinterface 287 6 0
    //   196: goto -74 -> 122
    //   199: lload 9
    //   201: aload_2
    //   202: invokevirtual 283	java/io/RandomAccessFile:length	()J
    //   205: lcmp
    //   206: ifne +30 -> 236
    //   209: ldc 135
    //   211: aload_0
    //   212: aload_0
    //   213: getfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   216: invokespecial 291	com/bokecc/sdk/mobile/upload/Uploader:b	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   219: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   222: ifeq +52 -> 274
    //   225: aload_0
    //   226: sipush 400
    //   229: putfield 37	com/bokecc/sdk/mobile/upload/Uploader:status	I
    //   232: aload_0
    //   233: invokespecial 226	com/bokecc/sdk/mobile/upload/Uploader:y	()V
    //   236: aload 6
    //   238: ifnull +13 -> 251
    //   241: aload 6
    //   243: invokevirtual 254	java/io/OutputStream:flush	()V
    //   246: aload 6
    //   248: invokevirtual 257	java/io/OutputStream:close	()V
    //   251: aload_2
    //   252: ifnull +7 -> 259
    //   255: aload_2
    //   256: invokevirtual 260	java/io/RandomAccessFile:close	()V
    //   259: aload_0
    //   260: getfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   263: ifnull +10 -> 273
    //   266: aload_0
    //   267: getfield 244	com/bokecc/sdk/mobile/upload/Uploader:aI	Ljava/net/HttpURLConnection;
    //   270: invokevirtual 265	java/net/HttpURLConnection:disconnect	()V
    //   273: return
    //   274: aload_0
    //   275: getfield 39	com/bokecc/sdk/mobile/upload/Uploader:aG	Lcom/bokecc/sdk/mobile/upload/VideoInfo;
    //   278: ldc_w 297
    //   281: invokevirtual 300	com/bokecc/sdk/mobile/upload/VideoInfo:setUploadOrResume	(Ljava/lang/String;)V
    //   284: aload_0
    //   285: invokespecial 303	com/bokecc/sdk/mobile/upload/Uploader:x	()V
    //   288: goto -52 -> 236
    //   291: astore 5
    //   293: goto -227 -> 66
    //   296: astore 13
    //   298: aload 13
    //   300: athrow
    //   301: astore 7
    //   303: aload 7
    //   305: athrow
    //   306: astore 5
    //   308: aconst_null
    //   309: astore 6
    //   311: goto -245 -> 66
    //   314: astore 8
    //   316: aload 6
    //   318: astore 4
    //   320: goto -263 -> 57
    //
    // Exception table:
    //   from	to	target	type
    //   9	55	55	java/io/IOException
    //   109	118	55	java/io/IOException
    //   57	60	60	finally
    //   122	129	291	finally
    //   135	196	291	finally
    //   199	236	291	finally
    //   274	288	291	finally
    //   241	251	296	java/io/IOException
    //   255	259	296	java/io/IOException
    //   259	273	296	java/io/IOException
    //   71	81	301	java/io/IOException
    //   85	89	301	java/io/IOException
    //   89	103	301	java/io/IOException
    //   9	55	306	finally
    //   109	118	306	finally
    //   122	129	314	java/io/IOException
    //   135	196	314	java/io/IOException
    //   199	236	314	java/io/IOException
    //   274	288	314	java/io/IOException
  }

  private String b(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    InputStream localInputStream = null;
    try
    {
      localInputStream = paramHttpURLConnection.getInputStream();
      byte[] arrayOfByte = new byte[1];
      localInputStream.read(arrayOfByte);
      String str = new String(arrayOfByte, "GBK");
      if (localInputStream != null);
      try
      {
        localInputStream.close();
        return str;
      }
      catch (IOException localIOException3)
      {
        throw localIOException3;
      }
    }
    catch (IOException localIOException2)
    {
      throw localIOException2;
    }
    finally
    {
      if (localInputStream != null);
      try
      {
        localInputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
      }
    }
    throw localIOException1;
  }

  private void e(String paramString)
    throws DreamwinException, XmlPullParserException, IOException
  {
    XmlPullParserFactory localXmlPullParserFactory = XmlPullParserFactory.newInstance();
    localXmlPullParserFactory.setNamespaceAware(true);
    XmlPullParser localXmlPullParser = localXmlPullParserFactory.newPullParser();
    localXmlPullParser.setInput(new StringReader(paramString));
    int i = localXmlPullParser.getEventType();
    while (i != 1)
    {
      if (i != 2)
      {
        i = localXmlPullParser.next();
        continue;
      }
      if ("error".equals(localXmlPullParser.getName()))
        throw new DreamwinException(ErrorCode.INVALID_REQUEST, new String[] { "INVALID_REQUEST" });
      if ("videoid".equals(localXmlPullParser.getName()))
        this.aG.setVideoId(localXmlPullParser.nextText());
      if ("createtime".equals(localXmlPullParser.getName()))
        this.aG.setCreationTime(localXmlPullParser.nextText());
      if ("servicetype".equals(localXmlPullParser.getName()))
        this.aG.setServicetype(localXmlPullParser.nextText());
      if ("priority".equals(localXmlPullParser.getName()))
        this.aG.setPriority(localXmlPullParser.nextText());
      if ("encodetype".equals(localXmlPullParser.getName()))
        this.aG.setEncodetype(localXmlPullParser.nextText());
      if ("server".equals(localXmlPullParser.getName()))
        this.aG.setServer(localXmlPullParser.nextText());
      i = localXmlPullParser.next();
    }
  }

  private HttpURLConnection f(String paramString)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setConnectTimeout(5000);
    localHttpURLConnection.setChunkedStreamingMode(1024);
    localHttpURLConnection.setDoOutput(true);
    localHttpURLConnection.setDoInput(true);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setRequestProperty("User-Agent", HttpUtil.getUserAgent());
    return localHttpURLConnection;
  }

  // ERROR //
  private String retrieve(String paramString, int paramInt, java.util.List<org.apache.http.NameValuePair> paramList, HttpUtil.HttpMethod paramHttpMethod)
  {
    // Byte code:
    //   0: getstatic 427	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   3: getstatic 432	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:DETAIL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   6: if_acmpne +11 -> 17
    //   9: ldc_w 434
    //   12: aload_1
    //   13: invokestatic 144	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: aload_0
    //   18: new 436	org/apache/http/impl/client/DefaultHttpClient
    //   21: dup
    //   22: invokespecial 437	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   25: putfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   28: aload_0
    //   29: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   32: invokeinterface 445 1 0
    //   37: ldc_w 447
    //   40: getstatic 453	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   43: invokeinterface 459 3 0
    //   48: pop
    //   49: aload_0
    //   50: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   53: invokeinterface 445 1 0
    //   58: ldc_w 461
    //   61: invokestatic 417	com/bokecc/sdk/mobile/util/HttpUtil:getUserAgent	()Ljava/lang/String;
    //   64: invokeinterface 459 3 0
    //   69: pop
    //   70: aload_0
    //   71: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   74: invokeinterface 445 1 0
    //   79: ldc_w 463
    //   82: getstatic 469	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   85: invokeinterface 459 3 0
    //   90: pop
    //   91: aload_0
    //   92: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   95: invokeinterface 445 1 0
    //   100: ldc_w 471
    //   103: ldc_w 473
    //   106: invokeinterface 459 3 0
    //   111: pop
    //   112: aload_0
    //   113: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   116: invokeinterface 445 1 0
    //   121: iload_2
    //   122: sipush 1000
    //   125: imul
    //   126: invokestatic 479	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   129: aload_0
    //   130: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   133: invokeinterface 445 1 0
    //   138: iload_2
    //   139: sipush 1000
    //   142: imul
    //   143: invokestatic 482	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   146: getstatic 484	com/bokecc/sdk/mobile/util/HttpUtil$HttpMethod:POST	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpMethod;
    //   149: aload 4
    //   151: invokevirtual 485	com/bokecc/sdk/mobile/util/HttpUtil$HttpMethod:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +156 -> 310
    //   157: new 487	org/apache/http/client/methods/HttpPost
    //   160: dup
    //   161: aload_1
    //   162: invokespecial 488	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   165: astore 19
    //   167: aload 19
    //   169: new 490	org/apache/http/client/entity/UrlEncodedFormEntity
    //   172: dup
    //   173: aload_3
    //   174: ldc_w 492
    //   177: invokespecial 495	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   180: invokevirtual 499	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   183: aload_0
    //   184: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   187: aload 19
    //   189: invokeinterface 503 2 0
    //   194: astore 20
    //   196: aload 20
    //   198: invokeinterface 509 1 0
    //   203: invokeinterface 514 1 0
    //   208: istore 21
    //   210: getstatic 427	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   213: getstatic 517	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:GENERAL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   216: if_acmpeq +12 -> 228
    //   219: getstatic 427	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   222: getstatic 432	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:DETAIL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   225: if_acmpne +31 -> 256
    //   228: ldc_w 519
    //   231: new 146	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   238: iload 21
    //   240: invokevirtual 522	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: ldc_w 524
    //   246: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 144	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   255: pop
    //   256: iload 21
    //   258: sipush 200
    //   261: if_icmpeq +96 -> 357
    //   264: ldc_w 526
    //   267: new 146	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   274: iload 21
    //   276: invokevirtual 522	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc_w 524
    //   282: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 144	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   291: pop
    //   292: iconst_0
    //   293: ifeq +7 -> 300
    //   296: aconst_null
    //   297: invokevirtual 316	java/io/InputStream:close	()V
    //   300: iconst_0
    //   301: ifeq +7 -> 308
    //   304: aconst_null
    //   305: invokevirtual 529	java/io/BufferedReader:close	()V
    //   308: aconst_null
    //   309: areturn
    //   310: new 531	org/apache/http/client/methods/HttpGet
    //   313: dup
    //   314: aload_1
    //   315: invokespecial 532	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   318: astore 42
    //   320: aload_0
    //   321: getfield 439	com/bokecc/sdk/mobile/upload/Uploader:q	Lorg/apache/http/client/HttpClient;
    //   324: aload 42
    //   326: invokeinterface 503 2 0
    //   331: astore 43
    //   333: aload 43
    //   335: astore 20
    //   337: goto -141 -> 196
    //   340: astore 24
    //   342: aload_0
    //   343: getfield 35	com/bokecc/sdk/mobile/upload/Uploader:TAG	Ljava/lang/String;
    //   346: aload 24
    //   348: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   351: invokestatic 537	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   354: pop
    //   355: aconst_null
    //   356: areturn
    //   357: aload 20
    //   359: invokeinterface 541 1 0
    //   364: astore 26
    //   366: aload 26
    //   368: ifnonnull +46 -> 414
    //   371: ldc_w 543
    //   374: aload_1
    //   375: invokestatic 144	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   378: pop
    //   379: iconst_0
    //   380: ifeq +7 -> 387
    //   383: aconst_null
    //   384: invokevirtual 316	java/io/InputStream:close	()V
    //   387: iconst_0
    //   388: ifeq -80 -> 308
    //   391: aconst_null
    //   392: invokevirtual 529	java/io/BufferedReader:close	()V
    //   395: aconst_null
    //   396: areturn
    //   397: astore 28
    //   399: aload_0
    //   400: getfield 35	com/bokecc/sdk/mobile/upload/Uploader:TAG	Ljava/lang/String;
    //   403: aload 28
    //   405: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   408: invokestatic 537	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   411: pop
    //   412: aconst_null
    //   413: areturn
    //   414: aload 26
    //   416: invokeinterface 548 1 0
    //   421: astore 30
    //   423: aload 30
    //   425: astore 7
    //   427: aload 7
    //   429: ifnonnull +48 -> 477
    //   432: ldc_w 550
    //   435: aload_1
    //   436: invokestatic 144	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   439: pop
    //   440: aload 7
    //   442: ifnull +8 -> 450
    //   445: aload 7
    //   447: invokevirtual 316	java/io/InputStream:close	()V
    //   450: iconst_0
    //   451: ifeq -143 -> 308
    //   454: aconst_null
    //   455: invokevirtual 529	java/io/BufferedReader:close	()V
    //   458: aconst_null
    //   459: areturn
    //   460: astore 40
    //   462: aload_0
    //   463: getfield 35	com/bokecc/sdk/mobile/upload/Uploader:TAG	Ljava/lang/String;
    //   466: aload 40
    //   468: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   471: invokestatic 537	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   474: pop
    //   475: aconst_null
    //   476: areturn
    //   477: new 528	java/io/BufferedReader
    //   480: dup
    //   481: new 552	java/io/InputStreamReader
    //   484: dup
    //   485: aload 7
    //   487: ldc_w 554
    //   490: invokespecial 557	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   493: invokespecial 559	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   496: astore 6
    //   498: ldc_w 524
    //   501: astore 31
    //   503: aload 6
    //   505: invokevirtual 562	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   508: astore 32
    //   510: aload 32
    //   512: ifnull +34 -> 546
    //   515: new 146	java/lang/StringBuilder
    //   518: dup
    //   519: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   522: aload 31
    //   524: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload 32
    //   529: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 564
    //   535: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: astore 31
    //   543: goto -40 -> 503
    //   546: aload 31
    //   548: ldc_w 524
    //   551: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   554: ifne +257 -> 811
    //   557: aload 31
    //   559: iconst_0
    //   560: aload 31
    //   562: ldc_w 564
    //   565: invokevirtual 568	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   568: invokevirtual 572	java/lang/String:substring	(II)Ljava/lang/String;
    //   571: astore 33
    //   573: new 191	java/lang/String
    //   576: dup
    //   577: aload 33
    //   579: ldc_w 554
    //   582: invokevirtual 576	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   585: ldc_w 473
    //   588: invokespecial 315	java/lang/String:<init>	([BLjava/lang/String;)V
    //   591: astore 34
    //   593: getstatic 427	com/bokecc/sdk/mobile/util/HttpUtil:LOG_LEVEL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   596: getstatic 432	com/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel:DETAIL	Lcom/bokecc/sdk/mobile/util/HttpUtil$HttpLogLevel;
    //   599: if_acmpne +12 -> 611
    //   602: ldc_w 578
    //   605: aload 34
    //   607: invokestatic 144	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   610: pop
    //   611: aload 7
    //   613: ifnull +8 -> 621
    //   616: aload 7
    //   618: invokevirtual 316	java/io/InputStream:close	()V
    //   621: aload 6
    //   623: ifnull +8 -> 631
    //   626: aload 6
    //   628: invokevirtual 529	java/io/BufferedReader:close	()V
    //   631: aload 34
    //   633: areturn
    //   634: astore 35
    //   636: aload_0
    //   637: getfield 35	com/bokecc/sdk/mobile/upload/Uploader:TAG	Ljava/lang/String;
    //   640: aload 35
    //   642: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   645: invokestatic 537	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   648: pop
    //   649: goto -18 -> 631
    //   652: astore 11
    //   654: aconst_null
    //   655: astore 6
    //   657: aconst_null
    //   658: astore 7
    //   660: aload_0
    //   661: getfield 35	com/bokecc/sdk/mobile/upload/Uploader:TAG	Ljava/lang/String;
    //   664: new 146	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   671: aload 11
    //   673: invokevirtual 581	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   676: ldc_w 524
    //   679: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokestatic 537	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   688: pop
    //   689: aload 7
    //   691: ifnull +8 -> 699
    //   694: aload 7
    //   696: invokevirtual 316	java/io/InputStream:close	()V
    //   699: aload 6
    //   701: ifnull -393 -> 308
    //   704: aload 6
    //   706: invokevirtual 529	java/io/BufferedReader:close	()V
    //   709: aconst_null
    //   710: areturn
    //   711: astore 13
    //   713: aload_0
    //   714: getfield 35	com/bokecc/sdk/mobile/upload/Uploader:TAG	Ljava/lang/String;
    //   717: aload 13
    //   719: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   722: invokestatic 537	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   725: pop
    //   726: aconst_null
    //   727: areturn
    //   728: astore 5
    //   730: aconst_null
    //   731: astore 6
    //   733: aconst_null
    //   734: astore 7
    //   736: aload 5
    //   738: astore 8
    //   740: aload 7
    //   742: ifnull +8 -> 750
    //   745: aload 7
    //   747: invokevirtual 316	java/io/InputStream:close	()V
    //   750: aload 6
    //   752: ifnull +8 -> 760
    //   755: aload 6
    //   757: invokevirtual 529	java/io/BufferedReader:close	()V
    //   760: aload 8
    //   762: athrow
    //   763: astore 9
    //   765: aload_0
    //   766: getfield 35	com/bokecc/sdk/mobile/upload/Uploader:TAG	Ljava/lang/String;
    //   769: aload 9
    //   771: invokevirtual 535	java/io/IOException:getMessage	()Ljava/lang/String;
    //   774: invokestatic 537	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   777: pop
    //   778: goto -18 -> 760
    //   781: astore 38
    //   783: aload 38
    //   785: astore 8
    //   787: aconst_null
    //   788: astore 6
    //   790: goto -50 -> 740
    //   793: astore 8
    //   795: goto -55 -> 740
    //   798: astore 11
    //   800: aconst_null
    //   801: astore 6
    //   803: goto -143 -> 660
    //   806: astore 11
    //   808: goto -148 -> 660
    //   811: aload 31
    //   813: astore 33
    //   815: goto -242 -> 573
    //
    // Exception table:
    //   from	to	target	type
    //   296	300	340	java/io/IOException
    //   304	308	340	java/io/IOException
    //   383	387	397	java/io/IOException
    //   391	395	397	java/io/IOException
    //   445	450	460	java/io/IOException
    //   454	458	460	java/io/IOException
    //   616	621	634	java/io/IOException
    //   626	631	634	java/io/IOException
    //   0	17	652	java/lang/Exception
    //   17	196	652	java/lang/Exception
    //   196	228	652	java/lang/Exception
    //   228	256	652	java/lang/Exception
    //   264	292	652	java/lang/Exception
    //   310	333	652	java/lang/Exception
    //   357	366	652	java/lang/Exception
    //   371	379	652	java/lang/Exception
    //   414	423	652	java/lang/Exception
    //   694	699	711	java/io/IOException
    //   704	709	711	java/io/IOException
    //   0	17	728	finally
    //   17	196	728	finally
    //   196	228	728	finally
    //   228	256	728	finally
    //   264	292	728	finally
    //   310	333	728	finally
    //   357	366	728	finally
    //   371	379	728	finally
    //   414	423	728	finally
    //   745	750	763	java/io/IOException
    //   755	760	763	java/io/IOException
    //   432	440	781	finally
    //   477	498	781	finally
    //   503	510	793	finally
    //   515	543	793	finally
    //   546	573	793	finally
    //   573	611	793	finally
    //   660	689	793	finally
    //   432	440	798	java/lang/Exception
    //   477	498	798	java/lang/Exception
    //   503	510	806	java/lang/Exception
    //   515	543	806	java/lang/Exception
    //   546	573	806	java/lang/Exception
    //   573	611	806	java/lang/Exception
  }

  private void v()
  {
    try
    {
      this.m.interrupt();
      this.m.join();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.e(this.TAG, localInterruptedException.getMessage());
      a(ErrorCode.NETWORK_ERROR);
    }
  }

  private void w()
    throws DreamwinException, XmlPullParserException, IOException
  {
    File localFile = new File(this.aG.getFilePath());
    String str1 = Md5Encrypt.md5(localFile);
    this.aG.setFileName(localFile.getName());
    this.aG.setFileByteSize(localFile.length() + "");
    this.aG.setMd5(str1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userid", this.aG.getUserId());
    localHashMap.put("title", this.aG.getTitle());
    localHashMap.put("description", this.aG.getDescription());
    localHashMap.put("tag", this.aG.getTags());
    String str2 = a("http://spark.bokecc.com/api/uploadvalidate", localHashMap, this.aG.getApiKey()).concat("&filename=").concat(HttpUtil.urlEncode(localFile.getName())).concat("&filesize=").concat(localFile.length() + "").concat("&videouploadtype=10&client_type=2&notify_url=").concat(this.aG.getNotifyUrl() + "");
    String str3 = this.aG.getCategoryId();
    if ((str3 != null) && (!"".equals(str3)))
      str2 = str2.concat("&categoryid=" + str3);
    String str4 = retrieve(str2, 5000, null, HttpUtil.HttpMethod.GET);
    if ((str4 == null) || ("".equals(str4)))
      throw new DreamwinException(ErrorCode.NETWORK_ERROR, new String[] { "Create Video Fail." });
    e(str4);
  }

  private void x()
    throws IOException, DreamwinException
  {
    this.status = 200;
    y();
    long l = a(this.aG);
    int i = 0;
    while (true)
      if (l == -2L)
      {
        l = a(this.aG);
        try
        {
          Thread.sleep(1000L);
          i++;
          if (i <= 9)
            continue;
          ErrorCode localErrorCode2 = ErrorCode.NETWORK_ERROR;
          String[] arrayOfString2 = new String[1];
          arrayOfString2[0] = ("upload error. range: " + l);
          throw new DreamwinException(localErrorCode2, arrayOfString2);
        }
        catch (InterruptedException localInterruptedException)
        {
          while (true)
            Log.e(this.TAG, localInterruptedException.getMessage());
        }
      }
    if (l < 0L)
    {
      if (l == -4L)
      {
        this.status = 400;
        y();
        return;
      }
      ErrorCode localErrorCode1 = ErrorCode.NETWORK_ERROR;
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = ("upload error. range: " + l);
      throw new DreamwinException(localErrorCode1, arrayOfString1);
    }
    this.aG.setRange(l);
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(this.aG.getFilePath(), "r");
    localRandomAccessFile.seek(this.aG.getRange());
    a(this.aG.getServer().concat("servlet/resumereceive").concat("?ccvid=").concat(this.aG.getVideoId()).concat("&range=").concat(this.aG.getRange() + "").concat("&version=").concat(HttpUtil.SDK_VERSION), localRandomAccessFile);
  }

  private void y()
  {
    if (this.aH == null)
      return;
    this.aH.handleStatus(this.aG, this.status);
  }

  private long z()
  {
    long l1 = System.currentTimeMillis();
    String str = retrieve("http://p.bokecc.com/api/system/localtime?format=json", 5000, null, HttpUtil.HttpMethod.GET);
    if ((str == null) || ("".equals(str)))
      return l1;
    try
    {
      long l2 = ((JSONObject)new JSONObject(str).get("system")).getLong("time");
      return l2;
    }
    catch (JSONException localJSONException)
    {
      Log.e(this.TAG, "server is error: " + localJSONException.getMessage());
    }
    return l1;
  }

  public void cancel()
  {
    if (this.status == 100);
    while (true)
    {
      return;
      if (this.status == 200)
      {
        this.status = 100;
        disconnectRequest();
        v();
        if (this.aH == null)
          continue;
        this.aH.handleCancel(this.aG.getVideoId());
      }
      if ((this.status != 300) && (this.status != 400))
        break;
      this.status = 100;
      v();
      if (this.aH == null)
        continue;
      this.aH.handleCancel(this.aG.getVideoId());
    }
    this.aG = null;
  }

  public void disconnectRequest()
  {
    if (this.q != null)
      this.q.getConnectionManager().shutdown();
  }

  public int getStatus()
  {
    return this.status;
  }

  public void pause()
  {
    if (this.status == 200)
    {
      this.status = 300;
      disconnectRequest();
      v();
      y();
    }
  }

  public void resume()
  {
    if (this.status == 300)
    {
      if (this.aG.getVideoId() == null)
      {
        this.status = 100;
        start();
      }
    }
    else
      return;
    this.aG.setUploadOrResume("2");
    this.m = new Thread(new b(this));
    this.m.start();
  }

  public void setUploadListener(UploadListener paramUploadListener)
  {
    this.aH = paramUploadListener;
  }

  public void start()
  {
    if (this.aG.getVideoId() != null)
    {
      this.status = 300;
      resume();
    }
    do
      return;
    while (this.status != 100);
    this.aG.setUploadOrResume("1");
    this.m = new Thread(new a(this));
    this.m.start();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.upload.Uploader
 * JD-Core Version:    0.6.0
 */