package com.withustudy.koudaizikao.activity;

class t extends Thread
{
  t(ImageSelectorActivity paramImageSelectorActivity)
  {
  }

  public void run()
  {
    super.run();
    int i = -2 + ImageSelectorActivity.h(this.a).length;
    while (true)
    {
      if (i < 0)
      {
        ImageSelectorActivity.o(this.a).sendEmptyMessage(4);
        return;
      }
      ImageSelectorActivity.o(this.a).sendMessage(ImageSelectorActivity.o(this.a).obtainMessage(2, i, 0));
      try
      {
        sleep(40L);
        i--;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          localInterruptedException.printStackTrace();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.t
 * JD-Core Version:    0.6.0
 */