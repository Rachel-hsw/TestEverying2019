package com.ta.utdid2.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import com.ta.utdid2.b.a.b;
import com.ta.utdid2.b.a.g;
import com.ta.utdid2.b.a.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static final String a = c.class.getName();
  private static Map<String, String> b = new ConcurrentHashMap();
  private static Map<String, Long> c = new ConcurrentHashMap();

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    String str2;
    if (paramContext == null)
    {
      Log.e(a, "no context!");
      str2 = "";
    }
    String str1;
    do
    {
      return str2;
      str1 = a(paramString1, paramString2);
      str2 = (String)b.get(str1);
      if (!com.ta.utdid2.b.a.c.a)
        continue;
      Log.d(a, "cache AID:" + str2);
    }
    while (!h.a(str2));
    String str3 = paramContext.getSharedPreferences("UTCommon", 0).getString("EvQwnbilKezpOJey".concat(str1), "");
    b.put(str1, str3);
    return str3;
  }

  private static String a(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 8);
    for (String str = Base64.encodeToString(paramString1.concat(paramString2).getBytes(), 2); ; str = b.a(paramString1.concat(paramString2).getBytes(), 2))
    {
      if (com.ta.utdid2.b.a.c.a)
        Log.d(a, "encodedName:" + str);
      return str;
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (paramContext == null)
    {
      Log.e(a, "no context!");
      return;
    }
    String str = a(paramString1, paramString3);
    long l = System.currentTimeMillis();
    b.put(str, paramString2);
    c.put(str, Long.valueOf(l));
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("UTCommon", 0);
    if (Build.VERSION.SDK_INT >= 9)
    {
      g.a(localSharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(str), paramString2));
      g.a(localSharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(str), l));
      return;
    }
    localSharedPreferences.edit().putString("EvQwnbilKezpOJey".concat(str), paramString2).commit();
    localSharedPreferences.edit().putLong("rKrMJgyAEbVtSQGi".concat(str), l).commit();
  }

  public static long b(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      Log.e(a, "no context!");
      return 0L;
    }
    String str = a(paramString1, paramString2);
    long l;
    if (c.containsKey(str))
      l = ((Long)c.get(str)).longValue();
    while (true)
    {
      Long localLong = Long.valueOf(l);
      if (com.ta.utdid2.b.a.c.a)
        Log.d(a, "cache AIDGenTime:" + localLong);
      if (localLong.longValue() == 0L)
      {
        localLong = Long.valueOf(paramContext.getSharedPreferences("UTCommon", 0).getLong("rKrMJgyAEbVtSQGi".concat(str), 0L));
        c.put(str, localLong);
      }
      return localLong.longValue();
      l = 0L;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.a.c
 * JD-Core Version:    0.6.0
 */