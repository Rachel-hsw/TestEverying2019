package org.a.a.a.h;

import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.a.a.a.p;
import org.a.a.a.x;

public class b extends MessageFormat
{
  private static final long a = -2362048321261811743L;
  private static final int b = 31;
  private static final String c = "";
  private static final String d = "''";
  private static final char e = ',';
  private static final char f = '}';
  private static final char g = '{';
  private static final char h = '\'';
  private String i;
  private final Map<String, ? extends c> j;

  public b(String paramString)
  {
    this(paramString, Locale.getDefault());
  }

  public b(String paramString, Locale paramLocale)
  {
    this(paramString, paramLocale, null);
  }

  public b(String paramString, Locale paramLocale, Map<String, ? extends c> paramMap)
  {
    super("");
    setLocale(paramLocale);
    this.j = paramMap;
    applyPattern(paramString);
  }

  public b(String paramString, Map<String, ? extends c> paramMap)
  {
    this(paramString, Locale.getDefault(), paramMap);
  }

  private int a(String paramString, ParsePosition paramParsePosition)
  {
    int k = paramParsePosition.getIndex();
    c(paramString, paramParsePosition);
    StringBuffer localStringBuffer = new StringBuffer();
    int m = 0;
    while ((m == 0) && (paramParsePosition.getIndex() < paramString.length()))
    {
      char c1 = paramString.charAt(paramParsePosition.getIndex());
      if (Character.isWhitespace(c1))
      {
        c(paramString, paramParsePosition);
        c1 = paramString.charAt(paramParsePosition.getIndex());
        if ((c1 != ',') && (c1 != '}'))
        {
          m = 1;
          a(paramParsePosition);
          continue;
        }
      }
      char c2 = c1;
      if (((c2 == ',') || (c2 == '}')) && (localStringBuffer.length() > 0))
        try
        {
          int n = Integer.parseInt(localStringBuffer.toString());
          return n;
        }
        catch (NumberFormatException localNumberFormatException)
        {
        }
      if (!Character.isDigit(c2));
      for (m = 1; ; m = 0)
      {
        localStringBuffer.append(c2);
        break;
      }
    }
    if (m != 0)
      throw new IllegalArgumentException("Invalid format argument index at position " + k + ": " + paramString.substring(k, paramParsePosition.getIndex()));
    throw new IllegalArgumentException("Unterminated format element at position " + k);
  }

  private String a(String paramString, ArrayList<String> paramArrayList)
  {
    if (!a(paramArrayList))
      return paramString;
    StringBuilder localStringBuilder = new StringBuilder(2 * paramString.length());
    ParsePosition localParsePosition = new ParsePosition(0);
    int k = -1;
    int m = 0;
    while (true)
    {
      int n;
      if (localParsePosition.getIndex() < paramString.length())
      {
        char c1 = paramString.charAt(localParsePosition.getIndex());
        switch (c1)
        {
        default:
        case '\'':
        case '{':
        case '}':
        }
        while (true)
        {
          localStringBuilder.append(c1);
          a(localParsePosition);
          break;
          a(paramString, localParsePosition, localStringBuilder, false);
          break;
          n = m + 1;
          if (n != 1)
            break label212;
          k++;
          localStringBuilder.append('{').append(a(paramString, a(localParsePosition)));
          String str = (String)paramArrayList.get(k);
          if (str != null)
            localStringBuilder.append(',').append(str);
          m = n;
          break;
          m--;
        }
      }
      return localStringBuilder.toString();
      label212: m = n;
    }
  }

  private StringBuilder a(String paramString, ParsePosition paramParsePosition, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    int k = paramParsePosition.getIndex();
    char[] arrayOfChar = paramString.toCharArray();
    if ((paramBoolean) && (arrayOfChar[k] == '\''))
    {
      a(paramParsePosition);
      if (paramStringBuilder != null);
    }
    while (true)
    {
      return null;
      return paramStringBuilder.append('\'');
      int m = paramParsePosition.getIndex();
      int n = k;
      if (m >= paramString.length())
        break;
      if ((paramBoolean) && (paramString.substring(m).startsWith("''")))
      {
        paramStringBuilder.append(arrayOfChar, n, paramParsePosition.getIndex() - n).append('\'');
        paramParsePosition.setIndex(m + "''".length());
        n = paramParsePosition.getIndex();
      }
      while (true)
      {
        m++;
        break;
        switch (arrayOfChar[paramParsePosition.getIndex()])
        {
        default:
          a(paramParsePosition);
        case '\'':
        }
      }
      a(paramParsePosition);
      if (paramStringBuilder != null)
        return paramStringBuilder.append(arrayOfChar, n, paramParsePosition.getIndex() - n);
    }
    throw new IllegalArgumentException("Unterminated quoted string at position " + k);
  }

  private Format a(String paramString)
  {
    Map localMap = this.j;
    Format localFormat = null;
    String str3;
    if (localMap != null)
    {
      int k = paramString.indexOf(',');
      if (k <= 0)
        break label95;
      String str2 = paramString.substring(0, k).trim();
      str3 = paramString.substring(k + 1).trim();
      paramString = str2;
    }
    label95: for (String str1 = str3; ; str1 = null)
    {
      c localc = (c)this.j.get(paramString);
      localFormat = null;
      if (localc != null)
        localFormat = localc.a(paramString, str1, getLocale());
      return localFormat;
    }
  }

  private ParsePosition a(ParsePosition paramParsePosition)
  {
    paramParsePosition.setIndex(1 + paramParsePosition.getIndex());
    return paramParsePosition;
  }

  private void a(String paramString, ParsePosition paramParsePosition, boolean paramBoolean)
  {
    a(paramString, paramParsePosition, null, paramBoolean);
  }

  private boolean a(Collection<?> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()));
    Iterator localIterator;
    do
      while (!localIterator.hasNext())
      {
        return false;
        localIterator = paramCollection.iterator();
      }
    while (localIterator.next() == null);
    return true;
  }

  private String b(String paramString, ParsePosition paramParsePosition)
  {
    int k = paramParsePosition.getIndex();
    c(paramString, paramParsePosition);
    int m = paramParsePosition.getIndex();
    int n = 1;
    if (paramParsePosition.getIndex() < paramString.length())
    {
      switch (paramString.charAt(paramParsePosition.getIndex()))
      {
      default:
      case '{':
      case '}':
      case '\'':
      }
      while (true)
      {
        a(paramParsePosition);
        break;
        n++;
        continue;
        n--;
        if (n == 0)
        {
          return paramString.substring(m, paramParsePosition.getIndex());
          a(paramString, paramParsePosition, false);
        }
      }
    }
    throw new IllegalArgumentException("Unterminated format element at position " + k);
  }

  private void c(String paramString, ParsePosition paramParsePosition)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int k;
    do
    {
      k = g.d().a(arrayOfChar, paramParsePosition.getIndex());
      paramParsePosition.setIndex(k + paramParsePosition.getIndex());
    }
    while ((k > 0) && (paramParsePosition.getIndex() < paramString.length()));
  }

  public final void applyPattern(String paramString)
  {
    int k = 0;
    if (this.j == null)
    {
      super.applyPattern(paramString);
      this.i = super.toPattern();
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    ParsePosition localParsePosition = new ParsePosition(0);
    char[] arrayOfChar = paramString.toCharArray();
    int m = 0;
    label120: int n;
    int i1;
    String str;
    Format localFormat2;
    while (true)
      if (localParsePosition.getIndex() < paramString.length())
        switch (arrayOfChar[localParsePosition.getIndex()])
        {
        default:
          localStringBuilder.append(arrayOfChar[localParsePosition.getIndex()]);
          a(localParsePosition);
          break;
        case '\'':
          a(paramString, localParsePosition, localStringBuilder, true);
          break;
        case '{':
          n = m + 1;
          c(paramString, localParsePosition);
          i1 = localParsePosition.getIndex();
          int i2 = a(paramString, a(localParsePosition));
          localStringBuilder.append('{').append(i2);
          c(paramString, localParsePosition);
          if (arrayOfChar[localParsePosition.getIndex()] != ',')
            break label470;
          str = b(paramString, a(localParsePosition));
          localFormat2 = a(str);
          if (localFormat2 == null)
            localStringBuilder.append(',').append(str);
        }
    while (true)
    {
      localArrayList1.add(localFormat2);
      if (localFormat2 == null)
        str = null;
      localArrayList2.add(str);
      boolean bool1;
      if (localArrayList1.size() == n)
      {
        bool1 = true;
        x.a(bool1);
        if (localArrayList2.size() != n)
          break label368;
      }
      label368: for (boolean bool2 = true; ; bool2 = false)
      {
        x.a(bool2);
        if (arrayOfChar[localParsePosition.getIndex()] == '}')
          break label463;
        throw new IllegalArgumentException("Unreadable format element at position " + i1);
        bool1 = false;
        break;
      }
      super.applyPattern(localStringBuilder.toString());
      this.i = a(super.toPattern(), localArrayList2);
      if (!a(localArrayList1))
        break;
      Format[] arrayOfFormat = getFormats();
      Iterator localIterator = localArrayList1.iterator();
      while (localIterator.hasNext())
      {
        Format localFormat1 = (Format)localIterator.next();
        if (localFormat1 != null)
          arrayOfFormat[k] = localFormat1;
        k++;
      }
      super.setFormats(arrayOfFormat);
      return;
      label463: m = n;
      break label120;
      label470: str = null;
      localFormat2 = null;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    b localb;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (!super.equals(paramObject))
        return false;
      if (p.c(getClass(), paramObject.getClass()))
        return false;
      localb = (b)paramObject;
      if (p.c(this.i, localb.i))
        return false;
    }
    while (!p.c(this.j, localb.j));
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * super.hashCode() + p.a(this.j)) + p.a(this.i);
  }

  public void setFormat(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }

  public void setFormatByArgumentIndex(int paramInt, Format paramFormat)
  {
    throw new UnsupportedOperationException();
  }

  public void setFormats(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }

  public void setFormatsByArgumentIndex(Format[] paramArrayOfFormat)
  {
    throw new UnsupportedOperationException();
  }

  public String toPattern()
  {
    return this.i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.b
 * JD-Core Version:    0.6.0
 */