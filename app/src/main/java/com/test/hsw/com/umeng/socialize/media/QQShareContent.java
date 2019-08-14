package com.umeng.socialize.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.umeng.socialize.b.b.d;
import com.umeng.socialize.bean.p;
import com.umeng.socialize.utils.i;

public class QQShareContent extends BaseShareContent
{
  public static final Parcelable.Creator<QQShareContent> CREATOR = new c();

  public QQShareContent()
  {
  }

  protected QQShareContent(Parcel paramParcel)
  {
    super(paramParcel);
  }

  public QQShareContent(UMImage paramUMImage)
  {
    super(paramUMImage);
  }

  public QQShareContent(UMVideo paramUMVideo)
  {
    super(paramUMVideo);
  }

  public QQShareContent(UMusic paramUMusic)
  {
    super(paramUMusic);
  }

  public QQShareContent(String paramString)
  {
    super(paramString);
  }

  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (d.b(paramString)))
    {
      this.b = paramString;
      return;
    }
    i.b(this.e, "### QQ的targetUrl必须以http://或者https://开头");
  }

  public p f()
  {
    return p.g;
  }

  public String toString()
  {
    return super.toString() + "QQShareContent [mTitle=" + this.a + ", mTargetUrl =" + this.b + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.media.QQShareContent
 * JD-Core Version:    0.6.0
 */