package com.withustudy.koudaizikao.a.b;

import com.android.http.n;
import com.android.http.n.a;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;

public class y extends b
{
  public void a(n.a parama, Object paramObject, int paramInt)
  {
    n.a().a("http://m.kdzikao.com/news/post_comment_news", c.a().toJson(paramObject), parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.b.y
 * JD-Core Version:    0.6.0
 */