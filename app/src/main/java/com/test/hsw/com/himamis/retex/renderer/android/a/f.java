package com.himamis.retex.renderer.android.a;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import com.himamis.retex.renderer.a.g.a.g;

public class f
  implements g
{
  private Paint a;
  private String b;
  private a c;

  public f(String paramString, a parama, d paramd)
  {
    this.b = paramString;
    this.c = parama;
    this.a = paramd.a();
  }

  private void b()
  {
    this.a.setTypeface(this.c.a());
    this.a.setTextSize(this.c.b());
    this.a.setStyle(Paint.Style.FILL);
  }

  public com.himamis.retex.renderer.a.g.b.d a()
  {
    b();
    Rect localRect = new Rect();
    this.a.getTextBounds(this.b, 0, this.b.length(), localRect);
    return new com.himamis.retex.renderer.android.b.d(localRect);
  }

  public void a(com.himamis.retex.renderer.a.g.c.c paramc, int paramInt1, int paramInt2)
  {
    b();
    ((com.himamis.retex.renderer.android.c.c)paramc).a(this.b, paramInt1, paramInt2, this.a);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.a.f
 * JD-Core Version:    0.6.0
 */