package com.umeng.socialize.view.abs;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.umeng.socialize.utils.i;
import com.umeng.socialize.view.wigets.b;

public class a extends RelativeLayout
{
  private static final int a = 150;
  private Context b;
  private b c;
  private Animation d;
  private View e;

  public a(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    b();
  }

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void b()
  {
    this.c = new b(this.b);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams1.addRule(12);
    this.c.setLayoutParams(localLayoutParams1);
    this.d = new TranslateAnimation(0.0F, 0.0F, 80.0F, 0.0F);
    this.d.setDuration(150L);
    addView(this.c);
    this.e = new View(this.b);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams2.addRule(10);
    this.e.setLayoutParams(localLayoutParams2);
    this.e.setBackgroundColor(Color.argb(50, 0, 0, 0));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(1500L);
    this.e.setAnimation(localAlphaAnimation);
    addView(this.e);
  }

  public void a()
  {
    this.c.startAnimation(this.d);
  }

  public void a(View.OnClickListener paramOnClickListener)
  {
    this.e.setOnClickListener(paramOnClickListener);
  }

  public void a(com.umeng.socialize.view.wigets.a parama)
  {
    this.c.a(parama);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    i.c("onMeasure", "ActionBoard, width = " + i + ", height = " + j);
    ViewGroup.LayoutParams localLayoutParams1 = this.c.getLayoutParams();
    localLayoutParams1.height = this.c.e(i);
    localLayoutParams1.width = i;
    ViewGroup.LayoutParams localLayoutParams2 = this.e.getLayoutParams();
    localLayoutParams2.height = (j - localLayoutParams1.height);
    localLayoutParams2.width = i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.umeng.socialize.view.abs.a
 * JD-Core Version:    0.6.0
 */