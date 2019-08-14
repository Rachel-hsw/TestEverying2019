package com.gensee.vodpdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;

public class AnnoPointer extends AbsAnno
{
  private static final int RADIUS = 15;
  private long blockhandle;
  private long filehandle;
  private long id;
  private long owner;
  private long x;
  private long y;

  public AnnoPointer()
  {
    setType(2050);
  }

  public boolean contain(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 - (float)this.x) * (paramFloat1 - (float)this.x) + (paramFloat2 - (float)this.y) * (paramFloat2 - (float)this.y) <= 225.0F;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    long l1 = ()((float)this.x * arrayOfFloat[0] + arrayOfFloat[2]);
    long l2 = ()((float)this.y * arrayOfFloat[4] + arrayOfFloat[5]);
    long l3 = l1 + 15L;
    long l4 = l2 + 15L;
    Paint localPaint = new Paint();
    localPaint.setDither(true);
    localPaint.setAntiAlias(true);
    localPaint.setColor(-16776961);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeCap(Paint.Cap.ROUND);
    localPaint.setStrokeWidth(4.0F);
    paramCanvas.drawCircle((float)l3, (float)l4, 15.0F, localPaint);
    paramCanvas.drawLine((float)(l3 - 20L), (float)l4, (float)(20L + l3), (float)l4, localPaint);
    paramCanvas.drawLine((float)l3, (float)(l4 - 20L), (float)l3, (float)(20L + l4), localPaint);
    localPaint.setColor(-65536);
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawCircle((float)l3, (float)l4, 7.0F, localPaint);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AnnoPointer localAnnoPointer;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAnnoPointer = (AnnoPointer)paramObject;
    }
    while (this.id == localAnnoPointer.id);
    return false;
  }

  public long getBlockhandle()
  {
    return this.blockhandle;
  }

  public long getFilehandle()
  {
    return this.filehandle;
  }

  public long getId()
  {
    return this.id;
  }

  public long getOwner()
  {
    return this.owner;
  }

  public long getX()
  {
    return this.x;
  }

  public long getY()
  {
    return this.y;
  }

  public int hashCode()
  {
    return 31 + (int)(this.id ^ this.id >>> 32);
  }

  public void setBlockhandle(long paramLong)
  {
    this.blockhandle = paramLong;
  }

  public void setFilehandle(long paramLong)
  {
    this.filehandle = paramLong;
  }

  public void setId(long paramLong)
  {
    this.id = paramLong;
  }

  public void setOwner(long paramLong)
  {
    this.owner = paramLong;
  }

  public void setX(long paramLong)
  {
    this.x = paramLong;
  }

  public void setY(long paramLong)
  {
    this.y = paramLong;
  }

  public String toString()
  {
    return "AnnoPointer [id=" + this.id + ", filehandle=" + this.filehandle + ", blockhandle=" + this.blockhandle + ", owner=" + this.owner + ", x=" + this.x + ", y=" + this.y + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AnnoPointer
 * JD-Core Version:    0.6.0
 */