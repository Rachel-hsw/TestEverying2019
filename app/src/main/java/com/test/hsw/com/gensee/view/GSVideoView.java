package com.gensee.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.gensee.utils.GenseeLog;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

public class GSVideoView extends SurfaceView
  implements SurfaceHolder.Callback, IVideoIndication
{
  private static final Object LOCK = new Object();
  private static final String TAG = "GSVideoView";
  private byte[] data = null;
  private SoftReference<Bitmap> defBitmapRef = null;
  private int defColor = -16777216;
  private BitmapDrawable drawable;
  private SurfaceHolder holder;
  private boolean isDestroyed;
  private boolean isFillXY = false;
  private Matrix m;
  private int mH264Height;
  private int mH264Width;
  private int mHeight;
  private int mWidth;
  private RenderMode renderMode = RenderMode.RM_ADPT_XY;
  private SoftReference<Bitmap> videoBit;

  public GSVideoView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GSVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GSVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    SurfaceHolder localSurfaceHolder = getHolder();
    localSurfaceHolder.addCallback(this);
    localSurfaceHolder.setFormat(4);
  }

  private void renderDrawble(SurfaceHolder paramSurfaceHolder, Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (this.isFillXY)
    {
      (this.mWidth / f1);
      (this.mHeight / f2);
    }
    while (true)
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(getResources(), paramBitmap);
      localBitmapDrawable.setBounds(0, 0, localBitmapDrawable.getIntrinsicWidth(), localBitmapDrawable.getIntrinsicHeight());
      drawFram(paramSurfaceHolder, localMatrix, localBitmapDrawable, false);
      return;
      if ((f1 > this.mWidth) || (f2 > this.mHeight))
      {
        float f3 = this.mWidth / f1;
        float f4 = this.mHeight / f2;
        if (f3 > f4)
        {
          localMatrix.postScale(f4, f4);
          localMatrix.postTranslate(0.0F, (this.mWidth - f1 * f4) / 2.0F);
          continue;
        }
        localMatrix.postTranslate((this.mHeight - f2 * f3) / 2.0F, 0.0F);
        localMatrix.postScale(f3, f3);
        continue;
      }
      localMatrix.postTranslate((this.mWidth - f1) / 2.0F, (this.mHeight - f2) / 2.0F);
    }
  }

  private void updateVideoMatrix()
  {
    if (this.m == null)
      this.m = new Matrix();
    this.m.reset();
    float f1 = 1.0F * this.mWidth / this.mH264Width;
    float f2 = 1.0F * this.mHeight / this.mH264Height;
    float[] arrayOfFloat;
    switch ($SWITCH_TABLE$com$gensee$view$GSVideoView$RenderMode()[this.renderMode.ordinal()])
    {
    case 2:
    default:
      arrayOfFloat = new float[9];
      if (f1 >= f2)
        break;
      this.m.postScale(f1, f1);
      this.m.getValues(arrayOfFloat);
      arrayOfFloat[5] = ((this.mHeight - f1 * this.mH264Height) / 2.0F);
    case 1:
    case 3:
    }
    while (true)
    {
      this.m.setValues(arrayOfFloat);
      return;
      this.m.postScale(f1, f2);
      return;
      if ((f1 <= 0.0F) || (f2 <= 0.0F))
        break;
      this.m.postTranslate((this.mWidth - this.mH264Width) / 2.0F, (this.mHeight - this.mH264Height) / 2.0F);
      return;
      this.m.postScale(f2, f2);
      this.m.getValues(arrayOfFloat);
      arrayOfFloat[2] = ((this.mWidth - f2 * this.mH264Width) / 2.0F);
    }
  }

  protected void drawFram(SurfaceHolder paramSurfaceHolder, Matrix paramMatrix, Drawable paramDrawable, boolean paramBoolean)
  {
    if (paramSurfaceHolder == null);
    label105: 
    while (true)
    {
      return;
      if (!this.isDestroyed);
      for (Canvas localCanvas = paramSurfaceHolder.lockCanvas(); ; localCanvas = null)
        while (true)
        {
          if (localCanvas == null)
            break label105;
          localCanvas.save();
          localCanvas.drawColor(this.defColor);
          if ((!paramBoolean) && (paramDrawable != null) && (this.videoBit != null));
          try
          {
            localCanvas.concat(paramMatrix);
            paramDrawable.draw(localCanvas);
            localCanvas.restore();
            if (this.isDestroyed)
              break;
            paramSurfaceHolder.unlockCanvasAndPost(localCanvas);
            return;
          }
          catch (Exception localException)
          {
            while (true)
              GenseeLog.e("GSVideoView", localException);
          }
        }
    }
  }

  public byte[] getData()
  {
    return this.data;
  }

  public RenderMode getRenderMode()
  {
    return this.renderMode;
  }

  public int getVideoHeight()
  {
    return this.mH264Height;
  }

  public int getVideoWidth()
  {
    return this.mH264Width;
  }

  protected void onReceiveData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
    {
      GenseeLog.w("GSVideoView -> onReceiveData h264Width = " + paramInt1 + " h264Height = " + paramInt2);
      return;
    }
    Bitmap localBitmap;
    synchronized (LOCK)
    {
      if (this.holder == null)
        break label273;
      if ((this.mH264Width == paramInt1) && (this.mH264Height == paramInt2) && (this.videoBit != null))
        break label239;
      SoftReference localSoftReference = this.videoBit;
      localBitmap = null;
      if (localSoftReference != null)
        localBitmap = (Bitmap)this.videoBit.get();
      this.videoBit = null;
    }
    try
    {
      this.videoBit = new SoftReference(Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.RGB_565));
      if (localBitmap != null)
        localBitmap.recycle();
      if (this.videoBit == null)
      {
        System.gc();
        monitorexit;
        return;
        localObject2 = finally;
        monitorexit;
        throw localObject2;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
        GenseeLog.w("OutOfMemoryError video err!");
      this.mH264Width = paramInt1;
      this.mH264Height = paramInt2;
      this.drawable = new BitmapDrawable(getResources(), (Bitmap)this.videoBit.get());
      this.drawable.setBounds(0, 0, this.drawable.getIntrinsicWidth(), this.drawable.getIntrinsicHeight());
      updateVideoMatrix();
    }
    try
    {
      label239: ((Bitmap)this.videoBit.get()).copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
      drawFram(this.holder, this.m, this.drawable, false);
      label273: monitorexit;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      GenseeLog.e("GSVideoView", localRuntimeException);
      monitorexit;
      return;
    }
    catch (Exception localException)
    {
      GenseeLog.e("GSVideoView", localException);
      monitorexit;
    }
  }

  public void onReceiveFrame(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    onReceiveData(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void renderDefault()
  {
    if (this.data != null)
      this.data = null;
    drawFram(this.holder, null, null, true);
  }

  public void renderDrawble(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap == null);
    do
    {
      return;
      this.isFillXY = paramBoolean;
      if (this.defBitmapRef != null)
        this.defBitmapRef.clear();
      this.defBitmapRef = new SoftReference(paramBitmap);
    }
    while (this.holder == null);
    renderDrawble(this.holder, paramBitmap);
  }

  public void setBackgroundColor(int paramInt)
  {
    setDefColor(paramInt);
  }

  public void setDefColor(int paramInt)
  {
    this.defColor = paramInt;
  }

  public void setRenderMode(RenderMode paramRenderMode)
  {
    this.renderMode = paramRenderMode;
    if ((this.holder == null) || (this.drawable == null))
      return;
    synchronized (LOCK)
    {
      updateVideoMatrix();
      drawFram(this.holder, this.m, this.drawable, false);
      return;
    }
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    GenseeLog.d("GSVideoView", "surfaceChanged");
    this.mWidth = paramInt2;
    this.mHeight = paramInt3;
    this.holder = paramSurfaceHolder;
    if (this.data != null);
    Bitmap localBitmap;
    do
    {
      synchronized (LOCK)
      {
        updateVideoMatrix();
        onReceiveData(this.data, this.mH264Width, this.mH264Height);
        return;
      }
      SoftReference localSoftReference = this.defBitmapRef;
      localBitmap = null;
      if (localSoftReference == null)
        continue;
      localBitmap = (Bitmap)this.defBitmapRef.get();
    }
    while (localBitmap == null);
    renderDrawble(paramSurfaceHolder, localBitmap);
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.isDestroyed = false;
    GenseeLog.d("GSVideoView", "surfaceCreated holder = " + paramSurfaceHolder.hashCode());
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.isDestroyed = true;
    this.holder = null;
    if (this.videoBit != null)
    {
      Bitmap localBitmap = (Bitmap)this.videoBit.get();
      if (localBitmap != null)
        localBitmap.recycle();
      this.videoBit.clear();
      this.videoBit = null;
    }
    GenseeLog.d("GSVideoView", "surfaceDestroyed holder = " + paramSurfaceHolder.hashCode());
  }

  public static enum RenderMode
  {
    static
    {
      RM_ADPT_XY = new RenderMode("RM_ADPT_XY", 1);
      RM_CENTER = new RenderMode("RM_CENTER", 2);
      RenderMode[] arrayOfRenderMode = new RenderMode[3];
      arrayOfRenderMode[0] = RM_FILL_XY;
      arrayOfRenderMode[1] = RM_ADPT_XY;
      arrayOfRenderMode[2] = RM_CENTER;
      ENUM$VALUES = arrayOfRenderMode;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.GSVideoView
 * JD-Core Version:    0.6.0
 */