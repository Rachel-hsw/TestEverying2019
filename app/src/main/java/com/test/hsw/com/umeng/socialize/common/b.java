package com.umeng.socialize.common;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class b
{
  private static String c = "";
  private Map<String, b> a;
  private Context b;

  public b(Context paramContext, Map<String, b> paramMap)
  {
    this.a = paramMap;
    this.b = paramContext;
  }

  public static int a(Context paramContext, a parama, String paramString)
  {
    Resources localResources = paramContext.getResources();
    if (TextUtils.isEmpty(c))
      c = paramContext.getPackageName();
    int i = localResources.getIdentifier(paramString, parama.toString(), c);
    if (i <= 0)
      throw new RuntimeException("获取资源ID失败:(packageName=" + c + " type=" + parama + " name=" + paramString);
    return i;
  }

  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getString(a(paramContext, a.e, paramString));
  }

  public static void a(String paramString)
  {
    c = paramString;
  }

  public static int[] b(Context paramContext, String paramString)
  {
    return c(paramContext, paramString);
  }

  private static final int[] c(Context paramContext, String paramString)
  {
    try
    {
      for (Field localField : Class.forName(paramContext.getPackageName() + ".R$styleable").getFields())
      {
        if (!localField.getName().equals(paramString))
          continue;
        int[] arrayOfInt = (int[])(int[])localField.get(null);
        return arrayOfInt;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }

  public Map<String, b> a()
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (this.a != null)
          continue;
        localMap = this.a;
        return localMap;
        Iterator localIterator = this.a.keySet().iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          b localb = (b)this.a.get(str);
          localb.d = a(this.b, localb.a, localb.b);
          localb.c = true;
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      Map localMap = this.a;
    }
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[10];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      k = arrayOfa;
    }
  }

  public static class b
  {
    public b.a a;
    public String b;
    public boolean c = false;
    public int d;

    public b(b.a parama, String paramString)
    {
      this.a = parama;
      this.b = paramString;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.common.b
 * JD-Core Version:    0.6.0
 */