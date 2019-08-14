package com.umeng.socialize.bean;

public enum c
{
  static
  {
    c[] arrayOfc = new c[2];
    arrayOfc[0] = a;
    arrayOfc[1] = b;
    c = arrayOfc;
  }

  public static c a(String paramString)
  {
    for (c localc : values())
      if (localc.toString().equals(paramString))
        return localc;
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.c
 * JD-Core Version:    0.6.0
 */