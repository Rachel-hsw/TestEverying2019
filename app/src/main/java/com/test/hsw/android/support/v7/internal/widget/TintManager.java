package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.LruCache;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.drawable;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class TintManager
{
  private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
  private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
  private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
  private static final ColorFilterLruCache COLOR_FILTER_CACHE;
  private static final boolean DEBUG = false;
  private static final PorterDuff.Mode DEFAULT_MODE;
  private static final WeakHashMap<Context, TintManager> INSTANCE_CACHE;
  public static final boolean SHOULD_BE_USED = false;
  private static final String TAG = "TintManager";
  private static final int[] TINT_CHECKABLE_BUTTON_LIST;
  private static final int[] TINT_COLOR_CONTROL_NORMAL;
  private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
  private final WeakReference<Context> mContextRef;
  private ColorStateList mDefaultColorStateList;
  private SparseArray<ColorStateList> mTintLists;

  static
  {
    if (Build.VERSION.SDK_INT < 21);
    for (boolean bool = true; ; bool = false)
    {
      SHOULD_BE_USED = bool;
      DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
      INSTANCE_CACHE = new WeakHashMap();
      COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
      int[] arrayOfInt1 = new int[3];
      arrayOfInt1[0] = R.drawable.abc_textfield_search_default_mtrl_alpha;
      arrayOfInt1[1] = R.drawable.abc_textfield_default_mtrl_alpha;
      arrayOfInt1[2] = R.drawable.abc_ab_share_pack_mtrl_alpha;
      COLORFILTER_TINT_COLOR_CONTROL_NORMAL = arrayOfInt1;
      int[] arrayOfInt2 = new int[12];
      arrayOfInt2[0] = R.drawable.abc_ic_ab_back_mtrl_am_alpha;
      arrayOfInt2[1] = R.drawable.abc_ic_go_search_api_mtrl_alpha;
      arrayOfInt2[2] = R.drawable.abc_ic_search_api_mtrl_alpha;
      arrayOfInt2[3] = R.drawable.abc_ic_commit_search_api_mtrl_alpha;
      arrayOfInt2[4] = R.drawable.abc_ic_clear_mtrl_alpha;
      arrayOfInt2[5] = R.drawable.abc_ic_menu_share_mtrl_alpha;
      arrayOfInt2[6] = R.drawable.abc_ic_menu_copy_mtrl_am_alpha;
      arrayOfInt2[7] = R.drawable.abc_ic_menu_cut_mtrl_alpha;
      arrayOfInt2[8] = R.drawable.abc_ic_menu_selectall_mtrl_alpha;
      arrayOfInt2[9] = R.drawable.abc_ic_menu_paste_mtrl_am_alpha;
      arrayOfInt2[10] = R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha;
      arrayOfInt2[11] = R.drawable.abc_ic_voice_search_api_mtrl_alpha;
      TINT_COLOR_CONTROL_NORMAL = arrayOfInt2;
      int[] arrayOfInt3 = new int[4];
      arrayOfInt3[0] = R.drawable.abc_textfield_activated_mtrl_alpha;
      arrayOfInt3[1] = R.drawable.abc_textfield_search_activated_mtrl_alpha;
      arrayOfInt3[2] = R.drawable.abc_cab_background_top_mtrl_alpha;
      arrayOfInt3[3] = R.drawable.abc_text_cursor_mtrl_alpha;
      COLORFILTER_COLOR_CONTROL_ACTIVATED = arrayOfInt3;
      int[] arrayOfInt4 = new int[3];
      arrayOfInt4[0] = R.drawable.abc_popup_background_mtrl_mult;
      arrayOfInt4[1] = R.drawable.abc_cab_background_internal_bg;
      arrayOfInt4[2] = R.drawable.abc_menu_hardkey_panel_mtrl_mult;
      COLORFILTER_COLOR_BACKGROUND_MULTIPLY = arrayOfInt4;
      int[] arrayOfInt5 = new int[10];
      arrayOfInt5[0] = R.drawable.abc_edit_text_material;
      arrayOfInt5[1] = R.drawable.abc_tab_indicator_material;
      arrayOfInt5[2] = R.drawable.abc_textfield_search_material;
      arrayOfInt5[3] = R.drawable.abc_spinner_mtrl_am_alpha;
      arrayOfInt5[4] = R.drawable.abc_spinner_textfield_background_material;
      arrayOfInt5[5] = R.drawable.abc_ratingbar_full_material;
      arrayOfInt5[6] = R.drawable.abc_switch_track_mtrl_alpha;
      arrayOfInt5[7] = R.drawable.abc_switch_thumb_material;
      arrayOfInt5[8] = R.drawable.abc_btn_default_mtrl_shape;
      arrayOfInt5[9] = R.drawable.abc_btn_borderless_material;
      TINT_COLOR_CONTROL_STATE_LIST = arrayOfInt5;
      int[] arrayOfInt6 = new int[2];
      arrayOfInt6[0] = R.drawable.abc_btn_check_material;
      arrayOfInt6[1] = R.drawable.abc_btn_radio_material;
      TINT_CHECKABLE_BUTTON_LIST = arrayOfInt6;
      return;
    }
  }

  private TintManager(Context paramContext)
  {
    this.mContextRef = new WeakReference(paramContext);
  }

  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (paramArrayOfInt[j] != paramInt)
          continue;
        k = 1;
      }
      return k;
    }
  }

  private ColorStateList createButtonColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[4][];
    int[] arrayOfInt1 = new int[4];
    int i = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    int j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlHighlight);
    arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
    arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorButtonNormal);
    arrayOfInt[1] = ThemeUtils.PRESSED_STATE_SET;
    arrayOfInt1[1] = ColorUtils.compositeColors(j, i);
    arrayOfInt[2] = ThemeUtils.FOCUSED_STATE_SET;
    arrayOfInt1[2] = ColorUtils.compositeColors(j, i);
    arrayOfInt[3] = ThemeUtils.EMPTY_STATE_SET;
    arrayOfInt1[3] = i;
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private ColorStateList createCheckableButtonColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
    arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
    arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
    arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
    arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
    arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private ColorStateList createEditTextColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
    arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
    arrayOfInt[1] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
    arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
    arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
    arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private ColorStateList createSpinnerColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
    arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
    arrayOfInt[1] = ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET;
    arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
    arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
    arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  private ColorStateList createSwitchThumbColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    ColorStateList localColorStateList = ThemeUtils.getThemeAttrColorStateList(paramContext, R.attr.colorSwitchThumbNormal);
    if ((localColorStateList != null) && (localColorStateList.isStateful()))
    {
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = localColorStateList.getColorForState(arrayOfInt[0], 0);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = localColorStateList.getDefaultColor();
    }
    while (true)
    {
      return new ColorStateList(arrayOfInt, arrayOfInt1);
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
      arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorSwitchThumbNormal);
    }
  }

  private ColorStateList createSwitchTrackColorStateList(Context paramContext)
  {
    int[][] arrayOfInt = new int[3][];
    int[] arrayOfInt1 = new int[3];
    arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
    arrayOfInt1[0] = ThemeUtils.getThemeAttrColor(paramContext, 16842800, 0.1F);
    arrayOfInt[1] = ThemeUtils.CHECKED_STATE_SET;
    arrayOfInt1[1] = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated, 0.3F);
    arrayOfInt[2] = ThemeUtils.EMPTY_STATE_SET;
    arrayOfInt1[2] = ThemeUtils.getThemeAttrColor(paramContext, 16842800, 0.3F);
    return new ColorStateList(arrayOfInt, arrayOfInt1);
  }

  public static TintManager get(Context paramContext)
  {
    TintManager localTintManager = (TintManager)INSTANCE_CACHE.get(paramContext);
    if (localTintManager == null)
    {
      localTintManager = new TintManager(paramContext);
      INSTANCE_CACHE.put(paramContext, localTintManager);
    }
    return localTintManager;
  }

  private ColorStateList getDefaultColorStateList(Context paramContext)
  {
    if (this.mDefaultColorStateList == null)
    {
      int i = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlNormal);
      int j = ThemeUtils.getThemeAttrColor(paramContext, R.attr.colorControlActivated);
      int[][] arrayOfInt = new int[7][];
      int[] arrayOfInt1 = new int[7];
      arrayOfInt[0] = ThemeUtils.DISABLED_STATE_SET;
      arrayOfInt1[0] = ThemeUtils.getDisabledThemeAttrColor(paramContext, R.attr.colorControlNormal);
      arrayOfInt[1] = ThemeUtils.FOCUSED_STATE_SET;
      arrayOfInt1[1] = j;
      arrayOfInt[2] = ThemeUtils.ACTIVATED_STATE_SET;
      arrayOfInt1[2] = j;
      arrayOfInt[3] = ThemeUtils.PRESSED_STATE_SET;
      arrayOfInt1[3] = j;
      arrayOfInt[4] = ThemeUtils.CHECKED_STATE_SET;
      arrayOfInt1[4] = j;
      arrayOfInt[5] = ThemeUtils.SELECTED_STATE_SET;
      arrayOfInt1[5] = j;
      arrayOfInt[6] = ThemeUtils.EMPTY_STATE_SET;
      arrayOfInt1[6] = i;
      this.mDefaultColorStateList = new ColorStateList(arrayOfInt, arrayOfInt1);
    }
    return this.mDefaultColorStateList;
  }

  public static Drawable getDrawable(Context paramContext, int paramInt)
  {
    if (isInTintList(paramInt))
      return get(paramContext).getDrawable(paramInt);
    return ContextCompat.getDrawable(paramContext, paramInt);
  }

  private static boolean isInTintList(int paramInt)
  {
    return (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt)) || (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt)) || (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt)) || (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt)) || (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt)) || (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt)) || (paramInt == R.drawable.abc_cab_background_top_material);
  }

  private static void setPorterDuffColorFilter(Drawable paramDrawable, int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramMode == null)
      paramMode = DEFAULT_MODE;
    PorterDuffColorFilter localPorterDuffColorFilter = COLOR_FILTER_CACHE.get(paramInt, paramMode);
    if (localPorterDuffColorFilter == null)
    {
      localPorterDuffColorFilter = new PorterDuffColorFilter(paramInt, paramMode);
      COLOR_FILTER_CACHE.put(paramInt, paramMode, localPorterDuffColorFilter);
    }
    paramDrawable.setColorFilter(localPorterDuffColorFilter);
  }

  public static void tintViewBackground(View paramView, TintInfo paramTintInfo)
  {
    Drawable localDrawable = paramView.getBackground();
    PorterDuff.Mode localMode;
    if (paramTintInfo.mHasTintList)
    {
      int i = paramTintInfo.mTintList.getColorForState(paramView.getDrawableState(), paramTintInfo.mTintList.getDefaultColor());
      if (paramTintInfo.mHasTintMode)
      {
        localMode = paramTintInfo.mTintMode;
        setPorterDuffColorFilter(localDrawable, i, localMode);
      }
    }
    while (true)
    {
      if (Build.VERSION.SDK_INT <= 10)
        paramView.invalidate();
      return;
      localMode = null;
      break;
      localDrawable.clearColorFilter();
    }
  }

  public Drawable getDrawable(int paramInt)
  {
    return getDrawable(paramInt, false);
  }

  public Drawable getDrawable(int paramInt, boolean paramBoolean)
  {
    Context localContext = (Context)this.mContextRef.get();
    if (localContext == null)
      return null;
    Drawable localDrawable = ContextCompat.getDrawable(localContext, paramInt);
    if (localDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 8)
        localDrawable = localDrawable.mutate();
      ColorStateList localColorStateList = getTintList(paramInt);
      if (localColorStateList == null)
        break label92;
      localDrawable = DrawableCompat.wrap(localDrawable);
      DrawableCompat.setTintList(localDrawable, localColorStateList);
      PorterDuff.Mode localMode = getTintMode(paramInt);
      if (localMode != null)
        DrawableCompat.setTintMode(localDrawable, localMode);
    }
    while (true)
    {
      return localDrawable;
      label92: if (paramInt == R.drawable.abc_cab_background_top_material)
      {
        Drawable[] arrayOfDrawable = new Drawable[2];
        arrayOfDrawable[0] = getDrawable(R.drawable.abc_cab_background_internal_bg);
        arrayOfDrawable[1] = getDrawable(R.drawable.abc_cab_background_top_mtrl_alpha);
        return new LayerDrawable(arrayOfDrawable);
      }
      if ((tintDrawableUsingColorFilter(paramInt, localDrawable)) || (!paramBoolean))
        continue;
      localDrawable = null;
    }
  }

  public final ColorStateList getTintList(int paramInt)
  {
    Context localContext = (Context)this.mContextRef.get();
    Object localObject;
    if (localContext == null)
      localObject = null;
    ColorStateList localColorStateList;
    while (true)
    {
      return localObject;
      SparseArray localSparseArray = this.mTintLists;
      localColorStateList = null;
      if (localSparseArray != null)
        localColorStateList = (ColorStateList)this.mTintLists.get(paramInt);
      if (localColorStateList != null)
        break;
      if (paramInt == R.drawable.abc_edit_text_material)
        localObject = createEditTextColorStateList(localContext);
      while (localObject != null)
      {
        if (this.mTintLists == null)
          this.mTintLists = new SparseArray();
        this.mTintLists.append(paramInt, localObject);
        return localObject;
        if (paramInt == R.drawable.abc_switch_track_mtrl_alpha)
        {
          localObject = createSwitchTrackColorStateList(localContext);
          continue;
        }
        if (paramInt == R.drawable.abc_switch_thumb_material)
        {
          localObject = createSwitchThumbColorStateList(localContext);
          continue;
        }
        if ((paramInt == R.drawable.abc_btn_default_mtrl_shape) || (paramInt == R.drawable.abc_btn_borderless_material))
        {
          localObject = createButtonColorStateList(localContext);
          continue;
        }
        if ((paramInt == R.drawable.abc_spinner_mtrl_am_alpha) || (paramInt == R.drawable.abc_spinner_textfield_background_material))
        {
          localObject = createSpinnerColorStateList(localContext);
          continue;
        }
        if (arrayContains(TINT_COLOR_CONTROL_NORMAL, paramInt))
        {
          localObject = ThemeUtils.getThemeAttrColorStateList(localContext, R.attr.colorControlNormal);
          continue;
        }
        if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, paramInt))
        {
          localObject = getDefaultColorStateList(localContext);
          continue;
        }
        if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, paramInt))
        {
          localObject = createCheckableButtonColorStateList(localContext);
          continue;
        }
        localObject = localColorStateList;
      }
    }
    return (ColorStateList)localColorStateList;
  }

  final PorterDuff.Mode getTintMode(int paramInt)
  {
    int i = R.drawable.abc_switch_thumb_material;
    PorterDuff.Mode localMode = null;
    if (paramInt == i)
      localMode = PorterDuff.Mode.MULTIPLY;
    return localMode;
  }

  public final boolean tintDrawableUsingColorFilter(int paramInt, Drawable paramDrawable)
  {
    Context localContext = (Context)this.mContextRef.get();
    if (localContext == null)
      return false;
    int j;
    Object localObject;
    int k;
    int i;
    if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, paramInt))
    {
      j = R.attr.colorControlNormal;
      localObject = null;
      k = 1;
      i = -1;
    }
    while (true)
    {
      if (k != 0)
      {
        setPorterDuffColorFilter(paramDrawable, ThemeUtils.getThemeAttrColor(localContext, j), (PorterDuff.Mode)localObject);
        if (i != -1)
          paramDrawable.setAlpha(i);
        return true;
        if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, paramInt))
        {
          j = R.attr.colorControlActivated;
          k = 1;
          i = -1;
          localObject = null;
          continue;
        }
        if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, paramInt))
        {
          PorterDuff.Mode localMode = PorterDuff.Mode.MULTIPLY;
          k = 1;
          localObject = localMode;
          j = 16842801;
          i = -1;
          continue;
        }
        if (paramInt == R.drawable.abc_list_divider_mtrl_alpha)
        {
          j = 16842800;
          i = Math.round(40.799999F);
          k = 1;
          localObject = null;
          continue;
        }
      }
      else
      {
        return false;
      }
      i = -1;
      j = 0;
      k = 0;
      localObject = null;
    }
  }

  private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter>
  {
    public ColorFilterLruCache(int paramInt)
    {
      super();
    }

    private static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
    {
      return 31 * (paramInt + 31) + paramMode.hashCode();
    }

    PorterDuffColorFilter get(int paramInt, PorterDuff.Mode paramMode)
    {
      return (PorterDuffColorFilter)get(Integer.valueOf(generateCacheKey(paramInt, paramMode)));
    }

    PorterDuffColorFilter put(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
    {
      return (PorterDuffColorFilter)put(Integer.valueOf(generateCacheKey(paramInt, paramMode)), paramPorterDuffColorFilter);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintManager
 * JD-Core Version:    0.6.0
 */