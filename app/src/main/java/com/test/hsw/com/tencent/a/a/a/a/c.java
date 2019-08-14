package com.tencent.a.a.a.a;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  String a = null;
  String b = null;
  String c = "0";
  long d = 0L;

  static c c(String paramString)
  {
    c localc = new c();
    if (h.d(paramString));
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (!localJSONObject.isNull("ui"))
        localc.a = localJSONObject.getString("ui");
      if (!localJSONObject.isNull("mc"))
        localc.b = localJSONObject.getString("mc");
      if (!localJSONObject.isNull("mid"))
        localc.c = localJSONObject.getString("mid");
      if (!localJSONObject.isNull("ts"))
        localc.d = localJSONObject.getLong("ts");
      return localc;
    }
    catch (JSONException localJSONException)
    {
      Log.w("MID", localJSONException);
    }
    return localc;
  }

  private JSONObject d()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      h.a(localJSONObject, "ui", this.a);
      h.a(localJSONObject, "mc", this.b);
      h.a(localJSONObject, "mid", this.c);
      localJSONObject.put("ts", this.d);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.w("MID", localJSONException);
    }
    return localJSONObject;
  }

  public final String c()
  {
    return this.c;
  }

  public final String toString()
  {
    return d().toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a.a.c
 * JD-Core Version:    0.6.0
 */