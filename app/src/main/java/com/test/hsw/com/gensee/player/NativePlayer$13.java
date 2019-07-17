package com.gensee.player;

import com.gensee.taskret.IGSTask;
import com.gensee.taskret.OnTaskRet;

class NativePlayer$13
  implements IGSTask
{
  public int doTask()
  {
    if (NativePlayer.access$1() != 0L);
    for (int i = NativePlayer.access$10(this.this$0, NativePlayer.access$1(), this.val$isClose); ; i = 0)
    {
      OnTaskRet localOnTaskRet;
      if (this.val$taskRet != null)
      {
        localOnTaskRet = this.val$taskRet;
        if (i != 0)
          break label53;
      }
      label53: for (boolean bool = true; ; bool = false)
      {
        localOnTaskRet.onTaskRet(bool, i, "closeVideo");
        return 0;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer.13
 * JD-Core Version:    0.6.0
 */