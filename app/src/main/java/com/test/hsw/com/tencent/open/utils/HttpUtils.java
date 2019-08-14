package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtils
{
  private static final String a = HttpUtils.class.getName();

  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11)
      if (paramContext != null)
      {
        i = Proxy.getPort(paramContext);
        if (i < 0)
          i = Proxy.getDefaultPort();
      }
    String str;
    do
    {
      return i;
      return Proxy.getDefaultPort();
      str = System.getProperty("http.proxyPort");
    }
    while (TextUtils.isEmpty(str));
    try
    {
      int j = Integer.parseInt(str);
      return j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return i;
  }

  private static String a(HttpResponse paramHttpResponse)
    throws IllegalStateException, IOException
  {
    InputStream localInputStream = paramHttpResponse.getEntity().getContent();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((localHeader != null) && (localHeader.getValue().toLowerCase().indexOf("gzip") > -1));
    for (Object localObject = new GZIPInputStream(localInputStream); ; localObject = localInputStream)
    {
      byte[] arrayOfByte = new byte[512];
      while (true)
      {
        int i = ((InputStream)localObject).read(arrayOfByte);
        if (i == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
    }
  }

  private static void a(Context paramContext, QQToken paramQQToken, String paramString)
  {
    if ((paramString.indexOf("add_share") > -1) || (paramString.indexOf("upload_pic") > -1) || (paramString.indexOf("add_topic") > -1) || (paramString.indexOf("set_user_face") > -1) || (paramString.indexOf("add_t") > -1) || (paramString.indexOf("add_pic_t") > -1) || (paramString.indexOf("add_pic_url") > -1) || (paramString.indexOf("add_video") > -1))
      a.a(paramContext, paramQQToken, "requireApi", new String[] { paramString });
  }

  private static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        if (TextUtils.isEmpty(str))
          str = Proxy.getDefaultHost();
        return str;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }

  public static String encodePostBody(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramBundle.size();
    Iterator localIterator = paramBundle.keySet().iterator();
    int j = -1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int k = j + 1;
      Object localObject = paramBundle.get(str);
      if (!(localObject instanceof String))
      {
        j = k;
        continue;
      }
      localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"" + "\r\n" + "\r\n" + (String)localObject);
      if (k < i - 1)
        localStringBuilder.append("\r\n--" + paramString + "\r\n");
      j = k;
    }
    return localStringBuilder.toString();
  }

  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if ((!(localObject instanceof String)) && (!(localObject instanceof String[])))
        continue;
      label129: label171: label205: int j;
      if ((localObject instanceof String[]))
      {
        String[] arrayOfString;
        int k;
        if (i != 0)
        {
          i = 0;
          localStringBuilder.append(URLEncoder.encode(str) + "=");
          arrayOfString = paramBundle.getStringArray(str);
          if (arrayOfString == null)
            continue;
          k = 0;
          if (k >= arrayOfString.length)
            break label205;
          if (k != 0)
            break label171;
          localStringBuilder.append(URLEncoder.encode(arrayOfString[k]));
        }
        while (true)
        {
          k++;
          break label129;
          localStringBuilder.append("&");
          break;
          localStringBuilder.append(URLEncoder.encode("," + arrayOfString[k]));
        }
        j = i;
        i = j;
        continue;
      }
      if (i != 0)
        i = 0;
      while (true)
      {
        localStringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(paramBundle.getString(str)));
        j = i;
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }

  public static int getErrorCodeFromException(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException))
      return -20;
    if ((paramIOException instanceof MalformedInputException))
      return -21;
    if ((paramIOException instanceof UnmappableCharacterException))
      return -22;
    if ((paramIOException instanceof HttpResponseException))
      return -23;
    if ((paramIOException instanceof ClosedChannelException))
      return -24;
    if ((paramIOException instanceof ConnectionClosedException))
      return -25;
    if ((paramIOException instanceof EOFException))
      return -26;
    if ((paramIOException instanceof FileLockInterruptionException))
      return -27;
    if ((paramIOException instanceof FileNotFoundException))
      return -28;
    if ((paramIOException instanceof HttpRetryException))
      return -29;
    if ((paramIOException instanceof ConnectTimeoutException))
      return -7;
    if ((paramIOException instanceof SocketTimeoutException))
      return -8;
    if ((paramIOException instanceof InvalidPropertiesFormatException))
      return -30;
    if ((paramIOException instanceof MalformedChunkCodingException))
      return -31;
    if ((paramIOException instanceof MalformedURLException))
      return -3;
    if ((paramIOException instanceof NoHttpResponseException))
      return -32;
    if ((paramIOException instanceof InvalidClassException))
      return -33;
    if ((paramIOException instanceof InvalidObjectException))
      return -34;
    if ((paramIOException instanceof NotActiveException))
      return -35;
    if ((paramIOException instanceof NotSerializableException))
      return -36;
    if ((paramIOException instanceof OptionalDataException))
      return -37;
    if ((paramIOException instanceof StreamCorruptedException))
      return -38;
    if ((paramIOException instanceof WriteAbortedException))
      return -39;
    if ((paramIOException instanceof ProtocolException))
      return -40;
    if ((paramIOException instanceof SSLHandshakeException))
      return -41;
    if ((paramIOException instanceof SSLKeyException))
      return -42;
    if ((paramIOException instanceof SSLPeerUnverifiedException))
      return -43;
    if ((paramIOException instanceof SSLProtocolException))
      return -44;
    if ((paramIOException instanceof BindException))
      return -45;
    if ((paramIOException instanceof ConnectException))
      return -46;
    if ((paramIOException instanceof NoRouteToHostException))
      return -47;
    if ((paramIOException instanceof PortUnreachableException))
      return -48;
    if ((paramIOException instanceof SyncFailedException))
      return -49;
    if ((paramIOException instanceof UTFDataFormatException))
      return -50;
    if ((paramIOException instanceof UnknownHostException))
      return -51;
    if ((paramIOException instanceof UnknownServiceException))
      return -52;
    if ((paramIOException instanceof UnsupportedEncodingException))
      return -53;
    if ((paramIOException instanceof ZipException))
      return -54;
    return -2;
  }

  public static HttpClient getHttpClient(Context paramContext, String paramString1, String paramString2)
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    if (Build.VERSION.SDK_INT < 16);
    while (true)
    {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        localKeyStore.load(null, null);
        CustomSSLSocketFactory localCustomSSLSocketFactory = new CustomSSLSocketFactory(localKeyStore);
        localCustomSSLSocketFactory.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        localSchemeRegistry.register(new Scheme("https", localCustomSSLSocketFactory, 443));
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        if (paramContext == null)
          break label366;
        localOpenConfig = OpenConfig.getInstance(paramContext, paramString1);
        if (localOpenConfig == null)
          break label357;
        j = localOpenConfig.getInt("Common_HttpConnectionTimeout");
        i = localOpenConfig.getInt("Common_SocketConnectionTimeout");
        if (j != 0)
          continue;
        j = 15000;
        if (i != 0)
          continue;
        i = 30000;
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, j);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, i);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
        NetworkProxy localNetworkProxy = getProxy(paramContext);
        if (localNetworkProxy == null)
          continue;
        HttpHost localHttpHost = new HttpHost(localNetworkProxy.host, localNetworkProxy.port);
        localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
        return localDefaultHttpClient;
      }
      catch (Exception localException)
      {
        localSchemeRegistry.register(new Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
        continue;
      }
      localSchemeRegistry.register(new Scheme("https", org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory(), 443));
      continue;
      label357: int i = 0;
      int j = 0;
      continue;
      label366: OpenConfig localOpenConfig = null;
    }
  }

  public static NetworkProxy getProxy(Context paramContext)
  {
    if (paramContext == null)
      return null;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return null;
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return null;
    if (localNetworkInfo.getType() == 0)
    {
      String str = b(paramContext);
      int i = a(paramContext);
      if ((!TextUtils.isEmpty(str)) && (i >= 0))
        return new NetworkProxy(str, i, null);
    }
    return null;
  }

  public static Util.Statistic openUrl2(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws MalformedURLException, IOException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    if (paramContext != null)
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()))
          throw new NetworkUnavailableException("network unavailable");
      }
    }
    Bundle localBundle1;
    HttpClient localHttpClient;
    String str5;
    label178: Object localObject1;
    int i;
    if (paramBundle != null)
    {
      localBundle1 = new Bundle(paramBundle);
      String str1 = localBundle1.getString("appid_for_getting_config");
      localBundle1.remove("appid_for_getting_config");
      localHttpClient = getHttpClient(paramContext, str1, paramString1);
      if (!paramString2.equals("GET"))
        break label349;
      String str4 = encodeUrl(localBundle1);
      int n = 0 + str4.length();
      f.b(a, "-->openUrl2 before url =" + paramString1);
      if (paramString1.indexOf("?") != -1)
        break label325;
      str5 = paramString1 + "?";
      f.b(a, "-->openUrl2 encodedParam =" + str4 + " -- url = " + str5);
      HttpGet localHttpGet = new HttpGet(str5 + str4);
      localHttpGet.addHeader("Accept-Encoding", "gzip");
      localObject1 = localHttpGet;
      i = n;
    }
    while (true)
    {
      HttpResponse localHttpResponse = localHttpClient.execute((HttpUriRequest)localObject1);
      int j = localHttpResponse.getStatusLine().getStatusCode();
      if (j == 200)
      {
        return new Util.Statistic(a(localHttpResponse), i);
        localBundle1 = new Bundle();
        break;
        label325: str5 = paramString1 + "&";
        break label178;
        label349: if (paramString2.equals("POST"))
        {
          HttpPost localHttpPost = new HttpPost(paramString1);
          localHttpPost.addHeader("Accept-Encoding", "gzip");
          Bundle localBundle2 = new Bundle();
          Iterator localIterator1 = localBundle1.keySet().iterator();
          while (localIterator1.hasNext())
          {
            String str3 = (String)localIterator1.next();
            Object localObject2 = localBundle1.get(str3);
            if (!(localObject2 instanceof byte[]))
              continue;
            localBundle2.putByteArray(str3, (byte[])(byte[])localObject2);
          }
          if (!localBundle1.containsKey("method"))
            localBundle1.putString("method", paramString2);
          localHttpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
          localHttpPost.setHeader("Connection", "Keep-Alive");
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          localByteArrayOutputStream.write(Util.getBytesUTF8("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
          localByteArrayOutputStream.write(Util.getBytesUTF8(encodePostBody(localBundle1, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
          if (!localBundle2.isEmpty())
          {
            int k = localBundle2.size();
            localByteArrayOutputStream.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            Iterator localIterator2 = localBundle2.keySet().iterator();
            int m = -1;
            while (localIterator2.hasNext())
            {
              String str2 = (String)localIterator2.next();
              m++;
              localByteArrayOutputStream.write(Util.getBytesUTF8("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"" + "\r\n"));
              localByteArrayOutputStream.write(Util.getBytesUTF8("Content-Type: content/unknown\r\n\r\n"));
              byte[] arrayOfByte2 = localBundle2.getByteArray(str2);
              if (arrayOfByte2 != null)
                localByteArrayOutputStream.write(arrayOfByte2);
              if (m >= k - 1)
                continue;
              localByteArrayOutputStream.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            }
          }
          localByteArrayOutputStream.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
          byte[] arrayOfByte1 = localByteArrayOutputStream.toByteArray();
          i = 0 + arrayOfByte1.length;
          localByteArrayOutputStream.close();
          localHttpPost.setEntity(new ByteArrayEntity(arrayOfByte1));
          localObject1 = localHttpPost;
          continue;
        }
      }
      else
      {
        throw new HttpStatusException("http status code error:" + j);
      }
      i = 0;
      localObject1 = null;
    }
  }

  public static JSONObject request(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2)
    throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    f.a(f.d, "OpenApi request");
    String str2;
    String str1;
    if (!paramString1.toLowerCase().startsWith("http"))
    {
      str2 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
      str1 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
    }
    while (true)
    {
      a(paramContext, paramQQToken, paramString1);
      long l1 = SystemClock.elapsedRealtime();
      int i = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      f.b("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      int j;
      long l2;
      int k;
      Object localObject1;
      if (i == 0)
      {
        j = 3;
        f.b("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
        l2 = l1;
        k = 0;
        localObject1 = null;
      }
      while (true)
        while (true)
        {
          int m = k + 1;
          try
          {
            while (true)
            {
              Util.Statistic localStatistic = openUrl2(paramContext, str2, paramString2, paramBundle);
              JSONObject localJSONObject = Util.parseJson(localStatistic.response);
              try
              {
                int i4 = localJSONObject.getInt("ret");
                n = i4;
                l5 = localStatistic.reqSize;
                l3 = localStatistic.rspSize;
                localObject5 = localJSONObject;
                g.a().a(str1, l2, l5, l3, n);
                return localObject5;
                j = i;
              }
              catch (JSONException localJSONException2)
              {
                while (true)
                  n = -4;
              }
              catch (ConnectTimeoutException localConnectTimeoutException2)
              {
                while (true)
                {
                  long l5;
                  Object localObject5;
                  localObject3 = localJSONObject;
                  localObject2 = localConnectTimeoutException2;
                  ((ConnectTimeoutException)localObject2).printStackTrace();
                  n = -7;
                  l3 = 0L;
                  if (m < j)
                  {
                    l2 = SystemClock.elapsedRealtime();
                    localObject4 = localObject3;
                    l4 = 0L;
                    if (m < j)
                      break;
                    localObject5 = localObject4;
                    l5 = l4;
                    continue;
                  }
                  else
                  {
                    g.a().a(str1, l2, 0L, l3, n);
                    throw ((Throwable)localObject2);
                  }
                }
              }
              catch (SocketTimeoutException localSocketTimeoutException2)
              {
                int n;
                long l3;
                while (true)
                {
                  localObject7 = localJSONObject;
                  localObject6 = localSocketTimeoutException2;
                  ((SocketTimeoutException)localObject6).printStackTrace();
                  n = -8;
                  l3 = 0L;
                  if (m >= j)
                    break;
                  l2 = SystemClock.elapsedRealtime();
                  localObject4 = localObject7;
                  long l4 = 0L;
                }
                g.a().a(str1, l2, 0L, l3, n);
                throw ((Throwable)localObject6);
              }
            }
          }
          catch (HttpStatusException localHttpStatusException)
          {
            localHttpStatusException.printStackTrace();
            String str3 = localHttpStatusException.getMessage();
            try
            {
              int i3 = Integer.parseInt(str3.replace("http status code error:", ""));
              i2 = i3;
              g.a().a(str1, l2, 0L, 0L, i2);
              throw localHttpStatusException;
            }
            catch (Exception localException)
            {
              while (true)
              {
                localException.printStackTrace();
                int i2 = -9;
              }
            }
          }
          catch (NetworkUnavailableException localNetworkUnavailableException)
          {
            localNetworkUnavailableException.printStackTrace();
            throw localNetworkUnavailableException;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            localMalformedURLException.printStackTrace();
            g.a().a(str1, l2, 0L, 0L, -3);
            throw localMalformedURLException;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            int i1 = getErrorCodeFromException(localIOException);
            g.a().a(str1, l2, 0L, 0L, i1);
            throw localIOException;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            g.a().a(str1, l2, 0L, 0L, -4);
            throw localJSONException1;
          }
          catch (SocketTimeoutException localSocketTimeoutException1)
          {
            while (true)
            {
              Object localObject6 = localSocketTimeoutException1;
              Object localObject7 = localObject1;
            }
          }
          catch (ConnectTimeoutException localConnectTimeoutException1)
          {
            Object localObject4;
            while (true)
            {
              Object localObject2 = localConnectTimeoutException1;
              Object localObject3 = localObject1;
            }
            localObject1 = localObject4;
            k = m;
          }
        }
      str1 = paramString1;
      str2 = paramString1;
    }
  }

  public static void requestAsync(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener)
  {
    f.a(f.d, "OpenApi requestAsync");
    new HttpUtils.1(paramQQToken, paramContext, paramString1, paramBundle, paramString2, paramIRequestListener).start();
  }

  public static JSONObject upload(QQToken paramQQToken, Context paramContext, String paramString, Bundle paramBundle)
    throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException
  {
    String str2;
    String str1;
    if (!paramString.toLowerCase().startsWith("http"))
    {
      str2 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
      str1 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
    }
    while (true)
    {
      a(paramContext, paramQQToken, paramString);
      long l1 = SystemClock.elapsedRealtime();
      int i = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      f.b("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      int j;
      long l2;
      int k;
      Object localObject1;
      if (i == 0)
      {
        j = 3;
        f.b("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
        l2 = l1;
        k = 0;
        localObject1 = null;
      }
      while (true)
        while (true)
        {
          int m = k + 1;
          try
          {
            while (true)
            {
              Util.Statistic localStatistic = Util.upload(paramContext, str2, paramBundle);
              JSONObject localJSONObject = Util.parseJson(localStatistic.response);
              try
              {
                int i4 = localJSONObject.getInt("ret");
                n = i4;
                l5 = localStatistic.reqSize;
                l3 = localStatistic.rspSize;
                localObject5 = localJSONObject;
                g.a().a(str1, l2, l5, l3, n);
                return localObject5;
                j = i;
              }
              catch (JSONException localJSONException2)
              {
                while (true)
                  n = -4;
              }
              catch (ConnectTimeoutException localConnectTimeoutException2)
              {
                while (true)
                {
                  long l5;
                  Object localObject5;
                  localObject3 = localJSONObject;
                  localObject2 = localConnectTimeoutException2;
                  ((ConnectTimeoutException)localObject2).printStackTrace();
                  n = -7;
                  l3 = 0L;
                  if (m < j)
                  {
                    l2 = SystemClock.elapsedRealtime();
                    localObject4 = localObject3;
                    l4 = 0L;
                    if (m < j)
                      break;
                    localObject5 = localObject4;
                    l5 = l4;
                    continue;
                  }
                  else
                  {
                    g.a().a(str1, l2, 0L, l3, n);
                    throw ((Throwable)localObject2);
                  }
                }
              }
              catch (SocketTimeoutException localSocketTimeoutException2)
              {
                int n;
                long l3;
                while (true)
                {
                  localObject7 = localJSONObject;
                  localObject6 = localSocketTimeoutException2;
                  ((SocketTimeoutException)localObject6).printStackTrace();
                  n = -8;
                  l3 = 0L;
                  if (m >= j)
                    break;
                  l2 = SystemClock.elapsedRealtime();
                  localObject4 = localObject7;
                  long l4 = 0L;
                }
                g.a().a(str1, l2, 0L, l3, n);
                throw ((Throwable)localObject6);
              }
            }
          }
          catch (HttpStatusException localHttpStatusException)
          {
            localHttpStatusException.printStackTrace();
            String str3 = localHttpStatusException.getMessage();
            try
            {
              int i3 = Integer.parseInt(str3.replace("http status code error:", ""));
              i2 = i3;
              g.a().a(str1, l2, 0L, 0L, i2);
              throw localHttpStatusException;
            }
            catch (Exception localException)
            {
              while (true)
              {
                localException.printStackTrace();
                int i2 = -9;
              }
            }
          }
          catch (NetworkUnavailableException localNetworkUnavailableException)
          {
            localNetworkUnavailableException.printStackTrace();
            throw localNetworkUnavailableException;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            localMalformedURLException.printStackTrace();
            g.a().a(str1, l2, 0L, 0L, -3);
            throw localMalformedURLException;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
            int i1 = getErrorCodeFromException(localIOException);
            g.a().a(str1, l2, 0L, 0L, i1);
            throw localIOException;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            g.a().a(str1, l2, 0L, 0L, -4);
            throw localJSONException1;
          }
          catch (SocketTimeoutException localSocketTimeoutException1)
          {
            while (true)
            {
              Object localObject6 = localSocketTimeoutException1;
              Object localObject7 = localObject1;
            }
          }
          catch (ConnectTimeoutException localConnectTimeoutException1)
          {
            Object localObject4;
            while (true)
            {
              Object localObject2 = localConnectTimeoutException1;
              Object localObject3 = localObject1;
            }
            localObject1 = localObject4;
            k = m;
          }
        }
      str1 = paramString;
      str2 = paramString;
    }
  }

  public static class CustomSSLSocketFactory extends org.apache.http.conn.ssl.SSLSocketFactory
  {
    private final SSLContext a = SSLContext.getInstance("TLS");

    public CustomSSLSocketFactory(KeyStore paramKeyStore)
      throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
    {
      super();
      try
      {
        localMyX509TrustManager = new HttpUtils.MyX509TrustManager();
        this.a.init(null, new TrustManager[] { localMyX509TrustManager }, null);
        return;
      }
      catch (Exception localException)
      {
        while (true)
          HttpUtils.MyX509TrustManager localMyX509TrustManager = null;
      }
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

  public static class HttpStatusException extends Exception
  {
    public static final String ERROR_INFO = "http status code error:";

    public HttpStatusException(String paramString)
    {
      super();
    }
  }

  public static class MyX509TrustManager
    implements X509TrustManager
  {
    X509TrustManager a;

    // ERROR //
    MyX509TrustManager()
      throws Exception
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 14	java/lang/Object:<init>	()V
      //   4: ldc 16
      //   6: invokestatic 22	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
      //   9: astore 13
      //   11: aload 13
      //   13: astore_2
      //   14: iconst_0
      //   15: anewarray 24	javax/net/ssl/TrustManager
      //   18: pop
      //   19: aload_2
      //   20: ifnull +124 -> 144
      //   23: new 26	java/io/FileInputStream
      //   26: dup
      //   27: ldc 28
      //   29: invokespecial 31	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
      //   32: astore 7
      //   34: aload_2
      //   35: aload 7
      //   37: ldc 33
      //   39: invokevirtual 39	java/lang/String:toCharArray	()[C
      //   42: invokevirtual 43	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
      //   45: ldc 45
      //   47: ldc 47
      //   49: invokestatic 52	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
      //   52: astore 10
      //   54: aload 10
      //   56: aload_2
      //   57: invokevirtual 56	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
      //   60: aload 10
      //   62: invokevirtual 60	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
      //   65: astore 11
      //   67: aload 11
      //   69: astore 5
      //   71: aload 7
      //   73: ifnull +8 -> 81
      //   76: aload 7
      //   78: invokevirtual 63	java/io/FileInputStream:close	()V
      //   81: iconst_0
      //   82: istore 6
      //   84: iload 6
      //   86: aload 5
      //   88: arraylength
      //   89: if_icmpge +88 -> 177
      //   92: aload 5
      //   94: iload 6
      //   96: aaload
      //   97: instanceof 6
      //   100: ifeq +71 -> 171
      //   103: aload_0
      //   104: aload 5
      //   106: iload 6
      //   108: aaload
      //   109: checkcast 6	javax/net/ssl/X509TrustManager
      //   112: putfield 65	com/tencent/open/utils/HttpUtils$MyX509TrustManager:a	Ljavax/net/ssl/X509TrustManager;
      //   115: return
      //   116: astore_1
      //   117: aconst_null
      //   118: astore_2
      //   119: goto -105 -> 14
      //   122: astore 12
      //   124: aconst_null
      //   125: astore 9
      //   127: aload 12
      //   129: astore 8
      //   131: aload 9
      //   133: ifnull +8 -> 141
      //   136: aload 9
      //   138: invokevirtual 63	java/io/FileInputStream:close	()V
      //   141: aload 8
      //   143: athrow
      //   144: invokestatic 69	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
      //   147: invokestatic 72	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
      //   150: astore 4
      //   152: aload 4
      //   154: aconst_null
      //   155: checkcast 18	java/security/KeyStore
      //   158: invokevirtual 56	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
      //   161: aload 4
      //   163: invokevirtual 60	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
      //   166: astore 5
      //   168: goto -87 -> 81
      //   171: iinc 6 1
      //   174: goto -90 -> 84
      //   177: new 12	java/lang/Exception
      //   180: dup
      //   181: ldc 74
      //   183: invokespecial 75	java/lang/Exception:<init>	(Ljava/lang/String;)V
      //   186: athrow
      //   187: astore 8
      //   189: aload 7
      //   191: astore 9
      //   193: goto -62 -> 131
      //
      // Exception table:
      //   from	to	target	type
      //   4	11	116	java/lang/Exception
      //   23	34	122	finally
      //   34	67	187	finally
    }

    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      try
      {
        this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      catch (CertificateException localCertificateException)
      {
      }
    }

    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      try
      {
        this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
        return;
      }
      catch (CertificateException localCertificateException)
      {
      }
    }

    public X509Certificate[] getAcceptedIssuers()
    {
      return this.a.getAcceptedIssuers();
    }
  }

  public static class NetworkProxy
  {
    public final String host;
    public final int port;

    private NetworkProxy(String paramString, int paramInt)
    {
      this.host = paramString;
      this.port = paramInt;
    }
  }

  public static class NetworkUnavailableException extends Exception
  {
    public static final String ERROR_INFO = "network unavailable";

    public NetworkUnavailableException(String paramString)
    {
      super();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.HttpUtils
 * JD-Core Version:    0.6.0
 */