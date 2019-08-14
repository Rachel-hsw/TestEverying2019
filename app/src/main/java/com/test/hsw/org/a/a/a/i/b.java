package org.a.a.a.i;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class b
{
  public static final long a = 1000L;
  public static final long b = 60000L;
  public static final long c = 3600000L;
  public static final long d = 86400000L;
  public static final int e = 1001;
  public static final int f = 1;
  public static final int g = 2;
  public static final int h = 3;
  public static final int i = 4;
  public static final int j = 5;
  public static final int k = 6;
  private static final int[][] l = { { 14 }, { 13 }, { 12 }, { 11, 10 }, { 5, 5, 9 }, { 2, 1001 }, { 1 }, { 0 } };
  private static final int m = 0;
  private static final int n = 1;
  private static final int o = 2;

  private static long a(int paramInt)
  {
    switch (paramInt)
    {
    case 7:
    case 8:
    case 9:
    case 10:
    default:
      throw new IllegalArgumentException("The unit " + paramInt + " cannot be represented is milleseconds");
    case 5:
    case 6:
      return 86400000L;
    case 11:
      return 3600000L;
    case 12:
      return 60000L;
    case 13:
      return 1000L;
    case 14:
    }
    return 1L;
  }

  public static Calendar a(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    a(localCalendar, paramInt, 1);
    return localCalendar;
  }

  public static Calendar a(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar;
  }

  public static Date a(Object paramObject, int paramInt)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("The date must not be null");
    if ((paramObject instanceof Date))
      return p((Date)paramObject, paramInt);
    if ((paramObject instanceof Calendar))
      return a((Calendar)paramObject, paramInt).getTime();
    throw new ClassCastException("Could not round " + paramObject);
  }

  public static Date a(String paramString, String[] paramArrayOfString)
    throws ParseException
  {
    return a(paramString, paramArrayOfString, true);
  }

  private static Date a(String paramString, String[] paramArrayOfString, boolean paramBoolean)
    throws ParseException
  {
    if ((paramString == null) || (paramArrayOfString == null))
      throw new IllegalArgumentException("Date and Patterns must not be null");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
    localSimpleDateFormat.setLenient(paramBoolean);
    ParsePosition localParsePosition = new ParsePosition(0);
    int i1 = paramArrayOfString.length;
    int i2 = 0;
    String str1;
    if (i2 < i1)
    {
      str1 = paramArrayOfString[i2];
      if (!str1.endsWith("ZZ"))
        break label189;
    }
    label189: for (String str2 = str1.substring(0, -1 + str1.length()); ; str2 = str1)
    {
      localSimpleDateFormat.applyPattern(str2);
      localParsePosition.setIndex(0);
      if (str1.endsWith("ZZ"));
      for (String str3 = paramString.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2"); ; str3 = paramString)
      {
        Date localDate = localSimpleDateFormat.parse(str3, localParsePosition);
        if ((localDate != null) && (localParsePosition.getIndex() == str3.length()))
          return localDate;
        i2++;
        break;
        throw new ParseException("Unable to parse the date: " + paramString, -1);
      }
    }
  }

  public static Date a(Date paramDate, int paramInt)
  {
    return a(paramDate, 1, paramInt);
  }

  private static Date a(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    localCalendar.add(paramInt1, paramInt2);
    return localCalendar.getTime();
  }

  private static void a(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    if (paramCalendar.get(1) > 280000000)
      throw new ArithmeticException("Calendar value too large for accurate calculations");
    if (paramInt1 == 14)
      return;
    Date localDate = paramCalendar.getTime();
    long l1 = localDate.getTime();
    int i1 = paramCalendar.get(14);
    if ((paramInt2 == 0) || (i1 < 500))
      l1 -= i1;
    int i2 = 0;
    if (paramInt1 == 13)
      i2 = 1;
    int i3 = paramCalendar.get(13);
    if ((i2 == 0) && ((paramInt2 == 0) || (i3 < 30)))
      l1 -= 1000L * i3;
    if (paramInt1 == 12)
      i2 = 1;
    int i4 = paramCalendar.get(12);
    long l2;
    if ((i2 == 0) && ((paramInt2 == 0) || (i4 < 30)))
      l2 = l1 - 60000L * i4;
    while (true)
    {
      if (localDate.getTime() != l2)
      {
        localDate.setTime(l2);
        paramCalendar.setTime(localDate);
      }
      int i5 = 0;
      int[][] arrayOfInt = l;
      int i6 = arrayOfInt.length;
      int i7 = 0;
      if (i7 < i6)
      {
        int[] arrayOfInt1 = arrayOfInt[i7];
        int i8 = arrayOfInt1.length;
        for (int i9 = 0; ; i9++)
        {
          if (i9 >= i8)
            break label342;
          if (arrayOfInt1[i9] != paramInt1)
            continue;
          if ((paramInt2 != 2) && ((paramInt2 != 1) || (i5 == 0)))
            break;
          if (paramInt1 == 1001)
          {
            if (paramCalendar.get(5) == 1)
            {
              paramCalendar.add(5, 15);
              return;
            }
            paramCalendar.add(5, -15);
            paramCalendar.add(2, 1);
            return;
          }
          if (paramInt1 == 9)
          {
            if (paramCalendar.get(11) == 0)
            {
              paramCalendar.add(11, 12);
              return;
            }
            paramCalendar.add(11, -12);
            paramCalendar.add(5, 1);
            return;
          }
          paramCalendar.add(arrayOfInt1[0], 1);
          return;
        }
        label342: label368: int i13;
        int i12;
        int i14;
        int i17;
        switch (paramInt1)
        {
        default:
          i13 = 0;
          i12 = i5;
          i14 = 0;
          if (i14 != 0)
            break;
          int i15 = paramCalendar.getActualMinimum(arrayOfInt1[0]);
          int i16 = paramCalendar.getActualMaximum(arrayOfInt1[0]);
          i17 = paramCalendar.get(arrayOfInt1[0]) - i15;
          if (i17 <= (i16 - i15) / 2);
        case 1001:
        case 9:
        }
        for (int i18 = 1; ; i18 = 0)
        {
          i12 = i18;
          i13 = i17;
          if (i13 != 0)
            paramCalendar.set(arrayOfInt1[0], paramCalendar.get(arrayOfInt1[0]) - i13);
          i7++;
          i5 = i12;
          break;
          if (arrayOfInt1[0] != 5)
            break label368;
          int i19 = -1 + paramCalendar.get(5);
          if (i19 >= 15)
            i19 -= 15;
          if (i19 > 7);
          for (int i20 = 1; ; i20 = 0)
          {
            i12 = i20;
            i13 = i19;
            i14 = 1;
            break;
          }
          if (arrayOfInt1[0] != 11)
            break label368;
          int i10 = paramCalendar.get(11);
          if (i10 >= 12)
            i10 -= 12;
          if (i10 >= 6);
          for (int i11 = 1; ; i11 = 0)
          {
            i12 = i11;
            i13 = i10;
            i14 = 1;
            break;
          }
        }
      }
      throw new IllegalArgumentException("The field " + paramInt1 + " is not supported");
      l2 = l1;
    }
  }

  public static boolean a(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null))
      throw new IllegalArgumentException("The date must not be null");
    return (paramCalendar1.get(0) == paramCalendar2.get(0)) && (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(6) == paramCalendar2.get(6));
  }

  public static boolean a(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt)
  {
    return b(paramCalendar1, paramCalendar2, paramInt) == 0;
  }

  public static boolean a(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 == null) || (paramDate2 == null))
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(paramDate1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(paramDate2);
    return a(localCalendar1, localCalendar2);
  }

  public static boolean a(Date paramDate1, Date paramDate2, int paramInt)
  {
    return b(paramDate1, paramDate2, paramInt) == 0;
  }

  public static int b(Calendar paramCalendar1, Calendar paramCalendar2, int paramInt)
  {
    return b(paramCalendar1, paramInt).compareTo(b(paramCalendar2, paramInt));
  }

  public static int b(Date paramDate1, Date paramDate2, int paramInt)
  {
    return q(paramDate1, paramInt).compareTo(q(paramDate2, paramInt));
  }

  private static long b(Calendar paramCalendar, int paramInt1, int paramInt2)
  {
    if (paramCalendar == null)
      throw new IllegalArgumentException("The date must not be null");
    long l1 = a(paramInt2);
    long l2 = 0L;
    switch (paramInt1)
    {
    default:
    case 1:
    case 2:
    }
    while (true)
      switch (paramInt1)
      {
      case 3:
      case 4:
      case 7:
      case 8:
      case 9:
      case 10:
      default:
        throw new IllegalArgumentException("The fragment " + paramInt1 + " is not supported");
        l2 += 86400000L * paramCalendar.get(6) / l1;
        continue;
        l2 += 86400000L * paramCalendar.get(5) / l1;
      case 1:
      case 2:
      case 5:
      case 6:
      case 11:
      case 12:
      case 13:
      case 14:
      }
    l2 += 3600000L * paramCalendar.get(11) / l1;
    l2 += 60000L * paramCalendar.get(12) / l1;
    l2 += 1000L * paramCalendar.get(13) / l1;
    l2 += 1 * paramCalendar.get(14) / l1;
    return l2;
  }

  public static Calendar b(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    a(localCalendar, paramInt, 0);
    return localCalendar;
  }

  public static Date b(Object paramObject, int paramInt)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("The date must not be null");
    if ((paramObject instanceof Date))
      return q((Date)paramObject, paramInt);
    if ((paramObject instanceof Calendar))
      return b((Calendar)paramObject, paramInt).getTime();
    throw new ClassCastException("Could not truncate " + paramObject);
  }

  public static Date b(String paramString, String[] paramArrayOfString)
    throws ParseException
  {
    return a(paramString, paramArrayOfString, false);
  }

  public static Date b(Date paramDate, int paramInt)
  {
    return a(paramDate, 2, paramInt);
  }

  private static Date b(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setLenient(false);
    localCalendar.setTime(paramDate);
    localCalendar.set(paramInt1, paramInt2);
    return localCalendar.getTime();
  }

  public static boolean b(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null))
      throw new IllegalArgumentException("The date must not be null");
    return paramCalendar1.getTime().getTime() == paramCalendar2.getTime().getTime();
  }

  public static boolean b(Date paramDate1, Date paramDate2)
  {
    if ((paramDate1 == null) || (paramDate2 == null))
      throw new IllegalArgumentException("The date must not be null");
    return paramDate1.getTime() == paramDate2.getTime();
  }

  private static long c(Date paramDate, int paramInt1, int paramInt2)
  {
    if (paramDate == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return b(localCalendar, paramInt1, paramInt2);
  }

  public static Calendar c(Calendar paramCalendar, int paramInt)
  {
    if (paramCalendar == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = (Calendar)paramCalendar.clone();
    a(localCalendar, paramInt, 2);
    return localCalendar;
  }

  public static Date c(Object paramObject, int paramInt)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("The date must not be null");
    if ((paramObject instanceof Date))
      return r((Date)paramObject, paramInt);
    if ((paramObject instanceof Calendar))
      return c((Calendar)paramObject, paramInt).getTime();
    throw new ClassCastException("Could not find ceiling of for type: " + paramObject.getClass());
  }

  public static Date c(Date paramDate, int paramInt)
  {
    return a(paramDate, 3, paramInt);
  }

  public static boolean c(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    if ((paramCalendar1 == null) || (paramCalendar2 == null))
      throw new IllegalArgumentException("The date must not be null");
    return (paramCalendar1.get(14) == paramCalendar2.get(14)) && (paramCalendar1.get(13) == paramCalendar2.get(13)) && (paramCalendar1.get(12) == paramCalendar2.get(12)) && (paramCalendar1.get(11) == paramCalendar2.get(11)) && (paramCalendar1.get(6) == paramCalendar2.get(6)) && (paramCalendar1.get(1) == paramCalendar2.get(1)) && (paramCalendar1.get(0) == paramCalendar2.get(0)) && (paramCalendar1.getClass() == paramCalendar2.getClass());
  }

  public static Date d(Date paramDate, int paramInt)
  {
    return a(paramDate, 5, paramInt);
  }

  public static Iterator<?> d(Object paramObject, int paramInt)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("The date must not be null");
    if ((paramObject instanceof Date))
      return s((Date)paramObject, paramInt);
    if ((paramObject instanceof Calendar))
      return d((Calendar)paramObject, paramInt);
    throw new ClassCastException("Could not iterate based on " + paramObject);
  }

  public static Iterator<Calendar> d(Calendar paramCalendar, int paramInt)
  {
    int i1 = 2;
    if (paramCalendar == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar3;
    Calendar localCalendar4;
    Calendar localCalendar1;
    Calendar localCalendar2;
    int i2;
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("The range style " + paramInt + " is not valid.");
    case 5:
    case 6:
      localCalendar3 = b(paramCalendar, i1);
      localCalendar4 = (Calendar)localCalendar3.clone();
      localCalendar4.add(i1, 1);
      localCalendar4.add(5, -1);
      if (paramInt != 6)
        break;
      localCalendar1 = localCalendar3;
      localCalendar2 = localCalendar4;
      i2 = 1;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      if (i1 < 1)
        i1 += 7;
      if (i1 > 7)
        i1 -= 7;
      if (i2 < 1)
        i2 += 7;
      if (i2 > 7)
        i2 -= 7;
      while (true)
        if (localCalendar1.get(7) != i1)
        {
          localCalendar1.add(5, -1);
          continue;
          localCalendar1 = b(paramCalendar, 5);
          localCalendar2 = b(paramCalendar, 5);
          switch (paramInt)
          {
          default:
            i2 = 7;
            i1 = 1;
            break;
          case 1:
            i2 = 7;
            i1 = 1;
            break;
          case 2:
            i2 = 1;
            break;
          case 3:
            i1 = paramCalendar.get(7);
            i2 = i1 - 1;
            break;
          case 4:
            i1 = -3 + paramCalendar.get(7);
            i2 = 3 + paramCalendar.get(7);
            break;
          }
        }
      while (localCalendar2.get(7) != i2)
        localCalendar2.add(5, 1);
      return new a(localCalendar1, localCalendar2);
      i1 = 1;
      localCalendar1 = localCalendar3;
      localCalendar2 = localCalendar4;
      i2 = 7;
    }
  }

  public static long e(Calendar paramCalendar, int paramInt)
  {
    return b(paramCalendar, paramInt, 14);
  }

  public static Date e(Date paramDate, int paramInt)
  {
    return a(paramDate, 11, paramInt);
  }

  public static long f(Calendar paramCalendar, int paramInt)
  {
    return b(paramCalendar, paramInt, 13);
  }

  public static Date f(Date paramDate, int paramInt)
  {
    return a(paramDate, 12, paramInt);
  }

  public static long g(Calendar paramCalendar, int paramInt)
  {
    return b(paramCalendar, paramInt, 12);
  }

  public static Date g(Date paramDate, int paramInt)
  {
    return a(paramDate, 13, paramInt);
  }

  public static long h(Calendar paramCalendar, int paramInt)
  {
    return b(paramCalendar, paramInt, 11);
  }

  public static Date h(Date paramDate, int paramInt)
  {
    return a(paramDate, 14, paramInt);
  }

  public static long i(Calendar paramCalendar, int paramInt)
  {
    return b(paramCalendar, paramInt, 6);
  }

  public static Date i(Date paramDate, int paramInt)
  {
    return b(paramDate, 1, paramInt);
  }

  public static Date j(Date paramDate, int paramInt)
  {
    return b(paramDate, 2, paramInt);
  }

  public static Date k(Date paramDate, int paramInt)
  {
    return b(paramDate, 5, paramInt);
  }

  public static Date l(Date paramDate, int paramInt)
  {
    return b(paramDate, 11, paramInt);
  }

  public static Date m(Date paramDate, int paramInt)
  {
    return b(paramDate, 12, paramInt);
  }

  public static Date n(Date paramDate, int paramInt)
  {
    return b(paramDate, 13, paramInt);
  }

  public static Date o(Date paramDate, int paramInt)
  {
    return b(paramDate, 14, paramInt);
  }

  public static Date p(Date paramDate, int paramInt)
  {
    if (paramDate == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    a(localCalendar, paramInt, 1);
    return localCalendar.getTime();
  }

  public static Date q(Date paramDate, int paramInt)
  {
    if (paramDate == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    a(localCalendar, paramInt, 0);
    return localCalendar.getTime();
  }

  public static Date r(Date paramDate, int paramInt)
  {
    if (paramDate == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    a(localCalendar, paramInt, 2);
    return localCalendar.getTime();
  }

  public static Iterator<Calendar> s(Date paramDate, int paramInt)
  {
    if (paramDate == null)
      throw new IllegalArgumentException("The date must not be null");
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return d(localCalendar, paramInt);
  }

  public static long t(Date paramDate, int paramInt)
  {
    return c(paramDate, paramInt, 14);
  }

  public static long u(Date paramDate, int paramInt)
  {
    return c(paramDate, paramInt, 13);
  }

  public static long v(Date paramDate, int paramInt)
  {
    return c(paramDate, paramInt, 12);
  }

  public static long w(Date paramDate, int paramInt)
  {
    return c(paramDate, paramInt, 11);
  }

  public static long x(Date paramDate, int paramInt)
  {
    return c(paramDate, paramInt, 6);
  }

  static class a
    implements Iterator<Calendar>
  {
    private final Calendar a;
    private final Calendar b;

    a(Calendar paramCalendar1, Calendar paramCalendar2)
    {
      this.a = paramCalendar2;
      this.b = paramCalendar1;
      this.b.add(5, -1);
    }

    public Calendar a()
    {
      if (this.b.equals(this.a))
        throw new NoSuchElementException();
      this.b.add(5, 1);
      return (Calendar)this.b.clone();
    }

    public boolean hasNext()
    {
      return this.b.before(this.a);
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.i.b
 * JD-Core Version:    0.6.0
 */