package org.a.a.a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;

public class t
{
  // ERROR //
  public static <T extends Serializable> T a(T paramT)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aload_1
    //   7: areturn
    //   8: new 16	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokestatic 20	org/a/a/a/t:b	(Ljava/io/Serializable;)[B
    //   16: invokespecial 23	java/io/ByteArrayInputStream:<init>	([B)V
    //   19: astore_2
    //   20: new 25	org/a/a/a/t$a
    //   23: dup
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 29	java/lang/Object:getClass	()Ljava/lang/Class;
    //   29: invokevirtual 35	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   32: invokespecial 38	org/a/a/a/t$a:<init>	(Ljava/io/InputStream;Ljava/lang/ClassLoader;)V
    //   35: astore_3
    //   36: aload_3
    //   37: invokevirtual 42	org/a/a/a/t$a:readObject	()Ljava/lang/Object;
    //   40: checkcast 44	java/io/Serializable
    //   43: astore_1
    //   44: aload_3
    //   45: ifnull -39 -> 6
    //   48: aload_3
    //   49: invokevirtual 47	org/a/a/a/t$a:close	()V
    //   52: aload_1
    //   53: areturn
    //   54: astore 8
    //   56: new 49	org/a/a/a/s
    //   59: dup
    //   60: ldc 51
    //   62: aload 8
    //   64: invokespecial 54	org/a/a/a/s:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: athrow
    //   68: astore 11
    //   70: aconst_null
    //   71: astore_3
    //   72: aload 11
    //   74: astore 4
    //   76: new 49	org/a/a/a/s
    //   79: dup
    //   80: ldc 56
    //   82: aload 4
    //   84: invokespecial 54	org/a/a/a/s:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: athrow
    //   88: astore 5
    //   90: aload_3
    //   91: ifnull +7 -> 98
    //   94: aload_3
    //   95: invokevirtual 47	org/a/a/a/t$a:close	()V
    //   98: aload 5
    //   100: athrow
    //   101: astore 10
    //   103: aconst_null
    //   104: astore_3
    //   105: aload 10
    //   107: astore 7
    //   109: new 49	org/a/a/a/s
    //   112: dup
    //   113: ldc 58
    //   115: aload 7
    //   117: invokespecial 54	org/a/a/a/s:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   120: athrow
    //   121: astore 6
    //   123: new 49	org/a/a/a/s
    //   126: dup
    //   127: ldc 51
    //   129: aload 6
    //   131: invokespecial 54	org/a/a/a/s:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: athrow
    //   135: astore 9
    //   137: aload 9
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_3
    //   143: goto -53 -> 90
    //   146: astore 7
    //   148: goto -39 -> 109
    //   151: astore 4
    //   153: goto -77 -> 76
    //
    // Exception table:
    //   from	to	target	type
    //   48	52	54	java/io/IOException
    //   20	36	68	java/lang/ClassNotFoundException
    //   36	44	88	finally
    //   76	88	88	finally
    //   109	121	88	finally
    //   20	36	101	java/io/IOException
    //   94	98	121	java/io/IOException
    //   20	36	135	finally
    //   36	44	146	java/io/IOException
    //   36	44	151	java/lang/ClassNotFoundException
  }

  // ERROR //
  public static Object a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 61	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 63
    //   10: invokespecial 66	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aconst_null
    //   15: astore_1
    //   16: new 68	java/io/ObjectInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 71	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 72	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   29: astore 7
    //   31: aload_2
    //   32: ifnull +7 -> 39
    //   35: aload_2
    //   36: invokevirtual 73	java/io/ObjectInputStream:close	()V
    //   39: aload 7
    //   41: areturn
    //   42: astore_3
    //   43: aconst_null
    //   44: astore_2
    //   45: new 49	org/a/a/a/s
    //   48: dup
    //   49: aload_3
    //   50: invokespecial 76	org/a/a/a/s:<init>	(Ljava/lang/Throwable;)V
    //   53: athrow
    //   54: astore 4
    //   56: aload_2
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 73	java/io/ObjectInputStream:close	()V
    //   66: aload 4
    //   68: athrow
    //   69: astore 6
    //   71: new 49	org/a/a/a/s
    //   74: dup
    //   75: aload 6
    //   77: invokespecial 76	org/a/a/a/s:<init>	(Ljava/lang/Throwable;)V
    //   80: athrow
    //   81: astore 4
    //   83: goto -25 -> 58
    //   86: astore 8
    //   88: aload 7
    //   90: areturn
    //   91: astore 5
    //   93: goto -27 -> 66
    //   96: astore 6
    //   98: aload_2
    //   99: astore_1
    //   100: goto -29 -> 71
    //   103: astore_3
    //   104: goto -59 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   16	25	42	java/lang/ClassNotFoundException
    //   25	31	54	finally
    //   45	54	54	finally
    //   16	25	69	java/io/IOException
    //   16	25	81	finally
    //   71	81	81	finally
    //   35	39	86	java/io/IOException
    //   62	66	91	java/io/IOException
    //   25	31	96	java/io/IOException
    //   25	31	103	java/lang/ClassNotFoundException
  }

  public static Object a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      throw new IllegalArgumentException("The byte[] must not be null");
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }

  // ERROR //
  public static void a(Serializable paramSerializable, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 61	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 84
    //   10: invokespecial 66	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: new 86	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 89	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 93	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload_2
    //   29: ifnull +7 -> 36
    //   32: aload_2
    //   33: invokevirtual 94	java/io/ObjectOutputStream:close	()V
    //   36: return
    //   37: astore_3
    //   38: aconst_null
    //   39: astore_2
    //   40: new 49	org/a/a/a/s
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 76	org/a/a/a/s:<init>	(Ljava/lang/Throwable;)V
    //   48: athrow
    //   49: astore 4
    //   51: aload_2
    //   52: ifnull +7 -> 59
    //   55: aload_2
    //   56: invokevirtual 94	java/io/ObjectOutputStream:close	()V
    //   59: aload 4
    //   61: athrow
    //   62: astore 6
    //   64: return
    //   65: astore 5
    //   67: goto -8 -> 59
    //   70: astore 4
    //   72: aconst_null
    //   73: astore_2
    //   74: goto -23 -> 51
    //   77: astore_3
    //   78: goto -38 -> 40
    //
    // Exception table:
    //   from	to	target	type
    //   14	23	37	java/io/IOException
    //   23	28	49	finally
    //   40	49	49	finally
    //   32	36	62	java/io/IOException
    //   55	59	65	java/io/IOException
    //   14	23	70	finally
    //   23	28	77	java/io/IOException
  }

  public static byte[] b(Serializable paramSerializable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(512);
    a(paramSerializable, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  static class a extends ObjectInputStream
  {
    private ClassLoader a;

    public a(InputStream paramInputStream, ClassLoader paramClassLoader)
      throws IOException
    {
      super();
      this.a = paramClassLoader;
    }

    protected Class<?> resolveClass(ObjectStreamClass paramObjectStreamClass)
      throws IOException, ClassNotFoundException
    {
      String str = paramObjectStreamClass.getName();
      try
      {
        Class localClass = Class.forName(str, false, this.a);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
      }
      return Class.forName(str, false, Thread.currentThread().getContextClassLoader());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.t
 * JD-Core Version:    0.6.0
 */