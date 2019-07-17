package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.a.a.c.c;
import com.xiaomi.push.service.w;

public class h
{
  private static h a;
  private Context b;
  private a c;

  private h(Context paramContext)
  {
    this.b = paramContext;
    o();
  }

  public static h a(Context paramContext)
  {
    if (a == null)
      a = new h(paramContext);
    return a;
  }

  public static String a(Context paramContext, String paramString)
  {
    try
    {
      PackageInfo localPackageInfo2 = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
      localPackageInfo1 = localPackageInfo2;
      if (localPackageInfo1 != null)
        return localPackageInfo1.versionName;
    }
    catch (Exception localException)
    {
      while (true)
      {
        c.a(localException);
        PackageInfo localPackageInfo1 = null;
      }
    }
    return "1.0";
  }

  private void o()
  {
    this.c = new a(null);
    SharedPreferences localSharedPreferences = j();
    this.c.a = localSharedPreferences.getString("appId", null);
    this.c.b = localSharedPreferences.getString("appToken", null);
    this.c.c = localSharedPreferences.getString("regId", null);
    this.c.d = localSharedPreferences.getString("regSec", null);
    this.c.f = localSharedPreferences.getString("devId", null);
    if ((!TextUtils.isEmpty(this.c.f)) && (this.c.f.startsWith("a-")))
    {
      this.c.f = w.c(this.b);
      localSharedPreferences.edit().putString("devId", this.c.f).commit();
    }
    this.c.e = localSharedPreferences.getString("vName", null);
    this.c.h = localSharedPreferences.getBoolean("valid", true);
    this.c.i = localSharedPreferences.getBoolean("paused", false);
    this.c.j = localSharedPreferences.getInt("envType", 1);
    this.c.g = localSharedPreferences.getString("regResource", null);
  }

  public void a(int paramInt)
  {
    this.c.a(paramInt);
    j().edit().putInt("envType", paramInt).commit();
  }

  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = j().edit();
    localEditor.putString("vName", paramString);
    localEditor.commit();
    this.c.e = paramString;
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramString1, paramString2, paramString3);
  }

  public void a(boolean paramBoolean)
  {
    this.c.a(paramBoolean);
    j().edit().putBoolean("paused", paramBoolean).commit();
  }

  public boolean a()
  {
    return !TextUtils.equals(a(this.b, this.b.getPackageName()), this.c.e);
  }

  public boolean a(String paramString1, String paramString2)
  {
    return this.c.b(paramString1, paramString2);
  }

  public void b(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }

  public boolean b()
  {
    if (!this.c.a())
    {
      c.a("Don't send message before initialization succeeded!");
      return false;
    }
    return true;
  }

  public String c()
  {
    return this.c.a;
  }

  public String d()
  {
    return this.c.b;
  }

  public String e()
  {
    return this.c.c;
  }

  public String f()
  {
    return this.c.d;
  }

  public String g()
  {
    return this.c.g;
  }

  public void h()
  {
    this.c.b();
  }

  public boolean i()
  {
    return this.c.a();
  }

  public SharedPreferences j()
  {
    return this.b.getSharedPreferences("mipush", 0);
  }

  public void k()
  {
    this.c.c();
  }

  public boolean l()
  {
    return this.c.i;
  }

  public int m()
  {
    return this.c.j;
  }

  public boolean n()
  {
    return !this.c.h;
  }

  private class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h = true;
    public boolean i = false;
    public int j = 1;

    private a()
    {
    }

    private String d()
    {
      return h.a(h.a(h.this), h.a(h.this).getPackageName());
    }

    public void a(int paramInt)
    {
      this.j = paramInt;
    }

    public void a(String paramString1, String paramString2)
    {
      this.c = paramString1;
      this.d = paramString2;
      this.f = w.c(h.a(h.this));
      this.e = d();
      this.h = true;
      SharedPreferences.Editor localEditor = h.this.j().edit();
      localEditor.putString("regId", paramString1);
      localEditor.putString("regSec", paramString2);
      localEditor.putString("devId", this.f);
      localEditor.putString("vName", d());
      localEditor.putBoolean("valid", true);
      localEditor.commit();
    }

    public void a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.g = paramString3;
      SharedPreferences.Editor localEditor = h.this.j().edit();
      localEditor.putString("appId", this.a);
      localEditor.putString("appToken", paramString2);
      localEditor.putString("regResource", paramString3);
      localEditor.commit();
    }

    public void a(boolean paramBoolean)
    {
      this.i = paramBoolean;
    }

    public boolean a()
    {
      return b(this.a, this.b);
    }

    public void b()
    {
      h.this.j().edit().clear().commit();
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.f = null;
      this.e = null;
      this.h = false;
      this.i = false;
      this.j = 1;
    }

    public boolean b(String paramString1, String paramString2)
    {
      return (TextUtils.equals(this.a, paramString1)) && (TextUtils.equals(this.b, paramString2)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(this.d)) && (TextUtils.equals(this.f, w.c(h.a(h.this))));
    }

    public void c()
    {
      this.h = false;
      h.this.j().edit().putBoolean("valid", this.h).commit();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.h
 * JD-Core Version:    0.6.0
 */