package com.tencent.connect.share;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;
import com.tencent.open.utils.Util;

final class a$2
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = a.a(this.a, 140);
    if (localBitmap != null)
    {
      String str1 = Environment.getExternalStorageDirectory() + "/tmp/";
      String str2 = Util.encrypt(this.a);
      String str3 = "share2qq_temp" + str2 + ".jpg";
      if (!a.a(this.a, 140, 140))
        f.b("AsynScaleCompressImage", "not out of bound,not compress!");
      for (String str4 = this.a; ; str4 = a.a(localBitmap, str1, str3))
      {
        f.b("AsynScaleCompressImage", "-->destFilePath: " + str4);
        if (str4 == null)
          break;
        Message localMessage2 = this.b.obtainMessage(101);
        localMessage2.obj = str4;
        this.b.sendMessage(localMessage2);
        return;
        f.b("AsynScaleCompressImage", "out of bound,compress!");
      }
    }
    Message localMessage1 = this.b.obtainMessage(102);
    localMessage1.arg1 = 3;
    this.b.sendMessage(localMessage1);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.a.2
 * JD-Core Version:    0.6.0
 */