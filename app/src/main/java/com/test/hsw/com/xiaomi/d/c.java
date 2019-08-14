package com.xiaomi.d;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class c
{
  public static int a(Throwable paramThrowable)
  {
    if (((paramThrowable instanceof p)) && (((p)paramThrowable).a() != null));
    for (Throwable localThrowable = ((p)paramThrowable).a(); ; localThrowable = paramThrowable)
    {
      String str = localThrowable.getMessage();
      if (localThrowable.getCause() != null)
        str = localThrowable.getCause().getMessage();
      if ((localThrowable instanceof SocketTimeoutException))
        return 105;
      if ((localThrowable instanceof SocketException))
      {
        if (str.indexOf("Network is unreachable") != -1)
          return 102;
        if (str.indexOf("Connection refused") != -1)
          return 103;
        if (str.indexOf("Connection timed out") != -1)
          return 105;
        if (str.endsWith("EACCES (Permission denied)"))
          return 101;
        if (str.indexOf("Connection reset by peer") != -1)
          return 109;
        if (str.indexOf("Broken pipe") != -1)
          return 110;
        if (str.indexOf("No route to host") != -1)
          return 104;
        if (str.endsWith("EINVAL (Invalid argument)"))
          return 106;
        return 199;
      }
      if ((localThrowable instanceof UnknownHostException))
        return 107;
      if ((paramThrowable instanceof p))
        return 399;
      return 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.c
 * JD-Core Version:    0.6.0
 */