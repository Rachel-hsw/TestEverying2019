package com.tencent.open.b;

class g$4
  implements Runnable
{
  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/open/b/g$4:a	Lcom/tencent/open/b/g;
    //   4: invokevirtual 28	com/tencent/open/b/g:c	()Landroid/os/Bundle;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: invokestatic 34	com/tencent/open/utils/Global:getContext	()Landroid/content/Context;
    //   16: aconst_null
    //   17: invokestatic 40	com/tencent/open/utils/OpenConfig:getInstance	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/open/utils/OpenConfig;
    //   20: ldc 42
    //   22: invokevirtual 46	com/tencent/open/utils/OpenConfig:getInt	(Ljava/lang/String;)I
    //   25: istore_3
    //   26: iload_3
    //   27: ifne +210 -> 237
    //   30: iconst_3
    //   31: istore 4
    //   33: getstatic 49	com/tencent/open/b/g:a	Ljava/lang/String;
    //   36: new 51	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   43: ldc 54
    //   45: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 4
    //   50: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 71	com/tencent/open/a/f:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: iconst_0
    //   60: istore 5
    //   62: iinc 5 1
    //   65: invokestatic 34	com/tencent/open/utils/Global:getContext	()Landroid/content/Context;
    //   68: aconst_null
    //   69: ldc 73
    //   71: invokestatic 79	com/tencent/open/utils/HttpUtils:getHttpClient	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
    //   74: astore 10
    //   76: new 81	org/apache/http/client/methods/HttpPost
    //   79: dup
    //   80: ldc 73
    //   82: invokespecial 84	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   85: astore 11
    //   87: aload 11
    //   89: ldc 86
    //   91: ldc 88
    //   93: invokevirtual 91	org/apache/http/client/methods/HttpPost:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload 11
    //   98: ldc 93
    //   100: ldc 95
    //   102: invokevirtual 98	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 11
    //   107: new 100	org/apache/http/entity/ByteArrayEntity
    //   110: dup
    //   111: aload_2
    //   112: invokestatic 104	com/tencent/open/utils/HttpUtils:encodeUrl	(Landroid/os/Bundle;)Ljava/lang/String;
    //   115: invokevirtual 110	java/lang/String:getBytes	()[B
    //   118: invokespecial 113	org/apache/http/entity/ByteArrayEntity:<init>	([B)V
    //   121: invokevirtual 117	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   124: aload 10
    //   126: aload 11
    //   128: invokeinterface 123 2 0
    //   133: invokeinterface 129 1 0
    //   138: invokeinterface 135 1 0
    //   143: istore 12
    //   145: getstatic 49	com/tencent/open/b/g:a	Ljava/lang/String;
    //   148: new 51	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   155: ldc 137
    //   157: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 12
    //   162: invokevirtual 61	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 71	com/tencent/open/a/f:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: iconst_0
    //   172: istore 7
    //   174: iload 12
    //   176: sipush 200
    //   179: if_icmpne +14 -> 193
    //   182: invokestatic 142	com/tencent/open/b/f:a	()Lcom/tencent/open/b/f;
    //   185: ldc 144
    //   187: invokevirtual 146	com/tencent/open/b/f:b	(Ljava/lang/String;)V
    //   190: iconst_1
    //   191: istore 7
    //   193: iload 7
    //   195: ifne +18 -> 213
    //   198: invokestatic 142	com/tencent/open/b/f:a	()Lcom/tencent/open/b/f;
    //   201: ldc 144
    //   203: aload_0
    //   204: getfield 12	com/tencent/open/b/g$4:a	Lcom/tencent/open/b/g;
    //   207: getfield 150	com/tencent/open/b/g:d	Ljava/util/List;
    //   210: invokevirtual 153	com/tencent/open/b/f:a	(Ljava/lang/String;Ljava/util/List;)V
    //   213: aload_0
    //   214: getfield 12	com/tencent/open/b/g$4:a	Lcom/tencent/open/b/g;
    //   217: getfield 150	com/tencent/open/b/g:d	Ljava/util/List;
    //   220: invokeinterface 158 1 0
    //   225: return
    //   226: astore_1
    //   227: getstatic 49	com/tencent/open/b/g:a	Ljava/lang/String;
    //   230: ldc 160
    //   232: aload_1
    //   233: invokestatic 163	com/tencent/open/a/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   236: return
    //   237: iload_3
    //   238: istore 4
    //   240: goto -207 -> 33
    //   243: astore 9
    //   245: getstatic 49	com/tencent/open/b/g:a	Ljava/lang/String;
    //   248: ldc 165
    //   250: aload 9
    //   252: invokestatic 163	com/tencent/open/a/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   255: goto +36 -> 291
    //   258: astore 8
    //   260: getstatic 49	com/tencent/open/b/g:a	Ljava/lang/String;
    //   263: ldc 165
    //   265: aload 8
    //   267: invokestatic 163	com/tencent/open/a/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto +21 -> 291
    //   273: astore 6
    //   275: getstatic 49	com/tencent/open/b/g:a	Ljava/lang/String;
    //   278: ldc 165
    //   280: aload 6
    //   282: invokestatic 163	com/tencent/open/a/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   285: iconst_0
    //   286: istore 7
    //   288: goto -95 -> 193
    //   291: iload 5
    //   293: iload 4
    //   295: if_icmplt -233 -> 62
    //   298: iconst_0
    //   299: istore 7
    //   301: goto -108 -> 193
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	226	java/lang/Exception
    //   13	26	226	java/lang/Exception
    //   33	59	226	java/lang/Exception
    //   198	213	226	java/lang/Exception
    //   213	225	226	java/lang/Exception
    //   245	255	226	java/lang/Exception
    //   260	270	226	java/lang/Exception
    //   275	285	226	java/lang/Exception
    //   65	171	243	org/apache/http/conn/ConnectTimeoutException
    //   182	190	243	org/apache/http/conn/ConnectTimeoutException
    //   65	171	258	java/net/SocketTimeoutException
    //   182	190	258	java/net/SocketTimeoutException
    //   65	171	273	java/lang/Exception
    //   182	190	273	java/lang/Exception
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.g.4
 * JD-Core Version:    0.6.0
 */