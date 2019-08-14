package a.a.a.e;

import a.a.a.a;
import a.a.a.d;
import a.a.a.i;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class j<T>
{
  private final a<T, ?> a;
  private final List<k> b;
  private final String c;

  j(a<T, ?> parama, String paramString)
  {
    this.a = parama;
    this.c = paramString;
    this.b = new ArrayList();
  }

  k a(String paramString, k paramk1, k paramk2, k[] paramArrayOfk)
  {
    StringBuilder localStringBuilder = new StringBuilder("(");
    ArrayList localArrayList = new ArrayList();
    a(localStringBuilder, localArrayList, paramk1);
    localStringBuilder.append(paramString);
    a(localStringBuilder, localArrayList, paramk2);
    int i = paramArrayOfk.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        localStringBuilder.append(')');
        return new k.c(localStringBuilder.toString(), localArrayList.toArray());
      }
      k localk = paramArrayOfk[j];
      localStringBuilder.append(paramString);
      a(localStringBuilder, localArrayList, localk);
    }
  }

  void a(k paramk)
  {
    if ((paramk instanceof k.b))
      a(((k.b)paramk).d);
  }

  void a(k paramk, k[] paramArrayOfk)
  {
    a(paramk);
    this.b.add(paramk);
    int i = paramArrayOfk.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      k localk = paramArrayOfk[j];
      a(localk);
      this.b.add(localk);
    }
  }

  void a(i parami)
  {
    if (this.a != null)
    {
      i[] arrayOfi = this.a.d();
      int i = arrayOfi.length;
      for (int j = 0; ; j++)
      {
        int k = 0;
        if (j >= i);
        while (true)
        {
          if (k != 0)
            return;
          throw new d("Property '" + parami.c + "' is not part of " + this.a);
          if (parami != arrayOfi[j])
            break;
          k = 1;
        }
      }
    }
  }

  void a(StringBuilder paramStringBuilder, String paramString, List<Object> paramList)
  {
    ListIterator localListIterator = this.b.listIterator();
    while (true)
    {
      if (!localListIterator.hasNext())
        return;
      if (localListIterator.hasPrevious())
        paramStringBuilder.append(" AND ");
      k localk = (k)localListIterator.next();
      localk.a(paramStringBuilder, paramString);
      localk.a(paramList);
    }
  }

  void a(StringBuilder paramStringBuilder, List<Object> paramList, k paramk)
  {
    a(paramk);
    paramk.a(paramStringBuilder, this.c);
    paramk.a(paramList);
  }

  boolean a()
  {
    return this.b.isEmpty();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     a.a.a.e.j
 * JD-Core Version:    0.6.0
 */