package org.a.a.a.h;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class h
{
  public static final char a = '$';
  public static final g b = g.b("${");
  public static final g c = g.b("}");
  private char d;
  private g e;
  private g f;
  private f<?> g;
  private boolean h;

  public h()
  {
    this((f)null, b, c, '$');
  }

  public <V> h(Map<String, V> paramMap)
  {
    this(f.a(paramMap), b, c, '$');
  }

  public <V> h(Map<String, V> paramMap, String paramString1, String paramString2)
  {
    this(f.a(paramMap), paramString1, paramString2, '$');
  }

  public <V> h(Map<String, V> paramMap, String paramString1, String paramString2, char paramChar)
  {
    this(f.a(paramMap), paramString1, paramString2, paramChar);
  }

  public h(f<?> paramf)
  {
    this(paramf, b, c, '$');
  }

  public h(f<?> paramf, String paramString1, String paramString2, char paramChar)
  {
    a(paramf);
    b(paramString1);
    c(paramString2);
    a(paramChar);
  }

  public h(f<?> paramf, g paramg1, g paramg2, char paramChar)
  {
    a(paramf);
    a(paramg1);
    b(paramg2);
    a(paramChar);
  }

  private int a(e parame, int paramInt1, int paramInt2, List<String> paramList)
  {
    g localg1 = b();
    g localg2 = c();
    int i = a();
    int j;
    int k;
    int m;
    char[] arrayOfChar;
    int n;
    int i1;
    Object localObject;
    label50: int i2;
    int i3;
    if (paramList == null)
    {
      j = 1;
      k = 0;
      m = 0;
      arrayOfChar = parame.b;
      n = paramInt1 + paramInt2;
      i1 = paramInt1;
      localObject = paramList;
      if (i1 >= n)
        break label471;
      i2 = localg1.a(arrayOfChar, i1, paramInt1, n);
      if (i2 != 0)
        break label95;
      i3 = i1 + 1;
    }
    label469: 
    while (true)
    {
      i1 = i3;
      break label50;
      j = 0;
      break;
      label95: if ((i1 > paramInt1) && (arrayOfChar[(i1 - 1)] == i))
      {
        parame.c(i1 - 1);
        arrayOfChar = parame.b;
        m--;
        k = 1;
        n--;
        i3 = i1;
        continue;
      }
      i3 = i1 + i2;
      int i4 = 0;
      while (true)
      {
        if (i3 >= n)
          break label469;
        if (e())
        {
          int i8 = localg1.a(arrayOfChar, i3, paramInt1, n);
          if (i8 != 0)
          {
            i4++;
            i3 += i8;
            continue;
          }
        }
        int i5 = localg2.a(arrayOfChar, i3, paramInt1, n);
        if (i5 == 0)
        {
          i3++;
          continue;
        }
        if (i4 == 0)
        {
          String str1 = new String(arrayOfChar, i1 + i2, i3 - i1 - i2);
          if (e())
          {
            e locale = new e(str1);
            c(locale, 0, locale.length());
            str1 = locale.toString();
          }
          i3 += i5;
          if (localObject == null)
          {
            localObject = new ArrayList();
            ((List)localObject).add(new String(arrayOfChar, paramInt1, paramInt2));
          }
          a(str1, (List)localObject);
          ((List)localObject).add(str1);
          String str2 = a(str1, parame, i1, i3);
          if (str2 != null)
          {
            int i6 = str2.length();
            parame.a(i1, i3, str2);
            k = 1;
            int i7 = i6 + a(parame, i1, i6, (List)localObject) - (i3 - i1);
            i3 += i7;
            n += i7;
            m += i7;
            arrayOfChar = parame.b;
          }
          ((List)localObject).remove(-1 + ((List)localObject).size());
          break;
        }
        i4--;
        i3 += i5;
      }
    }
    label471: if (j != 0)
    {
      if (k != 0)
        return 1;
      return 0;
    }
    return m;
  }

  public static String a(Object paramObject)
  {
    return new h(f.b()).b(paramObject);
  }

  public static <V> String a(Object paramObject, Map<String, V> paramMap)
  {
    return new h(paramMap).b(paramObject);
  }

  public static <V> String a(Object paramObject, Map<String, V> paramMap, String paramString1, String paramString2)
  {
    return new h(paramMap, paramString1, paramString2).b(paramObject);
  }

  public static String a(Object paramObject, Properties paramProperties)
  {
    if (paramProperties == null)
      return paramObject.toString();
    HashMap localHashMap = new HashMap();
    Enumeration localEnumeration = paramProperties.propertyNames();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      localHashMap.put(str, paramProperties.getProperty(str));
    }
    return a(paramObject, localHashMap);
  }

  private void a(String paramString, List<String> paramList)
  {
    if (!paramList.contains(paramString))
      return;
    e locale = new e(256);
    locale.c("Infinite loop in property interpolation of ");
    locale.c((String)paramList.remove(0));
    locale.c(": ");
    locale.a(paramList, "->");
    throw new IllegalStateException(locale.toString());
  }

  public char a()
  {
    return this.d;
  }

  public String a(String paramString)
  {
    if (paramString == null)
      paramString = null;
    e locale;
    do
    {
      return paramString;
      locale = new e(paramString);
    }
    while (!c(locale, 0, paramString.length()));
    return locale.toString();
  }

  public String a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      return null;
    e locale = new e(paramInt2).a(paramString, paramInt1, paramInt2);
    if (!c(locale, 0, paramInt2))
      return paramString.substring(paramInt1, paramInt1 + paramInt2);
    return locale.toString();
  }

  protected String a(String paramString, e parame, int paramInt1, int paramInt2)
  {
    f localf = d();
    if (localf == null)
      return null;
    return localf.a(paramString);
  }

  public String a(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null)
      return null;
    e locale = new e(paramStringBuffer.length()).a(paramStringBuffer);
    c(locale, 0, locale.length());
    return locale.toString();
  }

  public String a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null)
      return null;
    e locale = new e(paramInt2).a(paramStringBuffer, paramInt1, paramInt2);
    c(locale, 0, paramInt2);
    return locale.toString();
  }

  public String a(e parame)
  {
    if (parame == null)
      return null;
    e locale = new e(parame.length()).a(parame);
    c(locale, 0, locale.length());
    return locale.toString();
  }

  public String a(e parame, int paramInt1, int paramInt2)
  {
    if (parame == null)
      return null;
    e locale = new e(paramInt2).a(parame, paramInt1, paramInt2);
    c(locale, 0, paramInt2);
    return locale.toString();
  }

  public String a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
      return null;
    e locale = new e(paramArrayOfChar.length).b(paramArrayOfChar);
    c(locale, 0, paramArrayOfChar.length);
    return locale.toString();
  }

  public String a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null)
      return null;
    e locale = new e(paramInt2).a(paramArrayOfChar, paramInt1, paramInt2);
    c(locale, 0, paramInt2);
    return locale.toString();
  }

  public h a(g paramg)
  {
    if (paramg == null)
      throw new IllegalArgumentException("Variable prefix matcher must not be null!");
    this.e = paramg;
    return this;
  }

  public void a(char paramChar)
  {
    this.d = paramChar;
  }

  public void a(f<?> paramf)
  {
    this.g = paramf;
  }

  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public String b(Object paramObject)
  {
    if (paramObject == null)
      return null;
    e locale = new e().a(paramObject);
    c(locale, 0, locale.length());
    return locale.toString();
  }

  public g b()
  {
    return this.e;
  }

  public h b(char paramChar)
  {
    return a(g.a(paramChar));
  }

  public h b(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Variable prefix must not be null!");
    return a(g.b(paramString));
  }

  public h b(g paramg)
  {
    if (paramg == null)
      throw new IllegalArgumentException("Variable suffix matcher must not be null!");
    this.f = paramg;
    return this;
  }

  public boolean b(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null)
      return false;
    return b(paramStringBuffer, 0, paramStringBuffer.length());
  }

  public boolean b(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null);
    e locale;
    do
    {
      return false;
      locale = new e(paramInt2).a(paramStringBuffer, paramInt1, paramInt2);
    }
    while (!c(locale, 0, paramInt2));
    paramStringBuffer.replace(paramInt1, paramInt1 + paramInt2, locale.toString());
    return true;
  }

  public boolean b(e parame)
  {
    if (parame == null)
      return false;
    return c(parame, 0, parame.length());
  }

  public boolean b(e parame, int paramInt1, int paramInt2)
  {
    if (parame == null)
      return false;
    return c(parame, paramInt1, paramInt2);
  }

  public g c()
  {
    return this.f;
  }

  public h c(char paramChar)
  {
    return b(g.a(paramChar));
  }

  public h c(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("Variable suffix must not be null!");
    return b(g.b(paramString));
  }

  protected boolean c(e parame, int paramInt1, int paramInt2)
  {
    return a(parame, paramInt1, paramInt2, null) > 0;
  }

  public f<?> d()
  {
    return this.g;
  }

  public boolean e()
  {
    return this.h;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.h
 * JD-Core Version:    0.6.0
 */