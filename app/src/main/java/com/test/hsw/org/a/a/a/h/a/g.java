package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.EnumSet;

public class g extends b
{
  private final EnumSet<a> a;

  public g(a[] paramArrayOfa)
  {
    if (paramArrayOfa.length > 0)
    {
      this.a = EnumSet.copyOf(Arrays.asList(paramArrayOfa));
      return;
    }
    a[] arrayOfa = new a[1];
    arrayOfa[0] = a.a;
    this.a = EnumSet.copyOf(Arrays.asList(arrayOfa));
  }

  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    int i = 1;
    int j = paramCharSequence.length();
    int k;
    int n;
    if ((paramCharSequence.charAt(paramInt) == '&') && (paramInt < j - 2) && (paramCharSequence.charAt(paramInt + 1) == '#'))
    {
      k = paramInt + 2;
      int m = paramCharSequence.charAt(k);
      if ((m != 120) && (m != 88))
        break label405;
      n = k + 1;
      if (n != j);
    }
    else
    {
      return 0;
    }
    int i1 = n;
    for (int i2 = i; ; i2 = 0)
    {
      for (int i3 = i1; (i3 < j) && (((paramCharSequence.charAt(i3) >= '0') && (paramCharSequence.charAt(i3) <= '9')) || ((paramCharSequence.charAt(i3) >= 'a') && (paramCharSequence.charAt(i3) <= 'f')) || ((paramCharSequence.charAt(i3) >= 'A') && (paramCharSequence.charAt(i3) <= 'F'))); i3++);
      if ((i3 != j) && (paramCharSequence.charAt(i3) == ';'));
      for (int i4 = i; ; i4 = 0)
      {
        if (i4 != 0)
          break label257;
        if (a(a.a))
          break;
        if (!a(a.c))
          break label257;
        throw new IllegalArgumentException("Semi-colon required at end of numeric entity");
      }
      label257: if (i2 != 0);
      try
      {
        int i10 = Integer.parseInt(paramCharSequence.subSequence(i1, i3).toString(), 16);
        int i6 = i10;
        label317: int i8;
        label335: int i9;
        if (i6 > 65535)
        {
          char[] arrayOfChar = Character.toChars(i6);
          paramWriter.write(arrayOfChar[0]);
          paramWriter.write(arrayOfChar[i]);
          int i7 = i3 + 2 - i1;
          if (i2 == 0)
            break label389;
          i8 = i;
          i9 = i8 + i7;
          if (i4 == 0)
            break label395;
        }
        while (true)
        {
          return i9 + i;
          int i5 = Integer.parseInt(paramCharSequence.subSequence(i1, i3).toString(), 10);
          i6 = i5;
          break;
          paramWriter.write(i6);
          break label317;
          label389: i8 = 0;
          break label335;
          label395: i = 0;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return 0;
      }
      label405: i1 = k;
    }
  }

  public boolean a(a parama)
  {
    if (this.a == null)
      return false;
    return this.a.contains(parama);
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      d = arrayOfa;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.g
 * JD-Core Version:    0.6.0
 */