package org.a.a.a;

import java.util.Random;

public class q
{
  private static final Random a = new Random();

  public static String a(int paramInt)
  {
    return a(paramInt, false, false);
  }

  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, null, a);
  }

  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar)
  {
    return a(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2, paramArrayOfChar, a);
  }

  public static String a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, char[] paramArrayOfChar, Random paramRandom)
  {
    if (paramInt1 == 0)
      return "";
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Requested random string length " + paramInt1 + " is less than 0.");
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramInt3 = 123;
      paramInt2 = 32;
      if ((!paramBoolean1) && (!paramBoolean2))
      {
        paramInt2 = 0;
        paramInt3 = 2147483647;
      }
    }
    char[] arrayOfChar = new char[paramInt1];
    int i = paramInt3 - paramInt2;
    int j = paramInt1 - 1;
    if (paramInt1 != 0)
    {
      if (paramArrayOfChar == null)
      {
        int k = (char)(paramInt2 + paramRandom.nextInt(i));
        label107: if (((!paramBoolean1) || (!Character.isLetter(k))) && ((!paramBoolean2) || (!Character.isDigit(k))) && ((paramBoolean1) || (paramBoolean2)))
          break label301;
        if ((k < 56320) || (k > 57343))
          break label216;
        if (j != 0)
          break label186;
        j++;
      }
      while (true)
      {
        paramInt1 = j;
        break;
        int m = paramArrayOfChar[(paramInt2 + paramRandom.nextInt(i))];
        break label107;
        label186: arrayOfChar[j] = m;
        j--;
        arrayOfChar[j] = (char)(55296 + paramRandom.nextInt(128));
        continue;
        label216: if ((m >= 55296) && (m <= 56191))
        {
          if (j == 0)
          {
            j++;
            continue;
          }
          arrayOfChar[j] = (char)(56320 + paramRandom.nextInt(128));
          j--;
          arrayOfChar[j] = m;
          continue;
        }
        if ((m >= 56192) && (m <= 56319))
        {
          j++;
          continue;
        }
        arrayOfChar[j] = m;
        continue;
        label301: j++;
      }
    }
    return new String(arrayOfChar);
  }

  public static String a(int paramInt, String paramString)
  {
    if (paramString == null)
      return a(paramInt, 0, 0, false, false, null, a);
    return a(paramInt, paramString.toCharArray());
  }

  public static String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramInt, 0, 0, paramBoolean1, paramBoolean2);
  }

  public static String a(int paramInt, char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
      return a(paramInt, 0, 0, false, false, null, a);
    return a(paramInt, 0, paramArrayOfChar.length, false, false, paramArrayOfChar, a);
  }

  public static String b(int paramInt)
  {
    return a(paramInt, 32, 127, false, false);
  }

  public static String c(int paramInt)
  {
    return a(paramInt, true, false);
  }

  public static String d(int paramInt)
  {
    return a(paramInt, true, true);
  }

  public static String e(int paramInt)
  {
    return a(paramInt, false, true);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.q
 * JD-Core Version:    0.6.0
 */