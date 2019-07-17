package com.gensee.media;

import com.gensee.taskret.IGSTask;
import com.gensee.utils.GenseeLog;

class GSOLPlayer$4
  implements IGSTask
{
  public int doTask()
  {
    int i = -1;
    long l = GSOLPlayer.nativePlayer;
    if (l != 0L)
    {
      i = GSOLPlayer.access$5(this.this$0, l);
      GenseeLog.d("GSOLPlayer", "stop()");
    }
    GSOLPlayer.access$6(this.this$0, false);
    if ((GSOLPlayer.access$3(this.this$0) != null) && (i != 0))
      GSOLPlayer.access$3(this.this$0).onError(4);
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.GSOLPlayer.4
 * JD-Core Version:    0.6.0
 */