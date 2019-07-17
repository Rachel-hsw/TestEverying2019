package com.ut.device;

import android.content.Context;
import com.ta.utdid2.a.a;

public class UTDevice
{
  public static String getAid(String paramString1, String paramString2, Context paramContext)
  {
    return a.a(paramContext).a(paramString1, paramString2, getUtdid(paramContext));
  }

  public static void getAidAsync(String paramString1, String paramString2, Context paramContext, AidCallback paramAidCallback)
  {
    a.a(paramContext).a(paramString1, paramString2, getUtdid(paramContext), paramAidCallback);
  }

  public static String getUtdid(Context paramContext)
  {
    return com.ta.utdid2.device.UTDevice.getUtdid(paramContext);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ut.device.UTDevice
 * JD-Core Version:    0.6.0
 */