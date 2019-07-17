package com.baidu.location.b;

import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class m$6 extends Thread
{
  public void run()
  {
    this.a.c5 = k.ab();
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
            StringEntity localStringEntity = new StringEntity(this.a.da, "UTF-8");
            ((HttpPost)localObject2).setHeader("Content-Type", "text/xml");
            ((HttpPost)localObject2).setEntity(localStringEntity);
            BasicHttpParams localBasicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, g.Q);
            HttpConnectionParams.setSoTimeout(localBasicHttpParams, g.Q);
            HttpClient localHttpClient = m.jdMethod_if(localBasicHttpParams);
            HttpProtocolParams.setUseExpectContinue(localHttpClient.getParams(), false);
            if (k == 0)
              break label345;
            HttpHost localHttpHost = new HttpHost(m.al(), m.ar(), "http");
            localHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
            break label345;
            while (true)
            {
              HttpResponse localHttpResponse = localHttpClient.execute((HttpUriRequest)localObject2);
              if (localHttpResponse.getStatusLine().getStatusCode() != 200)
                break;
              this.a.c6 = localHttpResponse.getEntity();
              this.a.jdMethod_int(true);
              if (j > 0)
                break label319;
              m.de = 1 + m.de;
              this.a.c6 = null;
              this.a.jdMethod_int(false);
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
        label319: m.de = 0;
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
      label345: if (k != 0)
        continue;
      k = 1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.m.6
 * JD-Core Version:    0.6.0
 */