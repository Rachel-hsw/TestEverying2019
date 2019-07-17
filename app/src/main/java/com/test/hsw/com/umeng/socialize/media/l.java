package com.umeng.socialize.media;

import android.graphics.Bitmap;

class l
  implements Runnable
{
  l(UMImage paramUMImage, Bitmap paramBitmap)
  {
  }

  // ERROR //
  public void run()
  {
    // Byte code:
    //   0: invokestatic 30	java/lang/System:currentTimeMillis	()J
    //   3: lstore 6
    //   5: aload_0
    //   6: getfield 14	com/umeng/socialize/media/l:b	Lcom/umeng/socialize/media/UMImage;
    //   9: aload_0
    //   10: getfield 16	com/umeng/socialize/media/l:a	Landroid/graphics/Bitmap;
    //   13: invokevirtual 34	java/lang/Object:toString	()Ljava/lang/String;
    //   16: invokestatic 40	com/umeng/socialize/b/b/a:c	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 45	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;Ljava/lang/String;)Ljava/io/File;
    //   22: astore 8
    //   24: new 47	java/io/FileOutputStream
    //   27: dup
    //   28: aload 8
    //   30: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: astore_2
    //   34: aload_0
    //   35: getfield 16	com/umeng/socialize/media/l:a	Landroid/graphics/Bitmap;
    //   38: invokevirtual 56	android/graphics/Bitmap:getRowBytes	()I
    //   41: aload_0
    //   42: getfield 16	com/umeng/socialize/media/l:a	Landroid/graphics/Bitmap;
    //   45: invokevirtual 59	android/graphics/Bitmap:getHeight	()I
    //   48: imul
    //   49: sipush 1024
    //   52: idiv
    //   53: istore 9
    //   55: invokestatic 62	com/umeng/socialize/media/UMImage:p	()Ljava/lang/String;
    //   58: new 64	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   65: ldc 67
    //   67: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload 9
    //   72: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: ldc 76
    //   77: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 82	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: bipush 100
    //   88: istore 10
    //   90: iload 9
    //   92: i2f
    //   93: aload_0
    //   94: getfield 14	com/umeng/socialize/media/l:b	Lcom/umeng/socialize/media/UMImage;
    //   97: invokestatic 85	com/umeng/socialize/media/UMImage:b	(Lcom/umeng/socialize/media/UMImage;)F
    //   100: fcmpl
    //   101: ifle +21 -> 122
    //   104: aload_0
    //   105: getfield 14	com/umeng/socialize/media/l:b	Lcom/umeng/socialize/media/UMImage;
    //   108: invokestatic 85	com/umeng/socialize/media/UMImage:b	(Lcom/umeng/socialize/media/UMImage;)F
    //   111: iload 9
    //   113: i2f
    //   114: fdiv
    //   115: iload 10
    //   117: i2f
    //   118: fmul
    //   119: f2i
    //   120: istore 10
    //   122: invokestatic 62	com/umeng/socialize/media/UMImage:p	()Ljava/lang/String;
    //   125: new 64	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   132: ldc 87
    //   134: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload 10
    //   139: invokevirtual 74	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 82	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload_0
    //   149: getfield 16	com/umeng/socialize/media/l:a	Landroid/graphics/Bitmap;
    //   152: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   155: ifne +17 -> 172
    //   158: aload_0
    //   159: getfield 16	com/umeng/socialize/media/l:a	Landroid/graphics/Bitmap;
    //   162: getstatic 97	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   165: iload 10
    //   167: aload_2
    //   168: invokevirtual 101	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   171: pop
    //   172: aload_0
    //   173: getfield 14	com/umeng/socialize/media/l:b	Lcom/umeng/socialize/media/UMImage;
    //   176: aload 8
    //   178: invokestatic 104	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;Ljava/io/File;)Ljava/io/File;
    //   181: pop
    //   182: invokestatic 62	com/umeng/socialize/media/UMImage:p	()Ljava/lang/String;
    //   185: new 64	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   192: ldc 106
    //   194: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload 8
    //   199: invokevirtual 111	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   202: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 82	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: invokestatic 30	java/lang/System:currentTimeMillis	()J
    //   214: lstore 12
    //   216: invokestatic 62	com/umeng/socialize/media/UMImage:p	()Ljava/lang/String;
    //   219: new 64	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   226: ldc 113
    //   228: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: lload 12
    //   233: lload 6
    //   235: lsub
    //   236: invokevirtual 116	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: ldc 118
    //   241: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 82	com/umeng/socialize/utils/i:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: aload_0
    //   251: getfield 14	com/umeng/socialize/media/l:b	Lcom/umeng/socialize/media/UMImage;
    //   254: invokestatic 121	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;)V
    //   257: aload_2
    //   258: ifnull +7 -> 265
    //   261: aload_2
    //   262: invokevirtual 126	java/io/OutputStream:close	()V
    //   265: return
    //   266: astore 4
    //   268: aconst_null
    //   269: astore_2
    //   270: invokestatic 62	com/umeng/socialize/media/UMImage:p	()Ljava/lang/String;
    //   273: new 64	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   280: ldc 128
    //   282: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload 4
    //   287: invokevirtual 129	java/lang/Exception:toString	()Ljava/lang/String;
    //   290: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 131
    //   295: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 133	com/umeng/socialize/utils/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_0
    //   305: getfield 14	com/umeng/socialize/media/l:b	Lcom/umeng/socialize/media/UMImage;
    //   308: invokestatic 121	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;)V
    //   311: aload_2
    //   312: ifnull -47 -> 265
    //   315: aload_2
    //   316: invokevirtual 126	java/io/OutputStream:close	()V
    //   319: return
    //   320: astore 5
    //   322: return
    //   323: astore_1
    //   324: aconst_null
    //   325: astore_2
    //   326: aload_0
    //   327: getfield 14	com/umeng/socialize/media/l:b	Lcom/umeng/socialize/media/UMImage;
    //   330: invokestatic 121	com/umeng/socialize/media/UMImage:a	(Lcom/umeng/socialize/media/UMImage;)V
    //   333: aload_2
    //   334: ifnull +7 -> 341
    //   337: aload_2
    //   338: invokevirtual 126	java/io/OutputStream:close	()V
    //   341: aload_1
    //   342: athrow
    //   343: astore 14
    //   345: return
    //   346: astore_3
    //   347: goto -6 -> 341
    //   350: astore_1
    //   351: goto -25 -> 326
    //   354: astore 4
    //   356: goto -86 -> 270
    //
    // Exception table:
    //   from	to	target	type
    //   0	34	266	java/lang/Exception
    //   315	319	320	java/io/IOException
    //   0	34	323	finally
    //   261	265	343	java/io/IOException
    //   337	341	346	java/io/IOException
    //   34	86	350	finally
    //   90	122	350	finally
    //   122	172	350	finally
    //   172	250	350	finally
    //   270	304	350	finally
    //   34	86	354	java/lang/Exception
    //   90	122	354	java/lang/Exception
    //   122	172	354	java/lang/Exception
    //   172	250	354	java/lang/Exception
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.l
 * JD-Core Version:    0.6.0
 */