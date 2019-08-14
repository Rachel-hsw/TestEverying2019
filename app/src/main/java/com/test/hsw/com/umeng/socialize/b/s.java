package com.umeng.socialize.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.utils.m;
import com.umeng.socialize.utils.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class s extends b
{
  private static final String j = "/app/oper/";
  private static final String k = "StatisticsDataRequest";
  private Context f;

  public s(Context paramContext, ay paramay)
  {
    super(paramContext, "", t.class, paramay, 0, b.b.b);
    this.f = paramContext;
    this.e = paramay;
  }

  protected String a()
  {
    return "/app/oper/" + m.a(this.f) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    try
    {
      n.c(this.f);
      n.c(this.f);
      Map localMap1 = this.e.q();
      paramMap.remove("opid");
      localObject1 = new HashMap();
      Iterator localIterator1 = localMap1.keySet().iterator();
      while (true)
      {
        if (!localIterator1.hasNext())
          break label188;
        localp = (p)localIterator1.next();
        StringBuilder localStringBuilder = (StringBuilder)localMap1.get(localp);
        if (TextUtils.isEmpty(localStringBuilder))
          break label499;
        if (localp != p.b)
          break;
        m = 0;
        if (localStringBuilder.substring(-1 + localStringBuilder.length(), localStringBuilder.length()).equals("+"))
          localStringBuilder = localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        localObject2 = n.a(String.valueOf(m), localStringBuilder.toString(), (Map)localObject1);
        localObject1 = localObject2;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Object localObject1;
        p localp;
        localException.printStackTrace();
        continue;
        int m = n.a(localp);
        continue;
        label188: Map localMap2 = this.e.r();
        Iterator localIterator2 = localMap2.keySet().iterator();
        while (localIterator2.hasNext())
        {
          String str3 = (String)localIterator2.next();
          int i = ((Integer)localMap2.get(str3)).intValue();
          if (i <= 0)
            continue;
          ((Map)localObject1).put(str3, i + "");
        }
        Map localMap3 = this.e.a(this.f);
        if (localMap3.containsKey("shake"))
          ((Map)localObject1).put("shake", localMap3.get("shake"));
        JSONObject localJSONObject1 = new JSONObject();
        Iterator localIterator3 = ((Map)localObject1).keySet().iterator();
        while (localIterator3.hasNext())
        {
          String str2 = (String)localIterator3.next();
          try
          {
            localJSONObject1.put(str2, Integer.parseInt(((Map)localObject1).get(str2).toString()));
          }
          catch (JSONException localJSONException3)
          {
            localJSONException3.printStackTrace();
          }
        }
        String str1 = this.e.t();
        if (!TextUtils.isEmpty(str1));
        try
        {
          localJSONObject1.put(this.e.u(), str1);
          localJSONObject2 = new JSONObject();
        }
        catch (JSONException localJSONException2)
        {
          try
          {
            JSONObject localJSONObject2;
            localJSONObject2.put("param", localJSONObject1.toString());
            return a("StatisticsDataRequest", localJSONObject2.toString());
            localJSONException2 = localJSONException2;
            localJSONException2.printStackTrace();
          }
          catch (JSONException localJSONException1)
          {
            while (true)
              localJSONException1.printStackTrace();
          }
        }
        label499: Object localObject2 = localObject1;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.s
 * JD-Core Version:    0.6.0
 */