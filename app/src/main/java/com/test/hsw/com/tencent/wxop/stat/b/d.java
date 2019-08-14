package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.g;
import org.json.JSONObject;

public final class d
{
  static e cw;
  private static b cx = l.av();
  private static JSONObject cz = new JSONObject();
  String c = null;
  Integer cy = null;

  public d(Context paramContext)
  {
    try
    {
      u(paramContext);
      this.cy = l.F(paramContext.getApplicationContext());
      this.c = g.r(paramContext).b();
      return;
    }
    catch (Throwable localThrowable)
    {
      cx.b(localThrowable);
    }
  }

  private static e u(Context paramContext)
  {
    monitorenter;
    try
    {
      if (cw == null)
        cw = new e(paramContext.getApplicationContext(), 0);
      e locale = cw;
      return locale;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final void a(JSONObject paramJSONObject, Thread paramThread)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (cw != null)
        cw.a(localJSONObject, paramThread);
      r.a(localJSONObject, "cn", this.c);
      if (this.cy != null)
        localJSONObject.put("tn", this.cy);
      if (paramThread == null)
        paramJSONObject.put("ev", localJSONObject);
      while ((cz != null) && (cz.length() > 0))
      {
        paramJSONObject.put("eva", cz);
        return;
        paramJSONObject.put("errkv", localJSONObject.toString());
      }
    }
    catch (Throwable localThrowable)
    {
      cx.b(localThrowable);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b.d
 * JD-Core Version:    0.6.0
 */