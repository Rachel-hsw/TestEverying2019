package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class i extends d
{
  private com.tencent.wxop.stat.b.d bJ;
  private JSONObject bK = null;

  public i(Context paramContext, int paramInt, JSONObject paramJSONObject, f paramf)
  {
    super(paramContext, paramInt, paramf);
    this.bJ = new com.tencent.wxop.stat.b.d(paramContext);
    this.bK = paramJSONObject;
  }

  public final e ac()
  {
    return e.by;
  }

  public final boolean b(JSONObject paramJSONObject)
  {
    if (this.bp != null)
      paramJSONObject.put("ut", this.bp.as());
    if (this.bK != null)
      paramJSONObject.put("cfg", this.bK);
    if (l.P(this.bv))
      paramJSONObject.put("ncts", 1);
    this.bJ.a(paramJSONObject, null);
    return true;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.a.i
 * JD-Core Version:    0.6.0
 */