package com.himamis.retex.renderer.a;

import com.himamis.retex.renderer.a.d.a;
import java.util.LinkedList;
import java.util.ListIterator;

public class cl extends d
  implements ck
{
  private static g g = new g();
  private static g h;
  protected LinkedList<d> a = new LinkedList();
  public boolean b = false;
  private z f = null;

  static
  {
    g.a(2);
    g.a(1);
    g.a(3);
    g.a(4);
    g.a(6);
    h = new g();
    h.a(0);
    h.a(1);
    h.a(2);
    h.a(3);
    h.a(4);
    h.a(5);
    h.a(6);
  }

  protected cl()
  {
  }

  public cl(d paramd)
  {
    if (paramd != null)
    {
      if ((paramd instanceof cl))
        this.a.addAll(((cl)paramd).a);
    }
    else
      return;
    this.a.add(paramd);
  }

  private void a(z paramz1, z paramz2, d paramd)
  {
    if ((paramz1.b() == 2) && ((paramz2 == null) || (g.b(paramz2.c())) || (paramd == null)))
      paramz1.a(0);
    int i;
    do
    {
      do
        return;
      while ((paramd == null) || (paramz1.c() != 2));
      i = paramd.a();
    }
    while ((i != 3) && (i != 5) && (i != 6));
    paramz1.a(0);
  }

  public int a()
  {
    if (this.a.size() == 0)
      return 0;
    return ((d)this.a.get(0)).a();
  }

  public i a(dp paramdp)
  {
    dq localdq = paramdp.m();
    at localat = new at(paramdp.h(), paramdp.g());
    paramdp.o();
    ListIterator localListIterator = this.a.listIterator();
    int i = 0;
    int j;
    Object localObject;
    int k;
    int n;
    label91: d locald4;
    label185: z localz;
    d locald2;
    label226: label238: int i1;
    float f1;
    while (true)
    {
      if (!localListIterator.hasNext())
      {
        this.f = null;
        return localat;
      }
      d locald1 = (d)localListIterator.next();
      j = i + 1;
      localObject = locald1;
      k = 0;
      if (!(localObject instanceof k))
      {
        n = k;
        if (((localObject instanceof a)) && (((a)localObject).e()))
        {
          locald4 = ((a)localObject).f();
          if (!(locald4 instanceof cl))
            break;
          this.a.remove(j - 1);
          this.a.addAll(j - 1, ((cl)locald4).a);
          localListIterator = this.a.listIterator(j - 1);
          localObject = (d)localListIterator.next();
        }
        else
        {
          localz = new z((d)localObject);
          if (!localListIterator.hasNext())
            break label647;
          locald2 = (d)localListIterator.next();
          localListIterator.previous();
          a(localz, this.f, locald2);
          if ((localListIterator.hasNext()) && (localz.c() == 0) && (localz.d()))
            break label495;
          i1 = j;
          f1 = 0.0F;
          label271: if ((localListIterator.previousIndex() != 0) && (this.f != null) && (!this.f.f()) && (!localz.f()))
            localat.a(am.a(this.f.c(), localz.b(), paramdp));
          localz.a(this.f);
          i locali = localz.a(paramdp);
          if ((n != 0) || (((localObject instanceof n)) && (Character.isDigit(((n)localObject).d()))))
            localat.a(localat.k.size());
          localat.a(locali);
          paramdp.b(locali.h());
          if (Math.abs(f1) > 1.0E-007F)
            localat.a(new dk(f1, 0.0F, 0.0F, 0.0F));
          if (!localz.f())
            this.f = localz;
          i = i1;
          continue;
        }
      }
      else
      {
        if (k != 0)
          break label660;
      }
    }
    label647: label660: for (int m = 1; ; m = k)
    {
      if (localListIterator.hasNext())
      {
        d locald5 = (d)localListIterator.next();
        j++;
        localObject = locald5;
        k = m;
        break;
        localObject = locald4;
        break label185;
        label495: d locald3 = (d)localListIterator.next();
        j++;
        if (((locald3 instanceof q)) && (h.b(locald3.a())))
        {
          localz.e();
          p localp1 = localz.a(localdq);
          p localp2 = ((q)locald3).a(localdq);
          p localp3 = localdq.a(localp1, localp2);
          if (localp3 == null)
          {
            float f2 = localdq.a(localp1, localp2, paramdp.j());
            localListIterator.previous();
            i1 = j - 1;
            f1 = f2;
            break label271;
          }
          localz.a(new ag(localp3));
          break label238;
        }
        localListIterator.previous();
        i1 = j - 1;
        f1 = 0.0F;
        break label271;
        locald2 = null;
        break label226;
      }
      n = m;
      break label91;
    }
  }

  public final void a(d paramd)
  {
    if (paramd != null)
      this.a.add(paramd);
  }

  public void a(z paramz)
  {
    this.f = paramz;
  }

  public int b()
  {
    if (this.a.size() == 0)
      return 0;
    return ((d)this.a.get(-1 + this.a.size())).b();
  }

  public d d()
  {
    if (this.a.size() != 0)
      return (d)this.a.removeLast();
    return new cu(3, 0.0F, 0.0F, 0.0F);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     com.himamis.retex.renderer.a.cl
 * JD-Core Version:    0.6.0
 */