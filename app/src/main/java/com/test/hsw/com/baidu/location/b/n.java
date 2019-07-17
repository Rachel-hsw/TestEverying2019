package com.baidu.location.b;

import java.io.File;
import java.io.RandomAccessFile;

public class n
{
  static n jdField_if;
  int a = 20;
  int jdField_do = 0;
  int jdField_for = 3164;
  int jdField_int = 60;
  int jdField_new = 40;
  String jdField_try = "firll.dat";

  // ERROR //
  private long a(int paramInt)
  {
    // Byte code:
    //   0: invokestatic 43	com/baidu/location/b/k:ai	()Ljava/lang/String;
    //   3: astore_2
    //   4: aload_2
    //   5: ifnonnull +7 -> 12
    //   8: ldc2_w 44
    //   11: lreturn
    //   12: new 47	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 57	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 22	com/baidu/location/b/n:jdField_try	Ljava/lang/String;
    //   33: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_3
    //   40: aconst_null
    //   41: astore 4
    //   43: new 62	java/io/RandomAccessFile
    //   46: dup
    //   47: aload_3
    //   48: ldc 64
    //   50: invokespecial 67	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: astore 5
    //   55: iload_1
    //   56: i2l
    //   57: lstore 6
    //   59: aload 5
    //   61: lload 6
    //   63: invokevirtual 71	java/io/RandomAccessFile:seek	(J)V
    //   66: aload 5
    //   68: invokevirtual 75	java/io/RandomAccessFile:readInt	()I
    //   71: istore 12
    //   73: aload 5
    //   75: invokevirtual 79	java/io/RandomAccessFile:readLong	()J
    //   78: lstore 13
    //   80: aload 5
    //   82: invokevirtual 75	java/io/RandomAccessFile:readInt	()I
    //   85: istore 15
    //   87: iload 12
    //   89: iload 15
    //   91: if_icmpne +16 -> 107
    //   94: aload 5
    //   96: ifnull +8 -> 104
    //   99: aload 5
    //   101: invokevirtual 82	java/io/RandomAccessFile:close	()V
    //   104: lload 13
    //   106: lreturn
    //   107: aload 5
    //   109: ifnull -101 -> 8
    //   112: aload 5
    //   114: invokevirtual 82	java/io/RandomAccessFile:close	()V
    //   117: ldc2_w 44
    //   120: lreturn
    //   121: astore 16
    //   123: ldc2_w 44
    //   126: lreturn
    //   127: astore 18
    //   129: aload 4
    //   131: ifnull -123 -> 8
    //   134: aload 4
    //   136: invokevirtual 82	java/io/RandomAccessFile:close	()V
    //   139: ldc2_w 44
    //   142: lreturn
    //   143: astore 9
    //   145: ldc2_w 44
    //   148: lreturn
    //   149: astore 10
    //   151: aconst_null
    //   152: astore 5
    //   154: aload 5
    //   156: ifnull +8 -> 164
    //   159: aload 5
    //   161: invokevirtual 82	java/io/RandomAccessFile:close	()V
    //   164: aload 10
    //   166: athrow
    //   167: astore 17
    //   169: goto -65 -> 104
    //   172: astore 11
    //   174: goto -10 -> 164
    //   177: astore 10
    //   179: goto -25 -> 154
    //   182: astore 8
    //   184: aload 5
    //   186: astore 4
    //   188: goto -59 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   112	117	121	java/io/IOException
    //   43	55	127	java/lang/Exception
    //   134	139	143	java/io/IOException
    //   43	55	149	finally
    //   99	104	167	java/io/IOException
    //   159	164	172	java/io/IOException
    //   59	87	177	finally
    //   59	87	182	java/lang/Exception
  }

  private void a(int paramInt, long paramLong)
  {
    String str1 = k.ai();
    if (str1 == null)
      return;
    String str2 = str1 + File.separator + this.jdField_try;
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(str2, "rw");
      localRandomAccessFile.seek(paramInt);
      localRandomAccessFile.writeInt(this.jdField_for);
      localRandomAccessFile.writeLong(paramLong);
      localRandomAccessFile.writeInt(this.jdField_for);
      localRandomAccessFile.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static n jdField_if()
  {
    if (jdField_if == null)
      jdField_if = new n();
    return jdField_if;
  }

  public long a()
  {
    return a(this.a);
  }

  public void a(long paramLong)
  {
    a(this.jdField_int, paramLong);
  }

  public long jdField_do()
  {
    return a(this.jdField_do);
  }

  public void jdField_do(long paramLong)
  {
    a(this.a, paramLong);
  }

  public long jdField_for()
  {
    return a(this.jdField_int);
  }

  public void jdField_for(long paramLong)
  {
    a(this.jdField_do, paramLong);
  }

  public void jdField_if(long paramLong)
  {
    a(this.jdField_new, paramLong);
  }

  public long jdField_int()
  {
    return a(this.jdField_new);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.n
 * JD-Core Version:    0.6.0
 */