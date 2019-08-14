package com.himamis.retex.renderer.android.c;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private List<Float> a = new ArrayList();
  private List<Float> b;

  public f()
  {
    this.a.add(Float.valueOf(1.0F));
    this.b = new ArrayList();
    this.b.add(Float.valueOf(1.0F));
  }

  private int e()
  {
    return -1 + this.a.size();
  }

  private int f()
  {
    return -1 + this.b.size();
  }

  public float a()
  {
    return ((Float)this.a.get(e())).floatValue();
  }

  public float a(float paramFloat)
  {
    return paramFloat * a();
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    return Bitmap.createScaledBitmap(paramBitmap, Math.round(a(paramBitmap.getWidth())), Math.round(b(paramBitmap.getHeight())), false);
  }

  public PointF a(PointF paramPointF)
  {
    paramPointF.x *= a();
    paramPointF.y *= b();
    return paramPointF;
  }

  public RectF a(RectF paramRectF)
  {
    paramRectF.bottom *= b();
    paramRectF.top *= b();
    paramRectF.left *= a();
    paramRectF.right *= a();
    return paramRectF;
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    float f1 = a(paramFloat1);
    float f2 = b(paramFloat2);
    this.a.set(e(), Float.valueOf(f1));
    this.b.set(f(), Float.valueOf(f2));
  }

  public float b()
  {
    return ((Float)this.b.get(f())).floatValue();
  }

  public float b(float paramFloat)
  {
    return paramFloat * b();
  }

  public float c(float paramFloat)
  {
    return paramFloat * Math.min(a(), b());
  }

  public void c()
  {
    this.a.add(Float.valueOf(a()));
    this.b.add(Float.valueOf(b()));
  }

  public void d()
  {
    this.a.remove(e());
    this.b.remove(f());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.android.c.f
 * JD-Core Version:    0.6.0
 */