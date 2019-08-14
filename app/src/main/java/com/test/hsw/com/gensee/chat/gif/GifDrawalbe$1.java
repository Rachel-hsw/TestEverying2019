package com.gensee.chat.gif;

import android.os.Handler.Callback;
import android.os.Message;

class GifDrawalbe$1
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    if (((Boolean)paramMessage.obj).booleanValue())
      this.this$0.start();
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.chat.gif.GifDrawalbe.1
 * JD-Core Version:    0.6.0
 */