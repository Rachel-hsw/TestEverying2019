package com.xiaomi.a.a.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class c extends Handler
{
  c(b paramb, Looper paramLooper)
  {
    super(paramLooper);
  }

  public void handleMessage(Message paramMessage)
  {
    b.b localb = (b.b)paramMessage.obj;
    if (paramMessage.what == 0)
      localb.a();
    while (true)
    {
      super.handleMessage(paramMessage);
      return;
      if (paramMessage.what != 1)
        continue;
      localb.c();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.d.c
 * JD-Core Version:    0.6.0
 */