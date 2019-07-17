package com.xiaomi.network;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  protected String h;
  private long i;
  private ArrayList<o> j = new ArrayList();
  private String k;
  private double l = 0.1D;
  private String m = "s.mi1.cc";
  private long n = 86400000L;

  public b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("the host is empty");
    this.i = System.currentTimeMillis();
    this.j.add(new o(paramString, -1));
    this.a = f.a().b();
    this.b = paramString;
  }

  private void c(String paramString)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        if (!TextUtils.equals(((o)localIterator.next()).a, paramString))
          continue;
        localIterator.remove();
      }
    }
    finally
    {
      monitorexit;
    }
    monitorexit;
  }

  public b a(JSONObject paramJSONObject)
  {
    monitorenter;
    try
    {
      this.a = paramJSONObject.optString("net");
      this.n = paramJSONObject.getLong("ttl");
      this.l = paramJSONObject.getDouble("pct");
      this.i = paramJSONObject.getLong("ts");
      this.d = paramJSONObject.optString("city");
      this.c = paramJSONObject.optString("prv");
      this.g = paramJSONObject.optString("cty");
      this.e = paramJSONObject.optString("isp");
      this.f = paramJSONObject.optString("ip");
      this.b = paramJSONObject.optString("host");
      this.h = paramJSONObject.optString("xf");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("fbs");
      for (int i1 = 0; i1 < localJSONArray.length(); i1++)
        a(new o().a(localJSONArray.getJSONObject(i1)));
      return this;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public ArrayList<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("the url is empty.");
    URL localURL = new URL(paramString);
    ArrayList localArrayList;
    if (TextUtils.equals(localURL.getHost(), this.b))
    {
      localArrayList = new ArrayList();
      Iterator localIterator = a(true).iterator();
      while (localIterator.hasNext())
      {
        d locald = d.a((String)localIterator.next(), localURL.getPort());
        localArrayList.add(new URL(localURL.getProtocol(), locald.b(), locald.a(), localURL.getFile()).toString());
      }
    }
    throw new IllegalArgumentException("the url is not supported by the fallback");
    return localArrayList;
  }

  public ArrayList<String> a(boolean paramBoolean)
  {
    int i1 = 0;
    monitorenter;
    while (true)
    {
      ArrayList localArrayList;
      o localo;
      try
      {
        o[] arrayOfo = new o[this.j.size()];
        this.j.toArray(arrayOfo);
        Arrays.sort(arrayOfo);
        localArrayList = new ArrayList();
        int i2 = arrayOfo.length;
        if (i1 >= i2)
          break label132;
        localo = arrayOfo[i1];
        if (!paramBoolean)
          continue;
        localArrayList.add(localo.a);
        break label137;
        int i3 = localo.a.indexOf(":");
        if (i3 != -1)
          localArrayList.add(localo.a.substring(0, i3));
      }
      finally
      {
        monitorexit;
      }
      localArrayList.add(localo.a);
      break label137;
      label132: monitorexit;
      return localArrayList;
      label137: i1++;
    }
  }

  public void a(double paramDouble)
  {
    this.l = paramDouble;
  }

  public void a(long paramLong)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("the duration is invalid " + paramLong);
    this.n = paramLong;
  }

  void a(o paramo)
  {
    monitorenter;
    try
    {
      c(paramo.a);
      this.j.add(paramo);
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

  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, Exception paramException)
  {
    a(paramString, new a(paramInt, paramLong1, paramLong2, paramException));
  }

  public void a(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      b(new URL(paramString).getHost(), paramLong1, paramLong2);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
  }

  public void a(String paramString, long paramLong1, long paramLong2, Exception paramException)
  {
    try
    {
      b(new URL(paramString).getHost(), paramLong1, paramLong2, paramException);
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
    }
  }

  public void a(String paramString, a parama)
  {
    monitorenter;
    try
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        o localo = (o)localIterator.next();
        if (!TextUtils.equals(paramString, localo.a))
          continue;
        localo.a(parama);
      }
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(String[] paramArrayOfString)
  {
    monitorenter;
    while (true)
    {
      int i1;
      int i3;
      try
      {
        i1 = -1 + this.j.size();
        if (i1 < 0)
          continue;
        int i2 = paramArrayOfString.length;
        i3 = 0;
        if (i3 >= i2)
          break label175;
        String str = paramArrayOfString[i3];
        if (!TextUtils.equals(((o)this.j.get(i1)).a, str))
          break label181;
        this.j.remove(i1);
        break label175;
        Iterator localIterator = this.j.iterator();
        i4 = 0;
        if (!localIterator.hasNext())
          break label194;
        o localo = (o)localIterator.next();
        if (localo.b > i4)
        {
          i6 = localo.b;
          break label187;
          if (i5 >= paramArrayOfString.length)
            continue;
          a(new o(paramArrayOfString[i5], i4 + paramArrayOfString.length - i5));
          i5++;
          continue;
          return;
        }
      }
      finally
      {
        monitorexit;
      }
      int i6 = i4;
      break label187;
      label175: i1--;
      continue;
      label181: i3++;
      continue;
      label187: int i4 = i6;
      continue;
      label194: int i5 = 0;
    }
  }

  public boolean a()
  {
    return TextUtils.equals(this.a, f.a().b());
  }

  public boolean a(b paramb)
  {
    return TextUtils.equals(this.a, paramb.a);
  }

  public void b(String paramString)
  {
    this.m = paramString;
  }

  public void b(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString, 0, paramLong1, paramLong2, null);
  }

  public void b(String paramString, long paramLong1, long paramLong2, Exception paramException)
  {
    a(paramString, -1, paramLong1, paramLong2, paramException);
  }

  public boolean b()
  {
    return System.currentTimeMillis() - this.i < this.n;
  }

  boolean c()
  {
    long l1 = 864000000L;
    if (l1 < this.n)
      l1 = this.n;
    long l2 = System.currentTimeMillis();
    return (l2 - this.i > l1) || ((l2 - this.i > this.n) && (this.a.startsWith("WIFI-")));
  }

  public ArrayList<String> d()
  {
    monitorenter;
    try
    {
      ArrayList localArrayList = a(false);
      monitorexit;
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public String e()
  {
    monitorenter;
    try
    {
      String str;
      if (!TextUtils.isEmpty(this.k))
        str = this.k;
      while (true)
      {
        return str;
        if (TextUtils.isEmpty(this.e))
        {
          str = "hardcode_isp";
          continue;
        }
        String[] arrayOfString = new String[5];
        arrayOfString[0] = this.e;
        arrayOfString[1] = this.c;
        arrayOfString[2] = this.d;
        arrayOfString[3] = this.g;
        arrayOfString[4] = this.f;
        this.k = f.a(arrayOfString, "_");
        str = this.k;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  ArrayList<o> f()
  {
    return this.j;
  }

  public double g()
  {
    if (this.l < 1.E-005D)
      return 0.1D;
    return this.l;
  }

  public JSONObject h()
  {
    monitorenter;
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("net", this.a);
      localJSONObject.put("ttl", this.n);
      localJSONObject.put("pct", this.l);
      localJSONObject.put("ts", this.i);
      localJSONObject.put("city", this.d);
      localJSONObject.put("prv", this.c);
      localJSONObject.put("cty", this.g);
      localJSONObject.put("isp", this.e);
      localJSONObject.put("ip", this.f);
      localJSONObject.put("host", this.b);
      localJSONObject.put("xf", this.h);
      localJSONArray = new JSONArray();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((o)localIterator.next()).b());
    }
    finally
    {
      monitorexit;
    }
    localJSONObject.put("fbs", localJSONArray);
    monitorexit;
    return localJSONObject;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append(e());
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      o localo = (o)localIterator.next();
      localStringBuilder.append("\n");
      localStringBuilder.append(localo.toString());
    }
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.b
 * JD-Core Version:    0.6.0
 */