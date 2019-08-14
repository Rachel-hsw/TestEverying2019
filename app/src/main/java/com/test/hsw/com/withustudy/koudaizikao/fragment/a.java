package com.withustudy.koudaizikao.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import com.withustudy.koudaizikao.custom.SlidingTabLayout;
import com.withustudy.koudaizikao.custom.j;
import com.withustudy.koudaizikao.d.f;
import com.withustudy.koudaizikao.entity.Carousel_list;
import com.withustudy.koudaizikao.entity.RspBrushBannerBean;
import com.withustudy.koudaizikao.entity.Subject;
import com.withustudy.koudaizikao.g.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import krelve.view.Kanner;

class a extends Handler
{
  a(BrushMainFragment paramBrushMainFragment)
  {
  }

  public void handleMessage(Message paramMessage)
  {
    int i = 0;
    switch (paramMessage.what)
    {
    default:
    case 17:
    case 100:
    }
    List localList;
    do
    {
      do
      {
        RspBrushBannerBean localRspBrushBannerBean;
        do
        {
          return;
          localRspBrushBannerBean = (RspBrushBannerBean)paramMessage.obj;
        }
        while ((localRspBrushBannerBean == null) || (!"true".equals(localRspBrushBannerBean.getResult())));
        BrushMainFragment.a(this.a, localRspBrushBannerBean.getCarousel_list());
      }
      while ((BrushMainFragment.a(this.a) == null) || (BrushMainFragment.a(this.a).size() <= 0));
      int k = BrushMainFragment.a(this.a).size();
      String[] arrayOfString = new String[k];
      while (true)
      {
        if (i >= k)
        {
          BrushMainFragment.b(this.a).setImagesUrl(arrayOfString);
          return;
        }
        arrayOfString[i] = ((Carousel_list)BrushMainFragment.a(this.a).get(i)).getImage_url();
        i++;
      }
      localList = BrushMainFragment.c(this.a);
    }
    while ((localList == null) || (localList.size() <= 0));
    this.a.e.clear();
    this.a.e.addAll(localList);
    if ((this.a.e != null) && (this.a.e.size() > 0))
    {
      if (this.a.a == null)
        this.a.a = new ArrayList();
      this.a.a.clear();
      this.a.b = new ArrayList();
      this.a.b.clear();
      Iterator localIterator = this.a.e.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          BrushMainFragment.d(this.a).setOffscreenPageLimit(1);
          h.a("BrushSubjectIndex", Integer.valueOf(BrushMainFragment.e(this.a).g()));
          BrushMainFragment.a(this.a, new b(this, this.a.getChildFragmentManager()));
          BrushMainFragment.f(this.a).a(this.a);
          BrushMainFragment.d(this.a).setAdapter(BrushMainFragment.f(this.a));
          BrushMainFragment.g(this.a).setViewPager(BrushMainFragment.d(this.a));
          int j = BrushMainFragment.e(this.a).g();
          this.a.d = j;
          BrushMainFragment.d(this.a).setCurrentItem(j);
          BrushMainFragment.g(this.a).setVisibility(0);
          BrushMainFragment.d(this.a).setVisibility(0);
          return;
        }
        String str = ((Subject)localIterator.next()).getName().replace("（", "(").replace("）", ")");
        this.a.a.add(str);
        SubjectFragment localSubjectFragment = new SubjectFragment();
        new Bundle();
        this.a.b.add(localSubjectFragment);
      }
    }
    h.a("科目列表为null");
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.fragment.a
 * JD-Core Version:    0.6.0
 */