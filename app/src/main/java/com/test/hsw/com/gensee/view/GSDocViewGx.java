package com.gensee.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.gensee.pdu.GSDocView.OnDocViewEventListener;

public class GSDocViewGx extends FrameLayout
{
  private Handler docViewHandler;
  private GSDocViewEx glDocView;
  private Handler glDocViewHandler;
  private Handler handler = new GSDocViewGx.1(this);
  private GSPduView pduView;

  public GSDocViewGx(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }

  public GSDocViewGx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }

  public GSDocViewGx(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }

  private void init(Context paramContext)
  {
    removeAllViews();
    this.glDocView = new GSDocViewEx(paramContext);
    addView(this.glDocView, new FrameLayout.LayoutParams(-1, -1));
    this.glDocViewHandler = this.glDocView.getHandler();
    this.pduView = new GSPduView(paramContext);
    this.pduView.setDocZoomer(this.glDocView);
    addView(this.pduView, new FrameLayout.LayoutParams(-1, -1));
    this.docViewHandler = this.pduView.getHandler();
    this.glDocView.setDocExInterface(this.pduView);
  }

  public void closeDoc()
  {
    this.glDocView.closeDoc();
    this.pduView.reset();
  }

  public void destroy()
  {
    this.glDocView.destroy();
  }

  public void forbidZoomGestrue(boolean paramBoolean)
  {
    this.pduView.forbidZoomGestrue(paramBoolean);
  }

  public Handler getHandler()
  {
    return this.handler;
  }

  public void onPause()
  {
    this.glDocView.onPause();
  }

  public void onResume()
  {
    this.glDocView.onResume();
  }

  public void onUpdate()
  {
    this.pduView.onUpdate();
  }

  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    this.glDocView.setBackgroundColor(paramInt);
  }

  public void setDefImg(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.pduView.setDefImg(paramBitmap, paramBoolean);
  }

  public void setGlVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.glDocView.setVisibility(0);
      return;
    }
    this.glDocView.setVisibility(4);
  }

  public void setOnDocViewClickedListener(GSDocView.OnDocViewEventListener paramOnDocViewEventListener)
  {
    this.pduView.setOnDocViewClickedListener(paramOnDocViewEventListener);
  }

  public void setTouchforbidden(boolean paramBoolean)
  {
    this.pduView.setTouchforbidden(paramBoolean);
  }

  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    this.glDocView.setVisibility(0);
  }

  public void showAdaptView()
  {
    this.pduView.showAdaptView();
  }

  public void showAdaptViewHeight()
  {
    this.pduView.showAdaptViewHeight();
  }

  public void showAdaptViewWidth()
  {
    this.pduView.showAdaptViewWidth();
  }

  public void showFillView()
  {
    this.pduView.showFillView();
  }

  public void showSourceScall()
  {
    this.pduView.showSourceScall();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSDocViewGx
 * JD-Core Version:    0.6.0
 */