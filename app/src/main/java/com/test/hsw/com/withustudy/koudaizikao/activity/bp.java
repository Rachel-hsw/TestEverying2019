package com.withustudy.koudaizikao.activity;

import java.util.TimerTask;

class bp extends TimerTask
{
  bp(VideoLiveReplayActivity.a parama)
  {
  }

  public void run()
  {
    if (VideoLiveReplayActivity.l(VideoLiveReplayActivity.a.a(this.a)))
      VideoLiveReplayActivity.b.sendEmptyMessage(1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bp
 * JD-Core Version:    0.6.0
 */