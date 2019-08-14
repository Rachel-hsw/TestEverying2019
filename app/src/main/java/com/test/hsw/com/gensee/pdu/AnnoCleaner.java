package com.gensee.pdu;

import android.graphics.Canvas;
import android.graphics.Matrix;

public class AnnoCleaner extends AbsAnno
{
  private long removedId;

  public AnnoCleaner()
  {
    setType(3);
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

  public long getRemovedId()
  {
    return this.removedId;
  }

  public int hashCode()
  {
    return 31 + (int)(this.id ^ this.id >>> 32);
  }

  public void setRemovedId(long paramLong)
  {
    this.removedId = paramLong;
  }

  public String toString()
  {
    return "AnnoCleaner [id=" + this.id + ", removedId=" + this.removedId + ", filehandle=" + this.docId + ", blockhandle=" + this.pageId + super.toString() + "]";
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.AnnoCleaner
 * JD-Core Version:    0.6.0
 */