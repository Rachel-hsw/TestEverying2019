package com.tencent.wxop.stat.b;

import android.util.Log;
import com.tencent.wxop.stat.c;

public final class b
{
  private String a = "default";
  private boolean ch = true;
  private int cp = 2;

  public b()
  {
  }

  public b(String paramString)
  {
    this.a = paramString;
  }

  private String c()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null);
    while (true)
    {
      return null;
      int i = arrayOfStackTraceElement.length;
      for (int j = 0; j < i; j++)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
        if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (!localStackTraceElement.getClassName().equals(getClass().getName())))
          return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
      }
    }
  }

  public final void a(Throwable paramThrowable)
  {
    if (this.cp <= 6)
    {
      Log.e(this.a, "", paramThrowable);
      c.F();
    }
  }

  public final void ap()
  {
    this.ch = false;
  }

  public final void b(Object paramObject)
  {
    String str1;
    if ((this.ch) && (this.cp <= 4))
    {
      str1 = c();
      if (str1 != null)
        break label43;
    }
    label43: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.i(this.a, str2);
      c.F();
      return;
    }
  }

  public final void b(Throwable paramThrowable)
  {
    if (this.ch)
      a(paramThrowable);
  }

  public final void c(Object paramObject)
  {
    if (this.ch)
      warn(paramObject);
  }

  public final void d(Object paramObject)
  {
    if (this.ch)
      error(paramObject);
  }

  public final void debug(Object paramObject)
  {
    String str1;
    if (this.cp <= 3)
    {
      str1 = c();
      if (str1 != null)
        break label36;
    }
    label36: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.d(this.a, str2);
      c.F();
      return;
    }
  }

  public final void e(Object paramObject)
  {
    if (this.ch)
      debug(paramObject);
  }

  public final void error(Object paramObject)
  {
    String str1;
    if (this.cp <= 6)
    {
      str1 = c();
      if (str1 != null)
        break label37;
    }
    label37: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.e(this.a, str2);
      c.F();
      return;
    }
  }

  public final void warn(Object paramObject)
  {
    String str1;
    if (this.cp <= 5)
    {
      str1 = c();
      if (str1 != null)
        break label36;
    }
    label36: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.w(this.a, str2);
      c.F();
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.b
 * JD-Core Version:    0.6.0
 */