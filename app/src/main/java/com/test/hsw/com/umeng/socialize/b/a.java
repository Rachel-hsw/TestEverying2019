package com.umeng.socialize.b;

import android.text.TextUtils;
import com.umeng.socialize.b.a.f;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.utils.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class a extends f
{
  public Map<String, Object> a;
  public Map<String, String> b;
  public Map<String, String> c;

  public a(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public void a()
  {
    JSONObject localJSONObject1 = this.l;
    this.a = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
    if (localJSONObject1 == null)
    {
      i.b(f.k, "data json is null....");
      return;
    }
    try
    {
      p[] arrayOfp = p.d();
      int i = arrayOfp.length;
      int j = 0;
      while (true)
        if (j < i)
        {
          p localp = arrayOfp[j];
          try
          {
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(localp.toString());
            if (localJSONObject2 != null)
            {
              String str1 = localJSONObject2.getString("key");
              this.a.put(localp.toString(), str1);
              this.b.put(localp.toString(), localJSONObject2.optString("secret"));
              String str2 = localJSONObject2.optString("id");
              if (!TextUtils.isEmpty(str2))
                this.c.put(str1, str2);
            }
            j++;
          }
          catch (Exception localException2)
          {
            while (true)
              i.b(k, "Parse json error[ " + localJSONObject1.toString() + " ]", localException2);
          }
        }
    }
    catch (Exception localException1)
    {
      i.b(k, "Parse json error[ " + localJSONObject1.toString() + " ]", localException1);
      return;
    }
    i.a(k, "platform key found: " + this.a.keySet().toString());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.a
 * JD-Core Version:    0.6.0
 */