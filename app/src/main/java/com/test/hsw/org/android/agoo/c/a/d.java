package org.android.agoo.c.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public final class d
{
  private static final String b = "UTF-8";
  private static final String c = "&";
  private static final String d = "=";
  protected ConcurrentHashMap<String, String> a;

  public d()
  {
    d();
  }

  public d(String paramString1, String paramString2)
  {
    d();
    a(paramString1, paramString2);
  }

  public d(Map<String, String> paramMap)
  {
    d();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }

  public static final String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = b((String)localEntry.getKey());
      String str2 = (String)localEntry.getValue();
      if (str2 != null);
      for (String str3 = b(str2); ; str3 = "")
      {
        if (localStringBuilder.length() > 0)
          localStringBuilder.append("&");
        localStringBuilder.append(str1);
        localStringBuilder.append("=");
        localStringBuilder.append(str3);
        break;
      }
    }
    return localStringBuilder.toString();
  }

  private static String b(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new IllegalArgumentException(localUnsupportedEncodingException);
  }

  private void d()
  {
    this.a = new ConcurrentHashMap();
  }

  public final HttpEntity a()
  {
    try
    {
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(b(), "UTF-8");
      return localUrlEncodedFormEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }

  public final void a(String paramString)
  {
    this.a.remove(paramString);
  }

  public final void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
      this.a.put(paramString1, paramString2);
  }

  protected List<BasicNameValuePair> b()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localLinkedList;
  }

  public final String c()
  {
    return a(this.a);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append("&");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.c.a.d
 * JD-Core Version:    0.6.0
 */