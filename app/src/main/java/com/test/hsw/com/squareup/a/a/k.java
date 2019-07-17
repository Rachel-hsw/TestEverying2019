package com.squareup.a.a;

import com.squareup.a.ac;
import java.util.LinkedHashSet;
import java.util.Set;

public final class k
{
  private final Set<ac> a = new LinkedHashSet();

  public int a()
  {
    monitorenter;
    try
    {
      int i = this.a.size();
      monitorexit;
      return i;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void a(ac paramac)
  {
    monitorenter;
    try
    {
      this.a.add(paramac);
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

  public void b(ac paramac)
  {
    monitorenter;
    try
    {
      this.a.remove(paramac);
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

  public boolean c(ac paramac)
  {
    monitorenter;
    try
    {
      boolean bool = this.a.contains(paramac);
      monitorexit;
      return bool;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.a.k
 * JD-Core Version:    0.6.0
 */