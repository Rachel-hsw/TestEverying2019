package uk.co.senab.photoview.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
public class c extends b
{
  protected final ScaleGestureDetector f = new ScaleGestureDetector(paramContext, new d(this));

  public c(Context paramContext)
  {
    super(paramContext);
  }

  public boolean a()
  {
    return this.f.isInProgress();
  }

  public boolean c(MotionEvent paramMotionEvent)
  {
    this.f.onTouchEvent(paramMotionEvent);
    return super.c(paramMotionEvent);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.senab.photoview.a.c
 * JD-Core Version:    0.6.0
 */