package com.a.a.c;

import java.util.Comparator;

final class f
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    return paramString1.substring(0, paramString1.lastIndexOf("_")).compareTo(paramString2.substring(0, paramString2.lastIndexOf("_")));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.a.a.c.f
 * JD-Core Version:    0.6.0
 */