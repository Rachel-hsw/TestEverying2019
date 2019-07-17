package com.withustudy.koudaizikao.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

class aj extends FragmentPagerAdapter
{
  aj(ai paramai, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }

  public int getCount()
  {
    return KnowledgePointDetailActivity.c(ai.a(this.a)).size();
  }

  public Fragment getItem(int paramInt)
  {
    return (Fragment)KnowledgePointDetailActivity.c(ai.a(this.a)).get(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.aj
 * JD-Core Version:    0.6.0
 */