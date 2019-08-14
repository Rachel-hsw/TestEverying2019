package com.gensee.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.gensee.player.IPlayerModule;

public abstract class GsAbsView extends FrameLayout
  implements View.OnClickListener
{
  public GsAbsView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GsAbsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GsAbsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    loadView(paramContext);
  }

  protected abstract View getView(Context paramContext);

  protected void initView(View paramView)
  {
  }

  protected void loadView(Context paramContext)
  {
    removeAllViews();
    View localView = getView(paramContext);
    addView(localView, -1, -1);
    initView(localView);
  }

  public void setModuleHandle(IPlayerModule paramIPlayerModule)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GsAbsView
 * JD-Core Version:    0.6.0
 */