package com.umeng.socialize.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class c
  implements LocationListener
{
  private a a;

  public void a(a parama)
  {
    this.a = parama;
  }

  public void onLocationChanged(Location paramLocation)
  {
    if (this.a != null)
    {
      this.a.a(paramLocation);
      this.a.c().a(this);
    }
  }

  public void onProviderDisabled(String paramString)
  {
  }

  public void onProviderEnabled(String paramString)
  {
  }

  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.location.c
 * JD-Core Version:    0.6.0
 */