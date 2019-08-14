package com.withustudy.koudaizikao.custom;

import android.support.v4.view.ViewPager.OnPageChangeListener;

class q
  implements ViewPager.OnPageChangeListener
{
  q(ViewPagerIndicator paramViewPagerIndicator)
  {
  }

  public void onPageScrollStateChanged(int paramInt)
  {
    if (ViewPagerIndicator.b(this.a) != null)
      ViewPagerIndicator.b(this.a).b(paramInt);
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.a.a(paramInt1, paramFloat);
    if (ViewPagerIndicator.b(this.a) != null)
      ViewPagerIndicator.b(this.a).a(paramInt1, paramFloat, paramInt2);
  }

  public void onPageSelected(int paramInt)
  {
    ViewPagerIndicator.a(this.a);
    this.a.a(paramInt);
    if (ViewPagerIndicator.b(this.a) != null)
      ViewPagerIndicator.b(this.a).a(paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.q
 * JD-Core Version:    0.6.0
 */