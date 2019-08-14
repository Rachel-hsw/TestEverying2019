package com.handmark.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.handmark.pulltorefresh.library.a.d;
import java.util.HashSet;
import java.util.Iterator;

public class c
  implements a
{
  private final HashSet<d> a = new HashSet();

  public void a(d paramd)
  {
    if (paramd != null)
      this.a.add(paramd);
  }

  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((d)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }

  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((d)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }

  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((d)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }

  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((d)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }

  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((d)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }

  public void setTextTypeface(Typeface paramTypeface)
  {
    Iterator localIterator = this.a.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((d)localIterator.next()).setTextTypeface(paramTypeface);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.c
 * JD-Core Version:    0.6.0
 */