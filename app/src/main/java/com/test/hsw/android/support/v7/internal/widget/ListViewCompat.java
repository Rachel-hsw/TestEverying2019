package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat extends ListView
{
  public static final int INVALID_POSITION = -1;
  public static final int NO_POSITION = -1;
  private static final int[] STATE_SET_NOTHING = { 0 };
  private Field mIsChildViewEnabled;
  int mSelectionBottomPadding = 0;
  int mSelectionLeftPadding = 0;
  int mSelectionRightPadding = 0;
  int mSelectionTopPadding = 0;
  private GateKeeperDrawable mSelector;
  final Rect mSelectorRect = new Rect();

  public ListViewCompat(Context paramContext)
  {
    this(paramContext, null);
  }

  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      this.mIsChildViewEnabled = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.mIsChildViewEnabled.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    drawSelectorCompat(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }

  protected void drawSelectorCompat(Canvas paramCanvas)
  {
    if (!this.mSelectorRect.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.mSelectorRect);
        localDrawable.draw(paramCanvas);
      }
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    setSelectorEnabled(true);
    updateSelectorStateCompat();
  }

  public int lookForSelectablePosition(int paramInt, boolean paramBoolean)
  {
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter == null) || (isInTouchMode()))
      paramInt = -1;
    int i;
    do
      while (true)
      {
        return paramInt;
        i = localListAdapter.getCount();
        if (getAdapter().areAllItemsEnabled())
          break;
        if (paramBoolean)
          for (paramInt = Math.max(0, paramInt); (paramInt < i) && (!localListAdapter.isEnabled(paramInt)); paramInt++);
        for (paramInt = Math.min(paramInt, i - 1); (paramInt >= 0) && (!localListAdapter.isEnabled(paramInt)); paramInt--);
        if ((paramInt < 0) || (paramInt >= i))
          return -1;
      }
    while ((paramInt >= 0) && (paramInt < i));
    return -1;
  }

  public int measureHeightOfChildrenCompat(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int i = getListPaddingTop();
    int j = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int k = getDividerHeight();
    Drawable localDrawable = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      paramInt4 = i + j;
      return paramInt4;
    }
    int m = j + i;
    label72: int n;
    View localView1;
    int i3;
    label93: View localView2;
    label125: int i5;
    if ((k > 0) && (localDrawable != null))
    {
      n = 0;
      localView1 = null;
      int i1 = 0;
      int i2 = localListAdapter.getCount();
      i3 = 0;
      if (i3 >= i2)
        break label277;
      int i4 = localListAdapter.getItemViewType(i3);
      if (i4 == i1)
        break label280;
      localView2 = null;
      i1 = i4;
      localView1 = localListAdapter.getView(i3, localView2, this);
      ViewGroup.LayoutParams localLayoutParams = localView1.getLayoutParams();
      if ((localLayoutParams == null) || (localLayoutParams.height <= 0))
        break label241;
      i5 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
      label171: localView1.measure(paramInt1, i5);
      if (i3 <= 0)
        break label287;
    }
    label277: label280: label287: for (int i6 = m + k; ; i6 = m)
    {
      int i7 = i6 + localView1.getMeasuredHeight();
      if (i7 >= paramInt4)
      {
        if ((paramInt5 < 0) || (i3 <= paramInt5) || (n <= 0) || (i7 == paramInt4))
          break;
        return n;
        k = 0;
        break label72;
        label241: i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
        break label171;
      }
      if ((paramInt5 >= 0) && (i3 >= paramInt5))
        n = i7;
      i3++;
      m = i7;
      break label93;
      return m;
      localView2 = localView1;
      break label125;
    }
  }

  protected void positionSelectorCompat(int paramInt, View paramView)
  {
    Rect localRect = this.mSelectorRect;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    localRect.left -= this.mSelectionLeftPadding;
    localRect.top -= this.mSelectionTopPadding;
    localRect.right += this.mSelectionRightPadding;
    localRect.bottom += this.mSelectionBottomPadding;
    try
    {
      boolean bool1 = this.mIsChildViewEnabled.getBoolean(this);
      Field localField;
      if (paramView.isEnabled() != bool1)
      {
        localField = this.mIsChildViewEnabled;
        if (bool1)
          break label131;
      }
      label131: for (boolean bool2 = true; ; bool2 = false)
      {
        localField.set(this, Boolean.valueOf(bool2));
        if (paramInt != -1)
          refreshDrawableState();
        return;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }

  protected void positionSelectorLikeFocusCompat(int paramInt, View paramView)
  {
    boolean bool1 = true;
    Drawable localDrawable = getSelector();
    boolean bool2;
    float f1;
    float f2;
    if ((localDrawable != null) && (paramInt != -1))
    {
      bool2 = bool1;
      if (bool2)
        localDrawable.setVisible(false, false);
      positionSelectorCompat(paramInt, paramView);
      if (bool2)
      {
        Rect localRect = this.mSelectorRect;
        f1 = localRect.exactCenterX();
        f2 = localRect.exactCenterY();
        if (getVisibility() != 0)
          break label96;
      }
    }
    while (true)
    {
      localDrawable.setVisible(bool1, false);
      DrawableCompat.setHotspot(localDrawable, f1, f2);
      return;
      bool2 = false;
      break;
      label96: bool1 = false;
    }
  }

  protected void positionSelectorLikeTouchCompat(int paramInt, View paramView, float paramFloat1, float paramFloat2)
  {
    positionSelectorLikeFocusCompat(paramInt, paramView);
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (paramInt != -1))
      DrawableCompat.setHotspot(localDrawable, paramFloat1, paramFloat2);
  }

  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null);
    for (GateKeeperDrawable localGateKeeperDrawable = new GateKeeperDrawable(paramDrawable); ; localGateKeeperDrawable = null)
    {
      this.mSelector = localGateKeeperDrawable;
      super.setSelector(this.mSelector);
      Rect localRect = new Rect();
      if (paramDrawable != null)
        paramDrawable.getPadding(localRect);
      this.mSelectionLeftPadding = localRect.left;
      this.mSelectionTopPadding = localRect.top;
      this.mSelectionRightPadding = localRect.right;
      this.mSelectionBottomPadding = localRect.bottom;
      return;
    }
  }

  protected void setSelectorEnabled(boolean paramBoolean)
  {
    if (this.mSelector != null)
      this.mSelector.setEnabled(paramBoolean);
  }

  protected boolean shouldShowSelectorCompat()
  {
    return (touchModeDrawsInPressedStateCompat()) && (isPressed());
  }

  protected boolean touchModeDrawsInPressedStateCompat()
  {
    return false;
  }

  protected void updateSelectorStateCompat()
  {
    Drawable localDrawable = getSelector();
    if ((localDrawable != null) && (shouldShowSelectorCompat()))
      localDrawable.setState(getDrawableState());
  }

  private static class GateKeeperDrawable extends DrawableWrapper
  {
    private boolean mEnabled = true;

    public GateKeeperDrawable(Drawable paramDrawable)
    {
      super();
    }

    public void draw(Canvas paramCanvas)
    {
      if (this.mEnabled)
        super.draw(paramCanvas);
    }

    void setEnabled(boolean paramBoolean)
    {
      this.mEnabled = paramBoolean;
    }

    public void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (this.mEnabled)
        super.setHotspot(paramFloat1, paramFloat2);
    }

    public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.mEnabled)
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }

    public boolean setState(int[] paramArrayOfInt)
    {
      if (this.mEnabled)
        return super.setState(paramArrayOfInt);
      return false;
    }

    public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.mEnabled)
        return super.setVisible(paramBoolean1, paramBoolean2);
      return false;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ListViewCompat
 * JD-Core Version:    0.6.0
 */