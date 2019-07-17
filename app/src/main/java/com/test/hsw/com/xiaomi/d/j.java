package com.xiaomi.d;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;

public final class j
{
  private static int a = 5000;
  private static int b = 330000;
  private static int c = 300000;
  private static int d = 330000;
  private static Vector<String> e = new Vector();

  // ERROR //
  static
  {
    // Byte code:
    //   0: sipush 5000
    //   3: putstatic 18	com/xiaomi/d/j:a	I
    //   6: ldc 19
    //   8: putstatic 21	com/xiaomi/d/j:b	I
    //   11: ldc 22
    //   13: putstatic 24	com/xiaomi/d/j:c	I
    //   16: ldc 19
    //   18: putstatic 26	com/xiaomi/d/j:d	I
    //   21: new 28	java/util/Vector
    //   24: dup
    //   25: invokespecial 31	java/util/Vector:<init>	()V
    //   28: putstatic 33	com/xiaomi/d/j:e	Ljava/util/Vector;
    //   31: invokestatic 36	com/xiaomi/d/j:d	()[Ljava/lang/ClassLoader;
    //   34: astore_1
    //   35: aload_1
    //   36: arraylength
    //   37: istore_2
    //   38: iconst_0
    //   39: istore_3
    //   40: iload_3
    //   41: iload_2
    //   42: if_icmpge +234 -> 276
    //   45: aload_1
    //   46: iload_3
    //   47: aaload
    //   48: ldc 38
    //   50: invokevirtual 44	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   53: astore 4
    //   55: aload 4
    //   57: invokeinterface 50 1 0
    //   62: ifeq +247 -> 309
    //   65: aload 4
    //   67: invokeinterface 54 1 0
    //   72: checkcast 56	java/net/URL
    //   75: astore 5
    //   77: aconst_null
    //   78: astore 6
    //   80: aload 5
    //   82: invokevirtual 60	java/net/URL:openStream	()Ljava/io/InputStream;
    //   85: astore 6
    //   87: invokestatic 66	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   90: invokevirtual 70	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   93: astore 11
    //   95: aload 11
    //   97: ldc 72
    //   99: iconst_1
    //   100: invokeinterface 78 3 0
    //   105: aload 11
    //   107: aload 6
    //   109: ldc 80
    //   111: invokeinterface 84 3 0
    //   116: aload 11
    //   118: invokeinterface 88 1 0
    //   123: istore 12
    //   125: iload 12
    //   127: iconst_2
    //   128: if_icmpne +23 -> 151
    //   131: aload 11
    //   133: invokeinterface 92 1 0
    //   138: ldc 94
    //   140: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   143: ifeq +40 -> 183
    //   146: aload 11
    //   148: invokestatic 103	com/xiaomi/d/j:a	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   151: aload 11
    //   153: invokeinterface 106 1 0
    //   158: istore 14
    //   160: iload 14
    //   162: istore 12
    //   164: iload 12
    //   166: iconst_1
    //   167: if_icmpne -42 -> 125
    //   170: aload 6
    //   172: invokevirtual 111	java/io/InputStream:close	()V
    //   175: goto -120 -> 55
    //   178: astore 15
    //   180: goto -125 -> 55
    //   183: aload 11
    //   185: invokeinterface 92 1 0
    //   190: ldc 113
    //   192: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifeq +37 -> 232
    //   198: aload 11
    //   200: getstatic 18	com/xiaomi/d/j:a	I
    //   203: invokestatic 116	com/xiaomi/d/j:a	(Lorg/xmlpull/v1/XmlPullParser;I)I
    //   206: putstatic 18	com/xiaomi/d/j:a	I
    //   209: goto -58 -> 151
    //   212: astore 9
    //   214: aload 9
    //   216: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   219: aload 6
    //   221: invokevirtual 111	java/io/InputStream:close	()V
    //   224: goto -169 -> 55
    //   227: astore 10
    //   229: goto -174 -> 55
    //   232: aload 11
    //   234: invokeinterface 92 1 0
    //   239: ldc 121
    //   241: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifeq +33 -> 277
    //   247: aload 11
    //   249: getstatic 21	com/xiaomi/d/j:b	I
    //   252: invokestatic 116	com/xiaomi/d/j:a	(Lorg/xmlpull/v1/XmlPullParser;I)I
    //   255: putstatic 21	com/xiaomi/d/j:b	I
    //   258: goto -107 -> 151
    //   261: astore 7
    //   263: aload 6
    //   265: invokevirtual 111	java/io/InputStream:close	()V
    //   268: aload 7
    //   270: athrow
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   276: return
    //   277: aload 11
    //   279: invokeinterface 92 1 0
    //   284: ldc 123
    //   286: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   289: ifeq -138 -> 151
    //   292: getstatic 33	com/xiaomi/d/j:e	Ljava/util/Vector;
    //   295: aload 11
    //   297: invokeinterface 126 1 0
    //   302: invokevirtual 129	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   305: pop
    //   306: goto -155 -> 151
    //   309: iinc 3 1
    //   312: goto -272 -> 40
    //   315: astore 8
    //   317: goto -49 -> 268
    //
    // Exception table:
    //   from	to	target	type
    //   170	175	178	java/lang/Exception
    //   80	125	212	java/lang/Exception
    //   131	151	212	java/lang/Exception
    //   151	160	212	java/lang/Exception
    //   183	209	212	java/lang/Exception
    //   232	258	212	java/lang/Exception
    //   277	306	212	java/lang/Exception
    //   219	224	227	java/lang/Exception
    //   80	125	261	finally
    //   131	151	261	finally
    //   151	160	261	finally
    //   183	209	261	finally
    //   214	219	261	finally
    //   232	258	261	finally
    //   277	306	261	finally
    //   31	38	271	java/lang/Exception
    //   45	55	271	java/lang/Exception
    //   55	77	271	java/lang/Exception
    //   268	271	271	java/lang/Exception
    //   263	268	315	java/lang/Exception
  }

  private static int a(XmlPullParser paramXmlPullParser, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramXmlPullParser.nextText());
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return paramInt;
  }

  public static String a()
  {
    return "3.1.0";
  }

  private static void a(XmlPullParser paramXmlPullParser)
  {
    String str = paramXmlPullParser.nextText();
    try
    {
      Class.forName(str);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + str);
    }
  }

  public static int b()
  {
    return b;
  }

  public static int c()
  {
    return c;
  }

  private static ClassLoader[] d()
  {
    int i = 0;
    ClassLoader[] arrayOfClassLoader = new ClassLoader[2];
    arrayOfClassLoader[0] = j.class.getClassLoader();
    arrayOfClassLoader[1] = Thread.currentThread().getContextClassLoader();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfClassLoader.length;
    while (i < j)
    {
      ClassLoader localClassLoader = arrayOfClassLoader[i];
      if (localClassLoader != null)
        localArrayList.add(localClassLoader);
      i++;
    }
    return (ClassLoader[])localArrayList.toArray(new ClassLoader[localArrayList.size()]);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.d.j
 * JD-Core Version:    0.6.0
 */