package com.umeng.socialize.view;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.umeng.socialize.utils.i;

class ab extends Handler
{
  ab(aa paramaa)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what == 1) && (aa.a(this.a) != null))
      aa.a(this.a).setVisibility(8);
    if (paramMessage.what == 2);
    try
    {
      aa.b(this.a);
      return;
    }
    catch (Exception localException)
    {
      i.b(aa.a(), "follow error", localException);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.ab
 * JD-Core Version:    0.6.0
 */