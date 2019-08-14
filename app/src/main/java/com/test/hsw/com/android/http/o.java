package com.android.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class o
  implements Runnable
{
  o(n paramn, String paramString1, String paramString2, n.a parama, int paramInt)
  {
  }

  public void run()
  {
    HttpPost localHttpPost = new HttpPost(this.b);
    try
    {
      localHttpPost.setHeader("Content-Type", "application/json");
      localHttpPost.setEntity(new StringEntity(this.c, "UTF-8"));
      HttpResponse localHttpResponse = new DefaultHttpClient().execute(localHttpPost);
      if (localHttpResponse.getStatusLine().getStatusCode() == 200)
      {
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpResponse.getEntity().getContent(), "UTF-8"));
        StringBuffer localStringBuffer = new StringBuffer();
        while (true)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
          {
            this.d.onSuccess(localStringBuffer.toString(), null, this.b, this.e);
            return;
          }
          localStringBuffer.append(str);
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      this.d.onError(localUnsupportedEncodingException.getMessage(), this.b, this.e);
      return;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      localClientProtocolException.printStackTrace();
      this.d.onError(localClientProtocolException.getMessage(), this.b, this.e);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      this.d.onError(localIOException.getMessage(), this.b, this.e);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.o
 * JD-Core Version:    0.6.0
 */