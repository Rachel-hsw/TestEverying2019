package com.baidu.location.b;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class m$5 extends Thread
{
  public void run()
  {
    this.a.c5 = k.Z();
    this.a.au();
    int i = this.a.dg;
    m.jdMethod_if(this.a);
    int j;
    Object localObject1;
    int k;
    if (m.c8 == g.byte)
    {
      j = i;
      localObject1 = null;
      k = 1;
      if (j <= 0);
    }
    while (true)
    {
      try
      {
        while (true)
        {
          localObject2 = new HttpPost(this.a.c5);
          try
          {
            ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(this.a.db);
            ((HttpPost)localObject2).setHeader("Content-Type", "application/octet-stream");
            ((HttpPost)localObject2).setHeader("Accept-Charset", "UTF-8;");
            ((HttpPost)localObject2).setEntity(localByteArrayEntity);
            DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
            localDefaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.Q));
            localDefaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.Q));
            HttpProtocolParams.setUseExpectContinue(localDefaultHttpClient.getParams(), false);
            if (k == 0)
              break label379;
            HttpHost localHttpHost = new HttpHost(m.al(), m.ar(), "http");
            localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
            break label379;
            while (true)
            {
              HttpResponse localHttpResponse = localDefaultHttpClient.execute((HttpUriRequest)localObject2);
              if (localHttpResponse.getStatusLine().getStatusCode() != 200)
                break;
              this.a.c6 = localHttpResponse.getEntity();
              this.a.jdMethod_int(true);
              if (j > 0)
                break label353;
              m.de = 1 + m.de;
              this.a.c6 = null;
              this.a.jdMethod_int(false);
              this.a.db = null;
              m.jdMethod_if(this.a, false);
              return;
              k = 0;
            }
            ((HttpPost)localObject2).abort();
            j--;
            localObject1 = localObject2;
          }
          catch (Exception localException1)
          {
          }
        }
        if (localObject2 == null)
          continue;
        ((HttpPost)localObject2).abort();
        Log.d(g.m, "NetworkCommunicationException!");
        continue;
        label353: m.de = 0;
        continue;
      }
      catch (Exception localException2)
      {
        Object localObject2 = localObject1;
        continue;
      }
      j = i;
      k = 0;
      localObject1 = null;
      break;
      label379: if (k != 0)
        continue;
      k = 1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.m.5
 * JD-Core Version:    0.6.0
 */