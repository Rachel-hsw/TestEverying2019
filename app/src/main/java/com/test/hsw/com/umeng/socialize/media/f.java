package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class f
  implements Parcelable.Creator<SinaShareContent>
{
  public SinaShareContent a(Parcel paramParcel)
  {
    return new SinaShareContent(paramParcel);
  }

  public SinaShareContent[] a(int paramInt)
  {
    return new SinaShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.f
 * JD-Core Version:    0.6.0
 */