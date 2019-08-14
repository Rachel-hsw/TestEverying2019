package com.umeng.message.b;

import android.os.Process;

public class cb
{
  public static int a()
  {
    return Process.myPid();
  }

  // ERROR //
  public static void a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: new 20	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 26	android/content/Context:getFilesDir	()Ljava/io/File;
    //   8: aload_1
    //   9: invokespecial 29	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   12: astore_2
    //   13: ldc 30
    //   15: aload_2
    //   16: invokevirtual 34	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   19: invokestatic 40	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: aload_2
    //   24: invokevirtual 44	java/io/File:exists	()Z
    //   27: ifeq +8 -> 35
    //   30: aload_2
    //   31: invokevirtual 47	java/io/File:delete	()Z
    //   34: pop
    //   35: aload_2
    //   36: invokevirtual 50	java/io/File:createNewFile	()Z
    //   39: pop
    //   40: invokestatic 52	com/umeng/message/b/cb:a	()I
    //   43: istore 7
    //   45: new 54	java/io/FileWriter
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 57	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   53: astore 8
    //   55: aload 8
    //   57: iload 7
    //   59: invokestatic 63	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   62: invokevirtual 67	java/lang/String:toCharArray	()[C
    //   65: invokevirtual 71	java/io/FileWriter:write	([C)V
    //   68: aload 8
    //   70: invokevirtual 74	java/io/FileWriter:flush	()V
    //   73: aload 8
    //   75: invokevirtual 77	java/io/FileWriter:close	()V
    //   78: return
    //   79: astore 4
    //   81: ldc 79
    //   83: ldc 81
    //   85: aload 4
    //   87: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   90: pop
    //   91: return
    //   92: astore 16
    //   94: ldc 87
    //   96: ldc 89
    //   98: aload 16
    //   100: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   103: pop
    //   104: return
    //   105: astore 9
    //   107: aconst_null
    //   108: astore 8
    //   110: ldc 87
    //   112: ldc 89
    //   114: aload 9
    //   116: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   119: pop
    //   120: aload 8
    //   122: invokevirtual 74	java/io/FileWriter:flush	()V
    //   125: aload 8
    //   127: invokevirtual 77	java/io/FileWriter:close	()V
    //   130: return
    //   131: astore 14
    //   133: ldc 87
    //   135: ldc 89
    //   137: aload 14
    //   139: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   142: pop
    //   143: return
    //   144: astore 10
    //   146: aconst_null
    //   147: astore 8
    //   149: aload 8
    //   151: invokevirtual 74	java/io/FileWriter:flush	()V
    //   154: aload 8
    //   156: invokevirtual 77	java/io/FileWriter:close	()V
    //   159: aload 10
    //   161: athrow
    //   162: astore 11
    //   164: ldc 87
    //   166: ldc 89
    //   168: aload 11
    //   170: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   173: pop
    //   174: goto -15 -> 159
    //   177: astore 10
    //   179: goto -30 -> 149
    //   182: astore 9
    //   184: goto -74 -> 110
    //
    // Exception table:
    //   from	to	target	type
    //   35	40	79	java/io/IOException
    //   68	78	92	java/io/IOException
    //   45	55	105	java/io/IOException
    //   120	130	131	java/io/IOException
    //   45	55	144	finally
    //   149	159	162	java/io/IOException
    //   55	68	177	finally
    //   110	120	177	finally
    //   55	68	182	java/io/IOException
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cb
 * JD-Core Version:    0.6.0
 */