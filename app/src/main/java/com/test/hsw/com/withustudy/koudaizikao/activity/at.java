package com.withustudy.koudaizikao.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.withustudy.koudaizikao.custom.j;
import java.util.List;

class at extends j
{
  at(aq paramaq, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }

  public Fragment a(int paramInt)
  {
    return (Fragment)QuestionDetailActivity.f(aq.a(this.a)).get(paramInt);
  }

  public int getCount()
  {
    return QuestionDetailActivity.f(aq.a(this.a)).size();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.at
 * JD-Core Version:    0.6.0
 */