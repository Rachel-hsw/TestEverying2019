package com.umeng.socialize.b;

import com.umeng.socialize.b.a.f;
import com.umeng.socialize.utils.i;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends f
{
  public int a;
  public int b;
  public int c;
  public String d;
  public String e;
  public int f;
  public int g;
  public String h;
  public String i;
  public int j;

  public c(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public void a()
  {
    JSONObject localJSONObject = this.l;
    if (localJSONObject == null)
      i.b(f.k, "data json is null....");
    while (true)
    {
      return;
      try
      {
        if (localJSONObject.has("cm"))
          this.b = localJSONObject.getInt("cm");
        if (localJSONObject.has("ek"))
          this.e = localJSONObject.getString("ek");
        if (localJSONObject.has("ft"))
          this.f = localJSONObject.getInt("ft");
        if (localJSONObject.has("fr"))
          this.g = localJSONObject.optInt("fr", 0);
        if (localJSONObject.has("lk"))
          this.c = localJSONObject.getInt("lk");
        if (localJSONObject.has("pv"))
          this.a = localJSONObject.getInt("pv");
        if (localJSONObject.has("sid"))
          this.d = localJSONObject.getString("sid");
        if (localJSONObject.has("uid"))
          this.h = localJSONObject.getString("uid");
        if (!localJSONObject.has("sn"))
          continue;
        this.j = localJSONObject.getInt("sn");
        return;
      }
      catch (JSONException localJSONException)
      {
        i.b(k, "Parse json error[ " + localJSONObject.toString() + " ]", localJSONException);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.c
 * JD-Core Version:    0.6.0
 */