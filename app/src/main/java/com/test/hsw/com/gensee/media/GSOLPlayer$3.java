package com.gensee.media;

import com.gensee.taskret.IGSTask;
import com.gensee.utils.GenseeLog;

class GSOLPlayer$3
  implements IGSTask
{
  public int doTask()
  {
    int i = -1;
    long l = GSOLPlayer.nativePlayer;
    if (l != 0L)
    {
      i = GSOLPlayer.access$4(this.this$0, l);
      GenseeLog.d("GSOLPlayer", "resume nativeResume");
    }
    if (GSOLPlayer.access$3(this.this$0) != null)
    {
      if (i == 0)
        break label57;
      GSOLPlayer.access$3(this.this$0).onError(3);
    }
    while (true)
    {
      return 0;
      label57: GSOLPlayer.access$3(this.this$0).onPlayResume();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.GSOLPlayer.3
 * JD-Core Version:    0.6.0
 */