package com.himamis.retex.renderer.a;

import java.util.Iterator;
import java.util.LinkedList;

public class c extends dr
{
  public LinkedList<LinkedList<d>> a = new LinkedList();
  public int b;
  public int c;

  public c()
  {
    this.a.add(new LinkedList());
    this.c = 0;
  }

  public void a()
  {
    ((LinkedList)this.a.get(this.c)).add(this.u);
    this.u = null;
  }

  public void a(int paramInt)
  {
    ((LinkedList)this.a.get(this.c)).add(this.u);
    for (int i = 1; ; i++)
    {
      if (i >= paramInt - 1)
      {
        this.u = null;
        return;
      }
      ((LinkedList)this.a.get(this.c)).add(null);
    }
  }

  public void b()
  {
    a();
    this.a.add(new LinkedList());
    this.c = (1 + this.c);
  }

  public int c()
  {
    return this.c;
  }

  public int d()
  {
    return this.b;
  }

  public eh e()
  {
    eh localeh = new eh();
    localeh.a(true);
    Iterator localIterator1 = this.a.iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
        return localeh;
      Iterator localIterator2 = ((LinkedList)localIterator1.next()).iterator();
      while (localIterator2.hasNext())
        localeh.b((d)localIterator2.next());
    }
  }

  public void f()
  {
    if (((LinkedList)this.a.getLast()).size() != 0)
    {
      b();
      this.c = (-1 + this.a.size());
      this.b = ((LinkedList)this.a.get(0)).size();
    }
    int j;
    for (int i = 1; ; i++)
    {
      if (i >= this.c)
      {
        j = 0;
        if (j < this.c)
          break label131;
        return;
        if (this.u == null)
          break;
        b();
        break;
      }
      if (((LinkedList)this.a.get(i)).size() <= this.b)
        continue;
      this.b = ((LinkedList)this.a.get(i)).size();
    }
    label131: int k = ((LinkedList)this.a.get(j)).size();
    LinkedList localLinkedList;
    if ((k != this.b) && (((LinkedList)this.a.get(j)).get(0) != null) && (((d)((LinkedList)this.a.get(j)).get(0)).c != 11))
      localLinkedList = (LinkedList)this.a.get(j);
    while (true)
    {
      if (k >= this.b)
      {
        j++;
        break;
      }
      localLinkedList.add(null);
      k++;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.c
 * JD-Core Version:    0.6.0
 */