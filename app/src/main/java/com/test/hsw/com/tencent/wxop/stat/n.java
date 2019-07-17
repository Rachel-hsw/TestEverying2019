package com.tencent.wxop.stat;

import com.tencent.wxop.stat.b.b;

final class n
  implements Thread.UncaughtExceptionHandler
{
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((!c.l()) || (e.J() == null));
    do
    {
      do
      {
        return;
        if (c.x())
        {
          t.s(e.J()).b(new com.tencent.wxop.stat.a.c(e.J(), e.a(e.J(), false, null), paramThrowable, paramThread), null, false, true);
          e.K().debug("MTA has caught the following uncaught exception:");
          e.K().a(paramThrowable);
        }
        e.p(e.J());
      }
      while (e.L() == null);
      e.K().e("Call the original uncaught exception handler.");
    }
    while ((e.L() instanceof n));
    e.L().uncaughtException(paramThread, paramThrowable);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.n
 * JD-Core Version:    0.6.0
 */