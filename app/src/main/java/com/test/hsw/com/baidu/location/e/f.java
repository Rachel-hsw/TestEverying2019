package com.baidu.location.e;

import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import com.baidu.location.b.n;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class f
  implements com.baidu.location.b.f
{
  private static int gA = 0;
  private static final int gD = 128;
  private static f gF = null;
  private static int gI;
  private static int gK;
  private static final String gy = e.int + "/conlts.dat";
  public boolean gB = true;
  public boolean gC = true;
  public boolean gE = true;
  public boolean gG = false;
  public boolean gH = false;
  public boolean gJ = true;
  public boolean gw = true;
  public boolean gx = true;
  private a gz = null;

  static
  {
    gI = -1;
    gA = -1;
    gK = 0;
  }

  public static f bA()
  {
    if (gF == null)
      gF = new f();
    return gF;
  }

  private void bB()
  {
    try
    {
      File localFile1 = new File(gy);
      if (!localFile1.exists())
      {
        File localFile2 = new File(e.int);
        if (!localFile2.exists())
          localFile2.mkdirs();
        if (!localFile1.createNewFile())
          localFile1 = null;
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile.seek(0L);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.writeInt(128);
        localRandomAccessFile.writeInt(0);
        localRandomAccessFile.close();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void bC()
  {
    String str = e.int + "/config.dat";
    try
    {
      File localFile = new File(str);
      if (localFile.exists())
      {
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
        if (localRandomAccessFile.readBoolean())
        {
          localRandomAccessFile.seek(2L);
          int i = localRandomAccessFile.readInt();
          byte[] arrayOfByte = new byte[i];
          localRandomAccessFile.read(arrayOfByte, 0, i);
          n(new String(arrayOfByte));
        }
        localRandomAccessFile.seek(1L);
        if (localRandomAccessFile.readBoolean())
        {
          localRandomAccessFile.seek(1024L);
          k.bG = localRandomAccessFile.readDouble();
          k.b4 = localRandomAccessFile.readDouble();
          k.cM = localRandomAccessFile.readBoolean();
          if (k.cM)
          {
            k.b2 = new byte[625];
            localRandomAccessFile.read(k.b2, 0, 625);
          }
        }
        localRandomAccessFile.close();
      }
      label182: jdMethod_do(null);
      return;
    }
    catch (Exception localException)
    {
      break label182;
    }
  }

  private void bE()
  {
    String str = "&ver=" + k.b0 + "&usr=" + c.N().L() + "&app=" + c.bn + "&prod=" + c.bj;
    if (this.gz == null)
      this.gz = new a();
    this.gz.jdMethod_if(str, false);
  }

  private void bF()
  {
    String str = e.int + "/config.dat";
    try
    {
      File localFile1 = new File(str);
      if (!localFile1.exists())
      {
        File localFile2 = new File(e.int);
        if (!localFile2.exists())
          localFile2.mkdirs();
        if (localFile1.createNewFile())
        {
          RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile1, "rw");
          localRandomAccessFile1.seek(0L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.close();
        }
      }
      else
      {
        RandomAccessFile localRandomAccessFile2 = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile2.seek(1L);
        localRandomAccessFile2.writeBoolean(true);
        localRandomAccessFile2.seek(1024L);
        localRandomAccessFile2.writeDouble(k.bG);
        localRandomAccessFile2.writeDouble(k.b4);
        localRandomAccessFile2.writeBoolean(k.cM);
        if ((k.cM) && (k.b2 != null))
          localRandomAccessFile2.write(k.b2);
        localRandomAccessFile2.close();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void bH()
  {
    for (int i = 0; ; i++)
      try
      {
        File localFile = new File(gy);
        if (!localFile.exists())
          break;
        RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
        localRandomAccessFile.seek(4L);
        int j = localRandomAccessFile.readInt();
        if (j > 3000)
        {
          localRandomAccessFile.close();
          gK = 0;
          bB();
          return;
        }
        int k = localRandomAccessFile.readInt();
        localRandomAccessFile.seek(128L);
        byte[] arrayOfByte = new byte[j];
        if (i < k)
        {
          localRandomAccessFile.seek(128 + j * i);
          int m = localRandomAccessFile.readInt();
          if ((m <= 0) || (m >= j))
            continue;
          localRandomAccessFile.read(arrayOfByte, 0, m);
          if (arrayOfByte[(m - 1)] != 0)
            continue;
          String str = new String(arrayOfByte, 0, m - 1);
          c.N();
          if (!str.equals(c.bn))
            continue;
          gI = localRandomAccessFile.readInt();
          gK = i;
        }
        if (i == k)
          gK = k;
        localRandomAccessFile.close();
        return;
      }
      catch (Exception localException)
      {
        return;
      }
  }

  private void bz()
  {
    String str = e.int + "/config.dat";
    if (k.bR);
    for (int i = 1; ; i = 0)
    {
      if (k.bK);
      for (int j = 1; ; j = 0)
      {
        Locale localLocale = Locale.CHINA;
        Object[] arrayOfObject = new Object[39];
        arrayOfObject[0] = Integer.valueOf(k.b0);
        arrayOfObject[1] = Float.valueOf(k.cQ);
        arrayOfObject[2] = Float.valueOf(k.bW);
        arrayOfObject[3] = Float.valueOf(k.ck);
        arrayOfObject[4] = Float.valueOf(k.cA);
        arrayOfObject[5] = Integer.valueOf(k.b7);
        arrayOfObject[6] = Integer.valueOf(k.cq);
        arrayOfObject[7] = Integer.valueOf(k.cC);
        arrayOfObject[8] = Integer.valueOf(k.bJ);
        arrayOfObject[9] = Integer.valueOf(k.bH);
        arrayOfObject[10] = Integer.valueOf(k.cI);
        arrayOfObject[11] = Integer.valueOf(k.bQ);
        arrayOfObject[12] = Float.valueOf(k.ch);
        arrayOfObject[13] = Float.valueOf(k.cg);
        arrayOfObject[14] = Float.valueOf(k.cO);
        arrayOfObject[15] = Float.valueOf(k.cx);
        arrayOfObject[16] = Integer.valueOf(k.cD);
        arrayOfObject[17] = Float.valueOf(k.bL);
        arrayOfObject[18] = Integer.valueOf(k.cy);
        arrayOfObject[19] = Float.valueOf(k.bF);
        arrayOfObject[20] = Float.valueOf(k.cb);
        arrayOfObject[21] = Float.valueOf(k.ca);
        arrayOfObject[22] = Integer.valueOf(k.b9);
        arrayOfObject[23] = Integer.valueOf(k.b8);
        arrayOfObject[24] = Integer.valueOf(i);
        arrayOfObject[25] = Integer.valueOf(j);
        arrayOfObject[26] = Integer.valueOf(k.cB);
        arrayOfObject[27] = Integer.valueOf(k.cr);
        arrayOfObject[28] = Long.valueOf(k.cH);
        arrayOfObject[29] = Integer.valueOf(k.cL);
        arrayOfObject[30] = Float.valueOf(k.cd);
        arrayOfObject[31] = Float.valueOf(k.cz);
        arrayOfObject[32] = Integer.valueOf(k.cc);
        arrayOfObject[33] = Integer.valueOf(k.cK);
        arrayOfObject[34] = Integer.valueOf(k.bO);
        arrayOfObject[35] = Integer.valueOf(k.bI);
        arrayOfObject[36] = Integer.valueOf(k.bM);
        arrayOfObject[37] = Float.valueOf(k.cn);
        arrayOfObject[38] = Integer.valueOf(k.bT);
        byte[] arrayOfByte = String.format(localLocale, "{\"ver\":\"%d\",\"gps\":\"%.1f|%.1f|%.1f|%.1f|%d|%d|%d|%d|%d|%d|%d\",\"up\":\"%.1f|%.1f|%.1f|%.1f\",\"wf\":\"%d|%.1f|%d|%.1f\",\"ab\":\"%.2f|%.2f|%d|%d\",\"gpc\":\"%d|%d|%d|%d|%d|%d\",\"zxd\":\"%.1f|%.1f|%d|%d|%d\",\"shak\":\"%d|%d|%.1f\",\"dmx\":%d}", arrayOfObject).getBytes();
        try
        {
          File localFile1 = new File(str);
          if (!localFile1.exists())
          {
            File localFile2 = new File(e.int);
            if (!localFile2.exists())
              localFile2.mkdirs();
            if (localFile1.createNewFile())
            {
              RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile1, "rw");
              localRandomAccessFile1.seek(0L);
              localRandomAccessFile1.writeBoolean(false);
              localRandomAccessFile1.writeBoolean(false);
              localRandomAccessFile1.close();
            }
          }
          else
          {
            RandomAccessFile localRandomAccessFile2 = new RandomAccessFile(localFile1, "rw");
            localRandomAccessFile2.seek(0L);
            localRandomAccessFile2.writeBoolean(true);
            localRandomAccessFile2.seek(2L);
            localRandomAccessFile2.writeInt(arrayOfByte.length);
            localRandomAccessFile2.write(arrayOfByte);
            localRandomAccessFile2.close();
          }
          return;
        }
        catch (Exception localException)
        {
          return;
        }
      }
    }
  }

  private void jdMethod_do(int paramInt)
  {
    int i = 1;
    int j;
    int k;
    label26: int m;
    label42: int n;
    label60: int i1;
    if ((paramInt & 0x1) == i)
    {
      j = i;
      this.gC = j;
      if ((paramInt & 0x2) != 2)
        break label122;
      k = i;
      this.gE = k;
      if ((paramInt & 0x4) != 4)
        break label128;
      m = i;
      this.gH = m;
      if ((paramInt & 0x8) != 8)
        break label134;
      n = i;
      this.gw = n;
      if ((paramInt & 0x10000) != 65536)
        break label140;
      i1 = i;
      label80: this.gx = i1;
      if ((paramInt & 0x20000) != 131072)
        break label146;
    }
    while (true)
    {
      this.gB = i;
      if ((paramInt & 0x10) == 16)
        this.gJ = false;
      return;
      j = 0;
      break;
      label122: k = 0;
      break label26;
      label128: m = 0;
      break label42;
      label134: n = 0;
      break label60;
      label140: i1 = 0;
      break label80;
      label146: i = 0;
    }
  }

  // ERROR //
  private void jdMethod_do(HttpEntity paramHttpEntity)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_m1
    //   3: putstatic 58	com/baidu/location/e/f:gA	I
    //   6: aload_1
    //   7: ifnull +58 -> 65
    //   10: aload_1
    //   11: ldc_w 388
    //   14: invokestatic 393	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_2
    //   18: aload_0
    //   19: aload_2
    //   20: invokespecial 143	com/baidu/location/e/f:n	(Ljava/lang/String;)Z
    //   23: ifeq +7 -> 30
    //   26: aload_0
    //   27: invokespecial 395	com/baidu/location/e/f:bz	()V
    //   30: new 397	org/json/JSONObject
    //   33: dup
    //   34: aload_2
    //   35: invokespecial 398	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: astore 9
    //   40: aload 9
    //   42: ldc_w 400
    //   45: invokevirtual 403	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   48: ifeq +17 -> 65
    //   51: aload 9
    //   53: ldc_w 400
    //   56: invokevirtual 407	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: invokestatic 411	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   62: putstatic 58	com/baidu/location/e/f:gA	I
    //   65: aload_0
    //   66: invokespecial 413	com/baidu/location/e/f:bH	()V
    //   69: getstatic 58	com/baidu/location/e/f:gA	I
    //   72: iconst_m1
    //   73: if_icmpeq +55 -> 128
    //   76: getstatic 58	com/baidu/location/e/f:gA	I
    //   79: istore 4
    //   81: aload_0
    //   82: getstatic 58	com/baidu/location/e/f:gA	I
    //   85: invokespecial 415	com/baidu/location/e/f:if	(I)V
    //   88: iload 4
    //   90: iconst_m1
    //   91: if_icmpeq +9 -> 100
    //   94: aload_0
    //   95: iload 4
    //   97: invokespecial 417	com/baidu/location/e/f:do	(I)V
    //   100: getstatic 422	com/baidu/location/f:isServing	Z
    //   103: istore 5
    //   105: iload 5
    //   107: ifeq +20 -> 127
    //   110: aload_0
    //   111: getfield 69	com/baidu/location/e/f:gH	Z
    //   114: ifeq +13 -> 127
    //   117: getstatic 425	com/baidu/location/b/k:cl	Z
    //   120: istore 7
    //   122: iload 7
    //   124: ifeq +3 -> 127
    //   127: return
    //   128: getstatic 56	com/baidu/location/e/f:gI	I
    //   131: iconst_m1
    //   132: if_icmpeq +26 -> 158
    //   135: getstatic 56	com/baidu/location/e/f:gI	I
    //   138: istore 4
    //   140: goto -52 -> 88
    //   143: astore_3
    //   144: return
    //   145: astore 6
    //   147: return
    //   148: astore 10
    //   150: goto -85 -> 65
    //   153: astore 8
    //   155: goto -125 -> 30
    //   158: iconst_m1
    //   159: istore 4
    //   161: goto -73 -> 88
    //
    // Exception table:
    //   from	to	target	type
    //   65	88	143	java/lang/Exception
    //   94	100	143	java/lang/Exception
    //   100	105	143	java/lang/Exception
    //   128	140	143	java/lang/Exception
    //   110	122	145	java/lang/Exception
    //   30	65	148	java/lang/Exception
    //   10	30	153	java/lang/Exception
  }

  private void jdMethod_if(int paramInt)
  {
    File localFile = new File(gy);
    if (!localFile.exists())
      bB();
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      localRandomAccessFile.seek(4L);
      int i = localRandomAccessFile.readInt();
      int j = localRandomAccessFile.readInt();
      localRandomAccessFile.seek(128 + i * gK);
      byte[] arrayOfByte = (c.bn + '\000').getBytes();
      localRandomAccessFile.writeInt(arrayOfByte.length);
      localRandomAccessFile.write(arrayOfByte, 0, arrayOfByte.length);
      localRandomAccessFile.writeInt(paramInt);
      if (j == gK)
      {
        localRandomAccessFile.seek(8L);
        localRandomAccessFile.writeInt(j + 1);
      }
      localRandomAccessFile.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void jdMethod_if(HttpEntity paramHttpEntity)
  {
    while (true)
    {
      try
      {
        byte[] arrayOfByte = EntityUtils.toByteArray(paramHttpEntity);
        i = 0;
        if (arrayOfByte != null)
          continue;
        if (i == 0)
          break;
        bF();
        return;
        if (arrayOfByte.length >= 640)
          continue;
        k.cM = false;
        k.b4 = 0.025D + k.cE;
        k.bG = k.cp - 0.025D;
        i = 1;
        continue;
        k.cM = true;
        k.bG = Double.longBitsToDouble((0xFF & arrayOfByte[7]) << 56 | (0xFF & arrayOfByte[6]) << 48 | (0xFF & arrayOfByte[5]) << 40 | (0xFF & arrayOfByte[4]) << 32 | (0xFF & arrayOfByte[3]) << 24 | (0xFF & arrayOfByte[2]) << 16 | (0xFF & arrayOfByte[1]) << 8 | 0xFF & arrayOfByte[0]);
        k.b4 = Double.longBitsToDouble((0xFF & arrayOfByte[15]) << 56 | (0xFF & arrayOfByte[14]) << 48 | (0xFF & arrayOfByte[13]) << 40 | (0xFF & arrayOfByte[12]) << 32 | (0xFF & arrayOfByte[11]) << 24 | (0xFF & arrayOfByte[10]) << 16 | (0xFF & arrayOfByte[9]) << 8 | 0xFF & arrayOfByte[8]);
        k.b2 = new byte[625];
        if (i < 625)
        {
          k.b2[i] = arrayOfByte[(i + 16)];
          i++;
          continue;
        }
      }
      catch (Exception localException)
      {
        return;
      }
      int i = 1;
    }
  }

  private boolean n(String paramString)
  {
    int i = 1;
    if (paramString != null);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      int j = Integer.parseInt(localJSONObject.getString("ver"));
      if (j > k.b0)
      {
        k.b0 = j;
        if (localJSONObject.has("gps"))
        {
          String[] arrayOfString7 = localJSONObject.getString("gps").split("\\|");
          if (arrayOfString7.length > 10)
          {
            if ((arrayOfString7[0] != null) && (!arrayOfString7[0].equals("")))
              k.cQ = Float.parseFloat(arrayOfString7[0]);
            if ((arrayOfString7[1] != null) && (!arrayOfString7[1].equals("")))
              k.bW = Float.parseFloat(arrayOfString7[1]);
            if ((arrayOfString7[2] != null) && (!arrayOfString7[2].equals("")))
              k.ck = Float.parseFloat(arrayOfString7[2]);
            if ((arrayOfString7[3] != null) && (!arrayOfString7[3].equals("")))
              k.cA = Float.parseFloat(arrayOfString7[3]);
            if ((arrayOfString7[4] != null) && (!arrayOfString7[4].equals("")))
              k.b7 = Integer.parseInt(arrayOfString7[4]);
            if ((arrayOfString7[5] != null) && (!arrayOfString7[5].equals("")))
              k.cq = Integer.parseInt(arrayOfString7[5]);
            if ((arrayOfString7[6] != null) && (!arrayOfString7[6].equals("")))
              k.cC = Integer.parseInt(arrayOfString7[6]);
            if ((arrayOfString7[7] != null) && (!arrayOfString7[7].equals("")))
              k.bJ = Integer.parseInt(arrayOfString7[7]);
            if ((arrayOfString7[8] != null) && (!arrayOfString7[8].equals("")))
              k.bH = Integer.parseInt(arrayOfString7[8]);
            if ((arrayOfString7[9] != null) && (!arrayOfString7[9].equals("")))
              k.cI = Integer.parseInt(arrayOfString7[9]);
            if ((arrayOfString7[10] != null) && (!arrayOfString7[10].equals("")))
              k.bQ = Integer.parseInt(arrayOfString7[10]);
          }
        }
        if (localJSONObject.has("up"))
        {
          String[] arrayOfString6 = localJSONObject.getString("up").split("\\|");
          if (arrayOfString6.length > 3)
          {
            if ((arrayOfString6[0] != null) && (!arrayOfString6[0].equals("")))
              k.ch = Float.parseFloat(arrayOfString6[0]);
            if ((arrayOfString6[1] != null) && (!arrayOfString6[1].equals("")))
              k.cg = Float.parseFloat(arrayOfString6[1]);
            if ((arrayOfString6[2] != null) && (!arrayOfString6[2].equals("")))
              k.cO = Float.parseFloat(arrayOfString6[2]);
            if ((arrayOfString6[3] != null) && (!arrayOfString6[3].equals("")))
              k.cx = Float.parseFloat(arrayOfString6[3]);
          }
        }
        if (localJSONObject.has("wf"))
        {
          String[] arrayOfString5 = localJSONObject.getString("wf").split("\\|");
          if (arrayOfString5.length > 3)
          {
            if ((arrayOfString5[0] != null) && (!arrayOfString5[0].equals("")))
              k.cD = Integer.parseInt(arrayOfString5[0]);
            if ((arrayOfString5[1] != null) && (!arrayOfString5[1].equals("")))
              k.bL = Float.parseFloat(arrayOfString5[1]);
            if ((arrayOfString5[2] != null) && (!arrayOfString5[2].equals("")))
              k.cy = Integer.parseInt(arrayOfString5[2]);
            if ((arrayOfString5[3] != null) && (!arrayOfString5[3].equals("")))
              k.bF = Float.parseFloat(arrayOfString5[3]);
          }
        }
        if (localJSONObject.has("ab"))
        {
          String[] arrayOfString4 = localJSONObject.getString("ab").split("\\|");
          if (arrayOfString4.length > 3)
          {
            if ((arrayOfString4[0] != null) && (!arrayOfString4[0].equals("")))
              k.cb = Float.parseFloat(arrayOfString4[0]);
            if ((arrayOfString4[1] != null) && (!arrayOfString4[1].equals("")))
              k.ca = Float.parseFloat(arrayOfString4[1]);
            if ((arrayOfString4[2] != null) && (!arrayOfString4[2].equals("")))
              k.b9 = Integer.parseInt(arrayOfString4[2]);
            if ((arrayOfString4[3] != null) && (!arrayOfString4[3].equals("")))
              k.b8 = Integer.parseInt(arrayOfString4[3]);
          }
        }
        if (localJSONObject.has("zxd"))
        {
          String[] arrayOfString3 = localJSONObject.getString("zxd").split("\\|");
          if (arrayOfString3.length > 4)
          {
            if ((arrayOfString3[0] != null) && (!arrayOfString3[0].equals("")))
              k.cd = Float.parseFloat(arrayOfString3[0]);
            if ((arrayOfString3[1] != null) && (!arrayOfString3[1].equals("")))
              k.cz = Float.parseFloat(arrayOfString3[1]);
            if ((arrayOfString3[2] != null) && (!arrayOfString3[2].equals("")))
              k.cc = Integer.parseInt(arrayOfString3[2]);
            if ((arrayOfString3[3] != null) && (!arrayOfString3[3].equals("")))
              k.cK = Integer.parseInt(arrayOfString3[3]);
            if ((arrayOfString3[4] != null) && (!arrayOfString3[4].equals("")))
              k.bO = Integer.parseInt(arrayOfString3[4]);
          }
        }
        String[] arrayOfString2;
        if (localJSONObject.has("gpc"))
        {
          arrayOfString2 = localJSONObject.getString("gpc").split("\\|");
          if (arrayOfString2.length > 5)
          {
            if ((arrayOfString2[0] != null) && (!arrayOfString2[0].equals("")))
            {
              if (Integer.parseInt(arrayOfString2[0]) <= 0)
                break label1453;
              k.bR = true;
            }
            if ((arrayOfString2[1] != null) && (!arrayOfString2[1].equals("")))
            {
              if (Integer.parseInt(arrayOfString2[1]) <= 0)
                break label1460;
              k.bK = true;
            }
            label1156: if ((arrayOfString2[2] != null) && (!arrayOfString2[2].equals("")))
              k.cB = Integer.parseInt(arrayOfString2[2]);
            if ((arrayOfString2[3] != null) && (!arrayOfString2[3].equals("")))
              k.cr = Integer.parseInt(arrayOfString2[3]);
            if ((arrayOfString2[4] != null) && (!arrayOfString2[4].equals("")))
            {
              int k = Integer.parseInt(arrayOfString2[4]);
              if (k <= 0)
                break label1467;
              k.cH = k;
              k.cs = 60L * (1000L * k.cH);
              k.cP = k.cs >> 2;
            }
          }
        }
        while (true)
        {
          if ((arrayOfString2[5] != null) && (!arrayOfString2[5].equals("")))
            k.cL = Integer.parseInt(arrayOfString2[5]);
          if (localJSONObject.has("shak"))
          {
            String[] arrayOfString1 = localJSONObject.getString("shak").split("\\|");
            if (arrayOfString1.length > 2)
            {
              if ((arrayOfString1[0] != null) && (!arrayOfString1[0].equals("")))
                k.bI = Integer.parseInt(arrayOfString1[0]);
              if ((arrayOfString1[1] != null) && (!arrayOfString1[1].equals("")))
                k.bM = Integer.parseInt(arrayOfString1[1]);
              if ((arrayOfString1[2] != null) && (!arrayOfString1[2].equals("")))
                k.cn = Float.parseFloat(arrayOfString1[2]);
            }
          }
          if (!localJSONObject.has("dmx"))
            break label1476;
          k.bT = localJSONObject.getInt("dmx");
          break label1476;
          label1453: k.bR = false;
          break;
          label1460: k.bK = false;
          break label1156;
          label1467: k.cl = false;
        }
      }
      i = 0;
      label1476: return i;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  public void bD()
  {
    if (System.currentTimeMillis() - n.jdMethod_if().jdMethod_for() > 86400000L)
    {
      n.jdMethod_if().a(System.currentTimeMillis());
      bE();
    }
    bC();
  }

  public void bG()
  {
  }

  public void m(String paramString)
  {
    if (this.gz == null)
      this.gz = new a();
    this.gz.jdMethod_if(paramString, true);
  }

  class a extends m
  {
    boolean eG = false;
    String eH = null;
    boolean eI = false;

    public a()
    {
      this.c7 = new ArrayList();
    }

    public void au()
    {
      this.c5 = k.Z();
      this.dg = 2;
      String str = Jni.H(this.eH);
      this.eH = null;
      if (this.eG)
        this.c7.add(new BasicNameValuePair("qt", "grid"));
      while (true)
      {
        this.c7.add(new BasicNameValuePair("req", str));
        return;
        this.c7.add(new BasicNameValuePair("qt", "conf"));
      }
    }

    public void jdMethod_if(String paramString, boolean paramBoolean)
    {
      if (this.eI)
        return;
      this.eI = true;
      this.eH = paramString;
      this.eG = paramBoolean;
      if (paramBoolean)
      {
        ap();
        return;
      }
      ao();
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null))
        if (this.eG)
          f.jdMethod_do(f.this, this.c6);
      while (true)
      {
        if (this.c7 != null)
          this.c7.clear();
        this.eI = false;
        return;
        f.jdMethod_if(f.this, this.c6);
        continue;
        f.jdMethod_if(f.this, null);
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.f
 * JD-Core Version:    0.6.0
 */