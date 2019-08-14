package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UmengNotificationClickHandler
  implements UHandler
{
  private static final String a = UmengNotificationClickHandler.class.getName();

  private Intent a(Intent paramIntent, com.umeng.message.a.a parama)
  {
    if ((paramIntent == null) || (parama == null) || (parama.B == null));
    while (true)
    {
      return paramIntent;
      Iterator localIterator = parama.B.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str1 = (String)localEntry.getKey();
        String str2 = (String)localEntry.getValue();
        if (str1 == null)
          continue;
        paramIntent.putExtra(str1, str2);
      }
    }
  }

  public void autoUpdate(Context paramContext, com.umeng.message.a.a parama)
  {
    try
    {
      Object localObject = MsgLogStore.getInstance(paramContext).getMsgConfigInfo_UpdateResponse();
      Class localClass1 = Class.forName("com.umeng.update.UmengUpdateAgent");
      Class localClass2 = Class.forName("com.umeng.update.UpdateResponse");
      Method localMethod = localClass1.getMethod("showUpdateDialog", new Class[] { Context.class, localClass2 });
      if (localObject != null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramContext;
        arrayOfObject[1] = localClass2.cast(localObject);
        localMethod.invoke(localClass1, arrayOfObject);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void dealWithCustomAction(Context paramContext, com.umeng.message.a.a parama)
  {
  }

  public void dismissNotification(Context paramContext, com.umeng.message.a.a parama)
  {
  }

  public void handleMessage(Context paramContext, com.umeng.message.a.a parama)
  {
    try
    {
      if (!parama.E)
      {
        dismissNotification(paramContext, parama);
        return;
      }
      if ((TextUtils.equals("autoupdate", parama.k)) && (PushAgent.getInstance(paramContext).isIncludesUmengUpdateSDK()))
      {
        autoUpdate(paramContext, parama);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    if (!TextUtils.isEmpty(parama.t))
    {
      if (TextUtils.equals("go_url", parama.t))
      {
        openUrl(paramContext, parama);
        return;
      }
      if (TextUtils.equals("go_activity", parama.t))
      {
        openActivity(paramContext, parama);
        return;
      }
      if (TextUtils.equals("go_custom", parama.t))
      {
        dealWithCustomAction(paramContext, parama);
        return;
      }
      if (TextUtils.equals("go_app", parama.t))
      {
        launchApp(paramContext, parama);
        return;
      }
    }
    if ((parama.v != null) && (!TextUtils.isEmpty(parama.v.trim())))
    {
      openUrl(paramContext, parama);
      return;
    }
    if ((parama.z != null) && (!TextUtils.isEmpty(parama.z.trim())))
    {
      openActivity(paramContext, parama);
      return;
    }
    if ((parama.u != null) && (!TextUtils.isEmpty(parama.u.trim())))
    {
      dealWithCustomAction(paramContext, parama);
      return;
    }
    launchApp(paramContext, parama);
  }

  public void launchApp(Context paramContext, com.umeng.message.a.a parama)
  {
    Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName());
    if (localIntent == null)
    {
      com.umeng.b.a.a.b(a, "handleMessage(): cannot find app: " + paramContext.getPackageName());
      return;
    }
    localIntent.setPackage(null);
    localIntent.addFlags(268435456);
    a(localIntent, parama);
    paramContext.startActivity(localIntent);
    com.umeng.b.a.a.c(a, "handleMessage(): lunach app: " + paramContext.getPackageName());
  }

  public void openActivity(Context paramContext, com.umeng.message.a.a parama)
  {
    if ((parama.z == null) || (TextUtils.isEmpty(parama.z.trim())))
      return;
    Intent localIntent = new Intent();
    a(localIntent, parama);
    localIntent.setClassName(paramContext, parama.z);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  public void openUrl(Context paramContext, com.umeng.message.a.a parama)
  {
    if ((parama.v == null) || (TextUtils.isEmpty(parama.v.trim())))
      return;
    com.umeng.b.a.a.c(a, "handleMessage(): open url: " + parama.v);
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(parama.v));
    a(localIntent, parama);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengNotificationClickHandler
 * JD-Core Version:    0.6.0
 */