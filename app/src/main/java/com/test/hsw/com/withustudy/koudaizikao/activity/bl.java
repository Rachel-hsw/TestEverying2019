package com.withustudy.koudaizikao.activity;

import java.util.TimerTask;

class bl extends TimerTask
{
  bl(VideoLivePlayActivity.a parama)
  {
  }

  public void run()
  {
    if (VideoLivePlayActivity.f(VideoLivePlayActivity.a.a(this.a)))
      VideoLivePlayActivity.d(VideoLivePlayActivity.a.a(this.a)).sendEmptyMessage(3);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bl
 * JD-Core Version:    0.6.0
 */