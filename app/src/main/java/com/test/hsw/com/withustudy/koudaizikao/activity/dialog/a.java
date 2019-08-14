package com.withustudy.koudaizikao.activity.dialog;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.VideoCourse;
import com.withustudy.koudaizikao.g.h;

class a extends Handler
{
  a(DialogActivityPay paramDialogActivityPay)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 0:
      Intent localIntent2 = new Intent();
      String str2 = this.a.getPackageName();
      localIntent2.setComponent(new ComponentName(str2, str2 + ".wxapi.WXPayEntryActivity"));
      localIntent2.putExtra("com.pingplusplus.android.PaymentActivity.CHARGE", DialogActivityPay.a(this.a));
      this.a.startActivityForResult(localIntent2, 1);
      return;
    case 1:
    }
    while (true)
    {
      float f2;
      try
      {
        String str1 = DialogActivityPay.b(this.a).getExtras().getString("pay_result");
        h.a(this.a, str1);
        if (!str1.equals("cancel"))
          continue;
        this.a.setResult(0);
        this.a.finish(0, 0);
        return;
        if (!str1.equals("success"))
          continue;
        if (!DialogActivityPay.c(this.a))
          continue;
        f1 = 100.0F * DialogActivityPay.d(this.a).getPrice();
        f2 = DialogActivityPay.e(this.a).a();
        (int)(1.0D * f2 / 100.0D);
        if (f2 >= f1)
        {
          h.a(this.a.getApplicationContext(), "使用奖学金成功c=" + f1);
          float f3 = f2 - f1;
          boolean bool = f3 < 0.0F;
          float f4 = 0.0F;
          if (bool)
            continue;
          h.a(this.a.getApplicationContext(), "使用奖学金成功y=" + f4);
          DialogActivityPay.e(this.a).a(f4);
          Intent localIntent1 = new Intent("com.koudai.update_sco");
          localIntent1.putExtra("isFresh", true);
          this.a.sendBroadcast(localIntent1);
          this.a.setResult(1);
          this.a.finish(0, 0);
          return;
          this.a.setResult(0);
          this.a.finish(0, 0);
          return;
          f4 = f3;
          continue;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      float f1 = f2;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.dialog.a
 * JD-Core Version:    0.6.0
 */