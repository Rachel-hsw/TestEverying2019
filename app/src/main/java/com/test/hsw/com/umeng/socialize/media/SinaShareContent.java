package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;

public class SinaShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<SinaShareContent> CREATOR = new f();

  public SinaShareContent()
  {
  }

  protected SinaShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public SinaShareContent(UMediaObject paramUMediaObject)
  {
    super(paramUMediaObject);
  }

  public SinaShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.e;
  }

  public String toString()
  {
    return super.toString() + "SinaShareContent";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.SinaShareContent
 * JD-Core Version:    0.6.0
 */