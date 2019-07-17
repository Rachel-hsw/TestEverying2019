package com.squareup.a.a;

import java.net.InetAddress;
import java.net.UnknownHostException;

final class f
  implements e
{
  public InetAddress[] a(String paramString)
    throws UnknownHostException
  {
    if (paramString == null)
      throw new UnknownHostException("host == null");
    return InetAddress.getAllByName(paramString);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.f
 * JD-Core Version:    0.6.0
 */