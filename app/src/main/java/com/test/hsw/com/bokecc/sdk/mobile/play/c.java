package com.bokecc.sdk.mobile.play;

import org.json.JSONException;
import org.json.JSONObject;

class c
{
  private String a;
  private int b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private int h;

  public c()
  {
  }

  c(JSONObject paramJSONObject)
    throws JSONException
  {
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("response");
    this.a = localJSONObject1.getString("UPID");
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("video");
    this.b = localJSONObject2.getInt("status");
    this.c = localJSONObject2.getString("statusinfo");
    this.d = localJSONObject2.getString("title");
    this.e = localJSONObject2.getString("shareurl");
    this.f = localJSONObject2.getInt("defaultquality");
  }

  public String a()
  {
    return this.c;
  }

  public void a(int paramInt)
  {
    this.f = paramInt;
  }

  public String b()
  {
    return this.d;
  }

  public void b(int paramInt)
  {
    this.g = paramInt;
  }

  public int c()
  {
    return this.f;
  }

  public void c(int paramInt)
  {
    this.h = paramInt;
  }

  public int d()
  {
    return this.g;
  }

  public boolean e()
  {
    return this.b == 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.play.c
 * JD-Core Version:    0.6.0
 */