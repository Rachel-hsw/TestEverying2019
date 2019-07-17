package com.umeng.socialize.common;

import android.content.Context;
import com.umeng.socialize.bean.aw;
import com.umeng.socialize.bean.ax;
import com.umeng.socialize.utils.j;
import com.umeng.socialize.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class p
{
  public static final String A = "line";
  public static final String B = "flickr";
  public static final String C = "tumblr";
  public static final String D = "kakao";
  public static final String a = "sina";
  public static final String b = "tencent";
  public static final String c = "renren";
  public static final String d = "douban";
  public static final String e = "qzone";
  public static final String f = "qq";
  public static final String g = "weixin";
  public static final String h = "weixin_circle";
  public static final String i = "sms";
  public static final String j = "email";
  public static final String k = "facebook";
  public static final String l = "google+";
  public static final String m = "twitter";
  public static final String n = "generic";
  public static final String o = "yixin";
  public static final String p = "yixin_circle";
  public static final String q = "laiwang";
  public static final String r = "laiwang_dynamic";
  public static final String s = "instagram";
  public static final String t = "pinterest";
  public static final String u = "evernote";
  public static final String v = "pocket";
  public static final String w = "linkedin";
  public static final String x = "foursquare";
  public static final String y = "ynote";
  public static final String z = "whatsapp";

  public static String a(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    switch (q.a[paramp.ordinal()])
    {
    default:
      return "";
    case 1:
      return paramContext.getString(b.a(paramContext, b.a.e, "umeng_socialize_text_tencent_key"));
    case 2:
      return paramContext.getString(b.a(paramContext, b.a.e, "umeng_socialize_text_sina_key"));
    case 3:
      return paramContext.getString(b.a(paramContext, b.a.e, "umeng_socialize_text_renren_key"));
    case 4:
      return paramContext.getString(b.a(paramContext, b.a.e, "umeng_socialize_text_douban_key"));
    case 5:
      return paramContext.getString(b.a(paramContext, b.a.e, "umeng_socialize_text_qq_zone_key"));
    case 6:
    }
    return "facebook";
  }

  public static String a(com.umeng.socialize.bean.p paramp)
  {
    switch (q.a[paramp.ordinal()])
    {
    default:
      return null;
    case 2:
      return "sina";
    case 1:
      return "tencent";
    case 3:
      return "renren";
    case 4:
      return "douban";
    case 5:
      return "qzone";
    case 7:
      return "qq";
    case 6:
      return "facebook";
    case 8:
      return "weixin";
    case 9:
      return "weixin_circle";
    case 10:
      return "pocket";
    case 11:
      return "linkedin";
    case 12:
    }
    return "foursquare";
  }

  public static List<aw> a(Context paramContext, ax paramax)
  {
    ArrayList localArrayList = new ArrayList();
    com.umeng.socialize.bean.p localp1 = j.b(paramContext);
    Iterator localIterator = paramax.l().iterator();
    int i1 = 0;
    while (true)
    {
      com.umeng.socialize.bean.p localp2;
      aw localaw;
      if (localIterator.hasNext())
      {
        localp2 = (com.umeng.socialize.bean.p)localIterator.next();
        localaw = (aw)paramax.c().get(localp2.toString());
        localaw.c = b(paramContext, localp2);
        localaw.d = c(paramContext, localp2);
        localaw.b = a(paramContext, localp2);
      }
      try
      {
        if (k.a(paramContext, localp2))
        {
          localaw.e = true;
          localaw.g = k.e(paramContext, localp2);
        }
        if ((localp1 != null) && (localp1 == localp2))
          localaw.f = true;
        label143: int i2 = i1 + 1;
        localaw.i = i1;
        localArrayList.add(localaw);
        i1 = i2;
        continue;
        return localArrayList;
      }
      catch (Exception localException)
      {
        break label143;
      }
    }
  }

  private static int b(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    switch (q.a[paramp.ordinal()])
    {
    default:
      return -1;
    case 1:
      return b.a(paramContext, b.a.c, "umeng_socialize_tx_on");
    case 2:
      return b.a(paramContext, b.a.c, "umeng_socialize_sina_on");
    case 3:
      return b.a(paramContext, b.a.c, "umeng_socialize_renren_on");
    case 4:
      return b.a(paramContext, b.a.c, "umeng_socialize_douban_on");
    case 5:
    }
    return b.a(paramContext, b.a.c, "umeng_socialize_qzone_on");
  }

  private static int c(Context paramContext, com.umeng.socialize.bean.p paramp)
  {
    switch (q.a[paramp.ordinal()])
    {
    default:
      return -1;
    case 1:
      return b.a(paramContext, b.a.c, "umeng_socialize_tx_off");
    case 2:
      return b.a(paramContext, b.a.c, "umeng_socialize_sina_off");
    case 3:
      return b.a(paramContext, b.a.c, "umeng_socialize_renren_off");
    case 4:
      return b.a(paramContext, b.a.c, "umeng_socialize_douban_off");
    case 5:
    }
    return b.a(paramContext, b.a.c, "umeng_socialize_qzone_off");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.common.p
 * JD-Core Version:    0.6.0
 */