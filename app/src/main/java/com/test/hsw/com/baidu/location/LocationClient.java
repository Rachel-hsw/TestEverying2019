package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.b.j;
import com.baidu.location.d.a;
import com.baidu.location.e.p;
import com.baidu.location.e.p.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class LocationClient
  implements com.baidu.location.b.f, p.a
{
  private static final int lA = 9;
  private static final int lC = 7;
  private static final int lK = 5;
  private static final int lL = 12;
  private static final int lN = 6;
  private static final int lO = 2;
  private static final int lV = 11;
  private static final int lZ = 4;
  private static final int lk = 10;
  private static final String lm = "baidu_location_Client";
  private static final int lp = 1;
  private static final int lt = 1000;
  private static final int lw = 3;
  private static final int lx = 8;
  private boolean l0 = true;
  private p l1 = null;
  private ArrayList l2 = null;
  private boolean lB = false;
  private boolean lD;
  private final Messenger lE = new Messenger(this.ll);
  private Context lF = null;
  private boolean lG = false;
  private Messenger lH = null;
  private long lI = 0L;
  private LocationClientOption lJ = new LocationClientOption();
  private Boolean lM = Boolean.valueOf(true);
  private boolean lP = false;
  private long lQ = 0L;
  private long lR = 0L;
  private ServiceConnection lS = new LocationClient.1(this);
  private String lT;
  private BDLocation lU = null;
  private String lW = null;
  private boolean lX = false;
  private String lY = null;
  private boolean lj = false;
  private a ll = new a(null);
  private boolean ln = false;
  private final Object lo = new Object();
  private b lq = null;
  private Boolean lr = Boolean.valueOf(false);
  private a ls = null;
  private Boolean lu = Boolean.valueOf(false);
  private boolean lv = false;
  private BDLocationListener ly = null;
  private boolean lz = false;

  public LocationClient(Context paramContext)
  {
    this.lF = paramContext;
    this.lJ = new LocationClientOption();
  }

  public LocationClient(Context paramContext, LocationClientOption paramLocationClientOption)
  {
    this.lF = paramContext;
    this.lJ = paramLocationClientOption;
    if (this.l1 == null)
    {
      this.l1 = new p(this.lF, this.lJ, this);
      this.l1.cq();
    }
  }

  private void jdMethod_byte(BDLocation paramBDLocation)
  {
    if (this.l0);
    while (true)
    {
      return;
      this.lU = paramBDLocation;
      if ((!this.ln) && (paramBDLocation.getLocType() == 161))
        this.lG = true;
      if (this.l2 == null)
        continue;
      Iterator localIterator = this.l2.iterator();
      while (localIterator.hasNext())
        ((BDLocationListener)localIterator.next()).onReceiveLocation(paramBDLocation);
    }
  }

  private void d(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null));
    BDLocationListener localBDLocationListener;
    do
    {
      return;
      localBDLocationListener = (BDLocationListener)paramMessage.obj;
    }
    while ((this.l2 == null) || (!this.l2.contains(localBDLocationListener)));
    this.l2.remove(localBDLocationListener);
  }

  private Bundle dH()
  {
    if (this.lJ == null)
      return null;
    Bundle localBundle = new Bundle();
    localBundle.putString("packName", this.lY);
    localBundle.putString("prodName", this.lJ.prodName);
    localBundle.putString("coorType", this.lJ.coorType);
    localBundle.putString("addrType", this.lJ.addrType);
    localBundle.putBoolean("openGPS", this.lJ.openGps);
    localBundle.putBoolean("location_change_notify", this.lJ.location_change_notify);
    localBundle.putInt("scanSpan", this.lJ.scanSpan);
    localBundle.putInt("timeOut", this.lJ.timeOut);
    localBundle.putInt("priority", this.lJ.priority);
    localBundle.putBoolean("map", this.lu.booleanValue());
    localBundle.putBoolean("import", this.lr.booleanValue());
    localBundle.putBoolean("needDirect", this.lJ.mIsNeedDeviceDirect);
    localBundle.putBoolean("isneedaptag", this.lJ.isNeedAptag);
    localBundle.putBoolean("isneedpoiregion", this.lJ.isNeedPoiRegion);
    localBundle.putBoolean("isneedregular", this.lJ.isNeedRegular);
    localBundle.putBoolean("isneedaptagd", this.lJ.isNeedAptagd);
    localBundle.putBoolean("isneedaltitude", this.lJ.isNeedAltitude);
    return localBundle;
  }

  private void dI()
  {
    if (this.lP == true)
      return;
    if (this.lM.booleanValue())
    {
      if (this.l1 == null)
      {
        this.l1 = new p(this.lF, this.lJ, this);
        this.l1.cq();
      }
      this.l1.cp();
      this.lM = Boolean.valueOf(false);
    }
    this.lY = this.lF.getPackageName();
    this.lW = (this.lY + "_bdls_v2.9");
    Intent localIntent = new Intent(this.lF, f.class);
    try
    {
      localIntent.putExtra("debug_dev", this.lD);
      label134: if (this.lJ == null)
        this.lJ = new LocationClientOption();
      localIntent.putExtra("cache_exception", this.lJ.isIgnoreCacheException);
      localIntent.putExtra("kill_process", this.lJ.isIgnoreKillProcess);
      try
      {
        this.lF.bindService(localIntent, this.lS, 1);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        this.lP = false;
        return;
      }
    }
    catch (Exception localException1)
    {
      break label134;
    }
  }

  // ERROR //
  private void dJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/baidu/location/LocationClient:lP	Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 106	com/baidu/location/LocationClient:lH	Landroid/os/Messenger;
    //   11: ifnonnull +4 -> 15
    //   14: return
    //   15: aconst_null
    //   16: bipush 12
    //   18: invokestatic 389	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   21: astore_1
    //   22: aload_1
    //   23: aload_0
    //   24: getfield 120	com/baidu/location/LocationClient:lE	Landroid/os/Messenger;
    //   27: putfield 392	android/os/Message:replyTo	Landroid/os/Messenger;
    //   30: aload_0
    //   31: getfield 106	com/baidu/location/LocationClient:lH	Landroid/os/Messenger;
    //   34: aload_1
    //   35: invokevirtual 395	android/os/Messenger:send	(Landroid/os/Message;)V
    //   38: aload_0
    //   39: getfield 104	com/baidu/location/LocationClient:lF	Landroid/content/Context;
    //   42: aload_0
    //   43: getfield 175	com/baidu/location/LocationClient:lS	Landroid/content/ServiceConnection;
    //   46: invokevirtual 399	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   49: aload_0
    //   50: getfield 136	com/baidu/location/LocationClient:lo	Ljava/lang/Object;
    //   53: astore 4
    //   55: aload 4
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 130	com/baidu/location/LocationClient:lB	Z
    //   62: iconst_1
    //   63: if_icmpne +19 -> 82
    //   66: aload_0
    //   67: getfield 113	com/baidu/location/LocationClient:ll	Lcom/baidu/location/LocationClient$a;
    //   70: aload_0
    //   71: getfield 132	com/baidu/location/LocationClient:lq	Lcom/baidu/location/LocationClient$b;
    //   74: invokevirtual 403	com/baidu/location/LocationClient$a:removeCallbacks	(Ljava/lang/Runnable;)V
    //   77: aload_0
    //   78: iconst_0
    //   79: putfield 130	com/baidu/location/LocationClient:lB	Z
    //   82: aload 4
    //   84: monitorexit
    //   85: aload_0
    //   86: getfield 142	com/baidu/location/LocationClient:ls	Lcom/baidu/location/d/a;
    //   89: ifnull +10 -> 99
    //   92: aload_0
    //   93: getfield 142	com/baidu/location/LocationClient:ls	Lcom/baidu/location/d/a;
    //   96: invokevirtual 408	com/baidu/location/d/a:a2	()V
    //   99: aload_0
    //   100: aconst_null
    //   101: putfield 106	com/baidu/location/LocationClient:lH	Landroid/os/Messenger;
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 128	com/baidu/location/LocationClient:lX	Z
    //   109: aload_0
    //   110: iconst_0
    //   111: putfield 148	com/baidu/location/LocationClient:lv	Z
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 102	com/baidu/location/LocationClient:lP	Z
    //   119: aload_0
    //   120: iconst_0
    //   121: putfield 166	com/baidu/location/LocationClient:lG	Z
    //   124: aload_0
    //   125: iconst_0
    //   126: putfield 168	com/baidu/location/LocationClient:ln	Z
    //   129: return
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   135: goto -97 -> 38
    //   138: astore 6
    //   140: aload 4
    //   142: monitorexit
    //   143: aload 6
    //   145: athrow
    //   146: astore 5
    //   148: goto -66 -> 82
    //   151: astore_3
    //   152: goto -103 -> 49
    //
    // Exception table:
    //   from	to	target	type
    //   30	38	130	java/lang/Exception
    //   58	82	138	finally
    //   82	85	138	finally
    //   140	143	138	finally
    //   58	82	146	java/lang/Exception
    //   38	49	151	java/lang/Exception
  }

  private void dK()
  {
    if (this.lH == null)
      return;
    Message localMessage = Message.obtain(null, 22);
    try
    {
      localMessage.replyTo = this.lE;
      this.lH.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void dL()
  {
    Message localMessage = Message.obtain(null, 28);
    try
    {
      localMessage.replyTo = this.lE;
      this.lH.send(localMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void dM()
  {
    if (this.lH == null)
      return;
    Message localMessage;
    if (((System.currentTimeMillis() - this.lI > 3000L) || (!this.lJ.location_change_notify) || (this.lX)) && ((!this.lv) || (System.currentTimeMillis() - this.lR > 20000L) || (this.lX)))
    {
      localMessage = Message.obtain(null, 22);
      if (this.lX)
      {
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isWaitingLocTag", this.lX);
        localMessage.setData(localBundle);
      }
    }
    try
    {
      localMessage.replyTo = this.lE;
      this.lH.send(localMessage);
      this.lQ = System.currentTimeMillis();
      this.lz = true;
      synchronized (this.lo)
      {
        if ((this.lJ != null) && (this.lJ.scanSpan >= 1000) && (!this.lB))
        {
          if (this.lq == null)
            this.lq = new b(null);
          this.ll.postDelayed(this.lq, this.lJ.scanSpan);
          this.lB = true;
        }
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private void e(Message paramMessage)
  {
    this.lX = false;
    if ((paramMessage == null) || (paramMessage.obj == null));
    while (true)
    {
      return;
      LocationClientOption localLocationClientOption = (LocationClientOption)paramMessage.obj;
      if (this.lJ.equals(localLocationClientOption))
        continue;
      if (this.lJ.scanSpan != localLocationClientOption.scanSpan);
      try
      {
        synchronized (this.lo)
        {
          if (this.lB == true)
          {
            this.ll.removeCallbacks(this.lq);
            this.lB = false;
          }
          if ((localLocationClientOption.scanSpan >= 1000) && (!this.lB))
          {
            if (this.lq == null)
              this.lq = new b(null);
            this.ll.postDelayed(this.lq, localLocationClientOption.scanSpan);
            this.lB = true;
          }
          label145: this.lJ = new LocationClientOption(localLocationClientOption);
          if (this.lH == null)
            continue;
          try
          {
            Message localMessage = Message.obtain(null, 15);
            localMessage.replyTo = this.lE;
            localMessage.setData(dH());
            this.lH.send(localMessage);
            return;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        break label145;
      }
    }
  }

  public static BDLocation getBDLocationInCoorType(BDLocation paramBDLocation, String paramString)
  {
    BDLocation localBDLocation = new BDLocation(paramBDLocation);
    double[] arrayOfDouble = Jni.jdMethod_if(paramBDLocation.getLongitude(), paramBDLocation.getLatitude(), paramString);
    localBDLocation.setLatitude(arrayOfDouble[1]);
    localBDLocation.setLongitude(arrayOfDouble[0]);
    return localBDLocation;
  }

  private void h(Message paramMessage)
  {
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(BDLocation.class.getClassLoader());
    BDLocation localBDLocation = (BDLocation)localBundle.getParcelable("locStr");
    if ((this.ly == null) || ((this.lJ != null) && (this.lJ.isDisableCache()) && (localBDLocation.getLocType() == 65)))
      return;
    this.ly.onReceiveLocation(localBDLocation);
  }

  private void i(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null));
    BDNotifyListener localBDNotifyListener;
    do
    {
      return;
      localBDNotifyListener = (BDNotifyListener)paramMessage.obj;
    }
    while (this.ls == null);
    this.ls.jdMethod_for(localBDNotifyListener);
  }

  private void jdMethod_if(Message paramMessage, int paramInt)
  {
    if (!this.lP)
      return;
    Bundle localBundle = paramMessage.getData();
    localBundle.setClassLoader(BDLocation.class.getClassLoader());
    this.lU = ((BDLocation)localBundle.getParcelable("locStr"));
    if (this.lU.getLocType() == 61)
      this.lI = System.currentTimeMillis();
    k(paramInt);
  }

  private void j(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null));
    BDLocationListener localBDLocationListener;
    do
    {
      return;
      localBDLocationListener = (BDLocationListener)paramMessage.obj;
      if (this.l2 != null)
        continue;
      this.l2 = new ArrayList();
    }
    while (this.l2.contains(localBDLocationListener));
    this.l2.add(localBDLocationListener);
  }

  private void k(int paramInt)
  {
    if (this.lU.getCoorType() == null)
      this.lU.setCoorType(this.lJ.coorType);
    if ((this.lz == true) || ((this.lJ.location_change_notify == true) && (this.lU.getLocType() == 61)) || (this.lU.getLocType() == 66) || (this.lU.getLocType() == 67) || (this.lv) || (this.lU.getLocType() == 161))
    {
      if (this.l2 != null)
      {
        Iterator localIterator = this.l2.iterator();
        while (localIterator.hasNext())
          ((BDLocationListener)localIterator.next()).onReceiveLocation(this.lU);
      }
      if ((this.lU.getLocType() != 66) && (this.lU.getLocType() != 67));
    }
    else
    {
      return;
    }
    this.lz = false;
    this.lR = System.currentTimeMillis();
  }

  private void k(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null))
      return;
    this.ly = ((BDLocationListener)paramMessage.obj);
  }

  private void jdMethod_void(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.obj == null))
      return;
    BDNotifyListener localBDNotifyListener = (BDNotifyListener)paramMessage.obj;
    if (this.ls == null)
      this.ls = new a(this.lF, this);
    this.ls.jdMethod_do(localBDNotifyListener);
  }

  public String getAccessKey()
  {
    try
    {
      this.lT = j.a(this.lF);
      if (TextUtils.isEmpty(this.lT))
        throw new IllegalStateException("please setting key from Manifest.xml");
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.lT;
      arrayOfObject[1] = j.jdMethod_if(this.lF);
      String str = String.format("KEY=%s;SHA1=%s", arrayOfObject);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public BDLocation getLastKnownLocation()
  {
    return this.lU;
  }

  public LocationClientOption getLocOption()
  {
    return this.lJ;
  }

  public String getVersion()
  {
    return "6.1.3";
  }

  public boolean isStarted()
  {
    return this.lP;
  }

  public void onReceiveLocation(BDLocation paramBDLocation)
  {
    if ((this.ln == true) && (!this.lG));
    do
      return;
    while (paramBDLocation == null);
    Message localMessage = this.ll.obtainMessage(701);
    localMessage.obj = paramBDLocation;
    localMessage.sendToTarget();
  }

  public void registerLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null)
      throw new IllegalStateException("please set a non-null listener");
    Message localMessage = this.ll.obtainMessage(5);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }

  public void registerNotify(BDNotifyListener paramBDNotifyListener)
  {
    Message localMessage = this.ll.obtainMessage(9);
    localMessage.obj = paramBDNotifyListener;
    localMessage.sendToTarget();
  }

  public void registerNotifyLocationListener(BDLocationListener paramBDLocationListener)
  {
    Message localMessage = this.ll.obtainMessage(8);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }

  public void removeNotifyEvent(BDNotifyListener paramBDNotifyListener)
  {
    Message localMessage = this.ll.obtainMessage(10);
    localMessage.obj = paramBDNotifyListener;
    localMessage.sendToTarget();
  }

  public int requestLocation()
  {
    if ((this.lH == null) || (this.lE == null))
      return 1;
    if ((this.l2 == null) || (this.l2.size() < 1))
      return 2;
    if (System.currentTimeMillis() - this.lQ < 1000L)
      return 6;
    Message localMessage = this.ll.obtainMessage(4);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
    return 0;
  }

  public void requestNotifyLocation()
  {
    this.ll.obtainMessage(11).sendToTarget();
  }

  public int requestOfflineLocation()
  {
    if ((this.lH == null) || (this.lE == null))
      return 1;
    if ((this.l2 == null) || (this.l2.size() < 1))
      return 2;
    this.ll.obtainMessage(12).sendToTarget();
    return 0;
  }

  public void setLocOption(LocationClientOption paramLocationClientOption)
  {
    if (paramLocationClientOption == null)
      paramLocationClientOption = new LocationClientOption();
    if (this.l1 == null)
    {
      this.l1 = new p(this.lF, paramLocationClientOption, this);
      this.l1.cq();
    }
    Message localMessage = this.ll.obtainMessage(3);
    localMessage.obj = paramLocationClientOption;
    localMessage.sendToTarget();
  }

  public void start()
  {
    this.l0 = false;
    this.ll.obtainMessage(1).sendToTarget();
  }

  public void stop()
  {
    this.l0 = true;
    this.ll.obtainMessage(2).sendToTarget();
    this.l1 = null;
  }

  public void unRegisterLocationListener(BDLocationListener paramBDLocationListener)
  {
    if (paramBDLocationListener == null)
      throw new IllegalStateException("please set a non-null listener");
    Message localMessage = this.ll.obtainMessage(6);
    localMessage.obj = paramBDLocationListener;
    localMessage.sendToTarget();
  }

  public boolean updateLocation(Location paramLocation)
  {
    if ((this.lH == null) || (this.lE == null) || (paramLocation == null))
      return false;
    try
    {
      Message localMessage = Message.obtain(null, 57);
      localMessage.obj = paramLocation;
      this.lH.send(localMessage);
      return true;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private class a extends Handler
  {
    private a()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default:
        super.handleMessage(paramMessage);
      case 7:
      case 3:
      case 8:
      case 5:
      case 6:
      case 9:
      case 10:
      case 1:
      case 2:
      case 11:
      case 4:
      case 12:
      case 54:
      case 55:
      case 21:
        BDLocation localBDLocation;
        do
        {
          do
          {
            do
            {
              return;
              LocationClient.jdMethod_byte(LocationClient.this, paramMessage);
              return;
              LocationClient.jdMethod_try(LocationClient.this, paramMessage);
              return;
              LocationClient.jdMethod_new(LocationClient.this, paramMessage);
              return;
              LocationClient.jdMethod_int(LocationClient.this, paramMessage);
              return;
              LocationClient.jdMethod_do(LocationClient.this, paramMessage);
              return;
              LocationClient.jdMethod_for(LocationClient.this, paramMessage);
              return;
              LocationClient.jdMethod_for(LocationClient.this);
              return;
              LocationClient.jdMethod_else(LocationClient.this);
              return;
              LocationClient.i(LocationClient.this);
              return;
              LocationClient.jdMethod_byte(LocationClient.this);
              return;
              LocationClient.e(LocationClient.this);
              return;
            }
            while (!LocationClient.jdMethod_char(LocationClient.this).location_change_notify);
            LocationClient.jdMethod_do(LocationClient.this, true);
            return;
          }
          while (!LocationClient.jdMethod_char(LocationClient.this).location_change_notify);
          LocationClient.jdMethod_do(LocationClient.this, false);
          return;
          Bundle localBundle = paramMessage.getData();
          localBundle.setClassLoader(BDLocation.class.getClassLoader());
          localBDLocation = (BDLocation)localBundle.getParcelable("locStr");
        }
        while ((!LocationClient.jdMethod_goto(LocationClient.this)) && (LocationClient.j(LocationClient.this) == true) && (localBDLocation.getLocType() == 66));
        if ((!LocationClient.jdMethod_goto(LocationClient.this)) && (LocationClient.j(LocationClient.this) == true))
        {
          LocationClient.jdMethod_if(LocationClient.this, true);
          return;
        }
        if (!LocationClient.jdMethod_goto(LocationClient.this))
          LocationClient.jdMethod_if(LocationClient.this, true);
        LocationClient.jdMethod_if(LocationClient.this, paramMessage, 21);
        return;
      case 26:
        LocationClient.jdMethod_if(LocationClient.this, paramMessage, 26);
        return;
      case 27:
        LocationClient.jdMethod_if(LocationClient.this, paramMessage);
        return;
      case 701:
      }
      LocationClient.jdMethod_if(LocationClient.this, (BDLocation)paramMessage.obj);
    }
  }

  private class b
    implements Runnable
  {
    private b()
    {
    }

    public void run()
    {
      synchronized (LocationClient.jdMethod_long(LocationClient.this))
      {
        LocationClient.jdMethod_int(LocationClient.this, false);
        if ((LocationClient.h(LocationClient.this) == null) || (LocationClient.jdMethod_try(LocationClient.this) == null))
          return;
        if ((LocationClient.d(LocationClient.this) == null) || (LocationClient.d(LocationClient.this).size() < 1))
          return;
      }
      if (LocationClient.jdMethod_if(LocationClient.this))
      {
        if (LocationClient.jdMethod_void(LocationClient.this) == null)
          LocationClient.jdMethod_if(LocationClient.this, new b(LocationClient.this));
        LocationClient.jdMethod_new(LocationClient.this).postDelayed(LocationClient.jdMethod_void(LocationClient.this), LocationClient.jdMethod_char(LocationClient.this).scanSpan);
        monitorexit;
        return;
      }
      LocationClient.jdMethod_new(LocationClient.this).obtainMessage(4).sendToTarget();
      monitorexit;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.LocationClient
 * JD-Core Version:    0.6.0
 */