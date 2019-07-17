package com.baidu.location.h;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.b.k;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class b extends j
  implements com.baidu.location.b.f
{
  public static final long j0 = 3000L;
  private static Method j1;
  private static Class j2;
  public static final int j3 = 3;
  private static Method j6;
  private static b j7 = null;
  private static Method j8;
  private static Method jS;
  private static Method jT;
  public static int jW;
  public static int jY;
  private List j4 = null;
  private a j5 = null;
  private TelephonyManager jR = null;
  private h jU = null;
  private boolean jV = false;
  private h jX = new h();
  private boolean jZ = false;

  static
  {
    j6 = null;
    jT = null;
    j1 = null;
    jS = null;
    j8 = null;
    j2 = null;
    jY = 0;
    jW = 0;
  }

  private String jdMethod_byte(h paramh)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17);
    try
    {
      List localList = this.jR.getAllCellInfo();
      if ((localList != null) && (localList.size() > 0))
      {
        localStringBuilder.append("&nc=");
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          CellInfo localCellInfo = (CellInfo)localIterator.next();
          if (localCellInfo.isRegistered())
            continue;
          localh = jdMethod_if(localCellInfo);
          if ((localh == null) || (localh.ku == -1) || (localh.ky == -1))
            continue;
          if (paramh.ku == localh.ku)
            break label199;
          localStringBuilder.append(localh.ku + "|" + localh.ky + "|" + localh.kz + ";");
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        h localh;
        return localStringBuilder.toString();
        localStringBuilder.append("|" + localh.ky + "|" + localh.kz + ";");
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label194: label199: break label194;
    }
  }

  private void cS()
  {
    String str = k.ah();
    if (str == null);
    File localFile;
    do
    {
      return;
      localFile = new File(str + File.separator + "lcvif.dat");
    }
    while (!localFile.exists());
    RandomAccessFile localRandomAccessFile;
    try
    {
      localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      localRandomAccessFile.seek(0L);
      long l1 = localRandomAccessFile.readLong();
      if (System.currentTimeMillis() - l1 > 60000L)
      {
        localRandomAccessFile.close();
        localFile.delete();
        return;
      }
    }
    catch (Exception localException)
    {
      localFile.delete();
      return;
    }
    localRandomAccessFile.readInt();
    for (int i = 0; ; i++)
    {
      long l2;
      int j;
      int k;
      int m;
      int n;
      int i1;
      char c;
      if (i < 3)
      {
        l2 = localRandomAccessFile.readLong();
        j = localRandomAccessFile.readInt();
        k = localRandomAccessFile.readInt();
        m = localRandomAccessFile.readInt();
        n = localRandomAccessFile.readInt();
        i1 = localRandomAccessFile.readInt();
        c = '\000';
        if (i1 != 1)
          break label228;
        c = 'g';
      }
      label228: 
      do
      {
        h localh = new h(m, n, j, k, 0, c);
        localh.kw = l2;
        if (!localh.ds())
          break;
        this.jZ = true;
        this.j4.add(localh);
        break;
        localRandomAccessFile.close();
        return;
        if (i1 != 2)
          continue;
        c = 'c';
      }
      while (l2 != 0L);
    }
  }

  private void cT()
  {
    h localh = cX();
    if (localh != null)
      jdMethod_try(localh);
    if ((localh == null) || (!localh.ds()))
      jdMethod_do(this.jR.getCellLocation());
  }

  public static b cU()
  {
    if (j7 == null)
      j7 = new b();
    return j7;
  }

  private void cW()
  {
    if ((this.j4 == null) && (this.jU == null));
    String str;
    do
    {
      return;
      if ((this.j4 == null) && (this.jU != null))
      {
        this.j4 = new LinkedList();
        this.j4.add(this.jU);
      }
      str = k.ah();
    }
    while (str == null);
    File localFile = new File(str + File.separator + "lcvif.dat");
    int i = this.j4.size();
    try
    {
      if (localFile.exists())
        localFile.delete();
      localFile.createNewFile();
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(localFile, "rw");
      localRandomAccessFile.seek(0L);
      localRandomAccessFile.writeLong(((h)this.j4.get(i - 1)).kw);
      localRandomAccessFile.writeInt(i);
      int m;
      for (int j = 0; ; j++)
      {
        int k = 3 - i;
        m = 0;
        if (j >= k)
          break;
        localRandomAccessFile.writeLong(0L);
        localRandomAccessFile.writeInt(-1);
        localRandomAccessFile.writeInt(-1);
        localRandomAccessFile.writeInt(-1);
        localRandomAccessFile.writeInt(-1);
        localRandomAccessFile.writeInt(2);
      }
      while (true)
      {
        if (m < i)
        {
          localRandomAccessFile.writeLong(((h)this.j4.get(m)).kw);
          localRandomAccessFile.writeInt(((h)this.j4.get(m)).kB);
          localRandomAccessFile.writeInt(((h)this.j4.get(m)).kC);
          localRandomAccessFile.writeInt(((h)this.j4.get(m)).ku);
          localRandomAccessFile.writeInt(((h)this.j4.get(m)).ky);
          if (((h)this.j4.get(m)).kA == 'g')
            localRandomAccessFile.writeInt(1);
          else if (((h)this.j4.get(m)).kA == 'c')
            localRandomAccessFile.writeInt(2);
          else
            localRandomAccessFile.writeInt(3);
        }
        else
        {
          localRandomAccessFile.close();
          return;
        }
        m++;
      }
    }
    catch (Exception localException)
    {
    }
  }

  // ERROR //
  private h cX()
  {
    // Byte code:
    //   0: getstatic 91	android/os/Build$VERSION:SDK_INT	I
    //   3: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6: invokevirtual 101	java/lang/Integer:intValue	()I
    //   9: bipush 17
    //   11: if_icmpge +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: getfield 62	com/baidu/location/h/b:jR	Landroid/telephony/TelephonyManager;
    //   20: invokevirtual 107	android/telephony/TelephonyManager:getAllCellInfo	()Ljava/util/List;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull -11 -> 14
    //   28: aload_3
    //   29: invokeinterface 112 1 0
    //   34: ifle -20 -> 14
    //   37: aload_3
    //   38: invokeinterface 122 1 0
    //   43: astore 4
    //   45: aconst_null
    //   46: astore 5
    //   48: aload 4
    //   50: invokeinterface 128 1 0
    //   55: ifeq +85 -> 140
    //   58: aload 4
    //   60: invokeinterface 132 1 0
    //   65: checkcast 134	android/telephony/CellInfo
    //   68: astore 7
    //   70: aload 7
    //   72: invokevirtual 137	android/telephony/CellInfo:isRegistered	()Z
    //   75: ifeq -27 -> 48
    //   78: aload_0
    //   79: aload 7
    //   81: invokespecial 141	com/baidu/location/h/b:if	(Landroid/telephony/CellInfo;)Lcom/baidu/location/h/h;
    //   84: astore 8
    //   86: aload 8
    //   88: astore 9
    //   90: aload 9
    //   92: ifnonnull +10 -> 102
    //   95: aload 9
    //   97: astore 5
    //   99: goto -51 -> 48
    //   102: aload 9
    //   104: invokevirtual 221	com/baidu/location/h/h:ds	()Z
    //   107: ifne +9 -> 116
    //   110: aconst_null
    //   111: astore 9
    //   113: goto +30 -> 143
    //   116: aload 9
    //   118: invokevirtual 276	com/baidu/location/h/h:dr	()V
    //   121: goto +22 -> 143
    //   124: astore 10
    //   126: aload 9
    //   128: areturn
    //   129: astore_2
    //   130: aconst_null
    //   131: areturn
    //   132: astore_1
    //   133: aconst_null
    //   134: areturn
    //   135: astore 6
    //   137: aload 5
    //   139: areturn
    //   140: aload 5
    //   142: areturn
    //   143: aload 9
    //   145: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   102	110	124	java/lang/Exception
    //   116	121	124	java/lang/Exception
    //   16	24	129	java/lang/NoSuchMethodError
    //   28	45	129	java/lang/NoSuchMethodError
    //   48	86	129	java/lang/NoSuchMethodError
    //   102	110	129	java/lang/NoSuchMethodError
    //   116	121	129	java/lang/NoSuchMethodError
    //   16	24	132	java/lang/Exception
    //   28	45	132	java/lang/Exception
    //   48	86	135	java/lang/Exception
  }

  private h jdMethod_do(CellLocation paramCellLocation)
  {
    if ((paramCellLocation == null) || (this.jR == null))
      return null;
    h localh = new h();
    localh.kw = System.currentTimeMillis();
    try
    {
      String str1 = this.jR.getNetworkOperator();
      String str2;
      int j;
      char[] arrayOfChar;
      if ((str1 != null) && (str1.length() > 0))
      {
        if (str1.length() >= 3)
        {
          int m = Integer.valueOf(str1.substring(0, 3)).intValue();
          if (m < 0)
            m = this.jX.kB;
          localh.kB = m;
        }
        str2 = str1.substring(3);
        j = 0;
        if (str2 != null)
          arrayOfChar = str2.toCharArray();
      }
      while (true)
      {
        if ((j >= arrayOfChar.length) || (!Character.isDigit(arrayOfChar[j])))
        {
          int k = Integer.valueOf(str2.substring(0, j)).intValue();
          if (k < 0)
            k = this.jX.kC;
          localh.kC = k;
          jY = this.jR.getSimState();
          if (!(paramCellLocation instanceof GsmCellLocation))
            break;
          localh.ku = ((GsmCellLocation)paramCellLocation).getLac();
          localh.ky = ((GsmCellLocation)paramCellLocation).getCid();
          localh.kA = 'g';
          jdMethod_try(localh);
          return localh;
        }
        j++;
      }
    }
    catch (Exception localException1)
    {
      while (true)
      {
        jW = 1;
        continue;
        if (!(paramCellLocation instanceof CdmaCellLocation))
          continue;
        localh.kA = 'c';
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 5)
          return localh;
        if (j2 == null);
        try
        {
          j2 = Class.forName("android.telephony.cdma.CdmaCellLocation");
          j6 = j2.getMethod("getBaseStationId", new Class[0]);
          jT = j2.getMethod("getNetworkId", new Class[0]);
          j1 = j2.getMethod("getSystemId", new Class[0]);
          jS = j2.getMethod("getBaseStationLatitude", new Class[0]);
          j8 = j2.getMethod("getBaseStationLongitude", new Class[0]);
          if ((j2 == null) || (!j2.isInstance(paramCellLocation)))
            continue;
          try
          {
            int i = ((Integer)j1.invoke(paramCellLocation, new Object[0])).intValue();
            if (i < 0)
              i = this.jX.kC;
            localh.kC = i;
            localh.ky = ((Integer)j6.invoke(paramCellLocation, new Object[0])).intValue();
            localh.ku = ((Integer)jT.invoke(paramCellLocation, new Object[0])).intValue();
            Object localObject1 = jS.invoke(paramCellLocation, new Object[0]);
            if (((Integer)localObject1).intValue() < 2147483647)
              localh.kD = ((Integer)localObject1).intValue();
            Object localObject2 = j8.invoke(paramCellLocation, new Object[0]);
            if (((Integer)localObject2).intValue() >= 2147483647)
              continue;
            localh.kx = ((Integer)localObject2).intValue();
          }
          catch (Exception localException2)
          {
            jW = 3;
            return localh;
          }
        }
        catch (Exception localException3)
        {
          j2 = null;
          jW = 2;
        }
      }
    }
    return localh;
  }

  private h jdMethod_if(CellInfo paramCellInfo)
  {
    int i = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
    if (i < 17)
      return null;
    h localh = new h();
    int j;
    if ((paramCellInfo instanceof CellInfoGsm))
    {
      CellIdentityGsm localCellIdentityGsm = ((CellInfoGsm)paramCellInfo).getCellIdentity();
      localh.kB = jdMethod_void(localCellIdentityGsm.getMcc());
      localh.kC = jdMethod_void(localCellIdentityGsm.getMnc());
      localh.ku = jdMethod_void(localCellIdentityGsm.getLac());
      localh.ky = jdMethod_void(localCellIdentityGsm.getCid());
      localh.kA = 'g';
      localh.kz = ((CellInfoGsm)paramCellInfo).getCellSignalStrength().getAsuLevel();
      j = 1;
    }
    while (true)
    {
      if ((i >= 18) && (j == 0));
      try
      {
        if ((paramCellInfo instanceof CellInfoWcdma))
        {
          CellIdentityWcdma localCellIdentityWcdma = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
          localh.kB = jdMethod_void(localCellIdentityWcdma.getMcc());
          localh.kC = jdMethod_void(localCellIdentityWcdma.getMnc());
          localh.ku = jdMethod_void(localCellIdentityWcdma.getLac());
          localh.ky = jdMethod_void(localCellIdentityWcdma.getCid());
          localh.kA = 'g';
          localh.kz = ((CellInfoWcdma)paramCellInfo).getCellSignalStrength().getAsuLevel();
        }
        try
        {
          label216: long l = (SystemClock.elapsedRealtimeNanos() - paramCellInfo.getTimeStamp()) / 1000000L;
          localh.kw = (System.currentTimeMillis() - l);
          return localh;
          if ((paramCellInfo instanceof CellInfoCdma))
          {
            CellIdentityCdma localCellIdentityCdma = ((CellInfoCdma)paramCellInfo).getCellIdentity();
            localh.kD = localCellIdentityCdma.getLatitude();
            localh.kx = localCellIdentityCdma.getLongitude();
            localh.kC = jdMethod_void(localCellIdentityCdma.getSystemId());
            localh.ku = jdMethod_void(localCellIdentityCdma.getNetworkId());
            localh.ky = jdMethod_void(localCellIdentityCdma.getBasestationId());
            localh.kA = 'c';
            localh.kz = ((CellInfoCdma)paramCellInfo).getCellSignalStrength().getCdmaDbm();
            j = 1;
            continue;
          }
          boolean bool = paramCellInfo instanceof CellInfoLte;
          j = 0;
          if (!bool)
            continue;
          CellIdentityLte localCellIdentityLte = ((CellInfoLte)paramCellInfo).getCellIdentity();
          localh.kB = jdMethod_void(localCellIdentityLte.getMcc());
          localh.kC = jdMethod_void(localCellIdentityLte.getMnc());
          localh.ku = jdMethod_void(localCellIdentityLte.getTac());
          localh.ky = jdMethod_void(localCellIdentityLte.getCi());
          localh.kA = 'g';
          localh.kz = ((CellInfoLte)paramCellInfo).getCellSignalStrength().getAsuLevel();
          j = 1;
        }
        catch (Error localError)
        {
          while (true)
            localh.kw = System.currentTimeMillis();
        }
      }
      catch (Exception localException)
      {
        break label216;
      }
    }
  }

  private void jdMethod_try(h paramh)
  {
    int i;
    h localh;
    if ((paramh.ds()) && ((this.jX == null) || (!this.jX.jdMethod_case(paramh))))
    {
      this.jX = paramh;
      if (!paramh.ds())
        break label152;
      i = this.j4.size();
      if (i != 0)
        break label133;
      localh = null;
      if ((localh == null) || (localh.ky != this.jX.ky) || (localh.ku != this.jX.ku))
      {
        this.j4.add(this.jX);
        if (this.j4.size() > 3)
          this.j4.remove(0);
        cW();
        this.jZ = false;
      }
    }
    label133: label152: 
    do
    {
      return;
      localh = (h)this.j4.get(i - 1);
      break;
    }
    while (this.j4 == null);
    this.j4.clear();
  }

  private int jdMethod_void(int paramInt)
  {
    if (paramInt == 2147483647)
      paramInt = -1;
    return paramInt;
  }

  public h cM()
  {
    if (((this.jX == null) || (!this.jX.du()) || (!this.jX.ds())) && (this.jR != null));
    try
    {
      cT();
      label38: if (this.jX.dy())
      {
        this.jU = null;
        this.jU = new h(this.jX.ku, this.jX.ky, this.jX.kB, this.jX.kC, this.jX.kz, this.jX.kA);
      }
      if ((this.jX.dB()) && (this.jU != null) && (this.jX.kA == 'g'))
      {
        this.jX.kC = this.jU.kC;
        this.jX.kB = this.jU.kB;
      }
      return this.jX;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }

  // ERROR //
  public void cN()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 75	com/baidu/location/h/b:jV	Z
    //   6: istore_2
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 496	com/baidu/location/f:isServing	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 500	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: ldc_w 502
    //   28: invokevirtual 508	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 103	android/telephony/TelephonyManager
    //   34: putfield 62	com/baidu/location/h/b:jR	Landroid/telephony/TelephonyManager;
    //   37: aload_0
    //   38: new 248	java/util/LinkedList
    //   41: dup
    //   42: invokespecial 249	java/util/LinkedList:<init>	()V
    //   45: putfield 71	com/baidu/location/h/b:j4	Ljava/util/List;
    //   48: aload_0
    //   49: new 510	com/baidu/location/h/b$a
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 512	com/baidu/location/h/b$a:<init>	(Lcom/baidu/location/h/b;)V
    //   57: putfield 73	com/baidu/location/h/b:j5	Lcom/baidu/location/h/b$a;
    //   60: aload_0
    //   61: invokespecial 514	com/baidu/location/h/b:cS	()V
    //   64: aload_0
    //   65: getfield 62	com/baidu/location/h/b:jR	Landroid/telephony/TelephonyManager;
    //   68: ifnull -56 -> 12
    //   71: aload_0
    //   72: getfield 73	com/baidu/location/h/b:j5	Lcom/baidu/location/h/b$a;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull -65 -> 12
    //   80: aload_0
    //   81: getfield 62	com/baidu/location/h/b:jR	Landroid/telephony/TelephonyManager;
    //   84: aload_0
    //   85: getfield 73	com/baidu/location/h/b:j5	Lcom/baidu/location/h/b$a;
    //   88: sipush 272
    //   91: invokevirtual 518	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   94: aload_0
    //   95: iconst_1
    //   96: putfield 75	com/baidu/location/h/b:jV	Z
    //   99: goto -87 -> 12
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    //   107: astore 4
    //   109: goto -15 -> 94
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	102	finally
    //   15	76	102	finally
    //   80	94	102	finally
    //   94	99	102	finally
    //   80	94	107	java/lang/Exception
  }

  public String cO()
  {
    return null;
  }

  public int cP()
  {
    if (this.jR == null)
      return 0;
    try
    {
      int i = this.jR.getNetworkType();
      return i;
    }
    catch (Exception localException)
    {
    }
    return 0;
  }

  public int cQ()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)com.baidu.location.f.getServiceContext().getSystemService("phone");
    try
    {
      String str2 = localTelephonyManager.getSubscriberId();
      str1 = str2;
      if (str1 != null)
        if ((str1.startsWith("46000")) || (str1.startsWith("46002")) || (str1.startsWith("46007")))
          return 1;
    }
    catch (Exception localException)
    {
      String str1;
      while (true)
        str1 = null;
      if (str1.startsWith("46001"))
        return 2;
      if (str1.startsWith("46003"))
        return 3;
    }
    return 0;
  }

  public void cR()
  {
    monitorenter;
    try
    {
      boolean bool = this.jV;
      if (!bool);
      while (true)
      {
        return;
        if ((this.j5 != null) && (this.jR != null))
          this.jR.listen(this.j5, 0);
        this.j5 = null;
        this.jR = null;
        this.j4.clear();
        this.j4 = null;
        cW();
        this.jV = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public boolean cV()
  {
    return this.jZ;
  }

  public String jdMethod_int(h paramh)
  {
    Object localObject1;
    try
    {
      localObject1 = jdMethod_byte(paramh);
      if ((localObject1 != null) && (!((String)localObject1).equals("")) && (!((String)localObject1).equals("&nc=")))
        return localObject1;
      List localList = this.jR.getNeighboringCellInfo();
      Iterator localIterator;
      int i;
      if ((localList != null) && (!localList.isEmpty()))
      {
        localObject2 = "&nc=";
        localIterator = localList.iterator();
        i = 0;
      }
      while (true)
      {
        if (!localIterator.hasNext())
          break label290;
        NeighboringCellInfo localNeighboringCellInfo = (NeighboringCellInfo)localIterator.next();
        int j = localNeighboringCellInfo.getLac();
        if ((j == -1) || (localNeighboringCellInfo.getCid() == -1))
          break;
        String str2;
        if (paramh.ku != j)
          str2 = (String)localObject2 + j + "|" + localNeighboringCellInfo.getCid() + "|" + localNeighboringCellInfo.getRssi() + ";";
        int k;
        String str1;
        for (localObject1 = str2; ; localObject1 = str1)
        {
          k = i + 1;
          if (k < 8)
            break;
          if ((localObject1 == null) || (!((String)localObject1).equals("&nc=")))
            break label296;
          return null;
          str1 = (String)localObject2 + "|" + localNeighboringCellInfo.getCid() + "|" + localNeighboringCellInfo.getRssi() + ";";
        }
        i = k;
        localObject2 = localObject1;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Object localObject2;
        localException.printStackTrace();
        localObject1 = "";
        continue;
        localObject1 = localObject2;
        continue;
        label290: localObject1 = localObject2;
      }
    }
    label296: return (String)(String)localObject1;
  }

  public String jdMethod_new(h paramh)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw=");
    localStringBuffer.append(paramh.kA);
    Locale localLocale1 = Locale.CHINA;
    Object[] arrayOfObject1 = new Object[5];
    arrayOfObject1[0] = Integer.valueOf(paramh.kB);
    arrayOfObject1[1] = Integer.valueOf(paramh.kC);
    arrayOfObject1[2] = Integer.valueOf(paramh.ku);
    arrayOfObject1[3] = Integer.valueOf(paramh.ky);
    arrayOfObject1[4] = Integer.valueOf(paramh.kz);
    localStringBuffer.append(String.format(localLocale1, "&cl=%d|%d|%d|%d&cl_s=%d", arrayOfObject1));
    if ((paramh.kD < 2147483647) && (paramh.kx < 2147483647))
    {
      Locale localLocale2 = Locale.CHINA;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = Double.valueOf(paramh.kx / 14400.0D);
      arrayOfObject2[1] = Double.valueOf(paramh.kD / 14400.0D);
      localStringBuffer.append(String.format(localLocale2, "&cdmall=%.6f|%.6f", arrayOfObject2));
    }
    localStringBuffer.append("&cl_t=");
    localStringBuffer.append(paramh.kw);
    if ((this.j4 != null) && (this.j4.size() > 0))
    {
      int j = this.j4.size();
      localStringBuffer.append("&clt=");
      for (int k = 0; k < j; k++)
      {
        h localh = (h)this.j4.get(k);
        if (localh.kB != paramh.kB)
          localStringBuffer.append(localh.kB);
        localStringBuffer.append("|");
        if (localh.kC != paramh.kC)
          localStringBuffer.append(localh.kC);
        localStringBuffer.append("|");
        if (localh.ku != paramh.ku)
          localStringBuffer.append(localh.ku);
        localStringBuffer.append("|");
        if (localh.ky != paramh.ky)
          localStringBuffer.append(localh.ky);
        localStringBuffer.append("|");
        localStringBuffer.append((System.currentTimeMillis() - localh.kw) / 1000L);
        localStringBuffer.append(";");
      }
    }
    if (jY > 100)
      jY = 0;
    int i = (jW << 8) + jY;
    localStringBuffer.append("&cs=" + i);
    return localStringBuffer.toString();
  }

  private class a extends PhoneStateListener
  {
    public a()
    {
    }

    public void onCellLocationChanged(CellLocation paramCellLocation)
    {
      if (paramCellLocation == null)
        return;
      try
      {
        b.jdMethod_if(b.this);
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      if (b.jdMethod_do(b.this) != null)
      {
        if (b.jdMethod_do(b.this).kA != 'g')
          break label40;
        b.jdMethod_do(b.this).kz = paramSignalStrength.getGsmSignalStrength();
      }
      label40: 
      do
        return;
      while (b.jdMethod_do(b.this).kA != 'c');
      b.jdMethod_do(b.this).kz = paramSignalStrength.getCdmaDbm();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.h.b
 * JD-Core Version:    0.6.0
 */