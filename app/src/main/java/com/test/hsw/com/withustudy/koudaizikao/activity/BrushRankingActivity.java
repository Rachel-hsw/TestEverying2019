package com.withustudy.koudaizikao.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.b.e;
import com.withustudy.koudaizikao.base.AbsBaseActivity;
import com.withustudy.koudaizikao.fragment.BrushRankingFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrushRankingActivity extends AbsBaseActivity
{
  public static HashMap<Integer, String> a = new k();
  private static final int n = 1;
  public int b;
  public String c;
  public String d;
  public int e = 0;
  private Button f;
  private Button[] g;
  private ImageView[] h;
  private a i;
  private ViewPager j;
  private List<BrushRankingFragment> k = new ArrayList();
  private e l;
  private TextView m;

  private void a(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
      return;
    int i1 = 0;
    if (i1 >= 4);
    switch (paramInt)
    {
    default:
      return;
    case 0:
      if (this.b == 0)
      {
        g.b(this.mContext, "brush_rank_today");
        return;
        if (i1 == paramInt)
        {
          this.g[i1].setTextColor(getResources().getColor(2131034212));
          this.h[i1].setVisibility(0);
        }
        while (true)
        {
          i1++;
          break;
          this.g[i1].setTextColor(Color.parseColor("#666666"));
          this.h[i1].setVisibility(4);
        }
      }
      g.b(this.mContext, "test_rank_today");
      return;
    case 1:
      if (this.b == 0)
      {
        g.b(this.mContext, "brush_rank_week");
        return;
      }
      g.b(this.mContext, "test_rank_week");
      return;
    case 2:
      if (this.b == 0)
      {
        g.b(this.mContext, "brush_rank_month");
        return;
      }
      g.b(this.mContext, "test_rank_month");
      return;
    case 3:
    }
    if (this.b == 0)
    {
      g.b(this.mContext, "brush_rank_all\t");
      return;
    }
    g.b(this.mContext, "test_rank_all");
  }

  protected void bindData()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= 4)
      {
        this.l = new e(this.mFragmentManager, this.k);
        this.j.setAdapter(this.l);
        a(0);
        this.j.setCurrentItem(0);
        return;
      }
      BrushRankingFragment localBrushRankingFragment = new BrushRankingFragment();
      this.k.add(localBrushRankingFragment);
    }
  }

  protected void initData()
  {
    Bundle localBundle = getIntent().getExtras();
    try
    {
      this.b = localBundle.getInt("type");
      this.c = localBundle.getString("subjectId");
      this.d = localBundle.getString("subjectName");
      label38: this.i = new a();
      switch (this.b)
      {
      default:
        return;
      case 0:
        this.m.setText("刷题排行榜");
        return;
      case 1:
      }
      this.m.setText("模考排行榜");
      return;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }

  protected void initListener()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= 4)
      {
        this.j.setOnPageChangeListener(this.i);
        this.f.setOnClickListener(this.i);
        return;
      }
      this.g[i1].setOnClickListener(this.i);
    }
  }

  protected void initView()
  {
    this.m = ((TextView)findViewById(2131296426));
    this.f = ((Button)findViewById(2131296427));
    this.g = new Button[4];
    this.h = new ImageView[4];
    this.g[0] = ((Button)findViewById(2131296428));
    this.g[1] = ((Button)findViewById(2131296429));
    this.g[2] = ((Button)findViewById(2131296430));
    this.g[3] = ((Button)findViewById(2131296431));
    this.h[0] = ((ImageView)findViewById(2131296432));
    this.h[1] = ((ImageView)findViewById(2131296433));
    this.h[2] = ((ImageView)findViewById(2131296434));
    this.h[3] = ((ImageView)findViewById(2131296435));
    this.j = ((ViewPager)findViewById(2131296436));
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  protected void setContentView()
  {
    setContentView(2130903071);
  }

  public class a
    implements ViewPager.OnPageChangeListener, View.OnClickListener
  {
    public a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      default:
        return;
      case 2131296427:
        BrushRankingActivity.this.finish(2130968588, 2130968592);
        return;
      case 2131296428:
        BrushRankingActivity.a(BrushRankingActivity.this, 0);
        BrushRankingActivity.this.e = 0;
        BrushRankingActivity.a(BrushRankingActivity.this).setCurrentItem(0, true);
        return;
      case 2131296429:
        BrushRankingActivity.a(BrushRankingActivity.this, 1);
        BrushRankingActivity.this.e = 1;
        BrushRankingActivity.a(BrushRankingActivity.this).setCurrentItem(1, true);
        return;
      case 2131296430:
        BrushRankingActivity.a(BrushRankingActivity.this, 2);
        BrushRankingActivity.this.e = 2;
        BrushRankingActivity.a(BrushRankingActivity.this).setCurrentItem(2, true);
        return;
      case 2131296431:
      }
      BrushRankingActivity.a(BrushRankingActivity.this, 3);
      BrushRankingActivity.this.e = 3;
      BrushRankingActivity.a(BrushRankingActivity.this).setCurrentItem(3, true);
    }

    public void onPageScrollStateChanged(int paramInt)
    {
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
    }

    public void onPageSelected(int paramInt)
    {
      BrushRankingActivity.a(BrushRankingActivity.this).setCurrentItem(paramInt);
      BrushRankingActivity.a(BrushRankingActivity.this, paramInt);
      BrushRankingActivity.this.e = paramInt;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.activity.BrushRankingActivity
 * JD-Core Version:    0.6.0
 */