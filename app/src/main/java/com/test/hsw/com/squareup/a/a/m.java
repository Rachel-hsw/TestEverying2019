package com.squareup.a.a;

import java.util.concurrent.ThreadFactory;

final class m
  implements ThreadFactory
{
  m(String paramString, boolean paramBoolean)
  {
  }

  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = new Thread(paramRunnable, this.a);
    localThread.setDaemon(this.b);
    return localThread;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.m
 * JD-Core Version:    0.6.0
 */