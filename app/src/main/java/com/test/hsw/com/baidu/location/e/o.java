package com.baidu.location.e;

import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.g;
import com.baidu.location.b.m;
import com.baidu.location.c.d;
import com.baidu.location.c.d.b;
import com.baidu.location.c.d.c;
import com.baidu.location.h.a;
import com.baidu.location.h.h;
import com.baidu.location.h.l;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;

public class o
  implements com.baidu.location.b.f
{
  private static final String iA;
  private static File iB;
  private static o iC;
  private static final int iD = 1040;
  private static final int iE = 32;
  private static int iF = 0;
  private static final String iH;
  private static double iI = 0.0D;
  private static double iJ = 0.0D;
  private static ArrayList iK;
  private static final int iL = 128;
  private static String iM;
  private static int iN = 0;
  private static int iP = 0;
  private static double ik = 0.0D;
  private static final String il;
  private static Location im;
  private static ArrayList in = new ArrayList();
  private static com.baidu.location.h.f io;
  private static ArrayList ip;
  private static int iq = 0;
  private static int ir = 0;
  private static Location is;
  private static int it = 0;
  private static final String iu;
  private static final int iv = 2048;
  private static Location ix;
  private static double iy;
  private static int iz;
  private int iG = 0;
  private b iO = null;
  long iw = 0L;

  static
  {
    iK = new ArrayList();
    ip = new ArrayList();
    iM = com.baidu.location.b.e.int + "/yo.dat";
    iu = com.baidu.location.b.e.int + "/yoh.dat";
    iH = com.baidu.location.b.e.int + "/yom.dat";
    il = com.baidu.location.b.e.int + "/yol.dat";
    iA = com.baidu.location.b.e.int + "/yor.dat";
    iB = null;
    iN = 8;
    it = 8;
    iF = 16;
    iP = 1024;
    iJ = 0.0D;
    ik = 0.1D;
    iy = 30.0D;
    iI = 100.0D;
    ir = 0;
    iz = 64;
    iq = 128;
    ix = null;
    is = null;
    im = null;
    io = null;
    iC = null;
  }

  private static void A(String paramString)
  {
    w(paramString);
  }

  public static String jdMethod_byte(int paramInt)
  {
    String str1;
    ArrayList localArrayList;
    if (paramInt == 1)
    {
      str1 = iu;
      localArrayList = in;
    }
    while (localArrayList == null)
    {
      do
      {
        return null;
        if (paramInt == 2)
        {
          str1 = iH;
          localArrayList = iK;
          break;
        }
        if (paramInt != 3)
          continue;
        str1 = il;
        localArrayList = ip;
        break;
      }
      while (paramInt != 4);
      str1 = iA;
      localArrayList = ip;
    }
    if (localArrayList.size() < 1)
      jdMethod_for(str1, localArrayList);
    monitorenter;
    try
    {
      int i = localArrayList.size();
      String str2 = null;
      if (i > 0)
      {
        str2 = (String)localArrayList.get(i - 1);
        localArrayList.remove(i - 1);
      }
      return str2;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static boolean jdMethod_byte(Location paramLocation)
  {
    int i = 1;
    if (paramLocation == null)
      i = 0;
    double d2;
    do
    {
      return i;
      if ((is == null) || (ix == null))
      {
        is = paramLocation;
        return i;
      }
      double d1 = paramLocation.distanceTo(is);
      d2 = d1 * (d1 * com.baidu.location.b.k.cb) + d1 * com.baidu.location.b.k.ca + com.baidu.location.b.k.b9;
    }
    while (paramLocation.distanceTo(ix) > d2);
    return false;
  }

  public static void ch()
  {
    it = 0;
    jdMethod_if(1, false);
    jdMethod_if(2, false);
    jdMethod_if(3, false);
    it = 8;
  }

  public static String ci()
  {
    File localFile1 = new File(iH);
    boolean bool = localFile1.exists();
    String str = null;
    if (bool);
    try
    {
      RandomAccessFile localRandomAccessFile3 = new RandomAccessFile(localFile1, "rw");
      localRandomAccessFile3.seek(20L);
      int k = localRandomAccessFile3.readInt();
      str = null;
      if (k > 128)
      {
        str = "&p1=" + k;
        localRandomAccessFile3.seek(20L);
        localRandomAccessFile3.writeInt(0);
        localRandomAccessFile3.close();
        return str;
      }
      localRandomAccessFile3.close();
      label106: File localFile2 = new File(il);
      RandomAccessFile localRandomAccessFile2;
      if (localFile2.exists())
        try
        {
          localRandomAccessFile2 = new RandomAccessFile(localFile2, "rw");
          localRandomAccessFile2.seek(20L);
          int j = localRandomAccessFile2.readInt();
          if (j > 256)
          {
            str = "&p2=" + j;
            localRandomAccessFile2.seek(20L);
            localRandomAccessFile2.writeInt(0);
            localRandomAccessFile2.close();
            return str;
          }
        }
        catch (Exception localException2)
        {
        }
      while (true)
      {
        File localFile3 = new File(iA);
        if (!localFile3.exists())
          break;
        RandomAccessFile localRandomAccessFile1;
        try
        {
          localRandomAccessFile1 = new RandomAccessFile(localFile3, "rw");
          localRandomAccessFile1.seek(20L);
          int i = localRandomAccessFile1.readInt();
          if (i <= 512)
            break label313;
          str = "&p3=" + i;
          localRandomAccessFile1.seek(20L);
          localRandomAccessFile1.writeInt(0);
          localRandomAccessFile1.close();
          return str;
        }
        catch (Exception localException1)
        {
          return str;
        }
        localRandomAccessFile2.close();
        continue;
        label313: localRandomAccessFile1.close();
        return str;
      }
    }
    catch (Exception localException3)
    {
      break label106;
    }
    return str;
  }

  public static String cl()
  {
    return cn();
  }

  public static o cm()
  {
    if (iC == null)
      iC = new o();
    return iC;
  }

  public static String cn()
  {
    String str1 = null;
    int i = 1;
    if (i < 5)
    {
      str1 = jdMethod_byte(i);
      if (str1 == null);
    }
    do
    {
      do
      {
        do
        {
          return str1;
          i++;
          break;
          jdMethod_if(ip, iz);
          if (ip.size() <= 0)
            continue;
          str1 = (String)ip.get(0);
          ip.remove(0);
        }
        while (str1 != null);
        jdMethod_if(ip, ir);
        if (ip.size() <= 0)
          continue;
        str1 = (String)ip.get(0);
        ip.remove(0);
      }
      while (str1 != null);
      jdMethod_if(ip, iq);
    }
    while (ip.size() <= 0);
    String str2 = (String)ip.get(0);
    ip.remove(0);
    return str2;
  }

  public static void jdMethod_do(h paramh, com.baidu.location.h.f paramf, Location paramLocation, String paramString)
  {
    label9: if (!f.bA().gC)
    {
      break label9;
      break label9;
      break label9;
      break label9;
      break label9;
      break label9;
    }
    do
      return;
    while ((com.baidu.location.b.k.co == 3) && (!jdMethod_if(paramLocation, paramf)) && (!jdMethod_if(paramLocation, false)));
    BDLocation localBDLocation1 = com.baidu.location.c.b.aZ().jdMethod_byte(true);
    if (localBDLocation1.getLocType() == 66)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append(paramString);
      Locale localLocale2 = Locale.CHINA;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Double.valueOf(localBDLocation1.getLongitude());
      arrayOfObject2[1] = Double.valueOf(localBDLocation1.getLatitude());
      arrayOfObject2[2] = Integer.valueOf((int)localBDLocation1.getRadius());
      paramString = String.format(localLocale2, "&ofrt=%f|%f|%d", arrayOfObject2);
    }
    d locald2;
    d.c localc2;
    d.b localb2;
    if (com.baidu.location.b.k.jdMethod_for(com.baidu.location.f.getServiceContext()))
    {
      locald2 = d.jdMethod_try();
      localc2 = d.c.do;
      localb2 = d.b.do;
    }
    String str1;
    d locald1;
    d.c localc1;
    d.b localb1;
    for (BDLocation localBDLocation2 = locald2.jdMethod_if(paramh, paramf, null, localc2, localb2); ; localBDLocation2 = locald1.jdMethod_if(paramh, paramf, null, localc1, localb1))
    {
      if ((localBDLocation2 != null) && (localBDLocation2.getLocType() != 67))
        break label317;
      str1 = paramString + String.format(Locale.CHINA, "&ofl=%s|0", new Object[] { "1" });
      if ((paramh == null) || (!paramh.du()))
        break label461;
      if (!jdMethod_if(paramLocation, paramf))
        paramf = null;
      String str4 = com.baidu.location.b.k.jdMethod_if(paramh, paramf, paramLocation, str1, 1);
      if (str4 == null)
        break;
      y(Jni.H(str4));
      is = paramLocation;
      ix = paramLocation;
      if (paramf == null)
        break;
      io = paramf;
      return;
      locald1 = d.jdMethod_try();
      localc1 = d.c.if;
      localb1 = d.b.do;
    }
    label317: int i;
    if (localBDLocation2.getNetworkLocationType().equals("cl"))
      i = 1;
    while (true)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append(paramString);
      Locale localLocale1 = Locale.CHINA;
      Object[] arrayOfObject1 = new Object[5];
      arrayOfObject1[0] = "1";
      arrayOfObject1[1] = Integer.valueOf(i);
      arrayOfObject1[2] = Double.valueOf(localBDLocation2.getLongitude());
      arrayOfObject1[3] = Double.valueOf(localBDLocation2.getLatitude());
      arrayOfObject1[4] = Integer.valueOf((int)localBDLocation2.getRadius());
      str1 = String.format(localLocale1, "&ofl=%s|%d|%f|%f|%d", arrayOfObject1);
      break;
      boolean bool = localBDLocation2.getNetworkLocationType().equals("wf");
      i = 0;
      if (!bool)
        continue;
      i = 2;
    }
    label461: if ((paramf != null) && (paramf.dj()) && (jdMethod_if(paramLocation, paramf)))
    {
      if ((!jdMethod_byte(paramLocation)) && (!com.baidu.location.h.b.cU().cV()))
        str1 = "&cfr=1" + str1;
      while (true)
      {
        String str3 = com.baidu.location.b.k.jdMethod_if(paramh, paramf, paramLocation, str1, 2);
        if (str3 == null)
          break;
        x(Jni.H(str3));
        im = paramLocation;
        ix = paramLocation;
        if (paramf == null)
          break;
        io = paramf;
        return;
        if ((!jdMethod_byte(paramLocation)) && (com.baidu.location.h.b.cU().cV()))
        {
          str1 = "&cfr=3" + str1;
          continue;
        }
        if (!com.baidu.location.h.b.cU().cV())
          continue;
        str1 = "&cfr=2" + str1;
      }
    }
    if ((!jdMethod_byte(paramLocation)) && (!com.baidu.location.h.b.cU().cV()))
      str1 = "&cfr=1" + str1;
    while (true)
    {
      if (!jdMethod_if(paramLocation, paramf))
        paramf = null;
      if ((paramh == null) && (paramf == null))
        break;
      String str2 = com.baidu.location.b.k.jdMethod_if(paramh, paramf, paramLocation, str1, 3);
      if (str2 == null)
        break;
      A(Jni.H(str2));
      ix = paramLocation;
      if (paramf == null)
        break;
      io = paramf;
      return;
      if ((!jdMethod_byte(paramLocation)) && (com.baidu.location.h.b.cU().cV()))
      {
        str1 = "&cfr=3" + str1;
        continue;
      }
      if (!com.baidu.location.h.b.cU().cV())
        continue;
      str1 = "&cfr=2" + str1;
    }
  }

  public static boolean jdMethod_for(String paramString, List paramList)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
      return false;
    while (true)
    {
      int i1;
      int i2;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
        localRandomAccessFile.seek(8L);
        int i = localRandomAccessFile.readInt();
        int j = localRandomAccessFile.readInt();
        int k = localRandomAccessFile.readInt();
        byte[] arrayOfByte = new byte[iP];
        int m = it;
        int n = m + 1;
        i1 = j;
        i2 = n;
        int i3 = 0;
        if ((i2 <= 0) || (i1 <= 0))
          continue;
        if (i1 >= k)
          continue;
        k = 0;
        long l = 128 + i * (i1 - 1);
        try
        {
          localRandomAccessFile.seek(l);
          int i4 = localRandomAccessFile.readInt();
          if ((i4 > 0) && (i4 < i))
          {
            localRandomAccessFile.read(arrayOfByte, 0, i4);
            if (arrayOfByte[(i4 - 1)] == 0)
            {
              paramList.add(0, new String(arrayOfByte, 0, i4 - 1));
              i3 = 1;
              break label223;
              localRandomAccessFile.seek(12L);
              localRandomAccessFile.writeInt(i1);
              localRandomAccessFile.writeInt(k);
              localRandomAccessFile.close();
              return i3;
            }
          }
        }
        catch (Exception localException2)
        {
          return i3;
        }
      }
      catch (Exception localException1)
      {
        return false;
      }
      label223: i2--;
      i1--;
    }
  }

  private static int jdMethod_if(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramInt > 256) || (paramInt < 0))
      return -1;
    while (true)
    {
      int i1;
      int i2;
      try
      {
        if (iB != null)
          continue;
        iB = new File(iM);
        if (iB.exists())
          continue;
        iB = null;
        return -2;
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(iB, "rw");
        if (localRandomAccessFile.length() >= 1L)
          continue;
        localRandomAccessFile.close();
        return -3;
        localRandomAccessFile.seek(paramInt);
        int i = localRandomAccessFile.readInt();
        int j = localRandomAccessFile.readInt();
        int k = localRandomAccessFile.readInt();
        int m = localRandomAccessFile.readInt();
        long l = localRandomAccessFile.readLong();
        if ((jdMethod_if(i, j, k, m, l)) && (j >= 1))
          continue;
        localRandomAccessFile.close();
        return -4;
        byte[] arrayOfByte = new byte[iP];
        int n = iN;
        i1 = j;
        i2 = n;
        if ((i2 <= 0) || (i1 <= 0))
          continue;
        localRandomAccessFile.seek(l + m * ((-1 + (i + i1)) % k));
        int i4 = localRandomAccessFile.readInt();
        if ((i4 > 0) && (i4 < m))
        {
          localRandomAccessFile.read(arrayOfByte, 0, i4);
          if (arrayOfByte[(i4 - 1)] == 0)
          {
            paramList.add(new String(arrayOfByte, 0, i4 - 1));
            break label318;
            localRandomAccessFile.seek(paramInt);
            localRandomAccessFile.writeInt(i);
            localRandomAccessFile.writeInt(i1);
            localRandomAccessFile.writeInt(k);
            localRandomAccessFile.writeInt(m);
            localRandomAccessFile.writeLong(l);
            localRandomAccessFile.close();
            int i3 = iN;
            return i3 - i2;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return -5;
      }
      label318: i2--;
      i1--;
    }
  }

  public static String jdMethod_if(h paramh, com.baidu.location.h.f paramf, Location paramLocation, String paramString1, String paramString2)
  {
    if (!f.bA().gC)
      return null;
    return com.baidu.location.b.k.jdMethod_if(paramh, paramf, paramLocation, paramString1) + paramString2;
  }

  public static void jdMethod_if(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    label28: File localFile;
    if (paramInt == 1)
    {
      String str4 = iu;
      if (paramBoolean)
        return;
      ArrayList localArrayList6 = in;
      localObject1 = str4;
      localObject2 = localArrayList6;
      localFile = new File((String)localObject1);
      if (!localFile.exists())
        v((String)localObject1);
    }
    while (true)
    {
      int k;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
        localRandomAccessFile.seek(4L);
        int i = localRandomAccessFile.readInt();
        int j = localRandomAccessFile.readInt();
        k = localRandomAccessFile.readInt();
        int m = localRandomAccessFile.readInt();
        int n = localRandomAccessFile.readInt();
        int i1 = ((List)localObject2).size();
        i2 = n;
        if (i1 <= it)
          break label541;
        if (paramBoolean)
        {
          i3 = i2 + 1;
          if (k >= i)
            continue;
          localRandomAccessFile.seek(128 + j * k);
          byte[] arrayOfByte1 = ((String)((List)localObject2).get(0) + '\000').getBytes();
          localRandomAccessFile.writeInt(arrayOfByte1.length);
          localRandomAccessFile.write(arrayOfByte1, 0, arrayOfByte1.length);
          ((List)localObject2).remove(0);
          int i4 = k + 1;
          int i5 = m;
          i6 = i4;
          int i7 = i5;
          i1--;
          k = i6;
          m = i7;
          i2 = i3;
          continue;
          if (paramInt != 2)
            continue;
          String str3 = iH;
          if (!paramBoolean)
            continue;
          ArrayList localArrayList5 = in;
          localObject1 = str3;
          localObject2 = localArrayList5;
          break label28;
          ArrayList localArrayList4 = iK;
          localObject1 = str3;
          localObject2 = localArrayList4;
          break label28;
          if (paramInt != 3)
            continue;
          String str2 = il;
          if (!paramBoolean)
            continue;
          ArrayList localArrayList3 = iK;
          localObject1 = str2;
          localObject2 = localArrayList3;
          break label28;
          ArrayList localArrayList2 = ip;
          localObject1 = str2;
          localObject2 = localArrayList2;
          break label28;
          if (paramInt != 4)
            break;
          String str1 = iA;
          if (!paramBoolean)
            break;
          ArrayList localArrayList1 = ip;
          localObject1 = str1;
          localObject2 = localArrayList1;
          break label28;
          if (!paramBoolean)
            break label554;
          long l = 128 + m * j;
          localRandomAccessFile.seek(l);
          byte[] arrayOfByte2 = ((String)((List)localObject2).get(0) + '\000').getBytes();
          localRandomAccessFile.writeInt(arrayOfByte2.length);
          localRandomAccessFile.write(arrayOfByte2, 0, arrayOfByte2.length);
          ((List)localObject2).remove(0);
          i7 = m + 1;
          if (i7 <= k)
            break label547;
          i7 = 0;
          break label547;
          localRandomAccessFile.seek(12L);
          localRandomAccessFile.writeInt(k);
          localRandomAccessFile.writeInt(m);
          localRandomAccessFile.writeInt(i2);
          localRandomAccessFile.close();
          if ((i8 == 0) || (paramInt >= 4))
            break;
          jdMethod_if(paramInt + 1, true);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      int i3 = i2;
      continue;
      label541: int i8 = 0;
      continue;
      label547: int i6 = k;
      continue;
      label554: i8 = 1;
      int i2 = i3;
    }
  }

  private static boolean jdMethod_if(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if ((paramInt1 < 0) || (paramInt1 >= paramInt3));
    do
      return false;
    while ((paramInt2 < 0) || (paramInt2 > paramInt3) || (paramInt3 < 0) || (paramInt3 > 1024) || (paramInt4 < 128) || (paramInt4 > 1024));
    return true;
  }

  private static boolean jdMethod_if(Location paramLocation, com.baidu.location.h.f paramf)
  {
    if ((paramLocation == null) || (paramf == null) || (paramf.kr == null) || (paramf.kr.isEmpty()));
    do
      return false;
    while (paramf.jdMethod_int(io));
    if (im == null)
    {
      im = paramLocation;
      return true;
    }
    return true;
  }

  public static boolean jdMethod_if(Location paramLocation, boolean paramBoolean)
  {
    return a.jdMethod_if(ix, paramLocation, paramBoolean);
  }

  public static void jdMethod_new(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if (paramDouble1 > 0.0D)
    {
      iJ = paramDouble1;
      ik = paramDouble2;
      if (paramDouble3 <= 20.0D)
        break label41;
    }
    while (true)
    {
      iy = paramDouble3;
      iI = paramDouble4;
      return;
      paramDouble1 = iJ;
      break;
      label41: paramDouble3 = iy;
    }
  }

  public static void v(String paramString)
  {
    try
    {
      File localFile1 = new File(paramString);
      if (!localFile1.exists())
      {
        File localFile2 = new File(com.baidu.location.b.e.int);
        if (!localFile2.exists())
          localFile2.mkdirs();
        if (!localFile1.createNewFile())
          localFile1 = null;
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile.seek(0L);
        localRandomAccessFile.writeInt(32);
        localRandomAccessFile.writeInt(2048);
        localRandomAccessFile.writeInt(1040);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.close();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void w(String paramString)
  {
    monitorenter;
    try
    {
      int i = com.baidu.location.b.k.b3;
      ArrayList localArrayList;
      if (i == 1)
      {
        localArrayList = in;
        if (localArrayList != null)
          break label48;
      }
      while (true)
      {
        return;
        if (i == 2)
        {
          localArrayList = iK;
          break;
        }
        if (i != 3)
          continue;
        localArrayList = ip;
        break;
        label48: if (localArrayList.size() <= iF)
          localArrayList.add(paramString);
        if (localArrayList.size() >= iF)
          jdMethod_if(i, false);
        while (localArrayList.size() > iF)
          localArrayList.remove(0);
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  private static void x(String paramString)
  {
    w(paramString);
  }

  private static void y(String paramString)
  {
    w(paramString);
  }

  public void cj()
  {
    if ((!e.bv().bt()) || (this.iw == 0L));
    do
      return;
    while (System.currentTimeMillis() - this.iw <= 1200000L);
    ck();
  }

  public void ck()
  {
  }

  public void co()
  {
    if (!l.a().c9())
      return;
    this.iO.aT();
  }

  public void z(String paramString)
  {
    new a(paramString).aS();
  }

  private class a extends m
  {
    private String eO;

    public a(String arg2)
    {
      Object localObject;
      this.eO = localObject;
      this.c7 = new ArrayList();
    }

    public void aS()
    {
      ao();
    }

    public void au()
    {
      this.c5 = com.baidu.location.b.k.Z();
      this.c7.add(new BasicNameValuePair("cldc[0]", this.eO));
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null));
    }
  }

  private class b extends m
  {
    boolean eQ = false;
    private ArrayList eR = null;
    int eS = 0;
    int eT = 0;

    public b()
    {
      this.c7 = new ArrayList();
    }

    public void aT()
    {
      if (this.eQ)
        return;
      if ((de > 4) && (this.eS < de))
      {
        this.eS = (1 + this.eS);
        return;
      }
      this.eS = 0;
      this.eQ = true;
      this.eT = 0;
      int i;
      if ((this.eR == null) || (this.eR.size() < 1))
      {
        if (this.eR == null)
          this.eR = new ArrayList();
        this.eT = 0;
        i = 0;
        if (this.eT >= 2)
          break label210;
      }
      label179: label205: label210: for (Object localObject = o.cl(); ; localObject = null)
      {
        if ((localObject == null) && (this.eT != 1))
          this.eT = 2;
        while (true)
        {
          try
          {
            String str = k.b7();
            localObject = str;
            if (localObject != null)
              break label179;
            if ((this.eR != null) && (this.eR.size() >= 1))
              break label205;
            this.eR = null;
            this.eQ = false;
            return;
          }
          catch (Exception localException)
          {
            localObject = null;
            continue;
          }
          this.eT = 1;
          continue;
          this.eR.add(localObject);
          i += ((String)localObject).length();
          if (i < g.Y)
            break;
        }
        ao();
        return;
      }
    }

    public void au()
    {
      this.c5 = com.baidu.location.b.k.Z();
      this.dg = 2;
      if (this.eR != null)
      {
        int i = 0;
        if (i < this.eR.size())
        {
          if (this.eT == 1)
            this.c7.add(new BasicNameValuePair("cldc[" + i + "]", (String)this.eR.get(i)));
          while (true)
          {
            i++;
            break;
            this.c7.add(new BasicNameValuePair("cltr[" + i + "]", (String)this.eR.get(i)));
          }
        }
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Long.valueOf(System.currentTimeMillis());
        String str = String.format(localLocale, "%d", arrayOfObject);
        this.c7.add(new BasicNameValuePair("trtm", str));
      }
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null) && (this.eR != null))
        this.eR.clear();
      if (this.c7 != null)
        this.c7.clear();
      this.eQ = false;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.o
 * JD-Core Version:    0.6.0
 */