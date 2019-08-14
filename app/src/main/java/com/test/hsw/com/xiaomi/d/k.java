package com.xiaomi.d;

import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.g.b;
import com.xiaomi.d.c.d;
import com.xiaomi.d.c.e;
import com.xiaomi.d.c.h;
import com.xiaomi.d.e.g;
import com.xiaomi.push.service.an.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class k
{
  public void a(an.b paramb, String paramString, a parama)
  {
    a locala = new a(paramb, paramString, parama);
    parama.a(locala);
    c.a("SMACK: bind id=" + locala.k());
  }

  public class a extends d
  {
    public a(an.b paramString, String parama, a arg4)
    {
      HashMap localHashMap = new HashMap();
      Object localObject;
      int i = localObject.i();
      localHashMap.put("challenge", parama);
      localHashMap.put("token", paramString.c);
      localHashMap.put("chid", paramString.h);
      localHashMap.put("from", paramString.b);
      localHashMap.put("id", k());
      localHashMap.put("to", "xiaomi.com");
      String str6;
      if (paramString.e)
      {
        localHashMap.put("kick", "1");
        if (localObject.k() <= 0L)
          break label704;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(i);
        arrayOfObject[1] = Long.valueOf(localObject.k());
        str6 = String.format("conn:%1$d,t:%2$d", arrayOfObject);
        localHashMap.put("pf", str6);
        localObject.j();
        localObject.l();
      }
      label283: label670: label680: label692: label704: for (String str1 = str6; ; str1 = null)
      {
        label219: label243: String str2;
        String str3;
        label379: com.xiaomi.d.c.a locala4;
        label464: String str4;
        label501: com.xiaomi.d.c.a locala6;
        if (!TextUtils.isEmpty(paramString.f))
        {
          localHashMap.put("client_attrs", paramString.f);
          if (TextUtils.isEmpty(paramString.g))
            break label630;
          localHashMap.put("cloud_attrs", paramString.g);
          if ((!paramString.d.equals("XIAOMI-PASS")) && (!paramString.d.equals("XMPUSH-PASS")))
            break label645;
          str2 = b.a(paramString.d, null, localHashMap, paramString.i);
          l(paramString.h);
          n(paramString.b);
          m("xiaomi.com");
          o(paramString.a);
          com.xiaomi.d.c.a locala1 = new com.xiaomi.d.c.a("token", null, (String[])null, (String[])null);
          locala1.b(paramString.c);
          a(locala1);
          com.xiaomi.d.c.a locala2 = new com.xiaomi.d.c.a("kick", null, (String[])null, (String[])null);
          if (!paramString.e)
            break label663;
          str3 = "1";
          locala2.b(str3);
          a(locala2);
          com.xiaomi.d.c.a locala3 = new com.xiaomi.d.c.a("sig", null, (String[])null, (String[])null);
          locala3.b(str2);
          a(locala3);
          locala4 = new com.xiaomi.d.c.a("method", null, (String[])null, (String[])null);
          if (TextUtils.isEmpty(paramString.d))
            break label670;
          locala4.b(paramString.d);
          a(locala4);
          com.xiaomi.d.c.a locala5 = new com.xiaomi.d.c.a("client_attrs", null, (String[])null, (String[])null);
          if (paramString.f != null)
            break label680;
          str4 = "";
          locala5.b(str4);
          a(locala5);
          locala6 = new com.xiaomi.d.c.a("cloud_attrs", null, (String[])null, (String[])null);
          if (paramString.g != null)
            break label692;
        }
        for (String str5 = ""; ; str5 = g.a(paramString.g))
        {
          locala6.b(str5);
          a(locala6);
          if (!TextUtils.isEmpty(str1))
          {
            com.xiaomi.d.c.a locala7 = new com.xiaomi.d.c.a("pf", null, (String[])null, (String[])null);
            locala7.b(str1);
            a(locala7);
          }
          return;
          localHashMap.put("kick", "0");
          break;
          localHashMap.put("client_attrs", "");
          break label219;
          label630: localHashMap.put("cloud_attrs", "");
          break label243;
          if (paramString.d.equals("XIAOMI-SASL"));
          str2 = null;
          break label283;
          str3 = "0";
          break label379;
          locala4.b("XIAOMI-SASL");
          break label464;
          str4 = g.a(paramString.f);
          break label501;
        }
      }
    }

    public String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<bind ");
      if (k() != null)
        localStringBuilder.append("id=\"" + k() + "\" ");
      if (m() != null)
        localStringBuilder.append("to=\"").append(g.a(m())).append("\" ");
      if (n() != null)
        localStringBuilder.append("from=\"").append(g.a(n())).append("\" ");
      if (l() != null)
        localStringBuilder.append("chid=\"").append(g.a(l())).append("\">");
      if (q() != null)
      {
        Iterator localIterator = q().iterator();
        while (localIterator.hasNext())
          localStringBuilder.append(((com.xiaomi.d.c.a)localIterator.next()).d());
      }
      localStringBuilder.append("</bind>");
      return localStringBuilder.toString();
    }
  }

  public static class b extends d
  {
    private a a;

    public String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<bind ");
      if (k() != null)
        localStringBuilder.append("id=\"" + k() + "\" ");
      if (m() != null)
        localStringBuilder.append("to=\"").append(g.a(m())).append("\" ");
      if (n() != null)
        localStringBuilder.append("from=\"").append(g.a(n())).append("\" ");
      if (l() != null)
        localStringBuilder.append(" chid=\"").append(g.a(l())).append("\" ");
      if (this.a == null)
        localStringBuilder.append("type=\"result\">");
      while (q() != null)
      {
        Iterator localIterator = q().iterator();
        while (localIterator.hasNext())
          localStringBuilder.append(((com.xiaomi.d.c.a)localIterator.next()).d());
        localStringBuilder.append("type=\"").append(b()).append("\">");
      }
      h localh = p();
      if (localh != null)
        localStringBuilder.append(localh.d());
      localStringBuilder.append("</bind>");
      return localStringBuilder.toString();
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

    public a b()
    {
      return this.a;
    }

    public static class a
    {
      public static final a a = new a("result");
      public static final a b = new a("error");
      private String c;

      private a(String paramString)
      {
        this.c = paramString;
      }

      public static a a(String paramString)
      {
        if (paramString == null);
        String str;
        do
        {
          return null;
          str = paramString.toLowerCase();
          if (b.toString().equals(str))
            return b;
        }
        while (!a.toString().equals(str));
        return a;
      }

      public String toString()
      {
        return this.c;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.k
 * JD-Core Version:    0.6.0
 */