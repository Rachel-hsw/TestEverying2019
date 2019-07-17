package com.umeng.message.b;

import com.umeng.b.a.a;

public class eo
  implements en
{
  private static final String a = eo.class.getName();
  private static int b = 256;

  public boolean a(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim())))
      return false;
    if ((paramString != null) && (paramString.length() > b))
    {
      String str = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(b);
      a.b(str, String.format("The length of %s exceeds allowed max length %i", arrayOfObject));
      return false;
    }
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.eo
 * JD-Core Version:    0.6.0
 */