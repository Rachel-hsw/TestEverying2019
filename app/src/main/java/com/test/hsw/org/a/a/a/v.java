package org.a.a.a;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class v
{
  public static final String a = "";
  public static final int b = -1;
  private static final int c = 8192;
  private static final Pattern d = Pattern.compile("\\s+");

  public static int a(CharSequence paramCharSequence, int paramInt)
  {
    if (a(paramCharSequence))
      return -1;
    return h.a(paramCharSequence, paramInt, 0);
  }

  public static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (a(paramCharSequence))
      return -1;
    return h.a(paramCharSequence, paramInt1, paramInt2);
  }

  public static int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      return -1;
    return h.a(paramCharSequence1, paramCharSequence2, paramInt);
  }

  private static int a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt, boolean paramBoolean)
  {
    int i = -1;
    int j;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null) || (paramInt <= 0))
      j = i;
    label60: label115: 
    while (true)
    {
      return j;
      if (paramCharSequence2.length() == 0)
      {
        j = 0;
        if (paramBoolean)
          return paramCharSequence1.length();
      }
      if (paramBoolean)
        i = paramCharSequence1.length();
      int k = 0;
      if (paramBoolean);
      for (j = h.b(paramCharSequence1, paramCharSequence2, i - 1); ; j = h.a(paramCharSequence1, paramCharSequence2, i + 1))
      {
        if (j < 0)
          break label115;
        int m = k + 1;
        if (m >= paramInt)
          break;
        k = m;
        i = j;
        break label60;
      }
    }
  }

  public static int a(CharSequence paramCharSequence, String paramString)
  {
    if ((a(paramCharSequence)) || (a(paramString)))
      return -1;
    return a(paramCharSequence, paramString.toCharArray());
  }

  public static int a(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    if ((a(paramCharSequence)) || (c.e(paramArrayOfChar)))
    {
      i = -1;
      return i;
    }
    int j = paramCharSequence.length();
    int k = j - 1;
    int m = paramArrayOfChar.length;
    int n = m - 1;
    label120: for (int i = 0; ; i++)
    {
      if (i >= j)
        break label126;
      char c1 = paramCharSequence.charAt(i);
      for (int i1 = 0; ; i1++)
      {
        if (i1 >= m)
          break label120;
        if ((paramArrayOfChar[i1] == c1) && ((i >= k) || (i1 >= n) || (!Character.isHighSurrogate(c1)) || (paramArrayOfChar[(i1 + 1)] == paramCharSequence.charAt(i + 1))))
          break;
      }
    }
    label126: return -1;
  }

  public static int a(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    int i;
    if ((paramCharSequence == null) || (paramArrayOfCharSequence == null))
      i = -1;
    do
    {
      return i;
      int j = paramArrayOfCharSequence.length;
      int k = 0;
      i = 2147483647;
      if (k >= j)
        continue;
      CharSequence localCharSequence = paramArrayOfCharSequence[k];
      if (localCharSequence == null);
      while (true)
      {
        k++;
        break;
        int m = h.a(paramCharSequence, localCharSequence, 0);
        if ((m == -1) || (m >= i))
          continue;
        i = m;
      }
    }
    while (i != 2147483647);
    return -1;
  }

  public static int a(CharSequence[] paramArrayOfCharSequence)
  {
    int i;
    if ((paramArrayOfCharSequence == null) || (paramArrayOfCharSequence.length <= 1))
      i = -1;
    label167: label221: label231: 
    while (true)
    {
      return i;
      int j = paramArrayOfCharSequence.length;
      int k = 2147483647;
      int m = 0;
      int n = 0;
      int i1 = 1;
      int i2 = 0;
      if (m < j)
      {
        int i9;
        int i8;
        int i7;
        if (paramArrayOfCharSequence[m] == null)
        {
          i9 = i1;
          i8 = 1;
          i7 = 0;
        }
        while (true)
        {
          m++;
          int i10 = i7;
          i1 = i9;
          i2 = i8;
          k = i10;
          break;
          i7 = Math.min(paramArrayOfCharSequence[m].length(), k);
          n = Math.max(paramArrayOfCharSequence[m].length(), n);
          i8 = i2;
          i9 = 0;
        }
      }
      if ((i1 != 0) || ((n == 0) && (i2 == 0)))
        return -1;
      i = 0;
      if (k == 0)
        continue;
      int i3 = 0;
      int i4 = -1;
      int i6;
      if (i3 < k)
      {
        int i5 = paramArrayOfCharSequence[0].charAt(i3);
        i6 = 1;
        if (i6 < j)
        {
          if (paramArrayOfCharSequence[i6].charAt(i3) != i5)
            i4 = i3;
        }
        else
          if (i4 == -1)
            break label221;
      }
      for (i = i4; ; i = i4)
      {
        if ((i != -1) || (k == n))
          break label231;
        return k;
        i6++;
        break label167;
        i3++;
        break;
      }
    }
  }

  public static String a(char paramChar, int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    for (int i = paramInt - 1; i >= 0; i--)
      arrayOfChar[i] = paramChar;
    return new String(arrayOfChar);
  }

  public static String a(Iterable<?> paramIterable, char paramChar)
  {
    if (paramIterable == null)
      return null;
    return a(paramIterable.iterator(), paramChar);
  }

  public static String a(Iterable<?> paramIterable, String paramString)
  {
    if (paramIterable == null)
      return null;
    return a(paramIterable.iterator(), paramString);
  }

  public static String a(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.trim();
  }

  public static String a(String paramString, char paramChar1, char paramChar2)
  {
    if (paramString == null)
      return null;
    return paramString.replace(paramChar1, paramChar2);
  }

  public static String a(String paramString, int paramInt)
  {
    if (paramString == null)
      return null;
    if (paramInt < 0);
    for (int i = paramInt + paramString.length(); ; i = paramInt)
    {
      if (i < 0)
        i = 0;
      if (i > paramString.length())
        return "";
      return paramString.substring(i);
    }
  }

  public static String a(String paramString, int paramInt, char paramChar)
  {
    if (paramString == null)
      paramString = null;
    int i;
    do
    {
      return paramString;
      i = paramInt - paramString.length();
    }
    while (i <= 0);
    if (i > 8192)
      return a(paramString, paramInt, String.valueOf(paramChar));
    return paramString.concat(a(paramChar, i));
  }

  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      return null;
    if (paramInt2 < 0);
    for (int i = paramInt2 + paramString.length(); ; i = paramInt2)
    {
      if (paramInt1 < 0)
        paramInt1 += paramString.length();
      if (i > paramString.length())
        i = paramString.length();
      if (paramInt1 > i)
        return "";
      if (paramInt1 < 0)
        paramInt1 = 0;
      int j = 0;
      if (i < 0);
      while (true)
      {
        return paramString.substring(paramInt1, j);
        j = i;
      }
    }
  }

  public static String a(String paramString1, int paramInt, String paramString2)
  {
    int i = 0;
    if (paramString1 == null)
      paramString1 = null;
    int j;
    int k;
    do
    {
      return paramString1;
      if (a(paramString2))
        paramString2 = " ";
      j = paramString2.length();
      k = paramInt - paramString1.length();
    }
    while (k <= 0);
    if ((j == 1) && (k <= 8192))
      return a(paramString1, paramInt, paramString2.charAt(0));
    if (k == j)
      return paramString1.concat(paramString2);
    if (k < j)
      return paramString1.concat(paramString2.substring(0, k));
    char[] arrayOfChar1 = new char[k];
    char[] arrayOfChar2 = paramString2.toCharArray();
    while (i < k)
    {
      arrayOfChar1[i] = arrayOfChar2[(i % j)];
      i++;
    }
    return paramString1.concat(new String(arrayOfChar1));
  }

  public static String a(String paramString1, String paramString2)
  {
    if (a(paramString1))
      return paramString1;
    return c(b(paramString1, paramString2), paramString2);
  }

  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (paramString1 == null)
      return null;
    if (paramString2 == null)
      paramString2 = "";
    int i = paramString1.length();
    if (paramInt1 < 0);
    for (int j = 0; ; j = paramInt1)
    {
      if (j > i)
        j = i;
      if (paramInt2 < 0);
      for (int k = 0; ; k = paramInt2)
      {
        if (k > i)
          k = i;
        if (j > k);
        while (true)
        {
          return 1 + (i + k - j + paramString2.length()) + paramString1.substring(0, k) + paramString2 + paramString1.substring(j);
          int m = k;
          k = j;
          j = m;
        }
      }
    }
  }

  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null));
    int i;
    int j;
    do
    {
      do
      {
        return null;
        i = paramString1.indexOf(paramString2);
      }
      while (i == -1);
      j = paramString1.indexOf(paramString3, i + paramString2.length());
    }
    while (j == -1);
    return paramString1.substring(i + paramString2.length(), j);
  }

  public static String a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = 64;
    if ((a(paramString1)) || (a(paramString2)) || (paramString3 == null) || (paramInt == 0));
    int j;
    do
    {
      return paramString1;
      j = paramString1.indexOf(paramString2, 0);
    }
    while (j == -1);
    int k = paramString2.length();
    int m = paramString3.length() - k;
    if (m < 0)
      m = 0;
    StringBuilder localStringBuilder;
    int n;
    if (paramInt < 0)
    {
      i = 16;
      localStringBuilder = new StringBuilder(i * m + paramString1.length());
      n = 0;
    }
    while (true)
    {
      if (j != -1)
      {
        localStringBuilder.append(paramString1.substring(n, j)).append(paramString3);
        n = j + k;
        paramInt--;
        if (paramInt != 0);
      }
      else
      {
        localStringBuilder.append(paramString1.substring(n));
        return localStringBuilder.toString();
        if (paramInt > i)
          break;
        i = paramInt;
        break;
      }
      j = paramString1.indexOf(paramString2, n);
    }
  }

  public static String a(String paramString, Locale paramLocale)
  {
    if (paramString == null)
      return null;
    return paramString.toUpperCase(paramLocale);
  }

  public static String a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    return a(paramString, paramArrayOfString1, paramArrayOfString2, false, 0);
  }

  private static String a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0) || (paramArrayOfString1 == null) || (paramArrayOfString1.length == 0) || (paramArrayOfString2 == null) || (paramArrayOfString2.length == 0));
    do
    {
      int i;
      boolean[] arrayOfBoolean;
      int m;
      int n;
      do
      {
        return paramString;
        if (paramInt < 0)
          throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
        i = paramArrayOfString1.length;
        int j = paramArrayOfString2.length;
        if (i != j)
          throw new IllegalArgumentException("Search and Replace array lengths don't match: " + i + " vs " + j);
        arrayOfBoolean = new boolean[i];
        int k = 0;
        m = -1;
        n = -1;
        if (k >= i)
          continue;
        if ((arrayOfBoolean[k] != 0) || (paramArrayOfString1[k] == null) || (paramArrayOfString1[k].length() == 0) || (paramArrayOfString2[k] == null));
        while (true)
        {
          k++;
          break;
          int i11 = paramString.indexOf(paramArrayOfString1[k]);
          if (i11 == -1)
          {
            arrayOfBoolean[k] = true;
            continue;
          }
          if ((n != -1) && (i11 >= n))
            continue;
          m = k;
          n = i11;
        }
      }
      while (n == -1);
      int i1 = 0;
      int i2 = 0;
      if (i1 < paramArrayOfString1.length)
      {
        if ((paramArrayOfString1[i1] == null) || (paramArrayOfString2[i1] == null));
        while (true)
        {
          i1++;
          break;
          int i10 = paramArrayOfString2[i1].length() - paramArrayOfString1[i1].length();
          if (i10 <= 0)
            continue;
          i2 += i10 * 3;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder(Math.min(i2, paramString.length() / 5) + paramString.length());
      int i3 = m;
      int i6;
      for (int i4 = 0; n != -1; i4 = i6)
      {
        while (i4 < n)
        {
          localStringBuilder.append(paramString.charAt(i4));
          i4++;
        }
        localStringBuilder.append(paramArrayOfString2[i3]);
        i6 = n + paramArrayOfString1[i3].length();
        int i7 = 0;
        int i8 = -1;
        n = -1;
        if (i7 < i)
        {
          if ((arrayOfBoolean[i7] != 0) || (paramArrayOfString1[i7] == null) || (paramArrayOfString1[i7].length() == 0) || (paramArrayOfString2[i7] == null));
          while (true)
          {
            i7++;
            break;
            int i9 = paramString.indexOf(paramArrayOfString1[i7], i6);
            if (i9 == -1)
            {
              arrayOfBoolean[i7] = true;
              continue;
            }
            if ((n != -1) && (i9 >= n))
              continue;
            i8 = i7;
            n = i9;
          }
        }
        i3 = i8;
      }
      int i5 = paramString.length();
      while (i4 < i5)
      {
        localStringBuilder.append(paramString.charAt(i4));
        i4++;
      }
      paramString = localStringBuilder.toString();
    }
    while (!paramBoolean);
    return a(paramString, paramArrayOfString1, paramArrayOfString2, paramBoolean, paramInt - 1);
  }

  public static String a(Iterator<?> paramIterator, char paramChar)
  {
    if (paramIterator == null)
      return null;
    if (!paramIterator.hasNext())
      return "";
    Object localObject1 = paramIterator.next();
    if (!paramIterator.hasNext())
      return p.c(localObject1);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (localObject1 != null)
      localStringBuilder.append(localObject1);
    while (paramIterator.hasNext())
    {
      localStringBuilder.append(paramChar);
      Object localObject2 = paramIterator.next();
      if (localObject2 == null)
        continue;
      localStringBuilder.append(localObject2);
    }
    return localStringBuilder.toString();
  }

  public static String a(Iterator<?> paramIterator, String paramString)
  {
    if (paramIterator == null)
      return null;
    if (!paramIterator.hasNext())
      return "";
    Object localObject1 = paramIterator.next();
    if (!paramIterator.hasNext())
      return p.c(localObject1);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (localObject1 != null)
      localStringBuilder.append(localObject1);
    while (paramIterator.hasNext())
    {
      if (paramString != null)
        localStringBuilder.append(paramString);
      Object localObject2 = paramIterator.next();
      if (localObject2 == null)
        continue;
      localStringBuilder.append(localObject2);
    }
    return localStringBuilder.toString();
  }

  public static String a(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException
  {
    if (paramString == null)
      return new String(paramArrayOfByte);
    return new String(paramArrayOfByte, paramString);
  }

  public static <T> String a(T[] paramArrayOfT)
  {
    return a(paramArrayOfT, null);
  }

  public static String a(Object[] paramArrayOfObject, char paramChar)
  {
    if (paramArrayOfObject == null)
      return null;
    return a(paramArrayOfObject, paramChar, 0, paramArrayOfObject.length);
  }

  public static String a(Object[] paramArrayOfObject, char paramChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfObject == null)
      return null;
    int i = paramInt2 - paramInt1;
    if (i <= 0)
      return "";
    StringBuilder localStringBuilder = new StringBuilder(i * 16);
    for (int j = paramInt1; j < paramInt2; j++)
    {
      if (j > paramInt1)
        localStringBuilder.append(paramChar);
      if (paramArrayOfObject[j] == null)
        continue;
      localStringBuilder.append(paramArrayOfObject[j]);
    }
    return localStringBuilder.toString();
  }

  public static String a(Object[] paramArrayOfObject, String paramString)
  {
    if (paramArrayOfObject == null)
      return null;
    return a(paramArrayOfObject, paramString, 0, paramArrayOfObject.length);
  }

  public static String a(Object[] paramArrayOfObject, String paramString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfObject == null)
      return null;
    if (paramString == null)
      paramString = "";
    int i = paramInt2 - paramInt1;
    if (i <= 0)
      return "";
    StringBuilder localStringBuilder = new StringBuilder(i * 16);
    for (int j = paramInt1; j < paramInt2; j++)
    {
      if (j > paramInt1)
        localStringBuilder.append(paramString);
      if (paramArrayOfObject[j] == null)
        continue;
      localStringBuilder.append(paramArrayOfObject[j]);
    }
    return localStringBuilder.toString();
  }

  public static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }

  public static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == null)
      return paramCharSequence2 == null;
    return paramCharSequence1.equals(paramCharSequence2);
  }

  private static boolean a(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    int i;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
    {
      i = 0;
      if (paramCharSequence1 == null)
      {
        i = 0;
        if (paramCharSequence2 == null)
          i = 1;
      }
    }
    int j;
    int k;
    do
    {
      return i;
      j = paramCharSequence2.length();
      k = paramCharSequence1.length();
      i = 0;
    }
    while (j > k);
    return h.a(paramCharSequence1, paramBoolean, 0, paramCharSequence2, 0, paramCharSequence2.length());
  }

  public static String[] a(String paramString, char paramChar)
  {
    return a(paramString, paramChar, false);
  }

  private static String[] a(String paramString, char paramChar, boolean paramBoolean)
  {
    if (paramString == null)
      return null;
    int i = paramString.length();
    if (i == 0)
      return c.c;
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    while (n < i)
    {
      if (paramString.charAt(n) == paramChar)
      {
        if ((k != 0) || (paramBoolean))
        {
          localArrayList.add(paramString.substring(m, n));
          j = 1;
          k = 0;
        }
        m = n + 1;
        n = m;
        continue;
      }
      int i1 = n + 1;
      k = 1;
      n = i1;
      j = 0;
    }
    if ((k != 0) || ((paramBoolean) && (j != 0)))
      localArrayList.add(paramString.substring(m, n));
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public static String[] a(String paramString1, String paramString2, int paramInt)
  {
    return b(paramString1, paramString2, paramInt, false);
  }

  private static String[] a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if (paramString1 == null)
      return null;
    int j = paramString1.length();
    if (j == 0)
      return c.c;
    if ((paramString2 == null) || ("".equals(paramString2)))
      return b(paramString1, null, paramInt, paramBoolean);
    int k = paramString2.length();
    ArrayList localArrayList = new ArrayList();
    int m = 0;
    int n = 0;
    while (m < j)
    {
      m = paramString1.indexOf(paramString2, n);
      if (m > -1)
      {
        if (m > n)
        {
          int i1 = i + 1;
          if (i1 == paramInt)
          {
            localArrayList.add(paramString1.substring(n));
            m = j;
            i = i1;
            continue;
          }
          localArrayList.add(paramString1.substring(n, m));
          n = m + k;
          i = i1;
          continue;
        }
        if (paramBoolean)
        {
          i++;
          if (i != paramInt)
            break label197;
          localArrayList.add(paramString1.substring(n));
          m = j;
        }
        while (true)
        {
          n = m + k;
          break;
          label197: localArrayList.add("");
        }
      }
      localArrayList.add(paramString1.substring(n));
      m = j;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  private static String[] a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return null;
    if (paramString.length() == 0)
      return c.c;
    char[] arrayOfChar = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList();
    int i = Character.getType(arrayOfChar[0]);
    int j = 0;
    int k = i;
    int m = 1;
    while (m < arrayOfChar.length)
    {
      int n = Character.getType(arrayOfChar[m]);
      if (n == k)
      {
        m++;
        continue;
      }
      int i1;
      if ((paramBoolean) && (n == 2) && (k == 1))
      {
        i1 = m - 1;
        if (i1 != j)
          localArrayList.add(new String(arrayOfChar, j, i1 - j));
      }
      for (j = i1; ; j = m)
      {
        k = n;
        break;
        localArrayList.add(new String(arrayOfChar, j, m - j));
      }
    }
    localArrayList.add(new String(arrayOfChar, j, arrayOfChar.length - j));
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public static String[] a(String[] paramArrayOfString)
  {
    return a(paramArrayOfString, null);
  }

  public static String[] a(String[] paramArrayOfString, String paramString)
  {
    int i;
    if (paramArrayOfString != null)
    {
      i = paramArrayOfString.length;
      if (i != 0);
    }
    else
    {
      return paramArrayOfString;
    }
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++)
      arrayOfString[j] = a(paramArrayOfString[j], paramString);
    return arrayOfString;
  }

  public static int b(CharSequence paramCharSequence, int paramInt)
  {
    if (a(paramCharSequence))
      return -1;
    return h.b(paramCharSequence, paramInt, paramCharSequence.length());
  }

  public static int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (a(paramCharSequence))
      return -1;
    return h.b(paramCharSequence, paramInt1, paramInt2);
  }

  public static int b(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return a(paramCharSequence1, paramCharSequence2, paramInt, false);
  }

  public static int b(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    int i = -1;
    if ((paramCharSequence == null) || (paramArrayOfCharSequence == null))
      return i;
    int j = paramArrayOfCharSequence.length;
    int k = 0;
    label18: CharSequence localCharSequence;
    if (k < j)
    {
      localCharSequence = paramArrayOfCharSequence[k];
      if (localCharSequence != null)
        break label41;
    }
    while (true)
    {
      k++;
      break label18;
      break;
      label41: int m = h.b(paramCharSequence, localCharSequence, paramCharSequence.length());
      if (m <= i)
        continue;
      i = m;
    }
  }

  public static String b(String paramString)
  {
    String str = a(paramString);
    if (a(str))
      str = null;
    return str;
  }

  public static String b(String paramString, int paramInt)
  {
    if (paramString == null)
      paramString = null;
    do
    {
      return paramString;
      if (paramInt < 0)
        return "";
    }
    while (paramString.length() <= paramInt);
    return paramString.substring(0, paramInt);
  }

  public static String b(String paramString, int paramInt, char paramChar)
  {
    if (paramString == null)
      paramString = null;
    int i;
    do
    {
      return paramString;
      i = paramInt - paramString.length();
    }
    while (i <= 0);
    if (i > 8192)
      return b(paramString, paramInt, String.valueOf(paramChar));
    return a(paramChar, i).concat(paramString);
  }

  public static String b(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      return null;
    if ((paramInt2 < 0) || (paramInt1 > paramString.length()))
      return "";
    if (paramInt1 < 0)
      paramInt1 = 0;
    if (paramString.length() <= paramInt1 + paramInt2)
      return paramString.substring(paramInt1);
    return paramString.substring(paramInt1, paramInt1 + paramInt2);
  }

  public static String b(String paramString1, int paramInt, String paramString2)
  {
    int i = 0;
    if (paramString1 == null)
      paramString1 = null;
    int j;
    int k;
    do
    {
      return paramString1;
      if (a(paramString2))
        paramString2 = " ";
      j = paramString2.length();
      k = paramInt - paramString1.length();
    }
    while (k <= 0);
    if ((j == 1) && (k <= 8192))
      return b(paramString1, paramInt, paramString2.charAt(0));
    if (k == j)
      return paramString2.concat(paramString1);
    if (k < j)
      return paramString2.substring(0, k).concat(paramString1);
    char[] arrayOfChar1 = new char[k];
    char[] arrayOfChar2 = paramString2.toCharArray();
    while (i < k)
    {
      arrayOfChar1[i] = arrayOfChar2[(i % j)];
      i++;
    }
    return new String(arrayOfChar1).concat(paramString1);
  }

  public static String b(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 != null)
    {
      i = paramString1.length();
      if (i != 0)
        break label15;
    }
    label15: int j;
    while (true)
    {
      return paramString1;
      j = 0;
      if (paramString2 == null)
        while ((j != i) && (Character.isWhitespace(paramString1.charAt(j))))
          j++;
      int k = paramString2.length();
      j = 0;
      if (k == 0)
        continue;
      while ((j != i) && (paramString2.indexOf(paramString1.charAt(j)) != -1))
        j++;
    }
    return paramString1.substring(j);
  }

  public static String b(String paramString, Locale paramLocale)
  {
    if (paramString == null)
      return null;
    return paramString.toLowerCase(paramLocale);
  }

  public static String b(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString1 == null);
    for (int i = 0; ; i = paramArrayOfString1.length)
      return a(paramString, paramArrayOfString1, paramArrayOfString2, true, i);
  }

  public static String b(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      return "";
    int i = a(paramArrayOfString);
    if (i == -1)
    {
      if (paramArrayOfString[0] == null)
        return "";
      return paramArrayOfString[0];
    }
    if (i == 0)
      return "";
    return paramArrayOfString[0].substring(0, i);
  }

  public static boolean b(CharSequence paramCharSequence)
  {
    return !a(paramCharSequence);
  }

  public static boolean b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      return paramCharSequence1 == paramCharSequence2;
    return h.a(paramCharSequence1, true, 0, paramCharSequence2, 0, Math.max(paramCharSequence1.length(), paramCharSequence2.length()));
  }

  private static boolean b(CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean)
  {
    int i;
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
    {
      i = 0;
      if (paramCharSequence1 == null)
      {
        i = 0;
        if (paramCharSequence2 == null)
          i = 1;
      }
    }
    int j;
    int k;
    do
    {
      return i;
      j = paramCharSequence2.length();
      k = paramCharSequence1.length();
      i = 0;
    }
    while (j > k);
    return h.a(paramCharSequence1, paramBoolean, paramCharSequence1.length() - paramCharSequence2.length(), paramCharSequence2, 0, paramCharSequence2.length());
  }

  public static boolean b(CharSequence paramCharSequence, String paramString)
  {
    if ((paramCharSequence == null) || (paramString == null))
      return false;
    return d(paramCharSequence, paramString.toCharArray());
  }

  public static boolean b(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    int i = 1;
    if ((a(paramCharSequence)) || (c.e(paramArrayOfChar)))
    {
      i = 0;
      return i;
    }
    int j = paramCharSequence.length();
    int k = paramArrayOfChar.length;
    int m = j - 1;
    int n = k - 1;
    label127: for (int i1 = 0; ; i1++)
    {
      if (i1 >= j)
        break label133;
      char c1 = paramCharSequence.charAt(i1);
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= k)
          break label127;
        if ((paramArrayOfChar[i2] == c1) && ((!Character.isHighSurrogate(c1)) || (i2 == n) || ((i1 < m) && (paramArrayOfChar[(i2 + 1)] == paramCharSequence.charAt(i1 + 1)))))
          break;
      }
    }
    label133: return false;
  }

  public static String[] b(String paramString, char paramChar)
  {
    return a(paramString, paramChar, true);
  }

  public static String[] b(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, false);
  }

  private static String[] b(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramString1 == null)
      return null;
    int i = paramString1.length();
    if (i == 0)
      return c.c;
    ArrayList localArrayList = new ArrayList();
    int m;
    int n;
    int i1;
    int k;
    int i23;
    int i22;
    label96: int i24;
    int i25;
    if (paramString2 == null)
    {
      m = 0;
      n = 0;
      i1 = 0;
      k = 0;
      int i20 = 1;
      if (k >= i)
        break label488;
      if (Character.isWhitespace(paramString1.charAt(k)))
      {
        if ((n == 0) && (!paramBoolean))
          break label556;
        int i21 = i20 + 1;
        if (i20 != paramInt)
          break label546;
        i23 = 0;
        i22 = i;
        localArrayList.add(paramString1.substring(i1, i22));
        i20 = i21;
        i24 = i22;
        i25 = 0;
      }
    }
    while (true)
    {
      i1 = i24 + 1;
      n = i25;
      m = i23;
      k = i1;
      break;
      k++;
      n = 1;
      m = 0;
      break;
      int i12;
      int i16;
      int i15;
      int i17;
      int i18;
      label259: int i2;
      int i3;
      if (paramString2.length() == 1)
      {
        int i10 = paramString2.charAt(0);
        m = 0;
        n = 0;
        int i11 = 0;
        i12 = 0;
        int i13 = 1;
        while (true)
          if (i12 < i)
          {
            if (paramString1.charAt(i12) == i10)
            {
              if ((n == 0) && (!paramBoolean))
                break label509;
              int i14 = i13 + 1;
              if (i13 != paramInt)
                break;
              i16 = 0;
              i15 = i;
              localArrayList.add(paramString1.substring(i11, i15));
              i13 = i14;
              i17 = i15;
              i18 = 0;
              i11 = i17 + 1;
              n = i18;
              m = i16;
              i12 = i11;
              continue;
            }
            else
            {
              i12++;
              n = 1;
              m = 0;
              continue;
            }
          }
          else
          {
            i2 = i12;
            i3 = i11;
            label300: if ((n != 0) || ((paramBoolean) && (m != 0)))
              localArrayList.add(paramString1.substring(i3, i2));
            return (String[])localArrayList.toArray(new String[localArrayList.size()]);
          }
      }
      while (true)
      {
        if (k < i)
        {
          int i6;
          int i5;
          label399: int i7;
          int i8;
          if (paramString2.indexOf(paramString1.charAt(k)) >= 0)
          {
            if ((n == 0) && (!paramBoolean))
              break label469;
            int i4 = j + 1;
            if (j != paramInt)
              break label459;
            i6 = 0;
            i5 = i;
            localArrayList.add(paramString1.substring(i1, i5));
            j = i4;
            i7 = i5;
            i8 = 0;
          }
          while (true)
          {
            i1 = i7 + 1;
            n = i8;
            m = i6;
            k = i1;
            break;
            k++;
            n = 1;
            m = 0;
            break;
            label459: i5 = k;
            i6 = 1;
            break label399;
            label469: int i9 = m;
            i8 = n;
            i7 = k;
            i6 = i9;
          }
        }
        label488: i2 = k;
        i3 = i1;
        break label300;
        i15 = i12;
        i16 = 1;
        break;
        label509: int i19 = m;
        i18 = n;
        i17 = i12;
        i16 = i19;
        break label259;
        int j = 1;
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
      }
      label546: i22 = k;
      i23 = 1;
      break label96;
      label556: int i26 = m;
      i25 = n;
      i24 = k;
      i23 = i26;
    }
  }

  public static String[] b(String paramString1, String paramString2, String paramString3)
  {
    label18: int i;
    int j;
    int k;
    ArrayList localArrayList;
    if ((paramString1 == null) || (a(paramString2)) || (a(paramString3)))
    {
      break label80;
      return null;
    }
    else
    {
      i = paramString1.length();
      if (i == 0)
        return c.c;
      j = paramString3.length();
      k = paramString2.length();
      localArrayList = new ArrayList();
    }
    label80: int i2;
    for (int m = 0; ; m = i2 + j)
    {
      int n;
      if (m < i - j)
      {
        n = paramString1.indexOf(paramString2, m);
        if (n >= 0);
      }
      else
      {
        if (localArrayList.isEmpty())
          break label18;
        return (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      int i1 = n + k;
      i2 = paramString1.indexOf(paramString3, i1);
      if (i2 < 0)
        break;
      localArrayList.add(paramString1.substring(i1, i2));
    }
  }

  public static int c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      return -1;
    return h.a(paramCharSequence1, paramCharSequence2, 0);
  }

  public static int c(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      paramInt = -1;
    int i;
    do
    {
      return paramInt;
      if (paramInt < 0)
        paramInt = 0;
      i = 1 + (paramCharSequence1.length() - paramCharSequence2.length());
      if (paramInt > i)
        return -1;
    }
    while (paramCharSequence2.length() == 0);
    for (int j = paramInt; j < i; j++)
      if (h.a(paramCharSequence1, true, j, paramCharSequence2, 0, paramCharSequence2.length()))
        return j;
    return -1;
  }

  public static int c(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    int i;
    if ((a(paramCharSequence)) || (c.e(paramArrayOfChar)))
      i = -1;
    label124: 
    while (true)
    {
      return i;
      int j = paramCharSequence.length();
      int k = j - 1;
      int m = paramArrayOfChar.length;
      int n = m - 1;
      i = 0;
      if (i >= j)
        break;
      char c1 = paramCharSequence.charAt(i);
      for (int i1 = 0; ; i1++)
      {
        if (i1 >= m)
          break label124;
        if ((paramArrayOfChar[i1] != c1) || ((i < k) && (i1 < n) && (Character.isHighSurrogate(c1)) && (paramArrayOfChar[(i1 + 1)] != paramCharSequence.charAt(i + 1))))
          continue;
        i++;
        break;
      }
    }
    return -1;
  }

  public static String c(String paramString)
  {
    if (paramString == null)
      return "";
    return paramString.trim();
  }

  public static String c(String paramString, char paramChar)
  {
    if ((a(paramString)) || (paramString.indexOf(paramChar) == -1))
      return paramString;
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    int j = 0;
    while (i < arrayOfChar.length)
    {
      if (arrayOfChar[i] != paramChar)
      {
        int k = j + 1;
        arrayOfChar[j] = arrayOfChar[i];
        j = k;
      }
      i++;
    }
    return new String(arrayOfChar, 0, j);
  }

  public static String c(String paramString, int paramInt)
  {
    if (paramString == null)
      paramString = null;
    do
    {
      return paramString;
      if (paramInt < 0)
        return "";
    }
    while (paramString.length() <= paramInt);
    return paramString.substring(paramString.length() - paramInt);
  }

  public static String c(String paramString, int paramInt, char paramChar)
  {
    if ((paramString == null) || (paramInt <= 0));
    int i;
    int j;
    do
    {
      return paramString;
      i = paramString.length();
      j = paramInt - i;
    }
    while (j <= 0);
    return a(b(paramString, i + j / 2, paramChar), paramInt, paramChar);
  }

  public static String c(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      paramString = null;
    do
    {
      return paramString;
      if (paramInt2 >= 4)
        continue;
      throw new IllegalArgumentException("Minimum abbreviation width is 4");
    }
    while (paramString.length() <= paramInt2);
    if (paramInt1 > paramString.length())
      paramInt1 = paramString.length();
    if (paramString.length() - paramInt1 < paramInt2 - 3)
      paramInt1 = paramString.length() - (paramInt2 - 3);
    if (paramInt1 <= 4)
      return paramString.substring(0, paramInt2 - 3) + "...";
    if (paramInt2 < 7)
      throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
    if (-3 + (paramInt1 + paramInt2) < paramString.length())
      return "..." + h(paramString.substring(paramInt1), paramInt2 - 3);
    return "..." + paramString.substring(paramString.length() - (paramInt2 - 3));
  }

  public static String c(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1 == null) || (paramInt <= 0));
    int i;
    int j;
    do
    {
      return paramString1;
      if (a(paramString2))
        paramString2 = " ";
      i = paramString1.length();
      j = paramInt - i;
    }
    while (j <= 0);
    return a(b(paramString1, i + j / 2, paramString2), paramInt, paramString2);
  }

  public static String c(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 != null)
    {
      i = paramString1.length();
      if (i != 0)
        break label15;
    }
    while (true)
    {
      return paramString1;
      label15: if (paramString2 == null)
        while ((i != 0) && (Character.isWhitespace(paramString1.charAt(i - 1))))
          i--;
      if (paramString2.length() == 0)
        continue;
      while ((i != 0) && (paramString2.indexOf(paramString1.charAt(i - 1)) != -1))
        i--;
    }
    return paramString1.substring(0, i);
  }

  public static String c(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, 1);
  }

  public static boolean c(CharSequence paramCharSequence)
  {
    int j;
    int i;
    if (paramCharSequence != null)
    {
      j = paramCharSequence.length();
      if (j != 0);
    }
    else
    {
      i = 1;
      return i;
    }
    for (int k = 0; ; k++)
    {
      if (k >= j)
        break label51;
      boolean bool = Character.isWhitespace(paramCharSequence.charAt(k));
      i = 0;
      if (!bool)
        break;
    }
    label51: return true;
  }

  public static boolean c(CharSequence paramCharSequence, int paramInt)
  {
    if (a(paramCharSequence));
    do
      return false;
    while (h.a(paramCharSequence, paramInt, 0) < 0);
    return true;
  }

  public static boolean c(CharSequence paramCharSequence, String paramString)
  {
    if ((paramCharSequence == null) || (paramString == null))
      return true;
    return e(paramCharSequence, paramString.toCharArray());
  }

  public static boolean c(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    if ((a(paramCharSequence)) || (c.f(paramArrayOfCharSequence)));
    while (true)
    {
      return false;
      int i = paramArrayOfCharSequence.length;
      for (int j = 0; j < i; j++)
        if (p(paramCharSequence, paramArrayOfCharSequence[j]))
          return true;
    }
  }

  public static String[] c(String paramString1, String paramString2, int paramInt)
  {
    return a(paramString1, paramString2, paramInt, true);
  }

  public static int d(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return c(paramCharSequence1, paramCharSequence2, 0);
  }

  public static int d(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    return a(paramCharSequence1, paramCharSequence2, paramInt, true);
  }

  public static String d(String paramString)
  {
    return a(paramString, null);
  }

  public static String d(String paramString, char paramChar)
  {
    if (paramString == null)
      return null;
    String[] arrayOfString = a(paramString, paramChar);
    c.e(arrayOfString);
    return a(arrayOfString, paramChar);
  }

  public static String d(String paramString, int paramInt)
  {
    int i = 0;
    if (paramString == null)
      paramString = null;
    int j;
    do
    {
      return paramString;
      if (paramInt <= 0)
        return "";
      j = paramString.length();
    }
    while ((paramInt == 1) || (j == 0));
    if ((j == 1) && (paramInt <= 8192))
      return a(paramString.charAt(0), paramInt);
    int k = j * paramInt;
    StringBuilder localStringBuilder;
    switch (j)
    {
    default:
      localStringBuilder = new StringBuilder(k);
    case 1:
    case 2:
    }
    while (i < paramInt)
    {
      localStringBuilder.append(paramString);
      i++;
      continue;
      return a(paramString.charAt(0), paramInt);
      int m = paramString.charAt(0);
      int n = paramString.charAt(1);
      char[] arrayOfChar = new char[k];
      for (int i1 = -2 + paramInt * 2; i1 >= 0; i1 = -1 + (i1 - 1))
      {
        arrayOfChar[i1] = m;
        arrayOfChar[(i1 + 1)] = n;
      }
      return new String(arrayOfChar);
    }
    return localStringBuilder.toString();
  }

  public static String d(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (paramString2 == null));
    int i;
    do
    {
      return paramString1;
      if (paramString2.length() == 0)
        return "";
      i = paramString1.indexOf(paramString2);
    }
    while (i == -1);
    return paramString1.substring(0, i);
  }

  public static String d(String paramString1, String paramString2, String paramString3)
  {
    return a(paramString1, paramString2, paramString3, -1);
  }

  public static boolean d(CharSequence paramCharSequence)
  {
    return !c(paramCharSequence);
  }

  public static boolean d(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    int i = 1;
    if ((paramArrayOfChar == null) || (paramCharSequence == null))
      i = 0;
    do
    {
      do
        return i;
      while (paramCharSequence.length() == 0);
      if (paramArrayOfChar.length == 0)
        return false;
    }
    while (c(paramCharSequence, paramArrayOfChar) == -1);
    return false;
  }

  public static boolean d(CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence)
  {
    if ((a(paramCharSequence)) || (c.f(paramArrayOfCharSequence)));
    while (true)
    {
      return false;
      int i = paramArrayOfCharSequence.length;
      for (int j = 0; j < i; j++)
        if (r(paramCharSequence, paramArrayOfCharSequence[j]))
          return true;
    }
  }

  public static String[] d(String paramString1, String paramString2, int paramInt)
  {
    return b(paramString1, paramString2, paramInt, true);
  }

  public static int e(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      return -1;
    return h.b(paramCharSequence1, paramCharSequence2, paramCharSequence1.length());
  }

  public static int e(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      return -1;
    return h.b(paramCharSequence1, paramCharSequence2, paramInt);
  }

  public static String e(String paramString)
  {
    if (paramString == null);
    String str;
    do
    {
      return null;
      str = a(paramString, null);
    }
    while (str.length() == 0);
    return str;
  }

  public static String e(String paramString, int paramInt)
  {
    return a(paramString, paramInt, ' ');
  }

  public static String e(String paramString1, String paramString2)
  {
    if (a(paramString1))
      return paramString1;
    if (paramString2 == null)
      return "";
    int i = paramString1.indexOf(paramString2);
    if (i == -1)
      return "";
    return paramString1.substring(i + paramString2.length());
  }

  public static String e(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString2 == null))
      return d(paramString1, paramInt);
    return o(d(paramString1 + paramString2, paramInt), paramString2);
  }

  public static String e(String paramString1, String paramString2, String paramString3)
  {
    int i = 0;
    if ((a(paramString1)) || (a(paramString2)));
    StringBuilder localStringBuilder;
    do
    {
      return paramString1;
      if (paramString3 == null)
        paramString3 = "";
      int j = paramString3.length();
      int k = paramString1.length();
      localStringBuilder = new StringBuilder(k);
      int m = 0;
      if (m >= k)
        continue;
      char c1 = paramString1.charAt(m);
      int n = paramString2.indexOf(c1);
      if (n >= 0)
      {
        i = 1;
        if (n < j)
          localStringBuilder.append(paramString3.charAt(n));
      }
      while (true)
      {
        m++;
        break;
        localStringBuilder.append(c1);
      }
    }
    while (i == 0);
    return localStringBuilder.toString();
  }

  public static boolean e(CharSequence paramCharSequence)
  {
    if (a(paramCharSequence));
    while (true)
    {
      return false;
      int i = paramCharSequence.length();
      for (int j = 0; j < i; j++)
        if (Character.isWhitespace(paramCharSequence.charAt(j)))
          return true;
    }
  }

  public static boolean e(CharSequence paramCharSequence, char[] paramArrayOfChar)
  {
    int i;
    if ((paramCharSequence == null) || (paramArrayOfChar == null))
    {
      i = 1;
      return i;
    }
    int j = paramCharSequence.length();
    int k = j - 1;
    int m = paramArrayOfChar.length;
    int n = m - 1;
    label137: for (int i1 = 0; ; i1++)
    {
      if (i1 >= j)
        break label143;
      char c1 = paramCharSequence.charAt(i1);
      for (int i2 = 0; ; i2++)
      {
        if (i2 >= m)
          break label137;
        if (paramArrayOfChar[i2] != c1)
          continue;
        boolean bool = Character.isHighSurrogate(c1);
        i = 0;
        if (!bool)
          break;
        i = 0;
        if (i2 == n)
          break;
        if (i1 >= k)
          continue;
        int i3 = paramArrayOfChar[(i2 + 1)];
        int i4 = paramCharSequence.charAt(i1 + 1);
        i = 0;
        if (i3 == i4)
          break;
      }
    }
    label143: return true;
  }

  public static int f(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return 0;
    return paramCharSequence.length();
  }

  public static int f(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      return -1;
    return f(paramCharSequence1, paramCharSequence2, paramCharSequence1.length());
  }

  public static int f(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
    {
      i = -1;
      return i;
    }
    if (paramInt > paramCharSequence1.length() - paramCharSequence2.length());
    for (int i = paramCharSequence1.length() - paramCharSequence2.length(); ; i = paramInt)
    {
      if (i < 0)
        return -1;
      if (paramCharSequence2.length() == 0)
        break;
      while (true)
      {
        if (i < 0)
          break label85;
        if (h.a(paramCharSequence1, true, i, paramCharSequence2, 0, paramCharSequence2.length()))
          break;
        i--;
      }
      label85: return -1;
    }
  }

  public static String f(String paramString)
  {
    if (paramString == null)
      return "";
    return a(paramString, null);
  }

  public static String f(String paramString, int paramInt)
  {
    return b(paramString, paramInt, ' ');
  }

  public static String f(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (a(paramString2)));
    int i;
    do
    {
      return paramString1;
      i = paramString1.lastIndexOf(paramString2);
    }
    while (i == -1);
    return paramString1.substring(0, i);
  }

  public static String f(String paramString1, String paramString2, int paramInt)
  {
    if ((a(paramString1)) || (a(paramString2)));
    do
      return paramString1;
    while ((paramInt >= paramString1.length()) || (paramInt < 2 + paramString2.length()));
    int i = paramInt - paramString2.length();
    int j = i / 2 + i % 2;
    int k = paramString1.length() - i / 2;
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    localStringBuilder.append(paramString1.substring(0, j));
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1.substring(k));
    return localStringBuilder.toString();
  }

  public static int g(CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      throw new IllegalArgumentException("Strings must not be null");
    if (paramInt < 0)
      throw new IllegalArgumentException("Threshold must not be negative");
    int i = paramCharSequence1.length();
    int j = paramCharSequence2.length();
    if (i == 0)
    {
      if (j <= paramInt)
        return j;
      return -1;
    }
    if (j == 0)
    {
      if (i <= paramInt)
        return i;
      return -1;
    }
    if (i > j)
    {
      int i4 = paramCharSequence1.length();
      i = j;
      j = i4;
    }
    while (true)
    {
      Object localObject1 = new int[i + 1];
      int[] arrayOfInt = new int[i + 1];
      int k = 1 + Math.min(i, paramInt);
      for (int m = 0; m < k; m++)
        localObject1[m] = m;
      Arrays.fill(localObject1, k, localObject1.length, 2147483647);
      Arrays.fill(arrayOfInt, 2147483647);
      Object localObject2 = arrayOfInt;
      int n = 1;
      while (n <= j)
      {
        int i1 = paramCharSequence1.charAt(n - 1);
        localObject2[0] = n;
        int i2 = Math.max(1, n - paramInt);
        int i3 = Math.min(i, n + paramInt);
        if (i2 > i3)
          return -1;
        if (i2 > 1)
          localObject2[(i2 - 1)] = 2147483647;
        if (i2 <= i3)
        {
          if (paramCharSequence2.charAt(i2 - 1) == i1)
            localObject2[i2] = localObject1[(i2 - 1)];
          while (true)
          {
            i2++;
            break;
            localObject2[i2] = (1 + Math.min(Math.min(localObject2[(i2 - 1)], localObject1[i2]), localObject1[(i2 - 1)]));
          }
        }
        n++;
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      if (localObject1[i] <= paramInt)
        return localObject1[i];
      return -1;
      CharSequence localCharSequence = paramCharSequence2;
      paramCharSequence2 = paramCharSequence1;
      paramCharSequence1 = localCharSequence;
    }
  }

  public static String g(String paramString)
  {
    if (paramString == null)
      return null;
    try
    {
      if (a.a() != null)
        return q(paramString);
      if (a.b() != null)
        return r(paramString);
      throw new UnsupportedOperationException("The stripAccents(CharSequence) method requires at least Java6, but got: " + a.c() + "; or a Sun JVM: " + a.d());
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new RuntimeException("IllegalArgumentException occurred", localIllegalArgumentException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("IllegalAccessException occurred", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException("InvocationTargetException occurred", localInvocationTargetException);
    }
    catch (SecurityException localSecurityException)
    {
    }
    throw new RuntimeException("SecurityException occurred", localSecurityException);
  }

  public static String g(String paramString, int paramInt)
  {
    return c(paramString, paramInt, ' ');
  }

  public static String g(String paramString1, String paramString2)
  {
    if (a(paramString1))
      return paramString1;
    if (a(paramString2))
      return "";
    int i = paramString1.lastIndexOf(paramString2);
    if ((i == -1) || (i == paramString1.length() - paramString2.length()))
      return "";
    return paramString1.substring(i + paramString2.length());
  }

  public static boolean g(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label48;
      if (!Character.isLetter(paramCharSequence.charAt(j)))
        break;
    }
    label48: return true;
  }

  public static boolean g(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null));
    do
      return false;
    while (h.a(paramCharSequence1, paramCharSequence2, 0) < 0);
    return true;
  }

  public static String h(String paramString, int paramInt)
  {
    return c(paramString, 0, paramInt);
  }

  public static String h(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, paramString2);
  }

  public static boolean h(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label51;
      if ((!Character.isLetter(paramCharSequence.charAt(j))) && (paramCharSequence.charAt(j) != ' '))
        break;
    }
    label51: return true;
  }

  public static boolean h(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null));
    while (true)
    {
      return false;
      int i = paramCharSequence2.length();
      int j = paramCharSequence1.length() - i;
      for (int k = 0; k <= j; k++)
        if (h.a(paramCharSequence1, true, k, paramCharSequence2, 0, i))
          return true;
    }
  }

  public static String[] h(String paramString)
  {
    return a(paramString, null, -1);
  }

  public static boolean i(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label48;
      if (!Character.isLetterOrDigit(paramCharSequence.charAt(j)))
        break;
    }
    label48: return true;
  }

  public static boolean i(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence2 == null)
      return false;
    return b(paramCharSequence1, h.a(paramCharSequence2));
  }

  public static String[] i(String paramString)
  {
    return b(paramString, null, -1, true);
  }

  public static String[] i(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, -1, false);
  }

  public static int j(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i;
    if ((a(paramCharSequence1)) || (a(paramCharSequence2)))
      i = -1;
    while (true)
    {
      return i;
      int j = paramCharSequence1.length();
      i = 0;
      if (i >= j)
        break;
      char c1 = paramCharSequence1.charAt(i);
      int k;
      if (h.a(paramCharSequence2, c1, 0) >= 0)
      {
        k = 1;
        label54: if ((i + 1 >= j) || (!Character.isHighSurrogate(c1)))
          break label107;
        int m = paramCharSequence1.charAt(i + 1);
        if ((k != 0) && (h.a(paramCharSequence2, m, 0) < 0))
          continue;
      }
      label107: 
      do
      {
        i++;
        break;
        k = 0;
        break label54;
      }
      while (k != 0);
      return i;
    }
    return -1;
  }

  public static boolean j(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label51;
      if ((!Character.isLetterOrDigit(paramCharSequence.charAt(j))) && (paramCharSequence.charAt(j) != ' '))
        break;
    }
    label51: return true;
  }

  public static String[] j(String paramString)
  {
    return a(paramString, false);
  }

  public static String[] j(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, -1, false);
  }

  public static int k(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i = 0;
    if ((a(paramCharSequence1)) || (a(paramCharSequence2)))
    {
      j = 0;
      return j;
    }
    int j = 0;
    while (true)
    {
      int k = h.a(paramCharSequence1, paramCharSequence2, i);
      if (k == -1)
        break;
      j++;
      i = k + paramCharSequence2.length();
    }
  }

  public static boolean k(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label39;
      if (!k.f(paramCharSequence.charAt(j)))
        break;
    }
    label39: return true;
  }

  public static String[] k(String paramString)
  {
    return a(paramString, true);
  }

  public static String[] k(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, -1, true);
  }

  public static <T extends CharSequence> T l(T paramT1, T paramT2)
  {
    if (c(paramT1))
      return paramT2;
    return paramT1;
  }

  public static String l(String paramString)
  {
    if (a(paramString))
      return paramString;
    int i = paramString.length();
    char[] arrayOfChar = new char[i];
    int j = 0;
    int k = 0;
    label23: int m;
    if (j < i)
    {
      if (Character.isWhitespace(paramString.charAt(j)))
        break label82;
      m = k + 1;
      arrayOfChar[k] = paramString.charAt(j);
    }
    while (true)
    {
      j++;
      k = m;
      break label23;
      if (k == i)
        break;
      return new String(arrayOfChar, 0, k);
      label82: m = k;
    }
  }

  public static boolean l(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() == 0))
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label48;
      if (!Character.isDigit(paramCharSequence.charAt(j)))
        break;
    }
    label48: return true;
  }

  public static String[] l(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, -1, true);
  }

  public static <T extends CharSequence> T m(T paramT1, T paramT2)
  {
    if (a(paramT1))
      return paramT2;
    return paramT1;
  }

  public static String m(String paramString)
  {
    if (a(paramString));
    while (true)
    {
      return paramString;
      if (paramString.length() != 1)
        break;
      int k = paramString.charAt(0);
      if ((k == 13) || (k == 10))
        return "";
    }
    int i = -1 + paramString.length();
    int j = paramString.charAt(i);
    if (j == 10)
      if (paramString.charAt(i - 1) == '\r')
        i--;
    while (true)
    {
      return paramString.substring(0, i);
      if (j == 13)
        continue;
      i++;
    }
  }

  public static String m(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (a(paramString2)));
    do
      return paramString1;
    while (!paramString1.startsWith(paramString2));
    return paramString1.substring(paramString2.length());
  }

  public static boolean m(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label51;
      if ((!Character.isDigit(paramCharSequence.charAt(j))) && (paramCharSequence.charAt(j) != ' '))
        break;
    }
    label51: return true;
  }

  public static int n(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    int i;
    if (paramCharSequence1 == paramCharSequence2)
      i = -1;
    do
    {
      do
      {
        return i;
        i = 0;
      }
      while (paramCharSequence1 == null);
      i = 0;
    }
    while (paramCharSequence2 == null);
    while (true)
    {
      if ((i >= paramCharSequence1.length()) || (i >= paramCharSequence2.length()) || (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(i)))
      {
        if ((i < paramCharSequence2.length()) || (i < paramCharSequence1.length()))
          break;
        return -1;
      }
      i++;
    }
  }

  public static String n(String paramString)
  {
    String str;
    if (paramString == null)
      str = null;
    int j;
    do
    {
      return str;
      int i = paramString.length();
      if (i < 2)
        return "";
      j = i - 1;
      str = paramString.substring(0, j);
    }
    while ((paramString.charAt(j) != '\n') || (str.charAt(j - 1) != '\r'));
    return str.substring(0, j - 1);
  }

  public static String n(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (a(paramString2)));
    do
      return paramString1;
    while (!q(paramString1, paramString2));
    return paramString1.substring(paramString2.length());
  }

  public static boolean n(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label39;
      if (!Character.isWhitespace(paramCharSequence.charAt(j)))
        break;
    }
    label39: return true;
  }

  public static int o(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramCharSequence1 == null) || (paramCharSequence2 == null))
      throw new IllegalArgumentException("Strings must not be null");
    int i = paramCharSequence1.length();
    int j = paramCharSequence2.length();
    if (i == 0)
      return j;
    if (j == 0)
      return i;
    int m;
    if (i > j)
      m = paramCharSequence1.length();
    while (true)
    {
      Object localObject1 = new int[j + 1];
      int[] arrayOfInt = new int[j + 1];
      for (int n = 0; n <= j; n++)
        localObject1[n] = n;
      int i1 = 1;
      Object localObject3;
      for (Object localObject2 = arrayOfInt; i1 <= m; localObject2 = localObject3)
      {
        int i2 = paramCharSequence1.charAt(i1 - 1);
        localObject2[0] = i1;
        int i3 = 1;
        if (i3 <= j)
        {
          if (paramCharSequence2.charAt(i3 - 1) == i2);
          for (int i4 = 0; ; i4 = 1)
          {
            localObject2[i3] = Math.min(Math.min(1 + localObject2[(i3 - 1)], 1 + localObject1[i3]), i4 + localObject1[(i3 - 1)]);
            i3++;
            break;
          }
        }
        i1++;
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      return localObject1[j];
      int k = j;
      j = i;
      m = k;
      CharSequence localCharSequence = paramCharSequence2;
      paramCharSequence2 = paramCharSequence1;
      paramCharSequence1 = localCharSequence;
    }
  }

  public static String o(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.toUpperCase();
  }

  public static String o(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (a(paramString2)));
    do
      return paramString1;
    while (!paramString1.endsWith(paramString2));
    return paramString1.substring(0, paramString1.length() - paramString2.length());
  }

  public static boolean o(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (a(paramCharSequence)))
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label46;
      if (!Character.isLowerCase(paramCharSequence.charAt(j)))
        break;
    }
    label46: return true;
  }

  public static String p(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.toLowerCase();
  }

  public static String p(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (a(paramString2)));
    do
      return paramString1;
    while (!s(paramString1, paramString2));
    return paramString1.substring(0, paramString1.length() - paramString2.length());
  }

  public static boolean p(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (a(paramCharSequence)))
      return false;
    int i = paramCharSequence.length();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label46;
      if (!Character.isUpperCase(paramCharSequence.charAt(j)))
        break;
    }
    label46: return true;
  }

  public static boolean p(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return a(paramCharSequence1, paramCharSequence2, false);
  }

  private static String q(CharSequence paramCharSequence)
    throws IllegalAccessException, InvocationTargetException
  {
    if ((a.a() == null) || (a.e() == null))
      throw new IllegalStateException("java.text.Normalizer is not available", a.c());
    Method localMethod = a.a();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramCharSequence;
    arrayOfObject[1] = a.e();
    String str = (String)localMethod.invoke(null, arrayOfObject);
    return a.f().matcher(str).replaceAll("");
  }

  public static String q(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = paramString.length();
      if (i != 0);
    }
    else
    {
      return paramString;
    }
    return i + Character.toTitleCase(paramString.charAt(0)) + paramString.substring(1);
  }

  public static String q(String paramString1, String paramString2)
  {
    if ((a(paramString1)) || (a(paramString2)))
      return paramString1;
    return a(paramString1, paramString2, "", -1);
  }

  public static boolean q(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return a(paramCharSequence1, paramCharSequence2, true);
  }

  private static String r(CharSequence paramCharSequence)
    throws IllegalAccessException, InvocationTargetException
  {
    if (a.b() == null)
      throw new IllegalStateException("sun.text.Normalizer is not available", a.d());
    Method localMethod = a.b();
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = paramCharSequence;
    arrayOfObject[1] = Boolean.FALSE;
    arrayOfObject[2] = Integer.valueOf(0);
    String str = (String)localMethod.invoke(null, arrayOfObject);
    return a.g().matcher(str).replaceAll("");
  }

  public static String r(String paramString)
  {
    int i;
    if (paramString != null)
    {
      i = paramString.length();
      if (i != 0);
    }
    else
    {
      return paramString;
    }
    return i + Character.toLowerCase(paramString.charAt(0)) + paramString.substring(1);
  }

  @Deprecated
  public static String r(String paramString1, String paramString2)
  {
    return o(paramString1, paramString2);
  }

  public static boolean r(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return b(paramCharSequence1, paramCharSequence2, false);
  }

  public static String s(String paramString)
  {
    if (a(paramString))
      return paramString;
    char[] arrayOfChar = paramString.toCharArray();
    int i = 0;
    if (i < arrayOfChar.length)
    {
      char c1 = arrayOfChar[i];
      if (Character.isUpperCase(c1))
        arrayOfChar[i] = Character.toLowerCase(c1);
      while (true)
      {
        i++;
        break;
        if (Character.isTitleCase(c1))
        {
          arrayOfChar[i] = Character.toLowerCase(c1);
          continue;
        }
        if (!Character.isLowerCase(c1))
          continue;
        arrayOfChar[i] = Character.toUpperCase(c1);
      }
    }
    return new String(arrayOfChar);
  }

  public static String s(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2;
    return paramString1;
  }

  public static boolean s(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return b(paramCharSequence1, paramCharSequence2, true);
  }

  public static String t(String paramString)
  {
    if (paramString == null)
      paramString = "";
    return paramString;
  }

  public static String t(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2;
    if (paramString2 == null)
      return paramString1;
    int i = n(paramString1, paramString2);
    if (i == -1)
      return "";
    return paramString2.substring(i);
  }

  public static String u(String paramString)
  {
    if (paramString == null)
      return null;
    return new StringBuilder(paramString).reverse().toString();
  }

  public static String v(String paramString)
  {
    if (paramString == null)
      return null;
    return d.matcher(a(paramString)).replaceAll(" ");
  }

  private static class a
  {
    private static final Throwable a;
    private static final Method b;
    private static final Pattern c;
    private static final Throwable d;
    private static final Method e;
    private static final Object f;
    private static final Pattern g;

    // ERROR //
    static
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_0
      //   2: ldc 21
      //   4: invokestatic 27	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
      //   7: putstatic 29	org/a/a/a/v$a:c	Ljava/util/regex/Pattern;
      //   10: getstatic 29	org/a/a/a/v$a:c	Ljava/util/regex/Pattern;
      //   13: putstatic 31	org/a/a/a/v$a:g	Ljava/util/regex/Pattern;
      //   16: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   19: invokevirtual 41	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
      //   22: ldc 43
      //   24: invokevirtual 49	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
      //   27: astore 11
      //   29: aload 11
      //   31: ldc 51
      //   33: invokevirtual 57	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
      //   36: aconst_null
      //   37: invokevirtual 63	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   40: astore 12
      //   42: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   45: invokevirtual 41	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
      //   48: ldc 65
      //   50: invokevirtual 49	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
      //   53: ldc 67
      //   55: iconst_2
      //   56: anewarray 53	java/lang/Class
      //   59: dup
      //   60: iconst_0
      //   61: ldc 69
      //   63: aastore
      //   64: dup
      //   65: iconst_1
      //   66: aload 11
      //   68: aastore
      //   69: invokevirtual 73	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   72: astore 14
      //   74: aload 14
      //   76: astore 7
      //   78: aload 12
      //   80: astore 4
      //   82: aconst_null
      //   83: astore 5
      //   85: aconst_null
      //   86: astore 6
      //   88: aload 5
      //   90: putstatic 75	org/a/a/a/v$a:d	Ljava/lang/Throwable;
      //   93: aload 4
      //   95: putstatic 77	org/a/a/a/v$a:f	Ljava/lang/Object;
      //   98: aload 7
      //   100: putstatic 79	org/a/a/a/v$a:e	Ljava/lang/reflect/Method;
      //   103: aload_0
      //   104: putstatic 81	org/a/a/a/v$a:a	Ljava/lang/Throwable;
      //   107: aload 6
      //   109: putstatic 83	org/a/a/a/v$a:b	Ljava/lang/reflect/Method;
      //   112: return
      //   113: astore_1
      //   114: aconst_null
      //   115: astore_2
      //   116: invokestatic 37	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   119: invokevirtual 41	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
      //   122: ldc 85
      //   124: invokevirtual 49	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
      //   127: astore 8
      //   129: iconst_3
      //   130: anewarray 53	java/lang/Class
      //   133: astore 9
      //   135: aload 9
      //   137: iconst_0
      //   138: ldc 87
      //   140: aastore
      //   141: aload 9
      //   143: iconst_1
      //   144: getstatic 93	java/lang/Boolean:TYPE	Ljava/lang/Class;
      //   147: aastore
      //   148: aload 9
      //   150: iconst_2
      //   151: getstatic 96	java/lang/Integer:TYPE	Ljava/lang/Class;
      //   154: aastore
      //   155: aload 8
      //   157: ldc 98
      //   159: aload 9
      //   161: invokevirtual 73	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
      //   164: astore 10
      //   166: aload_2
      //   167: astore 4
      //   169: aload_1
      //   170: astore 5
      //   172: aload 10
      //   174: astore 6
      //   176: aconst_null
      //   177: astore_0
      //   178: aconst_null
      //   179: astore 7
      //   181: goto -93 -> 88
      //   184: astore_3
      //   185: aload_2
      //   186: astore 4
      //   188: aload_3
      //   189: astore_0
      //   190: aload_1
      //   191: astore 5
      //   193: aconst_null
      //   194: astore 6
      //   196: aconst_null
      //   197: astore 7
      //   199: goto -111 -> 88
      //   202: astore 13
      //   204: aload 12
      //   206: astore_2
      //   207: aload 13
      //   209: astore_1
      //   210: goto -94 -> 116
      //
      // Exception table:
      //   from	to	target	type
      //   16	42	113	java/lang/Exception
      //   116	166	184	java/lang/Exception
      //   42	74	202	java/lang/Exception
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.v
 * JD-Core Version:    0.6.0
 */