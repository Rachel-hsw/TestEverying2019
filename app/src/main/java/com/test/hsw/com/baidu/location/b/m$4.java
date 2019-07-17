package com.baidu.location.b;

import android.util.Log;
import java.io.File;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class m$4 extends Thread
{
  public void run()
  {
    this.a.c5 = k.Z();
    this.a.au();
    int i = this.a.dg;
    m.jdMethod_if(this.a);
    int j = i;
    Object localObject1 = null;
    while (true)
    {
      if (j > 0);
      try
      {
        localObject2 = new HttpPost(this.a.c5);
        while (true)
        {
          try
          {
            FileEntity localFileEntity = new FileEntity(new File(this.a.dc), "binary/octet-stream");
            ((HttpPost)localObject2).setHeader("Content-Type", "application/octet-stream");
            ((HttpPost)localObject2).setHeader("Accept-Charset", "UTF-8;");
            ((HttpPost)localObject2).setEntity(localFileEntity);
            DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
            localDefaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.Q));
            localDefaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.d));
            HttpProtocolParams.setUseExpectContinue(localDefaultHttpClient.getParams(), false);
            if (((m.c8 != g.byte) && (m.c8 != g.w)) || ((this.a.dg - j) % 2 != 0))
              continue;
            HttpHost localHttpHost = new HttpHost(m.al(), m.ar(), "http");
            localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
            HttpResponse localHttpResponse = localDefaultHttpClient.execute((HttpUriRequest)localObject2);
            if (localHttpResponse.getStatusLine().getStatusCode() != 200)
              continue;
            this.a.c6 = localHttpResponse.getEntity();
            this.a.jdMethod_int(true);
            if (j > 0)
              break label361;
            m.de = 1 + m.de;
            this.a.c6 = null;
            this.a.jdMethod_int(false);
            m.jdMethod_if(this.a, false);
            return;
            ((HttpPost)localObject2).abort();
            j--;
            localObject1 = localObject2;
          }
          catch (Exception localException1)
          {
          }
          if (localObject2 != null)
            ((HttpPost)localObject2).abort();
          Log.d(g.m, "NetworkCommunicationException!");
          continue;
          label361: m.de = 0;
        }
      }
      catch (Exception localException2)
      {
        while (true)
          Object localObject2 = localObject1;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.m.4
 * JD-Core Version:    0.6.0
 */