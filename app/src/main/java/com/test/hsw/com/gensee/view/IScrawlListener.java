package com.gensee.view;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface IScrawlListener
{
  public abstract void onDrawEnd(View paramView, Bitmap paramBitmap);

  public abstract void onNextPage(View paramView);

  public abstract void onPrePage(View paramView);

  public abstract void onSingleClick(View paramView);
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.IScrawlListener
 * JD-Core Version:    0.6.0
 */