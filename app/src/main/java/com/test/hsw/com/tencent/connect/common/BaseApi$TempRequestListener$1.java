package com.tencent.connect.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

class BaseApi$TempRequestListener$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      BaseApi.TempRequestListener.access$000(this.this$1).onComplete(paramMessage.obj);
      return;
    }
    BaseApi.TempRequestListener.access$000(this.this$1).onError(new UiError(paramMessage.what, (String)paramMessage.obj, null));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.connect.common.BaseApi.TempRequestListener.1
 * JD-Core Version:    0.6.0
 */