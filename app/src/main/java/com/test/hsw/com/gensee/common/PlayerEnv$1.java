package com.gensee.common;

import com.gensee.taskret.IGSTask;
import com.gensee.taskret.OnTaskRet;

class PlayerEnv$1
  implements IGSTask
{
  public int doTask()
  {
    PlayerEnv.access$0(true, 1, this.val$serviceType, this.val$sampleSize, true);
    if (this.val$ret != null)
      this.val$ret.onTaskRet(true, 1, "initOfflineComp");
    return 1;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.common.PlayerEnv.1
 * JD-Core Version:    0.6.0
 */