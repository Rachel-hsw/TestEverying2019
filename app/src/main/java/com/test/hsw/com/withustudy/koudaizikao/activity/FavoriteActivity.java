package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.fragment.FavoriteNewsFragment;
import com.withustudy.koudaizikao.fragment.FavoritePostFragment;

public class FavoriteActivity extends AbsBaseActivity
{
  private Button a;
  private Button[] b;
  private ImageView[] c;
  private FavoriteNewsFragment d;
  private FavoritePostFragment e;
  private ViewPager f;
  private b g;
  private a h;

  private void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 1))
      return;
    int i = 0;
    label12: if (i < 2)
    {
      if (i != paramInt)
        break label53;
      this.b[i].setTextColor(Color.parseColor("#00B8E5"));
      this.c[i].setBackgroundResource(2131034212);
    }
    while (true)
    {
      i++;
      break label12;
      break;
      label53: this.b[i].setTextColor(Color.parseColor("#999999"));
      this.c[i].setBackgroundColor(Color.parseColor("#ffffff"));
    }
  }

  private void a(FragmentTransaction paramFragmentTransaction)
  {
    if (this.d != null)
      paramFragmentTransaction.hide(this.d);
    if (this.e != null)
      paramFragmentTransaction.hide(this.e);
  }

  protected void bindData()
  {
    this.f.setAdapter(this.g);
    a(0);
  }

  protected void initData()
  {
    this.h = new a();
    this.d = new FavoriteNewsFragment();
    this.e = new FavoritePostFragment();
    this.g = new b(getSupportFragmentManager(), this.d, this.e);
  }

  protected void initListener()
  {
    for (int i = 0; ; i++)
    {
      if (i >= 2)
      {
        this.a.setOnClickListener(this.h);
        this.f.setOnPageChangeListener(this.h);
        return;
      }
      this.b[i].setOnClickListener(this.h);
    }
  }

  protected void initView()
  {
    this.a = ((Button)findViewById(2131296505));
    this.b = new Button[2];
    this.b[0] = ((Button)findViewById(2131296506));
    this.b[1] = ((Button)findViewById(2131296507));
    this.c = new ImageView[2];
    this.c[0] = ((ImageView)findViewById(2131296508));
    this.c[1] = ((ImageView)findViewById(2131296509));
    this.f = ((ViewPager)findViewById(2131296510));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 20)
    {
      String str = paramIntent.getStringExtra("result");
      this.d.a(str, paramInt2);
    }
  }

  protected void setContentView()
  {
    setContentView(2130903084);
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
      case 2131296505:
        FavoriteActivity.this.finish();
        return;
      case 2131296506:
        FavoriteActivity.a(FavoriteActivity.this, 0);
        FavoriteActivity.a(FavoriteActivity.this).setCurrentItem(0);
        return;
      case 2131296507:
      }
      FavoriteActivity.a(FavoriteActivity.this, 1);
      FavoriteActivity.a(FavoriteActivity.this).setCurrentItem(1);
    }

    public void onPageScrollStateChanged(int paramInt)
    {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
      FavoriteActivity.a(FavoriteActivity.this, paramInt);
    }
  }

  public class b extends FragmentPagerAdapter
  {
    private FavoriteNewsFragment b;
    private FavoritePostFragment c;

    public b(FragmentManager paramFavoriteNewsFragment, FavoriteNewsFragment paramFavoritePostFragment, FavoritePostFragment arg4)
    {
      super();
      this.b = paramFavoritePostFragment;
      Object localObject;
      this.c = localObject;
    }

    public int getCount()
    {
      return 2;
    }

    public Fragment getItem(int paramInt)
    {
      if (paramInt == 0)
        return this.b;
      if (paramInt == 1)
        return this.c;
      return null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.FavoriteActivity
 * JD-Core Version:    0.6.0
 */