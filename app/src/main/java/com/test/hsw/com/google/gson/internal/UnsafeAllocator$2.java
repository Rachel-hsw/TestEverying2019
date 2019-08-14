package com.google.gson.internal;

import java.lang.reflect.Method;

final class UnsafeAllocator$2 extends UnsafeAllocator
{
  public <T> T newInstance(Class<T> paramClass)
    throws Exception
  {
    return this.val$newInstance.invoke(null, new Object[] { paramClass, Object.class });
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.UnsafeAllocator.2
 * JD-Core Version:    0.6.0
 */