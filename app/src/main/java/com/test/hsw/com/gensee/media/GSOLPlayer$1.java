package com.gensee.media;

import com.gensee.taskret.IGSTask;
import com.gensee.utils.GenseeLog;
import com.gensee.vod.VodMr;
import java.io.File;

class GSOLPlayer$1
  implements IGSTask
{
  private boolean isValidDir(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)));
    File localFile;
    do
    {
      return false;
      localFile = new File(paramString);
    }
    while ((localFile.exists()) || (!localFile.mkdirs()));
    return localFile.isDirectory();
  }

  public int doTask()
  {
    if (0L == GSOLPlayer.nativePlayer)
      if (!isValidDir(this.val$cachDir))
        break label111;
    label111: String str;
    for (Object localObject = this.val$cachDir; ; localObject = str)
    {
      GenseeLog.d("GSOLPlayer", "play player is 0,and will create, catch dir is " + (String)localObject);
      GSOLPlayer.nativePlayer = GSOLPlayer.access$0(this.this$0, this.val$siteId, this.val$userId, this.val$nickName, this.val$albAddr, (String)localObject);
      if (GSOLPlayer.nativePlayer == 0L)
        GenseeLog.d("GSOLPlayer", "play player is 0 create failed");
      GSOLPlayer.access$1(this.this$0, GSOLPlayer.nativePlayer, this.val$filePath, this.val$vodId, this.val$tid);
      return 0;
      str = VodMr.getIns().getCachDir();
      if (str == null)
        str = GSOLPlayer.CATCH_DEF_DIR;
      File localFile = new File(str);
      if (localFile.exists())
        continue;
      localFile.mkdirs();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.media.GSOLPlayer.1
 * JD-Core Version:    0.6.0
 */