package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.RspSco;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class j extends Handler
{
  j(ActivitySimuResult paramActivitySimuResult)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 5:
        String str3 = ActivitySimuResult.a(this.a).getStatus();
        if ("STATUS_OK".equals(str3))
        {
          this.a.s = false;
          int i = ActivitySimuResult.a(this.a).getAmount();
          ActivitySimuResult.b(this.a).a(i);
          h.a(this.a.getApplicationContext(), "累计奖学金=" + i);
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
      case 101:
        if (ActivitySimuResult.c(this.a) == null)
          break;
        List localList = ActivitySimuResult.c(this.a).getUrls();
        if ((localList == null) || (localList.size() <= 0))
          break;
        ActivitySimuResult.a(this.a, (Urls)localList.get(0));
        String str1 = ActivitySimuResult.d(this.a).getUrl_short();
        String str2 = ActivitySimuResult.d(this.a).getUrl_long();
        h.a("url_short ", str1);
        h.a("url_long ", str2);
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.j
 * JD-Core Version:    0.6.0
 */