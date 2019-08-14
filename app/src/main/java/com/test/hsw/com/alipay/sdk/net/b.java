package com.alipay.sdk.net;

import android.os.Build.VERSION;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class b
{
  public static final String a = "msp";
  public static b b;
  final DefaultHttpClient c;

  private b(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    this.c = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams);
  }

  private b(HttpParams paramHttpParams)
  {
    this.c = new DefaultHttpClient(paramHttpParams);
  }

  public static b a()
  {
    BasicHttpParams localBasicHttpParams;
    if (b == null)
    {
      localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
      localBasicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 50);
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(30));
      ConnManagerParams.setTimeout(localBasicHttpParams, 1000L);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
      HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 16384);
      HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
      HttpClientParams.setRedirecting(localBasicHttpParams, true);
      HttpClientParams.setAuthenticating(localBasicHttpParams, false);
      HttpProtocolParams.setUserAgent(localBasicHttpParams, "msp");
    }
    try
    {
      SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
      localSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      Scheme localScheme1 = new Scheme("https", localSSLSocketFactory, 443);
      Scheme localScheme2 = new Scheme("http", PlainSocketFactory.getSocketFactory(), 80);
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(localScheme1);
      localSchemeRegistry.register(localScheme2);
      b = new b(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      return b;
    }
    catch (Exception localException)
    {
      while (true)
        b = new b(localBasicHttpParams);
    }
  }

  private <T> T a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws Exception
  {
    try
    {
      Object localObject = this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  private <T> T a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws Exception
  {
    try
    {
      Object localObject = this.c.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  private <T> T a(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler)
    throws Exception
  {
    try
    {
      Object localObject = this.c.execute(paramHttpUriRequest, paramResponseHandler);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  private <T> T a(HttpUriRequest paramHttpUriRequest, ResponseHandler<? extends T> paramResponseHandler, HttpContext paramHttpContext)
    throws Exception
  {
    try
    {
      Object localObject = this.c.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
    throws Exception
  {
    try
    {
      HttpResponse localHttpResponse = this.c.execute(paramHttpHost, paramHttpRequest);
      return localHttpResponse;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  private HttpResponse a(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    throws Exception
  {
    try
    {
      HttpResponse localHttpResponse = this.c.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
      return localHttpResponse;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  private HttpResponse a(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
    throws Exception
  {
    try
    {
      HttpResponse localHttpResponse = this.c.execute(paramHttpUriRequest, paramHttpContext);
      return localHttpResponse;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  private static b c()
  {
    return b;
  }

  private static void d()
  {
    b = null;
  }

  private void e()
  {
    ClientConnectionManager localClientConnectionManager = this.c.getConnectionManager();
    if (localClientConnectionManager != null)
    {
      localClientConnectionManager.closeExpiredConnections();
      if (Build.VERSION.SDK_INT >= 9)
        localClientConnectionManager.closeIdleConnections(30L, TimeUnit.MINUTES);
    }
  }

  private HttpParams f()
  {
    return this.c.getParams();
  }

  private ClientConnectionManager g()
  {
    return this.c.getConnectionManager();
  }

  public final HttpResponse a(HttpUriRequest paramHttpUriRequest)
    throws Exception
  {
    try
    {
      HttpResponse localHttpResponse = this.c.execute(paramHttpUriRequest);
      return localHttpResponse;
    }
    catch (Exception localException)
    {
    }
    throw new Exception(localException);
  }

  public final void b()
  {
    ClientConnectionManager localClientConnectionManager = this.c.getConnectionManager();
    if (localClientConnectionManager != null)
    {
      localClientConnectionManager.shutdown();
      b = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.net.b
 * JD-Core Version:    0.6.0
 */