package uk.co.senab.photoview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

class e extends GestureDetector.SimpleOnGestureListener
{
  e(d paramd)
  {
  }

  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (d.c(this.a) != null)
      d.c(this.a).onLongClick(this.a.c());
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.e
 * JD-Core Version:    0.6.0
 */