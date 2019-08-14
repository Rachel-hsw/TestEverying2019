package com.umeng.socialize.b;

import android.content.Context;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ar;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.utils.m;
import java.util.Map;

public class y extends b
{
  private static final String f = "/share/userinfo/";
  private static final int j = 12;
  private ar k;

  public y(Context paramContext, ay paramay, ar paramar)
  {
    super(paramContext, "", z.class, paramay, 12, b.b.a);
    this.d = paramContext;
    this.k = paramar;
  }

  protected String a()
  {
    return "/share/userinfo/" + m.a(this.d) + "/" + this.k.b + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    paramMap.put("sns", this.k.a.toString());
    return paramMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.y
 * JD-Core Version:    0.6.0
 */