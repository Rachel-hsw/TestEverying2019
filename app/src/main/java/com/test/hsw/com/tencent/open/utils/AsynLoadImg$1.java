package com.tencent.open.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.open.a.f;

class AsynLoadImg$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    f.a("AsynLoadImg", "handleMessage:" + paramMessage.arg1);
    if (paramMessage.arg1 == 0)
    {
      AsynLoadImg.a(this.a).saved(paramMessage.arg1, (String)paramMessage.obj);
      return;
    }
    AsynLoadImg.a(this.a).saved(paramMessage.arg1, null);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.utils.AsynLoadImg.1
 * JD-Core Version:    0.6.0
 */