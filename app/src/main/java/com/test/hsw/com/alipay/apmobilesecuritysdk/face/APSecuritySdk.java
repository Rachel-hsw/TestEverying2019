package com.alipay.apmobilesecuritysdk.face;

import android.annotation.SuppressLint;
import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.b;
import com.taobao.dp.DeviceSecuritySDK;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

@SuppressLint({"NewApi"})
public class APSecuritySdk
{
  private static APSecuritySdk a;
  private static Object b = new Object();
  private Context c;
  private String d;
  private volatile boolean e = false;
  private volatile boolean f = false;
  private Thread g;
  private LinkedList<RunningTask> h = new LinkedList();

  private APSecuritySdk(Context paramContext)
  {
    this.c = paramContext;
  }

  public static APSecuritySdk getInstance(Context paramContext)
  {
    synchronized (b)
    {
      if (a == null)
        a = new APSecuritySdk(paramContext);
      APSecuritySdk localAPSecuritySdk = a;
      return localAPSecuritySdk;
    }
  }

  public static String getUtdid(Context paramContext)
  {
    try
    {
      String str = (String)Class.forName("com.ta.utdid2.device.UTDevice").getMethod("getUtdid", new Class[] { Context.class }).invoke(null, new Object[] { paramContext });
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public TokenResult getTokenResult()
  {
    if (com.alipay.security.mobile.module.a.a.a(this.d))
      this.d = DeviceSecuritySDK.getInstance(this.c).getSecurityToken();
    TokenResult localTokenResult = new TokenResult();
    try
    {
      localTokenResult.apdid = com.alipay.apmobilesecuritysdk.a.a.b(this.c);
      localTokenResult.apdidToken = com.alipay.apmobilesecuritysdk.a.a.a(this.c);
      localTokenResult.umidToken = this.d;
      localTokenResult.clientKey = b.a(this.c);
      return localTokenResult;
    }
    catch (Throwable localThrowable)
    {
    }
    return localTokenResult;
  }

  public void initToken(int paramInt, Map<String, String> paramMap, InitResultListener paramInitResultListener)
  {
    String str1 = com.alipay.security.mobile.module.a.a.a(paramMap, "utdid", "");
    String str2 = com.alipay.security.mobile.module.a.a.a(paramMap, "tid", "");
    String str3 = com.alipay.security.mobile.module.a.a.a(paramMap, "userId", "");
    this.h.addLast(new RunningTask(paramInt, str1, str2, str3, paramInitResultListener));
    if (this.g == null)
    {
      this.g = new Thread(new APSecuritySdk.1(this));
      this.g.setUncaughtExceptionHandler(new APSecuritySdk.2(this));
      this.g.start();
    }
  }

  public static abstract interface InitResultListener
  {
    public abstract void onResult(APSecuritySdk.TokenResult paramTokenResult);
  }

  private class RunningTask
  {
    private int b;
    private String c;
    private String d;
    private String e;
    private APSecuritySdk.InitResultListener f;

    public RunningTask(int paramString1, String paramString2, String paramString3, String paramInitResultListener, APSecuritySdk.InitResultListener arg6)
    {
      this.b = paramString1;
      this.e = paramInitResultListener;
      if (com.alipay.security.mobile.module.a.a.a(paramString2));
      for (this.c = APSecuritySdk.getUtdid(APSecuritySdk.c(APSecuritySdk.this)); ; this.c = paramString2)
      {
        this.d = paramString3;
        Object localObject;
        this.f = localObject;
        return;
      }
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   6: invokestatic 53	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:d	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Z
      //   9: ifeq +4 -> 13
      //   12: return
      //   13: aload_0
      //   14: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   17: iload_1
      //   18: invokestatic 56	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   21: pop
      //   22: aload_0
      //   23: getfield 23	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:b	I
      //   26: tableswitch	default:+26 -> 52, 1:+109->135, 2:+117->143, 3:+125->151
      //   53: astore 179
      //   55: nop
      //   56: istore_3
      //   57: aload_0
      //   58: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   61: iconst_0
      //   62: invokestatic 64	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:b	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   65: pop
      //   66: aload_0
      //   67: getfield 23	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:b	I
      //   70: istore 18
      //   72: iload 18
      //   74: iconst_3
      //   75: if_icmpne +338 -> 413
      //   78: aload_0
      //   79: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   82: invokestatic 35	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   85: invokestatic 70	com/taobao/dp/DeviceSecuritySDK:getInstance	(Landroid/content/Context;)Lcom/taobao/dp/DeviceSecuritySDK;
      //   88: ldc 72
      //   90: iload_1
      //   91: aconst_null
      //   92: new 74	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask$1
      //   95: dup
      //   96: aload_0
      //   97: invokespecial 77	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask$1:<init>	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask;)V
      //   100: invokevirtual 81	com/taobao/dp/DeviceSecuritySDK:initAsync	(Ljava/lang/String;ILcom/taobao/dp/http/IUrlRequestService;Lcom/taobao/dp/client/IInitResultListener;)V
      //   103: sipush 3000
      //   106: istore 19
      //   108: aload_0
      //   109: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   112: invokestatic 83	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:e	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Z
      //   115: ifne +44 -> 159
      //   118: iload 19
      //   120: ifle +39 -> 159
      //   123: ldc2_w 84
      //   126: invokestatic 91	java/lang/Thread:sleep	(J)V
      //   129: iinc 19 246
      //   132: goto -24 -> 108
      //   135: ldc 93
      //   137: putstatic 62	com/alipay/apmobilesecuritysdk/b/a:a	Ljava/lang/String;
      //   140: goto -83 -> 57
      //   143: ldc 58
      //   145: putstatic 62	com/alipay/apmobilesecuritysdk/b/a:a	Ljava/lang/String;
      //   148: goto -91 -> 57
      //   151: ldc 95
      //   153: putstatic 62	com/alipay/apmobilesecuritysdk/b/a:a	Ljava/lang/String;
      //   156: goto -99 -> 57
      //   159: aload_0
      //   160: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   163: invokestatic 35	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   166: invokestatic 70	com/taobao/dp/DeviceSecuritySDK:getInstance	(Landroid/content/Context;)Lcom/taobao/dp/DeviceSecuritySDK;
      //   169: invokevirtual 99	com/taobao/dp/DeviceSecuritySDK:getSecurityToken	()Ljava/lang/String;
      //   172: astore 20
      //   174: aload 20
      //   176: invokestatic 30	com/alipay/security/mobile/module/a/a:a	(Ljava/lang/String;)Z
      //   179: ifne +13 -> 192
      //   182: aload_0
      //   183: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   186: aload 20
      //   188: invokestatic 102	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Ljava/lang/String;)Ljava/lang/String;
      //   191: pop
      //   192: new 104	java/util/HashMap
      //   195: dup
      //   196: invokespecial 105	java/util/HashMap:<init>	()V
      //   199: astore 4
      //   201: aload 4
      //   203: ldc 107
      //   205: ldc 109
      //   207: invokeinterface 115 3 0
      //   212: pop
      //   213: aload 4
      //   215: ldc 117
      //   217: aload_0
      //   218: getfield 43	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:d	Ljava/lang/String;
      //   221: invokeinterface 115 3 0
      //   226: pop
      //   227: aload 4
      //   229: ldc 119
      //   231: aload_0
      //   232: getfield 41	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:c	Ljava/lang/String;
      //   235: invokeinterface 115 3 0
      //   240: pop
      //   241: aload 4
      //   243: ldc 121
      //   245: aload_0
      //   246: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   249: invokestatic 124	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:f	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/String;
      //   252: invokeinterface 115 3 0
      //   257: pop
      //   258: aload 4
      //   260: ldc 126
      //   262: aload_0
      //   263: getfield 25	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:e	Ljava/lang/String;
      //   266: invokeinterface 115 3 0
      //   271: pop
      //   272: aload_0
      //   273: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   276: invokestatic 35	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   279: aload 4
      //   281: invokestatic 132	com/alipay/apmobilesecuritysdk/face/SecureSdk:getApdidToken	(Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;
      //   284: pop
      //   285: aload_0
      //   286: getfield 45	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:f	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;
      //   289: ifnull +84 -> 373
      //   292: new 134	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult
      //   295: dup
      //   296: aload_0
      //   297: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   300: invokespecial 137	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:<init>	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V
      //   303: astore 15
      //   305: aload 15
      //   307: aload_0
      //   308: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   311: invokestatic 35	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   314: invokestatic 141	com/alipay/apmobilesecuritysdk/a/a:b	(Landroid/content/Context;)Ljava/lang/String;
      //   317: putfield 144	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:apdid	Ljava/lang/String;
      //   320: aload 15
      //   322: aload_0
      //   323: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   326: invokestatic 35	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   329: invokestatic 146	com/alipay/apmobilesecuritysdk/a/a:a	(Landroid/content/Context;)Ljava/lang/String;
      //   332: putfield 149	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:apdidToken	Ljava/lang/String;
      //   335: aload 15
      //   337: aload_0
      //   338: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   341: invokestatic 124	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:f	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/String;
      //   344: putfield 152	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:umidToken	Ljava/lang/String;
      //   347: aload 15
      //   349: aload_0
      //   350: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   353: invokestatic 35	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:c	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
      //   356: invokestatic 155	com/alipay/apmobilesecuritysdk/e/b:a	(Landroid/content/Context;)Ljava/lang/String;
      //   359: putfield 158	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult:clientKey	Ljava/lang/String;
      //   362: aload_0
      //   363: getfield 45	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:f	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;
      //   366: aload 15
      //   368: invokeinterface 164 2 0
      //   373: aload_0
      //   374: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   377: iconst_0
      //   378: invokestatic 56	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   381: pop
      //   382: return
      //   383: astore 7
      //   385: aload_0
      //   386: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   389: iconst_0
      //   390: invokestatic 56	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   393: pop
      //   394: return
      //   395: astore 5
      //   397: aload_0
      //   398: getfield 18	com/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask:a	Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
      //   401: iconst_0
      //   402: invokestatic 56	com/alipay/apmobilesecuritysdk/face/APSecuritySdk:a	(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
      //   405: pop
      //   406: aload 5
      //   408: athrow
      //   409: astore_3
      //   410: goto -218 -> 192
      //   413: iload 18
      //   415: istore_1
      //   416: goto -338 -> 78
      //
      // Exception table:
      //   from	to	target	type
      //   57	72	383	java/lang/Throwable
      //   78	103	383	java/lang/Throwable
      //   108	118	383	java/lang/Throwable
      //   123	129	383	java/lang/Throwable
      //   159	192	383	java/lang/Throwable
      //   192	373	383	java/lang/Throwable
      //   57	72	395	finally
      //   78	103	395	finally
      //   108	118	395	finally
      //   123	129	395	finally
      //   159	192	395	finally
      //   192	373	395	finally
      //   57	72	409	java/lang/Exception
      //   78	103	409	java/lang/Exception
      //   108	118	409	java/lang/Exception
      //   123	129	409	java/lang/Exception
      //   159	192	409	java/lang/Exception
    }
  }

  public class TokenResult
  {
    public String apdid;
    public String apdidToken;
    public String clientKey;
    public String umidToken;

    public TokenResult()
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.face.APSecuritySdk
 * JD-Core Version:    0.6.0
 */