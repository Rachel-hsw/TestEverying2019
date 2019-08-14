package com.gensee.swf;

import android.graphics.RectF;
import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import com.gensee.pdu.IGSDocZoom;
import com.gensee.utils.GenseeLog;
import java.io.File;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLSwfRender
  implements GLSurfaceView.Renderer, IGSDocZoom
{
  private static final String TAG = "GLViewRender";
  private int aniStep;
  private int fileID;
  private SwfPlayer swfPlayer;
  private String szSwfUrl;
  private String szXmlUrl;

  public GLSwfRender(ISwfCallback paramISwfCallback)
  {
    init(paramISwfCallback);
  }

  private void init(ISwfCallback paramISwfCallback)
  {
    this.swfPlayer = new SwfPlayer();
    if (this.swfPlayer.createSwfPlayer(paramISwfCallback) != 0)
    {
      Log.i("GLViewRender", "createSwfPlayer failure");
      return;
    }
    this.swfPlayer.initRender();
    this.swfPlayer.enableBitmapFont(true);
  }

  private boolean openFile()
  {
    boolean bool;
    if ((this.szSwfUrl == null) || ("".equals(this.szSwfUrl)))
      bool = false;
    do
    {
      return bool;
      bool = this.swfPlayer.openFile(this.szSwfUrl, this.szXmlUrl, this.fileID);
    }
    while (bool);
    Log.i("GLViewRender", "openFile failure");
    return bool;
  }

  public void callOnTimer()
  {
    this.swfPlayer.callOnTimer();
  }

  public void closeFile()
  {
    GenseeLog.d("GLViewRender", "closeFile 0");
    if (this.swfPlayer.isFileLoad())
    {
      GenseeLog.d("GLViewRender", "closeFile 1");
      this.swfPlayer.closeFile();
    }
  }

  public void destroy()
  {
    this.swfPlayer.destorySwfPlayer();
  }

  public void doDrawFrame()
  {
    GenseeLog.d("GLViewRender", "doDrawFrame");
    this.swfPlayer.draw();
  }

  public void goToAnimation(int paramInt, boolean paramBoolean)
  {
    this.aniStep = paramInt;
    GenseeLog.d("GLViewRender", "goToAnimation aniStep = " + this.aniStep + "  bAnimation = " + paramBoolean);
    this.swfPlayer.gotoAnimation(paramInt, paramBoolean);
  }

  public void onDocBound(RectF paramRectF, int paramInt1, int paramInt2)
  {
    this.swfPlayer.setViewPort(paramRectF.left, paramInt2 - paramRectF.top - paramRectF.height(), paramRectF.width(), paramRectF.height());
  }

  public void onDrawFrame(GL10 paramGL10)
  {
    doDrawFrame();
  }

  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    GenseeLog.d("GLViewRender", "onSurfaceChanged w = " + paramInt1 + " h = " + paramInt2);
  }

  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    GenseeLog.d("GLViewRender", "onSurfaceCreated ");
    reOpenFile();
  }

  public boolean reOpenFile()
  {
    if (this.swfPlayer.isFileLoad())
      this.swfPlayer.closeFile();
    boolean bool = openFile();
    if ((bool) && (this.aniStep >= 0))
      goToAnimation(this.aniStep, true);
    return bool;
  }

  public void setBackgroundColor(int paramInt)
  {
    this.swfPlayer.setBkColor((0xFF0000 & paramInt) >> 16, (0xFF00 & paramInt) >> 8, paramInt & 0xFF);
  }

  public void setDocPage(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    File localFile = new File(paramString2);
    this.szSwfUrl = paramString1;
    if (localFile.exists());
    while (true)
    {
      this.szXmlUrl = paramString2;
      this.aniStep = paramInt1;
      this.fileID = paramInt2;
      reOpenFile();
      return;
      paramString2 = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.swf.GLSwfRender
 * JD-Core Version:    0.6.0
 */