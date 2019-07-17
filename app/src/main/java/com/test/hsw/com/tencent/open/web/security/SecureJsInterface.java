package com.tencent.open.web.security;

import com.tencent.open.a.b;
import com.tencent.open.a.f;

public class SecureJsInterface extends a.b
{
  private static final String a = f.d + ".SI";
  public static boolean isPWDEdit = false;
  private String b;

  public void clearAllEdit()
  {
    f.c(a, "-->clear all edit.");
    try
    {
      JniInterface.clearAllPWD();
      return;
    }
    catch (Exception localException)
    {
      f.e(a, "-->clear all edit exception: " + localException.getMessage());
    }
    throw new RuntimeException(localException);
  }

  public void curPosFromJS(String paramString)
  {
    f.c(a, "-->curPosFromJS: " + paramString);
    int i = -1;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
      if (i < 0)
        throw new RuntimeException("position is illegal.");
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        f.e(a, "-->curPosFromJS number format exception.");
      if ((a.c) || (a.b))
      {
        if (Boolean.valueOf(JniInterface.BackSpaceChar(a.b, i)).booleanValue())
          a.b = false;
        return;
      }
      this.b = a.a;
      JniInterface.insetTextToArray(i, this.b, this.b.length());
      f.b(a, "mKey: " + this.b);
    }
  }

  public boolean customCallback()
  {
    return true;
  }

  public String getMD5FromNative()
  {
    f.c(a, "-->get md5 form native");
    try
    {
      String str = JniInterface.getPWDKeyToMD5(null);
      f.b(a, "-->getMD5FromNative, MD5= " + str);
      return str;
    }
    catch (Exception localException)
    {
      f.e(a, "-->get md5 form native exception: " + localException.getMessage());
    }
    throw new RuntimeException(localException);
  }

  public void isPasswordEdit(String paramString)
  {
    f.c(a, "-->is pswd edit, flag: " + paramString);
    int i = -1;
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
      if ((i != 0) && (i != 1))
        throw new RuntimeException("is pswd edit flag is illegal.");
    }
    catch (Exception localException)
    {
      while (true)
        f.e(a, "-->is pswd edit exception: " + localException.getMessage());
      if (i == 0)
        isPWDEdit = false;
      do
        return;
      while (i != 1);
      isPWDEdit = true;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.web.security.SecureJsInterface
 * JD-Core Version:    0.6.0
 */