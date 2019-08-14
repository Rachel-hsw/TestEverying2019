package com.alipay.sdk.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alipay.sdk.data.c;
import com.alipay.sdk.exception.NetErrorException;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public final class a
{
  String a;
  private Context b;

  private a(Context paramContext)
  {
    this(paramContext, null);
  }

  public a(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.a = paramString;
  }

  private String a()
  {
    return this.a;
  }

  private static ByteArrayEntity a(c paramc, String paramString)
    throws IOException
  {
    String str = null;
    if (paramc != null)
    {
      str = paramc.c;
      if (!TextUtils.isEmpty(paramc.d))
        paramString = paramc.d + "=" + paramString;
    }
    if (TextUtils.isEmpty(str))
      str = "application/octet-stream;binary/octet-stream";
    ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(paramString.getBytes("utf-8"));
    localByteArrayEntity.setContentType(str);
    return localByteArrayEntity;
  }

  private void a(String paramString)
  {
    this.a = paramString;
  }

  private URL b()
  {
    try
    {
      URL localURL = new URL(this.a);
      return localURL;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private HttpResponse b(String paramString)
    throws NetErrorException
  {
    return a(paramString, null);
  }

  private HttpHost c()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      String str2 = g();
      if ((str2 == null) || (str2.contains("wap")));
    }
    String str1;
    int i;
    do
    {
      NetworkInfo localNetworkInfo;
      do
      {
        String str3;
        String str4;
        do
        {
          URL localURL;
          do
          {
            return null;
            localURL = b();
          }
          while (localURL == null);
          "https".equalsIgnoreCase(localURL.getProtocol());
          str3 = System.getProperty("https.proxyHost");
          str4 = System.getProperty("https.proxyPort");
        }
        while (TextUtils.isEmpty(str3));
        return new HttpHost(str3, Integer.parseInt(str4));
        localNetworkInfo = f();
      }
      while ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()) || (localNetworkInfo.getType() != 0));
      str1 = Proxy.getDefaultHost();
      i = Proxy.getDefaultPort();
    }
    while (str1 == null);
    return new HttpHost(str1, i);
  }

  private HttpHost d()
  {
    NetworkInfo localNetworkInfo = f();
    HttpHost localHttpHost = null;
    if (localNetworkInfo != null)
    {
      boolean bool = localNetworkInfo.isAvailable();
      localHttpHost = null;
      if (bool)
      {
        int i = localNetworkInfo.getType();
        localHttpHost = null;
        if (i == 0)
        {
          String str = Proxy.getDefaultHost();
          int j = Proxy.getDefaultPort();
          localHttpHost = null;
          if (str != null)
            localHttpHost = new HttpHost(str, j);
        }
      }
    }
    return localHttpHost;
  }

  private HttpHost e()
  {
    String str1 = g();
    if ((str1 != null) && (!str1.contains("wap")));
    String str2;
    String str3;
    do
    {
      URL localURL;
      do
      {
        return null;
        localURL = b();
      }
      while (localURL == null);
      "https".equalsIgnoreCase(localURL.getProtocol());
      str2 = System.getProperty("https.proxyHost");
      str3 = System.getProperty("https.proxyPort");
    }
    while (TextUtils.isEmpty(str2));
    return new HttpHost(str2, Integer.parseInt(str3));
  }

  private NetworkInfo f()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private String g()
  {
    try
    {
      NetworkInfo localNetworkInfo = f();
      if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable()))
      {
        if (localNetworkInfo.getType() == 1)
          return "wifi";
        String str = localNetworkInfo.getExtraInfo().toLowerCase();
        return str;
      }
      return "none";
    }
    catch (Exception localException)
    {
    }
    return "none";
  }

  public final HttpResponse a(String paramString, c paramc)
    throws NetErrorException
  {
    b localb = b.a();
    HttpResponse localHttpResponse = null;
    if (localb == null)
      return localHttpResponse;
    while (true)
    {
      try
      {
        HttpParams localHttpParams = localb.c.getParams();
        if (Build.VERSION.SDK_INT < 11)
          continue;
        String str3 = g();
        if ((str3 == null) || (str3.contains("wap")))
          continue;
        localObject1 = null;
        if (localObject1 == null)
          continue;
        localHttpParams.setParameter("http.route.default-proxy", localObject1);
        new StringBuilder("requestUrl : ").append(this.a).toString();
        if (!TextUtils.isEmpty(paramString))
          continue;
        localObject2 = new HttpGet(this.a);
        if (paramc == null)
          continue;
        ArrayList localArrayList = paramc.a();
        if (localArrayList == null)
          continue;
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext())
          continue;
        ((HttpUriRequest)localObject2).addHeader((Header)localIterator.next());
        continue;
      }
      catch (NetErrorException localNetErrorException)
      {
        throw localNetErrorException;
        URL localURL = b();
        if (localURL == null)
          break label617;
        "https".equalsIgnoreCase(localURL.getProtocol());
        String str4 = System.getProperty("https.proxyHost");
        String str5 = System.getProperty("https.proxyPort");
        if (TextUtils.isEmpty(str4))
          break label617;
        localObject1 = new HttpHost(str4, Integer.parseInt(str5));
        continue;
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        if (localb == null)
          continue;
        localb.b();
        throw new NetErrorException();
        NetworkInfo localNetworkInfo = f();
        if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()) || (localNetworkInfo.getType() != 0))
          break label611;
        String str2 = Proxy.getDefaultHost();
        int i = Proxy.getDefaultPort();
        if (str2 == null)
          break label611;
        localObject1 = new HttpHost(str2, i);
        continue;
      }
      catch (SocketException localSocketException)
      {
        throw new NetErrorException();
        localObject2 = new HttpPost(this.a);
        if (paramc != null)
        {
          str1 = paramc.c;
          if (TextUtils.isEmpty(paramc.d))
            continue;
          paramString = paramc.d + "=" + paramString;
          if (!TextUtils.isEmpty(str1))
            continue;
          str1 = "application/octet-stream;binary/octet-stream";
          ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(paramString.getBytes("utf-8"));
          localByteArrayEntity.setContentType(str1);
          ((HttpPost)localObject2).setEntity(localByteArrayEntity);
          ((HttpUriRequest)localObject2).addHeader("Accept-Charset", "UTF-8");
          ((HttpUriRequest)localObject2).addHeader("Accept-Encoding", "gzip");
          ((HttpUriRequest)localObject2).addHeader("Connection", "Keep-Alive");
          ((HttpUriRequest)localObject2).addHeader("Keep-Alive", "timeout=180, max=100");
          continue;
        }
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        Object localObject2;
        if (localb == null)
          continue;
        localb.b();
        throw new NetErrorException();
        localHttpResponse = localb.a((HttpUriRequest)localObject2);
        Header[] arrayOfHeader1 = localHttpResponse.getHeaders("X-Hostname");
        if ((arrayOfHeader1 == null) || (arrayOfHeader1.length <= 0) || (arrayOfHeader1[0] == null))
          continue;
        localHttpResponse.getHeaders("X-Hostname")[0].toString();
        Header[] arrayOfHeader2 = localHttpResponse.getHeaders("X-ExecuteTime");
        if ((arrayOfHeader2 == null) || (arrayOfHeader2.length <= 0) || (arrayOfHeader2[0] == null))
          break;
        localHttpResponse.getHeaders("X-ExecuteTime")[0].toString();
        return localHttpResponse;
      }
      catch (Exception localException)
      {
        throw new NetErrorException();
      }
      String str1 = null;
      continue;
      label611: Object localObject1 = null;
      continue;
      label617: localObject1 = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.net.a
 * JD-Core Version:    0.6.0
 */