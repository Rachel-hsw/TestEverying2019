package com.ta.utdid2.b.a;

public final class h
{
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }

  public static int b(String paramString)
  {
    int i = 0;
    if (paramString.length() > 0)
    {
      char[] arrayOfChar = paramString.toCharArray();
      j = 0;
      while (i < arrayOfChar.length)
      {
        j = j * 31 + arrayOfChar[i];
        i++;
      }
    }
    int j = 0;
    return j;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.b.a.h
 * JD-Core Version:    0.6.0
 */