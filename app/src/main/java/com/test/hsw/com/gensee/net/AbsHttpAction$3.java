package com.gensee.net;

import com.gensee.utils.GenseeLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

class AbsHttpAction$3
  implements Runnable
{
  public void run()
  {
    try
    {
      GenseeLog.d("AbsHttpAction", "getStream addr = " + this.val$addr);
      InputStream localInputStream2 = ((HttpURLConnection)new URL(this.val$addr).openConnection()).getInputStream();
      localInputStream1 = localInputStream2;
      i = 3;
      if (this.val$res != null)
      {
        if (localInputStream1 == null)
          this.val$res.onConnectError(i, "");
      }
      else
        return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
      {
        localMalformedURLException.printStackTrace();
        i = 3;
        localInputStream1 = null;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      while (true)
      {
        i = 1;
        localInputStream1 = null;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localIOException.printStackTrace();
        i = 3;
        localInputStream1 = null;
      }
    }
    catch (Exception localException)
    {
      InputStream localInputStream1;
      while (true)
      {
        localException.printStackTrace();
        int i = 3;
        localInputStream1 = null;
      }
      this.val$res.onRes(localInputStream1);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.net.AbsHttpAction.3
 * JD-Core Version:    0.6.0
 */