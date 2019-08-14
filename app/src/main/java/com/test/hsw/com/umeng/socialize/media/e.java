package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class e
  implements Parcelable.Creator<RenrenShareContent>
{
  public RenrenShareContent a(Parcel paramParcel)
  {
    return new RenrenShareContent(paramParcel);
  }

  public RenrenShareContent[] a(int paramInt)
  {
    return new RenrenShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.e
 * JD-Core Version:    0.6.0
 */