package com.umeng.message.b;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class et
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.et
 * JD-Core Version:    0.6.0
 */