package com.withustudy.koudaizikao.custom;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import java.util.BitSet;

public abstract class AbstractSlideExpandableListAdapter extends s
{
  private View a = null;
  private int c = -1;
  private int d = 330;
  private BitSet e = new BitSet();
  private final SparseIntArray f = new SparseIntArray(10);
  private ViewGroup g;
  private a h;

  public AbstractSlideExpandableListAdapter(ListAdapter paramListAdapter)
  {
    super(paramListAdapter);
  }

  private void a(int paramInt1, View paramView, int paramInt2)
  {
    if (this.h != null)
    {
      if (paramInt1 != 0)
        break label23;
      this.h.a(paramView, paramInt2);
    }
    label23: 
    do
      return;
    while (paramInt1 != 1);
    this.h.b(paramView, paramInt2);
  }

  private void a(View paramView1, View paramView2, int paramInt)
  {
    if ((paramView2 == this.a) && (paramInt != this.c))
      this.a = null;
    if (paramInt == this.c)
      this.a = paramView2;
    if (this.f.get(paramInt, -1) == -1)
    {
      this.f.put(paramInt, paramView2.getMeasuredHeight());
      b(paramView2, paramInt);
    }
    while (true)
    {
      paramView1.setOnClickListener(new a(this, paramView2, paramInt));
      return;
      b(paramView2, paramInt);
    }
  }

  private static BitSet b(Parcel paramParcel)
  {
    BitSet localBitSet = new BitSet();
    if (paramParcel == null);
    while (true)
    {
      return localBitSet;
      int i = paramParcel.readInt();
      for (int j = 0; j < i; j++)
        localBitSet.set(paramParcel.readInt());
    }
  }

  private static void b(Parcel paramParcel, BitSet paramBitSet)
  {
    if ((paramParcel == null) || (paramBitSet == null))
      return;
    paramParcel.writeInt(paramBitSet.cardinality());
    int i = -1;
    while (true)
    {
      i = paramBitSet.nextSetBit(i + 1);
      if (i == -1)
        break;
      paramParcel.writeInt(i);
    }
  }

  private void b(View paramView, int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    if (this.e.get(paramInt))
    {
      paramView.setVisibility(0);
      localLayoutParams.bottomMargin = 0;
      return;
    }
    paramView.setVisibility(8);
    localLayoutParams.bottomMargin = (0 - this.f.get(paramInt));
  }

  private void c(View paramView, int paramInt)
  {
    i locali = new i(paramView, paramInt);
    locali.setDuration(b());
    locali.setAnimationListener(new c(this, paramInt, paramView));
    paramView.startAnimation(locali);
  }

  public Parcelable a(Parcelable paramParcelable)
  {
    SavedState localSavedState = new SavedState(paramParcelable);
    localSavedState.b = this.c;
    localSavedState.a = this.e;
    return localSavedState;
  }

  public abstract View a(View paramView);

  public void a()
  {
    this.h = null;
  }

  public void a(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Duration is less than zero");
    this.d = paramInt;
  }

  public void a(View paramView, int paramInt)
  {
    View localView1 = a(paramView);
    View localView2 = b(paramView);
    localView2.measure(paramView.getWidth(), paramView.getHeight());
    a(localView1, localView2, paramInt);
    localView2.requestLayout();
  }

  public void a(SavedState paramSavedState)
  {
    if (paramSavedState != null)
    {
      this.c = paramSavedState.b;
      this.e = paramSavedState.a;
    }
  }

  public void a(a parama)
  {
    this.h = parama;
  }

  public int b()
  {
    return this.d;
  }

  public abstract View b(View paramView);

  public boolean c()
  {
    return this.c != -1;
  }

  public boolean d()
  {
    if (c())
    {
      if (this.a != null)
        c(this.a, 1);
      this.e.set(this.c, false);
      this.c = -1;
      return true;
    }
    return false;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.g = paramViewGroup;
    View localView = this.b.getView(paramInt, paramView, paramViewGroup);
    a(localView, paramInt);
    return localView;
  }

  static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new d();
    public BitSet a = null;
    public int b = -1;

    private SavedState(Parcel paramParcel)
    {
      super();
      this.b = paramParcel.readInt();
      this.a = AbstractSlideExpandableListAdapter.a(paramParcel);
    }

    SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.b);
      AbstractSlideExpandableListAdapter.a(paramParcel, this.a);
    }
  }

  public static abstract interface a
  {
    public abstract void a(View paramView, int paramInt);

    public abstract void b(View paramView, int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.AbstractSlideExpandableListAdapter
 * JD-Core Version:    0.6.0
 */