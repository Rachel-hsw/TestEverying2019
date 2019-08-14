package com.gensee.player;

import com.gensee.taskret.IGSTask;
import com.gensee.taskret.OnTaskRet;

class NativePlayer$9
  implements IGSTask
{
  public int doTask()
  {
    if (NativePlayer.access$1() != 0L);
    for (int i = NativePlayer.access$7(this.this$0, NativePlayer.access$1(), this.val$qId, this.val$content); ; i = 0)
    {
      if ((i != 0) && (this.val$ret != null))
        this.val$ret.onTaskRet(false, i, "question");
      return 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer.9
 * JD-Core Version:    0.6.0
 */