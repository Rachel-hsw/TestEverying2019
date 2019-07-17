package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Map;

class m extends b
{
  b i = this.j;

  m(f paramf, String paramString, b paramb)
  {
    super(paramString);
    if (this.j != null)
      this.f = this.j.f;
  }

  public ArrayList<String> a(boolean paramBoolean)
  {
    monitorenter;
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      if (this.i != null)
        localArrayList1.addAll(this.i.a(true));
      synchronized (f.b)
      {
        ArrayList localArrayList2 = (ArrayList)f.b.get(this.b);
        if (localArrayList2 != null)
          localArrayList1.addAll(localArrayList2);
        monitorexit;
        return localArrayList1;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }

  public void a(String paramString, a parama)
  {
    monitorenter;
    try
    {
      if (this.i != null)
        this.i.a(paramString, parama);
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

  public boolean b()
  {
    return false;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.m
 * JD-Core Version:    0.6.0
 */