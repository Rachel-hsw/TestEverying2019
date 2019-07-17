package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.d.f;

class an extends Handler
{
  an(MainActivity paramMainActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 0:
      do
        return;
      while (MainActivity.access$0(this.a) == null);
      MainActivity.access$0(this.a).d();
      return;
    case 100:
      a locala2 = c.b().au();
      MainActivity localMainActivity2 = this.a;
      String[] arrayOfString2 = new String[1];
      arrayOfString2[0] = MainActivity.access$1(this.a).i();
      locala2.a(localMainActivity2, arrayOfString2, 12, MainActivity.access$2(this.a));
      return;
    case 99:
      MainActivity.access$3(this.a).setVisibility(0);
      MainActivity.access$4(this.a, true);
      return;
    case 101:
      if (!MainActivity.access$1(this.a).s().equals(""))
      {
        a locala1 = c.b().aC();
        MainActivity localMainActivity1 = this.a;
        String[] arrayOfString1 = new String[3];
        arrayOfString1[0] = MainActivity.access$1(this.a).i();
        arrayOfString1[1] = MainActivity.access$1(this.a).s();
        arrayOfString1[2] = ((String)paramMessage.obj);
        locala1.a(localMainActivity1, arrayOfString1, 13, MainActivity.access$2(this.a));
        return;
      }
      MainActivity.access$5(this.a).sendMessageDelayed(MainActivity.access$5(this.a).obtainMessage(101, (String)paramMessage.obj), 2000L);
      return;
    case 102:
      MainActivity.access$6(this.a).setVisibility(0);
      return;
    case 105:
      Toast.makeText(MainActivity.access$2(this.a), "服务器未响应，请稍后再试", 0).show();
      return;
    case 103:
      MainActivity.access$6(this.a).setVisibility(8);
      MainActivity.access$7(this.a).setVisibility(8);
      return;
    case 5:
      MainActivity.access$3(this.a).setVisibility(0);
      return;
    case 15:
    }
    MainActivity.access$7(this.a).setVisibility(0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.an
 * JD-Core Version:    0.6.0
 */