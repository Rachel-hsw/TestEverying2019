package com.withustudy.koudaizikao.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import org.a.a.a.v;
import org.apache.http.conn.util.InetAddressUtils;

public class k
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;

  public static String a()
  {
    try
    {
      while (true)
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        while (true)
          if (localEnumeration1.hasMoreElements())
          {
            Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
            if (!localEnumeration2.hasMoreElements())
              continue;
            InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
            if ((localInetAddress.isLoopbackAddress()) || (localInetAddress.isLinkLocalAddress()))
              break;
            String str = localInetAddress.getHostAddress().toString();
            return str;
          }
      }
    }
    catch (SocketException localSocketException)
    {
    }
    return null;
  }

  public static boolean a(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnectedOrConnecting());
  }

  public static int b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return 0;
    int i = localNetworkInfo.getType();
    int j;
    if (i == 0)
    {
      String str = localNetworkInfo.getExtraInfo();
      if (v.a(str))
        break label74;
      if (str.toLowerCase().equals("cmnet"))
        j = 3;
    }
    while (true)
    {
      return j;
      j = 2;
      continue;
      if (i == 1)
      {
        j = 1;
        continue;
      }
      label74: j = 0;
    }
  }

  public static String b()
  {
    try
    {
      label15: InetAddress localInetAddress;
      do
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration2;
        while (!localEnumeration2.hasMoreElements())
        {
          boolean bool = localEnumeration1.hasMoreElements();
          if (!bool)
            return "";
          localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration2.nextElement();
      }
      while ((localInetAddress.isLoopbackAddress()) || (!InetAddressUtils.isIPv4Address(localInetAddress.getHostAddress())));
      String str = localInetAddress.getHostAddress();
      return str;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }

  public static boolean c(Context paramContext)
  {
    int i = 1;
    if (n.b(paramContext) != i)
      i = 0;
    return i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.k
 * JD-Core Version:    0.6.0
 */