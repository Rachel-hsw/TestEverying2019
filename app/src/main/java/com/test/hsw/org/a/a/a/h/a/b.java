package org.a.a.a.h.a;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

public abstract class b
{
  public static String a(int paramInt)
  {
    return Integer.toHexString(paramInt).toUpperCase(Locale.ENGLISH);
  }

  public abstract int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException;

  public final String a(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null)
      return null;
    try
    {
      StringWriter localStringWriter = new StringWriter(2 * paramCharSequence.length());
      a(paramCharSequence, localStringWriter);
      String str = localStringWriter.toString();
      return str;
    }
    catch (IOException localIOException)
    {
    }
    throw new RuntimeException(localIOException);
  }

  public final b a(b[] paramArrayOfb)
  {
    b[] arrayOfb = new b[1 + paramArrayOfb.length];
    arrayOfb[0] = this;
    System.arraycopy(paramArrayOfb, 0, arrayOfb, 1, paramArrayOfb.length);
    return new a(arrayOfb);
  }

  public final void a(CharSequence paramCharSequence, Writer paramWriter)
    throws IOException
  {
    if (paramWriter == null)
      throw new IllegalArgumentException("The Writer must not be null");
    if (paramCharSequence == null);
    while (true)
    {
      return;
      int i = paramCharSequence.length();
      int j = 0;
      while (j < i)
      {
        int k = a(paramCharSequence, j, paramWriter);
        if (k == 0)
        {
          char[] arrayOfChar = Character.toChars(Character.codePointAt(paramCharSequence, j));
          paramWriter.write(arrayOfChar);
          j += arrayOfChar.length;
          continue;
        }
        int m = j;
        for (int n = 0; n < k; n++)
          m += Character.charCount(Character.codePointAt(paramCharSequence, m));
        j = m;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.b
 * JD-Core Version:    0.6.0
 */