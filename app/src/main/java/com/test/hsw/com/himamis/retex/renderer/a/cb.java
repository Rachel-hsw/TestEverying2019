package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.e.s;
import com.himamis.retex.renderer.a.g.d.c;
import java.util.Map;

public class cb
{
  public static final String a = "PredefinedTeXFormulas.xml";
  private static final String b = "";
  private c c;
  private String d;

  public cb(Object paramObject, String paramString)
    throws o
  {
    try
    {
      this.d = paramString;
      this.c = new com.himamis.retex.renderer.a.g.e().a(paramObject, true, true);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new s("", localException);
  }

  public cb(String paramString1, String paramString2)
    throws o
  {
    this(new com.himamis.retex.renderer.a.g.f().a(cb.class, paramString1), paramString2);
  }

  private static String a(String paramString, c paramc)
    throws o
  {
    String str = paramc.b(paramString);
    if (str.equals(""))
      throw new s("PredefinedTeXFormulas.xml", paramc.a(), paramString, null);
    return str;
  }

  public void a(Map paramMap)
  {
    com.himamis.retex.renderer.a.g.d.f localf;
    int i;
    if ("true".equals(a("enabled", this.c)))
    {
      localf = this.c.a(this.d);
      i = 0;
      if (i < localf.a());
    }
    else
    {
      return;
    }
    c localc = localf.a(i).f();
    String str;
    if ("true".equals(a("enabled", localc)))
    {
      str = a("name", localc);
      if (!"TeXFormula".equals(this.d))
        break label130;
      paramMap.put(str, (dr)new ds(str, localc, this.d).a());
    }
    while (true)
    {
      i++;
      break;
      label130: paramMap.put(str, (be)new ds(str, localc, this.d).a());
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cb
 * JD-Core Version:    0.6.0
 */