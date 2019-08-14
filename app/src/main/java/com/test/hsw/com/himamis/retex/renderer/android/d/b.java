package com.himamis.retex.renderer.android.d;

import org.w3c.dom.Document;

public class b
  implements com.himamis.retex.renderer.a.g.d.b
{
  private Document a;

  public b(Document paramDocument)
  {
    this.a = paramDocument;
  }

  public com.himamis.retex.renderer.a.g.d.c a()
  {
    return new c(this.a.getDocumentElement());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.d.b
 * JD-Core Version:    0.6.0
 */