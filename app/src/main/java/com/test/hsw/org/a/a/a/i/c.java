package org.a.a.a.i;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.a.a.a.v;

public class c
{
  public static final String a = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
  static final Object b = "y";
  static final Object c = "M";
  static final Object d = "d";
  static final Object e = "H";
  static final Object f = "m";
  static final Object g = "s";
  static final Object h = "S";

  public static String a(long paramLong)
  {
    return a(paramLong, "H:mm:ss.SSS");
  }

  public static String a(long paramLong1, long paramLong2)
  {
    return a(paramLong1, paramLong2, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false, TimeZone.getDefault());
  }

  public static String a(long paramLong1, long paramLong2, String paramString)
  {
    return a(paramLong1, paramLong2, paramString, true, TimeZone.getDefault());
  }

  public static String a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, TimeZone paramTimeZone)
  {
    a[] arrayOfa = a(paramString);
    Calendar localCalendar1 = Calendar.getInstance(paramTimeZone);
    localCalendar1.setTime(new Date(paramLong1));
    Calendar localCalendar2 = Calendar.getInstance(paramTimeZone);
    localCalendar2.setTime(new Date(paramLong2));
    int i = localCalendar2.get(14) - localCalendar1.get(14);
    int j = localCalendar2.get(13) - localCalendar1.get(13);
    int k = localCalendar2.get(12) - localCalendar1.get(12);
    int m = localCalendar2.get(11) - localCalendar1.get(11);
    int n = localCalendar2.get(5) - localCalendar1.get(5);
    int i1 = localCalendar2.get(2) - localCalendar1.get(2);
    int i2 = localCalendar2.get(1) - localCalendar1.get(1);
    while (i < 0)
    {
      i += 1000;
      j--;
    }
    while (j < 0)
    {
      j += 60;
      k--;
    }
    while (k < 0)
    {
      k += 60;
      m--;
    }
    while (m < 0)
    {
      m += 24;
      n--;
    }
    int i3;
    int i4;
    if (a.a(arrayOfa, c))
    {
      i3 = n;
      i4 = i1;
      while (i3 < 0)
      {
        i3 += localCalendar1.getActualMaximum(5);
        i4--;
        localCalendar1.add(2, 1);
      }
      while (i4 < 0)
      {
        i4 += 12;
        i2--;
      }
      if ((!a.a(arrayOfa, b)) && (i2 != 0))
        while (i2 != 0)
        {
          i4 += i2 * 12;
          i2 = 0;
        }
    }
    else
    {
      if (!a.a(arrayOfa, b))
      {
        int i5 = localCalendar2.get(1);
        if (i1 < 0)
          i5--;
        while (localCalendar1.get(1) != i5)
        {
          int i6 = n + (localCalendar1.getActualMaximum(6) - localCalendar1.get(6));
          if (((localCalendar1 instanceof GregorianCalendar)) && (localCalendar1.get(2) == 1) && (localCalendar1.get(5) == 29))
            i6++;
          localCalendar1.add(1, 1);
          n = i6 + localCalendar1.get(6);
        }
        i2 = 0;
      }
      while (localCalendar1.get(2) != localCalendar2.get(2))
      {
        n += localCalendar1.getActualMaximum(5);
        localCalendar1.add(2, 1);
      }
      i3 = n;
      i4 = 0;
      while (i3 < 0)
      {
        i3 += localCalendar1.getActualMaximum(5);
        i4--;
        localCalendar1.add(2, 1);
      }
    }
    if (!a.a(arrayOfa, d))
    {
      m += i3 * 24;
      i3 = 0;
    }
    if (!a.a(arrayOfa, e))
    {
      k += m * 60;
      m = 0;
    }
    if (!a.a(arrayOfa, f))
    {
      j += k * 60;
      k = 0;
    }
    if (!a.a(arrayOfa, g))
    {
      i += j * 1000;
      j = 0;
    }
    return a(arrayOfa, i2, i4, i3, m, k, j, i, paramBoolean);
  }

  public static String a(long paramLong, String paramString)
  {
    return a(paramLong, paramString, true);
  }

  public static String a(long paramLong, String paramString, boolean paramBoolean)
  {
    a[] arrayOfa = a(paramString);
    boolean bool1 = a.a(arrayOfa, d);
    int i = 0;
    if (bool1)
    {
      i = (int)(paramLong / 86400000L);
      paramLong -= 86400000L * i;
    }
    boolean bool2 = a.a(arrayOfa, e);
    int j = 0;
    if (bool2)
    {
      j = (int)(paramLong / 3600000L);
      paramLong -= 3600000L * j;
    }
    boolean bool3 = a.a(arrayOfa, f);
    int k = 0;
    if (bool3)
    {
      k = (int)(paramLong / 60000L);
      paramLong -= 60000L * k;
    }
    boolean bool4 = a.a(arrayOfa, g);
    int m = 0;
    if (bool4)
    {
      m = (int)(paramLong / 1000L);
      paramLong -= 1000L * m;
    }
    boolean bool5 = a.a(arrayOfa, h);
    int n = 0;
    if (bool5)
      n = (int)paramLong;
    return a(arrayOfa, 0, 0, i, j, k, m, n, paramBoolean);
  }

  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = a(paramLong, "d' days 'H' hours 'm' minutes 's' seconds'");
    String str3;
    if (paramBoolean1)
    {
      str3 = " " + (String)localObject;
      localObject = v.c(str3, " 0 days", "");
      if (((String)localObject).length() == str3.length())
        break label279;
      String str4 = v.c((String)localObject, " 0 hours", "");
      if (str4.length() != ((String)localObject).length())
      {
        localObject = v.c(str4, " 0 minutes", "");
        if (((String)localObject).length() == ((String)localObject).length());
      }
    }
    label272: label279: for (localObject = v.c((String)localObject, " 0 seconds", ""); ; localObject = str3)
    {
      if (((String)localObject).length() != 0)
        localObject = ((String)localObject).substring(1);
      String str1;
      String str2;
      if (paramBoolean2)
      {
        str1 = v.c((String)localObject, " 0 seconds", "");
        if (str1.length() != ((String)localObject).length())
        {
          localObject = v.c(str1, " 0 minutes", "");
          if (((String)localObject).length() == str1.length())
            break label272;
          str2 = v.c((String)localObject, " 0 hours", "");
          if (str2.length() == ((String)localObject).length());
        }
      }
      for (localObject = v.c(str2, " 0 days", ""); ; localObject = str1)
        return v.c(v.c(v.c(v.c(" " + (String)localObject, " 1 seconds", " 1 second"), " 1 minutes", " 1 minute"), " 1 hours", " 1 hour"), " 1 days", " 1 day").trim();
    }
  }

  static String a(a[] paramArrayOfa, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayOfa.length;
    int j = 0;
    int k = 0;
    int m = paramInt7;
    if (j < i)
    {
      a locala = paramArrayOfa[j];
      Object localObject = locala.c();
      int n = locala.b();
      if ((localObject instanceof StringBuffer))
        localStringBuffer.append(localObject.toString());
      do
      {
        j++;
        break;
        if (localObject == b)
        {
          if (paramBoolean);
          for (String str8 = v.b(Integer.toString(paramInt1), n, '0'); ; str8 = Integer.toString(paramInt1))
          {
            localStringBuffer.append(str8);
            k = 0;
            break;
          }
        }
        if (localObject == c)
        {
          if (paramBoolean);
          for (String str7 = v.b(Integer.toString(paramInt2), n, '0'); ; str7 = Integer.toString(paramInt2))
          {
            localStringBuffer.append(str7);
            k = 0;
            break;
          }
        }
        if (localObject == d)
        {
          if (paramBoolean);
          for (String str6 = v.b(Integer.toString(paramInt3), n, '0'); ; str6 = Integer.toString(paramInt3))
          {
            localStringBuffer.append(str6);
            k = 0;
            break;
          }
        }
        if (localObject == e)
        {
          if (paramBoolean);
          for (String str5 = v.b(Integer.toString(paramInt4), n, '0'); ; str5 = Integer.toString(paramInt4))
          {
            localStringBuffer.append(str5);
            k = 0;
            break;
          }
        }
        if (localObject == f)
        {
          if (paramBoolean);
          for (String str4 = v.b(Integer.toString(paramInt5), n, '0'); ; str4 = Integer.toString(paramInt5))
          {
            localStringBuffer.append(str4);
            k = 0;
            break;
          }
        }
        if (localObject != g)
          continue;
        if (paramBoolean);
        for (String str3 = v.b(Integer.toString(paramInt6), n, '0'); ; str3 = Integer.toString(paramInt6))
        {
          localStringBuffer.append(str3);
          k = 1;
          break;
        }
      }
      while (localObject != h);
      int i1;
      if (k != 0)
      {
        int i2 = m + 1000;
        if (paramBoolean);
        for (String str2 = v.b(Integer.toString(i2), n, '0'); ; str2 = Integer.toString(i2))
        {
          localStringBuffer.append(str2.substring(1));
          i1 = i2;
          m = i1;
          k = 0;
          break;
        }
      }
      if (paramBoolean);
      for (String str1 = v.b(Integer.toString(m), n, '0'); ; str1 = Integer.toString(m))
      {
        localStringBuffer.append(str1);
        i1 = m;
        break;
      }
    }
    return localStringBuffer.toString();
  }

  static a[] a(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    ArrayList localArrayList = new ArrayList(arrayOfChar.length);
    int i = arrayOfChar.length;
    int j = 0;
    a locala = null;
    StringBuffer localStringBuffer = null;
    int k = 0;
    if (j < i)
    {
      char c1 = arrayOfChar[j];
      if ((k != 0) && (c1 != '\''))
        localStringBuffer.append(c1);
      Object localObject;
      label183: 
      do
      {
        j++;
        break;
        switch (c1)
        {
        default:
          if (localStringBuffer == null)
          {
            localStringBuffer = new StringBuffer();
            localArrayList.add(new a(localStringBuffer));
          }
          localStringBuffer.append(c1);
          localObject = null;
        case '\'':
        case 'y':
        case 'M':
        case 'd':
        case 'H':
        case 'm':
        case 's':
        case 'S':
        }
      }
      while (localObject == null);
      if ((locala != null) && (locala.c() == localObject))
        locala.a();
      while (true)
      {
        localStringBuffer = null;
        break;
        if (k != 0)
        {
          localStringBuffer = null;
          k = 0;
          localObject = null;
          break label183;
        }
        localStringBuffer = new StringBuffer();
        localArrayList.add(new a(localStringBuffer));
        k = 1;
        localObject = null;
        break label183;
        localObject = b;
        break label183;
        localObject = c;
        break label183;
        localObject = d;
        break label183;
        localObject = e;
        break label183;
        localObject = f;
        break label183;
        localObject = g;
        break label183;
        localObject = h;
        break label183;
        locala = new a(localObject);
        localArrayList.add(locala);
      }
    }
    return (a[])localArrayList.toArray(new a[localArrayList.size()]);
  }

  public static String b(long paramLong)
  {
    return a(paramLong, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false);
  }

  static class a
  {
    private final Object a;
    private int b;

    a(Object paramObject)
    {
      this.a = paramObject;
      this.b = 1;
    }

    a(Object paramObject, int paramInt)
    {
      this.a = paramObject;
      this.b = paramInt;
    }

    static boolean a(a[] paramArrayOfa, Object paramObject)
    {
      int i = paramArrayOfa.length;
      for (int j = 0; ; j++)
      {
        int k = 0;
        if (j < i)
        {
          if (paramArrayOfa[j].c() != paramObject)
            continue;
          k = 1;
        }
        return k;
      }
    }

    void a()
    {
      this.b = (1 + this.b);
    }

    int b()
    {
      return this.b;
    }

    Object c()
    {
      return this.a;
    }

    public boolean equals(Object paramObject)
    {
      a locala;
      if ((paramObject instanceof a))
      {
        locala = (a)paramObject;
        if (this.a.getClass() == locala.a.getClass())
          break label31;
      }
      label31: 
      do
      {
        do
          return false;
        while (this.b != locala.b);
        if ((this.a instanceof StringBuffer))
          return this.a.toString().equals(locala.a.toString());
        if ((this.a instanceof Number))
          return this.a.equals(locala.a);
      }
      while (this.a != locala.a);
      return true;
    }

    public int hashCode()
    {
      return this.a.hashCode();
    }

    public String toString()
    {
      return v.d(this.a.toString(), this.b);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.i.c
 * JD-Core Version:    0.6.0
 */