package com.gensee.download;

import com.gensee.taskret.IGSTask;
import java.io.File;

class VodDownLoadManager$4
  implements IGSTask
{
  public int doTask()
  {
    String str1 = this.this$0.getSaveDir() + VodDownLoadManager.access$2(this.this$0) + File.separator + this.val$downLoadId + File.separator;
    File localFile = new File(str1);
    if (!localFile.exists())
      localFile.mkdirs();
    String str2 = str1 + "record.xml";
    VodDownLoadManager.access$0(this.this$0).download(this.val$entity.getDownLoadUrl(), str2, this.val$downLoadId);
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.download.VodDownLoadManager.4
 * JD-Core Version:    0.6.0
 */