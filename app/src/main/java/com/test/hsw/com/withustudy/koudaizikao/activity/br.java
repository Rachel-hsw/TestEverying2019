package com.withustudy.koudaizikao.activity;

import android.widget.ProgressBar;
import android.widget.SeekBar;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Video;
import java.util.TimerTask;

class br extends TimerTask
{
  br(VideoTapePlayActivity paramVideoTapePlayActivity)
  {
  }

  public void run()
  {
    if ((VideoTapePlayActivity.w(this.a)) && (VideoTapePlayActivity.t(this.a).getVisibility() == 8) && (!VideoTapePlayActivity.z(this.a)))
    {
      a locala = c.b().aA();
      VideoTapePlayActivity localVideoTapePlayActivity = this.a;
      String[] arrayOfString = new String[4];
      arrayOfString[0] = VideoTapePlayActivity.l(this.a).i();
      arrayOfString[1] = VideoTapePlayActivity.J(this.a);
      arrayOfString[2] = VideoTapePlayActivity.f(this.a).getVideo_id();
      arrayOfString[3] = String.valueOf(VideoTapePlayActivity.q(this.a).getProgress() / 1000);
      locala.a(localVideoTapePlayActivity, arrayOfString, 20, VideoTapePlayActivity.y(this.a));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.br
 * JD-Core Version:    0.6.0
 */