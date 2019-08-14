package com.bokecc.sdk.mobile.download;

import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import java.io.IOException;
import org.json.JSONException;

class a
  implements Runnable
{
  a(Downloader paramDownloader)
  {
  }

  public void run()
  {
    try
    {
      if (Downloader.a(this.a) == null)
        Downloader.a(this.a, Downloader.b(this.a), Downloader.c(this.a), Downloader.d(this.a));
      if (Downloader.e(this.a) == null)
        Downloader.f(this.a);
      Downloader.g(this.a);
      Downloader.h(this.a);
      return;
    }
    catch (DreamwinException localDreamwinException)
    {
      try
      {
        Log.e("Downloader", localDreamwinException.getMessage() + "");
        Downloader.a(this.a, localDreamwinException.getErrorCode());
        return;
      }
      catch (Exception localException2)
      {
        while (true)
          Log.e("Downloader msg error", localException2.getMessage() + "1");
      }
    }
    catch (IOException localIOException)
    {
      while (Downloader.i(this.a) == 300);
      Log.e("Downloader", localIOException + "");
      Downloader.a(this.a, ErrorCode.NETWORK_ERROR);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("Downloader", localJSONException + "");
      Downloader.a(this.a, ErrorCode.NETWORK_ERROR);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("Downloader", localNullPointerException + "");
      Downloader.a(this.a, ErrorCode.NETWORK_ERROR);
      return;
    }
    catch (Exception localException1)
    {
      while (Downloader.i(this.a) == 300);
      Log.e("Downloader", localException1 + "");
      Downloader.a(this.a, ErrorCode.NETWORK_ERROR);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.download.a
 * JD-Core Version:    0.6.0
 */