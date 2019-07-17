package com.alipay.security.mobile.module.c.a;

public final class a
{
  public static boolean a(String paramString)
  {
    int j;
    int i;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0);
    }
    else
    {
      i = 1;
      return i;
    }
    for (int k = 0; ; k++)
    {
      if (k >= j)
        break label47;
      boolean bool = Character.isWhitespace(paramString.charAt(k));
      i = 0;
      if (!bool)
        break;
    }
    label47: return true;
  }

  // ERROR //
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 30	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: new 36	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 39	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 43	java/io/File:exists	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: new 45	java/io/BufferedReader
    //   27: dup
    //   28: new 47	java/io/InputStreamReader
    //   31: dup
    //   32: new 49	java/io/FileInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   40: ldc 52
    //   42: invokespecial 55	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   45: invokespecial 58	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore 6
    //   50: aload 6
    //   52: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   55: astore 10
    //   57: aload 10
    //   59: ifnull +31 -> 90
    //   62: aload_1
    //   63: aload 10
    //   65: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: goto -19 -> 50
    //   72: astore 9
    //   74: aload 6
    //   76: astore_3
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 69	java/io/BufferedReader:close	()V
    //   85: aload_1
    //   86: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: areturn
    //   90: aload 6
    //   92: invokevirtual 69	java/io/BufferedReader:close	()V
    //   95: goto -10 -> 85
    //   98: astore 12
    //   100: goto -15 -> 85
    //   103: astore 5
    //   105: aconst_null
    //   106: astore 6
    //   108: aload 5
    //   110: astore 7
    //   112: aload 6
    //   114: ifnull +8 -> 122
    //   117: aload 6
    //   119: invokevirtual 69	java/io/BufferedReader:close	()V
    //   122: aload 7
    //   124: athrow
    //   125: astore 4
    //   127: goto -42 -> 85
    //   130: astore 8
    //   132: goto -10 -> 122
    //   135: astore 7
    //   137: goto -25 -> 112
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_3
    //   143: goto -66 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   50	57	72	java/io/IOException
    //   62	69	72	java/io/IOException
    //   90	95	98	java/lang/Throwable
    //   8	22	103	finally
    //   24	50	103	finally
    //   81	85	125	java/lang/Throwable
    //   117	122	130	java/lang/Throwable
    //   50	57	135	finally
    //   62	69	135	finally
    //   8	22	140	java/io/IOException
    //   24	50	140	java/io/IOException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.c.a.a
 * JD-Core Version:    0.6.0
 */