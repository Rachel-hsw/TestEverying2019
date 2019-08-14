package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.e.s;
import com.himamis.retex.renderer.a.g.b;
import com.himamis.retex.renderer.a.g.d.c;
import com.himamis.retex.renderer.a.g.d.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class w
{
  public static final String a = "DefaultTeXFont.xml";
  public static final String b = "TextStyleMapping";
  public static final String c = "SymbolMapping";
  public static final String d = "GeneralSettings";
  public static final String e = "mufontid";
  public static final String f = "spacefontid";
  protected static ArrayList<String> g;
  private static boolean h = false;
  private static boolean i = true;
  private static Map<String, Integer> j;
  private static Map<String, a> k;
  private Map<String, p[]> l;
  private c m;
  private Object n = null;
  private final com.himamis.retex.renderer.a.g.f o;
  private final com.himamis.retex.renderer.a.g.e p;

  static
  {
    g = new ArrayList();
    j = new HashMap();
    k = new HashMap();
    i();
    g();
  }

  public w()
    throws o
  {
    this.o = new com.himamis.retex.renderer.a.g.f();
    this.p = new com.himamis.retex.renderer.a.g.e();
    Object localObject = this.o.a(w.class, "DefaultTeXFont.xml");
    try
    {
      this.m = this.p.a(localObject, true, true);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new s("DefaultTeXFont.xml", localException);
  }

  public w(Object paramObject1, Object paramObject2, String paramString)
    throws o
  {
    this.n = paramObject1;
    this.o = new com.himamis.retex.renderer.a.g.f();
    this.p = new com.himamis.retex.renderer.a.g.e();
    try
    {
      this.m = this.p.a(paramObject2, true, true);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new s(paramString, localException);
  }

  public w(Object paramObject, String paramString)
    throws o
  {
    this.o = new com.himamis.retex.renderer.a.g.f();
    this.p = new com.himamis.retex.renderer.a.g.e();
    try
    {
      this.m = this.p.a(paramObject, true, true);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new s(paramString, localException);
  }

  public static float a(String paramString, c paramc)
    throws o
  {
    String str = d(paramString, paramc);
    try
    {
      double d1 = Double.parseDouble(str);
      return (float)d1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new s("DefaultTeXFont.xml", paramc.a(), paramString, "has an invalid real value!");
  }

  public static float a(String paramString, c paramc, float paramFloat)
    throws o
  {
    String str = paramc.b(paramString);
    if (str.equals(""))
      return paramFloat;
    try
    {
      double d1 = Double.parseDouble(str);
      return (float)d1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new s("DefaultTeXFont.xml", paramc.a(), paramString, "has an invalid float value!");
  }

  public static int a(String paramString, c paramc, int paramInt)
    throws o
  {
    String str = paramc.b(paramString);
    if (str.equals(""))
      return paramInt;
    try
    {
      int i1 = Integer.parseInt(str);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new s("DefaultTeXFont.xml", paramc.a(), paramString, "has an invalid integer value!");
  }

  public static com.himamis.retex.renderer.a.g.a.a a(Object paramObject, String paramString)
    throws o
  {
    return new b().a(paramObject, paramString);
  }

  public static com.himamis.retex.renderer.a.g.a.a a(String paramString)
    throws o
  {
    return a(null, paramString);
  }

  private static void a(c paramc, ah paramah)
    throws o
  {
    char c1 = (char)b("code", paramc);
    float[] arrayOfFloat = new float[4];
    arrayOfFloat[0] = a("width", paramc, 0.0F);
    arrayOfFloat[1] = a("height", paramc, 0.0F);
    arrayOfFloat[2] = a("depth", paramc, 0.0F);
    arrayOfFloat[3] = a("italic", paramc, 0.0F);
    paramah.a(c1, arrayOfFloat);
    com.himamis.retex.renderer.a.g.d.f localf = paramc.b();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= localf.a())
        return;
      com.himamis.retex.renderer.a.g.d.e locale = localf.a(i1);
      if (locale.e() == 3)
        continue;
      c localc = locale.f();
      Object localObject = k.get(localc.a());
      if (localObject == null)
        throw new s("DefaultTeXFont.xml: a <Char>-element has an unknown child element '" + localc.a() + "'!");
      ((a)localObject).a(localc, c1, paramah);
    }
  }

  public static void a(boolean paramBoolean)
  {
    i = paramBoolean;
  }

  public static int b(String paramString, c paramc)
    throws o
  {
    String str = d(paramString, paramc);
    try
    {
      int i1 = Integer.parseInt(str);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new s("DefaultTeXFont.xml", paramc.a(), paramString, "has an invalid integer value!");
  }

  private static String d(String paramString, c paramc)
    throws o
  {
    String str = paramc.b(paramString);
    if (str.equals(""))
      throw new s("DefaultTeXFont.xml", paramc.a(), paramString, null);
    return str;
  }

  private static void g()
  {
    k.put("Kern", new c());
    k.put("Lig", new d());
    k.put("NextLarger", new e());
    k.put("Extension", new b());
  }

  private Map<String, p[]> h()
    throws o
  {
    HashMap localHashMap = new HashMap();
    c localc1 = this.m.a("TextStyleMappings").a(0).f();
    if (localc1.d())
      return localHashMap;
    com.himamis.retex.renderer.a.g.d.f localf1 = localc1.a("TextStyleMapping");
    int i1 = 0;
    String str2;
    p[] arrayOfp;
    int i2;
    String str3;
    int i3;
    Object localObject;
    while (true)
    {
      if (i1 >= localf1.a())
        return localHashMap;
      c localc2 = localf1.a(i1).f();
      String str1 = d("name", localc2);
      try
      {
        String str5 = d("bold", localc2);
        str2 = str5;
        localf2 = localc2.a("MapRange");
        arrayOfp = new p[4];
        i2 = 0;
        if (i2 >= localf2.a())
        {
          localHashMap.put(str1, arrayOfp);
          i1++;
        }
      }
      catch (o localo)
      {
        com.himamis.retex.renderer.a.g.d.f localf2;
        while (true)
          str2 = null;
        c localc3 = localf2.a(i2).f();
        str3 = d("fontId", localc3);
        i3 = b("start", localc3);
        String str4 = d("code", localc3);
        localObject = j.get(str4);
        if (localObject == null)
          throw new s("DefaultTeXFont.xml", "MapRange", "code", "contains an unknown \"range name\" '" + str4 + "'!");
        if (str2 != null)
          break label304;
      }
    }
    arrayOfp[((Integer)localObject).intValue()] = new p((char)i3, g.indexOf(str3));
    while (true)
    {
      i2++;
      break;
      label304: arrayOfp[((Integer)localObject).intValue()] = new p((char)i3, g.indexOf(str3), g.indexOf(str2));
    }
  }

  private static void i()
  {
    j.put("numbers", Integer.valueOf(0));
    j.put("capitals", Integer.valueOf(1));
    j.put("small", Integer.valueOf(2));
    j.put("unicode", Integer.valueOf(3));
  }

  protected void a()
    throws o
  {
    c localc1 = this.m.a("TeXSymbols").a(0).f();
    if (!localc1.d())
    {
      String str2 = d("include", localc1);
      dm.a(this.o.a(this.n, str2), str2);
    }
    c localc2 = this.m.a("FormulaSettings").a(0).f();
    if (!localc2.d())
    {
      String str1 = d("include", localc2);
      dr.a(this.o.a(this.n, str1), str1);
    }
  }

  public ah[] a(ah[] paramArrayOfah)
    throws o
  {
    int i1 = 0;
    c localc = this.m.a("FontDescriptions").a(0).f();
    com.himamis.retex.renderer.a.g.d.f localf;
    if (!localc.d())
    {
      localf = localc.a("Metrics");
      if (i1 < localf.a());
    }
    else
    {
      return paramArrayOfah;
    }
    String str = d("include", localf.a(i1).f());
    if (this.n == null);
    for (paramArrayOfah = a(paramArrayOfah, this.o.a(w.class, str), str); ; paramArrayOfah = a(paramArrayOfah, this.o.a(this.n, str), str))
    {
      i1++;
      break;
    }
  }

  // ERROR //
  public ah[] a(ah[] paramArrayOfah, Object paramObject, String paramString)
    throws o
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aload_1
    //   5: areturn
    //   6: new 52	java/util/ArrayList
    //   9: dup
    //   10: aload_1
    //   11: invokestatic 321	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   14: invokespecial 324	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 85	com/himamis/retex/renderer/a/w:p	Lcom/himamis/retex/renderer/a/g/e;
    //   23: aload_2
    //   24: invokevirtual 327	com/himamis/retex/renderer/a/g/e:a	(Ljava/lang/Object;)Lcom/himamis/retex/renderer/a/g/d/c;
    //   27: astore 6
    //   29: ldc_w 257
    //   32: aload 6
    //   34: invokestatic 106	com/himamis/retex/renderer/a/w:d	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   37: astore 7
    //   39: ldc_w 329
    //   42: aload 6
    //   44: invokestatic 106	com/himamis/retex/renderer/a/w:d	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   47: astore 8
    //   49: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   52: aload 8
    //   54: invokevirtual 276	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   57: ifge +332 -> 389
    //   60: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   63: aload 8
    //   65: invokevirtual 332	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: ldc_w 334
    //   72: aload 6
    //   74: invokestatic 336	com/himamis/retex/renderer/a/w:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)F
    //   77: fstore 10
    //   79: ldc_w 338
    //   82: aload 6
    //   84: invokestatic 336	com/himamis/retex/renderer/a/w:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)F
    //   87: fstore 11
    //   89: ldc_w 340
    //   92: aload 6
    //   94: invokestatic 336	com/himamis/retex/renderer/a/w:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)F
    //   97: fstore 12
    //   99: ldc_w 342
    //   102: aload 6
    //   104: iconst_m1
    //   105: invokestatic 344	com/himamis/retex/renderer/a/w:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;I)I
    //   108: istore 13
    //   110: ldc_w 294
    //   113: aload 6
    //   115: iconst_0
    //   116: invokestatic 344	com/himamis/retex/renderer/a/w:a	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;I)I
    //   119: istore 14
    //   121: ldc_w 346
    //   124: aload 6
    //   126: invokestatic 106	com/himamis/retex/renderer/a/w:d	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   129: astore 36
    //   131: aload 36
    //   133: astore 16
    //   135: ldc_w 348
    //   138: aload 6
    //   140: invokestatic 106	com/himamis/retex/renderer/a/w:d	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   143: astore 35
    //   145: aload 35
    //   147: astore 18
    //   149: ldc_w 350
    //   152: aload 6
    //   154: invokestatic 106	com/himamis/retex/renderer/a/w:d	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   157: astore 34
    //   159: aload 34
    //   161: astore 20
    //   163: ldc_w 352
    //   166: aload 6
    //   168: invokestatic 106	com/himamis/retex/renderer/a/w:d	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   171: astore 33
    //   173: aload 33
    //   175: astore 22
    //   177: ldc_w 354
    //   180: aload 6
    //   182: invokestatic 106	com/himamis/retex/renderer/a/w:d	(Ljava/lang/String;Lcom/himamis/retex/renderer/a/g/d/c;)Ljava/lang/String;
    //   185: astore 32
    //   187: aload 32
    //   189: astore 24
    //   191: new 201	java/lang/StringBuilder
    //   194: dup
    //   195: aload_3
    //   196: iconst_0
    //   197: iconst_1
    //   198: aload_3
    //   199: ldc_w 356
    //   202: invokevirtual 359	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   205: iadd
    //   206: invokevirtual 363	java/lang/String:substring	(II)Ljava/lang/String;
    //   209: invokestatic 366	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   212: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload 7
    //   217: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: astore 25
    //   225: new 171	com/himamis/retex/renderer/a/ah
    //   228: dup
    //   229: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   232: aload 8
    //   234: invokevirtual 276	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   237: aload_0
    //   238: getfield 75	com/himamis/retex/renderer/a/w:n	Ljava/lang/Object;
    //   241: aload 25
    //   243: aload 7
    //   245: iload 14
    //   247: fload 11
    //   249: fload 10
    //   251: fload 12
    //   253: aload 16
    //   255: aload 18
    //   257: aload 20
    //   259: aload 22
    //   261: aload 24
    //   263: invokespecial 369	com/himamis/retex/renderer/a/ah:<init>	(ILjava/lang/Object;Ljava/lang/String;Ljava/lang/String;IFFFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   266: astore 26
    //   268: iload 13
    //   270: iconst_m1
    //   271: if_icmpeq +11 -> 282
    //   274: aload 26
    //   276: iload 13
    //   278: i2c
    //   279: invokevirtual 372	com/himamis/retex/renderer/a/ah:d	(C)V
    //   282: aload 6
    //   284: ldc_w 374
    //   287: invokeinterface 252 2 0
    //   292: astore 27
    //   294: iconst_0
    //   295: istore 28
    //   297: iload 28
    //   299: aload 27
    //   301: invokeinterface 182 1 0
    //   306: if_icmplt +115 -> 421
    //   309: aload 4
    //   311: aload 26
    //   313: invokevirtual 332	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   316: pop
    //   317: iconst_0
    //   318: istore 30
    //   320: iload 30
    //   322: aload 4
    //   324: invokevirtual 377	java/util/ArrayList:size	()I
    //   327: if_icmplt +119 -> 446
    //   330: aload_0
    //   331: aload_0
    //   332: invokespecial 379	com/himamis/retex/renderer/a/w:h	()Ljava/util/Map;
    //   335: putfield 381	com/himamis/retex/renderer/a/w:l	Ljava/util/Map;
    //   338: aload 4
    //   340: aload_1
    //   341: invokevirtual 385	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   344: checkcast 387	[Lcom/himamis/retex/renderer/a/ah;
    //   347: areturn
    //   348: astore 5
    //   350: new 95	com/himamis/retex/renderer/a/e/s
    //   353: dup
    //   354: new 201	java/lang/StringBuilder
    //   357: dup
    //   358: ldc_w 389
    //   361: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   364: aload_3
    //   365: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: ldc_w 391
    //   371: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: aload 5
    //   376: invokevirtual 392	java/lang/Exception:toString	()Ljava/lang/String;
    //   379: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokespecial 216	com/himamis/retex/renderer/a/e/s:<init>	(Ljava/lang/String;)V
    //   388: athrow
    //   389: new 394	com/himamis/retex/renderer/a/e/d
    //   392: dup
    //   393: new 201	java/lang/StringBuilder
    //   396: dup
    //   397: ldc_w 396
    //   400: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: aload 8
    //   405: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 398
    //   411: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokespecial 399	com/himamis/retex/renderer/a/e/d:<init>	(Ljava/lang/String;)V
    //   420: athrow
    //   421: aload 27
    //   423: iload 28
    //   425: invokeinterface 185 2 0
    //   430: invokeinterface 193 1 0
    //   435: aload 26
    //   437: invokestatic 401	com/himamis/retex/renderer/a/w:a	(Lcom/himamis/retex/renderer/a/g/d/c;Lcom/himamis/retex/renderer/a/ah;)V
    //   440: iinc 28 1
    //   443: goto -146 -> 297
    //   446: aload 4
    //   448: iload 30
    //   450: invokevirtual 404	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   453: checkcast 171	com/himamis/retex/renderer/a/ah
    //   456: astore 31
    //   458: aload 31
    //   460: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   463: aload 31
    //   465: getfield 406	com/himamis/retex/renderer/a/ah:b	Ljava/lang/String;
    //   468: invokevirtual 276	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   471: invokevirtual 409	com/himamis/retex/renderer/a/ah:e	(I)V
    //   474: aload 31
    //   476: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   479: aload 31
    //   481: getfield 411	com/himamis/retex/renderer/a/ah:c	Ljava/lang/String;
    //   484: invokevirtual 276	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   487: invokevirtual 413	com/himamis/retex/renderer/a/ah:d	(I)V
    //   490: aload 31
    //   492: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   495: aload 31
    //   497: getfield 415	com/himamis/retex/renderer/a/ah:d	Ljava/lang/String;
    //   500: invokevirtual 276	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   503: invokevirtual 417	com/himamis/retex/renderer/a/ah:a	(I)V
    //   506: aload 31
    //   508: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   511: aload 31
    //   513: getfield 419	com/himamis/retex/renderer/a/ah:e	Ljava/lang/String;
    //   516: invokevirtual 276	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   519: invokevirtual 421	com/himamis/retex/renderer/a/ah:b	(I)V
    //   522: aload 31
    //   524: getstatic 57	com/himamis/retex/renderer/a/w:g	Ljava/util/ArrayList;
    //   527: aload 31
    //   529: getfield 423	com/himamis/retex/renderer/a/ah:f	Ljava/lang/String;
    //   532: invokevirtual 276	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   535: invokevirtual 425	com/himamis/retex/renderer/a/ah:c	(I)V
    //   538: iinc 30 1
    //   541: goto -221 -> 320
    //   544: astore 23
    //   546: aconst_null
    //   547: astore 24
    //   549: goto -358 -> 191
    //   552: astore 21
    //   554: aconst_null
    //   555: astore 22
    //   557: goto -380 -> 177
    //   560: astore 19
    //   562: aconst_null
    //   563: astore 20
    //   565: goto -402 -> 163
    //   568: astore 17
    //   570: aconst_null
    //   571: astore 18
    //   573: goto -424 -> 149
    //   576: astore 15
    //   578: aconst_null
    //   579: astore 16
    //   581: goto -446 -> 135
    //
    // Exception table:
    //   from	to	target	type
    //   19	29	348	java/lang/Exception
    //   177	187	544	com/himamis/retex/renderer/a/e/o
    //   163	173	552	com/himamis/retex/renderer/a/e/o
    //   149	159	560	com/himamis/retex/renderer/a/e/o
    //   135	145	568	com/himamis/retex/renderer/a/e/o
    //   121	131	576	com/himamis/retex/renderer/a/e/o
  }

  public Map<String, p> b()
    throws o
  {
    HashMap localHashMap = new HashMap();
    c localc1 = this.m.a("SymbolMappings").a(0).f();
    if (localc1.d())
      throw new s("DefaultTeXFont.xml", "SymbolMappings");
    com.himamis.retex.renderer.a.g.d.f localf1 = localc1.a("Mapping");
    int i1 = 0;
    if (i1 >= localf1.a())
      return localHashMap;
    String str1 = d("include", localf1.a(i1).f());
    while (true)
    {
      com.himamis.retex.renderer.a.g.d.f localf2;
      int i2;
      try
      {
        if (this.n != null)
          continue;
        c localc4 = this.p.a(this.o.a(w.class, str1));
        Object localObject = localc4;
        localf2 = ((c)localObject).a("SymbolMapping");
        i2 = 0;
        if (i2 >= localf2.a())
        {
          i1++;
          break;
          c localc2 = this.p.a(this.o.a(this.n, str1));
          localObject = localc2;
          continue;
        }
      }
      catch (Exception localException)
      {
        throw new s("Cannot find the file " + str1 + "!");
      }
      c localc3 = localf2.a(i2).f();
      String str2 = d("name", localc3);
      int i3 = b("ch", localc3);
      String str3 = d("fontId", localc3);
      try
      {
        String str5 = d("boldId", localc3);
        str4 = str5;
        if (str4 == null)
          localHashMap.put(str2, new p((char)i3, g.indexOf(str3)));
        while (true)
        {
          i2++;
          break;
          localHashMap.put(str2, new p((char)i3, g.indexOf(str3), g.indexOf(str4)));
        }
      }
      catch (o localo)
      {
        while (true)
          String str4 = null;
      }
    }
  }

  public String[] c()
    throws o
  {
    String[] arrayOfString = new String[4];
    c localc1 = this.m.a("DefaultTextStyleMapping").a(0).f();
    if (localc1.d())
      return arrayOfString;
    com.himamis.retex.renderer.a.g.d.f localf = localc1.a("MapStyle");
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= localf.a())
        return arrayOfString;
      c localc2 = localf.a(i1).f();
      String str1 = d("code", localc2);
      Object localObject = j.get(str1);
      if (localObject == null)
        throw new s("DefaultTeXFont.xml", "MapStyle", "code", "contains an unknown \"range name\" '" + str1 + "'!");
      String str2 = d("textStyle", localc2);
      if (this.l.get(str2) == null)
        throw new s("DefaultTeXFont.xml", "MapStyle", "textStyle", "contains an unknown text style '" + str2 + "'!");
      p[] arrayOfp = (p[])this.l.get(str2);
      int i2 = ((Integer)localObject).intValue();
      if (arrayOfp[i2] == null)
        throw new s("DefaultTeXFont.xml: the default text style mapping '" + str2 + "' for the range '" + str1 + "' contains no mapping for that range!");
      arrayOfString[i2] = str2;
    }
  }

  public Map<String, Float> d()
    throws o
  {
    int i1 = 0;
    HashMap localHashMap = new HashMap();
    c localc = this.m.a("Parameters").a(0).f();
    if (localc.d())
      throw new s("DefaultTeXFont.xml", "Parameters");
    d locald = localc.c();
    while (true)
    {
      if (i1 >= locald.a())
        return localHashMap;
      String str = locald.a(i1).g().a();
      localHashMap.put(str, new Float(a(str, localc)));
      i1++;
    }
  }

  public Map<String, Number> e()
    throws o
  {
    HashMap localHashMap = new HashMap();
    c localc = this.m.a("GeneralSettings").a(0).f();
    if (localc.d())
      throw new s("DefaultTeXFont.xml", "GeneralSettings");
    localHashMap.put("mufontid", Integer.valueOf(g.indexOf(d("mufontid", localc))));
    localHashMap.put("spacefontid", Integer.valueOf(g.indexOf(d("spacefontid", localc))));
    localHashMap.put("scriptfactor", Float.valueOf(a("scriptfactor", localc)));
    localHashMap.put("scriptscriptfactor", Float.valueOf(a("scriptscriptfactor", localc)));
    return localHashMap;
  }

  public Map<String, p[]> f()
  {
    return this.l;
  }

  private static abstract interface a
  {
    public abstract void a(c paramc, char paramChar, ah paramah)
      throws s;
  }

  private static class b
    implements w.a
  {
    public void a(c paramc, char paramChar, ah paramah)
      throws o
    {
      int[] arrayOfInt = new int[4];
      arrayOfInt[2] = w.b("rep", paramc);
      arrayOfInt[0] = w.a("top", paramc, -1);
      arrayOfInt[1] = w.a("mid", paramc, -1);
      arrayOfInt[3] = w.a("bot", paramc, -1);
      paramah.a(paramChar, arrayOfInt);
    }
  }

  private static class c
    implements w.a
  {
    public void a(c paramc, char paramChar, ah paramah)
      throws o
    {
      int i = w.b("code", paramc);
      float f = w.a("val", paramc);
      paramah.a(paramChar, (char)i, f);
    }
  }

  private static class d
    implements w.a
  {
    public void a(c paramc, char paramChar, ah paramah)
      throws o
    {
      int i = w.b("code", paramc);
      int j = w.b("ligCode", paramc);
      paramah.a(paramChar, (char)i, (char)j);
    }
  }

  private static class e
    implements w.a
  {
    public void a(c paramc, char paramChar, ah paramah)
      throws o
    {
      String str = w.c("fontId", paramc);
      paramah.a(paramChar, (char)w.b("code", paramc), w.g.indexOf(str));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.w
 * JD-Core Version:    0.6.0
 */