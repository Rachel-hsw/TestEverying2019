package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class PhotoView extends ImageView
  implements c
{
  private final d e;
  private ImageView.ScaleType f;

  public PhotoView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PhotoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PhotoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setScaleType(ImageView.ScaleType.MATRIX);
    this.e = new d(this);
    if (this.f != null)
    {
      setScaleType(this.f);
      this.f = null;
    }
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    this.e.a(paramFloat1, paramFloat2, paramFloat3, paramBoolean);
  }

  public void a(float paramFloat, boolean paramBoolean)
  {
    this.e.a(paramFloat, paramBoolean);
  }

  public boolean a()
  {
    return this.e.a();
  }

  public boolean a(Matrix paramMatrix)
  {
    return this.e.a(paramMatrix);
  }

  public Matrix getDisplayMatrix()
  {
    return this.e.e();
  }

  public RectF getDisplayRect()
  {
    return this.e.getDisplayRect();
  }

  public c getIPhotoViewImplementation()
  {
    return this.e;
  }

  @Deprecated
  public float getMaxScale()
  {
    return getMaximumScale();
  }

  public float getMaximumScale()
  {
    return this.e.getMaximumScale();
  }

  public float getMediumScale()
  {
    return this.e.getMediumScale();
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
    return this.e.getMinimumScale();
  }

  public d.d getOnPhotoTapListener()
  {
    return this.e.getOnPhotoTapListener();
  }

  public d.e getOnViewTapListener()
  {
    return this.e.getOnViewTapListener();
  }

  public float getScale()
  {
    return this.e.getScale();
  }

  public ImageView.ScaleType getScaleType()
  {
    return this.e.getScaleType();
  }

  public Bitmap getVisibleRectangleBitmap()
  {
    return this.e.getVisibleRectangleBitmap();
  }

  protected void onDetachedFromWindow()
  {
    this.e.b();
    super.onDetachedFromWindow();
  }

  public void setAllowParentInterceptOnEdge(boolean paramBoolean)
  {
    this.e.setAllowParentInterceptOnEdge(paramBoolean);
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.e != null)
      this.e.d();
  }

  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    if (this.e != null)
      this.e.d();
  }

  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    if (this.e != null)
      this.e.d();
  }

  @Deprecated
  public void setMaxScale(float paramFloat)
  {
    setMaximumScale(paramFloat);
  }

  public void setMaximumScale(float paramFloat)
  {
    this.e.setMaximumScale(paramFloat);
  }

  public void setMediumScale(float paramFloat)
  {
    this.e.setMediumScale(paramFloat);
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
    this.e.setMinimumScale(paramFloat);
  }

  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.e.setOnDoubleTapListener(paramOnDoubleTapListener);
  }

  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.e.setOnLongClickListener(paramOnLongClickListener);
  }

  public void setOnMatrixChangeListener(d.c paramc)
  {
    this.e.setOnMatrixChangeListener(paramc);
  }

  public void setOnPhotoTapListener(d.d paramd)
  {
    this.e.setOnPhotoTapListener(paramd);
  }

  public void setOnViewTapListener(d.e parame)
  {
    this.e.setOnViewTapListener(parame);
  }

  public void setPhotoViewRotation(float paramFloat)
  {
    this.e.setRotationTo(paramFloat);
  }

  public void setRotationBy(float paramFloat)
  {
    this.e.setRotationBy(paramFloat);
  }

  public void setRotationTo(float paramFloat)
  {
    this.e.setRotationTo(paramFloat);
  }

  public void setScale(float paramFloat)
  {
    this.e.setScale(paramFloat);
  }

  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (this.e != null)
    {
      this.e.setScaleType(paramScaleType);
      return;
    }
    this.f = paramScaleType;
  }

  public void setZoomTransitionDuration(int paramInt)
  {
    this.e.setZoomTransitionDuration(paramInt);
  }

  public void setZoomable(boolean paramBoolean)
  {
    this.e.setZoomable(paramBoolean);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.PhotoView
 * JD-Core Version:    0.6.0
 */