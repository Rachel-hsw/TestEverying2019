package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.entity.KpointDetails;
import com.withustudy.koudaizikao.entity.KpointDetailsW;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.fragment.FragmentKPoint;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class ai extends Handler
{
  ai(KnowledgePointDetailActivity paramKnowledgePointDetailActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    try
    {
      switch (paramMessage.what)
      {
      case 0:
        List localList2 = KnowledgePointDetailActivity.a(this.a).getKpointDetails();
        if (localList2 == null)
          break;
        KnowledgePointDetailActivity.b(this.a).addAll(localList2);
        int j = localList2.size();
        while (true)
        {
          if (i >= j)
          {
            if (KnowledgePointDetailActivity.d(this.a) != null)
              break;
            KnowledgePointDetailActivity.a(this.a, new aj(this, this.a.getSupportFragmentManager()));
            KnowledgePointDetailActivity.e(this.a).setAdapter(KnowledgePointDetailActivity.d(this.a));
            ((FragmentKPoint)KnowledgePointDetailActivity.c(this.a).get(0)).a((KpointDetails)KnowledgePointDetailActivity.b(this.a).get(0), KnowledgePointDetailActivity.b(this.a));
            return;
          }
          FragmentKPoint localFragmentKPoint = new FragmentKPoint();
          KnowledgePointDetailActivity.c(this.a).add(localFragmentKPoint);
          i++;
        }
        KnowledgePointDetailActivity.d(this.a).notifyDataSetChanged();
        return;
      case 101:
        if (KnowledgePointDetailActivity.f(this.a) == null)
          break;
        List localList1 = KnowledgePointDetailActivity.f(this.a).getUrls();
        if ((localList1 == null) || (localList1.size() <= 0))
          break;
        Urls localUrls = (Urls)localList1.get(0);
        String str1 = localUrls.getUrl_short();
        String str2 = localUrls.getUrl_long();
        h.a("url_short ", str1);
        h.a("url_long ", str2);
        KnowledgePointDetailActivity.a(this.a, new a(this.a, KnowledgePointDetailActivity.e(this.a)));
        KnowledgePointDetailActivity.g(this.a).c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
        KnowledgePointDetailActivity.g(this.a).a(str2);
        KnowledgePointDetailActivity.g(this.a).d(str1);
        KnowledgePointDetailActivity.g(this.a).b("口袋自考");
        KnowledgePointDetailActivity.g(this.a).b();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.ai
 * JD-Core Version:    0.6.0
 */