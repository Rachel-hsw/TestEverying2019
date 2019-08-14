package com.umeng.socialize.bean;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UMLocation
  implements Parcelable
{
  public static final Parcelable.Creator<UMLocation> CREATOR = new bd();
  private double a;
  private double b;

  public UMLocation(double paramDouble1, double paramDouble2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
  }

  private UMLocation(Parcel paramParcel)
  {
    this.a = paramParcel.readDouble();
    this.b = paramParcel.readDouble();
  }

  public static UMLocation a(Location paramLocation)
  {
    try
    {
      if ((paramLocation.getLatitude() != 0.0D) && (paramLocation.getLongitude() != 0.0D))
      {
        UMLocation localUMLocation = new UMLocation(paramLocation.getLatitude(), paramLocation.getLongitude());
        return localUMLocation;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static UMLocation a(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.substring(1, -1 + paramString.length()).split(",");
      UMLocation localUMLocation = new UMLocation(Double.parseDouble(arrayOfString[1]), Double.parseDouble(arrayOfString[0]));
      return localUMLocation;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public double a()
  {
    return this.a;
  }

  public void a(double paramDouble)
  {
    this.a = paramDouble;
  }

  public double b()
  {
    return this.b;
  }

  public void b(double paramDouble)
  {
    this.b = paramDouble;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "(" + this.b + "," + this.a + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeDouble(this.a);
    paramParcel.writeDouble(this.b);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.bean.UMLocation
 * JD-Core Version:    0.6.0
 */