package c.a;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g extends ae
  implements ev
{
  public g(String paramString, Map<String, Object> paramMap, long paramLong, int paramInt)
  {
    a(paramString);
    b(System.currentTimeMillis());
    if (paramMap.size() > 0)
      a(b(paramMap));
    if (paramInt > 0);
    while (true)
    {
      a(paramInt);
      if (paramLong > 0L)
        a(paramLong);
      return;
      paramInt = 1;
    }
  }

  public static f a(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    f localf = new f();
    localf.b = paramString1;
    localf.c = paramString2;
    localf.d = paramMap;
    return localf;
  }

  public static String b(String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    return paramString1 + paramString2;
  }

  private HashMap<String, bc> b(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    HashMap localHashMap = new HashMap();
    int i = 0;
    label208: 
    while ((i < 10) && (localIterator.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bc localbc = new bc();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof String))
        localbc.b((String)localObject);
      while (true)
      {
        if (!localbc.k())
          break label208;
        localHashMap.put(localEntry.getKey(), localbc);
        i++;
        break;
        if ((localObject instanceof Long))
        {
          localbc.b(((Long)localObject).longValue());
          continue;
        }
        if ((localObject instanceof Integer))
        {
          localbc.b(((Integer)localObject).longValue());
          continue;
        }
        if ((localObject instanceof Float))
        {
          localbc.b(((Float)localObject).longValue());
          continue;
        }
        if (!(localObject instanceof Double))
          continue;
        localbc.b(((Double)localObject).longValue());
      }
    }
    return localHashMap;
  }

  public void a(bn parambn, String paramString)
  {
    as localas;
    if (parambn.s() > 0)
    {
      Iterator localIterator = parambn.u().iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localas = (as)localIterator.next();
      }
      while (!paramString.equals(localas.c()));
    }
    while (true)
    {
      if (localas == null)
      {
        localas = new as();
        localas.a(paramString);
        parambn.a(localas);
      }
      localas.a(this);
      return;
      localas = null;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.g
 * JD-Core Version:    0.6.0
 */