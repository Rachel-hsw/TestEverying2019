package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import java.util.HashMap;
import java.util.Map;

public class a extends com.withustudy.koudaizikao.a.a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("reply_id", paramArrayOfString[0]);
    localHashMap.put("reply_type", paramArrayOfString[1]);
    localHashMap.put("userid", paramArrayOfString[2]);
    localHashMap.put("content", paramArrayOfString[3]);
    if (!paramArrayOfString[4].equals(""))
      localHashMap.put("filenames", paramArrayOfString[4]);
    a(localHashMap);
    n.a().a("http://bbs.kdzikao.com/forumTopicReplyApi/add/bbs.page", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.a
 * JD-Core Version:    0.6.0
 */