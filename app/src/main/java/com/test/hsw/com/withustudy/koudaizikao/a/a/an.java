package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class an extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramArrayOfString[0]);
    localHashMap.put("course_id", paramArrayOfString[1]);
    localHashMap.put("video_id", paramArrayOfString[2]);
    localHashMap.put("watch_progress", paramArrayOfString[3]);
    a(localHashMap);
    n.a().a("http://course.kdzikao.com/course/push_watch_progress", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.an
 * JD-Core Version:    0.6.0
 */