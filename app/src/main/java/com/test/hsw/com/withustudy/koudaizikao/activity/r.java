package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.withustudy.koudaizikao.entity.SubjectFavoriteExercise;

class r
  implements View.OnClickListener
{
  r(FavoriteExerciseActivity.c paramc, SubjectFavoriteExercise paramSubjectFavoriteExercise)
  {
  }

  public void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("SubjectFavoriteExercise", this.b);
    FavoriteExerciseActivity.c.a(this.a).startNewActivity(ActivityCollectSubject.class, 2130968591, 2130968589, false, localBundle);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.r
 * JD-Core Version:    0.6.0
 */