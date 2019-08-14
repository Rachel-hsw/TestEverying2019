package org.a.a.a.h;

import java.util.Formattable;
import java.util.Formatter;
import org.a.a.a.p;
import org.a.a.a.x;

public class d
{
  private static final String a = "%s";

  public static String a(Formattable paramFormattable)
  {
    return String.format("%s", new Object[] { paramFormattable });
  }

  public static Formatter a(CharSequence paramCharSequence, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', null);
  }

  public static Formatter a(CharSequence paramCharSequence, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, char paramChar)
  {
    return a(paramCharSequence, paramFormatter, paramInt1, paramInt2, paramInt3, paramChar, null);
  }

  public static Formatter a(CharSequence paramCharSequence1, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, char paramChar, CharSequence paramCharSequence2)
  {
    int i = 1;
    StringBuilder localStringBuilder;
    label133: int m;
    if ((paramCharSequence2 == null) || (paramInt3 < 0) || (paramCharSequence2.length() <= paramInt3))
    {
      int j = i;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramCharSequence2;
      arrayOfObject[i] = Integer.valueOf(paramInt3);
      x.a(j, "Specified ellipsis '%1$s' exceeds precision of %2$s", arrayOfObject);
      localStringBuilder = new StringBuilder(paramCharSequence1);
      if ((paramInt3 >= 0) && (paramInt3 < paramCharSequence1.length()))
      {
        CharSequence localCharSequence = (CharSequence)p.a(paramCharSequence2, "");
        localStringBuilder.replace(paramInt3 - localCharSequence.length(), paramCharSequence1.length(), localCharSequence.toString());
      }
      if ((paramInt1 & 0x1) != i)
        break label177;
      m = localStringBuilder.length();
      label140: if (m >= paramInt2)
        break label189;
      if (i == 0)
        break label183;
    }
    label177: label183: for (int n = m; ; n = 0)
    {
      localStringBuilder.insert(n, paramChar);
      m++;
      break label140;
      int k = 0;
      break;
      i = 0;
      break label133;
    }
    label189: paramFormatter.format(localStringBuilder.toString(), new Object[0]);
    return paramFormatter;
  }

  public static Formatter a(CharSequence paramCharSequence1, Formatter paramFormatter, int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence2)
  {
    return a(paramCharSequence1, paramFormatter, paramInt1, paramInt2, paramInt3, ' ', paramCharSequence2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.h.d
 * JD-Core Version:    0.6.0
 */