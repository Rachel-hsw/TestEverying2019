package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;

public class DoubanShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<DoubanShareContent> CREATOR = new a();

  public DoubanShareContent()
  {
  }

  protected DoubanShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public DoubanShareContent(UMediaObject paramUMediaObject)
  {
    super(paramUMediaObject);
  }

  public DoubanShareContent(String paramString)
  {
    super(paramString);
  }

  public int describeContents()
  {
    return 0;
  }

  public p f()
  {
    return p.l;
  }

  public String toString()
  {
    return super.toString() + "DoubanShareContent";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.DoubanShareContent
 * JD-Core Version:    0.6.0
 */