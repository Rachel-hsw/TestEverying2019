package com.withustudy.koudaizikao.activity;

import com.bokecc.sdk.mobile.play.DWMediaPlayer;
import java.util.TimerTask;

class bq extends TimerTask
{
  bq(VideoTapePlayActivity paramVideoTapePlayActivity)
  {
  }

  public void run()
  {
    if ((VideoTapePlayActivity.w(this.a)) && (!VideoTapePlayActivity.z(this.a)) && (VideoTapePlayActivity.m(this.a) != null))
      VideoTapePlayActivity.a.sendMessage(VideoTapePlayActivity.a.obtainMessage(4, Integer.valueOf(VideoTapePlayActivity.m(this.a).getCurrentPosition())));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bq
 * JD-Core Version:    0.6.0
 */