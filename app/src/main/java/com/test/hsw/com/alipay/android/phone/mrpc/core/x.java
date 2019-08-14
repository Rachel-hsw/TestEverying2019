package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

public final class x
{
  private g a;
  private z b;

  public x(g paramg)
  {
    this.a = paramg;
    this.b = new z(this);
  }

  public final g a()
  {
    return this.a;
  }

  public final <T> T a(Class<T> paramClass)
  {
    return Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, new y(this.a, paramClass, this.b));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.x
 * JD-Core Version:    0.6.0
 */