package com.bokecc.sdk.mobile.play;

import java.util.Collections;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class d
{
  private String a;
  private TreeMap<Integer, String> b;

  public d()
  {
  }

  public d(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.getString("desp");
    TreeMap localTreeMap = new TreeMap(Collections.reverseOrder());
    JSONArray localJSONArray = paramJSONObject.getJSONArray("copies");
    for (int i = 0; i < localJSONArray.length(); i++)
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      localTreeMap.put(Integer.valueOf(localJSONObject.getInt("priority")), localJSONObject.getString("playurl"));
    }
    this.b = localTreeMap;
  }

  public String a()
  {
    return this.a;
  }

  public TreeMap<Integer, String> b()
  {
    return this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.play.d
 * JD-Core Version:    0.6.0
 */