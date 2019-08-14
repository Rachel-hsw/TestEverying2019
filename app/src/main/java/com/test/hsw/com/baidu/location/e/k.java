package com.baidu.location.e;

import android.location.Location;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

public class k
  implements com.baidu.location.b.f
{
  private static int h0 = 0;
  private static final int h1 = 5;
  private static final int h2 = 750;
  private static final int h3 = 1000;
  private static final int h5 = 100;
  private static int h7 = 0;
  private static k h8 = null;
  private static long h9 = 0L;
  private static final int hL = 12;
  private static StringBuffer hM;
  private static final int hN = 5;
  private static File hO;
  private static final int hP = 3600;
  private static int hQ = 0;
  private static long hR = 0L;
  private static long hS = 0L;
  private static boolean hT = false;
  private static final int hU = 1024;
  private static int hV;
  private static double hW;
  private static double hX;
  private static String hY = "Temp_in.dat";
  private static int hZ;
  private String h4 = null;
  private boolean h6 = true;

  static
  {
    hO = new File(e.int, hY);
    hM = null;
    hT = true;
    hZ = 0;
    h7 = 0;
    hS = 0L;
    hR = 0L;
    h9 = 0L;
    hW = 0.0D;
    hX = 0.0D;
    hQ = 0;
    hV = 0;
    h0 = 0;
  }

  private k(String paramString)
  {
    if (paramString != null)
      if (paramString.length() <= 100);
    for (paramString = paramString.substring(0, 100); ; paramString = "")
    {
      this.h4 = paramString;
      return;
    }
  }

  private static boolean b2()
  {
    if (hO.exists())
      hO.delete();
    if (!hO.getParentFile().exists())
      hO.getParentFile().mkdirs();
    try
    {
      hO.createNewFile();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(hO, "rw");
      localRandomAccessFile.seek(0L);
      localRandomAccessFile.writeInt(0);
      localRandomAccessFile.writeInt(0);
      localRandomAccessFile.writeInt(1);
      localRandomAccessFile.close();
      b4();
      return hO.exists();
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  private void b3()
  {
    if ((hM != null) && (hM.length() >= 100))
      u(hM.toString());
    b4();
  }

  private static void b4()
  {
    hT = true;
    hM = null;
    hZ = 0;
    h7 = 0;
    hS = 0L;
    hR = 0L;
    h9 = 0L;
    hW = 0.0D;
    hX = 0.0D;
    hQ = 0;
    hV = 0;
    h0 = 0;
  }

  private void b5()
  {
  }

  public static k b6()
  {
    if (h8 == null)
      h8 = new k(c.N().K());
    return h8;
  }

  public static String b7()
  {
    if (hO == null)
      return null;
    if (!hO.exists())
      return null;
    while (true)
    {
      int j;
      int k;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(hO, "rw");
        localRandomAccessFile.seek(0L);
        int i = localRandomAccessFile.readInt();
        j = localRandomAccessFile.readInt();
        k = localRandomAccessFile.readInt();
        if (!jdMethod_if(i, j, k))
        {
          localRandomAccessFile.close();
          b2();
          return null;
          localRandomAccessFile.close();
          return null;
          long l = 0L + (12 + 1024 * (j - 1));
          localRandomAccessFile.seek(l);
          int m = localRandomAccessFile.readInt();
          byte[] arrayOfByte = new byte[m];
          localRandomAccessFile.seek(l + 4L);
          int n = 0;
          if (n >= m)
            continue;
          arrayOfByte[n] = localRandomAccessFile.readByte();
          n++;
          continue;
          String str = new String(arrayOfByte);
          if (i >= com.baidu.location.b.k.cr)
            continue;
          int i1 = j + 1;
          localRandomAccessFile.seek(4L);
          localRandomAccessFile.writeInt(i1);
          localRandomAccessFile.close();
          return str;
          int i2 = com.baidu.location.b.k.cr;
          if (j != i2)
            continue;
          i1 = 1;
          continue;
          i1 = j + 1;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        return null;
      }
      if (j == 0)
        continue;
      if (j != k)
        continue;
    }
  }

  private boolean b8()
  {
    if (hO.exists())
      hO.delete();
    b4();
    return !hO.exists();
  }

  private static boolean jdMethod_if(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if ((paramInt1 < 0) || (paramInt1 > com.baidu.location.b.k.cr))
      i = 0;
    do
    {
      return i;
      if ((paramInt2 < 0) || (paramInt2 > paramInt1 + 1))
        return false;
    }
    while ((paramInt3 >= i) && (paramInt3 <= paramInt1 + 1) && (paramInt3 <= com.baidu.location.b.k.cr));
    return false;
  }

  private boolean jdMethod_if(Location paramLocation, int paramInt1, int paramInt2)
  {
    if ((paramLocation == null) || (!com.baidu.location.b.k.bR) || (!this.h6) || (!f.bA().gE))
      return false;
    if (com.baidu.location.b.k.cB < 5)
    {
      com.baidu.location.b.k.cB = 5;
      if (com.baidu.location.b.k.cF >= 5)
        break label243;
      com.baidu.location.b.k.cF = 5;
    }
    double d1;
    double d2;
    long l1;
    while (true)
    {
      d1 = paramLocation.getLongitude();
      d2 = paramLocation.getLatitude();
      l1 = paramLocation.getTime() / 1000L;
      if (!hT)
        break label261;
      hZ = 1;
      hM = new StringBuffer("");
      StringBuffer localStringBuffer3 = hM;
      Locale localLocale3 = Locale.CHINA;
      Object[] arrayOfObject3 = new Object[4];
      arrayOfObject3[0] = this.h4;
      arrayOfObject3[1] = Long.valueOf(l1);
      arrayOfObject3[2] = Double.valueOf(d1);
      arrayOfObject3[3] = Double.valueOf(d2);
      localStringBuffer3.append(String.format(localLocale3, "&nr=%s&traj=%d,%.5f,%.5f|", arrayOfObject3));
      h7 = hM.length();
      hS = l1;
      hW = d1;
      hX = d2;
      hR = ()Math.floor(0.5D + d1 * 100000.0D);
      h9 = ()Math.floor(0.5D + d2 * 100000.0D);
      hT = false;
      return true;
      if (com.baidu.location.b.k.cB <= 1000)
        break;
      com.baidu.location.b.k.cB = 1000;
      break;
      label243: if (com.baidu.location.b.k.cF <= 3600)
        continue;
      com.baidu.location.b.k.cF = 3600;
    }
    label261: float[] arrayOfFloat = new float[1];
    Location.distanceBetween(d2, d1, hX, hW, arrayOfFloat);
    long l2 = l1 - hS;
    if ((arrayOfFloat[0] >= com.baidu.location.b.k.cB) || (l2 >= com.baidu.location.b.k.cF))
    {
      if (hM == null)
      {
        hZ = 1 + hZ;
        h7 = 0;
        hM = new StringBuffer("");
        StringBuffer localStringBuffer2 = hM;
        Locale localLocale2 = Locale.CHINA;
        Object[] arrayOfObject2 = new Object[4];
        arrayOfObject2[0] = this.h4;
        arrayOfObject2[1] = Long.valueOf(l1);
        arrayOfObject2[2] = Double.valueOf(d1);
        arrayOfObject2[3] = Double.valueOf(d2);
        localStringBuffer2.append(String.format(localLocale2, "&nr=%s&traj=%d,%.5f,%.5f|", arrayOfObject2));
        h7 = hM.length();
        hS = l1;
        hW = d1;
        hX = d2;
        hR = ()Math.floor(0.5D + d1 * 100000.0D);
        h9 = ()Math.floor(0.5D + d2 * 100000.0D);
      }
      while (true)
      {
        if (15 + h7 > 750)
        {
          u(hM.toString());
          hM = null;
        }
        if (hZ >= com.baidu.location.b.k.cr)
          this.h6 = false;
        return true;
        hW = d1;
        hX = d2;
        long l3 = ()Math.floor(0.5D + d1 * 100000.0D);
        long l4 = ()Math.floor(0.5D + d2 * 100000.0D);
        hQ = (int)(l1 - hS);
        hV = (int)(l3 - hR);
        h0 = (int)(l4 - h9);
        StringBuffer localStringBuffer1 = hM;
        Locale localLocale1 = Locale.CHINA;
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = Integer.valueOf(hQ);
        arrayOfObject1[1] = Integer.valueOf(hV);
        arrayOfObject1[2] = Integer.valueOf(h0);
        localStringBuffer1.append(String.format(localLocale1, "%d,%d,%d|", arrayOfObject1));
        h7 = hM.length();
        hS = l1;
        hR = l3;
        h9 = l4;
      }
    }
    return false;
  }

  private String jdMethod_try(int paramInt)
  {
    if (!hO.exists())
      return null;
    while (true)
    {
      int i;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(hO, "rw");
        localRandomAccessFile.seek(0L);
        i = localRandomAccessFile.readInt();
        if (!jdMethod_if(i, localRandomAccessFile.readInt(), localRandomAccessFile.readInt()))
        {
          localRandomAccessFile.close();
          b2();
          return null;
          localRandomAccessFile.close();
          return null;
          long l = 12L + 0L + 1024 * (paramInt - 1);
          localRandomAccessFile.seek(l);
          int j = localRandomAccessFile.readInt();
          byte[] arrayOfByte = new byte[j];
          localRandomAccessFile.seek(l + 4L);
          int k = 0;
          if (k >= j)
            continue;
          arrayOfByte[k] = localRandomAccessFile.readByte();
          k++;
          continue;
          localRandomAccessFile.close();
          String str = new String(arrayOfByte);
          return str;
        }
      }
      catch (IOException localIOException)
      {
        return null;
      }
      if (paramInt == 0)
        continue;
      if (paramInt != i + 1)
        continue;
    }
  }

  private boolean u(String paramString)
  {
    if ((paramString == null) || (!paramString.startsWith("&nr")));
    do
      return false;
    while ((!hO.exists()) && (!b2()));
    while (true)
    {
      int k;
      try
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(hO, "rw");
        localRandomAccessFile.seek(0L);
        int i = localRandomAccessFile.readInt();
        int j = localRandomAccessFile.readInt();
        k = localRandomAccessFile.readInt();
        if (jdMethod_if(i, j, k))
          continue;
        localRandomAccessFile.close();
        b2();
        return false;
        if (!com.baidu.location.b.k.bK)
          continue;
        if (i == com.baidu.location.b.k.cr)
          continue;
        if ((k <= 1) || (!paramString.equals(jdMethod_try(k - 1))))
          continue;
        localRandomAccessFile.close();
        return false;
        if (k == 1)
        {
          i4 = com.baidu.location.b.k.cr;
          if (!paramString.equals(jdMethod_try(i4)))
            continue;
          localRandomAccessFile.close();
          return false;
          localRandomAccessFile.seek(0L + (12 + 1024 * (k - 1)));
          if (paramString.length() <= 750)
            continue;
          localRandomAccessFile.close();
          return false;
          String str = Jni.H(paramString);
          int m = str.length();
          if (m <= 1020)
            continue;
          localRandomAccessFile.close();
          return false;
          localRandomAccessFile.writeInt(m);
          localRandomAccessFile.writeBytes(str);
          if (i != 0)
            continue;
          localRandomAccessFile.seek(0L);
          localRandomAccessFile.writeInt(1);
          localRandomAccessFile.writeInt(1);
          localRandomAccessFile.writeInt(2);
          localRandomAccessFile.close();
          return true;
          if (i >= -1 + com.baidu.location.b.k.cr)
            continue;
          localRandomAccessFile.seek(0L);
          localRandomAccessFile.writeInt(i + 1);
          localRandomAccessFile.seek(8L);
          localRandomAccessFile.writeInt(i + 2);
          continue;
          if (i != -1 + com.baidu.location.b.k.cr)
            continue;
          localRandomAccessFile.seek(0L);
          localRandomAccessFile.writeInt(com.baidu.location.b.k.cr);
          if ((j != 0) && (j != 1))
            continue;
          localRandomAccessFile.writeInt(2);
          localRandomAccessFile.seek(8L);
          localRandomAccessFile.writeInt(1);
          continue;
          if (k != j)
            continue;
          if (k != com.baidu.location.b.k.cr)
            break label497;
          n = 1;
          if (n != com.baidu.location.b.k.cr)
            break label506;
          i1 = 1;
          localRandomAccessFile.seek(4L);
          localRandomAccessFile.writeInt(i1);
          localRandomAccessFile.writeInt(n);
          continue;
          if (k != com.baidu.location.b.k.cr)
            continue;
          int i2 = 1;
          if (i2 != j)
            continue;
          if (i2 != com.baidu.location.b.k.cr)
            continue;
          int i3 = 1;
          localRandomAccessFile.seek(4L);
          localRandomAccessFile.writeInt(i3);
          localRandomAccessFile.seek(8L);
          localRandomAccessFile.writeInt(i2);
          continue;
          i2 = k + 1;
          continue;
          i3 = i2 + 1;
          continue;
        }
      }
      catch (IOException localIOException)
      {
        return false;
      }
      int i4 = k - 1;
      continue;
      label497: int n = k + 1;
      continue;
      label506: int i1 = n + 1;
    }
  }

  public void b9()
  {
    b3();
  }

  public boolean jdMethod_try(Location paramLocation)
  {
    return jdMethod_if(paramLocation, com.baidu.location.b.k.cB, com.baidu.location.b.k.cF);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.k
 * JD-Core Version:    0.6.0
 */