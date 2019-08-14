package com.withustudy.koudaizikao.custom;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class d
  implements Parcelable.Creator<AbstractSlideExpandableListAdapter.SavedState>
{
  public AbstractSlideExpandableListAdapter.SavedState a(Parcel paramParcel)
  {
    return new AbstractSlideExpandableListAdapter.SavedState(paramParcel, null);
  }

  public AbstractSlideExpandableListAdapter.SavedState[] a(int paramInt)
  {
    return new AbstractSlideExpandableListAdapter.SavedState[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.d
 * JD-Core Version:    0.6.0
 */