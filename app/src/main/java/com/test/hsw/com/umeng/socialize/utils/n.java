package com.umeng.socialize.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.socialize.bean.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class n
{
  private static boolean a;
  private static Map<p, StringBuilder> b;
  private static Map<String, Integer> c;
  private static Map<String, Integer> d;
  private static Map<p, Integer> e;

  static
  {
    int i = 0;
    a = false;
    b = new HashMap();
    c = new HashMap();
    d = new HashMap();
    e = new HashMap();
    e.put(p.f, Integer.valueOf(1));
    e.put(p.e, Integer.valueOf(2));
    e.put(p.k, Integer.valueOf(3));
    e.put(p.h, Integer.valueOf(4));
    e.put(p.l, Integer.valueOf(5));
    e.put(p.d, Integer.valueOf(6));
    e.put(p.c, Integer.valueOf(7));
    e.put(p.i, Integer.valueOf(8));
    e.put(p.j, Integer.valueOf(9));
    e.put(p.g, Integer.valueOf(10));
    e.put(p.m, Integer.valueOf(11));
    e.put(p.n, Integer.valueOf(12));
    e.put(p.a, Integer.valueOf(13));
    e.put(p.q, Integer.valueOf(14));
    e.put(p.r, Integer.valueOf(15));
    e.put(p.o, Integer.valueOf(16));
    e.put(p.p, Integer.valueOf(17));
    e.put(p.s, Integer.valueOf(18));
    p[] arrayOfp = p.values();
    int j = arrayOfp.length;
    while (i < j)
    {
      p localp = arrayOfp[i];
      b.put(localp, new StringBuilder());
      i++;
    }
  }

  public static int a(p paramp)
  {
    if (paramp != null)
      try
      {
        if (paramp != p.b)
        {
          int i = ((Integer)e.get(paramp)).intValue();
          return i;
        }
      }
      catch (Exception localException)
      {
        return -1;
      }
    return -1;
  }

  private static String a(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder == null) || (paramStringBuilder.length() <= 0))
      return "0";
    String str1 = paramStringBuilder.toString();
    String str2 = str1.substring(0, str1.lastIndexOf("("));
    return str2.substring(1 + str2.lastIndexOf("+"), str2.length());
  }

  public static Map<p, StringBuilder> a()
  {
    return b;
  }

  public static Map<String, Object> a(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString2))
      return paramMap;
    while (true)
    {
      try
      {
        String[] arrayOfString = paramString2.split("\\+");
        int j = arrayOfString.length;
        if (i >= j)
          break;
        String str1 = arrayOfString[i];
        String str2 = str1.substring(0, str1.indexOf("("));
        String str3 = str1.substring(1 + str1.indexOf("("), str1.indexOf("-"));
        String str4 = str1.substring(1 + str1.indexOf("-"), str1.indexOf(")"));
        String str5 = paramString1 + "-" + str3 + "-" + str2;
        if (paramMap.get(str5) != null)
        {
          str6 = paramMap.get(str5).toString();
          int k = Integer.parseInt(str4);
          if (TextUtils.isEmpty(str6))
            continue;
          k += Integer.parseInt(str6);
          paramMap.put(str5, String.valueOf(k));
          i++;
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return paramMap;
      }
      String str6 = "";
    }
  }

  public static void a(Context paramContext)
  {
    b(paramContext);
    if (!d.containsKey("shake"))
      d.put("shake", Integer.valueOf(0));
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("umeng_social_shake", 0).edit();
    localEditor.putInt("shake", 1 + ((Integer)d.get("shake")).intValue());
    localEditor.commit();
  }

  public static void a(Context paramContext, p paramp, int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 25))
      return;
    a(paramContext, paramp, false);
    if ((a) && (paramp != p.b))
    {
      a(paramp, b);
      a = false;
    }
    if (paramp == p.b)
      a = true;
    StringBuilder localStringBuilder = (StringBuilder)b.get(paramp);
    String str = a(localStringBuilder);
    if (localStringBuilder.length() <= 0)
      localStringBuilder.append(String.valueOf(paramInt)).append("(0-1)+");
    while (true)
    {
      b(paramContext, false);
      return;
      if (b(localStringBuilder, paramInt))
      {
        a(localStringBuilder, paramInt);
        continue;
      }
      localStringBuilder.append(String.valueOf(paramInt)).append("(").append(String.valueOf(str)).append("-").append("1").append(")").append("+");
    }
  }

  public static void a(Context paramContext, p paramp, boolean paramBoolean)
  {
    String str;
    SharedPreferences localSharedPreferences;
    if (paramBoolean)
    {
      str = "umeng_social_oauth";
      localSharedPreferences = paramContext.getSharedPreferences(str, 0);
      if (!paramBoolean)
        break label160;
      int k = a(paramp);
      int m = localSharedPreferences.getInt(k + "-3-s", 0);
      int n = localSharedPreferences.getInt(k + "-3-f", 0);
      c.put(k + "-3-s", Integer.valueOf(m));
      c.put(k + "-3-f", Integer.valueOf(n));
    }
    while (true)
    {
      return;
      str = "umeng_social_method";
      break;
      label160: for (p localp : p.values())
      {
        StringBuilder localStringBuilder = new StringBuilder(localSharedPreferences.getString(localp.toString(), ""));
        b.remove(localp.toString());
        b.put(localp, localStringBuilder);
      }
    }
  }

  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("umeng_social_oauth", 0).edit().clear().commit();
    c.clear();
    if (paramBoolean)
    {
      paramContext.getSharedPreferences("umeng_social_method", 0).edit().clear().commit();
      b.clear();
      paramContext.getSharedPreferences("umeng_social_shake", 0).edit().clear().commit();
      d.clear();
    }
  }

  private static void a(p paramp, Map<p, StringBuilder> paramMap)
  {
    StringBuilder localStringBuilder = (StringBuilder)paramMap.get(paramp);
    if (!TextUtils.isEmpty(localStringBuilder.toString()))
      if (b(localStringBuilder, 1))
        a(localStringBuilder, 1);
    while (true)
    {
      paramMap.put(p.b, new StringBuilder());
      return;
      paramMap.put(paramp, new StringBuilder("1(0-1)+"));
    }
  }

  public static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    String str1 = paramStringBuilder.toString();
    int i = str1.indexOf(paramInt + "(");
    String str2 = str1.substring(i);
    if (str2.contains("+"))
    {
      String str3 = str2.substring(0, str2.indexOf("+"));
      if ((str3.contains("-")) && (str3.contains(")")))
      {
        int j = str3.indexOf("-");
        int k = str3.lastIndexOf(")");
        String str4 = str3.substring(j + 1, k);
        if (!TextUtils.isEmpty(str4))
        {
          int m = 1 + Integer.valueOf(str4).intValue();
          paramStringBuilder.delete(1 + (i + j), k + i);
          paramStringBuilder.insert(1 + (i + j), String.valueOf(m));
        }
      }
    }
  }

  public static Map<String, Integer> b()
  {
    return c;
  }

  public static Map<String, Integer> b(Context paramContext)
  {
    int i = paramContext.getSharedPreferences("umeng_social_shake", 0).getInt("shake", 0);
    d.put("shake", Integer.valueOf(i));
    return d;
  }

  public static void b(Context paramContext, p paramp, int paramInt)
  {
    a(paramContext, paramp, true);
    int i = a(paramp);
    if (paramInt == 1)
    {
      String str2 = i + "-3-s";
      int k = 1 + ((Integer)c.get(str2)).intValue();
      c.put(str2, Integer.valueOf(k));
    }
    while (true)
    {
      b(paramContext, true);
      return;
      if (paramInt != 0)
        continue;
      String str1 = i + "-3-f";
      int j = 1 + ((Integer)c.get(str1)).intValue();
      c.put(str1, Integer.valueOf(j));
    }
  }

  private static void b(Context paramContext, boolean paramBoolean)
  {
    String str1;
    if (paramBoolean)
      str1 = "umeng_social_oauth";
    Object localObject1;
    p localp;
    StringBuilder localStringBuilder;
    while (true)
    {
      localObject1 = paramContext.getSharedPreferences(str1, 0).edit();
      if (paramBoolean)
      {
        Iterator localIterator2 = c.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str2 = (String)localIterator2.next();
          ((SharedPreferences.Editor)localObject1).putInt(str2, ((Integer)c.get(str2)).intValue());
        }
        str1 = "umeng_social_method";
        continue;
      }
      Iterator localIterator1 = b.keySet().iterator();
      if (!localIterator1.hasNext())
        break;
      localp = (p)localIterator1.next();
      localStringBuilder = (StringBuilder)b.get(localp);
      if ((localStringBuilder == null) || (localStringBuilder.length() <= 0))
        break label191;
    }
    label191: for (Object localObject2 = ((SharedPreferences.Editor)localObject1).putString(localp.toString(), localStringBuilder.toString()); ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      ((SharedPreferences.Editor)localObject1).commit();
      return;
    }
  }

  private static boolean b(StringBuilder paramStringBuilder, int paramInt)
  {
    if ((paramStringBuilder == null) || (TextUtils.isEmpty(paramStringBuilder.toString())));
    do
      return false;
    while (!("+" + paramStringBuilder.toString()).contains("+" + paramInt + "("));
    return true;
  }

  public static void c(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("umeng_social_oauth", 0);
    p[] arrayOfp = p.values();
    int i = arrayOfp.length;
    int j = 0;
    if (j < i)
    {
      int k = a(arrayOfp[j]);
      if (k == -1);
      while (true)
      {
        j++;
        break;
        int m = localSharedPreferences.getInt(k + "-3-s", 0);
        int n = localSharedPreferences.getInt(k + "-3-f", 0);
        c.put(k + "-3-s", Integer.valueOf(m));
        c.put(k + "-3-f", Integer.valueOf(n));
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.n
 * JD-Core Version:    0.6.0
 */