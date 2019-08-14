package uk.co.senab.photoview;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;

public abstract interface c
{
  public static final float a = 3.0F;
  public static final float b = 1.75F;
  public static final float c = 1.0F;
  public static final int d = 200;

  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);

  public abstract void a(float paramFloat, boolean paramBoolean);

  public abstract boolean a();

  public abstract boolean a(Matrix paramMatrix);

  public abstract Matrix getDisplayMatrix();

  public abstract RectF getDisplayRect();

  public abstract c getIPhotoViewImplementation();

  @Deprecated
  public abstract float getMaxScale();

  public abstract float getMaximumScale();

  public abstract float getMediumScale();

  @Deprecated
  public abstract float getMidScale();

  @Deprecated
  public abstract float getMinScale();

  public abstract float getMinimumScale();

  public abstract d.d getOnPhotoTapListener();

  public abstract d.e getOnViewTapListener();

  public abstract float getScale();

  public abstract ImageView.ScaleType getScaleType();

  public abstract Bitmap getVisibleRectangleBitmap();

  public abstract void setAllowParentInterceptOnEdge(boolean paramBoolean);

  @Deprecated
  public abstract void setMaxScale(float paramFloat);

  public abstract void setMaximumScale(float paramFloat);

  public abstract void setMediumScale(float paramFloat);

  @Deprecated
  public abstract void setMidScale(float paramFloat);

  @Deprecated
  public abstract void setMinScale(float paramFloat);

  public abstract void setMinimumScale(float paramFloat);

  public abstract void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);

  public abstract void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener);

  public abstract void setOnMatrixChangeListener(d.c paramc);

  public abstract void setOnPhotoTapListener(d.d paramd);

  public abstract void setOnViewTapListener(d.e parame);

  public abstract void setPhotoViewRotation(float paramFloat);

  public abstract void setRotationBy(float paramFloat);

  public abstract void setRotationTo(float paramFloat);

  public abstract void setScale(float paramFloat);

  public abstract void setScaleType(ImageView.ScaleType paramScaleType);

  public abstract void setZoomTransitionDuration(int paramInt);

  public abstract void setZoomable(boolean paramBoolean);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.c
 * JD-Core Version:    0.6.0
 */