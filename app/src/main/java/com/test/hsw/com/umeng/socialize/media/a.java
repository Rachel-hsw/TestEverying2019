package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<DoubanShareContent>
{
  public DoubanShareContent a(Parcel paramParcel)
  {
    return new DoubanShareContent(paramParcel);
  }

  public DoubanShareContent[] a(int paramInt)
  {
    return new DoubanShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.a
 * JD-Core Version:    0.6.0
 */