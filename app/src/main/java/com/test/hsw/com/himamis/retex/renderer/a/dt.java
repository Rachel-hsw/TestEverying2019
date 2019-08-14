package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.e.s;
import com.himamis.retex.renderer.a.g.d.c;

public class dt
{
  public static final String a = "TeXFormulaSettings.xml";
  public static final String b = "Map";
  private c c;

  public dt()
    throws o
  {
    this(new com.himamis.retex.renderer.a.g.f().a(dt.class, "TeXFormulaSettings.xml"), "TeXFormulaSettings.xml");
  }

  public dt(Object paramObject, String paramString)
    throws o
  {
    try
    {
      this.c = new com.himamis.retex.renderer.a.g.e().a(paramObject, true, true);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new s(paramString, localException);
  }

  private static void a(com.himamis.retex.renderer.a.g.d.f paramf, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws o
  {
    c localc;
    for (int i = 0; ; i++)
    {
      if (i >= paramf.a())
        return;
      localc = paramf.a(i).f();
      String str1 = localc.b("char");
      String str2 = localc.b("symbol");
      String str3 = localc.b("text");
      if (str1.equals(""))
        throw new s("TeXFormulaSettings.xml", localc.a(), "char", null);
      if (str2.equals(""))
        throw new s("TeXFormulaSettings.xml", localc.a(), "symbol", null);
      if (str1.length() != 1)
        break;
      paramArrayOfString1[str1.charAt(0)] = str2;
      if ((paramArrayOfString2 == null) || (str3.equals("")))
        continue;
      paramArrayOfString2[str1.charAt(0)] = str3;
    }
    throw new s("TeXFormulaSettings.xml", localc.a(), "char", "must have a value that contains exactly 1 character!");
  }

  private static void b(com.himamis.retex.renderer.a.g.d.f paramf, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws o
  {
    c localc;
    for (int i = 0; ; i++)
    {
      if (i >= paramf.a())
        return;
      localc = paramf.a(i).f();
      String str1 = localc.b("char");
      String str2 = localc.b("formula");
      String str3 = localc.b("text");
      if (str1.equals(""))
        throw new s("TeXFormulaSettings.xml", localc.a(), "char", null);
      if (str2.equals(""))
        throw new s("TeXFormulaSettings.xml", localc.a(), "formula", null);
      if (str1.length() != 1)
        break;
      paramArrayOfString1[str1.charAt(0)] = str2;
      if ((paramArrayOfString2 == null) || (str3.equals("")))
        continue;
      paramArrayOfString2[str1.charAt(0)] = str3;
    }
    throw new s("TeXFormulaSettings.xml", localc.a(), "char", "must have a value that contains exactly 1 character!");
  }

  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws o
  {
    c localc = this.c.a("CharacterToFormulaMappings").a(0).f();
    if (!localc.d())
      b(localc.a("Map"), paramArrayOfString1, paramArrayOfString2);
  }

  public void b(String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws o
  {
    c localc = this.c.a("CharacterToSymbolMappings").a(0).f();
    if (!localc.d())
      a(localc.a("Map"), paramArrayOfString1, paramArrayOfString2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dt
 * JD-Core Version:    0.6.0
 */