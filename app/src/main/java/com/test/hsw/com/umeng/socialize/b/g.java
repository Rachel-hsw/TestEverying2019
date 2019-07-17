package com.umeng.socialize.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.bf;
import com.umeng.socialize.utils.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends b
{
  private static final String f = "/share/token/";
  private static final int j = 21;
  private bf k;

  public g(Context paramContext, ay paramay, bf parambf)
  {
    super(paramContext, "", h.class, paramay, 21, b.b.b);
    this.k = parambf;
  }

  protected String a()
  {
    return "/share/token/" + m.a(this.d) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("usid", this.k.b);
      localJSONObject1.put("to", this.k.a);
      localJSONObject1.put("access_token", this.k.b());
      localJSONObject1.put("expires_in", this.k.f());
      if (!TextUtils.isEmpty(this.k.c()))
        localJSONObject1.put("openid", this.k.c());
      String str1 = this.k.d();
      if (!TextUtils.isEmpty(str1))
        localJSONObject1.put("app_id", str1);
      String str2 = this.k.e();
      if (!TextUtils.isEmpty(str2))
        localJSONObject1.put("app_id", str2);
      String str3 = this.k.g();
      if (!TextUtils.isEmpty(str3))
        localJSONObject1.put("refresh_token", str3);
      String str4 = this.k.h();
      if (!TextUtils.isEmpty(str4))
        localJSONObject1.put("scope", str4);
      JSONObject localJSONObject2 = a(localJSONObject1, paramMap);
      return a(a, localJSONObject2.toString());
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.g
 * JD-Core Version:    0.6.0
 */