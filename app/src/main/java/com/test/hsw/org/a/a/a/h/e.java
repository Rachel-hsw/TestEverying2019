package org.a.a.a.h;

import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import org.a.a.a.c;
import org.a.a.a.p;
import org.a.a.a.w;

public class e
  implements Appendable, CharSequence
{
  static final int a = 32;
  private static final long d = 7628716375283629643L;
  protected char[] b;
  protected int c;
  private String e;
  private String f;

  public e()
  {
    this(32);
  }

  public e(int paramInt)
  {
    if (paramInt <= 0)
      paramInt = 32;
    this.b = new char[paramInt];
  }

  public e(String paramString)
  {
    if (paramString == null)
    {
      this.b = new char[32];
      return;
    }
    this.b = new char[32 + paramString.length()];
    c(paramString);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.b, paramInt2, this.b, paramInt1, this.c - paramInt2);
    this.c -= paramInt3;
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4)
  {
    int i = paramInt4 + (this.c - paramInt3);
    if (paramInt4 != paramInt3)
    {
      b(i);
      System.arraycopy(this.b, paramInt2, this.b, paramInt1 + paramInt4, this.c - paramInt2);
      this.c = i;
    }
    if (paramInt4 > 0)
      paramString.getChars(0, paramInt4, this.b, paramInt1);
  }

  private e b(g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramg == null) || (this.c == 0))
      return this;
    int i;
    label20: int j;
    int k;
    int m;
    label37: int i2;
    int i1;
    if (paramString == null)
    {
      i = 0;
      char[] arrayOfChar = this.b;
      j = paramInt1;
      k = paramInt3;
      m = paramInt2;
      if ((j < m) && (k != 0))
      {
        int n = paramg.a(arrayOfChar, j, paramInt1, m);
        if (n <= 0)
          break label143;
        a(j, j + n, n, paramString, i);
        i2 = i + (m - n);
        j = -1 + (j + i);
        if (k <= 0)
          break label136;
        i1 = k - 1;
      }
    }
    while (true)
    {
      j++;
      k = i1;
      m = i2;
      break label37;
      break;
      i = paramString.length();
      break label20;
      label136: i1 = k;
      continue;
      label143: i1 = k;
      i2 = m;
    }
  }

  public int a(g paramg, int paramInt)
  {
    if (paramInt < 0);
    for (int i = 0; (paramg == null) || (i >= this.c); i = paramInt)
    {
      j = -1;
      return j;
    }
    int k = this.c;
    char[] arrayOfChar = this.b;
    for (int j = i; ; j++)
    {
      if (j >= k)
        break label71;
      if (paramg.a(arrayOfChar, j, i, k) > 0)
        break;
    }
    label71: return -1;
  }

  public String a()
  {
    return this.e;
  }

  public e a(char paramChar)
  {
    b(1 + length());
    char[] arrayOfChar = this.b;
    int i = this.c;
    this.c = (i + 1);
    arrayOfChar[i] = paramChar;
    return this;
  }

  public e a(char paramChar1, char paramChar2)
  {
    if (e() > 0)
    {
      a(paramChar1);
      return this;
    }
    a(paramChar2);
    return this;
  }

  public e a(char paramChar, int paramInt)
  {
    if (paramInt > 0)
      a(paramChar);
    return this;
  }

  public e a(double paramDouble)
  {
    return c(String.valueOf(paramDouble));
  }

  public e a(float paramFloat)
  {
    return c(String.valueOf(paramFloat));
  }

  public e a(int paramInt)
  {
    if (paramInt < 0)
      throw new StringIndexOutOfBoundsException(paramInt);
    if (paramInt < this.c)
      this.c = paramInt;
    while (true)
    {
      return this;
      if (paramInt <= this.c)
        continue;
      b(paramInt);
      int i = this.c;
      this.c = paramInt;
      while (i < paramInt)
      {
        this.b[i] = '\000';
        i++;
      }
    }
  }

  public e a(int paramInt, char paramChar)
  {
    if ((paramInt < 0) || (paramInt >= length()))
      throw new StringIndexOutOfBoundsException(paramInt);
    this.b[paramInt] = paramChar;
    return this;
  }

  public e a(int paramInt, double paramDouble)
  {
    return a(paramInt, String.valueOf(paramDouble));
  }

  public e a(int paramInt, float paramFloat)
  {
    return a(paramInt, String.valueOf(paramFloat));
  }

  public e a(int paramInt1, int paramInt2, char paramChar)
  {
    return a(String.valueOf(paramInt1), paramInt2, paramChar);
  }

  public e a(int paramInt1, int paramInt2, String paramString)
  {
    int i = f(paramInt1, paramInt2);
    if (paramString == null);
    for (int j = 0; ; j = paramString.length())
    {
      a(paramInt1, i, i - paramInt1, paramString, j);
      return this;
    }
  }

  public e a(int paramInt, long paramLong)
  {
    return a(paramInt, String.valueOf(paramLong));
  }

  public e a(int paramInt, Object paramObject)
  {
    if (paramObject == null)
      return a(paramInt, this.f);
    return a(paramInt, paramObject.toString());
  }

  public e a(int paramInt, String paramString)
  {
    i(paramInt);
    if (paramString == null)
      paramString = this.f;
    if (paramString == null);
    for (int i = 0; ; i = paramString.length())
    {
      if (i > 0)
      {
        int j = i + this.c;
        b(j);
        System.arraycopy(this.b, paramInt, this.b, paramInt + i, this.c - paramInt);
        this.c = j;
        paramString.getChars(0, i, this.b, paramInt);
      }
      return this;
    }
  }

  public e a(int paramInt, boolean paramBoolean)
  {
    i(paramInt);
    if (paramBoolean)
    {
      b(4 + this.c);
      System.arraycopy(this.b, paramInt, this.b, paramInt + 4, this.c - paramInt);
      char[] arrayOfChar5 = this.b;
      int n = paramInt + 1;
      arrayOfChar5[paramInt] = 't';
      char[] arrayOfChar6 = this.b;
      int i1 = n + 1;
      arrayOfChar6[n] = 'r';
      char[] arrayOfChar7 = this.b;
      int i2 = i1 + 1;
      arrayOfChar7[i1] = 'u';
      this.b[i2] = 'e';
      this.c = (4 + this.c);
      return this;
    }
    b(5 + this.c);
    System.arraycopy(this.b, paramInt, this.b, paramInt + 5, this.c - paramInt);
    char[] arrayOfChar1 = this.b;
    int i = paramInt + 1;
    arrayOfChar1[paramInt] = 'f';
    char[] arrayOfChar2 = this.b;
    int j = i + 1;
    arrayOfChar2[i] = 'a';
    char[] arrayOfChar3 = this.b;
    int k = j + 1;
    arrayOfChar3[j] = 'l';
    char[] arrayOfChar4 = this.b;
    int m = k + 1;
    arrayOfChar4[k] = 's';
    this.b[m] = 'e';
    this.c = (5 + this.c);
    return this;
  }

  public e a(int paramInt, char[] paramArrayOfChar)
  {
    i(paramInt);
    if (paramArrayOfChar == null)
      this = a(paramInt, this.f);
    int i;
    do
    {
      return this;
      i = paramArrayOfChar.length;
    }
    while (i <= 0);
    b(i + this.c);
    System.arraycopy(this.b, paramInt, this.b, paramInt + i, this.c - paramInt);
    System.arraycopy(paramArrayOfChar, 0, this.b, paramInt, i);
    this.c = (i + this.c);
    return this;
  }

  public e a(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
  {
    i(paramInt1);
    if (paramArrayOfChar == null)
      this = a(paramInt1, this.f);
    do
    {
      return this;
      if ((paramInt2 < 0) || (paramInt2 > paramArrayOfChar.length))
        throw new StringIndexOutOfBoundsException("Invalid offset: " + paramInt2);
      if ((paramInt3 >= 0) && (paramInt2 + paramInt3 <= paramArrayOfChar.length))
        continue;
      throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt3);
    }
    while (paramInt3 <= 0);
    b(paramInt3 + this.c);
    System.arraycopy(this.b, paramInt1, this.b, paramInt1 + paramInt3, this.c - paramInt1);
    System.arraycopy(paramArrayOfChar, paramInt2, this.b, paramInt1, paramInt3);
    this.c = (paramInt3 + this.c);
    return this;
  }

  public e a(long paramLong)
  {
    return c(String.valueOf(paramLong));
  }

  public e a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return j();
    return c(paramCharSequence.toString());
  }

  public e a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null)
      return j();
    return a(paramCharSequence.toString(), paramInt1, paramInt2);
  }

  public e a(Iterable<?> paramIterable)
  {
    if (paramIterable != null)
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
        a(localIterator.next());
    }
    return this;
  }

  public e a(Iterable<?> paramIterable, String paramString)
  {
    if (paramIterable != null)
    {
      String str = p.c(paramString);
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        a(localIterator.next());
        if (!localIterator.hasNext())
          continue;
        c(str);
      }
    }
    return this;
  }

  public e a(Object paramObject)
  {
    if (paramObject == null)
      return j();
    return c(paramObject.toString());
  }

  public e a(Object paramObject, int paramInt, char paramChar)
  {
    String str;
    int i;
    if (paramInt > 0)
    {
      b(paramInt + this.c);
      if (paramObject != null)
        break label78;
      str = b();
      if (str == null)
        str = "";
      i = str.length();
      if (i < paramInt)
        break label87;
      str.getChars(i - paramInt, i, this.b, this.c);
    }
    while (true)
    {
      this.c = (paramInt + this.c);
      return this;
      label78: str = paramObject.toString();
      break;
      label87: int j = paramInt - i;
      for (int k = 0; k < j; k++)
        this.b[(k + this.c)] = paramChar;
      str.getChars(0, i, this.b, j + this.c);
    }
  }

  public e a(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public e a(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramInt > 0))
      c(paramString);
    return this;
  }

  public e a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null)
      this = j();
    do
    {
      return this;
      if ((paramInt1 < 0) || (paramInt1 > paramString.length()))
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
      if ((paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramString.length()))
        continue;
      throw new StringIndexOutOfBoundsException("length must be valid");
    }
    while (paramInt2 <= 0);
    int i = length();
    b(i + paramInt2);
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.b, i);
    this.c = (paramInt2 + this.c);
    return this;
  }

  public e a(String paramString1, String paramString2)
  {
    if (f());
    while (true)
    {
      if (paramString2 != null)
        c(paramString2);
      return this;
      paramString2 = paramString1;
    }
  }

  public e a(StringBuffer paramStringBuffer)
  {
    if (paramStringBuffer == null)
      this = j();
    int i;
    do
    {
      return this;
      i = paramStringBuffer.length();
    }
    while (i <= 0);
    int j = length();
    b(j + i);
    paramStringBuffer.getChars(0, i, this.b, j);
    this.c = (i + this.c);
    return this;
  }

  public e a(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if (paramStringBuffer == null)
      this = j();
    do
    {
      return this;
      if ((paramInt1 < 0) || (paramInt1 > paramStringBuffer.length()))
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
      if ((paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramStringBuffer.length()))
        continue;
      throw new StringIndexOutOfBoundsException("length must be valid");
    }
    while (paramInt2 <= 0);
    int i = length();
    b(i + paramInt2);
    paramStringBuffer.getChars(paramInt1, paramInt1 + paramInt2, this.b, i);
    this.c = (paramInt2 + this.c);
    return this;
  }

  public e a(Iterator<?> paramIterator)
  {
    if (paramIterator != null)
      while (paramIterator.hasNext())
        a(paramIterator.next());
    return this;
  }

  public e a(Iterator<?> paramIterator, String paramString)
  {
    if (paramIterator != null)
    {
      String str = p.c(paramString);
      while (paramIterator.hasNext())
      {
        a(paramIterator.next());
        if (!paramIterator.hasNext())
          continue;
        c(str);
      }
    }
    return this;
  }

  public e a(e parame)
  {
    if (parame == null)
      this = j();
    int i;
    do
    {
      return this;
      i = parame.length();
    }
    while (i <= 0);
    int j = length();
    b(j + i);
    System.arraycopy(parame.b, 0, this.b, j, i);
    this.c = (i + this.c);
    return this;
  }

  public e a(e parame, int paramInt1, int paramInt2)
  {
    if (parame == null)
      this = j();
    do
    {
      return this;
      if ((paramInt1 < 0) || (paramInt1 > parame.length()))
        throw new StringIndexOutOfBoundsException("startIndex must be valid");
      if ((paramInt2 >= 0) && (paramInt1 + paramInt2 <= parame.length()))
        continue;
      throw new StringIndexOutOfBoundsException("length must be valid");
    }
    while (paramInt2 <= 0);
    int i = length();
    b(i + paramInt2);
    parame.a(paramInt1, paramInt1 + paramInt2, this.b, i);
    this.c = (paramInt2 + this.c);
    return this;
  }

  public e a(g paramg)
  {
    return a(paramg, null, 0, this.c, -1);
  }

  public e a(g paramg, String paramString)
  {
    return a(paramg, paramString, 0, this.c, -1);
  }

  public e a(g paramg, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return b(paramg, paramString, paramInt1, f(paramInt1, paramInt2), paramInt3);
  }

  public e a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(4 + this.c);
      char[] arrayOfChar6 = this.b;
      int i1 = this.c;
      this.c = (i1 + 1);
      arrayOfChar6[i1] = 't';
      char[] arrayOfChar7 = this.b;
      int i2 = this.c;
      this.c = (i2 + 1);
      arrayOfChar7[i2] = 'r';
      char[] arrayOfChar8 = this.b;
      int i3 = this.c;
      this.c = (i3 + 1);
      arrayOfChar8[i3] = 'u';
      char[] arrayOfChar9 = this.b;
      int i4 = this.c;
      this.c = (i4 + 1);
      arrayOfChar9[i4] = 'e';
      return this;
    }
    b(5 + this.c);
    char[] arrayOfChar1 = this.b;
    int i = this.c;
    this.c = (i + 1);
    arrayOfChar1[i] = 'f';
    char[] arrayOfChar2 = this.b;
    int j = this.c;
    this.c = (j + 1);
    arrayOfChar2[j] = 'a';
    char[] arrayOfChar3 = this.b;
    int k = this.c;
    this.c = (k + 1);
    arrayOfChar3[k] = 'l';
    char[] arrayOfChar4 = this.b;
    int m = this.c;
    this.c = (m + 1);
    arrayOfChar4[m] = 's';
    char[] arrayOfChar5 = this.b;
    int n = this.c;
    this.c = (n + 1);
    arrayOfChar5[n] = 'e';
    return this;
  }

  public e a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramArrayOfChar == null)
      this = j();
    do
    {
      return this;
      if ((paramInt1 < 0) || (paramInt1 > paramArrayOfChar.length))
        throw new StringIndexOutOfBoundsException("Invalid startIndex: " + paramInt2);
      if ((paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfChar.length))
        continue;
      throw new StringIndexOutOfBoundsException("Invalid length: " + paramInt2);
    }
    while (paramInt2 <= 0);
    int i = length();
    b(i + paramInt2);
    System.arraycopy(paramArrayOfChar, paramInt1, this.b, i, paramInt2);
    this.c = (paramInt2 + this.c);
    return this;
  }

  public e a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      int i = paramArrayOfObject.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfObject[j]);
    }
    return this;
  }

  public e a(Object[] paramArrayOfObject, String paramString)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      String str = p.c(paramString);
      a(paramArrayOfObject[0]);
      for (int i = 1; i < paramArrayOfObject.length; i++)
      {
        c(str);
        a(paramArrayOfObject[i]);
      }
    }
    return this;
  }

  public void a(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    if (paramInt1 < 0)
      throw new StringIndexOutOfBoundsException(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 > length()))
      throw new StringIndexOutOfBoundsException(paramInt2);
    if (paramInt1 > paramInt2)
      throw new StringIndexOutOfBoundsException("end < start");
    System.arraycopy(this.b, paramInt1, paramArrayOfChar, paramInt3, paramInt2 - paramInt1);
  }

  public char[] a(int paramInt1, int paramInt2)
  {
    int i = f(paramInt1, paramInt2) - paramInt1;
    if (i == 0)
      return c.r;
    char[] arrayOfChar = new char[i];
    System.arraycopy(this.b, paramInt1, arrayOfChar, 0, i);
    return arrayOfChar;
  }

  public char[] a(char[] paramArrayOfChar)
  {
    int i = length();
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length < i))
      paramArrayOfChar = new char[i];
    System.arraycopy(this.b, 0, paramArrayOfChar, 0, i);
    return paramArrayOfChar;
  }

  public int b(char paramChar, int paramInt)
  {
    if (paramInt < 0)
      paramInt = 0;
    if (paramInt >= this.c)
    {
      paramInt = -1;
      return paramInt;
    }
    char[] arrayOfChar = this.b;
    while (true)
    {
      if (paramInt >= this.c)
        break label44;
      if (arrayOfChar[paramInt] == paramChar)
        break;
      paramInt++;
    }
    label44: return -1;
  }

  public int b(String paramString, int paramInt)
  {
    int i;
    if (paramInt < 0)
    {
      i = 0;
      if ((paramString != null) && (i < this.c))
        break label27;
      i = -1;
    }
    label27: label125: 
    while (true)
    {
      return i;
      i = paramInt;
      break;
      int j = paramString.length();
      if (j == 1)
        return b(paramString.charAt(0), i);
      if (j == 0)
        continue;
      if (j > this.c)
        return -1;
      char[] arrayOfChar = this.b;
      int k = 1 + (this.c - j);
      if (i >= k)
        break label127;
      for (int m = 0; ; m++)
      {
        if (m >= j)
          break label125;
        if (paramString.charAt(m) == arrayOfChar[(i + m)])
          continue;
        i++;
        break;
      }
    }
    label127: return -1;
  }

  public int b(g paramg, int paramInt)
  {
    if (paramInt >= this.c);
    for (int i = -1 + this.c; (paramg == null) || (i < 0); i = paramInt)
    {
      i = -1;
      return i;
    }
    char[] arrayOfChar = this.b;
    int j = i + 1;
    while (true)
    {
      if (i < 0)
        break label66;
      if (paramg.a(arrayOfChar, i, 0, j) > 0)
        break;
      i--;
    }
    label66: return -1;
  }

  public String b()
  {
    return this.f;
  }

  public e b(char paramChar)
  {
    return a(paramChar).i();
  }

  public e b(char paramChar1, char paramChar2)
  {
    if (paramChar1 != paramChar2)
      for (int i = 0; i < this.c; i++)
      {
        if (this.b[i] != paramChar1)
          continue;
        this.b[i] = paramChar2;
      }
    return this;
  }

  public e b(double paramDouble)
  {
    return a(paramDouble).i();
  }

  public e b(float paramFloat)
  {
    return a(paramFloat).i();
  }

  public e b(int paramInt)
  {
    if (paramInt > this.b.length)
    {
      char[] arrayOfChar = this.b;
      this.b = new char[paramInt * 2];
      System.arraycopy(arrayOfChar, 0, this.b, 0, this.c);
    }
    return this;
  }

  public e b(int paramInt, char paramChar)
  {
    if (paramInt >= 0)
    {
      b(paramInt + this.c);
      for (int i = 0; i < paramInt; i++)
      {
        char[] arrayOfChar = this.b;
        int j = this.c;
        this.c = (j + 1);
        arrayOfChar[j] = paramChar;
      }
    }
    return this;
  }

  public e b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, String.valueOf(paramInt2));
  }

  public e b(int paramInt1, int paramInt2, char paramChar)
  {
    return b(String.valueOf(paramInt1), paramInt2, paramChar);
  }

  public e b(long paramLong)
  {
    return a(paramLong).i();
  }

  public e b(Object paramObject)
  {
    return a(paramObject).i();
  }

  public e b(Object paramObject, int paramInt, char paramChar)
  {
    String str;
    int i;
    if (paramInt > 0)
    {
      b(paramInt + this.c);
      if (paramObject != null)
        break label74;
      str = b();
      if (str == null)
        str = "";
      i = str.length();
      if (i < paramInt)
        break label83;
      str.getChars(0, paramInt, this.b, this.c);
    }
    while (true)
    {
      this.c = (paramInt + this.c);
      return this;
      label74: str = paramObject.toString();
      break;
      label83: int j = paramInt - i;
      str.getChars(0, i, this.b, this.c);
      for (int k = 0; k < j; k++)
        this.b[(k + (i + this.c))] = paramChar;
    }
  }

  public e b(String paramString)
  {
    if ((paramString != null) && (paramString.length() == 0))
      paramString = null;
    this.f = paramString;
    return this;
  }

  public e b(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2).i();
  }

  public e b(String paramString1, String paramString2)
  {
    int i;
    if (paramString1 == null)
    {
      i = 0;
      if (i <= 0)
        break label76;
      if (paramString2 != null)
        break label67;
    }
    label67: for (int j = 0; ; j = paramString2.length())
    {
      for (int k = b(paramString1, 0); k >= 0; k = b(paramString1, k + j))
        a(k, k + i, i, paramString2, j);
      i = paramString1.length();
      break;
    }
    label76: return this;
  }

  public e b(StringBuffer paramStringBuffer)
  {
    return a(paramStringBuffer).i();
  }

  public e b(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    return a(paramStringBuffer, paramInt1, paramInt2).i();
  }

  public e b(e parame)
  {
    return a(parame).i();
  }

  public e b(e parame, int paramInt1, int paramInt2)
  {
    return a(parame, paramInt1, paramInt2).i();
  }

  public e b(g paramg)
  {
    return a(paramg, null, 0, this.c, 1);
  }

  public e b(g paramg, String paramString)
  {
    return a(paramg, paramString, 0, this.c, 1);
  }

  public e b(boolean paramBoolean)
  {
    return a(paramBoolean).i();
  }

  public e b(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
      this = j();
    int i;
    do
    {
      return this;
      i = paramArrayOfChar.length;
    }
    while (i <= 0);
    int j = length();
    b(j + i);
    System.arraycopy(paramArrayOfChar, 0, this.b, j, i);
    this.c = (i + this.c);
    return this;
  }

  public e b(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return a(paramArrayOfChar, paramInt1, paramInt2).i();
  }

  public int c()
  {
    return this.b.length;
  }

  public int c(char paramChar, int paramInt)
  {
    int i;
    if (paramInt >= this.c)
    {
      i = -1 + this.c;
      if (i >= 0)
        break label29;
    }
    label29: 
    do
      do
      {
        return -1;
        i = paramInt;
        break;
        i--;
      }
      while (i < 0);
    while (this.b[i] != paramChar);
    return i;
  }

  public int c(String paramString, int paramInt)
  {
    int i;
    if (paramInt >= this.c)
    {
      i = -1 + this.c;
      if ((paramString != null) && (i >= 0))
        break label32;
      i = -1;
    }
    label32: int j;
    label118: label120: 
    do
      while (true)
      {
        return i;
        i = paramInt;
        break;
        j = paramString.length();
        if ((j <= 0) || (j > this.c))
          break label120;
        if (j == 1)
          return c(paramString.charAt(0), i);
        i = 1 + (i - j);
        if (i < 0)
          break label125;
        for (int k = 0; ; k++)
        {
          if (k >= j)
            break label118;
          if (paramString.charAt(k) == this.b[(i + k)])
            continue;
          i--;
          break;
        }
      }
    while (j == 0);
    label125: return -1;
  }

  public e c(char paramChar)
  {
    if (e() > 0)
      a(paramChar);
    return this;
  }

  public e c(char paramChar1, char paramChar2)
  {
    if (paramChar1 != paramChar2);
    for (int i = 0; ; i++)
    {
      if (i < this.c)
      {
        if (this.b[i] != paramChar1)
          continue;
        this.b[i] = paramChar2;
      }
      return this;
    }
  }

  public e c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.c))
      throw new StringIndexOutOfBoundsException(paramInt);
    a(paramInt, paramInt + 1, 1);
    return this;
  }

  public e c(int paramInt, char paramChar)
  {
    i(paramInt);
    b(1 + this.c);
    System.arraycopy(this.b, paramInt, this.b, paramInt + 1, this.c - paramInt);
    this.b[paramInt] = paramChar;
    this.c = (1 + this.c);
    return this;
  }

  public e c(int paramInt1, int paramInt2)
  {
    int i = f(paramInt1, paramInt2);
    int j = i - paramInt1;
    if (j > 0)
      a(paramInt1, i, j);
    return this;
  }

  public e c(String paramString)
  {
    if (paramString == null)
      this = j();
    int i;
    do
    {
      return this;
      i = paramString.length();
    }
    while (i <= 0);
    int j = length();
    b(j + i);
    paramString.getChars(0, i, this.b, j);
    this.c = (i + this.c);
    return this;
  }

  public e c(String paramString1, String paramString2)
  {
    int i;
    int j;
    int k;
    if (paramString1 == null)
    {
      i = 0;
      if (i > 0)
      {
        j = b(paramString1, 0);
        if (j >= 0)
        {
          k = 0;
          if (paramString2 != null)
            break label54;
        }
      }
    }
    while (true)
    {
      a(j, j + i, i, paramString2, k);
      return this;
      i = paramString1.length();
      break;
      label54: k = paramString2.length();
    }
  }

  public e c(char[] paramArrayOfChar)
  {
    return b(paramArrayOfChar).i();
  }

  public boolean c(e parame)
  {
    if (this == parame);
    while (true)
    {
      return true;
      if (this.c != parame.c)
        return false;
      char[] arrayOfChar1 = this.b;
      char[] arrayOfChar2 = parame.b;
      for (int i = -1 + this.c; i >= 0; i--)
      {
        char c1 = arrayOfChar1[i];
        char c2 = arrayOfChar2[i];
        if ((c1 != c2) && (Character.toUpperCase(c1) != Character.toUpperCase(c2)))
          return false;
      }
    }
  }

  public boolean c(g paramg)
  {
    int i = a(paramg, 0);
    int j = 0;
    if (i >= 0)
      j = 1;
    return j;
  }

  public char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= length()))
      throw new StringIndexOutOfBoundsException(paramInt);
    return this.b[paramInt];
  }

  public int d(g paramg)
  {
    return a(paramg, 0);
  }

  public String d(int paramInt1, int paramInt2)
  {
    int i = f(paramInt1, paramInt2);
    return new String(this.b, paramInt1, i - paramInt1);
  }

  public e d()
  {
    if (this.b.length > length())
    {
      char[] arrayOfChar = this.b;
      this.b = new char[length()];
      System.arraycopy(arrayOfChar, 0, this.b, 0, this.c);
    }
    return this;
  }

  public e d(char paramChar)
  {
    for (int i = 0; i < this.c; i++)
    {
      if (this.b[i] != paramChar)
        continue;
      int j = i;
      do
        j++;
      while ((j < this.c) && (this.b[j] == paramChar));
      int k = j - i;
      a(i, j, k);
      i = j - k;
    }
    return this;
  }

  public e d(int paramInt)
  {
    return c(String.valueOf(paramInt));
  }

  public e d(String paramString)
  {
    return c(paramString).i();
  }

  public boolean d(e parame)
  {
    if (this == parame);
    while (true)
    {
      return true;
      if (this.c != parame.c)
        return false;
      char[] arrayOfChar1 = this.b;
      char[] arrayOfChar2 = parame.b;
      for (int i = -1 + this.c; i >= 0; i--)
        if (arrayOfChar1[i] != arrayOfChar2[i])
          return false;
    }
  }

  public int e()
  {
    return this.c;
  }

  public int e(g paramg)
  {
    return b(paramg, this.c);
  }

  public String e(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      paramInt1 = 0;
    if ((paramInt2 <= 0) || (paramInt1 >= this.c))
      return "";
    if (this.c <= paramInt1 + paramInt2)
      return new String(this.b, paramInt1, this.c - paramInt1);
    return new String(this.b, paramInt1, paramInt2);
  }

  public e e(char paramChar)
  {
    for (int i = 0; ; i++)
    {
      if (i < this.c)
      {
        if (this.b[i] != paramChar)
          continue;
        a(i, i + 1, 1);
      }
      return this;
    }
  }

  public e e(int paramInt)
  {
    return d(paramInt).i();
  }

  public e e(String paramString)
  {
    return a(paramString, null);
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof e))
      return d((e)paramObject);
    return false;
  }

  protected int f(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new StringIndexOutOfBoundsException(paramInt1);
    if (paramInt2 > this.c)
      paramInt2 = this.c;
    if (paramInt1 > paramInt2)
      throw new StringIndexOutOfBoundsException("end < start");
    return paramInt2;
  }

  public String f(int paramInt)
  {
    return d(paramInt, this.c);
  }

  public e f(String paramString)
  {
    if (paramString == null);
    for (int i = 0; i > 0; i = paramString.length())
      for (int j = b(paramString, 0); j >= 0; j = b(paramString, j))
        a(j, j + i, i);
    return this;
  }

  public boolean f()
  {
    return this.c == 0;
  }

  public boolean f(char paramChar)
  {
    char[] arrayOfChar = this.b;
    for (int i = 0; ; i++)
    {
      int j = this.c;
      int k = 0;
      if (i < j)
      {
        if (arrayOfChar[i] != paramChar)
          continue;
        k = 1;
      }
      return k;
    }
  }

  public int g(char paramChar)
  {
    return b(paramChar, 0);
  }

  public String g(int paramInt)
  {
    if (paramInt <= 0)
      return "";
    if (paramInt >= this.c)
      return new String(this.b, 0, this.c);
    return new String(this.b, 0, paramInt);
  }

  public e g()
  {
    this.c = 0;
    return this;
  }

  public e g(String paramString)
  {
    if (paramString == null);
    for (int i = 0; ; i = paramString.length())
    {
      if (i > 0)
      {
        int j = b(paramString, 0);
        if (j >= 0)
          a(j, j + i, i);
      }
      return this;
    }
  }

  public int h(char paramChar)
  {
    return c(paramChar, -1 + this.c);
  }

  public String h(int paramInt)
  {
    if (paramInt <= 0)
      return "";
    if (paramInt >= this.c)
      return new String(this.b, 0, this.c);
    return new String(this.b, this.c - paramInt, paramInt);
  }

  public boolean h(String paramString)
  {
    if (paramString == null);
    int i;
    do
    {
      return false;
      i = paramString.length();
      if (i == 0)
        return true;
    }
    while (i > this.c);
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label52;
      if (this.b[j] != paramString.charAt(j))
        break;
    }
    label52: return true;
  }

  public char[] h()
  {
    if (this.c == 0)
      return c.r;
    char[] arrayOfChar = new char[this.c];
    System.arraycopy(this.b, 0, arrayOfChar, 0, this.c);
    return arrayOfChar;
  }

  public int hashCode()
  {
    char[] arrayOfChar = this.b;
    int i = 0;
    for (int j = -1 + this.c; j >= 0; j--)
      i = i * 31 + arrayOfChar[j];
    return i;
  }

  public e i()
  {
    if (this.e == null)
    {
      c(w.F);
      return this;
    }
    return c(this.e);
  }

  protected void i(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.c))
      throw new StringIndexOutOfBoundsException(paramInt);
  }

  public boolean i(String paramString)
  {
    if (paramString == null);
    int i;
    do
    {
      return false;
      i = paramString.length();
      if (i == 0)
        return true;
    }
    while (i > this.c);
    int j = this.c - i;
    int k = 0;
    while (true)
    {
      if (k >= i)
        break label65;
      if (this.b[j] != paramString.charAt(k))
        break;
      k++;
      j++;
    }
    label65: return true;
  }

  public e j()
  {
    if (this.f == null)
      return this;
    return c(this.f);
  }

  public boolean j(String paramString)
  {
    int i = b(paramString, 0);
    int j = 0;
    if (i >= 0)
      j = 1;
    return j;
  }

  public int k(String paramString)
  {
    return b(paramString, 0);
  }

  public e k()
  {
    if (this.c == 0);
    while (true)
    {
      return this;
      int i = this.c / 2;
      char[] arrayOfChar = this.b;
      int j = 0;
      for (int k = -1 + this.c; j < i; k--)
      {
        int m = arrayOfChar[j];
        arrayOfChar[j] = arrayOfChar[k];
        arrayOfChar[k] = m;
        j++;
      }
    }
  }

  public int l(String paramString)
  {
    return c(paramString, -1 + this.c);
  }

  public e l()
  {
    if (this.c == 0);
    int j;
    do
    {
      return this;
      int i = this.c;
      char[] arrayOfChar = this.b;
      for (j = 0; (j < i) && (arrayOfChar[j] <= ' '); j++);
      while ((j < i) && (arrayOfChar[(i - 1)] <= ' '))
        i--;
      if (i >= this.c)
        continue;
      c(i, this.c);
    }
    while (j <= 0);
    c(0, j);
    return this;
  }

  public int length()
  {
    return this.c;
  }

  public i m()
  {
    return new b();
  }

  public Reader n()
  {
    return new a();
  }

  public Writer o()
  {
    return new c();
  }

  public StringBuffer p()
  {
    return new StringBuffer(this.c).append(this.b, 0, this.c);
  }

  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new StringIndexOutOfBoundsException(paramInt1);
    if (paramInt2 > this.c)
      throw new StringIndexOutOfBoundsException(paramInt2);
    if (paramInt1 > paramInt2)
      throw new StringIndexOutOfBoundsException(paramInt2 - paramInt1);
    return d(paramInt1, paramInt2);
  }

  public String toString()
  {
    return new String(this.b, 0, this.c);
  }

  class a extends Reader
  {
    private int b;
    private int c;

    a()
    {
    }

    public void close()
    {
    }

    public void mark(int paramInt)
    {
      this.c = this.b;
    }

    public boolean markSupported()
    {
      return true;
    }

    public int read()
    {
      if (!ready())
        return -1;
      e locale = e.this;
      int i = this.b;
      this.b = (i + 1);
      return locale.charAt(i);
    }

    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 > paramArrayOfChar.length) || (paramInt1 + paramInt2 > paramArrayOfChar.length) || (paramInt1 + paramInt2 < 0))
        throw new IndexOutOfBoundsException();
      if (paramInt2 == 0)
        return 0;
      if (this.b >= e.this.e())
        return -1;
      if (paramInt2 + this.b > e.this.e())
        paramInt2 = e.this.e() - this.b;
      e.this.a(this.b, paramInt2 + this.b, paramArrayOfChar, paramInt1);
      this.b = (paramInt2 + this.b);
      return paramInt2;
    }

    public boolean ready()
    {
      return this.b < e.this.e();
    }

    public void reset()
    {
      this.b = this.c;
    }

    public long skip(long paramLong)
    {
      long l;
      if (paramLong + this.b > e.this.e())
        l = e.this.e() - this.b;
      while (true)
      {
        if (l < 0L)
          return 0L;
        this.b = (int)(l + this.b);
        return l;
        l = paramLong;
      }
    }
  }

  class b extends i
  {
    b()
    {
    }

    public String a()
    {
      String str = super.a();
      if (str == null)
        str = e.this.toString();
      return str;
    }

    protected List<String> a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if (paramArrayOfChar == null)
        return super.a(e.this.b, 0, e.this.e());
      return super.a(paramArrayOfChar, paramInt1, paramInt2);
    }
  }

  class c extends Writer
  {
    c()
    {
    }

    public void close()
    {
    }

    public void flush()
    {
    }

    public void write(int paramInt)
    {
      e.this.a((char)paramInt);
    }

    public void write(String paramString)
    {
      e.this.c(paramString);
    }

    public void write(String paramString, int paramInt1, int paramInt2)
    {
      e.this.a(paramString, paramInt1, paramInt2);
    }

    public void write(char[] paramArrayOfChar)
    {
      e.this.b(paramArrayOfChar);
    }

    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      e.this.a(paramArrayOfChar, paramInt1, paramInt2);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.e
 * JD-Core Version:    0.6.0
 */