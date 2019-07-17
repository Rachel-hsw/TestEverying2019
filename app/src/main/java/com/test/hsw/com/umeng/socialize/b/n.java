package com.umeng.socialize.b;

import android.content.Context;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.utils.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class n extends b
{
  private static final String f = "/share/follow/";
  private static final int j = 18;
  private ar k;
  private String[] l;

  public n(Context paramContext, ay paramay, ar paramar, String[] paramArrayOfString)
  {
    super(paramContext, "", o.class, paramay, 18, b.b.b);
    this.d = paramContext;
    this.k = paramar;
    this.l = paramArrayOfString;
  }

  protected String a()
  {
    return "/share/follow/" + m.a(this.d) + "/" + this.k.b + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.l != null)
      for (String str : this.l)
        localStringBuilder.append(str + ",");
    if (localStringBuilder.length() > 0)
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("to", this.k.a.toString());
      localJSONObject1.put("fusid", localStringBuilder.toString());
      JSONObject localJSONObject2 = a(localJSONObject1, paramMap);
      return a(a, localJSONObject2.toString());
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.n
 * JD-Core Version:    0.6.0
 */