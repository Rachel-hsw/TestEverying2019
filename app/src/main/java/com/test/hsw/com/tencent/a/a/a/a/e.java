package com.tencent.a.a.a.a;

import android.content.Context;
import android.provider.Settings.System;
import android.util.Log;

public final class e extends f
{
  public e(Context paramContext)
  {
    super(paramContext);
  }

  protected final boolean a()
  {
    return h.a(this.e, "android.permission.WRITE_SETTINGS");
  }

  protected final String b()
  {
    monitorenter;
    try
    {
      Log.i("MID", "read mid from Settings.System");
      String str = Settings.System.getString(this.e.getContentResolver(), h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="));
      monitorexit;
      return str;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  protected final void b(String paramString)
  {
    monitorenter;
    try
    {
      Log.i("MID", "write mid to Settings.System");
      Settings.System.putString(this.e.getContentResolver(), h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.a.a.a.a.e
 * JD-Core Version:    0.6.0
 */