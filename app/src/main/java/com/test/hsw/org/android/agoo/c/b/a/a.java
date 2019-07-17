package org.android.agoo.c.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.message.b.ay;
import com.umeng.message.b.bs;
import com.umeng.message.b.co;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.android.agoo.c.b.b;

public class a extends bs
{
  public static final String h = "agoo_push_errorid";
  public static final String i = "agoo_push_path";
  public static final String j = "agoo_connect_type";
  private static final String k = "HttpURLChunked";
  private volatile HttpURLConnection l = null;

  private final String a(List<String> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int m = paramList.size();
    for (int n = 0; n < m; n++)
    {
      localStringBuffer.append((String)paramList.get(n));
      if (n >= m - 1)
        continue;
      localStringBuffer.append(",");
    }
    return localStringBuffer.toString();
  }

  private final Map<String, String> a(HttpURLConnection paramHttpURLConnection)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHttpURLConnection.getHeaderFields().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      if (TextUtils.isEmpty(str1))
        continue;
      String str2 = a((List)localEntry.getValue());
      if (TextUtils.isEmpty(str2))
        continue;
      localHashMap.put(str1.toLowerCase(), str2);
    }
    return localHashMap;
  }

  private final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("AppStore", 4).edit();
      localEditor.putString("agoo_push_errorid", paramString1);
      localEditor.putString("agoo_push_path", paramString2);
      localEditor.putString("agoo_connect_type", "httpchunk");
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private final void b(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    if (paramHttpURLConnection == null)
      throw new IOException();
    this.b = paramHttpURLConnection.getInputStream();
  }

  protected final void a(String paramString, Map<String, String> paramMap)
  {
    try
    {
      SharedPreferences.Editor localEditor = this.f.getSharedPreferences("AppStore", 4).edit();
      localEditor.putString("agoo_connect_type", "httpchunk");
      localEditor.commit();
      while (true)
      {
        label37: URL localURL;
        try
        {
          ay.c("HttpURLChunked", "http chunked connectId:[" + c() + "]==>" + paramString);
          localURL = new URL(paramString);
          if (o())
          {
            ay.c("HttpURLChunked", "http chunked setPoxy:[" + super.m() + "][" + super.n() + "]");
            this.l = ((HttpURLConnection)localURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(InetAddress.getByName(super.m()), super.n()))));
            HttpURLConnection localHttpURLConnection = this.l;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Double.valueOf(2.0D);
            localHttpURLConnection.setRequestProperty("User-agent", String.format("Agoo-sdk-%s", arrayOfObject));
            if (paramMap == null)
              break;
            Iterator localIterator = paramMap.keySet().iterator();
            if (!localIterator.hasNext())
              break;
            String str = (String)localIterator.next();
            this.l.setRequestProperty(str, (String)paramMap.get(str));
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          if (a())
            continue;
          a(true);
          ay.d("HttpURLChunked", "http chunked connectId:[" + c() + "]==>[Throwable]", localThrowable2);
          a(b.s, localThrowable2);
          return;
        }
        this.l = ((HttpURLConnection)localURL.openConnection());
      }
      this.l.setReadTimeout(2147483647);
      this.l.setChunkedStreamingMode(2147483647);
      long l1 = System.currentTimeMillis();
      this.l.connect();
      long l2 = System.currentTimeMillis() - l1;
      int m = this.l.getResponseCode();
      Map localMap = a(this.l);
      if (200 == m)
      {
        this.e = System.currentTimeMillis();
        b(this.l);
        a(l2, localMap);
        i();
        return;
      }
      ay.d("HttpURLChunked", "http chunked connectId:[" + c() + "]==>[" + m + "]");
      if (!co.a(Integer.toString(m)))
        a(this.f, Integer.toString(m), paramString);
      a(b.b(m), localMap, new Throwable("http httpStatusCode==" + m));
      j();
      return;
    }
    catch (Throwable localThrowable1)
    {
      break label37;
    }
  }

  protected final void g()
  {
    if (this.l != null)
    {
      this.l.disconnect();
      this.l = null;
    }
  }

  protected final void h()
  {
    if (this.l != null)
    {
      this.l.disconnect();
      this.l = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.b.a.a
 * JD-Core Version:    0.6.0
 */