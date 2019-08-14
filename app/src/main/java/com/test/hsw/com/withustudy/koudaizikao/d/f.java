package com.withustudy.koudaizikao.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.withustudy.koudaizikao.g.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class f
{
  private static final String A = "is_first";
  private static final String B = "TEST";
  private static final String C = "ScoMount";
  private static final String D = "myTest";
  private static final String E = "SplashPageUrl";
  public static final String a = "koudai";
  private static f b;
  private static final String d = "uId";
  private static final String e = "phone";
  private static final String f = "password";
  private static final String g = "version_code";
  private static final String h = "version_name";
  private static final String i = "pro_id";
  private static final String j = "pro_name";
  private static final String k = "major_id";
  private static final String l = "major_name";
  private static final String m = "longitude";
  private static final String n = "latitude";
  private static final String o = "city_name";
  private static final String p = "update_subject";
  private static final String q = "avatar";
  private static final String r = "nick_name";
  private static final String s = "HEIGHT";
  private static final String t = "WIDTH";
  private static final String u = "DENSITY";
  private static final String v = "THIRD_ID";
  private static final String w = "THIRD_TYPE";
  private static final String x = "BRUSH_SUBJECT_INDEX";
  private static final String y = "BRUSH_SUBJECT_ID";
  private static final String z = "is_first_open_excercise";
  private Context c;

  private f(Context paramContext)
  {
    this.c = paramContext;
  }

  public static f a(Context paramContext)
  {
    if (b == null)
      monitorenter;
    try
    {
      if (b == null)
        b = new f(paramContext);
      return b;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public String A()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("THIRD_ID", "");
  }

  public String B()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("THIRD_TYPE", "");
  }

  public void C()
  {
    d("");
    i("");
    j("");
    m("");
    n("");
    o("");
    p("");
    q("");
    r("");
    s("");
    t("");
    a(0.0F);
  }

  public float a()
  {
    return this.c.getSharedPreferences("koudai", 0).getFloat("ScoMount", 0.0F);
  }

  public void a(float paramFloat)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putFloat("ScoMount", paramFloat).commit();
  }

  public void a(int paramInt)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putInt("BRUSH_SUBJECT_INDEX", paramInt).commit();
  }

  public void a(int paramInt, HashMap<Integer, String> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    String str2;
    for (Object localObject = ""; ; localObject = str2)
    {
      Integer localInteger;
      String str1;
      do
      {
        if (!localIterator.hasNext())
        {
          if (!((String)localObject).equals(""))
            this.c.getSharedPreferences("koudai", 0).edit().putString(paramInt, (String)localObject).commit();
          return;
        }
        localInteger = (Integer)localIterator.next();
        str1 = (String)paramHashMap.get(localInteger);
      }
      while ((str1 == null) || (str1.equals("")));
      str2 = localInteger + "$$" + str1 + "%%";
      h.a("缓存模拟考答案=" + str2);
    }
  }

  public void a(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("SplashPageUrl", paramString).commit();
  }

  public void a(boolean paramBoolean)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putBoolean("myTest", paramBoolean).commit();
  }

  public void b(float paramFloat)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putFloat("DENSITY", paramFloat).commit();
  }

  public void b(int paramInt)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putInt("HEIGHT", paramInt).commit();
  }

  public void b(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("TEST", paramString).commit();
  }

  public void b(boolean paramBoolean)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putBoolean("is_first", paramBoolean).commit();
  }

  public boolean b()
  {
    return this.c.getSharedPreferences("koudai", 0).getBoolean("myTest", false);
  }

  public String c()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("SplashPageUrl", "");
  }

  public void c(int paramInt)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putInt("WIDTH", paramInt).commit();
  }

  public void c(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("BRUSH_SUBJECT_ID", paramString).commit();
  }

  public void c(boolean paramBoolean)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putBoolean("is_first_open_excercise", paramBoolean).commit();
  }

  public String d()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("TEST", "");
  }

  public void d(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("uId", paramString).commit();
  }

  public void d(boolean paramBoolean)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putBoolean("update_subject", paramBoolean).commit();
  }

  public void e(String paramString)
  {
    this.c.getSharedPreferences("logTest", 0).edit().putString("uId", paramString).commit();
  }

  public boolean e()
  {
    return this.c.getSharedPreferences("koudai", 0).getBoolean("is_first", true);
  }

  public void f(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("longitude", paramString).commit();
  }

  public boolean f()
  {
    return this.c.getSharedPreferences("koudai", 0).getBoolean("is_first_open_excercise", true);
  }

  public int g()
  {
    return this.c.getSharedPreferences("koudai", 0).getInt("BRUSH_SUBJECT_INDEX", 0);
  }

  public void g(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("city_name", paramString).commit();
  }

  public String h()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("BRUSH_SUBJECT_ID", "");
  }

  public void h(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("latitude", paramString).commit();
  }

  public String i()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("uId", "");
  }

  public void i(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("phone", paramString).commit();
  }

  public String j()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("longitude", "");
  }

  public void j(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("password", paramString).commit();
  }

  public String k()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("city_name", "");
  }

  public void k(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("version_code", paramString).commit();
  }

  public String l()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("latitude", "");
  }

  public void l(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("version_name", paramString).commit();
  }

  public String m()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("phone", "");
  }

  public void m(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("pro_id", paramString).commit();
  }

  public String n()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("password", "");
  }

  public void n(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("pro_name", paramString).commit();
  }

  public String o()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("version_code", "");
  }

  public void o(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("major_id", paramString).commit();
  }

  public String p()
  {
    try
    {
      String str = this.c.getSharedPreferences("koudai", 0).getString("version_name", "");
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public void p(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("major_name", paramString).commit();
  }

  public String q()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("pro_id", "");
  }

  public void q(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("avatar", paramString).commit();
  }

  public String r()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("pro_name", "");
  }

  public void r(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("nick_name", paramString).commit();
  }

  public String s()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("major_id", "");
  }

  public void s(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("THIRD_ID", paramString).commit();
  }

  public String t()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("major_name", "");
  }

  public void t(String paramString)
  {
    this.c.getSharedPreferences("koudai", 0).edit().putString("THIRD_TYPE", paramString).commit();
  }

  public String u()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("avatar", "");
  }

  public String v()
  {
    return this.c.getSharedPreferences("koudai", 0).getString("nick_name", "");
  }

  public boolean w()
  {
    return this.c.getSharedPreferences("koudai", 0).getBoolean("update_subject", false);
  }

  public int x()
  {
    return this.c.getSharedPreferences("koudai", 0).getInt("HEIGHT", 0);
  }

  public int y()
  {
    return this.c.getSharedPreferences("koudai", 0).getInt("WIDTH", 0);
  }

  public float z()
  {
    return this.c.getSharedPreferences("koudai", 0).getFloat("DENSITY", 0.0F);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.d.f
 * JD-Core Version:    0.6.0
 */