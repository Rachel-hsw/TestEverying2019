package com.umeng.socialize.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.b.a.f;
import com.umeng.socialize.b.b.e;
import com.umeng.socialize.b.b.g.a;
import com.umeng.socialize.bean.UMLocation;
import com.umeng.socialize.bean.UMShareMsg;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.a;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.m;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class r extends b
{
  private static final String f = "/share/add/";
  private static final int j = 9;
  private String k;
  private String l;
  private UMShareMsg m;

  public r(Context paramContext, ay paramay, String paramString1, String paramString2, UMShareMsg paramUMShareMsg)
  {
    super(paramContext, "", f.class, paramay, 9, b.b.b);
    this.d = paramContext;
    this.e = paramay;
    this.k = paramString1;
    this.l = paramString2;
    this.m = paramUMShareMsg;
  }

  protected String a()
  {
    return "/share/add/" + m.a(this.d) + "/" + this.e.a + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("to", this.k);
      if (!TextUtils.isEmpty(this.m.a))
        localJSONObject1.put(e.s, this.m.a);
      localJSONObject1.put("usid", this.l);
      localJSONObject1.put("ak", m.a(this.d));
      if (!TextUtils.isEmpty(this.m.d))
        localJSONObject1.put("wid", this.m.d);
      if (this.m.b != null)
        localJSONObject1.put(e.t, this.m.b.toString());
      JSONObject localJSONObject2 = a(localJSONObject1, paramMap);
      Map localMap = a(a, localJSONObject2.toString());
      if ((this.m.a() != null) && (this.m.a().b()))
        a(this.m.a(), localMap);
      return localMap;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  public Map<String, g.a> c()
  {
    if ((this.m == null) || (this.m.a() == null) || (this.m.a().b()))
      return super.c();
    Map localMap = super.c();
    if ((this.m.a() instanceof UMImage))
    {
      byte[] arrayOfByte = a(((UMImage)this.m.a()).k());
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
 * Qualified Name:     com.umeng.socialize.b.r
 * JD-Core Version:    0.6.0
 */