package com.himamis.retex.editor.a.e;

import java.io.PrintStream;
import java.util.ArrayList;

public class h
{
  private static final String A = "up";
  private static final String B = "down";
  private static final String C = "code";
  private static final String D = "fontId";
  private static final String E = "initial";
  private static final String F = "insert";
  public static final String a = "Array";
  public static final String b = "Matrix";
  public static final String c = "Characters";
  public static final String d = "General";
  public static final String e = "Operators";
  public static final String f = "Symbols";
  public static final String g = "Functions";
  static final String h = "Open";
  static final String i = "Close";
  static final String j = "Field";
  static final String k = "Row";
  private static final String l = "Character";
  private static final String m = "Operator";
  private static final String n = "Symbol";
  private static final String o = "Function";
  private static final String p = "Parameter";
  private static final String q = "group";
  private static final String r = "columns";
  private static final String s = "name";
  private static final String t = "desc";
  private static final String u = "type";
  private static final String v = "cas";
  private static final String w = "tex";
  private static final String x = "key";
  private static final String y = "unicode";
  private static final String z = "img";
  private com.himamis.retex.renderer.a.g.e G = new com.himamis.retex.renderer.a.g.e();
  private ArrayList<g> H = new ArrayList();
  private int I = 1;
  private int J = 1;
  private int K = 2;
  private int L = 2;

  public h(Object paramObject)
  {
    try
    {
      e(this.G.a(paramObject, true, true));
      return;
    }
    catch (Exception localException)
    {
      System.out.println("parse failed\n");
      localException.printStackTrace();
    }
  }

  public h(String paramString)
  {
    this(h.class.getResourceAsStream(paramString));
  }

  private d a(com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    String str1 = paramc.a();
    String str2 = a("cas", paramc);
    int i1 = str2.length();
    char c1 = '\000';
    if (i1 > 0)
      c1 = str2.charAt(0);
    try
    {
      String str4 = a("tex", paramc);
      str3 = str4;
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          char c3 = c("key", paramc);
          c2 = c3;
          return new d(str1, str2, str3, c2, c2, 1);
          localException1 = localException1;
          String str3 = str2;
        }
      }
      catch (Exception localException2)
      {
        while (true)
          char c2 = c1;
      }
    }
  }

  private static String a(String paramString, com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    String str = paramc.b(paramString);
    if ((str == null) || (str.length() == 0))
      throw new Exception(paramc.a() + " is null.");
    return str;
  }

  private static int b(String paramString, com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    String str = a(paramString, paramc);
    try
    {
      int i1 = Integer.parseInt(str);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new Exception(paramc.a() + " has invalid value.");
  }

  private d b(com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    String str1 = a("name", paramc);
    int i1 = str1.length();
    char c1 = '\000';
    if (i1 > 0)
      c1 = str1.charAt(0);
    try
    {
      String str5 = a("cas", paramc);
      str2 = str5;
    }
    catch (Exception localException3)
    {
      try
      {
        String str4 = a("tex", paramc);
        str3 = str4;
      }
      catch (Exception localException3)
      {
        try
        {
          char c5 = c("key", paramc);
          c2 = c5;
        }
        catch (Exception localException3)
        {
          try
          {
            while (true)
            {
              char c4 = c("unicode", paramc);
              c3 = c4;
              return new d(str1, str2, str3, c2, c3, 1);
              localException1 = localException1;
              String str2 = str1;
              continue;
              localException2 = localException2;
              String str3 = str1;
              continue;
              localException3 = localException3;
              char c2 = c1;
            }
          }
          catch (Exception localException4)
          {
            while (true)
              char c3 = c1;
          }
        }
      }
    }
  }

  private static char c(String paramString, com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    String str = a(paramString, paramc);
    try
    {
      int i1 = str.length();
      int i2 = 0;
      if (i1 > 0)
      {
        int i3 = str.charAt(0);
        i2 = i3;
      }
      return i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new Exception(paramc.a() + " has invalid value.");
  }

  private j c(com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    int i1;
    if (paramc.a().equals("Operator"))
      i1 = 2;
    while (true)
    {
      String str1 = a("name", paramc);
      char c1;
      if (str1.length() > 0)
        c1 = str1.charAt(0);
      try
      {
        String str5 = a("cas", paramc);
        str2 = str5;
      }
      catch (Exception localException5)
      {
        try
        {
          String str4 = a("tex", paramc);
          str3 = str4;
        }
        catch (Exception localException5)
        {
          try
          {
            char c5 = c("key", paramc);
            c2 = c5;
          }
          catch (Exception localException5)
          {
            try
            {
              int i5 = b("code", paramc);
              i2 = i5;
            }
            catch (Exception localException5)
            {
              try
              {
                int i4 = b("fontId", paramc);
                i3 = i4;
              }
              catch (Exception localException5)
              {
                try
                {
                  while (true)
                  {
                    char c4 = c("unicode", paramc);
                    c3 = c4;
                    return new j(str1, str2, str3, c2, (char)i2, c3, i3, i1);
                    i1 = 3;
                    break;
                    c1 = '\000';
                    continue;
                    localException1 = localException1;
                    String str2 = str1;
                    continue;
                    localException2 = localException2;
                    String str3 = str1;
                    continue;
                    localException3 = localException3;
                    char c2 = c1;
                    continue;
                    localException4 = localException4;
                    int i2 = 0;
                    continue;
                    localException5 = localException5;
                    int i3 = 0;
                  }
                }
                catch (Exception localException6)
                {
                  while (true)
                    char c3 = c1;
                }
              }
            }
          }
        }
      }
    }
  }

  // ERROR //
  private f d(com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 80
    //   4: aload_1
    //   5: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 181	java/lang/String:length	()I
    //   13: ifle +151 -> 164
    //   16: aload_3
    //   17: iconst_0
    //   18: invokevirtual 185	java/lang/String:charAt	(I)C
    //   21: istore 4
    //   23: ldc 89
    //   25: aload_1
    //   26: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   29: astore 28
    //   31: aload 28
    //   33: astore 6
    //   35: ldc 92
    //   37: aload_1
    //   38: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   41: astore 27
    //   43: aload 27
    //   45: astore 8
    //   47: ldc 95
    //   49: aload_1
    //   50: invokestatic 188	com/himamis/retex/editor/a/e/h:c	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)C
    //   53: istore 26
    //   55: iload 26
    //   57: istore 10
    //   59: new 124	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 125	java/util/ArrayList:<init>	()V
    //   66: astore 11
    //   68: aload_1
    //   69: ldc 71
    //   71: invokeinterface 241 2 0
    //   76: astore 12
    //   78: iload_2
    //   79: aload 12
    //   81: invokeinterface 245 1 0
    //   86: if_icmplt +109 -> 195
    //   89: new 247	com/himamis/retex/editor/a/e/f
    //   92: dup
    //   93: aload_3
    //   94: aload 6
    //   96: aload 8
    //   98: iload 10
    //   100: aload 11
    //   102: aload 11
    //   104: invokevirtual 250	java/util/ArrayList:size	()I
    //   107: anewarray 252	com/himamis/retex/editor/a/e/i
    //   110: invokevirtual 256	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   113: checkcast 258	[Lcom/himamis/retex/editor/a/e/i;
    //   116: invokespecial 261	com/himamis/retex/editor/a/e/f:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;C[Lcom/himamis/retex/editor/a/e/i;)V
    //   119: astore 13
    //   121: ldc 101
    //   123: aload_1
    //   124: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   127: pop
    //   128: aload 13
    //   130: ldc 83
    //   132: aload_1
    //   133: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   136: invokevirtual 263	com/himamis/retex/editor/a/e/f:a	(Ljava/lang/String;)V
    //   139: aload 13
    //   141: ldc 20
    //   143: aload_1
    //   144: invokestatic 232	com/himamis/retex/editor/a/e/h:b	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)I
    //   147: invokevirtual 266	com/himamis/retex/editor/a/e/f:c	(I)V
    //   150: aload 13
    //   152: ldc 23
    //   154: aload_1
    //   155: invokestatic 232	com/himamis/retex/editor/a/e/h:b	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)I
    //   158: invokevirtual 268	com/himamis/retex/editor/a/e/f:b	(I)V
    //   161: aload 13
    //   163: areturn
    //   164: iconst_0
    //   165: istore 4
    //   167: goto -144 -> 23
    //   170: astore 5
    //   172: aload_3
    //   173: astore 6
    //   175: goto -140 -> 35
    //   178: astore 7
    //   180: aload_3
    //   181: astore 8
    //   183: goto -136 -> 47
    //   186: astore 9
    //   188: iload 4
    //   190: istore 10
    //   192: goto -133 -> 59
    //   195: aload 12
    //   197: iload_2
    //   198: invokeinterface 271 2 0
    //   203: astore 19
    //   205: new 252	com/himamis/retex/editor/a/e/i
    //   208: dup
    //   209: ldc 80
    //   211: aload 19
    //   213: invokeinterface 276 1 0
    //   218: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   221: ldc_w 278
    //   224: aload 19
    //   226: invokeinterface 276 1 0
    //   231: invokestatic 232	com/himamis/retex/editor/a/e/h:b	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)I
    //   234: invokespecial 281	com/himamis/retex/editor/a/e/i:<init>	(Ljava/lang/String;I)V
    //   237: astore 20
    //   239: aload 11
    //   241: aload 20
    //   243: invokevirtual 284	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   246: pop
    //   247: aload 20
    //   249: ldc 86
    //   251: aload 19
    //   253: invokeinterface 276 1 0
    //   258: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   261: invokevirtual 285	com/himamis/retex/editor/a/e/i:a	(Ljava/lang/String;)V
    //   264: aload 20
    //   266: ldc 83
    //   268: aload 19
    //   270: invokeinterface 276 1 0
    //   275: invokestatic 175	com/himamis/retex/editor/a/e/h:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   278: invokevirtual 287	com/himamis/retex/editor/a/e/i:b	(Ljava/lang/String;)V
    //   281: aload 20
    //   283: ldc 8
    //   285: aload 19
    //   287: invokeinterface 276 1 0
    //   292: invokestatic 232	com/himamis/retex/editor/a/e/h:b	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)I
    //   295: invokevirtual 289	com/himamis/retex/editor/a/e/i:a	(I)V
    //   298: aload 20
    //   300: ldc 11
    //   302: aload 19
    //   304: invokeinterface 276 1 0
    //   309: invokestatic 232	com/himamis/retex/editor/a/e/h:b	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)I
    //   312: invokevirtual 290	com/himamis/retex/editor/a/e/i:b	(I)V
    //   315: iinc 2 1
    //   318: goto -240 -> 78
    //   321: astore 17
    //   323: aload 13
    //   325: areturn
    //   326: astore 16
    //   328: goto -178 -> 150
    //   331: astore 15
    //   333: goto -194 -> 139
    //   336: astore 14
    //   338: goto -210 -> 128
    //   341: astore 25
    //   343: goto -28 -> 315
    //   346: astore 24
    //   348: goto -50 -> 298
    //   351: astore 23
    //   353: goto -72 -> 281
    //   356: astore 22
    //   358: goto -94 -> 264
    //
    // Exception table:
    //   from	to	target	type
    //   23	31	170	java/lang/Exception
    //   35	43	178	java/lang/Exception
    //   47	55	186	java/lang/Exception
    //   150	161	321	java/lang/Exception
    //   139	150	326	java/lang/Exception
    //   128	139	331	java/lang/Exception
    //   121	128	336	java/lang/Exception
    //   298	315	341	java/lang/Exception
    //   281	298	346	java/lang/Exception
    //   264	281	351	java/lang/Exception
    //   247	264	356	java/lang/Exception
  }

  private void e(com.himamis.retex.renderer.a.g.d.c paramc)
    throws Exception
  {
    com.himamis.retex.renderer.a.g.d.f localf1 = paramc.b();
    int i1 = 0;
    if (i1 >= localf1.a())
    {
      g();
      return;
    }
    com.himamis.retex.renderer.a.g.d.e locale1 = localf1.a(i1);
    if (locale1.e() != 1);
    while (true)
    {
      i1++;
      break;
      com.himamis.retex.renderer.a.g.d.c localc1 = locale1.f();
      String str1 = localc1.a();
      try
      {
        String str6 = a("name", localc1);
        str2 = str6;
      }
      catch (Exception localException2)
      {
        try
        {
          String str5 = a("group", localc1);
          str3 = str5;
        }
        catch (Exception localException2)
        {
          try
          {
            while (true)
            {
              int i4 = b("columns", localc1);
              i2 = i4;
              localArrayList = new ArrayList();
              localf2 = localc1.b();
              i3 = 0;
              if (i3 < localf2.a())
                break label210;
              if ((!str2.equals("Array")) && (!str2.equals("Matrix")))
                break label411;
              this.H.add(new c(str2, str3, localArrayList));
              break;
              localException1 = localException1;
              str2 = str1;
              continue;
              localException2 = localException2;
              str3 = str1;
            }
          }
          catch (Exception localException3)
          {
            String str2;
            String str3;
            int i2;
            ArrayList localArrayList;
            com.himamis.retex.renderer.a.g.d.f localf2;
            int i3;
            while (true)
              i2 = 0;
            label210: com.himamis.retex.renderer.a.g.d.e locale2 = localf2.a(i3);
            if (locale2.e() != 1);
            while (true)
            {
              i3++;
              break;
              com.himamis.retex.renderer.a.g.d.c localc2 = locale2.f();
              String str4 = localc2.a();
              if ((str4.equals("Open")) || (str4.equals("Close")) || (str4.equals("Field")) || (str4.equals("Row")))
              {
                localArrayList.add(a(localc2));
                continue;
              }
              if (str4.equals("Operator"))
              {
                localArrayList.add(c(localc2));
                continue;
              }
              if (str4.equals("Symbol"))
              {
                localArrayList.add(c(localc2));
                continue;
              }
              if (str4.equals("Function"))
              {
                localArrayList.add(d(localc2));
                continue;
              }
              if (!str4.equals("Character"))
                continue;
              localArrayList.add(b(localc2));
            }
            label411: this.H.add(new b(str2, str3, localArrayList, i2));
          }
        }
      }
    }
  }

  private void g()
  {
    this.H.add(new a());
  }

  public c a()
  {
    return (c)k("Array");
  }

  public e a(String paramString1, String paramString2)
  {
    g[] arrayOfg = l(paramString1);
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= arrayOfg.length)
        throw new ArrayIndexOutOfBoundsException("Component Not found " + paramString2);
      e locale = arrayOfg[i1].a(paramString2);
      if (locale != null)
        return locale;
    }
  }

  public void a(int paramInt)
  {
    this.I = paramInt;
  }

  public boolean a(String paramString)
  {
    try
    {
      b(paramString);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
    return false;
  }

  public c b()
  {
    return (c)k("Matrix");
  }

  public d b(String paramString)
  {
    return (d)a("Characters", paramString);
  }

  public void b(int paramInt)
  {
    this.J = paramInt;
  }

  public int c()
  {
    return this.I;
  }

  public void c(int paramInt)
  {
    this.K = paramInt;
  }

  public boolean c(String paramString)
  {
    try
    {
      d(paramString);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
    return false;
  }

  public int d()
  {
    return this.J;
  }

  public d d(String paramString)
  {
    return (d)a("Operators", paramString);
  }

  public void d(int paramInt)
  {
    this.L = paramInt;
  }

  public int e()
  {
    return this.K;
  }

  public boolean e(String paramString)
  {
    try
    {
      f(paramString);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
    return false;
  }

  public int f()
  {
    return this.L;
  }

  public j f(String paramString)
  {
    return (j)a("Symbols", paramString);
  }

  public boolean g(String paramString)
  {
    try
    {
      a("General", paramString);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
    return false;
  }

  public f h(String paramString)
  {
    return (f)a("General", paramString);
  }

  public boolean i(String paramString)
  {
    try
    {
      j(paramString);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
    return false;
  }

  public f j(String paramString)
  {
    return (f)a("Functions", paramString);
  }

  public g k(String paramString)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.H.size())
        throw new ArrayIndexOutOfBoundsException("ListMetaGroup Not found " + paramString);
      if (((g)this.H.get(i1)).a().equals(paramString))
        return (g)this.H.get(i1);
    }
  }

  public g[] l(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.H.size())
        return (g[])localArrayList.toArray(new g[localArrayList.size()]);
      if (!((g)this.H.get(i1)).b().equals(paramString))
        continue;
      localArrayList.add((g)this.H.get(i1));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.e.h
 * JD-Core Version:    0.6.0
 */