package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;

public class h extends b
{
  private static int a = 377;

  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    if ((paramCharSequence.charAt(paramInt) == '\\') && (paramInt < -1 + paramCharSequence.length()) && (Character.isDigit(paramCharSequence.charAt(paramInt + 1))))
    {
      int i = paramInt + 1;
      int j = paramInt + 2;
      while ((j < paramCharSequence.length()) && (Character.isDigit(paramCharSequence.charAt(j))))
      {
        j++;
        if (Integer.parseInt(paramCharSequence.subSequence(i, j).toString(), 10) <= a)
          continue;
        j--;
      }
      paramWriter.write(Integer.parseInt(paramCharSequence.subSequence(i, j).toString(), 8));
      return j + 1 - i;
    }
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.h
 * JD-Core Version:    0.6.0
 */