package org.a.a.a;

import java.io.IOException;
import java.io.Writer;
import org.a.a.a.h.a.a;
import org.a.a.a.h.a.b;
import org.a.a.a.h.a.d;
import org.a.a.a.h.a.e;
import org.a.a.a.h.a.g;
import org.a.a.a.h.a.g.a;
import org.a.a.a.h.a.h;
import org.a.a.a.h.a.i;
import org.a.a.a.h.a.j;

public class u
{
  public static final b a;
  public static final b b;
  public static final b c;
  public static final b d;
  public static final b e;
  public static final b f;
  public static final b g;
  public static final b h;
  public static final b i;
  public static final b j;
  public static final b k;
  public static final b l;

  static
  {
    e locale = new e(new String[][] { { "\"", "\\\"" }, { "\\", "\\\\" } });
    b[] arrayOfb1 = new b[1];
    arrayOfb1[0] = new e(d.i());
    b localb = locale.a(arrayOfb1);
    b[] arrayOfb2 = new b[1];
    arrayOfb2[0] = i.a(32, 127);
    a = localb.a(arrayOfb2);
    b[] arrayOfb3 = new b[3];
    arrayOfb3[0] = new e(new String[][] { { "'", "\\'" }, { "\"", "\\\"" }, { "\\", "\\\\" }, { "/", "\\/" } });
    arrayOfb3[1] = new e(d.i());
    arrayOfb3[2] = i.a(32, 127);
    b = new a(arrayOfb3);
    b[] arrayOfb4 = new b[2];
    arrayOfb4[0] = new e(d.e());
    arrayOfb4[1] = new e(d.g());
    c = new a(arrayOfb4);
    b[] arrayOfb5 = new b[2];
    arrayOfb5[0] = new e(d.e());
    arrayOfb5[1] = new e(d.a());
    d = new a(arrayOfb5);
    b[] arrayOfb6 = new b[3];
    arrayOfb6[0] = new e(d.e());
    arrayOfb6[1] = new e(d.a());
    arrayOfb6[2] = new e(d.c());
    e = new a(arrayOfb6);
    f = new a();
    b[] arrayOfb7 = new b[4];
    arrayOfb7[0] = new h();
    arrayOfb7[1] = new j();
    arrayOfb7[2] = new e(d.j());
    arrayOfb7[3] = new e(new String[][] { { "\\\\", "\\" }, { "\\\"", "\"" }, { "\\'", "'" }, { "\\", "" } });
    g = new a(arrayOfb7);
    h = g;
    b[] arrayOfb8 = new b[3];
    arrayOfb8[0] = new e(d.f());
    arrayOfb8[1] = new e(d.b());
    arrayOfb8[2] = new g(new g.a[0]);
    i = new a(arrayOfb8);
    b[] arrayOfb9 = new b[4];
    arrayOfb9[0] = new e(d.f());
    arrayOfb9[1] = new e(d.b());
    arrayOfb9[2] = new e(d.d());
    arrayOfb9[3] = new g(new g.a[0]);
    j = new a(arrayOfb9);
    b[] arrayOfb10 = new b[3];
    arrayOfb10[0] = new e(d.f());
    arrayOfb10[1] = new e(d.h());
    arrayOfb10[2] = new g(new g.a[0]);
    k = new a(arrayOfb10);
    l = new b();
  }

  public static final String a(String paramString)
  {
    return a.a(paramString);
  }

  public static final String b(String paramString)
  {
    return b.a(paramString);
  }

  public static final String c(String paramString)
  {
    return g.a(paramString);
  }

  public static final String d(String paramString)
  {
    return h.a(paramString);
  }

  public static final String e(String paramString)
  {
    return e.a(paramString);
  }

  public static final String f(String paramString)
  {
    return d.a(paramString);
  }

  public static final String g(String paramString)
  {
    return j.a(paramString);
  }

  public static final String h(String paramString)
  {
    return i.a(paramString);
  }

  public static final String i(String paramString)
  {
    return c.a(paramString);
  }

  public static final String j(String paramString)
  {
    return k.a(paramString);
  }

  public static final String k(String paramString)
  {
    return f.a(paramString);
  }

  public static final String l(String paramString)
  {
    return l.a(paramString);
  }

  static class a extends b
  {
    private static final char a = ',';
    private static final char b = '"';
    private static final String c = String.valueOf('"');
    private static final char[] d = { 44, 34, 13, 10 };

    public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
      throws IOException
    {
      if (paramInt != 0)
        throw new IllegalStateException("CsvEscaper should never reach the [1] index");
      if (v.e(paramCharSequence.toString(), d))
        paramWriter.write(paramCharSequence.toString());
      while (true)
      {
        return paramCharSequence.length();
        paramWriter.write(34);
        paramWriter.write(v.d(paramCharSequence.toString(), c, c + c));
        paramWriter.write(34);
      }
    }
  }

  static class b extends b
  {
    private static final char a = ',';
    private static final char b = '"';
    private static final String c = String.valueOf('"');
    private static final char[] d = { 44, 34, 13, 10 };

    public int a(CharSequence paramCharSequence, int paramInt, Writer paramWriter)
      throws IOException
    {
      if (paramInt != 0)
        throw new IllegalStateException("CsvUnescaper should never reach the [1] index");
      if ((paramCharSequence.charAt(0) != '"') || (paramCharSequence.charAt(-1 + paramCharSequence.length()) != '"'))
      {
        paramWriter.write(paramCharSequence.toString());
        return paramCharSequence.length();
      }
      String str = paramCharSequence.subSequence(1, -1 + paramCharSequence.length()).toString();
      if (v.b(str, d))
        paramWriter.write(v.d(str, c + c, c));
      while (true)
      {
        return paramCharSequence.length();
        paramWriter.write(paramCharSequence.toString());
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.u
 * JD-Core Version:    0.6.0
 */