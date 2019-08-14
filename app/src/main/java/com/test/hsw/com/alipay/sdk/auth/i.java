package com.alipay.sdk.auth;

import android.app.Activity;
import com.alipay.sdk.data.e;
import com.alipay.sdk.net.d;

final class i
  implements Runnable
{
  i(d paramd, Activity paramActivity, e parame, APAuthInfo paramAPAuthInfo)
  {
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 18	com/alipay/sdk/auth/i:a	Lcom/alipay/sdk/net/d;
    //   6: aload_0
    //   7: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   10: aload_0
    //   11: getfield 22	com/alipay/sdk/auth/i:c	Lcom/alipay/sdk/data/e;
    //   14: iconst_0
    //   15: invokevirtual 37	com/alipay/sdk/net/d:a	(Landroid/content/Context;Lcom/alipay/sdk/data/e;Z)Lcom/alipay/sdk/protocol/c;
    //   18: astore 16
    //   20: aload 16
    //   22: astore_3
    //   23: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   26: ifnull +13 -> 39
    //   29: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   32: invokevirtual 46	com/alipay/sdk/widget/a:c	()V
    //   35: invokestatic 48	com/alipay/sdk/auth/h:b	()Lcom/alipay/sdk/widget/a;
    //   38: pop
    //   39: aload_3
    //   40: ifnonnull +55 -> 95
    //   43: new 50	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   50: aload_0
    //   51: getfield 24	com/alipay/sdk/auth/i:d	Lcom/alipay/sdk/auth/APAuthInfo;
    //   54: invokevirtual 57	com/alipay/sdk/auth/APAuthInfo:getRedirectUri	()Ljava/lang/String;
    //   57: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 63
    //   62: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 69	com/alipay/sdk/auth/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: pop
    //   72: aload_0
    //   73: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   76: invokestatic 71	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   79: invokestatic 74	com/alipay/sdk/auth/h:a	(Landroid/app/Activity;Ljava/lang/String;)V
    //   82: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   85: ifnull +9 -> 94
    //   88: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   91: invokevirtual 46	com/alipay/sdk/widget/a:c	()V
    //   94: return
    //   95: aload_3
    //   96: getfield 79	com/alipay/sdk/protocol/c:c	Lorg/json/JSONObject;
    //   99: ldc 81
    //   101: invokevirtual 87	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   104: ldc 89
    //   106: invokestatic 94	com/alipay/sdk/protocol/b:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/alipay/sdk/protocol/b;
    //   109: invokestatic 99	com/alipay/sdk/protocol/a:a	(Lcom/alipay/sdk/protocol/b;)[Lcom/alipay/sdk/protocol/a;
    //   112: astore 7
    //   114: aload 7
    //   116: arraylength
    //   117: istore 8
    //   119: iload_1
    //   120: iload 8
    //   122: if_icmpge +31 -> 153
    //   125: aload 7
    //   127: iload_1
    //   128: aaload
    //   129: astore 9
    //   131: aload 9
    //   133: getstatic 102	com/alipay/sdk/protocol/a:a	Lcom/alipay/sdk/protocol/a;
    //   136: if_acmpne +78 -> 214
    //   139: aload 9
    //   141: invokevirtual 105	com/alipay/sdk/protocol/a:e	()Ljava/lang/String;
    //   144: invokestatic 110	com/alipay/sdk/util/a:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   147: iconst_0
    //   148: aaload
    //   149: invokestatic 69	com/alipay/sdk/auth/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   152: pop
    //   153: invokestatic 71	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   156: invokestatic 116	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   159: ifeq +61 -> 220
    //   162: new 50	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   169: aload_0
    //   170: getfield 24	com/alipay/sdk/auth/i:d	Lcom/alipay/sdk/auth/APAuthInfo;
    //   173: invokevirtual 57	com/alipay/sdk/auth/APAuthInfo:getRedirectUri	()Ljava/lang/String;
    //   176: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: ldc 63
    //   181: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 69	com/alipay/sdk/auth/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   190: pop
    //   191: aload_0
    //   192: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   195: invokestatic 71	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   198: invokestatic 74	com/alipay/sdk/auth/h:a	(Landroid/app/Activity;Ljava/lang/String;)V
    //   201: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   204: ifnull -110 -> 94
    //   207: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   210: invokevirtual 46	com/alipay/sdk/widget/a:c	()V
    //   213: return
    //   214: iinc 1 1
    //   217: goto -98 -> 119
    //   220: new 118	android/content/Intent
    //   223: dup
    //   224: aload_0
    //   225: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   228: ldc 120
    //   230: invokespecial 123	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   233: astore 11
    //   235: aload 11
    //   237: ldc 125
    //   239: invokestatic 71	com/alipay/sdk/auth/h:c	()Ljava/lang/String;
    //   242: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   245: pop
    //   246: aload 11
    //   248: ldc 131
    //   250: aload_0
    //   251: getfield 24	com/alipay/sdk/auth/i:d	Lcom/alipay/sdk/auth/APAuthInfo;
    //   254: invokevirtual 57	com/alipay/sdk/auth/APAuthInfo:getRedirectUri	()Ljava/lang/String;
    //   257: invokevirtual 129	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   260: pop
    //   261: aload_0
    //   262: getfield 20	com/alipay/sdk/auth/i:b	Landroid/app/Activity;
    //   265: aload 11
    //   267: invokevirtual 137	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   270: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   273: ifnull -179 -> 94
    //   276: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   279: invokevirtual 46	com/alipay/sdk/widget/a:c	()V
    //   282: return
    //   283: astore 5
    //   285: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   288: ifnull -194 -> 94
    //   291: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   294: invokevirtual 46	com/alipay/sdk/widget/a:c	()V
    //   297: return
    //   298: astore 4
    //   300: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   303: ifnull +9 -> 312
    //   306: invokestatic 42	com/alipay/sdk/auth/h:a	()Lcom/alipay/sdk/widget/a;
    //   309: invokevirtual 46	com/alipay/sdk/widget/a:c	()V
    //   312: aload 4
    //   314: athrow
    //   315: astore_2
    //   316: aconst_null
    //   317: astore_3
    //   318: goto -295 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   2	20	283	java/lang/Exception
    //   23	39	283	java/lang/Exception
    //   43	82	283	java/lang/Exception
    //   95	119	283	java/lang/Exception
    //   125	153	283	java/lang/Exception
    //   153	201	283	java/lang/Exception
    //   220	270	283	java/lang/Exception
    //   2	20	298	finally
    //   23	39	298	finally
    //   43	82	298	finally
    //   95	119	298	finally
    //   125	153	298	finally
    //   153	201	298	finally
    //   220	270	298	finally
    //   2	20	315	com/alipay/sdk/exception/NetErrorException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.auth.i
 * JD-Core Version:    0.6.0
 */