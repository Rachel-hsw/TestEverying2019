package com.withustudy.koudaizikao.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.umeng.a.g;
import com.withustudy.koudaizikao.base.AbsBaseFragment;
import com.withustudy.koudaizikao.entity.New_course_ids;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoMainFragment extends AbsBaseFragment
{
  public ImageView a;
  private Button b;
  private Button c;
  private Button d;
  private VideoAllFragment e;
  private VideoMineFragment f;
  private ViedeoChongCiFragment g;
  private a h;
  private b i;
  private int j = 0;
  private List<New_course_ids> k;

  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.b.setTextColor(Color.parseColor("#00b8e5"));
      this.b.setBackgroundResource(2130837742);
      this.c.setTextColor(Color.parseColor("#ffffff"));
      this.c.setBackgroundResource(2130837743);
      this.d.setTextColor(Color.parseColor("#ffffff"));
      this.d.setBackgroundResource(2130837731);
      return;
    }
    if (paramInt == 2)
    {
      this.d.setTextColor(Color.parseColor("#00b8e5"));
      this.d.setBackgroundResource(2130837732);
      this.c.setTextColor(Color.parseColor("#ffffff"));
      this.c.setBackgroundResource(2130837743);
      this.b.setTextColor(Color.parseColor("#ffffff"));
      this.b.setBackgroundResource(2130837741);
      return;
    }
    this.c.setTextColor(Color.parseColor("#00b8e5"));
    this.c.setBackgroundResource(2130837744);
    this.d.setTextColor(Color.parseColor("#ffffff"));
    this.d.setBackgroundResource(2130837731);
    this.b.setTextColor(Color.parseColor("#ffffff"));
    this.b.setBackgroundResource(2130837741);
  }

  private void b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.A.beginTransaction();
    if (this.e != null)
      localFragmentTransaction.hide(this.e);
    if (this.f != null)
      localFragmentTransaction.hide(this.f);
    if (this.g != null)
      localFragmentTransaction.hide(this.g);
    if (paramInt == 0)
    {
      if (this.e == null)
      {
        this.e = new VideoAllFragment();
        localFragmentTransaction.add(2131296955, this.e);
      }
      this.e.a(this.k);
      localFragmentTransaction.show(this.e);
    }
    while (true)
    {
      localFragmentTransaction.commit();
      return;
      if (paramInt == 2)
      {
        if (this.g == null)
        {
          this.g = new ViedeoChongCiFragment();
          localFragmentTransaction.add(2131296955, this.g);
        }
        this.g.a(this.k);
        localFragmentTransaction.show(this.g);
        continue;
      }
      if (this.f == null)
      {
        this.f = new VideoMineFragment();
        localFragmentTransaction.add(2131296955, this.f);
      }
      localFragmentTransaction.show(this.f);
    }
  }

  private void d()
  {
    this.i = new b();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.koudai.poll_new_course");
    this.y.registerReceiver(this.i, localIntentFilter);
  }

  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903153, null);
  }

  public void a()
  {
    this.h = new a();
    d();
  }

  public void a(View paramView)
  {
    this.b = ((Button)paramView.findViewById(2131296951));
    this.c = ((Button)paramView.findViewById(2131296954));
    this.d = ((Button)paramView.findViewById(2131296952));
    this.a = ((ImageView)paramView.findViewById(2131296953));
    this.a.setVisibility(8);
  }

  public void a(List<New_course_ids> paramList)
  {
    this.k = paramList;
  }

  public void b()
  {
    b(0);
  }

  public void c()
  {
    this.b.setOnClickListener(this.h);
    this.c.setOnClickListener(this.h);
    this.d.setOnClickListener(this.h);
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.i != null)
    {
      this.y.unregisterReceiver(this.i);
      this.i = null;
    }
  }

  public void onResume()
  {
    super.onResume();
    if ((this.k != null) && (this.k.size() > 0))
    {
      Iterator localIterator = this.k.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        if (((New_course_ids)localIterator.next()).getIs_chuanjiang() == 1)
        {
          this.a.setVisibility(0);
          return;
        }
        this.a.setVisibility(8);
      }
    }
    this.a.setVisibility(8);
  }

  class a
    implements View.OnClickListener
  {
    a()
    {
    }

    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      case 2131296953:
      default:
        return;
      case 2131296952:
        g.b(VideoMainFragment.d(VideoMainFragment.this), "course_all");
        VideoMainFragment.a(VideoMainFragment.this, 2);
        VideoMainFragment.b(VideoMainFragment.this, 2);
        VideoMainFragment.c(VideoMainFragment.this, 2);
        return;
      case 2131296951:
        g.b(VideoMainFragment.d(VideoMainFragment.this), "course_all");
        VideoMainFragment.a(VideoMainFragment.this, 0);
        VideoMainFragment.b(VideoMainFragment.this, 0);
        VideoMainFragment.c(VideoMainFragment.this, 0);
        return;
      case 2131296954:
      }
      g.b(VideoMainFragment.d(VideoMainFragment.this), "course_mine");
      VideoMainFragment.a(VideoMainFragment.this, 1);
      VideoMainFragment.b(VideoMainFragment.this, 1);
      VideoMainFragment.c(VideoMainFragment.this, 1);
    }
  }

  class b extends BroadcastReceiver
  {
    b()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      Bundle localBundle = paramIntent.getExtras();
      ArrayList localArrayList;
      if ((localBundle != null) && (localBundle.getSerializable("new_course_ids") != null))
      {
        localArrayList = (ArrayList)localBundle.getSerializable("new_course_ids");
        if ((localArrayList != null) && (localArrayList.size() > 0))
          VideoMainFragment.a(VideoMainFragment.this, localArrayList);
      }
      switch (VideoMainFragment.a(VideoMainFragment.this))
      {
      default:
      case 0:
        do
          return;
        while (VideoMainFragment.b(VideoMainFragment.this) == null);
        VideoMainFragment.b(VideoMainFragment.this).a(localArrayList);
        return;
      case 1:
        VideoMainFragment.this.a.setVisibility(0);
        return;
      case 2:
      }
      if (VideoMainFragment.c(VideoMainFragment.this) != null)
        VideoMainFragment.c(VideoMainFragment.this).a(localArrayList);
      VideoMainFragment.this.a.setVisibility(0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.VideoMainFragment
 * JD-Core Version:    0.6.0
 */