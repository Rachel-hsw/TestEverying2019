package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwitchCompat$1 extends Animation
{
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    SwitchCompat.access$000(this.this$0, this.val$startPosition + paramFloat * this.val$diff);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.SwitchCompat.1
 * JD-Core Version:    0.6.0
 */