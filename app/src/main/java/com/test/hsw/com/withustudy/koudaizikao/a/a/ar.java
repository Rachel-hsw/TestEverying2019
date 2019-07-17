package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class ar extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    if (!paramArrayOfString[0].equals(""))
      localHashMap.put("uid", paramArrayOfString[0]);
    localHashMap.put("newsType", paramArrayOfString[1]);
    localHashMap.put("articleId", paramArrayOfString[2]);
    a(localHashMap);
    n.a().a("http://m.kdzikao.com/news/disposal_favorite_news", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.ar
 * JD-Core Version:    0.6.0
 */