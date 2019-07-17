package com.tencent.open.b;

import com.tencent.open.utils.Global;
import com.tencent.open.utils.OpenConfig;

public class e
{
  public static int a()
  {
    int i = OpenConfig.getInstance(Global.getContext(), null).getInt("Common_HttpRetryCount");
    if (i == 0)
      i = 2;
    return i;
  }

  public static int a(String paramString)
  {
    int i = OpenConfig.getInstance(Global.getContext(), paramString).getInt("Common_BusinessReportFrequency");
    if (i == 0)
      i = 100;
    return i;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.open.b.e
 * JD-Core Version:    0.6.0
 */