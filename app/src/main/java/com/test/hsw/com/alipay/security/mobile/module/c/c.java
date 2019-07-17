package com.alipay.security.mobile.module.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return paramContext.getSharedPreferences(paramString1, 0).getString(paramString2, paramString3);
  }

  public static void a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(paramString, 0).edit();
    if (localEditor != null)
    {
      localEditor.clear();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.putString(str, (String)paramMap.get(str));
      }
      localEditor.commit();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.c.c
 * JD-Core Version:    0.6.0
 */