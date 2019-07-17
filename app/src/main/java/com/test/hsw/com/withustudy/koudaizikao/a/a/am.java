package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class am extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userid", paramArrayOfString[0]);
    if (!paramArrayOfString[1].equals(""))
      localHashMap.put("title", paramArrayOfString[1]);
    localHashMap.put("content", paramArrayOfString[2]);
    localHashMap.put("forum_id", paramArrayOfString[3]);
    if (!paramArrayOfString[4].equals(""))
      localHashMap.put("filenames", paramArrayOfString[4]);
    localHashMap.put("originate", "1");
    a(localHashMap);
    n.a().a("http://bbs.kdzikao.com/forumTopicApi/add/bbs.page", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.am
 * JD-Core Version:    0.6.0
 */