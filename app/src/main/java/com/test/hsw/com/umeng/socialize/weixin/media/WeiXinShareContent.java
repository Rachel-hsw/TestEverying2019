package com.umeng.socialize.weixin.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.media.BaseShareContent;
import com.umeng.socialize.media.UMEmoji;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;
import com.umeng.socialize.media.UMusic;

public class WeiXinShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<WeiXinShareContent> CREATOR = new b();

  public WeiXinShareContent()
  {
  }

  protected WeiXinShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public WeiXinShareContent(UMEmoji paramUMEmoji)
  {
    super(paramUMEmoji);
  }

  public WeiXinShareContent(UMImage paramUMImage)
  {
    super(paramUMImage);
  }

  public WeiXinShareContent(UMVideo paramUMVideo)
  {
    super(paramUMVideo);
  }

  public WeiXinShareContent(UMusic paramUMusic)
  {
    super(paramUMusic);
  }

  public WeiXinShareContent(String paramString)
  {
    super(paramString);
  }

  public p f()
  {
    return p.i;
  }

  public String toString()
  {
    return super.toString() + "WeiXinShareMedia [mTitle=" + this.a + ", mTargetUrl =" + this.b + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.media.WeiXinShareContent
 * JD-Core Version:    0.6.0
 */