package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class q extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramArrayOfString[0]);
    a(localHashMap);
    n.a().a("http://m.kdzikao.com/news/get_favorites_news", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.q
 * JD-Core Version:    0.6.0
 */