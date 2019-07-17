package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.g.a;
import com.himamis.retex.renderer.a.g.c.b;
import com.himamis.retex.renderer.a.g.c.d;
import java.util.HashMap;
import java.util.Map;

public abstract class s
{
  public static final b a;
  public static final b b;
  public static final b c;
  public static final b d;
  public static final b e;
  public static final b f;
  public static final b g;
  public static final b h;
  public static final Map<String, b> i;
  public static StringBuilder j;
  private static final d k = a.a.h();

  static
  {
    a = k.a(255, 0, 0);
    b = k.a(0, 0, 0);
    c = k.a(255, 255, 255);
    d = k.a(0, 0, 255);
    e = k.a(0, 255, 0);
    f = k.a(0, 255, 255);
    g = k.a(255, 0, 255);
    h = k.a(255, 255, 0);
    i = new HashMap();
    i.put("RED", a);
    i.put("BLACK", b);
    i.put("WHITE", c);
    i.put("BLUE", d);
    i.put("GREEN", e);
    i.put("CYAN", f);
    i.put("MAGENTA", g);
    i.put("YELLOW", h);
    j = new StringBuilder("#");
  }

  public static b a(String paramString)
    throws NumberFormatException
  {
    int m = Integer.decode(paramString).intValue();
    return k.a(0xFF & m >> 16, 0xFF & m >> 8, m & 0xFF);
  }

  public static String a(b paramb)
  {
    int m = paramb.b();
    int n = (0xFF000000 & m) >> 24;
    int i1 = (0xFF0000 & m) >> 16;
    int i2 = (m & 0xFF00) >> 8;
    j.setLength(1);
    j.append('#').append(b(Integer.toHexString(n))).append(b(Integer.toHexString(i1))).append(b(Integer.toHexString(i2)));
    return j.toString();
  }

  private static String b(String paramString)
  {
    if (paramString.length() == 0)
      paramString = "00";
    do
      return paramString;
    while (paramString.length() != 1);
    return "0" + paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.s
 * JD-Core Version:    0.6.0
 */