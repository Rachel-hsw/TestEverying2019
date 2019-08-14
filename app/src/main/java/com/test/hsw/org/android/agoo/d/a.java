package org.android.agoo.d;

import android.content.Context;
import android.util.Log;

public class a
{
  private static final String a = "ProxyFactroy";

  public static final <T> T a(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = a(paramContext, paramString, null);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.w("ProxyFactroy", "instance_update", localThrowable);
    }
    return null;
  }

  private static <T> T a(Context paramContext, String paramString, T paramT)
  {
    try
    {
      Log.v("ProxyFactroy", "getInstance[base] successfully");
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.w("ProxyFactroy", "instance_base", localThrowable);
    }
    return paramT;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.android.agoo.d.a
 * JD-Core Version:    0.6.0
 */