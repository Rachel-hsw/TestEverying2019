package com.xiaomi.e;

import com.xiaomi.d.p;
import com.xiaomi.push.d.a;
import java.net.UnknownHostException;

final class c
{
  static a a(Exception paramException)
  {
    e(paramException);
    if (((paramException instanceof p)) && (((p)paramException).a() != null))
      paramException = ((p)paramException).a();
    a locala = new a();
    String str1 = paramException.getMessage();
    if (paramException.getCause() != null)
      str1 = paramException.getCause().getMessage();
    String str2 = paramException.getClass().getSimpleName() + ":" + str1;
    int i = com.xiaomi.d.c.a(paramException);
    if (i != 0)
      locala.a = a.a(i + a.h.a());
    if (locala.a == null)
      locala.a = a.p;
    if (locala.a == a.p)
      locala.b = str2;
    return locala;
  }

  static a b(Exception paramException)
  {
    e(paramException);
    if (((paramException instanceof p)) && (((p)paramException).a() != null))
      paramException = ((p)paramException).a();
    a locala = new a();
    String str1 = paramException.getMessage();
    if (paramException.getCause() != null)
      str1 = paramException.getCause().getMessage();
    int i = com.xiaomi.d.c.a(paramException);
    String str2 = paramException.getClass().getSimpleName() + ":" + str1;
    if (i != 0)
    {
      locala.a = a.a(i + a.r.a());
      if (locala.a == a.C)
      {
        Throwable localThrowable = paramException.getCause();
        if ((localThrowable == null) || (!(localThrowable instanceof UnknownHostException)));
      }
    }
    for (locala.a = a.B; ; locala.a = a.A)
    {
      if ((locala.a == a.z) || (locala.a == a.A) || (locala.a == a.C))
        locala.b = str2;
      return locala;
    }
  }

  static a c(Exception paramException)
  {
    e(paramException);
    if (((paramException instanceof p)) && (((p)paramException).a() != null))
      paramException = ((p)paramException).a();
    a locala = new a();
    String str1 = paramException.getMessage();
    if (paramException.getCause() != null)
      str1 = paramException.getCause().getMessage();
    int i = com.xiaomi.d.c.a(paramException);
    String str2 = paramException.getClass().getSimpleName() + ":" + str1;
    switch (i)
    {
    default:
      locala.a = a.L;
    case 105:
    case 109:
    case 110:
    case 199:
    case 499:
    }
    while (true)
    {
      if ((locala.a == a.K) || (locala.a == a.L) || (locala.a == a.N))
        locala.b = str2;
      return locala;
      locala.a = a.H;
      continue;
      locala.a = a.I;
      continue;
      locala.a = a.J;
      continue;
      locala.a = a.K;
      continue;
      locala.a = a.N;
      if (!str1.startsWith("Terminal binding condition encountered: item-not-found"))
        continue;
      locala.a = a.M;
    }
  }

  static a d(Exception paramException)
  {
    e(paramException);
    if (((paramException instanceof p)) && (((p)paramException).a() != null))
      paramException = ((p)paramException).a();
    a locala = new a();
    String str1 = paramException.getMessage();
    int i = com.xiaomi.d.c.a(paramException);
    String str2 = paramException.getClass().getSimpleName() + ":" + str1;
    switch (i)
    {
    default:
      locala.a = a.X;
    case 105:
    case 109:
    case 110:
    case 199:
    case 499:
    }
    while (true)
    {
      if ((locala.a == a.W) || (locala.a == a.X) || (locala.a == a.Z))
        locala.b = str2;
      return locala;
      locala.a = a.T;
      continue;
      locala.a = a.U;
      continue;
      locala.a = a.V;
      continue;
      locala.a = a.W;
      continue;
      locala.a = a.Z;
      if (!str1.startsWith("Terminal binding condition encountered: item-not-found"))
        continue;
      locala.a = a.Y;
    }
  }

  private static void e(Exception paramException)
  {
    if (paramException == null)
      throw new NullPointerException();
  }

  static class a
  {
    a a;
    String b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.e.c
 * JD-Core Version:    0.6.0
 */