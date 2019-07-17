package com.xiaomi.push.service;

import com.xiaomi.a.a.c.c;
import com.xiaomi.e.e;
import com.xiaomi.network.d;
import com.xiaomi.push.b.a.a;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class al
{
  private static final Pattern a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");
  private static long b = 0L;
  private static ThreadPoolExecutor c = new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());

  public static void a()
  {
    long l = System.currentTimeMillis();
    if ((c.getActiveCount() > 0) && (l - b < 1800000L));
    a.a locala;
    do
    {
      do
        return;
      while (!e.a().c());
      locala = g.a().d();
    }
    while ((locala == null) || (locala.l() <= 0));
    b = l;
    a(locala.k(), true);
  }

  public static void a(List<String> paramList, boolean paramBoolean)
  {
    c.execute(new am(paramList, paramBoolean));
  }

  private static boolean b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    try
    {
      c.a("ConnectivityTest: begin to connect to " + paramString);
      Socket localSocket = new Socket();
      localSocket.connect(d.b(paramString, 5222), 5000);
      localSocket.setTcpNoDelay(true);
      long l2 = System.currentTimeMillis() - l1;
      c.a("ConnectivityTest: connect to " + paramString + " in " + l2);
      localSocket.close();
      return true;
    }
    catch (Throwable localThrowable)
    {
      c.d("ConnectivityTest: could not connect to:" + paramString + " exception: " + localThrowable.getClass().getSimpleName() + " description: " + localThrowable.getMessage());
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.al
 * JD-Core Version:    0.6.0
 */