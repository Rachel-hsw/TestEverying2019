package com.gensee.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.gensee.pdu.GSDocView;
import com.gensee.pdu.IGSDocZoom;
import com.gensee.pdu.PduPage;

public class GSPduView extends GSDocView
  implements GSDocViewEx.IDocExInterface
{
  private IGSDocZoom mZoomer;

  public GSPduView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GSPduView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GSPduView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    setBackgroundColor(0);
  }

  protected void drawDocPage(PduPage paramPduPage, Canvas paramCanvas, int paramInt)
  {
    if (paramPduPage != null)
    {
      String str = paramPduPage.getPath();
      if ((str != null) && ((str.endsWith("png")) || (str.endsWith("png.1"))))
      {
        super.drawDocPage(paramPduPage, paramCanvas, paramInt);
        return;
      }
      paramCanvas.drawColor(paramInt, PorterDuff.Mode.CLEAR);
      return;
    }
    paramCanvas.drawColor(paramInt, PorterDuff.Mode.CLEAR);
  }

  protected void initBitmap(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
  }

  protected boolean isDrawAnnos()
  {
    return (this.docPage != null) && (this.docPage.isRefreshAnnos());
  }

  protected void onDocBound(RectF paramRectF, int paramInt1, int paramInt2)
  {
    this.mZoomer.onDocBound(paramRectF, paramInt1, paramInt2);
  }

  public void onDocOpenComplete()
  {
    postInvalidate();
  }

  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(0);
  }

  public void setDocZoomer(IGSDocZoom paramIGSDocZoom)
  {
    this.mZoomer = paramIGSDocZoom;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSPduView
 * JD-Core Version:    0.6.0
 */