package com.baidu.location.e;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.c.d.b;
import com.baidu.location.c.d.c;
import com.baidu.location.h.e;
import com.baidu.location.h.g;
import java.util.List;

public class m extends b
  implements com.baidu.location.b.f
{
  private static m fW = null;
  private String f0 = null;
  private com.baidu.location.h.h f1 = null;
  private List f2 = null;
  private long f3 = 0L;
  private long f4 = 0L;
  private com.baidu.location.h.h f5 = null;
  private boolean f6 = false;
  private boolean f7 = false;
  private double f8;
  private com.baidu.location.h.f f9 = null;
  public final Handler fP = new b.b(this);
  final int fS = 1000;
  public b.a fT = null;
  private volatile boolean fU = false;
  private boolean fV = false;
  private long fX = 0L;
  private boolean fY = false;
  private b fZ = null;
  private boolean ga = false;
  private double gb;
  private long gc = 0L;
  private boolean gd = true;
  private boolean ge = true;
  private boolean gf = true;
  private Address gg = null;
  private BDLocation gh = null;
  private BDLocation gi = null;
  final int gj = 2000;
  private String gk = null;
  private com.baidu.location.h.f gl = null;

  private boolean a6()
  {
    return true;
  }

  private void a7()
  {
    this.fU = false;
    this.fY = false;
    this.gf = false;
    this.fV = false;
    bi();
  }

  public static m a9()
  {
    if (fW == null)
      fW = new m();
    return fW;
  }

  private boolean bg()
  {
    double d = Math.random();
    long l = SystemClock.uptimeMillis();
    com.baidu.location.h.h localh = com.baidu.location.h.c.a().cM();
    com.baidu.location.h.f localf = com.baidu.location.h.l.a().c6();
    if ((localh != null) && (localh.dy()) && ((localf == null) || (localf.dl() == 0)));
    for (int i = 1; ; i = 0)
    {
      boolean bool1 = com.baidu.location.c.d.jdMethod_try().jdMethod_long();
      BDLocation localBDLocation1 = null;
      if (bool1)
      {
        boolean bool4 = com.baidu.location.c.d.jdMethod_try().jdMethod_case();
        localBDLocation1 = null;
        if (bool4)
          if (i == 0)
          {
            boolean bool5 = 0.0D < d;
            localBDLocation1 = null;
            if (bool5)
            {
              boolean bool6 = d < com.baidu.location.c.d.jdMethod_try().jdMethod_byte();
              localBDLocation1 = null;
              if (!bool6);
            }
          }
          else
          {
            localBDLocation1 = com.baidu.location.c.d.jdMethod_try().jdMethod_if(com.baidu.location.h.c.a().cM(), com.baidu.location.h.l.a().c6(), null, d.c.do, d.b.a);
          }
      }
      int j = 0;
      if (localBDLocation1 != null)
      {
        int k = localBDLocation1.getLocType();
        j = 0;
        if (k == 66)
        {
          boolean bool2 = this.fU;
          j = 0;
          if (bool2)
          {
            com.baidu.location.b.l locall = new com.baidu.location.b.l();
            locall.jdMethod_do(this.fX);
            locall.jdMethod_if(l);
            locall.jdMethod_for(l);
            locall.jdMethod_int(SystemClock.uptimeMillis());
            locall.jdMethod_char("ofs");
            if (this.f5 != null)
            {
              locall.jdMethod_else(this.f5.dx());
              locall.jdMethod_else("&offtag=1");
            }
            BDLocation localBDLocation2 = new BDLocation(localBDLocation1);
            localBDLocation2.setLocType(161);
            boolean bool3 = this.fU;
            j = 0;
            if (bool3)
            {
              com.baidu.location.b.o.aX().jdMethod_if(locall);
              this.fY = true;
              c.bp().jdMethod_try(localBDLocation2);
              this.gh = localBDLocation2;
              j = 1;
            }
          }
        }
      }
      return j;
    }
  }

  private void bi()
  {
    if (this.gh != null)
      o.cm().co();
  }

  private void jdMethod_byte(Message paramMessage)
  {
    if (com.baidu.location.h.d.a().cH())
    {
      jdMethod_for(paramMessage);
      return;
    }
    jdMethod_int(paramMessage);
  }

  private boolean jdMethod_do(com.baidu.location.h.f paramf)
  {
    int i = 1;
    this.fR = com.baidu.location.h.l.a().dc();
    if (paramf == this.fR)
      i = 0;
    do
      return i;
    while ((this.fR == null) || (paramf == null) || (!paramf.jdMethod_try(this.fR)));
    return false;
  }

  private boolean jdMethod_do(com.baidu.location.h.h paramh)
  {
    int i = 1;
    this.fQ = com.baidu.location.h.c.a().cM();
    if (this.fQ == paramh)
      i = 0;
    do
      return i;
    while ((this.fQ == null) || (paramh == null) || (!paramh.jdMethod_case(this.fQ)));
    return false;
  }

  private void jdMethod_for(Message paramMessage)
  {
    BDLocation localBDLocation = new BDLocation(com.baidu.location.h.d.a().cD());
    if ((com.baidu.location.b.k.cf.equals("all")) || (com.baidu.location.b.k.bX) || (com.baidu.location.b.k.bP))
    {
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.gb, this.f8, localBDLocation.getLatitude(), localBDLocation.getLongitude(), arrayOfFloat);
      if (arrayOfFloat[0] >= 100.0F)
        break label136;
      if (this.gg != null)
        localBDLocation.setAddr(this.gg);
      if (this.f0 != null)
        localBDLocation.setLocationDescribe(this.f0);
      if (this.f2 != null)
        localBDLocation.setPoiList(this.f2);
    }
    while (true)
    {
      this.gh = localBDLocation;
      this.gi = null;
      c.bp().jdMethod_if(localBDLocation, paramMessage);
      return;
      label136: this.fV = true;
      jdMethod_int(null);
    }
  }

  private boolean jdMethod_if(com.baidu.location.h.f paramf)
  {
    int i = 1;
    if (paramf == null)
      i = 0;
    do
      return i;
    while ((this.gl == null) || (!e.jdMethod_if(paramf, this.gl, 0.1F)));
    return false;
  }

  private boolean jdMethod_if(com.baidu.location.h.h paramh)
  {
    int i = 1;
    if (paramh == null)
      i = 0;
    do
      return i;
    while ((this.f1 == null) || (!paramh.jdMethod_case(this.f1)));
    return false;
  }

  private void jdMethod_int(Message paramMessage)
  {
    if (this.ge)
    {
      this.fX = SystemClock.uptimeMillis();
      jdMethod_new(paramMessage);
    }
    do
      return;
    while (this.fU);
    this.fX = SystemClock.uptimeMillis();
    if (com.baidu.location.h.l.a().c3())
    {
      this.ga = true;
      this.fP.postDelayed(new a(null), 2000L);
      return;
    }
    jdMethod_new(paramMessage);
  }

  private void jdMethod_new(Message paramMessage)
  {
    if (this.fU);
    String str;
    while (true)
    {
      return;
      if ((System.currentTimeMillis() - this.f3 < 1000L) && (this.gh != null))
      {
        c.bp().jdMethod_try(this.gh);
        a7();
        return;
      }
      if (this.fX > 0L)
        com.baidu.location.b.o.aX().aU().jdMethod_do(this.fX);
      while (true)
      {
        this.fU = true;
        this.gd = jdMethod_do(this.f5);
        if ((jdMethod_do(this.f9)) || (this.gd) || (this.gh == null) || (this.fV))
          break;
        if ((this.gi != null) && (System.currentTimeMillis() - this.f4 > 30000L))
        {
          this.gh = this.gi;
          this.gi = null;
        }
        if (l.ce().cb())
          this.gh.setDirection(l.ce().cg());
        c.bp().jdMethod_try(this.gh);
        a7();
        return;
        com.baidu.location.b.o.aX().aU().jdMethod_do(SystemClock.uptimeMillis());
      }
      str = k(null);
      if (str != null)
        break;
      if (this.gh != null)
      {
        c.bp().jdMethod_try(this.gh);
        a7();
        return;
      }
      BDLocation localBDLocation = new BDLocation();
      localBDLocation.setLocType(62);
      c.bp().jdMethod_try(localBDLocation);
      a7();
      long l2 = System.currentTimeMillis();
      if (l2 - this.gc <= 60000L)
        continue;
      this.gc = l2;
      com.baidu.location.b.o.aX().j("TypeCriteriaException");
      return;
    }
    if (this.gk != null)
    {
      str = str + this.gk;
      this.gk = null;
    }
    com.baidu.location.b.o.aX().aU().jdMethod_if(SystemClock.uptimeMillis());
    this.fT.jdMethod_long(str);
    this.f5 = this.fQ;
    this.f9 = this.fR;
    if ((this.f5 != null) && (this.f5.dt() == 0))
    {
      new com.baidu.location.g.b(this.f5, this.f9, true).cz();
      a7();
    }
    while (true)
    {
      if (this.ge == true)
      {
        this.ge = false;
        if ((com.baidu.location.h.l.a().c9()) && (paramMessage != null) && (c.bp().jdMethod_case(paramMessage) < 1000) && (com.baidu.location.c.d.jdMethod_try().jdMethod_long()))
          new m.1(this).start();
      }
      this.f3 = System.currentTimeMillis();
      return;
      if (bg())
      {
        this.f5 = this.fQ;
        this.f9 = this.fR;
      }
      if (!com.baidu.location.c.d.jdMethod_try().i())
        continue;
      if (this.fZ == null)
        this.fZ = new b(null);
      long l1 = com.baidu.location.c.d.jdMethod_try().jdMethod_if(com.baidu.location.h.c.a(com.baidu.location.h.c.a().cP()));
      this.fP.postDelayed(this.fZ, l1);
      this.f6 = true;
    }
  }

  private void jdMethod_try(Message paramMessage)
  {
    if (paramMessage.getData().getBoolean("isWaitingLocTag", false))
      j.b1().b0();
    int i = c.bp().jdMethod_else(paramMessage);
    switch (i)
    {
    default:
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i);
      throw new IllegalArgumentException(String.format("this type %d is illegal", arrayOfObject));
    case 3:
      if (com.baidu.location.h.d.a().cH())
        jdMethod_for(paramMessage);
      return;
    case 1:
      jdMethod_byte(paramMessage);
      return;
    case 2:
    }
    jdMethod_int(paramMessage);
  }

  public void a4()
  {
    int i = 1;
    if ((this.fZ != null) && (this.f6))
    {
      this.f6 = false;
      this.fP.removeCallbacks(this.fZ);
    }
    for (int j = i; ; j = 0)
    {
      if (com.baidu.location.h.d.a().cH())
      {
        BDLocation localBDLocation1 = new BDLocation(com.baidu.location.h.d.a().cD());
        if ((com.baidu.location.b.k.cf.equals("all")) || (com.baidu.location.b.k.bX) || (com.baidu.location.b.k.bP))
        {
          float[] arrayOfFloat = new float[2];
          Location.distanceBetween(this.gb, this.f8, localBDLocation1.getLatitude(), localBDLocation1.getLongitude(), arrayOfFloat);
          if (arrayOfFloat[0] < 100.0F)
          {
            if (this.gg != null)
              localBDLocation1.setAddr(this.gg);
            if (this.f0 != null)
              localBDLocation1.setLocationDescribe(this.f0);
            if (this.f2 != null)
              localBDLocation1.setPoiList(this.f2);
          }
        }
        c.bp().jdMethod_do(localBDLocation1, 21);
        a7();
        return;
      }
      if (this.fY)
      {
        a7();
        return;
      }
      com.baidu.location.b.o.aX().aU().jdMethod_for(SystemClock.uptimeMillis());
      BDLocation localBDLocation3;
      if (j != 0)
      {
        if ((!com.baidu.location.c.d.jdMethod_try().jdMethod_long()) || (!com.baidu.location.c.d.jdMethod_try().e()))
          break label569;
        localBDLocation3 = com.baidu.location.c.d.jdMethod_try().jdMethod_if(com.baidu.location.h.c.a().cM(), com.baidu.location.h.l.a().c6(), null, d.c.if, d.b.a);
        if ((localBDLocation3 != null) && (localBDLocation3.getLocType() == 66))
          c.bp().jdMethod_do(localBDLocation3, 21);
      }
      while (true)
      {
        if ((localBDLocation3 == null) || (localBDLocation3.getLocType() == 67))
        {
          if ((!this.gd) && (this.gh != null))
            break label471;
          localBDLocation3 = com.baidu.location.c.b.aZ().jdMethod_byte(false);
          c.bp().jdMethod_do(localBDLocation3, 21);
          if ((com.baidu.location.b.k.cf.equals("all")) && (localBDLocation3.getAddrStr() == null))
            i = 0;
          if ((com.baidu.location.b.k.bX) && (localBDLocation3.getLocationDescribe() == null))
            i = 0;
          if ((com.baidu.location.b.k.bP) && (localBDLocation3.getPoiList() == null))
            i = 0;
          if (i == 0)
            localBDLocation3.setLocType(67);
        }
        com.baidu.location.b.o.aX().aU().jdMethod_int(SystemClock.uptimeMillis());
        if ((localBDLocation3 != null) && (localBDLocation3.getLocType() != 67))
        {
          this.gh = localBDLocation3;
          com.baidu.location.b.o.aX().aU().jdMethod_char("ofs");
          if (this.f5 != null)
            com.baidu.location.b.o.aX().aU().jdMethod_else(this.f5.dx());
          com.baidu.location.b.o.aX().aW();
        }
        while (true)
        {
          this.gi = null;
          a7();
          return;
          label471: c.bp().jdMethod_do(this.gh, 21);
          break;
          this.gh = null;
          com.baidu.location.b.o.aX().aU().jdMethod_char("off");
          if (this.f5 != null)
            com.baidu.location.b.o.aX().aU().jdMethod_else(this.f5.dx());
          com.baidu.location.b.o.aX().aW();
          continue;
          BDLocation localBDLocation2 = new BDLocation();
          localBDLocation2.setLocType(63);
          this.gh = null;
          c.bp().jdMethod_do(localBDLocation2, 21);
        }
        label569: localBDLocation3 = null;
      }
    }
  }

  public BDLocation a5()
  {
    return this.gh;
  }

  public void a8()
  {
    if (this.ga)
    {
      jdMethod_new(null);
      this.ga = false;
    }
  }

  public void ba()
  {
    this.fU = false;
    this.ga = false;
    this.fY = false;
    this.gf = true;
    bd();
    this.f7 = false;
  }

  public void bb()
  {
    BDLocation localBDLocation2;
    BDLocation localBDLocation1;
    if ((com.baidu.location.c.d.jdMethod_try().jdMethod_long()) && (com.baidu.location.c.d.jdMethod_try().jdMethod_goto()))
    {
      localBDLocation2 = com.baidu.location.c.d.jdMethod_try().jdMethod_if(com.baidu.location.h.c.a().cM(), com.baidu.location.h.l.a().c6(), null, d.c.if, d.b.a);
      if ((localBDLocation2 != null) && (localBDLocation2.getLocType() != 67))
        break label156;
      localBDLocation1 = com.baidu.location.c.b.aZ().jdMethod_byte(false);
    }
    while (true)
    {
      if ((localBDLocation1 != null) && (localBDLocation1.getLocType() == 66))
      {
        int i = 1;
        if ((com.baidu.location.b.k.cf.equals("all")) && (localBDLocation1.getAddrStr() == null))
          i = 0;
        if ((com.baidu.location.b.k.bX) && (localBDLocation1.getLocationDescribe() == null))
          i = 0;
        if ((com.baidu.location.b.k.bP) && (localBDLocation1.getPoiList() == null))
          i = 0;
        if (i != 0)
          c.bp().jdMethod_do(localBDLocation1, 21);
      }
      return;
      localBDLocation1 = com.baidu.location.c.b.aZ().jdMethod_byte(false);
      continue;
      label156: localBDLocation1 = localBDLocation2;
    }
  }

  public String bc()
  {
    return this.f0;
  }

  public void bd()
  {
    this.gh = null;
  }

  public List be()
  {
    return this.f2;
  }

  public boolean bf()
  {
    return this.gd;
  }

  public void bh()
  {
    this.ge = true;
    this.fU = false;
    this.f7 = true;
  }

  public void jdMethod_do(Message paramMessage)
  {
    if (!this.f7)
      return;
    jdMethod_try(paramMessage);
  }

  public void jdMethod_if(Message paramMessage)
  {
    if ((this.fZ != null) && (this.f6))
    {
      this.f6 = false;
      this.fP.removeCallbacks(this.fZ);
    }
    BDLocation localBDLocation1 = (BDLocation)paramMessage.obj;
    BDLocation localBDLocation2 = new BDLocation(localBDLocation1);
    if (localBDLocation1.hasAddr())
    {
      this.gg = localBDLocation1.getAddress();
      this.f8 = localBDLocation1.getLongitude();
      this.gb = localBDLocation1.getLatitude();
    }
    if (localBDLocation1.getLocationDescribe() != null)
    {
      this.f0 = localBDLocation1.getLocationDescribe();
      this.f8 = localBDLocation1.getLongitude();
      this.gb = localBDLocation1.getLatitude();
    }
    if (localBDLocation1.getPoiList() != null)
    {
      this.f2 = localBDLocation1.getPoiList();
      this.f8 = localBDLocation1.getLongitude();
      this.gb = localBDLocation1.getLatitude();
    }
    if (com.baidu.location.h.d.a().cH())
    {
      BDLocation localBDLocation3 = new BDLocation(com.baidu.location.h.d.a().cD());
      if ((com.baidu.location.b.k.cf.equals("all")) || (com.baidu.location.b.k.bX) || (com.baidu.location.b.k.bP))
      {
        float[] arrayOfFloat1 = new float[2];
        Location.distanceBetween(this.gb, this.f8, localBDLocation3.getLatitude(), localBDLocation3.getLongitude(), arrayOfFloat1);
        if (arrayOfFloat1[0] < 100.0F)
        {
          if (this.gg != null)
            localBDLocation3.setAddr(this.gg);
          if (this.f0 != null)
            localBDLocation3.setLocationDescribe(this.f0);
          if (this.f2 != null)
            localBDLocation3.setPoiList(this.f2);
        }
      }
      c.bp().jdMethod_do(localBDLocation3, 21);
      a7();
      return;
    }
    if ((localBDLocation1.getNetworkLocationType() != null) && (localBDLocation1.getNetworkLocationType().equals("sky")))
    {
      localBDLocation1.setNetworkLocationType("wf");
      c.bp().jdMethod_do(localBDLocation1, 21);
      this.f4 = System.currentTimeMillis();
      this.gh = localBDLocation1;
      return;
    }
    if (this.fY)
    {
      float[] arrayOfFloat2 = new float[2];
      if (this.gh != null)
        Location.distanceBetween(this.gh.getLatitude(), this.gh.getLongitude(), localBDLocation1.getLatitude(), localBDLocation1.getLongitude(), arrayOfFloat2);
      if (arrayOfFloat2[0] > 10.0F)
      {
        this.gh = localBDLocation1;
        if (!this.gf)
        {
          this.gf = false;
          c.bp().jdMethod_do(localBDLocation1, 21);
        }
      }
      a7();
      return;
    }
    com.baidu.location.b.o.aX().aU().jdMethod_for(SystemClock.uptimeMillis());
    this.gi = null;
    if ((this.f5 != null) && (this.f5.dt() != 0) && ((localBDLocation1.getLocationWhere() == 2) || (localBDLocation1.getLocationWhere() == 0)) && (localBDLocation1.getLocType() == 167))
      new com.baidu.location.g.b(this.f5, this.f9, true).cz();
    if ((localBDLocation1.getLocType() == 161) && (com.baidu.location.b.k.cf.equals("all")) && (localBDLocation1.getAddrStr() == null) && (!com.baidu.location.b.h.W().jdMethod_for(localBDLocation1.getLongitude(), localBDLocation1.getLatitude())))
    {
      new com.baidu.location.g.b(this.f5, this.f9, true).cz();
      a7();
      return;
    }
    if ((localBDLocation1.getLocType() == 161) && ("cl".equals(localBDLocation1.getNetworkLocationType())) && (this.gh != null) && (this.gh.getLocType() == 161) && ("wf".equals(this.gh.getNetworkLocationType())) && (System.currentTimeMillis() - this.f4 < 30000L))
      this.gi = localBDLocation1;
    for (int i = 1; ; i = 0)
    {
      label691: int j;
      if (i != 0)
      {
        c.bp().jdMethod_do(this.gh, 21);
        if (!com.baidu.location.b.k.jdMethod_do(localBDLocation1))
          break label1020;
        if (i == 0)
          this.gh = localBDLocation1;
        j = com.baidu.location.b.k.jdMethod_for(fN, "ssid\":\"", "\"");
        if ((j == -2147483648) || (this.f9 == null))
          break label1028;
      }
      label1028: for (this.gk = this.f9.j(j); ; this.gk = null)
      {
        if ((com.baidu.location.c.d.jdMethod_try().jdMethod_long()) && (localBDLocation1.getLocType() == 161) && ("cl".equals(localBDLocation1.getNetworkLocationType())) && (jdMethod_if(this.f5)))
        {
          com.baidu.location.c.d.jdMethod_try().jdMethod_if(this.f5, null, localBDLocation2, d.c.if, d.b.do);
          this.f1 = this.f5;
        }
        if ((com.baidu.location.c.d.jdMethod_try().jdMethod_long()) && (localBDLocation1.getLocType() == 161) && ("wf".equals(localBDLocation1.getNetworkLocationType())))
        {
          com.baidu.location.c.d.jdMethod_try().jdMethod_if(null, this.f9, localBDLocation2, d.c.if, d.b.do);
          this.gl = this.f9;
        }
        com.baidu.location.c.b.aZ().jdMethod_if(fN, this.f5, this.f9, localBDLocation2);
        if (com.baidu.location.h.l.a().c9())
          com.baidu.location.c.d.jdMethod_try().k();
        a7();
        return;
        c.bp().jdMethod_do(localBDLocation1, 21);
        this.f4 = System.currentTimeMillis();
        com.baidu.location.b.o.aX().aU().jdMethod_int(SystemClock.uptimeMillis());
        if (localBDLocation1.getLocType() == 161)
        {
          com.baidu.location.b.o.aX().aU().jdMethod_char("ons");
          if (this.f5 == null)
            break;
          com.baidu.location.b.o.aX().aU().jdMethod_else(this.f5.dx());
          break;
        }
        com.baidu.location.b.o.aX().aU().jdMethod_char("onf");
        if (this.f5 != null)
          com.baidu.location.b.o.aX().aU().jdMethod_else(this.f5.dx());
        com.baidu.location.b.o.aX().aW();
        break;
        label1020: this.gh = null;
        break label691;
      }
    }
  }

  public void jdMethod_int(BDLocation paramBDLocation)
  {
    bd();
    this.gh = paramBDLocation;
    this.gh.setIndoorLocMode(false);
  }

  public Address jdMethod_new(BDLocation paramBDLocation)
  {
    if ((com.baidu.location.b.k.cf.equals("all")) || (com.baidu.location.b.k.bX) || (com.baidu.location.b.k.bP))
    {
      float[] arrayOfFloat = new float[2];
      Location.distanceBetween(this.gb, this.f8, paramBDLocation.getLatitude(), paramBDLocation.getLongitude(), arrayOfFloat);
      if (arrayOfFloat[0] < 100.0F)
      {
        if (this.gg != null)
          return this.gg;
      }
      else
      {
        this.f0 = null;
        this.f2 = null;
        this.fV = true;
        jdMethod_int(null);
      }
    }
    return null;
  }

  private class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      if (m.jdMethod_do(m.this) == true)
      {
        m.jdMethod_do(m.this, false);
        m.jdMethod_if(m.this, null);
      }
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
      if (m.jdMethod_for(m.this) == true)
      {
        m.jdMethod_if(m.this, false);
        if (!m.jdMethod_if(m.this))
          m.this.bb();
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.m
 * JD-Core Version:    0.6.0
 */