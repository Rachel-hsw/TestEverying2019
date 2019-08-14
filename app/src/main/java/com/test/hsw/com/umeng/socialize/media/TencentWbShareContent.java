package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;

public class TencentWbShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<TencentWbShareContent> CREATOR = new g();

  public TencentWbShareContent()
  {
  }

  protected TencentWbShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public TencentWbShareContent(UMediaObject paramUMediaObject)
  {
    super(paramUMediaObject);
  }

  public TencentWbShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.k;
  }

  public String toString()
  {
    return super.toString() + "TencentWbShareContent";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.TencentWbShareContent
 * JD-Core Version:    0.6.0
 */