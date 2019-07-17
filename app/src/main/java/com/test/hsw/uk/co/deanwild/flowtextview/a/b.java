package uk.co.deanwild.flowtextview.a;

import java.util.ArrayList;
import java.util.Iterator;
import uk.co.deanwild.flowtextview.c.a;
import uk.co.deanwild.flowtextview.c.d;
import uk.co.deanwild.flowtextview.c.e;

public class b
{
  private static final ArrayList<a> a = new ArrayList();

  public static d a(float paramFloat1, int paramInt, float paramFloat2, ArrayList<e> paramArrayList)
  {
    d locald = new d();
    locald.a = 0.0F;
    locald.b = paramFloat2;
    float f = paramFloat1 - paramInt;
    a.clear();
    Iterator localIterator1 = paramArrayList.iterator();
    Iterator localIterator4;
    Object localObject;
    if (!localIterator1.hasNext())
      if (a.size() > 0)
      {
        localIterator4 = a.iterator();
        localObject = null;
      }
    while (true)
    {
      if (!localIterator4.hasNext())
      {
        locald.a = localObject.a;
        locald.b = localObject.b;
        return locald;
        e locale1 = (e)localIterator1.next();
        if ((locale1.b > paramFloat1) || (locale1.d < f))
          break;
        a locala1 = new a();
        locala1.a = 0.0F;
        Iterator localIterator2 = paramArrayList.iterator();
        label158: a locala2;
        Iterator localIterator3;
        if (!localIterator2.hasNext())
        {
          locala1.b = locale1.a;
          locala1.c = (locala1.b - locala1.a);
          locala2 = new a();
          locala2.a = locale1.c;
          locala2.b = paramFloat2;
          localIterator3 = paramArrayList.iterator();
        }
        while (true)
        {
          if (!localIterator3.hasNext())
          {
            locala2.c = (locala2.b - locala2.a);
            a.add(locala1);
            a.add(locala2);
            break;
            e locale2 = (e)localIterator2.next();
            if ((locale2.b > paramFloat1) || (locale2.d < f) || (locale2.a >= locale1.a))
              break label158;
            locala1.a = locale2.c;
            break label158;
          }
          e locale3 = (e)localIterator3.next();
          if ((locale3.b > paramFloat1) || (locale3.d < f) || (locale3.c <= locale1.c))
            continue;
          locala2.b = locale3.a;
        }
      }
      a locala3 = (a)localIterator4.next();
      if (localObject == null)
      {
        localObject = locala3;
        continue;
      }
      if (locala3.c <= localObject.c)
        continue;
      localObject = locala3;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     uk.co.deanwild.flowtextview.a.b
 * JD-Core Version:    0.6.0
 */