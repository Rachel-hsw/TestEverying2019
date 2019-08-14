package com.umeng.socialize.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class be
  implements Parcelable.Creator<UMShareMsg>
{
  public UMShareMsg a(Parcel paramParcel)
  {
    return new UMShareMsg(paramParcel, null);
  }

  public UMShareMsg[] a(int paramInt)
  {
    return new UMShareMsg[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.be
 * JD-Core Version:    0.6.0
 */