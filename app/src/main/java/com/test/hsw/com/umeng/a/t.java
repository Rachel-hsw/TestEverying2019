package com.umeng.a;

import android.content.Context;
import android.text.TextUtils;

public class t
{
  private static String[] a = new String[2];

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a[0] = paramString1;
    a[1] = paramString2;
    if (paramContext != null)
      w.a(paramContext).a(paramString1, paramString2);
  }

  public static String[] a(Context paramContext)
  {
    if ((!TextUtils.isEmpty(a[0])) && (!TextUtils.isEmpty(a[1])))
      return a;
    if (paramContext != null)
    {
      String[] arrayOfString = w.a(paramContext).a();
      if (arrayOfString != null)
      {
        a[0] = arrayOfString[0];
        a[1] = arrayOfString[1];
        return a;
      }
    }
    return null;
  }

  public static void b(Context paramContext)
  {
    a[0] = null;
    a[1] = null;
    if (paramContext != null)
      w.a(paramContext).b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.t
 * JD-Core Version:    0.6.0
 */