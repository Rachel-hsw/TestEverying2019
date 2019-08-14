package com.baidu.location.c;

import java.util.concurrent.Callable;

class d$1
  implements Callable
{
  // ERROR //
  public com.baidu.location.BDLocation a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 24	com/baidu/location/BDLocation
    //   5: dup
    //   6: invokespecial 25	com/baidu/location/BDLocation:<init>	()V
    //   9: astore_2
    //   10: aload_0
    //   11: getfield 16	com/baidu/location/c/d$1:if	[Ljava/lang/String;
    //   14: arraylength
    //   15: ifle +100 -> 115
    //   18: invokestatic 31	com/baidu/location/c/d:else	()Landroid/content/Context;
    //   21: invokevirtual 37	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   24: getstatic 41	com/baidu/location/c/d:ab	Ljava/lang/String;
    //   27: iconst_0
    //   28: invokevirtual 47	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +84 -> 117
    //   36: aload_3
    //   37: astore 5
    //   39: aload 5
    //   41: ifnull +176 -> 217
    //   44: invokestatic 31	com/baidu/location/c/d:else	()Landroid/content/Context;
    //   47: invokevirtual 51	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   50: aload 5
    //   52: getfield 56	android/content/pm/ProviderInfo:authority	Ljava/lang/String;
    //   55: invokestatic 60	com/baidu/location/c/d:for	(Ljava/lang/String;)Landroid/net/Uri;
    //   58: aload_0
    //   59: getfield 16	com/baidu/location/c/d$1:if	[Ljava/lang/String;
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 20
    //   70: aload 20
    //   72: invokestatic 71	com/baidu/location/c/c:if	(Landroid/database/Cursor;)Lcom/baidu/location/BDLocation;
    //   75: astore 22
    //   77: aload 22
    //   79: astore 18
    //   81: aload 20
    //   83: ifnull +10 -> 93
    //   86: aload 20
    //   88: invokeinterface 76 1 0
    //   93: aload 18
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull +18 -> 115
    //   100: aload_2
    //   101: invokevirtual 80	com/baidu/location/BDLocation:getLocType	()I
    //   104: bipush 67
    //   106: if_icmpeq +9 -> 115
    //   109: aload_2
    //   110: bipush 66
    //   112: invokevirtual 84	com/baidu/location/BDLocation:setLocType	(I)V
    //   115: aload_2
    //   116: areturn
    //   117: aload_0
    //   118: getfield 14	com/baidu/location/c/d$1:a	Lcom/baidu/location/c/d;
    //   121: invokestatic 87	com/baidu/location/c/d:if	(Lcom/baidu/location/c/d;)Lcom/baidu/location/c/e;
    //   124: invokevirtual 93	com/baidu/location/c/e:v	()[Ljava/lang/String;
    //   127: astore 4
    //   129: aload_3
    //   130: astore 5
    //   132: iconst_0
    //   133: istore 6
    //   135: iload 6
    //   137: aload 4
    //   139: arraylength
    //   140: if_icmpge -101 -> 39
    //   143: invokestatic 31	com/baidu/location/c/d:else	()Landroid/content/Context;
    //   146: invokevirtual 37	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   149: aload 4
    //   151: iload 6
    //   153: aaload
    //   154: iconst_0
    //   155: invokevirtual 47	android/content/pm/PackageManager:resolveContentProvider	(Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   158: astore 5
    //   160: aload 5
    //   162: ifnonnull -123 -> 39
    //   165: iinc 6 1
    //   168: goto -33 -> 135
    //   171: astore 16
    //   173: aconst_null
    //   174: astore 17
    //   176: aload 17
    //   178: ifnull +159 -> 337
    //   181: aload 17
    //   183: invokeinterface 76 1 0
    //   188: aload_2
    //   189: astore 18
    //   191: goto -98 -> 93
    //   194: astore 19
    //   196: aload_2
    //   197: astore 18
    //   199: goto -106 -> 93
    //   202: astore 14
    //   204: aload_1
    //   205: ifnull +9 -> 214
    //   208: aload_1
    //   209: invokeinterface 76 1 0
    //   214: aload 14
    //   216: athrow
    //   217: new 95	com/baidu/location/c/c$a
    //   220: dup
    //   221: aload_0
    //   222: getfield 16	com/baidu/location/c/d$1:if	[Ljava/lang/String;
    //   225: invokespecial 98	com/baidu/location/c/c$a:<init>	([Ljava/lang/String;)V
    //   228: astore 7
    //   230: aload_0
    //   231: getfield 14	com/baidu/location/c/d$1:a	Lcom/baidu/location/c/d;
    //   234: invokestatic 102	com/baidu/location/c/d:do	(Lcom/baidu/location/c/d;)Lcom/baidu/location/c/a;
    //   237: aload 7
    //   239: invokevirtual 107	com/baidu/location/c/a:if	(Lcom/baidu/location/c/c$a;)Landroid/database/Cursor;
    //   242: astore_1
    //   243: aload_1
    //   244: invokestatic 71	com/baidu/location/c/c:if	(Landroid/database/Cursor;)Lcom/baidu/location/BDLocation;
    //   247: astore 12
    //   249: aload 12
    //   251: astore_2
    //   252: aload_1
    //   253: ifnull -157 -> 96
    //   256: aload_1
    //   257: invokeinterface 76 1 0
    //   262: goto -166 -> 96
    //   265: astore 13
    //   267: goto -171 -> 96
    //   270: astore 10
    //   272: aload_1
    //   273: ifnull -177 -> 96
    //   276: aload_1
    //   277: invokeinterface 76 1 0
    //   282: goto -186 -> 96
    //   285: astore 11
    //   287: goto -191 -> 96
    //   290: astore 8
    //   292: aload_1
    //   293: ifnull +9 -> 302
    //   296: aload_1
    //   297: invokeinterface 76 1 0
    //   302: aload 8
    //   304: athrow
    //   305: astore 23
    //   307: goto -214 -> 93
    //   310: astore 15
    //   312: goto -98 -> 214
    //   315: astore 9
    //   317: goto -15 -> 302
    //   320: astore 14
    //   322: aload 20
    //   324: astore_1
    //   325: goto -121 -> 204
    //   328: astore 21
    //   330: aload 20
    //   332: astore 17
    //   334: goto -158 -> 176
    //   337: aload_2
    //   338: astore 18
    //   340: goto -247 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   44	70	171	java/lang/Exception
    //   181	188	194	java/lang/Exception
    //   44	70	202	finally
    //   256	262	265	java/lang/Exception
    //   230	249	270	java/lang/Exception
    //   276	282	285	java/lang/Exception
    //   230	249	290	finally
    //   86	93	305	java/lang/Exception
    //   208	214	310	java/lang/Exception
    //   296	302	315	java/lang/Exception
    //   70	77	320	finally
    //   70	77	328	java/lang/Exception
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.c.d.1
 * JD-Core Version:    0.6.0
 */