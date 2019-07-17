package com.alipay.android.phone.mrpc.core;

import java.io.IOException;
import java.net.SocketException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class ad
  implements HttpRequestRetryHandler
{
  static final String a = ad.class.getSimpleName();

  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    if (paramInt >= 3);
    do
    {
      return false;
      if ((paramIOException instanceof NoHttpResponseException))
        return true;
    }
    while (((!(paramIOException instanceof SocketException)) && (!(paramIOException instanceof SSLException))) || (paramIOException.getMessage() == null) || (!paramIOException.getMessage().contains("Broken pipe")));
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.ad
 * JD-Core Version:    0.6.0
 */