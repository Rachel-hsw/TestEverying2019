package com.gensee.pdu;

import android.content.Context;
import android.content.res.Resources;
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
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.gensee.utils.GenseeLog;

public class GSDocView extends View
{
  static final int DRAG = 1;
  public static final int DRAG_END_LEFT = 1;
  public static final int DRAG_END_RIGHT = 2;
  static final int NONE = 0;
  public static final int SHOW_ADPT_HEIGHT = 4;
  public static final int SHOW_ADPT_VIEW = 0;
  public static final int SHOW_ADPT_WIDTH = 3;
  public static final int SHOW_FILL_VIEW = 1;
  public static final int SHOW_SOURCE = 2;
  private static final String TAG = "GSDocView";
  private static final float TOUCH_TOLERANCE = 4.0F;
  static final int ZOOM = 2;
  private int bgColor = -1;
  int clickCount = 0;
  private Bitmap defBitmap;
  private GestureDetector detector;
  protected PduPage docPage;
  private int docShowMode = 0;
  float downX = 0.0F;
  float downY = 0.0F;
  float dragPreX;
  float dragPreY;
  private DrawMode drawMode = DrawMode.PEN;
  long firstTime = 0L;
  private int h;
  private Handler handler = new GSDocView.1(this);
  private boolean isDefImageFillView;
  private boolean isGestureforbidden;
  private boolean isHighLight = false;
  private boolean isTouchforbidden = false;
  private AnnoAction mAnnoAction;
  private Bitmap mBitmap;
  private MaskFilter mBlur;
  private Canvas mCanvas = new Canvas();
  private MaskFilter mEmboss;
  private AnnoFreepenEx mFreepen;
  private AnnoLine mLine;
  private OnDocViewEventListener mOnDocViewClickedListener;
  private Paint mPaint = new Paint();
  private Path mPath;
  private AnnoRect mRect;
  private float mX;
  private float mY;
  private PointF mid = new PointF();
  int mode = 0;
  private float oldDist = 1.0F;
  private CtrlMode option = CtrlMode.SIGHT;
  private int paintColor = -16777216;
  private RectF rectF = new RectF();
  private PointF start = new PointF();
  boolean tagStart = false;
  private float[] values = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  private int w;

  public GSDocView(Context paramContext)
  {
    this(paramContext, null);
  }

  public GSDocView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public GSDocView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setDither(true);
    this.mPaint.setColor(-16777216);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeJoin(Paint.Join.ROUND);
    this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    this.mPaint.setStrokeWidth(8.0F);
    this.mEmboss = new EmbossMaskFilter(new float[] { 1.0F, 1.0F, 1.0F }, 0.4F, 6.0F, 3.5F);
    this.mBlur = new BlurMaskFilter(8.0F, BlurMaskFilter.Blur.NORMAL);
    this.detector = new GestureDetector(paramContext, new GSDocView.2(this));
  }

  private void adaptScall(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    this.docShowMode = 0;
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
      drawDocPage(paramPduPage, this.mCanvas, this.bgColor);
      paramPduPage.drawAnno(this.mCanvas);
      this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
      onDocBound(this.rectF, paramInt1, paramInt2);
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

  private void cleanDefImg()
  {
    Bitmap localBitmap = this.defBitmap;
    this.defBitmap = null;
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
      localBitmap.recycle();
  }

  private Bitmap createBitmap(int paramInt1, int paramInt2)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      GenseeLog.w("GSDocView->" + localOutOfMemoryError);
    }
    return null;
  }

  private void deleteAnno(AbsAnno paramAbsAnno)
  {
    if (this.mAnnoAction == null)
      GenseeLog.e("GSDocView", "IAnnoAction is not set,so delete Anno failed!");
    do
      return;
    while (paramAbsAnno == null);
    this.mAnnoAction.deleteAnno(paramAbsAnno, false);
    drawDocPage(this.docPage, this.mCanvas, this.bgColor);
    this.docPage.drawAnno(this.mCanvas);
  }

  private void doDocTip(long paramLong1, long paramLong2)
  {
    if (this.mAnnoAction != null)
    {
      AnnoPointerEx localAnnoPointerEx = new AnnoPointerEx();
      localAnnoPointerEx.setPointerType(0);
      localAnnoPointerEx.setX(paramLong1);
      localAnnoPointerEx.setY(paramLong2);
      localAnnoPointerEx.setPageId(this.docPage.getPageId());
      localAnnoPointerEx.setDocId(this.docPage.getDocId());
      this.docPage.changePoint(localAnnoPointerEx);
      this.mAnnoAction.sendAnno(localAnnoPointerEx);
      drawDocPage(this.docPage, this.mCanvas, this.bgColor);
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

  private int dragUpBound(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this.values[0] * paramInt1 > this.w)
      if (this.values[2] > 0.0F)
      {
        this.values[2] = 0.0F;
        bool3 = bool1;
        paramBoolean = bool1;
        if (this.values[4] * paramInt2 <= this.h)
          break label289;
        if (this.values[5] <= 0.0F)
          break label240;
        this.values[5] = 0.0F;
      }
    while (true)
    {
      if (bool1)
        this.docPage.getMatrix().setValues(this.values);
      return bool3;
      boolean bool4 = this.values[2] < this.w - this.values[0] * paramInt1;
      bool3 = false;
      if (!bool4)
        break;
      this.values[2] = (this.w - this.values[0] * paramInt1);
      int i = 2;
      paramBoolean = bool1;
      break;
      float f = (this.w - this.values[0] * paramInt1) / 2.0F;
      if (this.values[2] > f)
        i = bool1;
      while (true)
      {
        this.values[2] = f;
        paramBoolean = bool1;
        break;
        boolean bool2 = this.values[2] < f;
        i = 0;
        if (!bool2)
          continue;
        i = 2;
      }
      label240: if (this.values[5] < this.h - this.values[4] * paramInt2)
      {
        this.values[5] = (this.h - this.values[4] * paramInt2);
        continue;
        this.values[5] = ((this.h - this.values[4] * paramInt2) / 2.0F);
        continue;
      }
      label289: bool1 = paramBoolean;
    }
  }

  private void drawDefBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    float f1 = 0.0F;
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      return;
    int i = getResources().getDisplayMetrics().densityDpi;
    int j = paramBitmap.getScaledWidth(i);
    int k = paramBitmap.getScaledHeight(i);
    Matrix localMatrix = new Matrix();
    float f2 = this.w / j;
    float f3 = this.h / k;
    float f5;
    if (!paramBoolean)
      if (f2 < f3)
      {
        f5 = 0.5F + 0.5F * (this.h - f2 * k);
        f3 = f2;
      }
    while (true)
    {
      localMatrix.postScale(f3, f2);
      localMatrix.postTranslate(f1, f5);
      this.mCanvas.save();
      this.mCanvas.concat(localMatrix);
      this.mCanvas.drawBitmap(paramBitmap, null, new Rect(0, 0, j, k), new Paint());
      this.mCanvas.restore();
      return;
      float f6 = 0.5F + 0.5F * (this.w - f3 * j);
      f2 = f3;
      f1 = f6;
      f5 = 0.0F;
      continue;
      float f4 = f3;
      f3 = f2;
      f2 = f4;
      f5 = 0.0F;
      f1 = 0.0F;
    }
  }

  private float getMinScall(int paramInt1, int paramInt2)
  {
    switch (this.docShowMode)
    {
    default:
      return 0.5F;
    case 3:
      return this.w / paramInt1;
    case 4:
    }
    return this.h / paramInt2;
  }

  private void initFirstFram(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    initBitmap(paramPduPage, paramInt1, paramInt2);
    viewAndDocChange(paramPduPage, paramInt1, paramInt2);
  }

  private boolean isMoveValid(float paramFloat1, float paramFloat2)
  {
    float f1 = Math.abs(paramFloat1 - this.mX);
    float f2 = Math.abs(paramFloat2 - this.mY);
    return (f1 >= 4.0F) || (f2 >= 4.0F);
  }

  private void midPoint(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    float f1 = (paramMotionEvent.getX(0) - this.values[2]) / this.values[0] + (paramMotionEvent.getX(1) - this.values[2]) / this.values[0];
    float f2 = (paramMotionEvent.getY(0) - this.values[5]) / this.values[4] + (paramMotionEvent.getY(1) - this.values[5]) / this.values[4];
    paramPointF.set(f1 / 2.0F, f2 / 2.0F);
  }

  private boolean scale(MotionEvent paramMotionEvent)
  {
    if (this.docPage == null)
      return true;
    if (this.isGestureforbidden)
      return super.onTouchEvent(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 3:
    case 4:
    default:
    case 0:
    case 5:
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
          long l = System.currentTimeMillis();
          float f7 = Math.abs((f1 - this.values[2]) / this.values[0] - this.downX);
          float f8 = Math.abs((f2 - this.values[5]) / this.values[4] - this.downY);
          if ((l - this.firstTime < 300L) && (f7 < 25.0F) && (f8 < 25.0F))
          {
            this.firstTime = 0L;
            if (this.docPage == null)
              continue;
            switchShowMode();
            continue;
          }
          this.firstTime = l;
          this.docPage.getMatrix().getValues(this.values);
          dragDown((f1 - this.values[2]) / this.values[0], (f2 - this.values[5]) / this.values[4]);
          continue;
          this.oldDist = spacing(paramMotionEvent);
          if (this.oldDist > 10.0F)
          {
            midPoint(this.mid, paramMotionEvent);
            this.mode = 2;
          }
          this.downX = paramMotionEvent.getX();
          this.downY = paramMotionEvent.getY();
          continue;
          if (this.mode == 1)
          {
            int k = this.docPage.getBitmapW();
            int m = this.docPage.getBitmapH();
            int n = dragUpBound(false, k, m);
            this.rectF.set(this.values[2], this.values[5], k * this.values[0] + this.values[2], m * this.values[4] + this.values[5]);
            drawDocPage(this.docPage, this.mCanvas, this.bgColor);
            onDocBound(this.rectF, this.w, this.h);
            this.docPage.drawAnno(this.mCanvas);
            if ((n != 0) && (this.mOnDocViewClickedListener != null) && (Math.abs((f1 - this.values[2]) / this.values[0] - this.start.x) > 2.0F * Math.abs((f2 - this.values[5]) / this.values[4] - this.start.y)))
              this.mOnDocViewClickedListener.onEndHDirection(this, n);
          }
          Log.w("FLAG", "ACTION_UP");
          this.mode = 0;
          continue;
          Log.w("FLAG", "ACTION_MOVE x = " + f1 + " y = " + f2);
          i = this.docPage.getBitmapW();
          j = this.docPage.getBitmapH();
          if (this.mode != 1)
            break;
          this.docPage.getMatrix().postTranslate((f1 - this.values[2]) / this.values[0] - this.start.x, (f2 - this.values[5]) / this.values[4] - this.start.y);
          this.docPage.getMatrix().getValues(this.values);
          this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
          drawDocPage(this.docPage, this.mCanvas, this.bgColor);
          onDocBound(this.rectF, this.w, this.h);
          this.docPage.drawAnno(this.mCanvas);
        }
      while (this.mode != 2);
      f3 = spacing(paramMotionEvent);
    }
    while (f3 <= 10.0F);
    float f4 = f3 / this.oldDist;
    this.oldDist = f3;
    this.docPage.getMatrix().postScale(f4, f4, this.mid.x, this.mid.y);
    this.docPage.getMatrix().getValues(this.values);
    float f5 = getMinScall(i, j);
    float f6 = 4.0F + f5;
    boolean bool1;
    if ((this.values[0] < f5) || (this.values[4] < f5))
    {
      this.values[0] = f5;
      this.values[4] = f5;
      bool1 = true;
    }
    while (true)
    {
      caculatBound(bool1, i, j);
      this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
      drawDocPage(this.docPage, this.mCanvas, this.bgColor);
      this.docPage.drawAnno(this.mCanvas);
      onDocBound(this.rectF, this.w, this.h);
      break;
      if (this.values[0] <= f6)
      {
        boolean bool2 = this.values[4] < f6;
        bool1 = false;
        if (!bool2)
          continue;
      }
      this.values[0] = f6;
      this.values[4] = f6;
      bool1 = true;
    }
  }

  private void sendAnno(AbsAnno paramAbsAnno)
  {
    if (this.mAnnoAction != null)
      this.mAnnoAction.sendAnno(paramAbsAnno);
  }

  private AnnoFreepenEx sendFreepenEx(float paramFloat1, float paramFloat2, int paramInt)
  {
    AnnoFreepenEx localAnnoFreepenEx = new AnnoFreepenEx();
    localAnnoFreepenEx.setPageId(this.docPage.getPageId());
    localAnnoFreepenEx.addPoint(paramFloat1, paramFloat2);
    localAnnoFreepenEx.setArgbColor(this.mPaint.getColor());
    localAnnoFreepenEx.setHighLight(this.isHighLight);
    localAnnoFreepenEx.setLinesize((byte)(int)this.mPaint.getStrokeWidth());
    localAnnoFreepenEx.setStepType(paramInt);
    sendAnno(localAnnoFreepenEx);
    return localAnnoFreepenEx;
  }

  private void showAdaptWidthOrHeight(PduPage paramPduPage)
  {
    Matrix localMatrix = paramPduPage.getMatrix();
    localMatrix.reset();
    int i = paramPduPage.getBitmapW();
    int j = paramPduPage.getBitmapH();
    float f = getMinScall(i, j);
    localMatrix.postScale(f, f);
    localMatrix.postTranslate((this.w - f * i) / 2.0F, (this.h - f * j) / 2.0F);
    drawDocPage(paramPduPage, this.mCanvas, this.bgColor);
    paramPduPage.drawAnno(this.mCanvas);
    localMatrix.getValues(this.values);
    this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
    onDocBound(this.rectF, this.w, this.h);
  }

  private void showFillScall(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    this.docShowMode = 1;
    Matrix localMatrix = paramPduPage.getMatrix();
    int i = paramPduPage.getBitmapW();
    int j = paramPduPage.getBitmapH();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    localMatrix.reset();
    localMatrix.postScale(f1, f2);
    localMatrix.getValues(this.values);
    caculatBound(false, i, j);
    drawDocPage(paramPduPage, this.mCanvas, this.bgColor);
    paramPduPage.drawAnno(this.mCanvas);
    this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
    onDocBound(this.rectF, paramInt1, paramInt2);
  }

  private void sourceScall(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    this.docShowMode = 0;
    int i = paramPduPage.getBitmapW();
    int j = paramPduPage.getBitmapH();
    Matrix localMatrix = paramPduPage.getMatrix();
    localMatrix.reset();
    localMatrix.getValues(this.values);
    if ((this.values[0] == 1.0F) && (this.values[2] == 0.0F) && (this.values[4] == 1.0F) && (this.values[5] == 0.0F))
      caculatBound(false, i, j);
    drawDocPage(paramPduPage, this.mCanvas, this.bgColor);
    paramPduPage.drawAnno(this.mCanvas);
    this.rectF.set(this.values[2], this.values[5], i * this.values[0] + this.values[2], j * this.values[4] + this.values[5]);
    onDocBound(this.rectF, paramInt1, paramInt2);
  }

  private float spacing(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
    float f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
    return FloatMath.sqrt(f1 * f1 + f2 * f2);
  }

  private void switchShowMode()
  {
    if (this.docPage != null)
    {
      if (this.docShowMode == 1)
        adaptScall(this.docPage, this.w, this.h);
    }
    else
      return;
    if (this.docShowMode == 2)
    {
      sourceScall(this.docPage, this.w, this.h);
      return;
    }
    showFillScall(this.docPage, this.w, this.h);
  }

  private void touch_move(float paramFloat1, float paramFloat2)
  {
    switch ($SWITCH_TABLE$com$gensee$pdu$GSDocView$DrawMode()[this.drawMode.ordinal()])
    {
    case 2:
    case 3:
    default:
    case 4:
    case 1:
    case 6:
    case 5:
    }
    do
    {
      do
      {
        return;
        this.mX = paramFloat1;
        this.mY = paramFloat2;
        doDocTip(()this.mX, ()this.mY);
        return;
        GenseeLog.d("GSDocView", " touch_move x = " + paramFloat1 + " y = " + paramFloat2);
        if ((isMoveValid(paramFloat1, paramFloat2)) && (this.mPath != null))
        {
          this.mPath.quadTo(this.mX, this.mY, (paramFloat1 + this.mX) / 2.0F, (paramFloat2 + this.mY) / 2.0F);
          this.mX = paramFloat1;
          this.mY = paramFloat2;
        }
        sendFreepenEx(paramFloat1, paramFloat2, 2);
        this.mFreepen.addPoint(paramFloat1, paramFloat2);
        return;
      }
      while ((!isMoveValid(paramFloat1, paramFloat2)) || (this.mPath == null));
      this.mX = paramFloat1;
      this.mY = paramFloat2;
      this.mPath.reset();
      this.mPath.moveTo(this.downX, this.downY);
      this.mPath.lineTo(paramFloat1, paramFloat2);
      return;
    }
    while ((!isMoveValid(paramFloat1, paramFloat2)) || (this.mPath == null));
    this.mPath.reset();
    this.mPath.moveTo(this.downX, this.downY);
    this.mPath.lineTo(paramFloat1, this.downY);
    this.mPath.lineTo(paramFloat1, paramFloat2);
    this.mPath.lineTo(this.downX, paramFloat2);
    this.mPath.lineTo(this.downX, this.downY);
    this.mX = paramFloat1;
    this.mY = paramFloat2;
  }

  private void touch_start(float paramFloat1, float paramFloat2)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
    this.downX = paramFloat1;
    this.downY = paramFloat2;
    switch ($SWITCH_TABLE$com$gensee$pdu$GSDocView$DrawMode()[this.drawMode.ordinal()])
    {
    case 2:
    case 3:
    case 4:
    default:
      return;
    case 1:
      this.mFreepen = sendFreepenEx(paramFloat1, paramFloat2, 1);
      this.mPath = new Path();
      this.mPath.reset();
      this.mPath.moveTo(paramFloat1, paramFloat2);
      return;
    case 6:
      this.mLine = new AnnoLine();
      this.mLine.setLeft((int)paramFloat1);
      this.mLine.setTop((int)paramFloat2);
      this.mPath = new Path();
      this.mPath.reset();
      this.mPath.moveTo(paramFloat1, paramFloat2);
      return;
    case 5:
    }
    this.mPath = new Path();
    this.mPath.reset();
    this.mPath.moveTo(paramFloat1, paramFloat2);
    this.mRect = new AnnoRect();
    this.mRect.setLeft((int)paramFloat1);
    this.mRect.setTop((int)paramFloat2);
  }

  private void touch_up()
  {
    switch ($SWITCH_TABLE$com$gensee$pdu$GSDocView$DrawMode()[this.drawMode.ordinal()])
    {
    case 3:
    default:
      return;
    case 2:
      deleteAnno(this.docPage.cleanAnno(this.mX, this.mY));
      return;
    case 4:
      doDocTip(()this.mX, ()this.mY);
      return;
    case 1:
      if (this.mFreepen.getPointCount() == 1)
      {
        this.mX = (float)(0.5D + this.mX);
        this.mY = (float)(0.5D + this.mY);
      }
      if (this.mPath != null)
      {
        this.mPath.lineTo(this.mX, this.mY);
        Path localPath = new Path(this.mPath);
        localPath.transform(this.docPage.getMatrix());
        this.mCanvas.drawPath(localPath, this.mPaint);
        if (this.docPage != null)
        {
          this.mFreepen.setPath(this.mPath);
          this.mFreepen.setPageId(this.docPage.getPageId());
          this.mFreepen.setStepType(3);
          this.docPage.addAnno(this.mFreepen, true);
        }
        sendFreepenEx(this.mX, this.mY, 3);
      }
      this.mPath = null;
      return;
    case 6:
      if (this.mX == this.downX)
        this.mX = (float)(0.5D + this.mX);
      if (this.mY == this.downY)
        this.mY = (float)(0.5D + this.mY);
      this.mLine.setRight((int)this.mX);
      this.mLine.setBottom((int)this.mY);
      this.mLine.setArgbColor(this.mPaint.getColor());
      this.mLine.setLinesize((byte)(int)this.mPaint.getStrokeWidth());
      this.mLine.setPath(this.mPath);
      this.mLine.setPageId(this.docPage.getPageId());
      if (this.docPage != null)
        this.docPage.addAnno(this.mLine, true);
      sendAnno(this.mLine);
      transAnnoToCache();
      this.mPath = null;
      return;
    case 5:
    }
    if (this.mX == this.downX)
      this.mX = (float)(0.5D + this.mX);
    if (this.mY == this.downY)
      this.mY = (float)(0.5D + this.mY);
    this.mRect.setRight((int)this.mX);
    this.mRect.setBottom((int)this.mY);
    this.mRect.setArgbColor(this.mPaint.getColor());
    this.mRect.setLinesize((byte)(int)this.mPaint.getStrokeWidth());
    this.mRect.setPath(this.mPath);
    this.mRect.setPageId(this.docPage.getPageId());
    if (this.docPage != null)
      this.docPage.addAnno(this.mRect, true);
    sendAnno(this.mRect);
    transAnnoToCache();
    this.mPath = null;
  }

  private void transAnnoToCache()
  {
    Path localPath = new Path(this.mPath);
    localPath.transform(this.docPage.getMatrix());
    this.mCanvas.drawPath(localPath, this.mPaint);
  }

  private void viewAndDocChange(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    switch (this.docShowMode)
    {
    default:
      return;
    case 0:
      adaptScall(paramPduPage, paramInt1, paramInt2);
      return;
    case 1:
      showFillScall(paramPduPage, paramInt1, paramInt2);
      return;
    case 2:
      sourceScall(paramPduPage, paramInt1, paramInt2);
      return;
    case 3:
      showAdaptWidthOrHeight(paramPduPage);
      return;
    case 4:
    }
    showAdaptWidthOrHeight(paramPduPage);
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

  protected void drawDocPage(PduPage paramPduPage, Canvas paramCanvas, int paramInt)
  {
    paramPduPage.drawBitmap(paramCanvas, getContext(), paramInt);
  }

  public void eraseAll()
  {
    if (this.mAnnoAction == null)
      GenseeLog.e("GSDocView", "IAnnoAction is not set,so delete Annos failed!");
    do
      return;
    while (this.docPage == null);
    this.docPage.cleanAllAnno();
    AnnoCleaner localAnnoCleaner = new AnnoCleaner();
    localAnnoCleaner.setRemovedId(0L);
    localAnnoCleaner.setPageId(this.docPage.getPageId());
    localAnnoCleaner.setDocId(this.docPage.getDocId());
    this.mAnnoAction.deleteAnno(localAnnoCleaner, true);
    drawDocPage(this.docPage, this.mCanvas, this.bgColor);
    postInvalidate();
  }

  public void forbidZoomGestrue(boolean paramBoolean)
  {
    this.isGestureforbidden = paramBoolean;
  }

  public PduPage getDocPage()
  {
    return this.docPage;
  }

  public Handler getHandler()
  {
    return this.handler;
  }

  public int getShowMode()
  {
    return this.docShowMode;
  }

  protected void initBitmap(PduPage paramPduPage, int paramInt1, int paramInt2)
  {
    paramPduPage.initBitmap(paramInt1, paramInt2);
  }

  protected boolean isDrawAnnos()
  {
    return true;
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
    onUpdate();
  }

  protected void onDocBound(RectF paramRectF, int paramInt1, int paramInt2)
  {
  }

  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.drawColor(this.bgColor);
    if (this.docPage != null)
      if (isDrawAnnos());
    do
    {
      do
      {
        return;
        drawDocPage(this.docPage, paramCanvas, this.bgColor);
        if (this.mBitmap == null)
          continue;
        paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, new Paint(4));
      }
      while ((this.option != CtrlMode.EDIT) || ((DrawMode.PEN != this.drawMode) && (DrawMode.LINE != this.drawMode) && (DrawMode.RECT != this.drawMode)) || (this.mPath == null));
      Path localPath = new Path(this.mPath);
      localPath.transform(this.docPage.getMatrix());
      paramCanvas.drawPath(localPath, this.mPaint);
      return;
    }
    while ((this.defBitmap == null) || (this.mBitmap == null));
    paramCanvas.drawBitmap(this.mBitmap, 0.0F, 0.0F, new Paint(4));
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mCanvas == null)
      this.mCanvas = new Canvas();
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      this.w = paramInt1;
      this.h = paramInt2;
      Bitmap localBitmap = this.mBitmap;
      this.mBitmap = createBitmap(paramInt1, paramInt2);
      if (localBitmap != null)
        localBitmap.recycle();
      if (this.mBitmap == null)
        this.mBitmap = createBitmap(paramInt1, paramInt2);
      if (this.mBitmap != null)
        this.mCanvas.setBitmap(this.mBitmap);
    }
    if (this.docPage != null)
    {
      viewAndDocChange(this.docPage, paramInt1, paramInt2);
      return;
    }
    drawDefBitmap(this.defBitmap, this.isDefImageFillView);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.option == CtrlMode.SIGHT)
    {
      if (this.isTouchforbidden)
        bool = super.onTouchEvent(paramMotionEvent);
      do
        return bool;
      while (this.detector.onTouchEvent(paramMotionEvent));
      return scale(paramMotionEvent);
    }
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
      return bool;
    case 0:
      this.docPage.getMatrix().getValues(this.values);
      this.rectF.set(this.values[2], this.values[5], this.docPage.getBitmapW() * this.values[0] + this.values[2], this.docPage.getBitmapH() * this.values[4] + this.values[5]);
      touch_start((f1 - this.values[2]) / this.values[0], (f2 - this.values[5]) / this.values[4]);
      invalidate();
      return bool;
    case 2:
      touch_move((f1 - this.values[2]) / this.values[0], (f2 - this.values[5]) / this.values[4]);
      invalidate();
      return bool;
    case 1:
    }
    touch_up();
    invalidate();
    return bool;
  }

  public void onUpdate()
  {
    if (this.docPage != null)
    {
      drawDocPage(this.docPage, this.mCanvas, this.bgColor);
      this.docPage.drawAnno(this.mCanvas);
      this.mPath = null;
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

  public void setAnnoMakeType(DrawMode paramDrawMode)
  {
    this.isHighLight = false;
    switch ($SWITCH_TABLE$com$gensee$pdu$GSDocView$DrawMode()[paramDrawMode.ordinal()])
    {
    default:
      return;
    case 1:
      setHLType(0);
      return;
    case 7:
      this.isHighLight = true;
      setHLType(1);
      return;
    case 5:
      this.option = CtrlMode.EDIT;
      this.drawMode = paramDrawMode;
      this.mPaint.setXfermode(null);
      this.mPaint.setColor(this.paintColor);
      return;
    case 6:
      this.option = CtrlMode.EDIT;
      this.drawMode = paramDrawMode;
      this.mPaint.setXfermode(null);
      this.mPaint.setColor(this.paintColor);
      return;
    case 4:
      setIndicate();
      return;
    case 2:
      setErase();
      return;
    case 3:
    }
    eraseAll();
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

  public void setCtrlMode(CtrlMode paramCtrlMode)
  {
    this.option = paramCtrlMode;
  }

  public void setDefImg(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.docPage == null)
    {
      this.isDefImageFillView = paramBoolean;
      cleanDefImg();
      this.defBitmap = paramBitmap;
      drawDefBitmap(paramBitmap, paramBoolean);
      invalidate();
    }
  }

  public void setDocPage(PduPage paramPduPage)
  {
    if ((this.docPage != null) && (this.docPage.equals(paramPduPage)));
    PduPage localPduPage;
    do
    {
      return;
      cleanDefImg();
      localPduPage = this.docPage;
      this.docPage = paramPduPage;
      if (paramPduPage != null)
        initFirstFram(paramPduPage, this.w, this.h);
      postInvalidate();
    }
    while (localPduPage == null);
    localPduPage.recycle();
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
    this.option = CtrlMode.EDIT;
    this.drawMode = DrawMode.ERASE;
    this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }

  public void setHLType(int paramInt)
  {
    this.option = CtrlMode.EDIT;
    this.drawMode = DrawMode.PEN;
    this.mPaint.setXfermode(null);
    int i;
    if (paramInt == 1)
    {
      i = 0xAFFFFFFF & this.paintColor;
      this.isHighLight = true;
    }
    while (true)
    {
      this.mPaint.setColor(i);
      return;
      this.isHighLight = false;
      i = this.paintColor;
    }
  }

  public void setIndicate()
  {
    this.option = CtrlMode.EDIT;
    this.drawMode = DrawMode.DOC_TIP;
  }

  public void setOnDocViewClickedListener(OnDocViewEventListener paramOnDocViewEventListener)
  {
    this.mOnDocViewClickedListener = paramOnDocViewEventListener;
  }

  public void setPaintColor(int paramInt)
  {
    this.paintColor = paramInt;
    if (this.option == CtrlMode.EDIT)
    {
      if (this.isHighLight)
        paramInt &= -1342177281;
      this.mPaint.setColor(paramInt);
    }
  }

  public void setStrokeWidth(LINE_SIZE paramLINE_SIZE)
  {
    this.option = CtrlMode.EDIT;
    this.mPaint.setXfermode(null);
    this.mPaint.setStrokeWidth(paramLINE_SIZE.getValue());
  }

  public void setTouchforbidden(boolean paramBoolean)
  {
    this.isTouchforbidden = paramBoolean;
  }

  public void showAdaptView()
  {
    this.docShowMode = 0;
    if (this.docPage != null)
    {
      adaptScall(this.docPage, this.w, this.h);
      postInvalidate();
    }
  }

  public void showAdaptViewHeight()
  {
    this.docShowMode = 4;
    if (this.docPage != null)
    {
      showAdaptWidthOrHeight(this.docPage);
      postInvalidate();
    }
  }

  public void showAdaptViewWidth()
  {
    this.docShowMode = 3;
    if (this.docPage != null)
    {
      showAdaptWidthOrHeight(this.docPage);
      postInvalidate();
    }
  }

  public void showFillView()
  {
    this.docShowMode = 1;
    if (this.docPage != null)
    {
      showFillScall(this.docPage, this.w, this.h);
      postInvalidate();
    }
  }

  public void showSourceScall()
  {
    this.docShowMode = 2;
    if (this.docPage != null)
    {
      sourceScall(this.docPage, this.w, this.h);
      postInvalidate();
    }
  }

  public void undo(long paramLong)
  {
    if (this.docPage != null)
      deleteAnno(this.docPage.cleanLastOwnAnno(paramLong));
  }

  private static enum CtrlMode
  {
    static
    {
      CtrlMode[] arrayOfCtrlMode = new CtrlMode[2];
      arrayOfCtrlMode[0] = EDIT;
      arrayOfCtrlMode[1] = SIGHT;
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
      RECT = new DrawMode("RECT", 4, 4);
      LINE = new DrawMode("LINE", 5, 5);
      HLIGHT = new DrawMode("HLIGHT", 6, 6);
      DrawMode[] arrayOfDrawMode = new DrawMode[7];
      arrayOfDrawMode[0] = PEN;
      arrayOfDrawMode[1] = ERASE;
      arrayOfDrawMode[2] = ERASE_ALL;
      arrayOfDrawMode[3] = DOC_TIP;
      arrayOfDrawMode[4] = RECT;
      arrayOfDrawMode[5] = LINE;
      arrayOfDrawMode[6] = HLIGHT;
      ENUM$VALUES = arrayOfDrawMode;
    }

    private DrawMode(int arg3)
    {
    }
  }

  public static enum LINE_SIZE
  {
    private int v;

    static
    {
      H = new LINE_SIZE("H", 2, 6);
      LINE_SIZE[] arrayOfLINE_SIZE = new LINE_SIZE[3];
      arrayOfLINE_SIZE[0] = L;
      arrayOfLINE_SIZE[1] = M;
      arrayOfLINE_SIZE[2] = H;
      ENUM$VALUES = arrayOfLINE_SIZE;
    }

    private LINE_SIZE(int arg3)
    {
      int j;
      this.v = j;
    }

    public int getValue()
    {
      return this.v;
    }
  }

  public static abstract interface OnDocViewEventListener
  {
    public abstract boolean onDoubleClicked(GSDocView paramGSDocView);

    public abstract boolean onEndHDirection(GSDocView paramGSDocView, int paramInt);

    public abstract boolean onSingleClicked(GSDocView paramGSDocView);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.pdu.GSDocView
 * JD-Core Version:    0.6.0
 */