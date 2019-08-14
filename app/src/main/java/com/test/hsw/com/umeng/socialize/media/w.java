package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class w
  implements Parcelable.Creator<UMusic>
{
  public UMusic a(Parcel paramParcel)
  {
    return new UMusic(paramParcel);
  }

  public UMusic[] a(int paramInt)
  {
    return new UMusic[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.w
 * JD-Core Version:    0.6.0
 */