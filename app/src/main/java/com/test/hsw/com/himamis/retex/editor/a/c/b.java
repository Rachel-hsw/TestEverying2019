package com.himamis.retex.editor.a.c;

import com.himamis.retex.editor.a.f.h;
import com.himamis.retex.renderer.a.dr;
import com.himamis.retex.renderer.a.dr.b;
import com.himamis.retex.renderer.a.du;

public class b
{
  com.himamis.retex.editor.a.d.b a = new e(this);
  private du b;
  private com.himamis.retex.editor.a.a.e c = new com.himamis.retex.editor.a.a.e();
  private a d;
  private com.himamis.retex.editor.a.d.a e = new c(this);
  private com.himamis.retex.editor.a.b.c f = new d(this);
  private com.himamis.retex.editor.a.d.d g = new f(this);
  private float h = 16.0F;
  private int i = 0;

  private void a(h paramh, int paramInt)
  {
    dr localdr = new dr(this.c.a(this.f.a(), paramh, paramInt));
    localdr.getClass();
    this.b = new dr.b(localdr).a(0).a(this.h).b(this.i).a();
    this.d.setTeXIcon(this.b);
  }

  private void a(boolean paramBoolean, h paramh, int paramInt)
  {
    if (this.d.b())
    {
      a(paramh, paramInt);
      if (!paramBoolean)
        this.d.requestLayout();
      this.d.a();
    }
  }

  private void c()
  {
    this.d.setFocusListener(this.a);
    this.d.setClickListener(this.e);
    this.d.setKeyListener(this.g);
  }

  public com.himamis.retex.editor.a.b.c a()
  {
    return this.f;
  }

  public void a(float paramFloat)
  {
    this.h = paramFloat;
  }

  public void a(int paramInt)
  {
    this.i = paramInt;
  }

  public void a(a parama)
  {
    this.d = parama;
    c();
  }

  public void a(com.himamis.retex.editor.a.f.f paramf)
  {
    this.f.a(paramf);
    a(null, 0);
  }

  public void a(boolean paramBoolean)
  {
    a(paramBoolean, null, 0);
  }

  public com.himamis.retex.editor.a.f.f b()
  {
    return this.f.a();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.editor.a.c.b
 * JD-Core Version:    0.6.0
 */