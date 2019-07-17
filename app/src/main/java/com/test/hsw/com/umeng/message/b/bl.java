package com.umeng.message.b;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.android.agoo.c.a.d;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class bl
{
  private static final int a = 10;
  private static final int b = 10000;
  private static final int c = 3;
  private static final int d = 8192;
  private static final String e = "Accept-Encoding";
  private static final String f = "gzip";
  private static int g = 10;
  private static int h = 10000;
  private final DefaultHttpClient i;
  private final HttpContext j;
  private final Map<String, String> k;

  public bl()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, h);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(g));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, h);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, h);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Double.valueOf(2.0D);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, String.format("Agoo-sdk-%s", arrayOfObject));
    this.k = new HashMap();
    this.j = new SyncBasicHttpContext(new BasicHttpContext());
    this.i = new DefaultHttpClient(localBasicHttpParams);
    this.i.addRequestInterceptor(new bm(this));
    this.i.addResponseInterceptor(new bn(this));
    this.i.setRedirectHandler(new bo(this));
  }

  protected final String a(String paramString, d paramd)
  {
    if (paramd != null)
    {
      String str = paramd.c();
      paramString = paramString + "?" + str;
    }
    return paramString;
  }

  public final DefaultHttpClient a()
  {
    return this.i;
  }

  public final void a(int paramInt)
  {
    HttpParams localHttpParams = this.i.getParams();
    ConnManagerParams.setTimeout(localHttpParams, paramInt);
    HttpConnectionParams.setSoTimeout(localHttpParams, paramInt);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, paramInt);
  }

  public final void a(String paramString1, String paramString2)
  {
    this.k.put(paramString1, paramString2);
  }

  public final void a(String paramString1, String paramString2, AuthScope paramAuthScope)
  {
    UsernamePasswordCredentials localUsernamePasswordCredentials = new UsernamePasswordCredentials(paramString1, paramString2);
    this.i.getCredentialsProvider().setCredentials(paramAuthScope, localUsernamePasswordCredentials);
  }

  public final void a(HttpRequestInterceptor paramHttpRequestInterceptor)
  {
    this.i.addRequestInterceptor(paramHttpRequestInterceptor);
  }

  public final void a(CookieStore paramCookieStore)
  {
    this.j.setAttribute("http.cookie-store", paramCookieStore);
  }

  public final void a(SSLSocketFactory paramSSLSocketFactory)
  {
    this.i.getConnectionManager().getSchemeRegistry().register(new Scheme("https", paramSSLSocketFactory, 443));
  }

  public final void a_(String paramString)
  {
    HttpProtocolParams.setUserAgent(this.i.getParams(), paramString);
  }

  public final HttpContext b()
  {
    return this.j;
  }

  public final void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, AuthScope.ANY);
  }

  static final class a extends HttpEntityWrapper
  {
    public a(HttpEntity paramHttpEntity)
    {
      super();
    }

    public final InputStream getContent()
      throws IOException
    {
      return new GZIPInputStream(this.wrappedEntity.getContent());
    }

    public final long getContentLength()
    {
      return -1L;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bl
 * JD-Core Version:    0.6.0
 */