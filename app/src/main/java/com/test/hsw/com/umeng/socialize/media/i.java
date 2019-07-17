package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class i
  implements Parcelable.Creator<UMEmoji>
{
  public UMEmoji a(Parcel paramParcel)
  {
    return new UMEmoji(paramParcel);
  }

  public UMEmoji[] a(int paramInt)
  {
    return new UMEmoji[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.i
 * JD-Core Version:    0.6.0
 */