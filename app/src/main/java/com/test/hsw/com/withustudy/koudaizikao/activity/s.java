package com.withustudy.koudaizikao.activity;

class s extends Thread
{
  s(ImageSelectorActivity paramImageSelectorActivity)
  {
  }

  public void run()
  {
    super.run();
    ImageSelectorActivity.o(this.a).sendEmptyMessage(3);
    int i = 1;
    while (true)
    {
      if (i >= ImageSelectorActivity.h(this.a).length)
        return;
      ImageSelectorActivity.o(this.a).sendMessage(ImageSelectorActivity.o(this.a).obtainMessage(2, i, 0));
      try
      {
        sleep(40L);
        i++;
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
 * Qualified Name:     com.withustudy.koudaizikao.activity.s
 * JD-Core Version:    0.6.0
 */