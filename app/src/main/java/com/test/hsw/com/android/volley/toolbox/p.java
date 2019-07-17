package com.android.volley.toolbox;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class p
  implements Runnable
{
  p(l paraml)
  {
  }

  public void run()
  {
    Iterator localIterator1 = l.b(this.a).values().iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        l.b(this.a).clear();
        l.a(this.a, null);
        return;
      }
      l.a locala = (l.a)localIterator1.next();
      Iterator localIterator2 = l.a.a(locala).iterator();
      while (localIterator2.hasNext())
      {
        l.c localc = (l.c)localIterator2.next();
        if (l.c.a(localc) == null)
          continue;
        if (locala.a() == null)
        {
          l.c.a(localc, l.a.b(locala));
          l.c.a(localc).a(localc, false);
          continue;
        }
        l.c.a(localc).a(locala.a());
      }
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.p
 * JD-Core Version:    0.6.0
 */