package com.gensee.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class DocView$1 extends GestureDetector.SimpleOnGestureListener
{
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (DocView.access$0(this.this$0) != null)
      DocView.access$0(this.this$0).onDoubleClicked(this.this$0);
    return false;
  }

  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (DocView.access$0(this.this$0) != null)
      DocView.access$0(this.this$0).onSingleClicked(this.this$0);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.DocView.1
 * JD-Core Version:    0.6.0
 */