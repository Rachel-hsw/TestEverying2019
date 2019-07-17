package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;

public class TwitterShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<TwitterShareContent> CREATOR = new h();

  public TwitterShareContent()
  {
  }

  protected TwitterShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public TwitterShareContent(UMImage paramUMImage)
  {
    super(paramUMImage);
  }

  public TwitterShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.n;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.TwitterShareContent
 * JD-Core Version:    0.6.0
 */