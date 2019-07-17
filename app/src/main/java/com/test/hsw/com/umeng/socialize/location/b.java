package com.umeng.socialize.location;

import android.location.Location;
import android.os.AsyncTask;
import com.umeng.socialize.utils.i;

public class b extends AsyncTask<Void, Void, Location>
{
  private static final String b = "Location";
  private a a;

  public b(a parama)
  {
    this.a = parama;
  }

  private Location a()
  {
    Location localLocation = this.a.b();
    if (localLocation == null)
    {
      i.c("Location", "Fetch gps info from default failed,then fetch form network..");
      this.a.a("network");
      localLocation = this.a.b();
      this.a.a(null);
    }
    return localLocation;
  }

  protected Location a(Void[] paramArrayOfVoid)
  {
    int i = 0;
    while (i < 20)
      try
      {
        if (isCancelled())
          return null;
        Location localLocation = a();
        if (localLocation != null)
          return localLocation;
        Thread.sleep(500L);
        i++;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.location.b
 * JD-Core Version:    0.6.0
 */