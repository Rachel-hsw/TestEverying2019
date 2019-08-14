package com.withustudy.koudaizikao.activity;

import java.util.TimerTask;

class bs extends TimerTask
{
  bs(VideoTapePlayActivity.a parama)
  {
  }

  public void run()
  {
    if (VideoTapePlayActivity.w(VideoTapePlayActivity.a.a(this.a)))
      VideoTapePlayActivity.a.sendEmptyMessage(1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bs
 * JD-Core Version:    0.6.0
 */