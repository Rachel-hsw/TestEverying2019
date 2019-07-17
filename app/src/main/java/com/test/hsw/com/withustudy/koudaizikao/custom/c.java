package com.withustudy.koudaizikao.custom;

import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ListView;

class c
  implements Animation.AnimationListener
{
  c(AbstractSlideExpandableListAdapter paramAbstractSlideExpandableListAdapter, int paramInt, View paramView)
  {
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    ListView localListView;
    int i;
    Rect localRect1;
    Rect localRect2;
    if ((this.b == 0) && ((AbstractSlideExpandableListAdapter.d(this.a) instanceof ListView)))
    {
      localListView = (ListView)AbstractSlideExpandableListAdapter.d(this.a);
      i = this.c.getBottom();
      localRect1 = new Rect();
      boolean bool = this.c.getGlobalVisibleRect(localRect1);
      localRect2 = new Rect();
      localListView.getGlobalVisibleRect(localRect2);
      if (bool)
        break label93;
      localListView.smoothScrollBy(i, this.a.b());
    }
    label93: 
    do
      return;
    while (localRect2.bottom != localRect1.bottom);
    localListView.smoothScrollBy(i, this.a.b());
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.c
 * JD-Core Version:    0.6.0
 */