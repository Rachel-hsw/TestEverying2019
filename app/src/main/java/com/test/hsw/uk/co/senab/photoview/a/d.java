package uk.co.senab.photoview.a;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class d
  implements ScaleGestureDetector.OnScaleGestureListener
{
  d(c paramc)
  {
  }

  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f)))
      return false;
    this.a.a.a(f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    return true;
  }

  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }

  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.a.d
 * JD-Core Version:    0.6.0
 */