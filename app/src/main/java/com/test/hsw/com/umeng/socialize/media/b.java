package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<GooglePlusShareContent>
{
  public GooglePlusShareContent a(Parcel paramParcel)
  {
    return new GooglePlusShareContent(paramParcel);
  }

  public GooglePlusShareContent[] a(int paramInt)
  {
    return new GooglePlusShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.b
 * JD-Core Version:    0.6.0
 */