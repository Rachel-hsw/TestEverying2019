package com.gensee.download;

import com.gensee.taskret.IGSTask;

class VodDownLoadManager$5
  implements IGSTask
{
  public int doTask()
  {
    VodDownLoadManager.access$0(this.this$0).stopDownLoading(this.val$downLoadId);
    if (VodDownLoadManager.access$1(this.this$0) != null)
      VodDownLoadManager.access$1(this.this$0).OnStatus(this.val$downLoadId, VodDownLoadStatus.STOP.getStatus());
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoadManager.5
 * JD-Core Version:    0.6.0
 */