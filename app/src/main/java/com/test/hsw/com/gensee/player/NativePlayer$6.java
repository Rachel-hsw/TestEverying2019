package com.gensee.player;

import com.gensee.taskret.IGSTask;
import com.gensee.taskret.OnTaskRet;

class NativePlayer$6
  implements IGSTask
{
  public int doTask()
  {
    if (NativePlayer.access$1() != 0L);
    for (int i = NativePlayer.access$2(this.this$0, NativePlayer.access$1(), 1); ; i = 0)
    {
      if ((i != 0) && (this.val$ret != null) && (!this.val$leaved))
        this.val$ret.onTaskRet(false, i, "leave");
      return 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer.6
 * JD-Core Version:    0.6.0
 */