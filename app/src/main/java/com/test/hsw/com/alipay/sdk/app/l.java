package com.alipay.sdk.app;

public final class l
{
  static String a;

  public static String a()
  {
    m localm = m.a(m.c.a());
    return a(localm.a(), localm.b(), "");
  }

  public static String a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resultStatus={").append(paramInt).append("};memo={").append(paramString1).append("};result={").append(paramString2).append("}");
    return localStringBuilder.toString();
  }

  private static void a(String paramString)
  {
    a = paramString;
  }

  public static String b()
  {
    m localm = m.a(m.e.a());
    return a(localm.a(), localm.b(), "");
  }

  private static String c()
  {
    return a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.sdk.app.l
 * JD-Core Version:    0.6.0
 */