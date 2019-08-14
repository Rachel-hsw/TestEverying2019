package com.squareup.a;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class s
{
  private static final String a = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  private static final String b = "\"([^\"]*)\"";
  private static final Pattern c = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  private static final Pattern d = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  private final String e;
  private final String f;
  private final String g;
  private final String h;

  private s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.h = paramString4;
  }

  public static s a(String paramString)
  {
    Matcher localMatcher1 = c.matcher(paramString);
    if (!localMatcher1.lookingAt());
    String str1;
    String str2;
    String str3;
    while (true)
    {
      return null;
      str1 = localMatcher1.group(1).toLowerCase(Locale.US);
      str2 = localMatcher1.group(2).toLowerCase(Locale.US);
      Matcher localMatcher2 = d.matcher(paramString);
      int i = localMatcher1.end();
      str3 = null;
      if (i >= paramString.length())
        break;
      localMatcher2.region(i, paramString.length());
      if (!localMatcher2.lookingAt())
        continue;
      String str4 = localMatcher2.group(1);
      if ((str4 == null) || (!str4.equalsIgnoreCase("charset")));
      while (true)
      {
        i = localMatcher2.end();
        break;
        if (str3 != null)
          throw new IllegalArgumentException("Multiple charsets: " + paramString);
        if (localMatcher2.group(2) != null)
        {
          str3 = localMatcher2.group(2);
          continue;
        }
        str3 = localMatcher2.group(3);
      }
    }
    return new s(paramString, str1, str2, str3);
  }

  public String a()
  {
    return this.f;
  }

  public Charset a(Charset paramCharset)
  {
    if (this.h != null)
      paramCharset = Charset.forName(this.h);
    return paramCharset;
  }

  public String b()
  {
    return this.g;
  }

  public Charset c()
  {
    if (this.h != null)
      return Charset.forName(this.h);
    return null;
  }

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof s)) && (((s)paramObject).e.equals(this.e));
  }

  public int hashCode()
  {
    return this.e.hashCode();
  }

  public String toString()
  {
    return this.e;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.s
 * JD-Core Version:    0.6.0
 */