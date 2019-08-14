package com.tencent.open.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;
import java.io.File;

class AsynLoadImg$2
  implements Runnable
{
  public void run()
  {
    f.a("AsynLoadImg", "saveFileRunnable:");
    String str1 = Util.encrypt(AsynLoadImg.b(this.a));
    String str2 = "share_qq_" + str1 + ".jpg";
    String str3 = AsynLoadImg.a() + str2;
    File localFile = new File(str3);
    Message localMessage = AsynLoadImg.c(this.a).obtainMessage();
    if (localFile.exists())
    {
      localMessage.arg1 = 0;
      localMessage.obj = str3;
      f.a("AsynLoadImg", "file exists: time:" + (System.currentTimeMillis() - AsynLoadImg.d(this.a)));
      AsynLoadImg.c(this.a).sendMessage(localMessage);
      return;
    }
    Bitmap localBitmap = AsynLoadImg.getbitmap(AsynLoadImg.b(this.a));
    boolean bool;
    if (localBitmap != null)
    {
      bool = this.a.saveFile(localBitmap, str2);
      label183: if (!bool)
        break label250;
      localMessage.arg1 = 0;
      localMessage.obj = str3;
    }
    while (true)
    {
      f.a("AsynLoadImg", "file not exists: download time:" + (System.currentTimeMillis() - AsynLoadImg.d(this.a)));
      break;
      f.a("AsynLoadImg", "saveFileRunnable:get bmp fail---");
      bool = false;
      break label183;
      label250: localMessage.arg1 = 1;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.AsynLoadImg.2
 * JD-Core Version:    0.6.0
 */