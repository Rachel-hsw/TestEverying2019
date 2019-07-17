package c.a;

import android.content.Context;
import com.umeng.a.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class et
{
  private final int a = 128;
  private final int b = 256;
  private er c;
  private Context d;
  private em e;

  public et(Context paramContext)
  {
    if (paramContext == null)
      throw new RuntimeException("Context is null, can't track event");
    this.d = paramContext.getApplicationContext();
    this.c = new er(this.d);
    er localer = this.c;
    if (!a.j);
    for (boolean bool = true; ; bool = false)
    {
      localer.a(bool);
      this.e = em.a(this.d);
      return;
    }
  }

  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.trim().getBytes().length;
      if ((i > 0) && (i <= 128))
        return true;
    }
    bu.b("MobclickAgent", "Event id is empty or too long in tracking Event");
    return false;
  }

  private boolean a(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      bu.b("MobclickAgent", "map is null or empty in onEvent");
      return false;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!a((String)localEntry.getKey()))
        return false;
      if (localEntry.getValue() == null)
        return false;
      if (((localEntry.getValue() instanceof String)) && (!b(localEntry.getValue().toString())))
        return false;
    }
    return true;
  }

  private boolean b(String paramString)
  {
    if (paramString == null);
    do
      return true;
    while (paramString.trim().getBytes().length <= 256);
    bu.b("MobclickAgent", "Event label or value is empty or too long in tracking Event");
    return false;
  }

  public void a(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) || (!b(paramString2)))
      return;
    this.c.a(g.b(paramString1, paramString2, null), g.a(paramString1, paramString2, null));
  }

  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((!a(paramString1)) || (!b(paramString2)))
      return;
    HashMap localHashMap = new HashMap();
    if (paramString2 == null)
      paramString2 = "";
    localHashMap.put(paramString1, paramString2);
    this.e.a(new g(paramString1, localHashMap, paramLong, paramInt));
  }

  public void a(String paramString, Map<String, Object> paramMap)
  {
    try
    {
      if (!a(paramString))
        return;
      this.e.a(new i(paramString, paramMap));
      return;
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", localException);
    }
  }

  public void a(String paramString, Map<String, Object> paramMap, long paramLong)
  {
    try
    {
      if (!a(paramString))
        return;
      if (a(paramMap))
      {
        this.e.a(new g(paramString, paramMap, paramLong, -1));
        return;
      }
    }
    catch (Exception localException)
    {
      bu.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", localException);
    }
  }

  public void a(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    if (!a(paramString1));
    do
      return;
    while (!a(paramMap));
    this.c.a(g.b(paramString1, paramString2, paramMap), g.a(paramString1, paramString2, paramMap));
  }

  public void b(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) || (!b(paramString2)));
    f localf;
    do
    {
      return;
      localf = this.c.b(g.b(paramString1, paramString2, null));
    }
    while (localf == null);
    a(paramString1, paramString2, (int)(System.currentTimeMillis() - localf.a), 0);
  }

  public void c(String paramString1, String paramString2)
  {
    if (!a(paramString1));
    f localf;
    do
    {
      return;
      localf = this.c.b(g.b(paramString1, paramString2, null));
    }
    while (localf == null);
    int i = (int)(System.currentTimeMillis() - localf.a);
    a(paramString1, localf.d, i);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.et
 * JD-Core Version:    0.6.0
 */