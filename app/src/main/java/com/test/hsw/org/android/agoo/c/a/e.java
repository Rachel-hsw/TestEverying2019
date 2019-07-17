package org.android.agoo.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.b.ay;
import com.umeng.message.b.bk;
import com.umeng.message.b.bl;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class e extends bl
{
  private static final String a = "SyncHttp.client";

  private final Map<String, String> a(Header[] paramArrayOfHeader)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayOfHeader.length;
    int j = 0;
    if (j < i)
    {
      Header localHeader = paramArrayOfHeader[j];
      String str1 = localHeader.getName();
      if (TextUtils.isEmpty(str1));
      while (true)
      {
        j++;
        break;
        String str2 = localHeader.getValue();
        if (TextUtils.isEmpty(str2))
          continue;
        localHashMap.put(str1.toLowerCase(), str2);
      }
    }
    return localHashMap;
  }

  public final a a(Context paramContext, String paramString, d paramd)
    throws Throwable
  {
    return a(paramContext, null, paramString, paramd);
  }

  public final a a(Context paramContext, HttpHost paramHttpHost, String paramString, d paramd)
    throws Throwable
  {
    try
    {
      localHttpGet = new HttpGet(a(paramString, paramd));
      try
      {
        if (bk.a(paramContext))
          break label146;
        ay.c("SyncHttp.client", "network connection error[" + localHttpGet.getURI().toString() + "]");
        throw new RuntimeException("network connection error[" + localHttpGet.getURI().toString() + "]");
      }
      catch (Throwable localThrowable1)
      {
      }
      if (localHttpGet != null)
        ay.e("SyncHttp.client", "request url error:[" + localHttpGet.getURI().toString() + "]", localThrowable1);
      while (true)
      {
        throw localThrowable1;
        label146: DefaultHttpClient localDefaultHttpClient = a();
        if (paramHttpHost != null)
          localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", paramHttpHost);
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpGet);
        a locala = new a();
        StatusLine localStatusLine = localHttpResponse.getStatusLine();
        locala.a = localStatusLine.getStatusCode();
        locala.b = a(localHttpResponse.getAllHeaders());
        if (localStatusLine.getStatusCode() >= 300)
        {
          ay.c("SyncHttp.client", "request url [" + localHttpGet.getURI().toString() + "]  result code:[" + localStatusLine.getStatusCode() + "]");
          return locala;
        }
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        String str = null;
        if (localHttpEntity != null)
        {
          str = EntityUtils.toString(new BufferedHttpEntity(localHttpEntity), "UTF-8");
          locala.c = str;
        }
        ay.c("SyncHttp.client", "request url:[" + localHttpGet.getURI().toString() + "] : result code [" + localStatusLine.getStatusCode() + "]:[" + str + "]");
        return locala;
        ay.e("SyncHttp.client", "request url error:[" + paramString + "]", localThrowable1);
      }
    }
    catch (Throwable localThrowable2)
    {
      while (true)
        HttpGet localHttpGet = null;
    }
  }

  public static final class a
  {
    public int a;
    public Map<String, String> b;
    public String c;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.a.e
 * JD-Core Version:    0.6.0
 */