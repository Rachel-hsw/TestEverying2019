package com.squareup.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

class m
  implements Runnable
{
  m(l paraml)
  {
  }

  public void run()
  {
    ArrayList localArrayList = new ArrayList(2);
    int k;
    for (int i = 0; ; i = k)
      while (true)
      {
        synchronized (this.a)
        {
          ListIterator localListIterator1 = l.a(this.a).listIterator(l.a(this.a).size());
          if (!localListIterator1.hasPrevious())
            continue;
          k localk2 = (k)localListIterator1.previous();
          if ((localk2.f()) && (!localk2.a(l.b(this.a))))
            continue;
          localListIterator1.remove();
          localArrayList.add(localk2);
          if (localArrayList.size() != 2)
            break label267;
          ListIterator localListIterator2 = l.a(this.a).listIterator(l.a(this.a).size());
          if ((!localListIterator2.hasPrevious()) || (i <= l.c(this.a)))
            continue;
          k localk1 = (k)localListIterator2.previous();
          if (!localk1.i())
            break label261;
          localArrayList.add(localk1);
          localListIterator2.remove();
          j = i - 1;
          break label273;
          if (!localk2.i())
            break label267;
          k = i + 1;
          break;
          Iterator localIterator = localArrayList.iterator();
          if (localIterator.hasNext())
            com.squareup.a.a.l.a(((k)localIterator.next()).e());
        }
        return;
        label261: int j = i;
        break label273;
        label267: k = i;
        break;
        label273: i = j;
      }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.squareup.a.m
 * JD-Core Version:    0.6.0
 */