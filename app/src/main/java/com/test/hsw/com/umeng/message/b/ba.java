package com.umeng.message.b;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public final class ba
  implements az
{
  private static final int a = 2;
  private static final int b = 10485760;
  private volatile boolean c = true;
  private volatile boolean d = false;
  private volatile Logger e;

  public ba()
  {
    this(false, false);
  }

  public ba(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    if (a())
    {
      this.c = true;
      this.d = true;
    }
    b();
  }

  // ERROR //
  private static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 39
    //   4: astore_2
    //   5: new 41	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   12: ldc 44
    //   14: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: iload_0
    //   18: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: ldc 53
    //   23: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 9
    //   31: new 41	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 42	java/lang/StringBuilder:<init>	()V
    //   38: ldc 44
    //   40: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_0
    //   44: invokevirtual 51	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: ldc 59
    //   49: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore 10
    //   57: new 61	java/io/File
    //   60: dup
    //   61: aload 9
    //   63: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 11
    //   68: new 66	java/io/BufferedReader
    //   71: dup
    //   72: new 68	java/io/FileReader
    //   75: dup
    //   76: aload 11
    //   78: invokespecial 71	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   81: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   84: astore 7
    //   86: aload 7
    //   88: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   91: astore 13
    //   93: aload 13
    //   95: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +42 -> 140
    //   101: aload 13
    //   103: iconst_0
    //   104: aload 13
    //   106: iconst_0
    //   107: invokevirtual 89	java/lang/String:indexOf	(I)I
    //   110: invokevirtual 93	java/lang/String:substring	(II)Ljava/lang/String;
    //   113: astore 20
    //   115: aload 20
    //   117: astore_2
    //   118: aload 7
    //   120: astore_1
    //   121: aload 11
    //   123: astore 4
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 96	java/io/BufferedReader:close	()V
    //   133: aload 4
    //   135: ifnull +3 -> 138
    //   138: aload_2
    //   139: areturn
    //   140: new 61	java/io/File
    //   143: dup
    //   144: aload 10
    //   146: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 4
    //   151: aload 7
    //   153: invokevirtual 96	java/io/BufferedReader:close	()V
    //   156: new 66	java/io/BufferedReader
    //   159: dup
    //   160: new 68	java/io/FileReader
    //   163: dup
    //   164: aload 4
    //   166: invokespecial 71	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   169: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   177: astore 16
    //   179: aload 16
    //   181: ifnull -56 -> 125
    //   184: aload 16
    //   186: ldc 98
    //   188: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   191: ifeq +30 -> 221
    //   194: aload 16
    //   196: ldc 104
    //   198: invokevirtual 107	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   201: istore 18
    //   203: iload 18
    //   205: iflt -80 -> 125
    //   208: aload 16
    //   210: iload 18
    //   212: iconst_1
    //   213: iadd
    //   214: invokevirtual 109	java/lang/String:substring	(I)Ljava/lang/String;
    //   217: astore_2
    //   218: goto -93 -> 125
    //   221: aload_1
    //   222: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   225: astore 17
    //   227: aload 17
    //   229: astore 16
    //   231: goto -52 -> 179
    //   234: astore 6
    //   236: aconst_null
    //   237: astore 7
    //   239: aload 7
    //   241: ifnull +8 -> 249
    //   244: aload 7
    //   246: invokevirtual 96	java/io/BufferedReader:close	()V
    //   249: aload_1
    //   250: ifnull -112 -> 138
    //   253: aload_2
    //   254: areturn
    //   255: astore_3
    //   256: aconst_null
    //   257: astore 4
    //   259: aload_1
    //   260: ifnull +7 -> 267
    //   263: aload_1
    //   264: invokevirtual 96	java/io/BufferedReader:close	()V
    //   267: aload 4
    //   269: ifnull +3 -> 272
    //   272: aload_3
    //   273: athrow
    //   274: astore 19
    //   276: goto -143 -> 133
    //   279: astore 8
    //   281: goto -32 -> 249
    //   284: astore 5
    //   286: goto -19 -> 267
    //   289: astore_3
    //   290: aload 11
    //   292: astore 4
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -37 -> 259
    //   299: astore_3
    //   300: aload 7
    //   302: astore_1
    //   303: aload 11
    //   305: astore 4
    //   307: goto -48 -> 259
    //   310: astore_3
    //   311: aload 7
    //   313: astore_1
    //   314: goto -55 -> 259
    //   317: astore_3
    //   318: goto -59 -> 259
    //   321: astore 21
    //   323: aload 11
    //   325: astore_1
    //   326: aconst_null
    //   327: astore 7
    //   329: goto -90 -> 239
    //   332: astore 12
    //   334: aload 11
    //   336: astore_1
    //   337: goto -98 -> 239
    //   340: astore 14
    //   342: aload 4
    //   344: astore_1
    //   345: goto -106 -> 239
    //   348: astore 15
    //   350: aload_1
    //   351: astore 7
    //   353: aload 4
    //   355: astore_1
    //   356: goto -117 -> 239
    //
    // Exception table:
    //   from	to	target	type
    //   5	68	234	java/lang/Throwable
    //   5	68	255	finally
    //   129	133	274	java/io/IOException
    //   244	249	279	java/io/IOException
    //   263	267	284	java/io/IOException
    //   68	86	289	finally
    //   86	115	299	finally
    //   140	151	299	finally
    //   151	173	310	finally
    //   173	179	317	finally
    //   184	203	317	finally
    //   208	218	317	finally
    //   221	227	317	finally
    //   68	86	321	java/lang/Throwable
    //   86	115	332	java/lang/Throwable
    //   140	151	332	java/lang/Throwable
    //   151	173	340	java/lang/Throwable
    //   173	179	348	java/lang/Throwable
    //   184	203	348	java/lang/Throwable
    //   208	218	348	java/lang/Throwable
    //   221	227	348	java/lang/Throwable
  }

  public static final String a(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(paramLong));
  }

  private final boolean a()
  {
    try
    {
      File localFile1 = Environment.getExternalStorageDirectory();
      File localFile2 = new File(localFile1.getPath() + "/_agoo_log_bin_");
      Log.v("Agoo", "agoo_logger_path[" + localFile1.getPath() + "/_agoo_log_bin_" + "]");
      if (localFile2.isDirectory())
      {
        Log.v("Agoo", "agoo_logger_print[true]");
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private static String b(Throwable paramThrowable)
  {
    if (paramThrowable == null)
      return "";
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }

  private final void b()
  {
    String str1;
    String str2;
    if (this.d)
    {
      str1 = c();
      str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + str1;
    }
    try
    {
      FileHandler localFileHandler = new FileHandler(str2 + "_%g.log", 10485760, 2, true);
      localFileHandler.setFormatter(new a(null));
      this.e = Logger.getLogger(str1);
      this.e.setLevel(Level.ALL);
      this.e.addHandler(localFileHandler);
      return;
    }
    catch (IOException localIOException)
    {
      return;
    }
    catch (SecurityException localSecurityException)
    {
    }
  }

  private static String c()
  {
    String str = a(Process.myPid());
    if (TextUtils.isEmpty(str))
      str = "AgooLog";
    return str.replace(':', '_');
  }

  public final void a(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.INFO, paramString1 + ":" + paramString2);
        return;
      }
      Log.d(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      a(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void a(String paramString, Object[] paramArrayOfObject)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.INFO, paramString + ":" + co.a(paramArrayOfObject));
        return;
      }
      if (Log.isLoggable(paramString, 3))
        Log.d(paramString, co.a(paramArrayOfObject));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void b(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.INFO, paramString1 + ":" + paramString2);
        return;
      }
      Log.i(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      b(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void c(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.INFO, paramString1 + ":" + paramString2);
        return;
      }
      Log.v(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      c(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void d(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.WARNING, paramString1 + ":" + paramString2);
        return;
      }
      Log.w(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      d(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void e(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.SEVERE, paramString1 + ":" + paramString2);
        return;
      }
      Log.e(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      e(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  static class a extends Formatter
  {
    private String a = null;

    private void a(LogRecord paramLogRecord)
    {
      int i = 0;
      Throwable localThrowable = paramLogRecord.getThrown();
      if (localThrowable == null)
        return;
      this.a = ba.a(localThrowable);
      StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
      int j = 0;
      label29: String str1;
      if (j < arrayOfStackTraceElement.length)
      {
        str1 = arrayOfStackTraceElement[j].getClassName();
        if (!str1.startsWith(ay.class.getName()))
          break label68;
        i = 1;
      }
      label68: 
      do
      {
        j++;
        break label29;
        break;
      }
      while (i == 0);
      String str2 = arrayOfStackTraceElement[j].getMethodName();
      paramLogRecord.setSourceClassName(str1);
      paramLogRecord.setSourceMethodName(str2);
    }

    public final String format(LogRecord paramLogRecord)
    {
      monitorenter;
      try
      {
        a(paramLogRecord);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(ba.a(paramLogRecord.getMillis()));
        localStringBuffer.append(" ");
        if (paramLogRecord.getSourceClassName() != null)
          localStringBuffer.append(paramLogRecord.getSourceClassName());
        while (true)
        {
          if (paramLogRecord.getSourceMethodName() != null)
          {
            localStringBuffer.append(" ");
            localStringBuffer.append(paramLogRecord.getSourceMethodName());
          }
          localStringBuffer.append("[");
          localStringBuffer.append(paramLogRecord.getLevel().getLocalizedName());
          localStringBuffer.append("]-->");
          localStringBuffer.append(formatMessage(paramLogRecord));
          localStringBuffer.append("\n");
          if (!TextUtils.isEmpty(this.a))
            localStringBuffer.append(this.a);
          String str = localStringBuffer.toString();
          return str;
          localStringBuffer.append(paramLogRecord.getLoggerName());
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.ba
 * JD-Core Version:    0.6.0
 */