package com.gensee.vodpdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class AnnoRect extends AbsAnno
{
  private long blockhandle;
  private int bottom;
  private int color;
  private long filehandle;
  private long id;
  private int left;
  private short linesize;
  Paint mPaint;
  Path mPath;
  private long owner;
  private int right;
  private int top;

  public AnnoRect()
  {
    setType(2054);
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
    if (((paramFloat1 >= i - 8.0F) && (paramFloat1 <= 8.0F + i)) || ((paramFloat1 >= k - 8.0F) && (paramFloat1 <= 8.0F + k)))
      return (paramFloat2 >= j) && (paramFloat2 <= m);
    if (((paramFloat2 >= j - 8.0F) && (paramFloat2 <= 8.0F + j)) || ((paramFloat2 >= m - 8.0F) && (paramFloat2 <= 8.0F + m)))
      return (paramFloat1 >= i) && (paramFloat1 <= k);
    return false;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
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

  public long getBlockhandle()
  {
    return this.blockhandle;
  }

  public int getBottom()
  {
    return this.bottom;
  }

  public long getColor()
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

  public long getLeft()
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
    return "AnnoRect [id=" + this.id + ", filehandle=" + this.filehandle + ", blockhandle=" + this.blockhandle + ", owner=" + this.owner + ", color=" + this.color + ", linesize=" + this.linesize + ", left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AnnoRect
 * JD-Core Version:    0.6.0
 */