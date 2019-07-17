package com.baidu.location.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public abstract class m
  implements f
{
  public static int c8 = g.w;
  private static String dd = "10.0.0.172";
  protected static int de;
  private static int df = 80;
  public String c5 = null;
  public HttpEntity c6 = null;
  public List c7 = null;
  private boolean c9 = false;
  public String da = null;
  public byte[] db = null;
  public String dc = null;
  public int dg = 3;

  static
  {
    de = 0;
  }

  private void am()
  {
    c8 = aq();
  }

  private int aq()
  {
    Context localContext = com.baidu.location.f.getServiceContext();
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)localContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
        return g.w;
      NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()))
        return g.w;
      if (localNetworkInfo.getType() == 1)
      {
        String str = Proxy.getDefaultHost();
        if ((str != null) && (str.length() > 0))
          return g.p;
        return g.o;
      }
      int i = jdMethod_if(localContext, localNetworkInfo);
      return i;
    }
    catch (Exception localException)
    {
    }
    return g.w;
  }

  private static int jdMethod_if(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.getExtraInfo() != null))
    {
      String str2 = paramNetworkInfo.getExtraInfo().toLowerCase();
      if (str2 != null)
      {
        if ((str2.startsWith("cmwap")) || (str2.startsWith("uniwap")) || (str2.startsWith("3gwap")))
        {
          String str3 = Proxy.getDefaultHost();
          if ((str3 != null) && (!str3.equals("")) && (!str3.equals("null")));
          while (true)
          {
            dd = str3;
            return g.byte;
            str3 = "10.0.0.172";
          }
        }
        if (str2.startsWith("ctwap"))
        {
          String str4 = Proxy.getDefaultHost();
          if ((str4 != null) && (!str4.equals("")) && (!str4.equals("null")));
          while (true)
          {
            dd = str4;
            return g.byte;
            str4 = "10.0.0.200";
          }
        }
        if ((str2.startsWith("cmnet")) || (str2.startsWith("uninet")) || (str2.startsWith("ctnet")) || (str2.startsWith("3gnet")))
          return g.for;
      }
    }
    String str1 = Proxy.getDefaultHost();
    if ((str1 != null) && (str1.length() > 0))
    {
      if ("10.0.0.172".equals(str1.trim()))
      {
        dd = "10.0.0.172";
        return g.byte;
      }
      if ("10.0.0.200".equals(str1.trim()))
      {
        dd = "10.0.0.200";
        return g.byte;
      }
    }
    return g.for;
  }

  public static HttpClient jdMethod_if(HttpParams paramHttpParams)
  {
    try
    {
      KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
      localKeyStore.load(null, null);
      a locala = new a(localKeyStore);
      locala.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      HttpProtocolParams.setVersion(paramHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(paramHttpParams, "UTF-8");
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", locala, 443));
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(paramHttpParams, localSchemeRegistry), paramHttpParams);
      return localDefaultHttpClient;
    }
    catch (Exception localException)
    {
    }
    return new DefaultHttpClient(paramHttpParams);
  }

  public static boolean jdMethod_int(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager.getActiveNetworkInfo() != null)
      {
        boolean bool = localConnectivityManager.getActiveNetworkInfo().isAvailable();
        return bool;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }

  public void an()
  {
    new m.5(this).start();
  }

  public void ao()
  {
    new m.3(this).start();
  }

  public void ap()
  {
    new m.2(this).start();
  }

  public void as()
  {
    new m.1(this).start();
  }

  public void at()
  {
    new m.4(this).start();
  }

  public abstract void au();

  public void av()
  {
    new m.6(this).start();
  }

  public abstract void jdMethod_int(boolean paramBoolean);

  public static class a extends org.apache.http.conn.ssl.SSLSocketFactory
  {
    final SSLContext a = SSLContext.getInstance("TLS");

    public a(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
      super();
      m.a.1 local1 = new m.a.1(this);
      this.a.init(null, new TrustManager[] { local1 }, null);
    }

    public Socket createSocket()
      throws IOException
    {
      return this.a.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
      throws IOException, UnknownHostException
    {
      return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.m
 * JD-Core Version:    0.6.0
 */