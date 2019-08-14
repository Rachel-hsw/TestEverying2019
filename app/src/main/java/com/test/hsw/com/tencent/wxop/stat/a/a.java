package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.f;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends d
{
  protected b bj = new b();
  private long bk = -1L;

  public a(Context paramContext, int paramInt, String paramString, f paramf)
  {
    super(paramContext, paramInt, paramf);
    this.bj.a = paramString;
  }

  public final b ab()
  {
    return this.bj;
  }

  public final e ac()
  {
    return e.bA;
  }

  public final boolean b(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ei", this.bj.a);
    if (this.bk > 0L)
      paramJSONObject.put("du", this.bk);
    Properties localProperties;
    if (this.bj.bl == null)
    {
      if (this.bj.a != null)
      {
        localProperties = com.tencent.wxop.stat.e.p(this.bj.a);
        if ((localProperties != null) && (localProperties.size() > 0))
        {
          if ((this.bj.bm != null) && (this.bj.bm.length() != 0))
            break label134;
          this.bj.bm = new JSONObject(localProperties);
        }
      }
      paramJSONObject.put("kv", this.bj.bm);
    }
    while (true)
    {
      return true;
      label134: Iterator localIterator = localProperties.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        try
        {
          this.bj.bm.put(localEntry.getKey().toString(), localEntry.getValue());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      break;
      paramJSONObject.put("ar", this.bj.bl);
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.tencent.wxop.stat.a.a
 * JD-Core Version:    0.6.0
 */