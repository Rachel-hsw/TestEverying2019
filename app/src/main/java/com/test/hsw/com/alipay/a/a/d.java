package com.alipay.a.a;

import java.lang.reflect.Type;

public final class d
  implements i, j
{
  public final Object a(Object paramObject)
  {
    return ((Enum)paramObject).name();
  }

  public final Object a(Object paramObject, Type paramType)
  {
    return Enum.valueOf((Class)paramType, paramObject.toString());
  }

  public final boolean a(Class<?> paramClass)
  {
    return Enum.class.isAssignableFrom(paramClass);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.a.d
 * JD-Core Version:    0.6.0
 */