package com.umeng.socialize.controller;

import com.umeng.socialize.bean.ay;
import com.umeng.socialize.bean.l;
import com.umeng.socialize.controller.a.x;
import java.util.Map;

public abstract class a
{
  public static UMSocialService a(String paramString)
  {
    return a(paramString, null);
  }

  @Deprecated
  public static UMSocialService a(String paramString, l paraml)
  {
    if (paraml == null)
      paraml = l.a;
    String str1 = paramString + paraml;
    if (x.g.containsKey(str1))
      return new x((ay)x.g.get(str1));
    String str2 = paramString + l.a;
    if ((paraml == l.b) && (x.g.containsKey(str2)));
    for (ay localay = ay.a((ay)x.g.get(str2), paraml); ; localay = new ay(paramString, paraml))
      return new x(localay);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.controller.a
 * JD-Core Version:    0.6.0
 */