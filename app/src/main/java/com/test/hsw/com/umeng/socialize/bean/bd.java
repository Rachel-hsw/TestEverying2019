package com.umeng.socialize.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bd
  implements Parcelable.Creator<UMLocation>
{
  public UMLocation a(Parcel paramParcel)
  {
    return new UMLocation(paramParcel, null);
  }

  public UMLocation[] a(int paramInt)
  {
    return new UMLocation[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.bd
 * JD-Core Version:    0.6.0
 */