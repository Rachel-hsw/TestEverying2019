package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.e.s;
import com.himamis.retex.renderer.a.g.d.c;
import java.util.HashMap;
import java.util.Map;

public class dw
{
  public static final String a = "TeXSymbols.xml";
  public static final String b = "del";
  public static final String c = "type";
  private static Map<String, Integer> d = new HashMap();
  private c e;

  public dw()
    throws o
  {
    this(new com.himamis.retex.renderer.a.g.f().a(dw.class, "TeXSymbols.xml"), "TeXSymbols.xml");
  }

  public dw(Object paramObject, String paramString)
    throws o
  {
    try
    {
      this.e = new com.himamis.retex.renderer.a.g.e().a(paramObject, true, true);
      b();
      return;
    }
    catch (Exception localException)
    {
    }
    throw new s(paramString, localException);
  }

  private static String a(String paramString, c paramc)
    throws o
  {
    String str = paramc.b(paramString);
    if (str.equals(""))
      throw new s("TeXSymbols.xml", paramc.a(), paramString, null);
    return str;
  }

  private void b()
  {
    d.put("ord", Integer.valueOf(0));
    d.put("op", Integer.valueOf(1));
    d.put("bin", Integer.valueOf(2));
    d.put("rel", Integer.valueOf(3));
    d.put("open", Integer.valueOf(4));
    d.put("close", Integer.valueOf(5));
    d.put("punct", Integer.valueOf(6));
    d.put("acc", Integer.valueOf(10));
  }

  public Map<String, dm> a()
    throws o
  {
    HashMap localHashMap = new HashMap();
    com.himamis.retex.renderer.a.g.d.f localf = this.e.a("Symbol");
    for (int i = 0; ; i++)
    {
      if (i >= localf.a())
        return localHashMap;
      c localc = localf.a(i).f();
      String str1 = a("name", localc);
      String str2 = a("type", localc);
      String str3 = localc.b("del");
      if ((str3 != null) && (str3.equals("true")));
      Object localObject;
      for (boolean bool = true; ; bool = false)
      {
        localObject = d.get(str2);
        if (localObject != null)
          break;
        throw new s("TeXSymbols.xml", "Symbol", "type", "has an unknown value '" + str2 + "'!");
      }
      localHashMap.put(str1, new dm(str1, ((Integer)localObject).intValue(), bool));
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.dw
 * JD-Core Version:    0.6.0
 */