package com.umeng.socialize.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.socialize.b.a.b.b;
import com.umeng.socialize.b.b.a;
import com.umeng.socialize.b.b.e;
import com.umeng.socialize.bean.ay;
import com.umeng.socialize.utils.m;
import java.util.Map;

public class b extends com.umeng.socialize.b.a.b
{
  private static final String f = "/bar/get/";
  private static final int j = 1;
  private int k = 0;

  public b(Context paramContext, ay paramay, int paramInt)
  {
    super(paramContext, "", c.class, paramay, 1, b.b.a);
    this.d = paramContext;
    this.e = paramay;
    this.k = paramInt;
    a.a(m.a(this.d));
  }

  protected String a()
  {
    return "/bar/get/" + m.a(this.d) + "/";
  }

  protected Map<String, Object> a(Map<String, Object> paramMap)
  {
    paramMap.put("dc", this.e.c);
    paramMap.put(e.E, Integer.valueOf(this.k));
    if (!TextUtils.isEmpty(this.e.b()))
      paramMap.put(e.G, this.e.b());
    if (!TextUtils.isEmpty(this.e.d))
      paramMap.put(e.F, this.e.d);
    return paramMap;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.b.b
 * JD-Core Version:    0.6.0
 */