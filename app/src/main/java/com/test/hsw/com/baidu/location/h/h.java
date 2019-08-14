package com.baidu.location.h;

import com.baidu.location.b.f;
import java.util.Locale;

public class h
  implements f
{
  public char kA = '\000';
  public int kB = -1;
  public int kC = -1;
  public int kD = 2147483647;
  public int ku = -1;
  private boolean kv = false;
  public long kw = 0L;
  public int kx = 2147483647;
  public int ky = -1;
  public int kz = -1;

  public h()
  {
    this.kw = System.currentTimeMillis();
  }

  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, char paramChar)
  {
    this.ku = paramInt1;
    this.ky = paramInt2;
    this.kB = paramInt3;
    this.kC = paramInt4;
    this.kz = paramInt5;
    this.kA = paramChar;
    this.kw = System.currentTimeMillis();
  }

  public h(h paramh)
  {
    this(paramh.ku, paramh.ky, paramh.kB, paramh.kC, paramh.kz, paramh.kA);
  }

  public boolean jdMethod_case(h paramh)
  {
    return (this.ku == paramh.ku) && (this.ky == paramh.ky) && (this.kC == paramh.kC) && (this.kB == paramh.kB);
  }

  public String dA()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append(23 + this.ky);
    localStringBuffer.append("H");
    localStringBuffer.append(45 + this.ku);
    localStringBuffer.append("K");
    localStringBuffer.append(54 + this.kC);
    localStringBuffer.append("Q");
    localStringBuffer.append(203 + this.kB);
    return localStringBuffer.toString();
  }

  public boolean dB()
  {
    return (this.ku > -1) && (this.ky > -1) && (this.kC == -1) && (this.kB == -1);
  }

  public void dr()
  {
    this.kv = true;
  }

  public boolean ds()
  {
    return (this.ku > -1) && (this.ky > 0);
  }

  public int dt()
  {
    int i = 2;
    if ((this.kB > 0) && (ds()))
    {
      if ((this.kB == 460) || (this.kB == 454) || (this.kB == 455) || (this.kB == 466))
        i = 1;
    }
    else
      return i;
    return 0;
  }

  public boolean du()
  {
    return System.currentTimeMillis() - this.kw < 3000L;
  }

  public boolean dv()
  {
    return (this.ku == -1) && (this.ky == -1) && (this.kC == -1) && (this.kB == -1);
  }

  public String dw()
  {
    if (ds())
    {
      Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = Integer.valueOf(this.kB);
      arrayOfObject[1] = Integer.valueOf(this.kC);
      arrayOfObject[2] = Integer.valueOf(this.ku);
      arrayOfObject[3] = Integer.valueOf(this.ky);
      arrayOfObject[4] = Integer.valueOf(this.kz);
      return String.format(localLocale, "<cell-tower>\n<mcc>%d</mcc><mnc>%d</mnc><lac>%d</lac><ci>%d</ci><rssi>%d</rssi></cell-tower>", arrayOfObject);
    }
    return null;
  }

  public String dx()
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw=");
    localStringBuffer.append(this.kA);
    Locale localLocale = Locale.CHINA;
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Integer.valueOf(this.kB);
    arrayOfObject[1] = Integer.valueOf(this.kC);
    arrayOfObject[2] = Integer.valueOf(this.ku);
    arrayOfObject[3] = Integer.valueOf(this.ky);
    arrayOfObject[4] = Integer.valueOf(this.kz);
    localStringBuffer.append(String.format(localLocale, "&cl=%d|%d|%d|%d&cl_s=%d", arrayOfObject));
    if (this.kv)
      localStringBuffer.append("&newcl=1");
    return localStringBuffer.toString();
  }

  public boolean dy()
  {
    return (this.ku > -1) && (this.ky > -1) && (this.kC > -1) && (this.kB > -1);
  }

  public String dz()
  {
    StringBuffer localStringBuffer = new StringBuffer(64);
    Locale localLocale = Locale.CHINA;
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = Integer.valueOf(this.kB);
    arrayOfObject[1] = Integer.valueOf(this.kC);
    arrayOfObject[2] = Integer.valueOf(this.ku);
    arrayOfObject[3] = Integer.valueOf(this.ky);
    arrayOfObject[4] = Integer.valueOf(this.kz);
    localStringBuffer.append(String.format(localLocale, "cell=%d|%d|%d|%d:%d", arrayOfObject));
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.h.h
 * JD-Core Version:    0.6.0
 */