package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class er
{
  private final String a = "umeng_event_snapshot";
  private boolean b = false;
  private SharedPreferences c;
  private Map<String, ArrayList<f>> d = new HashMap();

  public er(Context paramContext)
  {
    this.c = fc.a(paramContext, "umeng_event_snapshot");
  }

  private void c(String paramString)
  {
    boolean bool = this.d.containsKey(paramString);
    String str = null;
    if (bool)
    {
      ArrayList localArrayList = (ArrayList)this.d.get(paramString);
      while (localArrayList.size() > 4)
        localArrayList.remove(0);
      str = ez.a(localArrayList);
    }
    this.c.edit().putString(paramString, str).commit();
  }

  private boolean d(String paramString)
  {
    if (this.d.containsKey(paramString))
      return true;
    String str = this.c.getString(paramString, null);
    if (str != null)
    {
      ArrayList localArrayList = (ArrayList)ez.a(str);
      if (localArrayList != null)
      {
        this.d.put(paramString, localArrayList);
        return true;
      }
    }
    return false;
  }

  public int a(String paramString)
  {
    if (this.d.containsKey(paramString))
      return ((ArrayList)this.d.get(paramString)).size();
    return 0;
  }

  public void a(String paramString, f paramf)
  {
    if (this.b)
      d(paramString);
    if (this.d.containsKey(paramString))
      ((ArrayList)this.d.get(paramString)).add(paramf);
    while (true)
    {
      if (this.b)
        c(paramString);
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramf);
      this.d.put(paramString, localArrayList);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public f b(String paramString)
  {
    if (this.b)
      d(paramString);
    ArrayList localArrayList;
    if (this.d.containsKey(paramString))
    {
      localArrayList = (ArrayList)this.d.get(paramString);
      if (localArrayList.size() <= 0);
    }
    for (f localf = (f)localArrayList.remove(-1 + localArrayList.size()); ; localf = null)
    {
      if (this.b)
        c(paramString);
      return localf;
    }
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.er
 * JD-Core Version:    0.6.0
 */