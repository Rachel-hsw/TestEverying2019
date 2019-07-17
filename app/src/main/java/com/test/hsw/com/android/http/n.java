package com.android.http;

import android.content.Context;
import com.android.volley.a;
import com.android.volley.e;
import com.android.volley.toolbox.w;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.j;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class n
{
  private static final String a = "UTF-8";
  private static final int b = 10000;
  private static final int c = 1;
  private static volatile n d = null;
  private com.android.volley.q e = null;

  public static n a()
  {
    if (d == null)
      monitorenter;
    try
    {
      if (d == null)
        d = new n();
      return d;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private void b(String paramString1, String paramString2, a parama, int paramInt)
  {
    new Thread(new o(this, paramString1, paramString2, parama, paramInt)).start();
  }

  public l a(int paramInt1, String paramString, Object paramObject, Map<String, String> paramMap, m paramm, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramm == null)
      throw new NullPointerException();
    b localb = new b(paramm, paramInt4);
    Object localObject;
    if ((paramObject != null) && ((paramObject instanceof q)))
    {
      c localc2 = new c(1, paramString, paramObject, localb, localb);
      localc2.a(false);
      localObject = localc2;
    }
    while (true)
    {
      if ((paramMap != null) && (!paramMap.isEmpty()));
      try
      {
        ((com.android.volley.o)localObject).b().putAll(paramMap);
        ((com.android.volley.o)localObject).a(new e(paramInt2, paramInt3, 1.0F));
        localb.a((com.android.volley.o)localObject);
        if (this.e == null)
        {
          throw new NullPointerException();
          c localc1 = new c(paramInt1, paramString, paramObject, localb, localb);
          localc1.a(paramBoolean);
          localObject = localc1;
        }
      }
      catch (a locala)
      {
        while (true)
          locala.printStackTrace();
        paramm.a();
        this.e.a((com.android.volley.o)localObject);
      }
    }
    return (l)localb;
  }

  public l a(int paramInt1, String paramString, Object paramObject, Map<String, String> paramMap, a parama, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramString, paramObject, paramMap, new p(this, parama), paramBoolean, paramInt2, paramInt3, paramInt4);
  }

  public l a(String paramString, a parama, int paramInt)
  {
    return a(paramString, parama, true, paramInt);
  }

  public l a(String paramString, a parama, boolean paramBoolean, int paramInt)
  {
    return a(0, paramString, null, null, parama, paramBoolean, 10000, 1, paramInt);
  }

  public l a(String paramString, Object paramObject, a parama, int paramInt)
  {
    return a(paramString, paramObject, parama, false, 10000, 1, paramInt);
  }

  public l a(String paramString, Object paramObject, a parama, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(1, paramString, paramObject, null, parama, paramBoolean, paramInt1, paramInt2, paramInt3);
  }

  public l a(String paramString, Map<String, String> paramMap, a parama, int paramInt)
  {
    String str1 = paramString + "?";
    Iterator localIterator = paramMap.keySet().iterator();
    String str4;
    for (String str2 = str1; ; str2 = str2 + str4 + "&")
    {
      if (!localIterator.hasNext())
      {
        String str5 = str2.substring(0, -1 + str2.length());
        h.a("url---->" + str5);
        return a(str5, parama, true, paramInt);
      }
      String str3 = (String)localIterator.next();
      j.a("get params:", "key= " + str3 + " and value= " + (String)paramMap.get(str3));
      str4 = str3 + "=" + (String)paramMap.get(str3);
    }
  }

  public void a(Context paramContext)
  {
    this.e = w.a(paramContext);
  }

  public void a(String paramString1, String paramString2, a parama, int paramInt)
  {
    b(paramString1, paramString2, parama, paramInt);
    h.a("url------->" + paramString1);
    h.a("para------->" + paramString2);
  }

  public com.android.volley.q b()
  {
    return this.e;
  }

  public static abstract interface a
  {
    public abstract void onError(String paramString1, String paramString2, int paramInt);

    public abstract void onRequest();

    public abstract void onSuccess(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.http.n
 * JD-Core Version:    0.6.0
 */