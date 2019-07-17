package org.a.a.a.i;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

abstract class f<F extends Format>
{
  static final int a = -1;
  private final ConcurrentMap<a, F> b = new ConcurrentHashMap(7);
  private final ConcurrentMap<a, String> c = new ConcurrentHashMap(7);

  public F a()
  {
    return a(Integer.valueOf(3), Integer.valueOf(3), TimeZone.getDefault(), Locale.getDefault());
  }

  public F a(Integer paramInteger1, Integer paramInteger2, TimeZone paramTimeZone, Locale paramLocale)
  {
    if (paramLocale == null)
      paramLocale = Locale.getDefault();
    a locala = new a(new Object[] { paramInteger1, paramInteger2, paramLocale });
    Object localObject1 = (String)this.c.get(locala);
    if ((localObject1 != null) || (paramInteger1 == null));
    while (true)
    {
      String str;
      try
      {
        Object localObject2 = DateFormat.getTimeInstance(paramInteger2.intValue(), paramLocale);
        str = ((SimpleDateFormat)localObject2).toPattern();
        localObject1 = (String)this.c.putIfAbsent(locala, str);
        if (localObject1 != null)
        {
          return c((String)localObject1, paramTimeZone, paramLocale);
          if (paramInteger2 != null)
            continue;
          localObject2 = DateFormat.getDateInstance(paramInteger1.intValue(), paramLocale);
          continue;
          DateFormat localDateFormat = DateFormat.getDateTimeInstance(paramInteger1.intValue(), paramInteger2.intValue(), paramLocale);
          localObject2 = localDateFormat;
          continue;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        throw new IllegalArgumentException("No date time pattern for locale: " + paramLocale);
      }
      localObject1 = str;
    }
  }

  protected abstract F b(String paramString, TimeZone paramTimeZone, Locale paramLocale);

  public F c(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    if (paramString == null)
      throw new NullPointerException("pattern must not be null");
    if (paramTimeZone == null)
      paramTimeZone = TimeZone.getDefault();
    if (paramLocale == null)
      paramLocale = Locale.getDefault();
    a locala = new a(new Object[] { paramString, paramTimeZone, paramLocale });
    Format localFormat1 = (Format)this.b.get(locala);
    Format localFormat2;
    if (localFormat1 == null)
    {
      localFormat2 = b(paramString, paramTimeZone, paramLocale);
      localFormat1 = (Format)this.b.putIfAbsent(locala, localFormat2);
      if (localFormat1 == null);
    }
    else
    {
      return localFormat1;
    }
    return localFormat2;
  }

  private static class a
  {
    private final Object[] a;
    private int b;

    public a(Object[] paramArrayOfObject)
    {
      this.a = paramArrayOfObject;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject)
        return true;
      if (!(paramObject instanceof a))
        return false;
      return Arrays.equals(this.a, ((a)paramObject).a);
    }

    public int hashCode()
    {
      int i = 0;
      if (this.b == 0)
      {
        for (Object localObject : this.a)
        {
          if (localObject == null)
            continue;
          i = i * 7 + localObject.hashCode();
        }
        this.b = i;
      }
      return this.b;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.i.f
 * JD-Core Version:    0.6.0
 */