package com.withustudy.koudaizikao.a;

import android.content.Context;
import com.android.http.n.a;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.g.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class a
{
  protected static final String a = "http://m.kdzikao.com";
  protected static final String b = "http://pay.kdzikao.com/pay";
  protected static final String c = "http://course.kdzikao.com";
  protected static final String d = "http://bbs.kdzikao.com";
  public static final String e = "http://api.weibo.com/2/short_url/shorten.json";
  public static final String f = "http://share.kdzikao.com";
  public static final String g = "http://share.kdzikao.com/app/share.page";
  public static final String h = "http://share.kdzikao.com/news/share.page?article_id=";
  public static final String i = "http://share.kdzikao.com/bbs/share.page?topic_id=";
  public static final String j = "http://share.kdzikao.com/ChapterAnswer/share.page";
  public static final String k = "http://share.kdzikao.com/IntelliAnswer/share.page";
  public static final String l = "http://share.kdzikao.com/Simulationtest/share.page";
  public static final String m = "http://share.kdzikao.com/RankingList/share.page";
  public static final String n = "http://share.kdzikao.com/SimulationList/share.page";
  public static final String o = "http://share.kdzikao.com/brush/share.page";
  public static final String p = "http://share.kdzikao.com/course/share.page?course_id=";
  protected List<String> q;

  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.q = new ArrayList();
    this.q.add(f.a(paramContext).p());
    if (n.b(paramContext) == 1)
      this.q.add("WIFI");
    while (true)
    {
      this.q.add(n.a());
      this.q.add(n.d(paramContext));
      return;
      if (n.b(paramContext) == 2)
      {
        this.q.add("WAP");
        continue;
      }
      if (n.b(paramContext) == 3)
      {
        this.q.add("NET");
        continue;
      }
      this.q.add("");
    }
  }

  protected void a(Map<String, String> paramMap)
  {
    paramMap.put("versionName", (String)this.q.get(0));
    if (!((String)this.q.get(1)).equals(""))
      paramMap.put("net", (String)this.q.get(1));
    paramMap.put("clientType", (String)this.q.get(2));
    paramMap.put("imei", (String)this.q.get(3));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a
 * JD-Core Version:    0.6.0
 */