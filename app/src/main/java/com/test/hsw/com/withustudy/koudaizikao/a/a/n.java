package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class n extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userid", paramArrayOfString[0]);
    localHashMap.put("pagenum", paramArrayOfString[1]);
    localHashMap.put("pagecount", paramArrayOfString[2]);
    a(localHashMap);
    com.android.http.n.a().a("http://bbs.kdzikao.com/myTopicApi/list/bbs.page", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.n
 * JD-Core Version:    0.6.0
 */