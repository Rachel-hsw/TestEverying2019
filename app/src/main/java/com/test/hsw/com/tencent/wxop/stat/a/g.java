package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class g extends d
{
  private static String a = null;
  private String aR = null;
  private String aS = null;

  public g(Context paramContext, int paramInt, f paramf)
  {
    super(paramContext, paramInt, paramf);
    this.aR = com.tencent.wxop.stat.g.r(paramContext).b();
    if (a == null)
      a = l.C(paramContext);
  }

  public final e ac()
  {
    return e.bE;
  }

  public final void b(String paramString)
  {
    this.aS = paramString;
  }

  public final boolean b(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "op", a);
    r.a(paramJSONObject, "cn", this.aR);
    paramJSONObject.put("sp", this.aS);
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.a.g
 * JD-Core Version:    0.6.0
 */