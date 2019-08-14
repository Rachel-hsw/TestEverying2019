package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class y
{
  public static String a = "Volley";
  public static boolean b = Log.isLoggable(a, 2);

  public static void a(String paramString)
  {
    b("Changing log tag to %s", new Object[] { paramString });
    a = paramString;
    b = Log.isLoggable(a, 2);
  }

  public static void a(String paramString, Object[] paramArrayOfObject)
  {
    if (b)
      Log.v(a, e(paramString, paramArrayOfObject));
  }

  public static void a(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.e(a, e(paramString, paramArrayOfObject), paramThrowable);
  }

  public static void b(String paramString, Object[] paramArrayOfObject)
  {
    Log.d(a, e(paramString, paramArrayOfObject));
  }

  public static void b(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.wtf(a, e(paramString, paramArrayOfObject), paramThrowable);
  }

  public static void c(String paramString, Object[] paramArrayOfObject)
  {
    Log.e(a, e(paramString, paramArrayOfObject));
  }

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
    Log.wtf(a, e(paramString, paramArrayOfObject));
  }

  private static String e(String paramString, Object[] paramArrayOfObject)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    if (paramArrayOfObject == null)
      arrayOfStackTraceElement = new Throwable().fillInStackTrace().getStackTrace();
    label171: for (int i = 2; ; i++)
    {
      if (i >= arrayOfStackTraceElement.length);
      String str2;
      for (String str3 = "<unknown>"; ; str3 = str2.substring(1 + str2.lastIndexOf('$')) + "." + arrayOfStackTraceElement[i].getMethodName())
      {
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Long.valueOf(Thread.currentThread().getId());
        arrayOfObject[1] = str3;
        arrayOfObject[2] = paramString;
        return String.format(localLocale, "[%d] %s: %s", arrayOfObject);
        paramString = String.format(Locale.US, paramString, paramArrayOfObject);
        break;
        if (arrayOfStackTraceElement[i].getClass().equals(y.class))
          break label171;
        String str1 = arrayOfStackTraceElement[i].getClassName();
        str2 = str1.substring(1 + str1.lastIndexOf('.'));
      }
    }
  }

  static class a
  {
    public static final boolean a = y.b;
    private static final long b;
    private final List<a> c = new ArrayList();
    private boolean d = false;

    private long a()
    {
      if (this.c.size() == 0)
        return 0L;
      long l = ((a)this.c.get(0)).c;
      return ((a)this.c.get(-1 + this.c.size())).c - l;
    }

    public void a(String paramString)
    {
      monitorenter;
      try
      {
        this.d = true;
        long l1 = a();
        if (l1 <= 0L);
        while (true)
        {
          return;
          long l2 = ((a)this.c.get(0)).c;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Long.valueOf(l1);
          arrayOfObject1[1] = paramString;
          y.b("(%-4d ms) %s", arrayOfObject1);
          Iterator localIterator = this.c.iterator();
          long l3 = l2;
          while (localIterator.hasNext())
          {
            a locala = (a)localIterator.next();
            long l4 = locala.c;
            Object[] arrayOfObject2 = new Object[3];
            arrayOfObject2[0] = Long.valueOf(l4 - l3);
            arrayOfObject2[1] = Long.valueOf(locala.b);
            arrayOfObject2[2] = locala.a;
            y.b("(+%-4d) [%2d] %s", arrayOfObject2);
            l3 = l4;
          }
        }
      }
      finally
      {
        monitorexit;
      }
      throw localObject;
    }

    public void a(String paramString, long paramLong)
    {
      monitorenter;
      try
      {
        if (this.d)
          throw new IllegalStateException("Marker added to finished log");
      }
      finally
      {
        monitorexit;
      }
      this.c.add(new a(paramString, paramLong, SystemClock.elapsedRealtime()));
      monitorexit;
    }

    protected void finalize()
      throws Throwable
    {
      if (!this.d)
      {
        a("Request on the loose");
        y.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }

    private static class a
    {
      public final String a;
      public final long b;
      public final long c;

      public a(String paramString, long paramLong1, long paramLong2)
      {
        this.a = paramString;
        this.b = paramLong1;
        this.c = paramLong2;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.y
 * JD-Core Version:    0.6.0
 */