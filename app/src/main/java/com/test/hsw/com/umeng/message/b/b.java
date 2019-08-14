package com.umeng.message.b;

import java.lang.reflect.Field;
import java.util.Comparator;

final class b
  implements Comparator<Field>
{
  public int a(Field paramField1, Field paramField2)
  {
    return paramField1.getName().compareTo(paramField2.getName());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.b
 * JD-Core Version:    0.6.0
 */