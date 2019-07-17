package com.alipay.apmobilesecuritysdk.face;

import java.util.LinkedList;

class APSecuritySdk$1
  implements Runnable
{
  public void run()
  {
    try
    {
      while (!APSecuritySdk.a(this.a).isEmpty())
      {
        APSecuritySdk.RunningTask localRunningTask = (APSecuritySdk.RunningTask)APSecuritySdk.a(this.a).pollFirst();
        if (localRunningTask == null)
          continue;
        localRunningTask.run();
      }
    }
    catch (Throwable localThrowable)
    {
      return;
      return;
    }
    finally
    {
      APSecuritySdk.b(this.a);
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
 * JD-Core Version:    0.6.0
 */