package com.gensee.vodpdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnnoFreepen extends AbsAnno
{
  private long blockhandle;
  private int color;
  private long filehandle;
  private long id;
  private short linesize;
  private Paint mPaint;
  private Path mPath;
  private long owner;
  private float preX;
  private float preY;
  private List<Point> pts;

  public AnnoFreepen()
  {
    setType(2051);
    this.pts = new ArrayList(0);
  }

  private void lineToEnd()
  {
    this.mPath.lineTo(this.preX, this.preY);
  }

  private void moveTo(float paramFloat1, float paramFloat2)
  {
    if (this.mPath == null)
      this.mPath = new Path();
    this.mPath.reset();
    this.mPath.moveTo(paramFloat1, paramFloat2);
    this.preX = paramFloat1;
    this.preY = paramFloat2;
  }

  private void quadTo(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.preX);
    float f2 = Math.abs(paramFloat2 - this.preY);
    if ((f1 >= 4.0D) || (f2 >= 4.0D))
    {
      this.mPath.quadTo(this.preX, this.preY, (paramFloat1 + this.preX) / 2.0F, (paramFloat2 + this.preY) / 2.0F);
      this.preX = paramFloat1;
      this.preY = paramFloat2;
    }
  }

  public void addPoint(float paramFloat1, float paramFloat2)
  {
    this.pts.add(new Point(paramFloat1, paramFloat2));
  }

  public boolean contain(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = this.pts.iterator();
    Point localPoint;
    do
    {
      if (!localIterator.hasNext())
        return false;
      localPoint = (Point)localIterator.next();
    }
    while ((localPoint == null) || ((float)Math.sqrt((paramFloat1 - localPoint.x) * (paramFloat1 - localPoint.x) + (paramFloat2 - localPoint.y) * (paramFloat2 - localPoint.y)) > 8.0F));
    return true;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
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
      if (this.mPath == null)
        this.mPath = new Path();
      Path localPath = new Path(this.mPath);
      localPath.transform(paramMatrix);
      paramCanvas.drawPath(localPath, this.mPaint);
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AnnoFreepen localAnnoFreepen;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAnnoFreepen = (AnnoFreepen)paramObject;
    }
    while (this.id == localAnnoFreepen.id);
    return false;
  }

  public long getBlockhandle()
  {
    return this.blockhandle;
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

  public short getLinesize()
  {
    return this.linesize;
  }

  public long getOwner()
  {
    return this.owner;
  }

  public int hashCode()
  {
    return 31 + (int)(this.id ^ this.id >>> 32);
  }

  public void setBlockhandle(long paramLong)
  {
    this.blockhandle = paramLong;
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

  public void setLinesize(short paramShort)
  {
    this.linesize = paramShort;
  }

  public void setOwner(long paramLong)
  {
    this.owner = paramLong;
  }

  public void setPath(Path paramPath)
  {
    this.mPath = paramPath;
  }

  public void setPoints(List<Point> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
      return;
    int i = paramList.size();
    this.pts = paramList;
    int j = 0;
    if (j >= i)
    {
      lineToEnd();
      return;
    }
    Point localPoint = (Point)paramList.get(j);
    if (i <= 2)
      if (j == 0)
        moveTo(localPoint.x - 0.5F, localPoint.y - 0.5F);
    while (true)
    {
      j++;
      break;
      this.mPath.lineTo(0.5F + localPoint.x, 0.5F + localPoint.y);
      continue;
      if (j == 0)
      {
        moveTo(localPoint.x, localPoint.y);
        continue;
      }
      quadTo(localPoint.x, localPoint.y);
    }
  }

  public String toString()
  {
    return "AnnoFreepen [id=" + this.id + ", filehandle=" + this.filehandle + ", blockhandle=" + this.blockhandle + ", owner=" + this.owner + ", color=" + this.color + ", linesize=" + this.linesize + ", mPaint=" + this.mPaint + ", mPath=" + this.mPath + "," + super.toString() + "]";
  }

  public static class Point
  {
    public int x;
    public int y;

    public Point()
    {
    }

    public Point(float paramFloat1, float paramFloat2)
    {
      this.x = (int)paramFloat1;
      this.y = (int)paramFloat2;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AnnoFreepen
 * JD-Core Version:    0.6.0
 */