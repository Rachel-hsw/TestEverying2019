package com.bokecc.sdk.mobile.drm;

import com.bokecc.sdk.mobile.util.HttpUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

class f
  implements HttpRequestHandler
{
  private long a;
  private d b;

  private Map<String, String> a(String paramString)
  {
    String[] arrayOfString1 = paramString.split("&");
    HashMap localHashMap = new HashMap();
    int i = arrayOfString1.length;
    int j = 0;
    if (j < i)
    {
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length == 1)
        localHashMap.put(arrayOfString2[0], "");
      while (true)
      {
        j++;
        break;
        localHashMap.put(arrayOfString2[0], HttpUtil.urlDecode(arrayOfString2[1].trim()));
      }
    }
    return localHashMap;
  }

  private void a()
  {
    this.a = 0L;
    this.b = null;
  }

  public void handle(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws HttpException, IOException
  {
    a();
    if (paramHttpRequest.containsHeader("Range"))
    {
      String str2 = paramHttpRequest.getFirstHeader("Range").getValue();
      if ((str2 != null) && (str2.indexOf("=") > 0))
        this.a = Long.parseLong(str2.substring(1 + str2.indexOf("="), str2.indexOf("-")));
    }
    String str1 = paramHttpRequest.getRequestLine().getUri();
    if (!str1.contains("url"))
    {
      paramHttpResponse.setEntity(new StringEntity("呵呵", "UTF-8"));
      return;
    }
    Map localMap = a(str1.substring(1 + str1.indexOf("?"), str1.length()));
    e locale = new e();
    if (!locale.a((String)localMap.get("url"), this.a))
    {
      paramHttpResponse.setStatusCode(400);
      return;
    }
    this.b = new d(locale);
    if (!this.b.a(this.a, 0L))
    {
      paramHttpResponse.setStatusCode(400);
      return;
    }
    if (this.a > 0L);
    for (int i = 206; ; i = 200)
    {
      paramHttpResponse.setStatusCode(i);
      Iterator localIterator = this.b.a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramHttpResponse.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    if (locale.c() > 0L)
      paramHttpResponse.addHeader("Last-Modified", localSimpleDateFormat.format(new Date(locale.c())));
    paramHttpResponse.setEntity(new EntityTemplate(new g(this)));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.f
 * JD-Core Version:    0.6.0
 */