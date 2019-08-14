package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

class bb extends Handler
{
  bb(ReSetPasswordActivity paramReSetPasswordActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 1:
        Toast.makeText(this.a.getApplicationContext(), "验证码未过期", 0).show();
        return;
      case 2:
        Toast.makeText(this.a.getApplicationContext(), "该手机已经注册！", 0).show();
        return;
      case 3:
        Toast.makeText(this.a.getApplicationContext(), "服务器未能返回数据，请稍后再试", 0).show();
        return;
      case 4:
        Toast.makeText(this.a.getApplicationContext(), "服务器未响应，请稍后再试", 0).show();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bb
 * JD-Core Version:    0.6.0
 */