package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

class ConstructorConstructor$2
  implements ObjectConstructor<T>
{
  public T construct()
  {
    return this.val$rawTypeCreator.createInstance(this.val$type);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.2
 * JD-Core Version:    0.6.0
 */