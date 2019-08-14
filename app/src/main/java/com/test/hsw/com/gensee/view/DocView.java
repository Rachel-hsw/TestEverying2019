package com.gensee.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.gensee.common.GenseeConfig;
import com.gensee.utils.GenseeLog;
import com.gensee.vodpdu.AbsAnno;
import com.gensee.vodpdu.AnnoCleaner;
import com.gensee.vodpdu.AnnoFreepen;
import com.gensee.vodpdu.AnnoPointerEx;
import com.gensee.vodpdu.PduPage;
import java.util.ArrayList;
import java.util.List;

public class DocView extends View
  implements IDocHolder
{
  static final int DRAG = 1;
  private static final int DRAG_END_LEFT = 1;
  private static final int DRAG_END_RIGHT = 2;
  static final int NONE = 0;
  public static final int SHOW_ADAPT = 2;
  public static final int SHOW_NONE = 0;
  public static final int SHOW_SOURCE = 1;
  private static final String TAG = "DocView";
  private static final float TOUCH_TOLERANCE = 4.0F;
  static final int ZOOM = 2;
  private int bgColor = -16777216;
  private GestureDetector detector;
  private PduPage docPage;
  float downX = 0.0F;
  float downY = 0.0F;
  private DrawMode drawMode = DrawMode.PEN;
  private List<Integer> events = new ArrayList();
  int h;
  private AnnoAction mAnnoAction;
  private Bitmap mBitmap;
  private MaskFilter mBlur;
  private Canvas mCanvas = new Canvas();
  private MaskFilter mEmboss;
  private AnnoFreepen mFreepen;
  private OnDocClickListener mOnClickListener;
  private Paint mPaint = new Paint();
  private Path mPath;
  private IScrawlListener mScrawlListener;
  private float mX;
  private float mY;
  PointF mid = new PointF();
  int mode = 0;
  float oldDist = 1.0F;
  private CtrlMode option = CtrlMode.SCALL;
  private int paintColor = -65536;
  RectF rectF = new RectF();
  int showMode = 0;
  PointF start = new PointF();
  boolean tagStart = false;
  float[] values = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  int w;

  public DocView(Context paramContext)
  {
    this(paramContext, null);
  }

  public DocView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DocView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setColor(-65536);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    this.mPaint.setStrokeWidth(8.0F);
    this.mEmboss = new EmbossMaskFilter(new float[] { 1.0F, 1.0F, 1.0F }, 0.4F, 6.0F, 3.5F);
    this.mBlur = new BlurMaskFilter(8.0F, BlurMaskFilter.Blur.NORMAL);
    this.detector = new GestureDetector(paramContext, new DocView.1(this));
  }

  private void adaptScall(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    this.showMode = 2;
    Matrix localMatrix = paramPduPage.getMatrix();
    int i = paramPduPage.getBitmapW();
    int j = paramPduPage.getBitmapH();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    if (f1 < f2);
    while (true)
    {
      localMatrix.reset();
      localMatrix.postScale(f1, f1);
      localMatrix.getValues(this.values);
      caculatBound(false, i, j);
      paramPduPage.drawBitmap(this.mCanvas);
      paramPduPage.drawAnno(this.mCanvas);
      this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
      return;
      f1 = f2;
    }
  }

  private int caculatBound(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = 2;
    boolean bool = true;
    if (this.values[0] * paramInt1 > this.w)
      if (this.values[i] > 0.0F)
      {
        this.values[i] = 0.0F;
        i = bool;
        paramBoolean = bool;
      }
    while (true)
    {
      if (this.values[4] * paramInt2 > this.h)
        if (this.values[5] > 0.0F)
          this.values[5] = 0.0F;
      while (true)
      {
        if (bool)
          this.docPage.getMatrix().setValues(this.values);
        return i;
        if (this.values[i] >= this.w - this.values[0] * paramInt1)
          break label277;
        this.values[i] = (this.w - this.values[0] * paramInt1);
        paramBoolean = bool;
        break;
        this.values[i] = ((this.w - this.values[0] * paramInt1) / 2.0F);
        paramBoolean = bool;
        i = 0;
        break;
        if (this.values[5] < this.h - this.values[4] * paramInt2)
        {
          this.values[5] = (this.h - this.values[4] * paramInt2);
          continue;
          this.values[5] = ((this.h - this.values[4] * paramInt2) / 2.0F);
          continue;
        }
        bool = paramBoolean;
      }
      label277: i = 0;
    }
  }

  private void doDocTip(long paramLong1, long paramLong2)
  {
    if (this.mAnnoAction != null)
    {
      AnnoPointerEx localAnnoPointerEx = new AnnoPointerEx();
      localAnnoPointerEx.setPointerType(1);
      localAnnoPointerEx.setBitmapDrawable(GenseeConfig.getArrowDrawable());
      localAnnoPointerEx.setX(paramLong1);
      localAnnoPointerEx.setY(paramLong2);
      localAnnoPointerEx.setBlockhandle(this.docPage.getPageId());
      localAnnoPointerEx.setFilehandle(this.docPage.getDocId());
      this.docPage.changePoint(localAnnoPointerEx);
      this.mAnnoAction.sendAnno(localAnnoPointerEx);
      this.docPage.drawBitmap(this.mCanvas);
      this.docPage.drawAnno(this.mCanvas);
    }
  }

  private void dragDown(float paramFloat1, float paramFloat2)
  {
    this.start.set(paramFloat1, paramFloat2);
    this.downX = paramFloat1;
    this.downY = paramFloat2;
    this.mode = 1;
  }

  private void initFirstFram(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    paramPduPage.initBitmap(paramInt1, paramInt2);
    if (this.showMode == 0)
      this.showMode = 2;
    if (this.showMode == 2)
    {
      adaptScall(paramPduPage, paramInt1, paramInt2);
      return;
    }
    sourceScall(paramPduPage, paramInt1, paramInt2);
  }

  private void onSingleClick()
  {
    GenseeLog.d("DocView", "click onSingleClick");
    if (this.mScrawlListener != null)
      this.mScrawlListener.onSingleClick(this);
    if (this.mOnClickListener != null)
      this.mOnClickListener.onSingleClicked(this);
  }

  private boolean scale(MotionEvent paramMotionEvent)
  {
    if (this.detector.onTouchEvent(paramMotionEvent))
      return true;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 3:
    case 4:
    case 5:
    default:
    case 0:
    case 1:
    case 6:
    case 2:
    }
    int i;
    int j;
    float f3;
    do
    {
      do
        while (true)
        {
          invalidate();
          return true;
          if (this.docPage != null)
            this.docPage.getMatrix().getValues(this.values);
          dragDown((f1 - this.values[2]) / this.values[0], (f2 - this.values[5]) / this.values[4]);
          Log.w("FLAG", "ACTION_DOWN");
          continue;
          if ((paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= 200L) && (Math.abs((f1 - this.values[2]) / this.values[0] - this.downX) < 1.0F) && (Math.abs((f2 - this.values[5]) / this.values[4] - this.downY) < 1.0F))
          {
            this.events.add(Integer.valueOf(1));
            postDelayed(new DocView.2(this), 200L);
            continue;
          }
          Log.w("FLAG", "ACTION_UP");
          Log.w("FLAG", "ACTION_POINTER_UP");
          this.mode = 0;
          continue;
          if (this.docPage == null)
            continue;
          Log.w("FLAG", "ACTION_MOVE");
          i = this.docPage.getBitmapW();
          j = this.docPage.getBitmapH();
          if (this.mode != 1)
            break;
          this.docPage.getMatrix().postTranslate((f1 - this.values[2]) / this.values[0] - this.start.x, (f2 - this.values[5]) / this.values[4] - this.start.y);
          this.docPage.getMatrix().getValues(this.values);
          caculatBound(false, i, j);
          this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
          this.docPage.drawBitmap(this.mCanvas);
          this.docPage.drawAnno(this.mCanvas);
        }
      while (this.mode != 2);
      f3 = spacing(paramMotionEvent);
    }
    while (f3 <= 10.0F);
    float f4 = f3 / this.oldDist;
    this.docPage.getMatrix().postScale(f4, f4, this.mid.x, this.mid.y);
    this.docPage.getMatrix().getValues(this.values);
    boolean bool;
    if ((this.values[0] < 0.5F) || (this.values[4] < 0.5F))
    {
      this.values[0] = 0.5F;
      this.values[4] = 0.5F;
      bool = true;
    }
    while (true)
    {
      caculatBound(bool, i, j);
      this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
      this.docPage.drawBitmap(this.mCanvas);
      this.docPage.drawAnno(this.mCanvas);
      break;
      if ((this.values[0] > 4.0F) || (this.values[4] > 4.0F))
      {
        this.values[0] = 4.0F;
        this.values[4] = 4.0F;
        bool = true;
        continue;
      }
      bool = false;
    }
  }

  private void sourceScall(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    this.showMode = 1;
    int i = paramPduPage.getBitmapW();
    int j = paramPduPage.getBitmapH();
    Matrix localMatrix = paramPduPage.getMatrix();
    localMatrix.reset();
    localMatrix.getValues(this.values);
    if ((this.values[0] == 1.0F) && (this.values[2] == 0.0F) && (this.values[4] == 1.0F) && (this.values[5] == 0.0F))
      caculatBound(false, i, j);
    paramPduPage.drawBitmap(this.mCanvas);
    paramPduPage.drawAnno(this.mCanvas);
    this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
  }

  private float spacing(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
  }

  private void switchShowMode()
  {
    if (this.docPage == null);
    do
    {
      return;
      if (this.showMode != 1)
        continue;
      adaptScall(this.docPage, this.w, this.h);
      return;
    }
    while (this.showMode != 2);
    sourceScall(this.docPage, this.w, this.h);
  }

  private void touch_move(float paramFloat1, float paramFloat2)
  {
    if (this.drawMode == DrawMode.ERASE);
    do
      return;
    while (DrawMode.ERASE_ALL == this.drawMode);
    if (DrawMode.DOC_TIP == this.drawMode)
    {
      this.mX = paramFloat1;
      this.mY = paramFloat2;
      doDocTip(()this.mX, ()this.mY);
      return;
    }
    float f1 = Math.abs(paramFloat1 - this.mX);
    float f2 = Math.abs(paramFloat2 - this.mY);
    if ((f1 >= 4.0F) || (f2 >= 4.0F))
    {
      this.mPath.quadTo(this.mX, this.mY, (paramFloat1 + this.mX) / 2.0F, (paramFloat2 + this.mY) / 2.0F);
      this.mX = paramFloat1;
      this.mY = paramFloat2;
    }
    this.mFreepen.addPoint(paramFloat1, paramFloat2);
  }

  private void touch_start(float paramFloat1, float paramFloat2)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
    if (DrawMode.ERASE == this.drawMode);
    do
      return;
    while ((DrawMode.ERASE_ALL == this.drawMode) || (DrawMode.DOC_TIP == this.drawMode));
    this.mFreepen = new AnnoFreepen();
    this.mFreepen.addPoint(paramFloat1, paramFloat2);
    this.mFreepen.setColor(this.mPaint.getColor());
    this.mFreepen.setLinesize((short)(int)this.mPaint.getStrokeWidth());
    this.mPath = new Path();
    this.mPath.reset();
    this.mPath.moveTo(paramFloat1, paramFloat2);
    this.downX = paramFloat1;
    this.downY = paramFloat2;
  }

  private void touch_up()
  {
    if (this.drawMode == DrawMode.ERASE)
      if (this.mAnnoAction != null)
      {
        AbsAnno localAbsAnno = this.docPage.cleanAnno(this.mX, this.mY);
        if (localAbsAnno != null)
        {
          AnnoCleaner localAnnoCleaner2 = new AnnoCleaner();
          localAnnoCleaner2.setRemovedId(localAbsAnno.getId());
          localAnnoCleaner2.setBlockhandle(localAbsAnno.getBlockhandle());
          localAnnoCleaner2.setFilehandle(localAbsAnno.getFilehandle());
          this.mAnnoAction.sendAnno(localAnnoCleaner2);
          this.docPage.drawBitmap(this.mCanvas);
          this.docPage.drawAnno(this.mCanvas);
        }
      }
    while (true)
    {
      return;
      if (DrawMode.ERASE_ALL != this.drawMode)
        break;
      if (this.mAnnoAction == null)
        continue;
      this.docPage.cleanAllAnno();
      AnnoCleaner localAnnoCleaner1 = new AnnoCleaner();
      localAnnoCleaner1.setRemovedId(0L);
      localAnnoCleaner1.setBlockhandle(this.docPage.getPageId());
      localAnnoCleaner1.setFilehandle(this.docPage.getDocId());
      this.mAnnoAction.sendAnno(localAnnoCleaner1);
      this.docPage.drawBitmap(this.mCanvas);
      return;
    }
    if (DrawMode.DOC_TIP == this.drawMode)
    {
      doDocTip(()this.mX, ()this.mY);
      return;
    }
    this.mPath.lineTo(this.mX, this.mY);
    Path localPath = new Path(this.mPath);
    localPath.transform(this.docPage.getMatrix());
    this.mCanvas.drawPath(localPath, this.mPaint);
    if (this.mAnnoAction != null)
    {
      if (this.docPage != null)
      {
        this.mFreepen.setPath(this.mPath);
        this.mFreepen.setBlockhandle(this.docPage.getBlockHandle());
        this.docPage.addAnno(this.mFreepen);
      }
      this.mAnnoAction.sendAnno(this.mFreepen);
    }
    this.mPath = null;
  }

  public void clear()
  {
    if (this.mBitmap != null)
    {
      this.mBitmap.recycle();
      this.mBitmap = null;
    }
    if (this.docPage != null)
      this.docPage.clear();
  }

  public void colorChanged(int paramInt)
  {
    this.paintColor = paramInt;
    this.mPaint.setColor(paramInt);
  }

  public boolean isShowPage(PduPage paramPduPage)
  {
    return (paramPduPage != null) && (paramPduPage.equals(this.docPage));
  }

  public void onAnnoAdd(AbsAnno paramAbsAnno)
  {
    if ((paramAbsAnno != null) && (this.docPage != null))
    {
      paramAbsAnno.draw(this.mCanvas, this.docPage.getMatrix());
      postInvalidate();
    }
  }

  public void onAnnoDel(AbsAnno paramAbsAnno)
  {
    onUpdate(true);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(this.bgColor);
    if (this.docPage != null)
    {
      paramCanvas.clipRect(this.rectF);
      this.docPage.drawBitmap(paramCanvas);
      paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, new Paint(4));
      if ((this.option != CtrlMode.SCALL) && (DrawMode.PEN == this.drawMode) && (this.mPath != null))
      {
        Path localPath = new Path(this.mPath);
        localPath.transform(this.docPage.getMatrix());
        paramCanvas.drawPath(localPath, this.mPaint);
      }
    }
  }

  public void onPage(PduPage paramPduPage)
  {
    setDocPage(paramPduPage);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      GenseeLog.e("DocView", "onSizeChanged w = " + paramInt1 + " h = " + paramInt2);
      return;
    }
    this.w = paramInt1;
    this.h = paramInt2;
    if (this.docPage != null)
      initFirstFram(this.docPage, paramInt1, paramInt2);
    this.mBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    this.mCanvas = new Canvas(this.mBitmap);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.option == CtrlMode.SCALL)
      return scale(paramMotionEvent);
    if (this.docPage == null)
    {
      GenseeLog.e("onTouchEvent", "docPage is null! ");
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      return true;
      this.docPage.getMatrix().getValues(this.values);
      this.rectF.set(this.values[2], this.values[5], this.docPage.getBitmapW() * this.values[0] + this.values[2], this.docPage.getBitmapH() * this.values[4] + this.values[5]);
      touch_start((f1 - this.values[2]) / this.values[0], (f2 - this.values[5]) / this.values[4]);
      invalidate();
      continue;
      touch_move((f1 - this.values[2]) / this.values[0], (f2 - this.values[5]) / this.values[4]);
      invalidate();
      continue;
      if ((paramMotionEvent.getEventTime() - paramMotionEvent.getDownTime() <= 200L) && (Math.abs(this.mX - this.downX) < 1.0F) && (Math.abs(this.mY - this.downY) < 1.0F))
      {
        onSingleClick();
        continue;
      }
      touch_up();
      invalidate();
    }
  }

  public void onUpdate(boolean paramBoolean)
  {
    if (this.docPage != null)
    {
      this.docPage.drawBitmap(this.mCanvas);
      this.docPage.drawAnno(this.mCanvas);
      this.mPath = null;
      if (paramBoolean)
        postInvalidate();
    }
  }

  public void reset()
  {
    if (this.docPage != null)
    {
      this.docPage.recycle();
      this.docPage = null;
    }
    postInvalidate();
  }

  public void setAnnoAction(AnnoAction paramAnnoAction)
  {
    this.mAnnoAction = paramAnnoAction;
  }

  public void setBackgroundColor(int paramInt)
  {
    this.bgColor = paramInt;
    super.setBackgroundColor(paramInt);
  }

  public void setBlurMaskFilter()
  {
    if (this.mPaint.getMaskFilter() != this.mBlur)
    {
      this.mPaint.setMaskFilter(this.mBlur);
      return;
    }
    this.mPaint.setMaskFilter(null);
  }

  public void setColor(int paramInt)
  {
    this.paintColor = paramInt;
    if ((this.option == CtrlMode.SIGN) && (this.drawMode == DrawMode.PEN))
      this.mPaint.setColor(paramInt);
  }

  public void setDocClickListener(OnDocClickListener paramOnDocClickListener)
  {
    this.mOnClickListener = paramOnDocClickListener;
  }

  public void setDocPage(PduPage paramPduPage)
  {
    if ((this.docPage != null) && (this.docPage.equals(paramPduPage)));
    PduPage localPduPage;
    do
    {
      return;
      localPduPage = this.docPage;
      this.docPage = paramPduPage;
      if (paramPduPage != null)
        initFirstFram(paramPduPage, this.w, this.h);
      postInvalidate();
    }
    while (localPduPage == null);
    localPduPage.recycle();
  }

  public void setDocTip()
  {
    this.option = CtrlMode.SIGN;
    this.drawMode = DrawMode.DOC_TIP;
  }

  public void setEmbossmMaskFilter()
  {
    if (this.mPaint.getMaskFilter() != this.mEmboss)
    {
      this.mPaint.setMaskFilter(this.mEmboss);
      return;
    }
    this.mPaint.setMaskFilter(null);
  }

  public void setErase()
  {
    this.option = CtrlMode.SIGN;
    this.drawMode = DrawMode.ERASE;
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }

  public void setEraseAll()
  {
    this.option = CtrlMode.SIGN;
    this.drawMode = DrawMode.ERASE_ALL;
  }

  public void setHLType(int paramInt)
  {
    this.option = CtrlMode.SIGN;
    this.drawMode = DrawMode.PEN;
    this.mPaint.setXfermode(null);
    if (paramInt == 0);
    for (int i = -1342177536; ; i = this.paintColor)
    {
      this.mPaint.setColor(i);
      return;
    }
  }

  public void setModeSign(int paramInt)
  {
    this.option = CtrlMode.SCALL;
  }

  public void setScrawlListener(IScrawlListener paramIScrawlListener)
  {
    this.mScrawlListener = paramIScrawlListener;
  }

  public void setStrokeWidth(int paramInt)
  {
    this.option = CtrlMode.SIGN;
    this.drawMode = DrawMode.PEN;
    this.mPaint.setXfermode(null);
    this.mPaint.setStrokeWidth(paramInt);
  }

  public boolean showFullDoc(boolean paramBoolean)
  {
    if (this.docPage == null)
      return false;
    if (paramBoolean)
      adaptScall(this.docPage, this.w, this.h);
    while (true)
    {
      postInvalidate();
      return true;
      sourceScall(this.docPage, this.w, this.h);
    }
  }

  private static enum CtrlMode
  {
    static
    {
      SCALL = new CtrlMode("SCALL", 1);
      CtrlMode[] arrayOfCtrlMode = new CtrlMode[2];
      arrayOfCtrlMode[0] = SIGN;
      arrayOfCtrlMode[1] = SCALL;
      ENUM$VALUES = arrayOfCtrlMode;
    }
  }

  public static enum DrawMode
  {
    static
    {
      ERASE = new DrawMode("ERASE", 1, 1);
      ERASE_ALL = new DrawMode("ERASE_ALL", 2, 2);
      DOC_TIP = new DrawMode("DOC_TIP", 3, 3);
      DrawMode[] arrayOfDrawMode = new DrawMode[4];
      arrayOfDrawMode[0] = PEN;
      arrayOfDrawMode[1] = ERASE;
      arrayOfDrawMode[2] = ERASE_ALL;
      arrayOfDrawMode[3] = DOC_TIP;
      ENUM$VALUES = arrayOfDrawMode;
    }

    private DrawMode(int arg3)
    {
    }
  }

  public static abstract interface OnDocClickListener
  {
    public abstract void onDoubleClicked(DocView paramDocView);

    public abstract void onSingleClicked(DocView paramDocView);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.view.DocView
 * JD-Core Version:    0.6.0
 */