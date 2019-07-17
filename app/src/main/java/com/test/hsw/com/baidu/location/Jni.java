package com.baidu.location;

import com.baidu.location.b.f;
import com.baidu.location.f.b.b;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Jni
  implements f
{
  private static int k9;
  private static int la;
  private static int lb;
  private static int lc;
  private static int ld;
  private static int le;
  private static boolean lf;
  private static int lg;
  private static int lh;
  private static int li = 0;

  static
  {
    lg = 1;
    lh = 2;
    lc = 11;
    le = 12;
    la = 13;
    k9 = 14;
    ld = 15;
    lb = 1024;
    lf = false;
    try
    {
      System.loadLibrary("locSDK6a");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      lf = true;
    }
  }

  public static String E(String paramString)
  {
    if (lf)
      return null;
    String str1 = jdMethod_if(encrypt(paramString.getBytes()));
    try
    {
      String str2 = URLEncoder.encode(str1, "UTF-8");
      return str2;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String F(String paramString)
  {
    int i = 740;
    int j = 0;
    if (lf)
      return "err!";
    if (paramString == null)
      return "null";
    byte[] arrayOfByte1 = paramString.getBytes();
    byte[] arrayOfByte2 = new byte[lb];
    int k = arrayOfByte1.length;
    if (k > i);
    while (true)
    {
      int m = 0;
      while (j < i)
      {
        if (arrayOfByte1[j] != 0)
        {
          arrayOfByte2[m] = arrayOfByte1[j];
          m++;
        }
        j++;
      }
      try
      {
        String str = a(arrayOfByte2, 132456);
        return str;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        return "err!";
      }
      i = k;
    }
  }

  public static String G(String paramString)
  {
    if (lf)
      return "err!";
    try
    {
      str1 = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception localException)
    {
      try
      {
        while (true)
        {
          String str3 = encodeNotLimit(str1, 132456);
          str2 = str3;
          return str2 + "|tp=3";
          localException = localException;
          String str1 = "";
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        while (true)
        {
          localUnsatisfiedLinkError.printStackTrace();
          String str2 = "err!";
        }
      }
    }
  }

  public static String H(String paramString)
  {
    if (lf)
      return "err!";
    return F(paramString) + "|tp=3";
  }

  public static Long I(String paramString)
  {
    if (lf)
      return null;
    try
    {
      str = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception localException)
    {
      try
      {
        while (true)
        {
          Long localLong = Long.valueOf(murmur(str));
          return localLong;
          localException = localException;
          String str = "";
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
      }
    }
    return null;
  }

  public static String J(String paramString)
  {
    if (lf)
      return "err!";
    if (paramString == null)
      return "null";
    byte[] arrayOfByte = paramString.getBytes();
    try
    {
      String str = c(arrayOfByte, 132456);
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return "err!";
  }

  public static String K(String paramString)
  {
    if (lf)
      return "err!";
    try
    {
      str1 = new String(paramString.getBytes(), "UTF-8");
    }
    catch (Exception localException)
    {
      try
      {
        while (true)
        {
          String str3 = ee(str1, 132456);
          str2 = str3;
          return str2 + "|tp=4";
          localException = localException;
          String str1 = "";
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        while (true)
        {
          localUnsatisfiedLinkError.printStackTrace();
          String str2 = "err!";
        }
      }
    }
  }

  public static String L(String paramString)
  {
    if (lf);
    while (true)
    {
      return null;
      try
      {
        String str = g(paramString.getBytes());
        if ((str != null) && (str.length() >= 2) && (!"no".equals(str)))
          return str;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
      }
    }
    return null;
  }

  private static native String a(byte[] paramArrayOfByte, int paramInt);

  private static native String b(double paramDouble1, double paramDouble2, int paramInt1, int paramInt2);

  private static native String c(byte[] paramArrayOfByte, int paramInt);

  public static String dG()
  {
    if (lf)
      return "err!";
    try
    {
      String str = sky();
      return str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
    return "err!";
  }

  private static native String ee(String paramString, int paramInt);

  private static native String encodeNotLimit(String paramString, int paramInt);

  private static native byte[] encrypt(byte[] paramArrayOfByte);

  private static native void f(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  private static native String g(byte[] paramArrayOfByte);

  private static native String ib(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  private static String jdMethod_if(byte[] paramArrayOfByte)
  {
    try
    {
      String str = b.a(paramArrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return "";
  }

  public static String jdMethod_if(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (lf)
      return null;
    return ib(paramArrayOfByte1, paramArrayOfByte2);
  }

  public static double[] jdMethod_if(double paramDouble1, double paramDouble2, String paramString)
  {
    double[] arrayOfDouble = { 0.0D, 0.0D };
    if (lf)
      return arrayOfDouble;
    int i = -1;
    if (paramString.equals("bd09"))
      i = li;
    try
    {
      while (true)
      {
        String[] arrayOfString = b(paramDouble1, paramDouble2, i, 132456).split(":");
        arrayOfDouble[0] = Double.parseDouble(arrayOfString[0]);
        arrayOfDouble[1] = Double.parseDouble(arrayOfString[1]);
        label78: return arrayOfDouble;
        if (paramString.equals("bd09ll"))
        {
          i = lg;
          continue;
        }
        if (paramString.equals("gcj02"))
        {
          i = lh;
          continue;
        }
        if (paramString.equals("gps2gcj"))
        {
          i = lc;
          continue;
        }
        if (paramString.equals("bd092gcj"))
        {
          i = le;
          continue;
        }
        if (paramString.equals("bd09ll2gcj"))
        {
          i = la;
          continue;
        }
        if (!paramString.equals("wgs842mc"))
          continue;
        i = ld;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label78;
    }
  }

  public static void jdMethod_int(String paramString1, String paramString2)
  {
    if (lf)
      return;
    try
    {
      f(paramString1.getBytes(), paramString2.getBytes());
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }

  private static native long murmur(String paramString);

  private static native String sky();
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.baidu.location.Jni
 * JD-Core Version:    0.6.0
 */