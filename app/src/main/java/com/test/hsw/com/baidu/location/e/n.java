package com.baidu.location.e;

import android.os.HandlerThread;

public class n
{
  private static HandlerThread a = null;

  public static HandlerThread a()
  {
    if (a == null)
    {
      a = new HandlerThread("ServiceStartArguments", 10);
      a.start();
    }
    return a;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.n
 * JD-Core Version:    0.6.0
 */