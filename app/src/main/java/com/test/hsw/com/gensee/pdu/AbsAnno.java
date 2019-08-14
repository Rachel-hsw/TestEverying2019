package com.gensee.pdu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;

public abstract class AbsAnno extends PduBase
{
  protected int argbColor = -1;
  protected int docId;
  protected long id;
  protected long owner;
  protected int pageId;
  private long timestamp;

  protected int agbrToArgb(int paramInt)
  {
    int i = -16777216;
    int j = paramInt & 0xFF;
    int k = 0xFF00 & paramInt;
    int m = 0xFF0000 & paramInt;
    (paramInt & i);
    if (isHighLight())
      i = -1358954496;
    return k | (i | j << 16) | m >> 16;
  }

  public void clean()
  {
  }

  public abstract boolean contain(float paramFloat1, float paramFloat2);

  public abstract void draw(Canvas paramCanvas, Matrix paramMatrix);

  public int getDocId()
  {
    return this.docId;
  }

  public long getId()
  {
    return this.id;
  }

  public long getOwner()
  {
    return this.owner;
  }

  public int getPageId()
  {
    return this.pageId;
  }

  public long getTimestamp()
  {
    return this.timestamp;
  }

  protected boolean isHighLight()
  {
    return false;
  }

  public void resetAnno(AbsAnno paramAbsAnno)
  {
  }

  public int setArgbColor(int paramInt)
  {
    int i = Color.red(paramInt);
    int j = Color.green(paramInt);
    return i | (0x0 | Color.blue(paramInt) << 16 | j << 8);
  }

  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable)
  {
  }

  public void setDocId(int paramInt)
  {
    this.docId = paramInt;
  }

  public void setId(long paramLong)
  {
    this.id = paramLong;
  }

  public void setOwner(long paramLong)
  {
    this.owner = paramLong;
  }

  public void setPageId(int paramInt)
  {
    this.pageId = paramInt;
  }

  public void setPath(Path paramPath)
  {
  }

  public void setTimestamp(long paramLong)
  {
    this.timestamp = paramLong;
  }

  public String toString()
  {
    return "AbsAnno [id=" + this.id + ", docId=" + this.docId + ", pageId=" + this.pageId + ", owner=" + this.owner + ",timestamp=" + this.timestamp + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AbsAnno
 * JD-Core Version:    0.6.0
 */