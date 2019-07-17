package com.umeng.socialize.sso;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class u
  implements IUiListener
{
  u(l paraml, SocializeListeners.UMDataListener paramUMDataListener)
  {
  }

  public void onCancel()
  {
    this.a.a(40000, null);
  }

  public void onComplete(Object paramObject)
  {
    if (paramObject == null)
    {
      this.a.a(40002, null);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramObject.toString());
      HashMap localHashMap = new HashMap();
      localHashMap.put("screen_name", localJSONObject.optString("nickname"));
      localHashMap.put("gender", localJSONObject.optString("gender"));
      localHashMap.put("profile_image_url", localJSONObject.optString("figureurl_qq_2"));
      localHashMap.put("is_yellow_year_vip", localJSONObject.optString("is_yellow_year_vip"));
      localHashMap.put("yellow_vip_level", localJSONObject.optString("yellow_vip_level"));
      localHashMap.put("msg", localJSONObject.optString("msg"));
      localHashMap.put("city", localJSONObject.optString("city"));
      localHashMap.put("vip", localJSONObject.optString("vip"));
      localHashMap.put("level", localJSONObject.optString("level"));
      localHashMap.put("province", localJSONObject.optString("province"));
      localHashMap.put("is_yellow_vip", localJSONObject.optString("is_yellow_vip"));
      this.a.a(200, localHashMap);
      return;
    }
    catch (JSONException localJSONException)
    {
      this.a.a(40002, null);
    }
  }

  public void onError(UiError paramUiError)
  {
    this.a.a(40002, null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.sso.u
 * JD-Core Version:    0.6.0
 */