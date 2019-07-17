package com.baidu.location.h;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.Jni;
import com.baidu.location.e.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

public class a extends g
  implements com.baidu.location.b.f
{
  private static final int jA = 3000;
  private static String jD;
  private static a jE = null;
  private static int jM = 0;
  private GpsStatus jB;
  private a jC = null;
  private int jF;
  private final int jG = 1;
  private long jH = 0L;
  private c jI = null;
  private Handler jJ = null;
  private Context jK;
  private boolean jL = false;
  private b jN = null;
  private Location jO;
  private final long jP = 1000L;
  private LocationManager jQ = null;
  private HashMap jq;
  private boolean jr = false;
  private final long js = 9000L;
  private final int jt = 2;
  private int ju;
  private long jv = 0L;
  private String jw = null;
  private final int jx = 4;
  private boolean jy = false;
  private final int jz = 3;

  static
  {
    jD = null;
  }

  public static a cL()
  {
    if (jE == null)
      jE = new a();
    return jE;
  }

  private void jdMethod_case(Location paramLocation)
  {
    int i;
    if (paramLocation != null)
    {
      i = jM;
      if (i != 0);
    }
    try
    {
      int m = paramLocation.getExtras().getInt("satellites");
      i = m;
      label26: if ((i == 0) && (!com.baidu.location.b.k.cj));
      while (true)
      {
        return;
        this.jO = null;
        return;
        this.jO = paramLocation;
        if (this.jO == null)
          this.jw = null;
        try
        {
          com.baidu.location.e.k.b6().jdMethod_try(this.jO);
          if (this.jO != null)
            com.baidu.location.e.h.bI().jdMethod_for(this.jO);
          if ((!cH()) || (this.jO == null))
            continue;
          com.baidu.location.e.c.bp().l(cD());
          if ((jM <= 2) || (!o.jdMethod_if(this.jO, true)))
            continue;
          boolean bool = e.de().cY();
          com.baidu.location.e.a.a(new h(b.cU().cM()));
          com.baidu.location.e.a.a(System.currentTimeMillis());
          com.baidu.location.e.a.a(new Location(this.jO));
          com.baidu.location.e.a.a(com.baidu.location.e.c.bp().bs());
          if (bool)
            continue;
          o.jdMethod_do(com.baidu.location.e.a.a(), null, com.baidu.location.e.a.jdMethod_if(), com.baidu.location.e.c.bp().bs());
          return;
          l = System.currentTimeMillis();
          this.jO.setTime(l);
          f = (float)(3.6D * this.jO.getSpeed());
          if (!this.jO.hasSpeed())
            f = -1.0F;
          j = jM;
          if (j != 0);
        }
        catch (Exception localException1)
        {
          try
          {
            while (true)
            {
              long l;
              float f;
              int k = this.jO.getExtras().getInt("satellites");
              int j = k;
              label274: Locale localLocale = Locale.CHINA;
              Object[] arrayOfObject = new Object[6];
              arrayOfObject[0] = Double.valueOf(this.jO.getLongitude());
              arrayOfObject[1] = Double.valueOf(this.jO.getLatitude());
              arrayOfObject[2] = Float.valueOf(f);
              arrayOfObject[3] = Float.valueOf(this.jO.getBearing());
              arrayOfObject[4] = Integer.valueOf(j);
              arrayOfObject[5] = Long.valueOf(l);
              this.jw = String.format(localLocale, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", arrayOfObject);
              jdMethod_if(this.jO.getLongitude(), this.jO.getLatitude(), f);
            }
            localException1 = localException1;
          }
          catch (Exception localException2)
          {
            break label274;
          }
        }
      }
    }
    catch (Exception localException3)
    {
      break label26;
    }
  }

  private void jdMethod_char(Location paramLocation)
  {
    Message localMessage = this.jJ.obtainMessage(1, paramLocation);
    this.jJ.sendMessage(localMessage);
  }

  public static String jdMethod_else(Location paramLocation)
  {
    String str = jdMethod_long(paramLocation);
    if (str != null)
      str = str + jD;
    return str;
  }

  public static String jdMethod_goto(Location paramLocation)
  {
    String str = jdMethod_long(paramLocation);
    if (str != null)
      str = str + "&g_tp=0";
    return str;
  }

  private void jdMethod_goto(boolean paramBoolean)
  {
    this.jL = paramBoolean;
    if ((paramBoolean) && (!cH()));
  }

  private int jdMethod_if(i parami, int paramInt)
  {
    if (jM >= com.baidu.location.b.k.cq);
    do
    {
      double d2;
      do
      {
        double d1;
        do
        {
          return 1;
          if (jM <= com.baidu.location.b.k.b7)
            return 4;
          d1 = parami.jdMethod_if();
        }
        while (d1 <= com.baidu.location.b.k.cQ);
        if (d1 >= com.baidu.location.b.k.bW)
          return 4;
        d2 = parami.jdMethod_for();
      }
      while (d2 <= com.baidu.location.b.k.ck);
      if (d2 >= com.baidu.location.b.k.cA)
        return 4;
    }
    while (paramInt >= com.baidu.location.b.k.bJ);
    if (paramInt <= com.baidu.location.b.k.cC)
      return 4;
    if (this.jq != null)
      return jdMethod_if(this.jq);
    return 3;
  }

  private int jdMethod_if(HashMap paramHashMap)
  {
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    int n;
    if (this.jF > 4)
    {
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      Iterator localIterator = paramHashMap.entrySet().iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        List localList = (List)((Map.Entry)localIterator.next()).getValue();
        if (localList == null)
          break label305;
        double[] arrayOfDouble4 = jdMethod_if(localList);
        if (arrayOfDouble4 == null)
          break label305;
        localArrayList1.add(arrayOfDouble4);
        n = i + 1;
        localArrayList2.add(Integer.valueOf(i));
      }
    }
    while (true)
    {
      i = n;
      break;
      if (!localArrayList1.isEmpty())
      {
        double[] arrayOfDouble1 = new double[2];
        int j = localArrayList1.size();
        for (int k = 0; k < j; k++)
        {
          double[] arrayOfDouble3 = (double[])localArrayList1.get(k);
          int m = ((Integer)localArrayList2.get(k)).intValue();
          arrayOfDouble3[0] *= m;
          arrayOfDouble3[1] *= m;
          arrayOfDouble1[0] += arrayOfDouble3[0];
          arrayOfDouble1[1] += arrayOfDouble3[1];
        }
        arrayOfDouble1[0] /= j;
        arrayOfDouble1[1] /= j;
        double[] arrayOfDouble2 = jdMethod_new(arrayOfDouble1[0], arrayOfDouble1[1]);
        if (arrayOfDouble2[0] <= com.baidu.location.b.k.cI)
          return 1;
        if (arrayOfDouble2[0] >= com.baidu.location.b.k.bQ)
          return 4;
      }
      return 3;
      label305: n = i;
    }
  }

  private String jdMethod_if(GpsSatellite paramGpsSatellite, HashMap paramHashMap)
  {
    int i = (int)Math.floor(paramGpsSatellite.getAzimuth() / 6.0F);
    float f1 = paramGpsSatellite.getElevation();
    int j = (int)Math.floor(f1 / 1.5D);
    float f2 = paramGpsSatellite.getSnr();
    int k = Math.round(f2 / 5.0F);
    int m = paramGpsSatellite.getPrn();
    if (m >= 65);
    for (int n = m - 32; ; n = m)
    {
      if ((f2 >= 10.0F) && (f1 >= 1.0F))
      {
        Object localObject = (List)paramHashMap.get(Integer.valueOf(k));
        if (localObject == null)
          localObject = new ArrayList();
        ((List)localObject).add(paramGpsSatellite);
        paramHashMap.put(Integer.valueOf(k), localObject);
        this.jF = (1 + this.jF);
      }
      if ((i < 64) || ((j < 64) || (n >= 65)));
      return null;
    }
  }

  private void jdMethod_if(double paramDouble1, double paramDouble2, float paramFloat)
  {
    if (!com.baidu.location.e.f.bA().gx);
    while (true)
    {
      return;
      boolean bool1 = paramDouble1 < 73.146973000000003D;
      int i = 0;
      if (!bool1)
      {
        boolean bool2 = paramDouble1 < 135.25268600000001D;
        i = 0;
        if (!bool2)
        {
          boolean bool3 = paramDouble2 < 54.258806999999997D;
          i = 0;
          if (!bool3)
          {
            boolean bool4 = paramDouble2 < 14.604846999999999D;
            i = 0;
            if (!bool4)
            {
              boolean bool5 = paramFloat < 18.0F;
              i = 0;
              if (!bool5)
                break label100;
            }
          }
        }
      }
      while (com.baidu.location.b.k.co != i)
      {
        com.baidu.location.b.k.co = i;
        return;
        label100: double d1 = paramDouble1 - com.baidu.location.b.k.bG;
        double d2 = com.baidu.location.b.k.b4 - paramDouble2;
        int j = (int)(d1 * 1000.0D);
        int k = (int)(d2 * 1000.0D);
        if ((j > 0) && (j < 50) && (k > 0) && (k < 50))
        {
          int m = j + k * 50;
          int n = m >> 2;
          int i1 = m & 0x3;
          boolean bool6 = com.baidu.location.b.k.cM;
          i = 0;
          if (!bool6)
            continue;
          i = 0x3 & com.baidu.location.b.k.b2[n] >> i1 * 2;
          continue;
        }
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Double.valueOf(paramDouble1);
        arrayOfObject[1] = Double.valueOf(paramDouble2);
        String str1 = String.format(localLocale, "&ll=%.5f|%.5f", arrayOfObject);
        String str2 = str1 + "&im=" + com.baidu.location.b.c.N().L();
        com.baidu.location.b.k.cp = paramDouble1;
        com.baidu.location.b.k.cE = paramDouble2;
        com.baidu.location.e.f.bA().m(str2);
        i = 0;
      }
    }
  }

  private void jdMethod_if(String paramString, Location paramLocation)
  {
    if (paramLocation == null);
    String str;
    boolean bool;
    do
    {
      return;
      str = paramString + com.baidu.location.e.c.bp().bs();
      bool = e.de().cY();
      com.baidu.location.e.a.a(new h(b.cU().cM()));
      com.baidu.location.e.a.a(System.currentTimeMillis());
      com.baidu.location.e.a.a(new Location(paramLocation));
      com.baidu.location.e.a.a(str);
    }
    while (bool);
    o.jdMethod_do(com.baidu.location.e.a.a(), null, com.baidu.location.e.a.jdMethod_if(), str);
  }

  public static boolean jdMethod_if(Location paramLocation1, Location paramLocation2, boolean paramBoolean)
  {
    int i = 1;
    if (paramLocation1 == paramLocation2)
      i = 0;
    float f2;
    do
      while (true)
      {
        return i;
        if ((paramLocation1 == null) || (paramLocation2 == null))
          continue;
        float f1 = paramLocation2.getSpeed();
        if ((paramBoolean) && ((com.baidu.location.b.k.co == 3) || (!com.baidu.location.b.h.W().jdMethod_for(paramLocation2.getLongitude(), paramLocation2.getLatitude()))) && (f1 < 5.0F))
          continue;
        f2 = paramLocation2.distanceTo(paramLocation1);
        if (f1 > com.baidu.location.b.k.cg)
          if (f2 <= com.baidu.location.b.k.cx)
            return false;
        if (f1 <= com.baidu.location.b.k.ch)
          break;
        if (f2 <= com.baidu.location.b.k.cO)
          return false;
      }
    while (f2 > 5.0F);
    return false;
  }

  private double[] jdMethod_if(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return null;
    double[] arrayOfDouble1 = new double[2];
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
      if (localGpsSatellite == null)
        continue;
      double[] arrayOfDouble2 = jdMethod_int(90.0F - localGpsSatellite.getElevation(), localGpsSatellite.getAzimuth());
      arrayOfDouble1[0] += arrayOfDouble2[0];
      arrayOfDouble1[1] += arrayOfDouble2[1];
    }
    int i = paramList.size();
    arrayOfDouble1[0] /= i;
    arrayOfDouble1[1] /= i;
    return arrayOfDouble1;
  }

  private double[] jdMethod_int(double paramDouble1, double paramDouble2)
  {
    double[] arrayOfDouble = new double[2];
    arrayOfDouble[0] = (paramDouble1 * Math.sin(Math.toRadians(paramDouble2)));
    arrayOfDouble[1] = (paramDouble1 * Math.cos(Math.toRadians(paramDouble2)));
    return arrayOfDouble;
  }

  public static String jdMethod_long(Location paramLocation)
  {
    float f1 = -1.0F;
    if (paramLocation == null)
      return null;
    float f2 = (float)(3.6D * paramLocation.getSpeed());
    if (!paramLocation.hasSpeed())
      f2 = f1;
    float f3;
    int i;
    double d;
    if (paramLocation.hasAccuracy())
    {
      f3 = paramLocation.getAccuracy();
      i = (int)f3;
      if (!paramLocation.hasAltitude())
        break label181;
      d = paramLocation.getAltitude();
    }
    while (true)
    {
      if (paramLocation.hasBearing())
        f1 = paramLocation.getBearing();
      Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = Double.valueOf(paramLocation.getLongitude());
      arrayOfObject[1] = Double.valueOf(paramLocation.getLatitude());
      arrayOfObject[2] = Float.valueOf(f2);
      arrayOfObject[3] = Float.valueOf(f1);
      arrayOfObject[4] = Integer.valueOf(i);
      arrayOfObject[5] = Integer.valueOf(jM);
      arrayOfObject[6] = Double.valueOf(d);
      arrayOfObject[7] = Long.valueOf(paramLocation.getTime() / 1000L);
      return String.format(localLocale, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d", arrayOfObject);
      f3 = f1;
      break;
      label181: d = 555.0D;
    }
  }

  private double[] jdMethod_new(double paramDouble1, double paramDouble2)
  {
    double d = 0.0D;
    if (paramDouble2 == d)
      if (paramDouble1 > d)
        d = 90.0D;
    while (true)
    {
      double[] arrayOfDouble = new double[2];
      arrayOfDouble[0] = Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2);
      arrayOfDouble[1] = d;
      return arrayOfDouble;
      if (paramDouble1 >= d)
        continue;
      d = 270.0D;
      continue;
      d = Math.toDegrees(Math.atan(paramDouble1 / paramDouble2));
    }
  }

  // ERROR //
  public void cA()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 633	com/baidu/location/f:isServing	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: invokestatic 637	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   17: putfield 639	com/baidu/location/h/a:jK	Landroid/content/Context;
    //   20: aload_0
    //   21: aload_0
    //   22: getfield 639	com/baidu/location/h/a:jK	Landroid/content/Context;
    //   25: ldc_w 641
    //   28: invokevirtual 647	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 649	android/location/LocationManager
    //   34: putfield 69	com/baidu/location/h/a:jQ	Landroid/location/LocationManager;
    //   37: aload_0
    //   38: new 651	com/baidu/location/h/a$a
    //   41: dup
    //   42: aload_0
    //   43: aconst_null
    //   44: invokespecial 654	com/baidu/location/h/a$a:<init>	(Lcom/baidu/location/h/a;Lcom/baidu/location/h/a$1;)V
    //   47: putfield 75	com/baidu/location/h/a:jC	Lcom/baidu/location/h/a$a;
    //   50: aload_0
    //   51: getfield 69	com/baidu/location/h/a:jQ	Landroid/location/LocationManager;
    //   54: aload_0
    //   55: getfield 75	com/baidu/location/h/a:jC	Lcom/baidu/location/h/a$a;
    //   58: invokevirtual 658	android/location/LocationManager:addGpsStatusListener	(Landroid/location/GpsStatus$Listener;)Z
    //   61: pop
    //   62: aload_0
    //   63: new 660	com/baidu/location/h/a$c
    //   66: dup
    //   67: aload_0
    //   68: aconst_null
    //   69: invokespecial 661	com/baidu/location/h/a$c:<init>	(Lcom/baidu/location/h/a;Lcom/baidu/location/h/a$1;)V
    //   72: putfield 73	com/baidu/location/h/a:jI	Lcom/baidu/location/h/a$c;
    //   75: aload_0
    //   76: getfield 69	com/baidu/location/h/a:jQ	Landroid/location/LocationManager;
    //   79: ldc_w 663
    //   82: ldc2_w 64
    //   85: fconst_0
    //   86: aload_0
    //   87: getfield 73	com/baidu/location/h/a:jI	Lcom/baidu/location/h/a$c;
    //   90: invokevirtual 667	android/location/LocationManager:requestLocationUpdates	(Ljava/lang/String;JFLandroid/location/LocationListener;)V
    //   93: aload_0
    //   94: new 669	com/baidu/location/h/a$1
    //   97: dup
    //   98: aload_0
    //   99: invokespecial 672	com/baidu/location/h/a$1:<init>	(Lcom/baidu/location/h/a;)V
    //   102: putfield 89	com/baidu/location/h/a:jJ	Landroid/os/Handler;
    //   105: goto -95 -> 10
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    //   113: astore_3
    //   114: goto -21 -> 93
    //
    // Exception table:
    //   from	to	target	type
    //   2	6	108	finally
    //   13	20	108	finally
    //   20	93	108	finally
    //   93	105	108	finally
    //   20	93	113	java/lang/Exception
  }

  public Location cB()
  {
    return this.jO;
  }

  public boolean cC()
  {
    return (this.jO != null) && (this.jO.getLatitude() != 0.0D) && (this.jO.getLongitude() != 0.0D);
  }

  public String cD()
  {
    Location localLocation = this.jO;
    String str1 = null;
    String str2;
    float f1;
    int i;
    float f2;
    double[] arrayOfDouble1;
    double[] arrayOfDouble3;
    double[] arrayOfDouble2;
    int j;
    if (localLocation != null)
    {
      str2 = "{\"result\":{\"time\":\"" + com.baidu.location.b.k.ad() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"";
      if (!this.jO.hasAccuracy())
        break label386;
      f1 = this.jO.getAccuracy();
      i = (int)f1;
      f2 = (float)(3.6D * this.jO.getSpeed());
      if (!this.jO.hasSpeed())
        f2 = -1.0F;
      arrayOfDouble1 = new double[2];
      if (!com.baidu.location.b.h.W().jdMethod_for(this.jO.getLongitude(), this.jO.getLatitude()))
        break label394;
      arrayOfDouble3 = Jni.jdMethod_if(this.jO.getLongitude(), this.jO.getLatitude(), "gps2gcj");
      if ((arrayOfDouble3[0] > 0.0D) || (arrayOfDouble3[1] > 0.0D))
        break label448;
      arrayOfDouble3[0] = this.jO.getLongitude();
      arrayOfDouble3[1] = this.jO.getLatitude();
      arrayOfDouble2 = arrayOfDouble3;
      j = 1;
    }
    while (true)
    {
      Locale localLocale1 = Locale.CHINA;
      Object[] arrayOfObject1 = new Object[6];
      arrayOfObject1[0] = Double.valueOf(arrayOfDouble2[0]);
      arrayOfObject1[1] = Double.valueOf(arrayOfDouble2[1]);
      arrayOfObject1[2] = Integer.valueOf(i);
      arrayOfObject1[3] = Float.valueOf(this.jO.getBearing());
      arrayOfObject1[4] = Float.valueOf(f2);
      arrayOfObject1[5] = Integer.valueOf(jM);
      String str3 = String.format(localLocale1, str2, arrayOfObject1);
      if (j == 0)
        str3 = str3 + ",\"in_cn\":\"0\"";
      if (this.jO.hasAltitude())
      {
        StringBuilder localStringBuilder = new StringBuilder().append(str3);
        Locale localLocale2 = Locale.CHINA;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Double.valueOf(this.jO.getAltitude());
        str1 = String.format(localLocale2, ",\"h\":%.2f}}", arrayOfObject2);
        return str1;
        label386: f1 = 10.0F;
        break;
        label394: arrayOfDouble1[0] = this.jO.getLongitude();
        arrayOfDouble1[1] = this.jO.getLatitude();
        arrayOfDouble2 = arrayOfDouble1;
        j = 0;
        continue;
      }
      return str3 + "}}";
      label448: arrayOfDouble2 = arrayOfDouble3;
      j = 1;
    }
  }

  // ERROR //
  public void cE()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 699	com/baidu/location/h/a:cI	()V
    //   6: aload_0
    //   7: getfield 69	com/baidu/location/h/a:jQ	Landroid/location/LocationManager;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 75	com/baidu/location/h/a:jC	Lcom/baidu/location/h/a$a;
    //   22: ifnull +14 -> 36
    //   25: aload_0
    //   26: getfield 69	com/baidu/location/h/a:jQ	Landroid/location/LocationManager;
    //   29: aload_0
    //   30: getfield 75	com/baidu/location/h/a:jC	Lcom/baidu/location/h/a$a;
    //   33: invokevirtual 703	android/location/LocationManager:removeGpsStatusListener	(Landroid/location/GpsStatus$Listener;)V
    //   36: aload_0
    //   37: getfield 69	com/baidu/location/h/a:jQ	Landroid/location/LocationManager;
    //   40: aload_0
    //   41: getfield 73	com/baidu/location/h/a:jI	Lcom/baidu/location/h/a$c;
    //   44: invokevirtual 707	android/location/LocationManager:removeUpdates	(Landroid/location/LocationListener;)V
    //   47: aload_0
    //   48: aconst_null
    //   49: putfield 75	com/baidu/location/h/a:jC	Lcom/baidu/location/h/a$a;
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 69	com/baidu/location/h/a:jQ	Landroid/location/LocationManager;
    //   57: goto -42 -> 15
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    //   65: astore_3
    //   66: goto -19 -> 47
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	60	finally
    //   18	36	60	finally
    //   36	47	60	finally
    //   47	57	60	finally
    //   18	36	65	java/lang/Exception
    //   36	47	65	java/lang/Exception
  }

  public void cF()
  {
    cA();
    if (this.jy)
      return;
    try
    {
      this.jN = new b(null);
      this.jQ.requestLocationUpdates("gps", 1000L, 0.0F, this.jN);
      this.jQ.addNmeaListener(this.jC);
      this.jy = true;
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public String cG()
  {
    if ((cH()) && (this.jO != null))
      return jdMethod_long(this.jO);
    return null;
  }

  public boolean cH()
  {
    if (!cC());
    do
      return false;
    while (System.currentTimeMillis() - this.jH > 10000L);
    long l = System.currentTimeMillis();
    if ((this.jr) && (l - this.jv < 3000L))
      return true;
    return this.jL;
  }

  public void cI()
  {
    if (!this.jy)
      return;
    if (this.jQ != null);
    try
    {
      if (this.jN != null)
        this.jQ.removeUpdates(this.jN);
      if (this.jC != null)
        this.jQ.removeNmeaListener(this.jC);
      label51: com.baidu.location.b.k.b1 = 0;
      com.baidu.location.b.k.co = 0;
      this.jN = null;
      this.jy = false;
      jdMethod_goto(false);
      return;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }

  public String cJ()
  {
    return this.jw;
  }

  public boolean cK()
  {
    return this.jy;
  }

  public void jdMethod_else(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      cF();
      return;
    }
    cI();
  }

  private class a
    implements GpsStatus.Listener, GpsStatus.NmeaListener
  {
    private long a = 0L;
    private List jdField_byte = new ArrayList();
    private final int jdField_case = 400;
    private String jdField_do = null;
    private String jdField_for = null;
    long jdField_if = 0L;
    private String jdField_new = null;
    private boolean jdField_try = false;

    private a()
    {
    }

    public void a(String paramString)
    {
      if ((System.currentTimeMillis() - this.a > 400L) && (this.jdField_try) && (this.jdField_byte.size() > 0));
      try
      {
        i locali = new i(this.jdField_byte, this.jdField_for, this.jdField_new, this.jdField_do);
        if (locali.jdField_do())
        {
          com.baidu.location.b.k.b1 = a.jdField_if(a.this, locali, a.jdField_case(a.this));
          if (com.baidu.location.b.k.b1 > 0)
          {
            Locale localLocale = Locale.CHINA;
            Object[] arrayOfObject = new Object[3];
            arrayOfObject[0] = Double.valueOf(locali.jdField_if());
            arrayOfObject[1] = Double.valueOf(locali.jdField_for());
            arrayOfObject[2] = Integer.valueOf(com.baidu.location.b.k.b1);
            a.B(String.format(localLocale, "&nmea=%.1f|%.1f&g_tp=%d", arrayOfObject));
          }
        }
        while (true)
        {
          this.jdField_byte.clear();
          this.jdField_do = null;
          this.jdField_new = null;
          this.jdField_for = null;
          this.jdField_try = false;
          if (!paramString.startsWith("$GPGGA"))
            break;
          this.jdField_try = true;
          this.jdField_for = paramString.trim();
          this.a = System.currentTimeMillis();
          return;
          com.baidu.location.b.k.b1 = 0;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          com.baidu.location.b.k.b1 = 0;
          continue;
          if (paramString.startsWith("$GPGSV"))
          {
            this.jdField_byte.add(paramString.trim());
            continue;
          }
          if (!paramString.startsWith("$GPGSA"))
            continue;
          this.jdField_do = paramString.trim();
        }
      }
    }

    public void onGpsStatusChanged(int paramInt)
    {
      if (a.jdField_for(a.this) == null);
      do
      {
        return;
        switch (paramInt)
        {
        case 3:
        default:
          return;
        case 2:
          a.jdField_do(a.this, null);
          a.jdField_if(a.this, false);
          a.jdMethod_else(0);
          return;
        case 4:
        }
      }
      while (!a.jdMethod_int(a.this));
      try
      {
        if (a.jdField_new(a.this) == null)
          a.jdField_if(a.this, a.jdField_for(a.this).getGpsStatus(null));
        int i;
        while (true)
        {
          Iterator localIterator = a.jdField_new(a.this).getSatellites().iterator();
          a.jdField_do(a.this, 0);
          a.jdField_if(a.this, 0);
          a.jdField_if(a.this, new HashMap());
          i = 0;
          while (localIterator.hasNext())
          {
            GpsSatellite localGpsSatellite = (GpsSatellite)localIterator.next();
            if (!localGpsSatellite.usedInFix())
              continue;
            i++;
            if (localGpsSatellite.getSnr() >= com.baidu.location.b.k.bH)
              a.jdField_if(a.this);
            a.jdField_if(a.this, localGpsSatellite, a.jdField_byte(a.this));
          }
          a.jdField_for(a.this).getGpsStatus(a.jdField_new(a.this));
        }
        a.jdMethod_else(i);
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onNmeaReceived(long paramLong, String paramString)
    {
      if (!a.jdMethod_int(a.this));
      do
      {
        return;
        if (com.baidu.location.e.f.bA().gB)
          continue;
        com.baidu.location.b.k.b1 = 0;
        return;
      }
      while ((paramString == null) || (paramString.equals("")) || (paramString.length() < 9) || (paramString.length() > 150) || (!a.this.cH()));
      a.jdField_try(a.this).sendMessage(a.jdField_try(a.this).obtainMessage(2, paramString));
    }
  }

  private class b
    implements LocationListener
  {
    private b()
    {
    }

    public void onLocationChanged(Location paramLocation)
    {
      a.jdMethod_do(a.this, System.currentTimeMillis());
      a.jdMethod_if(a.this, true);
      a.jdMethod_do(a.this, paramLocation);
      a.jdMethod_do(a.this, false);
    }

    public void onProviderDisabled(String paramString)
    {
      a.jdMethod_do(a.this, null);
      a.jdMethod_if(a.this, false);
    }

    public void onProviderEnabled(String paramString)
    {
    }

    public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
    {
      switch (paramInt)
      {
      default:
        return;
      case 0:
        a.jdMethod_do(a.this, null);
        a.jdMethod_if(a.this, false);
        return;
      case 1:
        a.jdMethod_if(a.this, System.currentTimeMillis());
        a.jdMethod_do(a.this, true);
        a.jdMethod_if(a.this, false);
        return;
      case 2:
      }
      a.jdMethod_do(a.this, false);
    }
  }

  private class c
    implements LocationListener
  {
    private long jdField_if = 0L;

    private c()
    {
    }

    public void onLocationChanged(Location paramLocation)
    {
      if (a.jdMethod_int(a.this));
      do
        return;
      while ((paramLocation == null) || (paramLocation.getProvider() != "gps") || (System.currentTimeMillis() - this.jdField_if < 10000L) || (!o.jdField_if(paramLocation, false)));
      this.jdField_if = System.currentTimeMillis();
      Message localMessage = a.jdMethod_try(a.this).obtainMessage(4, paramLocation);
      a.jdMethod_try(a.this).sendMessage(localMessage);
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
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.h.a
 * JD-Core Version:    0.6.0
 */