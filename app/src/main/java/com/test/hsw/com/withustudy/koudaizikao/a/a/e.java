package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class e extends a
{
  public static String r = "NEWS";
  public static String s = "EXERCISE";
  public static String t = "ARTICLE";

  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("uId", paramArrayOfString[0]);
    localHashMap.put("subjectId", paramArrayOfString[1]);
    localHashMap.put("favoritesType", paramArrayOfString[2]);
    a(localHashMap);
    n.a().a("http://m.kdzikao.com/exercise/favorites", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.e
 * JD-Core Version:    0.6.0
 */