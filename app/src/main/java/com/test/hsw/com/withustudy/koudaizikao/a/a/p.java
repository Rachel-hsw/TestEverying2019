package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class p extends a
{
  private final String r = "get_all_course";
  private final String s = "get_my_course";

  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("uid", paramArrayOfString[3]);
    localHashMap.put("major_id", paramArrayOfString[0]);
    localHashMap.put("page_no", paramArrayOfString[1]);
    localHashMap.put("page_size", paramArrayOfString[2]);
    a(localHashMap);
    if (paramArrayOfString[4].equals("0"))
    {
      n.a().a("http://course.kdzikao.com/course/get_all_course", localHashMap, parama, paramInt);
      return;
    }
    n.a().a("http://course.kdzikao.com/course/get_my_course", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.p
 * JD-Core Version:    0.6.0
 */