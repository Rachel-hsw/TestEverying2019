package com.gensee.vodpdu;

import android.graphics.Canvas;
import android.graphics.Matrix;

public class AnnoCleaner extends AbsAnno
{
  private long blockhandle;
  private long filehandle;
  private long id;
  private long removedId;

  public AnnoCleaner()
  {
    setType(2049);
  }

  public boolean contain(float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public void draw(Canvas paramCanvas, Matrix paramMatrix)
  {
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    AnnoCleaner localAnnoCleaner;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localAnnoCleaner = (AnnoCleaner)paramObject;
    }
    while (this.id == localAnnoCleaner.id);
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

  public long getRemovedId()
  {
    return this.removedId;
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

  public void setRemovedId(long paramLong)
  {
    this.removedId = paramLong;
  }

  public String toString()
  {
    return "AnnoCleaner [id=" + this.id + ", removedId=" + this.removedId + ", filehandle=" + this.filehandle + ", blockhandle=" + this.blockhandle + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.vodpdu.AnnoCleaner
 * JD-Core Version:    0.6.0
 */