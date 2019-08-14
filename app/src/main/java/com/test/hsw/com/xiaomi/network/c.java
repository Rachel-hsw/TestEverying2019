package com.xiaomi.network;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class c
{
  private String a;
  private final ArrayList<b> b = new ArrayList();

  public c()
  {
  }

  public c(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("the host is empty");
    this.a = paramString;
  }

  public b a()
  {
    monitorenter;
    try
    {
      int i = -1 + this.b.size();
      b localb;
      if (i >= 0)
      {
        localb = (b)this.b.get(i);
        if (localb.a())
          f.a().e(localb.e());
      }
      while (true)
      {
        return localb;
        i--;
        break;
        localb = null;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public c a(JSONObject paramJSONObject)
  {
    monitorenter;
    try
    {
      this.a = paramJSONObject.getString("host");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("fbs");
      for (int i = 0; i < localJSONArray.length(); i++)
        this.b.add(new b(this.a).a(localJSONArray.getJSONObject(i)));
      return this;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(b paramb)
  {
    monitorenter;
    int i = 0;
    try
    {
      while (true)
      {
        if (i < this.b.size())
        {
          if (((b)this.b.get(i)).a(paramb))
            this.b.set(i, paramb);
        }
        else
        {
          if (i >= this.b.size())
            this.b.add(paramb);
          return;
        }
        i++;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void a(boolean paramBoolean)
  {
    monitorenter;
    while (true)
    {
      int i;
      try
      {
        i = -1 + this.b.size();
        if (i >= 0)
        {
          b localb = (b)this.b.get(i);
          if (!paramBoolean)
            continue;
          if (!localb.c())
            break label81;
          this.b.remove(i);
          break label81;
          if (localb.b())
            break label81;
          this.b.remove(i);
        }
      }
      finally
      {
        monitorexit;
      }
      monitorexit;
      return;
      label81: i--;
    }
  }

  public ArrayList<b> b()
  {
    return this.b;
  }

  public String c()
  {
    return this.a;
  }

  public JSONObject d()
  {
    monitorenter;
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("host", this.a);
      localJSONArray = new JSONArray();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((b)localIterator.next()).h());
    }
    finally
    {
      monitorexit;
    }
    localJSONObject.put("fbs", localJSONArray);
    monitorexit;
    return localJSONObject;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      localStringBuilder.append((b)localIterator.next());
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.c
 * JD-Core Version:    0.6.0
 */