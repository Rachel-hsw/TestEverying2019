package com.baidu.location.b;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class m$1 extends Thread
{
  public void run()
  {
    this.a.c5 = k.Z();
    this.a.au();
    int i = this.a.dg;
    m.jdMethod_if(this.a);
    int j;
    int k;
    if (m.c8 == g.byte)
    {
      j = i;
      k = 1;
      if (j <= 0);
    }
    while (true)
    {
      try
      {
        HttpGet localHttpGet = new HttpGet(this.a.c5);
        localHttpGet.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        localHttpGet.setHeader("Accept-Charset", "UTF-8;");
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        localDefaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.Q));
        localDefaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.Q));
        HttpProtocolParams.setUseExpectContinue(localDefaultHttpClient.getParams(), false);
        if (k == 0)
          break label319;
        HttpHost localHttpHost = new HttpHost(m.al(), m.ar(), "http");
        localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
        break label319;
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpGet);
        if (localHttpResponse.getStatusLine().getStatusCode() != 200)
          continue;
        this.a.c6 = localHttpResponse.getEntity();
        this.a.jdMethod_int(true);
        if (j > 0)
          continue;
        m.de = 1 + m.de;
        this.a.c6 = null;
        this.a.jdMethod_int(false);
        m.jdMethod_if(this.a, false);
        return;
        k = 0;
        continue;
        localHttpGet.abort();
        j--;
      }
      catch (Exception localException)
      {
        Log.d(g.m, "NetworkCommunicationException!");
        continue;
        m.de = 0;
        continue;
      }
      j = i;
      k = 0;
      break;
      label319: if (k != 0)
        continue;
      k = 1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.m.1
 * JD-Core Version:    0.6.0
 */