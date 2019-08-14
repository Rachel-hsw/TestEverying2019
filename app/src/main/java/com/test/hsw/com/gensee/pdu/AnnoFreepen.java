package com.gensee.pdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.gensee.utils.GenseeLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AnnoFreepen extends AbsAnno
{
  private static final String TAG = "AnnoFreepen";
  protected int color;
  private boolean isHighLight;
  protected byte linesize;
  private Paint mPaint;
  private Path mPath;
  private float preX;
  private float preY;
  private List<AnnoFPoint> pts;

  public AnnoFreepen()
  {
    setType(2);
    this.pts = new ArrayList(0);
  }

  private void buildPath(int paramInt1, int paramInt2, AnnoFPoint paramAnnoFPoint)
  {
    if (paramInt2 == 0)
    {
      moveTo(paramAnnoFPoint.x, paramAnnoFPoint.y);
      return;
    }
    quadTo(paramAnnoFPoint.x, paramAnnoFPoint.y);
  }

  private void lineToEnd()
  {
    this.mPath.lineTo(this.preX, this.preY);
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
    this.pts.add(new AnnoFPoint(paramFloat1, paramFloat2));
  }

  protected boolean appendPoints(AnnoFPoint[] paramArrayOfAnnoFPoint)
  {
    int i = 0;
    if ((paramArrayOfAnnoFPoint == null) || (paramArrayOfAnnoFPoint.length == 0))
      return false;
    int j = this.pts.size();
    int k = paramArrayOfAnnoFPoint.length;
    int m;
    if (i >= k)
      m = this.pts.size();
    while (true)
    {
      if (j >= m)
      {
        lineToEnd();
        return true;
        AnnoFPoint localAnnoFPoint = paramArrayOfAnnoFPoint[i];
        this.pts.add(localAnnoFPoint);
        i++;
        break;
      }
      buildPath(m, j, (AnnoFPoint)this.pts.get(j));
      j++;
    }
  }

  public void clean()
  {
    if (this.pts != null)
      this.pts.clear();
  }

  protected void clearPoints()
  {
    this.pts.clear();
  }

  public boolean contain(float paramFloat1, float paramFloat2)
  {
    Iterator localIterator = this.pts.iterator();
    AnnoFPoint localAnnoFPoint;
    do
    {
      if (!localIterator.hasNext())
        return false;
      localAnnoFPoint = (AnnoFPoint)localIterator.next();
    }
    while ((localAnnoFPoint == null) || ((float)Math.sqrt((paramFloat1 - localAnnoFPoint.x) * (paramFloat1 - localAnnoFPoint.x) + (paramFloat2 - localAnnoFPoint.y) * (paramFloat2 - localAnnoFPoint.y)) > 32.0F));
    return true;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    if ((paramCanvas != null) && (paramMatrix != null))
    {
      if (this.mPaint == null)
      {
        this.mPaint = new Paint();
        if (this.argbColor == -1)
          this.argbColor = agbrToArgb(this.color);
        this.mPaint.setColor(this.argbColor);
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

  public int getColor()
  {
    return this.color;
  }

  public short getLinesize()
  {
    return this.linesize;
  }

  public int getPointCount()
  {
    return this.pts.size();
  }

  protected AnnoFPoint[] getPoints()
  {
    AnnoFPoint[] arrayOfAnnoFPoint = new AnnoFPoint[this.pts.size()];
    return (AnnoFPoint[])this.pts.toArray(arrayOfAnnoFPoint);
  }

  public int hashCode()
  {
    return 31 + (int)(this.id ^ this.id >>> 32);
  }

  public boolean isHighLight()
  {
    return this.isHighLight;
  }

  protected void moveTo(float paramFloat1, float paramFloat2)
  {
    if (this.mPath == null)
      this.mPath = new Path();
    this.mPath.reset();
    this.mPath.moveTo(paramFloat1, paramFloat2);
    this.preX = paramFloat1;
    this.preY = paramFloat2;
  }

  public int setArgbColor(int paramInt)
  {
    this.argbColor = paramInt;
    int i = super.setArgbColor(paramInt);
    this.color = i;
    return i;
  }

  public void setColor(int paramInt)
  {
    this.color = paramInt;
  }

  public void setHighLight(boolean paramBoolean)
  {
    this.isHighLight = paramBoolean;
  }

  public void setLinesize(byte paramByte)
  {
    this.linesize = paramByte;
  }

  public void setPath(Path paramPath)
  {
    this.mPath = paramPath;
  }

  public void setPoints(List<AnnoFPoint> paramList)
  {
    int i;
    if (paramList != null)
      i = paramList.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        lineToEnd();
        return;
      }
      AnnoFPoint localAnnoFPoint = (AnnoFPoint)paramList.get(j);
      buildPath(i, j, localAnnoFPoint);
      this.pts.add(localAnnoFPoint);
    }
  }

  protected void setPoints(AnnoFPoint[] paramArrayOfAnnoFPoint)
  {
    if ((paramArrayOfAnnoFPoint == null) || (paramArrayOfAnnoFPoint.length == 0))
    {
      GenseeLog.e("AnnoFreepen", "setPoints size = 0");
      return;
    }
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfAnnoFPoint.length)
      {
        lineToEnd();
        return;
      }
      AnnoFPoint localAnnoFPoint = paramArrayOfAnnoFPoint[i];
      buildPath(paramArrayOfAnnoFPoint.length, i, localAnnoFPoint);
      this.pts.add(localAnnoFPoint);
    }
  }

  public String toString()
  {
    return "AnnoFreepen [" + super.toString() + "pts=" + this.pts + ", color=" + this.color + ", linesize=" + this.linesize + ", mPaint=" + this.mPaint + ", mPath=" + this.mPath + ",isHighLight=" + this.isHighLight + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoFreepen
 * JD-Core Version:    0.6.0
 */