package com.tencent.open.a;

import android.util.Log;

public final class e extends i
{
  public static final e a = new e();

  protected void a(int paramInt, Thread paramThread, long paramLong, String paramString1, String paramString2, Throwable paramThrowable)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      Log.v(paramString1, paramString2, paramThrowable);
      return;
    case 2:
      Log.d(paramString1, paramString2, paramThrowable);
      return;
    case 4:
      Log.i(paramString1, paramString2, paramThrowable);
      return;
    case 8:
      Log.w(paramString1, paramString2, paramThrowable);
      return;
    case 16:
      Log.e(paramString1, paramString2, paramThrowable);
      return;
    case 32:
    }
    Log.e(paramString1, paramString2, paramThrowable);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.a.e
 * JD-Core Version:    0.6.0
 */