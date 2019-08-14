package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public final class a
{
  private static int level = 6;
  public static d q;
  private static a r;
  private static a s;
  private static final String t;

  static
  {
    b localb = new b();
    r = localb;
    s = localb;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
    localStringBuilder.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
    localStringBuilder.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
    localStringBuilder.append("] BOARD:[" + Build.BOARD);
    localStringBuilder.append("] DEVICE:[" + Build.DEVICE);
    localStringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
    localStringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
    localStringBuilder.append("] HOST:[" + Build.HOST);
    localStringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
    localStringBuilder.append("] MODEL:[" + Build.MODEL);
    localStringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
    localStringBuilder.append("] TAGS:[" + Build.TAGS);
    localStringBuilder.append("] TYPE:[" + Build.TYPE);
    localStringBuilder.append("] USER:[" + Build.USER + "]");
    t = localStringBuilder.toString();
  }

  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }

  public static void a(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if ((s != null) && (s.h() <= 4))
      if (paramArrayOfObject != null)
        break label74;
    label74: for (String str1 = paramString2; ; str1 = String.format(paramString2, paramArrayOfObject))
    {
      if (str1 == null)
        str1 = "";
      String str2 = i(paramString1);
      a locala = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      locala.h(str2, str1);
      return;
    }
  }

  public static void b(String paramString1, String paramString2)
  {
    if ((s != null) && (s.h() <= 3))
    {
      if (paramString2 == null)
        paramString2 = "";
      String str = i(paramString1);
      a locala = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      locala.g(str, paramString2);
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if ((s != null) && (s.h() <= 2))
    {
      if (paramString2 == null)
        paramString2 = "";
      String str = i(paramString1);
      a locala = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      locala.e(str, paramString2);
    }
  }

  public static void d(String paramString1, String paramString2)
  {
    if ((s != null) && (s.h() <= 1))
    {
      if (paramString2 == null)
        paramString2 = "";
      String str = i(paramString1);
      a locala = s;
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      locala.f(str, paramString2);
    }
  }

  private static String i(String paramString)
  {
    if (q != null)
      paramString = q.i(paramString);
    return paramString;
  }

  public static abstract interface a
  {
    public abstract void e(String paramString1, String paramString2);

    public abstract void f(String paramString1, String paramString2);

    public abstract void g(String paramString1, String paramString2);

    public abstract int h();

    public abstract void h(String paramString1, String paramString2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.b.a
 * JD-Core Version:    0.6.0
 */