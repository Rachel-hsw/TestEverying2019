package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.b.a.h;

public class UTDevice
{
  public static String getUtdid(Context paramContext)
  {
    a locala = b.a(paramContext);
    if ((locala == null) || (h.a(locala.e())))
      return "ffffffffffffffffffffffff";
    return locala.e();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.ta.utdid2.device.UTDevice
 * JD-Core Version:    0.6.0
 */