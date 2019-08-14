package org.a.a.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class o
{
  private static final ConcurrentMap<String, List<Locale>> a = new ConcurrentHashMap();
  private static final ConcurrentMap<String, List<Locale>> b = new ConcurrentHashMap();

  public static List<Locale> a()
  {
    return a.a();
  }

  public static List<Locale> a(Locale paramLocale)
  {
    return a(paramLocale, paramLocale);
  }

  public static List<Locale> a(Locale paramLocale1, Locale paramLocale2)
  {
    ArrayList localArrayList = new ArrayList(4);
    if (paramLocale1 != null)
    {
      localArrayList.add(paramLocale1);
      if (paramLocale1.getVariant().length() > 0)
        localArrayList.add(new Locale(paramLocale1.getLanguage(), paramLocale1.getCountry()));
      if (paramLocale1.getCountry().length() > 0)
        localArrayList.add(new Locale(paramLocale1.getLanguage(), ""));
      if (!localArrayList.contains(paramLocale2))
        localArrayList.add(paramLocale2);
    }
    return Collections.unmodifiableList(localArrayList);
  }

  public static Locale a(String paramString)
  {
    if (paramString == null)
      return null;
    int i = paramString.length();
    if ((i != 2) && (i != 5) && (i < 7))
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    int j = paramString.charAt(0);
    int k = paramString.charAt(1);
    if ((j < 97) || (j > 122) || (k < 97) || (k > 122))
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    if (i == 2)
      return new Locale(paramString, "");
    if (paramString.charAt(2) != '_')
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    int m = paramString.charAt(3);
    if (m == 95)
      return new Locale(paramString.substring(0, 2), "", paramString.substring(4));
    int n = paramString.charAt(4);
    if ((m < 65) || (m > 90) || (n < 65) || (n > 90))
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    if (i == 5)
      return new Locale(paramString.substring(0, 2), paramString.substring(3, 5));
    if (paramString.charAt(5) != '_')
      throw new IllegalArgumentException("Invalid locale format: " + paramString);
    return new Locale(paramString.substring(0, 2), paramString.substring(3, 5), paramString.substring(6));
  }

  public static List<Locale> b(String paramString)
  {
    List localList1;
    if (paramString == null)
      localList1 = Collections.emptyList();
    do
    {
      return localList1;
      localList1 = (List)a.get(paramString);
    }
    while (localList1 != null);
    ArrayList localArrayList = new ArrayList();
    List localList2 = a();
    for (int i = 0; i < localList2.size(); i++)
    {
      Locale localLocale = (Locale)localList2.get(i);
      if ((!paramString.equals(localLocale.getCountry())) || (localLocale.getVariant().length() != 0))
        continue;
      localArrayList.add(localLocale);
    }
    List localList3 = Collections.unmodifiableList(localArrayList);
    a.putIfAbsent(paramString, localList3);
    return (List)a.get(paramString);
  }

  public static Set<Locale> b()
  {
    return a.b();
  }

  public static boolean b(Locale paramLocale)
  {
    return a().contains(paramLocale);
  }

  public static List<Locale> c(String paramString)
  {
    List localList1;
    if (paramString == null)
      localList1 = Collections.emptyList();
    do
    {
      return localList1;
      localList1 = (List)b.get(paramString);
    }
    while (localList1 != null);
    ArrayList localArrayList = new ArrayList();
    List localList2 = a();
    for (int i = 0; i < localList2.size(); i++)
    {
      Locale localLocale = (Locale)localList2.get(i);
      if ((!paramString.equals(localLocale.getLanguage())) || (localLocale.getCountry().length() == 0) || (localLocale.getVariant().length() != 0))
        continue;
      localArrayList.add(localLocale);
    }
    List localList3 = Collections.unmodifiableList(localArrayList);
    b.putIfAbsent(paramString, localList3);
    return (List)b.get(paramString);
  }

  static class a
  {
    private static List<Locale> a = Collections.unmodifiableList(new ArrayList(Arrays.asList(Locale.getAvailableLocales())));
    private static Set<Locale> b = Collections.unmodifiableSet(new HashSet(o.a()));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.o
 * JD-Core Version:    0.6.0
 */