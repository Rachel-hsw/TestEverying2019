package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.data.e;
import com.alipay.sdk.protocol.c;
import com.alipay.sdk.util.h;
import com.alipay.sdk.util.k;
import org.json.JSONObject;

public class PayTask
{
  static final Object a = h.class;
  private Activity b;
  private com.alipay.sdk.widget.a c = null;

  public PayTask(Activity paramActivity)
  {
    this.b = paramActivity;
  }

  private String a(com.alipay.sdk.protocol.a parama)
  {
    String[] arrayOfString = com.alipay.sdk.util.a.a(parama.e());
    Intent localIntent = new Intent(this.b, H5PayActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("url", arrayOfString[0]);
    if (arrayOfString.length == 2)
      localBundle.putString("cookie", arrayOfString[1]);
    localIntent.putExtras(localBundle);
    this.b.startActivity(localIntent);
    synchronized (a)
    {
      try
      {
        a.wait();
        String str2 = l.a;
        if (TextUtils.isEmpty(str2))
          str2 = l.a();
        return str2;
      }
      catch (InterruptedException localInterruptedException)
      {
        String str1 = l.a();
        return str1;
      }
    }
  }

  private String a(String paramString)
  {
    return new h(this.b).a(paramString);
  }

  private String b(String paramString)
  {
    try
    {
      if ((this.b != null) && (!this.b.isFinishing()))
      {
        this.c = new com.alipay.sdk.widget.a(this.b);
        this.c.b();
        com.alipay.sdk.sys.b.a().a(this.b, com.alipay.sdk.data.d.a());
      }
      return c(paramString);
    }
    catch (Exception localException)
    {
      while (true)
        this.c = null;
    }
  }

  // ERROR //
  private String c(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 117	com/alipay/sdk/data/c
    //   5: dup
    //   6: invokespecial 118	com/alipay/sdk/data/c:<init>	()V
    //   9: aload_1
    //   10: new 120	org/json/JSONObject
    //   13: dup
    //   14: invokespecial 121	org/json/JSONObject:<init>	()V
    //   17: invokestatic 126	com/alipay/sdk/data/b:a	(Lcom/alipay/sdk/data/c;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/alipay/sdk/data/e;
    //   20: astore_3
    //   21: new 128	com/alipay/sdk/net/d
    //   24: dup
    //   25: new 117	com/alipay/sdk/data/c
    //   28: dup
    //   29: invokespecial 118	com/alipay/sdk/data/c:<init>	()V
    //   32: invokespecial 131	com/alipay/sdk/net/d:<init>	(Lcom/alipay/sdk/data/c;)V
    //   35: astore 4
    //   37: aload 4
    //   39: aload_0
    //   40: getfield 24	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   43: aload_3
    //   44: iconst_0
    //   45: invokevirtual 134	com/alipay/sdk/net/d:a	(Landroid/content/Context;Lcom/alipay/sdk/data/e;Z)Lcom/alipay/sdk/protocol/c;
    //   48: getfield 139	com/alipay/sdk/protocol/c:c	Lorg/json/JSONObject;
    //   51: ldc 141
    //   53: invokevirtual 145	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   56: ldc 147
    //   58: invokestatic 152	com/alipay/sdk/protocol/b:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/alipay/sdk/protocol/b;
    //   61: invokestatic 155	com/alipay/sdk/protocol/a:a	(Lcom/alipay/sdk/protocol/b;)[Lcom/alipay/sdk/protocol/a;
    //   64: astore 11
    //   66: aload 11
    //   68: arraylength
    //   69: istore 12
    //   71: iconst_0
    //   72: istore 13
    //   74: iload 13
    //   76: iload 12
    //   78: if_icmpge +279 -> 357
    //   81: aload 11
    //   83: iload 13
    //   85: aaload
    //   86: astore 14
    //   88: aload 14
    //   90: getstatic 159	com/alipay/sdk/protocol/a:f	Lcom/alipay/sdk/protocol/a;
    //   93: if_acmpne +364 -> 457
    //   96: aload 14
    //   98: invokevirtual 33	com/alipay/sdk/protocol/a:e	()Ljava/lang/String;
    //   101: invokestatic 38	com/alipay/sdk/util/a:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   104: astore 15
    //   106: aload 15
    //   108: arraylength
    //   109: iconst_3
    //   110: if_icmpne +347 -> 457
    //   113: ldc 161
    //   115: aload 15
    //   117: iconst_0
    //   118: aaload
    //   119: invokestatic 165	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   122: ifeq +335 -> 457
    //   125: invokestatic 103	com/alipay/sdk/sys/b:a	()Lcom/alipay/sdk/sys/b;
    //   128: getfield 168	com/alipay/sdk/sys/b:a	Landroid/content/Context;
    //   131: astore 16
    //   133: invokestatic 173	com/alipay/sdk/tid/b:a	()Lcom/alipay/sdk/tid/b;
    //   136: astore 17
    //   138: aload 15
    //   140: iconst_1
    //   141: aaload
    //   142: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +312 -> 457
    //   148: aload 15
    //   150: iconst_2
    //   151: aaload
    //   152: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifeq +6 -> 161
    //   158: goto +299 -> 457
    //   161: aload 17
    //   163: aload 15
    //   165: iconst_1
    //   166: aaload
    //   167: putfield 174	com/alipay/sdk/tid/b:a	Ljava/lang/String;
    //   170: aload 17
    //   172: aload 15
    //   174: iconst_2
    //   175: aaload
    //   176: putfield 176	com/alipay/sdk/tid/b:b	Ljava/lang/String;
    //   179: new 178	com/alipay/sdk/tid/a
    //   182: dup
    //   183: aload 16
    //   185: invokespecial 181	com/alipay/sdk/tid/a:<init>	(Landroid/content/Context;)V
    //   188: astore 18
    //   190: aload 18
    //   192: aload 16
    //   194: invokestatic 186	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   197: invokevirtual 187	com/alipay/sdk/util/b:a	()Ljava/lang/String;
    //   200: aload 16
    //   202: invokestatic 186	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   205: invokevirtual 189	com/alipay/sdk/util/b:b	()Ljava/lang/String;
    //   208: aload 17
    //   210: getfield 174	com/alipay/sdk/tid/b:a	Ljava/lang/String;
    //   213: aload 17
    //   215: getfield 176	com/alipay/sdk/tid/b:b	Ljava/lang/String;
    //   218: invokevirtual 192	com/alipay/sdk/tid/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload 18
    //   223: invokevirtual 195	com/alipay/sdk/tid/a:close	()V
    //   226: goto +231 -> 457
    //   229: astore 9
    //   231: getstatic 201	com/alipay/sdk/app/m:d	Lcom/alipay/sdk/app/m;
    //   234: invokevirtual 204	com/alipay/sdk/app/m:a	()I
    //   237: invokestatic 207	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   240: astore 10
    //   242: aload 10
    //   244: astore 7
    //   246: aload_0
    //   247: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   250: ifnull +10 -> 260
    //   253: aload_0
    //   254: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   257: invokevirtual 209	com/alipay/sdk/widget/a:c	()V
    //   260: aload 7
    //   262: ifnonnull +14 -> 276
    //   265: getstatic 211	com/alipay/sdk/app/m:b	Lcom/alipay/sdk/app/m;
    //   268: invokevirtual 204	com/alipay/sdk/app/m:a	()I
    //   271: invokestatic 207	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   274: astore 7
    //   276: aload 7
    //   278: invokevirtual 204	com/alipay/sdk/app/m:a	()I
    //   281: aload 7
    //   283: invokevirtual 212	com/alipay/sdk/app/m:b	()Ljava/lang/String;
    //   286: ldc 214
    //   288: invokestatic 217	com/alipay/sdk/app/l:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   291: astore 8
    //   293: aload 8
    //   295: areturn
    //   296: astore 20
    //   298: aload 18
    //   300: invokevirtual 195	com/alipay/sdk/tid/a:close	()V
    //   303: goto +154 -> 457
    //   306: astore 6
    //   308: aload_0
    //   309: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   312: ifnull +139 -> 451
    //   315: aload_0
    //   316: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   319: invokevirtual 209	com/alipay/sdk/widget/a:c	()V
    //   322: aconst_null
    //   323: astore 7
    //   325: goto -65 -> 260
    //   328: astore 19
    //   330: aload 18
    //   332: invokevirtual 195	com/alipay/sdk/tid/a:close	()V
    //   335: aload 19
    //   337: athrow
    //   338: astore 5
    //   340: aload_0
    //   341: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   344: ifnull +10 -> 354
    //   347: aload_0
    //   348: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   351: invokevirtual 209	com/alipay/sdk/widget/a:c	()V
    //   354: aload 5
    //   356: athrow
    //   357: aload_0
    //   358: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   361: ifnull +10 -> 371
    //   364: aload_0
    //   365: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   368: invokevirtual 209	com/alipay/sdk/widget/a:c	()V
    //   371: aload 11
    //   373: arraylength
    //   374: istore 21
    //   376: iload_2
    //   377: iload 21
    //   379: if_icmpge +52 -> 431
    //   382: aload 11
    //   384: iload_2
    //   385: aaload
    //   386: astore 22
    //   388: aload 22
    //   390: getstatic 219	com/alipay/sdk/protocol/a:a	Lcom/alipay/sdk/protocol/a;
    //   393: if_acmpne +32 -> 425
    //   396: aload_0
    //   397: aload 22
    //   399: invokespecial 221	com/alipay/sdk/app/PayTask:a	(Lcom/alipay/sdk/protocol/a;)Ljava/lang/String;
    //   402: astore 23
    //   404: aload 23
    //   406: astore 8
    //   408: aload_0
    //   409: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   412: ifnull -119 -> 293
    //   415: aload_0
    //   416: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   419: invokevirtual 209	com/alipay/sdk/widget/a:c	()V
    //   422: aload 8
    //   424: areturn
    //   425: iinc 2 1
    //   428: goto -52 -> 376
    //   431: aload_0
    //   432: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   435: ifnull +16 -> 451
    //   438: aload_0
    //   439: getfield 22	com/alipay/sdk/app/PayTask:c	Lcom/alipay/sdk/widget/a;
    //   442: invokevirtual 209	com/alipay/sdk/widget/a:c	()V
    //   445: aconst_null
    //   446: astore 7
    //   448: goto -188 -> 260
    //   451: aconst_null
    //   452: astore 7
    //   454: goto -194 -> 260
    //   457: iinc 13 1
    //   460: goto -386 -> 74
    //
    // Exception table:
    //   from	to	target	type
    //   37	71	229	com/alipay/sdk/exception/NetErrorException
    //   81	158	229	com/alipay/sdk/exception/NetErrorException
    //   161	190	229	com/alipay/sdk/exception/NetErrorException
    //   221	226	229	com/alipay/sdk/exception/NetErrorException
    //   298	303	229	com/alipay/sdk/exception/NetErrorException
    //   330	338	229	com/alipay/sdk/exception/NetErrorException
    //   357	371	229	com/alipay/sdk/exception/NetErrorException
    //   371	376	229	com/alipay/sdk/exception/NetErrorException
    //   382	404	229	com/alipay/sdk/exception/NetErrorException
    //   190	221	296	java/lang/Exception
    //   37	71	306	java/lang/Exception
    //   81	158	306	java/lang/Exception
    //   161	190	306	java/lang/Exception
    //   221	226	306	java/lang/Exception
    //   298	303	306	java/lang/Exception
    //   330	338	306	java/lang/Exception
    //   357	371	306	java/lang/Exception
    //   371	376	306	java/lang/Exception
    //   382	404	306	java/lang/Exception
    //   190	221	328	finally
    //   37	71	338	finally
    //   81	158	338	finally
    //   161	190	338	finally
    //   221	226	338	finally
    //   231	242	338	finally
    //   298	303	338	finally
    //   330	338	338	finally
    //   357	371	338	finally
    //   371	376	338	finally
    //   382	404	338	finally
  }

  public boolean checkAccountIfExist()
  {
    e locale = com.alipay.sdk.data.b.a();
    try
    {
      boolean bool = new com.alipay.sdk.net.d().a(this.b, locale, true).c.optBoolean("hasAccount", false);
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public String getVersion()
  {
    return "15.0.0";
  }

  public String pay(String paramString)
  {
    monitorenter;
    try
    {
      if (!paramString.contains("bizcontext="))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("&bizcontext=\"");
        localStringBuilder.append(new com.alipay.sdk.sys.a(this.b).toString());
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
      }
      Object localObject2;
      if (paramString.contains("paymethod=\"expressGateway\""))
      {
        String str2 = b(paramString);
        localObject2 = str2;
      }
      while (true)
      {
        return localObject2;
        if (k.b(this.b))
        {
          localObject2 = new h(this.b).a(paramString);
          if (TextUtils.equals((CharSequence)localObject2, "failed"))
          {
            localObject2 = b(paramString);
            continue;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject2))
            continue;
          localObject2 = l.a();
          continue;
        }
        String str1 = b(paramString);
        localObject2 = str1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.app.PayTask
 * JD-Core Version:    0.6.0
 */