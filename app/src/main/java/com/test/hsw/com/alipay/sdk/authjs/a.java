package com.alipay.sdk.authjs;

import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static final String a = "CallInfo";
  public static final String b = "call";
  public static final String c = "callback";
  public static final String d = "bundleName";
  public static final String e = "clientId";
  public static final String f = "param";
  public static final String g = "func";
  public static final String h = "msgType";
  public String i;
  public String j;
  public String k;
  public String l;
  public JSONObject m;
  private boolean n = false;

  public a(String paramString)
  {
    this.l = paramString;
  }

  private static String a(a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default:
      return "none";
    case 1:
      return "function not found";
    case 2:
      return "invalid parameter";
    case 3:
    }
    return "runtime error";
  }

  private void a(String paramString)
  {
    this.i = paramString;
  }

  private void a(JSONObject paramJSONObject)
  {
    this.m = paramJSONObject;
  }

  private void a(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  private boolean a()
  {
    return this.n;
  }

  private String b()
  {
    return this.i;
  }

  private void b(String paramString)
  {
    this.j = paramString;
  }

  private String c()
  {
    return this.j;
  }

  private void c(String paramString)
  {
    this.k = paramString;
  }

  private String d()
  {
    return this.k;
  }

  private void d(String paramString)
  {
    this.l = paramString;
  }

  private String e()
  {
    return this.l;
  }

  private JSONObject f()
  {
    return this.m;
  }

  private String g()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("clientId", this.i);
    localJSONObject.put("func", this.k);
    localJSONObject.put("param", this.m);
    localJSONObject.put("msgType", this.l);
    return localJSONObject.toString();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      f = arrayOfa;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.authjs.a
 * JD-Core Version:    0.6.0
 */