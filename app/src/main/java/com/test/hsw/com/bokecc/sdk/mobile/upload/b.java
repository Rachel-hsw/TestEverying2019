package com.bokecc.sdk.mobile.upload;

import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import java.io.IOException;

class b
  implements Runnable
{
  b(Uploader paramUploader)
  {
  }

  public void run()
  {
    try
    {
      Uploader.b(this.a);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e(Uploader.c(this.a), localIOException + "");
      Uploader.a(this.a, ErrorCode.NETWORK_ERROR);
      return;
    }
    catch (DreamwinException localDreamwinException)
    {
      Log.e(Uploader.c(this.a), localDreamwinException.getMessage());
      Uploader.a(this.a, localDreamwinException.getErrorCode());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.upload.b
 * JD-Core Version:    0.6.0
 */