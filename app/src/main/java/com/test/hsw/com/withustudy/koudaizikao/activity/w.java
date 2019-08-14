package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.withustudy.koudaizikao.a.a;
import com.withustudy.koudaizikao.a.c;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.Scholarship;
import com.withustudy.koudaizikao.entity.SmartPushState;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import com.withustudy.koudaizikao.g.h;
import com.withustudy.koudaizikao.g.l;
import java.util.List;

class w extends Handler
{
  w(IntellWecomeActivity paramIntellWecomeActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 2:
    case 5:
    case 0:
    case 101:
    }
    List localList1;
    do
    {
      do
      {
        do
        {
          do
            return;
          while (IntellWecomeActivity.access$0(this.a) == null);
          List localList2 = IntellWecomeActivity.access$0(this.a).getCourse_list();
          if ((localList2 != null) && (localList2.size() > 0))
          {
            this.a.initIntellAndTuiJianData(localList2);
            return;
          }
          IntellWecomeActivity.access$1(this.a);
          return;
          String str3 = IntellWecomeActivity.access$2(this.a).getStatus();
          if ("STATUS_OK".equals(str3))
          {
            IntellWecomeActivity.access$3(this.a, false);
            int k = IntellWecomeActivity.access$2(this.a).getAmount();
            IntellWecomeActivity.access$4(this.a).a(k);
            h.a(this.a.getApplicationContext(), "累计奖学金=" + k);
            Intent localIntent = new Intent("com.koudai.update_sco");
            localIntent.putExtra("isShowScoRedDot", true);
            this.a.sendBroadcast(localIntent);
            return;
          }
          if ("UPPER_CONTROL_LIMIT".equals(str3))
          {
            h.a(this.a.getApplicationContext(), "一天只能得一次哟");
            return;
          }
          h.a(this.a.getApplicationContext(), "获取奖学金失败");
          return;
        }
        while (IntellWecomeActivity.access$5(this.a) == null);
        Scholarship localScholarship = IntellWecomeActivity.access$5(this.a).getScholarship();
        if (localScholarship != null)
        {
          IntellWecomeActivity.access$6(this.a).b();
          IntellWecomeActivity.access$7(this.a).setVisibility(8);
          IntellWecomeActivity.access$8(this.a).setVisibility(8);
          IntellWecomeActivity.access$9(this.a).setVisibility(8);
          IntellWecomeActivity.access$10(this.a).setVisibility(0);
          int i = localScholarship.getAmount();
          IntellWecomeActivity.access$11(this.a).setText(IntellWecomeActivity.access$12(this.a));
          IntellWecomeActivity.access$13(this.a).setText(IntellWecomeActivity.access$14(this.a));
          IntellWecomeActivity.access$15(this.a).setText(IntellWecomeActivity.access$16(this.a));
          IntellWecomeActivity.access$17(this.a).setText(IntellWecomeActivity.access$18(this.a));
          int j = (int)(1.0D * i / 100.0D);
          IntellWecomeActivity.access$19(this.a).setText(j + "元");
          new Thread(new x(this, localScholarship.getActivityId())).start();
          return;
        }
        a locala = c.b().r();
        IntellWecomeActivity localIntellWecomeActivity = this.a;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = IntellWecomeActivity.access$4(this.a).i();
        arrayOfString[1] = IntellWecomeActivity.access$20(this.a);
        locala.a(localIntellWecomeActivity, arrayOfString, 2, this.a);
        return;
      }
      while (IntellWecomeActivity.access$21(this.a) == null);
      localList1 = IntellWecomeActivity.access$21(this.a).getUrls();
    }
    while ((localList1 == null) || (localList1.size() <= 0));
    IntellWecomeActivity.access$22(this.a, (Urls)localList1.get(0));
    String str1 = IntellWecomeActivity.access$23(this.a).getUrl_short();
    String str2 = IntellWecomeActivity.access$23(this.a).getUrl_long();
    h.a("url_short ", str1);
    h.a("url_long ", str2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.w
 * JD-Core Version:    0.6.0
 */