package com.umeng.message.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static final String a = "custom";
  public static final String b = "notification";
  public static final String c = "autoupdate";
  public static final String d = "go_activity";
  public static final String e = "go_app";
  public static final String f = "go_url";
  public static final String g = "go_custom";
  public int A;
  public Map<String, String> B;
  public String C;
  public long D;
  public boolean E;
  private JSONObject F;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public boolean p;
  public boolean q;
  public boolean r;
  public boolean s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;

  public a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.F = paramJSONObject;
    this.h = paramJSONObject.getString("msg_id");
    this.k = paramJSONObject.getString("display_type");
    this.l = paramJSONObject.optString("alias");
    this.D = paramJSONObject.optLong("random_min");
    JSONObject localJSONObject1 = paramJSONObject.getJSONObject("body");
    this.m = localJSONObject1.optString("ticker");
    this.n = localJSONObject1.optString("title");
    this.o = localJSONObject1.optString("text");
    this.p = localJSONObject1.optBoolean("play_vibrate", true);
    this.q = localJSONObject1.optBoolean("play_lights", true);
    this.r = localJSONObject1.optBoolean("play_sound", true);
    this.s = localJSONObject1.optBoolean("screen_on", false);
    this.v = localJSONObject1.optString("url");
    this.x = localJSONObject1.optString("img");
    this.w = localJSONObject1.optString("sound");
    this.y = localJSONObject1.optString("icon");
    this.t = localJSONObject1.optString("after_open");
    this.C = localJSONObject1.optString("largeIcon");
    this.z = localJSONObject1.optString("activity");
    this.u = localJSONObject1.optString("custom");
    this.A = localJSONObject1.optInt("builder_id", 0);
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("extra");
    Iterator localIterator;
    if ((localJSONObject2 != null) && (localJSONObject2.keys() != null))
    {
      this.B = new HashMap();
      localIterator = localJSONObject2.keys();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str = (String)localIterator.next();
      this.B.put(str, localJSONObject2.getString(str));
    }
  }

  public JSONObject a()
  {
    return this.F;
  }

  public boolean b()
  {
    return (c()) || (d());
  }

  public boolean c()
  {
    return !TextUtils.isEmpty(this.x);
  }

  public boolean d()
  {
    return (!TextUtils.isEmpty(this.w)) && ((this.w.startsWith("http://")) || (this.w.startsWith("https://")));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.a.a
 * JD-Core Version:    0.6.0
 */