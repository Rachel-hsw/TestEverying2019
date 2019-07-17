package org.a.a.a;

public class e
{
  public static int a(Boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramBoolean == null)
      return paramInt3;
    if (paramBoolean.booleanValue());
    while (true)
    {
      return paramInt1;
      paramInt1 = paramInt2;
    }
  }

  public static int a(boolean paramBoolean)
  {
    if (paramBoolean)
      return 1;
    return 0;
  }

  public static int a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
      return paramInt1;
    return paramInt2;
  }

  public static Boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 == paramInt2)
      return Boolean.TRUE;
    if (paramInt1 == paramInt3)
      return Boolean.FALSE;
    if (paramInt1 == paramInt4)
      return null;
    throw new IllegalArgumentException("The Integer did not match any specified value");
  }

  public static Boolean a(Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return null;
    if (paramBoolean.booleanValue())
      return Boolean.FALSE;
    return Boolean.TRUE;
  }

  public static Boolean a(Integer paramInteger)
  {
    if (paramInteger == null)
      return null;
    if (paramInteger.intValue() == 0)
      return Boolean.FALSE;
    return Boolean.TRUE;
  }

  public static Boolean a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4)
  {
    if (paramInteger1 == null)
    {
      Boolean localBoolean;
      if (paramInteger2 == null)
        localBoolean = Boolean.TRUE;
      do
      {
        return localBoolean;
        if (paramInteger3 == null)
          return Boolean.FALSE;
        localBoolean = null;
      }
      while (paramInteger4 == null);
    }
    do
    {
      throw new IllegalArgumentException("The Integer did not match any specified value");
      if (paramInteger1.equals(paramInteger2))
        return Boolean.TRUE;
      if (paramInteger1.equals(paramInteger3))
        return Boolean.FALSE;
    }
    while (!paramInteger1.equals(paramInteger4));
    return null;
  }

  public static Boolean a(String paramString)
  {
    if (paramString == "true")
      return Boolean.TRUE;
    if (paramString == null)
      return null;
    switch (paramString.length())
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    int i;
    int j;
    int k;
    int m;
    int n;
    do
    {
      int i1;
      int i2;
      int i3;
      int i4;
      do
      {
        int i5;
        int i6;
        int i7;
        do
        {
          int i8;
          int i9;
          do
          {
            int i10;
            do
            {
              return null;
              i10 = paramString.charAt(0);
              if ((i10 == 121) || (i10 == 89) || (i10 == 116) || (i10 == 84))
                return Boolean.TRUE;
            }
            while ((i10 != 110) && (i10 != 78) && (i10 != 102) && (i10 != 70));
            return Boolean.FALSE;
            i8 = paramString.charAt(0);
            i9 = paramString.charAt(1);
            if (((i8 == 111) || (i8 == 79)) && ((i9 == 110) || (i9 == 78)))
              return Boolean.TRUE;
          }
          while (((i8 != 110) && (i8 != 78)) || ((i9 != 111) && (i9 != 79)));
          return Boolean.FALSE;
          i5 = paramString.charAt(0);
          i6 = paramString.charAt(1);
          i7 = paramString.charAt(2);
          if (((i5 == 121) || (i5 == 89)) && ((i6 == 101) || (i6 == 69)) && ((i7 == 115) || (i7 == 83)))
            return Boolean.TRUE;
        }
        while (((i5 != 111) && (i5 != 79)) || ((i6 != 102) && (i6 != 70)) || ((i7 != 102) && (i7 != 70)));
        return Boolean.FALSE;
        i1 = paramString.charAt(0);
        i2 = paramString.charAt(1);
        i3 = paramString.charAt(2);
        i4 = paramString.charAt(3);
      }
      while (((i1 != 116) && (i1 != 84)) || ((i2 != 114) && (i2 != 82)) || ((i3 != 117) && (i3 != 85)) || ((i4 != 101) && (i4 != 69)));
      return Boolean.TRUE;
      i = paramString.charAt(0);
      j = paramString.charAt(1);
      k = paramString.charAt(2);
      m = paramString.charAt(3);
      n = paramString.charAt(4);
    }
    while (((i != 102) && (i != 70)) || ((j != 97) && (j != 65)) || ((k != 108) && (k != 76)) || ((m != 115) && (m != 83)) || ((n != 101) && (n != 69)));
    return Boolean.FALSE;
  }

  public static Boolean a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null)
    {
      Boolean localBoolean;
      if (paramString2 == null)
        localBoolean = Boolean.TRUE;
      do
      {
        return localBoolean;
        if (paramString3 == null)
          return Boolean.FALSE;
        localBoolean = null;
      }
      while (paramString4 == null);
    }
    do
    {
      throw new IllegalArgumentException("The String did not match any specified value");
      if (paramString1.equals(paramString2))
        return Boolean.TRUE;
      if (paramString1.equals(paramString3))
        return Boolean.FALSE;
    }
    while (!paramString1.equals(paramString4));
    return null;
  }

  public static Boolean a(Boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfBoolean.length == 0)
      throw new IllegalArgumentException("Array is empty");
    try
    {
      if (a(c.b(paramArrayOfBoolean)))
        return Boolean.TRUE;
      Boolean localBoolean = Boolean.FALSE;
      return localBoolean;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    throw new IllegalArgumentException("The array must not contain any null elements");
  }

  public static Integer a(Boolean paramBoolean, Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (paramBoolean == null)
      return paramInteger3;
    if (paramBoolean.booleanValue());
    while (true)
    {
      return paramInteger1;
      paramInteger1 = paramInteger2;
    }
  }

  public static Integer a(boolean paramBoolean, Integer paramInteger1, Integer paramInteger2)
  {
    if (paramBoolean)
      return paramInteger1;
    return paramInteger2;
  }

  public static String a(Boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean == null)
      return paramString3;
    if (paramBoolean.booleanValue());
    while (true)
    {
      return paramString1;
      paramString1 = paramString2;
    }
  }

  public static String a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
      return paramString1;
    return paramString2;
  }

  public static boolean a(int paramInt)
  {
    return paramInt != 0;
  }

  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == paramInt2)
      return true;
    if (paramInt1 == paramInt3)
      return false;
    throw new IllegalArgumentException("The Integer did not match either specified value");
  }

  public static boolean a(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null)
      return paramBoolean1;
    return paramBoolean.booleanValue();
  }

  public static boolean a(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3)
  {
    if (paramInteger1 == null)
      if (paramInteger2 != null);
    while (true)
    {
      return true;
      if (paramInteger3 != null)
        break;
      return false;
      if (paramInteger1.equals(paramInteger2))
        continue;
      if (!paramInteger1.equals(paramInteger3))
        break;
      return false;
    }
    throw new IllegalArgumentException("The Integer did not match either specified value");
  }

  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == paramString2);
    while (true)
    {
      return true;
      if (paramString1 == paramString3)
        return false;
      if (paramString1 == null)
        break;
      if (paramString1.equals(paramString2))
        continue;
      if (!paramString1.equals(paramString3))
        break;
      return false;
    }
    throw new IllegalArgumentException("The String did not match either specified value");
  }

  public static boolean a(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfBoolean.length == 0)
      throw new IllegalArgumentException("Array is empty");
    int i = paramArrayOfBoolean.length;
    for (int j = 0; j < i; j++)
      if (paramArrayOfBoolean[j] == 0)
        return false;
    return true;
  }

  public static Boolean b(int paramInt)
  {
    if (paramInt == 0)
      return Boolean.FALSE;
    return Boolean.TRUE;
  }

  public static Boolean b(Boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfBoolean.length == 0)
      throw new IllegalArgumentException("Array is empty");
    try
    {
      if (b(c.b(paramArrayOfBoolean)))
        return Boolean.TRUE;
      Boolean localBoolean = Boolean.FALSE;
      return localBoolean;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    throw new IllegalArgumentException("The array must not contain any null elements");
  }

  public static Integer b(boolean paramBoolean)
  {
    if (paramBoolean)
      return org.a.a.a.e.c.e;
    return org.a.a.a.e.c.d;
  }

  public static boolean b(Boolean paramBoolean)
  {
    return Boolean.TRUE.equals(paramBoolean);
  }

  public static boolean b(String paramString)
  {
    return a(paramString) == Boolean.TRUE;
  }

  public static boolean b(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfBoolean.length == 0)
      throw new IllegalArgumentException("Array is empty");
    int i = paramArrayOfBoolean.length;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (paramArrayOfBoolean[j] == 0)
          continue;
        k = 1;
      }
      return k;
    }
  }

  public static Boolean c(Boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfBoolean.length == 0)
      throw new IllegalArgumentException("Array is empty");
    try
    {
      if (c(c.b(paramArrayOfBoolean)))
        return Boolean.TRUE;
      Boolean localBoolean = Boolean.FALSE;
      return localBoolean;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    throw new IllegalArgumentException("The array must not contain any null elements");
  }

  public static String c(boolean paramBoolean)
  {
    return a(paramBoolean, "true", "false");
  }

  public static boolean c(Boolean paramBoolean)
  {
    return !b(paramBoolean);
  }

  public static boolean c(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
      throw new IllegalArgumentException("The Array must not be null");
    if (paramArrayOfBoolean.length == 0)
      throw new IllegalArgumentException("Array is empty");
    int i = paramArrayOfBoolean.length;
    int j = 0;
    int k = 0;
    int n;
    while (true)
      if (j < i)
      {
        if (paramArrayOfBoolean[j] != 0)
        {
          n = 0;
          if (k >= 1)
            break;
          k++;
        }
        else
        {
          j++;
          continue;
        }
      }
      else
        if (k != 1)
          break label79;
    label79: for (int m = 1; ; m = 0)
    {
      n = m;
      return n;
    }
  }

  public static String d(boolean paramBoolean)
  {
    return a(paramBoolean, "on", "off");
  }

  public static boolean d(Boolean paramBoolean)
  {
    return Boolean.FALSE.equals(paramBoolean);
  }

  public static String e(boolean paramBoolean)
  {
    return a(paramBoolean, "yes", "no");
  }

  public static boolean e(Boolean paramBoolean)
  {
    return !d(paramBoolean);
  }

  public static boolean f(Boolean paramBoolean)
  {
    return (paramBoolean != null) && (paramBoolean.booleanValue());
  }

  public static Integer g(Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return null;
    if (paramBoolean.booleanValue())
      return org.a.a.a.e.c.e;
    return org.a.a.a.e.c.d;
  }

  public static String h(Boolean paramBoolean)
  {
    return a(paramBoolean, "true", "false", null);
  }

  public static String i(Boolean paramBoolean)
  {
    return a(paramBoolean, "on", "off", null);
  }

  public static String j(Boolean paramBoolean)
  {
    return a(paramBoolean, "yes", "no", null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.e
 * JD-Core Version:    0.6.0
 */