package com.squareup.a.a.a;

import java.util.Comparator;

final class l
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2)
      return 0;
    if (paramString1 == null)
      return -1;
    if (paramString2 == null)
      return 1;
    return String.CASE_INSENSITIVE_ORDER.compare(paramString1, paramString2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.l
 * JD-Core Version:    0.6.0
 */