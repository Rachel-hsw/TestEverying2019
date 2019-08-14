package org.a.a.a;

public class k
{
  public static final char a = '\n';
  public static final char b = '\r';
  private static final String[] c = new String[''];

  static
  {
    int j;
    for (int i = 0; i < c.length; j = (char)(i + 1))
      c[i] = String.valueOf(i);
  }

  public static char a(Character paramCharacter)
  {
    if (paramCharacter == null)
      throw new IllegalArgumentException("The Character must not be null");
    return paramCharacter.charValue();
  }

  public static char a(Character paramCharacter, char paramChar)
  {
    if (paramCharacter == null)
      return paramChar;
    return paramCharacter.charValue();
  }

  public static char a(String paramString, char paramChar)
  {
    if (v.a(paramString))
      return paramChar;
    return paramString.charAt(0);
  }

  public static int a(char paramChar, int paramInt)
  {
    if (!k(paramChar))
      return paramInt;
    return paramChar - '0';
  }

  public static int a(Character paramCharacter, int paramInt)
  {
    if (paramCharacter == null)
      return paramInt;
    return a(paramCharacter.charValue(), paramInt);
  }

  @Deprecated
  public static Character a(char paramChar)
  {
    return Character.valueOf(paramChar);
  }

  public static Character a(String paramString)
  {
    if (v.a(paramString))
      return null;
    return Character.valueOf(paramString.charAt(0));
  }

  public static char b(String paramString)
  {
    if (v.a(paramString))
      throw new IllegalArgumentException("The String must not be empty");
    return paramString.charAt(0);
  }

  public static int b(char paramChar)
  {
    if (!k(paramChar))
      throw new IllegalArgumentException("The character " + paramChar + " is not in the range '0' - '9'");
    return paramChar - '0';
  }

  public static int b(Character paramCharacter)
  {
    if (paramCharacter == null)
      throw new IllegalArgumentException("The character must not be null");
    return b(paramCharacter.charValue());
  }

  public static String c(char paramChar)
  {
    if (paramChar < '')
      return c[paramChar];
    return new String(new char[] { paramChar });
  }

  public static String c(Character paramCharacter)
  {
    if (paramCharacter == null)
      return null;
    return c(paramCharacter.charValue());
  }

  public static String d(char paramChar)
  {
    if (paramChar < '\020')
      return "\\u000" + Integer.toHexString(paramChar);
    if (paramChar < 'Ā')
      return "\\u00" + Integer.toHexString(paramChar);
    if (paramChar < 'က')
      return "\\u0" + Integer.toHexString(paramChar);
    return "\\u" + Integer.toHexString(paramChar);
  }

  public static String d(Character paramCharacter)
  {
    if (paramCharacter == null)
      return null;
    return d(paramCharacter.charValue());
  }

  public static boolean e(char paramChar)
  {
    return paramChar < '';
  }

  public static boolean f(char paramChar)
  {
    return (paramChar >= ' ') && (paramChar < '');
  }

  public static boolean g(char paramChar)
  {
    return (paramChar < ' ') || (paramChar == '');
  }

  public static boolean h(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z'));
  }

  public static boolean i(char paramChar)
  {
    return (paramChar >= 'A') && (paramChar <= 'Z');
  }

  public static boolean j(char paramChar)
  {
    return (paramChar >= 'a') && (paramChar <= 'z');
  }

  public static boolean k(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }

  public static boolean l(char paramChar)
  {
    return ((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z')) || ((paramChar >= '0') && (paramChar <= '9'));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.k
 * JD-Core Version:    0.6.0
 */