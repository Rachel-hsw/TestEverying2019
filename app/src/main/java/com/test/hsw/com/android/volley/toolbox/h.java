package com.android.volley.toolbox;

import com.android.volley.a;
import com.android.volley.o;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class h
  implements j
{
  private static final String b = "Content-Type";
  protected final HttpClient a;

  public h(HttpClient paramHttpClient)
  {
    this.a = paramHttpClient;
  }

  private static List<NameValuePair> a(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      String str = (String)localIterator.next();
      localArrayList.add(new BasicNameValuePair(str, (String)paramMap.get(str)));
    }
  }

  private static void a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, o<?> paramo)
    throws a
  {
    byte[] arrayOfByte = paramo.d();
    if (arrayOfByte != null)
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(arrayOfByte));
  }

  private static void a(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }

  static HttpUriRequest b(o<?> paramo, Map<String, String> paramMap)
    throws a
  {
    switch (paramo.e())
    {
    default:
      throw new IllegalStateException("Unknown request method.");
    case -1:
      byte[] arrayOfByte = paramo.t();
      if (arrayOfByte != null)
      {
        HttpPost localHttpPost2 = new HttpPost(paramo.j());
        localHttpPost2.addHeader("Content-Type", paramo.s());
        localHttpPost2.setEntity(new ByteArrayEntity(arrayOfByte));
        return localHttpPost2;
      }
      return new HttpGet(paramo.j());
    case 0:
      return new HttpGet(paramo.j());
    case 3:
      return new HttpDelete(paramo.j());
    case 1:
      HttpPost localHttpPost1 = new HttpPost(paramo.j());
      localHttpPost1.addHeader("Content-Type", paramo.c());
      a(localHttpPost1, paramo);
      return localHttpPost1;
    case 2:
      HttpPut localHttpPut = new HttpPut(paramo.j());
      localHttpPut.addHeader("Content-Type", paramo.c());
      a(localHttpPut, paramo);
      return localHttpPut;
    case 4:
      return new HttpHead(paramo.j());
    case 5:
      return new HttpOptions(paramo.j());
    case 6:
      return new HttpTrace(paramo.j());
    case 7:
    }
    a locala = new a(paramo.j());
    locala.addHeader("Content-Type", paramo.c());
    a(locala, paramo);
    return locala;
  }

  public HttpResponse a(o<?> paramo, Map<String, String> paramMap)
    throws IOException, a
  {
    HttpUriRequest localHttpUriRequest = b(paramo, paramMap);
    a(localHttpUriRequest, paramMap);
    a(localHttpUriRequest, paramo.b());
    a(localHttpUriRequest);
    HttpParams localHttpParams = localHttpUriRequest.getParams();
    int i = paramo.x();
    HttpConnectionParams.setConnectionTimeout(localHttpParams, 5000);
    HttpConnectionParams.setSoTimeout(localHttpParams, i);
    return this.a.execute(localHttpUriRequest);
  }

  protected void a(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
  }

  public static final class a extends HttpEntityEnclosingRequestBase
  {
    public static final String a = "PATCH";

    public a()
    {
    }

    public a(String paramString)
    {
      setURI(URI.create(paramString));
    }

    public a(URI paramURI)
    {
      setURI(paramURI);
    }

    public String getMethod()
    {
      return "PATCH";
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.h
 * JD-Core Version:    0.6.0
 */