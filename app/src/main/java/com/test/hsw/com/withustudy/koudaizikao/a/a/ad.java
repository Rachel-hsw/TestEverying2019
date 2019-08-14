package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class ad extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("newsType", paramArrayOfString[0]);
    localHashMap.put("lastIndex", paramArrayOfString[1]);
    if (!paramArrayOfString[2].equals(""))
      localHashMap.put("provinceId", paramArrayOfString[2]);
    if (!paramArrayOfString[3].equals(""))
      localHashMap.put("majorId", paramArrayOfString[3]);
    if (!paramArrayOfString[4].equals(""))
      localHashMap.put("uid", paramArrayOfString[4]);
    a(localHashMap);
    n.a().a("http://m.kdzikao.com/news/get_basic_news", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.ad
 * JD-Core Version:    0.6.0
 */