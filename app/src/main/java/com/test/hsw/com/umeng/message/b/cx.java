package com.umeng.message.b;

import java.util.Comparator;
import java.util.Map.Entry;

final class cx
  implements Comparator<Map.Entry<Integer, ?>>
{
  public int a(Map.Entry<Integer, ?> paramEntry1, Map.Entry<Integer, ?> paramEntry2)
  {
    return ((Integer)paramEntry1.getKey()).compareTo((Integer)paramEntry2.getKey());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cx
 * JD-Core Version:    0.6.0
 */