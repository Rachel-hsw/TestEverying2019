package com.alipay.a.a;

import java.lang.reflect.Type;
import java.util.Date;

public final class c
  implements i, j
{
  public final Object a(Object paramObject)
  {
    return Long.valueOf(((Date)paramObject).getTime());
  }

  public final Object a(Object paramObject, Type paramType)
  {
    return new Date(((Long)paramObject).longValue());
  }

  public final boolean a(Class<?> paramClass)
  {
    return Date.class.isAssignableFrom(paramClass);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.c
 * JD-Core Version:    0.6.0
 */