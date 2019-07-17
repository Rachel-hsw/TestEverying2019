package com.withustudy.koudaizikao.custom;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class j extends PagerAdapter
{
  private static final String a = "FragmentPagerAdapter";
  private static final boolean b = true;
  private final FragmentManager c;
  private a d;

  public j(FragmentManager paramFragmentManager)
  {
    this.c = paramFragmentManager;
  }

  private static String a(int paramInt1, int paramInt2)
  {
    return "android:switcher:" + paramInt1 + ":" + paramInt2;
  }

  public abstract Fragment a(int paramInt);

  public void a(a parama)
  {
    this.d = parama;
  }

  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }

  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    Fragment localFragment = a(paramInt);
    if (!localFragment.isAdded())
    {
      FragmentTransaction localFragmentTransaction = this.c.beginTransaction();
      localFragmentTransaction.add(localFragment, localFragment.getClass().getName());
      localFragmentTransaction.commitAllowingStateLoss();
      this.c.executePendingTransactions();
    }
    if (localFragment.getView().getParent() == null)
    {
      if (this.d != null)
        this.d.a(paramInt);
      paramViewGroup.addView(localFragment.getView());
    }
    return localFragment.getView();
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
  }

  public Parcelable saveState()
  {
    return null;
  }

  public void startUpdate(ViewGroup paramViewGroup)
  {
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.j
 * JD-Core Version:    0.6.0
 */