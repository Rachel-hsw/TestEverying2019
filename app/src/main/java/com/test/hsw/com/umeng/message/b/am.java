package com.umeng.message.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

public class am
{
  private static String a = Build.BRAND;
  private static final String b = "agoo_xiaomi";
  private static final String c = "agoo_huawei";
  private static final String d = "com.xiaomi.xmsf";
  private static final String e = "com.huawei.android.pushagent";
  private static final String f = "Huawei".toLowerCase();
  private static final String g = "Xiaomi".toLowerCase();

  public static final void a(Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(a)))
      return;
    cp.a(new an(paramContext));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.am
 * JD-Core Version:    0.6.0
 */