package com.alipay.sdk.util;

import android.util.Log;
import com.alipay.sdk.net.b;
import com.alipay.sdk.net.c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

final class e
  implements Runnable
{
  e(String paramString)
  {
  }

  public final void run()
  {
    ArrayList localArrayList;
    synchronized (d.a())
    {
      localArrayList = new ArrayList(1);
      localArrayList.add(new BasicNameValuePair("errorTag", this.a));
    }
    try
    {
      d.b().setEntity(new UrlEncodedFormEntity(localArrayList));
      try
      {
        label49: b.a();
        b.a();
        Log.d("Http Post Response:", c.a(b.b.a(d.b())));
        label75: monitorexit;
        return;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
      }
      catch (Throwable localThrowable)
      {
        break label75;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      break label49;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.util.e
 * JD-Core Version:    0.6.0
 */