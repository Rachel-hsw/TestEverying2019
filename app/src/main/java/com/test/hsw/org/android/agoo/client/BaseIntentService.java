package org.android.agoo.client;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import org.android.agoo.e;
import org.json.JSONObject;

public abstract class BaseIntentService extends IntentService
  implements org.android.agoo.a.a
{
  private static final String a = "BaseIntentService";
  private static final String b = "loadUpdateJar";

  public BaseIntentService()
  {
    super("AgooIntentService");
  }

  private final void a(Context paramContext)
  {
    boolean bool1 = true;
    if (paramContext != null);
    try
    {
      Log.v("BaseIntentService", "auto update [updateSwitchConfig]");
      org.android.agoo.b localb = (org.android.agoo.b)org.android.agoo.d.a.a(paramContext, "org.android.agoo.impl.MtopService");
      f localf = new f();
      localf.b("mtop.wswitch.syncconfiggroup");
      localf.c("1.0");
      localf.a("configName", "client_sdk_switch");
      h localh = localb.getV3(paramContext, localf);
      String str1;
      if (localh.a())
        str1 = localh.b();
      while (true)
      {
        long l1;
        boolean bool2;
        boolean bool3;
        label184: boolean bool4;
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          String str2 = (String)localJSONObject.get("autoUpdate");
          String str3 = (String)localJSONObject.get("multiplex");
          String str4 = (String)localJSONObject.get("spdy");
          l1 = Long.parseLong((String)localJSONObject.get("updateCycle"));
          String str5 = (String)localJSONObject.get("postData");
          if (!"true".equals(str2))
            break label369;
          bool2 = bool1;
          if (!"true".equals(str3))
            break label363;
          bool3 = bool1;
          if (!"true".equals(str4))
            break label357;
          bool4 = bool1;
          label197: if (!"true".equals(str5))
            break label352;
          break label375;
          label210: Object localObject;
          org.android.a.a(paramContext, bool2, bool3, bool4, localObject, bool1);
          org.android.a.a(paramContext, System.currentTimeMillis());
          return;
        }
        catch (Throwable localThrowable2)
        {
          org.android.agoo.e.b localb2 = org.android.agoo.e.b.a();
          String[] arrayOfString2 = new String[2];
          arrayOfString2[0] = "ERROR_EVENT_UPDATECONFIG_ERROR";
          arrayOfString2[1] = ("content=" + str1);
          localb2.a(paramContext, "updateConfig", arrayOfString2);
          continue;
        }
        org.android.agoo.e.b localb1 = org.android.agoo.e.b.a();
        String[] arrayOfString1 = new String[2];
        arrayOfString1[0] = "ERROR_EVENT_UPDATECONFIG_ERROR";
        arrayOfString1[1] = ("result=" + localh.toString());
        localb1.a(paramContext, "updateConfig", arrayOfString1);
        continue;
        label352: label357: label363: label369: label375: 
        do
        {
          l2 = 86400L;
          break label210;
          bool1 = false;
          continue;
          bool4 = false;
          break label197;
          bool3 = false;
          break label184;
          bool2 = false;
          break;
        }
        while (l1 == 0L);
        long l2 = l1;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
    }
  }

  static final void a(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      Log.d("BaseIntentService", "runIntent to receive one message" + paramIntent + "|" + paramString);
      paramIntent.setClassName(paramContext, paramString);
      paramContext.startService(paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "runIntentInService", localThrowable);
      return;
    }
    finally
    {
    }
    throw localObject;
  }

  private void e(Context paramContext, String paramString)
  {
    if (paramContext != null)
      try
      {
        if (TextUtils.isEmpty(paramString))
          return;
        boolean bool = org.android.a.b(paramContext, System.currentTimeMillis());
        if ((bool) && (b.isRegistered(paramContext)))
        {
          a(paramContext);
          if ((org.android.a.r(paramContext)) && (bool) && (b.isRegistered(paramContext)))
          {
            Log.w("BaseIntentService", "auto update [download]");
            e locale = (e)org.android.agoo.d.a.a(paramContext, "org.android.agoo.impl.UpdateService");
            if ((!TextUtils.isEmpty(paramString)) && (paramString.contains(".")))
            {
              String[] arrayOfString = paramString.split("\\.");
              if ((arrayOfString != null) && (arrayOfString.length > 0))
                paramString = arrayOfString[(-1 + arrayOfString.length)];
            }
            locale.a(paramContext, "push", paramString);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w("BaseIntentService", " onHandleIntent---isNeedAutoUpdate", localThrowable);
      }
  }

  protected Class<?> a()
  {
    return null;
  }

  protected void a(Context paramContext, int paramInt)
  {
  }

  protected abstract void a(Context paramContext, String paramString);

  protected boolean a(Context paramContext, Intent paramIntent)
  {
    return true;
  }

  protected abstract void b(Context paramContext, Intent paramIntent);

  protected abstract void b(Context paramContext, String paramString);

  protected void c(Context paramContext, Intent paramIntent)
  {
  }

  protected abstract void c(Context paramContext, String paramString);

  public Class<?> callAgooService()
  {
    try
    {
      Class localClass = a();
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callAgooService", localThrowable);
    }
    return null;
  }

  public final void callDeletedMessages(Context paramContext, int paramInt)
  {
    try
    {
      a(paramContext, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callDeletedMessages", localThrowable);
    }
  }

  public final void callError(Context paramContext, String paramString)
  {
    try
    {
      Log.w("BaseIntentService", "callError[" + paramString + "]");
      a(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callError", localThrowable);
    }
  }

  public final void callMessage(Context paramContext, Intent paramIntent)
  {
    try
    {
      b(paramContext, paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public boolean callRecoverableError(Context paramContext, String paramString)
  {
    return true;
  }

  public final void callRegistered(Context paramContext, String paramString)
  {
    try
    {
      b(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callRegistered", localThrowable);
    }
  }

  public final boolean callShouldProcessMessage(Context paramContext, Intent paramIntent)
  {
    try
    {
      boolean bool = a(paramContext, paramIntent);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callShouldProcessMessage", localThrowable);
    }
    return false;
  }

  public final void callUnregistered(Context paramContext, String paramString)
  {
    try
    {
      c(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callUnregistered", localThrowable);
    }
  }

  public final void callUserCommand(Context paramContext, Intent paramIntent)
  {
    try
    {
      c(paramContext, paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callUserCommand", localThrowable);
    }
  }

  public final void callUserHandleIntent(Context paramContext, Intent paramIntent)
  {
    try
    {
      d(paramContext, paramIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", "callUserHandleIntent", localThrowable);
    }
  }

  protected void d(Context paramContext, Intent paramIntent)
  {
  }

  protected boolean d(Context paramContext, String paramString)
  {
    return true;
  }

  public final void onHandleIntent(Intent paramIntent)
  {
    Context localContext = null;
    boolean bool = false;
    try
    {
      localContext = getApplicationContext();
      bool = org.android.a.t(localContext);
      org.android.agoo.a locala = (org.android.agoo.a)org.android.agoo.d.a.a(localContext, "org.android.agoo.impl.ControlService");
      if (locala != null)
        locala.onHandleIntent(localContext, paramIntent, this);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseIntentService", " onHandleIntent", localThrowable);
      return;
    }
    finally
    {
      if (bool)
        e(localContext, "0");
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.client.BaseIntentService
 * JD-Core Version:    0.6.0
 */