package com.umeng.socialize.bean;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.controller.a.x;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.SimpleShareContent;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.n;
import java.util.HashMap;
import java.util.Map;

public class ay
{
  public static String f = "";
  private static Map<p, String> u = new HashMap();
  public String a = "-1";
  public String b = "";
  public String c;
  public String d;
  public boolean e = false;
  public av g = null;
  private int h;
  private int i;
  private int j;
  private int k;
  private boolean l;
  private String m;
  private g n;
  private Map<p, UMediaObject> o = new HashMap();
  private String p;
  private ax q = null;
  private l r;
  private UMShareMsg s = null;
  private as t = as.b;
  private boolean v = false;
  private Bundle w = new Bundle();
  private String x = "";
  private String y = "";

  public ay(String paramString, l paraml)
  {
    this.c = paramString;
    this.r = paraml;
    x.g.put(paramString + paraml, this);
  }

  public static ay a(ay paramay, l paraml)
  {
    ay localay = new ay(paramay.c, paraml);
    localay.a = paramay.a;
    localay.b = paramay.b;
    localay.d = paramay.d;
    localay.h = paramay.h;
    localay.i = paramay.h;
    localay.j = paramay.j;
    localay.k = paramay.k;
    localay.l = paramay.l;
    localay.m = paramay.m;
    localay.n = paramay.n;
    localay.e = paramay.e;
    return localay;
  }

  public static String a(String paramString, l paraml)
  {
    return paramString + paraml.toString();
  }

  public static void a(p paramp, String paramString)
  {
    u.put(paramp, paramString);
  }

  public static String b(p paramp)
  {
    String str = (String)u.get(paramp);
    if (!TextUtils.isEmpty(str))
      return str;
    return (String)u.get(p.b);
  }

  private p v()
  {
    return ax.o();
  }

  public <T extends BaseMediaObject> T a(Class<T> paramClass)
  {
    p localp = v();
    UMediaObject localUMediaObject = (UMediaObject)this.o.get(localp);
    if ((localUMediaObject != null) && (paramClass != null) && (localUMediaObject.getClass().equals(paramClass)))
      return (BaseMediaObject)localUMediaObject;
    return null;
  }

  public UMediaObject a()
  {
    return a(v());
  }

  public UMediaObject a(p paramp)
  {
    UMediaObject localUMediaObject = (UMediaObject)this.o.get(paramp);
    if (localUMediaObject == null)
      localUMediaObject = (UMediaObject)this.o.get(p.b);
    return localUMediaObject;
  }

  public Map<String, Integer> a(Context paramContext)
  {
    try
    {
      Map localMap = n.b(paramContext);
      return localMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new HashMap();
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
  }

  public void a(Context paramContext, p paramp, int paramInt)
  {
    try
    {
      n.a(paramContext, paramp, paramInt);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      n.a(paramContext, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a(UMShareMsg paramUMShareMsg)
  {
    this.s = paramUMShareMsg;
  }

  public void a(as paramas)
  {
    this.t = paramas;
  }

  public void a(ax paramax)
  {
    this.q = paramax;
  }

  public void a(g paramg)
  {
    this.n = paramg;
  }

  public void a(UMediaObject paramUMediaObject)
  {
    p localp = p.b;
    if (paramUMediaObject != null)
      localp = paramUMediaObject.f();
    if (this.o.containsKey(localp))
      this.o.remove(localp);
    this.o.put(localp, paramUMediaObject);
  }

  public void a(String paramString)
  {
    this.m = paramString;
  }

  public void a(String paramString1, String paramString2)
  {
    this.w.putString(paramString1, paramString2);
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public String b()
  {
    return this.m;
  }

  public void b(int paramInt)
  {
    this.i = paramInt;
  }

  public void b(Context paramContext)
  {
    try
    {
      n.a(paramContext);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b(Context paramContext, p paramp, int paramInt)
  {
    try
    {
      n.b(paramContext, paramp, paramInt);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void b(String paramString)
  {
    this.p = paramString;
  }

  public void b(String paramString1, String paramString2)
  {
    this.x = paramString1;
    this.y = paramString2;
  }

  public void b(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }

  public String c(String paramString)
  {
    if (this.w.containsKey(paramString))
      return this.w.getString(paramString);
    return "";
  }

  public void c(int paramInt)
  {
    this.j = paramInt;
  }

  public boolean c()
  {
    return this.l;
  }

  public String d()
  {
    p localp = v();
    UMediaObject localUMediaObject = (UMediaObject)this.o.get(localp);
    if ((localUMediaObject instanceof SimpleShareContent))
    {
      String str = ((SimpleShareContent)localUMediaObject).k();
      if (!TextUtils.isEmpty(str))
        return str;
    }
    else
    {
      return this.p;
    }
    return "";
  }

  public void d(int paramInt)
  {
    this.k = paramInt;
  }

  public int e()
  {
    return this.h;
  }

  public int f()
  {
    return this.i;
  }

  public int g()
  {
    return this.j;
  }

  public int h()
  {
    return this.k;
  }

  public g i()
  {
    return this.n;
  }

  public as j()
  {
    return this.t;
  }

  public void k()
  {
    monitorenter;
    try
    {
      if (this.n == g.a)
        this.j = (-1 + this.j);
      for (this.n = g.b; ; this.n = g.a)
      {
        return;
        this.j = (1 + this.j);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void l()
  {
    monitorenter;
    try
    {
      this.k = (1 + this.k);
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

  public void m()
  {
    monitorenter;
    try
    {
      this.i = (1 + this.i);
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

  public ax n()
  {
    return this.q;
  }

  public l o()
  {
    return this.r;
  }

  public UMShareMsg p()
  {
    return this.s;
  }

  public Map<p, StringBuilder> q()
  {
    try
    {
      Map localMap = n.a();
      return localMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new HashMap();
  }

  public Map<String, Integer> r()
  {
    try
    {
      Map localMap = n.b();
      return localMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return new HashMap();
  }

  public boolean s()
  {
    return this.v;
  }

  public String t()
  {
    return this.y;
  }

  public String u()
  {
    return this.x;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.ay
 * JD-Core Version:    0.6.0
 */