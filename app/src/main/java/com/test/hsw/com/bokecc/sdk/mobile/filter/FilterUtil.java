package com.bokecc.sdk.mobile.filter;

import android.content.Context;
import java.io.File;

public class FilterUtil
{
  private static File ai;
  private static boolean aj = false;
  public static final String filterFileName = "ffmpeg";

  public static File getFilterFile(Context paramContext)
  {
    if (ai == null)
      ai = new File(paramContext.getFilesDir(), "ffmpeg");
    return ai;
  }

  public static boolean getFilterLogStatus()
  {
    return aj;
  }

  public static void setShowFilterLog(boolean paramBoolean)
  {
    aj = paramBoolean;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.bokecc.sdk.mobile.filter.FilterUtil
 * JD-Core Version:    0.6.0
 */