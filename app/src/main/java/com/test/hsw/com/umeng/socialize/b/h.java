package com.umeng.socialize.b;

import android.text.TextUtils;
import com.umeng.socialize.b.a.f;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends f
{
  public String a;
  public String b;

  public h(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  private void b()
  {
    if (this.l != null);
    try
    {
      JSONObject localJSONObject = this.l.getJSONObject("tencent");
      if (localJSONObject != null)
      {
        String str = localJSONObject.optString("user_id");
        if (!TextUtils.isEmpty(str))
          this.a = str;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private void c()
  {
    try
    {
      if (this.l != null)
      {
        JSONObject localJSONObject = this.l.getJSONObject("sina");
        if (localJSONObject != null)
        {
          String str = localJSONObject.optString("expires_in");
          if (!TextUtils.isEmpty(str))
            this.b = str;
        }
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a()
  {
    super.a();
    b();
    c();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.h
 * JD-Core Version:    0.6.0
 */