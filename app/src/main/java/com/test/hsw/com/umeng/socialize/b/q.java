package com.umeng.socialize.b;

import com.umeng.socialize.b.a.f;
import com.umeng.socialize.bean.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class q extends f
{
  public Map<p, Integer> a;
  public String b;
  public p c;

  public q(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }

  public void a()
  {
    super.a();
    this.a = new HashMap();
    p[] arrayOfp = p.d();
    int i;
    int j;
    if (arrayOfp != null)
    {
      i = arrayOfp.length;
      j = 0;
    }
    while (true)
    {
      p localp;
      String str;
      if (j < i)
      {
        localp = arrayOfp[j];
        str = localp.toString();
        if (!this.l.has(str));
      }
      try
      {
        localJSONObject1 = this.l.getJSONObject(str);
        localJSONObject2 = localJSONObject1.getJSONObject("data");
        if (localJSONObject2 != null)
        {
          boolean bool = localJSONObject2.has("send_result");
          if (!bool);
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          JSONObject localJSONObject1;
          JSONObject localJSONObject2;
          JSONObject localJSONObject4 = localJSONObject2.getJSONObject("send_result");
          localJSONObject3 = localJSONObject4;
          if (localJSONObject3 != null)
          {
            this.b = localJSONObject3.optString("id", "");
            this.c = localp;
          }
          int k = localJSONObject1.optInt("st");
          this.a.put(localp, Integer.valueOf(k));
          while (true)
          {
            j++;
            break;
            return;
            localJSONException = localJSONException;
          }
        }
        catch (Exception localException)
        {
          while (true)
            JSONObject localJSONObject3 = null;
        }
      }
    }
  }

  public String toString()
  {
    return "ShareMultiResponse [mInfoMap=" + this.a + ", mWeiboId=" + this.b + ", mMsg=" + this.m + ", mStCode=" + this.n + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.q
 * JD-Core Version:    0.6.0
 */