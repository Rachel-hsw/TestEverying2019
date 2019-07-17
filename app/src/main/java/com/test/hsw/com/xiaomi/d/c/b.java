package com.xiaomi.d.c;

import android.os.Bundle;
import com.xiaomi.d.e.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b extends d
{
  private a a = a.a;
  private final Map<String, String> d = new HashMap();

  public b()
  {
  }

  public b(Bundle paramBundle)
  {
    super(paramBundle);
    if (paramBundle.containsKey("ext_iq_type"))
      this.a = a.a(paramBundle.getString("ext_iq_type"));
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<iq ");
    if (k() != null)
      localStringBuilder.append("id=\"" + k() + "\" ");
    if (m() != null)
      localStringBuilder.append("to=\"").append(g.a(m())).append("\" ");
    if (n() != null)
      localStringBuilder.append("from=\"").append(g.a(n())).append("\" ");
    if (l() != null)
      localStringBuilder.append("chid=\"").append(g.a(l())).append("\" ");
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(g.a((String)localEntry.getKey())).append("=\"");
      localStringBuilder.append(g.a((String)localEntry.getValue())).append("\" ");
    }
    if (this.a == null)
      localStringBuilder.append("type=\"get\">");
    while (true)
    {
      String str = d();
      if (str != null)
        localStringBuilder.append(str);
      localStringBuilder.append(s());
      h localh = p();
      if (localh != null)
        localStringBuilder.append(localh.d());
      localStringBuilder.append("</iq>");
      return localStringBuilder.toString();
      localStringBuilder.append("type=\"").append(b()).append("\">");
    }
  }

  public String a(String paramString)
  {
    monitorenter;
    try
    {
      String str = (String)this.d.get(paramString);
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(a parama)
  {
    if (parama == null)
    {
      this.a = a.a;
      return;
    }
    this.a = parama;
  }

  public void a(String paramString1, String paramString2)
  {
    monitorenter;
    try
    {
      this.d.put(paramString1, paramString2);
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

  public void a(Map<String, String> paramMap)
  {
    monitorenter;
    try
    {
      this.d.putAll(paramMap);
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

  public a b()
  {
    return this.a;
  }

  public Bundle c()
  {
    Bundle localBundle = super.c();
    if (this.a != null)
      localBundle.putString("ext_iq_type", this.a.toString());
    return localBundle;
  }

  public String d()
  {
    return null;
  }

  public static class a
  {
    public static final a a = new a("get");
    public static final a b = new a("set");
    public static final a c = new a("result");
    public static final a d = new a("error");
    public static final a e = new a("command");
    private String f;

    private a(String paramString)
    {
      this.f = paramString;
    }

    public static a a(String paramString)
    {
      if (paramString == null);
      String str;
      do
      {
        return null;
        str = paramString.toLowerCase();
        if (a.toString().equals(str))
          return a;
        if (b.toString().equals(str))
          return b;
        if (d.toString().equals(str))
          return d;
        if (c.toString().equals(str))
          return c;
      }
      while (!e.toString().equals(str));
      return e;
    }

    public String toString()
    {
      return this.f;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.c.b
 * JD-Core Version:    0.6.0
 */