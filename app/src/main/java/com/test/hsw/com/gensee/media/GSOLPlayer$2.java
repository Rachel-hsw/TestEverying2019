package com.gensee.media;

import com.gensee.taskret.IGSTask;
import com.gensee.utils.GenseeLog;

class GSOLPlayer$2
  implements IGSTask
{
  public int doTask()
  {
    long l = GSOLPlayer.nativePlayer;
    int i = -1;
    if (l != 0L)
    {
      i = GSOLPlayer.access$2(this.this$0, l);
      GenseeLog.d("GSOLPlayer", "pause nativePause()");
    }
    this.this$0.audioPause();
    if (GSOLPlayer.access$3(this.this$0) != null)
    {
      if (i == 0)
        break label64;
      GSOLPlayer.access$3(this.this$0).onError(2);
    }
    while (true)
    {
      return 0;
      label64: GSOLPlayer.access$3(this.this$0).onPlayPause();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.GSOLPlayer.2
 * JD-Core Version:    0.6.0
 */