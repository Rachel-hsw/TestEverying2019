package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class UmengIntentService extends UmengBaseIntentService
{
  private static final String a = UmengIntentService.class.getName();

  protected void b(Context paramContext, Intent paramIntent)
  {
    super.b(paramContext, paramIntent);
    try
    {
      String str1 = paramIntent.getStringExtra("body");
      String str2 = paramIntent.getStringExtra("id");
      String str3 = paramIntent.getStringExtra("task_id");
      Intent localIntent = new Intent();
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.setAction("com.umeng.message.message.handler.action");
      localIntent.putExtra("body", str1);
      localIntent.putExtra("id", str2);
      localIntent.putExtra("task_id", str3);
      paramContext.startService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      Log.e(a, localException.getMessage());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengIntentService
 * JD-Core Version:    0.6.0
 */