package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class h
  implements Parcelable.Creator<TwitterShareContent>
{
  public TwitterShareContent a(Parcel paramParcel)
  {
    return new TwitterShareContent(paramParcel);
  }

  public TwitterShareContent[] a(int paramInt)
  {
    return new TwitterShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.h
 * JD-Core Version:    0.6.0
 */