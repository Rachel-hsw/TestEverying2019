package com.squareup.a.a;

import b.e;
import com.squareup.a.v;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public class j
{
  private static final j a = c();

  public static j a()
  {
    return a;
  }

  static byte[] a(List<v> paramList)
  {
    e locale = new e();
    int i = paramList.size();
    int j = 0;
    if (j < i)
    {
      v localv = (v)paramList.get(j);
      if (localv == v.a);
      while (true)
      {
        j++;
        break;
        locale.a(localv.toString().length());
        locale.a(localv.toString());
      }
    }
    return locale.u();
  }

  // ERROR //
  private static j c()
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   5: astore 34
    //   7: aload 34
    //   9: astore 15
    //   11: iconst_1
    //   12: anewarray 63	java/lang/Class
    //   15: astore 16
    //   17: aload 16
    //   19: iconst_0
    //   20: getstatic 73	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   23: aastore
    //   24: aload 15
    //   26: ldc 75
    //   28: aload 16
    //   30: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   33: astore 17
    //   35: aload 15
    //   37: ldc 81
    //   39: iconst_1
    //   40: anewarray 63	java/lang/Class
    //   43: dup
    //   44: iconst_0
    //   45: ldc 42
    //   47: aastore
    //   48: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   51: astore 18
    //   53: ldc 83
    //   55: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   58: astore 29
    //   60: aload 29
    //   62: ldc 85
    //   64: iconst_1
    //   65: anewarray 63	java/lang/Class
    //   68: dup
    //   69: iconst_0
    //   70: ldc 87
    //   72: aastore
    //   73: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   76: astore 30
    //   78: aload 30
    //   80: astore 20
    //   82: aload 29
    //   84: ldc 89
    //   86: iconst_1
    //   87: anewarray 63	java/lang/Class
    //   90: dup
    //   91: iconst_0
    //   92: ldc 87
    //   94: aastore
    //   95: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   98: astore 33
    //   100: aload 33
    //   102: astore 21
    //   104: aload 15
    //   106: ldc 91
    //   108: iconst_1
    //   109: anewarray 63	java/lang/Class
    //   112: dup
    //   113: iconst_0
    //   114: ldc 93
    //   116: aastore
    //   117: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   120: astore 25
    //   122: aload 25
    //   124: astore 23
    //   126: aload 15
    //   128: ldc 95
    //   130: iconst_0
    //   131: anewarray 63	java/lang/Class
    //   134: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   137: astore 27
    //   139: aload 27
    //   141: astore 24
    //   143: new 97	com/squareup/a/a/j$a
    //   146: dup
    //   147: aload 15
    //   149: aload 17
    //   151: aload 18
    //   153: aload 20
    //   155: aload 21
    //   157: aload 23
    //   159: aload 24
    //   161: aconst_null
    //   162: invokespecial 100	com/squareup/a/a/j$a:<init>	(Ljava/lang/Class;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/squareup/a/a/j$1;)V
    //   165: areturn
    //   166: astore 12
    //   168: ldc 102
    //   170: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   173: astore 14
    //   175: aload 14
    //   177: astore 15
    //   179: goto -168 -> 11
    //   182: astore 28
    //   184: aconst_null
    //   185: astore 20
    //   187: aconst_null
    //   188: astore 21
    //   190: goto -86 -> 104
    //   193: astore 19
    //   195: aconst_null
    //   196: astore 20
    //   198: aconst_null
    //   199: astore 21
    //   201: goto -97 -> 104
    //   204: astore 22
    //   206: aconst_null
    //   207: astore 23
    //   209: aconst_null
    //   210: astore 24
    //   212: goto -69 -> 143
    //   215: astore_0
    //   216: ldc 104
    //   218: astore_1
    //   219: aload_1
    //   220: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   223: astore 11
    //   225: aload 11
    //   227: astore 5
    //   229: new 106	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   236: aload_1
    //   237: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: ldc 113
    //   242: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   251: astore 7
    //   253: new 106	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   260: aload_1
    //   261: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 116
    //   266: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   275: astore 8
    //   277: new 106	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   284: aload_1
    //   285: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 118
    //   290: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   299: astore 9
    //   301: new 120	com/squareup/a/a/j$b
    //   304: dup
    //   305: aload 5
    //   307: ldc 122
    //   309: iconst_2
    //   310: anewarray 63	java/lang/Class
    //   313: dup
    //   314: iconst_0
    //   315: ldc 124
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload 7
    //   322: aastore
    //   323: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   326: aload 5
    //   328: ldc 125
    //   330: iconst_1
    //   331: anewarray 63	java/lang/Class
    //   334: dup
    //   335: iconst_0
    //   336: ldc 124
    //   338: aastore
    //   339: invokevirtual 79	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   342: aload 8
    //   344: aload 9
    //   346: invokespecial 128	com/squareup/a/a/j$b:<init>	(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V
    //   349: astore 10
    //   351: aload 10
    //   353: areturn
    //   354: astore 6
    //   356: new 2	com/squareup/a/a/j
    //   359: dup
    //   360: invokespecial 129	com/squareup/a/a/j:<init>	()V
    //   363: areturn
    //   364: astore_3
    //   365: ldc 131
    //   367: astore_1
    //   368: aload_1
    //   369: invokestatic 67	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   372: astore 4
    //   374: aload 4
    //   376: astore 5
    //   378: goto -149 -> 229
    //   381: astore_2
    //   382: goto -26 -> 356
    //   385: astore 13
    //   387: goto -171 -> 216
    //   390: astore 26
    //   392: goto -183 -> 209
    //   395: astore 32
    //   397: goto -199 -> 198
    //   400: astore 31
    //   402: goto -215 -> 187
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	166	java/lang/ClassNotFoundException
    //   53	78	182	java/lang/ClassNotFoundException
    //   53	78	193	java/lang/NoSuchMethodException
    //   104	122	204	java/lang/NoSuchMethodException
    //   0	7	215	java/lang/NoSuchMethodException
    //   11	53	215	java/lang/NoSuchMethodException
    //   143	166	215	java/lang/NoSuchMethodException
    //   168	175	215	java/lang/NoSuchMethodException
    //   229	351	354	java/lang/ClassNotFoundException
    //   368	374	354	java/lang/ClassNotFoundException
    //   219	225	364	java/lang/ClassNotFoundException
    //   219	225	381	java/lang/NoSuchMethodException
    //   229	351	381	java/lang/NoSuchMethodException
    //   368	374	381	java/lang/NoSuchMethodException
    //   11	53	385	java/lang/ClassNotFoundException
    //   104	122	385	java/lang/ClassNotFoundException
    //   126	139	385	java/lang/ClassNotFoundException
    //   143	166	385	java/lang/ClassNotFoundException
    //   168	175	385	java/lang/ClassNotFoundException
    //   126	139	390	java/lang/NoSuchMethodException
    //   82	100	395	java/lang/NoSuchMethodException
    //   82	100	400	java/lang/ClassNotFoundException
  }

  public String a(SSLSocket paramSSLSocket)
  {
    return null;
  }

  public URI a(URL paramURL)
    throws URISyntaxException
  {
    return paramURL.toURI();
  }

  public void a(String paramString)
  {
    System.out.println(paramString);
  }

  public void a(Socket paramSocket)
    throws SocketException
  {
  }

  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }

  public void a(SSLSocket paramSSLSocket, String paramString1, String paramString2)
  {
    if (paramString2.equals("SSLv3"))
      paramSSLSocket.setEnabledProtocols(new String[] { "SSLv3" });
  }

  public void a(SSLSocket paramSSLSocket, List<v> paramList)
  {
  }

  public String b()
  {
    return "OkHttp";
  }

  public void b(Socket paramSocket)
    throws SocketException
  {
  }

  private static class a extends j
  {
    protected final Class<?> a;
    private final Method b;
    private final Method c;
    private final Method d;
    private final Method e;
    private final Method f;
    private final Method g;

    private a(Class<?> paramClass, Method paramMethod1, Method paramMethod2, Method paramMethod3, Method paramMethod4, Method paramMethod5, Method paramMethod6)
    {
      this.a = paramClass;
      this.b = paramMethod1;
      this.c = paramMethod2;
      this.d = paramMethod3;
      this.e = paramMethod4;
      this.f = paramMethod5;
      this.g = paramMethod6;
    }

    public String a(SSLSocket paramSSLSocket)
    {
      if (this.g == null)
        return null;
      if (!this.a.isInstance(paramSSLSocket))
        return null;
      try
      {
        byte[] arrayOfByte = (byte[])(byte[])this.g.invoke(paramSSLSocket, new Object[0]);
        if (arrayOfByte == null)
          return null;
        String str = new String(arrayOfByte, l.d);
        return str;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
      }
      throw new AssertionError(localIllegalAccessException);
    }

    public void a(Socket paramSocket)
      throws SocketException
    {
      if (this.d == null)
        return;
      try
      {
        this.d.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
      }
      throw new RuntimeException(localInvocationTargetException);
    }

    public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
      throws IOException
    {
      IOException localIOException;
      try
      {
        paramSocket.connect(paramInetSocketAddress, paramInt);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        localIOException = new IOException("Exception in connect");
        localIOException.initCause(localSecurityException);
      }
      throw localIOException;
    }

    public void a(SSLSocket paramSSLSocket, String paramString1, String paramString2)
    {
      super.a(paramSSLSocket, paramString1, paramString2);
      if ((paramString2.equals("TLSv1")) && (this.a.isInstance(paramSSLSocket)));
      try
      {
        Method localMethod = this.b;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Boolean.valueOf(true);
        localMethod.invoke(paramSSLSocket, arrayOfObject);
        this.c.invoke(paramSSLSocket, new Object[] { paramString1 });
        return;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException(localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
      }
      throw new AssertionError(localIllegalAccessException);
    }

    public void a(SSLSocket paramSSLSocket, List<v> paramList)
    {
      if (this.f == null);
      do
        return;
      while (!this.a.isInstance(paramSSLSocket));
      try
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = a(paramList);
        this.f.invoke(paramSSLSocket, arrayOfObject);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
      }
      throw new RuntimeException(localInvocationTargetException);
    }

    public void b(Socket paramSocket)
      throws SocketException
    {
      if (this.e == null)
        return;
      try
      {
        this.e.invoke(null, new Object[] { paramSocket });
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException(localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
      }
      throw new RuntimeException(localInvocationTargetException);
    }
  }

  private static class b extends j
  {
    private final Method a;
    private final Method b;
    private final Class<?> c;
    private final Class<?> d;

    public b(Method paramMethod1, Method paramMethod2, Class<?> paramClass1, Class<?> paramClass2)
    {
      this.b = paramMethod1;
      this.a = paramMethod2;
      this.c = paramClass1;
      this.d = paramClass2;
    }

    public String a(SSLSocket paramSSLSocket)
    {
      Object localObject;
      try
      {
        j.c localc = (j.c)Proxy.getInvocationHandler(this.a.invoke(null, new Object[] { paramSSLSocket }));
        if ((!j.c.a(localc)) && (j.c.b(localc) == null))
        {
          Logger.getLogger("com.squareup.okhttp.OkHttpClient").log(Level.INFO, "NPN/ALPN callback dropped: SPDY and HTTP/2 are disabled. Is npn-boot or alpn-boot on the boot class path?");
          return null;
        }
        if (j.c.a(localc))
        {
          localObject = null;
        }
        else
        {
          String str = j.c.b(localc);
          localObject = str;
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new AssertionError();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new AssertionError();
      }
      return localObject;
    }

    public void a(SSLSocket paramSSLSocket, List<v> paramList)
    {
      while (true)
      {
        int j;
        try
        {
          localArrayList = new ArrayList(paramList.size());
          int i = paramList.size();
          j = 0;
          if (j >= i)
            continue;
          v localv = (v)paramList.get(j);
          if (localv != v.a)
            localArrayList.add(localv.toString());
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          ArrayList localArrayList;
          throw new AssertionError(localInvocationTargetException);
          ClassLoader localClassLoader = j.class.getClassLoader();
          Class[] arrayOfClass = new Class[2];
          arrayOfClass[0] = this.c;
          arrayOfClass[1] = this.d;
          Object localObject = Proxy.newProxyInstance(localClassLoader, arrayOfClass, new j.c(localArrayList));
          this.b.invoke(null, new Object[] { paramSSLSocket, localObject });
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new AssertionError(localIllegalAccessException);
        }
        j++;
      }
    }
  }

  private static class c
    implements InvocationHandler
  {
    private final List<String> a;
    private boolean b;
    private String c;

    public c(List<String> paramList)
    {
      this.a = paramList;
    }

    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str1 = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      if (paramArrayOfObject == null)
        paramArrayOfObject = l.b;
      if ((str1.equals("supports")) && (Boolean.TYPE == localClass))
        return Boolean.valueOf(true);
      if ((str1.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.b = true;
        return null;
      }
      if ((str1.equals("protocols")) && (paramArrayOfObject.length == 0))
        return this.a;
      if (((str1.equals("selectProtocol")) || (str1.equals("select"))) && (String.class == localClass) && (paramArrayOfObject.length == 1) && ((paramArrayOfObject[0] instanceof List)))
      {
        List localList = (List)paramArrayOfObject[0];
        int i = localList.size();
        for (int j = 0; j < i; j++)
        {
          if (!this.a.contains(localList.get(j)))
            continue;
          String str3 = (String)localList.get(j);
          this.c = str3;
          return str3;
        }
        String str2 = (String)this.a.get(0);
        this.c = str2;
        return str2;
      }
      if (((str1.equals("protocolSelected")) || (str1.equals("selected"))) && (paramArrayOfObject.length == 1))
      {
        this.c = ((String)paramArrayOfObject[0]);
        return null;
      }
      return paramMethod.invoke(this, paramArrayOfObject);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.j
 * JD-Core Version:    0.6.0
 */