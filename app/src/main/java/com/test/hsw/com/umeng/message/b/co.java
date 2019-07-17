package com.umeng.message.b;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;

public final class co
{
  public static final String a = "UTF-8";
  public static Charset b;

  static
  {
    try
    {
      b = Charset.forName("UTF-8");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
  }

  public static final <T extends CharSequence> String a(Collection<T> paramCollection, char paramChar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramCollection != null) && (paramCollection.size() > 0))
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
        localStringBuilder.append((CharSequence)localIterator.next());
    }
    return localStringBuilder.toString();
  }

  public static final String a(Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int i = paramArrayOfObject.length;
      for (int j = 0; j < i; j++)
        localStringBuilder.append(paramArrayOfObject[j]);
    }
    return localStringBuilder.toString();
  }

  public static final boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.b.co
 * JD-Core Version:    0.6.0
 */