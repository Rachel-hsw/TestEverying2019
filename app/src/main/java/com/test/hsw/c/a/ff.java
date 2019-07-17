package c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.umeng.a.a;
import java.util.Arrays;
import java.util.List;

public class ff
{
  private static final String a = "session_start_time";
  private static final String b = "session_end_time";
  private static final String c = "session_id";
  private static final String f = "activities";
  private static String g = null;
  private final String d = "a_start_time";
  private final String e = "a_end_time";

  private String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    em localem = em.a(paramContext);
    String str = b(paramContext);
    k localk = a(paramContext);
    SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
    localEditor.putString("session_id", str);
    localEditor.putLong("session_start_time", System.currentTimeMillis());
    localEditor.putLong("session_end_time", 0L);
    localEditor.putLong("a_start_time", System.currentTimeMillis());
    localEditor.putLong("a_end_time", 0L);
    localEditor.commit();
    if (localk != null)
    {
      localem.a(localk);
      return str;
    }
    localem.a((k)null);
    return str;
  }

  private void a(SharedPreferences paramSharedPreferences)
  {
    SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
    localEditor.remove("session_start_time");
    localEditor.remove("session_end_time");
    localEditor.remove("a_start_time");
    localEditor.remove("a_end_time");
    localEditor.putString("activities", "");
    localEditor.commit();
  }

  private boolean b(SharedPreferences paramSharedPreferences)
  {
    long l1 = paramSharedPreferences.getLong("a_start_time", 0L);
    long l2 = paramSharedPreferences.getLong("a_end_time", 0L);
    long l3 = System.currentTimeMillis();
    if ((l1 != 0L) && (l3 - l1 < a.l))
      bu.b("MobclickAgent", "onResume called before onPause");
    do
      return false;
    while (l3 - l2 <= a.l);
    return true;
  }

  public static String g(Context paramContext)
  {
    if (g == null)
      g = fc.a(paramContext).getString("session_id", null);
    return g;
  }

  public k a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    String str = localSharedPreferences.getString("session_id", null);
    if (str == null)
      return null;
    long l1 = localSharedPreferences.getLong("session_start_time", 0L);
    long l2 = localSharedPreferences.getLong("session_end_time", 0L);
    long l3 = 0L;
    if (l2 != 0L)
    {
      l3 = l2 - l1;
      if (Math.abs(l3) > 86400000L)
        l3 = 0L;
    }
    k localk = new k();
    localk.a(str);
    localk.a(l1);
    localk.b(l2);
    localk.c(l3);
    double[] arrayOfDouble = a.b();
    aw localaw;
    if (arrayOfDouble != null)
    {
      localaw = new aw(arrayOfDouble[0], arrayOfDouble[1], System.currentTimeMillis());
      if (!localk.y())
        break label216;
      localk.a(localaw);
    }
    while (true)
    {
      bl localbl = d.a(paramContext);
      if (localbl != null)
        localk.a(localbl);
      List localList = e.a(localSharedPreferences);
      if ((localList != null) && (localList.size() > 0))
        localk.a(localList);
      a(localSharedPreferences);
      return localk;
      label216: localk.b(Arrays.asList(new aw[] { localaw }));
    }
  }

  public String b(Context paramContext)
  {
    String str1 = bt.f(paramContext);
    String str2 = a.a(paramContext);
    long l = System.currentTimeMillis();
    if (str2 == null)
      throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l).append(str2).append(str1);
    g = ch.a(localStringBuilder.toString());
    return g;
  }

  public void c(Context paramContext)
  {
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    if (localSharedPreferences == null)
      return;
    if (b(localSharedPreferences))
    {
      String str2 = a(paramContext, localSharedPreferences);
      bu.a("MobclickAgent", "Start new session: " + str2);
      return;
    }
    String str1 = localSharedPreferences.getString("session_id", null);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putLong("a_start_time", System.currentTimeMillis());
    localEditor.putLong("a_end_time", 0L);
    localEditor.commit();
    bu.a("MobclickAgent", "Extend current session: " + str1);
  }

  public void d(Context paramContext)
  {
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    if (localSharedPreferences == null)
      return;
    if ((localSharedPreferences.getLong("a_start_time", 0L) == 0L) && (a.h))
    {
      bu.b("MobclickAgent", "onPause called before onResume");
      return;
    }
    long l = System.currentTimeMillis();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putLong("a_start_time", 0L);
    localEditor.putLong("a_end_time", l);
    localEditor.putLong("session_end_time", l);
    localEditor.commit();
  }

  public boolean e(Context paramContext)
  {
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    int i = 0;
    if (localSharedPreferences == null);
    em localem;
    k localk;
    do
    {
      String str;
      do
      {
        return i;
        str = localSharedPreferences.getString("session_id", null);
        i = 0;
      }
      while (str == null);
      long l1 = localSharedPreferences.getLong("a_start_time", 0L);
      long l2 = localSharedPreferences.getLong("a_end_time", 0L);
      boolean bool1 = l1 < 0L;
      i = 0;
      if (bool1)
      {
        boolean bool2 = l2 < 0L;
        i = 0;
        if (!bool2)
        {
          i = 1;
          d(paramContext);
        }
      }
      localem = em.a(paramContext);
      localk = a(paramContext);
    }
    while (localk == null);
    localem.b(localk);
    return i;
  }

  public void f(Context paramContext)
  {
    SharedPreferences localSharedPreferences = fc.a(paramContext);
    if (localSharedPreferences == null)
      return;
    String str = b(paramContext);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    localEditor.putString("session_id", str);
    localEditor.putLong("session_start_time", System.currentTimeMillis());
    localEditor.putLong("session_end_time", 0L);
    localEditor.putLong("a_start_time", System.currentTimeMillis());
    localEditor.putLong("a_end_time", 0L);
    localEditor.commit();
    bu.a("MobclickAgent", "Restart session: " + str);
  }
}

/* Location:           C:\Androidnixiangzhushou\zikao_classes_dex2jar.jar
 * Qualified Name:     c.a.ff
 * JD-Core Version:    0.6.0
 */