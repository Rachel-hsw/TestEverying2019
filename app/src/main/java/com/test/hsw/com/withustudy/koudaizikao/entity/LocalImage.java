package com.withustudy.koudaizikao.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LocalImage
  implements Parcelable
{
  public static final Parcelable.Creator<LocalImage> CREATOR = new LocalImage.1();
  private boolean isChoose;
  private String parent;
  private String path;

  public LocalImage()
  {
  }

  private LocalImage(Parcel paramParcel)
  {
    this.path = paramParcel.readString();
    this.parent = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public String getParent()
  {
    return this.parent;
  }

  public String getPath()
  {
    return this.path;
  }

  public boolean isChoose()
  {
    return this.isChoose;
  }

  public void setChoose(boolean paramBoolean)
  {
    this.isChoose = paramBoolean;
  }

  public void setParent(String paramString)
  {
    this.parent = paramString;
  }

  public void setPath(String paramString)
  {
    this.path = paramString;
  }

  public String toString()
  {
    return "LocalImage [path=" + this.path + ", parent=" + this.parent + ", isChoose=" + this.isChoose + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.path);
    paramParcel.writeString(this.parent);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.entity.LocalImage
 * JD-Core Version:    0.6.0
 */