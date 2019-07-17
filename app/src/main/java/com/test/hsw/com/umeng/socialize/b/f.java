package com.umeng.socialize.b;

import android.content.Context;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.utils.m;
import java.util.Map;

public class f extends b
{
  private static final String f = "/share/keysecret/";
  private static final int j = 20;

  public f(Context paramContext, ay paramay)
  {
    super(paramContext, "", a.class, paramay, 20, b.b.a);
    this.d = paramContext;
  }

  protected String a()
  {
    return "/share/keysecret/" + m.a(this.d) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    return paramMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.f
 * JD-Core Version:    0.6.0
 */