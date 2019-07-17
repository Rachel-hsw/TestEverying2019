package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;

public class RenrenShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<RenrenShareContent> CREATOR = new e();

  public RenrenShareContent()
  {
  }

  protected RenrenShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public RenrenShareContent(UMediaObject paramUMediaObject)
  {
    super(paramUMediaObject);
  }

  public RenrenShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.h;
  }

  public String toString()
  {
    return super.toString() + "RenrenShareMedia";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.RenrenShareContent
 * JD-Core Version:    0.6.0
 */