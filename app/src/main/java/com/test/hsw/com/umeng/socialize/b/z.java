package com.umeng.socialize.b;

import com.umeng.socialize.b.a.f;
import com.umeng.socialize.utils.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class z extends f
{
  public Map<String, Object> a;

  public z(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public void a()
  {
    this.a = new HashMap();
    try
    {
      JSONObject localJSONObject = this.l;
      Iterator localIterator = localJSONObject.keys();
      if (localIterator != null)
        while (true)
        {
          boolean bool = localIterator.hasNext();
          if (!bool)
            break;
          try
          {
            String str = (String)localIterator.next();
            Object localObject = localJSONObject.get(str);
            this.a.put(str, localObject);
          }
          catch (JSONException localJSONException)
          {
            i.e("com.umeng.socialize", localJSONException.toString());
          }
        }
    }
    catch (Exception localException)
    {
      i.e("com.umeng.socialize", localException.toString());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.z
 * JD-Core Version:    0.6.0
 */