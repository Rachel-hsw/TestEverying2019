package com.withustudy.koudaizikao;

import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.a.a;
import com.umeng.message.local.UmengLocalNotification;

class c extends UmengMessageHandler
{
  c(MyApplication paramMyApplication)
  {
  }

  public void dealWithCustomMessage(Context paramContext, a parama)
  {
    new Handler().post(new d(this, parama, paramContext));
  }

  public Notification getNotification(Context paramContext, a parama)
  {
    switch (parama.A)
    {
    default:
      return super.getNotification(paramContext, parama);
    case 1:
    }
    UmengLocalNotification localUmengLocalNotification = new UmengLocalNotification();
    localUmengLocalNotification.setTitle(parama.n);
    localUmengLocalNotification.setContent(parama.o);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903244);
    localRemoteViews.setTextViewText(2131297455, parama.n);
    localRemoteViews.setTextViewText(2131297456, parama.o);
    localRemoteViews.setImageViewBitmap(2131297454, getLargeIcon(paramContext, parama));
    localRemoteViews.setImageViewResource(2131297457, getSmallIconId(paramContext, parama));
    localBuilder.setContent(localRemoteViews);
    localBuilder.setContentTitle(parama.n).setContentText(parama.o).setTicker(parama.m).setAutoCancel(true);
    Notification localNotification = localBuilder.build();
    localNotification.contentView = localRemoteViews;
    return localNotification;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.c
 * JD-Core Version:    0.6.0
 */