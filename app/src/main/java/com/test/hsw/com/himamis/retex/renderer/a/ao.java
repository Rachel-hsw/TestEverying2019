package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.e.s;
import com.himamis.retex.renderer.a.g.d.c;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ao
{
  private static final String a = "GlueSettings.xml";
  private final Map<String, Integer> b = new HashMap();
  private final Map<String, Integer> c = new HashMap();
  private am[] d;
  private final Map<String, Integer> e = new HashMap();
  private c f;

  public ao()
    throws o
  {
    try
    {
      e();
      c();
      this.f = new com.himamis.retex.renderer.a.g.e().a(new com.himamis.retex.renderer.a.g.f().a(ao.class, "GlueSettings.xml"), true, true);
      d();
      return;
    }
    catch (Exception localException)
    {
    }
    throw new s("GlueSettings.xml", localException);
  }

  // ERROR //
  private am a(c paramc, String paramString)
    throws o
  {
    // Byte code:
    //   0: iconst_3
    //   1: anewarray 64	java/lang/String
    //   4: dup
    //   5: iconst_0
    //   6: ldc 66
    //   8: aastore
    //   9: dup
    //   10: iconst_1
    //   11: ldc 68
    //   13: aastore
    //   14: dup
    //   15: iconst_2
    //   16: ldc 70
    //   18: aastore
    //   19: astore_3
    //   20: aload_3
    //   21: arraylength
    //   22: newarray float
    //   24: astore 4
    //   26: iconst_0
    //   27: istore 5
    //   29: iload 5
    //   31: aload_3
    //   32: arraylength
    //   33: if_icmplt +24 -> 57
    //   36: new 72	com/himamis/retex/renderer/a/am
    //   39: dup
    //   40: aload 4
    //   42: iconst_0
    //   43: faload
    //   44: aload 4
    //   46: iconst_1
    //   47: faload
    //   48: aload 4
    //   50: iconst_2
    //   51: faload
    //   52: aload_2
    //   53: invokespecial 75	com/himamis/retex/renderer/a/am:<init>	(FFFLjava/lang/String;)V
    //   56: areturn
    //   57: dconst_0
    //   58: dstore 6
    //   60: aload_1
    //   61: aload_3
    //   62: iload 5
    //   64: aaload
    //   65: invokeinterface 80 2 0
    //   70: astore 10
    //   72: aload 10
    //   74: ldc 82
    //   76: invokevirtual 86	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifne +14 -> 93
    //   82: aload 10
    //   84: invokestatic 92	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   87: dstore 12
    //   89: dload 12
    //   91: dstore 6
    //   93: aload 4
    //   95: iload 5
    //   97: dload 6
    //   99: d2f
    //   100: fastore
    //   101: iinc 5 1
    //   104: goto -75 -> 29
    //   107: astore 8
    //   109: aconst_null
    //   110: astore 9
    //   112: new 56	com/himamis/retex/renderer/a/e/s
    //   115: dup
    //   116: ldc 8
    //   118: ldc 94
    //   120: aload_3
    //   121: iload 5
    //   123: aaload
    //   124: new 96	java/lang/StringBuilder
    //   127: dup
    //   128: ldc 98
    //   130: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: aload 9
    //   135: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 107
    //   140: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 114	com/himamis/retex/renderer/a/e/s:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   149: athrow
    //   150: astore 11
    //   152: aload 10
    //   154: astore 9
    //   156: goto -44 -> 112
    //
    // Exception table:
    //   from	to	target	type
    //   60	72	107	java/lang/NumberFormatException
    //   72	89	150	java/lang/NumberFormatException
  }

  private static String a(String paramString, c paramc)
    throws o
  {
    String str = paramc.b(paramString);
    if (str.equals(""))
      throw new s("GlueSettings.xml", paramc.a(), paramString, null);
    return str;
  }

  private static void a(Object paramObject, String paramString1, String paramString2, String paramString3)
    throws o
  {
    if (paramObject == null)
      throw new s("GlueSettings.xml", paramString1, paramString2, "has an unknown value '" + paramString3 + "'!");
  }

  private void c()
  {
    this.e.put("display", Integer.valueOf(0));
    this.e.put("text", Integer.valueOf(1));
    this.e.put("script", Integer.valueOf(2));
    this.e.put("script_script", Integer.valueOf(3));
  }

  private void d()
    throws o
  {
    ArrayList localArrayList = new ArrayList();
    c localc1 = this.f.a("GlueTypes").a(0).f();
    com.himamis.retex.renderer.a.g.d.f localf;
    int m;
    int n;
    int i1;
    int j;
    int i;
    if (!localc1.d())
    {
      localf = localc1.a("GlueType");
      m = 0;
      n = -1;
      i1 = 0;
      if (i1 >= localf.a())
      {
        j = m;
        i = n;
      }
    }
    while (true)
    {
      if (i < 0)
      {
        localArrayList.add(new am(0.0F, 0.0F, 0.0F, "default"));
        i = j;
      }
      this.d = ((am[])localArrayList.toArray(new am[localArrayList.size()]));
      int k = 0;
      if (i > 0)
      {
        am localam1 = this.d[i];
        this.d[i] = this.d[0];
        this.d[0] = localam1;
      }
      while (true)
      {
        if (k >= this.d.length)
        {
          return;
          c localc2 = localf.a(i1).f();
          String str = a("name", localc2);
          am localam2 = a(localc2, str);
          if (str.equalsIgnoreCase("default"))
            n = m;
          localArrayList.add(localam2);
          m++;
          i1++;
          break;
        }
        this.c.put(this.d[k].a(), Integer.valueOf(k));
        k++;
      }
      i = -1;
      j = 0;
    }
  }

  private void e()
  {
    this.b.put("ord", Integer.valueOf(0));
    this.b.put("op", Integer.valueOf(1));
    this.b.put("bin", Integer.valueOf(2));
    this.b.put("rel", Integer.valueOf(3));
    this.b.put("open", Integer.valueOf(4));
    this.b.put("close", Integer.valueOf(5));
    this.b.put("punct", Integer.valueOf(6));
    this.b.put("inner", Integer.valueOf(7));
  }

  public am[] a()
  {
    return this.d;
  }

  public int[][][] b()
    throws o
  {
    int i = this.b.size();
    int[] arrayOfInt = { i, i, this.e.size() };
    int[][][] arrayOfInt1 = (int[][][])Array.newInstance(Integer.TYPE, arrayOfInt);
    c localc1 = this.f.a("GlueTable").a(0).f();
    com.himamis.retex.renderer.a.g.d.f localf1;
    int j;
    if (!localc1.d())
    {
      localf1 = localc1.a("Glue");
      j = 0;
      if (j < localf1.a());
    }
    else
    {
      return arrayOfInt1;
    }
    c localc2 = localf1.a(j).f();
    String str1 = a("lefttype", localc2);
    String str2 = a("righttype", localc2);
    String str3 = a("gluetype", localc2);
    com.himamis.retex.renderer.a.g.d.f localf2 = localc2.a("Style");
    for (int k = 0; ; k++)
    {
      if (k >= localf2.a())
      {
        j++;
        break;
      }
      String str4 = a("name", localf2.a(k).f());
      Object localObject1 = this.b.get(str1);
      Object localObject2 = this.b.get(str2);
      Object localObject3 = this.e.get(str4);
      Object localObject4 = this.c.get(str3);
      a(localObject1, "Glue", "lefttype", str1);
      a(localObject2, "Glue", "righttype", str2);
      a(localObject4, "Glue", "gluetype", str3);
      a(localObject3, "Style", "name", str4);
      arrayOfInt1[((Integer)localObject1).intValue()][((Integer)localObject2).intValue()][((Integer)localObject3).intValue()] = ((Integer)localObject4).intValue();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ao
 * JD-Core Version:    0.6.0
 */