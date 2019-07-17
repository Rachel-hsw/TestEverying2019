package com.tencent.wxop.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class al extends DefaultConnectionKeepAliveStrategy
{
  al(ak paramak)
  {
  }

  public final long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    long l = super.getKeepAliveDuration(paramHttpResponse, paramHttpContext);
    if (l == -1L)
      l = 30000L;
    return l;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.al
 * JD-Core Version:    0.6.0
 */