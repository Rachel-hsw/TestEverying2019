package com.xiaomi.network;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

class k
  implements j.a
{
  k(f paramf)
  {
  }

  public List<com.xiaomi.b.a.a.a.b> a()
  {
    try
    {
      ArrayList localArrayList = this.a.j();
      return localArrayList;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public double b()
  {
    b localb = this.a.b("f3.mi-stat.gslb.mi-idc.com");
    double d = 0.1D;
    if (localb != null)
      d = localb.g();
    return d;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.k
 * JD-Core Version:    0.6.0
 */