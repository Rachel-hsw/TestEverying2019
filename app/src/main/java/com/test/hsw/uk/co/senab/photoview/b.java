package uk.co.senab.photoview;

import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.widget.ImageView;

public class b
  implements GestureDetector.OnDoubleTapListener
{
  private d a;

  public b(d paramd)
  {
    a(paramd);
  }

  public void a(d paramd)
  {
    this.a = paramd;
  }

  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a == null)
      return false;
    try
    {
      float f1 = this.a.getScale();
      float f2 = paramMotionEvent.getX();
      float f3 = paramMotionEvent.getY();
      if (f1 < this.a.getMediumScale())
      {
        this.a.a(this.a.getMediumScale(), f2, f3, true);
        return true;
      }
      if ((f1 >= this.a.getMediumScale()) && (f1 < this.a.getMaximumScale()))
      {
        this.a.a(this.a.getMaximumScale(), f2, f3, true);
        return true;
      }
      this.a.a(this.a.getMinimumScale(), f2, f3, true);
      return true;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
    return true;
  }

  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a == null);
    ImageView localImageView;
    do
    {
      return false;
      localImageView = this.a.c();
      if (this.a.getOnPhotoTapListener() == null)
        continue;
      RectF localRectF = this.a.getDisplayRect();
      if (localRectF == null)
        continue;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (!localRectF.contains(f1, f2))
        continue;
      float f3 = (f1 - localRectF.left) / localRectF.width();
      float f4 = (f2 - localRectF.top) / localRectF.height();
      this.a.getOnPhotoTapListener().a(localImageView, f3, f4);
      return true;
    }
    while (this.a.getOnViewTapListener() == null);
    this.a.getOnViewTapListener().a(localImageView, paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.b
 * JD-Core Version:    0.6.0
 */