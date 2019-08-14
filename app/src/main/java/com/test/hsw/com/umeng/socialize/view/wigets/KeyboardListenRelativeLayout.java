package com.umeng.socialize.view.wigets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class KeyboardListenRelativeLayout extends RelativeLayout
{
  public static final byte a = -3;
  public static final byte b = -2;
  public static final byte c = -1;
  private boolean d = false;
  private boolean e = false;
  private int f;
  private IOnKeyboardStateChangedListener g;

  public KeyboardListenRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }

  public KeyboardListenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public KeyboardListenRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.d)
    {
      this.d = true;
      this.f = paramInt4;
      if (this.g != null)
        this.g.a(-1);
      if ((this.d) && (this.f > paramInt4))
      {
        this.e = true;
        if (this.g != null)
          this.g.a(-3);
      }
      if ((this.d) && (this.e) && (this.f == paramInt4))
      {
        this.e = false;
        if (this.g != null)
          this.g.a(-2);
      }
      return;
    }
    if (this.f < paramInt4);
    for (int i = paramInt4; ; i = this.f)
    {
      this.f = i;
      break;
    }
  }

  public void setOnKeyboardStateChangedListener(IOnKeyboardStateChangedListener paramIOnKeyboardStateChangedListener)
  {
    this.g = paramIOnKeyboardStateChangedListener;
  }

  public static abstract interface IOnKeyboardStateChangedListener
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.wigets.KeyboardListenRelativeLayout
 * JD-Core Version:    0.6.0
 */