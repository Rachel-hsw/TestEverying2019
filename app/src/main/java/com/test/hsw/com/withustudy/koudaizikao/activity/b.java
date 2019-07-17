package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.entity.SubjectFavoriteExercise;
import com.withustudy.koudaizikao.entity.req.FavoriteExercise;
import java.util.HashMap;
import java.util.List;

class b
  implements AdapterView.OnItemClickListener
{
  b(ActivityCollectSubject paramActivityCollectSubject)
  {
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (ActivityCollectSubject.access$15(this.a))
    {
      Boolean localBoolean = (Boolean)ActivityCollectSubject.access$7(this.a).get(Integer.valueOf(paramInt));
      View localView1 = paramView.findViewById(2131296869);
      View localView2 = paramView.findViewById(2131296865);
      View localView3 = paramView.findViewById(2131296866);
      if ((localBoolean == null) || (!localBoolean.booleanValue()))
      {
        localView1.setVisibility(8);
        localView2.setVisibility(0);
        localView3.setVisibility(0);
        localView3.setBackgroundResource(2130837807);
        ActivityCollectSubject.access$7(this.a).put(Integer.valueOf(paramInt), Boolean.valueOf(true));
        return;
      }
      localView1.setVisibility(8);
      localView2.setVisibility(0);
      localView3.setVisibility(0);
      localView3.setBackgroundResource(2130838198);
      ActivityCollectSubject.access$7(this.a).put(Integer.valueOf(paramInt), Boolean.valueOf(false));
      return;
    }
    ((FavoriteExercise)ActivityCollectSubject.access$0(this.a).get(paramInt));
    Bundle localBundle = new Bundle();
    Subject localSubject = ActivityCollectSubject.access$1(this.a).getSubject();
    String str1 = localSubject.getId();
    String str2 = localSubject.getName();
    localBundle.putString("subjectId", str1);
    localBundle.putString("subjectName", str2);
    localBundle.putInt("FromPage", 15);
    localBundle.putSerializable("favoriteExercise", (FavoriteExercise)ActivityCollectSubject.access$0(this.a).get(paramInt));
    this.a.startNewActivity(QuestionDetailActivity.class, 2130968591, 2130968589, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.b
 * JD-Core Version:    0.6.0
 */