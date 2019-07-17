package com.umeng.message;

class PushAgent$2
  implements Runnable
{
  public void run()
  {
    try
    {
      PushAgent.a(this.a, 0);
      PushAgent.a(this.a, 1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.PushAgent.2
 * JD-Core Version:    0.6.0
 */