package com.withustudy.koudaizikao.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.withustudy.koudaizikao.custom.j;
import java.util.List;

class f extends j
{
  f(BrushMainFragment paramBrushMainFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }

  public Fragment a(int paramInt)
  {
    return (Fragment)this.a.b.get(paramInt);
  }

  public int getCount()
  {
    return this.a.b.size();
  }

  public CharSequence getPageTitle(int paramInt)
  {
    return (String)this.a.a.get(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.f
 * JD-Core Version:    0.6.0
 */