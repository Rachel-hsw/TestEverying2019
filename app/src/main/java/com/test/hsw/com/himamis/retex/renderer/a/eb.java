package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.b.a.c;
import java.net.URL;
import java.net.URLClassLoader;

public class eb
  implements b
{
  private URL c;
  private String d;
  private b e = null;
  private a.c[] f;

  private eb(URL paramURL, String paramString, a.c[] paramArrayOfc)
  {
    this.c = paramURL;
    this.d = paramString;
    this.f = paramArrayOfc;
  }

  public static void a(URL paramURL, String paramString, a.c[] paramArrayOfc)
  {
    v.b(new eb(paramURL, paramString, paramArrayOfc));
  }

  public a.c[] a()
  {
    return this.f;
  }

  public Object b()
    throws com.himamis.retex.renderer.a.e.a
  {
    URL[] arrayOfURL = new URL[1];
    arrayOfURL[0] = this.c;
    this.d = this.d.toLowerCase();
    String str = "com.himamis.retex.renderer.share." + this.d + "." + com.himamis.retex.renderer.a.b.a.b(Character.toUpperCase(this.d.charAt(0))) + this.d.substring(1, this.d.length()) + "Registration";
    try
    {
      this.e = ((b)Class.forName(str, true, new URLClassLoader(arrayOfURL)).newInstance());
      return this.e;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new com.himamis.retex.renderer.a.e.a("Class at " + this.c + " cannot be got.");
    }
    catch (Exception localException)
    {
    }
    throw new com.himamis.retex.renderer.a.e.a("Problem in loading the class at " + this.c + " :\n" + localException.getMessage());
  }

  public String c()
  {
    return this.e.c();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.eb
 * JD-Core Version:    0.6.0
 */