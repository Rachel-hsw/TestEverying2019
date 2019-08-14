package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class MediaMetadataCompat$1
  implements Parcelable.Creator<MediaMetadataCompat>
{
  public MediaMetadataCompat createFromParcel(Parcel paramParcel)
  {
    return new MediaMetadataCompat(paramParcel, null);
  }

  public MediaMetadataCompat[] newArray(int paramInt)
  {
    return new MediaMetadataCompat[paramInt];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaMetadataCompat.1
 * JD-Core Version:    0.6.0
 */