package org.a.a.a.h;

import java.util.Map;

public abstract class f<V>
{
  private static final f<String> a = new a(null);
  private static final f<String> b;

  static
  {
    try
    {
      localObject = new a(System.getProperties());
      b = (f)localObject;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        Object localObject = a;
    }
  }

  public static f<?> a()
  {
    return a;
  }

  public static <V> f<V> a(Map<String, V> paramMap)
  {
    return new a(paramMap);
  }

  public static f<String> b()
  {
    return b;
  }

  public abstract String a(String paramString);

  static class a<V> extends f<V>
  {
    private final Map<String, V> a;

    a(Map<String, V> paramMap)
    {
      this.a = paramMap;
    }

    public String a(String paramString)
    {
      if (this.a == null);
      Object localObject;
      do
      {
        return null;
        localObject = this.a.get(paramString);
      }
      while (localObject == null);
      return localObject.toString();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.f
 * JD-Core Version:    0.6.0
 */