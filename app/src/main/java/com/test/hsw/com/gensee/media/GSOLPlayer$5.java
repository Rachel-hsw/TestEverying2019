package com.gensee.media;

import com.gensee.taskret.IGSTask;
import com.gensee.utils.GenseeLog;

class GSOLPlayer$5
  implements IGSTask
{
  public int doTask()
  {
    long l = GSOLPlayer.nativePlayer;
    if (l != 0L)
    {
      int i = GSOLPlayer.access$7(this.this$0, l, this.val$position);
      GenseeLog.d("GSOLPlayer", "seekTo position = " + this.val$position + " ret = " + i);
      if ((i != 0) && (GSOLPlayer.access$3(this.this$0) != null))
        GSOLPlayer.access$3(this.this$0).onError(5);
    }
    while (true)
    {
      return 0;
      GenseeLog.w("GSOLPlayer", "player is 0 seekTo position = " + this.val$position);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.GSOLPlayer.5
 * JD-Core Version:    0.6.0
 */