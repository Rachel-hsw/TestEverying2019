package com.gensee.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class ChatViewPageAdapter extends PagerAdapter
{
  private List<View> mListViews;

  public ChatViewPageAdapter(List<View> paramList)
  {
    this.mListViews = paramList;
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.mListViews.get(paramInt % this.mListViews.size()));
  }

  public int getCount()
  {
    return 1;
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    try
    {
      ((ViewPager)paramViewGroup).addView((View)this.mListViews.get(paramInt % this.mListViews.size()), 0);
      label31: return this.mListViews.get(paramInt % this.mListViews.size());
    }
    catch (Exception localException)
    {
      break label31;
    }
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.adapter.ChatViewPageAdapter
 * JD-Core Version:    0.6.0
 */