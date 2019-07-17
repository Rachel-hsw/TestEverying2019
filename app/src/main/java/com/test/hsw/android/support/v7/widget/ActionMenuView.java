package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v7.internal.view.menu.ActionMenuItemView;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuBuilder.Callback;
import android.support.v7.internal.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.support.v7.internal.view.menu.MenuPresenter.Callback;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.internal.widget.ViewUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  private Context mContext;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private MenuBuilder mMenu;
  private MenuBuilder.Callback mMenuBuilderCallback;
  private int mMinCellSize;
  private OnMenuItemClickListener mOnMenuItemClickListener;
  private Context mPopupContext;
  private int mPopupTheme;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;

  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mMinCellSize = (int)(56.0F * f);
    this.mGeneratedItemPadding = (int)(f * 4.0F);
    this.mPopupContext = paramContext;
    this.mPopupTheme = 0;
  }

  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    int j;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText()))
        break label182;
      j = 1;
      label54: if ((paramInt2 <= 0) || ((j != 0) && (paramInt2 < 2)))
        break label188;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, -2147483648), i);
      int m = paramView.getMeasuredWidth();
      k = m / paramInt1;
      if (m % paramInt1 != 0)
        k++;
      if ((j == 0) || (k >= 2));
    }
    label182: label188: for (int k = 2; ; k = 0)
    {
      boolean bool1 = localLayoutParams.isOverflowButton;
      boolean bool2 = false;
      if (!bool1)
      {
        bool2 = false;
        if (j != 0)
          bool2 = true;
      }
      localLayoutParams.expandable = bool2;
      localLayoutParams.cellsUsed = k;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(k * paramInt1, 1073741824), i);
      return k;
      localActionMenuItemView = null;
      break;
      j = 0;
      break label54;
    }
  }

  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int m = getPaddingLeft() + getPaddingRight();
    int n = getPaddingTop() + getPaddingBottom();
    int i1 = getChildMeasureSpec(paramInt2, n, -2);
    int i2 = j - m;
    int i3 = i2 / this.mMinCellSize;
    int i4 = i2 % this.mMinCellSize;
    if (i3 == 0)
    {
      setMeasuredDimension(i2, 0);
      return;
    }
    int i5 = this.mMinCellSize + i4 / i3;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 0;
    int i10 = 0;
    long l1 = 0L;
    int i11 = getChildCount();
    int i12 = 0;
    View localView4;
    int i41;
    long l8;
    int i43;
    int i44;
    int i42;
    int i32;
    LayoutParams localLayoutParams5;
    boolean bool2;
    label295: int i33;
    label313: int i34;
    int i35;
    while (true)
      if (i12 < i11)
      {
        localView4 = getChildAt(i12);
        if (localView4.getVisibility() == 8)
        {
          i41 = i9;
          l8 = l1;
          i43 = i6;
          i44 = i3;
          i42 = i7;
          i12++;
          i7 = i42;
          i6 = i43;
          i3 = i44;
          l1 = l8;
          i9 = i41;
          continue;
        }
        boolean bool1 = localView4 instanceof ActionMenuItemView;
        i32 = i9 + 1;
        if (bool1)
          localView4.setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
        localLayoutParams5 = (LayoutParams)localView4.getLayoutParams();
        localLayoutParams5.expanded = false;
        localLayoutParams5.extraPixels = 0;
        localLayoutParams5.cellsUsed = 0;
        localLayoutParams5.expandable = false;
        localLayoutParams5.leftMargin = 0;
        localLayoutParams5.rightMargin = 0;
        if ((!bool1) || (!((ActionMenuItemView)localView4).hasText()))
          break;
        bool2 = true;
        localLayoutParams5.preventEdgeOffset = bool2;
        if (localLayoutParams5.isOverflowButton)
        {
          i33 = 1;
          i34 = measureChildForCells(localView4, i5, i33, i1, n);
          i35 = Math.max(i7, i34);
          if (!localLayoutParams5.expandable)
            break label1328;
        }
      }
    label530: label550: label1328: for (int i36 = i8 + 1; ; i36 = i8)
    {
      if (localLayoutParams5.isOverflowButton);
      for (int i37 = 1; ; i37 = i10)
      {
        int i38 = i3 - i34;
        int i39 = localView4.getMeasuredHeight();
        int i40 = Math.max(i6, i39);
        if (i34 == 1)
        {
          long l9 = l1 | 1 << i12;
          i43 = i40;
          i44 = i38;
          i8 = i36;
          i10 = i37;
          l8 = l9;
          i42 = i35;
          i41 = i32;
          break;
          bool2 = false;
          break label295;
          i33 = i3;
          break label313;
          int i13;
          int i14;
          long l2;
          int i15;
          int i23;
          long l4;
          int i24;
          int i25;
          label493: LayoutParams localLayoutParams4;
          int i30;
          int i31;
          if ((i10 != 0) && (i9 == 2))
          {
            i13 = 1;
            i14 = 0;
            l2 = l1;
            i15 = i3;
            if ((i8 <= 0) || (i15 <= 0))
              break label1279;
            i23 = 2147483647;
            l4 = 0L;
            i24 = 0;
            i25 = 0;
            if (i25 >= i11)
              break label613;
            localLayoutParams4 = (LayoutParams)getChildAt(i25).getLayoutParams();
            if (localLayoutParams4.expandable)
              break label550;
            i30 = i24;
            i31 = i23;
          }
          while (true)
          {
            i25++;
            i23 = i31;
            i24 = i30;
            break label493;
            i13 = 0;
            break;
            if (localLayoutParams4.cellsUsed < i23)
            {
              i31 = localLayoutParams4.cellsUsed;
              l4 = 1 << i25;
              i30 = 1;
              continue;
            }
            if (localLayoutParams4.cellsUsed != i23)
              break label1268;
            l4 |= 1 << i25;
            i30 = i24 + 1;
            i31 = i23;
          }
          label613: long l5 = l2 | l4;
          long l3;
          if (i24 > i15)
            l3 = l5;
          while (true)
          {
            int i16;
            float f1;
            float f2;
            int i20;
            int i21;
            int i17;
            int i22;
            label819: int i27;
            int i28;
            long l6;
            label846: View localView3;
            LayoutParams localLayoutParams3;
            int i29;
            if ((i10 == 0) && (i9 == 1))
            {
              i16 = 1;
              if ((i15 <= 0) || (l3 == 0L))
                break label1152;
              int i19 = i9 - 1;
              if ((i15 >= i19) && (i16 == 0) && (i7 <= 1))
                break label1152;
              f1 = Long.bitCount(l3);
              if (i16 != 0)
                break label1254;
              if (((1L & l3) != 0L) && (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset))
                f1 -= 0.5F;
              if (((l3 & 1 << i11 - 1) == 0L) || (((LayoutParams)getChildAt(i11 - 1).getLayoutParams()).preventEdgeOffset))
                break label1254;
              f2 = f1 - 0.5F;
              if (f2 <= 0.0F)
                break label1002;
              i20 = (int)(i15 * i5 / f2);
              i21 = 0;
              i17 = i14;
              while (true)
              {
                if (i21 >= i11)
                  break label1156;
                if ((l3 & 1 << i21) == 0L)
                {
                  i22 = i17;
                  i21++;
                  i17 = i22;
                  continue;
                  int i26 = i23 + 1;
                  i27 = 0;
                  i28 = i15;
                  l6 = l5;
                  if (i27 < i11)
                  {
                    localView3 = getChildAt(i27);
                    localLayoutParams3 = (LayoutParams)localView3.getLayoutParams();
                    if ((l4 & 1 << i27) != 0L)
                      break;
                    if (localLayoutParams3.cellsUsed != i26)
                      break label1261;
                    l6 |= 1 << i27;
                    i29 = i28;
                  }
                }
              }
            }
            while (true)
            {
              i27++;
              i28 = i29;
              break label846;
              if ((i13 != 0) && (localLayoutParams3.preventEdgeOffset) && (i28 == 1))
                localView3.setPadding(i5 + this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
              localLayoutParams3.cellsUsed = (1 + localLayoutParams3.cellsUsed);
              localLayoutParams3.expanded = true;
              i29 = i28 - 1;
              continue;
              l2 = l6;
              i14 = 1;
              i15 = i28;
              break;
              i16 = 0;
              break label645;
              label1002: i20 = 0;
              break label788;
              View localView2 = getChildAt(i21);
              LayoutParams localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
              if ((localView2 instanceof ActionMenuItemView))
              {
                localLayoutParams2.extraPixels = i20;
                localLayoutParams2.expanded = true;
                if ((i21 == 0) && (!localLayoutParams2.preventEdgeOffset))
                  localLayoutParams2.leftMargin = (-i20 / 2);
                i22 = 1;
                break label819;
              }
              if (localLayoutParams2.isOverflowButton)
              {
                localLayoutParams2.extraPixels = i20;
                localLayoutParams2.expanded = true;
                localLayoutParams2.rightMargin = (-i20 / 2);
                i22 = 1;
                break label819;
              }
              if (i21 != 0)
                localLayoutParams2.leftMargin = (i20 / 2);
              if (i21 != i11 - 1)
                localLayoutParams2.rightMargin = (i20 / 2);
              i22 = i17;
              break label819;
              i17 = i14;
              if (i17 != 0)
              {
                int i18 = 0;
                if (i18 < i11)
                {
                  View localView1 = getChildAt(i18);
                  LayoutParams localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
                  if (!localLayoutParams1.expanded);
                  while (true)
                  {
                    i18++;
                    break;
                    localView1.measure(View.MeasureSpec.makeMeasureSpec(i5 * localLayoutParams1.cellsUsed + localLayoutParams1.extraPixels, 1073741824), i1);
                  }
                }
              }
              if (i != 1073741824);
              while (true)
              {
                setMeasuredDimension(i2, i6);
                return;
                i6 = k;
              }
              label1254: f2 = f1;
              break label769;
              label1261: i29 = i28;
            }
            label1268: i30 = i24;
            i31 = i23;
            break label530;
            label1279: l3 = l2;
          }
        }
        i41 = i32;
        i42 = i35;
        long l7 = l1;
        i43 = i40;
        i44 = i38;
        i10 = i37;
        i8 = i36;
        l8 = l7;
        break;
      }
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }

  public void dismissPopupMenus()
  {
    if (this.mPresenter != null)
      this.mPresenter.dismissPopupMenus();
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }

  protected LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }

  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }

  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams));
      for (LayoutParams localLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams); ; localLayoutParams = new LayoutParams(paramLayoutParams))
      {
        if (localLayoutParams.gravity <= 0)
          localLayoutParams.gravity = 16;
        return localLayoutParams;
      }
    }
    return generateDefaultLayoutParams();
  }

  public LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }

  public Menu getMenu()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (this.mMenu == null)
    {
      Context localContext = getContext();
      this.mMenu = new MenuBuilder(localContext);
      this.mMenu.setCallback(new MenuBuilderCallback(null));
      this.mPresenter = new ActionMenuPresenter(localContext);
      this.mPresenter.setReserveOverflow(true);
      localActionMenuPresenter = this.mPresenter;
      if (this.mActionMenuPresenterCallback == null)
        break label110;
    }
    label110: for (Object localObject = this.mActionMenuPresenterCallback; ; localObject = new ActionMenuPresenterCallback(null))
    {
      localActionMenuPresenter.setCallback((MenuPresenter.Callback)localObject);
      this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
      this.mPresenter.setMenuView(this);
      return this.mMenu;
    }
  }

  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }

  public int getWindowAnimations()
  {
    return 0;
  }

  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    if (paramInt == 0)
      return false;
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    int i = getChildCount();
    boolean bool1 = false;
    if (paramInt < i)
    {
      boolean bool2 = localView1 instanceof ActionMenuChildView;
      bool1 = false;
      if (bool2)
        bool1 = false | ((ActionMenuChildView)localView1).needsDividerAfter();
    }
    if ((paramInt > 0) && ((localView2 instanceof ActionMenuChildView)))
      return bool1 | ((ActionMenuChildView)localView2).needsDividerBefore();
    return bool1;
  }

  public boolean hideOverflowMenu()
  {
    return (this.mPresenter != null) && (this.mPresenter.hideOverflowMenu());
  }

  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }

  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }

  public boolean isOverflowMenuShowPending()
  {
    return (this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowPending());
  }

  public boolean isOverflowMenuShowing()
  {
    return (this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowing());
  }

  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8)
      super.onConfigurationChanged(paramConfiguration);
    if (this.mPresenter != null)
    {
      this.mPresenter.updateMenuView(false);
      if (this.mPresenter.isOverflowMenuShowing())
      {
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
      }
    }
  }

  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int i = getChildCount();
    int j = (paramInt4 - paramInt2) / 2;
    int k = getDividerWidth();
    int m = 0;
    int n = 0;
    int i1 = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
    int i2 = 0;
    boolean bool = ViewUtils.isLayoutRtl(this);
    int i3 = 0;
    if (i3 < i)
    {
      View localView4 = getChildAt(i3);
      int i34;
      int i32;
      int i31;
      int i33;
      if (localView4.getVisibility() == 8)
      {
        i34 = i2;
        i32 = n;
        i31 = i1;
        i33 = m;
      }
      while (true)
      {
        i3++;
        m = i33;
        i1 = i31;
        n = i32;
        i2 = i34;
        break;
        LayoutParams localLayoutParams3 = (LayoutParams)localView4.getLayoutParams();
        if (localLayoutParams3.isOverflowButton)
        {
          int i35 = localView4.getMeasuredWidth();
          if (hasSupportDividerBeforeChildAt(i3))
            i35 += k;
          int i36 = localView4.getMeasuredHeight();
          int i38;
          int i37;
          if (bool)
          {
            i38 = getPaddingLeft() + localLayoutParams3.leftMargin;
            i37 = i38 + i35;
          }
          while (true)
          {
            int i39 = j - i36 / 2;
            localView4.layout(i38, i39, i37, i36 + i39);
            i31 = i1 - i35;
            i34 = 1;
            i32 = n;
            i33 = m;
            break;
            i37 = getWidth() - getPaddingRight() - localLayoutParams3.rightMargin;
            i38 = i37 - i35;
          }
        }
        int i26 = localView4.getMeasuredWidth() + localLayoutParams3.leftMargin + localLayoutParams3.rightMargin;
        int i27 = m + i26;
        int i28 = i1 - i26;
        if (hasSupportDividerBeforeChildAt(i3))
          i27 += k;
        int i29 = n + 1;
        int i30 = i2;
        i31 = i28;
        i32 = i29;
        i33 = i27;
        i34 = i30;
      }
    }
    if ((i == 1) && (i2 == 0))
    {
      View localView3 = getChildAt(0);
      int i22 = localView3.getMeasuredWidth();
      int i23 = localView3.getMeasuredHeight();
      int i24 = (paramInt3 - paramInt1) / 2 - i22 / 2;
      int i25 = j - i23 / 2;
      localView3.layout(i24, i25, i22 + i24, i23 + i25);
      return;
    }
    int i4;
    label441: int i6;
    label460: int i7;
    int i15;
    int i16;
    label487: View localView2;
    LayoutParams localLayoutParams2;
    int i17;
    if (i2 != 0)
    {
      i4 = 0;
      int i5 = n - i4;
      if (i5 <= 0)
        break label550;
      i6 = i1 / i5;
      i7 = Math.max(0, i6);
      if (!bool)
        break label627;
      i15 = getWidth() - getPaddingRight();
      i16 = 0;
      if (i16 < i)
      {
        localView2 = getChildAt(i16);
        localLayoutParams2 = (LayoutParams)localView2.getLayoutParams();
        if (localView2.getVisibility() == 8)
          break label771;
        if (!localLayoutParams2.isOverflowButton)
          break label556;
        i17 = i15;
      }
    }
    while (true)
    {
      i16++;
      i15 = i17;
      break label487;
      break;
      i4 = 1;
      break label441;
      label550: i6 = 0;
      break label460;
      label556: int i18 = i15 - localLayoutParams2.rightMargin;
      int i19 = localView2.getMeasuredWidth();
      int i20 = localView2.getMeasuredHeight();
      int i21 = j - i20 / 2;
      localView2.layout(i18 - i19, i21, i18, i20 + i21);
      i17 = i18 - (i7 + (i19 + localLayoutParams2.leftMargin));
      continue;
      label627: int i8 = getPaddingLeft();
      int i9 = 0;
      label636: View localView1;
      LayoutParams localLayoutParams1;
      int i10;
      if (i9 < i)
      {
        localView1 = getChildAt(i9);
        localLayoutParams1 = (LayoutParams)localView1.getLayoutParams();
        if (localView1.getVisibility() == 8)
          break label764;
        if (!localLayoutParams1.isOverflowButton)
          break label693;
        i10 = i8;
      }
      while (true)
      {
        i9++;
        i8 = i10;
        break label636;
        break;
        label693: int i11 = i8 + localLayoutParams1.leftMargin;
        int i12 = localView1.getMeasuredWidth();
        int i13 = localView1.getMeasuredHeight();
        int i14 = j - i13 / 2;
        localView1.layout(i11, i14, i11 + i12, i13 + i14);
        i10 = i11 + (i7 + (i12 + localLayoutParams1.rightMargin));
        continue;
        label764: i10 = i8;
      }
      label771: i17 = i15;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool1 = this.mFormatItems;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824);
    int j;
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.mFormatItems = bool2;
      if (bool1 != this.mFormatItems)
        this.mFormatItemsWidth = 0;
      int i = View.MeasureSpec.getSize(paramInt1);
      if ((this.mFormatItems) && (this.mMenu != null) && (i != this.mFormatItemsWidth))
      {
        this.mFormatItemsWidth = i;
        this.mMenu.onItemsChanged(true);
      }
      j = getChildCount();
      if ((!this.mFormatItems) || (j <= 0))
        break;
      onMeasureExactFormat(paramInt1, paramInt2);
      return;
    }
    for (int k = 0; k < j; k++)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(k).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  public MenuBuilder peekMenu()
  {
    return this.mMenu;
  }

  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mPresenter.setExpandedActionViewsExclusive(paramBoolean);
  }

  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
  }

  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }

  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }

  public void setPopupTheme(int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0)
        this.mPopupContext = this.mContext;
    }
    else
    {
      return;
    }
    this.mPopupContext = new ContextThemeWrapper(this.mContext, paramInt);
  }

  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
    this.mPresenter.setMenuView(this);
  }

  public boolean showOverflowMenu()
  {
    return (this.mPresenter != null) && (this.mPresenter.showOverflowMenu());
  }

  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();

    public abstract boolean needsDividerBefore();
  }

  private class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private ActionMenuPresenterCallback()
    {
    }

    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
    {
    }

    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      return false;
    }
  }

  public static class LayoutParams extends LinearLayoutCompat.LayoutParams
  {

    @ViewDebug.ExportedProperty
    public int cellsUsed;

    @ViewDebug.ExportedProperty
    public boolean expandable;
    boolean expanded;

    @ViewDebug.ExportedProperty
    public int extraPixels;

    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;

    @ViewDebug.ExportedProperty
    public boolean preventEdgeOffset;

    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.isOverflowButton = false;
    }

    LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt2);
      this.isOverflowButton = paramBoolean;
    }

    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.isOverflowButton = paramLayoutParams.isOverflowButton;
    }

    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }

  private class MenuBuilderCallback
    implements MenuBuilder.Callback
  {
    private MenuBuilderCallback()
    {
    }

    public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      return (ActionMenuView.this.mOnMenuItemClickListener != null) && (ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(paramMenuItem));
    }

    public void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (ActionMenuView.this.mMenuBuilderCallback != null)
        ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(paramMenuBuilder);
    }
  }

  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * JD-Core Version:    0.6.0
 */