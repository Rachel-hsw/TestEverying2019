package com.umeng.message.b;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class eq
  implements X509TrustManager
{
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.eq
 * JD-Core Version:    0.6.0
 */