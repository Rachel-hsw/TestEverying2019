package com.withustudy.koudaizikao.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.android.http.n;
import com.android.http.n.a;
import com.withustudy.koudaizikao.a.a;
import java.util.HashMap;
import java.util.Map;

public class ae extends a
{
  public void a(n.a parama, String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    super.a(parama, paramArrayOfString, paramInt, paramContext);
    HashMap localHashMap = new HashMap();
    localHashMap.put("clientId", paramArrayOfString[0]);
    if (!paramArrayOfString[1].equals(""))
      localHashMap.put("uid", paramArrayOfString[1]);
    a(localHashMap);
    localHashMap.put("mobile_mode", (Build.MODEL + ";" + Build.VERSION.SDK + ";" + Build.VERSION.RELEASE).replaceAll(" ", "_"));
    n.a().a("http://m.kdzikao.com/account/launch", localHashMap, parama, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.a.a.ae
 * JD-Core Version:    0.6.0
 */