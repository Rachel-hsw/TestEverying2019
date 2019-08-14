package com.umeng.socialize.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.i;

public class BaseMsg
  implements Parcelable
{
  public static final Parcelable.Creator<BaseMsg> CREATOR = new a();
  public String a = "";
  public UMLocation b;
  protected UMediaObject c = null;

  public BaseMsg()
  {
  }

  protected BaseMsg(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((UMLocation)paramParcel.readParcelable(UMLocation.class.getClassLoader()));
    String str = paramParcel.readString();
    if (!TextUtils.isEmpty(str))
      try
      {
        this.c = ((UMediaObject)paramParcel.readParcelable(Class.forName(str).getClassLoader()));
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        i.c(localClassNotFoundException.toString());
        return;
      }
    paramParcel.readString();
  }

  public UMediaObject a()
  {
    return this.c;
  }

  public void a(UMediaObject paramUMediaObject)
  {
    this.c = paramUMediaObject;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeParcelable(this.b, 1);
    if (this.c == null);
    for (String str = ""; ; str = this.c.getClass().getName())
    {
      paramParcel.writeString(str);
      paramParcel.writeParcelable(this.c, 1);
      return;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.BaseMsg
 * JD-Core Version:    0.6.0
 */