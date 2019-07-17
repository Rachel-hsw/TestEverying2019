package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class av
  implements ViewPager.OnPageChangeListener
{
  av(QuestionDetailActivity paramQuestionDetailActivity)
  {
  }

  public void onPageScrollStateChanged(int paramInt)
  {
    h.a("onPageScrollStateChanged state=" + paramInt);
    if (this.a.r == 0);
    switch (paramInt)
    {
    default:
      return;
    case 1:
      QuestionDetailActivity.d(this.a, false);
      return;
    case 2:
      QuestionDetailActivity.d(this.a, true);
      return;
    case 0:
    }
    if ((QuestionDetailActivity.i(this.a).getCurrentItem() == -1 + QuestionDetailActivity.i(this.a).getAdapter().getCount()) && (!QuestionDetailActivity.D(this.a)))
      QuestionDetailActivity.r(this.a);
    QuestionDetailActivity.d(this.a, true);
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    this.a.b(paramInt);
    if ((this.a.e != 9) && (this.a.e != 12));
    for (int i = 0; ; i = 1)
    {
      if ((QuestionDetailActivity.g(this.a)) && (this.a.e == 888) && (paramInt == -1 + QuestionDetailActivity.f(this.a).size()))
      {
        Bundle localBundle3 = new Bundle();
        localBundle3.putString("subjectId", this.a.c);
        localBundle3.putString("subjectName", QuestionDetailActivity.z(this.a));
        localBundle3.putInt("FromPage", 888);
        Intent localIntent3 = new Intent(this.a.getApplicationContext(), IntellWecomeActivity.class);
        localBundle3.putSerializable("currRight", this.a.a);
        localIntent3.putExtras(localBundle3);
        this.a.startActivity(localIntent3);
        this.a.finish(0, 0);
      }
      if ((QuestionDetailActivity.g(this.a)) && (i != 0) && (paramInt == -1 + QuestionDetailActivity.f(this.a).size()))
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("subjectId", this.a.c);
        localBundle2.putSerializable("currRight", this.a.a);
        localBundle2.putString("subjectName", QuestionDetailActivity.z(this.a));
        Intent localIntent2 = new Intent(this.a.getApplicationContext(), ShowCardActivity.class);
        localIntent2.putExtras(localBundle2);
        this.a.startActivity(localIntent2);
        this.a.finish(0, 0);
      }
      h.a(Boolean.valueOf(QuestionDetailActivity.g(this.a)));
      h.a(Integer.valueOf(this.a.r));
      if ((QuestionDetailActivity.g(this.a)) && (this.a.r == 100) && (paramInt == -1 + QuestionDetailActivity.f(this.a).size()))
        QuestionDetailActivity.A(this.a);
      if ((QuestionDetailActivity.g(this.a)) && (this.a.r == 101) && (paramInt == -1 + QuestionDetailActivity.f(this.a).size()))
        QuestionDetailActivity.A(this.a);
      if ((QuestionDetailActivity.g(this.a)) && (this.a.e == 10) && (paramInt == -1 + QuestionDetailActivity.f(this.a).size()))
      {
        Intent localIntent1 = new Intent(this.a.getApplicationContext(), ActivityErrorWecome.class);
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("subjectId", this.a.c);
        localBundle1.putString("subjectName", QuestionDetailActivity.z(this.a));
        localBundle1.putSerializable("errExsList", this.a.h);
        QuestionDetailActivity.a(this.a, System.currentTimeMillis());
        localBundle1.putLong("time", QuestionDetailActivity.B(this.a) - QuestionDetailActivity.C(this.a));
        localIntent1.putExtras(localBundle1);
        this.a.startActivity(localIntent1);
        this.a.finish(0, 0);
      }
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.av
 * JD-Core Version:    0.6.0
 */