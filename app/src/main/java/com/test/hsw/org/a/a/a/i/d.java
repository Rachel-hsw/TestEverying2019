package org.a.a.a.i;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.a.a.a.x;

public class d extends Format
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private static final long e = 1L;
  private static final f<d> f = new e();
  private static ConcurrentMap<g, String> g = new ConcurrentHashMap(7);
  private final String h;
  private final TimeZone i;
  private final Locale j;
  private transient d[] k;
  private transient int l;

  protected d(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    this.h = paramString;
    this.i = paramTimeZone;
    this.j = paramLocale;
    g();
  }

  static String a(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
  {
    g localg = new g(paramTimeZone, paramBoolean, paramInt, paramLocale);
    String str1 = (String)g.get(localg);
    String str2;
    if (str1 == null)
    {
      str2 = paramTimeZone.getDisplayName(paramBoolean, paramInt, paramLocale);
      str1 = (String)g.putIfAbsent(localg, str2);
      if (str1 == null);
    }
    else
    {
      return str1;
    }
    return str2;
  }

  public static d a()
  {
    return (d)f.a(Integer.valueOf(3), Integer.valueOf(3), null, null);
  }

  public static d a(int paramInt)
  {
    return (d)f.a(Integer.valueOf(paramInt), null, null, null);
  }

  public static d a(int paramInt1, int paramInt2)
  {
    return (d)f.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null, null);
  }

  public static d a(int paramInt1, int paramInt2, Locale paramLocale)
  {
    return (d)f.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), null, paramLocale);
  }

  public static d a(int paramInt1, int paramInt2, TimeZone paramTimeZone)
  {
    return a(paramInt1, paramInt2, paramTimeZone, null);
  }

  public static d a(int paramInt1, int paramInt2, TimeZone paramTimeZone, Locale paramLocale)
  {
    return (d)f.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramTimeZone, paramLocale);
  }

  public static d a(int paramInt, Locale paramLocale)
  {
    return (d)f.a(Integer.valueOf(paramInt), null, null, paramLocale);
  }

  public static d a(int paramInt, TimeZone paramTimeZone)
  {
    return (d)f.a(Integer.valueOf(paramInt), null, paramTimeZone, null);
  }

  public static d a(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    return (d)f.a(Integer.valueOf(paramInt), null, paramTimeZone, paramLocale);
  }

  public static d a(String paramString)
  {
    return (d)f.c(paramString, null, null);
  }

  public static d a(String paramString, Locale paramLocale)
  {
    return (d)f.c(paramString, null, paramLocale);
  }

  public static d a(String paramString, TimeZone paramTimeZone)
  {
    return (d)f.c(paramString, paramTimeZone, null);
  }

  public static d a(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    return (d)f.c(paramString, paramTimeZone, paramLocale);
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    g();
  }

  public static d b(int paramInt)
  {
    return (d)f.a(null, Integer.valueOf(paramInt), null, null);
  }

  public static d b(int paramInt, Locale paramLocale)
  {
    return (d)f.a(null, Integer.valueOf(paramInt), null, paramLocale);
  }

  public static d b(int paramInt, TimeZone paramTimeZone)
  {
    return (d)f.a(null, Integer.valueOf(paramInt), paramTimeZone, null);
  }

  public static d b(int paramInt, TimeZone paramTimeZone, Locale paramLocale)
  {
    return (d)f.a(null, Integer.valueOf(paramInt), paramTimeZone, paramLocale);
  }

  private void g()
  {
    List localList = b();
    this.k = ((d[])localList.toArray(new d[localList.size()]));
    int m = 0;
    int n = this.k.length;
    while (true)
    {
      n--;
      if (n < 0)
        break;
      m += this.k[n].a();
    }
    this.l = m;
  }

  public String a(long paramLong)
  {
    return a(new Date(paramLong));
  }

  protected String a(String paramString, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramArrayOfInt[0];
    int n = paramString.length();
    char c1 = paramString.charAt(m);
    if (((c1 >= 'A') && (c1 <= 'Z')) || ((c1 >= 'a') && (c1 <= 'z')))
      localStringBuilder.append(c1);
    int i1;
    char c2;
    while (true)
      if ((m + 1 < n) && (paramString.charAt(m + 1) == c1))
      {
        localStringBuilder.append(c1);
        m++;
        continue;
        localStringBuilder.append('\'');
        i1 = 0;
        if (m < n)
        {
          c2 = paramString.charAt(m);
          if (c2 == '\'')
          {
            if ((m + 1 >= n) || (paramString.charAt(m + 1) != '\''))
              break;
            m++;
            localStringBuilder.append(c2);
          }
        }
      }
    while (true)
    {
      m++;
      break;
      if (i1 == 0)
      {
        i1 = 1;
        continue;
      }
      i1 = 0;
      continue;
      if ((i1 == 0) && (((c2 >= 'A') && (c2 <= 'Z')) || ((c2 >= 'a') && (c2 <= 'z'))))
      {
        m--;
        paramArrayOfInt[0] = m;
        return localStringBuilder.toString();
      }
      localStringBuilder.append(c2);
    }
  }

  public String a(Calendar paramCalendar)
  {
    return a(paramCalendar, new StringBuffer(this.l)).toString();
  }

  public String a(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.i, this.j);
    localGregorianCalendar.setTime(paramDate);
    return b(localGregorianCalendar, new StringBuffer(this.l)).toString();
  }

  public StringBuffer a(long paramLong, StringBuffer paramStringBuffer)
  {
    return a(new Date(paramLong), paramStringBuffer);
  }

  public StringBuffer a(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    return b(paramCalendar, paramStringBuffer);
  }

  public StringBuffer a(Date paramDate, StringBuffer paramStringBuffer)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(this.i, this.j);
    localGregorianCalendar.setTime(paramDate);
    return b(localGregorianCalendar, paramStringBuffer);
  }

  protected StringBuffer b(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    d[] arrayOfd = this.k;
    int m = arrayOfd.length;
    for (int n = 0; n < m; n++)
      arrayOfd[n].a(paramStringBuffer, paramCalendar);
    return paramStringBuffer;
  }

  protected List<d> b()
  {
    DateFormatSymbols localDateFormatSymbols = new DateFormatSymbols(this.j);
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString1 = localDateFormatSymbols.getEras();
    String[] arrayOfString2 = localDateFormatSymbols.getMonths();
    String[] arrayOfString3 = localDateFormatSymbols.getShortMonths();
    String[] arrayOfString4 = localDateFormatSymbols.getWeekdays();
    String[] arrayOfString5 = localDateFormatSymbols.getShortWeekdays();
    String[] arrayOfString6 = localDateFormatSymbols.getAmPmStrings();
    int m = this.h.length();
    int[] arrayOfInt = new int[1];
    int n = 0;
    String str1;
    int i1;
    int i2;
    if (n < m)
    {
      arrayOfInt[0] = n;
      str1 = a(this.h, arrayOfInt);
      i1 = arrayOfInt[0];
      i2 = str1.length();
      if (i2 != 0);
    }
    else
    {
      return localArrayList;
    }
    Object localObject;
    switch (str1.charAt(0))
    {
    default:
      throw new IllegalArgumentException("Illegal pattern component: " + str1);
    case 'G':
      localObject = new f(0, arrayOfString1);
    case 'y':
    case 'M':
    case 'd':
    case 'h':
    case 'H':
    case 'm':
    case 's':
    case 'S':
    case 'E':
    case 'D':
    case 'F':
    case 'w':
    case 'W':
    case 'a':
    case 'k':
    case 'K':
    case 'z':
    case 'Z':
    case '\'':
    }
    while (true)
    {
      localArrayList.add(localObject);
      n = i1 + 1;
      break;
      if (i2 == 2)
      {
        localObject = n.a;
        continue;
      }
      if (i2 < 4)
        i2 = 4;
      localObject = b(1, i2);
      continue;
      if (i2 >= 4)
      {
        localObject = new f(2, arrayOfString2);
        continue;
      }
      if (i2 == 3)
      {
        localObject = new f(2, arrayOfString3);
        continue;
      }
      if (i2 == 2)
      {
        localObject = l.a;
        continue;
      }
      localObject = o.a;
      continue;
      localObject = b(5, i2);
      continue;
      localObject = new j(b(10, i2));
      continue;
      localObject = b(11, i2);
      continue;
      localObject = b(12, i2);
      continue;
      localObject = b(13, i2);
      continue;
      localObject = b(14, i2);
      continue;
      if (i2 < 4);
      for (String[] arrayOfString7 = arrayOfString5; ; arrayOfString7 = arrayOfString4)
      {
        localObject = new f(7, arrayOfString7);
        break;
      }
      localObject = b(6, i2);
      continue;
      localObject = b(8, i2);
      continue;
      localObject = b(3, i2);
      continue;
      localObject = b(4, i2);
      continue;
      localObject = new f(9, arrayOfString6);
      continue;
      localObject = new k(b(11, i2));
      continue;
      localObject = b(10, i2);
      continue;
      if (i2 >= 4)
      {
        localObject = new h(this.i, this.j, 1);
        continue;
      }
      localObject = new h(this.i, this.j, 0);
      continue;
      if (i2 == 1)
      {
        localObject = i.b;
        continue;
      }
      localObject = i.a;
      continue;
      String str2 = str1.substring(1);
      if (str2.length() == 1)
      {
        localObject = new a(str2.charAt(0));
        continue;
      }
      localObject = new e(str2);
    }
  }

  protected b b(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default:
      return new c(paramInt1, paramInt2);
    case 1:
      return new p(paramInt1);
    case 2:
    }
    return new m(paramInt1);
  }

  public String c()
  {
    return this.h;
  }

  public TimeZone d()
  {
    return this.i;
  }

  public Locale e()
  {
    return this.j;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d));
    d locald;
    do
    {
      return false;
      locald = (d)paramObject;
    }
    while ((!this.h.equals(locald.h)) || (!this.i.equals(locald.i)) || (!this.j.equals(locald.j)));
    return true;
  }

  public int f()
  {
    return this.l;
  }

  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if ((paramObject instanceof Date))
      return a((Date)paramObject, paramStringBuffer);
    if ((paramObject instanceof Calendar))
      return a((Calendar)paramObject, paramStringBuffer);
    if ((paramObject instanceof Long))
      return a(((Long)paramObject).longValue(), paramStringBuffer);
    StringBuilder localStringBuilder = new StringBuilder().append("Unknown class: ");
    if (paramObject == null);
    for (String str = "<null>"; ; str = paramObject.getClass().getName())
      throw new IllegalArgumentException(str);
  }

  public int hashCode()
  {
    return this.h.hashCode() + 13 * (this.i.hashCode() + 13 * this.j.hashCode());
  }

  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(0);
    paramParsePosition.setErrorIndex(0);
    return null;
  }

  public String toString()
  {
    return "FastDateFormat[" + this.h + "]";
  }

  private static class a
    implements d.d
  {
    private final char a;

    a(char paramChar)
    {
      this.a = paramChar;
    }

    public int a()
    {
      return 1;
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.a);
    }
  }

  private static abstract interface b extends d.d
  {
    public abstract void a(StringBuffer paramStringBuffer, int paramInt);
  }

  private static class c
    implements d.b
  {
    private final int a;
    private final int b;

    c(int paramInt1, int paramInt2)
    {
      if (paramInt2 < 3)
        throw new IllegalArgumentException();
      this.a = paramInt1;
      this.b = paramInt2;
    }

    public int a()
    {
      return 4;
    }

    public final void a(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 100)
      {
        int k = this.b;
        while (true)
        {
          k--;
          if (k < 2)
            break;
          paramStringBuffer.append('0');
        }
        paramStringBuffer.append((char)(48 + paramInt / 10));
        paramStringBuffer.append((char)(48 + paramInt % 10));
        return;
      }
      int i;
      if (paramInt < 1000)
      {
        i = 3;
        int j = this.b;
        while (true)
        {
          j--;
          if (j < i)
            break;
          paramStringBuffer.append('0');
        }
      }
      if (paramInt > -1);
      for (boolean bool = true; ; bool = false)
      {
        x.a(bool, "Negative values should not be possible", paramInt);
        i = Integer.toString(paramInt).length();
        break;
      }
      paramStringBuffer.append(Integer.toString(paramInt));
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      a(paramStringBuffer, paramCalendar.get(this.a));
    }
  }

  private static abstract interface d
  {
    public abstract int a();

    public abstract void a(StringBuffer paramStringBuffer, Calendar paramCalendar);
  }

  private static class e
    implements d.d
  {
    private final String a;

    e(String paramString)
    {
      this.a = paramString;
    }

    public int a()
    {
      return this.a.length();
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.a);
    }
  }

  private static class f
    implements d.d
  {
    private final int a;
    private final String[] b;

    f(int paramInt, String[] paramArrayOfString)
    {
      this.a = paramInt;
      this.b = paramArrayOfString;
    }

    public int a()
    {
      int i = 0;
      int j = this.b.length;
      int k = j - 1;
      int m;
      if (k >= 0)
      {
        m = this.b[k].length();
        if (m <= i)
          break label43;
      }
      while (true)
      {
        i = m;
        j = k;
        break;
        return i;
        label43: m = i;
      }
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.b[paramCalendar.get(this.a)]);
    }
  }

  private static class g
  {
    private final TimeZone a;
    private final int b;
    private final Locale c;

    g(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
    {
      this.a = paramTimeZone;
      if (paramBoolean)
        paramInt |= -2147483648;
      this.b = paramInt;
      this.c = paramLocale;
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      while (true)
      {
        return true;
        if (!(paramObject instanceof g))
          break;
        g localg = (g)paramObject;
        if ((!this.a.equals(localg.a)) || (this.b != localg.b) || (!this.c.equals(localg.c)))
          return false;
      }
      return false;
    }

    public int hashCode()
    {
      return 31 * (31 * this.b + this.c.hashCode()) + this.a.hashCode();
    }
  }

  private static class h
    implements d.d
  {
    private final TimeZone a;
    private final String b;
    private final String c;

    h(TimeZone paramTimeZone, Locale paramLocale, int paramInt)
    {
      this.a = paramTimeZone;
      this.b = d.a(paramTimeZone, false, paramInt, paramLocale);
      this.c = d.a(paramTimeZone, true, paramInt, paramLocale);
    }

    public int a()
    {
      return Math.max(this.b.length(), this.c.length());
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      if ((this.a.useDaylightTime()) && (paramCalendar.get(16) != 0))
      {
        paramStringBuffer.append(this.c);
        return;
      }
      paramStringBuffer.append(this.b);
    }
  }

  private static class i
    implements d.d
  {
    static final i a = new i(true);
    static final i b = new i(false);
    final boolean c;

    i(boolean paramBoolean)
    {
      this.c = paramBoolean;
    }

    public int a()
    {
      return 5;
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int i = paramCalendar.get(15) + paramCalendar.get(16);
      if (i < 0)
      {
        paramStringBuffer.append('-');
        i = -i;
      }
      while (true)
      {
        int j = i / 3600000;
        paramStringBuffer.append((char)(48 + j / 10));
        paramStringBuffer.append((char)(48 + j % 10));
        if (this.c)
          paramStringBuffer.append(':');
        int k = i / 60000 - j * 60;
        paramStringBuffer.append((char)(48 + k / 10));
        paramStringBuffer.append((char)(48 + k % 10));
        return;
        paramStringBuffer.append('+');
      }
    }
  }

  private static class j
    implements d.b
  {
    private final d.b a;

    j(d.b paramb)
    {
      this.a = paramb;
    }

    public int a()
    {
      return this.a.a();
    }

    public void a(StringBuffer paramStringBuffer, int paramInt)
    {
      this.a.a(paramStringBuffer, paramInt);
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int i = paramCalendar.get(10);
      if (i == 0)
        i = 1 + paramCalendar.getLeastMaximum(10);
      this.a.a(paramStringBuffer, i);
    }
  }

  private static class k
    implements d.b
  {
    private final d.b a;

    k(d.b paramb)
    {
      this.a = paramb;
    }

    public int a()
    {
      return this.a.a();
    }

    public void a(StringBuffer paramStringBuffer, int paramInt)
    {
      this.a.a(paramStringBuffer, paramInt);
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int i = paramCalendar.get(11);
      if (i == 0)
        i = 1 + paramCalendar.getMaximum(11);
      this.a.a(paramStringBuffer, i);
    }
  }

  private static class l
    implements d.b
  {
    static final l a = new l();

    public int a()
    {
      return 2;
    }

    public final void a(StringBuffer paramStringBuffer, int paramInt)
    {
      paramStringBuffer.append((char)(48 + paramInt / 10));
      paramStringBuffer.append((char)(48 + paramInt % 10));
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      a(paramStringBuffer, 1 + paramCalendar.get(2));
    }
  }

  private static class m
    implements d.b
  {
    private final int a;

    m(int paramInt)
    {
      this.a = paramInt;
    }

    public int a()
    {
      return 2;
    }

    public final void a(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 100)
      {
        paramStringBuffer.append((char)(48 + paramInt / 10));
        paramStringBuffer.append((char)(48 + paramInt % 10));
        return;
      }
      paramStringBuffer.append(Integer.toString(paramInt));
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      a(paramStringBuffer, paramCalendar.get(this.a));
    }
  }

  private static class n
    implements d.b
  {
    static final n a = new n();

    public int a()
    {
      return 2;
    }

    public final void a(StringBuffer paramStringBuffer, int paramInt)
    {
      paramStringBuffer.append((char)(48 + paramInt / 10));
      paramStringBuffer.append((char)(48 + paramInt % 10));
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      a(paramStringBuffer, paramCalendar.get(1) % 100);
    }
  }

  private static class o
    implements d.b
  {
    static final o a = new o();

    public int a()
    {
      return 2;
    }

    public final void a(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 10)
      {
        paramStringBuffer.append((char)(paramInt + 48));
        return;
      }
      paramStringBuffer.append((char)(48 + paramInt / 10));
      paramStringBuffer.append((char)(48 + paramInt % 10));
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      a(paramStringBuffer, 1 + paramCalendar.get(2));
    }
  }

  private static class p
    implements d.b
  {
    private final int a;

    p(int paramInt)
    {
      this.a = paramInt;
    }

    public int a()
    {
      return 4;
    }

    public final void a(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 10)
      {
        paramStringBuffer.append((char)(paramInt + 48));
        return;
      }
      if (paramInt < 100)
      {
        paramStringBuffer.append((char)(48 + paramInt / 10));
        paramStringBuffer.append((char)(48 + paramInt % 10));
        return;
      }
      paramStringBuffer.append(Integer.toString(paramInt));
    }

    public void a(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      a(paramStringBuffer, paramCalendar.get(this.a));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.i.d
 * JD-Core Version:    0.6.0
 */