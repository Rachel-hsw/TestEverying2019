package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.e.e;
import com.baidu.location.h.a;
import com.baidu.location.h.b;
import com.baidu.location.h.h;
import com.baidu.location.h.j;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;

public class k
  implements f
{
  public static int b0 = 0;
  public static int b1 = 0;
  public static byte[] b2;
  public static int b3 = 0;
  public static double b4 = 0.0D;
  private static String b5;
  private static String b6;
  public static int b7 = 0;
  public static int b8 = 0;
  public static int b9 = 0;
  private static String bE;
  public static float bF = 0.0F;
  public static double bG = 0.0D;
  public static int bH = 0;
  public static int bI = 0;
  public static int bJ = 0;
  public static boolean bK = false;
  public static float bL = 0.0F;
  public static int bM = 0;
  private static String bN;
  public static int bO = 0;
  public static boolean bP = false;
  public static int bQ = 0;
  public static boolean bR = false;
  public static boolean bS = false;
  public static int bT = 0;
  private static String bU;
  private static String bV;
  public static float bW = 0.0F;
  public static boolean bX = false;
  public static boolean bY = false;
  private static String bZ;
  public static float cA = 0.0F;
  public static int cB = 0;
  public static int cC = 0;
  public static int cD = 0;
  public static double cE = 0.0D;
  public static int cF = 0;
  public static boolean cG = false;
  public static long cH = 0L;
  public static int cI = 0;
  public static long cJ = 0L;
  public static int cK = 0;
  public static int cL = 0;
  public static boolean cM = false;
  public static String cN;
  public static float cO = 0.0F;
  public static long cP = 0L;
  public static float cQ = 0.0F;
  public static float ca = 0.0F;
  public static float cb = 0.0F;
  public static int cc = 0;
  public static float cd = 0.0F;
  public static final boolean ce = true;
  public static String cf;
  public static float cg;
  public static float ch;
  public static boolean ci;
  public static boolean cj;
  public static float ck;
  public static boolean cl;
  public static boolean cm = false;
  public static float cn;
  public static int co;
  public static double cp;
  public static int cq;
  public static int cr;
  public static long cs;
  public static long ct;
  public static long cu;
  public static String cv;
  public static int cw;
  public static float cx;
  public static int cy;
  public static float cz;

  static
  {
    cG = false;
    bY = false;
    b1 = 0;
    bN = "http://loc.map.baidu.com/sdk.php";
    cv = "http://loc.map.baidu.com/sdk_ep.php";
    b6 = "http://loc.map.baidu.com/user_err.php";
    bU = "http://loc.map.baidu.com/oqur.php";
    b5 = "http://loc.map.baidu.com/tcu.php";
    bE = "http://loc.map.baidu.com/iofd.php";
    bZ = "https://sapi.skyhookwireless.com/wps2/location";
    bV = "http://loc.map.baidu.com/wloc";
    cf = "no";
    bX = false;
    bP = false;
    ci = false;
    bS = false;
    cj = false;
    cN = "gcj02";
    cl = true;
    b3 = 3;
    cp = 0.0D;
    cE = 0.0D;
    bG = 0.0D;
    b4 = 0.0D;
    co = 0;
    b2 = null;
    cM = false;
    b0 = 0;
    cQ = 1.1F;
    bW = 2.2F;
    ck = 2.3F;
    cA = 3.8F;
    b7 = 3;
    cq = 10;
    cC = 2;
    bJ = 7;
    bH = 20;
    cI = 70;
    bQ = 120;
    ch = 2.0F;
    cg = 10.0F;
    cO = 50.0F;
    cx = 200.0F;
    cD = 16;
    bL = 0.9F;
    cy = 10000;
    bF = 0.5F;
    cb = 0.0F;
    ca = 0.1F;
    b9 = 30;
    b8 = 100;
    cw = 420000;
    bR = true;
    bK = true;
    cB = 20;
    cF = 300;
    cr = 1000;
    cs = 900000L;
    cJ = 420000L;
    cu = 180000L;
    ct = 0L;
    cH = 15L;
    cP = 300000L;
    bT = 1000;
    cL = 0;
    bI = 30000;
    bM = 30000;
    cn = 10.0F;
    cd = 6.0F;
    cz = 10.0F;
    cc = 60;
    cK = 70;
    bO = 6;
  }

  static String X()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(5);
    int j = localCalendar.get(1);
    int k = 1 + localCalendar.get(2);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    int i1 = localCalendar.get(13);
    Locale localLocale = Locale.CHINA;
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(j);
    arrayOfObject[1] = Integer.valueOf(k);
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(m);
    arrayOfObject[4] = Integer.valueOf(n);
    arrayOfObject[5] = Integer.valueOf(i1);
    return String.format(localLocale, "%d_%d_%d_%d_%d_%d", arrayOfObject);
  }

  public static String Y()
  {
    return bU;
  }

  public static String Z()
  {
    return bN;
  }

  public static String aa()
  {
    return bV;
  }

  public static String ab()
  {
    return bZ;
  }

  public static String ac()
  {
    return b5;
  }

  public static String ad()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(5);
    int j = localCalendar.get(1);
    int k = 1 + localCalendar.get(2);
    int m = localCalendar.get(11);
    int n = localCalendar.get(12);
    int i1 = localCalendar.get(13);
    Locale localLocale = Locale.CHINA;
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(j);
    arrayOfObject[1] = Integer.valueOf(k);
    arrayOfObject[2] = Integer.valueOf(i);
    arrayOfObject[3] = Integer.valueOf(m);
    arrayOfObject[4] = Integer.valueOf(n);
    arrayOfObject[5] = Integer.valueOf(i1);
    return String.format(localLocale, "%d-%02d-%02d %02d:%02d:%02d", arrayOfObject);
  }

  public static String ae()
  {
    return b6;
  }

  public static String af()
  {
    if (Environment.getExternalStorageState().equals("mounted"));
    try
    {
      String str = Environment.getExternalStorageDirectory().getPath();
      File localFile = new File(str + "/baidu/tempdata");
      if (!localFile.exists())
        localFile.mkdirs();
      return str;
      return null;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String ag()
  {
    return bE;
  }

  public static String ah()
  {
    String str = af();
    if (str == null)
      return null;
    return str + "/baidu/tempdata";
  }

  public static String ai()
  {
    try
    {
      File localFile = new File(com.baidu.location.f.getServiceContext().getFilesDir() + File.separator + "lldt");
      if (!localFile.exists())
        localFile.mkdirs();
      String str = localFile.getAbsolutePath();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  static float jdMethod_do(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals("")));
    String str;
    do
    {
      int j;
      int k;
      do
      {
        int i;
        do
        {
          return 1.4E-45F;
          i = paramString1.indexOf(paramString2);
        }
        while (i == -1);
        j = i + paramString2.length();
        k = paramString1.indexOf(paramString3, j);
      }
      while (k == -1);
      str = paramString1.substring(j, k);
    }
    while ((str == null) || (str.equals("")));
    try
    {
      float f = Float.parseFloat(str);
      return f;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 1.4E-45F;
  }

  public static boolean jdMethod_do(BDLocation paramBDLocation)
  {
    int i = paramBDLocation.getLocType();
    return (i > 100) && (i < 200);
  }

  public static int jdMethod_for(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals("")));
    String str;
    do
    {
      int j;
      int k;
      do
      {
        int i;
        do
        {
          return -2147483648;
          i = paramString1.indexOf(paramString2);
        }
        while (i == -1);
        j = i + paramString2.length();
        k = paramString1.indexOf(paramString3, j);
      }
      while (k == -1);
      str = paramString1.substring(j, k);
    }
    while ((str == null) || (str.equals("")));
    try
    {
      int m = Integer.parseInt(str);
      return m;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return -2147483648;
  }

  public static boolean jdMethod_for(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int i = 0;
    NetworkInfo[] arrayOfNetworkInfo;
    if (localConnectivityManager != null)
    {
      arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
      i = 0;
      if (arrayOfNetworkInfo == null);
    }
    for (int j = 0; ; j++)
    {
      int k = arrayOfNetworkInfo.length;
      i = 0;
      if (j < k)
      {
        if (arrayOfNetworkInfo[j].getState() != NetworkInfo.State.CONNECTED)
          continue;
        i = 1;
      }
      return i;
    }
  }

  public static String jdMethod_if(h paramh, com.baidu.location.h.f paramf, Location paramLocation, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramh != null)
    {
      String str6 = b.cU().jdMethod_new(paramh);
      if (str6 != null)
        localStringBuffer.append(str6);
    }
    if (paramf != null);
    try
    {
      String str5 = paramf.e(5);
      str4 = str5;
      if (str4 != null)
        localStringBuffer.append(str4);
      if (paramLocation != null)
      {
        if (b1 == 0)
          break label182;
        str3 = a.jdMethod_else(paramLocation);
        if (str3 != null)
          localStringBuffer.append(str3);
      }
      String str1 = c.N().jdMethod_do(false);
      if (str1 != null)
        localStringBuffer.append(str1);
      if (paramString != null)
        localStringBuffer.append(paramString);
      if (paramh != null)
      {
        String str2 = com.baidu.location.h.c.a().jdMethod_int(paramh);
        if ((str2 != null) && (str2.length() + localStringBuffer.length() < 750))
          localStringBuffer.append(str2);
      }
      return localStringBuffer.toString();
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str4 = null;
        continue;
        label182: String str3 = a.jdMethod_goto(paramLocation);
      }
    }
  }

  public static String jdMethod_if(h paramh, com.baidu.location.h.f paramf, Location paramLocation, String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    if (paramh != null)
    {
      String str7 = b.cU().jdMethod_new(paramh);
      if (str7 != null)
        localStringBuffer.append(str7);
    }
    String str6;
    if (paramf != null)
    {
      if (paramInt != 0)
        break label308;
      str6 = paramf.dp();
    }
    label87: String str3;
    while (true)
    {
      if (str6 != null)
        localStringBuffer.append(str6);
      String str5;
      if (paramLocation != null)
      {
        if ((b1 == 0) || (paramInt == 0))
          break label317;
        str5 = a.jdMethod_else(paramLocation);
        if (str5 != null)
          localStringBuffer.append(str5);
      }
      boolean bool1 = false;
      if (paramInt == 0)
        bool1 = true;
      String str1 = c.N().jdMethod_do(bool1);
      if (str1 != null)
        localStringBuffer.append(str1);
      if (paramString != null)
        localStringBuffer.append(paramString);
      String str2 = e.bv().bu();
      if (!TextUtils.isEmpty(str2))
        localStringBuffer.append("&bc=").append(str2);
      if ((paramInt != 0) || (paramh != null))
      {
        String str4 = com.baidu.location.h.c.a().jdMethod_int(paramh);
        if ((str4 != null) && (str4.length() + localStringBuffer.length() < 750))
          localStringBuffer.append(str4);
      }
      str3 = localStringBuffer.toString();
      if ((paramLocation == null) || (paramf == null))
        break label391;
      try
      {
        float f = paramLocation.getSpeed();
        int i = b1;
        int j = paramf.df();
        int k = paramf.dl();
        boolean bool2 = paramf.dh();
        if ((f < cd) && ((i == 1) || (i == 0)) && ((j < cc) || (bool2 == true)))
        {
          b3 = 1;
          return str3;
          label308: str6 = paramf.dk();
          continue;
          label317: str5 = a.jdMethod_goto(paramLocation);
          break label87;
        }
        if ((f >= cz) || ((i != 1) && (i != 0) && (i != 3)) || ((j >= cK) && (k <= bO)))
          break;
        b3 = 2;
        return str3;
      }
      catch (Exception localException)
      {
        b3 = 3;
        return str3;
      }
    }
    b3 = 3;
    return str3;
    label391: b3 = 3;
    return str3;
  }

  public static String jdMethod_if(File paramFile)
  {
    if (!paramFile.isFile())
      return null;
    byte[] arrayOfByte = new byte[1024];
    MessageDigest localMessageDigest;
    FileInputStream localFileInputStream;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      localFileInputStream = new FileInputStream(paramFile);
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1)
          break;
        localMessageDigest.update(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    localFileInputStream.close();
    return new BigInteger(1, localMessageDigest.digest()).toString(16);
  }

  static String jdMethod_if(String paramString1, String paramString2, String paramString3, double paramDouble)
  {
    if ((paramString1 == null) || (paramString1.equals("")));
    int j;
    int k;
    do
    {
      int i;
      do
      {
        return null;
        i = paramString1.indexOf(paramString2);
      }
      while (i == -1);
      j = i + paramString2.length();
      k = paramString1.indexOf(paramString3, j);
    }
    while (k == -1);
    String str1 = paramString1.substring(0, j);
    String str2 = paramString1.substring(k);
    Locale localLocale = Locale.CHINA;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Double.valueOf(paramDouble);
    String str3 = String.format(localLocale, "%.7f", arrayOfObject);
    return str1 + str3 + str2;
  }

  static double jdMethod_int(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals("")));
    String str;
    do
    {
      int j;
      int k;
      do
      {
        int i;
        do
        {
          return 4.9E-324D;
          i = paramString1.indexOf(paramString2);
        }
        while (i == -1);
        j = i + paramString2.length();
        k = paramString1.indexOf(paramString3, j);
      }
      while (k == -1);
      str = paramString1.substring(j, k);
    }
    while ((str == null) || (str.equals("")));
    try
    {
      double d = Double.parseDouble(str);
      return d;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return 4.9E-324D;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.b.k
 * JD-Core Version:    0.6.0
 */