package com.withustudy.koudaizikao.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class SlidingTabLayout extends HorizontalScrollView
{
  private static final int a = 24;
  private static final int b = 16;
  private static final int c = 12;
  private int d;
  private int e;
  private int f;
  private boolean g;
  private ViewPager h;
  private SparseArray<String> i = new SparseArray();
  private ViewPager.OnPageChangeListener j;
  private final p k;

  public SlidingTabLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlidingTabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SlidingTabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    setFillViewport(true);
    this.d = (int)(24.0F * getResources().getDisplayMetrics().density);
    this.k = new p(paramContext);
    addView(this.k, -1, -2);
  }

  private int a(float paramFloat)
  {
    return (int)TypedValue.applyDimension(2, paramFloat, getResources().getDisplayMetrics());
  }

  private void a()
  {
    PagerAdapter localPagerAdapter = this.h.getAdapter();
    b localb = new b(null);
    int m = 0;
    if (m >= localPagerAdapter.getCount())
      return;
    if (0 == 0);
    for (View localView = b(getContext()); ; localView = null)
    {
      if ((0 == 0) && (LinearLayout.class.isInstance(localView)));
      for (ColorTrackView localColorTrackView = (ColorTrackView)localView.findViewById(2131296334); ; localColorTrackView = null)
      {
        if (this.g)
        {
          LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
          localLayoutParams.width = 0;
          localLayoutParams.weight = 1.0F;
        }
        localColorTrackView.setText(localPagerAdapter.getPageTitle(m).toString());
        localView.setOnClickListener(localb);
        String str = (String)this.i.get(m, null);
        if (str != null)
          localView.setContentDescription(str);
        this.k.addView(localView);
        if (m == this.h.getCurrentItem())
        {
          localView.setSelected(true);
          localColorTrackView.setTextColor(getResources().getColor(2131034112));
          localColorTrackView.setTextSize(a(18.0F));
        }
        m++;
        break;
      }
    }
  }

  private void b(int paramInt1, int paramInt2)
  {
    int m = this.k.getChildCount();
    if ((m == 0) || (paramInt1 < 0) || (paramInt1 >= m));
    View localView;
    do
    {
      return;
      localView = this.k.getChildAt(paramInt1);
    }
    while (localView == null);
    int n = paramInt2 + localView.getLeft();
    if ((paramInt1 > 0) || (paramInt2 > 0))
      n -= this.d;
    scrollTo(n, 0);
  }

  @SuppressLint({"NewApi"})
  protected TextView a(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setGravity(17);
    localTextView.setTextSize(2, 12.0F);
    localTextView.setTypeface(Typeface.DEFAULT_BOLD);
    localTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    TypedValue localTypedValue = new TypedValue();
    if (Build.VERSION.SDK_INT >= 11)
      getContext().getTheme().resolveAttribute(16843534, localTypedValue, true);
    localTextView.setBackgroundResource(localTypedValue.resourceId);
    if (Build.VERSION.SDK_INT >= 14)
      localTextView.setAllCaps(true);
    int m = (int)(16.0F * getResources().getDisplayMetrics().density);
    localTextView.setPadding(m, m, m, m);
    return localTextView;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }

  public void a(int paramInt, String paramString)
  {
    this.i.put(paramInt, paramString);
  }

  @SuppressLint({"NewApi"})
  protected View b(Context paramContext)
  {
    return View.inflate(getContext(), 2130903300, null);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.h != null)
      b(this.h.getCurrentItem(), 0);
  }

  public void setCustomTabColorizer(c paramc)
  {
    this.k.a(paramc);
  }

  public void setDistributeEvenly(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public void setDividerColors(int[] paramArrayOfInt)
  {
    this.k.b(paramArrayOfInt);
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.j = paramOnPageChangeListener;
  }

  public void setSelectedIndicatorColors(int[] paramArrayOfInt)
  {
    this.k.a(paramArrayOfInt);
  }

  public void setViewPager(ViewPager paramViewPager)
  {
    this.k.removeAllViews();
    this.h = paramViewPager;
    if (paramViewPager != null)
    {
      paramViewPager.setOnPageChangeListener(new a(null));
      a();
    }
  }

  private class a
    implements ViewPager.OnPageChangeListener
  {
    private int b;

    private a()
    {
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      this.b = paramInt;
      if (SlidingTabLayout.b(SlidingTabLayout.this) != null)
        SlidingTabLayout.b(SlidingTabLayout.this).onPageScrollStateChanged(paramInt);
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      int i = SlidingTabLayout.a(SlidingTabLayout.this).getChildCount();
      if ((i == 0) || (paramInt1 < 0) || (paramInt1 >= i));
      ColorTrackView localColorTrackView1;
      while (true)
      {
        return;
        SlidingTabLayout.a(SlidingTabLayout.this).a(paramInt1, paramFloat);
        View localView = SlidingTabLayout.a(SlidingTabLayout.this).getChildAt(paramInt1);
        localColorTrackView1 = (ColorTrackView)localView.findViewById(2131296334);
        if (paramFloat != 0.0F)
          break;
        localColorTrackView1.setDirection(1);
        localColorTrackView1.setProgress(1.0F);
        int k = 0;
        if (localView != null)
          k = (int)(paramFloat * localView.getWidth());
        SlidingTabLayout.a(SlidingTabLayout.this, paramInt1, k);
        if (SlidingTabLayout.b(SlidingTabLayout.this) == null)
          continue;
        SlidingTabLayout.b(SlidingTabLayout.this).onPageScrolled(paramInt1, paramFloat, paramInt2);
        return;
      }
      int j = 0;
      label141: ColorTrackView localColorTrackView2;
      if (j < SlidingTabLayout.a(SlidingTabLayout.this).getChildCount())
      {
        localColorTrackView2 = (ColorTrackView)SlidingTabLayout.a(SlidingTabLayout.this).getChildAt(j).findViewById(2131296334);
        if (j != paramInt1)
          break label204;
        localColorTrackView1.setDirection(1);
        localColorTrackView1.setProgress(1.0F - paramFloat);
      }
      while (true)
      {
        j++;
        break label141;
        break;
        label204: if (j == paramInt1 + 1)
        {
          if (localColorTrackView2 != null)
            localColorTrackView2.setDirection(0);
          if (localColorTrackView2 == null)
            continue;
          localColorTrackView2.setProgress(paramFloat);
          continue;
        }
        localColorTrackView2.setDirection(0);
        localColorTrackView2.setProgress(0.0F);
      }
    }

    public void onPageSelected(int paramInt)
    {
      if (this.b == 0)
      {
        SlidingTabLayout.a(SlidingTabLayout.this).a(paramInt, 0.0F);
        SlidingTabLayout.a(SlidingTabLayout.this, paramInt, 0);
      }
      int i = 0;
      if (i >= SlidingTabLayout.a(SlidingTabLayout.this).getChildCount())
      {
        if (SlidingTabLayout.b(SlidingTabLayout.this) != null)
          SlidingTabLayout.b(SlidingTabLayout.this).onPageSelected(paramInt);
        return;
      }
      if (paramInt == i)
      {
        SlidingTabLayout.a(SlidingTabLayout.this).getChildAt(i).setSelected(true);
        ((ColorTrackView)SlidingTabLayout.a(SlidingTabLayout.this).getChildAt(i).findViewById(2131296334)).setTextSize(SlidingTabLayout.a(SlidingTabLayout.this, 18.0F));
      }
      while (true)
      {
        i++;
        break;
        SlidingTabLayout.a(SlidingTabLayout.this).getChildAt(i).setSelected(false);
        ((ColorTrackView)SlidingTabLayout.a(SlidingTabLayout.this).getChildAt(i).findViewById(2131296334)).setTextSize(SlidingTabLayout.a(SlidingTabLayout.this, 16.0F));
      }
    }
  }

  private class b
    implements View.OnClickListener
  {
    private b()
    {
    }

    public void onClick(View paramView)
    {
      for (int i = 0; ; i++)
      {
        if (i >= SlidingTabLayout.a(SlidingTabLayout.this).getChildCount())
          return;
        if (paramView != SlidingTabLayout.a(SlidingTabLayout.this).getChildAt(i))
          continue;
        SlidingTabLayout.c(SlidingTabLayout.this).setCurrentItem(i);
        return;
      }
    }
  }

  public static abstract interface c
  {
    public abstract int a(int paramInt);

    public abstract int b(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.SlidingTabLayout
 * JD-Core Version:    0.6.0
 */