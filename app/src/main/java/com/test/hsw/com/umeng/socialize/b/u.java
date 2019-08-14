package com.umeng.socialize.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.utils.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class u extends b
{
  private static final String f = "/share/keysecret/";
  private static final int j = 25;

  public u(Context paramContext, ay paramay)
  {
    super(paramContext, "", v.class, paramay, 25, b.b.b);
    this.d = paramContext;
  }

  protected String a()
  {
    return "/share/keysecret/" + m.a(this.d) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject1 = new JSONObject();
    String str1 = this.e.c("wx_appid");
    String str2 = this.e.c("wx_secret");
    String str3 = this.e.c("qzone_id");
    String str4 = this.e.c("qzone_secret");
    try
    {
      if (!TextUtils.isEmpty(str1))
      {
        localJSONObject1.put("wxsession_key", str1);
        localJSONObject1.put("wxsession_secret", str2);
      }
      if (!TextUtils.isEmpty(str3))
      {
        paramMap.put("qzone_key", str3);
        paramMap.put("qzone_secret", str4);
      }
      String str5 = m.a(this.d);
      localJSONObject1.put("ak", str5);
      localJSONObject1.put("umeng_secret", m.e(str5));
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
 * Qualified Name:     com.umeng.socialize.b.u
 * JD-Core Version:    0.6.0
 */