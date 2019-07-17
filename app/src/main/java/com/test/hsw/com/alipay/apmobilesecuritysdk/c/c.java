package com.alipay.apmobilesecuritysdk.c;

final class c
  implements Runnable
{
  c(b paramb)
  {
  }

  public final void run()
  {
    try
    {
      b.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      com.alipay.security.mobile.module.a.c.a(localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.c.c
 * JD-Core Version:    0.6.0
 */