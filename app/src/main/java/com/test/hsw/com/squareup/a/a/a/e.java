package com.squareup.a.a.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class e
{
  private static final ThreadLocal<DateFormat> a = new f();
  private static final String[] b = { "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z" };
  private static final DateFormat[] c = new DateFormat[b.length];

  public static String a(Date paramDate)
  {
    return ((DateFormat)a.get()).format(paramDate);
  }

  public static Date a(String paramString)
  {
    try
    {
      Date localDate2 = ((DateFormat)a.get()).parse(paramString);
      return localDate2;
    }
    catch (ParseException localParseException1)
    {
      while (true)
      {
        int j;
        Object localObject2;
        synchronized (b)
        {
          int i = b.length;
          j = 0;
          if (j >= i)
            break;
          localObject2 = c[j];
          if (localObject2 == null)
          {
            localObject2 = new SimpleDateFormat(b[j], Locale.US);
            c[j] = localObject2;
          }
        }
        try
        {
          Date localDate1 = ((DateFormat)localObject2).parse(paramString);
          monitorexit;
          return localDate1;
          localObject1 = finally;
          monitorexit;
          throw localObject1;
        }
        catch (ParseException localParseException2)
        {
          j++;
        }
      }
      monitorexit;
    }
    return (Date)null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.a.e
 * JD-Core Version:    0.6.0
 */