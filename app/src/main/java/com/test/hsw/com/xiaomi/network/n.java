package com.xiaomi.network;

import com.xiaomi.a.a.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;
import org.a.c.f;

class n extends TimerTask
{
  n(j paramj)
  {
  }

  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.a)
    {
      localArrayList.addAll(j.a(this.a));
      Iterator localIterator = localArrayList.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          j.a locala = (j.a)localIterator.next();
          List localList = locala.a();
          double d = locala.b();
          if (localList == null)
            continue;
          try
          {
            if (localList.size() <= 0)
              continue;
            j.a(this.a, localList, d);
          }
          catch (f localf)
          {
            c.a("uploadHostStat exception" + localf.toString());
          }
        }
    }
    j.a(this.a, false);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.n
 * JD-Core Version:    0.6.0
 */