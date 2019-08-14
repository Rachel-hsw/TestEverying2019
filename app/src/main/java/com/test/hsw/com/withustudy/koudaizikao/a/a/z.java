package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class z extends a
{
  private final String r = "get_live_list";
  private final String s = "get_record_list";

  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramArrayOfString[0]);
    localHashMap.put("course_id", paramArrayOfString[1]);
    a(localHashMap);
    if (paramArrayOfString[2].equals("0"))
    {
      n.a().a("http://course.kdzikao.com/course/get_live_list", localHashMap, parama, paramInt);
      return;
    }
    n.a().a("http://course.kdzikao.com/course/get_record_list", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.z
 * JD-Core Version:    0.6.0
 */