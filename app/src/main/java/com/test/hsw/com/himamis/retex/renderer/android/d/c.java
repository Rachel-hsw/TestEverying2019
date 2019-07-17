package com.himamis.retex.renderer.android.d;

import org.w3c.dom.Element;

public class c extends e
  implements com.himamis.retex.renderer.a.g.d.c
{
  private Element a;

  public c(Element paramElement)
  {
    super(paramElement);
    this.a = paramElement;
  }

  public com.himamis.retex.renderer.a.g.d.f a(String paramString)
  {
    return new f(this.a.getElementsByTagName(paramString));
  }

  public String a()
  {
    return this.a.getTagName();
  }

  public com.himamis.retex.renderer.a.g.d.f b()
  {
    return new f(this.a.getChildNodes());
  }

  public String b(String paramString)
  {
    return this.a.getAttribute(paramString);
  }

  public com.himamis.retex.renderer.a.g.d.d c()
  {
    return new d(this.a.getAttributes());
  }

  public boolean d()
  {
    return this.a == null;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.d.c
 * JD-Core Version:    0.6.0
 */