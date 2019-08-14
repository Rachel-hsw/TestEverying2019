package com.umeng.socialize.b;

import android.content.Context;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.p;
import java.util.Map;

public class l extends b
{
  private static final String f = "/share/friends/";
  private static final int j = 14;
  private String k;
  private p l;

  public l(Context paramContext, ay paramay, p paramp, String paramString)
  {
    super(paramContext, "", m.class, paramay, 14, b.b.a);
    this.d = paramContext;
    this.e = paramay;
    this.k = paramString;
    this.l = paramp;
  }

  protected String a()
  {
    return "/share/friends/" + com.umeng.socialize.utils.m.a(this.d) + "/" + this.k + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    paramMap.put("to", this.l.toString());
    return paramMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.l
 * JD-Core Version:    0.6.0
 */