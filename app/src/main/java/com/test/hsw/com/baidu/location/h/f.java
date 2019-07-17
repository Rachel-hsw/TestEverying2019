package com.baidu.location.h;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class f
  implements com.baidu.location.b.f
{
  private static final long ko = 10L;
  private long kp = 0L;
  private boolean kq = false;
  public List kr = null;
  private long ks = 0L;
  private boolean kt;

  public f(f paramf)
  {
    if (paramf != null)
    {
      this.kr = paramf.kr;
      this.kp = paramf.kp;
      this.ks = paramf.ks;
      this.kq = paramf.kq;
    }
  }

  public f(List paramList, long paramLong)
  {
    this.kp = paramLong;
    this.kr = paramList;
    this.ks = System.currentTimeMillis();
    dg();
  }

  private void dg()
  {
    if (dl() < 1)
      return;
    int i = -1 + this.kr.size();
    int j = 1;
    label23: int k;
    if ((i >= 1) && (j != 0))
    {
      k = 0;
      j = 0;
      label36: if (k < i)
      {
        if (((ScanResult)this.kr.get(k)).level >= ((ScanResult)this.kr.get(k + 1)).level)
          break label149;
        ScanResult localScanResult = (ScanResult)this.kr.get(k + 1);
        this.kr.set(k + 1, this.kr.get(k));
        this.kr.set(k, localScanResult);
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

  public static String jdMethod_if(int paramInt, List paramList)
  {
    if (paramList.size() < 1)
      return null;
    StringBuffer localStringBuffer = new StringBuffer(512);
    int i = paramList.size();
    if (i > paramInt);
    while (true)
    {
      int j = 0;
      int k = 1;
      while (j < paramInt)
      {
        int n;
        if (((ScanResult)paramList.get(j)).level == 0)
        {
          n = k;
          j++;
          k = n;
          continue;
        }
        if (k != 0)
          k = 0;
        while (true)
        {
          localStringBuffer.append(((ScanResult)paramList.get(j)).BSSID.replace(":", ""));
          int m = ((ScanResult)paramList.get(j)).level;
          if (m < 0)
            m = -m;
          Locale localLocale = Locale.CHINA;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(m);
          localStringBuffer.append(String.format(localLocale, ";%d;", arrayOfObject));
          n = k;
          break;
          localStringBuffer.append("|");
        }
      }
      if (k == 0)
        return localStringBuffer.toString();
      return null;
      paramInt = i;
    }
  }

  public String d(int paramInt)
  {
    if (dl() < 1)
      return null;
    StringBuffer localStringBuffer = new StringBuffer(512);
    int i = this.kr.size();
    if (i > paramInt);
    while (true)
    {
      int j = 0;
      int k = 1;
      while (j < paramInt)
      {
        int n;
        if (((ScanResult)this.kr.get(j)).level == 0)
        {
          n = k;
          j++;
          k = n;
          continue;
        }
        if (k != 0)
          k = 0;
        while (true)
        {
          localStringBuffer.append(((ScanResult)this.kr.get(j)).BSSID.replace(":", ""));
          int m = ((ScanResult)this.kr.get(j)).level;
          if (m < 0)
            m = -m;
          Locale localLocale = Locale.CHINA;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(m);
          localStringBuffer.append(String.format(localLocale, ";%d;", arrayOfObject));
          n = k;
          break;
          localStringBuffer.append("|");
        }
      }
      if (k == 0)
        return localStringBuffer.toString();
      return null;
      paramInt = i;
    }
  }

  public int df()
  {
    for (int i = 0; ; i++)
    {
      int j = dl();
      int k = 0;
      if (i < j)
      {
        int m = -((ScanResult)this.kr.get(i)).level;
        if (m <= 0)
          continue;
        k = m;
      }
      return k;
    }
  }

  public boolean dh()
  {
    return this.kq;
  }

  public String di()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("wifi=");
    if (this.kr == null)
      return localStringBuilder.toString();
    for (int i = 0; i < this.kr.size(); i++)
    {
      int j = ((ScanResult)this.kr.get(i)).level;
      localStringBuilder.append(((ScanResult)this.kr.get(i)).BSSID.replace(":", ""));
      Locale localLocale = Locale.CHINA;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(j);
      localStringBuilder.append(String.format(localLocale, ",%d;", arrayOfObject));
    }
    return localStringBuilder.toString();
  }

  public boolean dj()
  {
    return System.currentTimeMillis() - this.kp < 3000L;
  }

  public String dk()
  {
    try
    {
      String str = e(15);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public int dl()
  {
    if (this.kr == null)
      return 0;
    return this.kr.size();
  }

  public boolean dm()
  {
    return System.currentTimeMillis() - this.ks < 5000L;
  }

  public String dn()
  {
    StringBuffer localStringBuffer = new StringBuffer(512);
    localStringBuffer.append("wifi info:");
    if (dl() < 1)
      return localStringBuffer.toString();
    int i = this.kr.size();
    if (i > 10)
      i = 10;
    int j = 0;
    int k = 1;
    if (j < i)
    {
      int n;
      if (((ScanResult)this.kr.get(j)).level == 0)
        n = k;
      while (true)
      {
        j++;
        k = n;
        break;
        if (k != 0)
        {
          localStringBuffer.append("wifi=");
          localStringBuffer.append(((ScanResult)this.kr.get(j)).BSSID.replace(":", ""));
          int i1 = ((ScanResult)this.kr.get(j)).level;
          Locale localLocale2 = Locale.CHINA;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = Integer.valueOf(i1);
          localStringBuffer.append(String.format(localLocale2, ";%d;", arrayOfObject2));
          n = 0;
          continue;
        }
        localStringBuffer.append(";");
        localStringBuffer.append(((ScanResult)this.kr.get(j)).BSSID.replace(":", ""));
        int m = ((ScanResult)this.kr.get(j)).level;
        Locale localLocale1 = Locale.CHINA;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(m);
        localStringBuffer.append(String.format(localLocale1, ",%d;", arrayOfObject1));
        n = k;
      }
    }
    return localStringBuffer.toString();
  }

  public String jdMethod_do(int paramInt, boolean paramBoolean)
  {
    if (dl() < 1)
      return null;
    int i = 0;
    Random localRandom = new Random();
    StringBuffer localStringBuffer1 = new StringBuffer(512);
    ArrayList localArrayList = new ArrayList();
    String str1 = l.a().c7();
    int j = Build.VERSION.SDK_INT;
    int k = 0;
    if (j >= 17);
    while (true)
    {
      int i1;
      try
      {
        l2 = SystemClock.elapsedRealtimeNanos() / 1000L;
        boolean bool = l2 < 0L;
        k = 0;
        if (!bool)
          continue;
        k = 1;
        if ((k == 0) || (k == 0) || (!paramBoolean))
          continue;
        m = 0;
        n = 0;
        i1 = this.kr.size();
        i2 = 1;
        if (i1 <= paramInt)
          break label938;
        i3 = 0;
        if (i3 >= paramInt)
          continue;
        if (((ScanResult)this.kr.get(i3)).level != 0)
          continue;
        i12 = i2;
        i13 = m;
        int i16 = n;
        i11 = i;
        i10 = i16;
        i3++;
        m = i13;
        i2 = i12;
        int i14 = i10;
        i = i11;
        n = i14;
        continue;
      }
      catch (Error localError)
      {
        int m;
        int i3;
        int i12;
        int i13;
        int i11;
        int i10;
        long l2 = 0L;
        continue;
        if (i2 == 0)
          continue;
        int i2 = 0;
        localStringBuffer1.append("&wf=");
        String str2 = ((ScanResult)this.kr.get(i3)).BSSID.replace(":", "");
        localStringBuffer1.append(str2);
        int i7 = ((ScanResult)this.kr.get(i3)).level;
        if (i7 >= 0)
          continue;
        i7 = -i7;
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(i7);
        localStringBuffer1.append(String.format(localLocale, ";%d;", arrayOfObject));
        int i8 = m + 1;
        if ((str1 == null) || (!str1.equals(str2)))
          continue;
        this.kt = l.a().D(((ScanResult)this.kr.get(i3)).capabilities);
        l.a().da();
        int n = i8;
        if (i != 0)
          continue;
        try
        {
          if ((localRandom.nextInt(10) != 2) || (((ScanResult)this.kr.get(i3)).SSID == null) || (((ScanResult)this.kr.get(i3)).SSID.length() >= 30))
            break label932;
          localStringBuffer1.append(((ScanResult)this.kr.get(i3)).SSID);
          i9 = 1;
          i10 = n;
          i11 = i9;
          i12 = i2;
          i13 = i8;
          continue;
          localStringBuffer1.append("|");
          continue;
          if ((i != 1) || (localRandom.nextInt(20) != 1) || (((ScanResult)this.kr.get(i3)).SSID == null) || (((ScanResult)this.kr.get(i3)).SSID.length() >= 30))
            break label932;
          localStringBuffer1.append(((ScanResult)this.kr.get(i3)).SSID);
          i9 = 2;
          continue;
        }
        catch (Exception localException)
        {
          i12 = i2;
          i13 = i8;
          int i15 = n;
          i11 = i;
          i10 = i15;
        }
        continue;
        if (i2 != 0)
          continue;
        localStringBuffer1.append("&wf_n=" + n);
        if ((0L <= 10L) || (localArrayList.size() <= 0))
          continue;
        StringBuffer localStringBuffer2 = new StringBuffer(128);
        localStringBuffer2.append("&wf_ut=");
        Long localLong1 = (Long)localArrayList.get(0);
        Iterator localIterator = localArrayList.iterator();
        int i5 = 1;
        if (!localIterator.hasNext())
          continue;
        Long localLong2 = (Long)localIterator.next();
        if (i5 == 0)
          continue;
        localStringBuffer2.append(localLong2.longValue());
        int i6 = 0;
        localStringBuffer2.append("|");
        i5 = i6;
        continue;
        long l1 = localLong2.longValue() - localLong1.longValue();
        if (l1 == 0L)
          continue;
        localStringBuffer2.append("" + l1);
        i6 = i5;
        continue;
        localStringBuffer1.append(localStringBuffer2.toString());
        localStringBuffer1.append("&wf_st=");
        localStringBuffer1.append(this.kp);
        localStringBuffer1.append("&wf_et=");
        localStringBuffer1.append(this.ks);
        localStringBuffer1.append("&wf_vt=");
        localStringBuffer1.append(e.kc);
        if (n <= 0)
          continue;
        this.kq = true;
        localStringBuffer1.append("&wf_en=");
        if (!this.kt)
          continue;
        int i4 = 1;
        localStringBuffer1.append(i4);
        return localStringBuffer1.toString();
        i4 = 0;
        continue;
        return null;
      }
      label932: int i9 = i;
      continue;
      label938: paramInt = i1;
    }
  }

  public String dp()
  {
    try
    {
      String str = jdMethod_do(com.baidu.location.b.k.cD, true);
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public boolean dq()
  {
    return System.currentTimeMillis() - this.ks < 3000L;
  }

  public String e(int paramInt)
  {
    return jdMethod_do(paramInt, false);
  }

  public String h(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(512);
    if (dl() < 1)
      return localStringBuffer.toString();
    int i = this.kr.size();
    if (i > paramInt);
    while (true)
    {
      int j = 0;
      int k = 1;
      if (j < paramInt)
      {
        int n;
        if (((ScanResult)this.kr.get(j)).level == 0)
          n = k;
        while (true)
        {
          j++;
          k = n;
          break;
          if (k != 0)
          {
            localStringBuffer.append(((ScanResult)this.kr.get(j)).BSSID.replace(":", ""));
            int i1 = -((ScanResult)this.kr.get(j)).level;
            Locale localLocale2 = Locale.CHINA;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = Integer.valueOf(i1);
            localStringBuffer.append(String.format(localLocale2, ";%d|", arrayOfObject2));
            n = 0;
            continue;
          }
          localStringBuffer.append(((ScanResult)this.kr.get(j)).BSSID.replace(":", ""));
          int m = -((ScanResult)this.kr.get(j)).level;
          Locale localLocale1 = Locale.CHINA;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = Integer.valueOf(m);
          localStringBuffer.append(String.format(localLocale1, ";%d|", arrayOfObject1));
          n = k;
        }
      }
      return localStringBuffer.toString();
      paramInt = i;
    }
  }

  public String i(int paramInt)
  {
    try
    {
      if (dl() < 1)
        return null;
      StringBuffer localStringBuffer = new StringBuffer(512);
      int i = this.kr.size();
      int j = 0;
      if (i > paramInt);
      while (true)
      {
        if (j < paramInt)
        {
          if (((ScanResult)this.kr.get(j)).level != 0)
          {
            Locale localLocale = Locale.CHINA;
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = ((ScanResult)this.kr.get(j)).BSSID.replace(":", "");
            arrayOfObject[1] = Integer.valueOf(((ScanResult)this.kr.get(j)).level);
            localStringBuffer.append(String.format(localLocale, "<access-point>\n<mac>%s</mac>\n<signal-strength>%d</signal-strength>\n</access-point>\n", arrayOfObject));
          }
        }
        else
        {
          String str = localStringBuffer.toString();
          return str;
          paramInt = i;
          j = 0;
          continue;
        }
        j++;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public boolean jdMethod_int(f paramf)
  {
    if ((this.kr != null) && (paramf != null) && (paramf.kr != null))
    {
      int i;
      if (this.kr.size() < paramf.kr.size())
        i = this.kr.size();
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label166;
        String str1 = ((ScanResult)this.kr.get(j)).BSSID;
        int k = ((ScanResult)this.kr.get(j)).level;
        String str2 = ((ScanResult)paramf.kr.get(j)).BSSID;
        int m = ((ScanResult)paramf.kr.get(j)).level;
        if ((!str1.equals(str2)) || (k != m))
        {
          return false;
          i = paramf.kr.size();
          break;
        }
      }
      label166: return true;
    }
    return false;
  }

  public String j(int paramInt)
  {
    int i = 0;
    if ((paramInt == 0) || (dl() < 1))
      return null;
    StringBuffer localStringBuffer = new StringBuffer(256);
    int j = this.kr.size();
    if (j > com.baidu.location.b.k.cD);
    for (int k = com.baidu.location.b.k.cD; ; k = j)
    {
      int m = 1;
      int n = 0;
      if (n < k)
      {
        if ((m & paramInt) == 0)
          break label176;
        if (i == 0)
        {
          localStringBuffer.append("&ssid=");
          label83: localStringBuffer.append(((ScanResult)this.kr.get(n)).BSSID.replace(":", ""));
          localStringBuffer.append(";");
          localStringBuffer.append(((ScanResult)this.kr.get(n)).SSID);
        }
      }
      label176: for (int i1 = i + 1; ; i1 = i)
      {
        m <<= 1;
        n++;
        i = i1;
        break;
        localStringBuffer.append("|");
        break label83;
        return localStringBuffer.toString();
      }
    }
  }

  public boolean jdMethod_new(f paramf)
  {
    if ((this.kr != null) && (paramf != null) && (paramf.kr != null))
    {
      int i;
      if (this.kr.size() < paramf.kr.size())
        i = this.kr.size();
      for (int j = 0; ; j++)
      {
        if (j >= i)
          break label115;
        if (!((ScanResult)this.kr.get(j)).BSSID.equals(((ScanResult)paramf.kr.get(j)).BSSID))
        {
          return false;
          i = paramf.kr.size();
          break;
        }
      }
      label115: return true;
    }
    return false;
  }

  public boolean jdMethod_try(f paramf)
  {
    return e.jdMethod_if(paramf, this, com.baidu.location.b.k.bF);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.h.f
 * JD-Core Version:    0.6.0
 */