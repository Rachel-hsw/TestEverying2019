package com.himamis.retex.renderer.a.h;

public class a
{
  public static String a(String paramString)
  {
    if ((paramString.indexOf('\\') == -1) && (paramString.indexOf('$') == -1))
      return paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; ; i++)
    {
      if (i >= paramString.length())
        return localStringBuilder.toString();
      char c = paramString.charAt(i);
      if ((c == '\\') || (c == '$'))
        localStringBuilder.append('\\');
      localStringBuilder.append(c);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.h.a
 * JD-Core Version:    0.6.0
 */