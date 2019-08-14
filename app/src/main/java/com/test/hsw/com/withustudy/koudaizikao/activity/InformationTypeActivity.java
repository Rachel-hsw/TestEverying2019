package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.base.m;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.fragment.InformationTypeFragment;
import java.util.ArrayList;
import java.util.List;

public class InformationTypeActivity extends AbsBaseActivity
{
  public static b a;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 20;
  public static final int f = 21;
  public static final int g = 22;
  public static final int h = 23;
  public static final int i = 24;
  public static final int j = 25;
  private Button k;
  private HorizontalScrollView l;
  private TextView[] m;
  private ViewPager n;
  private c o;
  private List<InformationTypeFragment> p;
  private a q;
  private int r;

  private void a()
  {
    int i1 = 0;
    if (this.r == 0)
      this.l.scrollTo(0, 0);
    while (i1 >= 5)
    {
      return;
      int i2 = this.r;
      i1 = 0;
      if (i2 != 4)
        continue;
      this.l.scrollTo(this.mSP.y(), 0);
      i1 = 0;
    }
    if (i1 == this.r)
      this.m[i1].setTextColor(getResources().getColor(2131034212));
    while (true)
    {
      i1++;
      break;
      this.m[i1].setTextColor(Color.parseColor("#666666"));
    }
  }

  protected void bindData()
  {
    this.n.setAdapter(this.o);
    a();
    this.n.setCurrentItem(this.r);
    a.sendEmptyMessageDelayed(1, 500L);
  }

  protected void initData()
  {
    this.q = new a();
    a = new b(this);
    this.p = new ArrayList();
    int i1 = 0;
    if (i1 >= 5)
      switch (getIntent().getExtras().getInt("information_type"))
      {
      default:
      case 0:
      case 1:
      case 6:
      case 11:
      case 16:
      }
    while (true)
    {
      this.o = new c(getSupportFragmentManager(), this.p);
      return;
      InformationTypeFragment localInformationTypeFragment = new InformationTypeFragment(i1);
      this.p.add(localInformationTypeFragment);
      i1++;
      break;
      this.r = 0;
      continue;
      this.r = 1;
      continue;
      this.r = 2;
      continue;
      this.r = 3;
      continue;
      this.r = 4;
      a.sendEmptyMessageDelayed(2, 500L);
    }
  }

  protected void initListener()
  {
    this.k.setOnClickListener(this.q);
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= 5)
      {
        this.n.setOnPageChangeListener(this.q);
        return;
      }
      this.m[i1].setOnClickListener(this.q);
    }
  }

  protected void initView()
  {
    this.k = ((Button)findViewById(2131296546));
    this.m = new TextView[5];
    this.m[0] = ((TextView)findViewById(2131296548));
    this.m[1] = ((TextView)findViewById(2131296549));
    this.m[2] = ((TextView)findViewById(2131296550));
    this.m[3] = ((TextView)findViewById(2131296551));
    this.m[4] = ((TextView)findViewById(2131296552));
    this.l = ((HorizontalScrollView)findViewById(2131296547));
    this.n = ((ViewPager)findViewById(2131296553));
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str;
    if (paramInt1 == 20)
      str = paramIntent.getStringExtra("result");
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= this.p.size())
        return;
      ((InformationTypeFragment)this.p.get(i1)).a(str, paramInt2);
    }
  }

  protected void setContentView()
  {
    setContentView(2130903088);
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
      case 2131296547:
      default:
        return;
      case 2131296546:
        InformationTypeActivity.this.finish();
        return;
      case 2131296548:
        InformationTypeActivity.a(InformationTypeActivity.this, 0);
        InformationTypeActivity.e(InformationTypeActivity.this);
        InformationTypeActivity.f(InformationTypeActivity.this).setCurrentItem(InformationTypeActivity.b(InformationTypeActivity.this));
        return;
      case 2131296549:
        InformationTypeActivity.a(InformationTypeActivity.this, 1);
        InformationTypeActivity.e(InformationTypeActivity.this);
        InformationTypeActivity.f(InformationTypeActivity.this).setCurrentItem(InformationTypeActivity.b(InformationTypeActivity.this));
        return;
      case 2131296550:
        InformationTypeActivity.a(InformationTypeActivity.this, 2);
        InformationTypeActivity.e(InformationTypeActivity.this);
        InformationTypeActivity.f(InformationTypeActivity.this).setCurrentItem(InformationTypeActivity.b(InformationTypeActivity.this));
        return;
      case 2131296551:
        InformationTypeActivity.a(InformationTypeActivity.this, 3);
        InformationTypeActivity.e(InformationTypeActivity.this);
        InformationTypeActivity.f(InformationTypeActivity.this).setCurrentItem(InformationTypeActivity.b(InformationTypeActivity.this));
        return;
      case 2131296552:
      }
      InformationTypeActivity.a(InformationTypeActivity.this, 4);
      InformationTypeActivity.e(InformationTypeActivity.this);
      InformationTypeActivity.f(InformationTypeActivity.this).setCurrentItem(InformationTypeActivity.b(InformationTypeActivity.this));
    }

    public void onPageScrollStateChanged(int paramInt)
    {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
      ((InformationTypeFragment)InformationTypeActivity.a(InformationTypeActivity.this).get(paramInt)).d();
      InformationTypeActivity.a(InformationTypeActivity.this, paramInt);
      InformationTypeActivity.e(InformationTypeActivity.this);
    }
  }

  public static class b extends m<InformationTypeActivity>
  {
    public b(InformationTypeActivity paramInformationTypeActivity)
    {
      super();
    }

    protected void a(InformationTypeActivity paramInformationTypeActivity, Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        return;
        ((InformationTypeFragment)InformationTypeActivity.a(paramInformationTypeActivity).get(InformationTypeActivity.b(paramInformationTypeActivity))).d();
        return;
        InformationTypeActivity.c(paramInformationTypeActivity).scrollTo(InformationTypeActivity.d(paramInformationTypeActivity).y(), 0);
        return;
        for (int i = 0; i < InformationTypeActivity.a(paramInformationTypeActivity).size(); i++)
          ((InformationTypeFragment)InformationTypeActivity.a(paramInformationTypeActivity).get(i)).a((String)paramMessage.obj);
      }
    }
  }

  class c extends FragmentPagerAdapter
  {
    private List<InformationTypeFragment> b;

    public c(List<InformationTypeFragment> arg2)
    {
      super();
      Object localObject;
      this.b = localObject;
    }

    public int getCount()
    {
      return this.b.size();
    }

    public Fragment getItem(int paramInt)
    {
      return (Fragment)this.b.get(paramInt);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.InformationTypeActivity
 * JD-Core Version:    0.6.0
 */