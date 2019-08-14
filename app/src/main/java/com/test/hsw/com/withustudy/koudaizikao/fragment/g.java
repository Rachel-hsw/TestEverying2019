package com.withustudy.koudaizikao.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.activity.BrushRankingActivity;
import com.withustudy.koudaizikao.b.d;
import com.withustudy.koudaizikao.custom.a.a;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.entity.UrlShortBean;
import com.withustudy.koudaizikao.entity.Urls;
import com.withustudy.koudaizikao.entity.UserBrushSummaryW;
import com.withustudy.koudaizikao.entity.UserMockSummaryW;
import com.withustudy.koudaizikao.g.h;
import java.util.ArrayList;
import java.util.List;

class g extends Handler
{
  g(BrushRankingFragment paramBrushRankingFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 11:
    case 10:
    case 101:
    }
    label229: label231: label624: List localList1;
    label437: 
    do
    {
      do
      {
        while (true)
        {
          return;
          BrushRankingFragment.a(this.a).f();
          switch (BrushRankingFragment.b(this.a))
          {
          case 1:
          default:
          case 0:
          }
          while (true)
          {
            BrushRankingFragment.a(this.a, false);
            return;
            List localList4 = BrushRankingFragment.c(this.a).getUserBrushSummary();
            if (BrushRankingFragment.c(this.a).getMyRankPos() == -1)
              BrushRankingFragment.d(this.a).setText("还米有刷题");
            while (true)
            {
              if ((localList4 == null) || (localList4.size() <= 0))
                break label229;
              BrushRankingFragment.e(this.a).addAll(localList4);
              if (BrushRankingFragment.f(this.a) != null)
                break label231;
              BrushRankingFragment.a(this.a, new d(0, this.a.getActivity(), BrushRankingFragment.e(this.a)));
              BrushRankingFragment.a(this.a).setAdapter(BrushRankingFragment.f(this.a));
              break;
              BrushRankingFragment.d(this.a).setText("找找我在哪儿?");
            }
            continue;
            BrushRankingFragment.f(this.a).notifyDataSetChanged();
          }
          BrushRankingFragment.g(this.a).setRefreshing(false);
          switch (BrushRankingFragment.b(this.a))
          {
          default:
            return;
          case 0:
            List localList3 = BrushRankingFragment.c(this.a).getUserBrushSummary();
            if (BrushRankingFragment.c(this.a).getMyRankPos() == -1)
              BrushRankingFragment.d(this.a).setText("还米有刷题");
            while ((localList3 != null) && (localList3.size() > 0))
            {
              BrushRankingFragment.e(this.a).clear();
              BrushRankingFragment.e(this.a).addAll(localList3);
              if (BrushRankingFragment.f(this.a) != null)
                break label437;
              BrushRankingFragment.a(this.a, new d(0, BrushRankingFragment.h(this.a), BrushRankingFragment.e(this.a)));
              BrushRankingFragment.a(this.a).setAdapter(BrushRankingFragment.f(this.a));
              return;
              BrushRankingFragment.d(this.a).setText("找找我在哪儿?");
            }
            BrushRankingFragment.f(this.a).notifyDataSetChanged();
            return;
          case 1:
          }
          if (BrushRankingFragment.i(this.a) == null)
            BrushRankingFragment.a(this.a, new ArrayList());
          List localList2 = BrushRankingFragment.j(this.a).getUserMockSummary();
          if (BrushRankingFragment.j(this.a).getMyRankPos() == -1)
            BrushRankingFragment.d(this.a).setText("还米有模考");
          while ((localList2 != null) && (localList2.size() > 0))
          {
            BrushRankingFragment.i(this.a).clear();
            BrushRankingFragment.i(this.a).addAll(localList2);
            if (BrushRankingFragment.f(this.a) != null)
              break label624;
            BrushRankingFragment.a(this.a, new d(1, BrushRankingFragment.h(this.a), BrushRankingFragment.i(this.a)));
            BrushRankingFragment.a(this.a).setAdapter(BrushRankingFragment.f(this.a));
            return;
            BrushRankingFragment.d(this.a).setText("找找我在哪儿?");
          }
        }
        BrushRankingFragment.f(this.a).notifyDataSetChanged();
        return;
      }
      while (BrushRankingFragment.k(this.a) == null);
      localList1 = BrushRankingFragment.k(this.a).getUrls();
    }
    while ((localList1 == null) || (localList1.size() <= 0));
    Urls localUrls = (Urls)localList1.get(0);
    String str1 = localUrls.getUrl_short();
    String str2 = localUrls.getUrl_long();
    h.a("url_short ", str1);
    h.a("url_long ", str2);
    BrushRankingActivity localBrushRankingActivity = (BrushRankingActivity)this.a.getActivity();
    BrushRankingFragment.a(this.a, new a(localBrushRankingActivity, BrushRankingFragment.l(this.a)));
    BrushRankingFragment.m(this.a).c("快来口袋自考学本科吧，20大专业全科讲解题目，刷刷题就过关哦~");
    BrushRankingFragment.m(this.a).a(str2);
    BrushRankingFragment.m(this.a).d(str1);
    BrushRankingFragment.m(this.a).b("口袋自考");
    BrushRankingFragment.m(this.a).b();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.g
 * JD-Core Version:    0.6.0
 */