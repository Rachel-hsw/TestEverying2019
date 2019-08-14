package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class aq extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("uId", paramArrayOfString[0]);
    localHashMap.put("subjectId", paramArrayOfString[1]);
    localHashMap.put("timeSapm", paramArrayOfString[2]);
    a(localHashMap);
    n.a().a("http://m.kdzikao.com/exercise/brush_rank", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.aq
 * JD-Core Version:    0.6.0
 */