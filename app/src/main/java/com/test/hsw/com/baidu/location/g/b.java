package com.baidu.location.g;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.Address.Builder;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.h.h;
import com.baidu.location.h.j;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class b
  implements com.baidu.location.b.f
{
  private static SimpleDateFormat jn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  long jj = 0L;
  h jk = null;
  private com.baidu.location.b.l jl = new com.baidu.location.b.l();
  com.baidu.location.h.f jm = null;
  boolean jo = false;
  a jp = null;

  public b()
  {
  }

  public b(h paramh, com.baidu.location.h.f paramf, boolean paramBoolean)
  {
    this.jk = paramh;
    this.jm = paramf;
    this.jo = paramBoolean;
    this.jl.aj();
    long l = SystemClock.uptimeMillis();
    this.jl.jdMethod_do(l);
    this.jl.jdMethod_if(l);
  }

  public void cz()
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    if ((this.jm != null) && (this.jm.dl() > 1));
    for (String str1 = this.jm.i(15); ; str1 = null)
    {
      h localh = this.jk;
      String str2 = null;
      if (localh != null)
      {
        boolean bool = this.jk.ds();
        str2 = null;
        if (bool)
          str2 = this.jk.dw();
      }
      if ((str1 != null) || (str2 != null))
      {
        localStringBuffer.append("<LocationRQ xmlns=\"http://skyhookwireless.com/wps/2005\"\nversion=\"2.24\"\nstreet-address-lookup=\"full\">\n<authentication version=\"2.2\">\n<key key=\"" + Jni.dG() + "\"\n" + "username=\"BAIDULOC\"/></authentication>\n");
        if (str1 != null)
          localStringBuffer.append(str1);
        if (str2 != null)
          localStringBuffer.append(str2);
        localStringBuffer.append("</LocationRQ>");
        new b().h(localStringBuffer.toString());
        this.jj = System.currentTimeMillis();
      }
      return;
    }
  }

  class a extends com.baidu.location.b.m
  {
    boolean eX = false;
    BDLocation eY = null;

    public a(BDLocation arg2)
    {
      Object localObject;
      this.eY = localObject;
    }

    public void au()
    {
      if (this.eX)
      {
        this.c5 = "https://sapi.skyhookwireless.com/wps2/reverse-geo";
        StringBuffer localStringBuffer = new StringBuffer(1024);
        localStringBuffer.append("<ReverseGeoRQ xmlns=\"http://skyhookwireless.com/wps/2005\"\nversion=\"2.24\"\nstreet-address-lookup=\"full\">\n<authentication version=\"2.2\">\n<key key=\"" + Jni.dG() + "\"\n" + "username=\"BAIDULOC\"/></authentication>\n");
        localStringBuffer.append("<point>");
        localStringBuffer.append("<latitude>");
        localStringBuffer.append("" + this.eY.getLatitude());
        localStringBuffer.append("</latitude>");
        localStringBuffer.append("<longitude>");
        localStringBuffer.append("" + this.eY.getLongitude());
        localStringBuffer.append("</longitude>");
        localStringBuffer.append("</point>");
        localStringBuffer.append("</ReverseGeoRQ>");
        this.da = localStringBuffer.toString();
        return;
      }
      try
      {
        this.c5 = (k.aa() + "?&x=" + this.eY.getLongitude() + "&y=" + this.eY.getLatitude() + "&r=100&prodname=searchbox" + "&addr=" + URLEncoder.encode("country|country_code|province|city|city_code|street|street_number|district", "UTF-8"));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        this.c5 = (k.aa() + "?&x=" + this.eY.getLongitude() + "&y=" + this.eY.getLatitude() + "&r=100");
      }
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null));
      while (true)
      {
        String str3;
        String str4;
        try
        {
          String str1 = EntityUtils.toString(this.c6, "utf-8");
          if (!this.eX)
            continue;
          a locala = new a(str1);
          String str2 = locala.i8;
          str3 = locala.i7;
          str4 = locala.jc;
          if (!str3.equals(""))
            break label819;
          str5 = locala.i4;
          if (!str4.equals(""))
            break label812;
          str6 = locala.jd;
          String str7 = locala.ji;
          if (!str7.equals(""))
            continue;
          str7 = locala.jb;
          Log.i("skyhook rgc metro2 = ", "" + locala.jb);
          String str8 = locala.jf;
          String str9 = locala.i5;
          Address localAddress1 = new Address.Builder().country(str2).province(str5).city(str6).district(str7).street(str8).streetNumber(str9).build();
          this.eY.setAddr(localAddress1);
          if (!b.this.jp.cx())
            continue;
          double[] arrayOfDouble2 = Jni.jdMethod_if(b.this.jp.cu(), b.this.jp.ct(), "gps2gcj");
          this.eY.setCoorType("gcj02");
          this.eY.setLongitude(arrayOfDouble2[0]);
          this.eY.setLatitude(arrayOfDouble2[1]);
          Message localMessage2 = com.baidu.location.e.m.a9().fP.obtainMessage(21);
          localMessage2.obj = this.eY;
          localMessage2.sendToTarget();
          return;
          JSONObject localJSONObject1 = new JSONObject(str1);
          if (!localJSONObject1.has("addr"))
            continue;
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("addr");
          if (!localJSONObject2.has("country"))
            break label806;
          String str24 = localJSONObject2.getString("country");
          if (TextUtils.isEmpty(str24))
            break label806;
          str10 = str24;
          if (!localJSONObject2.has("country_code"))
            break label800;
          String str23 = localJSONObject2.getString("country_code");
          if (TextUtils.isEmpty(str23))
            break label800;
          str11 = str23;
          if (!localJSONObject2.has("province"))
            break label794;
          String str22 = localJSONObject2.getString("province");
          if (TextUtils.isEmpty(str22))
            break label794;
          str12 = str22;
          if (!localJSONObject2.has("city"))
            break label788;
          String str21 = localJSONObject2.getString("city");
          if (TextUtils.isEmpty(str21))
            break label788;
          str13 = str21;
          if (!localJSONObject2.has("city_code"))
            break label782;
          String str20 = localJSONObject2.getString("city_code");
          if (TextUtils.isEmpty(str20))
            break label782;
          str14 = str20;
          if (!localJSONObject2.has("district"))
            break label776;
          String str19 = localJSONObject2.getString("district");
          if (TextUtils.isEmpty(str19))
            break label776;
          str15 = str19;
          if (!localJSONObject2.has("street"))
            break label770;
          String str18 = localJSONObject2.getString("street");
          if (TextUtils.isEmpty(str18))
            break label770;
          str16 = str18;
          if (!localJSONObject2.has("streetNumber"))
            break label764;
          str17 = localJSONObject2.getString("street_number");
          if (TextUtils.isEmpty(str17))
            break label764;
          Address localAddress2 = new Address.Builder().country(str10).countryCode(str11).province(str12).city(str13).cityCode(str14).district(str15).street(str16).streetNumber(str17).build();
          this.eY.setAddr(localAddress2);
          continue;
        }
        catch (Exception localException)
        {
          return;
        }
        if (b.this.jp.cx())
        {
          double[] arrayOfDouble1 = Jni.jdMethod_if(b.this.jp.cu(), b.this.jp.ct(), "gps2gcj");
          this.eY.setCoorType("gcj02");
          this.eY.setLongitude(arrayOfDouble1[0]);
          this.eY.setLatitude(arrayOfDouble1[1]);
        }
        Message localMessage1 = com.baidu.location.e.m.a9().fP.obtainMessage(21);
        localMessage1.obj = this.eY;
        localMessage1.sendToTarget();
        return;
        label764: String str17 = null;
        continue;
        label770: String str16 = null;
        continue;
        label776: String str15 = null;
        continue;
        label782: String str14 = null;
        continue;
        label788: String str13 = null;
        continue;
        label794: String str12 = null;
        continue;
        label800: String str11 = null;
        continue;
        label806: String str10 = null;
        continue;
        label812: String str6 = str4;
        continue;
        label819: String str5 = str3;
      }
    }

    void jdMethod_new(boolean paramBoolean)
    {
      this.eX = paramBoolean;
      if (paramBoolean)
      {
        av();
        return;
      }
      as();
    }
  }

  class b extends com.baidu.location.b.m
  {
    public b()
    {
    }

    public void au()
    {
    }

    void h(String paramString)
    {
      this.da = paramString;
      av();
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      b.jdMethod_if(b.this).jdMethod_for(SystemClock.uptimeMillis());
      if ((paramBoolean) && (this.c6 != null))
      {
        try
        {
          String str1 = EntityUtils.toString(this.c6, "utf-8");
          b.this.jp = new a(str1);
          if ((b.this.jo) && (b.this.jp.cs()))
          {
            BDLocation localBDLocation3 = new BDLocation();
            localBDLocation3.setLongitude(b.this.jp.cu());
            localBDLocation3.setLatitude(b.this.jp.ct());
            localBDLocation3.setRadius(b.this.jp.cv());
            localBDLocation3.setLocType(161);
            localBDLocation3.setLocationWhere(0);
            localBDLocation3.setCoorType("wgs84");
            localBDLocation3.setNetworkLocationType("sky");
            String str2 = b.this.jp.i8;
            String str3 = b.this.jp.i7;
            String str4 = b.this.jp.jc;
            if (str3.equals(""))
              str3 = b.this.jp.i4;
            if (str4.equals(""))
              str4 = b.this.jp.jb;
            if (str4.equals(""))
              str4 = b.this.jp.jd;
            String str5 = b.this.jp.ji;
            String str6 = b.this.jp.jf;
            String str7 = b.this.jp.i5;
            Address localAddress = new Address.Builder().country(str2).province(str3).city(str4).district(str5).street(str6).streetNumber(str7).build();
            Date localDate = new Date();
            localBDLocation3.setTime(b.cy().format(localDate));
            localBDLocation3.setOperators(com.baidu.location.h.c.a().cQ());
            if (com.baidu.location.e.l.ce().cb())
              localBDLocation3.setDirection(com.baidu.location.e.l.ce().cg());
            if (k.cf.equals("all"))
              localBDLocation3.setAddr(localAddress);
            if (b.this.jp.cx())
            {
              double[] arrayOfDouble = Jni.jdMethod_if(b.this.jp.cu(), b.this.jp.ct(), "gps2gcj");
              localBDLocation3.setCoorType("gcj02");
              localBDLocation3.setLongitude(arrayOfDouble[0]);
              localBDLocation3.setLatitude(arrayOfDouble[1]);
            }
            Message localMessage = com.baidu.location.e.m.a9().fP.obtainMessage(21);
            localMessage.obj = localBDLocation3;
            localMessage.sendToTarget();
            b.jdMethod_if(b.this).jdMethod_int(SystemClock.uptimeMillis());
            b.jdMethod_if(b.this).jdMethod_char("skys");
            if (b.this.jk != null)
              b.jdMethod_if(b.this).jdMethod_else(b.this.jk.dx());
            o.aX().jdMethod_if(b.jdMethod_if(b.this));
            return;
          }
          if ((!b.this.jo) || (b.this.jp.cs()))
            return;
          BDLocation localBDLocation2 = new BDLocation();
          localBDLocation2.setLocType(167);
          com.baidu.location.e.c.bp().jdMethod_try(localBDLocation2);
          b.jdMethod_if(b.this).jdMethod_int(SystemClock.uptimeMillis());
          b.jdMethod_if(b.this).jdMethod_char("skyf");
          if (b.this.jk != null)
            b.jdMethod_if(b.this).jdMethod_else(b.this.jk.dx());
          o.aX().jdMethod_if(b.jdMethod_if(b.this));
          return;
        }
        catch (Exception localException)
        {
          return;
        }
      }
      else
      {
        BDLocation localBDLocation1 = new BDLocation();
        localBDLocation1.setLocType(63);
        com.baidu.location.e.c.bp().jdMethod_try(localBDLocation1);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.g.b
 * JD-Core Version:    0.6.0
 */