package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c
  implements Parcelable.Creator<QQShareContent>
{
  public QQShareContent a(Parcel paramParcel)
  {
    return new QQShareContent(paramParcel);
  }

  public QQShareContent[] a(int paramInt)
  {
    return new QQShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.c
 * JD-Core Version:    0.6.0
 */