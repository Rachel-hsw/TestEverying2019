package com.umeng.socialize.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements Parcelable.Creator<BaseMsg>
{
  public BaseMsg a(Parcel paramParcel)
  {
    return new BaseMsg(paramParcel);
  }

  public BaseMsg[] a(int paramInt)
  {
    return new BaseMsg[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.a
 * JD-Core Version:    0.6.0
 */