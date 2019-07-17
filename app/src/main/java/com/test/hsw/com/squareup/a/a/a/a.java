package com.squareup.a.a.a;

import com.squareup.a.aa;
import com.squareup.a.b;
import com.squareup.a.j;
import com.squareup.a.o;
import com.squareup.a.w;
import com.squareup.a.w.a;
import java.io.IOException;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.List;

public final class a
  implements b
{
  public static final b a = new a();

  private InetAddress a(Proxy paramProxy, URL paramURL)
    throws IOException
  {
    if ((paramProxy != null) && (paramProxy.type() != Proxy.Type.DIRECT))
      return ((InetSocketAddress)paramProxy.address()).getAddress();
    return InetAddress.getByName(paramURL.getHost());
  }

  public w a(Proxy paramProxy, aa paramaa)
    throws IOException
  {
    List localList = paramaa.m();
    w localw = paramaa.a();
    URL localURL = localw.a();
    int i = localList.size();
    int j = 0;
    if (j < i)
    {
      j localj = (j)localList.get(j);
      if (!"Basic".equalsIgnoreCase(localj.a()));
      PasswordAuthentication localPasswordAuthentication;
      do
      {
        j++;
        break;
        localPasswordAuthentication = Authenticator.requestPasswordAuthentication(localURL.getHost(), a(paramProxy, localURL), localURL.getPort(), localURL.getProtocol(), localj.b(), localj.a(), localURL, Authenticator.RequestorType.SERVER);
      }
      while (localPasswordAuthentication == null);
      String str = o.a(localPasswordAuthentication.getUserName(), new String(localPasswordAuthentication.getPassword()));
      return localw.h().a("Authorization", str).d();
    }
    return null;
  }

  public w b(Proxy paramProxy, aa paramaa)
    throws IOException
  {
    List localList = paramaa.m();
    w localw = paramaa.a();
    URL localURL = localw.a();
    int i = localList.size();
    int j = 0;
    if (j < i)
    {
      j localj = (j)localList.get(j);
      if (!"Basic".equalsIgnoreCase(localj.a()));
      PasswordAuthentication localPasswordAuthentication;
      do
      {
        j++;
        break;
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)paramProxy.address();
        localPasswordAuthentication = Authenticator.requestPasswordAuthentication(localInetSocketAddress.getHostName(), a(paramProxy, localURL), localInetSocketAddress.getPort(), localURL.getProtocol(), localj.b(), localj.a(), localURL, Authenticator.RequestorType.PROXY);
      }
      while (localPasswordAuthentication == null);
      String str = o.a(localPasswordAuthentication.getUserName(), new String(localPasswordAuthentication.getPassword()));
      return localw.h().a("Proxy-Authorization", str).d();
    }
    return null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.a
 * JD-Core Version:    0.6.0
 */