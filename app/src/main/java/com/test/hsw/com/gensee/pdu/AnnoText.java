package com.gensee.pdu;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;

public class AnnoText extends AbsAnno
{
  private int bottom;
  private int color;
  private byte fontsize;
  private int left;
  int mFontHeight = 0;
  Paint mPaint;
  private int right;
  private String text;
  String[] texts = null;
  private int top;

  public AnnoText()
  {
    setType(4);
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
    return (paramFloat1 >= i) && (paramFloat1 <= k) && (paramFloat2 >= j) && (paramFloat2 <= m);
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
    if ((this.text == null) || ("".equals(this.text)));
    while (true)
    {
      return;
      if (this.mPaint == null)
      {
        if (this.argbColor == -1)
          this.argbColor = agbrToArgb(this.color);
        this.mPaint = new Paint();
        this.mPaint.setColor(this.argbColor);
        this.mPaint.setTextSize(this.fontsize);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        Paint.FontMetrics localFontMetrics = this.mPaint.getFontMetrics();
        this.mFontHeight = (int)Math.ceil(localFontMetrics.bottom - localFontMetrics.descent - localFontMetrics.ascent);
        this.texts = this.text.split(String.valueOf('\n'));
      }
      if (this.texts == null)
        continue;
      float[] arrayOfFloat = new float[9];
      paramMatrix.getValues(arrayOfFloat);
      long l1 = ()(this.left * arrayOfFloat[0] + arrayOfFloat[2]);
      long l2 = ()(this.top * arrayOfFloat[4] + arrayOfFloat[5]);
      int i = this.texts.length;
      for (int j = 0; j < i; j++)
      {
        String str = this.texts[j];
        if ((str == null) || ("".equals(str)))
          continue;
        if (this.text == null)
          str = "";
        paramCanvas.drawText(str, (float)l1, (float)(l2 + (j + 1) * this.mFontHeight), this.mPaint);
      }
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AnnoText localAnnoText;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAnnoText = (AnnoText)paramObject;
    }
    while (this.id == localAnnoText.id);
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

  public byte getFontsize()
  {
    return this.fontsize;
  }

  public int getLeft()
  {
    return this.left;
  }

  public int getRight()
  {
    return this.right;
  }

  public String getText()
  {
    return this.text;
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

  public void setFontsize(byte paramByte)
  {
    this.fontsize = paramByte;
  }

  public void setLeft(int paramInt)
  {
    this.left = paramInt;
  }

  public void setRight(int paramInt)
  {
    this.right = paramInt;
  }

  public void setText(String paramString)
  {
    this.text = paramString;
  }

  public void setTop(int paramInt)
  {
    this.top = paramInt;
  }

  public String toString()
  {
    return "AnnoText [color=" + this.color + ", fontsize=" + this.fontsize + ", text=" + this.text + ", left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + "," + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoText
 * JD-Core Version:    0.6.0
 */