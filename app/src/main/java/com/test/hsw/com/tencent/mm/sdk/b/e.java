package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class e
{
  private static final long[] G = { 300L, 200L, 300L, 200L };
  private static final TimeZone GMT;
  private static final long[] H = { 300L, 50L, 300L, 50L };
  private static final char[] I;
  private static final String[] J;

  static
  {
    GMT = TimeZone.getTimeZone("GMT");
    I = new char[] { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
    J = new String[] { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
  }

  public static boolean j(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.b.e
 * JD-Core Version:    0.6.0
 */