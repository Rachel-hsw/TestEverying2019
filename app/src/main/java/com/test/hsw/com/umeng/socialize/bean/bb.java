package com.umeng.socialize.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class bb
  implements Parcelable.Creator<UMComment>
{
  public UMComment a(Parcel paramParcel)
  {
    return new UMComment(paramParcel, null);
  }

  public UMComment[] a(int paramInt)
  {
    return new UMComment[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.bb
 * JD-Core Version:    0.6.0
 */