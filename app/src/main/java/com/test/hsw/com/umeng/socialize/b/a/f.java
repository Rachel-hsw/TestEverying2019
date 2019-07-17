package com.umeng.socialize.b.a;

import android.text.TextUtils;
import com.umeng.socialize.b.b.h;
import com.umeng.socialize.utils.i;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends h
{
  protected static final String k = f.class.getName();
  protected JSONObject l = a(paramJSONObject);
  public String m;
  public int n = -103;

  public f(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    a();
  }

  private JSONObject a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      i.b(k, "failed requesting");
    String str;
    do
    {
      return null;
      try
      {
        this.n = paramJSONObject.optInt("st", 1998);
        if (this.n == 0)
        {
          i.b(k, "no status code in response.");
          return null;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i.b(k, "Data body can`t convert to json ");
        return null;
      }
      this.m = paramJSONObject.optString("msg", "");
      str = paramJSONObject.optString("data", null);
    }
    while (TextUtils.isEmpty(str));
    if (this.n != 200)
      a(str);
    JSONObject localJSONObject = new JSONObject(str);
    return localJSONObject;
  }

  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      Iterator localIterator = localJSONObject1.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str1);
        String str2 = localJSONObject2.getString("msg");
        if (!TextUtils.isEmpty(str2))
        {
          a(str1, str2);
          continue;
        }
        a(str1, localJSONObject2.getJSONObject("data").getString("platform_error"));
      }
    }
    catch (Exception localException)
    {
    }
  }

  private void a(String paramString1, String paramString2)
  {
    i.b(k, "error message -> " + paramString1 + " : " + paramString2);
  }

  public void a()
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.a.f
 * JD-Core Version:    0.6.0
 */