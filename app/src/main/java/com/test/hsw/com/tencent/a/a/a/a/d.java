package com.tencent.a.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

final class d extends f
{
  public d(Context paramContext)
  {
    super(paramContext);
  }

  protected final boolean a()
  {
    return true;
  }

  protected final String b()
  {
    monitorenter;
    try
    {
      Log.i("MID", "read mid from sharedPreferences");
      String str = PreferenceManager.getDefaultSharedPreferences(this.e).getString(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
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
      Log.i("MID", "write mid to sharedPreferences");
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.e).edit();
      localEditor.putString(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      localEditor.commit();
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
 * Qualified Name:     com.tencent.a.a.a.a.d
 * JD-Core Version:    0.6.0
 */