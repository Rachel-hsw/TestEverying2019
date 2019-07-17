package com.xiaomi.mipush;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.activity.InformationDetailActivity;
import com.withustudy.koudaizikao.activity.PostDetailActivity;
import com.withustudy.koudaizikao.activity.VideoPushLoadingActivity;
import com.withustudy.koudaizikao.activity.WelcomeActivity;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MiPushReceiver extends PushMessageReceiver
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private boolean g = false;

  @SuppressLint({"SimpleDateFormat"})
  public static String a()
  {
    return new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
  }

  private void a(Context paramContext)
  {
    if (this.g)
      return;
    this.g = true;
    com.withustudy.koudaizikao.a.a locala = c.b().aq();
    a locala1 = new a(this);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = (this.a + ";" + "xiaomi");
    arrayOfString[1] = com.withustudy.koudaizikao.d.f.a(paramContext).i();
    locala.a(locala1, arrayOfString, 0, paramContext);
  }

  public void onCommandResult(Context paramContext, e parame)
  {
    String str1 = parame.a();
    List localList = parame.b();
    String str2;
    if ((localList != null) && (localList.size() > 0))
    {
      str2 = (String)localList.get(0);
      if ((localList == null) || (localList.size() <= 1))
        break label111;
    }
    label111: for (String str3 = (String)localList.get(1); ; str3 = null)
    {
      if (!"register".equals(str1))
        break label125;
      if (parame.c() != 0L)
        break label117;
      this.a = str2;
      a(paramContext);
      paramContext.getString(2131165558);
      return;
      str2 = null;
      break;
    }
    label117: paramContext.getString(2131165559);
    return;
    label125: if ("set-alias".equals(str1))
    {
      if (parame.c() == 0L)
      {
        this.c = str2;
        Object[] arrayOfObject14 = new Object[1];
        arrayOfObject14[0] = this.c;
        paramContext.getString(2131165563, arrayOfObject14);
        return;
      }
      Object[] arrayOfObject13 = new Object[1];
      arrayOfObject13[0] = parame.d();
      paramContext.getString(2131165564, arrayOfObject13);
      return;
    }
    if ("unset-alias".equals(str1))
    {
      if (parame.c() == 0L)
      {
        this.c = str2;
        Object[] arrayOfObject12 = new Object[1];
        arrayOfObject12[0] = this.c;
        paramContext.getString(2131165565, arrayOfObject12);
        return;
      }
      Object[] arrayOfObject11 = new Object[1];
      arrayOfObject11[0] = parame.d();
      paramContext.getString(2131165566, arrayOfObject11);
      return;
    }
    if ("set-account".equals(str1))
    {
      if (parame.c() == 0L)
      {
        this.d = str2;
        Object[] arrayOfObject10 = new Object[1];
        arrayOfObject10[0] = this.d;
        paramContext.getString(2131165567, arrayOfObject10);
        return;
      }
      Object[] arrayOfObject9 = new Object[1];
      arrayOfObject9[0] = parame.d();
      paramContext.getString(2131165568, arrayOfObject9);
      return;
    }
    if ("unset-account".equals(str1))
    {
      if (parame.c() == 0L)
      {
        this.d = str2;
        Object[] arrayOfObject8 = new Object[1];
        arrayOfObject8[0] = this.d;
        paramContext.getString(2131165569, arrayOfObject8);
        return;
      }
      Object[] arrayOfObject7 = new Object[1];
      arrayOfObject7[0] = parame.d();
      paramContext.getString(2131165570, arrayOfObject7);
      return;
    }
    if ("subscribe-topic".equals(str1))
    {
      if (parame.c() == 0L)
      {
        this.b = str2;
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = this.b;
        paramContext.getString(2131165571, arrayOfObject6);
        return;
      }
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = parame.d();
      paramContext.getString(2131165572, arrayOfObject5);
      return;
    }
    if ("unsubscibe-topic".equals(str1))
    {
      if (parame.c() == 0L)
      {
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = this.b;
        paramContext.getString(2131165573, arrayOfObject4);
        return;
      }
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = parame.d();
      paramContext.getString(2131165574, arrayOfObject3);
      return;
    }
    if ("accept-time".equals(str1))
    {
      if (parame.c() == 0L)
      {
        this.e = str2;
        this.f = str3;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = this.e;
        arrayOfObject2[1] = this.f;
        paramContext.getString(2131165575, arrayOfObject2);
        return;
      }
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = parame.d();
      paramContext.getString(2131165576, arrayOfObject1);
      return;
    }
    parame.d();
  }

  public void onNotificationMessageArrived(Context paramContext, com.xiaomi.mipush.sdk.f paramf)
  {
    if (!TextUtils.isEmpty(paramf.g()))
      this.b = paramf.g();
    do
      return;
    while (TextUtils.isEmpty(paramf.e()));
    this.c = paramf.e();
  }

  public void onNotificationMessageClicked(Context paramContext, com.xiaomi.mipush.sdk.f paramf)
  {
    if (!TextUtils.isEmpty(paramf.g()))
      this.b = paramf.g();
    String[] arrayOfString;
    Intent localIntent1;
    while (true)
    {
      if ((paramf != null) && (paramf.d() != null) && (!paramf.equals("")))
      {
        arrayOfString = paramf.d().split(";");
        localIntent1 = new Intent();
        if (!arrayOfString[0].equals("资讯"))
          break;
        localIntent1.setClass(paramContext, InformationDetailActivity.class);
        Bundle localBundle3 = new Bundle();
        localBundle3.putInt("id", Integer.valueOf(arrayOfString[3]).intValue());
        localBundle3.putBoolean("push", true);
        localIntent1.setFlags(268435456);
        localIntent1.putExtras(localBundle3);
        paramContext.startActivity(localIntent1);
      }
      return;
      if (TextUtils.isEmpty(paramf.e()))
        continue;
      this.c = paramf.e();
    }
    if (arrayOfString[0].equals("社区"))
    {
      localIntent1.setClass(paramContext, PostDetailActivity.class);
      Bundle localBundle2 = new Bundle();
      localBundle2.putInt("id", Integer.valueOf(arrayOfString[3]).intValue());
      localBundle2.putBoolean("push", true);
      localIntent1.setFlags(268435456);
      localIntent1.putExtras(localBundle2);
      paramContext.startActivity(localIntent1);
      return;
    }
    if (arrayOfString[0].equals("课堂"))
    {
      localIntent1.setClass(paramContext, VideoPushLoadingActivity.class);
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("data", paramf.d());
      localIntent1.setFlags(268435456);
      localIntent1.putExtras(localBundle1);
      paramContext.startActivity(localIntent1);
      return;
    }
    Intent localIntent2 = new Intent(paramContext, WelcomeActivity.class);
    localIntent2.setFlags(268435456);
    paramContext.startActivity(localIntent2);
  }

  public void onReceivePassThroughMessage(Context paramContext, com.xiaomi.mipush.sdk.f paramf)
  {
    if (!TextUtils.isEmpty(paramf.g()))
      this.b = paramf.g();
    do
      return;
    while (TextUtils.isEmpty(paramf.e()));
    this.c = paramf.e();
  }

  public void onReceiveRegisterResult(Context paramContext, e parame)
  {
    String str1 = parame.a();
    List localList = parame.b();
    String str2;
    if ((localList != null) && (localList.size() > 0))
      str2 = (String)localList.get(0);
    while ("register".equals(str1))
    {
      if (parame.c() == 0L)
      {
        this.a = str2;
        a(paramContext);
        paramContext.getString(2131165558);
        return;
        str2 = null;
        continue;
      }
      paramContext.getString(2131165559);
      return;
    }
    parame.d();
  }

  public static class a extends Handler
  {
    private Context a;

    public a(Context paramContext)
    {
      this.a = paramContext;
    }

    public void handleMessage(Message paramMessage)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.MiPushReceiver
 * JD-Core Version:    0.6.0
 */