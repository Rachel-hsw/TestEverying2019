package com.bokecc.sdk.mobile.upload;

import android.util.Log;
import com.bokecc.sdk.mobile.exception.DreamwinException;
import com.bokecc.sdk.mobile.exception.ErrorCode;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

class a
  implements Runnable
{
  a(Uploader paramUploader)
  {
  }

  public void run()
  {
    try
    {
      Uploader.a(this.a);
      Uploader.b(this.a);
      return;
    }
    catch (DreamwinException localDreamwinException)
    {
      Log.e(Uploader.c(this.a), localDreamwinException.getMessage() + "");
      Uploader.a(this.a, localDreamwinException.getErrorCode());
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      Log.e(Uploader.c(this.a), localXmlPullParserException + "");
      Uploader.a(this.a, ErrorCode.PROCESS_FAIL);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e(Uploader.c(this.a), localIOException + "");
      Uploader.a(this.a, ErrorCode.NETWORK_ERROR);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.upload.a
 * JD-Core Version:    0.6.0
 */