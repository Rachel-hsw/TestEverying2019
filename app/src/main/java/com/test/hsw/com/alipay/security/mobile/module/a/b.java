package com.alipay.security.mobile.module.a;

public final class b
{
  // ERROR //
  public static java.lang.String a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 10	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 14	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 18	java/io/File:exists	()Z
    //   16: istore 12
    //   18: iload 12
    //   20: ifne +19 -> 39
    //   23: aconst_null
    //   24: invokevirtual 24	java/io/FileReader:close	()V
    //   27: aconst_null
    //   28: areturn
    //   29: astore 16
    //   31: aload 16
    //   33: invokevirtual 27	java/io/IOException:printStackTrace	()V
    //   36: goto -9 -> 27
    //   39: aload_3
    //   40: invokevirtual 31	java/io/File:length	()J
    //   43: l2i
    //   44: newarray char
    //   46: astore 9
    //   48: new 20	java/io/FileReader
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 34	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   56: astore 7
    //   58: aload 7
    //   60: aload 9
    //   62: invokevirtual 38	java/io/FileReader:read	([C)I
    //   65: pop
    //   66: aload 7
    //   68: invokevirtual 24	java/io/FileReader:close	()V
    //   71: aload 9
    //   73: invokestatic 44	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   76: areturn
    //   77: astore 14
    //   79: aload 14
    //   81: invokevirtual 27	java/io/IOException:printStackTrace	()V
    //   84: goto -13 -> 71
    //   87: astore 6
    //   89: aconst_null
    //   90: astore 7
    //   92: aload 6
    //   94: astore 8
    //   96: aconst_null
    //   97: astore 9
    //   99: aload 8
    //   101: invokevirtual 48	java/io/IOException:getMessage	()Ljava/lang/String;
    //   104: pop
    //   105: aload 7
    //   107: invokevirtual 24	java/io/FileReader:close	()V
    //   110: goto -39 -> 71
    //   113: astore 11
    //   115: aload 11
    //   117: invokevirtual 27	java/io/IOException:printStackTrace	()V
    //   120: goto -49 -> 71
    //   123: astore 4
    //   125: aload_2
    //   126: invokevirtual 24	java/io/FileReader:close	()V
    //   129: aload 4
    //   131: athrow
    //   132: astore 5
    //   134: aload 5
    //   136: invokevirtual 27	java/io/IOException:printStackTrace	()V
    //   139: goto -10 -> 129
    //   142: astore 4
    //   144: aload 7
    //   146: astore_2
    //   147: goto -22 -> 125
    //   150: astore 15
    //   152: aload 15
    //   154: astore 8
    //   156: aconst_null
    //   157: astore 7
    //   159: goto -60 -> 99
    //   162: astore 8
    //   164: goto -65 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   23	27	29	java/io/IOException
    //   66	71	77	java/io/IOException
    //   2	18	87	java/io/IOException
    //   39	48	87	java/io/IOException
    //   105	110	113	java/io/IOException
    //   2	18	123	finally
    //   39	48	123	finally
    //   48	58	123	finally
    //   125	129	132	java/io/IOException
    //   58	66	142	finally
    //   99	105	142	finally
    //   48	58	150	java/io/IOException
    //   58	66	162	java/io/IOException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.a.b
 * JD-Core Version:    0.6.0
 */