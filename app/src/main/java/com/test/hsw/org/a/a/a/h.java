package org.a.a.a;

public class h
{
  static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if ((paramCharSequence instanceof String))
    {
      j = ((String)paramCharSequence).indexOf(paramInt1, paramInt2);
      return j;
    }
    int i = paramCharSequence.length();
    if (paramInt2 < 0)
      paramInt2 = 0;
    for (int j = paramInt2; ; j++)
    {
      if (j >= i)
        break label61;
      if (paramCharSequence.charAt(j) == paramInt1)
        break;
    }
    label61: return -1;
  }

  static int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return paramCharSequence1.toString().indexOf(paramCharSequence2.toString(), paramInt);
  }

  public static CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence == null)
      return null;
    return paramCharSequence.subSequence(paramInt, paramCharSequence.length());
  }

  static boolean a(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3)
  {
    if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String)))
      return ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
    return paramCharSequence1.toString().regionMatches(paramBoolean, paramInt1, paramCharSequence2.toString(), paramInt2, paramInt3);
  }

  static char[] a(CharSequence paramCharSequence)
  {
    char[] arrayOfChar;
    if ((paramCharSequence instanceof String))
      arrayOfChar = ((String)paramCharSequence).toCharArray();
    while (true)
    {
      return arrayOfChar;
      int i = paramCharSequence.length();
      arrayOfChar = new char[paramCharSequence.length()];
      for (int j = 0; j < i; j++)
        arrayOfChar[j] = paramCharSequence.charAt(j);
    }
  }

  static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = -1;
    if ((paramCharSequence instanceof String))
      i = ((String)paramCharSequence).lastIndexOf(paramInt1, paramInt2);
    while (true)
    {
      return i;
      int j = paramCharSequence.length();
      if (paramInt2 < 0)
        continue;
      if (paramInt2 >= j)
        paramInt2 = j - 1;
      for (int k = paramInt2; k >= 0; k--)
        if (paramCharSequence.charAt(k) == paramInt1)
          return k;
    }
  }

  static int b(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return paramCharSequence1.toString().lastIndexOf(paramCharSequence2.toString(), paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h
 * JD-Core Version:    0.6.0
 */