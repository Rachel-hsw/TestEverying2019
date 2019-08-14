package com.ta.utdid2.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.ta.utdid2.b.a.h;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private String a;
  private String b;
  private boolean c;
  private boolean d;
  private boolean e;
  private SharedPreferences f;
  private b g;
  private SharedPreferences.Editor h;
  private b.a i;
  private Context j;
  private d k;
  private boolean l;

  // ERROR //
  public c(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 31	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: ldc 33
    //   7: putfield 35	com/ta/utdid2/c/a/c:a	Ljava/lang/String;
    //   10: aload_0
    //   11: ldc 33
    //   13: putfield 37	com/ta/utdid2/c/a/c:b	Ljava/lang/String;
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 39	com/ta/utdid2/c/a/c:c	Z
    //   21: aload_0
    //   22: iconst_0
    //   23: putfield 41	com/ta/utdid2/c/a/c:d	Z
    //   26: aload_0
    //   27: iconst_0
    //   28: putfield 43	com/ta/utdid2/c/a/c:e	Z
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 49	com/ta/utdid2/c/a/c:h	Landroid/content/SharedPreferences$Editor;
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 51	com/ta/utdid2/c/a/c:i	Lcom/ta/utdid2/c/a/b$a;
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 53	com/ta/utdid2/c/a/c:j	Landroid/content/Context;
    //   56: aload_0
    //   57: aconst_null
    //   58: putfield 55	com/ta/utdid2/c/a/c:k	Lcom/ta/utdid2/c/a/d;
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 57	com/ta/utdid2/c/a/c:l	Z
    //   66: aload_0
    //   67: iconst_0
    //   68: putfield 39	com/ta/utdid2/c/a/c:c	Z
    //   71: aload_0
    //   72: iconst_1
    //   73: putfield 57	com/ta/utdid2/c/a/c:l	Z
    //   76: aload_0
    //   77: aload_3
    //   78: putfield 35	com/ta/utdid2/c/a/c:a	Ljava/lang/String;
    //   81: aload_0
    //   82: aload_2
    //   83: putfield 37	com/ta/utdid2/c/a/c:b	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_1
    //   88: putfield 53	com/ta/utdid2/c/a/c:j	Landroid/content/Context;
    //   91: aload_1
    //   92: ifnull +569 -> 661
    //   95: aload_0
    //   96: aload_1
    //   97: aload_3
    //   98: iconst_0
    //   99: invokevirtual 63	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   102: putfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   105: aload_0
    //   106: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   109: ldc 65
    //   111: lconst_0
    //   112: invokeinterface 71 4 0
    //   117: lstore 4
    //   119: invokestatic 74	com/ta/utdid2/c/a/c:b	()Ljava/lang/String;
    //   122: astore 6
    //   124: aload 6
    //   126: invokestatic 79	com/ta/utdid2/b/a/h:a	(Ljava/lang/String;)Z
    //   129: ifne +317 -> 446
    //   132: aload 6
    //   134: ldc 81
    //   136: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifeq +284 -> 423
    //   142: aload_0
    //   143: iconst_1
    //   144: putfield 43	com/ta/utdid2/c/a/c:e	Z
    //   147: aload_0
    //   148: iconst_1
    //   149: putfield 41	com/ta/utdid2/c/a/c:d	Z
    //   152: aload_0
    //   153: getfield 41	com/ta/utdid2/c/a/c:d	Z
    //   156: ifne +10 -> 166
    //   159: aload_0
    //   160: getfield 43	com/ta/utdid2/c/a/c:e	Z
    //   163: ifeq +488 -> 651
    //   166: aload_1
    //   167: ifnull +484 -> 651
    //   170: aload_2
    //   171: invokestatic 79	com/ta/utdid2/b/a/h:a	(Ljava/lang/String;)Z
    //   174: ifne +477 -> 651
    //   177: aload_0
    //   178: aload_0
    //   179: aload_2
    //   180: invokespecial 90	com/ta/utdid2/c/a/c:b	(Ljava/lang/String;)Lcom/ta/utdid2/c/a/d;
    //   183: putfield 55	com/ta/utdid2/c/a/c:k	Lcom/ta/utdid2/c/a/d;
    //   186: aload_0
    //   187: getfield 55	com/ta/utdid2/c/a/c:k	Lcom/ta/utdid2/c/a/d;
    //   190: ifnull +461 -> 651
    //   193: aload_0
    //   194: aload_0
    //   195: getfield 55	com/ta/utdid2/c/a/c:k	Lcom/ta/utdid2/c/a/d;
    //   198: aload_3
    //   199: invokevirtual 95	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;)Lcom/ta/utdid2/c/a/b;
    //   202: putfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   205: aload_0
    //   206: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   209: ldc 65
    //   211: invokeinterface 100 2 0
    //   216: lstore 23
    //   218: aload_0
    //   219: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   222: ldc 102
    //   224: lconst_0
    //   225: invokeinterface 71 4 0
    //   230: lstore 26
    //   232: lload 26
    //   234: lstore 7
    //   236: aload_0
    //   237: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   240: ldc 102
    //   242: invokeinterface 100 2 0
    //   247: lstore 29
    //   249: lload 29
    //   251: lstore 9
    //   253: lload 7
    //   255: lload 9
    //   257: lcmp
    //   258: ifge +201 -> 459
    //   261: lload 7
    //   263: lconst_0
    //   264: lcmp
    //   265: ifle +194 -> 459
    //   268: aload_0
    //   269: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   272: aload_0
    //   273: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   276: invokestatic 105	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   279: aload_0
    //   280: aload_0
    //   281: getfield 55	com/ta/utdid2/c/a/c:k	Lcom/ta/utdid2/c/a/d;
    //   284: aload_3
    //   285: invokevirtual 95	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;)Lcom/ta/utdid2/c/a/b;
    //   288: putfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   291: lload 7
    //   293: lload 9
    //   295: lcmp
    //   296: ifne +17 -> 313
    //   299: lload 7
    //   301: lconst_0
    //   302: lcmp
    //   303: ifne +119 -> 422
    //   306: lload 9
    //   308: lconst_0
    //   309: lcmp
    //   310: ifne +112 -> 422
    //   313: invokestatic 111	java/lang/System:currentTimeMillis	()J
    //   316: lstore 11
    //   318: aload_0
    //   319: getfield 57	com/ta/utdid2/c/a/c:l	Z
    //   322: ifeq +24 -> 346
    //   325: aload_0
    //   326: getfield 57	com/ta/utdid2/c/a/c:l	Z
    //   329: ifeq +93 -> 422
    //   332: lload 7
    //   334: lconst_0
    //   335: lcmp
    //   336: ifne +86 -> 422
    //   339: lload 9
    //   341: lconst_0
    //   342: lcmp
    //   343: ifne +79 -> 422
    //   346: aload_0
    //   347: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   350: ifnull +34 -> 384
    //   353: aload_0
    //   354: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   357: invokeinterface 115 1 0
    //   362: astore 17
    //   364: aload 17
    //   366: ldc 102
    //   368: lload 11
    //   370: invokeinterface 121 4 0
    //   375: pop
    //   376: aload 17
    //   378: invokeinterface 125 1 0
    //   383: pop
    //   384: aload_0
    //   385: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   388: ifnull +34 -> 422
    //   391: aload_0
    //   392: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   395: invokeinterface 128 1 0
    //   400: astore 14
    //   402: aload 14
    //   404: ldc 102
    //   406: lload 11
    //   408: invokeinterface 133 4 0
    //   413: pop
    //   414: aload 14
    //   416: invokeinterface 135 1 0
    //   421: pop
    //   422: return
    //   423: aload 6
    //   425: ldc 137
    //   427: invokevirtual 87	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   430: ifeq +16 -> 446
    //   433: aload_0
    //   434: iconst_1
    //   435: putfield 41	com/ta/utdid2/c/a/c:d	Z
    //   438: aload_0
    //   439: iconst_0
    //   440: putfield 43	com/ta/utdid2/c/a/c:e	Z
    //   443: goto -291 -> 152
    //   446: aload_0
    //   447: iconst_0
    //   448: putfield 43	com/ta/utdid2/c/a/c:e	Z
    //   451: aload_0
    //   452: iconst_0
    //   453: putfield 41	com/ta/utdid2/c/a/c:d	Z
    //   456: goto -304 -> 152
    //   459: lload 7
    //   461: lload 9
    //   463: lcmp
    //   464: ifle +34 -> 498
    //   467: lload 9
    //   469: lconst_0
    //   470: lcmp
    //   471: ifle +27 -> 498
    //   474: aload_0
    //   475: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   478: aload_0
    //   479: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   482: invokestatic 140	com/ta/utdid2/c/a/c:a	(Lcom/ta/utdid2/c/a/b;Landroid/content/SharedPreferences;)V
    //   485: aload_0
    //   486: aload_1
    //   487: aload_3
    //   488: iconst_0
    //   489: invokevirtual 63	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   492: putfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   495: goto -204 -> 291
    //   498: lload 7
    //   500: lconst_0
    //   501: lcmp
    //   502: ifne +34 -> 536
    //   505: lload 9
    //   507: lconst_0
    //   508: lcmp
    //   509: ifle +27 -> 536
    //   512: aload_0
    //   513: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   516: aload_0
    //   517: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   520: invokestatic 140	com/ta/utdid2/c/a/c:a	(Lcom/ta/utdid2/c/a/b;Landroid/content/SharedPreferences;)V
    //   523: aload_0
    //   524: aload_1
    //   525: aload_3
    //   526: iconst_0
    //   527: invokevirtual 63	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   530: putfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   533: goto -242 -> 291
    //   536: lload 9
    //   538: lconst_0
    //   539: lcmp
    //   540: ifne +36 -> 576
    //   543: lload 7
    //   545: lconst_0
    //   546: lcmp
    //   547: ifle +29 -> 576
    //   550: aload_0
    //   551: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   554: aload_0
    //   555: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   558: invokestatic 105	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   561: aload_0
    //   562: aload_0
    //   563: getfield 55	com/ta/utdid2/c/a/c:k	Lcom/ta/utdid2/c/a/d;
    //   566: aload_3
    //   567: invokevirtual 95	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;)Lcom/ta/utdid2/c/a/b;
    //   570: putfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   573: goto -282 -> 291
    //   576: lload 7
    //   578: lload 9
    //   580: lcmp
    //   581: ifne -290 -> 291
    //   584: aload_0
    //   585: getfield 45	com/ta/utdid2/c/a/c:f	Landroid/content/SharedPreferences;
    //   588: aload_0
    //   589: getfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   592: invokestatic 105	com/ta/utdid2/c/a/c:a	(Landroid/content/SharedPreferences;Lcom/ta/utdid2/c/a/b;)V
    //   595: aload_0
    //   596: aload_0
    //   597: getfield 55	com/ta/utdid2/c/a/c:k	Lcom/ta/utdid2/c/a/d;
    //   600: aload_3
    //   601: invokevirtual 95	com/ta/utdid2/c/a/d:a	(Ljava/lang/String;)Lcom/ta/utdid2/c/a/b;
    //   604: putfield 47	com/ta/utdid2/c/a/c:g	Lcom/ta/utdid2/c/a/b;
    //   607: goto -316 -> 291
    //   610: astore 13
    //   612: return
    //   613: astore 20
    //   615: lload 4
    //   617: lstore 21
    //   619: lconst_0
    //   620: lstore 9
    //   622: goto +51 -> 673
    //   625: astore 25
    //   627: lload 4
    //   629: lstore 21
    //   631: lload 23
    //   633: lstore 9
    //   635: goto +38 -> 673
    //   638: astore 28
    //   640: lload 23
    //   642: lstore 9
    //   644: lload 7
    //   646: lstore 21
    //   648: goto +25 -> 673
    //   651: lload 4
    //   653: lstore 7
    //   655: lconst_0
    //   656: lstore 9
    //   658: goto -367 -> 291
    //   661: lconst_0
    //   662: lstore 4
    //   664: goto -545 -> 119
    //   667: astore 31
    //   669: lload 7
    //   671: lstore 21
    //   673: lload 21
    //   675: lstore 7
    //   677: goto -386 -> 291
    //
    // Exception table:
    //   from	to	target	type
    //   384	422	610	java/lang/Exception
    //   193	218	613	java/lang/Exception
    //   218	232	625	java/lang/Exception
    //   236	249	638	java/lang/Exception
    //   268	291	667	java/lang/Exception
    //   474	495	667	java/lang/Exception
    //   512	533	667	java/lang/Exception
    //   550	573	667	java/lang/Exception
    //   584	607	667	java/lang/Exception
  }

  private static void a(SharedPreferences paramSharedPreferences, b paramb)
  {
    if ((paramSharedPreferences != null) && (paramb != null))
    {
      b.a locala = paramb.c();
      if (locala != null)
      {
        locala.a();
        Iterator localIterator = paramSharedPreferences.getAll().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          Object localObject = localEntry.getValue();
          if ((localObject instanceof String))
          {
            locala.a(str, (String)localObject);
            continue;
          }
          if ((localObject instanceof Integer))
          {
            locala.a(str, ((Integer)localObject).intValue());
            continue;
          }
          if ((localObject instanceof Long))
          {
            locala.a(str, ((Long)localObject).longValue());
            continue;
          }
          if ((localObject instanceof Float))
          {
            locala.a(str, ((Float)localObject).floatValue());
            continue;
          }
          if (!(localObject instanceof Boolean))
            continue;
          locala.a(str, ((Boolean)localObject).booleanValue());
        }
        locala.b();
      }
    }
  }

  private static void a(b paramb, SharedPreferences paramSharedPreferences)
  {
    if ((paramb != null) && (paramSharedPreferences != null))
    {
      SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
      if (localEditor != null)
      {
        localEditor.clear();
        Iterator localIterator = paramb.b().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str = (String)localEntry.getKey();
          Object localObject = localEntry.getValue();
          if ((localObject instanceof String))
          {
            localEditor.putString(str, (String)localObject);
            continue;
          }
          if ((localObject instanceof Integer))
          {
            localEditor.putInt(str, ((Integer)localObject).intValue());
            continue;
          }
          if ((localObject instanceof Long))
          {
            localEditor.putLong(str, ((Long)localObject).longValue());
            continue;
          }
          if ((localObject instanceof Float))
          {
            localEditor.putFloat(str, ((Float)localObject).floatValue());
            continue;
          }
          if (!(localObject instanceof Boolean))
            continue;
          localEditor.putBoolean(str, ((Boolean)localObject).booleanValue());
        }
        localEditor.commit();
      }
    }
  }

  private d b(String paramString)
  {
    File localFile1 = Environment.getExternalStorageDirectory();
    File localFile2;
    if (localFile1 != null)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localFile1.getAbsolutePath();
      arrayOfObject[1] = File.separator;
      arrayOfObject[2] = paramString;
      localFile2 = new File(String.format("%s%s%s", arrayOfObject));
      if (!localFile2.exists())
        localFile2.mkdirs();
    }
    while (true)
    {
      d locald = null;
      if (localFile2 != null)
      {
        this.k = new d(localFile2.getAbsolutePath());
        locald = this.k;
      }
      return locald;
      localFile2 = null;
    }
  }

  private static String b()
  {
    try
    {
      String str = Environment.getExternalStorageState();
      return str;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    return "";
  }

  private boolean c()
  {
    if (this.g != null)
    {
      boolean bool = this.g.a();
      if (!bool)
        a();
      return bool;
    }
    return false;
  }

  public final String a(String paramString)
  {
    c();
    if (this.f != null)
    {
      String str = this.f.getString(paramString, "");
      if (!h.a(str))
        return str;
    }
    if (this.g != null)
      return this.g.a(paramString, "");
    return "";
  }

  public final void a(String paramString1, String paramString2)
  {
    if ((!h.a(paramString1)) && (!paramString1.equals("t")))
    {
      if ((this.h == null) && (this.f != null))
        this.h = this.f.edit();
      if ((this.e) && (this.i == null) && (this.g != null))
        this.i = this.g.c();
      c();
      if (this.h != null)
        this.h.putString(paramString1, paramString2);
      if (this.i != null)
        this.i.a(paramString1, paramString2);
    }
  }

  public final boolean a()
  {
    int m = 1;
    long l1 = System.currentTimeMillis();
    if (this.h != null)
    {
      if ((!this.l) && (this.f != null))
        this.h.putLong("t", l1);
      if (!this.h.commit())
        m = 0;
    }
    if ((this.f != null) && (this.j != null))
      this.f = this.j.getSharedPreferences(this.a, 0);
    String str = b();
    if (!h.a(str))
      if (str.equals("mounted"))
      {
        if (this.g != null)
          break label238;
        d locald = b(this.b);
        if (locald != null)
        {
          this.g = locald.a(this.a);
          if (this.l)
            break label224;
          a(this.f, this.g);
        }
      }
    while (true)
    {
      this.i = this.g.c();
      label173: if ((str.equals("mounted")) || ((str.equals("mounted_ro")) && (this.g != null)));
      try
      {
        if (this.k != null)
          this.g = this.k.a(this.a);
        return m;
        label224: a(this.g, this.f);
        continue;
        label238: if ((this.i == null) || (this.i.b()))
          break label173;
        m = 0;
      }
      catch (Exception localException)
      {
      }
    }
    return m;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.c.a.c
 * JD-Core Version:    0.6.0
 */