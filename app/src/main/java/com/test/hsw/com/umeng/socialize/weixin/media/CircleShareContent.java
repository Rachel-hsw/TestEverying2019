package com.umeng.socialize.weixin.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.media.BaseShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMusic;

public class CircleShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<CircleShareContent> CREATOR = new a();

  public CircleShareContent()
  {
  }

  protected CircleShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public CircleShareContent(UMImage paramUMImage)
  {
    super(paramUMImage);
  }

  public CircleShareContent(UMVideo paramUMVideo)
  {
    super(paramUMVideo);
  }

  public CircleShareContent(UMusic paramUMusic)
  {
    super(paramUMusic);
  }

  public CircleShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.j;
  }

  public String toString()
  {
    return super.toString() + "CircleShareContent [mTitle=" + this.a + ", mTargetUrl =" + this.b + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.media.CircleShareContent
 * JD-Core Version:    0.6.0
 */