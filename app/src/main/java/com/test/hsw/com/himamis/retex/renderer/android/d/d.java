package com.himamis.retex.renderer.android.d;

import org.w3c.dom.NamedNodeMap;

public class d
  implements com.himamis.retex.renderer.a.g.d.d
{
  private NamedNodeMap a;

  public d(NamedNodeMap paramNamedNodeMap)
  {
    this.a = paramNamedNodeMap;
  }

  public int a()
  {
    return this.a.getLength();
  }

  public com.himamis.retex.renderer.a.g.d.e a(int paramInt)
  {
    return new e(this.a.item(paramInt));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.d.d
 * JD-Core Version:    0.6.0
 */