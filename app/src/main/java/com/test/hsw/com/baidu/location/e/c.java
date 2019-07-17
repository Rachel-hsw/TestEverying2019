package com.baidu.location.e;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.h.d;
import com.baidu.location.h.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
  implements f
{
  private static c go = null;
  private boolean gm = false;
  private ArrayList gn = null;
  public boolean gp = true;
  private boolean gq = false;

  private void bl()
  {
    bo();
    bq();
  }

  private void bo()
  {
    Iterator localIterator = this.gn.iterator();
    boolean bool1 = false;
    boolean bool2 = false;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.jdField_do.openGps)
        bool2 = true;
      if (!locala.jdField_do.location_change_notify)
        break label93;
    }
    label93: for (boolean bool3 = true; ; bool3 = bool1)
    {
      bool1 = bool3;
      break;
      k.cm = bool1;
      if (this.gq != bool2)
      {
        this.gq = bool2;
        d.a().jdMethod_else(this.gq);
      }
      return;
    }
  }

  public static c bp()
  {
    if (go == null)
      go = new c();
    return go;
  }

  private a jdMethod_if(Messenger paramMessenger)
  {
    if (this.gn == null)
      return null;
    Iterator localIterator = this.gn.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.jdField_for.equals(paramMessenger))
        return locala;
    }
    return null;
  }

  private void jdMethod_if(a parama)
  {
    if (parama == null)
      return;
    if (jdMethod_if(parama.jdField_for) != null)
    {
      a.a(parama, 14);
      return;
    }
    this.gn.add(parama);
    a.a(parama, 13);
  }

  public void bj()
  {
    Iterator localIterator = this.gn.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).jdMethod_do();
  }

  public void bk()
  {
    Iterator localIterator = this.gn.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).jdMethod_if();
  }

  public boolean bm()
  {
    return this.gp;
  }

  public boolean bn()
  {
    return this.gq;
  }

  public void bq()
  {
    Iterator localIterator = this.gn.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a();
  }

  public void br()
  {
    this.gn.clear();
    bl();
  }

  public String bs()
  {
    StringBuffer localStringBuffer = new StringBuffer(256);
    if (this.gn.isEmpty())
      return "&prod=" + com.baidu.location.b.c.bj + ":" + com.baidu.location.b.c.bn;
    a locala = (a)this.gn.get(0);
    if (locala.jdField_do.prodName != null)
      localStringBuffer.append(locala.jdField_do.prodName);
    if (locala.jdField_int != null)
    {
      localStringBuffer.append(":");
      localStringBuffer.append(locala.jdField_int);
      localStringBuffer.append("|");
    }
    String str = localStringBuffer.toString();
    if ((str != null) && (!str.equals("")))
      return "&prod=" + str;
    return null;
  }

  public int jdMethod_case(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null));
    a locala;
    do
    {
      return 1000;
      locala = jdMethod_if(paramMessage.replyTo);
    }
    while ((locala == null) || (locala.jdField_do == null));
    return locala.jdField_do.scanSpan;
  }

  public void jdMethod_char(Message paramMessage)
  {
    a locala = jdMethod_if(paramMessage.replyTo);
    if (locala != null)
      this.gn.remove(locala);
    i.bW().bY();
    l.ce().cf();
    bl();
  }

  public void jdMethod_do(BDLocation paramBDLocation, int paramInt)
  {
    Iterator localIterator = this.gn.iterator();
    try
    {
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        locala.a(paramBDLocation, paramInt);
        if (locala.jdField_if <= 4)
          continue;
        localIterator.remove();
      }
    }
    catch (Exception localException)
    {
    }
  }

  public int jdMethod_else(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null));
    a locala;
    do
    {
      return 1;
      locala = jdMethod_if(paramMessage.replyTo);
    }
    while ((locala == null) || (locala.jdField_do == null));
    return locala.jdField_do.priority;
  }

  public boolean jdMethod_goto(Message paramMessage)
  {
    boolean bool = true;
    a locala = jdMethod_if(paramMessage.replyTo);
    if (locala == null)
      return false;
    int i = locala.jdField_do.scanSpan;
    locala.jdField_do.scanSpan = paramMessage.getData().getInt("scanSpan", locala.jdField_do.scanSpan);
    if (locala.jdField_do.scanSpan < 1000)
    {
      i.bW().bT();
      l.ce().cf();
      this.gp = false;
      if ((locala.jdField_do.scanSpan <= 999) || (i >= 1000))
        break label393;
      if ((locala.jdField_do.mIsNeedDeviceDirect) || (locala.jdField_do.isNeedAltitude))
      {
        l.ce().jdMethod_case(locala.jdField_do.mIsNeedDeviceDirect);
        l.ce().jdMethod_char(locala.jdField_do.isNeedAltitude);
        l.ce().cc();
      }
    }
    while (true)
    {
      locala.jdField_do.openGps = paramMessage.getData().getBoolean("openGPS", locala.jdField_do.openGps);
      String str1 = paramMessage.getData().getString("coorType");
      LocationClientOption localLocationClientOption1 = locala.jdField_do;
      label208: String str2;
      LocationClientOption localLocationClientOption2;
      if ((str1 != null) && (!str1.equals("")))
      {
        localLocationClientOption1.coorType = str1;
        str2 = paramMessage.getData().getString("addrType");
        localLocationClientOption2 = locala.jdField_do;
        if ((str2 == null) || (str2.equals("")))
          break label381;
      }
      while (true)
      {
        localLocationClientOption2.addrType = str2;
        if (!k.cf.equals(locala.jdField_do.addrType))
          m.a9().bd();
        locala.jdField_do.timeOut = paramMessage.getData().getInt("timeOut", locala.jdField_do.timeOut);
        locala.jdField_do.location_change_notify = paramMessage.getData().getBoolean("location_change_notify", locala.jdField_do.location_change_notify);
        locala.jdField_do.priority = paramMessage.getData().getInt("priority", locala.jdField_do.priority);
        bl();
        return bool;
        i.bW().bU();
        this.gp = bool;
        break;
        str1 = locala.jdField_do.coorType;
        break label208;
        label381: str2 = locala.jdField_do.addrType;
      }
      label393: bool = false;
    }
  }

  public void jdMethod_if(Bundle paramBundle, int paramInt)
  {
    Iterator localIterator = this.gn.iterator();
    try
    {
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        a.a(locala, paramInt, paramBundle);
        if (locala.jdField_if <= 4)
          continue;
        localIterator.remove();
      }
    }
    catch (Exception localException)
    {
    }
  }

  public void jdMethod_if(BDLocation paramBDLocation, Message paramMessage)
  {
    if ((paramBDLocation == null) || (paramMessage == null));
    a locala;
    do
    {
      do
      {
        return;
        locala = jdMethod_if(paramMessage.replyTo);
      }
      while (locala == null);
      locala.a(paramBDLocation);
    }
    while (locala.jdField_if <= 4);
    this.gn.remove(locala);
  }

  public void l(String paramString)
  {
    BDLocation localBDLocation = new BDLocation(paramString);
    Address localAddress = m.a9().jdMethod_new(localBDLocation);
    String str = m.a9().bc();
    List localList = m.a9().be();
    if (localAddress != null)
      localBDLocation.setAddr(localAddress);
    if (str != null)
      localBDLocation.setLocationDescribe(str);
    if (localList != null)
      localBDLocation.setPoiList(localList);
    Iterator localIterator = this.gn.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).jdMethod_if(localBDLocation);
  }

  public void jdMethod_long(Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.replyTo == null))
      return;
    jdMethod_if(new a(paramMessage));
    bl();
  }

  public void jdMethod_try(BDLocation paramBDLocation)
  {
    Iterator localIterator = this.gn.iterator();
    try
    {
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        locala.a(paramBDLocation);
        if (locala.jdField_if <= 4)
          continue;
        localIterator.remove();
      }
    }
    catch (Exception localException)
    {
    }
  }

  private class a
  {
    public LocationClientOption jdField_do = new LocationClientOption();
    public Messenger jdField_for = null;
    public int jdField_if = 0;
    public String jdField_int = null;

    public a(Message arg2)
    {
      Object localObject;
      this.jdField_for = localObject.replyTo;
      this.jdField_int = localObject.getData().getString("packName");
      this.jdField_do.prodName = localObject.getData().getString("prodName");
      com.baidu.location.b.c.N().jdField_if(this.jdField_do.prodName, this.jdField_int);
      this.jdField_do.coorType = localObject.getData().getString("coorType");
      this.jdField_do.addrType = localObject.getData().getString("addrType");
      this.jdField_do.enableSimulateGps = localObject.getData().getBoolean("enableSimulateGps", false);
      boolean bool1;
      if ((k.cj) || (this.jdField_do.enableSimulateGps))
      {
        bool1 = true;
        k.cj = bool1;
        if (!k.cf.equals("all"))
          k.cf = this.jdField_do.addrType;
        this.jdField_do.openGps = localObject.getData().getBoolean("openGPS");
        this.jdField_do.scanSpan = localObject.getData().getInt("scanSpan");
        this.jdField_do.timeOut = localObject.getData().getInt("timeOut");
        this.jdField_do.priority = localObject.getData().getInt("priority");
        this.jdField_do.location_change_notify = localObject.getData().getBoolean("location_change_notify");
        this.jdField_do.mIsNeedDeviceDirect = localObject.getData().getBoolean("needDirect", false);
        this.jdField_do.isNeedAltitude = localObject.getData().getBoolean("isneedaltitude", false);
        if ((!k.bX) && (!localObject.getData().getBoolean("isneedaptag", false)))
          break label433;
      }
      label433: for (boolean bool2 = true; ; bool2 = false)
      {
        k.bX = bool2;
        boolean bool3;
        if (!k.bP)
        {
          boolean bool4 = localObject.getData().getBoolean("isneedaptagd", false);
          bool3 = false;
          if (!bool4);
        }
        else
        {
          bool3 = true;
        }
        k.bP = bool3;
        if (this.jdField_do.scanSpan >= 1000)
          i.bW().bV();
        if ((this.jdField_do.mIsNeedDeviceDirect) || (this.jdField_do.isNeedAltitude))
        {
          l.ce().jdMethod_case(this.jdField_do.mIsNeedDeviceDirect);
          l.ce().jdMethod_char(this.jdField_do.isNeedAltitude);
          l.ce().cc();
        }
        return;
        bool1 = false;
        break;
      }
    }

    private void a(int paramInt)
    {
      Message localMessage = Message.obtain(null, paramInt);
      try
      {
        if (this.jdField_for != null)
          this.jdField_for.send(localMessage);
        this.jdField_if = 0;
        return;
      }
      catch (Exception localException)
      {
        while (!(localException instanceof DeadObjectException));
        this.jdField_if = (1 + this.jdField_if);
      }
    }

    private void a(int paramInt, Bundle paramBundle)
    {
      Message localMessage = Message.obtain(null, paramInt);
      localMessage.setData(paramBundle);
      try
      {
        if (this.jdField_for != null)
          this.jdField_for.send(localMessage);
        this.jdField_if = 0;
        return;
      }
      catch (Exception localException)
      {
        if ((localException instanceof DeadObjectException))
          this.jdField_if = (1 + this.jdField_if);
        localException.printStackTrace();
      }
    }

    private void a(int paramInt, String paramString, BDLocation paramBDLocation)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable(paramString, paramBDLocation);
      Message localMessage = Message.obtain(null, paramInt);
      localMessage.setData(localBundle);
      try
      {
        if (this.jdField_for != null)
          this.jdField_for.send(localMessage);
        this.jdField_if = 0;
        return;
      }
      catch (Exception localException)
      {
        while (!(localException instanceof DeadObjectException));
        this.jdField_if = (1 + this.jdField_if);
      }
    }

    public void a()
    {
      if (this.jdField_do.location_change_notify == true)
      {
        if (k.cG)
          a(54);
      }
      else
        return;
      a(55);
    }

    public void a(BDLocation paramBDLocation)
    {
      a(paramBDLocation, 21);
    }

    public void a(BDLocation paramBDLocation, int paramInt)
    {
      BDLocation localBDLocation = new BDLocation(paramBDLocation);
      if ((l.ce().ca()) && ((localBDLocation.getLocType() == 161) || (localBDLocation.getLocType() == 66)))
        localBDLocation.setAltitude(l.ce().cd());
      if (paramInt == 21)
        a(27, "locStr", localBDLocation);
      double d1;
      double d2;
      if ((this.jdField_do.coorType != null) && (!this.jdField_do.coorType.equals("gcj02")))
      {
        d1 = localBDLocation.getLongitude();
        d2 = localBDLocation.getLatitude();
        if ((d1 != 4.9E-324D) && (d2 != 4.9E-324D))
        {
          if (((localBDLocation.getCoorType() == null) || (!localBDLocation.getCoorType().equals("gcj02"))) && (localBDLocation.getCoorType() != null))
            break label195;
          double[] arrayOfDouble2 = Jni.jdField_if(d1, d2, this.jdField_do.coorType);
          localBDLocation.setLongitude(arrayOfDouble2[0]);
          localBDLocation.setLatitude(arrayOfDouble2[1]);
          localBDLocation.setCoorType(this.jdField_do.coorType);
        }
      }
      while (true)
      {
        a(paramInt, "locStr", localBDLocation);
        return;
        label195: if ((localBDLocation.getCoorType() == null) || (!localBDLocation.getCoorType().equals("wgs84")) || (this.jdField_do.coorType.equals("bd09ll")))
          continue;
        double[] arrayOfDouble1 = Jni.jdField_if(d1, d2, "wgs842mc");
        localBDLocation.setLongitude(arrayOfDouble1[0]);
        localBDLocation.setLatitude(arrayOfDouble1[1]);
        localBDLocation.setCoorType("wgs84mc");
      }
    }

    public void jdField_do()
    {
      a(111);
    }

    public void jdField_if()
    {
      a(23);
    }

    public void jdField_if(BDLocation paramBDLocation)
    {
      if (this.jdField_do.location_change_notify == true)
        a(paramBDLocation);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.c
 * JD-Core Version:    0.6.0
 */