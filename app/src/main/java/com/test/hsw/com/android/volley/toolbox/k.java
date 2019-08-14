package com.android.volley.toolbox;

import com.android.volley.a;
import com.android.volley.o;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class k
  implements j
{
  private static final String a = "Content-Type";
  private final a b;
  private final SSLSocketFactory c;

  public k()
  {
    this(null);
  }

  public k(a parama)
  {
    this(parama, null);
  }

  public k(a parama, SSLSocketFactory paramSSLSocketFactory)
  {
    this.b = parama;
    this.c = paramSSLSocketFactory;
  }

  private HttpURLConnection a(URL paramURL, o<?> paramo)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = a(paramURL);
    int i = paramo.x();
    localHttpURLConnection.setConnectTimeout(i);
    localHttpURLConnection.setReadTimeout(i);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    if (("https".equals(paramURL.getProtocol())) && (this.c != null))
      ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(this.c);
    return localHttpURLConnection;
  }

  private static HttpEntity a(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream2 = paramHttpURLConnection.getInputStream();
      localInputStream1 = localInputStream2;
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      while (true)
        InputStream localInputStream1 = paramHttpURLConnection.getErrorStream();
    }
  }

  static void a(HttpURLConnection paramHttpURLConnection, o<?> paramo)
    throws IOException, a
  {
    switch (paramo.e())
    {
    default:
      throw new IllegalStateException("Unknown method type.");
    case -1:
      byte[] arrayOfByte = paramo.t();
      if (arrayOfByte != null)
      {
        paramHttpURLConnection.setDoOutput(true);
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.addRequestProperty("Content-Type", paramo.s());
        DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
        localDataOutputStream.write(arrayOfByte);
        localDataOutputStream.close();
      }
      return;
    case 0:
      paramHttpURLConnection.setRequestMethod("GET");
      return;
    case 3:
      paramHttpURLConnection.setRequestMethod("DELETE");
      return;
    case 1:
      paramHttpURLConnection.setRequestMethod("POST");
      b(paramHttpURLConnection, paramo);
      return;
    case 2:
      paramHttpURLConnection.setRequestMethod("PUT");
      b(paramHttpURLConnection, paramo);
      return;
    case 4:
      paramHttpURLConnection.setRequestMethod("HEAD");
      return;
    case 5:
      paramHttpURLConnection.setRequestMethod("OPTIONS");
      return;
    case 6:
      paramHttpURLConnection.setRequestMethod("TRACE");
      return;
    case 7:
    }
    paramHttpURLConnection.setRequestMethod("PATCH");
    b(paramHttpURLConnection, paramo);
  }

  private static void b(HttpURLConnection paramHttpURLConnection, o<?> paramo)
    throws IOException, a
  {
    byte[] arrayOfByte = paramo.d();
    if (arrayOfByte != null)
    {
      paramHttpURLConnection.setDoOutput(true);
      paramHttpURLConnection.addRequestProperty("Content-Type", paramo.c());
      DataOutputStream localDataOutputStream = new DataOutputStream(paramHttpURLConnection.getOutputStream());
      localDataOutputStream.write(arrayOfByte);
      localDataOutputStream.close();
    }
  }

  protected HttpURLConnection a(URL paramURL)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection();
  }

  public HttpResponse a(o<?> paramo, Map<String, String> paramMap)
    throws IOException, a
  {
    String str1 = paramo.j();
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramo.b());
    localHashMap.putAll(paramMap);
    String str2;
    if (this.b != null)
    {
      str2 = this.b.a(str1);
      if (str2 == null)
        throw new IOException("URL blocked by rewriter: " + str1);
    }
    else
    {
      str2 = str1;
    }
    HttpURLConnection localHttpURLConnection = a(new URL(str2), paramo);
    Iterator localIterator1 = localHashMap.keySet().iterator();
    ProtocolVersion localProtocolVersion;
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        a(localHttpURLConnection, paramo);
        localProtocolVersion = new ProtocolVersion("HTTP", 1, 1);
        if (localHttpURLConnection.getResponseCode() != -1)
          break;
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      }
      String str3 = (String)localIterator1.next();
      localHttpURLConnection.addRequestProperty(str3, (String)localHashMap.get(str3));
    }
    BasicHttpResponse localBasicHttpResponse = new BasicHttpResponse(new BasicStatusLine(localProtocolVersion, localHttpURLConnection.getResponseCode(), localHttpURLConnection.getResponseMessage()));
    localBasicHttpResponse.setEntity(a(localHttpURLConnection));
    Iterator localIterator2 = localHttpURLConnection.getHeaderFields().entrySet().iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
        return localBasicHttpResponse;
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      if (localEntry.getKey() == null)
        continue;
      localBasicHttpResponse.addHeader(new BasicHeader((String)localEntry.getKey(), (String)((List)localEntry.getValue()).get(0)));
    }
  }

  public static abstract interface a
  {
    public abstract String a(String paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.k
 * JD-Core Version:    0.6.0
 */