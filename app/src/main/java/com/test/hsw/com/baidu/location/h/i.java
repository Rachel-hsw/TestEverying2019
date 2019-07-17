package com.baidu.location.h;

import java.util.List;

class i
{
  public static String jdField_try = null;
  private double a = 0.0D;
  private boolean jdField_do = false;
  private String jdField_for = "";
  private double jdField_if = 0.0D;
  private boolean jdField_int = false;
  public int jdField_new = 0;

  public i(List paramList, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_for = paramString3;
    a();
  }

  private void a()
  {
    int i = 0;
    String[] arrayOfString;
    if (a(this.jdField_for))
    {
      String str = this.jdField_for.substring(0, -3 + this.jdField_for.length());
      int j = 0;
      while (i < str.length())
      {
        if (str.charAt(i) == ',')
          j++;
        i++;
      }
      arrayOfString = str.split(",", j + 1);
      if (arrayOfString.length < 6)
        return;
      if ((arrayOfString[2].equals("")) || (arrayOfString[(-3 + arrayOfString.length)].equals("")) || (arrayOfString[(-2 + arrayOfString.length)].equals("")) || (arrayOfString[(-1 + arrayOfString.length)].equals("")));
    }
    try
    {
      this.a = Double.valueOf(arrayOfString[(-3 + arrayOfString.length)]).doubleValue();
      this.jdField_if = Double.valueOf(arrayOfString[(-2 + arrayOfString.length)]).doubleValue();
      label181: this.jdField_do = true;
      this.jdField_int = this.jdField_do;
      return;
    }
    catch (Exception localException)
    {
      break label181;
    }
  }

  private boolean a(String paramString)
  {
    int i = 0;
    if (paramString != null)
    {
      int j = paramString.length();
      i = 0;
      if (j > 8)
      {
        int k = 1;
        int m = 0;
        while (k < -3 + paramString.length())
        {
          m ^= paramString.charAt(k);
          k++;
        }
        boolean bool = Integer.toHexString(m).equalsIgnoreCase(paramString.substring(-2 + paramString.length(), paramString.length()));
        i = 0;
        if (bool)
          i = 1;
      }
    }
    return i;
  }

  public boolean jdField_do()
  {
    return this.jdField_int;
  }

  public double jdField_for()
  {
    return this.a;
  }

  public double jdField_if()
  {
    return this.jdField_if;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.h.i
 * JD-Core Version:    0.6.0
 */