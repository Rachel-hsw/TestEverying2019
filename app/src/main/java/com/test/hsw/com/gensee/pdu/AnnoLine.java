package com.gensee.pdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class AnnoLine extends AbsAnno
{
  protected int bottom;
  protected int color;
  protected int left;
  protected byte linesize;
  private Paint mPaint;
  private Path mPath;
  protected int right;
  protected int top;

  public AnnoLine()
  {
    setType(7);
  }

  public boolean contain(float paramFloat1, float paramFloat2)
  {
    int i = this.left;
    int j = this.top;
    int k = this.right;
    int m = this.bottom;
    if (this.left > this.right)
    {
      i = this.right;
      k = this.left;
    }
    if (this.top > this.bottom)
    {
      j = this.bottom;
      m = this.top;
    }
    if ((paramFloat1 >= i - 32.0F) && (paramFloat1 <= 32.0F + k) && (paramFloat2 >= j - 32.0F) && (paramFloat2 <= 32.0F + m))
    {
      if (this.left == this.right)
        return paramFloat1 == this.left;
      if (this.top == this.bottom)
        return paramFloat2 == this.top;
      float f1 = (this.bottom - this.top) / (this.right - this.left);
      float f2 = this.top - f1 * this.left;
      return (float)Math.sqrt((f2 + f1 * paramFloat1 - paramFloat2) * (f2 + f1 * paramFloat1 - paramFloat2) / (1.0F + f1 * f1)) <= 32.0F;
    }
    return false;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    if ((paramCanvas != null) && (paramMatrix != null))
    {
      getSourcePaint();
      getSourcePath();
      Path localPath = new Path(this.mPath);
      localPath.transform(paramMatrix);
      paramCanvas.drawPath(localPath, this.mPaint);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AnnoLine localAnnoLine;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAnnoLine = (AnnoLine)paramObject;
    }
    while (this.id == localAnnoLine.id);
    return false;
  }

  public int getBottom()
  {
    return this.bottom;
  }

  public int getColor()
  {
    return this.color;
  }

  public int getLeft()
  {
    return this.left;
  }

  public byte getLinesize()
  {
    return this.linesize;
  }

  public int getRight()
  {
    return this.right;
  }

  protected Paint getSourcePaint()
  {
    if (this.mPaint == null)
    {
      if (this.argbColor == -1)
        this.argbColor = agbrToArgb(this.color);
      this.mPaint = new Paint();
      this.mPaint.setColor(this.argbColor);
      this.mPaint.setStrokeWidth(this.linesize);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setDither(true);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeJoin(Paint.Join.ROUND);
      this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }
    return this.mPaint;
  }

  protected Path getSourcePath()
  {
    if (this.mPath == null)
    {
      this.mPath = new Path();
      this.mPath.moveTo(this.left, this.top);
      this.mPath.lineTo(this.right, this.bottom);
    }
    return this.mPath;
  }

  public int getTop()
  {
    return this.top;
  }

  public int hashCode()
  {
    return 31 + (int)(this.id ^ this.id >>> 32);
  }

  public int setArgbColor(int paramInt)
  {
    this.argbColor = paramInt;
    int i = super.setArgbColor(paramInt);
    this.color = i;
    return i;
  }

  public void setBottom(int paramInt)
  {
    this.bottom = paramInt;
  }

  public void setColor(int paramInt)
  {
    this.color = paramInt;
  }

  public void setLeft(int paramInt)
  {
    this.left = paramInt;
  }

  public void setLinesize(byte paramByte)
  {
    this.linesize = paramByte;
  }

  public void setPath(Path paramPath)
  {
    this.mPath = paramPath;
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
    return "AnnoLine [color=" + this.color + ", linesize=" + this.linesize + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + "," + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoLine
 * JD-Core Version:    0.6.0
 */