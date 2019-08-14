package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.d.c.b;
import com.xiaomi.d.c.d;
import com.xiaomi.d.c.f;
import java.util.Collection;
import java.util.Iterator;

public class s
{
  private ac a = new ac();

  public static String a(String paramString)
  {
    return paramString + ".permission.MIPUSH_RECEIVE";
  }

  private static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    if ("com.xiaomi.xmsf".equals(paramContext.getPackageName()))
    {
      paramContext.sendBroadcast(paramIntent);
      return;
    }
    paramContext.sendBroadcast(paramIntent, a(paramString));
  }

  an.b a(d paramd)
  {
    Collection localCollection = an.a().c(paramd.l());
    an.b localb;
    if (localCollection.isEmpty())
    {
      localb = null;
      return localb;
    }
    Iterator localIterator = localCollection.iterator();
    if (localCollection.size() == 1)
      return (an.b)localIterator.next();
    String str1 = paramd.n();
    String str2 = paramd.m();
    do
    {
      if (!localIterator.hasNext())
        break label114;
      localb = (an.b)localIterator.next();
      if (TextUtils.equals(str1, localb.b))
        break;
    }
    while (!TextUtils.equals(str2, localb.b));
    return localb;
    label114: return null;
  }

  public void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.service_started");
    paramContext.sendBroadcast(localIntent);
  }

  public void a(Context paramContext, an.b paramb, int paramInt)
  {
    if ("5".equalsIgnoreCase(paramb.h))
      return;
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.channel_closed");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra(ap.q, paramb.h);
    localIntent.putExtra("ext_reason", paramInt);
    localIntent.putExtra(ap.p, paramb.b);
    localIntent.putExtra(ap.B, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }

  public void a(Context paramContext, an.b paramb, String paramString1, String paramString2)
  {
    if ("5".equalsIgnoreCase(paramb.h))
    {
      com.xiaomi.a.a.c.c.d("mipush kicked by server");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.kicked");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra("ext_kick_type", paramString1);
    localIntent.putExtra("ext_kick_reason", paramString2);
    localIntent.putExtra("ext_chid", paramb.h);
    localIntent.putExtra(ap.p, paramb.b);
    localIntent.putExtra(ap.B, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }

  public void a(Context paramContext, an.b paramb, boolean paramBoolean, int paramInt, String paramString)
  {
    if ("5".equalsIgnoreCase(paramb.h))
    {
      this.a.a(paramContext, paramb, paramBoolean, paramInt, paramString);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.xiaomi.push.channel_opened");
    localIntent.setPackage(paramb.a);
    localIntent.putExtra("ext_succeeded", paramBoolean);
    if (!paramBoolean)
      localIntent.putExtra("ext_reason", paramInt);
    if (!TextUtils.isEmpty(paramString))
      localIntent.putExtra("ext_reason_msg", paramString);
    localIntent.putExtra("ext_chid", paramb.h);
    localIntent.putExtra(ap.p, paramb.b);
    localIntent.putExtra(ap.B, paramb.j);
    a(paramContext, localIntent, paramb.a);
  }

  public void a(XMPushService paramXMPushService, String paramString, d paramd)
  {
    an.b localb = a(paramd);
    if (localb == null)
    {
      com.xiaomi.a.a.c.c.d("error while notify channel closed! channel " + paramString + " not registered");
      return;
    }
    if ("5".equalsIgnoreCase(paramString))
    {
      this.a.a(paramXMPushService, paramd, localb);
      return;
    }
    String str1 = localb.a;
    String str2;
    if ((paramd instanceof com.xiaomi.d.c.c))
      str2 = "com.xiaomi.push.new_msg";
    while (true)
    {
      Intent localIntent = new Intent();
      localIntent.setAction(str2);
      localIntent.setPackage(str1);
      localIntent.putExtra("ext_chid", paramString);
      localIntent.putExtra("ext_packet", paramd.c());
      localIntent.putExtra(ap.B, localb.j);
      localIntent.putExtra(ap.u, localb.i);
      a(paramXMPushService, localIntent, str1);
      return;
      if ((paramd instanceof b))
      {
        str2 = "com.xiaomi.push.new_iq";
        continue;
      }
      if (!(paramd instanceof f))
        break;
      str2 = "com.xiaomi.push.new_pres";
    }
    com.xiaomi.a.a.c.c.d("unknown packet type, drop it");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.s
 * JD-Core Version:    0.6.0
 */