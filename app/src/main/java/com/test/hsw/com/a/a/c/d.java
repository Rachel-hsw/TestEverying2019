package com.a.a.c;

import android.util.Log;

public final class d
{
  private static final String a = "%1$s\n%2$s";
  private static volatile boolean b = false;
  private static volatile boolean c = true;

  @Deprecated
  public static void a()
  {
    b(true);
  }

  private static void a(int paramInt, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    if (!c)
      return;
    if (paramArrayOfObject.length > 0);
    for (String str = String.format(paramString, paramArrayOfObject); ; str = paramString)
    {
      if (paramThrowable == null);
      while (true)
      {
        Log.println(paramInt, com.a.a.b.d.a, str);
        return;
        if (str == null)
          str = paramThrowable.getMessage();
        str = String.format("%1$s\n%2$s", new Object[] { str, Log.getStackTraceString(paramThrowable) });
      }
    }
  }

  public static void a(String paramString, Object[] paramArrayOfObject)
  {
    if (b)
      a(3, null, paramString, paramArrayOfObject);
  }

  public static void a(Throwable paramThrowable)
  {
    a(6, paramThrowable, null, new Object[0]);
  }

  public static void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    a(6, paramThrowable, paramString, paramArrayOfObject);
  }

  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }

  @Deprecated
  public static void b()
  {
    b(false);
  }

  public static void b(String paramString, Object[] paramArrayOfObject)
  {
    a(4, null, paramString, paramArrayOfObject);
  }

  public static void b(boolean paramBoolean)
  {
    c = paramBoolean;
  }

  public static void c(String paramString, Object[] paramArrayOfObject)
  {
    a(5, null, paramString, paramArrayOfObject);
  }

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
    a(6, null, paramString, paramArrayOfObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.c.d
 * JD-Core Version:    0.6.0
 */