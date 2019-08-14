package com.withustudy.koudaizikao.custom.circleprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.withustudy.koudaizikao.R.styleable;

public class ProgressButton extends ViewGroup
{
  private Context a;

  public ProgressButton(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }

  public ProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a(paramAttributeSet);
    a();
  }

  private void a()
  {
  }

  private void a(AttributeSet paramAttributeSet)
  {
    this.a.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleProgressBar).recycle();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.circleprogressbar.ProgressButton
 * JD-Core Version:    0.6.0
 */