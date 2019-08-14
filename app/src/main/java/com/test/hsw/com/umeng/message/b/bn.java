package com.umeng.message.b;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class bn
  implements HttpResponseInterceptor
{
  bn(bl parambl)
  {
  }

  public final void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    HttpEntity localHttpEntity = paramHttpResponse.getEntity();
    if (localHttpEntity == null);
    while (true)
    {
      return;
      Header localHeader = localHttpEntity.getContentEncoding();
      if (localHeader == null)
        continue;
      HeaderElement[] arrayOfHeaderElement = localHeader.getElements();
      int i = arrayOfHeaderElement.length;
      for (int j = 0; j < i; j++)
      {
        if (!arrayOfHeaderElement[j].getName().equalsIgnoreCase("gzip"))
          continue;
        paramHttpResponse.setEntity(new bl.a(paramHttpResponse.getEntity()));
        return;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bn
 * JD-Core Version:    0.6.0
 */