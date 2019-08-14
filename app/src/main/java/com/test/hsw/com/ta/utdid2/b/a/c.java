package com.ta.utdid2.b.a;

import java.lang.reflect.Method;

public final class c
{
  public static boolean a;
  private static Class<?> b;
  private static Method c;
  private static Method d;

  static
  {
    int i = 1;
    if (a("alidebug") == i);
    while (true)
    {
      a = i;
      b = null;
      c = null;
      d = null;
      return;
      i = 0;
    }
  }

  private static int a(String paramString)
  {
    try
    {
      if (b == null)
      {
        Class localClass2 = Class.forName("android.os.SystemProperties");
        b = localClass2;
        c = localClass2.getDeclaredMethod("get", new Class[] { String.class });
        Class localClass3 = b;
        Class[] arrayOfClass = new Class[2];
        arrayOfClass[0] = String.class;
        arrayOfClass[1] = Integer.TYPE;
        d = localClass3.getDeclaredMethod("getInt", arrayOfClass);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          Method localMethod = d;
          Class localClass1 = b;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = paramString;
          arrayOfObject[1] = Integer.valueOf(0);
          int i = ((Integer)localMethod.invoke(localClass1, arrayOfObject)).intValue();
          return i;
          localException1 = localException1;
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.b.a.c
 * JD-Core Version:    0.6.0
 */