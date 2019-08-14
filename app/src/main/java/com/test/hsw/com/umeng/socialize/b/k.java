package com.umeng.socialize.b;

import android.content.Context;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.b.a.f;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.common.r;
import com.umeng.socialize.utils.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class k extends b
{
  private static final String f = "/share/auth_delete/";
  private static final int j = 15;
  private p k;

  public k(Context paramContext, ay paramay, p paramp)
  {
    super(paramContext, "", f.class, paramay, 15, b.b.b);
    this.d = paramContext;
    this.k = paramp;
  }

  protected String a()
  {
    return "/share/auth_delete/" + m.a(this.d) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("uid", r.g);
      localJSONObject1.put("via", this.k.toString());
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
 * Qualified Name:     com.umeng.socialize.b.k
 * JD-Core Version:    0.6.0
 */