package com.gensee.vodpdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public class AnnoCircle extends AbsAnno
{
  private long blockhandle;
  private int bottom;
  private int color;
  private long filehandle;
  private long id;
  private int left;
  private short linesize;
  private Paint mPaint;
  private long owner;
  private int right;
  private int top;

  public AnnoCircle()
  {
    setType(2053);
  }

  private float getScaleX(long paramLong, float[] paramArrayOfFloat)
  {
    return (float)paramLong * paramArrayOfFloat[0] + paramArrayOfFloat[2];
  }

  private float getScaleY(long paramLong, float[] paramArrayOfFloat)
  {
    return (float)paramLong * paramArrayOfFloat[4] + paramArrayOfFloat[5];
  }

  public boolean contain(float paramFloat1, float paramFloat2)
  {
    float f1 = this.left;
    float f2 = this.top;
    float f3 = this.right;
    float f4 = this.bottom;
    if (this.left > this.right)
    {
      f1 = this.right;
      f3 = this.left;
    }
    if (this.top > this.bottom)
    {
      f2 = this.bottom;
      f4 = this.top;
    }
    if ((paramFloat1 >= f1 - 8.0F) && (paramFloat1 <= f3 + 8.0F) && (paramFloat2 >= f2 - 8.0F) && (paramFloat2 <= f4 + 8.0F))
    {
      float f5 = (f1 + f3) / 2.0F;
      float f6 = (f2 + f4) / 2.0F;
      float f7 = f3 - f1;
      float f8 = f4 - f2;
      float f9 = f7 / 2.0F;
      float f10 = f8 / 2.0F;
      if ((f9 <= 8.0F) || (f10 <= 8.0F))
        return true;
      return ((paramFloat1 - f5) / (f9 - 8.0F) * ((paramFloat1 - f5) / (f9 - 8.0F)) + (paramFloat2 - f6) / (f10 - 8.0F) * ((paramFloat2 - f6) / (f10 - 8.0F)) > 1.0F) && ((paramFloat1 - f5) / (f9 + 8.0F) * ((paramFloat1 - f5) / (f9 + 8.0F)) + (paramFloat2 - f6) / (f10 + 8.0F) * ((paramFloat2 - f6) / (f10 + 8.0F)) < 1.0F);
    }
    return false;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    float[] arrayOfFloat;
    float f1;
    float f2;
    if ((paramCanvas != null) && (paramMatrix != null))
    {
      if (this.mPaint == null)
      {
        this.mPaint = new Paint();
        this.mPaint.setColor(this.color);
        this.mPaint.setStrokeWidth(this.linesize);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
      }
      arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      f1 = getScaleX(this.left, arrayOfFloat);
      f2 = getScaleX(this.right, arrayOfFloat);
      if (f1 <= f2)
        break label208;
    }
    while (true)
    {
      float f4 = getScaleY(this.top, arrayOfFloat);
      float f5 = getScaleY(this.bottom, arrayOfFloat);
      if (f4 > f5);
      while (true)
      {
        paramCanvas.drawOval(new RectF(f2, f5, f1, f4), this.mPaint);
        return;
        float f6 = f5;
        f5 = f4;
        f4 = f6;
      }
      label208: float f3 = f2;
      f2 = f1;
      f1 = f3;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AnnoCircle localAnnoCircle;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAnnoCircle = (AnnoCircle)paramObject;
    }
    while (this.id == localAnnoCircle.id);
    return false;
  }

  public long getBlockhandle()
  {
    return this.blockhandle;
  }

  public int getBottom()
  {
    return this.bottom;
  }

  public int getColor()
  {
    return this.color;
  }

  public long getFilehandle()
  {
    return this.filehandle;
  }

  public long getId()
  {
    return this.id;
  }

  public int getLeft()
  {
    return this.left;
  }

  public short getLinesize()
  {
    return this.linesize;
  }

  public long getOwner()
  {
    return this.owner;
  }

  public int getRight()
  {
    return this.right;
  }

  public int getTop()
  {
    return this.top;
  }

  public int hashCode()
  {
    return 31 + (int)(this.id ^ this.id >>> 32);
  }

  public void resetAnno(AbsAnno paramAbsAnno)
  {
  }

  public void setBlockhandle(long paramLong)
  {
    this.blockhandle = paramLong;
  }

  public void setBottom(int paramInt)
  {
    this.bottom = paramInt;
  }

  public void setColor(int paramInt)
  {
    this.color = paramInt;
  }

  public void setFilehandle(long paramLong)
  {
    this.filehandle = paramLong;
  }

  public void setId(long paramLong)
  {
    this.id = paramLong;
  }

  public void setLeft(int paramInt)
  {
    this.left = paramInt;
  }

  public void setLinesize(short paramShort)
  {
    this.linesize = paramShort;
  }

  public void setOwner(long paramLong)
  {
    this.owner = paramLong;
  }

  public void setRight(int paramInt)
  {
    this.right = paramInt;
  }

  public void setTop(int paramInt)
  {
    this.top = paramInt;
  }

  public String toString()
  {
    return "AnnoCircle [id=" + this.id + ", filehandle=" + this.filehandle + ", blockhandle=" + this.blockhandle + ", owner=" + this.owner + ", color=" + this.color + ", linesize=" + this.linesize + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AnnoCircle
 * JD-Core Version:    0.6.0
 */