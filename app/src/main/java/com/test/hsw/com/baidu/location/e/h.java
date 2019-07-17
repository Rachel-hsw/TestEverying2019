package com.baidu.location.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Environment;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.b.m;
import com.baidu.location.h.j;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  implements com.baidu.location.b.f
{
  private static final String g3 = "1";
  private static final String g7 = "%d_%02d_%02d";
  private static final long gN = 86400000L;
  private static final String gX = "utf-8";
  private static final int gZ = 400;
  private static final String hi = "http://loc.map.baidu.com/cc.php";
  private static final String hj = "0";
  private static final int hs = 10000;
  private static h ht = null;
  public static String hv = "0";
  private a g0 = null;
  private int g1 = 1;
  private long g2 = 0L;
  private int g4 = 0;
  private int g5 = 1;
  private int g6 = 307200;
  StringBuilder g8 = null;
  private float g9 = 0.0F;
  private Handler gL = null;
  private int gM = 15;
  private String gO = "3G|4G";
  private double gP = 3.5D;
  private float gQ = 0.0F;
  private int gR = 60;
  private boolean gS = false;
  private double gT = 0.699999988079071D;
  private int gU = 500;
  private int gV = 0;
  private boolean gW = false;
  private byte[] gY = null;
  private double ha = 3.0D;
  Location hb = null;
  long hc = 0L;
  private int hd = 0;
  private double he = 0.5D;
  private List hf = null;
  long hg = 0L;
  double hh = 116.22345545D;
  private boolean hk = false;
  private int hl = 0;
  private int hm = 60;
  private int hn = 1;
  private long ho = 0L;
  double hp = 40.245667322999999D;
  int hq = 0;
  private byte[] hr = new byte[4];
  Location hu = null;
  private int hw = 300;

  public static h bI()
  {
    if (ht == null)
      ht = new h();
    return ht;
  }

  private void bL()
  {
    this.hf = null;
    this.hc = 0L;
    this.hl = 0;
    this.hb = null;
    this.hu = null;
    this.g9 = 0.0F;
    this.gQ = 0.0F;
  }

  private void bM()
  {
  }

  private void bN()
  {
    int i = 0;
    this.hf.add(Byte.valueOf(0));
    this.hf.add(Byte.valueOf(0));
    if (hv.equals("0"))
      this.hf.add(Byte.valueOf(110));
    while (true)
    {
      this.hf.add(Byte.valueOf(0));
      this.hf.add(Byte.valueOf(this.hr[0]));
      this.hf.add(Byte.valueOf(this.hr[1]));
      this.hf.add(Byte.valueOf(this.hr[2]));
      this.hf.add(Byte.valueOf(this.hr[3]));
      int j = this.gY.length;
      this.hf.add(Byte.valueOf((byte)(0xFF & j + 1)));
      while (i < j)
      {
        this.hf.add(Byte.valueOf(this.gY[i]));
        i++;
      }
      this.hf.add(Byte.valueOf(126));
    }
  }

  private void bO()
  {
    String str = null;
    if (0 == 0)
      str = "6.1.3";
    String[] arrayOfString = str.split("\\.");
    int i = arrayOfString.length;
    this.hr[0] = 0;
    this.hr[1] = 0;
    this.hr[2] = 0;
    this.hr[3] = 0;
    if (i >= 4)
      i = 4;
    int j = 0;
    while (true)
      if (j < i)
        try
        {
          this.hr[j] = (byte)(0xFF & Integer.valueOf(arrayOfString[j]).intValue());
          j++;
        }
        catch (Exception localException)
        {
        }
    this.gY = q(com.baidu.location.b.c.bn + ":" + com.baidu.location.b.c.N().bm);
  }

  private void bP()
  {
    if (this.hk)
      return;
    this.hk = true;
    r(com.baidu.location.b.c.bn);
    bS();
    bO();
  }

  private boolean bQ()
  {
    if (this.gS)
      if (this.gW)
        if (this.g9 < this.he)
        {
          this.g4 += this.gM;
          if ((this.g4 > this.hw) && (System.currentTimeMillis() - this.g2 <= 1000 * this.gR))
            break label186;
        }
    do
    {
      do
      {
        return true;
        this.g4 = 0;
        this.gW = false;
        return true;
      }
      while (this.g9 >= this.he);
      this.gW = true;
      this.g4 = 0;
      this.g4 += this.gM;
      return true;
      if ((this.g9 < this.gP) && (this.gQ < this.ha))
        continue;
      this.gS = true;
      return true;
    }
    while ((this.gV == 1) && (System.currentTimeMillis() - this.g2 > 1000 * this.hm));
    label186: return false;
  }

  private void bR()
  {
    if ((this.hc == 0L) || (System.currentTimeMillis() - this.hc < 1000 * this.gM));
    do
    {
      return;
      if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false))
      {
        bL();
        return;
      }
      if ((this.g5 == 1) && (!bQ()))
      {
        bL();
        return;
      }
      if (jdMethod_if(com.baidu.location.b.c.bn, com.baidu.location.f.getServiceContext()))
        continue;
      bL();
      return;
    }
    while (this.hf == null);
    int i = this.hf.size();
    this.hf.set(0, Byte.valueOf((byte)(i & 0xFF)));
    this.hf.set(1, Byte.valueOf((byte)((0xFF00 & i) >> 8)));
    this.hf.set(3, Byte.valueOf((byte)(0xFF & this.hl)));
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++)
      arrayOfByte[j] = ((Byte)this.hf.get(j)).byteValue();
    File localFile2;
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      File localFile1 = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
      if (!localFile1.exists())
        localFile1.mkdirs();
      if (localFile1.exists())
      {
        localFile2 = new File(localFile1, "intime.dat");
        if (localFile2.exists())
          localFile2.delete();
      }
    }
    try
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(localFile2));
      localBufferedOutputStream.write(arrayOfByte);
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      new h.2(this).start();
      label344: bL();
      this.g2 = System.currentTimeMillis();
      return;
    }
    catch (Exception localException)
    {
      break label344;
    }
  }

  private void bS()
  {
    if (System.currentTimeMillis() - this.ho > 86400000L)
    {
      if (this.g0 == null)
        this.g0 = new a();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(com.baidu.location.b.c.N().jdMethod_do(false));
      localStringBuffer.append(c.bp().bs());
      this.g0.jdMethod_void(localStringBuffer.toString());
    }
    bM();
  }

  private void jdMethod_do(Location paramLocation)
  {
    jdMethod_new(paramLocation);
    bR();
  }

  private byte[] jdMethod_for(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    arrayOfByte[0] = (byte)(paramInt & 0xFF);
    arrayOfByte[1] = (byte)((0xFF00 & paramInt) >> 8);
    arrayOfByte[2] = (byte)((0xFF0000 & paramInt) >> 16);
    arrayOfByte[3] = (byte)((0xFF000000 & paramInt) >> 24);
    return arrayOfByte;
  }

  private String jdMethod_if(File paramFile, String paramString)
  {
    String str = UUID.randomUUID().toString();
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Charset", "utf-8");
      localHttpURLConnection.setRequestProperty("connection", "keep-alive");
      localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data" + ";boundary=" + str);
      if ((paramFile != null) && (paramFile.exists()))
      {
        localOutputStream = localHttpURLConnection.getOutputStream();
        localDataOutputStream = new DataOutputStream(localOutputStream);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("--");
        localStringBuffer.append(str);
        localStringBuffer.append("\r\n");
        localStringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + paramFile.getName() + "\"" + "\r\n");
        localStringBuffer.append("Content-Type: application/octet-stream; charset=utf-8" + "\r\n");
        localStringBuffer.append("\r\n");
        localDataOutputStream.write(localStringBuffer.toString().getBytes());
        localFileInputStream = new FileInputStream(paramFile);
        byte[] arrayOfByte = new byte[1024];
        while (true)
        {
          int i = localFileInputStream.read(arrayOfByte);
          if (i == -1)
            break;
          localDataOutputStream.write(arrayOfByte, 0, i);
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      int j;
      do
      {
        HttpURLConnection localHttpURLConnection;
        OutputStream localOutputStream;
        DataOutputStream localDataOutputStream;
        FileInputStream localFileInputStream;
        return "0";
        localFileInputStream.close();
        localDataOutputStream.write("\r\n".getBytes());
        localDataOutputStream.write(("--" + str + "--" + "\r\n").getBytes());
        localDataOutputStream.flush();
        j = localHttpURLConnection.getResponseCode();
        localOutputStream.close();
        this.hd = (400 + this.hd);
        jdMethod_new(this.hd);
      }
      while (j != 200);
      return "1";
    }
    catch (IOException localIOException)
    {
      label321: break label321;
    }
  }

  private void jdMethod_if(Location paramLocation)
  {
    this.hc = System.currentTimeMillis();
    jdMethod_int((int)(this.hc / 1000L));
    jdMethod_int((int)(1000000.0D * paramLocation.getLongitude()));
    jdMethod_int((int)(1000000.0D * paramLocation.getLatitude()));
    int i;
    int j;
    if (paramLocation.hasBearing())
    {
      i = 0;
      boolean bool = paramLocation.hasSpeed();
      j = 0;
      if (!bool)
        break label117;
      label67: if (i <= 0)
        break label123;
      this.hf.add(Byte.valueOf(32));
      label86: if (j <= 0)
        break label161;
      this.hf.add(Byte.valueOf(-128));
    }
    while (true)
    {
      this.hb = paramLocation;
      return;
      i = 1;
      break;
      label117: j = 1;
      break label67;
      label123: byte b1 = (byte)(0xFFFFFFDF & (byte)(0xFF & (int)(paramLocation.getBearing() / 15.0F)));
      this.hf.add(Byte.valueOf(b1));
      break label86;
      label161: byte b2 = (byte)(0x7F & (byte)(0xFF & (int)(3.6D * paramLocation.getSpeed() / 4.0D)));
      this.hf.add(Byte.valueOf(b2));
    }
  }

  private boolean jdMethod_if(String paramString, Context paramContext)
  {
    int i = 0;
    while (true)
    {
      try
      {
        List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        i = 0;
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            if (!localRunningAppProcessInfo.processName.equals(paramString))
              break label102;
            int k = localRunningAppProcessInfo.importance;
            if ((k != 200) && (k != 100))
              break label102;
            j = 1;
            i = j;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
      }
      return i;
      label102: int j = i;
    }
  }

  private void jdMethod_int(int paramInt)
  {
    byte[] arrayOfByte = jdMethod_for(paramInt);
    for (int i = 0; i < 4; i++)
      this.hf.add(Byte.valueOf(arrayOfByte[i]));
  }

  private void jdMethod_int(Location paramLocation)
  {
    int i = (int)(100000.0D * (paramLocation.getLongitude() - this.hb.getLongitude()));
    int j = (int)(100000.0D * (paramLocation.getLatitude() - this.hb.getLatitude()));
    int k;
    int m;
    label56: int n;
    label63: int i2;
    if (paramLocation.hasBearing())
    {
      k = 0;
      if (!paramLocation.hasSpeed())
        break label376;
      m = 0;
      if (i <= 0)
        break label382;
      n = 0;
      int i1 = Math.abs(i);
      if (j <= 0)
        break label388;
      i2 = 0;
      label76: int i3 = Math.abs(j);
      if (this.hl > 1)
      {
        this.hu = null;
        this.hu = this.hb;
      }
      this.hb = paramLocation;
      if ((this.hb != null) && (this.hu != null) && (this.hb.getTime() > this.hu.getTime()) && (this.hb.getTime() - this.hu.getTime() < 5000L))
      {
        long l = this.hb.getTime() - this.hu.getTime();
        float[] arrayOfFloat = new float[2];
        Location.distanceBetween(this.hb.getAltitude(), this.hb.getLongitude(), this.hu.getLatitude(), this.hu.getLongitude(), arrayOfFloat);
        double d = 2.0F * (arrayOfFloat[0] - this.hu.getSpeed() * (float)l) / (float)(l * l);
        if (d > this.gQ)
          this.gQ = (float)d;
      }
      this.hf.add(Byte.valueOf((byte)(i1 & 0xFF)));
      this.hf.add(Byte.valueOf((byte)(i3 & 0xFF)));
      if (k <= 0)
        break label394;
      byte b3 = 32;
      if (i2 > 0)
        b3 = 96;
      if (n > 0)
        b3 = (byte)(b3 | 0xFFFFFF80);
      this.hf.add(Byte.valueOf(b3));
    }
    while (true)
    {
      if (m <= 0)
        break label458;
      this.hf.add(Byte.valueOf(-128));
      return;
      k = 1;
      break;
      label376: m = 1;
      break label56;
      label382: n = 1;
      break label63;
      label388: i2 = 1;
      break label76;
      label394: byte b1 = (byte)(0x1F & (byte)(0xFF & (int)(paramLocation.getBearing() / 15.0F)));
      if (i2 > 0)
        b1 = (byte)(b1 | 0x40);
      if (n > 0)
        b1 = (byte)(b1 | 0xFFFFFF80);
      this.hf.add(Byte.valueOf(b1));
    }
    label458: byte b2 = (byte)(0x7F & (byte)(0xFF & (int)(3.6D * paramLocation.getSpeed() / 4.0D)));
    this.hf.add(Byte.valueOf(b2));
  }

  private void jdMethod_new(int paramInt)
  {
    if (paramInt == 0);
    while (true)
    {
      return;
      String str = com.baidu.location.b.e.int + "/grtcf.dat";
      try
      {
        File localFile1 = new File(str);
        if (!localFile1.exists())
        {
          File localFile2 = new File(com.baidu.location.b.e.int);
          if (!localFile2.exists())
            localFile2.mkdirs();
          if (!localFile1.createNewFile())
            continue;
          RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile1, "rw");
          localRandomAccessFile1.seek(2L);
          localRandomAccessFile1.writeInt(0);
          localRandomAccessFile1.seek(8L);
          byte[] arrayOfByte1 = "1980_01_01:0".getBytes();
          localRandomAccessFile1.writeInt(arrayOfByte1.length);
          localRandomAccessFile1.write(arrayOfByte1);
          localRandomAccessFile1.seek(200L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.seek(800L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.close();
        }
        RandomAccessFile localRandomAccessFile2 = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile2.seek(8L);
        byte[] arrayOfByte2 = (o("%d_%02d_%02d") + ":" + paramInt).getBytes();
        localRandomAccessFile2.writeInt(arrayOfByte2.length);
        localRandomAccessFile2.write(arrayOfByte2);
        localRandomAccessFile2.close();
        return;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private void jdMethod_new(Location paramLocation)
  {
    if ((System.currentTimeMillis() - this.hg < this.gU) || (paramLocation == null))
      return;
    if ((paramLocation != null) && (paramLocation.hasSpeed()) && (paramLocation.getSpeed() > this.g9))
      this.g9 = paramLocation.getSpeed();
    try
    {
      if (this.hf == null)
      {
        this.hf = new ArrayList();
        bN();
        jdMethod_if(paramLocation);
      }
      while (true)
      {
        label80: this.hl = (1 + this.hl);
        return;
        jdMethod_int(paramLocation);
      }
    }
    catch (Exception localException)
    {
      break label80;
    }
  }

  private String o(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(localCalendar.get(1));
    arrayOfObject[1] = Integer.valueOf(1 + localCalendar.get(2));
    arrayOfObject[2] = Integer.valueOf(localCalendar.get(5));
    return String.format(paramString, arrayOfObject);
  }

  private void p(String paramString)
  {
    if (paramString != null);
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (localJSONObject.has("on"))
        this.g1 = localJSONObject.getInt("on");
      if (localJSONObject.has("bash"))
        this.gT = localJSONObject.getDouble("bash");
      if (localJSONObject.has("net"))
        this.gO = localJSONObject.getString("net");
      if (localJSONObject.has("tcon"))
        this.g5 = localJSONObject.getInt("tcon");
      if (localJSONObject.has("tcsh"))
        this.g6 = localJSONObject.getInt("tcsh");
      if (localJSONObject.has("per"))
        this.gM = localJSONObject.getInt("per");
      if (localJSONObject.has("chdron"))
        this.hn = localJSONObject.getInt("chdron");
      if (localJSONObject.has("spsh"))
        this.gP = localJSONObject.getDouble("spsh");
      if (localJSONObject.has("acsh"))
        this.ha = localJSONObject.getDouble("acsh");
      if (localJSONObject.has("stspsh"))
        this.he = localJSONObject.getDouble("stspsh");
      if (localJSONObject.has("drstsh"))
        this.hw = localJSONObject.getInt("drstsh");
      if (localJSONObject.has("stper"))
        this.gR = localJSONObject.getInt("stper");
      if (localJSONObject.has("nondron"))
        this.gV = localJSONObject.getInt("nondron");
      if (localJSONObject.has("nondrper"))
        this.hm = localJSONObject.getInt("nondrper");
      if (localJSONObject.has("uptime"))
        this.ho = localJSONObject.getLong("uptime");
      bM();
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  private byte[] q(String paramString)
  {
    int i = 0;
    if (paramString == null)
      return null;
    byte[] arrayOfByte1 = paramString.getBytes();
    int j = (byte)new Random().nextInt(255);
    int k = (byte)new Random().nextInt(255);
    byte[] arrayOfByte2 = new byte[2 + arrayOfByte1.length];
    int m = arrayOfByte1.length;
    int i3;
    for (int n = 0; i < m; n = i3)
    {
      int i2 = arrayOfByte1[i];
      i3 = n + 1;
      arrayOfByte2[n] = (byte)(i2 ^ j);
      i++;
    }
    int i1 = n + 1;
    arrayOfByte2[n] = j;
    (i1 + 1);
    arrayOfByte2[i1] = k;
    return arrayOfByte2;
  }

  // ERROR //
  private void r(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 229	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 230	java/lang/StringBuilder:<init>	()V
    //   9: getstatic 627	com/baidu/location/b/e:int	Ljava/lang/String;
    //   12: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc_w 629
    //   18: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_3
    //   25: new 330	java/io/File
    //   28: dup
    //   29: aload_3
    //   30: invokespecial 630	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: invokevirtual 342	java/io/File:exists	()Z
    //   40: ifeq +213 -> 253
    //   43: new 635	java/io/RandomAccessFile
    //   46: dup
    //   47: aload 4
    //   49: ldc_w 637
    //   52: invokespecial 638	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 6
    //   57: aload 6
    //   59: ldc2_w 639
    //   62: invokevirtual 644	java/io/RandomAccessFile:seek	(J)V
    //   65: aload 6
    //   67: invokevirtual 755	java/io/RandomAccessFile:readInt	()I
    //   70: istore 7
    //   72: aload 6
    //   74: ldc2_w 648
    //   77: invokevirtual 644	java/io/RandomAccessFile:seek	(J)V
    //   80: aload 6
    //   82: invokevirtual 755	java/io/RandomAccessFile:readInt	()I
    //   85: istore 8
    //   87: iload 8
    //   89: newarray byte
    //   91: astore 9
    //   93: aload 6
    //   95: aload 9
    //   97: iconst_0
    //   98: iload 8
    //   100: invokevirtual 758	java/io/RandomAccessFile:read	([BII)I
    //   103: pop
    //   104: new 204	java/lang/String
    //   107: dup
    //   108: aload 9
    //   110: invokespecial 760	java/lang/String:<init>	([B)V
    //   113: astore 11
    //   115: aload 11
    //   117: aload_0
    //   118: ldc 13
    //   120: invokespecial 664	com/baidu/location/e/h:o	(Ljava/lang/String;)Ljava/lang/String;
    //   123: invokevirtual 764	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   126: ifeq +47 -> 173
    //   129: aload 11
    //   131: ldc 241
    //   133: invokevirtual 764	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   136: istore 18
    //   138: iload 18
    //   140: ifeq +33 -> 173
    //   143: aload 11
    //   145: ldc 241
    //   147: invokevirtual 218	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   150: astore 20
    //   152: aload 20
    //   154: arraylength
    //   155: iload_2
    //   156: if_icmple +17 -> 173
    //   159: aload_0
    //   160: aload 20
    //   162: iconst_1
    //   163: aaload
    //   164: invokestatic 223	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   167: invokevirtual 227	java/lang/Integer:intValue	()I
    //   170: putfield 131	com/baidu/location/e/h:hd	I
    //   173: iload_2
    //   174: iload 7
    //   176: if_icmpgt +72 -> 248
    //   179: iload_2
    //   180: sipush 2048
    //   183: imul
    //   184: i2l
    //   185: lstore 12
    //   187: aload 6
    //   189: lload 12
    //   191: invokevirtual 644	java/io/RandomAccessFile:seek	(J)V
    //   194: aload 6
    //   196: invokevirtual 755	java/io/RandomAccessFile:readInt	()I
    //   199: istore 14
    //   201: iload 14
    //   203: newarray byte
    //   205: astore 15
    //   207: aload 6
    //   209: aload 15
    //   211: iconst_0
    //   212: iload 14
    //   214: invokevirtual 758	java/io/RandomAccessFile:read	([BII)I
    //   217: pop
    //   218: new 204	java/lang/String
    //   221: dup
    //   222: aload 15
    //   224: invokespecial 760	java/lang/String:<init>	([B)V
    //   227: astore 17
    //   229: aload_1
    //   230: ifnull +24 -> 254
    //   233: aload 17
    //   235: aload_1
    //   236: invokevirtual 764	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   239: ifeq +15 -> 254
    //   242: aload_0
    //   243: aload 17
    //   245: invokespecial 766	com/baidu/location/e/h:p	(Ljava/lang/String;)V
    //   248: aload 6
    //   250: invokevirtual 660	java/io/RandomAccessFile:close	()V
    //   253: return
    //   254: iinc 2 1
    //   257: goto -84 -> 173
    //   260: astore 5
    //   262: return
    //   263: astore 19
    //   265: goto -92 -> 173
    //
    // Exception table:
    //   from	to	target	type
    //   25	138	260	java/lang/Exception
    //   187	229	260	java/lang/Exception
    //   233	248	260	java/lang/Exception
    //   248	253	260	java/lang/Exception
    //   143	173	263	java/lang/Exception
  }

  private void s(String paramString)
  {
    String str = com.baidu.location.b.e.int + "/grtcf.dat";
    try
    {
      File localFile1 = new File(str);
      RandomAccessFile localRandomAccessFile2;
      int i;
      if (!localFile1.exists())
      {
        File localFile2 = new File(com.baidu.location.b.e.int);
        if (!localFile2.exists())
          localFile2.mkdirs();
        if (localFile1.createNewFile())
        {
          RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(localFile1, "rw");
          localRandomAccessFile1.seek(2L);
          localRandomAccessFile1.writeInt(0);
          localRandomAccessFile1.seek(8L);
          byte[] arrayOfByte1 = "1980_01_01:0".getBytes();
          localRandomAccessFile1.writeInt(arrayOfByte1.length);
          localRandomAccessFile1.write(arrayOfByte1);
          localRandomAccessFile1.seek(200L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.seek(800L);
          localRandomAccessFile1.writeBoolean(false);
          localRandomAccessFile1.close();
        }
      }
      else
      {
        localRandomAccessFile2 = new RandomAccessFile(localFile1, "rw");
        localRandomAccessFile2.seek(2L);
        i = localRandomAccessFile2.readInt();
      }
      for (int j = 1; ; j++)
      {
        if (j <= i)
        {
          localRandomAccessFile2.seek(j * 2048);
          int k = localRandomAccessFile2.readInt();
          byte[] arrayOfByte2 = new byte[k];
          localRandomAccessFile2.read(arrayOfByte2, 0, k);
          if (!new String(arrayOfByte2).contains(com.baidu.location.b.c.bn))
            continue;
        }
        if (j >= i)
        {
          localRandomAccessFile2.seek(2L);
          localRandomAccessFile2.writeInt(j);
        }
        localRandomAccessFile2.seek(j * 2048);
        byte[] arrayOfByte3 = paramString.getBytes();
        localRandomAccessFile2.writeInt(arrayOfByte3.length);
        localRandomAccessFile2.write(arrayOfByte3);
        localRandomAccessFile2.close();
        return;
      }
    }
    catch (Exception localException)
    {
    }
  }

  public void bJ()
  {
    if (!this.hk)
      return;
    this.hk = false;
    bL();
  }

  public void bK()
  {
    this.gL.postDelayed(new h.3(this), 2000L);
  }

  public void jdMethod_for(Location paramLocation)
  {
    if (!this.hk)
      bP();
    if ((this.g1 != 1) || (e.bv().bw() >= 100.0D * this.gT) || (!this.gO.contains(com.baidu.location.h.c.a(com.baidu.location.h.c.a().cP()))) || ((this.g5 == 1) && (this.hd > this.g6)))
      return;
    this.gL.post(new h.1(this, paramLocation));
  }

  class a extends m
  {
    String eK = null;

    public a()
    {
      this.c7 = new ArrayList();
    }

    public void au()
    {
      this.c5 = "http://loc.map.baidu.com/cc.php";
      String str = Jni.H(this.eK);
      this.eK = null;
      this.c7.add(new BasicNameValuePair("q", str));
    }

    public void jdMethod_int(boolean paramBoolean)
    {
      if ((paramBoolean) && (this.c6 != null));
      try
      {
        JSONObject localJSONObject = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
        localJSONObject.put("prod", com.baidu.location.b.c.bn);
        localJSONObject.put("uptime", System.currentTimeMillis());
        h.jdMethod_if(h.this, localJSONObject.toString());
        label59: if (this.c7 != null)
          this.c7.clear();
        return;
      }
      catch (Exception localException)
      {
        break label59;
      }
    }

    public void jdMethod_void(String paramString)
    {
      this.eK = paramString;
      ao();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.e.h
 * JD-Core Version:    0.6.0
 */