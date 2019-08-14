package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class g
  implements Parcelable.Creator<TencentWbShareContent>
{
  public TencentWbShareContent a(Parcel paramParcel)
  {
    return new TencentWbShareContent(paramParcel);
  }

  public TencentWbShareContent[] a(int paramInt)
  {
    return new TencentWbShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.g
 * JD-Core Version:    0.6.0
 */