package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.xiaomi.a.a.e.a;
import com.xiaomi.a.a.e.d;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends f
{
  private final int f = 80;
  private final int g = 5222;
  private int h = 80;

  protected g(Context paramContext, e parame, f.b paramb, String paramString)
  {
    this(paramContext, parame, paramb, paramString, null, null);
  }

  protected g(Context paramContext, e parame, f.b paramb, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, parame, paramb, paramString1, paramString2, paramString3);
    a("resolver.msg.xiaomi.net", "resolver.msg.xiaomi.net:5222");
  }

  protected String a(ArrayList<String> paramArrayList, String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new a("type", paramString1));
    if (paramString1.equals("wap"))
      localArrayList2.add(new a("connpt", d.f(this.c)));
    localArrayList2.add(new a("uuid", paramString2));
    localArrayList2.add(new a("list", a(paramArrayList, ",")));
    b localb = c("resolver.msg.xiaomi.net");
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("resolver.msg.xiaomi.net:" + this.h);
    String str1 = String.format(localLocale, "http://%1$s/gslb/?ver=3.0", arrayOfObject);
    ArrayList localArrayList3;
    Iterator localIterator1;
    Object localObject1;
    if (localb == null)
    {
      localArrayList1.add(str1);
      synchronized (b)
      {
        Iterator localIterator3 = ((ArrayList)b.get("resolver.msg.xiaomi.net")).iterator();
        if (localIterator3.hasNext())
        {
          String str3 = (String)localIterator3.next();
          localArrayList1.add(String.format(Locale.US, "http://%1$s/gslb/?ver=3.0", new Object[] { str3 }));
        }
      }
      monitorexit;
      localArrayList3 = localArrayList1;
      localIterator1 = localArrayList3.iterator();
      localObject1 = null;
    }
    while (true)
    {
      Uri.Builder localBuilder;
      if (localIterator1.hasNext())
      {
        localBuilder = Uri.parse((String)localIterator1.next()).buildUpon();
        Iterator localIterator2 = localArrayList2.iterator();
        while (true)
          if (localIterator2.hasNext())
          {
            com.xiaomi.a.a.e.c localc = (com.xiaomi.a.a.e.c)localIterator2.next();
            localBuilder.appendQueryParameter(localc.a(), localc.b());
            continue;
            localArrayList3 = localb.a(str1);
            break;
          }
      }
      try
      {
        if (this.d == null)
          return d.a(this.c, new URL(localBuilder.toString()));
        String str2 = this.d.a(localBuilder.toString());
        return str2;
        if (localObject1 == null)
          break label436;
        return super.a(paramArrayList, paramString1, paramString2);
      }
      catch (IOException localIOException)
      {
      }
    }
    label436: return null;
  }

  protected String c()
  {
    return "resolver.msg.xiaomi.net";
  }

  protected void g(String paramString)
  {
    JSONObject localJSONObject;
    synchronized (this.a)
    {
      this.a.clear();
      localJSONObject = new JSONObject(paramString);
      if (localJSONObject.optInt("ver") != 2)
        throw new JSONException("Bad version");
    }
    JSONArray localJSONArray = localJSONObject.optJSONArray("data");
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      c localc = new c().a(localJSONArray.getJSONObject(i));
      this.a.put(localc.c(), localc);
    }
    monitorexit;
  }

  protected boolean g()
  {
    synchronized (this.a)
    {
      if (!e)
      {
        e = true;
        this.a.clear();
        try
        {
          String str = f();
          if (!TextUtils.isEmpty(str))
          {
            g(str);
            com.xiaomi.a.a.c.c.b("loading the new hosts succeed");
            return true;
          }
        }
        catch (Throwable localThrowable)
        {
          com.xiaomi.a.a.c.c.a("load bucket failure: " + localThrowable.getMessage());
          return false;
        }
      }
      return true;
    }
  }

  public void h()
  {
    synchronized (this.a)
    {
      try
      {
        BufferedWriter localBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.c.openFileOutput(i(), 0)));
        String str = m().toString();
        if (!TextUtils.isEmpty(str))
          localBufferedWriter.write(str);
        localBufferedWriter.close();
        return;
      }
      catch (Exception localException)
      {
        while (true)
          com.xiaomi.a.a.c.c.a("persist bucket failure: " + localException.getMessage());
      }
    }
  }

  public void k()
  {
    synchronized (this.a)
    {
      Iterator localIterator1 = this.a.values().iterator();
      if (localIterator1.hasNext())
        ((c)localIterator1.next()).a(true);
    }
    int i = 0;
    while (true)
    {
      if (i == 0)
      {
        Iterator localIterator2 = this.a.keySet().iterator();
        String str;
        do
        {
          if (!localIterator2.hasNext())
            break;
          str = (String)localIterator2.next();
        }
        while (!((c)this.a.get(str)).b().isEmpty());
        this.a.remove(str);
        i = 0;
        continue;
      }
      monitorexit;
      return;
      i = 1;
    }
  }

  protected JSONObject m()
  {
    synchronized (this.a)
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ver", 2);
      localJSONObject.put("data", l());
      return localJSONObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.g
 * JD-Core Version:    0.6.0
 */