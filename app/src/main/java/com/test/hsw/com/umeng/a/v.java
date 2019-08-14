package com.umeng.a;

public abstract class v
  implements Runnable
{
  public abstract void a();

  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localThrowable == null);
      localThrowable.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.a.v
 * JD-Core Version:    0.6.0
 */