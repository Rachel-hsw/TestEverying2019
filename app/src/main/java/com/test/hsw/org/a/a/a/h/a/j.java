package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;

public class j extends b
{
  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    if ((paramCharSequence.charAt(paramInt) == '\\') && (paramInt + 1 < paramCharSequence.length()) && (paramCharSequence.charAt(paramInt + 1) == 'u'))
    {
      for (int i = 2; (paramInt + i < paramCharSequence.length()) && (paramCharSequence.charAt(paramInt + i) == 'u'); i++);
      if ((paramInt + i < paramCharSequence.length()) && (paramCharSequence.charAt(paramInt + i) == '+'))
        i++;
      if (4 + (paramInt + i) <= paramCharSequence.length())
      {
        CharSequence localCharSequence = paramCharSequence.subSequence(paramInt + i, 4 + (paramInt + i));
        try
        {
          paramWriter.write((char)Integer.parseInt(localCharSequence.toString(), 16));
          return i + 4;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new IllegalArgumentException("Unable to parse unicode value: " + localCharSequence, localNumberFormatException);
        }
      }
      throw new IllegalArgumentException("Less than 4 hex digits in unicode value: '" + paramCharSequence.subSequence(paramInt, paramCharSequence.length()) + "' due to end of CharSequence");
    }
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.j
 * JD-Core Version:    0.6.0
 */