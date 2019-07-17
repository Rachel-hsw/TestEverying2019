package com.umeng.message.b;

import android.util.Log;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.protocol.HttpContext;

class bo
  implements RedirectHandler
{
  bo(bl parambl)
  {
  }

  String a(HttpResponse paramHttpResponse)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Header[] arrayOfHeader = paramHttpResponse.getAllHeaders();
    for (int i = 0; i < arrayOfHeader.length; i++)
      localStringBuffer.append(arrayOfHeader[i].getName() + "==" + arrayOfHeader[i].getValue());
    return localStringBuffer.toString();
  }

  public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
    throws ProtocolException
  {
    Log.d("httpClient", "getLocationURI[" + a(paramHttpResponse) + "]");
    return null;
  }

  public boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    Log.d("httpClient", "isRedirectRequested[" + a(paramHttpResponse) + "]");
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.bo
 * JD-Core Version:    0.6.0
 */