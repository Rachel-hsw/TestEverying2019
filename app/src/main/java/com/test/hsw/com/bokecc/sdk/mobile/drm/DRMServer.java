package com.bokecc.sdk.mobile.drm;

import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpService;

public class DRMServer
{
  private boolean E = false;
  private BasicHttpProcessor F = null;
  private BasicHttpContext G = null;
  private HttpService H = null;
  private HttpRequestHandlerRegistry I = null;
  private ServerSocket J;
  private int port;

  public DRMServer()
  {
    this.F.addInterceptor(new h());
    this.H = new HttpService(this.F, new DefaultConnectionReuseStrategy(), new DefaultHttpResponseFactory());
    this.I = new HttpRequestHandlerRegistry();
    this.I.register("*", new f());
    this.H.setHandlerResolver(this.I);
  }

  // ERROR //
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/bokecc/sdk/mobile/drm/DRMServer:E	Z
    //   4: ifeq +624 -> 628
    //   7: aconst_null
    //   8: astore 5
    //   10: new 88	org/apache/http/impl/DefaultHttpServerConnection
    //   13: dup
    //   14: invokespecial 89	org/apache/http/impl/DefaultHttpServerConnection:<init>	()V
    //   17: astore 6
    //   19: aload_0
    //   20: getfield 91	com/bokecc/sdk/mobile/drm/DRMServer:J	Ljava/net/ServerSocket;
    //   23: invokevirtual 97	java/net/ServerSocket:accept	()Ljava/net/Socket;
    //   26: astore 5
    //   28: aload 6
    //   30: aload 5
    //   32: new 99	org/apache/http/params/BasicHttpParams
    //   35: dup
    //   36: invokespecial 100	org/apache/http/params/BasicHttpParams:<init>	()V
    //   39: invokevirtual 104	org/apache/http/impl/DefaultHttpServerConnection:bind	(Ljava/net/Socket;Lorg/apache/http/params/HttpParams;)V
    //   42: aload_0
    //   43: getfield 29	com/bokecc/sdk/mobile/drm/DRMServer:H	Lorg/apache/http/protocol/HttpService;
    //   46: aload 6
    //   48: aload_0
    //   49: getfield 27	com/bokecc/sdk/mobile/drm/DRMServer:G	Lorg/apache/http/protocol/BasicHttpContext;
    //   52: invokevirtual 108	org/apache/http/protocol/HttpService:handleRequest	(Lorg/apache/http/HttpServerConnection;Lorg/apache/http/protocol/HttpContext;)V
    //   55: aload 5
    //   57: ifnull +8 -> 65
    //   60: aload 5
    //   62: invokevirtual 113	java/net/Socket:close	()V
    //   65: aload 6
    //   67: invokevirtual 116	org/apache/http/impl/DefaultHttpServerConnection:shutdown	()V
    //   70: goto -70 -> 0
    //   73: astore 30
    //   75: ldc 118
    //   77: new 120	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   84: aload 30
    //   86: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   89: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 131
    //   94: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   103: pop
    //   104: goto -104 -> 0
    //   107: astore_3
    //   108: ldc 142
    //   110: new 120	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   117: aload_3
    //   118: invokevirtual 143	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 131
    //   126: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   135: pop
    //   136: aload_0
    //   137: iconst_0
    //   138: putfield 23	com/bokecc/sdk/mobile/drm/DRMServer:E	Z
    //   141: return
    //   142: astore 32
    //   144: ldc 145
    //   146: new 120	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   153: aload 32
    //   155: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 131
    //   163: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   172: pop
    //   173: goto -108 -> 65
    //   176: astore_1
    //   177: ldc 142
    //   179: new 120	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   186: aload_1
    //   187: invokevirtual 146	java/io/IOException:getMessage	()Ljava/lang/String;
    //   190: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 131
    //   195: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   204: pop
    //   205: goto -69 -> 136
    //   208: astore 24
    //   210: ldc 148
    //   212: new 120	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   219: aload 24
    //   221: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: ldc 131
    //   226: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 154	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   235: pop
    //   236: aload 5
    //   238: ifnull +8 -> 246
    //   241: aload 5
    //   243: invokevirtual 113	java/net/Socket:close	()V
    //   246: aload 6
    //   248: invokevirtual 116	org/apache/http/impl/DefaultHttpServerConnection:shutdown	()V
    //   251: goto -251 -> 0
    //   254: astore 26
    //   256: ldc 118
    //   258: new 120	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   265: aload 26
    //   267: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   270: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 131
    //   275: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   284: pop
    //   285: goto -285 -> 0
    //   288: astore 28
    //   290: ldc 145
    //   292: new 120	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   299: aload 28
    //   301: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   304: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc 131
    //   309: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   318: pop
    //   319: goto -73 -> 246
    //   322: astore 18
    //   324: ldc 148
    //   326: new 120	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   333: aload 18
    //   335: invokevirtual 146	java/io/IOException:getMessage	()Ljava/lang/String;
    //   338: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc 131
    //   343: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 154	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   352: pop
    //   353: aload 5
    //   355: ifnull +8 -> 363
    //   358: aload 5
    //   360: invokevirtual 113	java/net/Socket:close	()V
    //   363: aload 6
    //   365: invokevirtual 116	org/apache/http/impl/DefaultHttpServerConnection:shutdown	()V
    //   368: goto -368 -> 0
    //   371: astore 20
    //   373: ldc 118
    //   375: new 120	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   382: aload 20
    //   384: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   387: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: ldc 131
    //   392: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   401: pop
    //   402: goto -402 -> 0
    //   405: astore 22
    //   407: ldc 145
    //   409: new 120	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   416: aload 22
    //   418: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: ldc 131
    //   426: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   435: pop
    //   436: goto -73 -> 363
    //   439: astore 12
    //   441: ldc 156
    //   443: aload 12
    //   445: invokevirtual 157	org/apache/http/HttpException:getMessage	()Ljava/lang/String;
    //   448: aload 12
    //   450: invokestatic 160	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   453: pop
    //   454: aload 5
    //   456: ifnull +8 -> 464
    //   459: aload 5
    //   461: invokevirtual 113	java/net/Socket:close	()V
    //   464: aload 6
    //   466: invokevirtual 116	org/apache/http/impl/DefaultHttpServerConnection:shutdown	()V
    //   469: goto -469 -> 0
    //   472: astore 14
    //   474: ldc 118
    //   476: new 120	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   483: aload 14
    //   485: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   488: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc 131
    //   493: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   502: pop
    //   503: goto -503 -> 0
    //   506: astore 16
    //   508: ldc 145
    //   510: new 120	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   517: aload 16
    //   519: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   522: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc 131
    //   527: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   536: pop
    //   537: goto -73 -> 464
    //   540: astore 7
    //   542: aload 5
    //   544: ifnull +8 -> 552
    //   547: aload 5
    //   549: invokevirtual 113	java/net/Socket:close	()V
    //   552: aload 6
    //   554: invokevirtual 116	org/apache/http/impl/DefaultHttpServerConnection:shutdown	()V
    //   557: aload 7
    //   559: athrow
    //   560: astore 10
    //   562: ldc 145
    //   564: new 120	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   571: aload 10
    //   573: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   576: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: ldc 131
    //   581: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   590: pop
    //   591: goto -39 -> 552
    //   594: astore 8
    //   596: ldc 118
    //   598: new 120	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   605: aload 8
    //   607: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   610: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc 131
    //   615: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 140	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   624: pop
    //   625: goto -68 -> 557
    //   628: ldc 162
    //   630: ldc 164
    //   632: invokestatic 154	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   635: pop
    //   636: aload_0
    //   637: getfield 91	com/bokecc/sdk/mobile/drm/DRMServer:J	Ljava/net/ServerSocket;
    //   640: invokevirtual 165	java/net/ServerSocket:close	()V
    //   643: goto -507 -> 136
    //
    // Exception table:
    //   from	to	target	type
    //   65	70	73	java/lang/Exception
    //   0	7	107	java/net/SocketException
    //   10	19	107	java/net/SocketException
    //   60	65	107	java/net/SocketException
    //   65	70	107	java/net/SocketException
    //   75	104	107	java/net/SocketException
    //   144	173	107	java/net/SocketException
    //   241	246	107	java/net/SocketException
    //   246	251	107	java/net/SocketException
    //   256	285	107	java/net/SocketException
    //   290	319	107	java/net/SocketException
    //   358	363	107	java/net/SocketException
    //   363	368	107	java/net/SocketException
    //   373	402	107	java/net/SocketException
    //   407	436	107	java/net/SocketException
    //   459	464	107	java/net/SocketException
    //   464	469	107	java/net/SocketException
    //   474	503	107	java/net/SocketException
    //   508	537	107	java/net/SocketException
    //   547	552	107	java/net/SocketException
    //   552	557	107	java/net/SocketException
    //   557	560	107	java/net/SocketException
    //   562	591	107	java/net/SocketException
    //   596	625	107	java/net/SocketException
    //   628	643	107	java/net/SocketException
    //   60	65	142	java/lang/Exception
    //   0	7	176	java/io/IOException
    //   10	19	176	java/io/IOException
    //   60	65	176	java/io/IOException
    //   65	70	176	java/io/IOException
    //   75	104	176	java/io/IOException
    //   144	173	176	java/io/IOException
    //   241	246	176	java/io/IOException
    //   246	251	176	java/io/IOException
    //   256	285	176	java/io/IOException
    //   290	319	176	java/io/IOException
    //   358	363	176	java/io/IOException
    //   363	368	176	java/io/IOException
    //   373	402	176	java/io/IOException
    //   407	436	176	java/io/IOException
    //   459	464	176	java/io/IOException
    //   464	469	176	java/io/IOException
    //   474	503	176	java/io/IOException
    //   508	537	176	java/io/IOException
    //   547	552	176	java/io/IOException
    //   552	557	176	java/io/IOException
    //   557	560	176	java/io/IOException
    //   562	591	176	java/io/IOException
    //   596	625	176	java/io/IOException
    //   628	643	176	java/io/IOException
    //   19	55	208	java/lang/IllegalStateException
    //   246	251	254	java/lang/Exception
    //   241	246	288	java/lang/Exception
    //   19	55	322	java/io/IOException
    //   363	368	371	java/lang/Exception
    //   358	363	405	java/lang/Exception
    //   19	55	439	org/apache/http/HttpException
    //   464	469	472	java/lang/Exception
    //   459	464	506	java/lang/Exception
    //   19	55	540	finally
    //   210	236	540	finally
    //   324	353	540	finally
    //   441	454	540	finally
    //   547	552	560	java/lang/Exception
    //   552	557	594	java/lang/Exception
  }

  public int getPort()
  {
    return this.port;
  }

  public void start()
  {
    this.E = true;
    if (this.J == null);
    try
    {
      this.J = new ServerSocket();
      this.J.setReuseAddress(true);
      this.J.bind(new InetSocketAddress(0));
      this.port = this.J.getLocalPort();
      Log.i("DRMServer", "server start. port: " + this.port);
      new Thread(new a(this)).start();
      new Thread(new b(this)).start();
      return;
    }
    catch (IOException localIOException)
    {
      Log.i("DRMServer error", localIOException.getMessage() + " BP: " + this.port);
    }
  }

  public void stop()
  {
    this.E = false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.DRMServer
 * JD-Core Version:    0.6.0
 */