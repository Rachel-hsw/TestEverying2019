package com.koudai.test;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.withustudy.koudaizikao.entity.Exercises;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l extends PagerAdapter
{
  private static final String a = "FragmentStatePagerAdapter";
  private static final boolean b;
  private final FragmentManager c;
  private FragmentTransaction d = null;
  private ArrayList<Fragment.SavedState> e = new ArrayList();
  private ArrayList<Fragment> f = new ArrayList();
  private Fragment g = null;
  private ArrayList<Exercises> h;

  public l(FragmentManager paramFragmentManager, ArrayList<Exercises> paramArrayList)
  {
    this.c = paramFragmentManager;
    this.h = paramArrayList;
  }

  public Fragment a(int paramInt)
  {
    return BrushExcerciseDetailFragment.a(paramInt);
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    try
    {
      Fragment localFragment = (Fragment)paramObject;
      if (this.d == null)
        this.d = this.c.beginTransaction();
      while (true)
      {
        if (this.e.size() > paramInt)
        {
          if (this.c.getFragments().contains(localFragment))
            this.e.set(paramInt, this.c.saveFragmentInstanceState(localFragment));
          this.f.set(paramInt, null);
          this.d.remove(localFragment);
          return;
        }
        this.e.add(null);
      }
    }
    catch (Exception localException)
    {
    }
  }

  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.d != null)
    {
      this.d.commitAllowingStateLoss();
      this.d = null;
      this.c.executePendingTransactions();
    }
  }

  public int getCount()
  {
    if (this.h == null)
      return 0;
    return this.h.size();
  }

  public int getItemPosition(Object paramObject)
  {
    return -2;
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    try
    {
      if (this.f.size() > paramInt)
      {
        Fragment localFragment2 = (Fragment)this.f.get(paramInt);
        if (localFragment2 != null)
          return localFragment2;
      }
      if (this.d == null)
        this.d = this.c.beginTransaction();
      Fragment localFragment1 = a(paramInt);
      if (this.e.size() > paramInt)
      {
        Fragment.SavedState localSavedState = (Fragment.SavedState)this.e.get(paramInt);
        if (localSavedState != null)
          localFragment1.setInitialSavedState(localSavedState);
      }
      while (true)
      {
        if (this.f.size() > paramInt)
        {
          localFragment1.setMenuVisibility(false);
          localFragment1.setUserVisibleHint(false);
          this.f.set(paramInt, localFragment1);
          this.d.add(paramView.getId(), localFragment1);
          Bundle localBundle = new Bundle();
          localBundle.putInt("position", paramInt);
          localBundle.putSerializable("exercises", (Exercises)this.h.get(paramInt));
          localFragment1.setArguments(localBundle);
          return localFragment1;
        }
        this.f.add(null);
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }

  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    Bundle localBundle;
    Parcelable[] arrayOfParcelable;
    int j;
    Iterator localIterator;
    if (paramParcelable != null)
    {
      localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      arrayOfParcelable = localBundle.getParcelableArray("states");
      this.e.clear();
      this.f.clear();
      if (arrayOfParcelable != null)
      {
        j = 0;
        if (j < arrayOfParcelable.length)
          break label74;
      }
      localIterator = localBundle.keySet().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        return;
        label74: this.e.add((Fragment.SavedState)arrayOfParcelable[j]);
        j++;
        break;
      }
      String str = (String)localIterator.next();
      if (!str.startsWith("f"))
        continue;
      int i = Integer.parseInt(str.substring(1));
      Fragment localFragment = this.c.getFragment(localBundle, str);
      if (localFragment != null)
        while (true)
        {
          if (this.f.size() > i)
          {
            localFragment.setMenuVisibility(false);
            this.f.set(i, localFragment);
            break;
          }
          this.f.add(null);
        }
      Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
    }
  }

  public Parcelable saveState()
  {
    int i = this.e.size();
    Bundle localBundle1 = null;
    if (i > 0)
    {
      localBundle1 = new Bundle();
      Fragment.SavedState[] arrayOfSavedState = new Fragment.SavedState[this.e.size()];
      this.e.toArray(arrayOfSavedState);
      localBundle1.putParcelableArray("states", arrayOfSavedState);
    }
    int j = 0;
    Bundle localBundle2 = localBundle1;
    while (true)
    {
      if (j >= this.f.size())
        return localBundle2;
      Fragment localFragment = (Fragment)this.f.get(j);
      if (localFragment != null)
      {
        if (localBundle2 == null)
          localBundle2 = new Bundle();
        String str = "f" + j;
        this.c.putFragment(localBundle2, str, localFragment);
      }
      j++;
    }
  }

  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (localFragment != this.g)
    {
      if (this.g != null)
      {
        this.g.setMenuVisibility(false);
        this.g.setUserVisibleHint(false);
      }
      if (localFragment != null)
      {
        localFragment.setMenuVisibility(true);
        localFragment.setUserVisibleHint(true);
      }
      this.g = localFragment;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.koudai.test.l
 * JD-Core Version:    0.6.0
 */