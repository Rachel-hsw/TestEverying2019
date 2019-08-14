package com.alipay.sdk.tid;

import android.content.Context;
import android.text.TextUtils;

public final class b
{
  private static b c;
  public String a;
  public String b;

  public static b a()
  {
    monitorenter;
    try
    {
      if (c == null)
      {
        c = new b();
        Context localContext = com.alipay.sdk.sys.b.a().a;
        a locala = new a(localContext);
        String str1 = com.alipay.sdk.util.b.a(localContext).a();
        String str2 = com.alipay.sdk.util.b.a(localContext).b();
        c.a = locala.b(str1, str2);
        c.b = locala.c(str1, str2);
        if (TextUtils.isEmpty(c.b))
        {
          b localb2 = c;
          String str3 = Long.toHexString(System.currentTimeMillis());
          if (str3.length() > 10)
            str3 = str3.substring(-10 + str3.length());
          localb2.b = str3;
        }
        locala.a(str1, str2, c.a, c.b);
      }
      b localb1 = c;
      return localb1;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  // ERROR //
  private void a(Context paramContext)
  {
    // Byte code:
    //   0: new 27	com/alipay/sdk/tid/a
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 30	com/alipay/sdk/tid/a:<init>	(Landroid/content/Context;)V
    //   8: astore_2
    //   9: aload_2
    //   10: aload_1
    //   11: invokestatic 35	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   14: invokevirtual 38	com/alipay/sdk/util/b:a	()Ljava/lang/String;
    //   17: aload_1
    //   18: invokestatic 35	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   21: invokevirtual 40	com/alipay/sdk/util/b:b	()Ljava/lang/String;
    //   24: aload_0
    //   25: getfield 45	com/alipay/sdk/tid/b:a	Ljava/lang/String;
    //   28: aload_0
    //   29: getfield 49	com/alipay/sdk/tid/b:b	Ljava/lang/String;
    //   32: invokevirtual 80	com/alipay/sdk/tid/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_2
    //   36: invokevirtual 85	com/alipay/sdk/tid/a:close	()V
    //   39: return
    //   40: astore 4
    //   42: aload_2
    //   43: invokevirtual 85	com/alipay/sdk/tid/a:close	()V
    //   46: return
    //   47: astore_3
    //   48: aload_2
    //   49: invokevirtual 85	com/alipay/sdk/tid/a:close	()V
    //   52: aload_3
    //   53: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   9	35	40	java/lang/Exception
    //   9	35	47	finally
  }

  private void a(String paramString)
  {
    this.a = paramString;
  }

  private String b()
  {
    return this.a;
  }

  private void b(String paramString)
  {
    this.b = paramString;
  }

  private String c()
  {
    return this.b;
  }

  private boolean d()
  {
    return TextUtils.isEmpty(this.a);
  }

  private static void e()
  {
    Context localContext = com.alipay.sdk.sys.b.a().a;
    String str1 = com.alipay.sdk.util.b.a(localContext).a();
    String str2 = com.alipay.sdk.util.b.a(localContext).b();
    a locala = new a(localContext);
    locala.a(str1, str2);
    locala.close();
  }

  private static String f()
  {
    String str = Long.toHexString(System.currentTimeMillis());
    if (str.length() > 10)
      str = str.substring(-10 + str.length());
    return str;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.tid.b
 * JD-Core Version:    0.6.0
 */