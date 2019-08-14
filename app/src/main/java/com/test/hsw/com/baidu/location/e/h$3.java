package com.baidu.location.e;

import android.location.Location;
import android.os.Handler;

class h$3
  implements Runnable
{
  public void run()
  {
    Location localLocation = new Location("GPS");
    h localh1 = this.a;
    localh1.hh -= 0.0001123456789D;
    h localh2 = this.a;
    localh2.hp -= 1.02340567E-005D;
    localLocation.setTime(System.currentTimeMillis());
    localLocation.setLongitude(this.a.hh);
    localLocation.setLatitude(this.a.hp);
    localLocation.setSpeed(20.0F);
    localLocation.setBearing(35.0F);
    h localh3 = this.a;
    localh3.hq = (1 + localh3.hq);
    this.a.jdMethod_for(localLocation);
    if (this.a.hq < 20)
      h.jdMethod_if(this.a).postDelayed(this, 1000L);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.h.3
 * JD-Core Version:    0.6.0
 */