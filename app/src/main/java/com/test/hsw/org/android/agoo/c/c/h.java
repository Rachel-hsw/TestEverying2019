package org.android.agoo.c.c;

import android.content.Context;
import android.text.TextUtils;
import org.android.agoo.c.a.e.a;

public final class h extends org.android.agoo.c.a.e
  implements b
{
  private volatile String a;
  private volatile String b;
  private volatile String c;

  private final String b(String paramString, org.android.agoo.c.a.d paramd)
  {
    if (paramd != null)
    {
      String str = paramd.c();
      paramString = paramString + "?" + str;
    }
    return paramString;
  }

  public final i a(Context paramContext, d paramd)
  {
    i locali1;
    try
    {
      e.a(paramd, this.a, this.b);
      org.android.agoo.c.a.d locald = e.a(paramContext, paramd);
      b(this.c, locald);
      e.a locala = a(paramContext, this.c, locald);
      String str = locala.c;
      if (TextUtils.isEmpty(str))
      {
        i locali2 = new i();
        locali2.a(false);
        locali2.b("request result is null");
        return locali2;
      }
      i locali3 = g.a(str);
      locali3.a(locala.b);
      return locali3;
    }
    catch (Throwable localThrowable)
    {
      locali1 = new i();
      locali1.a(false);
      locali1.b(localThrowable.getMessage());
    }
    return locali1;
  }

  public final void a(String paramString)
  {
    this.a = paramString;
  }

  // ERROR //
  public java.util.Map b(Context paramContext, d paramd)
  {
    // Byte code:
    //   0: new 91	java/util/HashMap
    //   3: dup
    //   4: invokespecial 92	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 37	org/android/agoo/c/c/h:a	Ljava/lang/String;
    //   13: aload_0
    //   14: getfield 39	org/android/agoo/c/c/h:b	Ljava/lang/String;
    //   17: invokestatic 44	org/android/agoo/c/c/e:a	(Lorg/android/agoo/c/c/d;Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 47	org/android/agoo/c/c/e:a	(Landroid/content/Context;Lorg/android/agoo/c/c/d;)Lorg/android/agoo/c/a/d;
    //   25: astore 10
    //   27: aload_0
    //   28: aload_0
    //   29: getfield 49	org/android/agoo/c/c/h:c	Ljava/lang/String;
    //   32: aload 10
    //   34: invokespecial 51	org/android/agoo/c/c/h:b	(Ljava/lang/String;Lorg/android/agoo/c/a/d;)Ljava/lang/String;
    //   37: astore 11
    //   39: aload 11
    //   41: astore 6
    //   43: aload_0
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 49	org/android/agoo/c/c/h:c	Ljava/lang/String;
    //   49: aload 10
    //   51: invokevirtual 54	org/android/agoo/c/c/h:a	(Landroid/content/Context;Ljava/lang/String;Lorg/android/agoo/c/a/d;)Lorg/android/agoo/c/a/e$a;
    //   54: astore 13
    //   56: aload 13
    //   58: getfield 57	org/android/agoo/c/a/e$a:c	Ljava/lang/String;
    //   61: astore 14
    //   63: aload 14
    //   65: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +49 -> 117
    //   71: new 65	org/android/agoo/c/c/i
    //   74: dup
    //   75: invokespecial 66	org/android/agoo/c/c/i:<init>	()V
    //   78: astore 15
    //   80: aload 15
    //   82: iconst_0
    //   83: invokevirtual 69	org/android/agoo/c/c/i:a	(Z)V
    //   86: aload 15
    //   88: ldc 71
    //   90: invokevirtual 74	org/android/agoo/c/c/i:b	(Ljava/lang/String;)V
    //   93: aload_3
    //   94: ldc 94
    //   96: aload 15
    //   98: invokeinterface 100 3 0
    //   103: pop
    //   104: aload_3
    //   105: ldc 102
    //   107: aload 6
    //   109: invokeinterface 100 3 0
    //   114: pop
    //   115: aload_3
    //   116: areturn
    //   117: aload 14
    //   119: invokestatic 79	org/android/agoo/c/c/g:a	(Ljava/lang/String;)Lorg/android/agoo/c/c/i;
    //   122: astore 7
    //   124: aload 7
    //   126: aload 13
    //   128: getfield 82	org/android/agoo/c/a/e$a:b	Ljava/util/Map;
    //   131: invokevirtual 85	org/android/agoo/c/c/i:a	(Ljava/util/Map;)V
    //   134: aload_3
    //   135: ldc 94
    //   137: aload 7
    //   139: invokeinterface 100 3 0
    //   144: pop
    //   145: aload_3
    //   146: ldc 102
    //   148: aload 6
    //   150: invokeinterface 100 3 0
    //   155: pop
    //   156: aload_3
    //   157: areturn
    //   158: astore 4
    //   160: aload 4
    //   162: astore 5
    //   164: aconst_null
    //   165: astore 6
    //   167: new 65	org/android/agoo/c/c/i
    //   170: dup
    //   171: invokespecial 66	org/android/agoo/c/c/i:<init>	()V
    //   174: astore 7
    //   176: aload 7
    //   178: iconst_0
    //   179: invokevirtual 69	org/android/agoo/c/c/i:a	(Z)V
    //   182: aload 7
    //   184: aload 5
    //   186: invokevirtual 88	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   189: invokevirtual 74	org/android/agoo/c/c/i:b	(Ljava/lang/String;)V
    //   192: goto -58 -> 134
    //   195: astore 12
    //   197: aload 12
    //   199: astore 5
    //   201: goto -34 -> 167
    //
    // Exception table:
    //   from	to	target	type
    //   8	39	158	java/lang/Throwable
    //   43	115	195	java/lang/Throwable
    //   117	134	195	java/lang/Throwable
  }

  public final void b(String paramString)
  {
    this.b = paramString;
  }

  public final void c(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.c.h
 * JD-Core Version:    0.6.0
 */