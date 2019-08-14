package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.util.h;

public class AuthTask
{
  static final Object a = h.class;
  private static final int b = 73;
  private Activity c;

  public AuthTask(Activity paramActivity)
  {
    this.c = paramActivity;
  }

  private String a(Activity paramActivity, String paramString)
  {
    if (a(paramActivity))
    {
      String str = new h(paramActivity).a(paramString);
      if (TextUtils.equals(str, "failed"))
        str = b(paramActivity, paramString);
      do
        return str;
      while (!TextUtils.isEmpty(str));
      return l.a();
    }
    return b(paramActivity, paramString);
  }

  private String a(com.alipay.sdk.protocol.a parama)
  {
    String[] arrayOfString = com.alipay.sdk.util.a.a(parama.e());
    Bundle localBundle = new Bundle();
    localBundle.putString("url", arrayOfString[0]);
    Intent localIntent = new Intent(this.c, H5AuthActivity.class);
    localIntent.putExtras(localBundle);
    this.c.startActivity(localIntent);
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

  private static boolean a(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
      if (localPackageInfo == null)
        return false;
      int i = localPackageInfo.versionCode;
      if (i >= 73)
        return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  // ERROR //
  private String b(Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull +326 -> 329
    //   6: aload_1
    //   7: invokevirtual 125	android/app/Activity:isFinishing	()Z
    //   10: ifne +319 -> 329
    //   13: new 127	com/alipay/sdk/widget/a
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 128	com/alipay/sdk/widget/a:<init>	(Landroid/app/Activity;)V
    //   21: astore 4
    //   23: aload 4
    //   25: invokevirtual 130	com/alipay/sdk/widget/a:b	()V
    //   28: invokestatic 135	com/alipay/sdk/sys/b:a	()Lcom/alipay/sdk/sys/b;
    //   31: aload_0
    //   32: getfield 23	com/alipay/sdk/app/AuthTask:c	Landroid/app/Activity;
    //   35: invokestatic 140	com/alipay/sdk/data/d:a	()Lcom/alipay/sdk/data/d;
    //   38: invokevirtual 143	com/alipay/sdk/sys/b:a	(Landroid/content/Context;Lcom/alipay/sdk/data/d;)V
    //   41: new 145	com/alipay/sdk/data/c
    //   44: dup
    //   45: invokespecial 146	com/alipay/sdk/data/c:<init>	()V
    //   48: aload_2
    //   49: invokevirtual 151	java/lang/String:toString	()Ljava/lang/String;
    //   52: new 153	org/json/JSONObject
    //   55: dup
    //   56: invokespecial 154	org/json/JSONObject:<init>	()V
    //   59: invokestatic 159	com/alipay/sdk/data/b:a	(Lcom/alipay/sdk/data/c;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/alipay/sdk/data/e;
    //   62: astore 5
    //   64: aload 5
    //   66: getfield 164	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   69: ldc 166
    //   71: putfield 170	com/alipay/sdk/data/a:b	Ljava/lang/String;
    //   74: aload 5
    //   76: getfield 164	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   79: ldc 172
    //   81: putfield 174	com/alipay/sdk/data/a:e	Ljava/lang/String;
    //   84: aload 5
    //   86: getfield 164	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   89: ldc 176
    //   91: putfield 179	com/alipay/sdk/data/a:d	Ljava/lang/String;
    //   94: aload 5
    //   96: getfield 164	com/alipay/sdk/data/e:a	Lcom/alipay/sdk/data/a;
    //   99: ldc 181
    //   101: putfield 183	com/alipay/sdk/data/a:c	Ljava/lang/String;
    //   104: new 185	com/alipay/sdk/net/d
    //   107: dup
    //   108: new 145	com/alipay/sdk/data/c
    //   111: dup
    //   112: invokespecial 146	com/alipay/sdk/data/c:<init>	()V
    //   115: invokespecial 188	com/alipay/sdk/net/d:<init>	(Lcom/alipay/sdk/data/c;)V
    //   118: astore 6
    //   120: aload 6
    //   122: aload_1
    //   123: aload 5
    //   125: iconst_0
    //   126: invokevirtual 191	com/alipay/sdk/net/d:a	(Landroid/content/Context;Lcom/alipay/sdk/data/e;Z)Lcom/alipay/sdk/protocol/c;
    //   129: astore 13
    //   131: aload 4
    //   133: ifnull +11 -> 144
    //   136: aload 4
    //   138: invokevirtual 193	com/alipay/sdk/widget/a:c	()V
    //   141: aconst_null
    //   142: astore 4
    //   144: aload 13
    //   146: getfield 198	com/alipay/sdk/protocol/c:c	Lorg/json/JSONObject;
    //   149: ldc 200
    //   151: invokevirtual 204	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   154: ldc 206
    //   156: invokestatic 211	com/alipay/sdk/protocol/b:a	(Lorg/json/JSONObject;Ljava/lang/String;)Lcom/alipay/sdk/protocol/b;
    //   159: invokestatic 214	com/alipay/sdk/protocol/a:a	(Lcom/alipay/sdk/protocol/b;)[Lcom/alipay/sdk/protocol/a;
    //   162: astore 14
    //   164: aload 14
    //   166: arraylength
    //   167: istore 15
    //   169: iload_3
    //   170: iload 15
    //   172: if_icmpge +42 -> 214
    //   175: aload 14
    //   177: iload_3
    //   178: aaload
    //   179: astore 16
    //   181: aload 16
    //   183: getstatic 217	com/alipay/sdk/protocol/a:a	Lcom/alipay/sdk/protocol/a;
    //   186: if_acmpne +22 -> 208
    //   189: aload_0
    //   190: aload 16
    //   192: invokespecial 219	com/alipay/sdk/app/AuthTask:a	(Lcom/alipay/sdk/protocol/a;)Ljava/lang/String;
    //   195: astore 17
    //   197: aload 17
    //   199: areturn
    //   200: astore 18
    //   202: aconst_null
    //   203: astore 4
    //   205: goto -177 -> 28
    //   208: iinc 3 1
    //   211: goto -42 -> 169
    //   214: aconst_null
    //   215: astore 10
    //   217: aload 10
    //   219: ifnonnull +14 -> 233
    //   222: getstatic 224	com/alipay/sdk/app/m:b	Lcom/alipay/sdk/app/m;
    //   225: invokevirtual 227	com/alipay/sdk/app/m:a	()I
    //   228: invokestatic 230	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   231: astore 10
    //   233: aload 10
    //   235: invokevirtual 227	com/alipay/sdk/app/m:a	()I
    //   238: aload 10
    //   240: invokevirtual 232	com/alipay/sdk/app/m:b	()Ljava/lang/String;
    //   243: ldc 234
    //   245: invokestatic 237	com/alipay/sdk/app/l:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   248: areturn
    //   249: astore 11
    //   251: getstatic 239	com/alipay/sdk/app/m:d	Lcom/alipay/sdk/app/m;
    //   254: invokevirtual 227	com/alipay/sdk/app/m:a	()I
    //   257: invokestatic 230	com/alipay/sdk/app/m:a	(I)Lcom/alipay/sdk/app/m;
    //   260: astore 12
    //   262: aload 4
    //   264: ifnull +58 -> 322
    //   267: aload 4
    //   269: invokevirtual 193	com/alipay/sdk/widget/a:c	()V
    //   272: aload 12
    //   274: astore 10
    //   276: goto -59 -> 217
    //   279: astore 9
    //   281: aload 4
    //   283: ifnull +33 -> 316
    //   286: aload 4
    //   288: invokevirtual 193	com/alipay/sdk/widget/a:c	()V
    //   291: aconst_null
    //   292: astore 10
    //   294: goto -77 -> 217
    //   297: astore 7
    //   299: aload 4
    //   301: astore 8
    //   303: aload 8
    //   305: ifnull +8 -> 313
    //   308: aload 8
    //   310: invokevirtual 193	com/alipay/sdk/widget/a:c	()V
    //   313: aload 7
    //   315: athrow
    //   316: aconst_null
    //   317: astore 10
    //   319: goto -102 -> 217
    //   322: aload 12
    //   324: astore 10
    //   326: goto -109 -> 217
    //   329: aconst_null
    //   330: astore 4
    //   332: goto -304 -> 28
    //
    // Exception table:
    //   from	to	target	type
    //   6	28	200	java/lang/Exception
    //   120	131	249	com/alipay/sdk/exception/NetErrorException
    //   136	141	249	com/alipay/sdk/exception/NetErrorException
    //   144	169	249	com/alipay/sdk/exception/NetErrorException
    //   175	197	249	com/alipay/sdk/exception/NetErrorException
    //   120	131	279	java/lang/Exception
    //   136	141	279	java/lang/Exception
    //   144	169	279	java/lang/Exception
    //   175	197	279	java/lang/Exception
    //   120	131	297	finally
    //   136	141	297	finally
    //   144	169	297	finally
    //   175	197	297	finally
    //   251	262	297	finally
  }

  public String auth(String paramString)
  {
    monitorenter;
    try
    {
      if (!paramString.contains("bizcontext="))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("&bizcontext=\"");
        localStringBuilder.append(new com.alipay.sdk.sys.a(this.c).toString());
        localStringBuilder.append("\"");
        paramString = localStringBuilder.toString();
      }
      Activity localActivity = this.c;
      String str2;
      if (a(localActivity))
      {
        localObject2 = new h(localActivity).a(paramString);
        if (!TextUtils.equals((CharSequence)localObject2, "failed"))
          if (TextUtils.isEmpty((CharSequence)localObject2))
            str2 = l.a();
      }
      String str1;
      for (Object localObject2 = str2; ; localObject2 = str1)
      {
        return localObject2;
        str1 = b(localActivity, paramString);
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
 * Qualified Name:     com.alipay.sdk.app.AuthTask
 * JD-Core Version:    0.6.0
 */