package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Poi$1
  implements Parcelable.Creator
{
  public Poi a(Parcel paramParcel)
  {
    return new Poi(paramParcel.readString(), paramParcel.readString(), paramParcel.readDouble());
  }

  public Poi[] a(int paramInt)
  {
    return new Poi[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.Poi.1
 * JD-Core Version:    0.6.0
 */