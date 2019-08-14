package com.umeng.socialize.b;

import com.umeng.socialize.b.a.f;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class e extends f
{
  public Map<String, Object> a;

  public e(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public void a()
  {
    super.a();
    JSONObject localJSONObject = this.l;
    if (localJSONObject != null)
    {
      this.a = new HashMap();
      Iterator localIterator = localJSONObject.keys();
      Boolean.valueOf(false);
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Boolean localBoolean = Boolean.valueOf(localJSONObject.optBoolean(str, false));
        this.a.put(str, localBoolean);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.e
 * JD-Core Version:    0.6.0
 */