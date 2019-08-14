package com.withustudy.koudaizikao.g;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.withustudy.koudaizikao.d.f;

public class m
{
  public static int a(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth();
  }

  public static int b(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getHeight();
  }

  public static int c(Context paramContext)
  {
    new DisplayMetrics();
    return paramContext.getResources().getDisplayMetrics().densityDpi;
  }

  public static void d(Context paramContext)
  {
    f.a(paramContext).c(a(paramContext));
    f.a(paramContext).b(b(paramContext));
    f.a(paramContext).b(c(paramContext));
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.withustudy.koudaizikao.g.m
 * JD-Core Version:    0.6.0
 */