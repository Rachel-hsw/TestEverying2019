package com.alipay.sdk.util;

import android.text.TextUtils;

public final class a
{
  public static String[] a(String paramString)
  {
    int i = 1 + paramString.indexOf('(');
    int j = paramString.lastIndexOf(')');
    if ((i == 0) || (j == -1))
      return null;
    String[] arrayOfString = paramString.substring(i, j).split(",");
    if (arrayOfString != null)
      for (int k = 0; k < arrayOfString.length; k++)
      {
        if (TextUtils.isEmpty(arrayOfString[k]))
          continue;
        arrayOfString[k] = arrayOfString[k].trim();
        arrayOfString[k] = arrayOfString[k].replaceAll("'", "").replaceAll("\"", "");
      }
    return arrayOfString;
  }

  // ERROR //
  private static void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 54	com/alipay/sdk/util/a:a	(Ljava/lang/String;)[Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: arraylength
    //   7: iconst_3
    //   8: if_icmpeq +4 -> 12
    //   11: return
    //   12: ldc 56
    //   14: aload_1
    //   15: iconst_0
    //   16: aaload
    //   17: invokestatic 60	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   20: ifeq -9 -> 11
    //   23: invokestatic 65	com/alipay/sdk/sys/b:a	()Lcom/alipay/sdk/sys/b;
    //   26: getfield 68	com/alipay/sdk/sys/b:a	Landroid/content/Context;
    //   29: astore_2
    //   30: invokestatic 73	com/alipay/sdk/tid/b:a	()Lcom/alipay/sdk/tid/b;
    //   33: astore_3
    //   34: aload_1
    //   35: iconst_1
    //   36: aaload
    //   37: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifne -29 -> 11
    //   43: aload_1
    //   44: iconst_2
    //   45: aaload
    //   46: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne -38 -> 11
    //   52: aload_3
    //   53: aload_1
    //   54: iconst_1
    //   55: aaload
    //   56: putfield 76	com/alipay/sdk/tid/b:a	Ljava/lang/String;
    //   59: aload_3
    //   60: aload_1
    //   61: iconst_2
    //   62: aaload
    //   63: putfield 78	com/alipay/sdk/tid/b:b	Ljava/lang/String;
    //   66: new 80	com/alipay/sdk/tid/a
    //   69: dup
    //   70: aload_2
    //   71: invokespecial 83	com/alipay/sdk/tid/a:<init>	(Landroid/content/Context;)V
    //   74: astore 4
    //   76: aload 4
    //   78: aload_2
    //   79: invokestatic 88	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   82: invokevirtual 90	com/alipay/sdk/util/b:a	()Ljava/lang/String;
    //   85: aload_2
    //   86: invokestatic 88	com/alipay/sdk/util/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/util/b;
    //   89: invokevirtual 92	com/alipay/sdk/util/b:b	()Ljava/lang/String;
    //   92: aload_3
    //   93: getfield 76	com/alipay/sdk/tid/b:a	Ljava/lang/String;
    //   96: aload_3
    //   97: getfield 78	com/alipay/sdk/tid/b:b	Ljava/lang/String;
    //   100: invokevirtual 95	com/alipay/sdk/tid/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 4
    //   105: invokevirtual 98	com/alipay/sdk/tid/a:close	()V
    //   108: return
    //   109: astore 6
    //   111: aload 4
    //   113: invokevirtual 98	com/alipay/sdk/tid/a:close	()V
    //   116: return
    //   117: astore 5
    //   119: aload 4
    //   121: invokevirtual 98	com/alipay/sdk/tid/a:close	()V
    //   124: aload 5
    //   126: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   76	103	109	java/lang/Exception
    //   76	103	117	finally
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.util.a
 * JD-Core Version:    0.6.0
 */