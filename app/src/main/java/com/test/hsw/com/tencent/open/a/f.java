package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.utils.Global;
import java.io.File;

public class f
{
  public static f a = null;
  protected static final b c;
  public static final String d = c.a;
  protected a b = new a(c);

  static
  {
    int i = c.s;
    long l = c.t;
    c = new b(c(), i, c.m, c.n, c.h, c.o, 10, c.k, l);
  }

  public static f a()
  {
    if (a == null)
      monitorenter;
    try
    {
      if (a == null)
        a = new f();
      return a;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static final void a(String paramString1, String paramString2)
  {
    a().a(1, paramString1, paramString2, null);
  }

  public static final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a().a(2, paramString1, paramString2, paramThrowable);
  }

  public static void b()
  {
    monitorenter;
    try
    {
      a().d();
      if (a != null)
        a = null;
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public static final void b(String paramString1, String paramString2)
  {
    a().a(2, paramString1, paramString2, null);
  }

  public static final void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a().a(16, paramString1, paramString2, paramThrowable);
  }

  protected static File c()
  {
    String str1 = Global.getPackageName();
    if (TextUtils.isEmpty(str1))
      str1 = "default";
    String str2 = c.i + File.separator + str1;
    d.d locald = d.c.b();
    if ((locald != null) && (locald.c() > c.l));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
        return new File(Environment.getExternalStorageDirectory(), str2);
      return new File(Global.getFilesDir(), str2);
    }
  }

  public static final void c(String paramString1, String paramString2)
  {
    a().a(4, paramString1, paramString2, null);
  }

  public static final void d(String paramString1, String paramString2)
  {
    a().a(8, paramString1, paramString2, null);
  }

  public static final void e(String paramString1, String paramString2)
  {
    a().a(16, paramString1, paramString2, null);
  }

  protected void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    e.a.b(paramInt, Thread.currentThread(), System.currentTimeMillis(), paramString1, paramString2, paramThrowable);
    if ((!d.a.a(c.c, paramInt)) || (this.b == null))
      return;
    this.b.b(paramInt, Thread.currentThread(), System.currentTimeMillis(), paramString1, paramString2, paramThrowable);
  }

  protected void d()
  {
    if (this.b != null)
    {
      this.b.a();
      this.b.b();
      this.b = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.a.f
 * JD-Core Version:    0.6.0
 */