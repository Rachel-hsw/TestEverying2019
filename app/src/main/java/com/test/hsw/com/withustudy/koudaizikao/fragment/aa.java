package com.withustudy.koudaizikao.fragment;

import android.os.Handler;
import android.os.Message;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.withustudy.koudaizikao.custom.swipyrefresh.SwipyRefreshLayout;
import com.withustudy.koudaizikao.entity.SubjectMockRecord;
import com.withustudy.koudaizikao.entity.SubjectMockRecordW;
import java.util.List;

class aa extends Handler
{
  aa(SubjectSimuHistoryFm paramSubjectSimuHistoryFm)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 0:
    }
    label154: List localList1;
    do
    {
      SubjectMockRecord localSubjectMockRecord1;
      do
      {
        return;
        SubjectSimuHistoryFm.a(this.a).f();
        SubjectMockRecord localSubjectMockRecord2 = SubjectSimuHistoryFm.b(this.a).getSubjectMockRecord();
        if (localSubjectMockRecord2 != null)
        {
          List localList2 = localSubjectMockRecord2.getMockRecord();
          if ((localList2 != null) && (localList2.size() > 0))
          {
            SubjectSimuHistoryFm.c(this.a).addAll(localList2);
            if (SubjectSimuHistoryFm.d(this.a) != null)
              break label154;
            SubjectSimuHistoryFm.a(this.a, new SubjectSimuHistoryFm.a(this.a, SubjectSimuHistoryFm.c(this.a)));
            SubjectSimuHistoryFm.a(this.a).setAdapter(SubjectSimuHistoryFm.d(this.a));
          }
        }
        while (true)
        {
          SubjectSimuHistoryFm.a(this.a, false);
          return;
          SubjectSimuHistoryFm.d(this.a).a(SubjectSimuHistoryFm.c(this.a));
          SubjectSimuHistoryFm.d(this.a).notifyDataSetChanged();
        }
        SubjectSimuHistoryFm.e(this.a).setRefreshing(false);
        localSubjectMockRecord1 = SubjectSimuHistoryFm.b(this.a).getSubjectMockRecord();
      }
      while (localSubjectMockRecord1 == null);
      localList1 = localSubjectMockRecord1.getMockRecord();
    }
    while ((localList1 == null) || (localList1.size() <= 0));
    SubjectSimuHistoryFm.c(this.a).clear();
    SubjectSimuHistoryFm.c(this.a).addAll(localList1);
    if (SubjectSimuHistoryFm.d(this.a) == null)
    {
      SubjectSimuHistoryFm.a(this.a, new SubjectSimuHistoryFm.a(this.a, SubjectSimuHistoryFm.c(this.a)));
      SubjectSimuHistoryFm.a(this.a).setAdapter(SubjectSimuHistoryFm.d(this.a));
      return;
    }
    SubjectSimuHistoryFm.d(this.a).a(SubjectSimuHistoryFm.c(this.a));
    SubjectSimuHistoryFm.d(this.a).notifyDataSetChanged();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.aa
 * JD-Core Version:    0.6.0
 */