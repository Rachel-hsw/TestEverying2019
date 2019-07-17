package com.umeng.socialize.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.b.b.e;
import com.umeng.socialize.b.b.g.a;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.a;
import com.umeng.socialize.media.BaseMediaObject;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.utils.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class w extends b
{
  private static final String f = "/api/upload_pic/";
  private static final int j = 23;
  private Context k;
  private String l;
  private UMediaObject m;

  public w(Context paramContext, ay paramay, UMediaObject paramUMediaObject, String paramString)
  {
    super(paramContext, "", x.class, paramay, 23, b.b.b);
    this.k = paramContext;
    this.l = paramString;
    this.m = paramUMediaObject;
  }

  private void b(UMediaObject paramUMediaObject, Map<String, Object> paramMap)
  {
    try
    {
      if ((paramUMediaObject instanceof BaseMediaObject))
      {
        BaseMediaObject localBaseMediaObject = (BaseMediaObject)paramUMediaObject;
        String str1 = localBaseMediaObject.c();
        String str2 = localBaseMediaObject.d();
        if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put(e.A, str1);
          localJSONObject.put(e.B, str2);
          paramMap.put("ext", localJSONObject);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      i.b(a, "can`t add qzone title & thumb.", localException);
    }
  }

  protected String a()
  {
    return "/api/upload_pic/" + m.a(this.k) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Map localMap;
    try
    {
      localJSONObject1.put("usid", this.l);
      JSONObject localJSONObject2 = a(localJSONObject1, paramMap);
      localMap = a(a, localJSONObject2.toString());
      if (this.m != null)
      {
        if (this.m.b())
          a(this.m, localMap);
      }
      else
        return localMap;
    }
    catch (JSONException localJSONException)
    {
      do
        while (true)
          localJSONException.printStackTrace();
      while (!(this.m instanceof UMImage));
      b(this.m, localMap);
    }
    return localMap;
  }

  public Map<String, g.a> c()
  {
    if ((this.m == null) || (this.m.b()))
      return super.c();
    Map localMap = super.c();
    if ((this.m instanceof UMImage))
    {
      byte[] arrayOfByte = a(((UMImage)this.m).k());
      String str1 = a.a(arrayOfByte);
      if (TextUtils.isEmpty(str1))
        str1 = "png";
      String str2 = System.currentTimeMillis() + "";
      g.a locala = new g.a(str2 + "." + str1, arrayOfByte);
      localMap.put(e.v, locala);
    }
    return localMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.w
 * JD-Core Version:    0.6.0
 */