package com.ta.utdid2.c.a;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public final class d
{
  private static final Object c = new Object();
  private final Object a = new Object();
  private File b;
  private HashMap<File, a> d = new HashMap();

  public d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.b = new File(paramString);
      return;
    }
    throw new RuntimeException("Directory can not be empty");
  }

  private File b()
  {
    synchronized (this.a)
    {
      File localFile = this.b;
      return localFile;
    }
  }

  private static File b(File paramFile)
  {
    return new File(paramFile.getPath() + ".bak");
  }

  // ERROR //
  public final b a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 76	com/ta/utdid2/c/a/d:b	()Ljava/io/File;
    //   4: astore_2
    //   5: new 51	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc 78
    //   18: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_3
    //   25: aload_3
    //   26: getstatic 82	java/io/File:separatorChar	C
    //   29: invokevirtual 86	java/lang/String:indexOf	(I)I
    //   32: ifge +55 -> 87
    //   35: new 35	java/io/File
    //   38: dup
    //   39: aload_2
    //   40: aload_3
    //   41: invokespecial 89	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   44: astore 4
    //   46: getstatic 19	com/ta/utdid2/c/a/d:c	Ljava/lang/Object;
    //   49: astore 5
    //   51: aload 5
    //   53: monitorenter
    //   54: aload_0
    //   55: getfield 27	com/ta/utdid2/c/a/d:d	Ljava/util/HashMap;
    //   58: aload 4
    //   60: invokevirtual 93	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 95	com/ta/utdid2/c/a/d$a
    //   66: astore 7
    //   68: aload 7
    //   70: ifnull +46 -> 116
    //   73: aload 7
    //   75: invokevirtual 99	com/ta/utdid2/c/a/d$a:e	()Z
    //   78: ifne +38 -> 116
    //   81: aload 5
    //   83: monitorexit
    //   84: aload 7
    //   86: areturn
    //   87: new 101	java/lang/IllegalArgumentException
    //   90: dup
    //   91: new 51	java/lang/StringBuilder
    //   94: dup
    //   95: ldc 103
    //   97: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: aload_3
    //   101: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 106
    //   106: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 107	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    //   116: aload 5
    //   118: monitorexit
    //   119: aload 4
    //   121: invokestatic 47	com/ta/utdid2/c/a/d:b	(Ljava/io/File;)Ljava/io/File;
    //   124: astore 8
    //   126: aload 8
    //   128: invokevirtual 110	java/io/File:exists	()Z
    //   131: ifeq +17 -> 148
    //   134: aload 4
    //   136: invokevirtual 113	java/io/File:delete	()Z
    //   139: pop
    //   140: aload 8
    //   142: aload 4
    //   144: invokevirtual 117	java/io/File:renameTo	(Ljava/io/File;)Z
    //   147: pop
    //   148: aload 4
    //   150: invokevirtual 110	java/io/File:exists	()Z
    //   153: ifeq +9 -> 162
    //   156: aload 4
    //   158: invokevirtual 120	java/io/File:canRead	()Z
    //   161: pop
    //   162: aload 4
    //   164: invokevirtual 110	java/io/File:exists	()Z
    //   167: ifeq +288 -> 455
    //   170: aload 4
    //   172: invokevirtual 120	java/io/File:canRead	()Z
    //   175: ifeq +280 -> 455
    //   178: new 122	java/io/FileInputStream
    //   181: dup
    //   182: aload 4
    //   184: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   187: astore 13
    //   189: invokestatic 131	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   192: astore 27
    //   194: aload 27
    //   196: aload 13
    //   198: aconst_null
    //   199: invokeinterface 137 3 0
    //   204: aload 27
    //   206: iconst_1
    //   207: anewarray 29	java/lang/String
    //   210: invokestatic 142	com/ta/utdid2/c/a/e:a	(Lorg/xmlpull/v1/XmlPullParser;[Ljava/lang/String;)Ljava/lang/Object;
    //   213: checkcast 24	java/util/HashMap
    //   216: astore 9
    //   218: aload 13
    //   220: invokevirtual 145	java/io/FileInputStream:close	()V
    //   223: getstatic 19	com/ta/utdid2/c/a/d:c	Ljava/lang/Object;
    //   226: astore 10
    //   228: aload 10
    //   230: monitorenter
    //   231: aload 7
    //   233: ifnull +155 -> 388
    //   236: aload 7
    //   238: aload 9
    //   240: invokevirtual 148	com/ta/utdid2/c/a/d$a:a	(Ljava/util/Map;)V
    //   243: aload 10
    //   245: monitorexit
    //   246: aload 7
    //   248: areturn
    //   249: astore 12
    //   251: aload 10
    //   253: monitorexit
    //   254: aload 12
    //   256: athrow
    //   257: astore 6
    //   259: aload 5
    //   261: monitorexit
    //   262: aload 6
    //   264: athrow
    //   265: astore 20
    //   267: aconst_null
    //   268: astore 9
    //   270: new 122	java/io/FileInputStream
    //   273: dup
    //   274: aload 4
    //   276: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   279: astore 21
    //   281: aload 21
    //   283: invokevirtual 151	java/io/FileInputStream:available	()I
    //   286: newarray byte
    //   288: astore 24
    //   290: aload 21
    //   292: aload 24
    //   294: invokevirtual 155	java/io/FileInputStream:read	([B)I
    //   297: pop
    //   298: new 29	java/lang/String
    //   301: dup
    //   302: aload 24
    //   304: iconst_0
    //   305: aload 24
    //   307: arraylength
    //   308: ldc 157
    //   310: invokespecial 160	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   313: pop
    //   314: goto -91 -> 223
    //   317: astore 23
    //   319: aload 23
    //   321: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   324: goto -101 -> 223
    //   327: astore 22
    //   329: aload 22
    //   331: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   334: goto -111 -> 223
    //   337: astore 18
    //   339: aconst_null
    //   340: astore 9
    //   342: aload 18
    //   344: astore 19
    //   346: aload 19
    //   348: invokevirtual 163	java/io/FileNotFoundException:printStackTrace	()V
    //   351: goto -128 -> 223
    //   354: astore 16
    //   356: aconst_null
    //   357: astore 9
    //   359: aload 16
    //   361: astore 17
    //   363: aload 17
    //   365: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   368: goto -145 -> 223
    //   371: astore 14
    //   373: aconst_null
    //   374: astore 9
    //   376: aload 14
    //   378: astore 15
    //   380: aload 15
    //   382: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   385: goto -162 -> 223
    //   388: aload_0
    //   389: getfield 27	com/ta/utdid2/c/a/d:d	Ljava/util/HashMap;
    //   392: aload 4
    //   394: invokevirtual 93	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   397: checkcast 95	com/ta/utdid2/c/a/d$a
    //   400: astore 7
    //   402: aload 7
    //   404: ifnonnull -161 -> 243
    //   407: new 95	com/ta/utdid2/c/a/d$a
    //   410: dup
    //   411: aload 4
    //   413: aload 9
    //   415: invokespecial 168	com/ta/utdid2/c/a/d$a:<init>	(Ljava/io/File;Ljava/util/Map;)V
    //   418: astore 7
    //   420: aload_0
    //   421: getfield 27	com/ta/utdid2/c/a/d:d	Ljava/util/HashMap;
    //   424: aload 4
    //   426: aload 7
    //   428: invokevirtual 172	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   431: pop
    //   432: goto -189 -> 243
    //   435: astore 15
    //   437: goto -57 -> 380
    //   440: astore 17
    //   442: goto -79 -> 363
    //   445: astore 19
    //   447: goto -101 -> 346
    //   450: astore 28
    //   452: goto -182 -> 270
    //   455: aconst_null
    //   456: astore 9
    //   458: goto -235 -> 223
    //
    // Exception table:
    //   from	to	target	type
    //   236	243	249	finally
    //   243	246	249	finally
    //   388	402	249	finally
    //   407	432	249	finally
    //   54	68	257	finally
    //   73	84	257	finally
    //   178	218	265	org/xmlpull/v1/XmlPullParserException
    //   270	314	317	java/io/FileNotFoundException
    //   270	314	327	java/io/IOException
    //   178	218	337	java/io/FileNotFoundException
    //   178	218	354	java/io/IOException
    //   178	218	371	java/lang/Exception
    //   218	223	435	java/lang/Exception
    //   218	223	440	java/io/IOException
    //   218	223	445	java/io/FileNotFoundException
    //   218	223	450	org/xmlpull/v1/XmlPullParserException
  }

  private static final class a
    implements b
  {
    private static final Object f = new Object();
    private final File a;
    private final File b;
    private final int c;
    private Map d;
    private boolean e = false;
    private WeakHashMap<b.b, Object> g;

    a(File paramFile, Map paramMap)
    {
      this.a = paramFile;
      this.b = d.a(paramFile);
      this.c = 0;
      if (paramMap != null);
      while (true)
      {
        this.d = paramMap;
        this.g = new WeakHashMap();
        return;
        paramMap = new HashMap();
      }
    }

    private static FileOutputStream a(File paramFile)
    {
      try
      {
        FileOutputStream localFileOutputStream1 = new FileOutputStream(paramFile);
        return localFileOutputStream1;
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        if (!paramFile.getParentFile().mkdir())
          return null;
        try
        {
          FileOutputStream localFileOutputStream2 = new FileOutputStream(paramFile);
          return localFileOutputStream2;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
        }
      }
      return null;
    }

    private boolean f()
    {
      if (this.a.exists())
        if (!this.b.exists())
          if (this.a.renameTo(this.b))
            break label44;
      while (true)
      {
        return false;
        this.a.delete();
        try
        {
          label44: FileOutputStream localFileOutputStream = a(this.a);
          if (localFileOutputStream == null)
            continue;
          Map localMap = this.d;
          a locala = new a();
          locala.setOutput(localFileOutputStream, "utf-8");
          locala.startDocument(null, Boolean.valueOf(true));
          locala.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
          e.a(localMap, null, locala);
          locala.endDocument();
          localFileOutputStream.close();
          this.b.delete();
          return true;
        }
        catch (IOException localIOException)
        {
          if (!this.a.exists())
            continue;
          this.a.delete();
          return false;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          label137: break label137;
        }
      }
    }

    public final long a(String paramString)
    {
      monitorenter;
      try
      {
        Long localLong = (Long)this.d.get(paramString);
        long l;
        if (localLong != null)
          l = localLong.longValue();
        while (true)
        {
          return l;
          l = 0L;
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    public final String a(String paramString1, String paramString2)
    {
      monitorenter;
      try
      {
        String str = (String)this.d.get(paramString1);
        if (str != null);
        while (true)
        {
          return str;
          str = paramString2;
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    public final void a(Map paramMap)
    {
      if (paramMap != null)
        monitorenter;
      try
      {
        this.d = paramMap;
        monitorexit;
        return;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public final boolean a()
    {
      return (this.a != null) && (new File(this.a.getAbsolutePath()).exists());
    }

    public final Map<String, ?> b()
    {
      monitorenter;
      try
      {
        HashMap localHashMap = new HashMap(this.d);
        monitorexit;
        return localHashMap;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public final b.a c()
    {
      return new a();
    }

    public final void d()
    {
      monitorenter;
      try
      {
        this.e = true;
        monitorexit;
        return;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public final boolean e()
    {
      monitorenter;
      try
      {
        boolean bool = this.e;
        monitorexit;
        return bool;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
      throw localObject;
    }

    public final class a
      implements b.a
    {
      private final Map<String, Object> b = new HashMap();
      private boolean c = false;

      public a()
      {
      }

      public final b.a a()
      {
        monitorenter;
        try
        {
          this.c = true;
          monitorexit;
          return this;
        }
        finally
        {
          localObject = finally;
          monitorexit;
        }
        throw localObject;
      }

      public final b.a a(String paramString, float paramFloat)
      {
        monitorenter;
        try
        {
          this.b.put(paramString, Float.valueOf(paramFloat));
          monitorexit;
          return this;
        }
        finally
        {
          localObject = finally;
          monitorexit;
        }
        throw localObject;
      }

      public final b.a a(String paramString, int paramInt)
      {
        monitorenter;
        try
        {
          this.b.put(paramString, Integer.valueOf(paramInt));
          monitorexit;
          return this;
        }
        finally
        {
          localObject = finally;
          monitorexit;
        }
        throw localObject;
      }

      public final b.a a(String paramString, long paramLong)
      {
        monitorenter;
        try
        {
          this.b.put(paramString, Long.valueOf(paramLong));
          monitorexit;
          return this;
        }
        finally
        {
          localObject = finally;
          monitorexit;
        }
        throw localObject;
      }

      public final b.a a(String paramString1, String paramString2)
      {
        monitorenter;
        try
        {
          this.b.put(paramString1, paramString2);
          monitorexit;
          return this;
        }
        finally
        {
          localObject = finally;
          monitorexit;
        }
        throw localObject;
      }

      public final b.a a(String paramString, boolean paramBoolean)
      {
        monitorenter;
        try
        {
          this.b.put(paramString, Boolean.valueOf(paramBoolean));
          monitorexit;
          return this;
        }
        finally
        {
          localObject = finally;
          monitorexit;
        }
        throw localObject;
      }

      public final boolean b()
      {
        while (true)
        {
          String str;
          Object localObject4;
          synchronized (d.a())
          {
            if (d.a.a(d.a.this).size() > 0)
            {
              i = 1;
              if (i == 0)
                break label330;
              ArrayList localArrayList1 = new ArrayList();
              localHashSet = new HashSet(d.a.a(d.a.this).keySet());
              localArrayList2 = localArrayList1;
              monitorenter;
              try
              {
                if (!this.c)
                  continue;
                d.a.b(d.a.this).clear();
                this.c = false;
                Iterator localIterator1 = this.b.entrySet().iterator();
                if (!localIterator1.hasNext())
                  break label217;
                Map.Entry localEntry = (Map.Entry)localIterator1.next();
                str = (String)localEntry.getKey();
                localObject4 = localEntry.getValue();
                if (localObject4 != this)
                  break label197;
                d.a.b(d.a.this).remove(str);
                if (i == 0)
                  continue;
                localArrayList2.add(str);
                continue;
              }
              finally
              {
                monitorexit;
              }
            }
          }
          int i = 0;
          continue;
          label197: d.a.b(d.a.this).put(str, localObject4);
          continue;
          label217: this.b.clear();
          monitorexit;
          boolean bool = d.a.c(d.a.this);
          if (bool)
            d.a.this.d();
          monitorexit;
          if (i != 0)
            for (int j = -1 + localArrayList2.size(); j >= 0; j--)
            {
              localArrayList2.get(j);
              Iterator localIterator2 = localHashSet.iterator();
              while (localIterator2.hasNext())
                if ((b.b)localIterator2.next() == null)
                  continue;
            }
          return bool;
          label330: HashSet localHashSet = null;
          ArrayList localArrayList2 = null;
        }
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.c.a.d
 * JD-Core Version:    0.6.0
 */