package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class g extends Handler
{
  g(ActivityErrorWecome paramActivityErrorWecome)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 2:
        Toast.makeText(this.a.getApplicationContext(), "删除成功!", 0).show();
        ActivityErrorWecome.a(this.a);
        return;
      case 3:
        Toast.makeText(this.a.getApplicationContext(), "删除失败!", 0).show();
        return;
      case 101:
        if (ActivityErrorWecome.b(this.a) == null)
          break;
        List localList = ActivityErrorWecome.b(this.a).getUrls();
        if ((localList == null) || (localList.size() <= 0))
          break;
        Urls localUrls = (Urls)localList.get(0);
        String str1 = localUrls.getUrl_short();
        String str2 = localUrls.getUrl_long();
        h.a("url_short ", str1);
        h.a("url_long ", str2);
        ActivityErrorWecome.a(this.a, new a(this.a, ActivityErrorWecome.c(this.a)));
        ActivityErrorWecome.d(this.a).c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        ActivityErrorWecome.d(this.a).a(str2);
        ActivityErrorWecome.d(this.a).d(str1);
        ActivityErrorWecome.d(this.a).b("口袋自考");
        ActivityErrorWecome.d(this.a).b();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.g
 * JD-Core Version:    0.6.0
 */