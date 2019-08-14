package com.baidu.location.e;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import com.baidu.location.c.b;
import com.baidu.location.f.a.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class p
  implements f
{
  private static Method i1 = null;
  private static Class i3;
  private static Method iU;
  private static Method iX = null;
  d i0 = new d();
  private LocationClientOption i2;
  private a iQ;
  private String iR = null;
  private b iS = new b(null);
  private Context iT = null;
  private String iV = null;
  private TelephonyManager iW = null;
  private c iY = null;
  private WifiManager iZ = null;

  static
  {
    iU = null;
    i3 = null;
  }

  public p(Context paramContext, LocationClientOption paramLocationClientOption, a parama)
  {
    this.iT = paramContext.getApplicationContext();
    this.i2 = paramLocationClientOption;
    this.iQ = parama;
    String str1 = this.iT.getPackageName();
    try
    {
      this.iW = ((TelephonyManager)this.iT.getSystemService("phone"));
      String str6 = this.iW.getDeviceId();
      str2 = str6;
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          String str5 = a.jdMethod_if(this.iT);
          str3 = str5;
          if (str3 == null)
            break;
          this.iR = ("&prod=" + this.i2.prodName + ":" + str1 + "|&cu=" + str3 + "&coor=" + paramLocationClientOption.getCoorType());
          StringBuffer localStringBuffer = new StringBuffer(256);
          localStringBuffer.append("&fw=");
          localStringBuffer.append("6.13");
          localStringBuffer.append("&lt=1");
          localStringBuffer.append("&mb=");
          localStringBuffer.append(Build.MODEL);
          localStringBuffer.append("&resid=");
          localStringBuffer.append("12");
          if ((paramLocationClientOption.getAddrType() == null) || ((paramLocationClientOption.getAddrType() != null) && (paramLocationClientOption.getAddrType().equals("all"))))
            this.iR += "&addr=all";
          if ((paramLocationClientOption.isNeedAptag == true) || (paramLocationClientOption.isNeedAptagd == true))
          {
            this.iR += "&sema=";
            if (paramLocationClientOption.isNeedAptag == true)
              this.iR += "aptag|";
            if (paramLocationClientOption.isNeedAptagd == true)
              this.iR += "aptagd|";
          }
          localStringBuffer.append("&first=1");
          localStringBuffer.append(Build.VERSION.SDK);
          this.iR += localStringBuffer.toString();
          this.iZ = ((WifiManager)this.iT.getSystemService("wifi"));
          String str4 = cr();
          if (!TextUtils.isEmpty(str4))
            str4 = str4.replace(":", "");
          if (!TextUtils.isEmpty(str4))
            this.iR = (this.iR + "&mac=" + str4);
          cq();
          return;
          localException1 = localException1;
          str2 = null;
        }
      }
      catch (Exception localException2)
      {
        while (true)
        {
          String str2;
          String str3 = null;
          continue;
          this.iR = ("&prod=" + this.i2.prodName + ":" + str1 + "|&im=" + str2 + "&coor=" + paramLocationClientOption.getCoorType());
        }
      }
    }
  }

  private String jdMethod_char(int paramInt)
  {
    if (paramInt < 3)
      paramInt = 3;
    String str1;
    try
    {
      jdMethod_if(this.iW.getCellLocation());
      String str4 = this.iS.toString();
      str1 = str4;
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          this.iY = null;
          this.iY = new c(this.iZ.getScanResults());
          String str3 = this.iY.a(paramInt);
          str2 = str3;
          if ((str1 != null) || (str2 != null))
            break;
          this.iV = null;
          return null;
          localException1 = localException1;
          str1 = null;
        }
      }
      catch (Exception localException2)
      {
        do
        {
          String str2;
          while (true)
            str2 = null;
          if (str2 == null)
            continue;
          str1 = str1 + str2;
        }
        while (str1 == null);
        this.iV = (str1 + this.iR);
      }
    }
    return str1 + this.iR;
  }

  private void jdMethod_if(CellLocation paramCellLocation)
  {
    if ((paramCellLocation == null) || (this.iW == null));
    while (true)
    {
      return;
      b localb = new b(null);
      String str1 = this.iW.getNetworkOperator();
      if ((str1 != null) && (str1.length() > 0));
      try
      {
        if (str1.length() >= 3)
        {
          int m = Integer.valueOf(str1.substring(0, 3)).intValue();
          if (m < 0)
            m = this.iS.jdField_do;
          localb.jdField_do = m;
        }
        String str2 = str1.substring(3);
        int j = 0;
        if (str2 != null)
        {
          char[] arrayOfChar = str2.toCharArray();
          label105: if ((j < arrayOfChar.length) && (Character.isDigit(arrayOfChar[j])));
        }
        else
        {
          int k = Integer.valueOf(str2.substring(0, j)).intValue();
          if (k < 0)
            k = this.iS.jdField_if;
          localb.jdField_if = k;
          label160: if (!(paramCellLocation instanceof GsmCellLocation))
            break label214;
          localb.jdField_for = ((GsmCellLocation)paramCellLocation).getLac();
          localb.jdField_new = ((GsmCellLocation)paramCellLocation).getCid();
          localb.jdField_int = 'g';
        }
        while (b.a(localb))
        {
          this.iS = localb;
          return;
          j++;
          break label105;
          label214: if (!(paramCellLocation instanceof CdmaCellLocation))
            continue;
          localb.jdField_int = 'c';
          if (i3 == null);
          try
          {
            i3 = Class.forName("android.telephony.cdma.CdmaCellLocation");
            i1 = i3.getMethod("getBaseStationId", new Class[0]);
            iX = i3.getMethod("getNetworkId", new Class[0]);
            iU = i3.getMethod("getSystemId", new Class[0]);
            if ((i3 == null) || (!i3.isInstance(paramCellLocation)))
              continue;
            try
            {
              int i = ((Integer)iU.invoke(paramCellLocation, new Object[0])).intValue();
              if (i < 0)
                i = this.iS.jdField_if;
              localb.jdField_if = i;
              localb.jdField_new = ((Integer)i1.invoke(paramCellLocation, new Object[0])).intValue();
              localb.jdField_for = ((Integer)iX.invoke(paramCellLocation, new Object[0])).intValue();
            }
            catch (Exception localException1)
            {
              return;
            }
          }
          catch (Exception localException2)
          {
            i3 = null;
            return;
          }
        }
      }
      catch (Exception localException3)
      {
        break label160;
      }
    }
  }

  public String jdMethod_case(int paramInt)
  {
    try
    {
      String str = jdMethod_char(paramInt);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public void cp()
  {
    if (this.iV == null);
    BDLocation localBDLocation;
    do
    {
      do
        return;
      while ((this.iS != null) && (this.iS.jdMethod_if() != 1));
      int i = this.i2.scanSpan;
      localBDLocation = null;
      if (i < 1000)
        continue;
      boolean bool1 = this.i2.getAddrType().equals("all");
      localBDLocation = null;
      if (bool1)
        continue;
      boolean bool2 = this.i2.isNeedAptag;
      localBDLocation = null;
      if (bool2)
        continue;
      boolean bool3 = this.i2.isNeedAptagd;
      localBDLocation = null;
      if (bool3)
        continue;
      localBDLocation = b.aZ().jdMethod_if(this.iS.a(), this.iZ.getScanResults(), false);
      if (!this.i2.coorType.equals("gcj02"))
      {
        double d1 = localBDLocation.getLongitude();
        double d2 = localBDLocation.getLatitude();
        if ((d1 != 4.9E-324D) && (d2 != 4.9E-324D))
        {
          double[] arrayOfDouble = Jni.jdMethod_if(d1, d2, this.i2.coorType);
          localBDLocation.setLongitude(arrayOfDouble[0]);
          localBDLocation.setLatitude(arrayOfDouble[1]);
          localBDLocation.setCoorType(this.i2.coorType);
        }
      }
      if (localBDLocation.getLocType() != 66)
        continue;
      this.iQ.onReceiveLocation(localBDLocation);
    }
    while (localBDLocation != null);
    this.i0.e(this.iV);
  }

  public String cq()
  {
    try
    {
      String str = jdMethod_char(15);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public String cr()
  {
    try
    {
      WifiInfo localWifiInfo = this.iZ.getConnectionInfo();
      Object localObject = null;
      if (localWifiInfo != null)
      {
        String str = localWifiInfo.getMacAddress();
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static abstract interface a
  {
    public abstract void onReceiveLocation(BDLocation paramBDLocation);
  }

  private class b
  {
    public int jdField_do = -1;
    public int jdField_for = -1;
    public int jdField_if = -1;
    public char jdField_int = '\000';
    public int jdField_new = -1;

    private b()
    {
    }

    private boolean jdField_do()
    {
      return (this.jdField_for > -1) && (this.jdField_new > 0);
    }

    public String a()
    {
      if (!jdField_do())
        return null;
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append(23 + this.jdField_new);
      localStringBuffer.append("H");
      localStringBuffer.append(45 + this.jdField_for);
      localStringBuffer.append("K");
      localStringBuffer.append(54 + this.jdField_if);
      localStringBuffer.append("Q");
      localStringBuffer.append(203 + this.jdField_do);
      return localStringBuffer.toString();
    }

    public int jdField_if()
    {
      int i = 2;
      if ((this.jdField_do > 0) && (jdField_do()))
      {
        if ((this.jdField_do == 460) || (this.jdField_do == 454) || (this.jdField_do == 455) || (this.jdField_do == 466))
          i = 1;
      }
      else
        return i;
      return 0;
    }

    public String toString()
    {
      if (!jdField_do())
        return null;
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append("&nw=");
      localStringBuffer.append(this.jdField_int);
      Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(this.jdField_do);
      arrayOfObject[1] = Integer.valueOf(this.jdField_if);
      arrayOfObject[2] = Integer.valueOf(this.jdField_for);
      arrayOfObject[3] = Integer.valueOf(this.jdField_new);
      localStringBuffer.append(String.format(localLocale, "&cl=%d|%d|%d|%d", arrayOfObject));
      return localStringBuffer.toString();
    }
  }

  protected class c
  {
    private long jdField_do = 0L;
    public List jdField_if = null;

    public c(List arg2)
    {
      Object localObject;
      this.jdField_if = localObject;
      this.jdField_do = System.currentTimeMillis();
      a();
    }

    private void a()
    {
      if (jdField_if() < 1)
        return;
      int i = -1 + this.jdField_if.size();
      int j = 1;
      label23: int k;
      if ((i >= 1) && (j != 0))
      {
        k = 0;
        j = 0;
        label36: if (k < i)
        {
          if (((ScanResult)this.jdField_if.get(k)).level >= ((ScanResult)this.jdField_if.get(k + 1)).level)
            break label149;
          ScanResult localScanResult = (ScanResult)this.jdField_if.get(k + 1);
          this.jdField_if.set(k + 1, this.jdField_if.get(k));
          this.jdField_if.set(k, localScanResult);
        }
      }
      label149: for (int m = 1; ; m = j)
      {
        k++;
        j = m;
        break label36;
        i--;
        break label23;
        break;
      }
    }

    public String a(int paramInt)
    {
      if (jdField_if() < 2)
        return null;
      StringBuffer localStringBuffer = new StringBuffer(512);
      int i = this.jdField_if.size();
      int j = 0;
      int k = 0;
      int m = 1;
      int i1;
      while (j < i)
      {
        if (((ScanResult)this.jdField_if.get(j)).level == 0)
        {
          i1 = k;
          j++;
          k = i1;
          continue;
        }
        if (m == 0)
          break label206;
        localStringBuffer.append("&wf=");
        m = 0;
      }
      while (true)
      {
        localStringBuffer.append(((ScanResult)this.jdField_if.get(j)).BSSID.replace(":", ""));
        int n = ((ScanResult)this.jdField_if.get(j)).level;
        if (n < 0)
          n = -n;
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(n);
        localStringBuffer.append(String.format(localLocale, ";%d;", arrayOfObject));
        i1 = k + 1;
        if (i1 <= paramInt)
          break;
        if (m == 0)
          break label216;
        return null;
        label206: localStringBuffer.append("|");
      }
      label216: return localStringBuffer.toString();
    }

    public int jdField_if()
    {
      if (this.jdField_if == null)
        return 0;
      return this.jdField_if.size();
    }
  }

  class d extends m
  {
    String eV = null;

    d()
    {
      this.c7 = new ArrayList();
    }

    public void au()
    {
      this.c5 = k.Z();
      String str1 = Jni.H(this.eV);
      this.eV = null;
      this.c7.add(new BasicNameValuePair("bloc", str1));
      StringBuffer localStringBuffer = new StringBuffer(512);
      if (localStringBuffer.length() > 0)
        this.c7.add(new BasicNameValuePair("ext", Jni.H(localStringBuffer.toString())));
      Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(System.currentTimeMillis());
      String str2 = String.format(localLocale, "%d", arrayOfObject);
      this.c7.add(new BasicNameValuePair("trtm", str2));
    }

    public void e(String paramString)
    {
      this.eV = paramString;
      ao();
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null));
      try
      {
        String str = EntityUtils.toString(this.c6, "utf-8");
        try
        {
          localBDLocation = new BDLocation(str);
          if ((localBDLocation != null) && (localBDLocation.getLocType() == 161))
          {
            localBDLocation.setCoorType(p.jdMethod_do(p.this).coorType);
            p.jdMethod_if(p.this).onReceiveLocation(localBDLocation);
          }
          label76: if (this.c7 != null)
            this.c7.clear();
          return;
        }
        catch (Exception localException2)
        {
          while (true)
          {
            BDLocation localBDLocation = new BDLocation();
            localBDLocation.setLocType(63);
          }
        }
      }
      catch (Exception localException1)
      {
        break label76;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.p
 * JD-Core Version:    0.6.0
 */