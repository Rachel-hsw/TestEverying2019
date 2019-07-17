package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.withustudy.koudaizikao.entity.SubjectErrorExercise;
import com.withustudy.koudaizikao.entity.SubjectErrorExerciseW;
import com.withustudy.koudaizikao.fragment.ErrorListFragement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

class c extends Handler
{
  c(ActivityErrorListActivity paramActivityErrorListActivity)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 13:
        Toast.makeText(this.a.getApplicationContext(), "删除失败!", 0).show();
        return;
      case 1:
        if (ActivityErrorListActivity.a(this.a) == null)
        {
          ActivityErrorListActivity.a(this.a, new ActivityErrorListActivity.a(this.a));
          ActivityErrorListActivity.b(this.a).setAdapter(ActivityErrorListActivity.a(this.a));
          return;
        }
        ActivityErrorListActivity.a(this.a).notifyDataSetChanged();
        return;
      case 11:
        if (ActivityErrorListActivity.c(this.a) != null)
        {
          SubjectErrorExercise localSubjectErrorExercise = ActivityErrorListActivity.c(this.a).getSubjectErrorExercise();
          if (localSubjectErrorExercise != null)
          {
            ArrayList localArrayList = (ArrayList)localSubjectErrorExercise.getErrorExercise();
            if ((localArrayList == null) || (localArrayList.size() <= 0))
              break;
            ActivityErrorListActivity.d(this.a).clear();
            ErrorListFragement localErrorListFragement = new ErrorListFragement();
            Bundle localBundle = new Bundle();
            localBundle.putString("subjectId", ActivityErrorListActivity.e(this.a));
            localBundle.putString("subjectName", ActivityErrorListActivity.f(this.a));
            localBundle.putSerializable("SubjectErrorExercise", localSubjectErrorExercise);
            localErrorListFragement.setArguments(localBundle);
            ActivityErrorListActivity.d(this.a).add(localErrorListFragement);
            ActivityErrorListActivity.a(this.a, new d(this, this.a.getSupportFragmentManager()));
            ActivityErrorListActivity.g(this.a).setAdapter(ActivityErrorListActivity.h(this.a));
            return;
          }
          else
          {
            ActivityErrorListActivity.i(this.a).setVisibility(0);
            return;
          }
        }
        else
        {
          ActivityErrorListActivity.i(this.a).setVisibility(0);
          return;
        }
      case 5:
        Toast.makeText(this.a.getApplicationContext(), "删除成功!", 0).show();
        Iterator localIterator = ActivityErrorListActivity.j(this.a).keySet().iterator();
        List localList;
        int i;
        int j;
        int k;
        if (!localIterator.hasNext())
        {
          localList = (List)this.a.f.get(Integer.valueOf(ActivityErrorListActivity.k(this.a)));
          localList.clear();
          localList.addAll(this.a.d);
          i = localList.size();
          ActivityErrorListActivity.l(this.a).setText(ActivityErrorListActivity.f(this.a));
          j = 0;
          k = 0;
        }
        while (true)
        {
          if (j >= i)
          {
            ActivityErrorListActivity.m(this.a).setText(k + "道错题");
            ActivityErrorListActivity.n(this.a).setBackgroundResource(2130838198);
            if (ActivityErrorListActivity.a(this.a) != null)
              break label607;
            ActivityErrorListActivity.a(this.a, new ActivityErrorListActivity.a(this.a));
            ActivityErrorListActivity.b(this.a).setAdapter(ActivityErrorListActivity.a(this.a));
            return;
            Integer localInteger = (Integer)localIterator.next();
            ActivityErrorListActivity.j(this.a).put(localInteger, Boolean.valueOf(false));
            break;
          }
          k += ((List)((Map.Entry)localList.get(j)).getValue()).size();
          j++;
        }
        label607: ActivityErrorListActivity.a(this.a).notifyDataSetChanged();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.c
 * JD-Core Version:    0.6.0
 */