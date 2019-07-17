package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class DrawerLayout extends ViewGroup
  implements DrawerLayoutImpl
{
  private static final boolean ALLOW_EDGE_LOCK = false;
  private static final boolean CAN_HIDE_DESCENDANTS = false;
  private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
  private static final int DEFAULT_SCRIM_COLOR = -1728053248;
  static final DrawerLayoutCompatImpl IMPL;
  private static final int[] LAYOUT_ATTRS;
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNLOCKED = 0;
  private static final int MIN_DRAWER_MARGIN = 64;
  private static final int MIN_FLING_VELOCITY = 400;
  private static final int PEEK_DELAY = 160;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String TAG = "DrawerLayout";
  private static final float TOUCH_SLOP_SENSITIVITY = 1.0F;
  private final ChildAccessibilityDelegate mChildAccessibilityDelegate = new ChildAccessibilityDelegate();
  private boolean mChildrenCanceledTouch;
  private boolean mDisallowInterceptRequested;
  private boolean mDrawStatusBarBackground;
  private int mDrawerState;
  private boolean mFirstLayout = true;
  private boolean mInLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private Object mLastInsets;
  private final ViewDragCallback mLeftCallback;
  private final ViewDragHelper mLeftDragger;
  private DrawerListener mListener;
  private int mLockModeLeft;
  private int mLockModeRight;
  private int mMinDrawerMargin;
  private final ViewDragCallback mRightCallback;
  private final ViewDragHelper mRightDragger;
  private int mScrimColor = -1728053248;
  private float mScrimOpacity;
  private Paint mScrimPaint = new Paint();
  private Drawable mShadowLeft;
  private Drawable mShadowRight;
  private Drawable mStatusBarBackground;
  private CharSequence mTitleLeft;
  private CharSequence mTitleRight;

  static
  {
    boolean bool = true;
    int[] arrayOfInt = new int[bool];
    arrayOfInt[0] = 16842931;
    LAYOUT_ATTRS = arrayOfInt;
    if (Build.VERSION.SDK_INT >= 19);
    while (true)
    {
      CAN_HIDE_DESCENDANTS = bool;
      if (Build.VERSION.SDK_INT < 21)
        break;
      IMPL = new DrawerLayoutCompatImplApi21();
      return;
      bool = false;
    }
    IMPL = new DrawerLayoutCompatImplBase();
  }

  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.mMinDrawerMargin = (int)(0.5F + 64.0F * f1);
    float f2 = f1 * 400.0F;
    this.mLeftCallback = new ViewDragCallback(3);
    this.mRightCallback = new ViewDragCallback(5);
    this.mLeftDragger = ViewDragHelper.create(this, 1.0F, this.mLeftCallback);
    this.mLeftDragger.setEdgeTrackingEnabled(1);
    this.mLeftDragger.setMinVelocity(f2);
    this.mLeftCallback.setDragger(this.mLeftDragger);
    this.mRightDragger = ViewDragHelper.create(this, 1.0F, this.mRightCallback);
    this.mRightDragger.setEdgeTrackingEnabled(2);
    this.mRightDragger.setMinVelocity(f2);
    this.mRightCallback.setDragger(this.mRightDragger);
    setFocusableInTouchMode(true);
    ViewCompat.setImportantForAccessibility(this, 1);
    ViewCompat.setAccessibilityDelegate(this, new AccessibilityDelegate());
    ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
    if (ViewCompat.getFitsSystemWindows(this))
    {
      IMPL.configureApplyInsets(this);
      this.mStatusBarBackground = IMPL.getDefaultStatusBarBackground(paramContext);
    }
  }

  private View findVisibleDrawer()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if ((isDrawerView(localView)) && (isDrawerVisible(localView)))
        return localView;
    }
    return null;
  }

  static String gravityToString(int paramInt)
  {
    if ((paramInt & 0x3) == 3)
      return "LEFT";
    if ((paramInt & 0x5) == 5)
      return "RIGHT";
    return Integer.toHexString(paramInt);
  }

  private static boolean hasOpaqueBackground(View paramView)
  {
    Drawable localDrawable = paramView.getBackground();
    int i = 0;
    if (localDrawable != null)
    {
      int j = localDrawable.getOpacity();
      i = 0;
      if (j == -1)
        i = 1;
    }
    return i;
  }

  private boolean hasPeekingDrawer()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
      if (((LayoutParams)getChildAt(j).getLayoutParams()).isPeeking)
        return true;
    return false;
  }

  private boolean hasVisibleDrawer()
  {
    return findVisibleDrawer() != null;
  }

  private static boolean includeChildForAccessibility(View paramView)
  {
    return (ViewCompat.getImportantForAccessibility(paramView) != 4) && (ViewCompat.getImportantForAccessibility(paramView) != 2);
  }

  private void updateChildrenImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    int i = getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = getChildAt(j);
      if (((!paramBoolean) && (!isDrawerView(localView))) || ((paramBoolean) && (localView == paramView)))
        ViewCompat.setImportantForAccessibility(localView, 1);
      while (true)
      {
        j++;
        break;
        ViewCompat.setImportantForAccessibility(localView, 4);
      }
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((findOpenDrawer() != null) || (isDrawerView(paramView)))
      ViewCompat.setImportantForAccessibility(paramView, 4);
    while (true)
    {
      if (!CAN_HIDE_DESCENDANTS)
        ViewCompat.setAccessibilityDelegate(paramView, this.mChildAccessibilityDelegate);
      return;
      ViewCompat.setImportantForAccessibility(paramView, 1);
    }
  }

  void cancelChildViewTouch()
  {
    int i = 0;
    if (!this.mChildrenCanceledTouch)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      while (i < j)
      {
        getChildAt(i).dispatchTouchEvent(localMotionEvent);
        i++;
      }
      localMotionEvent.recycle();
      this.mChildrenCanceledTouch = true;
    }
  }

  boolean checkDrawerViewAbsoluteGravity(View paramView, int paramInt)
  {
    return (paramInt & getDrawerViewAbsoluteGravity(paramView)) == paramInt;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public void closeDrawer(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView == null)
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
    closeDrawer(localView);
  }

  public void closeDrawer(View paramView)
  {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    if (this.mFirstLayout)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      localLayoutParams.onScreen = 0.0F;
      localLayoutParams.knownOpen = false;
    }
    while (true)
    {
      invalidate();
      return;
      if (checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        this.mLeftDragger.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
        continue;
      }
      this.mRightDragger.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
    }
  }

  public void closeDrawers()
  {
    closeDrawers(false);
  }

  void closeDrawers(boolean paramBoolean)
  {
    int i = getChildCount();
    int j = 0;
    boolean bool = false;
    while (j < i)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((!isDrawerView(localView)) || ((paramBoolean) && (!localLayoutParams.isPeeking)))
      {
        j++;
        continue;
      }
      int k = localView.getWidth();
      if (checkDrawerViewAbsoluteGravity(localView, 3))
        bool |= this.mLeftDragger.smoothSlideViewTo(localView, -k, localView.getTop());
      while (true)
      {
        localLayoutParams.isPeeking = false;
        break;
        bool |= this.mRightDragger.smoothSlideViewTo(localView, getWidth(), localView.getTop());
      }
    }
    this.mLeftCallback.removeCallbacks();
    this.mRightCallback.removeCallbacks();
    if (bool)
      invalidate();
  }

  public void computeScroll()
  {
    int i = getChildCount();
    float f = 0.0F;
    for (int j = 0; j < i; j++)
      f = Math.max(f, ((LayoutParams)getChildAt(j).getLayoutParams()).onScreen);
    this.mScrimOpacity = f;
    if ((this.mLeftDragger.continueSettling(true) | this.mRightDragger.continueSettling(true)))
      ViewCompat.postInvalidateOnAnimation(this);
  }

  void dispatchOnDrawerClosed(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.knownOpen)
    {
      localLayoutParams.knownOpen = false;
      if (this.mListener != null)
        this.mListener.onDrawerClosed(paramView);
      updateChildrenImportantForAccessibility(paramView, false);
      if (hasWindowFocus())
      {
        View localView = getRootView();
        if (localView != null)
          localView.sendAccessibilityEvent(32);
      }
    }
  }

  void dispatchOnDrawerOpened(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.knownOpen)
    {
      localLayoutParams.knownOpen = true;
      if (this.mListener != null)
        this.mListener.onDrawerOpened(paramView);
      updateChildrenImportantForAccessibility(paramView, true);
      if (hasWindowFocus())
        sendAccessibilityEvent(32);
      paramView.requestFocus();
    }
  }

  void dispatchOnDrawerSlide(View paramView, float paramFloat)
  {
    if (this.mListener != null)
      this.mListener.onDrawerSlide(paramView, paramFloat);
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i = getHeight();
    boolean bool1 = isContentView(paramView);
    int j = getWidth();
    int k = paramCanvas.save();
    int m = 0;
    View localView;
    int i11;
    int i12;
    if (bool1)
    {
      int i9 = getChildCount();
      int i10 = 0;
      while (true)
      {
        if (i10 >= i9)
          break label168;
        localView = getChildAt(i10);
        if ((localView != paramView) && (localView.getVisibility() == 0) && (hasOpaqueBackground(localView)) && (isDrawerView(localView)))
        {
          if (localView.getHeight() < i)
          {
            i11 = j;
            i10++;
            j = i11;
            continue;
          }
          if (!checkDrawerViewAbsoluteGravity(localView, 3))
            break;
          i12 = localView.getRight();
          if (i12 <= m)
            break label496;
        }
      }
    }
    while (true)
    {
      m = i12;
      i11 = j;
      break;
      i11 = localView.getLeft();
      if (i11 < j)
        break;
      i11 = j;
      break;
      label168: paramCanvas.clipRect(m, 0, j, getHeight());
      int n = j;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(k);
      if ((this.mScrimOpacity > 0.0F) && (bool1))
      {
        int i8 = (int)(((0xFF000000 & this.mScrimColor) >>> 24) * this.mScrimOpacity) << 24 | 0xFFFFFF & this.mScrimColor;
        this.mScrimPaint.setColor(i8);
        paramCanvas.drawRect(m, 0.0F, n, getHeight(), this.mScrimPaint);
      }
      do
      {
        return bool2;
        if ((this.mShadowLeft == null) || (!checkDrawerViewAbsoluteGravity(paramView, 3)))
          continue;
        int i5 = this.mShadowLeft.getIntrinsicWidth();
        int i6 = paramView.getRight();
        int i7 = this.mLeftDragger.getEdgeSize();
        float f2 = Math.max(0.0F, Math.min(i6 / i7, 1.0F));
        this.mShadowLeft.setBounds(i6, paramView.getTop(), i5 + i6, paramView.getBottom());
        this.mShadowLeft.setAlpha((int)(255.0F * f2));
        this.mShadowLeft.draw(paramCanvas);
        return bool2;
      }
      while ((this.mShadowRight == null) || (!checkDrawerViewAbsoluteGravity(paramView, 5)));
      int i1 = this.mShadowRight.getIntrinsicWidth();
      int i2 = paramView.getLeft();
      int i3 = getWidth() - i2;
      int i4 = this.mRightDragger.getEdgeSize();
      float f1 = Math.max(0.0F, Math.min(i3 / i4, 1.0F));
      this.mShadowRight.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
      this.mShadowRight.setAlpha((int)(255.0F * f1));
      this.mShadowRight.draw(paramCanvas);
      return bool2;
      label496: i12 = m;
    }
  }

  View findDrawerWithGravity(int paramInt)
  {
    int i = 0x7 & GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    int j = getChildCount();
    for (int k = 0; k < j; k++)
    {
      View localView = getChildAt(k);
      if ((0x7 & getDrawerViewAbsoluteGravity(localView)) == i)
        return localView;
    }
    return null;
  }

  View findOpenDrawer()
  {
    int i = getChildCount();
    for (int j = 0; j < i; j++)
    {
      View localView = getChildAt(j);
      if (((LayoutParams)localView.getLayoutParams()).knownOpen)
        return localView;
    }
    return null;
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
      return new LayoutParams((LayoutParams)paramLayoutParams);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new LayoutParams(paramLayoutParams);
  }

  public int getDrawerLockMode(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (i == 3)
      return this.mLockModeLeft;
    if (i == 5)
      return this.mLockModeRight;
    return 0;
  }

  public int getDrawerLockMode(View paramView)
  {
    int i = getDrawerViewAbsoluteGravity(paramView);
    if (i == 3)
      return this.mLockModeLeft;
    if (i == 5)
      return this.mLockModeRight;
    return 0;
  }

  @Nullable
  public CharSequence getDrawerTitle(int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (i == 3)
      return this.mTitleLeft;
    if (i == 5)
      return this.mTitleRight;
    return null;
  }

  int getDrawerViewAbsoluteGravity(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(this));
  }

  float getDrawerViewOffset(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).onScreen;
  }

  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.mStatusBarBackground;
  }

  boolean isContentView(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }

  public boolean isDrawerOpen(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null)
      return isDrawerOpen(localView);
    return false;
  }

  public boolean isDrawerOpen(View paramView)
  {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    return ((LayoutParams)paramView.getLayoutParams()).knownOpen;
  }

  boolean isDrawerView(View paramView)
  {
    return (0x7 & GravityCompat.getAbsoluteGravity(((LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView))) != 0;
  }

  public boolean isDrawerVisible(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView != null)
      return isDrawerVisible(localView);
    return false;
  }

  public boolean isDrawerVisible(View paramView)
  {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    return ((LayoutParams)paramView.getLayoutParams()).onScreen > 0.0F;
  }

  void moveDrawerToOffset(View paramView, float paramFloat)
  {
    float f = getDrawerViewOffset(paramView);
    int i = paramView.getWidth();
    int j = (int)(f * i);
    int k = (int)(paramFloat * i) - j;
    if (checkDrawerViewAbsoluteGravity(paramView, 3));
    while (true)
    {
      paramView.offsetLeftAndRight(k);
      setDrawerViewOffset(paramView, paramFloat);
      return;
      k = -k;
    }
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mFirstLayout = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
  }

  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mDrawStatusBarBackground) && (this.mStatusBarBackground != null))
    {
      int i = IMPL.getTopInset(this.mLastInsets);
      if (i > 0)
      {
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
        this.mStatusBarBackground.draw(paramCanvas);
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool1 = this.mLeftDragger.shouldInterceptTouchEvent(paramMotionEvent) | this.mRightDragger.shouldInterceptTouchEvent(paramMotionEvent);
    switch (i)
    {
    default:
      j = 0;
      int k;
      if ((!bool1) && (j == 0) && (!hasPeekingDrawer()))
      {
        boolean bool2 = this.mChildrenCanceledTouch;
        k = 0;
        if (!bool2);
      }
      else
      {
        k = 1;
      }
      return k;
    case 0:
      label59: float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      if (this.mScrimOpacity <= 0.0F)
        break;
      View localView = this.mLeftDragger.findTopChildUnder((int)f1, (int)f2);
      if ((localView == null) || (!isContentView(localView)))
        break;
    case 2:
    case 1:
    case 3:
    }
    for (int j = 1; ; j = 0)
    {
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      break label59;
      if (!this.mLeftDragger.checkTouchSlop(3))
        break;
      this.mLeftCallback.removeCallbacks();
      this.mRightCallback.removeCallbacks();
      j = 0;
      break label59;
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      break;
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (hasVisibleDrawer()))
    {
      KeyEventCompat.startTracking(paramKeyEvent);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      View localView = findVisibleDrawer();
      if ((localView != null) && (getDrawerLockMode(localView) == 0))
        closeDrawers();
      return localView != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    int i = paramInt3 - paramInt1;
    int j = getChildCount();
    int k = 0;
    if (k < j)
    {
      View localView = getChildAt(k);
      if (localView.getVisibility() == 8);
      LayoutParams localLayoutParams;
      while (true)
      {
        k++;
        break;
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!isContentView(localView))
          break label110;
        localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
      }
      label110: int m = localView.getMeasuredWidth();
      int n = localView.getMeasuredHeight();
      int i1;
      float f;
      label162: int i2;
      if (checkDrawerViewAbsoluteGravity(localView, 3))
      {
        i1 = -m + (int)(m * localLayoutParams.onScreen);
        f = (m + i1) / m;
        if (f == localLayoutParams.onScreen)
          break label313;
        i2 = 1;
        label176: switch (0x70 & localLayoutParams.gravity)
        {
        default:
          localView.layout(i1, localLayoutParams.topMargin, m + i1, n + localLayoutParams.topMargin);
          label237: if (i2 != 0)
            setDrawerViewOffset(localView, f);
          if (localLayoutParams.onScreen <= 0.0F)
            break;
        case 80:
        case 16:
        }
      }
      for (int i5 = 0; localView.getVisibility() != i5; i5 = 4)
      {
        localView.setVisibility(i5);
        break;
        i1 = i - (int)(m * localLayoutParams.onScreen);
        f = (i - i1) / m;
        break label162;
        label313: i2 = 0;
        break label176;
        int i6 = paramInt4 - paramInt2;
        localView.layout(i1, i6 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), m + i1, i6 - localLayoutParams.bottomMargin);
        break label237;
        int i3 = paramInt4 - paramInt2;
        int i4 = (i3 - n) / 2;
        if (i4 < localLayoutParams.topMargin)
          i4 = localLayoutParams.topMargin;
        while (true)
        {
          localView.layout(i1, i4, m + i1, n + i4);
          break;
          if (i4 + n <= i3 - localLayoutParams.bottomMargin)
            continue;
          i4 = i3 - localLayoutParams.bottomMargin - n;
        }
      }
    }
    this.mInLayout = false;
    this.mFirstLayout = false;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 300;
    int j = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    label70: int i1;
    label94: int i2;
    int i4;
    label109: View localView;
    if ((j != 1073741824) || (k != 1073741824))
    {
      if (!isInEditMode())
        break label162;
      if (j == -2147483648)
      {
        if (k != -2147483648)
          break label151;
        i = n;
        setMeasuredDimension(m, i);
        if ((this.mLastInsets == null) || (!ViewCompat.getFitsSystemWindows(this)))
          break label173;
        i1 = 1;
        i2 = ViewCompat.getLayoutDirection(this);
        int i3 = getChildCount();
        i4 = 0;
        if (i4 >= i3)
          return;
        localView = getChildAt(i4);
        if (localView.getVisibility() != 8)
          break label179;
      }
    }
    while (true)
    {
      i4++;
      break label109;
      if (j != 0)
        break;
      m = i;
      break;
      label151: if (k == 0)
        break label70;
      i = n;
      break label70;
      label162: throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
      label173: i1 = 0;
      break label94;
      label179: LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i6;
      if (i1 != 0)
      {
        i6 = GravityCompat.getAbsoluteGravity(localLayoutParams.gravity, i2);
        if (!ViewCompat.getFitsSystemWindows(localView))
          break label286;
        IMPL.dispatchChildInsets(localView, this.mLastInsets, i6);
      }
      while (true)
      {
        if (!isContentView(localView))
          break label305;
        localView.measure(View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        break;
        label286: IMPL.applyMarginInsets(localLayoutParams, this.mLastInsets, i6);
      }
      label305: if (!isDrawerView(localView))
        break label440;
      int i5 = 0x7 & getDrawerViewAbsoluteGravity(localView);
      if ((0x0 & i5) != 0)
        throw new IllegalStateException("Child drawer has absolute gravity " + gravityToString(i5) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
      localView.measure(getChildMeasureSpec(paramInt1, this.mMinDrawerMargin + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
    }
    label440: throw new IllegalStateException("Child " + localView + " at index " + i4 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.openDrawerGravity != 0)
    {
      View localView = findDrawerWithGravity(localSavedState.openDrawerGravity);
      if (localView != null)
        openDrawer(localView);
    }
    setDrawerLockMode(localSavedState.lockModeLeft, 3);
    setDrawerLockMode(localSavedState.lockModeRight, 5);
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    View localView = findOpenDrawer();
    if (localView != null)
      localSavedState.openDrawerGravity = ((LayoutParams)localView.getLayoutParams()).gravity;
    localSavedState.lockModeLeft = this.mLockModeLeft;
    localSavedState.lockModeRight = this.mLockModeRight;
    return localSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mLeftDragger.processTouchEvent(paramMotionEvent);
    this.mRightDragger.processTouchEvent(paramMotionEvent);
    boolean bool;
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 2:
    default:
      return true;
    case 0:
      float f5 = paramMotionEvent.getX();
      float f6 = paramMotionEvent.getY();
      this.mInitialMotionX = f5;
      this.mInitialMotionY = f6;
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      return true;
    case 1:
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      View localView1 = this.mLeftDragger.findTopChildUnder((int)f1, (int)f2);
      if ((localView1 != null) && (isContentView(localView1)))
      {
        float f3 = f1 - this.mInitialMotionX;
        float f4 = f2 - this.mInitialMotionY;
        int i = this.mLeftDragger.getTouchSlop();
        if (f3 * f3 + f4 * f4 < i * i)
        {
          View localView2 = findOpenDrawer();
          if (localView2 != null)
          {
            if (getDrawerLockMode(localView2) != 2)
              break;
            bool = true;
          }
        }
      }
    case 3:
    }
    while (true)
    {
      closeDrawers(bool);
      this.mDisallowInterceptRequested = false;
      return true;
      bool = false;
      continue;
      closeDrawers(true);
      this.mDisallowInterceptRequested = false;
      this.mChildrenCanceledTouch = false;
      return true;
      bool = true;
    }
  }

  public void openDrawer(int paramInt)
  {
    View localView = findDrawerWithGravity(paramInt);
    if (localView == null)
      throw new IllegalArgumentException("No drawer view found with gravity " + gravityToString(paramInt));
    openDrawer(localView);
  }

  public void openDrawer(View paramView)
  {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    if (this.mFirstLayout)
    {
      LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      localLayoutParams.onScreen = 1.0F;
      localLayoutParams.knownOpen = true;
      updateChildrenImportantForAccessibility(paramView, true);
    }
    while (true)
    {
      invalidate();
      return;
      if (checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        this.mLeftDragger.smoothSlideViewTo(paramView, 0, paramView.getTop());
        continue;
      }
      this.mRightDragger.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
    }
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.mDisallowInterceptRequested = paramBoolean;
    if (paramBoolean)
      closeDrawers(true);
  }

  public void requestLayout()
  {
    if (!this.mInLayout)
      super.requestLayout();
  }

  public void setChildInsets(Object paramObject, boolean paramBoolean)
  {
    this.mLastInsets = paramObject;
    this.mDrawStatusBarBackground = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null));
    for (boolean bool = true; ; bool = false)
    {
      setWillNotDraw(bool);
      requestLayout();
      return;
    }
  }

  public void setDrawerListener(DrawerListener paramDrawerListener)
  {
    this.mListener = paramDrawerListener;
  }

  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }

  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    ViewDragHelper localViewDragHelper;
    if (i == 3)
    {
      this.mLockModeLeft = paramInt1;
      if (paramInt1 != 0)
      {
        if (i != 3)
          break label78;
        localViewDragHelper = this.mLeftDragger;
        label34: localViewDragHelper.cancel();
      }
      switch (paramInt1)
      {
      default:
      case 2:
      case 1:
      }
    }
    label78: View localView1;
    do
    {
      View localView2;
      do
      {
        return;
        if (i != 5)
          break;
        this.mLockModeRight = paramInt1;
        break;
        localViewDragHelper = this.mRightDragger;
        break label34;
        localView2 = findDrawerWithGravity(i);
      }
      while (localView2 == null);
      openDrawer(localView2);
      return;
      localView1 = findDrawerWithGravity(i);
    }
    while (localView1 == null);
    closeDrawer(localView1);
  }

  public void setDrawerLockMode(int paramInt, View paramView)
  {
    if (!isDrawerView(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a " + "drawer with appropriate layout_gravity");
    setDrawerLockMode(paramInt, ((LayoutParams)paramView.getLayoutParams()).gravity);
  }

  public void setDrawerShadow(@DrawableRes int paramInt1, int paramInt2)
  {
    setDrawerShadow(getResources().getDrawable(paramInt1), paramInt2);
  }

  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if ((i & 0x3) == 3)
    {
      this.mShadowLeft = paramDrawable;
      invalidate();
    }
    if ((i & 0x5) == 5)
    {
      this.mShadowRight = paramDrawable;
      invalidate();
    }
  }

  public void setDrawerTitle(int paramInt, CharSequence paramCharSequence)
  {
    int i = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (i == 3)
      this.mTitleLeft = paramCharSequence;
    do
      return;
    while (i != 5);
    this.mTitleRight = paramCharSequence;
  }

  void setDrawerViewOffset(View paramView, float paramFloat)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.onScreen)
      return;
    localLayoutParams.onScreen = paramFloat;
    dispatchOnDrawerSlide(paramView, paramFloat);
  }

  public void setScrimColor(int paramInt)
  {
    this.mScrimColor = paramInt;
    invalidate();
  }

  public void setStatusBarBackground(int paramInt)
  {
    if (paramInt != 0);
    for (Drawable localDrawable = ContextCompat.getDrawable(getContext(), paramInt); ; localDrawable = null)
    {
      this.mStatusBarBackground = localDrawable;
      invalidate();
      return;
    }
  }

  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.mStatusBarBackground = paramDrawable;
    invalidate();
  }

  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.mStatusBarBackground = new ColorDrawable(paramInt);
    invalidate();
  }

  void updateDrawerState(int paramInt1, int paramInt2, View paramView)
  {
    int i = 1;
    int j = this.mLeftDragger.getViewDragState();
    int k = this.mRightDragger.getViewDragState();
    LayoutParams localLayoutParams;
    if ((j == i) || (k == i))
      if ((paramView != null) && (paramInt2 == 0))
      {
        localLayoutParams = (LayoutParams)paramView.getLayoutParams();
        if (localLayoutParams.onScreen != 0.0F)
          break label125;
        dispatchOnDrawerClosed(paramView);
      }
    while (true)
    {
      if (i != this.mDrawerState)
      {
        this.mDrawerState = i;
        if (this.mListener != null)
          this.mListener.onDrawerStateChanged(i);
      }
      return;
      if ((j == 2) || (k == 2))
      {
        i = 2;
        break;
      }
      i = 0;
      break;
      label125: if (localLayoutParams.onScreen != 1.0F)
        continue;
      dispatchOnDrawerOpened(paramView);
    }
  }

  class AccessibilityDelegate extends AccessibilityDelegateCompat
  {
    private final Rect mTmpRect = new Rect();

    AccessibilityDelegate()
    {
    }

    private void addChildrenForAccessibility(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, ViewGroup paramViewGroup)
    {
      int i = paramViewGroup.getChildCount();
      for (int j = 0; j < i; j++)
      {
        View localView = paramViewGroup.getChildAt(j);
        if (!DrawerLayout.access$400(localView))
          continue;
        paramAccessibilityNodeInfoCompat.addChild(localView);
      }
    }

    private void copyNodeInfoNoChildren(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat2)
    {
      Rect localRect = this.mTmpRect;
      paramAccessibilityNodeInfoCompat2.getBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInParent(localRect);
      paramAccessibilityNodeInfoCompat2.getBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setBoundsInScreen(localRect);
      paramAccessibilityNodeInfoCompat1.setVisibleToUser(paramAccessibilityNodeInfoCompat2.isVisibleToUser());
      paramAccessibilityNodeInfoCompat1.setPackageName(paramAccessibilityNodeInfoCompat2.getPackageName());
      paramAccessibilityNodeInfoCompat1.setClassName(paramAccessibilityNodeInfoCompat2.getClassName());
      paramAccessibilityNodeInfoCompat1.setContentDescription(paramAccessibilityNodeInfoCompat2.getContentDescription());
      paramAccessibilityNodeInfoCompat1.setEnabled(paramAccessibilityNodeInfoCompat2.isEnabled());
      paramAccessibilityNodeInfoCompat1.setClickable(paramAccessibilityNodeInfoCompat2.isClickable());
      paramAccessibilityNodeInfoCompat1.setFocusable(paramAccessibilityNodeInfoCompat2.isFocusable());
      paramAccessibilityNodeInfoCompat1.setFocused(paramAccessibilityNodeInfoCompat2.isFocused());
      paramAccessibilityNodeInfoCompat1.setAccessibilityFocused(paramAccessibilityNodeInfoCompat2.isAccessibilityFocused());
      paramAccessibilityNodeInfoCompat1.setSelected(paramAccessibilityNodeInfoCompat2.isSelected());
      paramAccessibilityNodeInfoCompat1.setLongClickable(paramAccessibilityNodeInfoCompat2.isLongClickable());
      paramAccessibilityNodeInfoCompat1.addAction(paramAccessibilityNodeInfoCompat2.getActions());
    }

    public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        List localList = paramAccessibilityEvent.getText();
        View localView = DrawerLayout.this.findVisibleDrawer();
        if (localView != null)
        {
          int i = DrawerLayout.this.getDrawerViewAbsoluteGravity(localView);
          CharSequence localCharSequence = DrawerLayout.this.getDrawerTitle(i);
          if (localCharSequence != null)
            localList.add(localCharSequence);
        }
        return true;
      }
      return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if (DrawerLayout.CAN_HIDE_DESCENDANTS)
        super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      while (true)
      {
        paramAccessibilityNodeInfoCompat.setClassName(DrawerLayout.class.getName());
        paramAccessibilityNodeInfoCompat.setFocusable(false);
        paramAccessibilityNodeInfoCompat.setFocused(false);
        return;
        AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(paramAccessibilityNodeInfoCompat);
        super.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
        paramAccessibilityNodeInfoCompat.setSource(paramView);
        ViewParent localViewParent = ViewCompat.getParentForAccessibility(paramView);
        if ((localViewParent instanceof View))
          paramAccessibilityNodeInfoCompat.setParent((View)localViewParent);
        copyNodeInfoNoChildren(paramAccessibilityNodeInfoCompat, localAccessibilityNodeInfoCompat);
        localAccessibilityNodeInfoCompat.recycle();
        addChildrenForAccessibility(paramAccessibilityNodeInfoCompat, (ViewGroup)paramView);
      }
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((DrawerLayout.CAN_HIDE_DESCENDANTS) || (DrawerLayout.access$400(paramView)))
        return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
      return false;
    }
  }

  final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat
  {
    ChildAccessibilityDelegate()
    {
    }

    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      if (!DrawerLayout.access$400(paramView))
        paramAccessibilityNodeInfoCompat.setParent(null);
    }
  }

  static abstract interface DrawerLayoutCompatImpl
  {
    public abstract void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt);

    public abstract void configureApplyInsets(View paramView);

    public abstract void dispatchChildInsets(View paramView, Object paramObject, int paramInt);

    public abstract Drawable getDefaultStatusBarBackground(Context paramContext);

    public abstract int getTopInset(Object paramObject);
  }

  static class DrawerLayoutCompatImplApi21
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
      DrawerLayoutCompatApi21.applyMarginInsets(paramMarginLayoutParams, paramObject, paramInt);
    }

    public void configureApplyInsets(View paramView)
    {
      DrawerLayoutCompatApi21.configureApplyInsets(paramView);
    }

    public void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
    {
      DrawerLayoutCompatApi21.dispatchChildInsets(paramView, paramObject, paramInt);
    }

    public Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return DrawerLayoutCompatApi21.getDefaultStatusBarBackground(paramContext);
    }

    public int getTopInset(Object paramObject)
    {
      return DrawerLayoutCompatApi21.getTopInset(paramObject);
    }
  }

  static class DrawerLayoutCompatImplBase
    implements DrawerLayout.DrawerLayoutCompatImpl
  {
    public void applyMarginInsets(ViewGroup.MarginLayoutParams paramMarginLayoutParams, Object paramObject, int paramInt)
    {
    }

    public void configureApplyInsets(View paramView)
    {
    }

    public void dispatchChildInsets(View paramView, Object paramObject, int paramInt)
    {
    }

    public Drawable getDefaultStatusBarBackground(Context paramContext)
    {
      return null;
    }

    public int getTopInset(Object paramObject)
    {
      return 0;
    }
  }

  public static abstract interface DrawerListener
  {
    public abstract void onDrawerClosed(View paramView);

    public abstract void onDrawerOpened(View paramView);

    public abstract void onDrawerSlide(View paramView, float paramFloat);

    public abstract void onDrawerStateChanged(int paramInt);
  }

  @Retention(RetentionPolicy.SOURCE)
  private static @interface EdgeGravity
  {
  }

  public static class LayoutParams extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    boolean isPeeking;
    boolean knownOpen;
    float onScreen;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2);
      this.gravity = paramInt3;
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.LAYOUT_ATTRS);
      this.gravity = localTypedArray.getInt(0, 0);
      localTypedArray.recycle();
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  private static @interface LockMode
  {
  }

  protected static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new DrawerLayout.SavedState.1();
    int lockModeLeft = 0;
    int lockModeRight = 0;
    int openDrawerGravity = 0;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.openDrawerGravity = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.openDrawerGravity);
    }
  }

  public static abstract class SimpleDrawerListener
    implements DrawerLayout.DrawerListener
  {
    public void onDrawerClosed(View paramView)
    {
    }

    public void onDrawerOpened(View paramView)
    {
    }

    public void onDrawerSlide(View paramView, float paramFloat)
    {
    }

    public void onDrawerStateChanged(int paramInt)
    {
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  private static @interface State
  {
  }

  private class ViewDragCallback extends ViewDragHelper.Callback
  {
    private final int mAbsGravity;
    private ViewDragHelper mDragger;
    private final Runnable mPeekRunnable = new DrawerLayout.ViewDragCallback.1(this);

    public ViewDragCallback(int arg2)
    {
      int i;
      this.mAbsGravity = i;
    }

    private void closeOtherDrawer()
    {
      int i = 3;
      if (this.mAbsGravity == i)
        i = 5;
      View localView = DrawerLayout.this.findDrawerWithGravity(i);
      if (localView != null)
        DrawerLayout.this.closeDrawer(localView);
    }

    private void peekDrawer()
    {
      int i = this.mDragger.getEdgeSize();
      int j;
      int i1;
      Object localObject;
      if (this.mAbsGravity == 3)
      {
        j = 1;
        if (j == 0)
          break label164;
        View localView2 = DrawerLayout.this.findDrawerWithGravity(3);
        int n = 0;
        if (localView2 != null)
          n = -localView2.getWidth();
        i1 = n + i;
        localObject = localView2;
      }
      label164: int k;
      for (int m = i1; ; m = k)
      {
        if ((localObject != null) && (((j != 0) && (((View)localObject).getLeft() < m)) || ((j == 0) && (((View)localObject).getLeft() > m) && (DrawerLayout.this.getDrawerLockMode((View)localObject) == 0))))
        {
          DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject).getLayoutParams();
          this.mDragger.smoothSlideViewTo((View)localObject, m, ((View)localObject).getTop());
          localLayoutParams.isPeeking = true;
          DrawerLayout.this.invalidate();
          closeOtherDrawer();
          DrawerLayout.this.cancelChildViewTouch();
        }
        return;
        j = 0;
        break;
        View localView1 = DrawerLayout.this.findDrawerWithGravity(5);
        k = DrawerLayout.this.getWidth() - i;
        localObject = localView1;
      }
    }

    public int clampViewPositionHorizontal(View paramView, int paramInt1, int paramInt2)
    {
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
        return Math.max(-paramView.getWidth(), Math.min(paramInt1, 0));
      int i = DrawerLayout.this.getWidth();
      return Math.max(i - paramView.getWidth(), Math.min(paramInt1, i));
    }

    public int clampViewPositionVertical(View paramView, int paramInt1, int paramInt2)
    {
      return paramView.getTop();
    }

    public int getViewHorizontalDragRange(View paramView)
    {
      if (DrawerLayout.this.isDrawerView(paramView))
        return paramView.getWidth();
      return 0;
    }

    public void onEdgeDragStarted(int paramInt1, int paramInt2)
    {
      if ((paramInt1 & 0x1) == 1);
      for (View localView = DrawerLayout.this.findDrawerWithGravity(3); ; localView = DrawerLayout.this.findDrawerWithGravity(5))
      {
        if ((localView != null) && (DrawerLayout.this.getDrawerLockMode(localView) == 0))
          this.mDragger.captureChildView(localView, paramInt2);
        return;
      }
    }

    public boolean onEdgeLock(int paramInt)
    {
      return false;
    }

    public void onEdgeTouched(int paramInt1, int paramInt2)
    {
      DrawerLayout.this.postDelayed(this.mPeekRunnable, 160L);
    }

    public void onViewCaptured(View paramView, int paramInt)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).isPeeking = false;
      closeOtherDrawer();
    }

    public void onViewDragStateChanged(int paramInt)
    {
      DrawerLayout.this.updateDrawerState(this.mAbsGravity, paramInt, this.mDragger.getCapturedView());
    }

    public void onViewPositionChanged(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = paramView.getWidth();
      float f;
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
      {
        f = (i + paramInt1) / i;
        DrawerLayout.this.setDrawerViewOffset(paramView, f);
        if (f != 0.0F)
          break label82;
      }
      label82: for (int j = 4; ; j = 0)
      {
        paramView.setVisibility(j);
        DrawerLayout.this.invalidate();
        return;
        f = (DrawerLayout.this.getWidth() - paramInt1) / i;
        break;
      }
    }

    public void onViewReleased(View paramView, float paramFloat1, float paramFloat2)
    {
      float f = DrawerLayout.this.getDrawerViewOffset(paramView);
      int i = paramView.getWidth();
      int j;
      if (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, 3))
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (f > 0.5F)))
          j = 0;
      while (true)
      {
        this.mDragger.settleCapturedViewAt(j, paramView.getTop());
        DrawerLayout.this.invalidate();
        return;
        j = -i;
        continue;
        j = DrawerLayout.this.getWidth();
        if ((paramFloat1 >= 0.0F) && ((paramFloat1 != 0.0F) || (f <= 0.5F)))
          continue;
        j -= i;
      }
    }

    public void removeCallbacks()
    {
      DrawerLayout.this.removeCallbacks(this.mPeekRunnable);
    }

    public void setDragger(ViewDragHelper paramViewDragHelper)
    {
      this.mDragger = paramViewDragHelper;
    }

    public boolean tryCaptureView(View paramView, int paramInt)
    {
      return (DrawerLayout.this.isDrawerView(paramView)) && (DrawerLayout.this.checkDrawerViewAbsoluteGravity(paramView, this.mAbsGravity)) && (DrawerLayout.this.getDrawerLockMode(paramView) == 0);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.6.0
 */