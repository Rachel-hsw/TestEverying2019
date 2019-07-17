package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.util.Log;
import android.view.View;

@TargetApi(9)
public final class d
{
  static final String a = "OverscrollHelper";
  static final float b = 1.0F;

  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    PullToRefreshBase.b localb;
    int m;
    switch (a()[paramPullToRefreshBase.getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      i = paramPullToRefreshBase.getScrollY();
      j = paramInt3;
      k = paramInt4;
      if ((!paramPullToRefreshBase.c()) || (paramPullToRefreshBase.d()))
        break;
      localb = paramPullToRefreshBase.getMode();
      if ((localb.b()) && (!paramBoolean) && (j != 0))
      {
        m = k + j;
        Log.d("OverscrollHelper", "OverScroll. DeltaX: " + paramInt1 + ", ScrollX: " + paramInt2 + ", DeltaY: " + paramInt3 + ", ScrollY: " + paramInt4 + ", NewY: " + m + ", ScrollRange: " + paramInt5 + ", CurrentScroll: " + i);
        if (m < 0 - paramInt6)
        {
          if (!localb.c())
            break;
          if (i == 0)
            paramPullToRefreshBase.a(PullToRefreshBase.j.f, new boolean[0]);
          paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (m + i)));
        }
      }
    case 2:
    }
    label279: 
    do
    {
      do
      {
        do
        {
          return;
          i = paramPullToRefreshBase.getScrollX();
          j = paramInt1;
          k = paramInt2;
          break;
          if (m <= paramInt5 + paramInt6)
            break label279;
        }
        while (!localb.d());
        if (i == 0)
          paramPullToRefreshBase.a(PullToRefreshBase.j.f, new boolean[0]);
        paramPullToRefreshBase.setHeaderScroll((int)(paramFloat * (m + i - paramInt5)));
        return;
      }
      while ((Math.abs(m) > paramInt6) && (Math.abs(m - paramInt5) > paramInt6));
      paramPullToRefreshBase.a(PullToRefreshBase.j.a, new boolean[0]);
      return;
    }
    while ((!paramBoolean) || (PullToRefreshBase.j.f != paramPullToRefreshBase.getState()));
    paramPullToRefreshBase.a(PullToRefreshBase.j.a, new boolean[0]);
  }

  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 0, 1.0F, paramBoolean);
  }

  public static void a(PullToRefreshBase<?> paramPullToRefreshBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    a(paramPullToRefreshBase, paramInt1, paramInt2, paramInt3, paramInt4, 0, paramBoolean);
  }

  static boolean a(View paramView)
  {
    return paramView.getOverScrollMode() != 2;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.d
 * JD-Core Version:    0.6.0
 */