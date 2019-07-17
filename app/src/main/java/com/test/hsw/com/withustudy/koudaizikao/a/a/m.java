package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class m extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    if (!paramArrayOfString[0].equals(""))
      localHashMap.put("uid", paramArrayOfString[0]);
    if (!paramArrayOfString[1].equals(""))
      localHashMap.put("major_id", paramArrayOfString[1]);
    if (!paramArrayOfString[2].equals(""))
      localHashMap.put("page_no", paramArrayOfString[2]);
    if (!paramArrayOfString[3].equals(""))
      localHashMap.put("page_size", paramArrayOfString[3]);
    a(localHashMap);
    n.a().a("http://course.kdzikao.com/course/get_chuanjiang_course", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.m
 * JD-Core Version:    0.6.0
 */