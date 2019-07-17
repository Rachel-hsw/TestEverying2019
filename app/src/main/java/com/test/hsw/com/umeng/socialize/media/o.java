package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class o
  implements Parcelable.Creator<UMVideo>
{
  public UMVideo a(Parcel paramParcel)
  {
    return new UMVideo(paramParcel);
  }

  public UMVideo[] a(int paramInt)
  {
    return new UMVideo[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.o
 * JD-Core Version:    0.6.0
 */