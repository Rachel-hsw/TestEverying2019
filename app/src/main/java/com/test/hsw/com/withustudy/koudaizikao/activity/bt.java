package com.withustudy.koudaizikao.activity;

import java.util.TimerTask;

class bt extends TimerTask
{
  bt(VideoTapePlayActivity.a parama)
  {
  }

  public void run()
  {
    if (VideoTapePlayActivity.w(VideoTapePlayActivity.a.a(this.a)))
      VideoTapePlayActivity.a.sendEmptyMessage(1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bt
 * JD-Core Version:    0.6.0
 */