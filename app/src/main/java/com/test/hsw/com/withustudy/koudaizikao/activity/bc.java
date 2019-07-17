package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.withustudy.koudaizikao.b.af;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.custom.PercentageRing;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class bc extends Handler
{
  bc(ShowCardActivity paramShowCardActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 5:
        String str = ShowCardActivity.a(this.a).getStatus();
        if ("STATUS_OK".equals(str))
        {
          ShowCardActivity.a(this.a, false);
          int j = ShowCardActivity.a(this.a).getAmount();
          h.a(this.a.getApplicationContext(), "累计奖学金=" + j);
          ShowCardActivity.b(this.a).a(j);
          Intent localIntent = new Intent("com.koudai.update_sco");
          localIntent.putExtra("isShowScoRedDot", true);
          this.a.sendBroadcast(localIntent);
          return;
        }
        if ("UPPER_CONTROL_LIMIT".equals(str))
        {
          h.a(this.a.getApplicationContext(), "一天只能得一次哟");
          return;
        }
        h.a(this.a.getApplicationContext(), "获取奖学金失败");
        return;
      case 2:
        if (ShowCardActivity.c(this.a) != null)
        {
          List localList = ShowCardActivity.c(this.a).getCourse_list();
          if ((localList != null) && (localList.size() > 0))
          {
            af localaf = new af(this.a, localList, 1);
            ShowCardActivity.d(this.a).setAdapter(localaf);
            ShowCardActivity.d(this.a).setVisibility(0);
            ShowCardActivity.e(this.a).setVisibility(8);
            ShowCardActivity.f(this.a).setVisibility(8);
            ShowCardActivity.g(this.a).setVisibility(0);
            ShowCardActivity.h(this.a).setText(ShowCardActivity.i(this.a));
            ShowCardActivity.j(this.a).setText(ShowCardActivity.k(this.a));
            ShowCardActivity.l(this.a).setText(ShowCardActivity.m(this.a));
            ShowCardActivity.n(this.a).setText(ShowCardActivity.o(this.a));
            ShowCardActivity.p(this.a).setText("恭喜你完成了本节的刷题");
            if (ShowCardActivity.q(this.a) != 0)
              break label511;
            ShowCardActivity.r(this.a).setVisibility(0);
            ShowCardActivity.s(this.a).setVisibility(8);
          }
        }
        while (true)
        {
          ShowCardActivity.t(this.a).setVisibility(0);
          new Thread(new bd(this)).start();
          return;
          ShowCardActivity.d(this.a).setVisibility(8);
          break;
          ShowCardActivity.d(this.a).setVisibility(8);
          break;
          label511: ShowCardActivity.r(this.a).setVisibility(8);
          ShowCardActivity.t(this.a).removeView(ShowCardActivity.s(this.a));
          int i = (int)(0.45D * ShowCardActivity.u(this.a));
          PercentageRing localPercentageRing = new PercentageRing(this.a.getApplicationContext(), i);
          localPercentageRing.a((int)(0.4D * i), i / 6);
          localPercentageRing.setTargetPercent(ShowCardActivity.q(this.a));
          ShowCardActivity.t(this.a).addView(localPercentageRing);
          ViewGroup.LayoutParams localLayoutParams = localPercentageRing.getLayoutParams();
          localLayoutParams.width = -2;
          localLayoutParams.height = -2;
          localPercentageRing.setLayoutParams(localLayoutParams);
        }
      case 1:
      case 3:
      case 4:
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bc
 * JD-Core Version:    0.6.0
 */