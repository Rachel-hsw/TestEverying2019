package com.umeng.socialize.media;

import java.io.InputStream;

class j extends Thread
{
  j(UMImage paramUMImage, InputStream paramInputStream)
  {
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/umeng/socialize/media/j:b	Lcom/umeng/socialize/media/UMImage;
    //   4: aload_0
    //   5: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   8: invokevirtual 26	java/lang/Object:toString	()Ljava/lang/String;
    //   11: invokestatic 32	com/umeng/socialize/b/b/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   14: invokestatic 37	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;Ljava/lang/String;)Ljava/io/File;
    //   17: astore 6
    //   19: new 39	java/io/FileOutputStream
    //   22: dup
    //   23: aload 6
    //   25: invokespecial 42	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: astore_2
    //   29: sipush 4096
    //   32: newarray byte
    //   34: astore 7
    //   36: aload_0
    //   37: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   40: aload 7
    //   42: invokevirtual 48	java/io/InputStream:read	([B)I
    //   45: iconst_m1
    //   46: if_icmpeq +47 -> 93
    //   49: aload_2
    //   50: aload 7
    //   52: invokevirtual 52	java/io/FileOutputStream:write	([B)V
    //   55: goto -19 -> 36
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   63: aload_0
    //   64: getfield 12	com/umeng/socialize/media/j:b	Lcom/umeng/socialize/media/UMImage;
    //   67: invokestatic 58	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;)V
    //   70: aload_0
    //   71: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   74: ifnull +10 -> 84
    //   77: aload_0
    //   78: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   81: invokevirtual 61	java/io/InputStream:close	()V
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   92: return
    //   93: aload_2
    //   94: invokevirtual 65	java/io/FileOutputStream:flush	()V
    //   97: aload 6
    //   99: ifnull +13 -> 112
    //   102: aload_0
    //   103: getfield 12	com/umeng/socialize/media/j:b	Lcom/umeng/socialize/media/UMImage;
    //   106: aload 6
    //   108: invokestatic 68	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;Ljava/io/File;)Ljava/io/File;
    //   111: pop
    //   112: aload_0
    //   113: getfield 12	com/umeng/socialize/media/j:b	Lcom/umeng/socialize/media/UMImage;
    //   116: invokestatic 58	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;)V
    //   119: aload_0
    //   120: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   123: ifnull +10 -> 133
    //   126: aload_0
    //   127: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   130: invokevirtual 61	java/io/InputStream:close	()V
    //   133: aload_2
    //   134: ifnull -42 -> 92
    //   137: aload_2
    //   138: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore 9
    //   144: aload 9
    //   146: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   149: return
    //   150: astore 5
    //   152: aload 5
    //   154: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   157: return
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_0
    //   162: getfield 12	com/umeng/socialize/media/j:b	Lcom/umeng/socialize/media/UMImage;
    //   165: invokestatic 58	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;)V
    //   168: aload_0
    //   169: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   172: ifnull +10 -> 182
    //   175: aload_0
    //   176: getfield 14	com/umeng/socialize/media/j:a	Ljava/io/InputStream;
    //   179: invokevirtual 61	java/io/InputStream:close	()V
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   190: aload_3
    //   191: athrow
    //   192: astore 4
    //   194: aload 4
    //   196: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   199: goto -9 -> 190
    //   202: astore_3
    //   203: goto -42 -> 161
    //   206: astore_1
    //   207: aconst_null
    //   208: astore_2
    //   209: goto -150 -> 59
    //
    // Exception table:
    //   from	to	target	type
    //   29	36	58	java/io/IOException
    //   36	55	58	java/io/IOException
    //   93	97	58	java/io/IOException
    //   102	112	58	java/io/IOException
    //   119	133	142	java/io/IOException
    //   137	141	142	java/io/IOException
    //   70	84	150	java/io/IOException
    //   88	92	150	java/io/IOException
    //   0	29	158	finally
    //   168	182	192	java/io/IOException
    //   186	190	192	java/io/IOException
    //   29	36	202	finally
    //   36	55	202	finally
    //   59	63	202	finally
    //   93	97	202	finally
    //   102	112	202	finally
    //   0	29	206	java/io/IOException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.j
 * JD-Core Version:    0.6.0
 */