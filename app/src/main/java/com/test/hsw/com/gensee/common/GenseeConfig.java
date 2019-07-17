package com.gensee.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import com.gensee.utils.FileUtil;
import java.io.File;

public class GenseeConfig
{
  public static final long MIN_CUSTOM_USER_ID = 1000000000L;
  private static BitmapDrawable arrowDrawable;
  private static String clientAppName;
  public static boolean isUIDVerification = true;

  public static void clear()
  {
    FileUtil.deleteFile(new File(GenseeConstant.FILE_VOD_DIR));
  }

  public static String getAppName()
  {
    return clientAppName;
  }

  public static BitmapDrawable getArrowDrawable()
  {
    return arrowDrawable;
  }

  public static String getSDKVersion()
  {
    return "version:3.2";
  }

  public static String getSDKVersionInfo()
  {
    return "\n|*****************************|\n|*------  GENSEE SDK   ------*|\n|*----   Version  3.2  ------*|\n|*- EXPORT 2015-12-11 12:48 -*|\n|*--    for doc by swf  -----*|\n|*****************************|\n";
  }

  public static void initDrawable(Context paramContext, int paramInt)
  {
    arrowDrawable = (BitmapDrawable)paramContext.getResources().getDrawable(paramInt);
  }

  public static void setAppName(String paramString)
  {
    clientAppName = paramString;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.gensee.common.GenseeConfig
 * JD-Core Version:    0.6.0
 */