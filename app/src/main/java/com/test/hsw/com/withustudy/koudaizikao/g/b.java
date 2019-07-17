package com.withustudy.koudaizikao.g;

import android.content.Context;
import android.content.res.Resources;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class b
{
  public static final long a = 1000L;
  public static final long b = 60000L;
  public static final long c = 3600000L;
  public static final long d = 86400000L;
  public static final long e = 604800000L;
  public static final long f = 2592000000L;
  public static final long g = 31104000000L;
  public static final int h = 60;

  public static long a(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return 0L;
  }

  public static long a(String paramString1, String paramString2)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date localDate = localSimpleDateFormat.parse(paramString1);
      long l = (localSimpleDateFormat.parse(paramString2).getTime() - localDate.getTime()) / 86400000L;
      return l;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return 0L;
  }

  public static String a()
  {
    return new SimpleDateFormat("HH:mm:ss").format(new Date());
  }

  public static String a(int paramInt1, int paramInt2)
  {
    int m;
    switch (paramInt1)
    {
    default:
      return "";
    case 0:
      if (paramInt2 < 60)
        break;
      m = paramInt2 % 60;
    case 1:
    }
    try
    {
      int n = paramInt2 / 60;
      if (n >= 60)
      {
        int i1 = n % 60;
        return n / 60 + "时" + i1 + "分" + m + "秒";
      }
      return n + "分" + m + "秒";
      return paramInt2 + "秒";
      if (paramInt2 >= 60)
      {
        int i = paramInt2 % 60;
        int j = paramInt2 / 60;
        if (j >= 60)
        {
          int k = j % 60;
          return c(new StringBuilder(String.valueOf(j / 60)).toString()) + ":" + c(new StringBuilder(String.valueOf(k)).toString()) + ":" + c(new StringBuilder(String.valueOf(i)).toString());
        }
        return c("") + ":" + c(new StringBuilder(String.valueOf(j)).toString()) + ":" + c(new StringBuilder(String.valueOf(i)).toString());
      }
      String str = c("") + ":" + c("") + ":" + c(new StringBuilder(String.valueOf(paramInt2)).toString());
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String a(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
  }

  public static String a(long paramLong, boolean paramBoolean)
  {
    Date localDate = new Date(paramLong);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    if (paramBoolean);
    for (SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("M月d日"); ; localSimpleDateFormat = new SimpleDateFormat("M月"))
      return localSimpleDateFormat.format(localCalendar.getTime());
  }

  public static String a(Context paramContext, long paramLong)
  {
    long l = System.currentTimeMillis() - paramLong;
    if (l <= 86400000L)
      return paramContext.getResources().getString(2131165468);
    if ((l > 86400000L) && (l <= 172800000L))
      return paramContext.getResources().getString(2131165469);
    if ((l > 172800000L) && (l <= 604800000L))
      return a(l, true);
    if ((l > 604800000L) && (l <= 1209600000L))
      return paramContext.getResources().getString(2131165470);
    if ((l > 1209600000L) && (l <= 2592000000L))
      return a(l, true);
    return a(l, false);
  }

  public static String b()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
  }

  public static String b(int paramInt1, int paramInt2)
  {
    int m;
    switch (paramInt1)
    {
    default:
      return "";
    case 0:
      if (paramInt2 < 60)
        break;
      m = paramInt2 % 60;
    case 1:
    }
    try
    {
      int n = paramInt2 / 60;
      if (n >= 60)
      {
        int i1 = n % 60;
        return n / 60 + "时" + i1 + "分" + m + "秒";
      }
      return n + "分" + m + "秒";
      return paramInt2 + "秒";
      if (paramInt2 >= 60)
      {
        int i = paramInt2 % 60;
        int j = paramInt2 / 60;
        if (j >= 60)
        {
          int k = j % 60;
          return c(new StringBuilder(String.valueOf(j / 60)).toString()) + ":" + c(new StringBuilder(String.valueOf(k)).toString()) + ":" + c(new StringBuilder(String.valueOf(i)).toString());
        }
        return c("") + ":" + c(new StringBuilder(String.valueOf(j)).toString()) + ":" + c(new StringBuilder(String.valueOf(i)).toString());
      }
      String str = c("") + ":" + c("") + ":" + c(new StringBuilder(String.valueOf(paramInt2)).toString());
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public static String b(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
  }

  public static String b(Context paramContext, long paramLong)
  {
    long l1 = System.currentTimeMillis() - paramLong;
    if (l1 < 60000L)
    {
      long l2 = l1 / 1000L;
      if (l2 == 0L)
        return "刚刚";
      return (int)l2 + paramContext.getResources().getString(2131165497);
    }
    if ((l1 >= 60000L) && (l1 < 3600000L))
      return (int)(l1 / 60000L) + paramContext.getResources().getString(2131165498);
    if ((l1 >= 3600000L) && (l1 < 86400000L))
      return (int)(l1 / 3600000L) + paramContext.getResources().getString(2131165499);
    if ((l1 >= 86400000L) && (l1 < 2592000000L))
      return (int)(l1 / 86400000L) + paramContext.getResources().getString(2131165500);
    if ((l1 >= 2592000000L) && (l1 < 31104000000L))
      return (int)(l1 / 2592000000L) + paramContext.getResources().getString(2131165501);
    return (int)(l1 / 31104000000L) + paramContext.getResources().getString(2131165502);
  }

  public static String b(String paramString)
  {
    String str = "";
    try
    {
      Date localDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString);
      long l1 = (System.currentTimeMillis() - localDate.getTime()) / 60000L;
      str = l1 + "分钟前";
      if (l1 < 2L)
        str = "刚刚";
      long l2 = l1 / 60L / 24L;
      if ((l1 > 60L) && (l2 < 1L))
        str = l1 / 60L + "小时前";
      if (l2 > 0L)
        str = l2 + "天前";
      if (l2 == 1L)
        str = "昨天";
      return str;
    }
    catch (Exception localException)
    {
    }
    return str;
  }

  public static String c(long paramLong)
  {
    return new SimpleDateFormat("HH:mm:ss").format(new Date(paramLong));
  }

  public static String c(String paramString)
  {
    if (paramString == null)
      return "00";
    int i;
    do
    {
      try
      {
        i = paramString.length();
        if (i < 2)
          continue;
        return paramString.substring(0, 2);
        if (i == 1)
        {
          String str = "0" + paramString;
          return str;
        }
      }
      catch (Exception localException)
      {
      }
      return "";
    }
    while (i != 0);
    return "00";
  }

  public static String d(String paramString)
  {
    if (paramString == null)
      return "00";
    try
    {
      int i = paramString.length();
      if (i >= 2)
        break label55;
      if (i == 0)
        return "00";
      if (i == 1)
      {
        String str = "0" + paramString;
        return str;
      }
    }
    catch (Exception localException)
    {
      return "";
    }
    paramString = "";
    label55: return paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.b
 * JD-Core Version:    0.6.0
 */