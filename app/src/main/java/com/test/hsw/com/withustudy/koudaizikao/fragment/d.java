package com.withustudy.koudaizikao.fragment;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.umeng.a.g;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.g.h;
import java.util.List;

class d
  implements ViewPager.OnPageChangeListener
{
  d(BrushMainFragment paramBrushMainFragment)
  {
  }

  public void onPageScrollStateChanged(int paramInt)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    g.b(BrushMainFragment.j(this.a), "brush_change_subject");
    this.a.d = paramInt;
    BrushMainFragment.e(this.a).a(paramInt);
    String str = ((Subject)this.a.e.get(paramInt)).getId();
    BrushMainFragment.e(this.a).c(str);
    h.a("bruhMainFragment onPageSelected", "id " + str + "   currentIndex=" + paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.d
 * JD-Core Version:    0.6.0
 */