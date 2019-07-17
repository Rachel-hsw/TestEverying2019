package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import com.withustudy.koudaizikao.custom.ViewPagerIndicator;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectW;
import com.withustudy.koudaizikao.fragment.SubjectSimuHistoryFm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bh extends Handler
{
  bh(SimuHistoryListActivity paramSimuHistoryListActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 0:
    }
    do
    {
      return;
      SimuHistoryListActivity.a(this.a, SimuHistoryListActivity.a(this.a).getSubject());
    }
    while ((SimuHistoryListActivity.b(this.a) == null) || (SimuHistoryListActivity.b(this.a).size() <= 0));
    if (SimuHistoryListActivity.c(this.a) == null)
      SimuHistoryListActivity.b(this.a, new ArrayList());
    SimuHistoryListActivity.c(this.a).clear();
    SimuHistoryListActivity.d(this.a).clear();
    Iterator localIterator = SimuHistoryListActivity.b(this.a).iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        SimuHistoryListActivity.a(this.a, new bi(this, this.a.getSupportFragmentManager()));
        SimuHistoryListActivity.e(this.a).setAdapter(SimuHistoryListActivity.f(this.a));
        SimuHistoryListActivity.g(this.a).setTabItemTitles(SimuHistoryListActivity.c(this.a));
        SimuHistoryListActivity.g(this.a).a(SimuHistoryListActivity.e(this.a), 0);
        SimuHistoryListActivity.e(this.a).setCurrentItem(0);
        return;
      }
      Subject localSubject = (Subject)localIterator.next();
      SimuHistoryListActivity.c(this.a).add(localSubject.getName());
      SubjectSimuHistoryFm localSubjectSimuHistoryFm = new SubjectSimuHistoryFm();
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("subject", localSubject);
      localSubjectSimuHistoryFm.setArguments(localBundle);
      SimuHistoryListActivity.d(this.a).add(localSubjectSimuHistoryFm);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.bh
 * JD-Core Version:    0.6.0
 */