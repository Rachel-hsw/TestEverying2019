package org.a.a.a.d;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.a.a.a.j.a;
import org.a.a.a.j.c;
import org.a.a.a.v;

public class d
  implements Serializable, e
{
  private static final long a = 20110706L;
  private final List<c<String, Object>> b = new ArrayList();

  public List<c<String, Object>> a()
  {
    return this.b;
  }

  public List<Object> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (!v.a(paramString, (CharSequence)localc.getKey()))
        continue;
      localArrayList.add(localc.getValue());
    }
    return localArrayList;
  }

  public d a(String paramString, Object paramObject)
  {
    this.b.add(new a(paramString, paramObject));
    return this;
  }

  public Object b(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (v.a(paramString, (CharSequence)localc.getKey()))
        return localc.getValue();
    }
    return null;
  }

  public Set<String> b()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      localHashSet.add(((c)localIterator.next()).getKey());
    return localHashSet;
  }

  public d b(String paramString, Object paramObject)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      if (!v.a(paramString, (CharSequence)((c)localIterator.next()).getKey()))
        continue;
      localIterator.remove();
    }
    a(paramString, paramObject);
    return this;
  }

  public String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (paramString != null)
      localStringBuilder.append(paramString);
    if (this.b.size() > 0)
    {
      if (localStringBuilder.length() > 0)
        localStringBuilder.append('\n');
      localStringBuilder.append("Exception Context:\n");
      Iterator localIterator = this.b.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        localStringBuilder.append("\t[");
        int j = i + 1;
        localStringBuilder.append(j);
        localStringBuilder.append(':');
        localStringBuilder.append((String)localc.getKey());
        localStringBuilder.append("=");
        Object localObject = localc.getValue();
        if (localObject == null)
          localStringBuilder.append("null");
        while (true)
        {
          localStringBuilder.append("]\n");
          i = j;
          break;
          try
          {
            String str2 = localObject.toString();
            str1 = str2;
            localStringBuilder.append(str1);
          }
          catch (Exception localException)
          {
            while (true)
              String str1 = "Exception thrown on toString(): " + f.h(localException);
          }
        }
      }
      localStringBuilder.append("---------------------------------");
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     org.a.a.a.d.d
 * JD-Core Version:    0.6.0
 */