package com.umeng.socialize.weixin.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class b
  implements Parcelable.Creator<WeiXinShareContent>
{
  public WeiXinShareContent a(Parcel paramParcel)
  {
    return new WeiXinShareContent(paramParcel);
  }

  public WeiXinShareContent[] a(int paramInt)
  {
    return new WeiXinShareContent[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.weixin.media.b
 * JD-Core Version:    0.6.0
 */