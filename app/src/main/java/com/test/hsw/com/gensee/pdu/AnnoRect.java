package com.gensee.pdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class AnnoRect extends AbsAnno
{
  private int bottom;
  private int color;
  private int left;
  private byte linesize;
  Paint mPaint;
  Path mPath;
  private int right;
  private int top;

  public AnnoRect()
  {
    setType(6);
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
    if (((paramFloat1 >= i - 32.0F) && (paramFloat1 <= 32.0F + i)) || ((paramFloat1 >= k - 32.0F) && (paramFloat1 <= 32.0F + k)))
      return (paramFloat2 >= j) && (paramFloat2 <= m);
    if (((paramFloat2 >= j - 32.0F) && (paramFloat2 <= 32.0F + j)) || ((paramFloat2 >= m - 32.0F) && (paramFloat2 <= 32.0F + m)))
      return (paramFloat1 >= i) && (paramFloat1 <= k);
    return false;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
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
    if (this.mPath == null)
    {
      this.mPath = new Path();
      this.mPath.moveTo(this.left, this.top);
      this.mPath.lineTo(this.right, this.top);
      this.mPath.lineTo(this.right, this.bottom);
      this.mPath.lineTo(this.left, this.bottom);
      this.mPath.close();
    }
    Path localPath = new Path(this.mPath);
    localPath.transform(paramMatrix);
    paramCanvas.drawPath(localPath, this.mPaint);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AnnoRect localAnnoRect;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAnnoRect = (AnnoRect)paramObject;
    }
    while (this.id == localAnnoRect.id);
    return false;
  }

  public int getBottom()
  {
    return this.bottom;
  }

  public long getColor()
  {
    return this.color;
  }

  public long getLeft()
  {
    return this.left;
  }

  public short getLinesize()
  {
    return this.linesize;
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
    return "AnnoRect [color=" + this.color + ", linesize=" + this.linesize + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ", mPaint=" + this.mPaint + ", mPath=" + this.mPath + "," + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoRect
 * JD-Core Version:    0.6.0
 */