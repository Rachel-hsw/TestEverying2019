package com.gensee.vodpdu;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;

public class AnnoLineEx extends AnnoLine
{
  public static final short ANNO_LINE_ARROW = 2;
  public static final short ANNO_LINE_DASH = 1;
  public static final short ANNO_LINE_NORMAL;
  private short lineType;

  public AnnoLineEx()
  {
    setType(2056);
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    switch (this.lineType)
    {
    default:
      return;
    case 0:
      super.draw(paramCanvas, paramMatrix);
      return;
    case 1:
      Paint localPaint = getSourcePaint();
      int i = 5 + getLinesize();
      float[] arrayOfFloat2 = new float[4];
      arrayOfFloat2[0] = i;
      arrayOfFloat2[1] = i;
      arrayOfFloat2[2] = i;
      arrayOfFloat2[3] = i;
      localPaint.setPathEffect(new DashPathEffect(arrayOfFloat2, 1.0F));
      Path localPath = new Path(getSourcePath());
      localPath.transform(paramMatrix);
      paramCanvas.drawPath(localPath, localPaint);
      return;
    case 2:
    }
    float[] arrayOfFloat1 = new float[9];
    paramMatrix.getValues(arrayOfFloat1);
    drawAL(paramCanvas, (int)(getLeft() * arrayOfFloat1[0] + arrayOfFloat1[2]), (int)(getTop() * arrayOfFloat1[4] + arrayOfFloat1[5]), (int)(getRight() * arrayOfFloat1[0] + arrayOfFloat1[2]), (int)(getBottom() * arrayOfFloat1[4] + arrayOfFloat1[5]));
  }

  public void drawAL(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = 6 + getLinesize();
    double d2 = 3.5D + getLinesize();
    double d3 = Math.atan(d2 / d1);
    double d4 = Math.sqrt(d2 * d2 + d1 * d1);
    double[] arrayOfDouble1 = rotateVec(paramInt3 - paramInt1, paramInt4 - paramInt2, d3, true, d4);
    double[] arrayOfDouble2 = rotateVec(paramInt3 - paramInt1, paramInt4 - paramInt2, -d3, true, d4);
    double d5 = paramInt3 - arrayOfDouble1[0];
    double d6 = paramInt4 - arrayOfDouble1[1];
    double d7 = paramInt3 - arrayOfDouble2[0];
    double d8 = paramInt4 - arrayOfDouble2[1];
    int i = Double.valueOf(d5).intValue();
    int j = Double.valueOf(d6).intValue();
    int k = Double.valueOf(d7).intValue();
    int m = Double.valueOf(d8).intValue();
    Paint localPaint = getSourcePaint();
    localPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawLine(paramInt1, paramInt2, paramInt3, paramInt4, localPaint);
    Path localPath = new Path();
    localPath.moveTo(paramInt3, paramInt4);
    localPath.lineTo(i, j);
    localPath.lineTo(k, m);
    localPath.close();
    localPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawPath(localPath, localPaint);
  }

  public short getLineType()
  {
    return this.lineType;
  }

  public double[] rotateVec(int paramInt1, int paramInt2, double paramDouble1, boolean paramBoolean, double paramDouble2)
  {
    double[] arrayOfDouble = new double[2];
    double d1 = paramInt1 * Math.cos(paramDouble1) - paramInt2 * Math.sin(paramDouble1);
    double d2 = paramInt1 * Math.sin(paramDouble1) + paramInt2 * Math.cos(paramDouble1);
    if (paramBoolean)
    {
      double d3 = Math.sqrt(d1 * d1 + d2 * d2);
      double d4 = paramDouble2 * (d1 / d3);
      double d5 = paramDouble2 * (d2 / d3);
      arrayOfDouble[0] = d4;
      arrayOfDouble[1] = d5;
    }
    return arrayOfDouble;
  }

  public void setLineType(byte paramByte)
  {
    this.lineType = paramByte;
  }

  public String toString()
  {
    return "AnnoLineEx [lineType=" + this.lineType + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AnnoLineEx
 * JD-Core Version:    0.6.0
 */