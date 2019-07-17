package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.withustudy.koudaizikao.entity.req.ExamDate;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class i
  implements AdapterView.OnItemClickListener
{
  i(ActivityOldExamList paramActivityOldExamList)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    h.a(this.a.getApplicationContext(), paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putString("subjectId", ActivityOldExamList.f(this.a));
    localBundle.putString("subjectName", ActivityOldExamList.g(this.a));
    localBundle.putSerializable("examDate", (ExamDate)ActivityOldExamList.b(this.a).get(paramInt));
    localBundle.putInt("FromPage", 16);
    this.a.startNewActivity(QuestionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.i
 * JD-Core Version:    0.6.0
 */