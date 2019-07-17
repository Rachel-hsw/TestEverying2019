package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.alipay.security.mobile.module.a.a;
import com.alipay.security.mobile.module.c.c;
import java.util.UUID;

public final class b
{
  public static String a(Context paramContext)
  {
    String str = c.a(paramContext, "alipay_vkey_random", "random", "");
    if (a.a(str))
    {
      str = com.alipay.security.mobile.module.a.a.b.a(UUID.randomUUID().toString());
      if (str != null)
      {
        SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("alipay_vkey_random", 0).edit();
        if (localEditor != null)
        {
          localEditor.clear();
          localEditor.putString("random", str);
          localEditor.commit();
        }
      }
    }
    return str;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.e.b
 * JD-Core Version:    0.6.0
 */