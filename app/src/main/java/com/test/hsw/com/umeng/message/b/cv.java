package com.umeng.message.b;

public final class cv
{
  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw new NullPointerException(paramString + " == null");
  }

  public static void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.cv
 * JD-Core Version:    0.6.0
 */