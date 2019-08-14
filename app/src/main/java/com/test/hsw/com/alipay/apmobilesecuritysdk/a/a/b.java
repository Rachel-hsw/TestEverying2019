package com.alipay.apmobilesecuritysdk.a.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, (String)localJSONObject.get(str));
      }
    }
    catch (JSONException localJSONException)
    {
      return null;
    }
    return localHashMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.a.a.b
 * JD-Core Version:    0.6.0
 */