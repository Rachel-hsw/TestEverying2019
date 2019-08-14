package com.withustudy.koudaizikao.a.b;

import com.android.http.n;
import com.android.http.n.a;
import com.google.gson.Gson;
import com.withustudy.koudaizikao.a.b;
import com.withustudy.koudaizikao.a.c;

public class p extends b
{
  public void a(n.a parama, Object paramObject, int paramInt)
  {
    n.a().a("http://m.kdzikao.com/exercise/get_exercise_more_comments", c.a().toJson(paramObject), parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.b.p
 * JD-Core Version:    0.6.0
 */