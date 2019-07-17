package org.a.a.a;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;

public class f
{
  public static final String a = "ISO-8859-1";
  public static final String b = "US-ASCII";
  public static final String c = "UTF-16";
  public static final String d = "UTF-16BE";
  public static final String e = "UTF-16LE";
  public static final String f = "UTF-8";

  public static boolean a(String paramString)
  {
    if (paramString == null)
      return false;
    try
    {
      boolean bool = Charset.isSupported(paramString);
      return bool;
    }
    catch (IllegalCharsetNameException localIllegalCharsetNameException)
    {
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.f
 * JD-Core Version:    0.6.0
 */