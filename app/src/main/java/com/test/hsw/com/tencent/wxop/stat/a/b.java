package com.tencent.wxop.stat.a;

import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public String a;
  public JSONArray bl;
  public JSONObject bm = null;

  public b()
  {
  }

  public b(String paramString)
  {
    this.a = paramString;
    this.bm = new JSONObject();
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == null);
    do
    {
      return false;
      if (this == paramObject)
        return true;
    }
    while (!(paramObject instanceof b));
    b localb = (b)paramObject;
    return toString().equals(localb.toString());
  }

  public final int hashCode()
  {
    return toString().hashCode();
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(this.a).append(",");
    if (this.bl != null)
      localStringBuilder.append(this.bl.toString());
    if (this.bm != null)
      localStringBuilder.append(this.bm.toString());
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.a.b
 * JD-Core Version:    0.6.0
 */