package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private long K = 0L;
  private int L = 0;
  private String M = "";
  private String c = "";
  private int g = 0;

  public final void a(long paramLong)
  {
    this.K = paramLong;
  }

  public final JSONObject i()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tm", this.K);
      localJSONObject.put("st", this.g);
      if (this.c != null)
        localJSONObject.put("dm", this.c);
      localJSONObject.put("pt", this.L);
      if (this.M != null)
        localJSONObject.put("rip", this.M);
      localJSONObject.put("ts", System.currentTimeMillis() / 1000L);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public final void k(String paramString)
  {
    this.M = paramString;
  }

  public final void setDomain(String paramString)
  {
    this.c = paramString;
  }

  public final void setPort(int paramInt)
  {
    this.L = paramInt;
  }

  public final void setStatusCode(int paramInt)
  {
    this.g = paramInt;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.b
 * JD-Core Version:    0.6.0
 */