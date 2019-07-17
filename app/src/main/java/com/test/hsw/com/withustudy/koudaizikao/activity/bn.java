package com.withustudy.koudaizikao.activity;

import android.widget.ProgressBar;
import android.widget.SeekBar;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Video;
import java.util.TimerTask;

class bn extends TimerTask
{
  bn(VideoLiveReplayActivity paramVideoLiveReplayActivity)
  {
  }

  public void run()
  {
    if ((VideoLiveReplayActivity.l(this.a)) && (VideoLiveReplayActivity.b(this.a).getVisibility() == 8) && (!VideoLiveReplayActivity.p(this.a)))
    {
      a locala = c.b().aA();
      VideoLiveReplayActivity localVideoLiveReplayActivity = this.a;
      String[] arrayOfString = new String[4];
      arrayOfString[0] = VideoLiveReplayActivity.x(this.a).i();
      arrayOfString[1] = VideoLiveReplayActivity.y(this.a);
      arrayOfString[2] = VideoLiveReplayActivity.g(this.a).getVideo_id();
      arrayOfString[3] = String.valueOf(VideoLiveReplayActivity.c(this.a).getProgress() / 1000);
      locala.a(localVideoLiveReplayActivity, arrayOfString, 20, VideoLiveReplayActivity.k(this.a));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bn
 * JD-Core Version:    0.6.0
 */