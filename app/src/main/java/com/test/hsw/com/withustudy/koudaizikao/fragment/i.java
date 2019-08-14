package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.withustudy.koudaizikao.activity.ActivityErrorListActivity;
import com.withustudy.koudaizikao.activity.QuestionDetailActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class i
  implements AdapterView.OnItemClickListener
{
  i(ErrorListFragement paramErrorListFragement)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ArrayList localArrayList = (ArrayList)((Map.Entry)((List)ErrorListFragement.a(this.a).f.get(Integer.valueOf(ErrorListFragement.b(this.a)))).get(paramInt)).getValue();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("errorExercises", localArrayList);
    String str = ErrorListFragement.f(this.a);
    ((ActivityErrorListActivity)this.a.getActivity());
    localBundle.putSerializable("subjectName", ErrorListFragement.g(this.a));
    localBundle.putSerializable("subjectId", str);
    localBundle.putInt("FromPage", 10);
    ErrorListFragement.a(this.a, QuestionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.i
 * JD-Core Version:    0.6.0
 */