package com.withustudy.koudaizikao.b;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.withustudy.koudaizikao.fragment.BrushRankingFragment;
import java.util.List;

public class e extends FragmentPagerAdapter
{
  private List<BrushRankingFragment> a;

  public e(FragmentManager paramFragmentManager, List<BrushRankingFragment> paramList)
  {
    super(paramFragmentManager);
    this.a = paramList;
  }

  public int getCount()
  {
    return this.a.size();
  }

  public Fragment getItem(int paramInt)
  {
    return (Fragment)this.a.get(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.b.e
 * JD-Core Version:    0.6.0
 */