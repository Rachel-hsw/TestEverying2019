package com.umeng.socialize.b;

import com.umeng.socialize.b.a.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class o extends f
{
  public Map<String, Integer> a;

  public o(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public void a()
  {
    super.a();
    this.a = new HashMap();
    Iterator localIterator = this.l.keys();
    String str;
    if (localIterator.hasNext())
      str = (String)localIterator.next();
    while (true)
    {
      try
      {
        JSONObject localJSONObject = this.l.getJSONObject(str);
        if (localJSONObject == null)
          break label92;
        i = localJSONObject.optInt("st", -102);
        this.a.put(str, Integer.valueOf(i));
      }
      catch (JSONException localJSONException)
      {
      }
      break;
      return;
      label92: int i = -102;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.o
 * JD-Core Version:    0.6.0
 */