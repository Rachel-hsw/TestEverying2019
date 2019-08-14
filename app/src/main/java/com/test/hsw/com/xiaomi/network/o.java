package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class o
  implements Comparable<o>
{
  String a;
  protected int b;
  private final LinkedList<a> c = new LinkedList();
  private long d = 0L;

  public o()
  {
    this(null, 0);
  }

  public o(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }

  public int a(o paramo)
  {
    if (paramo == null)
      return 1;
    return paramo.b - this.b;
  }

  public o a(JSONObject paramJSONObject)
  {
    monitorenter;
    try
    {
      this.d = paramJSONObject.getLong("tt");
      this.b = paramJSONObject.getInt("wt");
      this.a = paramJSONObject.getString("host");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("ah");
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        this.c.add(new a().a(localJSONObject));
      }
      return this;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public ArrayList<a> a()
  {
    monitorenter;
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.c() <= this.d)
          continue;
        localArrayList.add(locala);
      }
    }
    finally
    {
      monitorexit;
    }
    this.d = System.currentTimeMillis();
    monitorexit;
    return localArrayList;
  }

  protected void a(a parama)
  {
    monitorenter;
    if (parama != null);
    try
    {
      j.a().b();
      this.c.add(parama);
      int i = parama.a();
      if (i > 0)
        this.b += parama.a();
      while (true)
      {
        if (this.c.size() > 30)
        {
          a locala = (a)this.c.remove();
          this.b -= locala.a();
        }
        return;
        int j = -1 + this.c.size();
        int k = 0;
        for (int m = j; (m >= 0) && (((a)this.c.get(m)).a() < 0); m--)
          k++;
        this.b += i * k;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public JSONObject b()
  {
    monitorenter;
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("tt", this.d);
      localJSONObject.put("wt", this.b);
      localJSONObject.put("host", this.a);
      localJSONArray = new JSONArray();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((a)localIterator.next()).f());
    }
    finally
    {
      monitorexit;
    }
    localJSONObject.put("ah", localJSONArray);
    monitorexit;
    return localJSONObject;
  }

  public String toString()
  {
    return this.a + ":" + this.b;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.o
 * JD-Core Version:    0.6.0
 */