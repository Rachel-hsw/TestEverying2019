package com.umeng.message.b;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

class fa
  implements ep.c
{
  public HttpURLConnection a(URL paramURL)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection();
  }

  public HttpURLConnection a(URL paramURL, Proxy paramProxy)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection(paramProxy);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.fa
 * JD-Core Version:    0.6.0
 */