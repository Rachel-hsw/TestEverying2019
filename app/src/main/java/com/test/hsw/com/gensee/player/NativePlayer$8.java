package com.gensee.player;

import com.gensee.taskret.IGSTask;
import com.gensee.taskret.OnTaskRet;

class NativePlayer$8
  implements IGSTask
{
  public int doTask()
  {
    int i;
    if (NativePlayer.access$1() != 0L)
      if (this.val$receiverId == 0)
        i = NativePlayer.access$5(this.this$0, NativePlayer.access$1(), this.val$content, this.val$richtext);
    while (true)
    {
      OnTaskRet localOnTaskRet;
      if (this.val$ret != null)
      {
        localOnTaskRet = this.val$ret;
        if (i != 0)
          break label90;
      }
      label90: for (boolean bool = true; ; bool = false)
      {
        localOnTaskRet.onTaskRet(bool, i, "chat");
        return 0;
        i = NativePlayer.access$6(this.this$0, NativePlayer.access$1(), this.val$content, this.val$richtext, this.val$receiverId);
        break;
      }
      i = 0;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer.8
 * JD-Core Version:    0.6.0
 */