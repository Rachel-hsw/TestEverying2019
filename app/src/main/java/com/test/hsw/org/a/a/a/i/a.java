package org.a.a.a.i;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class a
{
  public static final d a;
  public static final d b;
  public static final d c;
  public static final d d;
  public static final d e;
  public static final d f;
  public static final d g;
  public static final d h;
  public static final d i;
  private static final TimeZone j = TimeZone.getTimeZone("GMT");

  static
  {
    a = d.a("yyyy-MM-dd'T'HH:mm:ss");
    b = d.a("yyyy-MM-dd'T'HH:mm:ssZZ");
    c = d.a("yyyy-MM-dd");
    d = d.a("yyyy-MM-ddZZ");
    e = d.a("'T'HH:mm:ss");
    f = d.a("'T'HH:mm:ssZZ");
    g = d.a("HH:mm:ss");
    h = d.a("HH:mm:ssZZ");
    i = d.a("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
  }

  public static String a(long paramLong, String paramString)
  {
    return a(new Date(paramLong), paramString, j, null);
  }

  public static String a(long paramLong, String paramString, Locale paramLocale)
  {
    return a(new Date(paramLong), paramString, j, paramLocale);
  }

  public static String a(long paramLong, String paramString, TimeZone paramTimeZone)
  {
    return a(new Date(paramLong), paramString, paramTimeZone, null);
  }

  public static String a(long paramLong, String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    return a(new Date(paramLong), paramString, paramTimeZone, paramLocale);
  }

  public static String a(Calendar paramCalendar, String paramString)
  {
    return a(paramCalendar, paramString, null, null);
  }

  public static String a(Calendar paramCalendar, String paramString, Locale paramLocale)
  {
    return a(paramCalendar, paramString, null, paramLocale);
  }

  public static String a(Calendar paramCalendar, String paramString, TimeZone paramTimeZone)
  {
    return a(paramCalendar, paramString, paramTimeZone, null);
  }

  public static String a(Calendar paramCalendar, String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    return d.a(paramString, paramTimeZone, paramLocale).a(paramCalendar);
  }

  public static String a(Date paramDate, String paramString)
  {
    return a(paramDate, paramString, j, null);
  }

  public static String a(Date paramDate, String paramString, Locale paramLocale)
  {
    return a(paramDate, paramString, j, paramLocale);
  }

  public static String a(Date paramDate, String paramString, TimeZone paramTimeZone)
  {
    return a(paramDate, paramString, paramTimeZone, null);
  }

  public static String a(Date paramDate, String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    return d.a(paramString, paramTimeZone, paramLocale).a(paramDate);
  }

  public static String b(long paramLong, String paramString)
  {
    return a(new Date(paramLong), paramString, null, null);
  }

  public static String b(long paramLong, String paramString, Locale paramLocale)
  {
    return a(new Date(paramLong), paramString, null, paramLocale);
  }

  public static String b(Date paramDate, String paramString)
  {
    return a(paramDate, paramString, null, null);
  }

  public static String b(Date paramDate, String paramString, Locale paramLocale)
  {
    return a(paramDate, paramString, null, paramLocale);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.i.a
 * JD-Core Version:    0.6.0
 */