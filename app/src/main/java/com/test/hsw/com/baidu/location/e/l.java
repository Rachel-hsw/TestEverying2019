package com.baidu.location.e;

import F;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class l
  implements SensorEventListener, com.baidu.location.b.f
{
  private static l ig;
  private SensorManager ia;
  private boolean ib = false;
  private boolean ic;
  private float id;
  private float[] ie;
  private double ih = 4.9E-324D;
  private float[] ii;
  private boolean ij = false;

  public static l ce()
  {
    if (ig == null)
      ig = new l();
    return ig;
  }

  public boolean ca()
  {
    return this.ib;
  }

  public void jdMethod_case(boolean paramBoolean)
  {
    this.ic = paramBoolean;
  }

  public boolean cb()
  {
    return this.ic;
  }

  public void cc()
  {
    monitorenter;
    try
    {
      boolean bool = this.ij;
      if (bool);
      while (true)
      {
        return;
        if (this.ia == null)
          this.ia = ((SensorManager)com.baidu.location.f.getServiceContext().getSystemService("sensor"));
        if (this.ia != null)
        {
          Sensor localSensor1 = this.ia.getDefaultSensor(11);
          if ((localSensor1 != null) && (this.ic))
            this.ia.registerListener(this, localSensor1, 3);
          Sensor localSensor2 = this.ia.getDefaultSensor(6);
          if ((localSensor2 != null) && (this.ib))
            this.ia.registerListener(this, localSensor2, 3);
        }
        this.ij = true;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public double cd()
  {
    return this.ih;
  }

  public void cf()
  {
    monitorenter;
    try
    {
      boolean bool = this.ij;
      if (!bool);
      while (true)
      {
        return;
        if (this.ia != null)
        {
          this.ia.unregisterListener(this);
          this.ia = null;
        }
        this.ij = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public float cg()
  {
    return this.id;
  }

  public void jdMethod_char(boolean paramBoolean)
  {
    this.ib = paramBoolean;
  }

  public void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
  }

  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default:
    case 11:
      do
      {
        return;
        this.ii = ((float[])paramSensorEvent.values.clone());
      }
      while (this.ii == null);
      float[] arrayOfFloat1 = new float[9];
      SensorManager.getRotationMatrixFromVector(arrayOfFloat1, this.ii);
      float[] arrayOfFloat2 = new float[3];
      SensorManager.getOrientation(arrayOfFloat1, arrayOfFloat2);
      this.id = (float)Math.toDegrees(arrayOfFloat2[0]);
      double d;
      if (this.id >= 0.0F)
        d = this.id;
      while (true)
      {
        this.id = (float)Math.floor(d);
        return;
        d = 360.0F + this.id;
      }
    case 6:
    }
    this.ie = ((float[])paramSensorEvent.values.clone());
    this.ih = SensorManager.getAltitude(1013.25F, this.ie[0]);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.l
 * JD-Core Version:    0.6.0
 */