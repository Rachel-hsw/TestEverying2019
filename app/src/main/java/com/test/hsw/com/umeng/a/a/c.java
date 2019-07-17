package com.umeng.a.a;

import c.a.bu;
import c.a.cb;
import java.util.Locale;
import org.json.JSONObject;

public class c extends cb
{
  public JSONObject a = null;
  boolean b = false;
  int c = -1;
  int d = -1;
  private final String e = "config_update";
  private final String f = "report_policy";
  private final String g = "online_params";
  private final String h = "report_interval";

  public c(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (paramJSONObject == null)
      return;
    a(paramJSONObject);
    a();
  }

  private void a()
  {
    if ((this.c < 0) || (this.c > 6))
      this.c = 1;
  }

  private void a(JSONObject paramJSONObject)
  {
    while (true)
    {
      try
      {
        if (!paramJSONObject.has("config_update"))
          break;
        if (paramJSONObject.getString("config_update").toLowerCase(Locale.US).equals("no"))
          return;
        if (paramJSONObject.has("report_policy"))
        {
          this.c = paramJSONObject.getInt("report_policy");
          this.d = (1000 * paramJSONObject.optInt("report_interval"));
          this.a = paramJSONObject.optJSONObject("online_params");
          this.b = true;
          return;
        }
      }
      catch (Exception localException)
      {
        bu.e("MobclickAgent", "fail to parce online config response", localException);
        return;
      }
      bu.e("MobclickAgent", " online config fetch no report policy");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.a.c
 * JD-Core Version:    0.6.0
 */