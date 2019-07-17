package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;

final class o
  implements Runnable
{
  private f bM = null;
  private Map<String, Integer> bO = null;
  private Context e = null;

  public o(Context paramContext)
  {
    this.e = paramContext;
    this.bM = null;
  }

  private static b a(String paramString, int paramInt)
  {
    b localb = new b();
    Socket localSocket = new Socket();
    int i = 0;
    try
    {
      localb.setDomain(paramString);
      localb.setPort(paramInt);
      long l = System.currentTimeMillis();
      InetSocketAddress localInetSocketAddress = new InetSocketAddress(paramString, paramInt);
      localSocket.connect(localInetSocketAddress, 30000);
      localb.a(System.currentTimeMillis() - l);
      localb.k(localInetSocketAddress.getAddress().getHostAddress());
      localSocket.close();
      try
      {
        localSocket.close();
        localb.setStatusCode(i);
        return localb;
      }
      catch (Throwable localThrowable3)
      {
        while (true)
        {
          e.K().b(localThrowable3);
          i = 0;
        }
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        i = -1;
        e.K().b(localIOException);
        try
        {
          localSocket.close();
        }
        catch (Throwable localThrowable2)
        {
          e.K().b(localThrowable2);
        }
      }
    }
    finally
    {
    }
    try
    {
      localSocket.close();
      throw localObject;
    }
    catch (Throwable localThrowable1)
    {
      while (true)
        e.K().b(localThrowable1);
    }
  }

  private static Map<String, Integer> ag()
  {
    HashMap localHashMap = new HashMap();
    String str1 = c.l("__MTA_TEST_SPEED__");
    if ((str1 == null) || (str1.trim().length() == 0))
      return localHashMap;
    String[] arrayOfString1 = str1.split(";");
    int i = arrayOfString1.length;
    int j = 0;
    while (j < i)
    {
      String[] arrayOfString2 = arrayOfString1[j].split(",");
      String str2;
      if ((arrayOfString2 != null) && (arrayOfString2.length == 2))
      {
        str2 = arrayOfString2[0];
        if ((str2 == null) || (str2.trim().length() == 0));
      }
      try
      {
        int k = Integer.valueOf(arrayOfString2[1]).intValue();
        localHashMap.put(str2, Integer.valueOf(k));
        j++;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        while (true)
          e.K().b(localNumberFormatException);
      }
    }
  }

  public final void run()
  {
    JSONArray localJSONArray;
    while (true)
    {
      Map.Entry localEntry;
      String str;
      try
      {
        if (this.bO != null)
          continue;
        this.bO = ag();
        if ((this.bO != null) && (this.bO.size() != 0))
          continue;
        e.K().b("empty domain list.");
        return;
        localJSONArray = new JSONArray();
        Iterator localIterator = this.bO.entrySet().iterator();
        if (!localIterator.hasNext())
          break;
        localEntry = (Map.Entry)localIterator.next();
        str = (String)localEntry.getKey();
        if ((str == null) || (str.length() == 0))
        {
          e.K().c("empty domain name.");
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        e.K().b(localThrowable);
        return;
      }
      if ((Integer)localEntry.getValue() == null)
      {
        e.K().c("port is null for " + str);
        continue;
      }
      localJSONArray.put(a((String)localEntry.getKey(), ((Integer)localEntry.getValue()).intValue()).i());
    }
    if (localJSONArray.length() != 0)
    {
      g localg = new g(this.e, e.a(this.e, false, this.bM), this.bM);
      localg.b(localJSONArray.toString());
      new p(localg).ah();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.o
 * JD-Core Version:    0.6.0
 */