package com.xiaomi.a.a.f;

import java.util.LinkedList;

public class a
{
  private LinkedList<a> a = new LinkedList();

  public static a a()
  {
    return a.a();
  }

  private void d()
  {
    if (this.a.size() > 100)
      this.a.removeFirst();
  }

  public void a(Object paramObject)
  {
    monitorenter;
    try
    {
      this.a.add(new a(0, paramObject));
      d();
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

  public int b()
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

  public LinkedList<a> c()
  {
    monitorenter;
    try
    {
      LinkedList localLinkedList = this.a;
      this.a = new LinkedList();
      monitorexit;
      return localLinkedList;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public static class a
  {
    private static final a d = new a();
    public int a;
    public String b;
    public Object c;

    a(int paramInt, Object paramObject)
    {
      this.a = paramInt;
      this.c = paramObject;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.a.a.f.a
 * JD-Core Version:    0.6.0
 */