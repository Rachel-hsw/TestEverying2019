package com.bokecc.sdk.mobile.drm;

import android.util.Log;
import com.bokecc.sdk.mobile.util.HttpUtil;
import com.bokecc.sdk.mobile.util.HttpUtil.HttpLogLevel;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpDateGenerator;

class h
  implements HttpResponseInterceptor
{
  private static final HttpDateGenerator a = new HttpDateGenerator();

  public void process(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws HttpException, IOException
  {
    if (paramHttpResponse == null)
      throw new IllegalArgumentException("HTTP request may not be null");
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if (i >= 200)
      paramHttpResponse.setHeader("Date", a.getCurrentDate());
    paramHttpResponse.addHeader("Server", "nginx/1.2.5");
    paramHttpResponse.setHeader("Connection", "Close");
    paramHttpResponse.setHeader("Content-Type", "video/mp4");
    if (HttpUtil.LOG_LEVEL == HttpUtil.HttpLogLevel.DETAIL)
    {
      Log.i("Response Header", i + " " + paramHttpResponse.getStatusLine().getReasonPhrase());
      for (Header localHeader : paramHttpResponse.getAllHeaders())
        Log.i("Response Header", localHeader.getName() + ": " + localHeader.getValue());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.drm.h
 * JD-Core Version:    0.6.0
 */