package com.tencent.wxop.stat.b;

import java.io.File;

final class p
{
  private static int aI = -1;

  public static boolean a()
  {
    if (aI == 1)
      return true;
    if (aI == 0)
      return false;
    String[] arrayOfString = { "/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/" };
    for (int i = 0; ; i++)
      try
      {
        if (i < arrayOfString.length)
        {
          if (!new File(arrayOfString[i] + "su").exists())
            continue;
          aI = 1;
          return true;
        }
      }
      catch (Exception localException)
      {
        aI = 0;
        return false;
      }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.p
 * JD-Core Version:    0.6.0
 */