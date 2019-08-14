package org.a.a.a;

public class j
{
  public static String a(String paramString, String[] paramArrayOfString)
  {
    if ((v.a(paramString)) || (a(paramArrayOfString)))
      return paramString;
    i locali = i.a(paramArrayOfString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    int k = 32;
    if (j < i)
    {
      char c = arrayOfChar[j];
      if ((c == k) && (j != 0) && (locali.a(c)));
      while (true)
      {
        j++;
        break;
        localStringBuilder.append(c);
        k = c;
      }
    }
    return localStringBuilder.toString();
  }

  private static String a(String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    i locali = i.a(paramArrayOfString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length;
    for (int j = 0; j < i; j++)
    {
      if (locali.a(arrayOfChar[j]) != paramBoolean)
        continue;
      localStringBuilder.append(arrayOfChar[j]);
    }
    return localStringBuilder.toString();
  }

  private static boolean a(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
        if (v.b(paramArrayOfString[j]))
          return false;
    }
    return true;
  }

  public static int b(String paramString, String[] paramArrayOfString)
  {
    boolean bool1 = v.a(paramString);
    int i = 0;
    if (!bool1)
    {
      boolean bool2 = a(paramArrayOfString);
      i = 0;
      if (!bool2)
        break label26;
    }
    while (true)
    {
      return i;
      label26: i locali = i.a(paramArrayOfString);
      char[] arrayOfChar = paramString.toCharArray();
      int j = arrayOfChar.length;
      for (int k = 0; k < j; k++)
      {
        if (!locali.a(arrayOfChar[k]))
          continue;
        i++;
      }
    }
  }

  public static String c(String paramString, String[] paramArrayOfString)
  {
    if (paramString == null)
      return null;
    if ((paramString.length() == 0) || (a(paramArrayOfString)))
      return "";
    return a(paramString, paramArrayOfString, true);
  }

  public static String d(String paramString, String[] paramArrayOfString)
  {
    if ((v.a(paramString)) || (a(paramArrayOfString)))
      return paramString;
    return a(paramString, paramArrayOfString, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.j
 * JD-Core Version:    0.6.0
 */