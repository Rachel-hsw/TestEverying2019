package com.umeng.socialize.b;

import com.umeng.socialize.b.a.f;
import org.json.JSONObject;

public class x extends f
{
  public String a;
  public String b;

  public x(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public void a()
  {
    super.a();
    JSONObject localJSONObject = this.l;
    if (localJSONObject != null)
    {
      this.a = localJSONObject.optString("large_url");
      this.b = localJSONObject.optString("small_url");
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.x
 * JD-Core Version:    0.6.0
 */