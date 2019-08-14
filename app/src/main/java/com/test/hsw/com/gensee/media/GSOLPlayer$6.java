package com.gensee.media;

import com.gensee.taskret.IGSTask;
import com.gensee.utils.GenseeLog;

class GSOLPlayer$6
  implements IGSTask
{
  public int doTask()
  {
    long l = GSOLPlayer.nativePlayer;
    if (l != 0L)
    {
      GenseeLog.d("GSOLPlayer", "release");
      if (GSOLPlayer.access$8(this.this$0, l) == 0)
        GSOLPlayer.nativePlayer = 0L;
    }
    GSOLPlayer.access$6(this.this$0, false);
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.GSOLPlayer.6
 * JD-Core Version:    0.6.0
 */