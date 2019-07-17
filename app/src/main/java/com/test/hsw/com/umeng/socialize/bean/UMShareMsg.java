package com.umeng.socialize.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UMShareMsg extends BaseMsg
  implements Parcelable
{
  public static final Parcelable.Creator<UMShareMsg> CREATOR = new be();
  public String d;

  public UMShareMsg()
  {
  }

  private UMShareMsg(Parcel paramParcel)
  {
    super(paramParcel);
    this.d = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.d);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.UMShareMsg
 * JD-Core Version:    0.6.0
 */