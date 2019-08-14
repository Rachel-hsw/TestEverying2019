package org.android.agoo.b;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public final class a
{
  public static final String a = "org.agoo.android.intent.action.RECEIVE";
  public static final String b = "org.agoo.android.intent.action.ELECTION_RESULT_V4";
  public static final String c = "org.agoo.android.intent.action.PING_V4";
  public static final String d = ".intent.action.SEND";
  public static final String e = "command";
  public static final String f = "re_user";
  public static final String g = "registration";
  public static final String h = "command_restart_sudo";
  public static final String i = "command_other_channel";
  public static final String j = "agoo_command_restart_sudo_app";
  public static final String k = "channel_android_device_token";
  public static final String l = "channel_android_device_type";
  public static final String m = "command_bind_user";
  public static final String n = "command_unbind_user";
  public static final String o = "command_bind_user_xtoken";
  private static final String p = ".intent.action.COMMAND";
  private static final String q = ".intent.action.START";
  private static final String r = ".intent.action.COCKROACH";
  private static final String s = "org.agoo.android";
  private static final String t = "org.agoo.android.intent.action.";
  private static final String u = "IntentUtil";

  // ERROR //
  public static final Intent a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 77	android/content/Intent
    //   3: dup
    //   4: invokespecial 78	android/content/Intent:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokestatic 81	org/android/agoo/b/a:b	(Landroid/content/Context;)Ljava/lang/String;
    //   13: invokevirtual 85	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   16: pop
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 91	android/content/Context:getPackageName	()Ljava/lang/String;
    //   22: invokevirtual 94	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   25: pop
    //   26: aload_2
    //   27: ldc 20
    //   29: aload_1
    //   30: invokevirtual 98	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   33: pop
    //   34: aload_2
    //   35: areturn
    //   36: astore 8
    //   38: aconst_null
    //   39: astore_2
    //   40: aload 8
    //   42: astore_3
    //   43: ldc 68
    //   45: ldc 100
    //   47: aload_3
    //   48: invokestatic 106	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   51: pop
    //   52: aload_2
    //   53: areturn
    //   54: astore_3
    //   55: goto -12 -> 43
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	36	java/lang/Throwable
    //   8	34	54	java/lang/Throwable
  }

  public static String a(Context paramContext)
  {
    if (paramContext != null)
      try
      {
        String str = paramContext.getPackageName() + ".intent.action.SEND";
        return str;
      }
      catch (Throwable localThrowable)
      {
        Log.w("IntentUtil", "getAgooSendAction", localThrowable);
      }
    return null;
  }

  public static final void a(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("org.agoo.android.intent.action.RECEIVE");
      localIntent.putExtra("message_source", paramString);
      localIntent.putExtras(paramIntent.getExtras());
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = a(paramContext, "command_other_channel");
      localIntent.putExtra("channel_android_device_token", paramString1);
      localIntent.putExtra("channel_android_device_type", paramString2);
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("IntentUtil", "sendOtherChannel", localThrowable);
    }
  }

  public static final String b(Context paramContext)
  {
    if (paramContext != null)
      try
      {
        String str = paramContext.getPackageName() + ".intent.action.COMMAND";
        return str;
      }
      catch (Throwable localThrowable)
      {
        Log.w("IntentUtil", "getAgooCommand", localThrowable);
      }
    return null;
  }

  public static final String c(Context paramContext)
  {
    if (paramContext != null)
      try
      {
        String str = paramContext.getPackageName() + ".intent.action.START";
        return str;
      }
      catch (Throwable localThrowable)
      {
        Log.w("IntentUtil", "getAgooStart", localThrowable);
      }
    return null;
  }

  public static final String d(Context paramContext)
  {
    if (paramContext != null)
      try
      {
        String str = paramContext.getPackageName() + ".intent.action.COCKROACH";
        return str;
      }
      catch (Throwable localThrowable)
      {
        Log.w("IntentUtil", "getAgooCockroach", localThrowable);
      }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.b.a
 * JD-Core Version:    0.6.0
 */