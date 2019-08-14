package com.withustudy.koudaizikao.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.android.http.e;
import com.withustudy.koudaizikao.activity.ActivitySimuResult;
import com.withustudy.koudaizikao.b.af;
import com.withustudy.koudaizikao.custom.MyListView;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.content.VideoAllContent;
import java.util.List;

class w extends Handler
{
  w(SimuFragment paramSimuFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 2:
    }
    SimuFragment.a(this.a);
    SimuFragment.b(this.a);
    String str1 = SimuFragment.c(this.a).u();
    if ((str1 != null) && (!str1.equals("")))
      SimuFragment.d(this.a).a(str1, SimuFragment.e(this.a), 1000);
    String str2 = SimuFragment.c(this.a).v();
    SimuFragment.f(this.a).setText(str2);
    if ("LOW".equals(SimuFragment.g(this.a).g))
    {
      SimuFragment.h(this.a).setText("低等");
      SimuFragment.i(this.a).setText(SimuFragment.g(this.a).t);
      SimuFragment.j(this.a).setText(SimuFragment.g(this.a).d);
      SimuFragment.g(this.a).l = SimuFragment.g(this.a).p;
      SimuFragment.k(this.a).setText(SimuFragment.g(this.a).u);
      if (SimuFragment.l(this.a) == null)
        break label408;
      List localList = SimuFragment.l(this.a).getCourse_list();
      if ((localList == null) || (localList.size() <= 0))
        break label393;
      af localaf = new af(SimuFragment.g(this.a), localList, 1);
      SimuFragment.m(this.a).setAdapter(localaf);
      SimuFragment.m(this.a).setVisibility(0);
    }
    while (true)
    {
      new Thread(new x(this)).start();
      return;
      if ("MIDDLE".equals(SimuFragment.g(this.a).g))
      {
        SimuFragment.h(this.a).setText("中等");
        break;
      }
      if (!"HIGH".equals(SimuFragment.g(this.a).g))
        break;
      SimuFragment.h(this.a).setText("高级");
      break;
      label393: SimuFragment.m(this.a).setVisibility(8);
      continue;
      label408: SimuFragment.m(this.a).setVisibility(8);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.w
 * JD-Core Version:    0.6.0
 */