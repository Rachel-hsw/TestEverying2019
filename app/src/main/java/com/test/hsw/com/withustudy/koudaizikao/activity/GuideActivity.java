package com.withustudy.koudaizikao.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.umeng.a.g;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AbsBaseActivity
{
  private RelativeLayout a;
  private RelativeLayout b;
  private ViewPager c;
  private View[] d;
  private List<View> e;
  private ImageView[] f;
  private int g;
  private a h;
  private boolean i;

  private void a()
  {
    for (int j = 0; ; j++)
    {
      if (j >= 3)
      {
        this.f[this.g].setBackgroundResource(2130837837);
        return;
      }
      this.f[j].setBackgroundResource(2130837838);
    }
  }

  protected void bindData()
  {
    this.c.setAdapter(new b());
  }

  protected void initData()
  {
    this.h = new a();
    this.e = new ArrayList();
    this.e.add(this.d[0]);
    this.e.add(this.d[1]);
    this.e.add(this.d[2]);
  }

  protected void initListener()
  {
    this.c.setOnPageChangeListener(this.h);
    this.a.setOnClickListener(this.h);
    this.b.setOnClickListener(this.h);
  }

  protected void initView()
  {
    this.a = ((RelativeLayout)findViewById(2131296513));
    this.b = ((RelativeLayout)findViewById(2131296514));
    this.c = ((ViewPager)findViewById(2131296511));
    this.d = new View[3];
    this.d[0] = View.inflate(this.mContext, 2130903176, null);
    this.d[1] = View.inflate(this.mContext, 2130903178, null);
    this.d[2] = View.inflate(this.mContext, 2130903177, null);
    this.f = new ImageView[3];
    this.f[0] = ((ImageView)findViewById(2131296515));
    this.f[1] = ((ImageView)findViewById(2131296516));
    this.f[2] = ((ImageView)findViewById(2131296517));
  }

  protected void setContentView()
  {
    setContentView(2130903085);
  }

  class a
    implements ViewPager.OnPageChangeListener, View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296513:
        g.b(GuideActivity.d(GuideActivity.this), "login");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("flag", "0");
        GuideActivity.this.startNewActivity(LoginActivity.class, true, localBundle2);
        return;
      case 2131296514:
      }
      g.b(GuideActivity.d(GuideActivity.this), "register");
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("flag", "1");
      GuideActivity.this.startNewActivity(LoginActivity.class, true, localBundle1);
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case 1:
        GuideActivity.a(GuideActivity.this, false);
        return;
      case 2:
        GuideActivity.a(GuideActivity.this, true);
        return;
      case 0:
      }
      if ((GuideActivity.a(GuideActivity.this).getCurrentItem() == -1 + GuideActivity.a(GuideActivity.this).getAdapter().getCount()) && (!GuideActivity.b(GuideActivity.this)))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("flag", "0");
        GuideActivity.this.startNewActivity(LoginActivity.class, true, localBundle);
      }
      GuideActivity.a(GuideActivity.this, true);
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
      GuideActivity.a(GuideActivity.this, paramInt);
      GuideActivity.c(GuideActivity.this);
    }
  }

  class b extends PagerAdapter
  {
    b()
    {
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)GuideActivity.e(GuideActivity.this).get(paramInt));
    }

    public int getCount()
    {
      return GuideActivity.e(GuideActivity.this).size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = (View)GuideActivity.e(GuideActivity.this).get(paramInt);
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      if (localViewGroup != null)
        localViewGroup.removeAllViews();
      paramViewGroup.addView(localView);
      return localView;
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.GuideActivity
 * JD-Core Version:    0.6.0
 */