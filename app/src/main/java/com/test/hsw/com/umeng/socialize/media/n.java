package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class n
  implements Parcelable.Creator<UMImage>
{
  public UMImage a(Parcel paramParcel)
  {
    return new UMImage(paramParcel);
  }

  public UMImage[] a(int paramInt)
  {
    return new UMImage[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.n
 * JD-Core Version:    0.6.0
 */