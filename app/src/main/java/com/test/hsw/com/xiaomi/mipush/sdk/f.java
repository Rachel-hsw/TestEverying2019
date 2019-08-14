package com.xiaomi.mipush.sdk;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class f
  implements PushMessageHandler.a
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static final long e = 1L;
  private static final String f = "messageId";
  private static final String g = "messageType";
  private static final String h = "content";
  private static final String i = "alias";
  private static final String j = "topic";
  private static final String k = "user_account";
  private static final String l = "passThrough";
  private static final String m = "notifyType";
  private static final String n = "notifyId";
  private static final String o = "isNotified";
  private static final String p = "description";
  private static final String q = "title";
  private static final String r = "category";
  private static final String s = "extra";
  private int A;
  private int B;
  private boolean C;
  private String D;
  private String E;
  private String F;
  private boolean G = false;
  private HashMap<String, String> H = new HashMap();
  private String t;
  private int u;
  private String v;
  private String w;
  private String x;
  private String y;
  private int z;

  public static f a(Bundle paramBundle)
  {
    f localf = new f();
    localf.t = paramBundle.getString("messageId");
    localf.u = paramBundle.getInt("messageType");
    localf.z = paramBundle.getInt("passThrough");
    localf.w = paramBundle.getString("alias");
    localf.y = paramBundle.getString("user_account");
    localf.x = paramBundle.getString("topic");
    localf.v = paramBundle.getString("content");
    localf.D = paramBundle.getString("description");
    localf.E = paramBundle.getString("title");
    localf.C = paramBundle.getBoolean("isNotified");
    localf.B = paramBundle.getInt("notifyId");
    localf.A = paramBundle.getInt("notifyType");
    localf.F = paramBundle.getString("category");
    localf.H = ((HashMap)paramBundle.getSerializable("extra"));
    return localf;
  }

  public String a()
  {
    return this.t;
  }

  public void a(int paramInt)
  {
    this.u = paramInt;
  }

  public void a(String paramString)
  {
    this.t = paramString;
  }

  public void a(Map<String, String> paramMap)
  {
    this.H.clear();
    if (paramMap != null)
      this.H.putAll(paramMap);
  }

  public void a(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }

  public void b(int paramInt)
  {
    this.A = paramInt;
  }

  public void b(String paramString)
  {
    this.v = paramString;
  }

  public void b(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }

  public boolean b()
  {
    return this.G;
  }

  public int c()
  {
    return this.u;
  }

  public void c(int paramInt)
  {
    this.B = paramInt;
  }

  public void c(String paramString)
  {
    this.w = paramString;
  }

  public String d()
  {
    return this.v;
  }

  public void d(int paramInt)
  {
    this.z = paramInt;
  }

  public void d(String paramString)
  {
    this.y = paramString;
  }

  public String e()
  {
    return this.w;
  }

  public void e(String paramString)
  {
    this.x = paramString;
  }

  public String f()
  {
    return this.y;
  }

  public void f(String paramString)
  {
    this.D = paramString;
  }

  public String g()
  {
    return this.x;
  }

  public void g(String paramString)
  {
    this.E = paramString;
  }

  public int h()
  {
    return this.A;
  }

  public void h(String paramString)
  {
    this.F = paramString;
  }

  public int i()
  {
    return this.B;
  }

  public boolean j()
  {
    return this.C;
  }

  public String k()
  {
    return this.D;
  }

  public String l()
  {
    return this.E;
  }

  public String m()
  {
    return this.F;
  }

  public int n()
  {
    return this.z;
  }

  public Map<String, String> o()
  {
    return this.H;
  }

  public Bundle p()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("messageId", this.t);
    localBundle.putInt("passThrough", this.z);
    localBundle.putInt("messageType", this.u);
    if (!TextUtils.isEmpty(this.w))
      localBundle.putString("alias", this.w);
    if (!TextUtils.isEmpty(this.y))
      localBundle.putString("user_account", this.y);
    if (!TextUtils.isEmpty(this.x))
      localBundle.putString("topic", this.x);
    localBundle.putString("content", this.v);
    if (!TextUtils.isEmpty(this.D))
      localBundle.putString("description", this.D);
    if (!TextUtils.isEmpty(this.E))
      localBundle.putString("title", this.E);
    localBundle.putBoolean("isNotified", this.C);
    localBundle.putInt("notifyId", this.B);
    localBundle.putInt("notifyType", this.A);
    if (!TextUtils.isEmpty(this.F))
      localBundle.putString("category", this.F);
    if (this.H != null)
      localBundle.putSerializable("extra", this.H);
    return localBundle;
  }

  public String toString()
  {
    return "messageId={" + this.t + "},passThrough={" + this.z + "},alias={" + this.w + "},topic={" + this.x + "},userAccount={" + this.y + "},content={" + this.v + "},description={" + this.D + "},title={" + this.E + "},isNotified={" + this.C + "},notifyId={" + this.B + "},notifyType={" + this.A + "}, category={" + this.F + "}, extra={" + this.H + "}";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.f
 * JD-Core Version:    0.6.0
 */