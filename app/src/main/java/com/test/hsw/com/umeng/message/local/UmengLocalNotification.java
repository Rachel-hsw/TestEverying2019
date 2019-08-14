package com.umeng.message.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.PushAgent;
import com.umeng.message.b.dl;
import java.io.Serializable;
import java.util.Calendar;

public class UmengLocalNotification
  implements Serializable
{
  public static final int CHINESE_NEW_YEAR = 3;
  public static final int CHINESE_NEW_YEAR_EVE = 2;
  public static final int CHUNG_YEUNG_FESTIVAL = 11;
  public static final int DRAGON_BOAT_FESTIVAL = 7;
  public static final int LABA_FESTIVAL = 12;
  public static final int LABOR_DAY = 6;
  public static final int LANTERN = 4;
  public static final int MID_AUTUMN_FESTIVAL = 9;
  public static final int NATIONAL_DAY = 10;
  public static final int NEW_YEAR_DAY = 1;
  public static final int QINGMING_FESTIVAL = 5;
  public static final int QIXI_FESTIVAL = 8;
  public static final int REPEATING_UNIT_DAY = 3;
  public static final int REPEATING_UNIT_HOUR = 4;
  public static final int REPEATING_UNIT_MINUTE = 5;
  public static final int REPEATING_UNIT_MONTH = 2;
  public static final int REPEATING_UNIT_SECOND = 6;
  public static final int REPEATING_UNIT_YEAR = 1;
  private static final long a = -1080206884562188471L;
  private static final String b = UmengLocalNotification.class.getName();
  private static final String c = "id";
  private static final String d = "year";
  private static final String e = "month";
  private static final String f = "day";
  private static final String g = "hour";
  private static final String h = "minute";
  private static final String i = "second";
  private static final String j = "repeating_num";
  private static final String k = "repeating_unit";
  private static final String l = "repeating_interval";
  private static final String m = "special_day";
  private static final String n = "title";
  private static final String o = "content";
  private static final String p = "ticker";
  private int A;
  private int B;
  private int C;
  private int D;
  private String E;
  private String F;
  private String G;
  private UmengNotificationBuilder H;
  private String q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;

  public UmengLocalNotification()
  {
    this.q = dl.b();
    Calendar localCalendar = Calendar.getInstance();
    this.r = localCalendar.get(1);
    this.t = (1 + localCalendar.get(2));
    this.v = (1 + localCalendar.get(5));
    this.x = 12;
    this.y = 0;
    this.z = 0;
    this.A = 1;
    this.B = 3;
    this.C = 1;
    this.D = 0;
    this.E = "test";
    this.F = "test message";
    this.G = "test";
    this.H = new UmengNotificationBuilder(this.q);
  }

  public UmengLocalNotification(Cursor paramCursor)
  {
    if (paramCursor == null)
      return;
    this.q = paramCursor.getString(paramCursor.getColumnIndex("id"));
    this.r = paramCursor.getInt(paramCursor.getColumnIndex("year"));
    this.t = paramCursor.getInt(paramCursor.getColumnIndex("month"));
    this.v = paramCursor.getInt(paramCursor.getColumnIndex("day"));
    this.x = paramCursor.getInt(paramCursor.getColumnIndex("hour"));
    this.y = paramCursor.getInt(paramCursor.getColumnIndex("minute"));
    this.z = paramCursor.getInt(paramCursor.getColumnIndex("second"));
    this.A = paramCursor.getInt(paramCursor.getColumnIndex("repeating_num"));
    this.B = paramCursor.getInt(paramCursor.getColumnIndex("repeating_unit"));
    this.C = paramCursor.getInt(paramCursor.getColumnIndex("repeating_interval"));
    this.D = paramCursor.getInt(paramCursor.getColumnIndex("special_day"));
    this.E = paramCursor.getString(paramCursor.getColumnIndex("title"));
    this.F = paramCursor.getString(paramCursor.getColumnIndex("content"));
    this.G = paramCursor.getString(paramCursor.getColumnIndex("ticker"));
    this.H = new UmengNotificationBuilder(this.q);
  }

  public String getContent()
  {
    return this.F;
  }

  public ContentValues getContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", this.q);
    localContentValues.put("year", Integer.valueOf(this.r));
    localContentValues.put("month", Integer.valueOf(this.t));
    localContentValues.put("day", Integer.valueOf(this.v));
    localContentValues.put("hour", Integer.valueOf(this.x));
    localContentValues.put("minute", Integer.valueOf(this.y));
    localContentValues.put("second", Integer.valueOf(this.z));
    localContentValues.put("repeating_num", Integer.valueOf(this.A));
    localContentValues.put("repeating_unit", Integer.valueOf(this.B));
    localContentValues.put("repeating_interval", Integer.valueOf(this.C));
    localContentValues.put("special_day", Integer.valueOf(this.D));
    localContentValues.put("title", this.E);
    localContentValues.put("content", this.F);
    localContentValues.put("ticker", this.G);
    return localContentValues;
  }

  public String getDateTime()
  {
    String str1 = "" + this.r + "-";
    String str2;
    String str3;
    label110: String str4;
    if (this.t < 10)
    {
      str2 = str1 + "0" + this.t + "-";
      if (this.v >= 10)
        break label262;
      str3 = str2 + "0" + this.v + " ";
      if (this.x >= 10)
        break label292;
      str4 = str3 + "0" + this.x + ":";
      label152: if (this.y >= 10)
        break label323;
    }
    label262: label292: label323: for (String str5 = str4 + "0" + this.y + ":"; ; str5 = str4 + this.y + ":")
    {
      if (this.z >= 10)
        break label355;
      return str5 + "0" + this.z;
      str2 = str1 + this.t + "-";
      break;
      str3 = str2 + this.v + " ";
      break label110;
      str4 = str3 + this.x + ":";
      break label152;
    }
    label355: return str5 + this.z;
  }

  public int getDay()
  {
    return this.v;
  }

  public int getHour()
  {
    return this.x;
  }

  public String getId()
  {
    return this.q;
  }

  public int getMinute()
  {
    return this.y;
  }

  public int getMonth()
  {
    return this.t;
  }

  public UmengNotificationBuilder getNotificationBuilder()
  {
    return this.H;
  }

  public int getRepeatingInterval()
  {
    return this.C;
  }

  public int getRepeatingNum()
  {
    return this.A;
  }

  public int getRepeatingUnit()
  {
    return this.B;
  }

  public String getRepeatingUnitName()
  {
    switch (this.B)
    {
    default:
      return "";
    case 1:
      return "年";
    case 2:
      return "月";
    case 3:
      return "日";
    case 4:
      return "小时";
    case 5:
      return "分钟";
    case 6:
    }
    return "秒";
  }

  public int getSecond()
  {
    return this.z;
  }

  public int getSpecialDay()
  {
    return this.D;
  }

  public String getSpecialDayName()
  {
    switch (this.D)
    {
    default:
      return "";
    case 1:
      return "New Year's Day";
    case 2:
      return "Chinese New Year's Eve";
    case 3:
      return "Chinese New Year";
    case 4:
      return "Lantern";
    case 5:
      return "Qing Ming Festival";
    case 6:
      return "Labor's Day";
    case 7:
      return "Dragon Boat Festival";
    case 8:
      return "Qixi Festival";
    case 9:
      return "Mid Autumn Festival";
    case 10:
      return "National Day";
    case 11:
      return "Chung Yeung Festival";
    case 12:
    }
    return "Laba Festival";
  }

  public String getTicker()
  {
    return this.G;
  }

  public String getTitle()
  {
    return this.E;
  }

  public int getYear()
  {
    return this.r;
  }

  public void setContent(String paramString)
  {
    this.F = paramString;
  }

  public void setDateTime(String paramString)
  {
    try
    {
      long l1 = UmengLocalNotificationHelper.getTimeFromDate(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l1);
      this.r = localCalendar.get(1);
      this.t = (1 + localCalendar.get(2));
      this.v = localCalendar.get(5);
      this.x = localCalendar.get(11);
      this.y = localCalendar.get(12);
      this.z = localCalendar.get(13);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Log.d(b, localException.toString());
    }
  }

  public void setDay(int paramInt)
  {
    this.v = paramInt;
  }

  public void setHour(int paramInt)
  {
    this.x = paramInt;
  }

  public void setLunarDateTime(String paramString)
  {
    try
    {
      setDateTime(UmengCalendar.lunarTosolar(paramString));
      return;
    }
    catch (Exception localException)
    {
      Log.d(b, localException.toString());
      localException.printStackTrace();
    }
  }

  public void setMinute(int paramInt)
  {
    this.y = paramInt;
  }

  public void setMonth(int paramInt)
  {
    this.t = paramInt;
  }

  public void setNotificationBuilder(UmengNotificationBuilder paramUmengNotificationBuilder)
  {
    if (!TextUtils.equals(this.q, paramUmengNotificationBuilder.getLocalNotificationId()))
    {
      Log.e(b, "localNotificationId for notificationBuilder is not equal");
      paramUmengNotificationBuilder.setLocalNotificationId(this.q);
    }
    this.H = paramUmengNotificationBuilder;
  }

  public void setRepeatingInterval(int paramInt)
  {
    this.C = paramInt;
  }

  public void setRepeatingNum(int paramInt)
  {
    this.A = paramInt;
  }

  public void setRepeatingUnit(int paramInt)
  {
    this.B = paramInt;
  }

  public void setSecond(int paramInt)
  {
    this.z = paramInt;
  }

  public void setSpecialDay(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 7))
      this.B = 1;
    this.D = paramInt;
  }

  public void setTicker(String paramString)
  {
    this.G = paramString;
  }

  public void setTitle(String paramString)
  {
    this.E = paramString;
  }

  public void setYear(int paramInt)
  {
    this.r = paramInt;
  }

  public boolean validateData(Context paramContext)
  {
    if (this.A < -1)
    {
      Log.d(b, "repeatingNum is isValid");
      return false;
    }
    if (this.C <= 0)
    {
      Log.d(b, "repeatingInterval is isValid");
      return false;
    }
    if ((this.B < 1) || (this.B > 6))
    {
      Log.d(b, "repeatingUnit is isValid");
      return false;
    }
    if ((PushAgent.getInstance(paramContext).getLocalNotificationIntervalLimit()) && (((this.B == 6) && (this.C < 600)) || ((this.B == 5) && (this.C < 10))))
    {
      Log.d(b, "repeatingInterval is less than 10 minutes for limit");
      return false;
    }
    return true;
  }

  public boolean validateDateTime()
  {
    if ((this.D < 0) || (this.D > 12))
    {
      Log.d(b, "specialDay is isValid");
      return false;
    }
    int i1 = Calendar.getInstance().get(1);
    if (this.r < i1)
    {
      Log.d(b, "year is isValid");
      return false;
    }
    if ((this.t < 1) || (this.t > 12))
    {
      Log.d(b, "month is isValid");
      return false;
    }
    if ((this.v < 1) || (this.v > 31))
    {
      Log.d(b, "day is isValid");
      return false;
    }
    switch (this.t)
    {
    case 3:
    case 5:
    case 7:
    case 8:
    case 10:
    default:
    case 4:
    case 6:
    case 9:
    case 11:
    case 2:
    }
    while ((this.x < 0) || (this.x > 23))
    {
      Log.d(b, "hour is isValid");
      return false;
      if (this.v <= 30)
        continue;
      Log.d(b, "dateTime: day is invalid");
      return false;
      if (((this.r % 4 == 0) && (this.r % 100 != 0)) || (this.r % 400 == 0))
      {
        if (this.v <= 29)
          continue;
        Log.d(b, "dateTime: day is invalid");
        return false;
      }
      if (this.v <= 28)
        continue;
      Log.d(b, "dateTime: day is invalid");
      return false;
    }
    if ((this.y < 0) || (this.y > 59))
    {
      Log.d(b, "minute is isValid");
      return false;
    }
    if ((this.z < 0) || (this.z > 59))
    {
      Log.d(b, "second is isValid");
      return false;
    }
    if ((this.D >= 1) && (this.D <= 12))
    {
      long l3 = 0L;
      long l4 = System.currentTimeMillis();
      try
      {
        int i2 = this.D;
        switch (i2)
        {
        default:
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
        case 12:
        }
        label642: label687: label1114: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          Calendar localCalendar = Calendar.getInstance();
                          localCalendar.setTimeInMillis(l3);
                          this.r = localCalendar.get(1);
                          this.t = (1 + localCalendar.get(2));
                          this.v = localCalendar.get(5);
                          this.x = localCalendar.get(11);
                          this.y = localCalendar.get(12);
                          this.z = localCalendar.get(13);
                          Log.d(b, "year=" + this.r + ",month=" + this.t + ",day=" + this.v + ",specialDay=" + this.D);
                          return true;
                          StringBuilder localStringBuilder7 = new StringBuilder(String.valueOf(this.r + "-01-01 "));
                          Object localObject7;
                          Object localObject8;
                          StringBuilder localStringBuilder9;
                          if (this.x >= 10)
                          {
                            localObject7 = Integer.valueOf(this.x);
                            StringBuilder localStringBuilder8 = new StringBuilder(String.valueOf(localObject7 + ":"));
                            if (this.y < 10)
                              break label791;
                            localObject8 = Integer.valueOf(this.y);
                            localStringBuilder9 = new StringBuilder(String.valueOf(localObject8 + ":"));
                            if (this.z < 10)
                              break label815;
                          }
                          for (Object localObject9 = Integer.valueOf(this.z); ; localObject9 = "0" + this.z)
                          {
                            l3 = UmengLocalNotificationHelper.getTimeFromDate(localObject9);
                            if (l3 >= l4)
                              break;
                            Log.d(b, "元旦的开始年份小于当前时间，请重新设置");
                            return false;
                            localObject7 = "0" + this.x;
                            break label642;
                            localObject8 = "0" + this.y;
                            break label687;
                          }
                          this.t = 12;
                          this.v = UmengCalendar.iGetLMonthDays(this.r, 12);
                          l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
                        }
                        while (l3 >= l4);
                        Log.d(b, "除夕的开始年份小于当前时间，请重新设置");
                        return false;
                        this.t = 1;
                        this.v = 1;
                        l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
                      }
                      while (l3 >= l4);
                      Log.d(b, "春节的开始年份小于当前时间，请重新设置");
                      return false;
                      this.t = 1;
                      this.v = 15;
                      l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
                    }
                    while (l3 >= l4);
                    Log.d(b, "元宵节的开始年份小于当前时间，请重新设置");
                    return false;
                    l3 = UmengLocalNotificationHelper.getQingMingTime(this.r, this.x, this.y, this.z);
                  }
                  while (l3 >= l4);
                  Log.d(b, "清明的开始年份小于当前时间，请重新设置");
                  return false;
                  StringBuilder localStringBuilder4 = new StringBuilder(String.valueOf(this.r + "-05-01 "));
                  Object localObject4;
                  Object localObject5;
                  StringBuilder localStringBuilder6;
                  if (this.x >= 10)
                  {
                    localObject4 = Integer.valueOf(this.x);
                    StringBuilder localStringBuilder5 = new StringBuilder(String.valueOf(localObject4 + ":"));
                    if (this.y < 10)
                      break label1218;
                    localObject5 = Integer.valueOf(this.y);
                    localStringBuilder6 = new StringBuilder(String.valueOf(localObject5 + ":"));
                    if (this.z < 10)
                      break label1242;
                  }
                  for (Object localObject6 = Integer.valueOf(this.z); ; localObject6 = "0" + this.z)
                  {
                    l3 = UmengLocalNotificationHelper.getTimeFromDate(localObject6);
                    if (l3 >= l4)
                      break;
                    Log.d(b, "五一劳动节的开始年份小于当前时间，请重新设置");
                    return false;
                    localObject4 = "0" + this.x;
                    break label1069;
                    localObject5 = "0" + this.y;
                    break label1114;
                  }
                  this.t = 5;
                  this.v = 5;
                  l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
                }
                while (l3 >= l4);
                Log.d(b, "端午节的开始年份小于当前时间，请重新设置");
                return false;
                this.t = 7;
                this.v = 7;
                l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
              }
              while (l3 >= l4);
              Log.d(b, "七夕节的开始年份小于当前时间，请重新设置");
              return false;
              this.t = 8;
              this.v = 15;
              l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
            }
            while (l3 >= l4);
            Log.d(b, "春节的开始年份小于当前时间，请重新设置");
            return false;
            StringBuilder localStringBuilder1 = new StringBuilder(String.valueOf(this.r + "-10-01 "));
            Object localObject1;
            Object localObject2;
            StringBuilder localStringBuilder3;
            if (this.x >= 10)
            {
              localObject1 = Integer.valueOf(this.x);
              StringBuilder localStringBuilder2 = new StringBuilder(String.valueOf(localObject1 + ":"));
              if (this.y < 10)
                break label1598;
              localObject2 = Integer.valueOf(this.y);
              localStringBuilder3 = new StringBuilder(String.valueOf(localObject2 + ":"));
              if (this.z < 10)
                break label1622;
            }
            for (Object localObject3 = Integer.valueOf(this.z); ; localObject3 = "0" + this.z)
            {
              l3 = UmengLocalNotificationHelper.getTimeFromDate(localObject3);
              if (l3 >= l4)
                break;
              Log.d(b, "国庆节的开始年份小于当前时间，请重新设置");
              return false;
              localObject1 = "0" + this.x;
              break label1449;
              localObject2 = "0" + this.y;
              break label1494;
            }
            this.t = 9;
            this.v = 9;
            l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
          }
          while (l3 >= l4);
          Log.d(b, "清明节的开始年份小于当前时间，请重新设置");
          return false;
          this.t = 12;
          this.v = 8;
          l3 = UmengLocalNotificationHelper.getTimeFromDate(UmengCalendar.lunarTosolar(getDateTime()));
        }
        while (l3 >= l4);
        label791: label815: label1218: label1242: Log.d(b, "腊八节的开始年份小于当前时间，请重新设置");
        label1069: label1494: return false;
      }
      catch (Exception localException2)
      {
        while (true)
          label1449: label1598: label1622: localException2.printStackTrace();
      }
    }
    long l1 = 0L;
    try
    {
      long l2 = UmengLocalNotificationHelper.getTimeFromDate(getDateTime());
      l1 = l2;
      if (l1 < System.currentTimeMillis())
      {
        Log.d(b, "dateTime: date time is invalid");
        return false;
      }
    }
    catch (Exception localException1)
    {
      while (true)
        localException1.printStackTrace();
    }
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.message.local.UmengLocalNotification
 * JD-Core Version:    0.6.0
 */