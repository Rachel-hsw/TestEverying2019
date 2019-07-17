package com.koudai.test;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class a extends Handler
{
  a(BrushExcerciseDetailActivity paramBrushExcerciseDetailActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 0:
        this.a.c();
        return;
      case 101:
        this.a.b();
        return;
      case 8:
        this.a.a();
        return;
      case 9:
        Toast.makeText(this.a.getApplicationContext(), "取消失败!", 0).show();
        return;
      case 5:
        this.a.a(paramMessage);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.a
 * JD-Core Version:    0.6.0
 */