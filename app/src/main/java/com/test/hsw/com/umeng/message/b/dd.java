package com.umeng.message.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.b.a.a;
import com.umeng.b.a.b;
import com.umeng.message.PushAgent;
import org.json.JSONObject;

public class dd
{
  public static final String A = "Android";
  public static final String B = "Android";
  private static final String C = dd.class.getName();
  private final String D = "appkey";
  private final String E = "channel";
  private final String F = "device_id";
  private final String G = "idmd5";
  private final String H = "mc";
  private final String I = "req_time";
  private final String J = "device_model";
  private final String K = "os";
  private final String L = "os_version";
  private final String M = "resolution";
  private final String N = "cpu";
  private final String O = "gpu_vender";
  private final String P = "gpu_renderer";
  private final String Q = "app_version";
  private final String R = "version_code";
  private final String S = "package_name";
  private final String T = "sdk_type";
  private final String U = "sdk_version";
  private final String V = "timezone";
  private final String W = "country";
  private final String X = "language";
  private final String Y = "access";
  private final String Z = "access_subtype";
  public String a;
  private final String aa = "carrier";
  private final String ab = "wrapper_type";
  private final String ac = "wrapper_version";
  public String b;
  public String c;
  public String d;
  public String e;
  public long f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public int s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;

  public dd()
  {
  }

  public dd(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  private void d(JSONObject paramJSONObject)
    throws Exception
  {
    this.a = paramJSONObject.getString("appkey");
    this.c = paramJSONObject.getString("device_id");
    this.d = paramJSONObject.getString("idmd5");
    if (paramJSONObject.has("mc"))
      this.e = paramJSONObject.getString("mc");
    if (paramJSONObject.has("channel"))
      this.b = paramJSONObject.getString("channel");
    if (paramJSONObject.has("req_time"))
      this.f = paramJSONObject.getLong("req_time");
  }

  private void e(JSONObject paramJSONObject)
    throws Exception
  {
    String str1;
    String str2;
    label37: String str3;
    label59: String str4;
    label82: String str5;
    if (paramJSONObject.has("device_model"))
    {
      str1 = paramJSONObject.getString("device_model");
      this.g = str1;
      if (!paramJSONObject.has("os"))
        break label170;
      str2 = paramJSONObject.getString("os");
      this.h = str2;
      if (!paramJSONObject.has("os_version"))
        break label175;
      str3 = paramJSONObject.getString("os_version");
      this.i = str3;
      if (!paramJSONObject.has("resolution"))
        break label181;
      str4 = paramJSONObject.getString("resolution");
      this.j = str4;
      if (!paramJSONObject.has("cpu"))
        break label187;
      str5 = paramJSONObject.getString("cpu");
      label105: this.k = str5;
      if (!paramJSONObject.has("gpu_vender"))
        break label193;
    }
    label170: label175: label181: label187: label193: for (String str6 = paramJSONObject.getString("gpu_vender"); ; str6 = null)
    {
      this.l = str6;
      boolean bool = paramJSONObject.has("gpu_renderer");
      String str7 = null;
      if (bool)
        str7 = paramJSONObject.getString("gpu_renderer");
      this.m = str7;
      return;
      str1 = null;
      break;
      str2 = null;
      break label37;
      str3 = null;
      break label59;
      str4 = null;
      break label82;
      str5 = null;
      break label105;
    }
  }

  private void f(JSONObject paramJSONObject)
    throws Exception
  {
    String str1;
    if (paramJSONObject.has("app_version"))
    {
      str1 = paramJSONObject.getString("app_version");
      this.n = str1;
      if (!paramJSONObject.has("version_code"))
        break label78;
    }
    label78: for (String str2 = paramJSONObject.getString("version_code"); ; str2 = null)
    {
      this.o = str2;
      boolean bool = paramJSONObject.has("package_name");
      String str3 = null;
      if (bool)
        str3 = paramJSONObject.getString("package_name");
      this.p = str3;
      return;
      str1 = null;
      break;
    }
  }

  private void g(JSONObject paramJSONObject)
    throws Exception
  {
    this.q = paramJSONObject.getString("sdk_type");
    this.r = paramJSONObject.getString("sdk_version");
  }

  private void h(JSONObject paramJSONObject)
    throws Exception
  {
    int i1;
    if (paramJSONObject.has("timezone"))
    {
      i1 = paramJSONObject.getInt("timezone");
      this.s = i1;
      if (!paramJSONObject.has("country"))
        break label79;
    }
    label79: for (String str1 = paramJSONObject.getString("country"); ; str1 = null)
    {
      this.t = str1;
      boolean bool = paramJSONObject.has("language");
      String str2 = null;
      if (bool)
        str2 = paramJSONObject.getString("language");
      this.u = str2;
      return;
      i1 = 8;
      break;
    }
  }

  private void i(JSONObject paramJSONObject)
    throws Exception
  {
    String str1;
    if (paramJSONObject.has("access"))
    {
      str1 = paramJSONObject.getString("access");
      this.v = str1;
      if (!paramJSONObject.has("access_subtype"))
        break label78;
    }
    label78: for (String str2 = paramJSONObject.getString("access_subtype"); ; str2 = null)
    {
      this.w = str2;
      boolean bool = paramJSONObject.has("carrier");
      String str3 = null;
      if (bool)
        str3 = paramJSONObject.getString("carrier");
      this.x = str3;
      return;
      str1 = null;
      break;
    }
  }

  private void j(JSONObject paramJSONObject)
    throws Exception
  {
    if (paramJSONObject.has("wrapper_type"));
    for (String str1 = paramJSONObject.getString("wrapper_type"); ; str1 = null)
    {
      this.y = str1;
      boolean bool = paramJSONObject.has("wrapper_version");
      String str2 = null;
      if (bool)
        str2 = paramJSONObject.getString("wrapper_version");
      this.z = str2;
      return;
    }
  }

  private void k(JSONObject paramJSONObject)
    throws Exception
  {
    paramJSONObject.put("appkey", this.a);
    String[] arrayOfString2;
    if ((this.a != null) && (24 == this.a.length()))
    {
      arrayOfString2 = new String[3];
      arrayOfString2[0] = this.c;
      arrayOfString2[1] = "utf-8";
      arrayOfString2[2] = this.a.substring(0, 16);
    }
    String[] arrayOfString1;
    for (this.c = dg.a(arrayOfString2); ; this.c = dg.a(arrayOfString1))
    {
      paramJSONObject.put("device_id", this.c);
      paramJSONObject.put("idmd5", this.d);
      if (this.b != null)
        paramJSONObject.put("channel", this.b);
      if (this.e != null)
        paramJSONObject.put("mc", this.e);
      if (this.f > 0L)
        paramJSONObject.put("req_time", this.f);
      return;
      arrayOfString1 = new String[2];
      arrayOfString1[0] = this.c;
      arrayOfString1[1] = "utf-8";
    }
  }

  private void l(JSONObject paramJSONObject)
    throws Exception
  {
    paramJSONObject.put("appkey", this.a);
    if (this.b != null)
      paramJSONObject.put("channel", this.b);
  }

  private void m(JSONObject paramJSONObject)
    throws Exception
  {
    if (this.g != null)
      paramJSONObject.put("device_model", this.g);
    if (this.h != null)
      paramJSONObject.put("os", this.h);
    if (this.i != null)
      paramJSONObject.put("os_version", this.i);
    if (this.j != null)
      paramJSONObject.put("resolution", this.j);
    if (this.k != null)
      paramJSONObject.put("cpu", this.k);
    if (this.l != null)
      paramJSONObject.put("gpu_vender", this.l);
    if (this.m != null)
      paramJSONObject.put("gpu_vender", this.m);
  }

  private void n(JSONObject paramJSONObject)
    throws Exception
  {
    if (this.g != null)
      paramJSONObject.put("device_model", this.g);
    if (this.h != null)
      paramJSONObject.put("os", this.h);
    if (this.i != null)
      paramJSONObject.put("os_version", this.i);
  }

  private void o(JSONObject paramJSONObject)
    throws Exception
  {
    if (this.n != null)
      paramJSONObject.put("app_version", this.n);
    if (this.o != null)
      paramJSONObject.put("version_code", this.o);
    if (this.p != null)
      paramJSONObject.put("package_name", this.p);
  }

  private void p(JSONObject paramJSONObject)
    throws Exception
  {
    if (this.n != null)
      paramJSONObject.put("app_version", this.n);
    if (this.o != null)
      paramJSONObject.put("version_code", this.o);
  }

  private void q(JSONObject paramJSONObject)
    throws Exception
  {
    paramJSONObject.put("sdk_type", this.q);
    paramJSONObject.put("sdk_version", this.r);
  }

  private void r(JSONObject paramJSONObject)
    throws Exception
  {
    paramJSONObject.put("timezone", this.s);
    if (this.t != null)
      paramJSONObject.put("country", this.t);
    if (this.u != null)
      paramJSONObject.put("language", this.u);
  }

  private void s(JSONObject paramJSONObject)
    throws Exception
  {
    if (this.v != null)
      paramJSONObject.put("access", this.v);
    if (this.w != null)
      paramJSONObject.put("access_subtype", this.w);
    if (this.x != null)
      paramJSONObject.put("carrier", this.x);
  }

  private void t(JSONObject paramJSONObject)
    throws Exception
  {
    if (this.y != null)
      paramJSONObject.put("wrapper_type", this.y);
    if (this.z != null)
      paramJSONObject.put("wrapper_version", this.z);
  }

  public void a(Context paramContext)
  {
    this.g = Build.MODEL;
    this.h = "Android";
    this.i = Build.VERSION.RELEASE;
    this.j = b.t(paramContext);
    this.k = b.a();
  }

  public void a(Context paramContext, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length == 2))
    {
      this.a = paramArrayOfString[0];
      this.b = paramArrayOfString[1];
    }
    if (this.a == null)
      this.a = PushAgent.getInstance(paramContext).getMessageAppkey();
    if (this.b == null)
      this.b = PushAgent.getInstance(paramContext).getMessageChannel();
    this.c = b.g(paramContext);
    this.d = b.i(paramContext);
    this.e = b.s(paramContext);
  }

  public void a(JSONObject paramJSONObject)
    throws Exception
  {
    if (paramJSONObject == null)
      return;
    d(paramJSONObject);
    e(paramJSONObject);
    f(paramJSONObject);
    g(paramJSONObject);
    h(paramJSONObject);
    i(paramJSONObject);
    j(paramJSONObject);
  }

  public boolean a()
  {
    if (this.a == null)
    {
      a.b(C, "missing appkey ");
      return false;
    }
    if ((this.c == null) || (this.d == null))
    {
      a.b(C, "missing device id");
      return false;
    }
    return true;
  }

  public void b(Context paramContext)
  {
    this.n = b.e(paramContext);
    this.o = b.d(paramContext);
    this.p = b.w(paramContext);
  }

  public void b(Context paramContext, String[] paramArrayOfString)
  {
    a(paramContext, paramArrayOfString);
    a(paramContext);
    b(paramContext);
    c(paramContext);
    d(paramContext);
    e(paramContext);
  }

  public void b(JSONObject paramJSONObject)
    throws Exception
  {
    k(paramJSONObject);
    m(paramJSONObject);
    o(paramJSONObject);
    q(paramJSONObject);
    r(paramJSONObject);
    s(paramJSONObject);
    t(paramJSONObject);
  }

  public boolean b()
  {
    return (this.a != null) && (this.c != null);
  }

  public void c(Context paramContext)
  {
    this.q = "Android";
    this.r = "2.6.0";
  }

  public void c(Context paramContext, String[] paramArrayOfString)
  {
    a(paramContext, paramArrayOfString);
    a(paramContext);
    b(paramContext);
    c(paramContext);
    e(paramContext);
  }

  public void c(JSONObject paramJSONObject)
    throws Exception
  {
    l(paramJSONObject);
    n(paramJSONObject);
    p(paramJSONObject);
    q(paramJSONObject);
    s(paramJSONObject);
  }

  public void d(Context paramContext)
  {
    this.s = b.p(paramContext);
    String[] arrayOfString = b.q(paramContext);
    this.t = arrayOfString[0];
    this.u = arrayOfString[1];
  }

  public void e(Context paramContext)
  {
    String[] arrayOfString = b.l(paramContext);
    this.v = arrayOfString[0];
    this.w = arrayOfString[1];
    this.x = b.u(paramContext);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.dd
 * JD-Core Version:    0.6.0
 */