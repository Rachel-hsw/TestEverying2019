package com.withustudy.koudaizikao.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.withustudy.koudaizikao.R.styleable;

public class RoundImageView extends ImageView
{
  public static final int a = 0;
  public static final int b = 1;
  private static final int d = 10;
  private static final String l = "state_instance";
  private static final String m = "state_type";
  private static final String n = "state_border_radius";
  private int c;
  private int e;
  private Paint f = new Paint();
  private int g;
  private Matrix h = new Matrix();
  private BitmapShader i;
  private int j;
  private RectF k;

  public RoundImageView(Context paramContext)
  {
    this(paramContext, null);
  }

  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f.setAntiAlias(true);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RoundImageView);
    this.e = localTypedArray.getDimensionPixelSize(0, (int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.c = localTypedArray.getInt(1, 0);
    localTypedArray.recycle();
  }

  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
      return ((BitmapDrawable)paramDrawable).getBitmap();
    int i1 = paramDrawable.getIntrinsicWidth();
    int i2 = paramDrawable.getIntrinsicHeight();
    Bitmap localBitmap = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, i1, i2);
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }

  private void a()
  {
    float f1 = 1.0F;
    Drawable localDrawable = getDrawable();
    if (localDrawable == null)
      return;
    Bitmap localBitmap = a(localDrawable);
    this.i = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    if (this.c == 0)
    {
      int i1 = Math.min(localBitmap.getWidth(), localBitmap.getHeight());
      f1 = f1 * this.j / i1;
    }
    while (true)
    {
      this.h.setScale(f1, f1);
      this.i.setLocalMatrix(this.h);
      this.f.setShader(this.i);
      return;
      if (this.c != 1)
        continue;
      Log.e("TAG", "b'w = " + localBitmap.getWidth() + " , " + "b'h = " + localBitmap.getHeight());
      if ((localBitmap.getWidth() == getWidth()) && (localBitmap.getHeight() == getHeight()))
        continue;
      f1 = Math.max(f1 * getWidth() / localBitmap.getWidth(), f1 * getHeight() / localBitmap.getHeight());
    }
  }

  public int a(int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
  }

  protected void onDraw(Canvas paramCanvas)
  {
    Log.e("TAG", "onDraw");
    if (getDrawable() == null)
      return;
    a();
    if (this.c == 1)
    {
      paramCanvas.drawRoundRect(this.k, this.e, this.e, this.f);
      return;
    }
    paramCanvas.drawCircle(this.g, this.g, this.g, this.f);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.c == 0)
    {
      this.j = Math.min(getMeasuredWidth(), getMeasuredHeight());
      this.g = (this.j / 2);
      setMeasuredDimension(this.j, this.j);
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      super.onRestoreInstanceState(((Bundle)paramParcelable).getParcelable("state_instance"));
      this.c = localBundle.getInt("state_type");
      this.e = localBundle.getInt("state_border_radius");
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("state_instance", super.onSaveInstanceState());
    localBundle.putInt("state_type", this.c);
    localBundle.putInt("state_border_radius", this.e);
    return localBundle;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c == 1)
      this.k = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
  }

  public void setBorderRadius(int paramInt)
  {
    int i1 = a(paramInt);
    if (this.e != i1)
    {
      this.e = i1;
      invalidate();
    }
  }

  public void setType(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      if ((this.c != 1) && (this.c != 0))
        this.c = 0;
      requestLayout();
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.custom.RoundImageView
 * JD-Core Version:    0.6.0
 */