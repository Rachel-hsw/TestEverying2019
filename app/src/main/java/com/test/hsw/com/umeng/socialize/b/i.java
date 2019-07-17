package com.umeng.socialize.b;

import android.content.Context;
import com.umeng.socialize.b.a.b;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.common.r;
import com.umeng.socialize.utils.m;
import java.util.Map;

public class i extends b
{
  private static final String f = "/user/profile/get/";
  private static final int j = 3;

  public i(Context paramContext, ay paramay)
  {
    super(paramContext, "", j.class, paramay, 3, b.b.a);
    this.d = paramContext;
  }

  protected String a()
  {
    return "/user/profile/get/" + m.a(this.d) + "/" + r.g + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    return paramMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.i
 * JD-Core Version:    0.6.0
 */