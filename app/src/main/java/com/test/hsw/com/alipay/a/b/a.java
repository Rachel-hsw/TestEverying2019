package com.alipay.a.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public final class a
{
  public static Class<?> a(Type paramType)
  {
    for (Type localType = paramType; ; localType = ((ParameterizedType)localType).getRawType())
    {
      if ((localType instanceof Class))
        return (Class)localType;
      if (!(localType instanceof ParameterizedType))
        break;
    }
    throw new IllegalArgumentException("TODO");
  }

  public static boolean a(Class<?> paramClass)
  {
    if (paramClass.isPrimitive());
    do
      return true;
    while ((paramClass.equals(String.class)) || (paramClass.equals(Integer.class)) || (paramClass.equals(Long.class)) || (paramClass.equals(Double.class)) || (paramClass.equals(Float.class)) || (paramClass.equals(Boolean.class)) || (paramClass.equals(Short.class)) || (paramClass.equals(Character.class)) || (paramClass.equals(Byte.class)) || (paramClass.equals(Void.class)));
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.a.b.a
 * JD-Core Version:    0.6.0
 */