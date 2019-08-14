package com.baidu.location.h;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f;

class a$1 extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (!f.isServing);
    do
    {
      return;
      switch (paramMessage.what)
      {
      default:
        return;
      case 1:
        a.jdMethod_if(this.a, (Location)paramMessage.obj);
        return;
      case 2:
      case 3:
      case 4:
      }
    }
    while (a.jdMethod_do(this.a) == null);
    a.jdMethod_do(this.a).a((String)paramMessage.obj);
    return;
    a.jdMethod_if(this.a, "&og=1", (Location)paramMessage.obj);
    return;
    a.jdMethod_if(this.a, "&og=2", (Location)paramMessage.obj);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.h.a.1
 * JD-Core Version:    0.6.0
 */