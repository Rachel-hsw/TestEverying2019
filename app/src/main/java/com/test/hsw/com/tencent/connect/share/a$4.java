package com.tencent.connect.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;
import com.tencent.open.utils.Util;
import java.util.ArrayList;

final class a$4
  implements Runnable
{
  public void run()
  {
    int i = 0;
    if (i < this.a.size())
    {
      String str1 = (String)this.a.get(i);
      Bitmap localBitmap;
      String str2;
      String str4;
      if ((!Util.isValidUrl(str1)) && (Util.fileExists(str1)))
      {
        localBitmap = a.a(str1, 10000);
        if (localBitmap != null)
        {
          str2 = Environment.getExternalStorageDirectory() + "/tmp/";
          String str3 = Util.encrypt(str1);
          str4 = "share2qzone_temp" + str3 + ".jpg";
          if (a.a(str1, 640, 10000))
            break label157;
          f.b("AsynScaleCompressImage", "not out of bound,not compress!");
        }
      }
      while (true)
      {
        if (str1 != null)
          this.a.set(i, str1);
        i++;
        break;
        label157: f.b("AsynScaleCompressImage", "out of bound, compress!");
        str1 = a.a(localBitmap, str2, str4);
      }
    }
    Message localMessage = this.b.obtainMessage(101);
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("images", this.a);
    localMessage.setData(localBundle);
    this.b.sendMessage(localMessage);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.a.4
 * JD-Core Version:    0.6.0
 */