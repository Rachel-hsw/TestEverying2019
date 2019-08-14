package org.a.a.a.h.a;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

public class e extends b
{
  private final HashMap<CharSequence, CharSequence> a = new HashMap();
  private final int b;
  private final int c;

  public e(CharSequence[][] paramArrayOfCharSequence)
  {
    int i = 2147483647;
    int j;
    int i1;
    if (paramArrayOfCharSequence != null)
    {
      int k = paramArrayOfCharSequence.length;
      int m = 0;
      j = 0;
      int n = i;
      while (true)
        if (m < k)
        {
          CharSequence[] arrayOfCharSequence = paramArrayOfCharSequence[m];
          this.a.put(arrayOfCharSequence[0], arrayOfCharSequence[1]);
          i1 = arrayOfCharSequence[0].length();
          if (i1 < n)
            n = i1;
          if (i1 <= j)
            break;
          m++;
          j = i1;
          continue;
        }
        else
        {
          i = n;
        }
    }
    while (true)
    {
      this.b = i;
      this.c = j;
      return;
      i1 = j;
      break;
      j = 0;
    }
  }

  public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
    throws IOException
  {
    int i = this.c;
    if (paramInt + this.c > paramCharSequence.length())
      i = paramCharSequence.length() - paramInt;
    for (int j = i; j >= this.b; j--)
    {
      CharSequence localCharSequence1 = paramCharSequence.subSequence(paramInt, paramInt + j);
      CharSequence localCharSequence2 = (CharSequence)this.a.get(localCharSequence1);
      if (localCharSequence2 == null)
        continue;
      paramWriter.write(localCharSequence2.toString());
      return j;
    }
    return 0;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.a.e
 * JD-Core Version:    0.6.0
 */