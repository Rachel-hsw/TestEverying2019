package com.himamis.retex.renderer.android.d;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class e
  implements com.himamis.retex.renderer.a.g.d.e
{
  private Node a;

  public e(Node paramNode)
  {
    this.a = paramNode;
  }

  public short e()
  {
    return this.a.getNodeType();
  }

  public com.himamis.retex.renderer.a.g.d.c f()
  {
    return new c((Element)this.a);
  }

  public com.himamis.retex.renderer.a.g.d.a g()
  {
    return new a((Attr)this.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.d.e
 * JD-Core Version:    0.6.0
 */