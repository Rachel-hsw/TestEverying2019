package com.alipay.security.mobile.module.c;

import java.io.File;

public final class a
{
  public static String a(String paramString)
  {
    Object localObject = "";
    try
    {
      String str = System.getProperty(paramString);
      localObject = str;
      label10: if (com.alipay.security.mobile.module.c.a.a.a((String)localObject))
        localObject = b.a(".SystemConfig" + File.separator + paramString);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      break label10;
    }
  }

  // ERROR //
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 20	com/alipay/security/mobile/module/c/a/a:a	(Ljava/lang/String;)Z
    //   4: ifne +9 -> 13
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 55	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   12: pop
    //   13: invokestatic 58	com/alipay/security/mobile/module/c/b:a	()Z
    //   16: ifeq +102 -> 118
    //   19: new 22	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 24
    //   25: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: getstatic 34	java/io/File:separator	Ljava/lang/String;
    //   31: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_3
    //   42: invokestatic 58	com/alipay/security/mobile/module/c/b:a	()Z
    //   45: ifeq +73 -> 118
    //   48: new 30	java/io/File
    //   51: dup
    //   52: invokestatic 64	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   55: aload_3
    //   56: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   59: astore 5
    //   61: aload 5
    //   63: invokevirtual 70	java/io/File:exists	()Z
    //   66: ifne +12 -> 78
    //   69: aload 5
    //   71: invokevirtual 73	java/io/File:getParentFile	()Ljava/io/File;
    //   74: invokevirtual 76	java/io/File:mkdirs	()Z
    //   77: pop
    //   78: new 30	java/io/File
    //   81: dup
    //   82: aload 5
    //   84: invokevirtual 79	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore 6
    //   92: aconst_null
    //   93: astore 7
    //   95: new 82	java/io/FileWriter
    //   98: dup
    //   99: aload 6
    //   101: iconst_0
    //   102: invokespecial 85	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   105: astore 8
    //   107: aload 8
    //   109: aload_1
    //   110: invokevirtual 88	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   113: aload 8
    //   115: invokevirtual 92	java/io/FileWriter:close	()V
    //   118: return
    //   119: astore 15
    //   121: aconst_null
    //   122: astore 8
    //   124: aload 8
    //   126: ifnull -8 -> 118
    //   129: aload 8
    //   131: invokevirtual 92	java/io/FileWriter:close	()V
    //   134: return
    //   135: astore 10
    //   137: return
    //   138: astore 12
    //   140: aload 7
    //   142: ifnull +8 -> 150
    //   145: aload 7
    //   147: invokevirtual 92	java/io/FileWriter:close	()V
    //   150: aload 12
    //   152: athrow
    //   153: astore 4
    //   155: return
    //   156: astore 14
    //   158: return
    //   159: astore 13
    //   161: goto -11 -> 150
    //   164: astore 11
    //   166: aload 8
    //   168: astore 7
    //   170: aload 11
    //   172: astore 12
    //   174: goto -34 -> 140
    //   177: astore 9
    //   179: goto -55 -> 124
    //   182: astore_2
    //   183: goto -170 -> 13
    //
    // Exception table:
    //   from	to	target	type
    //   95	107	119	java/lang/Exception
    //   129	134	135	java/io/IOException
    //   95	107	138	finally
    //   42	78	153	java/lang/Exception
    //   78	92	153	java/lang/Exception
    //   113	118	153	java/lang/Exception
    //   129	134	153	java/lang/Exception
    //   145	150	153	java/lang/Exception
    //   150	153	153	java/lang/Exception
    //   113	118	156	java/io/IOException
    //   145	150	159	java/io/IOException
    //   107	113	164	finally
    //   107	113	177	java/lang/Exception
    //   0	13	182	java/lang/Throwable
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.security.mobile.module.c.a
 * JD-Core Version:    0.6.0
 */