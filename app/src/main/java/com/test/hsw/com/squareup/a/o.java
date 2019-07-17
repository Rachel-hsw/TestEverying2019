package com.squareup.a;

import b.j;
import java.io.UnsupportedEncodingException;

public final class o
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      String str1 = j.a((paramString1 + ":" + paramString2).getBytes("ISO-8859-1")).b();
      String str2 = "Basic " + str1;
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new AssertionError();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.o
 * JD-Core Version:    0.6.0
 */