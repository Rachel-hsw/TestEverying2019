package com.xiaomi.push.service;

import android.content.Context;
import com.google.a.a.b;
import com.xiaomi.a.a.c.c;
import com.xiaomi.a.a.d.b.b;
import com.xiaomi.d.e.i;
import com.xiaomi.push.b.a.a;
import com.xiaomi.push.b.b.a;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  private static g d = new g();
  private List<a> a = new ArrayList();
  private a.a b;
  private b.b c;

  static
  {
    d.f();
  }

  public static g a()
  {
    return d;
  }

  private void e()
  {
    if (this.c != null)
      return;
    this.c = new h(this);
    i.a(this.c);
  }

  // ERROR //
  private void f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: getfield 35	com/xiaomi/push/service/g:b	Lcom/xiaomi/push/b/a$a;
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_1
    //   10: aload 4
    //   12: ifnull +103 -> 115
    //   15: new 56	java/io/BufferedInputStream
    //   18: dup
    //   19: invokestatic 61	com/xiaomi/d/e/h:a	()Landroid/content/Context;
    //   22: ldc 63
    //   24: invokevirtual 69	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   27: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   30: astore 5
    //   32: aload_0
    //   33: aload 5
    //   35: invokestatic 77	com/google/a/a/a:a	(Ljava/io/InputStream;)Lcom/google/a/a/a;
    //   38: invokestatic 82	com/xiaomi/push/b/a$a:c	(Lcom/google/a/a/a;)Lcom/xiaomi/push/b/a$a;
    //   41: putfield 35	com/xiaomi/push/service/g:b	Lcom/xiaomi/push/b/a$a;
    //   44: aload 5
    //   46: invokevirtual 85	java/io/BufferedInputStream:close	()V
    //   49: aload 5
    //   51: invokestatic 89	com/xiaomi/a/a/b/a:a	(Ljava/io/InputStream;)V
    //   54: return
    //   55: astore_3
    //   56: new 91	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   63: ldc 94
    //   65: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_3
    //   69: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   72: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 110	com/xiaomi/a/a/c/c:a	(Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokestatic 89	com/xiaomi/a/a/b/a:a	(Ljava/io/InputStream;)V
    //   85: return
    //   86: astore_2
    //   87: aload_1
    //   88: invokestatic 89	com/xiaomi/a/a/b/a:a	(Ljava/io/InputStream;)V
    //   91: aload_2
    //   92: athrow
    //   93: astore 7
    //   95: aload 5
    //   97: astore_1
    //   98: aload 7
    //   100: astore_2
    //   101: goto -14 -> 87
    //   104: astore 6
    //   106: aload 5
    //   108: astore_1
    //   109: aload 6
    //   111: astore_3
    //   112: goto -56 -> 56
    //   115: aconst_null
    //   116: astore 5
    //   118: goto -69 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	55	java/lang/Exception
    //   15	32	55	java/lang/Exception
    //   2	8	86	finally
    //   15	32	86	finally
    //   56	81	86	finally
    //   32	49	93	finally
    //   32	49	104	java/lang/Exception
  }

  private void g()
  {
    try
    {
      if (this.b != null)
      {
        BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(com.xiaomi.d.e.h.a().openFileOutput("XMCloudCfg", 0));
        b localb = b.a(localBufferedOutputStream);
        this.b.a(localb);
        localb.a();
        localBufferedOutputStream.close();
      }
      return;
    }
    catch (Exception localException)
    {
      c.a("save config failure: " + localException.getMessage());
    }
  }

  void a(b.a parama)
  {
    if ((parama.h()) && (parama.g() > c()))
      e();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a(parama);
  }

  public void a(a parama)
  {
    this.a.add(parama);
  }

  void b()
  {
    this.a.clear();
  }

  int c()
  {
    if (this.b != null)
      return this.b.c();
    return 0;
  }

  public a.a d()
  {
    return this.b;
  }

  public static abstract class a
  {
    public void a(a.a parama)
    {
    }

    public void a(b.a parama)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.g
 * JD-Core Version:    0.6.0
 */