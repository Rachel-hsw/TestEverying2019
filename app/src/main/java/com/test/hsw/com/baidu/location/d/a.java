package com.baidu.location.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.location.b.f;
import java.util.ArrayList;
import java.util.Iterator;

public class a
  implements f
{
  public static final String fB = "android.com.baidu.location.TIMER.NOTIFY";
  private a fA = new a();
  private PendingIntent fC = null;
  private ArrayList fD = null;
  private BDLocation fE = null;
  private long fF = 0L;
  private b fG = null;
  private float fH = 3.4028235E+38F;
  private boolean fI = false;
  private long fJ = 0L;
  private boolean fK = false;
  private LocationClient fL = null;
  private int fx = 0;
  private Context fy = null;
  private AlarmManager fz = null;

  public a(Context paramContext, LocationClient paramLocationClient)
  {
    this.fy = paramContext;
    this.fL = paramLocationClient;
    this.fL.registerNotifyLocationListener(this.fA);
    this.fz = ((AlarmManager)this.fy.getSystemService("alarm"));
    this.fG = new b();
    this.fK = false;
  }

  private void a1()
  {
    int i = 10000;
    if (!a3())
      return;
    int j;
    if (this.fH > 5000.0F)
    {
      j = 600000;
      if (!this.fI)
        break label138;
      this.fI = false;
    }
    while (true)
    {
      if (this.fx != 0)
      {
        long l = this.fF + this.fx - System.currentTimeMillis();
        if (i <= l);
      }
      for (int k = 0; ; k = 1)
      {
        if (k == 0)
          break label136;
        this.fx = i;
        this.fF = System.currentTimeMillis();
        jdMethod_new(this.fx);
        return;
        if (this.fH > 1000.0F)
        {
          j = 120000;
          break;
        }
        if (this.fH > 500.0F)
        {
          j = 60000;
          break;
        }
        j = i;
        break;
      }
      label136: break;
      label138: i = j;
    }
  }

  private boolean a3()
  {
    if ((this.fD == null) || (this.fD.isEmpty()))
    {
      i = 0;
      return i;
    }
    Iterator localIterator = this.fD.iterator();
    int i = 0;
    label31: if (localIterator.hasNext())
      if (((BDNotifyListener)localIterator.next()).Notified >= 3)
        break label63;
    label63: for (int j = 1; ; j = i)
    {
      i = j;
      break label31;
      break;
    }
  }

  private void jdMethod_for(BDLocation paramBDLocation)
  {
    if ((paramBDLocation.getLocType() != 61) && (paramBDLocation.getLocType() != 161) && (paramBDLocation.getLocType() != 65))
      jdMethod_new(120000L);
    do
      return;
    while ((System.currentTimeMillis() - this.fJ < 5000L) || (this.fD == null));
    this.fE = paramBDLocation;
    this.fJ = System.currentTimeMillis();
    float[] arrayOfFloat = new float[1];
    Iterator localIterator = this.fD.iterator();
    float f1 = 3.4028235E+38F;
    if (localIterator.hasNext())
    {
      BDNotifyListener localBDNotifyListener = (BDNotifyListener)localIterator.next();
      Location.distanceBetween(paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), localBDNotifyListener.mLatitudeC, localBDNotifyListener.mLongitudeC, arrayOfFloat);
      float f2 = arrayOfFloat[0] - localBDNotifyListener.mRadius - paramBDLocation.getRadius();
      if (f2 > 0.0F)
        if (f2 >= f1)
          break label210;
      while (true)
      {
        f1 = f2;
        break;
        if (localBDNotifyListener.Notified < 3)
        {
          localBDNotifyListener.Notified = (1 + localBDNotifyListener.Notified);
          localBDNotifyListener.onNotify(paramBDLocation, arrayOfFloat[0]);
          if (localBDNotifyListener.Notified < 3)
            this.fI = true;
        }
        label210: f2 = f1;
      }
    }
    if (f1 < this.fH)
      this.fH = f1;
    this.fx = 0;
    a1();
  }

  private void jdMethod_new(long paramLong)
  {
    try
    {
      if (this.fC != null)
        this.fz.cancel(this.fC);
      this.fC = PendingIntent.getBroadcast(this.fy, 0, new Intent("android.com.baidu.location.TIMER.NOTIFY"), 134217728);
      if (this.fC == null)
        return;
      this.fz.set(0, paramLong + System.currentTimeMillis(), this.fC);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void a2()
  {
    if (this.fC != null)
      this.fz.cancel(this.fC);
    this.fE = null;
    this.fJ = 0L;
    if (this.fK)
      this.fy.unregisterReceiver(this.fG);
    this.fK = false;
  }

  public int jdMethod_do(BDNotifyListener paramBDNotifyListener)
  {
    if (this.fD == null)
      this.fD = new ArrayList();
    this.fD.add(paramBDNotifyListener);
    paramBDNotifyListener.isAdded = true;
    paramBDNotifyListener.mNotifyCache = this;
    if (!this.fK)
    {
      this.fy.registerReceiver(this.fG, new IntentFilter("android.com.baidu.location.TIMER.NOTIFY"));
      this.fK = true;
    }
    if (paramBDNotifyListener.mCoorType == null)
      return 1;
    if (!paramBDNotifyListener.mCoorType.equals("gcj02"))
    {
      double[] arrayOfDouble = Jni.jdMethod_if(paramBDNotifyListener.mLongitude, paramBDNotifyListener.mLatitude, paramBDNotifyListener.mCoorType + "2gcj");
      paramBDNotifyListener.mLongitudeC = arrayOfDouble[0];
      paramBDNotifyListener.mLatitudeC = arrayOfDouble[1];
    }
    if ((this.fE == null) || (System.currentTimeMillis() - this.fJ > 30000L))
      this.fL.requestNotifyLocation();
    while (true)
    {
      a1();
      return 1;
      float[] arrayOfFloat = new float[1];
      Location.distanceBetween(this.fE.getLatitude(), this.fE.getLongitude(), paramBDNotifyListener.mLatitudeC, paramBDNotifyListener.mLongitudeC, arrayOfFloat);
      float f = arrayOfFloat[0] - paramBDNotifyListener.mRadius - this.fE.getRadius();
      if (f > 0.0F)
      {
        if (f >= this.fH)
          continue;
        this.fH = f;
        continue;
      }
      if (paramBDNotifyListener.Notified >= 3)
        continue;
      paramBDNotifyListener.Notified = (1 + paramBDNotifyListener.Notified);
      paramBDNotifyListener.onNotify(this.fE, arrayOfFloat[0]);
      if (paramBDNotifyListener.Notified >= 3)
        continue;
      this.fI = true;
    }
  }

  public int jdMethod_for(BDNotifyListener paramBDNotifyListener)
  {
    if (this.fD == null)
      return 0;
    if (this.fD.contains(paramBDNotifyListener))
      this.fD.remove(paramBDNotifyListener);
    if ((this.fD.size() == 0) && (this.fC != null))
      this.fz.cancel(this.fC);
    return 1;
  }

  public void jdMethod_if(BDNotifyListener paramBDNotifyListener)
  {
    if (paramBDNotifyListener.mCoorType == null)
      return;
    if (!paramBDNotifyListener.mCoorType.equals("gcj02"))
    {
      double[] arrayOfDouble = Jni.jdMethod_if(paramBDNotifyListener.mLongitude, paramBDNotifyListener.mLatitude, paramBDNotifyListener.mCoorType + "2gcj");
      paramBDNotifyListener.mLongitudeC = arrayOfDouble[0];
      paramBDNotifyListener.mLatitudeC = arrayOfDouble[1];
    }
    if ((this.fE == null) || (System.currentTimeMillis() - this.fJ > 300000L))
      this.fL.requestNotifyLocation();
    while (true)
    {
      a1();
      return;
      float[] arrayOfFloat = new float[1];
      Location.distanceBetween(this.fE.getLatitude(), this.fE.getLongitude(), paramBDNotifyListener.mLatitudeC, paramBDNotifyListener.mLongitudeC, arrayOfFloat);
      float f = arrayOfFloat[0] - paramBDNotifyListener.mRadius - this.fE.getRadius();
      if (f > 0.0F)
      {
        if (f >= this.fH)
          continue;
        this.fH = f;
        continue;
      }
      if (paramBDNotifyListener.Notified >= 3)
        continue;
      paramBDNotifyListener.Notified = (1 + paramBDNotifyListener.Notified);
      paramBDNotifyListener.onNotify(this.fE, arrayOfFloat[0]);
      if (paramBDNotifyListener.Notified >= 3)
        continue;
      this.fI = true;
    }
  }

  public class a
    implements BDLocationListener
  {
    public a()
    {
    }

    public void onReceiveLocation(BDLocation paramBDLocation)
    {
      if ((a.jdMethod_do(a.this) != null) && (a.jdMethod_do(a.this).size() > 0))
        a.jdMethod_if(a.this, paramBDLocation);
    }
  }

  public class b extends BroadcastReceiver
  {
    public b()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ((a.jdMethod_do(a.this) == null) || (a.jdMethod_do(a.this).isEmpty()))
        return;
      a.jdMethod_if(a.this).requestNotifyLocation();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.d.a
 * JD-Core Version:    0.6.0
 */