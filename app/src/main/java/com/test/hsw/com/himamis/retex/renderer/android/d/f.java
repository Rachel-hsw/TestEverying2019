package com.himamis.retex.renderer.android.d;

import org.w3c.dom.NodeList;

public class f
  implements com.himamis.retex.renderer.a.g.d.f
{
  private NodeList a;

  public f(NodeList paramNodeList)
  {
    this.a = paramNodeList;
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
 * Qualified Name:     com.himamis.retex.renderer.android.d.f
 * JD-Core Version:    0.6.0
 */