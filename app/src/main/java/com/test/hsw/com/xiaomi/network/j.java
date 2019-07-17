package com.xiaomi.network;

import android.content.Context;
import com.xiaomi.a.a.e.d;
import com.xiaomi.b.a.a.a.b;
import com.xiaomi.b.a.a.a.c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TreeMap;
import org.a.c.b.b.a;
import org.a.c.g;

public class j
{
  private static j e;
  private List<a> a = new ArrayList();
  private final Random b = new Random();
  private Timer c = new Timer("Upload Http Record Timer");
  private boolean d = false;
  private Context f = null;

  private j(Context paramContext)
  {
    this.f = paramContext.getApplicationContext();
  }

  public static j a()
  {
    monitorenter;
    try
    {
      j localj = e;
      monitorexit;
      return localj;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(b(paramString));
      String str = String.format("%1$032X", new Object[] { new BigInteger(1, localMessageDigest.digest()) });
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    throw new RuntimeException(localNoSuchAlgorithmException);
  }

  public static void a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (e == null)
        e = new j(paramContext);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  private void a(String paramString1, String paramString2)
  {
    String str1 = String.valueOf(System.nanoTime());
    String str2 = String.valueOf(System.currentTimeMillis());
    TreeMap localTreeMap = new TreeMap();
    localTreeMap.put("n", str1);
    localTreeMap.put("d", paramString2);
    localTreeMap.put("t", str2);
    localTreeMap.put("s", a(str1 + paramString2 + str2 + "56C6A520%$C99119A0&^229(!@2746C7"));
    String str3 = String.format("http://%1$s/diagnoses/v1/report", new Object[] { paramString1 });
    d.a(this.f, str3, localTreeMap);
  }

  private void a(List<b> paramList, double paramDouble)
  {
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      String str;
      if (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        c localc = new c();
        localc.a("httpapi");
        localc.a(localb);
        localc.a(new com.xiaomi.b.a.a.a());
        str = new String(com.xiaomi.a.a.g.a.a(new g(new b.a()).a(localc)));
        if (this.b.nextInt(10000) >= 10000.0D * paramDouble)
          continue;
      }
      try
      {
        a("f3.mi-stat.gslb.mi-idc.com", str);
      }
      catch (IOException localIOException)
      {
        continue;
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private byte[] b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return paramString.getBytes();
  }

  public void a(a parama)
  {
    monitorenter;
    try
    {
      this.a.add(parama);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void b()
  {
    if (!this.d)
    {
      this.d = true;
      this.c.schedule(new n(this), 60000L);
    }
  }

  public void b(a parama)
  {
    monitorenter;
    try
    {
      this.a.remove(parama);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static abstract interface a
  {
    public abstract List<b> a();

    public abstract double b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.j
 * JD-Core Version:    0.6.0
 */