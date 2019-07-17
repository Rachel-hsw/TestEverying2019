package com.withustudy.koudaizikao.custom.swipyrefresh;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class c
  implements Drawable.Callback
{
  c(b paramb)
  {
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.invalidateSelf();
  }

  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.a.scheduleSelf(paramRunnable, paramLong);
  }

  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.a.unscheduleSelf(paramRunnable);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.swipyrefresh.c
 * JD-Core Version:    0.6.0
 */