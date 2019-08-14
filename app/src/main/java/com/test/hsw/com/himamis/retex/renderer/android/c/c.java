package com.himamis.retex.renderer.android.c;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import com.himamis.retex.renderer.a.g.c.g;
import com.himamis.retex.renderer.a.g.c.j;
import com.himamis.retex.renderer.a.g.c.k;
import com.himamis.retex.renderer.a.s;

@SuppressLint({"NewApi"})
public class c
  implements com.himamis.retex.renderer.a.g.c.c
{
  private Canvas a;
  private View b;
  private Paint c = new Paint();
  private Paint d;
  private f e;
  private com.himamis.retex.renderer.android.a.a f;
  private b g;
  private Paint.Style h;

  public c()
  {
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setSubpixelText(true);
    this.c.setAntiAlias(true);
    this.c.setLinearText(true);
    this.d = new Paint();
    this.d.set(this.c);
    this.e = new f();
    this.f = new com.himamis.retex.renderer.android.a.a("Serif", 0, 10);
    this.g = ((b)s.b);
  }

  public c(Canvas paramCanvas)
  {
    this();
    a(paramCanvas);
  }

  public c(Canvas paramCanvas, View paramView)
  {
    this(paramCanvas);
    a(paramView);
  }

  private void a(a parama)
  {
    this.c.setStrokeWidth(parama.a());
    this.c.setStrokeMiter(parama.b());
    this.c.setStrokeCap(parama.f());
    this.c.setStrokeJoin(parama.g());
  }

  private void i()
  {
    this.h = this.c.getStyle();
  }

  private void j()
  {
    this.c.setStyle(this.h);
  }

  private void k()
  {
    this.c.setStyle(Paint.Style.FILL);
  }

  private void l()
  {
    i();
    k();
  }

  private void m()
  {
    j();
  }

  public int a(int paramInt)
  {
    return -1;
  }

  public j a()
  {
    return new a(this.c.getStrokeWidth(), this.c.getStrokeMiter(), this.c.getStrokeCap(), this.c.getStrokeJoin());
  }

  public void a(double paramDouble)
  {
    float f1 = (float)Math.toDegrees(paramDouble);
    this.a.rotate(f1);
  }

  public void a(double paramDouble1, double paramDouble2)
  {
    this.a.translate(this.e.a((float)paramDouble1), this.e.b((float)paramDouble2));
  }

  public void a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    a(paramDouble2, paramDouble3);
    a(paramDouble1);
    a(-paramDouble2, -paramDouble3);
  }

  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 1))
      this.c.setAntiAlias(true);
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    l();
    this.a.drawRect(this.e.a(paramInt1), this.e.b(paramInt2), this.e.a(paramInt1 + paramInt3), this.e.b(paramInt2 + paramInt4), this.c);
    m();
  }

  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    this.a.drawArc(this.e.a(localRectF), paramInt5, paramInt6, false, this.c);
  }

  public void a(Canvas paramCanvas)
  {
    this.a = paramCanvas;
  }

  public void a(View paramView)
  {
    this.b = paramView;
  }

  public void a(com.himamis.retex.renderer.a.g.a.a parama)
  {
    this.f = ((com.himamis.retex.renderer.android.a.a)parama);
    this.c.setTypeface(this.f.a());
    this.c.setTextSize(this.e.c(this.f.b()));
  }

  public void a(com.himamis.retex.renderer.a.g.b.b paramb)
  {
    com.himamis.retex.renderer.android.b.b localb = (com.himamis.retex.renderer.android.b.b)paramb;
    PointF localPointF1 = localb.a();
    PointF localPointF2 = localb.b();
    this.a.drawLine(this.e.a(localPointF1.x), this.e.b(localPointF1.y), this.e.a(localPointF2.x), this.e.b(localPointF2.y), this.c);
  }

  public void a(com.himamis.retex.renderer.a.g.b.d paramd)
  {
    l();
    b(paramd);
    m();
  }

  public void a(com.himamis.retex.renderer.a.g.b.e parame)
  {
    RectF localRectF = new RectF(((com.himamis.retex.renderer.android.b.e)parame).g());
    this.a.drawRoundRect(this.e.a(localRectF), this.e.a((float)parame.a()), this.e.b((float)parame.b()), this.c);
  }

  public void a(com.himamis.retex.renderer.a.g.c.b paramb)
  {
    this.g = ((b)paramb);
    this.c.setColor(this.g.b());
  }

  public void a(g paramg, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = ((e)paramg).d();
    this.a.drawBitmap(this.e.a(localBitmap), this.e.a(paramInt1), this.e.b(paramInt2), this.c);
  }

  public void a(g paramg, k paramk)
  {
    Bitmap localBitmap = ((e)paramg).d();
    this.a.drawBitmap(this.e.a(localBitmap), (Matrix)paramk, this.c);
  }

  public void a(j paramj)
  {
    a((a)paramj);
  }

  public void a(String paramString, int paramInt1, int paramInt2, Paint paramPaint)
  {
    this.a.drawText(paramString, this.e.a(paramInt1), this.e.b(paramInt2), paramPaint);
  }

  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    l();
    this.c.setTextSize(this.e.c(this.f.b()));
    this.a.drawText(paramArrayOfChar, paramInt1, paramInt2, this.e.a(paramInt3), this.e.b(paramInt4), this.c);
    m();
  }

  public com.himamis.retex.renderer.a.g.c.b b()
  {
    return this.g;
  }

  public void b(double paramDouble1, double paramDouble2)
  {
    this.e.a((float)paramDouble1, (float)paramDouble2);
  }

  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    l();
    a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
    m();
  }

  public void b(com.himamis.retex.renderer.a.g.b.d paramd)
  {
    RectF localRectF = new RectF(((com.himamis.retex.renderer.android.b.d)paramd).a());
    this.a.drawRect(this.e.a(localRectF), this.c);
  }

  public k c()
  {
    View localView = this.b;
    Matrix localMatrix = null;
    if (localView != null)
    {
      int i = Build.VERSION.SDK_INT;
      localMatrix = null;
      if (i >= 11)
        localMatrix = this.b.getMatrix();
    }
    if (localMatrix == null)
      localMatrix = this.a.getMatrix();
    return new h(localMatrix);
  }

  public com.himamis.retex.renderer.a.g.a.a d()
  {
    return this.f;
  }

  public com.himamis.retex.renderer.a.g.a.d e()
  {
    this.d.set(this.c);
    return new com.himamis.retex.renderer.android.a.d(this.d);
  }

  public void f()
  {
  }

  public void g()
  {
    this.a.save(1);
    this.e.c();
  }

  public void h()
  {
    this.a.restore();
    this.e.d();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.c.c
 * JD-Core Version:    0.6.0
 */