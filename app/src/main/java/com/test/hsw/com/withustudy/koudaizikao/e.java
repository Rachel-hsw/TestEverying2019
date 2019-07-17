package com.withustudy.koudaizikao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.a.a;
import com.withustudy.koudaizikao.activity.InformationDetailActivity;
import com.withustudy.koudaizikao.activity.PostDetailActivity;
import com.withustudy.koudaizikao.activity.VideoPushLoadingActivity;
import com.withustudy.koudaizikao.activity.WelcomeActivity;
import com.withustudy.koudaizikao.g.h;

class e extends UmengNotificationClickHandler
{
  e(MyApplication paramMyApplication)
  {
  }

  public void dealWithCustomAction(Context paramContext, a parama)
  {
    String str = parama.u;
    h.a(this.a.getApplicationContext(), " custom=" + str);
    String[] arrayOfString;
    Intent localIntent1;
    if ((str != null) && (!str.equals("")))
    {
      arrayOfString = str.split(";");
      localIntent1 = new Intent();
      if (arrayOfString[0].equals("资讯"))
      {
        localIntent1.setClass(paramContext, InformationDetailActivity.class);
        Bundle localBundle3 = new Bundle();
        localBundle3.putInt("id", Integer.valueOf(arrayOfString[3]).intValue());
        localBundle3.putBoolean("push", true);
        localIntent1.setFlags(268435456);
        localIntent1.putExtras(localBundle3);
        paramContext.startActivity(localIntent1);
      }
    }
    else
    {
      return;
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
      localBundle1.putString("data", str);
      localIntent1.setFlags(268435456);
      localIntent1.putExtras(localBundle1);
      paramContext.startActivity(localIntent1);
      return;
    }
    Intent localIntent2 = new Intent(paramContext, WelcomeActivity.class);
    localIntent2.setFlags(268435456);
    paramContext.startActivity(localIntent2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.e
 * JD-Core Version:    0.6.0
 */