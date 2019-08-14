package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.a.f;
import uk.co.senab.photoview.a.g;

public class d
  implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, f, c
{
  static final Interpolator e;
  static final int g = -1;
  static final int h = 0;
  static final int i = 1;
  static final int j = 2;
  private static final String k = "PhotoViewAttacher";
  private static final boolean l = Log.isLoggable("PhotoViewAttacher", 3);
  private e A;
  private View.OnLongClickListener B;
  private int C;
  private int D;
  private int E;
  private int F;
  private b G;
  private int H = 2;
  private boolean I;
  private ImageView.ScaleType J = ImageView.ScaleType.FIT_CENTER;
  int f = 200;
  private float m = 1.0F;
  private float n = 1.75F;
  private float o = 3.0F;
  private boolean p = true;
  private WeakReference<ImageView> q;
  private GestureDetector r;
  private uk.co.senab.photoview.a.e s;
  private final Matrix t = new Matrix();
  private final Matrix u = new Matrix();
  private final Matrix v = new Matrix();
  private final RectF w = new RectF();
  private final float[] x = new float[9];
  private c y;
  private d z;

  static
  {
    e = new AccelerateDecelerateInterpolator();
  }

  public d(ImageView paramImageView)
  {
    this.q = new WeakReference(paramImageView);
    paramImageView.setDrawingCacheEnabled(true);
    paramImageView.setOnTouchListener(this);
    ViewTreeObserver localViewTreeObserver = paramImageView.getViewTreeObserver();
    if (localViewTreeObserver != null)
      localViewTreeObserver.addOnGlobalLayoutListener(this);
    b(paramImageView);
    if (paramImageView.isInEditMode())
      return;
    this.s = g.a(paramImageView.getContext(), this);
    this.r = new GestureDetector(paramImageView.getContext(), new e(this));
    this.r.setOnDoubleTapListener(new b(this));
    setZoomable(true);
  }

  private float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.x);
    return this.x[paramInt];
  }

  private void a(Drawable paramDrawable)
  {
    ImageView localImageView = c();
    if ((localImageView == null) || (paramDrawable == null))
      return;
    float f1 = c(localImageView);
    float f2 = d(localImageView);
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    this.t.reset();
    float f3 = f1 / i1;
    float f4 = f2 / i2;
    if (this.J == ImageView.ScaleType.CENTER)
      this.t.postTranslate((f1 - i1) / 2.0F, (f2 - i2) / 2.0F);
    while (true)
    {
      l();
      return;
      if (this.J == ImageView.ScaleType.CENTER_CROP)
      {
        float f6 = Math.max(f3, f4);
        this.t.postScale(f6, f6);
        this.t.postTranslate((f1 - f6 * i1) / 2.0F, (f2 - f6 * i2) / 2.0F);
        continue;
      }
      if (this.J == ImageView.ScaleType.CENTER_INSIDE)
      {
        float f5 = Math.min(1.0F, Math.min(f3, f4));
        this.t.postScale(f5, f5);
        this.t.postTranslate((f1 - f5 * i1) / 2.0F, (f2 - f5 * i2) / 2.0F);
        continue;
      }
      RectF localRectF1 = new RectF(0.0F, 0.0F, i1, i2);
      RectF localRectF2 = new RectF(0.0F, 0.0F, f1, f2);
      switch (g()[this.J.ordinal()])
      {
      default:
        break;
      case 4:
        this.t.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
        break;
      case 6:
        this.t.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.START);
        break;
      case 5:
        this.t.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.END);
        break;
      case 7:
        this.t.setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.FILL);
      }
    }
  }

  private static boolean a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null)
      return false;
    switch (g()[paramScaleType.ordinal()])
    {
    default:
      return true;
    case 8:
    }
    throw new IllegalArgumentException(paramScaleType.name() + " is not supported in PhotoView");
  }

  private static boolean a(ImageView paramImageView)
  {
    return (paramImageView != null) && (paramImageView.getDrawable() != null);
  }

  private RectF b(Matrix paramMatrix)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      Drawable localDrawable = localImageView.getDrawable();
      if (localDrawable != null)
      {
        this.w.set(0.0F, 0.0F, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        paramMatrix.mapRect(this.w);
        return this.w;
      }
    }
    return null;
  }

  private static void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 >= paramFloat2)
      throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
    if (paramFloat2 >= paramFloat3)
      throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
  }

  private static void b(ImageView paramImageView)
  {
    if ((paramImageView != null) && (!(paramImageView instanceof c)) && (!ImageView.ScaleType.MATRIX.equals(paramImageView.getScaleType())))
      paramImageView.setScaleType(ImageView.ScaleType.MATRIX);
  }

  private int c(ImageView paramImageView)
  {
    if (paramImageView == null)
      return 0;
    return paramImageView.getWidth() - paramImageView.getPaddingLeft() - paramImageView.getPaddingRight();
  }

  private void c(Matrix paramMatrix)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      j();
      localImageView.setImageMatrix(paramMatrix);
      if (this.y != null)
      {
        RectF localRectF = b(paramMatrix);
        if (localRectF != null)
          this.y.a(localRectF);
      }
    }
  }

  private int d(ImageView paramImageView)
  {
    if (paramImageView == null)
      return 0;
    return paramImageView.getHeight() - paramImageView.getPaddingTop() - paramImageView.getPaddingBottom();
  }

  private void h()
  {
    if (this.G != null)
    {
      this.G.a();
      this.G = null;
    }
  }

  private void i()
  {
    if (k())
      c(e());
  }

  private void j()
  {
    ImageView localImageView = c();
    if ((localImageView != null) && (!(localImageView instanceof c)) && (!ImageView.ScaleType.MATRIX.equals(localImageView.getScaleType())))
      throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
  }

  private boolean k()
  {
    ImageView localImageView = c();
    if (localImageView == null)
      return false;
    RectF localRectF = b(e());
    if (localRectF == null)
      return false;
    float f1 = localRectF.height();
    float f2 = localRectF.width();
    int i1 = d(localImageView);
    float f3;
    if (f1 <= i1)
      switch (g()[this.J.ordinal()])
      {
      default:
        f3 = (i1 - f1) / 2.0F - localRectF.top;
      case 6:
      case 5:
      }
    while (true)
    {
      int i2 = c(localImageView);
      float f4;
      if (f2 <= i2)
        switch (g()[this.J.ordinal()])
        {
        default:
          f4 = (i2 - f2) / 2.0F - localRectF.left;
          label163: this.H = 2;
        case 6:
        case 5:
        }
      while (true)
      {
        this.v.postTranslate(f4, f3);
        return true;
        f3 = -localRectF.top;
        break;
        f3 = i1 - f1 - localRectF.top;
        break;
        if (localRectF.top > 0.0F)
        {
          f3 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= i1)
          break label340;
        f3 = i1 - localRectF.bottom;
        break;
        f4 = -localRectF.left;
        break label163;
        f4 = i2 - f2 - localRectF.left;
        break label163;
        if (localRectF.left > 0.0F)
        {
          this.H = 0;
          f4 = -localRectF.left;
          continue;
        }
        if (localRectF.right < i2)
        {
          f4 = i2 - localRectF.right;
          this.H = 1;
          continue;
        }
        this.H = -1;
        f4 = 0.0F;
      }
      label340: f3 = 0.0F;
    }
  }

  private void l()
  {
    this.v.reset();
    c(e());
    k();
  }

  public void a(float paramFloat1, float paramFloat2)
  {
    if (this.s.a());
    ViewParent localViewParent;
    do
      while (true)
      {
        return;
        if (l)
        {
          uk.co.senab.photoview.b.b localb = uk.co.senab.photoview.b.a.a();
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = Float.valueOf(paramFloat1);
          arrayOfObject[1] = Float.valueOf(paramFloat2);
          localb.b("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", arrayOfObject));
        }
        ImageView localImageView = c();
        this.v.postTranslate(paramFloat1, paramFloat2);
        i();
        localViewParent = localImageView.getParent();
        if ((!this.p) || (this.s.a()))
          break;
        if (((this.H != 2) && ((this.H != 0) || (paramFloat1 < 1.0F)) && ((this.H != 1) || (paramFloat1 > -1.0F))) || (localViewParent == null))
          continue;
        localViewParent.requestDisallowInterceptTouchEvent(false);
        return;
      }
    while (localViewParent == null);
    localViewParent.requestDisallowInterceptTouchEvent(true);
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (l)
    {
      uk.co.senab.photoview.b.b localb = uk.co.senab.photoview.b.a.a();
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Float.valueOf(paramFloat1);
      arrayOfObject[1] = Float.valueOf(paramFloat2);
      arrayOfObject[2] = Float.valueOf(paramFloat3);
      localb.b("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", arrayOfObject));
    }
    if ((getScale() < this.o) || (paramFloat1 < 1.0F))
    {
      this.v.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      i();
    }
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (l)
      uk.co.senab.photoview.b.a.a().b("PhotoViewAttacher", "onFling. sX: " + paramFloat1 + " sY: " + paramFloat2 + " Vx: " + paramFloat3 + " Vy: " + paramFloat4);
    ImageView localImageView = c();
    this.G = new b(localImageView.getContext());
    this.G.a(c(localImageView), d(localImageView), (int)paramFloat3, (int)paramFloat4);
    localImageView.post(this.G);
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if ((paramFloat1 < this.m) || (paramFloat1 > this.o))
        uk.co.senab.photoview.b.a.a().c("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
    }
    else
      return;
    if (paramBoolean)
    {
      localImageView.post(new a(getScale(), paramFloat1, paramFloat2, paramFloat3));
      return;
    }
    this.v.setScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    i();
  }

  public void a(float paramFloat, boolean paramBoolean)
  {
    ImageView localImageView = c();
    if (localImageView != null)
      a(paramFloat, localImageView.getRight() / 2, localImageView.getBottom() / 2, paramBoolean);
  }

  public boolean a()
  {
    return this.I;
  }

  public boolean a(Matrix paramMatrix)
  {
    if (paramMatrix == null)
      throw new IllegalArgumentException("Matrix cannot be null");
    ImageView localImageView = c();
    if (localImageView == null);
    do
      return false;
    while (localImageView.getDrawable() == null);
    this.v.set(paramMatrix);
    c(e());
    k();
    return true;
  }

  public void b()
  {
    if (this.q == null)
      return;
    ImageView localImageView = (ImageView)this.q.get();
    if (localImageView != null)
    {
      ViewTreeObserver localViewTreeObserver = localImageView.getViewTreeObserver();
      if ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()))
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      localImageView.setOnTouchListener(null);
      h();
    }
    if (this.r != null)
      this.r.setOnDoubleTapListener(null);
    this.y = null;
    this.z = null;
    this.A = null;
    this.q = null;
  }

  public ImageView c()
  {
    WeakReference localWeakReference = this.q;
    ImageView localImageView = null;
    if (localWeakReference != null)
      localImageView = (ImageView)this.q.get();
    if (localImageView == null)
    {
      b();
      Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
    }
    return localImageView;
  }

  public void d()
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if (this.I)
      {
        b(localImageView);
        a(localImageView.getDrawable());
      }
    }
    else
      return;
    l();
  }

  public Matrix e()
  {
    this.u.set(this.t);
    this.u.postConcat(this.v);
    return this.u;
  }

  public Matrix getDisplayMatrix()
  {
    return new Matrix(e());
  }

  public RectF getDisplayRect()
  {
    k();
    return b(e());
  }

  public c getIPhotoViewImplementation()
  {
    return this;
  }

  @Deprecated
  public float getMaxScale()
  {
    return getMaximumScale();
  }

  public float getMaximumScale()
  {
    return this.o;
  }

  public float getMediumScale()
  {
    return this.n;
  }

  @Deprecated
  public float getMidScale()
  {
    return getMediumScale();
  }

  @Deprecated
  public float getMinScale()
  {
    return getMinimumScale();
  }

  public float getMinimumScale()
  {
    return this.m;
  }

  public d getOnPhotoTapListener()
  {
    return this.z;
  }

  public e getOnViewTapListener()
  {
    return this.A;
  }

  public float getScale()
  {
    return FloatMath.sqrt((float)Math.pow(a(this.v, 0), 2.0D) + (float)Math.pow(a(this.v, 3), 2.0D));
  }

  public ImageView.ScaleType getScaleType()
  {
    return this.J;
  }

  public Bitmap getVisibleRectangleBitmap()
  {
    ImageView localImageView = c();
    if (localImageView == null)
      return null;
    return localImageView.getDrawingCache();
  }

  public void onGlobalLayout()
  {
    ImageView localImageView = c();
    if (localImageView != null)
    {
      if (!this.I)
        break label103;
      int i1 = localImageView.getTop();
      int i2 = localImageView.getRight();
      int i3 = localImageView.getBottom();
      int i4 = localImageView.getLeft();
      if ((i1 != this.C) || (i3 != this.E) || (i4 != this.F) || (i2 != this.D))
      {
        a(localImageView.getDrawable());
        this.C = i1;
        this.D = i2;
        this.E = i3;
        this.F = i4;
      }
    }
    return;
    label103: a(localImageView.getDrawable());
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.I) && (a((ImageView)paramView)))
    {
      ViewParent localViewParent = paramView.getParent();
      int i1;
      switch (paramMotionEvent.getAction())
      {
      case 2:
      default:
        i1 = 0;
      case 0:
      case 1:
      case 3:
      }
      while (true)
      {
        if ((this.s != null) && (this.s.c(paramMotionEvent)))
          i1 = 1;
        if ((this.r != null) && (this.r.onTouchEvent(paramMotionEvent)))
          i1 = 1;
        return i1;
        if (localViewParent != null)
          localViewParent.requestDisallowInterceptTouchEvent(true);
        while (true)
        {
          h();
          i1 = 0;
          break;
          Log.i("PhotoViewAttacher", "onTouch getParent() returned null");
        }
        if (getScale() >= this.m)
          break;
        RectF localRectF = getDisplayRect();
        if (localRectF == null)
          break;
        paramView.post(new a(getScale(), this.m, localRectF.centerX(), localRectF.centerY()));
        i1 = 1;
      }
    }
    return false;
  }

  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  @Deprecated
  public void setMaxScale(float paramFloat)
  {
    setMaximumScale(paramFloat);
  }

  public void setMaximumScale(float paramFloat)
  {
    b(this.m, this.n, paramFloat);
    this.o = paramFloat;
  }

  public void setMediumScale(float paramFloat)
  {
    b(this.m, paramFloat, this.o);
    this.n = paramFloat;
  }

  @Deprecated
  public void setMidScale(float paramFloat)
  {
    setMediumScale(paramFloat);
  }

  @Deprecated
  public void setMinScale(float paramFloat)
  {
    setMinimumScale(paramFloat);
  }

  public void setMinimumScale(float paramFloat)
  {
    b(paramFloat, this.n, this.o);
    this.m = paramFloat;
  }

  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    if (paramOnDoubleTapListener != null)
    {
      this.r.setOnDoubleTapListener(paramOnDoubleTapListener);
      return;
    }
    this.r.setOnDoubleTapListener(new b(this));
  }

  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.B = paramOnLongClickListener;
  }

  public void setOnMatrixChangeListener(c paramc)
  {
    this.y = paramc;
  }

  public void setOnPhotoTapListener(d paramd)
  {
    this.z = paramd;
  }

  public void setOnViewTapListener(e parame)
  {
    this.A = parame;
  }

  public void setPhotoViewRotation(float paramFloat)
  {
    this.v.setRotate(paramFloat % 360.0F);
    i();
  }

  public void setRotationBy(float paramFloat)
  {
    this.v.postRotate(paramFloat % 360.0F);
    i();
  }

  public void setRotationTo(float paramFloat)
  {
    this.v.setRotate(paramFloat % 360.0F);
    i();
  }

  public void setScale(float paramFloat)
  {
    a(paramFloat, false);
  }

  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((a(paramScaleType)) && (paramScaleType != this.J))
    {
      this.J = paramScaleType;
      d();
    }
  }

  public void setZoomTransitionDuration(int paramInt)
  {
    if (paramInt < 0)
      paramInt = 200;
    this.f = paramInt;
  }

  public void setZoomable(boolean paramBoolean)
  {
    this.I = paramBoolean;
    d();
  }

  private class a
    implements Runnable
  {
    private final float b;
    private final float c;
    private final long d;
    private final float e;
    private final float f;

    public a(float paramFloat1, float paramFloat2, float paramFloat3, float arg5)
    {
      this.b = paramFloat3;
      Object localObject;
      this.c = localObject;
      this.d = System.currentTimeMillis();
      this.e = paramFloat1;
      this.f = paramFloat2;
    }

    private float a()
    {
      float f1 = Math.min(1.0F, 1.0F * (float)(System.currentTimeMillis() - this.d) / d.this.f);
      return d.e.getInterpolation(f1);
    }

    public void run()
    {
      ImageView localImageView = d.this.c();
      if (localImageView == null);
      float f1;
      do
      {
        return;
        f1 = a();
        float f2 = (this.e + f1 * (this.f - this.e)) / d.this.getScale();
        d.a(d.this).postScale(f2, f2, this.b, this.c);
        d.b(d.this);
      }
      while (f1 >= 1.0F);
      a.a(localImageView, this);
    }
  }

  private class b
    implements Runnable
  {
    private final uk.co.senab.photoview.c.d b;
    private int c;
    private int d;

    public b(Context arg2)
    {
      Context localContext;
      this.b = uk.co.senab.photoview.c.d.a(localContext);
    }

    public void a()
    {
      if (d.f())
        uk.co.senab.photoview.b.a.a().b("PhotoViewAttacher", "Cancel Fling");
      this.b.a(true);
    }

    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RectF localRectF = d.this.getDisplayRect();
      if (localRectF == null)
        return;
      int i = Math.round(-localRectF.left);
      int j;
      int k;
      label53: int m;
      int n;
      if (paramInt1 < localRectF.width())
      {
        j = Math.round(localRectF.width() - paramInt1);
        k = 0;
        m = Math.round(-localRectF.top);
        if (paramInt2 >= localRectF.height())
          break label217;
        n = Math.round(localRectF.height() - paramInt2);
      }
      for (int i1 = 0; ; i1 = m)
      {
        this.c = i;
        this.d = m;
        if (d.f())
          uk.co.senab.photoview.b.a.a().b("PhotoViewAttacher", "fling. StartX:" + i + " StartY:" + m + " MaxX:" + j + " MaxY:" + n);
        if ((i == j) && (m == n))
          break;
        this.b.a(i, m, paramInt3, paramInt4, k, j, i1, n, 0, 0);
        return;
        j = i;
        k = i;
        break label53;
        label217: n = m;
      }
    }

    public void run()
    {
      if (this.b.b());
      ImageView localImageView;
      do
      {
        return;
        localImageView = d.this.c();
      }
      while ((localImageView == null) || (!this.b.a()));
      int i = this.b.c();
      int j = this.b.d();
      if (d.f())
        uk.co.senab.photoview.b.a.a().b("PhotoViewAttacher", "fling run(). CurrentX:" + this.c + " CurrentY:" + this.d + " NewX:" + i + " NewY:" + j);
      d.a(d.this).postTranslate(this.c - i, this.d - j);
      d.a(d.this, d.this.e());
      this.c = i;
      this.d = j;
      a.a(localImageView, this);
    }
  }

  public static abstract interface c
  {
    public abstract void a(RectF paramRectF);
  }

  public static abstract interface d
  {
    public abstract void a(View paramView, float paramFloat1, float paramFloat2);
  }

  public static abstract interface e
  {
    public abstract void a(View paramView, float paramFloat1, float paramFloat2);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.d
 * JD-Core Version:    0.6.0
 */