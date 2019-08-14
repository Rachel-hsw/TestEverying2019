package com.umeng.socialize.utils;

import android.app.ProgressDialog;
import android.content.Context;
import com.umeng.socialize.common.b;
import com.umeng.socialize.common.b.a;

public class h
{
  private static int a = -1;
  private static int b = -1;
  private static int c = -1;

  public static ProgressDialog a(Context paramContext, com.umeng.socialize.bean.p paramp, String paramString, boolean paramBoolean)
  {
    if (a == -1)
      a = b.a(paramContext, b.a.d, "Theme.UMDialog");
    if ((!paramBoolean) && (b == -1))
      b = b.a(paramContext, b.a.e, "umeng_socialize_text_waitting_redirect");
    if ((!paramBoolean) && (c == -1))
      c = b.a(paramContext, b.a.e, "umeng_socialize_text_waitting_message");
    ProgressDialog localProgressDialog = new ProgressDialog(paramContext, a);
    if (!paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getString(b));
      localStringBuilder.append(com.umeng.socialize.common.p.a(paramContext, paramp));
      localStringBuilder.append(paramContext.getString(c));
      paramString = localStringBuilder.toString();
    }
    localProgressDialog.setMessage(paramString);
    return localProgressDialog;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.utils.h
 * JD-Core Version:    0.6.0
 */