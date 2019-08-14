package com.squareup.a.a.a;

import com.squareup.a.aa;
import com.squareup.a.b;
import com.squareup.a.r;
import com.squareup.a.r.a;
import com.squareup.a.w;
import com.squareup.a.w.a;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Set<Ljava.lang.String;>;
import java.util.TreeMap;
import java.util.TreeSet;

public final class k
{
  static final String a;
  public static final String b;
  public static final String c;
  public static final String d;
  private static final Comparator<String> e = new l();

  static
  {
    a = com.squareup.a.a.j.a().b();
    b = a + "-Sent-Millis";
    c = a + "-Received-Millis";
    d = a + "-Selected-Protocol";
  }

  public static long a(aa paramaa)
  {
    return a(paramaa.f());
  }

  public static long a(r paramr)
  {
    return b(paramr.a("Content-Length"));
  }

  public static long a(w paramw)
  {
    return a(paramw.e());
  }

  public static w a(b paramb, aa paramaa, Proxy paramProxy)
    throws IOException
  {
    if (paramaa.c() == 407)
      return paramb.b(paramProxy, paramaa);
    return paramb.a(paramProxy, paramaa);
  }

  private static String a(List<String> paramList)
  {
    if (paramList.size() == 1)
      return (String)paramList.get(0);
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramList.size(); i++)
    {
      if (i > 0)
        localStringBuilder.append("; ");
      localStringBuilder.append((String)paramList.get(i));
    }
    return localStringBuilder.toString();
  }

  public static Map<String, List<String>> a(r paramr, String paramString)
  {
    TreeMap localTreeMap = new TreeMap(e);
    for (int i = 0; i < paramr.a(); i++)
    {
      String str1 = paramr.a(i);
      String str2 = paramr.b(i);
      ArrayList localArrayList = new ArrayList();
      List localList = (List)localTreeMap.get(str1);
      if (localList != null)
        localArrayList.addAll(localList);
      localArrayList.add(str2);
      localTreeMap.put(str1, Collections.unmodifiableList(localArrayList));
    }
    if (paramString != null)
      localTreeMap.put(null, Collections.unmodifiableList(Collections.singletonList(paramString)));
    return Collections.unmodifiableMap(localTreeMap);
  }

  public static void a(w.a parama, Map<String, List<String>> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((!"Cookie".equalsIgnoreCase(str)) && (!"Cookie2".equalsIgnoreCase(str))) || (((List)localEntry.getValue()).isEmpty()))
        continue;
      parama.b(str, a((List)localEntry.getValue()));
    }
  }

  public static boolean a(aa paramaa, r paramr, w paramw)
  {
    Iterator localIterator = d(paramaa).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!com.squareup.a.a.l.a(paramr.c(str), paramw.b(str)))
        return false;
    }
    return true;
  }

  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }

  private static long b(String paramString)
  {
    if (paramString == null)
      return -1L;
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -1L;
  }

  public static List<com.squareup.a.j> b(r paramr, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramr.a())
    {
      if (!paramString.equalsIgnoreCase(paramr.a(i)));
      label185: 
      while (true)
      {
        i++;
        break;
        String str1 = paramr.b(i);
        int j = 0;
        while (true)
        {
          if (j >= str1.length())
            break label185;
          int k = c.a(str1, j, " ");
          String str2 = str1.substring(j, k).trim();
          int m = c.a(str1, k);
          if (!str1.regionMatches(true, m, "realm=\"", 0, "realm=\"".length()))
            break;
          int n = m + "realm=\"".length();
          int i1 = c.a(str1, n, "\"");
          String str3 = str1.substring(n, i1);
          j = c.a(str1, 1 + c.a(str1, i1 + 1, ","));
          localArrayList.add(new com.squareup.a.j(str2, str3));
        }
      }
    }
    return localArrayList;
  }

  public static boolean b(aa paramaa)
  {
    return d(paramaa).contains("*");
  }

  public static r c(aa paramaa)
  {
    Set localSet = d(paramaa);
    if (localSet.isEmpty())
      return new r.a().a();
    r.a locala = new r.a();
    r localr = paramaa.a().e();
    for (int i = 0; i < localr.a(); i++)
    {
      String str = localr.a(i);
      if (!localSet.contains(str))
        continue;
      locala.a(str, localr.b(i));
    }
    return locala.a();
  }

  private static Set<String> d(aa paramaa)
  {
    Object localObject = Collections.emptySet();
    r localr = paramaa.f();
    int i = 0;
    if (i < localr.a())
    {
      if (!"Vary".equalsIgnoreCase(localr.a(i)));
      while (true)
      {
        i++;
        break;
        String str = localr.b(i);
        if (((Set)localObject).isEmpty())
          localObject = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        String[] arrayOfString = str.split(",");
        int j = arrayOfString.length;
        for (int k = 0; k < j; k++)
          ((Set)localObject).add(arrayOfString[k].trim());
      }
    }
    return (Set<String>)localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.k
 * JD-Core Version:    0.6.0
 */