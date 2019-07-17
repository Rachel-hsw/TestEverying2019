package com.withustudy.koudaizikao.custom;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import java.util.BitSet;

class a
  implements View.OnClickListener
{
  a(AbstractSlideExpandableListAdapter paramAbstractSlideExpandableListAdapter, View paramView, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
    Animation localAnimation = this.b.getAnimation();
    if ((localAnimation != null) && (localAnimation.hasStarted()) && (!localAnimation.hasEnded()))
    {
      localAnimation.setAnimationListener(new b(this, paramView));
      return;
    }
    this.b.setAnimation(null);
    int i;
    if (this.b.getVisibility() == 0)
    {
      i = 1;
      if (i != 0)
        break label229;
      AbstractSlideExpandableListAdapter.a(this.a).set(this.c, true);
      label79: if (i != 0)
        break label247;
      if ((AbstractSlideExpandableListAdapter.b(this.a) != -1) && (AbstractSlideExpandableListAdapter.b(this.a) != this.c))
      {
        if (AbstractSlideExpandableListAdapter.c(this.a) != null)
        {
          AbstractSlideExpandableListAdapter.a(this.a, AbstractSlideExpandableListAdapter.c(this.a), 1);
          AbstractSlideExpandableListAdapter.a(this.a, 1, AbstractSlideExpandableListAdapter.c(this.a), AbstractSlideExpandableListAdapter.b(this.a));
        }
        AbstractSlideExpandableListAdapter.a(this.a).set(AbstractSlideExpandableListAdapter.b(this.a), false);
      }
      AbstractSlideExpandableListAdapter.a(this.a, this.b);
      AbstractSlideExpandableListAdapter.a(this.a, this.c);
    }
    while (true)
    {
      AbstractSlideExpandableListAdapter.a(this.a, this.b, i);
      AbstractSlideExpandableListAdapter.a(this.a, i, this.b, this.c);
      return;
      i = 0;
      break;
      label229: AbstractSlideExpandableListAdapter.a(this.a).set(this.c, false);
      break label79;
      label247: if (AbstractSlideExpandableListAdapter.b(this.a) != this.c)
        continue;
      AbstractSlideExpandableListAdapter.a(this.a, -1);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.a
 * JD-Core Version:    0.6.0
 */