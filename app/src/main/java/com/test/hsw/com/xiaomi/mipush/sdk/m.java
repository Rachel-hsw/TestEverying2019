package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.f.a.a;
import com.xiaomi.f.a.i;
import com.xiaomi.f.a.k;
import com.xiaomi.f.a.p;
import com.xiaomi.f.a.r;
import com.xiaomi.f.a.t;
import com.xiaomi.f.a.u;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.ap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

public class m
{
  private static m a = null;
  private static Queue<String> c;
  private static Object d = new Object();
  private Context b;

  private m(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    if (this.b == null)
      this.b = paramContext;
  }

  // ERROR //
  public static Intent a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +14 -> 15
    //   4: aload_2
    //   5: ldc 42
    //   7: invokeinterface 48 2 0
    //   12: ifne +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: aload_2
    //   18: ldc 42
    //   20: invokeinterface 52 2 0
    //   25: checkcast 54	java/lang/String
    //   28: astore_3
    //   29: getstatic 59	com/xiaomi/push/service/ap:a	Ljava/lang/String;
    //   32: aload_3
    //   33: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +85 -> 121
    //   39: aload_0
    //   40: invokevirtual 66	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   43: aload_1
    //   44: invokevirtual 72	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   47: astore 27
    //   49: aload 27
    //   51: astore 4
    //   53: aload 4
    //   55: ifnull -40 -> 15
    //   58: aload 4
    //   60: ldc 73
    //   62: invokevirtual 79	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   65: pop
    //   66: aload_0
    //   67: invokevirtual 66	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   70: aload 4
    //   72: ldc 80
    //   74: invokevirtual 84	android/content/pm/PackageManager:resolveActivity	(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
    //   77: astore 7
    //   79: aload 7
    //   81: ifnull -66 -> 15
    //   84: aload 4
    //   86: areturn
    //   87: astore 26
    //   89: new 86	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   96: ldc 89
    //   98: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 26
    //   103: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   106: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 105	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   115: aconst_null
    //   116: astore 4
    //   118: goto -65 -> 53
    //   121: getstatic 107	com/xiaomi/push/service/ap:b	Ljava/lang/String;
    //   124: aload_3
    //   125: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   128: ifeq +203 -> 331
    //   131: aload_2
    //   132: ldc 109
    //   134: invokeinterface 48 2 0
    //   139: ifeq +74 -> 213
    //   142: aload_2
    //   143: ldc 109
    //   145: invokeinterface 52 2 0
    //   150: checkcast 54	java/lang/String
    //   153: astore 21
    //   155: aload 21
    //   157: ifnull +422 -> 579
    //   160: aload 21
    //   162: iconst_1
    //   163: invokestatic 113	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   166: astore 24
    //   168: aload 24
    //   170: astore 4
    //   172: aload 4
    //   174: aload_1
    //   175: invokevirtual 116	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   178: pop
    //   179: goto -126 -> 53
    //   182: astore 23
    //   184: new 86	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   191: ldc 89
    //   193: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload 23
    //   198: invokevirtual 117	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   201: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 105	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   210: goto -157 -> 53
    //   213: aload_2
    //   214: ldc 119
    //   216: invokeinterface 48 2 0
    //   221: ifeq +352 -> 573
    //   224: aload_2
    //   225: ldc 119
    //   227: invokeinterface 52 2 0
    //   232: checkcast 54	java/lang/String
    //   235: astore 16
    //   237: new 75	android/content/Intent
    //   240: dup
    //   241: invokespecial 120	android/content/Intent:<init>	()V
    //   244: astore 17
    //   246: aload 17
    //   248: new 122	android/content/ComponentName
    //   251: dup
    //   252: aload_1
    //   253: aload 16
    //   255: invokespecial 125	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: invokevirtual 129	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   261: pop
    //   262: aload_2
    //   263: ldc 131
    //   265: invokeinterface 48 2 0
    //   270: ifeq +23 -> 293
    //   273: aload 17
    //   275: aload_2
    //   276: ldc 131
    //   278: invokeinterface 52 2 0
    //   283: checkcast 54	java/lang/String
    //   286: invokestatic 137	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   289: invokevirtual 140	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   292: pop
    //   293: aload 17
    //   295: astore 4
    //   297: goto -244 -> 53
    //   300: astore 19
    //   302: new 86	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   309: ldc 142
    //   311: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 19
    //   316: invokevirtual 143	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   319: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 105	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   328: goto -35 -> 293
    //   331: getstatic 145	com/xiaomi/push/service/ap:c	Ljava/lang/String;
    //   334: aload_3
    //   335: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +235 -> 573
    //   341: aload_2
    //   342: ldc 147
    //   344: invokeinterface 52 2 0
    //   349: checkcast 54	java/lang/String
    //   352: astore 8
    //   354: aload 8
    //   356: ifnull +217 -> 573
    //   359: aload 8
    //   361: invokevirtual 150	java/lang/String:trim	()Ljava/lang/String;
    //   364: astore 9
    //   366: aload 9
    //   368: ldc 152
    //   370: invokevirtual 156	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   373: ifne +193 -> 566
    //   376: aload 9
    //   378: ldc 158
    //   380: invokevirtual 156	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   383: ifne +183 -> 566
    //   386: new 86	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   393: ldc 152
    //   395: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 9
    //   400: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: astore 10
    //   408: new 160	java/net/URL
    //   411: dup
    //   412: aload 10
    //   414: invokespecial 162	java/net/URL:<init>	(Ljava/lang/String;)V
    //   417: invokevirtual 165	java/net/URL:getProtocol	()Ljava/lang/String;
    //   420: astore 13
    //   422: ldc 167
    //   424: aload 13
    //   426: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   429: ifne +13 -> 442
    //   432: ldc 169
    //   434: aload 13
    //   436: invokevirtual 62	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   439: ifeq +121 -> 560
    //   442: new 75	android/content/Intent
    //   445: dup
    //   446: ldc 171
    //   448: invokespecial 172	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   451: astore 4
    //   453: aload 4
    //   455: aload 10
    //   457: invokestatic 178	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   460: invokevirtual 182	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   463: pop
    //   464: goto -411 -> 53
    //   467: astore 14
    //   469: aload 4
    //   471: astore 12
    //   473: aload 14
    //   475: astore 11
    //   477: new 86	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   484: ldc 89
    //   486: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 11
    //   491: invokevirtual 183	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   494: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 105	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   503: aload 12
    //   505: astore 4
    //   507: goto -454 -> 53
    //   510: astore 6
    //   512: new 86	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   519: ldc 89
    //   521: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload 6
    //   526: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   529: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 105	com/xiaomi/a/a/c/c:d	(Ljava/lang/String;)V
    //   538: aconst_null
    //   539: areturn
    //   540: astore 11
    //   542: aconst_null
    //   543: astore 12
    //   545: goto -68 -> 477
    //   548: astore 22
    //   550: aload 22
    //   552: astore 23
    //   554: aconst_null
    //   555: astore 4
    //   557: goto -373 -> 184
    //   560: aconst_null
    //   561: astore 4
    //   563: goto -510 -> 53
    //   566: aload 9
    //   568: astore 10
    //   570: goto -162 -> 408
    //   573: aconst_null
    //   574: astore 4
    //   576: goto -523 -> 53
    //   579: aconst_null
    //   580: astore 4
    //   582: goto -529 -> 53
    //
    // Exception table:
    //   from	to	target	type
    //   39	49	87	java/lang/Exception
    //   172	179	182	java/net/URISyntaxException
    //   262	293	300	java/lang/NumberFormatException
    //   453	464	467	java/net/MalformedURLException
    //   66	79	510	java/lang/Exception
    //   408	442	540	java/net/MalformedURLException
    //   442	453	540	java/net/MalformedURLException
    //   160	168	548	java/net/URISyntaxException
  }

  private PushMessageHandler.a a(com.xiaomi.f.a.h paramh, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    org.a.c.b localb;
    try
    {
      localb = l.a(this.b, paramh);
      if (localb == null)
      {
        com.xiaomi.a.a.c.c.d("receiving an un-recognized message. " + paramh.a);
        return null;
      }
      com.xiaomi.a.a.c.c.c("receive a message." + localb);
      a locala = paramh.a();
      com.xiaomi.a.a.c.c.a("processing a message, action=" + locala);
      switch (1.a[locala.ordinal()])
      {
      default:
        return null;
      case 1:
        if ((!h.a(this.b).l()) || (paramBoolean))
          break label327;
        com.xiaomi.a.a.c.c.a("receive a message in pause state. drop it");
        return null;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    }
    catch (org.a.c.f localf)
    {
      com.xiaomi.a.a.c.c.a(localf);
      com.xiaomi.a.a.c.c.d("receive a message which action string is not valid. is the reg expired?");
      return null;
    }
    k localk = (k)localb;
    if (localk.f == 0L)
      h.a(this.b).b(localk.h, localk.i);
    ArrayList localArrayList3;
    if (!TextUtils.isEmpty(localk.h))
    {
      localArrayList3 = new ArrayList();
      localArrayList3.add(localk.h);
    }
    while (true)
    {
      e locale = g.a("register", localArrayList3, localk.f, localk.g, null);
      n.a(this.b).d();
      return locale;
      if (((r)localb).f == 0L)
      {
        h.a(this.b).h();
        d.e(this.b);
      }
      PushMessageHandler.a();
      return null;
      label327: com.xiaomi.f.a.n localn = (com.xiaomi.f.a.n)localb;
      com.xiaomi.f.a.b localb1 = localn.l();
      if (localb1 == null)
      {
        com.xiaomi.a.a.c.c.d("receive an empty message without push content, drop it");
        return null;
      }
      if (paramBoolean)
      {
        if (aj.b(paramh))
          d.a(this.b, localb1.b(), paramh.m(), paramh.f, localb1.d());
      }
      else
      {
        if (!paramBoolean)
        {
          if ((TextUtils.isEmpty(localn.j())) || (d.l(this.b, localn.j()) >= 0L))
            break label574;
          d.d(this.b, localn.j());
        }
        label434: if ((paramh.h == null) || (paramh.h.s() == null))
          break label1589;
      }
      label1589: for (String str3 = (String)paramh.h.j.get("jobkey"); ; str3 = null)
      {
        if (TextUtils.isEmpty(str3));
        for (String str4 = localb1.b(); ; str4 = str3)
        {
          if ((!paramBoolean) && (a(this.b, str4)))
            com.xiaomi.a.a.c.c.a("drop a duplicate message, key=" + str4);
          while (true)
          {
            if ((paramh.m() != null) || (paramBoolean))
              break label1601;
            a(localn, paramh.m());
            return localObject;
            d.a(this.b, localb1.b(), paramh.m(), localb1.d());
            break;
            label574: if ((TextUtils.isEmpty(localn.h())) || (d.j(this.b, localn.h()) >= 0L))
              break label434;
            d.h(this.b, localn.h());
            break label434;
            f localf1 = g.a(localn, paramh.m(), paramBoolean);
            if ((localf1.n() == 0) && (!paramBoolean) && (aj.a(localf1.o())))
            {
              aj.a(this.b, paramh, paramArrayOfByte);
              return null;
            }
            com.xiaomi.a.a.c.c.a("receive a message, msgid=" + localb1.b() + ", jobkey=" + str4);
            if ((paramBoolean) && (localf1.o() != null) && (localf1.o().containsKey("notify_effect")))
            {
              Map localMap2 = localf1.o();
              String str5 = (String)localMap2.get("notify_effect");
              if (aj.b(paramh))
              {
                Intent localIntent2 = a(this.b, paramh.f, localMap2);
                if (localIntent2 == null)
                {
                  com.xiaomi.a.a.c.c.a("Getting Intent fail from ignore reg message. ");
                  return null;
                }
                String str6 = localb1.f();
                if (!TextUtils.isEmpty(str6))
                  localIntent2.putExtra("payload", str6);
                this.b.startActivity(localIntent2);
                return null;
              }
              Intent localIntent1 = a(this.b, this.b.getPackageName(), localMap2);
              localObject = null;
              if (localIntent1 == null)
                break label1601;
              if (!str5.equals(ap.c))
                localIntent1.putExtra("key_message", localf1);
              this.b.startActivity(localIntent1);
              return null;
              p localp = (p)localb;
              if (localp.f == 0L)
                d.h(this.b, localp.h());
              ArrayList localArrayList2;
              if (!TextUtils.isEmpty(localp.h()))
              {
                localArrayList2 = new ArrayList();
                localArrayList2.add(localp.h());
              }
              while (true)
              {
                return g.a("subscribe-topic", localArrayList2, localp.f, localp.g, localp.k());
                t localt = (t)localb;
                if (localt.f == 0L)
                  d.i(this.b, localt.h());
                ArrayList localArrayList1;
                if (!TextUtils.isEmpty(localt.h()))
                {
                  localArrayList1 = new ArrayList();
                  localArrayList1.add(localt.h());
                }
                while (true)
                {
                  return g.a("unsubscibe-topic", localArrayList1, localt.f, localt.g, localt.k());
                  com.xiaomi.f.a.g localg = (com.xiaomi.f.a.g)localb;
                  String str2 = localg.e();
                  List localList1 = localg.k();
                  List localList2;
                  if (localg.g == 0L)
                    if ((TextUtils.equals(str2, "accept-time")) && (localList1 != null) && (localList1.size() > 1))
                    {
                      d.h(this.b, (String)localList1.get(0), (String)localList1.get(1));
                      if (("00:00".equals(localList1.get(0))) && ("00:00".equals(localList1.get(1))))
                      {
                        h.a(this.b).a(true);
                        localList2 = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), localList1);
                      }
                    }
                  while (true)
                  {
                    return g.a(str2, localList2, localg.g, localg.h, localg.m());
                    h.a(this.b).a(false);
                    break;
                    if ((TextUtils.equals(str2, "set-alias")) && (localList1 != null) && (localList1.size() > 0))
                    {
                      d.d(this.b, (String)localList1.get(0));
                      localList2 = localList1;
                      continue;
                    }
                    if ((TextUtils.equals(str2, "unset-alias")) && (localList1 != null) && (localList1.size() > 0))
                    {
                      d.e(this.b, (String)localList1.get(0));
                      localList2 = localList1;
                      continue;
                    }
                    if ((TextUtils.equals(str2, "set-account")) && (localList1 != null) && (localList1.size() > 0))
                    {
                      d.f(this.b, (String)localList1.get(0));
                      localList2 = localList1;
                      continue;
                    }
                    if ((TextUtils.equals(str2, "unset-account")) && (localList1 != null) && (localList1.size() > 0))
                      d.g(this.b, (String)localList1.get(0));
                    localList2 = localList1;
                  }
                  i locali = (i)localb;
                  if ("registration id expired".equalsIgnoreCase(locali.e))
                  {
                    d.f(this.b);
                    return null;
                  }
                  boolean bool1 = "client_info_update_ok".equalsIgnoreCase(locali.e);
                  localObject = null;
                  if (!bool1)
                    break;
                  Map localMap1 = locali.h();
                  localObject = null;
                  if (localMap1 == null)
                    break;
                  boolean bool2 = locali.h().containsKey("app_version");
                  localObject = null;
                  if (!bool2)
                    break;
                  String str1 = (String)locali.h().get("app_version");
                  h.a(this.b).a(str1);
                  return null;
                  localArrayList1 = null;
                }
                localArrayList2 = null;
              }
            }
            localObject = localf1;
          }
        }
      }
      localArrayList3 = null;
    }
    label1601: return localObject;
  }

  private PushMessageHandler.a a(com.xiaomi.f.a.h paramh, byte[] paramArrayOfByte)
  {
    com.xiaomi.f.a.n localn;
    com.xiaomi.f.a.b localb1;
    try
    {
      org.a.c.b localb = l.a(this.b, paramh);
      if (localb == null)
      {
        com.xiaomi.a.a.c.c.d("message arrived: receiving an un-recognized message. " + paramh.a);
        return null;
      }
      com.xiaomi.a.a.c.c.c("message arrived: receive a message." + localb);
      a locala = paramh.a();
      com.xiaomi.a.a.c.c.a("message arrived: processing an arrived message, action=" + locala);
      switch (1.a[locala.ordinal()])
      {
      default:
        return null;
      case 1:
      }
      localn = (com.xiaomi.f.a.n)localb;
      localb1 = localn.l();
      if (localb1 == null)
      {
        com.xiaomi.a.a.c.c.d("message arrived: receive an empty message without push content, drop it");
        return null;
      }
    }
    catch (org.a.c.f localf)
    {
      com.xiaomi.a.a.c.c.a(localf);
      com.xiaomi.a.a.c.c.d("message arrived: receive a message which action string is not valid. is the reg expired?");
      return null;
    }
    com.xiaomi.f.a.c localc = paramh.h;
    String str = null;
    if (localc != null)
    {
      Map localMap = paramh.h.s();
      str = null;
      if (localMap != null)
        str = (String)paramh.h.j.get("jobkey");
    }
    f localf1 = g.a(localn, paramh.m(), false);
    localf1.a(true);
    com.xiaomi.a.a.c.c.a("message arrived: receive a message, msgid=" + localb1.b() + ", jobkey=" + str);
    return localf1;
  }

  public static m a(Context paramContext)
  {
    if (a == null)
      a = new m(paramContext);
    return a;
  }

  private void a(com.xiaomi.f.a.h paramh)
  {
    com.xiaomi.f.a.c localc = paramh.m();
    com.xiaomi.f.a.e locale = new com.xiaomi.f.a.e();
    locale.b(paramh.h());
    locale.a(localc.b());
    locale.a(localc.d());
    if (!TextUtils.isEmpty(localc.f()))
      locale.c(localc.f());
    n.a(this.b).a(locale, a.f, false, paramh.m());
  }

  private void a(com.xiaomi.f.a.n paramn, com.xiaomi.f.a.c paramc)
  {
    com.xiaomi.f.a.e locale = new com.xiaomi.f.a.e();
    locale.b(paramn.e());
    locale.a(paramn.c());
    locale.a(paramn.l().h());
    if (!TextUtils.isEmpty(paramn.h()))
      locale.c(paramn.h());
    if (!TextUtils.isEmpty(paramn.j()))
      locale.d(paramn.j());
    n.a(this.b).a(locale, a.f, paramc);
  }

  private static boolean a(Context paramContext, String paramString)
  {
    synchronized (d)
    {
      SharedPreferences localSharedPreferences = h.a(paramContext).j();
      if (c == null)
      {
        String[] arrayOfString = localSharedPreferences.getString("pref_msg_ids", "").split(",");
        c = new LinkedList();
        int i = arrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          String str2 = arrayOfString[j];
          c.add(str2);
        }
      }
      if (c.contains(paramString))
        return true;
      c.add(paramString);
      if (c.size() > 10)
        c.poll();
      String str1 = com.xiaomi.a.a.g.d.a(c, ",");
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      localEditor.putString("pref_msg_ids", str1);
      localEditor.commit();
      return false;
    }
  }

  public PushMessageHandler.a a(Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    com.xiaomi.a.a.c.c.a("receive an intent from server, action=" + str1);
    String str2 = paramIntent.getStringExtra("mrt");
    if (str2 == null)
      str2 = Long.toString(System.currentTimeMillis());
    byte[] arrayOfByte3;
    boolean bool;
    com.xiaomi.f.a.h localh4;
    if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(str1))
    {
      arrayOfByte3 = paramIntent.getByteArrayExtra("mipush_payload");
      bool = paramIntent.getBooleanExtra("mipush_notified", false);
      if (arrayOfByte3 == null)
      {
        com.xiaomi.a.a.c.c.d("receiving an empty message, drop");
        return null;
      }
      localh4 = new com.xiaomi.f.a.h();
    }
    while (true)
    {
      try
      {
        u.a(localh4, arrayOfByte3);
        h localh5 = h.a(this.b);
        com.xiaomi.f.a.c localc = localh4.m();
        if ((localh4.a() != a.e) || (localc == null) || (localh5.l()) || (bool))
          continue;
        if (localc == null)
          continue;
        localh4.m().a("mrt", str2);
        localh4.m().a("mat", Long.toString(System.currentTimeMillis()));
        a(localh4);
        if ((localh4.a() != a.e) || (localh4.c()))
          continue;
        if (aj.b(localh4))
          continue;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = localh4.j();
        if (localc == null)
          break label762;
        str3 = localc.b();
        arrayOfObject2[1] = str3;
        com.xiaomi.a.a.c.c.a(String.format("drop an un-encrypted messages. %1$s, %2$s", arrayOfObject2));
        return null;
        if ((!bool) || (localc.s() == null) || (!localc.s().containsKey("notify_effect")))
          continue;
        if ((localh5.i()) || (localh4.a == a.a))
          continue;
        if (aj.b(localh4))
        {
          return a(localh4, bool, arrayOfByte3);
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = localh4.j();
          arrayOfObject1[1] = localc.b();
          com.xiaomi.a.a.c.c.a(String.format("drop an un-encrypted messages. %1$s, %2$s", arrayOfObject1));
          return null;
        }
        com.xiaomi.a.a.c.c.d("receive message without registration. need unregister or re-register!");
        break;
        if ((localh5.i()) && (localh5.n()))
        {
          if (localh4.a != a.b)
            continue;
          localh5.h();
          d.e(this.b);
          PushMessageHandler.a();
        }
      }
      catch (org.a.c.f localf3)
      {
        com.xiaomi.a.a.c.c.a(localf3);
        break;
        d.h(this.b);
      }
      catch (Exception localException2)
      {
        com.xiaomi.a.a.c.c.a(localException2);
      }
      PushMessageHandler.a locala2 = a(localh4, bool, arrayOfByte3);
      return locala2;
      e locale;
      com.xiaomi.f.a.h localh1;
      if ("com.xiaomi.mipush.ERROR".equals(str1))
      {
        locale = new e();
        localh1 = new com.xiaomi.f.a.h();
      }
      try
      {
        byte[] arrayOfByte1 = paramIntent.getByteArrayExtra("mipush_payload");
        if (arrayOfByte1 != null)
          u.a(localh1, arrayOfByte1);
        label514: locale.a(String.valueOf(localh1.a()));
        locale.a(paramIntent.getIntExtra("mipush_error_code", 0));
        locale.b(paramIntent.getStringExtra("mipush_error_msg"));
        com.xiaomi.a.a.c.c.d("receive a error message. code = " + paramIntent.getIntExtra("mipush_error_code", 0) + ", msg= " + paramIntent.getStringExtra("mipush_error_msg"));
        return locale;
        if (!"com.xiaomi.mipush.MESSAGE_ARRIVED".equals(str1))
          break;
        byte[] arrayOfByte2 = paramIntent.getByteArrayExtra("mipush_payload");
        if (arrayOfByte2 == null)
        {
          com.xiaomi.a.a.c.c.d("message arrived: receiving an empty message, drop");
          return null;
        }
        com.xiaomi.f.a.h localh2 = new com.xiaomi.f.a.h();
        h localh3;
        try
        {
          u.a(localh2, arrayOfByte2);
          localh3 = h.a(this.b);
          localh2.m();
          if (!localh3.i())
            if (aj.b(localh2))
              com.xiaomi.a.a.c.c.d("message arrived: receive ignore reg message invalid!");
        }
        catch (org.a.c.f localf2)
        {
          com.xiaomi.a.a.c.c.a(localf2);
          break;
          com.xiaomi.a.a.c.c.d("message arrived: receive message without registration. need unregister or re-register!");
        }
        catch (Exception localException1)
        {
          com.xiaomi.a.a.c.c.a(localException1);
        }
        if ((localh3.i()) && (localh3.n()))
        {
          com.xiaomi.a.a.c.c.d("message arrived: app info is invalidated");
          break;
        }
        PushMessageHandler.a locala1 = a(localh2, arrayOfByte2);
        return locala1;
      }
      catch (org.a.c.f localf1)
      {
        break label514;
      }
      label762: String str3 = "";
    }
    return null;
  }

  public List<String> a(TimeZone paramTimeZone1, TimeZone paramTimeZone2, List<String> paramList)
  {
    if (paramTimeZone1.equals(paramTimeZone2))
      return paramList;
    long l1 = (paramTimeZone1.getRawOffset() - paramTimeZone2.getRawOffset()) / 1000 / 60;
    long l2 = Long.parseLong(((String)paramList.get(0)).split(":")[0]);
    long l3 = Long.parseLong(((String)paramList.get(0)).split(":")[1]);
    long l4 = Long.parseLong(((String)paramList.get(1)).split(":")[0]);
    long l5 = Long.parseLong(((String)paramList.get(1)).split(":")[1]);
    long l6 = (1440L + (l3 + l2 * 60L - l1)) % 1440L;
    long l7 = (1440L + (l5 + 60L * l4 - l1)) % 1440L;
    ArrayList localArrayList = new ArrayList();
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Long.valueOf(l6 / 60L);
    arrayOfObject1[1] = Long.valueOf(l6 % 60L);
    localArrayList.add(String.format("%1$02d:%2$02d", arrayOfObject1));
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = Long.valueOf(l7 / 60L);
    arrayOfObject2[1] = Long.valueOf(l7 % 60L);
    localArrayList.add(String.format("%1$02d:%2$02d", arrayOfObject2));
    return localArrayList;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.m
 * JD-Core Version:    0.6.0
 */