package com.squareup.a.a.c;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class b
  implements HostnameVerifier
{
  public static final b a = new b();
  private static final Pattern b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  private static final int c = 2;
  private static final int d = 7;

  private List<String> a(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Collection localCollection = paramX509Certificate.getSubjectAlternativeNames();
      if (localCollection == null)
        return Collections.emptyList();
      Iterator localIterator = localCollection.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        if ((localList == null) || (localList.size() < 2))
          continue;
        Integer localInteger = (Integer)localList.get(0);
        if ((localInteger == null) || (localInteger.intValue() != paramInt))
          continue;
        String str = (String)localList.get(1);
        if (str == null)
          continue;
        localArrayList.add(str);
      }
    }
    catch (CertificateParsingException localCertificateParsingException)
    {
      return Collections.emptyList();
    }
    return localArrayList;
  }

  static boolean a(String paramString)
  {
    return b.matcher(paramString).matches();
  }

  private boolean b(String paramString, X509Certificate paramX509Certificate)
  {
    Iterator localIterator = a(paramX509Certificate, 7).iterator();
    while (localIterator.hasNext())
      if (paramString.equalsIgnoreCase((String)localIterator.next()))
        return true;
    return false;
  }

  private boolean c(String paramString, X509Certificate paramX509Certificate)
  {
    String str1 = paramString.toLowerCase(Locale.US);
    Iterator localIterator = a(paramX509Certificate, 2).iterator();
    for (int i = 0; localIterator.hasNext(); i = 1)
      if (a(str1, (String)localIterator.next()))
        return true;
    if (i == 0)
    {
      String str2 = new a(paramX509Certificate.getSubjectX500Principal()).a("cn");
      if (str2 != null)
        return a(str1, str2);
    }
    return false;
  }

  public boolean a(String paramString1, String paramString2)
  {
    int i = 1;
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString2 == null) || (paramString2.length() == 0))
      i = 0;
    String str;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        return i;
        str = paramString2.toLowerCase(Locale.US);
        if (!str.contains("*"))
          return paramString1.equals(str);
      }
      while ((str.startsWith("*.")) && (paramString1.regionMatches(0, str, 2, -2 + str.length())));
      j = str.indexOf('*');
      if (j > str.indexOf('.'))
        return false;
      if (!paramString1.regionMatches(0, str, 0, j))
        return false;
      k = str.length() - (j + 1);
      m = paramString1.length() - k;
      if (paramString1.indexOf('.', j) < m)
        return false;
    }
    while (paramString1.regionMatches(m, str, j + 1, k));
    return false;
  }

  public boolean a(String paramString, X509Certificate paramX509Certificate)
  {
    if (a(paramString))
      return b(paramString, paramX509Certificate);
    return c(paramString, paramX509Certificate);
  }

  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException localSSLException)
    {
    }
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.c.b
 * JD-Core Version:    0.6.0
 */