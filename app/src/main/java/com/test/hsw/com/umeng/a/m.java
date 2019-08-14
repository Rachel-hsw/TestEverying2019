package com.umeng.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import c.a.bu;
import c.a.e;
import c.a.em;
import c.a.es;
import c.a.et;
import c.a.fa;
import c.a.fc;
import c.a.ff;
import c.a.h;
import com.umeng.a.a.b;
import java.util.HashMap;
import java.util.Map;

public class m
  implements fa
{
  private final b a = new b();
  private Context b = null;
  private l c;
  private es d = new es();
  private e e = new e();
  private ff f = new ff();
  private et g;
  private em h;
  private boolean i = false;

  m()
  {
    this.d.a(this);
  }

  private void f(Context paramContext)
  {
    if (!this.i)
    {
      this.b = paramContext.getApplicationContext();
      this.g = new et(this.b);
      this.h = em.a(this.b);
      this.i = true;
    }
  }

  private void g(Context paramContext)
  {
    this.f.c(paramContext);
    if (this.c != null)
      this.c.a();
  }

  private void h(Context paramContext)
  {
    this.f.d(paramContext);
    this.e.a(paramContext);
    if (this.c != null)
      this.c.b();
    this.h.b();
  }

  public ff a()
  {
    return this.f;
  }

  public void a(int paramInt)
  {
    a.c = paramInt;
  }

  void a(Context paramContext)
  {
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    this.a.a(paramContext);
    try
    {
      em.a(paramContext).a(this.a);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "unexpected null context in reportError");
      return;
    }
    try
    {
      if (!this.i)
        f(paramContext);
      this.h.a(new h(paramString).a(false));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      u.a(new p(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.g.a(paramString1, paramString2, paramLong, paramInt);
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  public void a(Context paramContext, String paramString, HashMap<String, Object> paramHashMap)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.g.a(paramString, paramHashMap);
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void a(Context paramContext, String paramString1, HashMap<String, Object> paramHashMap, String paramString2)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      u.a(new r(this, paramString1, paramHashMap, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void a(Context paramContext, String paramString, Map<String, Object> paramMap, long paramLong)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.g.a(paramString, paramMap, paramLong);
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void a(Context paramContext, Throwable paramThrowable)
  {
    if ((paramContext == null) || (paramThrowable == null))
      return;
    try
    {
      if (!this.i)
        f(paramContext);
      this.h.a(new h(paramThrowable).a(false));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void a(com.umeng.a.a.a parama)
  {
    this.a.a(parama);
  }

  public void a(l paraml)
  {
    this.c = paraml;
  }

  void a(String paramString)
  {
    if (!a.h);
    try
    {
      this.e.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void a(String paramString1, String paramString2)
  {
    a.a = paramString1;
    a.b = paramString2;
  }

  public void a(Throwable paramThrowable)
  {
    try
    {
      this.e.a();
      if (this.b != null)
      {
        if ((paramThrowable != null) && (this.h != null))
          this.h.b(new h(paramThrowable));
        h(this.b);
        fc.a(this.b).edit().commit();
      }
      u.a();
      return;
    }
    catch (Exception localException)
    {
      bu.a("MobclickAgent", "Exception in onAppCrash", localException);
    }
  }

  void b(Context paramContext)
  {
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    if (a.h)
      this.e.a(paramContext.getClass().getName());
    try
    {
      if (!this.i)
        f(paramContext);
      u.a(new n(this, paramContext));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "Exception occurred in Mobclick.onResume(). ", localException);
    }
  }

  void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      u.a(new q(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void b(String paramString)
  {
    if (!a.h);
    try
    {
      this.e.b(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  void c(Context paramContext)
  {
    if (paramContext == null)
    {
      bu.b("MobclickAgent", "unexpected null context in onPause");
      return;
    }
    if (a.h)
      this.e.b(paramContext.getClass().getName());
    try
    {
      if (!this.i)
        f(paramContext);
      u.a(new o(this, paramContext));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "Exception occurred in Mobclick.onRause(). ", localException);
    }
  }

  void c(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      u.a(new s(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void d(Context paramContext)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.h.a();
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "", localException);
    }
  }

  void e(Context paramContext)
  {
    try
    {
      this.e.a();
      h(paramContext);
      fc.a(paramContext).edit().commit();
      u.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.m
 * JD-Core Version:    0.6.0
 */