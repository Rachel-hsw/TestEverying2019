package com.withustudy.koudaizikao.activity;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.withustudy.koudaizikao.entity.ExamDateList;

class h extends Handler
{
  h(ActivityOldExamList paramActivityOldExamList)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 0:
    }
    ActivityOldExamList.a(this.a, ActivityOldExamList.a(this.a).getExamDate());
    if (ActivityOldExamList.b(this.a) == null)
    {
      ActivityOldExamList.c(this.a).setVisibility(0);
      return;
    }
    if (ActivityOldExamList.d(this.a) == null)
    {
      ActivityOldExamList.a(this.a, new ActivityOldExamList.a(this.a, null));
      ActivityOldExamList.e(this.a).setAdapter(ActivityOldExamList.d(this.a));
      return;
    }
    ActivityOldExamList.d(this.a).notifyDataSetChanged();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.h
 * JD-Core Version:    0.6.0
 */