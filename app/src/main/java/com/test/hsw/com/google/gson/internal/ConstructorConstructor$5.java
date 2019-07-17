package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

class ConstructorConstructor$5
  implements ObjectConstructor<T>
{
  public T construct()
  {
    if ((this.val$type instanceof ParameterizedType))
    {
      Type localType = ((ParameterizedType)this.val$type).getActualTypeArguments()[0];
      if ((localType instanceof Class))
        return EnumSet.noneOf((Class)localType);
      throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
    }
    throw new JsonIOException("Invalid EnumSet type: " + this.val$type.toString());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.google.gson.internal.ConstructorConstructor.5
 * JD-Core Version:    0.6.0
 */