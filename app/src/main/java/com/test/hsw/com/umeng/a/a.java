package com.umeng.a;

import android.content.Context;
import c.a.bt;

public class a
{
  public static String a;
  public static String b;
  public static int c;
  public static String d;
  public static String e;
  public static boolean f;
  public static int g;
  public static boolean h;
  public static boolean i;
  public static boolean j;
  public static boolean k;
  public static long l;
  private static String m = null;
  private static String n = null;
  private static double[] o;

  static
  {
    a = null;
    b = null;
    d = "";
    e = "";
    f = false;
    o = null;
    h = true;
    i = true;
    j = true;
    k = true;
    l = 30000L;
  }

  public static String a()
  {
    if (c == 1)
      return "5.5.3.0";
    return "5.5.3";
  }

  public static String a(Context paramContext)
  {
    if (m == null)
      m = bt.o(paramContext);
    return m;
  }

  public static void a(double paramDouble1, double paramDouble2)
  {
    if (o == null)
      o = new double[2];
    o[0] = paramDouble1;
    o[1] = paramDouble2;
  }

  public static void a(long paramLong)
  {
    g = 1000 * (int)paramLong;
  }

  public static void a(String paramString)
  {
    m = paramString;
  }

  public static void a(boolean paramBoolean)
  {
    f = paramBoolean;
  }

  public static String b(Context paramContext)
  {
    if (n == null)
      n = bt.t(paramContext);
    return n;
  }

  public static void b(String paramString)
  {
    n = paramString;
  }

  public static double[] b()
  {
    return o;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.a
 * JD-Core Version:    0.6.0
 */