package com.tencent.a.a.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
{
  private static g i = null;
  private Map<Integer, f> f = null;
  private int g = 0;
  private Context h = null;

  private g(Context paramContext)
  {
    this.h = paramContext.getApplicationContext();
    this.f = new HashMap(3);
    this.f.put(Integer.valueOf(1), new e(paramContext));
    this.f.put(Integer.valueOf(2), new b(paramContext));
    this.f.put(Integer.valueOf(4), new d(paramContext));
  }

  private c a(List<Integer> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        f localf = (f)this.f.get(localInteger);
        if (localf == null)
          continue;
        c localc = localf.e();
        if ((localc != null) && (h.e(localc.c)))
          return localc;
      }
    }
    return new c();
  }

  public static g a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (i == null)
        i = new g(paramContext);
      g localg = i;
      return localg;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final void b(String paramString)
  {
    c localc = f();
    localc.c = paramString;
    if (!h.d(localc.a))
      localc.a = h.b(this.h);
    if (!h.d(localc.b))
      localc.b = h.c(this.h);
    localc.d = System.currentTimeMillis();
    Iterator localIterator = this.f.entrySet().iterator();
    while (localIterator.hasNext())
      ((f)((Map.Entry)localIterator.next()).getValue()).a(localc);
  }

  public final c f()
  {
    Integer[] arrayOfInteger = new Integer[3];
    arrayOfInteger[0] = Integer.valueOf(1);
    arrayOfInteger[1] = Integer.valueOf(2);
    arrayOfInteger[2] = Integer.valueOf(4);
    return a(new ArrayList(Arrays.asList(arrayOfInteger)));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a.a.g
 * JD-Core Version:    0.6.0
 */