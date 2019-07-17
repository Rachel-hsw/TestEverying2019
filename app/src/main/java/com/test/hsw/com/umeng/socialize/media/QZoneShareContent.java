package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;

public class QZoneShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<QZoneShareContent> CREATOR = new d();

  public QZoneShareContent()
  {
  }

  protected QZoneShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public QZoneShareContent(UMImage paramUMImage)
  {
    super(paramUMImage);
  }

  public QZoneShareContent(UMVideo paramUMVideo)
  {
    super(paramUMVideo);
  }

  public QZoneShareContent(UMusic paramUMusic)
  {
    super(paramUMusic);
  }

  public QZoneShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.f;
  }

  public String toString()
  {
    return super.toString() + "[QZoneShareMedia]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.QZoneShareContent
 * JD-Core Version:    0.6.0
 */