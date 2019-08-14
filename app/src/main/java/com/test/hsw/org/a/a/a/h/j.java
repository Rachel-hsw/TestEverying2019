package org.a.a.a.h;

import org.a.a.a.v;
import org.a.a.a.w;

public class j
{
  public static String a(String paramString)
  {
    return a(paramString, null);
  }

  public static String a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null, false);
  }

  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null)
      return null;
    if (paramString2 == null)
      paramString2 = w.F;
    if (paramInt < 1)
      paramInt = 1;
    int i = paramString1.length();
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder(i + 32);
    while (i - j > paramInt)
    {
      if (paramString1.charAt(j) == ' ')
      {
        j++;
        continue;
      }
      int k = paramString1.lastIndexOf(' ', paramInt + j);
      if (k >= j)
      {
        localStringBuilder.append(paramString1.substring(j, k));
        localStringBuilder.append(paramString2);
        j = k + 1;
        continue;
      }
      if (paramBoolean)
      {
        localStringBuilder.append(paramString1.substring(j, paramInt + j));
        localStringBuilder.append(paramString2);
        j += paramInt;
        continue;
      }
      int m = paramString1.indexOf(' ', paramInt + j);
      if (m >= 0)
      {
        localStringBuilder.append(paramString1.substring(j, m));
        localStringBuilder.append(paramString2);
        j = m + 1;
        continue;
      }
      localStringBuilder.append(paramString1.substring(j));
      j = i;
    }
    localStringBuilder.append(paramString1.substring(j));
    return localStringBuilder.toString();
  }

  public static String a(String paramString, char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null);
    for (int i = -1; (v.a(paramString)) || (i == 0); i = paramArrayOfChar.length)
      return paramString;
    char[] arrayOfChar = paramString.toCharArray();
    int j = 0;
    int k = 1;
    if (j < arrayOfChar.length)
    {
      char c = arrayOfChar[j];
      if (a(c, paramArrayOfChar))
        k = 1;
      while (true)
      {
        j++;
        break;
        if (k == 0)
          continue;
        arrayOfChar[j] = Character.toTitleCase(c);
        k = 0;
      }
    }
    return new String(arrayOfChar);
  }

  private static boolean a(char paramChar, char[] paramArrayOfChar)
  {
    boolean bool;
    if (paramArrayOfChar == null)
    {
      bool = Character.isWhitespace(paramChar);
      return bool;
    }
    int i = paramArrayOfChar.length;
    for (int j = 0; ; j++)
    {
      bool = false;
      if (j >= i)
        break;
      if (paramChar == paramArrayOfChar[j])
        return true;
    }
  }

  public static String b(String paramString)
  {
    return b(paramString, null);
  }

  public static String b(String paramString, char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null);
    for (int i = -1; (v.a(paramString)) || (i == 0); i = paramArrayOfChar.length)
      return paramString;
    return a(paramString.toLowerCase(), paramArrayOfChar);
  }

  public static String c(String paramString)
  {
    return c(paramString, null);
  }

  public static String c(String paramString, char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null);
    for (int i = -1; (v.a(paramString)) || (i == 0); i = paramArrayOfChar.length)
      return paramString;
    char[] arrayOfChar = paramString.toCharArray();
    int j = 0;
    int k = 1;
    if (j < arrayOfChar.length)
    {
      char c = arrayOfChar[j];
      if (a(c, paramArrayOfChar))
        k = 1;
      while (true)
      {
        j++;
        break;
        if (k == 0)
          continue;
        arrayOfChar[j] = Character.toLowerCase(c);
        k = 0;
      }
    }
    return new String(arrayOfChar);
  }

  public static String d(String paramString)
  {
    if (v.a(paramString))
      return paramString;
    char[] arrayOfChar = paramString.toCharArray();
    boolean bool = true;
    int i = 0;
    if (i < arrayOfChar.length)
    {
      char c = arrayOfChar[i];
      if (Character.isUpperCase(c))
      {
        arrayOfChar[i] = Character.toLowerCase(c);
        bool = false;
      }
      while (true)
      {
        i++;
        break;
        if (Character.isTitleCase(c))
        {
          arrayOfChar[i] = Character.toLowerCase(c);
          bool = false;
          continue;
        }
        if (Character.isLowerCase(c))
        {
          if (bool)
          {
            arrayOfChar[i] = Character.toTitleCase(c);
            bool = false;
            continue;
          }
          arrayOfChar[i] = Character.toUpperCase(c);
          continue;
        }
        bool = Character.isWhitespace(c);
      }
    }
    return new String(arrayOfChar);
  }

  public static String d(String paramString, char[] paramArrayOfChar)
  {
    if (v.a(paramString))
      return paramString;
    if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 0))
      return "";
    int i = paramString.length();
    char[] arrayOfChar = new char[1 + i / 2];
    int j = 0;
    int k = 1;
    int m = 0;
    if (j < i)
    {
      char c = paramString.charAt(j);
      if (a(c, paramArrayOfChar))
        k = 1;
      while (true)
      {
        j++;
        break;
        if (k == 0)
          continue;
        int n = m + 1;
        arrayOfChar[m] = c;
        m = n;
        k = 0;
      }
    }
    return new String(arrayOfChar, 0, m);
  }

  public static String e(String paramString)
  {
    return d(paramString, null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.j
 * JD-Core Version:    0.6.0
 */