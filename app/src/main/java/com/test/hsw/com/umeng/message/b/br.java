package com.umeng.message.b;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class br
  implements HttpRequestRetryHandler
{
  private static final int a = 3000;
  private static HashSet<Class<?>> b = new HashSet();
  private static HashSet<Class<?>> c = new HashSet();
  private final int d;

  static
  {
    b.add(NoHttpResponseException.class);
    b.add(UnknownHostException.class);
    b.add(SocketException.class);
    c.add(InterruptedIOException.class);
    c.add(SSLHandshakeException.class);
  }

  public br(int paramInt)
  {
    this.d = paramInt;
  }

  public final boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    int i;
    int k;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      int j = this.d;
      k = 0;
      if (paramInt <= j)
        break label64;
    }
    while (true)
    {
      if (k == 0)
        break label151;
      SystemClock.sleep(3000L);
      return k;
      i = 0;
      break;
      label64: boolean bool1 = c.contains(paramIOException.getClass());
      k = 0;
      if (bool1)
        continue;
      if (b.contains(paramIOException.getClass()))
      {
        k = 1;
        continue;
      }
      if (i == 0)
      {
        k = 1;
        continue;
      }
      boolean bool2 = ((HttpUriRequest)paramHttpContext.getAttribute("http.request")).getMethod().equals("POST");
      k = 0;
      if (bool2)
        continue;
      k = 1;
    }
    label151: paramIOException.printStackTrace();
    return k;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.br
 * JD-Core Version:    0.6.0
 */