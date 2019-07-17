package com.tencent.connect.share;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.utils.AsynLoadImgBack;

final class a$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      super.handleMessage(paramMessage);
      return;
    case 101:
      String str = (String)paramMessage.obj;
      this.a.saved(0, str);
      return;
    case 102:
    }
    int i = paramMessage.arg1;
    this.a.saved(i, null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.share.a.1
 * JD-Core Version:    0.6.0
 */