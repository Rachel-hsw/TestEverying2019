package com.gensee.view;

import android.content.Context;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import com.gensee.pdu.IGSDocZoom;
import com.gensee.pdu.PduPage;
import com.gensee.swf.GLSwfRender;
import com.gensee.swf.ISwfCallback;
import com.gensee.utils.GenseeLog;
import java.lang.ref.WeakReference;

public class GSDocViewEx extends GLSurfaceView
  implements IGSDocZoom, ISwfCallback
{
  private static final String TAG = "GSDocViewEx";
  private IDocExInterface docExInterface;
  private PduPage docPage;
  private GLSwfRender glViewRender;
  private DocViewExHanlder handler;

  public GSDocViewEx(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }

  public GSDocViewEx(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }

  private void callOnTimer()
  {
    this.glViewRender.callOnTimer();
  }

  private void docPageAnimation(PduPage paramPduPage)
  {
    if ((paramPduPage == null) || (!paramPduPage.isPrepare()))
      return;
    queueEvent(new GSDocViewEx.1(this, paramPduPage));
  }

  private void init(Context paramContext)
  {
    this.handler = new DocViewExHanlder(this);
    this.glViewRender = new GLSwfRender(this);
    setEGLConfigChooser(8, 8, 8, 8, 8, 8);
    setRenderer(this.glViewRender);
    setRenderMode(0);
  }

  private void setDocPage(PduPage paramPduPage)
  {
    if ((paramPduPage == null) || (!paramPduPage.isPrepare()))
    {
      GenseeLog.w("GSDocViewEx setDocPage page is unPrepared");
      return;
    }
    this.docPage = paramPduPage;
    this.docPage.setRefreshAnnos(false);
    GenseeLog.d("GSDocViewEx", "test fileId setDocPage aniStep = " + this.docPage.getAniStep() + " fileId = " + this.docPage.hashCode());
    queueEvent(new GSDocViewEx.2(this));
  }

  public void closeDoc()
  {
    this.glViewRender.closeFile();
  }

  public void destroy()
  {
    this.glViewRender.destroy();
  }

  public Handler getHandler()
  {
    return this.handler;
  }

  public void onBeginDraw()
  {
  }

  public void onDocBound(RectF paramRectF, int paramInt1, int paramInt2)
  {
    queueEvent(new GSDocViewEx.3(this, paramRectF, paramInt1, paramInt2));
  }

  public void onEndDraw()
  {
  }

  public void onKillTimer()
  {
    this.handler.removeMessages(143);
  }

  public void onNeedDraw()
  {
    requestRender();
  }

  public void onOpenComplete(int paramInt)
  {
    GenseeLog.d("GSDocViewEx", "test fileId onOpenComplete hasCode = " + this.docPage.hashCode() + " fileId = " + paramInt);
    if ((this.docPage != null) && (this.docPage.hashCode() == paramInt))
      this.docPage.setRefreshAnnos(true);
    if (this.docExInterface != null)
      this.docExInterface.onDocOpenComplete();
  }

  public void onResume()
  {
    super.onResume();
  }

  public void onSetTimer()
  {
    this.handler.sendEmptyMessage(143);
  }

  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    this.glViewRender.setBackgroundColor(paramInt);
  }

  public void setDocExInterface(IDocExInterface paramIDocExInterface)
  {
    this.docExInterface = paramIDocExInterface;
  }

  private class DocViewExHanlder extends Handler
  {
    private WeakReference<GSDocViewEx> docViewEx;

    public DocViewExHanlder(GSDocViewEx arg2)
    {
      Object localObject;
      this.docViewEx = new WeakReference(localObject);
    }

    public void handleMessage(Message paramMessage)
    {
      GSDocViewEx localGSDocViewEx = (GSDocViewEx)this.docViewEx.get();
      if (localGSDocViewEx == null)
        return;
      switch (paramMessage.what)
      {
      case 139:
      case 141:
      default:
        return;
      case 138:
      case 140:
        localGSDocViewEx.setDocPage((PduPage)paramMessage.obj);
        return;
      case 142:
        localGSDocViewEx.docPageAnimation((PduPage)paramMessage.obj);
        return;
      case 143:
      }
      localGSDocViewEx.queueEvent(new GSDocViewEx.DocViewExHanlder.1(this, localGSDocViewEx));
    }
  }

  public static abstract interface IDocExInterface
  {
    public abstract void onDocOpenComplete();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSDocViewEx
 * JD-Core Version:    0.6.0
 */