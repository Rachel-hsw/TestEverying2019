package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.internal.view.SupportMenuInflater;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.view.menu.SubMenuBuilder;
import android.support.v7.internal.widget.DecorToolbar;
import android.support.v7.internal.widget.RtlSpacingHelper;
import android.support.v7.internal.widget.TintManager;
import android.support.v7.internal.widget.TintTypedArray;
import android.support.v7.internal.widget.ToolbarWidgetWrapper;
import android.support.v7.internal.widget.ViewUtils;
import android.support.v7.view.CollapsibleActionView;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup
{
  private static final String TAG = "Toolbar";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  private int mButtonGravity;
  private ImageButton mCollapseButtonView;
  private CharSequence mCollapseDescription;
  private Drawable mCollapseIcon;
  private boolean mCollapsible;
  private final RtlSpacingHelper mContentInsets = new RtlSpacingHelper();
  private boolean mEatingHover;
  private boolean mEatingTouch;
  View mExpandedActionView;
  private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
  private int mGravity = 8388627;
  private ImageView mLogoView;
  private int mMaxButtonHeight;
  private MenuBuilder.Callback mMenuBuilderCallback;
  private ActionMenuView mMenuView;
  private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener = new Toolbar.1(this);
  private ImageButton mNavButtonView;
  private OnMenuItemClickListener mOnMenuItemClickListener;
  private ActionMenuPresenter mOuterActionMenuPresenter;
  private Context mPopupContext;
  private int mPopupTheme;
  private final Runnable mShowOverflowMenuRunnable = new Toolbar.2(this);
  private CharSequence mSubtitleText;
  private int mSubtitleTextAppearance;
  private int mSubtitleTextColor;
  private TextView mSubtitleTextView;
  private final int[] mTempMargins = new int[2];
  private final ArrayList<View> mTempViews = new ArrayList();
  private final TintManager mTintManager;
  private int mTitleMarginBottom;
  private int mTitleMarginEnd;
  private int mTitleMarginStart;
  private int mTitleMarginTop;
  private CharSequence mTitleText;
  private int mTitleTextAppearance;
  private int mTitleTextColor;
  private TextView mTitleTextView;
  private ToolbarWidgetWrapper mWrapper;

  public Toolbar(Context paramContext)
  {
    this(paramContext, null);
  }

  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.toolbarStyle);
  }

  public Toolbar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(getContext(), paramAttributeSet, R.styleable.Toolbar, paramInt, 0);
    this.mTitleTextAppearance = localTintTypedArray.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
    this.mSubtitleTextAppearance = localTintTypedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
    this.mGravity = localTintTypedArray.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
    this.mButtonGravity = 48;
    int i = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, 0);
    this.mTitleMarginBottom = i;
    this.mTitleMarginTop = i;
    this.mTitleMarginEnd = i;
    this.mTitleMarginStart = i;
    int j = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
    if (j >= 0)
      this.mTitleMarginStart = j;
    int k = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
    if (k >= 0)
      this.mTitleMarginEnd = k;
    int m = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
    if (m >= 0)
      this.mTitleMarginTop = m;
    int n = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
    if (n >= 0)
      this.mTitleMarginBottom = n;
    this.mMaxButtonHeight = localTintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
    int i1 = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, -2147483648);
    int i2 = localTintTypedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, -2147483648);
    int i3 = localTintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
    int i4 = localTintTypedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
    this.mContentInsets.setAbsolute(i3, i4);
    if ((i1 != -2147483648) || (i2 != -2147483648))
      this.mContentInsets.setRelative(i1, i2);
    this.mCollapseIcon = localTintTypedArray.getDrawable(R.styleable.Toolbar_collapseIcon);
    this.mCollapseDescription = localTintTypedArray.getText(R.styleable.Toolbar_collapseContentDescription);
    CharSequence localCharSequence1 = localTintTypedArray.getText(R.styleable.Toolbar_title);
    if (!TextUtils.isEmpty(localCharSequence1))
      setTitle(localCharSequence1);
    CharSequence localCharSequence2 = localTintTypedArray.getText(R.styleable.Toolbar_subtitle);
    if (!TextUtils.isEmpty(localCharSequence2))
      setSubtitle(localCharSequence2);
    this.mPopupContext = getContext();
    setPopupTheme(localTintTypedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
    Drawable localDrawable = localTintTypedArray.getDrawable(R.styleable.Toolbar_navigationIcon);
    if (localDrawable != null)
      setNavigationIcon(localDrawable);
    CharSequence localCharSequence3 = localTintTypedArray.getText(R.styleable.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(localCharSequence3))
      setNavigationContentDescription(localCharSequence3);
    localTintTypedArray.recycle();
    this.mTintManager = localTintTypedArray.getTintManager();
  }

  private void addCustomViewsWithGravity(List<View> paramList, int paramInt)
  {
    int i = 1;
    if (ViewCompat.getLayoutDirection(this) == i);
    while (true)
    {
      int j = getChildCount();
      int k = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
      paramList.clear();
      int m = 0;
      if (i != 0)
      {
        for (int n = j - 1; n >= 0; n--)
        {
          View localView2 = getChildAt(n);
          LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
          if ((localLayoutParams2.mViewType != 0) || (!shouldLayout(localView2)) || (getChildHorizontalGravity(localLayoutParams2.gravity) != k))
            continue;
          paramList.add(localView2);
        }
        i = 0;
        continue;
      }
      while (m < j)
      {
        View localView1 = getChildAt(m);
        LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
        if ((localLayoutParams1.mViewType == 0) && (shouldLayout(localView1)) && (getChildHorizontalGravity(localLayoutParams1.gravity) == k))
          paramList.add(localView1);
        m++;
      }
    }
  }

  private void addSystemView(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    LayoutParams localLayoutParams1;
    if (localLayoutParams == null)
      localLayoutParams1 = generateDefaultLayoutParams();
    while (true)
    {
      localLayoutParams1.mViewType = 1;
      addView(paramView, localLayoutParams1);
      return;
      if (!checkLayoutParams(localLayoutParams))
      {
        localLayoutParams1 = generateLayoutParams(localLayoutParams);
        continue;
      }
      localLayoutParams1 = (LayoutParams)localLayoutParams;
    }
  }

  private void ensureCollapseButtonView()
  {
    if (this.mCollapseButtonView == null)
    {
      this.mCollapseButtonView = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
      this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | 0x70 & this.mButtonGravity);
      localLayoutParams.mViewType = 2;
      this.mCollapseButtonView.setLayoutParams(localLayoutParams);
      this.mCollapseButtonView.setOnClickListener(new Toolbar.3(this));
    }
  }

  private void ensureLogoView()
  {
    if (this.mLogoView == null)
      this.mLogoView = new ImageView(getContext());
  }

  private void ensureMenu()
  {
    ensureMenuView();
    if (this.mMenuView.peekMenu() == null)
    {
      MenuBuilder localMenuBuilder = (MenuBuilder)this.mMenuView.getMenu();
      if (this.mExpandedMenuPresenter == null)
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(null);
      this.mMenuView.setExpandedActionViewsExclusive(true);
      localMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    }
  }

  private void ensureMenuView()
  {
    if (this.mMenuView == null)
    {
      this.mMenuView = new ActionMenuView(getContext());
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
      this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800005 | 0x70 & this.mButtonGravity);
      this.mMenuView.setLayoutParams(localLayoutParams);
      addSystemView(this.mMenuView);
    }
  }

  private void ensureNavButtonView()
  {
    if (this.mNavButtonView == null)
    {
      this.mNavButtonView = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = generateDefaultLayoutParams();
      localLayoutParams.gravity = (0x800003 | 0x70 & this.mButtonGravity);
      this.mNavButtonView.setLayoutParams(localLayoutParams);
    }
  }

  private int getChildHorizontalGravity(int paramInt)
  {
    int i = ViewCompat.getLayoutDirection(this);
    int j = 0x7 & GravityCompat.getAbsoluteGravity(paramInt, i);
    switch (j)
    {
    case 2:
    case 4:
    default:
      if (i != 1)
        break;
      j = 5;
    case 1:
    case 3:
    case 5:
      return j;
    }
    return 3;
  }

  private int getChildTop(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = paramView.getMeasuredHeight();
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i3;
    if (paramInt > 0)
    {
      j = (i - paramInt) / 2;
      switch (getChildVerticalGravity(localLayoutParams.gravity))
      {
      default:
        k = getPaddingTop();
        m = getPaddingBottom();
        n = getHeight();
        i1 = (n - k - m - i) / 2;
        if (i1 >= localLayoutParams.topMargin)
          break;
        i3 = localLayoutParams.topMargin;
      case 48:
      case 80:
      }
    }
    while (true)
    {
      return i3 + k;
      j = 0;
      break;
      return getPaddingTop() - j;
      return getHeight() - getPaddingBottom() - i - localLayoutParams.bottomMargin - j;
      int i2 = n - m - i - i1 - k;
      if (i2 < localLayoutParams.bottomMargin)
      {
        i3 = Math.max(0, i1 - (localLayoutParams.bottomMargin - i2));
        continue;
      }
      i3 = i1;
    }
  }

  private int getChildVerticalGravity(int paramInt)
  {
    int i = paramInt & 0x70;
    switch (i)
    {
    default:
      i = 0x70 & this.mGravity;
    case 16:
    case 48:
    case 80:
    }
    return i;
  }

  private int getHorizontalMargins(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return MarginLayoutParamsCompat.getMarginStart(localMarginLayoutParams) + MarginLayoutParamsCompat.getMarginEnd(localMarginLayoutParams);
  }

  private MenuInflater getMenuInflater()
  {
    return new SupportMenuInflater(getContext());
  }

  private int getVerticalMargins(View paramView)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
  }

  private int getViewListMeasuredWidth(List<View> paramList, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramList.size();
    int m = 0;
    int n = 0;
    int i1 = j;
    int i2 = i;
    while (m < k)
    {
      View localView = (View)paramList.get(m);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i3 = localLayoutParams.leftMargin - i2;
      int i4 = localLayoutParams.rightMargin - i1;
      int i5 = Math.max(0, i3);
      int i6 = Math.max(0, i4);
      i2 = Math.max(0, -i3);
      i1 = Math.max(0, -i4);
      int i7 = n + (i6 + (i5 + localView.getMeasuredWidth()));
      m++;
      n = i7;
    }
    return n;
  }

  private static boolean isCustomView(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).mViewType == 0;
  }

  private int layoutChildLeft(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = paramInt1 + Math.max(0, i);
    paramArrayOfInt[0] = Math.max(0, -i);
    int k = getChildTop(paramView, paramInt2);
    int m = paramView.getMeasuredWidth();
    paramView.layout(j, k, j + m, k + paramView.getMeasuredHeight());
    return j + (m + localLayoutParams.rightMargin);
  }

  private int layoutChildRight(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = localLayoutParams.rightMargin - paramArrayOfInt[1];
    int j = paramInt1 - Math.max(0, i);
    paramArrayOfInt[1] = Math.max(0, -i);
    int k = getChildTop(paramView, paramInt2);
    int m = paramView.getMeasuredWidth();
    paramView.layout(j - m, k, j, k + paramView.getMeasuredHeight());
    return j - (m + localLayoutParams.leftMargin);
  }

  private int measureChildCollapseMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int j = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int k = Math.max(0, i) + Math.max(0, j);
    paramArrayOfInt[0] = Math.max(0, -i);
    paramArrayOfInt[1] = Math.max(0, -j);
    paramView.measure(getChildMeasureSpec(paramInt1, paramInt2 + (k + (getPaddingLeft() + getPaddingRight())), localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, paramInt4 + (getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin), localMarginLayoutParams.height));
    return k + paramView.getMeasuredWidth();
  }

  private void measureChildConstrained(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i = getChildMeasureSpec(paramInt1, paramInt2 + (getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin), localMarginLayoutParams.width);
    int j = getChildMeasureSpec(paramInt3, paramInt4 + (getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin), localMarginLayoutParams.height);
    int k = View.MeasureSpec.getMode(j);
    if ((k != 1073741824) && (paramInt5 >= 0))
    {
      if (k != 0)
        paramInt5 = Math.min(View.MeasureSpec.getSize(j), paramInt5);
      j = View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824);
    }
    paramView.measure(i, j);
  }

  private void postShowOverflowMenu()
  {
    removeCallbacks(this.mShowOverflowMenuRunnable);
    post(this.mShowOverflowMenuRunnable);
  }

  private void setChildVisibilityForExpandedActionView(boolean paramBoolean)
  {
    int i = getChildCount();
    int j = 0;
    if (j < i)
    {
      View localView = getChildAt(j);
      if ((((LayoutParams)localView.getLayoutParams()).mViewType != 2) && (localView != this.mMenuView))
        if (!paramBoolean)
          break label64;
      label64: for (int k = 8; ; k = 0)
      {
        localView.setVisibility(k);
        j++;
        break;
      }
    }
  }

  private boolean shouldCollapse()
  {
    if (!this.mCollapsible)
      return false;
    int i = getChildCount();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label55;
      View localView = getChildAt(j);
      if ((shouldLayout(localView)) && (localView.getMeasuredWidth() > 0) && (localView.getMeasuredHeight() > 0))
        break;
    }
    label55: return true;
  }

  private boolean shouldLayout(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }

  private void updateChildVisibilityForExpandedActionView(View paramView)
  {
    if ((((LayoutParams)paramView.getLayoutParams()).mViewType != 2) && (paramView != this.mMenuView))
      if (this.mExpandedActionView == null)
        break label38;
    label38: for (int i = 8; ; i = 0)
    {
      paramView.setVisibility(i);
      return;
    }
  }

  public boolean canShowOverflowMenu()
  {
    return (getVisibility() == 0) && (this.mMenuView != null) && (this.mMenuView.isOverflowReserved());
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }

  public void collapseActionView()
  {
    if (this.mExpandedMenuPresenter == null);
    for (MenuItemImpl localMenuItemImpl = null; ; localMenuItemImpl = this.mExpandedMenuPresenter.mCurrentExpandedItem)
    {
      if (localMenuItemImpl != null)
        localMenuItemImpl.collapseActionView();
      return;
    }
  }

  public void dismissPopupMenus()
  {
    if (this.mMenuView != null)
      this.mMenuView.dismissPopupMenus();
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
      return new LayoutParams((LayoutParams)paramLayoutParams);
    if ((paramLayoutParams instanceof ActionBar.LayoutParams))
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new LayoutParams(paramLayoutParams);
  }

  public int getContentInsetEnd()
  {
    return this.mContentInsets.getEnd();
  }

  public int getContentInsetLeft()
  {
    return this.mContentInsets.getLeft();
  }

  public int getContentInsetRight()
  {
    return this.mContentInsets.getRight();
  }

  public int getContentInsetStart()
  {
    return this.mContentInsets.getStart();
  }

  public Drawable getLogo()
  {
    if (this.mLogoView != null)
      return this.mLogoView.getDrawable();
    return null;
  }

  public CharSequence getLogoDescription()
  {
    if (this.mLogoView != null)
      return this.mLogoView.getContentDescription();
    return null;
  }

  public Menu getMenu()
  {
    ensureMenu();
    return this.mMenuView.getMenu();
  }

  @Nullable
  public CharSequence getNavigationContentDescription()
  {
    if (this.mNavButtonView != null)
      return this.mNavButtonView.getContentDescription();
    return null;
  }

  @Nullable
  public Drawable getNavigationIcon()
  {
    if (this.mNavButtonView != null)
      return this.mNavButtonView.getDrawable();
    return null;
  }

  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }

  public CharSequence getSubtitle()
  {
    return this.mSubtitleText;
  }

  public CharSequence getTitle()
  {
    return this.mTitleText;
  }

  public DecorToolbar getWrapper()
  {
    if (this.mWrapper == null)
      this.mWrapper = new ToolbarWidgetWrapper(this, true);
    return this.mWrapper;
  }

  public boolean hasExpandedActionView()
  {
    return (this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.mCurrentExpandedItem != null);
  }

  public boolean hideOverflowMenu()
  {
    return (this.mMenuView != null) && (this.mMenuView.hideOverflowMenu());
  }

  public void inflateMenu(int paramInt)
  {
    getMenuInflater().inflate(paramInt, getMenu());
  }

  public boolean isOverflowMenuShowPending()
  {
    return (this.mMenuView != null) && (this.mMenuView.isOverflowMenuShowPending());
  }

  public boolean isOverflowMenuShowing()
  {
    return (this.mMenuView != null) && (this.mMenuView.isOverflowMenuShowing());
  }

  public boolean isTitleTruncated()
  {
    if (this.mTitleTextView == null);
    while (true)
    {
      return false;
      Layout localLayout = this.mTitleTextView.getLayout();
      if (localLayout == null)
        continue;
      int i = localLayout.getLineCount();
      for (int j = 0; j < i; j++)
        if (localLayout.getEllipsisCount(j) > 0)
          return true;
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.mShowOverflowMenuRunnable);
  }

  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 9)
      this.mEatingHover = false;
    if (!this.mEatingHover)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool))
        this.mEatingHover = true;
    }
    if ((i == 10) || (i == 3))
      this.mEatingHover = false;
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    int[] arrayOfInt;
    int i4;
    int i5;
    if (ViewCompat.getLayoutDirection(this) == 1)
    {
      i = 1;
      j = getWidth();
      k = getHeight();
      m = getPaddingLeft();
      n = getPaddingRight();
      i1 = getPaddingTop();
      i2 = getPaddingBottom();
      i3 = j - n;
      arrayOfInt = this.mTempMargins;
      arrayOfInt[1] = 0;
      arrayOfInt[0] = 0;
      i4 = ViewCompat.getMinimumHeight(this);
      if (!shouldLayout(this.mNavButtonView))
        break label1612;
      if (i == 0)
        break label881;
      i3 = layoutChildRight(this.mNavButtonView, i3, arrayOfInt, i4);
      i5 = m;
    }
    while (true)
    {
      label112: int i6;
      label144: label176: int i7;
      label272: int i8;
      int i9;
      if (shouldLayout(this.mCollapseButtonView))
      {
        if (i != 0)
          i3 = layoutChildRight(this.mCollapseButtonView, i3, arrayOfInt, i4);
      }
      else
      {
        if (shouldLayout(this.mMenuView))
        {
          if (i == 0)
            break label919;
          i5 = layoutChildLeft(this.mMenuView, i5, arrayOfInt, i4);
        }
        arrayOfInt[0] = Math.max(0, getContentInsetLeft() - i5);
        arrayOfInt[1] = Math.max(0, getContentInsetRight() - (j - n - i3));
        i6 = Math.max(i5, getContentInsetLeft());
        i7 = Math.min(i3, j - n - getContentInsetRight());
        if (shouldLayout(this.mExpandedActionView))
        {
          if (i == 0)
            break label938;
          i7 = layoutChildRight(this.mExpandedActionView, i7, arrayOfInt, i4);
        }
        if (!shouldLayout(this.mLogoView))
          break label1601;
        if (i == 0)
          break label957;
        i8 = layoutChildRight(this.mLogoView, i7, arrayOfInt, i4);
        i9 = i6;
      }
      while (true)
      {
        label308: boolean bool1 = shouldLayout(this.mTitleTextView);
        boolean bool2 = shouldLayout(this.mSubtitleTextView);
        int i10 = 0;
        if (bool1)
        {
          LayoutParams localLayoutParams8 = (LayoutParams)this.mTitleTextView.getLayoutParams();
          i10 = 0 + (localLayoutParams8.topMargin + this.mTitleTextView.getMeasuredHeight() + localLayoutParams8.bottomMargin);
        }
        LayoutParams localLayoutParams7;
        if (bool2)
          localLayoutParams7 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
        for (int i11 = i10 + (localLayoutParams7.topMargin + this.mSubtitleTextView.getMeasuredHeight() + localLayoutParams7.bottomMargin); ; i11 = i10)
        {
          TextView localTextView1;
          label433: TextView localTextView2;
          label444: LayoutParams localLayoutParams1;
          LayoutParams localLayoutParams2;
          int i12;
          label497: int i51;
          int i53;
          if ((bool1) || (bool2))
          {
            if (!bool1)
              break label984;
            localTextView1 = this.mTitleTextView;
            if (!bool2)
              break label993;
            localTextView2 = this.mSubtitleTextView;
            localLayoutParams1 = (LayoutParams)localTextView1.getLayoutParams();
            localLayoutParams2 = (LayoutParams)localTextView2.getLayoutParams();
            if (((!bool1) || (this.mTitleTextView.getMeasuredWidth() <= 0)) && ((!bool2) || (this.mSubtitleTextView.getMeasuredWidth() <= 0)))
              break label1002;
            i12 = 1;
            switch (0x70 & this.mGravity)
            {
            default:
              i51 = (k - i1 - i2 - i11) / 2;
              if (i51 >= localLayoutParams1.topMargin + this.mTitleMarginTop)
                break;
              i53 = localLayoutParams1.topMargin + this.mTitleMarginTop;
            case 48:
            case 80:
            }
          }
          while (true)
          {
            label574: int i13 = i1 + i53;
            label581: int i38;
            label597: int i40;
            int i50;
            if (i != 0)
              if (i12 != 0)
              {
                i38 = this.mTitleMarginStart;
                int i39 = i38 - arrayOfInt[1];
                i40 = i8 - Math.max(0, i39);
                arrayOfInt[1] = Math.max(0, -i39);
                if (!bool1)
                  break label1580;
                LayoutParams localLayoutParams6 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                int i48 = i40 - this.mTitleTextView.getMeasuredWidth();
                int i49 = i13 + this.mTitleTextView.getMeasuredHeight();
                this.mTitleTextView.layout(i48, i13, i40, i49);
                i50 = i48 - this.mTitleMarginEnd;
                i13 = i49 + localLayoutParams6.bottomMargin;
              }
            label919: label938: label1580: for (int i41 = i50; ; i41 = i40)
            {
              int i47;
              if (bool2)
              {
                LayoutParams localLayoutParams5 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                int i44 = i13 + localLayoutParams5.topMargin;
                int i45 = i40 - this.mSubtitleTextView.getMeasuredWidth();
                int i46 = i44 + this.mSubtitleTextView.getMeasuredHeight();
                this.mSubtitleTextView.layout(i45, i44, i40, i46);
                i47 = i40 - this.mTitleMarginEnd;
                (i46 + localLayoutParams5.bottomMargin);
              }
              for (int i42 = i47; ; i42 = i40)
              {
                if (i12 != 0);
                for (int i43 = Math.min(i41, i42); ; i43 = i40)
                {
                  i8 = i43;
                  addCustomViewsWithGravity(this.mTempViews, 3);
                  int i19 = this.mTempViews.size();
                  int i20 = 0;
                  int i21 = i9;
                  label881: int i14;
                  label957: label984: label993: label1002: int i37;
                  label1125: int i16;
                  while (true)
                    if (i20 < i19)
                    {
                      i21 = layoutChildLeft((View)this.mTempViews.get(i20), i21, arrayOfInt, i4);
                      i20++;
                      continue;
                      i = 0;
                      break;
                      i5 = layoutChildLeft(this.mNavButtonView, m, arrayOfInt, i4);
                      break label112;
                      i5 = layoutChildLeft(this.mCollapseButtonView, i5, arrayOfInt, i4);
                      break label144;
                      i3 = layoutChildRight(this.mMenuView, i3, arrayOfInt, i4);
                      break label176;
                      i6 = layoutChildLeft(this.mExpandedActionView, i6, arrayOfInt, i4);
                      break label272;
                      int i54 = layoutChildLeft(this.mLogoView, i6, arrayOfInt, i4);
                      i8 = i7;
                      i9 = i54;
                      break label308;
                      localTextView1 = this.mSubtitleTextView;
                      break label433;
                      localTextView2 = this.mTitleTextView;
                      break label444;
                      i12 = 0;
                      break label497;
                      i13 = getPaddingTop() + localLayoutParams1.topMargin + this.mTitleMarginTop;
                      break label581;
                      int i52 = k - i2 - i11 - i51 - i1;
                      if (i52 >= localLayoutParams1.bottomMargin + this.mTitleMarginBottom)
                        break label1587;
                      i53 = Math.max(0, i51 - (localLayoutParams2.bottomMargin + this.mTitleMarginBottom - i52));
                      break label574;
                      i13 = k - i2 - localLayoutParams2.bottomMargin - this.mTitleMarginBottom - i11;
                      break label581;
                      i38 = 0;
                      break label597;
                      if (i12 != 0)
                      {
                        i14 = this.mTitleMarginStart;
                        int i15 = i14 - arrayOfInt[0];
                        i9 += Math.max(0, i15);
                        arrayOfInt[0] = Math.max(0, -i15);
                        if (!bool1)
                          break label1555;
                        LayoutParams localLayoutParams4 = (LayoutParams)this.mTitleTextView.getLayoutParams();
                        int i34 = i9 + this.mTitleTextView.getMeasuredWidth();
                        int i35 = i13 + this.mTitleTextView.getMeasuredHeight();
                        this.mTitleTextView.layout(i9, i13, i34, i35);
                        int i36 = i34 + this.mTitleMarginEnd;
                        i37 = i35 + localLayoutParams4.bottomMargin;
                        i16 = i36;
                      }
                    }
                  for (int i17 = i37; ; i17 = i13)
                  {
                    int i33;
                    if (bool2)
                    {
                      LayoutParams localLayoutParams3 = (LayoutParams)this.mSubtitleTextView.getLayoutParams();
                      int i30 = i17 + localLayoutParams3.topMargin;
                      int i31 = i9 + this.mSubtitleTextView.getMeasuredWidth();
                      int i32 = i30 + this.mSubtitleTextView.getMeasuredHeight();
                      this.mSubtitleTextView.layout(i9, i30, i31, i32);
                      i33 = i31 + this.mTitleMarginEnd;
                      (i32 + localLayoutParams3.bottomMargin);
                    }
                    for (int i18 = i33; ; i18 = i9)
                    {
                      if (i12 == 0)
                        break label1553;
                      i9 = Math.max(i16, i18);
                      break;
                      i14 = 0;
                      break label1125;
                      addCustomViewsWithGravity(this.mTempViews, 5);
                      int i22 = this.mTempViews.size();
                      for (int i23 = 0; i23 < i22; i23++)
                        i8 = layoutChildRight((View)this.mTempViews.get(i23), i8, arrayOfInt, i4);
                      addCustomViewsWithGravity(this.mTempViews, 1);
                      int i24 = getViewListMeasuredWidth(this.mTempViews, arrayOfInt);
                      int i25 = m + (j - m - n) / 2 - i24 / 2;
                      int i26 = i24 + i25;
                      if (i25 < i21)
                        i25 = i21;
                      while (true)
                      {
                        int i27 = this.mTempViews.size();
                        int i28 = 0;
                        int i29 = i25;
                        while (i28 < i27)
                        {
                          i29 = layoutChildLeft((View)this.mTempViews.get(i28), i29, arrayOfInt, i4);
                          i28++;
                        }
                        if (i26 <= i8)
                          continue;
                        i25 -= i26 - i8;
                      }
                      this.mTempViews.clear();
                      return;
                    }
                    break;
                    i16 = i9;
                  }
                }
              }
            }
            label1553: label1555: label1587: i53 = i51;
          }
        }
        label1601: i8 = i7;
        i9 = i6;
      }
      label1612: i5 = m;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.mTempMargins;
    int i;
    int j;
    int i5;
    int i7;
    int i8;
    int i9;
    label499: View localView;
    int i20;
    int i21;
    if (ViewUtils.isLayoutRtl(this))
    {
      i = 0;
      j = 1;
      boolean bool1 = shouldLayout(this.mNavButtonView);
      int k = 0;
      int m = 0;
      int n = 0;
      if (bool1)
      {
        measureChildConstrained(this.mNavButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
        k = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int i23 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        m = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
        n = i23;
      }
      if (shouldLayout(this.mCollapseButtonView))
      {
        measureChildConstrained(this.mCollapseButtonView, paramInt1, 0, paramInt2, 0, this.mMaxButtonHeight);
        k = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        n = Math.max(n, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        m = ViewUtils.combineMeasuredStates(m, ViewCompat.getMeasuredState(this.mCollapseButtonView));
      }
      int i1 = getContentInsetStart();
      int i2 = 0 + Math.max(i1, k);
      arrayOfInt[j] = Math.max(0, i1 - k);
      boolean bool2 = shouldLayout(this.mMenuView);
      int i3 = 0;
      if (bool2)
      {
        measureChildConstrained(this.mMenuView, paramInt1, i2, paramInt2, 0, this.mMaxButtonHeight);
        i3 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        n = Math.max(n, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        m = ViewUtils.combineMeasuredStates(m, ViewCompat.getMeasuredState(this.mMenuView));
      }
      int i4 = getContentInsetEnd();
      i5 = i2 + Math.max(i4, i3);
      arrayOfInt[i] = Math.max(0, i4 - i3);
      if (shouldLayout(this.mExpandedActionView))
      {
        i5 += measureChildCollapseMargins(this.mExpandedActionView, paramInt1, i5, paramInt2, 0, arrayOfInt);
        n = Math.max(n, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        m = ViewUtils.combineMeasuredStates(m, ViewCompat.getMeasuredState(this.mExpandedActionView));
      }
      if (shouldLayout(this.mLogoView))
      {
        i5 += measureChildCollapseMargins(this.mLogoView, paramInt1, i5, paramInt2, 0, arrayOfInt);
        n = Math.max(n, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        m = ViewUtils.combineMeasuredStates(m, ViewCompat.getMeasuredState(this.mLogoView));
      }
      int i6 = getChildCount();
      i7 = 0;
      i8 = n;
      i9 = m;
      if (i7 >= i6)
        break label623;
      localView = getChildAt(i7);
      if (((LayoutParams)localView.getLayoutParams()).mViewType != 0)
        break label913;
      if (shouldLayout(localView))
        break label568;
      i20 = i9;
      i21 = i8;
    }
    while (true)
    {
      i7++;
      i9 = i20;
      i8 = i21;
      break label499;
      i = 1;
      j = 0;
      break;
      label568: i5 += measureChildCollapseMargins(localView, paramInt1, i5, paramInt2, 0, arrayOfInt);
      int i22 = Math.max(i8, localView.getMeasuredHeight() + getVerticalMargins(localView));
      i20 = ViewUtils.combineMeasuredStates(i9, ViewCompat.getMeasuredState(localView));
      i21 = i22;
      continue;
      label623: int i10 = this.mTitleMarginTop + this.mTitleMarginBottom;
      int i11 = this.mTitleMarginStart + this.mTitleMarginEnd;
      boolean bool3 = shouldLayout(this.mTitleTextView);
      int i12 = 0;
      int i13 = 0;
      if (bool3)
      {
        measureChildCollapseMargins(this.mTitleTextView, paramInt1, i5 + i11, paramInt2, i10, arrayOfInt);
        i13 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        i12 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        i9 = ViewUtils.combineMeasuredStates(i9, ViewCompat.getMeasuredState(this.mTitleTextView));
      }
      if (shouldLayout(this.mSubtitleTextView))
      {
        i13 = Math.max(i13, measureChildCollapseMargins(this.mSubtitleTextView, paramInt1, i5 + i11, paramInt2, i10 + i12, arrayOfInt));
        i12 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
        i9 = ViewUtils.combineMeasuredStates(i9, ViewCompat.getMeasuredState(this.mSubtitleTextView));
      }
      int i14 = i13 + i5;
      int i15 = Math.max(i8, i12);
      int i16 = i14 + (getPaddingLeft() + getPaddingRight());
      int i17 = i15 + (getPaddingTop() + getPaddingBottom());
      int i18 = ViewCompat.resolveSizeAndState(Math.max(i16, getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i9);
      int i19 = ViewCompat.resolveSizeAndState(Math.max(i17, getSuggestedMinimumHeight()), paramInt2, i9 << 16);
      if (shouldCollapse())
        i19 = 0;
      setMeasuredDimension(i18, i19);
      return;
      label913: i20 = i9;
      i21 = i8;
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.mMenuView != null);
    for (MenuBuilder localMenuBuilder = this.mMenuView.peekMenu(); ; localMenuBuilder = null)
    {
      if ((localSavedState.expandedMenuItemId != 0) && (this.mExpandedMenuPresenter != null) && (localMenuBuilder != null))
      {
        MenuItem localMenuItem = localMenuBuilder.findItem(localSavedState.expandedMenuItemId);
        if (localMenuItem != null)
          MenuItemCompat.expandActionView(localMenuItem);
      }
      if (localSavedState.isOverflowOpen)
        postShowOverflowMenu();
      return;
    }
  }

  public void onRtlPropertiesChanged(int paramInt)
  {
    int i = 1;
    if (Build.VERSION.SDK_INT >= 17)
      super.onRtlPropertiesChanged(paramInt);
    RtlSpacingHelper localRtlSpacingHelper = this.mContentInsets;
    if (paramInt == i);
    while (true)
    {
      localRtlSpacingHelper.setDirection(i);
      return;
      i = 0;
    }
  }

  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if ((this.mExpandedMenuPresenter != null) && (this.mExpandedMenuPresenter.mCurrentExpandedItem != null))
      localSavedState.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
    localSavedState.isOverflowOpen = isOverflowMenuShowing();
    return localSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i == 0)
      this.mEatingTouch = false;
    if (!this.mEatingTouch)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool))
        this.mEatingTouch = true;
    }
    if ((i == 1) || (i == 3))
      this.mEatingTouch = false;
    return true;
  }

  public void setCollapsible(boolean paramBoolean)
  {
    this.mCollapsible = paramBoolean;
    requestLayout();
  }

  public void setContentInsetsAbsolute(int paramInt1, int paramInt2)
  {
    this.mContentInsets.setAbsolute(paramInt1, paramInt2);
  }

  public void setContentInsetsRelative(int paramInt1, int paramInt2)
  {
    this.mContentInsets.setRelative(paramInt1, paramInt2);
  }

  public void setLogo(int paramInt)
  {
    setLogo(this.mTintManager.getDrawable(paramInt));
  }

  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureLogoView();
      if (this.mLogoView.getParent() == null)
      {
        addSystemView(this.mLogoView);
        updateChildVisibilityForExpandedActionView(this.mLogoView);
      }
    }
    while (true)
    {
      if (this.mLogoView != null)
        this.mLogoView.setImageDrawable(paramDrawable);
      return;
      if ((this.mLogoView == null) || (this.mLogoView.getParent() == null))
        continue;
      removeView(this.mLogoView);
    }
  }

  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }

  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
      ensureLogoView();
    if (this.mLogoView != null)
      this.mLogoView.setContentDescription(paramCharSequence);
  }

  public void setMenu(MenuBuilder paramMenuBuilder, ActionMenuPresenter paramActionMenuPresenter)
  {
    if ((paramMenuBuilder == null) && (this.mMenuView == null));
    MenuBuilder localMenuBuilder;
    do
    {
      return;
      ensureMenuView();
      localMenuBuilder = this.mMenuView.peekMenu();
    }
    while (localMenuBuilder == paramMenuBuilder);
    if (localMenuBuilder != null)
    {
      localMenuBuilder.removeMenuPresenter(this.mOuterActionMenuPresenter);
      localMenuBuilder.removeMenuPresenter(this.mExpandedMenuPresenter);
    }
    if (this.mExpandedMenuPresenter == null)
      this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(null);
    paramActionMenuPresenter.setExpandedActionViewsExclusive(true);
    if (paramMenuBuilder != null)
    {
      paramMenuBuilder.addMenuPresenter(paramActionMenuPresenter, this.mPopupContext);
      paramMenuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    }
    while (true)
    {
      this.mMenuView.setPopupTheme(this.mPopupTheme);
      this.mMenuView.setPresenter(paramActionMenuPresenter);
      this.mOuterActionMenuPresenter = paramActionMenuPresenter;
      return;
      paramActionMenuPresenter.initForMenu(this.mPopupContext, null);
      this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
      paramActionMenuPresenter.updateMenuView(true);
      this.mExpandedMenuPresenter.updateMenuView(true);
    }
  }

  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
  }

  public void setNavigationContentDescription(int paramInt)
  {
    if (paramInt != 0);
    for (CharSequence localCharSequence = getContext().getText(paramInt); ; localCharSequence = null)
    {
      setNavigationContentDescription(localCharSequence);
      return;
    }
  }

  public void setNavigationContentDescription(@Nullable CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
      ensureNavButtonView();
    if (this.mNavButtonView != null)
      this.mNavButtonView.setContentDescription(paramCharSequence);
  }

  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(this.mTintManager.getDrawable(paramInt));
  }

  public void setNavigationIcon(@Nullable Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      ensureNavButtonView();
      if (this.mNavButtonView.getParent() == null)
      {
        addSystemView(this.mNavButtonView);
        updateChildVisibilityForExpandedActionView(this.mNavButtonView);
      }
    }
    while (true)
    {
      if (this.mNavButtonView != null)
        this.mNavButtonView.setImageDrawable(paramDrawable);
      return;
      if ((this.mNavButtonView == null) || (this.mNavButtonView.getParent() == null))
        continue;
      removeView(this.mNavButtonView);
    }
  }

  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    ensureNavButtonView();
    this.mNavButtonView.setOnClickListener(paramOnClickListener);
  }

  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }

  public void setPopupTheme(int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0)
        this.mPopupContext = getContext();
    }
    else
    {
      return;
    }
    this.mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
  }

  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }

  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mSubtitleTextView == null)
      {
        Context localContext = getContext();
        this.mSubtitleTextView = new TextView(localContext);
        this.mSubtitleTextView.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mSubtitleTextAppearance != 0)
          this.mSubtitleTextView.setTextAppearance(localContext, this.mSubtitleTextAppearance);
        if (this.mSubtitleTextColor != 0)
          this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
      }
      if (this.mSubtitleTextView.getParent() == null)
      {
        addSystemView(this.mSubtitleTextView);
        updateChildVisibilityForExpandedActionView(this.mSubtitleTextView);
      }
    }
    while (true)
    {
      if (this.mSubtitleTextView != null)
        this.mSubtitleTextView.setText(paramCharSequence);
      this.mSubtitleText = paramCharSequence;
      return;
      if ((this.mSubtitleTextView == null) || (this.mSubtitleTextView.getParent() == null))
        continue;
      removeView(this.mSubtitleTextView);
    }
  }

  public void setSubtitleTextAppearance(Context paramContext, int paramInt)
  {
    this.mSubtitleTextAppearance = paramInt;
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setTextAppearance(paramContext, paramInt);
  }

  public void setSubtitleTextColor(int paramInt)
  {
    this.mSubtitleTextColor = paramInt;
    if (this.mSubtitleTextView != null)
      this.mSubtitleTextView.setTextColor(paramInt);
  }

  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mTitleTextView == null)
      {
        Context localContext = getContext();
        this.mTitleTextView = new TextView(localContext);
        this.mTitleTextView.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        if (this.mTitleTextAppearance != 0)
          this.mTitleTextView.setTextAppearance(localContext, this.mTitleTextAppearance);
        if (this.mTitleTextColor != 0)
          this.mTitleTextView.setTextColor(this.mTitleTextColor);
      }
      if (this.mTitleTextView.getParent() == null)
      {
        addSystemView(this.mTitleTextView);
        updateChildVisibilityForExpandedActionView(this.mTitleTextView);
      }
    }
    while (true)
    {
      if (this.mTitleTextView != null)
        this.mTitleTextView.setText(paramCharSequence);
      this.mTitleText = paramCharSequence;
      return;
      if ((this.mTitleTextView == null) || (this.mTitleTextView.getParent() == null))
        continue;
      removeView(this.mTitleTextView);
    }
  }

  public void setTitleTextAppearance(Context paramContext, int paramInt)
  {
    this.mTitleTextAppearance = paramInt;
    if (this.mTitleTextView != null)
      this.mTitleTextView.setTextAppearance(paramContext, paramInt);
  }

  public void setTitleTextColor(int paramInt)
  {
    this.mTitleTextColor = paramInt;
    if (this.mTitleTextView != null)
      this.mTitleTextView.setTextColor(paramInt);
  }

  public boolean showOverflowMenu()
  {
    return (this.mMenuView != null) && (this.mMenuView.showOverflowMenu());
  }

  private class ExpandedActionViewMenuPresenter
    implements MenuPresenter
  {
    MenuItemImpl mCurrentExpandedItem;
    MenuBuilder mMenu;

    private ExpandedActionViewMenuPresenter()
    {
    }

    public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      if ((Toolbar.this.mExpandedActionView instanceof CollapsibleActionView))
        ((CollapsibleActionView)Toolbar.this.mExpandedActionView).onActionViewCollapsed();
      Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
      Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
      Toolbar.this.mExpandedActionView = null;
      Toolbar.this.setChildVisibilityForExpandedActionView(false);
      this.mCurrentExpandedItem = null;
      Toolbar.this.requestLayout();
      paramMenuItemImpl.setActionViewExpanded(false);
      return true;
    }

    public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
    {
      Toolbar.this.ensureCollapseButtonView();
      if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this)
        Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
      Toolbar.this.mExpandedActionView = paramMenuItemImpl.getActionView();
      this.mCurrentExpandedItem = paramMenuItemImpl;
      if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this)
      {
        Toolbar.LayoutParams localLayoutParams = Toolbar.this.generateDefaultLayoutParams();
        localLayoutParams.gravity = (0x800003 | 0x70 & Toolbar.this.mButtonGravity);
        localLayoutParams.mViewType = 2;
        Toolbar.this.mExpandedActionView.setLayoutParams(localLayoutParams);
        Toolbar.this.addView(Toolbar.this.mExpandedActionView);
      }
      Toolbar.this.setChildVisibilityForExpandedActionView(true);
      Toolbar.this.requestLayout();
      paramMenuItemImpl.setActionViewExpanded(true);
      if ((Toolbar.this.mExpandedActionView instanceof CollapsibleActionView))
        ((CollapsibleActionView)Toolbar.this.mExpandedActionView).onActionViewExpanded();
      return true;
    }

    public boolean flagActionItems()
    {
      return false;
    }

    public int getId()
    {
      return 0;
    }

    public MenuView getMenuView(ViewGroup paramViewGroup)
    {
      return null;
    }

    public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
    {
      if ((this.mMenu != null) && (this.mCurrentExpandedItem != null))
        this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
      this.mMenu = paramMenuBuilder;
    }

    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
    }

    public void onRestoreInstanceState(Parcelable paramParcelable)
    {
    }

    public Parcelable onSaveInstanceState()
    {
      return null;
    }

    public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
    {
      return false;
    }

    public void setCallback(MenuPresenter.Callback paramCallback)
    {
    }

    public void updateMenuView(boolean paramBoolean)
    {
      int i;
      int j;
      if (this.mCurrentExpandedItem != null)
      {
        MenuBuilder localMenuBuilder = this.mMenu;
        i = 0;
        if (localMenuBuilder != null)
          j = this.mMenu.size();
      }
      for (int k = 0; ; k++)
      {
        i = 0;
        if (k < j)
        {
          if (this.mMenu.getItem(k) != this.mCurrentExpandedItem)
            continue;
          i = 1;
        }
        if (i == 0)
          collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
        return;
      }
    }
  }

  public static class LayoutParams extends ActionBar.LayoutParams
  {
    static final int CUSTOM = 0;
    static final int EXPANDED = 2;
    static final int SYSTEM = 1;
    int mViewType = 0;

    public LayoutParams(int paramInt)
    {
      this(-2, -1, paramInt);
    }

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.gravity = 8388627;
    }

    public LayoutParams(int paramInt1, int paramInt2, int paramInt3)
    {
      super(paramInt2);
      this.gravity = paramInt3;
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.mViewType = paramLayoutParams.mViewType;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }

    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      copyMarginsFromCompat(paramMarginLayoutParams);
    }

    void copyMarginsFromCompat(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }

  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }

  public static class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Toolbar.SavedState.1();
    int expandedMenuItemId;
    boolean isOverflowOpen;

    public SavedState(Parcel paramParcel)
    {
      super();
      this.expandedMenuItemId = paramParcel.readInt();
      if (paramParcel.readInt() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.isOverflowOpen = bool;
        return;
      }
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.expandedMenuItemId);
      if (this.isOverflowOpen);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeInt(i);
        return;
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.Toolbar
 * JD-Core Version:    0.6.0
 */