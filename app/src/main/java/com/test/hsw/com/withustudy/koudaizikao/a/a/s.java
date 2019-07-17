package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class s extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("userid", paramArrayOfString[1]);
    localHashMap.put("pagenum", paramArrayOfString[2]);
    localHashMap.put("pagecount", paramArrayOfString[3]);
    a(localHashMap);
    n.a().a("http://bbs.kdzikao.com/pcApi/" + paramArrayOfString[0] + "/bbs.page", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.s
 * JD-Core Version:    0.6.0
 */