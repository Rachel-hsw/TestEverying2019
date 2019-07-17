package com.handmark.pulltorefresh.library.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.b;
import com.handmark.pulltorefresh.library.PullToRefreshBase.h;
import com.handmark.pulltorefresh.library.a;
import com.handmark.pulltorefresh.library.j.e;
import com.handmark.pulltorefresh.library.j.f;
import com.handmark.pulltorefresh.library.j.g;
import com.handmark.pulltorefresh.library.j.h;

@SuppressLint({"ViewConstructor"})
public abstract class d extends FrameLayout
  implements a
{
  static final String b = "PullToRefresh-LoadingLayout";
  static final Interpolator c = new LinearInterpolator();
  private FrameLayout a;
  protected final ImageView d;
  protected final ProgressBar e;
  protected final PullToRefreshBase.b f;
  protected final PullToRefreshBase.h g;
  private boolean h;
  private final TextView i;
  private final TextView j;
  private CharSequence k;
  private CharSequence l;
  private CharSequence m;

  public d(Context paramContext, PullToRefreshBase.b paramb, PullToRefreshBase.h paramh, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.f = paramb;
    this.g = paramh;
    FrameLayout.LayoutParams localLayoutParams;
    int i2;
    label183: Drawable localDrawable1;
    switch (l()[paramh.ordinal()])
    {
    default:
      LayoutInflater.from(paramContext).inflate(j.f.pull_to_refresh_header_vertical, this);
      this.a = ((FrameLayout)findViewById(j.e.fl_inner));
      this.i = ((TextView)this.a.findViewById(j.e.pull_to_refresh_text));
      this.e = ((ProgressBar)this.a.findViewById(j.e.pull_to_refresh_progress));
      this.j = ((TextView)this.a.findViewById(j.e.pull_to_refresh_sub_text));
      this.d = ((ImageView)this.a.findViewById(j.e.pull_to_refresh_image));
      localLayoutParams = (FrameLayout.LayoutParams)this.a.getLayoutParams();
      switch (m()[paramb.ordinal()])
      {
      default:
        if (paramh == PullToRefreshBase.h.a)
        {
          i2 = 80;
          localLayoutParams.gravity = i2;
          this.k = paramContext.getString(j.g.pull_to_refresh_pull_label);
          this.l = paramContext.getString(j.g.pull_to_refresh_refreshing_label);
          this.m = paramContext.getString(j.g.pull_to_refresh_release_label);
          if (paramTypedArray.hasValue(j.h.PullToRefresh_ptrHeaderBackground))
          {
            Drawable localDrawable2 = paramTypedArray.getDrawable(j.h.PullToRefresh_ptrHeaderBackground);
            if (localDrawable2 != null)
              g.a(this, localDrawable2);
          }
          if (paramTypedArray.hasValue(j.h.PullToRefresh_ptrHeaderTextAppearance))
          {
            TypedValue localTypedValue1 = new TypedValue();
            paramTypedArray.getValue(j.h.PullToRefresh_ptrHeaderTextAppearance, localTypedValue1);
            setTextAppearance(localTypedValue1.data);
          }
          if (paramTypedArray.hasValue(j.h.PullToRefresh_ptrSubHeaderTextAppearance))
          {
            TypedValue localTypedValue2 = new TypedValue();
            paramTypedArray.getValue(j.h.PullToRefresh_ptrSubHeaderTextAppearance, localTypedValue2);
            setSubTextAppearance(localTypedValue2.data);
          }
          if (paramTypedArray.hasValue(j.h.PullToRefresh_ptrHeaderTextColor))
          {
            ColorStateList localColorStateList2 = paramTypedArray.getColorStateList(j.h.PullToRefresh_ptrHeaderTextColor);
            if (localColorStateList2 != null)
              setTextColor(localColorStateList2);
          }
          if (paramTypedArray.hasValue(j.h.PullToRefresh_ptrHeaderSubTextColor))
          {
            ColorStateList localColorStateList1 = paramTypedArray.getColorStateList(j.h.PullToRefresh_ptrHeaderSubTextColor);
            if (localColorStateList1 != null)
              setSubTextColor(localColorStateList1);
          }
          boolean bool = paramTypedArray.hasValue(j.h.PullToRefresh_ptrDrawable);
          localDrawable1 = null;
          if (bool)
            localDrawable1 = paramTypedArray.getDrawable(j.h.PullToRefresh_ptrDrawable);
          switch (m()[paramb.ordinal()])
          {
          default:
            if (paramTypedArray.hasValue(j.h.PullToRefresh_ptrDrawableStart))
              localDrawable1 = paramTypedArray.getDrawable(j.h.PullToRefresh_ptrDrawableStart);
          case 3:
          }
        }
      case 3:
      }
    case 2:
    }
    while (true)
    {
      if (localDrawable1 == null)
        localDrawable1 = paramContext.getResources().getDrawable(getDefaultDrawableResId());
      setLoadingDrawable(localDrawable1);
      j();
      return;
      LayoutInflater.from(paramContext).inflate(j.f.pull_to_refresh_header_horizontal, this);
      break;
      if (paramh == PullToRefreshBase.h.a);
      for (int i1 = 48; ; i1 = 3)
      {
        localLayoutParams.gravity = i1;
        this.k = paramContext.getString(j.g.pull_to_refresh_from_bottom_pull_label);
        this.l = paramContext.getString(j.g.pull_to_refresh_from_bottom_refreshing_label);
        this.m = paramContext.getString(j.g.pull_to_refresh_from_bottom_release_label);
        break;
      }
      i2 = 5;
      break label183;
      if (!paramTypedArray.hasValue(j.h.PullToRefresh_ptrDrawableTop))
        continue;
      f.a("ptrDrawableTop", "ptrDrawableStart");
      localDrawable1 = paramTypedArray.getDrawable(j.h.PullToRefresh_ptrDrawableTop);
      continue;
      if (paramTypedArray.hasValue(j.h.PullToRefresh_ptrDrawableEnd))
      {
        localDrawable1 = paramTypedArray.getDrawable(j.h.PullToRefresh_ptrDrawableEnd);
        continue;
      }
      if (!paramTypedArray.hasValue(j.h.PullToRefresh_ptrDrawableBottom))
        continue;
      f.a("ptrDrawableBottom", "ptrDrawableEnd");
      localDrawable1 = paramTypedArray.getDrawable(j.h.PullToRefresh_ptrDrawableBottom);
    }
  }

  private void setSubHeaderText(CharSequence paramCharSequence)
  {
    if (this.j != null)
    {
      if (!TextUtils.isEmpty(paramCharSequence))
        break label24;
      this.j.setVisibility(8);
    }
    label24: 
    do
    {
      return;
      this.j.setText(paramCharSequence);
    }
    while (8 != this.j.getVisibility());
    this.j.setVisibility(0);
  }

  private void setSubTextAppearance(int paramInt)
  {
    if (this.j != null)
      this.j.setTextAppearance(getContext(), paramInt);
  }

  private void setSubTextColor(ColorStateList paramColorStateList)
  {
    if (this.j != null)
      this.j.setTextColor(paramColorStateList);
  }

  private void setTextAppearance(int paramInt)
  {
    if (this.i != null)
      this.i.setTextAppearance(getContext(), paramInt);
    if (this.j != null)
      this.j.setTextAppearance(getContext(), paramInt);
  }

  private void setTextColor(ColorStateList paramColorStateList)
  {
    if (this.i != null)
      this.i.setTextColor(paramColorStateList);
    if (this.j != null)
      this.j.setTextColor(paramColorStateList);
  }

  protected abstract void a();

  protected abstract void a(float paramFloat);

  protected abstract void a(Drawable paramDrawable);

  protected abstract void b();

  public final void b(float paramFloat)
  {
    if (!this.h)
      a(paramFloat);
  }

  protected abstract void c();

  protected abstract void d();

  public final void f()
  {
    if (this.i.getVisibility() == 0)
      this.i.setVisibility(4);
    if (this.e.getVisibility() == 0)
      this.e.setVisibility(4);
    if (this.d.getVisibility() == 0)
      this.d.setVisibility(4);
    if (this.j.getVisibility() == 0)
      this.j.setVisibility(4);
  }

  public final void g()
  {
    if (this.i != null)
      this.i.setText(this.k);
    a();
  }

  public final int getContentSize()
  {
    switch (l()[this.g.ordinal()])
    {
    default:
      return this.a.getHeight();
    case 2:
    }
    return this.a.getWidth();
  }

  protected abstract int getDefaultDrawableResId();

  public final void h()
  {
    if (this.i != null)
      this.i.setText(this.l);
    if (this.h)
      ((AnimationDrawable)this.d.getDrawable()).start();
    while (true)
    {
      if (this.j != null)
        this.j.setVisibility(8);
      return;
      b();
    }
  }

  public final void i()
  {
    if (this.i != null)
      this.i.setText(this.m);
    c();
  }

  public final void j()
  {
    if (this.i != null)
      this.i.setText(this.k);
    this.d.setVisibility(0);
    if (this.h)
      ((AnimationDrawable)this.d.getDrawable()).stop();
    while (true)
    {
      if (this.j != null)
      {
        if (!TextUtils.isEmpty(this.j.getText()))
          break;
        this.j.setVisibility(8);
      }
      return;
      d();
    }
    this.j.setVisibility(0);
  }

  public final void k()
  {
    if (4 == this.i.getVisibility())
      this.i.setVisibility(0);
    if (4 == this.e.getVisibility())
      this.e.setVisibility(0);
    if (4 == this.d.getVisibility())
      this.d.setVisibility(0);
    if (4 == this.j.getVisibility())
      this.j.setVisibility(0);
  }

  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }

  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    setSubHeaderText(paramCharSequence);
  }

  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.d.setImageDrawable(paramDrawable);
    this.h = (paramDrawable instanceof AnimationDrawable);
    a(paramDrawable);
  }

  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.k = paramCharSequence;
  }

  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
  }

  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
  }

  public void setTextTypeface(Typeface paramTypeface)
  {
    this.i.setTypeface(paramTypeface);
  }

  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.a.d
 * JD-Core Version:    0.6.0
 */