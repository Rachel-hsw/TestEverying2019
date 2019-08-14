package com.bokecc.sdk.mobile.drm;

import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.http.entity.ContentProducer;

class g
  implements ContentProducer
{
  g(f paramf)
  {
  }

  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      f.a(this.a).a(paramOutputStream);
      return;
    }
    catch (Exception localException)
    {
      while ((localException instanceof SocketException));
      Log.e("stream output error", localException + "", localException);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.g
 * JD-Core Version:    0.6.0
 */