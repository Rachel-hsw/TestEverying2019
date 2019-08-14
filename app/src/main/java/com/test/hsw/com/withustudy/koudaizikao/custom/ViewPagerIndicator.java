package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.withustudy.koudaizikao.R.styleable;
import java.util.Iterator;
import java.util.List;

public class ViewPagerIndicator extends LinearLayout
{
  private static final float f = 0.1666667F;
  private static final int j = 2;
  private static final int m = 2013265919;
  private static final int n = 2599386;
  public ViewPager a;
  private Paint b;
  private Path c;
  private int d;
  private int e;
  private final int g = (int)(0.1666667F * (getScreenWidth() / 3));
  private int h;
  private float i;
  private int k = 2;
  private List<String> l;
  private a o;

  public ViewPagerIndicator(Context paramContext)
  {
    this(paramContext, null);
  }

  public ViewPagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerIndicator);
    this.k = localTypedArray.getInt(0, 2);
    if (this.k < 0)
      this.k = 2;
    localTypedArray.recycle();
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setColor(Color.parseColor("#ffffffff"));
    this.b.setStyle(Paint.Style.FILL);
    this.b.setPathEffect(new CornerPathEffect(3.0F));
  }

  private TextView a(String paramString)
  {
    TextView localTextView = new TextView(getContext());
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.width = (getScreenWidth() / this.k);
    localTextView.setGravity(17);
    localTextView.setTextColor(getResources().getColor(2131034229));
    localTextView.setText(paramString);
    localTextView.setTextSize(2, 16.0F);
    localTextView.setLayoutParams(localLayoutParams);
    return localTextView;
  }

  private void c()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= getChildCount())
        return;
      View localView = getChildAt(i1);
      if (!(localView instanceof TextView))
        continue;
      ((TextView)localView).setTextColor(getResources().getColor(2131034229));
    }
  }

  private void d()
  {
    this.c = new Path();
    this.e = (int)(this.d / 2 / Math.sqrt(2.0D));
    this.c.moveTo(0.0F, 0.0F);
    this.c.lineTo(this.d, 0.0F);
    this.c.lineTo(this.d / 2, -this.e);
    this.c.close();
  }

  public void a()
  {
    this.h = (getWidth() / this.k / 2 - this.d / 2);
    this.i = 0.0F;
  }

  protected void a(int paramInt)
  {
    View localView = getChildAt(paramInt);
    if ((localView instanceof TextView))
      ((TextView)localView).setTextColor(getResources().getColor(2131034212));
  }

  public void a(int paramInt, float paramFloat)
  {
    int i1 = getWidth();
    this.i = ((paramFloat + paramInt) * (i1 / this.k));
    int i2 = getScreenWidth() / this.k;
    if ((paramFloat >= 0.0F) && (paramInt >= -2 + this.k) && (getChildCount() > this.k))
    {
      if (this.k == 1)
        break label97;
      scrollTo(i2 * (paramInt - (-2 + this.k)) + (int)(paramFloat * i2), 0);
    }
    while (true)
    {
      invalidate();
      return;
      label97: scrollTo(paramInt * i2 + (int)(paramFloat * i2), 0);
    }
  }

  public void a(ViewPager paramViewPager, int paramInt)
  {
    this.a = paramViewPager;
    paramViewPager.setOnPageChangeListener(new q(this));
    paramViewPager.setCurrentItem(paramInt);
    a(paramInt);
  }

  public void b()
  {
    int i1 = getChildCount();
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        return;
      getChildAt(i2).setOnClickListener(new r(this, i2));
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.h + this.i, 1 + getHeight());
    paramCanvas.drawPath(this.c, this.b);
    paramCanvas.restore();
    super.dispatchDraw(paramCanvas);
  }

  public int getScreenWidth()
  {
    WindowManager localWindowManager = (WindowManager)getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }

  protected void onFinishInflate()
  {
    Log.e("TAG", "onFinishInflate");
    super.onFinishInflate();
    int i1 = getChildCount();
    if (i1 == 0)
      return;
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        b();
        return;
      }
      View localView = getChildAt(i2);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.weight = 0.0F;
      localLayoutParams.width = (getScreenWidth() / this.k);
      localView.setLayoutParams(localLayoutParams);
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = (int)(0.1666667F * (paramInt1 / this.k));
    this.d = Math.min(this.g, this.d);
    d();
    this.h = (getWidth() / this.k / 2 - this.d / 2);
  }

  public void setOnPageChangeListener(a parama)
  {
    this.o = parama;
  }

  public void setTabItemTitles(List<String> paramList)
  {
    Iterator localIterator;
    if ((paramList != null) && (paramList.size() > 0))
    {
      removeAllViews();
      this.l = paramList;
      localIterator = this.l.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        b();
        return;
      }
      addView(a((String)localIterator.next()));
    }
  }

  public void setVisibleTabCount(int paramInt)
  {
    this.k = paramInt;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, float paramFloat, int paramInt2);

    public abstract void b(int paramInt);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.ViewPagerIndicator
 * JD-Core Version:    0.6.0
 */