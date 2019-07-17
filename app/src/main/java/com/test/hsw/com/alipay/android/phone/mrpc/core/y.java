package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class y
  implements InvocationHandler
{
  protected g a;
  protected Class<?> b;
  protected z c;

  public y(g paramg, Class<?> paramClass, z paramz)
  {
    this.a = paramg;
    this.b = paramClass;
    this.c = paramz;
  }

  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    z localz = this.c;
    return localz.a(paramMethod, paramArrayOfObject);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.android.phone.mrpc.core.y
 * JD-Core Version:    0.6.0
 */