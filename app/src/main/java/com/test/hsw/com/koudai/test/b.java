package com.koudai.test;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.withustudy.koudaizikao.g.h;
import java.util.HashMap;

class b
  implements ViewPager.OnPageChangeListener
{
  b(BrushExcerciseDetailActivity paramBrushExcerciseDetailActivity)
  {
  }

  public void onPageScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
      this.a.e();
    switch (paramInt)
    {
    default:
      return;
    case 1:
      BrushExcerciseDetailActivity.a(this.a, false);
      return;
    case 2:
      BrushExcerciseDetailActivity.a(this.a, true);
      return;
    case 0:
    }
    if ((BrushExcerciseDetailActivity.d(this.a).getCurrentItem() == -1 + BrushExcerciseDetailActivity.d(this.a).getAdapter().getCount()) && (!BrushExcerciseDetailActivity.e(this.a)))
    {
      if (!BrushExcerciseDetailActivity.f(this.a))
        break label123;
      this.a.d();
    }
    while (true)
    {
      BrushExcerciseDetailActivity.a(this.a, true);
      return;
      label123: Toast.makeText(this.a.getApplicationContext(), "小袋努力加载中。。。", 0).show();
    }
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    h.a(Float.valueOf(paramFloat));
  }

  public void onPageSelected(int paramInt)
  {
    BrushExcerciseDetailActivity.a(this.a, paramInt);
    Boolean localBoolean = (Boolean)BrushExcerciseDetailActivity.a(this.a).get(Integer.valueOf(BrushExcerciseDetailActivity.b(this.a)));
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      BrushExcerciseDetailActivity.c(this.a).setImageResource(2130837688);
      return;
    }
    BrushExcerciseDetailActivity.c(this.a).setImageResource(2130837677);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.b
 * JD-Core Version:    0.6.0
 */