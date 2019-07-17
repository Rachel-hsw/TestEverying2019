package com.umeng.message.b;

import android.util.Log;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class aw extends av
{
  private static final String f = "FileProcessLock";
  private String b;
  private String c;
  private FileOutputStream d = null;
  private FileLock e = null;

  public aw(String paramString)
  {
    this.b = paramString;
    this.c = String.format("%s_log", new Object[] { paramString });
  }

  protected void a()
  {
    a(2147483647L, TimeUnit.SECONDS);
  }

  protected boolean a(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      if (this.d == null)
        this.d = new FileOutputStream(this.b);
      this.e = this.d.getChannel().tryLock();
      FileLock localFileLock = this.e;
      int i = 0;
      if (localFileLock != null)
      {
        boolean bool = this.e.isValid();
        i = 0;
        if (bool)
          i = 1;
      }
      if (i == 0);
      return i;
    }
    catch (Throwable localThrowable)
    {
      Log.e("FileProcessLock", "doTryLock", localThrowable);
      return false;
    }
    finally
    {
      if (0 != 0);
    }
    throw localObject;
  }

  protected void b()
  {
    try
    {
      if (this.d != null)
      {
        if ((this.e != null) && (this.e.isValid()))
        {
          this.e.release();
          this.e = null;
        }
        this.d.close();
        this.d = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("FileProcessLock", "doUnlock", localThrowable);
    }
  }

  protected boolean c()
  {
    return a(0L, TimeUnit.SECONDS);
  }

  protected void d()
    throws InterruptedException
  {
    a(2147483647L, TimeUnit.SECONDS);
  }

  class a
  {
    int a;
    long b;

    a()
    {
    }

    // ERROR //
    void a()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: invokestatic 25	android/os/Process:myPid	()I
      //   5: istore 7
      //   7: invokestatic 31	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   10: invokevirtual 35	java/lang/Thread:getId	()J
      //   13: lstore 8
      //   15: new 37	java/io/FileWriter
      //   18: dup
      //   19: aload_0
      //   20: getfield 14	com/umeng/message/b/aw$a:c	Lcom/umeng/message/b/aw;
      //   23: invokestatic 42	com/umeng/message/b/aw:a	(Lcom/umeng/message/b/aw;)Ljava/lang/String;
      //   26: invokespecial 45	java/io/FileWriter:<init>	(Ljava/lang/String;)V
      //   29: astore 5
      //   31: aload 5
      //   33: new 47	java/lang/StringBuilder
      //   36: dup
      //   37: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   40: ldc 50
      //   42: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   45: iload 7
      //   47: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   50: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   53: invokevirtual 64	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
      //   56: pop
      //   57: aload 5
      //   59: ldc 66
      //   61: invokevirtual 64	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
      //   64: pop
      //   65: aload 5
      //   67: new 47	java/lang/StringBuilder
      //   70: dup
      //   71: invokespecial 48	java/lang/StringBuilder:<init>	()V
      //   74: ldc 50
      //   76: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: lload 8
      //   81: invokevirtual 69	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   84: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   87: invokevirtual 64	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
      //   90: pop
      //   91: aload 5
      //   93: invokevirtual 72	java/io/FileWriter:flush	()V
      //   96: aload 5
      //   98: ifnull +8 -> 106
      //   101: aload 5
      //   103: invokevirtual 75	java/io/FileWriter:close	()V
      //   106: return
      //   107: astore 4
      //   109: aconst_null
      //   110: astore 5
      //   112: aload 5
      //   114: ifnull -8 -> 106
      //   117: aload 5
      //   119: invokevirtual 75	java/io/FileWriter:close	()V
      //   122: return
      //   123: astore 6
      //   125: return
      //   126: astore_2
      //   127: aload_1
      //   128: ifnull +7 -> 135
      //   131: aload_1
      //   132: invokevirtual 75	java/io/FileWriter:close	()V
      //   135: aload_2
      //   136: athrow
      //   137: astore 15
      //   139: return
      //   140: astore_3
      //   141: goto -6 -> 135
      //   144: astore 11
      //   146: aload 5
      //   148: astore_1
      //   149: aload 11
      //   151: astore_2
      //   152: goto -25 -> 127
      //   155: astore 10
      //   157: goto -45 -> 112
      //
      // Exception table:
      //   from	to	target	type
      //   2	31	107	java/lang/Throwable
      //   117	122	123	java/lang/Throwable
      //   2	31	126	finally
      //   101	106	137	java/lang/Throwable
      //   131	135	140	java/lang/Throwable
      //   31	96	144	finally
      //   31	96	155	java/lang/Throwable
    }

    // ERROR //
    void b()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: new 77	java/io/FileReader
      //   5: dup
      //   6: aload_0
      //   7: getfield 14	com/umeng/message/b/aw$a:c	Lcom/umeng/message/b/aw;
      //   10: invokestatic 42	com/umeng/message/b/aw:a	(Lcom/umeng/message/b/aw;)Ljava/lang/String;
      //   13: invokespecial 78	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   16: astore_2
      //   17: new 80	java/lang/StringBuffer
      //   20: dup
      //   21: invokespecial 81	java/lang/StringBuffer:<init>	()V
      //   24: astore_3
      //   25: aload_2
      //   26: invokevirtual 84	java/io/FileReader:read	()I
      //   29: istore 9
      //   31: iload 9
      //   33: iconst_m1
      //   34: if_icmpeq +25 -> 59
      //   37: aload_3
      //   38: iload 9
      //   40: i2c
      //   41: invokevirtual 87	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
      //   44: pop
      //   45: goto -20 -> 25
      //   48: astore 7
      //   50: aload_2
      //   51: ifnull +7 -> 58
      //   54: aload_2
      //   55: invokevirtual 88	java/io/FileReader:close	()V
      //   58: return
      //   59: aload_3
      //   60: invokevirtual 89	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   63: ldc 66
      //   65: invokevirtual 95	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   68: astore 11
      //   70: aload_0
      //   71: aload 11
      //   73: iconst_0
      //   74: aaload
      //   75: invokestatic 101	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   78: putfield 103	com/umeng/message/b/aw$a:a	I
      //   81: aload_0
      //   82: aload 11
      //   84: iconst_1
      //   85: aaload
      //   86: invokestatic 109	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   89: putfield 111	com/umeng/message/b/aw$a:b	J
      //   92: aload_2
      //   93: ifnull -35 -> 58
      //   96: aload_2
      //   97: invokevirtual 88	java/io/FileReader:close	()V
      //   100: return
      //   101: astore 12
      //   103: return
      //   104: astore 5
      //   106: aload_1
      //   107: ifnull +7 -> 114
      //   110: aload_1
      //   111: invokevirtual 88	java/io/FileReader:close	()V
      //   114: aload 5
      //   116: athrow
      //   117: astore 8
      //   119: return
      //   120: astore 6
      //   122: goto -8 -> 114
      //   125: astore 4
      //   127: aload_2
      //   128: astore_1
      //   129: aload 4
      //   131: astore 5
      //   133: goto -27 -> 106
      //   136: astore 13
      //   138: aconst_null
      //   139: astore_2
      //   140: goto -90 -> 50
      //
      // Exception table:
      //   from	to	target	type
      //   17	25	48	java/lang/Throwable
      //   25	31	48	java/lang/Throwable
      //   37	45	48	java/lang/Throwable
      //   59	92	48	java/lang/Throwable
      //   96	100	101	java/lang/Throwable
      //   2	17	104	finally
      //   54	58	117	java/lang/Throwable
      //   110	114	120	java/lang/Throwable
      //   17	25	125	finally
      //   25	31	125	finally
      //   37	45	125	finally
      //   59	92	125	finally
      //   2	17	136	java/lang/Throwable
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.aw
 * JD-Core Version:    0.6.0
 */