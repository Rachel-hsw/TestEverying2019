package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class d
  implements Parcelable.Creator<QZoneShareContent>
{
  public QZoneShareContent a(Parcel paramParcel)
  {
    return new QZoneShareContent(paramParcel);
  }

  public QZoneShareContent[] a(int paramInt)
  {
    return new QZoneShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.d
 * JD-Core Version:    0.6.0
 */