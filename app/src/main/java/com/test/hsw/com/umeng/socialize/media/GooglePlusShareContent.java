package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;

public class GooglePlusShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<GooglePlusShareContent> CREATOR = new b();

  public GooglePlusShareContent()
  {
  }

  protected GooglePlusShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public GooglePlusShareContent(UMediaObject paramUMediaObject)
  {
    super(paramUMediaObject);
  }

  public GooglePlusShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.a;
  }

  public String toString()
  {
    return super.toString() + "GooglePlusShareContent";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.GooglePlusShareContent
 * JD-Core Version:    0.6.0
 */