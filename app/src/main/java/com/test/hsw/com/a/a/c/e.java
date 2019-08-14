package com.a.a.c;

import android.graphics.Bitmap;
import com.a.a.a.b.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private static final String a = "_";
  private static final String b = "x";

  public static String a(String paramString, com.a.a.b.a.e parame)
  {
    return paramString + "_" + parame.a() + "x" + parame.b();
  }

  public static Comparator<String> a()
  {
    return new f();
  }

  public static List<Bitmap> a(String paramString, c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramc.a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.startsWith(paramString))
        continue;
      localArrayList.add(paramc.b(str));
    }
    return localArrayList;
  }

  public static List<String> b(String paramString, c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramc.a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!str.startsWith(paramString))
        continue;
      localArrayList.add(str);
    }
    return localArrayList;
  }

  public static void c(String paramString, c paramc)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramc.a().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      if (!str.startsWith(paramString))
        continue;
      localArrayList.add(str);
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
      paramc.a((String)localIterator2.next());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.c.e
 * JD-Core Version:    0.6.0
 */