package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.e.o;
import com.himamis.retex.renderer.a.g.d.c;
import com.himamis.retex.renderer.a.g.d.e;
import com.himamis.retex.renderer.a.g.d.f;
import java.util.HashMap;
import java.util.Map;

public class ds
{
  private static final String a = "value";
  private static final String b = "Return";
  private static final String c = "formula";
  private static Map<String, Class<?>> d = new HashMap();
  private static final int l = 0;
  private static final int m = 1;
  private final Map<String, b> e = new HashMap();
  private final Map<String, a> f = new HashMap();
  private final Map<String, dr> g = new HashMap();
  private final Map<String, be> h = new HashMap();
  private Object i = new Object();
  private final String j;
  private final c k;
  private int n;

  static
  {
    d.put("TeXConstants", Integer.TYPE);
    d.put("TeXFormula", dr.class);
    d.put("String", String.class);
    d.put("float", Float.TYPE);
    d.put("int", Integer.TYPE);
    d.put("boolean", Boolean.TYPE);
    d.put("char", Character.TYPE);
    d.put("ColorConstant", s.class);
  }

  public ds(String paramString1, c paramc, String paramString2)
  {
    this.j = paramString1;
    this.k = paramc;
    int i1;
    if ("Command".equals(paramString2))
    {
      i1 = 0;
      this.n = i1;
      if (!"Command".equals(paramString2))
        break label323;
      this.f.put("CreateCommand", new f());
    }
    while (true)
    {
      this.f.put("MethodInvocation", new j());
      this.f.put("Return", new k());
      this.e.put("TeXConstants", new m());
      this.e.put("TeXFormula", new n());
      this.e.put("String", new l());
      this.e.put("float", new h());
      this.e.put("int", new i());
      this.e.put("boolean", new c());
      this.e.put("char", new d());
      this.e.put("ColorConstant", new e());
      return;
      i1 = 1;
      break;
      label323: this.f.put("CreateTeXFormula", new g());
    }
  }

  private static String b(String paramString, c paramc)
    throws o
  {
    String str = paramc.b(paramString);
    if (str.equals(""))
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", paramc.a(), paramString, null);
    return str;
  }

  private static void b(String paramString1, String paramString2)
    throws o
  {
    if (paramString1.equals(""))
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "is required for an argument of type '" + paramString2 + "'!");
  }

  private Object[] b(f paramf)
  {
    Object[] arrayOfObject = new Object[paramf.a()];
    int i1 = 0;
    int i2 = 0;
    while (true)
    {
      if (i1 >= paramf.a())
        return arrayOfObject;
      c localc = paramf.a(i1).f();
      String str1 = b("type", localc);
      String str2 = localc.b("value");
      arrayOfObject[i2] = ((b)this.e.get(str1)).a(str2, str1);
      i2++;
      i1++;
    }
  }

  private static Class[] c(f paramf)
    throws o
  {
    Class[] arrayOfClass = new Class[paramf.a()];
    int i1 = 0;
    int i2 = 0;
    while (true)
    {
      if (i1 >= paramf.a())
        return arrayOfClass;
      String str = b("type", paramf.a(i1).f());
      Object localObject = d.get(str);
      if (localObject == null)
        throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "type", "has an invalid class name value!");
      arrayOfClass[i2] = ((Class)localObject);
      i2++;
      i1++;
    }
  }

  public Object a()
    throws o
  {
    f localf = this.k.b();
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= localf.a())
        return this.i;
      e locale = localf.a(i1);
      if (locale.e() == 3)
        continue;
      c localc = locale.f();
      a locala = (a)this.f.get(localc.a());
      if (locala == null)
        continue;
      locala.a(localc);
    }
  }

  private static abstract interface a
  {
    public abstract void a(c paramc)
      throws o;
  }

  private static abstract interface b
  {
    public abstract Object a(String paramString1, String paramString2)
      throws o;
  }

  private class c
    implements ds.b
  {
    c()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      ds.a(paramString1, paramString2);
      if ("true".equals(paramString1))
        return Boolean.TRUE;
      if ("false".equals(paramString1))
        return Boolean.FALSE;
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "has an invalid '" + paramString2 + "'-value : '" + paramString1 + "'!");
    }
  }

  private class d
    implements ds.b
  {
    d()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      ds.a(paramString1, paramString2);
      if (paramString1.length() == 1)
        return new Character(paramString1.charAt(0));
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "must have a value that consists of exactly 1 character!");
    }
  }

  private class e
    implements ds.b
  {
    e()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      ds.a(paramString1, paramString2);
      try
      {
        Object localObject = s.i.get(paramString1);
        return localObject;
      }
      catch (Exception localException)
      {
      }
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "has an unknown color constant name as value : '" + paramString1 + "'!", localException);
    }
  }

  private class f
    implements ds.a
  {
    f()
    {
    }

    public void a(c paramc)
      throws o
    {
      int i = 0;
      String str1 = ds.a("name", paramc);
      f localf = paramc.a("Argument");
      Class[] arrayOfClass = ds.a(localf);
      Object[] arrayOfObject = ds.a(ds.this, localf);
      try
      {
        throw new UnsupportedOperationException("Not implemented");
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Object localObject1 = "IllegalArgumentException:\n" + "ClassLoader to load this class (TeXFormulaParser): " + getClass() + "\n";
        int j = arrayOfClass.length;
        int k = 0;
        int m;
        if (k >= j)
          m = arrayOfObject.length;
        while (true)
        {
          if (i >= m)
          {
            throw new com.himamis.retex.renderer.a.e.s("Error creating the temporary command '" + str1 + "' while constructing the predefined command '" + ds.b(ds.this) + "'!\n" + (String)localObject1);
            Class localClass = arrayOfClass[k];
            String str2 = localObject1 + "Created class: " + localClass + " loaded with the ClassLoader: " + localClass + "\n";
            k++;
            localObject1 = str2;
            break;
          }
          Object localObject2 = arrayOfObject[i];
          localObject1 = localObject1 + "Created object: " + localObject2 + "\n";
          i++;
        }
      }
      catch (Exception localException)
      {
      }
      throw new com.himamis.retex.renderer.a.e.s("Error creating the temporary command '" + str1 + "' while constructing the predefined command '" + ds.b(ds.this) + "'!\n" + localException.toString());
    }
  }

  private class g
    implements ds.a
  {
    g()
    {
    }

    public void a(c paramc)
      throws o
    {
      String str = ds.a("name", paramc);
      f localf = paramc.a("Argument");
      ds.a(localf);
      ds.a(ds.this, localf);
      try
      {
        throw new UnsupportedOperationException("Not implemented");
      }
      catch (Exception localException)
      {
      }
      throw new com.himamis.retex.renderer.a.e.s("Error creating the temporary TeXFormula '" + str + "' while constructing the predefined TeXFormula '" + ds.b(ds.this) + "'!\n" + localException.toString());
    }
  }

  private class h
    implements ds.b
  {
    h()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      ds.a(paramString1, paramString2);
      try
      {
        Float localFloat = new Float(Float.parseFloat(paramString1));
        return localFloat;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "has an invalid '" + paramString2 + "'-value : '" + paramString1 + "'!", localNumberFormatException);
    }
  }

  private class i
    implements ds.b
  {
    i()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      ds.a(paramString1, paramString2);
      try
      {
        Float localFloat = new Float(Integer.parseInt(paramString1));
        return localFloat;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "has an invalid '" + paramString2 + "'-value : '" + paramString1 + "'!", localNumberFormatException);
    }
  }

  private class j
    implements ds.a
  {
    j()
    {
    }

    public void a(c paramc)
      throws o
    {
      String str1 = ds.a("name", paramc);
      String str2 = ds.a("formula", paramc);
      if (ds.a(ds.this).get(str2) == null)
        throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "formula", "has an unknown temporary TeXFormula name as value : '" + str2 + "'!");
      f localf = paramc.a("Argument");
      ds.a(localf);
      ds.a(ds.this, localf);
      try
      {
        throw new UnsupportedOperationException("Not implemented yet.");
      }
      catch (Exception localException)
      {
      }
      throw new com.himamis.retex.renderer.a.e.s("Error invoking the method '" + str1 + "' on the temporary TeXFormula '" + str2 + "' while constructing the predefined TeXFormula '" + ds.b(ds.this) + "'!\n" + localException.toString());
    }
  }

  private class k
    implements ds.a
  {
    k()
    {
    }

    public void a(c paramc)
      throws o
    {
      String str = ds.a("name", paramc);
      if (ds.c(ds.this) == 0);
      for (Object localObject = ds.d(ds.this).get(str); localObject == null; localObject = ds.a(ds.this).get(str))
        throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Return", "name", "contains an unknown temporary TeXFormula variable name '" + str + "' for the predefined TeXFormula '" + ds.b(ds.this) + "'!");
      ds.a(ds.this, localObject);
    }
  }

  private class l
    implements ds.b
  {
    l()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      return paramString1;
    }
  }

  private class m
    implements ds.b
  {
    m()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      ds.a(paramString1, paramString2);
      try
      {
        Integer localInteger = Integer.valueOf(((Integer)do.ae.get(paramString1)).intValue());
        return localInteger;
      }
      catch (Exception localException)
      {
      }
      throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "has an unknown constant name as value : '" + paramString1 + "'!", localException);
    }
  }

  private class n
    implements ds.b
  {
    n()
    {
    }

    public Object a(String paramString1, String paramString2)
      throws o
    {
      if (paramString1 == null)
        return null;
      Object localObject = ds.a(ds.this).get(paramString1);
      if (localObject == null)
        throw new com.himamis.retex.renderer.a.e.s("PredefinedTeXFormulas.xml", "Argument", "value", "has an unknown temporary TeXFormula name as value : '" + paramString1 + "'!");
      return (dr)localObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.ds
 * JD-Core Version:    0.6.0
 */