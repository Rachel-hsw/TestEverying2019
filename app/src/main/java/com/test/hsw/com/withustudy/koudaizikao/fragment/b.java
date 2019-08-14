package com.withustudy.koudaizikao.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.withustudy.koudaizikao.custom.j;
import java.util.List;

class b extends j
{
  b(a parama, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }

  public Fragment a(int paramInt)
  {
    return (Fragment)a.a(this.a).b.get(paramInt);
  }

  public int getCount()
  {
    return a.a(this.a).b.size();
  }

  public CharSequence getPageTitle(int paramInt)
  {
    return (String)a.a(this.a).a.get(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.b
 * JD-Core Version:    0.6.0
 */