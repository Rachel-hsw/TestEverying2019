package com.squareup.a;

import com.squareup.a.a.l;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class q
{
  private final String a;
  private final List<Certificate> b;
  private final List<Certificate> c;

  private q(String paramString, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.a = paramString;
    this.b = paramList1;
    this.c = paramList2;
  }

  public static q a(String paramString, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    if (paramString == null)
      throw new IllegalArgumentException("cipherSuite == null");
    return new q(paramString, l.a(paramList1), l.a(paramList2));
  }

  public static q a(SSLSession paramSSLSession)
  {
    String str = paramSSLSession.getCipherSuite();
    if (str == null)
      throw new IllegalStateException("cipherSuite == null");
    try
    {
      Certificate[] arrayOfCertificate3 = paramSSLSession.getPeerCertificates();
      arrayOfCertificate1 = arrayOfCertificate3;
      if (arrayOfCertificate1 != null)
      {
        localList1 = l.a(arrayOfCertificate1);
        Certificate[] arrayOfCertificate2 = paramSSLSession.getLocalCertificates();
        if (arrayOfCertificate2 == null)
          break label89;
        localList2 = l.a(arrayOfCertificate2);
        return new q(str, localList1, localList2);
      }
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      while (true)
      {
        Certificate[] arrayOfCertificate1 = null;
        continue;
        List localList1 = Collections.emptyList();
        continue;
        label89: List localList2 = Collections.emptyList();
      }
    }
  }

  public String a()
  {
    return this.a;
  }

  public List<Certificate> b()
  {
    return this.b;
  }

  public Principal c()
  {
    if (!this.b.isEmpty())
      return ((X509Certificate)this.b.get(0)).getSubjectX500Principal();
    return null;
  }

  public List<Certificate> d()
  {
    return this.c;
  }

  public Principal e()
  {
    if (!this.c.isEmpty())
      return ((X509Certificate)this.c.get(0)).getSubjectX500Principal();
    return null;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof q));
    q localq;
    do
    {
      return false;
      localq = (q)paramObject;
    }
    while ((!this.a.equals(localq.a)) || (!this.b.equals(localq.b)) || (!this.c.equals(localq.c)));
    return true;
  }

  public int hashCode()
  {
    return 31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.q
 * JD-Core Version:    0.6.0
 */