package com.umeng.message.b;

import android.content.Context;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import org.android.agoo.c.a.b;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public class bp
  implements Runnable
{
  private static final String a = "AsyncHttp.request";
  private final AbstractHttpClient b;
  private final HttpContext c;
  private final HttpUriRequest d;
  private final b e;
  private volatile boolean f;
  private Context g;

  public bp(Context paramContext, AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, HttpHost paramHttpHost, HttpUriRequest paramHttpUriRequest, b paramb)
  {
    this.b = paramAbstractHttpClient;
    this.c = paramHttpContext;
    this.g = paramContext;
    this.d = paramHttpUriRequest;
    this.e = paramb;
    if (paramHttpHost != null)
      paramAbstractHttpClient.getParams().setParameter("http.route.default-proxy", paramHttpHost);
  }

  private final void a()
    throws IOException
  {
    if (!Thread.currentThread().isInterrupted())
    {
      HttpResponse localHttpResponse = this.b.execute(this.d, this.c);
      ay.b("AsyncHttp.request", "http request:[" + this.d.getURI().toString() + "]===response[:" + localHttpResponse.getStatusLine().getStatusCode() + "]");
      if ((!Thread.currentThread().isInterrupted()) && (this.e != null))
        this.e.a(localHttpResponse);
    }
  }

  private void b()
    throws ConnectException
  {
    while (true)
      try
      {
        a();
        return;
      }
      catch (IOException localIOException)
      {
        ay.e("AsyncHttp.request", "http request makeRequestWithRetries", localIOException);
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        ay.e("AsyncHttp.request", "", localNullPointerException);
        new IOException("NPE in HttpClient" + localNullPointerException.getMessage());
      }
  }

  public final void run()
  {
    try
    {
      if (this.e != null)
        this.e.a();
      if (!bk.a(this.g))
        this.e.a(new RuntimeException("http request network connection error[" + this.d.getURI().toString() + "]"));
      while (this.e != null)
      {
        this.e.b();
        return;
        b();
      }
    }
    catch (IOException localIOException)
    {
      ay.e("AsyncHttp.request", "http request io", localIOException);
      if (this.e != null)
      {
        this.e.b();
        if (this.f)
        {
          this.e.a(localIOException);
          return;
        }
        this.e.a(localIOException);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bp
 * JD-Core Version:    0.6.0
 */