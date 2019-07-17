package com.gensee.player;

import com.gensee.taskret.IGSTask;
import com.gensee.taskret.OnTaskRet;
import com.gensee.utils.FileUtil;

class NativePlayer$7
  implements IGSTask
{
  public int doTask()
  {
    NativePlayer.access$3(this.this$0);
    if (this.val$ret != null)
      this.val$ret.onTaskRet(true, 0, "release");
    FileUtil.deleteFile(NativePlayer.access$4(this.this$0));
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.player.NativePlayer.7
 * JD-Core Version:    0.6.0
 */