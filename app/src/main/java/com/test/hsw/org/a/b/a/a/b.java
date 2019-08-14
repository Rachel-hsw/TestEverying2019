package org.a.b.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class b
  implements Iterable<f>
{
  private final List<f> a = new LinkedList();
  private final Map<String, List<f>> b = new HashMap();

  public List<f> a()
  {
    return new ArrayList(this.a);
  }

  public f a(String paramString)
  {
    if (paramString == null)
      return null;
    String str = paramString.toLowerCase(Locale.US);
    List localList = (List)this.b.get(str);
    if ((localList != null) && (!localList.isEmpty()))
      return (f)localList.get(0);
    return null;
  }

  public void a(f paramf)
  {
    if (paramf == null)
      return;
    String str = paramf.a().toLowerCase(Locale.US);
    Object localObject = (List)this.b.get(str);
    if (localObject == null)
    {
      localObject = new LinkedList();
      this.b.put(str, localObject);
    }
    ((List)localObject).add(paramf);
    this.a.add(paramf);
  }

  public List<f> b(String paramString)
  {
    if (paramString == null)
      return null;
    String str = paramString.toLowerCase(Locale.US);
    List localList = (List)this.b.get(str);
    if ((localList == null) || (localList.isEmpty()))
      return Collections.emptyList();
    return new ArrayList(localList);
  }

  public void b(f paramf)
  {
    if (paramf == null)
      return;
    String str = paramf.a().toLowerCase(Locale.US);
    List localList = (List)this.b.get(str);
    if ((localList == null) || (localList.isEmpty()))
    {
      a(paramf);
      return;
    }
    localList.clear();
    localList.add(paramf);
    Iterator localIterator = this.a.iterator();
    int i = 0;
    int j = -1;
    while (localIterator.hasNext())
    {
      if (((f)localIterator.next()).a().equalsIgnoreCase(paramf.a()))
      {
        localIterator.remove();
        if (j == -1)
          j = i;
      }
      i++;
    }
    this.a.add(j, paramf);
  }

  public int c(String paramString)
  {
    if (paramString == null)
      return 0;
    String str = paramString.toLowerCase(Locale.US);
    List localList = (List)this.b.remove(str);
    if ((localList == null) || (localList.isEmpty()))
      return 0;
    this.a.removeAll(localList);
    return localList.size();
  }

  public Iterator<f> iterator()
  {
    return Collections.unmodifiableList(this.a).iterator();
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.b.a.a.b
 * JD-Core Version:    0.6.0
 */